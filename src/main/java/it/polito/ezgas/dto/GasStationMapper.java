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
}
