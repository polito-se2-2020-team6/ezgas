package it.polito.ezgas.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.GPSDataException;
import exception.InvalidGasStationException;
import exception.InvalidGasTypeException;
import exception.InvalidUserException;
import exception.PriceException;
import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.dto.GasStationMapper;
import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.entity.PriceReport;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.repository.PriceReportRepository;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.GasStationService;


/**
 * Created by softeng on 27/4/2020.
 */
@Service
public class GasStationServiceimpl implements GasStationService {

	@Autowired GasStationRepository gasStationRepository;
	@Autowired UserRepository userRepository;
	//	@Autowired PriceReportRepository priceReportRepository;

	@Override
	public GasStationDto getGasStationById(Integer gasStationId) throws InvalidGasStationException {
		Optional<GasStation> gs = Optional.ofNullable(gasStationRepository.findOne(gasStationId));
		if (gs.isPresent()) {
			return GasStationMapper.toGSDto(gs.get());
		}
		else {
			throw new InvalidGasStationException("ERROR: Gas Station "+ gasStationId +" not found!");
		}

	}

	@Override
	public GasStationDto saveGasStation(GasStationDto gasStationDto) throws PriceException, GPSDataException {
		//set default prices (0)	
		
				gasStationDto.setDieselPrice(gasStationDto.getHasDiesel() ? 0 : -1);
		// 				gasStationDto.setLpgPrice(gasStationDto.getHasLpg() ? 0 : -1);

				gasStationDto.setGasPrice(gasStationDto.getHasGas() ? 0 : -1);
		gasStationDto.setMethanePrice(gasStationDto.getHasMethane() ? 0 : -1);
		gasStationDto.setSuperPrice(gasStationDto.getHasSuper() ? 0 : -1);
		gasStationDto.setSuperPlusPrice(gasStationDto.getHasSuperPlus() ? 0 : -1);

		//check not valid prices
			if (!gasStationDto.getHasDiesel() && gasStationDto.getDieselPrice() != -1||
					//			!gasStationDto.getHasLpg() && gasStationDto.getLpgPrice() != -1 ||
				 !gasStationDto.getHasGas() && gasStationDto.getGasPrice() != -1||
				!gasStationDto.getHasMethane() && gasStationDto.getMethanePrice() !=-1 ||
				!gasStationDto.getHasSuper() && gasStationDto.getSuperPrice() !=-1 ||
				!gasStationDto.getHasSuperPlus() && gasStationDto.getSuperPlusPrice() !=-1) {
				throw new PriceException("ERROR: Price not valid or setted");
			}
			else if (gasStationDto.getLat()<-90 || gasStationDto.getLat()>90 || gasStationDto.getLon()>180 || gasStationDto.getLon()<-180 ) {
				throw new GPSDataException("ERROR: Invalid latitude(" + gasStationDto.getLat() + ") or longitude(" + gasStationDto.getLon() + ") values");
			}
			else {
				GasStation gs = gasStationRepository.save(GasStationMapper.toGS(gasStationDto));
			
				return GasStationMapper.toGSDto(gs);
			}
	}

	@Override
	public List<GasStationDto> getAllGasStations() {
		return gasStationRepository.findAll()
				.stream()
				.map(gasStation -> GasStationMapper.toGSDto(gasStation))
				.collect(Collectors.toList());

	}

	@Override
	public Boolean deleteGasStation(Integer gasStationId) throws InvalidGasStationException {
		Optional<GasStation> gs = Optional.ofNullable(gasStationRepository.findOne(gasStationId));
		// Check if gas station exists
		if (!gs.isPresent())
			throw new InvalidGasStationException("ERROR: Gas Station "+ gasStationId +" not found!");
		gasStationRepository.delete(gs.get());
		gs = Optional.ofNullable(gasStationRepository.findOne(gasStationId));
		if (!gs.isPresent())
			return true;
		else 
			return false;
	}

	@Override
	public List<GasStationDto> getGasStationsByGasolineType(String gasolinetype) throws InvalidGasTypeException {
		// Check if gas station exists
		if(!isGasolineTypeValid(gasolinetype)) throw new InvalidGasTypeException("ERROR: gasoline type " + gasolinetype + " not found!");

		return gasStationRepository.findAll()
				.parallelStream()
				.map(GasStationMapper::toGSDto)
				.filter(gasStation -> mapGasolineTypeToMethod(gasolinetype).test(gasStation))
				.collect(Collectors.toList());
	}

	@Override
	public List<GasStationDto> getGasStationsByProximity(double lat, double lon) throws GPSDataException {
		// Check coordinates make sense
		if (lat < -90 || lat > 90 || lon < -180 || lon > 180 ) {
			throw new GPSDataException("ERROR: Invalid latitude(" + lat + ") or longitude(" + lon + ") values");
		}

		return gasStationRepository.findAll()
				.parallelStream()
				.filter(gs -> geoPointDistance(lat, lon, gs.getLat(), gs.getLon()) < 5)
				.map(GasStationMapper::toGSDto)
				.sorted((a, b) -> (geoPointDistance(lat, lon, b.getLat(), b.getLon()) - geoPointDistance(lat, lon, a.getLat(), a.getLon()) < 0 ? -1 : 1))
				.collect(Collectors.toList());
	}

	@Override
	public List<GasStationDto> getGasStationsWithCoordinates(double lat, double lon, String gasolinetype,
			String carsharing) throws InvalidGasTypeException, GPSDataException {
		// Check coordinates make sense
		if (lat < -90 || lat > 90 || lon < -180 || lon > 180 ) {
			throw new GPSDataException("ERROR: Invalid latitude(" + lat + ") or longitude(" + lon + ") values");
		}
		
		return getGasStationsWithoutCoordinates(gasolinetype, carsharing)
				.parallelStream()
				.filter(gs -> geoPointDistance(lat, lon, gs.getLat(), gs.getLon()) < 5)
				.sorted((a, b) -> (geoPointDistance(lat, lon, b.getLat(), b.getLon()) - geoPointDistance(lat, lon, a.getLat(), a.getLon()) < 0 ? -1 : 1))
				.collect(Collectors.toList());
	}

	@Override
	public List<GasStationDto> getGasStationsWithoutCoordinates(String gasolinetype, String carsharing)
			throws InvalidGasTypeException {
		// Check if gas station exists
		if(!isGasolineTypeValid(gasolinetype)) throw new InvalidGasTypeException("ERROR: gasoline type " + gasolinetype + " not found!");

		return getGasStationByCarSharing(carsharing)
				.parallelStream()
				.filter(gasStation -> mapGasolineTypeToMethod(gasolinetype).test(gasStation))
				.collect(Collectors.toList());
	}

	@Override
	public void setReport(Integer gasStationId, double dieselPrice, double superPrice, double superPlusPrice,
			double gasPrice, double methanePrice, Integer userId)
					throws InvalidGasStationException, PriceException, InvalidUserException {
		// Check if gas station exists
		Optional<GasStation> optGS = Optional.ofNullable(gasStationRepository.findOne(gasStationId));
		if(!optGS.isPresent()) throw new InvalidGasStationException("ERROR: GasStation " + gasStationId + " not found!");
		GasStation gs = optGS.get();
		// Check if user exists
		Optional<User> optU = Optional.ofNullable(userRepository.findOne(userId));
		if(!optU.isPresent()) throw new InvalidUserException("ERROR: User " + userId + " not found!");
		User u = optU.get();
		// Check price report compatibility with gas station
		if (gs.getHasDiesel() && dieselPrice <= 0 || !gs.getHasDiesel() && dieselPrice > 0 ||
				//				gs.getHasLpg() && lpgPrice <= 0 || !gs.getHasLpg() && lpgPrice > 0 ||
				gs.getHasGas() && gasPrice <= 0 || !gs.getHasGas() && gasPrice > 0 ||
				gs.getHasMethane() && methanePrice <= 0 || !gs.getHasMethane() && methanePrice > 0 ||
				gs.getHasSuper() && superPrice <= 0 || !gs.getHasSuper() && superPrice > 0 ||
				gs.getHasSuperPlus() && superPlusPrice <= 0 || !gs.getHasSuperPlus() && superPlusPrice > 0) {
			throw new PriceException("ERROR: Price not valid or setted");
		}

		// TODO: Missing methane and lpg args
		PriceReport pr = new PriceReport(u, dieselPrice, superPrice, superPlusPrice, gasPrice);

		// Set gas station fields
		gs.setDieselPrice(pr.getDieselPrice());
		//		gs.setLpgPrice(pr.getLpgPrice());
		gs.setMethanePrice(/*pr.getMethanePrice*/methanePrice);
		gs.setGasPrice(pr.getGasPrice());
		gs.setSuperPrice(pr.getSuperPrice());
		gs.setSuperPlusPrice(pr.getSuperPlusPrice());

		gs.setReportUser(u.getUserId());
		gs.setReportTimestamp(new Date().toString()); // TODO: Maybe change
		// pr.trust_level = 50 * (U.trust_level +5)/10 + 50 * obsolescence
		gs.setReportDependability(50 * (u.getReputation() + 5) / 10 + 50 * 1);
		
		gasStationRepository.save(gs);
	}

	@Override
	public List<GasStationDto> getGasStationByCarSharing(String carSharing) {
		
		if(carSharing.equals("null")) return getAllGasStations();

		List<GasStation> gss = gasStationRepository.findByCarSharing(carSharing);
		return gss
				.parallelStream()
				.map(gasStation -> GasStationMapper.toGSDto(gasStation))
				.collect(Collectors.toList());
	}

	private boolean isGasolineTypeValid(String gasolinetype) {
		switch(gasolinetype) {
		case "null": 
		case "Diesel":
			//		case "LPG":
		case "Gas":
		case "Methane":
		case "Super":
		case "SuperPlus": return true;
		default: return false;
		}
	}

	private Predicate<GasStationDto> mapGasolineTypeToMethod(String gasolinetype) {
		switch(gasolinetype) {
		case "Diesel": return GasStationDto::getHasDiesel;
		//		case "LPG": return GasStationDto::getHasLPG;
		case "Gas": return GasStationDto::getHasGas;
		case "Methane": return GasStationDto::getHasMethane;
		case "Super": return GasStationDto::getHasSuper;
		case "SuperPlus": return GasStationDto::getHasSuperPlus;
		case "null": return (gsdto) -> true;
		default: return (gsdto) -> false;
		}
	}

	// Haversine formula. Takes into account curvature of Earth, but assumes a sphere.
	// With long distances, error < 0.1%.
	// Return value in Km.
	// https://en.wikipedia.org/wiki/Haversine_formula
	// Implementation by https://www.geeksforgeeks.org/haversine-formula-to-find-distance-between-two-points-on-a-sphere/
	private double geoPointDistance(double lat1, double lon1, double lat2, double lon2) {
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);

		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		double a = Math.pow(Math.sin(dLat / 2), 2) +
				Math.pow(Math.sin(dLon / 2), 2) *
				Math.cos(lat1) *
				Math.cos(lat2);

		double rad = 6371;
		double c = 2 * Math.asin(Math.sqrt(a));

		return rad * c;
	}
}
