package it.polito.ezgas.service.impl;

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
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.service.GasStationService;


/**
 * Created by softeng on 27/4/2020.
 */
@Service
public class GasStationServiceimpl implements GasStationService {

	@Autowired GasStationRepository gasStationRepository;

	@Override
	public GasStationDto getGasStationById(Integer gasStationId) throws InvalidGasStationException {
		// TODO Auto-generated method stub
		Optional<GasStation> gs = Optional.ofNullable(gasStationRepository.findOne(gasStationId));
		if (gs.isPresent()) {
			return GasStationMapper.toGSDto(gs.get());
		}
		else {
			throw new InvalidGasStationException("ERROR: GasStation not found");
		}

	}

	@Override
	public GasStationDto saveGasStation(GasStationDto gasStationDto) throws PriceException, GPSDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GasStationDto> getAllGasStations() {
		// TODO Auto-generated method stub
		return gasStationRepository.findAll()
				.stream()
				.map(gasStation -> GasStationMapper.toGSDto(gasStation))
				.collect(Collectors.toList());

	}

	@Override
	public Boolean deleteGasStation(Integer gasStationId) throws InvalidGasStationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GasStationDto> getGasStationsByGasolineType(String gasolinetype) throws InvalidGasTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GasStationDto> getGasStationsByProximity(double lat, double lon) throws GPSDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GasStationDto> getGasStationsWithCoordinates(double lat, double lon, String gasolinetype,
			String carsharing) throws InvalidGasTypeException, GPSDataException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GasStationDto> getGasStationsWithoutCoordinates(String gasolinetype, String carsharing)
			throws InvalidGasTypeException {
		
		if(!isGasolineTypeValid(gasolinetype)) throw new InvalidGasTypeException(gasolinetype);
		
		return getGasStationByCarSharing(carsharing)
				.parallelStream()
				.filter(gasStation -> mapGasolineTypeToMethod(gasolinetype).test(gasStation))
				.collect(Collectors.toList());
	}

	@Override
	public void setReport(Integer gasStationId, double dieselPrice, double superPrice, double superPlusPrice,
			double gasPrice, double methanePrice, Integer userId)
					throws InvalidGasStationException, PriceException, InvalidUserException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<GasStationDto> getGasStationByCarSharing(String carSharing) {

		List<GasStation> gss = gasStationRepository.findByCarSharing(carSharing);
		return gss
				.stream()
				.map(gasStation -> GasStationMapper.toGSDto(gasStation))
				.collect(Collectors.toList());
	}

	private boolean isGasolineTypeValid(String gasolinetype) {
		switch(gasolinetype) {
		case "diesel":
//		case "lpg":
		case "gas":
		case "methane":
		case "super":
		case "superplus": return true;
		default: return false;
		}
	}

	private Predicate<GasStationDto> mapGasolineTypeToMethod(String gasolinetype) {
		switch(gasolinetype) {
		case "diesel": return GasStationDto::getHasDiesel;
//		case "lpg": return GasStationDto::getHasLPG;
		case "gas": return GasStationDto::getHasGas;
		case "methane": return GasStationDto::getHasMethane;
		case "super": return GasStationDto::getHasSuper;
		case "superplus": return GasStationDto::getHasSuperPlus;
		default: return (gsdto) -> false;
		}
	}



}
