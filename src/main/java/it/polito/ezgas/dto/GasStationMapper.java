package it.polito.ezgas.dto;

import it.polito.ezgas.entity.GasStation;

public class GasStationMapper {
	public static GasStationDto toGSDto(GasStation gs) {		
		GasStationDto gsDto = 	new GasStationDto();
				gsDto.setGasStationId(gs.getGasStationId());
				gsDto.setGasStationName(gs.getGasStationName());
				gsDto.setGasStationAddress(gs.getGasStationAddress());
				gsDto.setCarSharing(gs.getCarSharing());
				gsDto.setHasDiesel(gs.getHasDiesel());
				gsDto.setHasGas(gs.getHasGas());
				gsDto.setHasMethane(gs.getHasMethane());
				gsDto.setHasSuper(gs.getHasSuper());
				gsDto.setHasSuperPlus(gs.getHasSuperPlus());
				gsDto.setDieselPrice(gs.getDieselPrice());
				gsDto.setMethanePrice(gs.getMethanePrice());
				gsDto.setGasPrice(gs.getGasPrice());
				gsDto.setSuperPlusPrice(gs.getSuperPlusPrice());
				gsDto.setSuperPrice(gs.getSuperPrice());
				gsDto.setLat(gs.getLat());
				gsDto.setLon(gs.getLon());
				gsDto.setReportUser(gs.getReportUser());
				//TODO: gsDto.setUserDto(UserMapper.toUserDto(gs.getUser()));
				gsDto.setReportTimestamp(gs.getReportTimestamp());
				gsDto.setReportDependability(gs.getReportDependability());
				return gsDto;

	}
	
	public static GasStation toGS(GasStationDto gsDto) {
		GasStation gas = 	new GasStation();
		gas.setGasStationId(gsDto.getGasStationId());
		gas.setGasStationName(gsDto.getGasStationName());
		gas.setGasStationAddress(gsDto.getGasStationAddress());
		gas.setCarSharing(gsDto.getCarSharing());
		gas.setHasDiesel(gsDto.getHasDiesel());
		gas.setHasGas(gsDto.getHasGas());
		gas.setHasMethane(gsDto.getHasMethane());
		gas.setHasSuper(gsDto.getHasSuper());
		gas.setHasSuperPlus(gsDto.getHasSuperPlus());
		gas.setDieselPrice(gsDto.getDieselPrice());
		gas.setMethanePrice(gsDto.getMethanePrice());
		gas.setGasPrice(gsDto.getGasPrice());
		gas.setSuperPlusPrice(gsDto.getSuperPlusPrice());
		gas.setSuperPrice(gsDto.getSuperPrice());
		gas.setLat(gsDto.getLat());
		gas.setLon(gsDto.getLon());
		gas.setReportUser(gsDto.getReportUser());
		//TODO: gsDto.setUserDto(UserMapper.toUserDto(gs.getUser()));
		gas.setReportTimestamp(gsDto.getReportTimestamp());
		gas.setReportDependability(gsDto.getReportDependability());
		return gas;
	}
}
