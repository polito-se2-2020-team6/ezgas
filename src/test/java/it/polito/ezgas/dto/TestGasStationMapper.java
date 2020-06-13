package it.polito.ezgas.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.polito.ezgas.entity.GasStation;


@SpringBootTest
public class TestGasStationMapper {
	
	@Test
	public void testToGS1() {
		Integer gasStationId = 20;
		String gasStationName = "Q8 Ventimiglia";
		String gasStationAddress = "Via Dante 18";
		Boolean hasDiesel = true;
		Boolean hasSuper = false;
		Boolean hasSuperPlus = false;
		Boolean hasGas = true;
		Boolean hasMethane = true;
		Boolean hasPremiumDiesel = true;
		String carSharing = "Enjoy";
		double lat = 45.0004;
		double lon = 67.2345;
		double dieselPrice = 2.44;
		double superPrice = -1;
		double superPlusPrice = -1;
		double gasPrice = 1.67;
		double methanePrice = 2.06;
		double premiumDieselPrice = 2.90;
		Integer reportUser = 1;
		String reportTimestamp = "Report, 20/05/2020 - 9.45";
		double reportDependability = 40.75;
		
		GasStationDto dummy = new GasStationDto(gasStationId, gasStationName, gasStationAddress, hasDiesel, hasSuper, hasSuperPlus, hasGas, hasMethane, hasPremiumDiesel, carSharing, lat, lon, dieselPrice, superPrice, superPlusPrice, gasPrice, methanePrice, premiumDieselPrice, reportUser, reportTimestamp, reportDependability);
		GasStation ret = GasStationMapper.toGS(dummy);
		
		assertEquals(gasStationId, ret.getGasStationId());
		assertEquals(gasStationName, ret.getGasStationName());
		assertEquals(gasStationAddress, ret.getGasStationAddress());
		assertTrue(ret.getHasDiesel());
		assertFalse(ret.getHasSuper());
		assertFalse(ret.getHasSuperPlus());
		assertTrue(ret.getHasGas());
		assertTrue(ret.getHasMethane());
		assertTrue(ret.getHasPremiumDiesel());
		assertEquals(carSharing, ret.getCarSharing());
		assertEquals(lat, ret.getLat(), 0.1);
		assertEquals(lon, ret.getLon(), 0.1);
		assertEquals(dieselPrice, ret.getDieselPrice(), 0.1);
		assertEquals(superPrice, ret.getSuperPrice(), 0.1);
		assertEquals(superPlusPrice, ret.getSuperPlusPrice(), 0.1);
		assertEquals(gasPrice, ret.getGasPrice(), 0.1);
		assertEquals(methanePrice, ret.getMethanePrice(), 0.1);
		assertEquals(premiumDieselPrice, ret.getPremiumDieselPrice(), 0.1);
		assertEquals(reportUser, ret.getReportUser());
		assertEquals(reportTimestamp, ret.getReportTimestamp());
		assertEquals(reportDependability, ret.getReportDependability(), 0.1);
	}
	
	@Test
	public void testToGS2() {
		Integer gasStationId = -20;
		String gasStationName = "Q8 Ventimiglia";
		String gasStationAddress = "Via Dante 18";
		Boolean hasDiesel = true;
		Boolean hasSuper = false;
		Boolean hasSuperPlus = false;
		Boolean hasGas = true;
		Boolean hasMethane = true;
		Boolean hasPremiumDiesel = false;
		String carSharing = "";
		double lat = 0.0000;
		double lon = 0.0000;
		double dieselPrice = 2.44;
		double superPrice = -1;
		double superPlusPrice = -1;
		double gasPrice = 1.67;
		double methanePrice = 2.06;
		double premiumDieselPrice = -1;
		Integer reportUser = 1;
		String reportTimestamp = "Report, 20/05/2020 - 9.45";
		double reportDependability = 40.75;
		
		GasStationDto dummy = new GasStationDto(gasStationId, gasStationName, gasStationAddress, hasDiesel, hasSuper, hasSuperPlus, hasGas, hasMethane, hasPremiumDiesel, carSharing, lat, lon, dieselPrice, superPrice, superPlusPrice, gasPrice, methanePrice, premiumDieselPrice, reportUser, reportTimestamp, reportDependability);
		GasStation ret = GasStationMapper.toGS(dummy);
		
		assertEquals(gasStationId, ret.getGasStationId());
		assertEquals(gasStationName, ret.getGasStationName());
		assertEquals(gasStationAddress, ret.getGasStationAddress());
		assertTrue(ret.getHasDiesel());
		assertFalse(ret.getHasSuper());
		assertFalse(ret.getHasSuperPlus());
		assertTrue(ret.getHasGas());
		assertTrue(ret.getHasMethane());
		assertFalse(ret.getHasPremiumDiesel());
		assertEquals(carSharing, ret.getCarSharing());
		assertEquals(lat, ret.getLat(), 0.1);
		assertEquals(lon, ret.getLon(), 0.1);
		assertEquals(dieselPrice, ret.getDieselPrice(), 0.1);
		assertEquals(superPrice, ret.getSuperPrice(), 0.1);
		assertEquals(superPlusPrice, ret.getSuperPlusPrice(), 0.1);
		assertEquals(gasPrice, ret.getGasPrice(), 0.1);
		assertEquals(methanePrice, ret.getMethanePrice(), 0.1);
		assertEquals(premiumDieselPrice, ret.getPremiumDieselPrice(), 0.1);
		assertEquals(reportUser, ret.getReportUser());
		assertEquals(reportTimestamp, ret.getReportTimestamp());
		assertEquals(reportDependability, ret.getReportDependability(), 0.1);
	}
	
	@Test
	public void testToGS3() {
		Integer gasStationId = 16;
		String gasStationName = "";
		String gasStationAddress = "Via Dante 18";
		Boolean hasDiesel = false;
		Boolean hasSuper = false;
		Boolean hasSuperPlus = false;
		Boolean hasGas = false;
		Boolean hasMethane = false;
		Boolean hasPremiumDiesel = false;
		String carSharing = "Car2Go";
		double lat = 46.7533;
		double lon = 88.5321;
		double dieselPrice = -1;
		double superPrice = -1;
		double superPlusPrice = -1;
		double gasPrice = -1;
		double methanePrice = -1;
		double premiumDieselPrice = -1;
		Integer reportUser = 0;
		String reportTimestamp = null;
		double reportDependability = 0;
		
		GasStationDto dummy = new GasStationDto(gasStationId, gasStationName, gasStationAddress, hasDiesel, hasSuper, hasSuperPlus, hasGas, hasMethane, hasPremiumDiesel, carSharing, lat, lon, dieselPrice, superPrice, superPlusPrice, gasPrice, methanePrice, premiumDieselPrice, reportUser, reportTimestamp, reportDependability);
		GasStation ret = GasStationMapper.toGS(dummy);
		
		assertEquals(gasStationId, ret.getGasStationId());
		assertEquals(gasStationName, ret.getGasStationName());
		assertEquals(gasStationAddress, ret.getGasStationAddress());
		assertFalse(ret.getHasDiesel());
		assertFalse(ret.getHasSuper());
		assertFalse(ret.getHasSuperPlus());
		assertFalse(ret.getHasGas());
		assertFalse(ret.getHasMethane());
		assertFalse(ret.getHasPremiumDiesel());
		assertEquals(carSharing, ret.getCarSharing());
		assertEquals(lat, ret.getLat(), 0.1);
		assertEquals(lon, ret.getLon(), 0.1);
		assertEquals(dieselPrice, ret.getDieselPrice(), 0.1);
		assertEquals(superPrice, ret.getSuperPrice(), 0.1);
		assertEquals(superPlusPrice, ret.getSuperPlusPrice(), 0.1);
		assertEquals(gasPrice, ret.getGasPrice(), 0.1);
		assertEquals(methanePrice, ret.getMethanePrice(), 0.1);
		assertEquals(premiumDieselPrice, ret.getPremiumDieselPrice(), 0.1);
		assertEquals(reportUser, ret.getReportUser());
		assertEquals(reportTimestamp, ret.getReportTimestamp());
		assertEquals(reportDependability, ret.getReportDependability(), 0.1);
	}
	
	@Test
	public void testToGS4() {
		
		GasStationDto dummy = new GasStationDto();
		GasStation ret = GasStationMapper.toGS(dummy);
		
		assertEquals(dummy.getGasStationId(), ret.getGasStationId());
		assertEquals(dummy.getGasStationName(), ret.getGasStationName());
		assertEquals(dummy.getGasStationAddress(), ret.getGasStationAddress());
		assertEquals(dummy.getHasDiesel(), ret.getHasDiesel());
		assertEquals(dummy.getHasSuper(), ret.getHasSuper());
		assertEquals(dummy.getHasSuperPlus(), ret.getHasSuperPlus());
		assertEquals(dummy.getHasGas(), ret.getHasGas());
		assertEquals(dummy.getHasMethane(), ret.getHasMethane());
		assertEquals(dummy.getHasPremiumDiesel(), ret.getHasPremiumDiesel());
		assertEquals(dummy.getCarSharing(), ret.getCarSharing());
		assertEquals(dummy.getLat(), ret.getLat(), 0.1);
		assertEquals(dummy.getLon(), ret.getLon(), 0.1);
		assertNull(ret.getDieselPrice());
		assertNull(ret.getSuperPrice());
		assertNull(ret.getSuperPlusPrice());
		assertNull(ret.getGasPrice());
		assertNull(ret.getMethanePrice());
		assertNull(ret.getPremiumDieselPrice());
		assertEquals(dummy.getReportUser(), ret.getReportUser());
		assertEquals(dummy.getReportTimestamp(), ret.getReportTimestamp());
		assertEquals(dummy.getReportDependability(), ret.getReportDependability(), 0.1);
	}
	
	@Test
	public void testToGS5() {
		Integer gasStationId = 4;
		String gasStationName = "Q8 Giardini Naxos";
		String gasStationAddress = "Via Schisò 20";
		Boolean hasDiesel = false;
		Boolean hasSuper = true;
		Boolean hasSuperPlus = false;
		Boolean hasGas = true;
		Boolean hasMethane = false;
		String carSharing = "Car2Go";
		double lat = 46.7533;
		double lon = 88.5321;
		double dieselPrice = -1;
		double superPrice = 3.664;
		double superPlusPrice = -1;
		double gasPrice = 2.345;
		double methanePrice = -1;
		Integer reportUser = 4;
		String reportTimestamp = "Report, 20/05/2020 - 10.25";
		double reportDependability = 70.75;
		
		GasStationDto dummy = new GasStationDto();
		dummy.setGasStationId(gasStationId);
		dummy.setGasStationName(gasStationName);
		dummy.setGasStationAddress(gasStationAddress);
		dummy.setHasDiesel(hasDiesel);
		dummy.setHasSuper(hasSuper);
		dummy.setHasSuperPlus(hasSuperPlus);
		dummy.setHasGas(hasGas);
		dummy.setHasMethane(hasMethane);
		dummy.setCarSharing(carSharing);
		dummy.setLat(lat);
		dummy.setLon(lon);
		dummy.setDieselPrice(dieselPrice);
		dummy.setSuperPrice(superPrice);
		dummy.setSuperPlusPrice(superPlusPrice);
		dummy.setGasPrice(gasPrice);
		dummy.setMethanePrice(methanePrice);
		dummy.setReportUser(reportUser);
		dummy.setReportTimestamp(reportTimestamp);
		dummy.setReportDependability(reportDependability);
		GasStation ret = GasStationMapper.toGS(dummy);
		
		assertEquals(gasStationId, ret.getGasStationId());
		assertEquals(gasStationName, ret.getGasStationName());
		assertEquals(gasStationAddress, ret.getGasStationAddress());
		assertFalse(ret.getHasDiesel());
		assertTrue(ret.getHasSuper());
		assertFalse(ret.getHasSuperPlus());
		assertTrue(ret.getHasGas());
		assertFalse(ret.getHasMethane());
		assertEquals(carSharing, ret.getCarSharing());
		assertEquals(lat, ret.getLat(), 0.1);
		assertEquals(lon, ret.getLon(), 0.1);
		assertEquals(dieselPrice, ret.getDieselPrice(), 0.1);
		assertEquals(superPrice, ret.getSuperPrice(), 0.1);
		assertEquals(superPlusPrice, ret.getSuperPlusPrice(), 0.1);
		assertEquals(gasPrice, ret.getGasPrice(), 0.1);
		assertEquals(methanePrice, ret.getMethanePrice(), 0.1);
		assertEquals(reportUser, ret.getReportUser());
		assertEquals(reportTimestamp, ret.getReportTimestamp());
		assertEquals(reportDependability, ret.getReportDependability(), 0.1);
	}
	
	
	@Test
	public void testToGS6() {
		Integer gasStationId = 4;
		String gasStationName = "";
		String gasStationAddress = "Via Schisò 2";
		Boolean hasDiesel = false;
		Boolean hasSuper = true;
		Boolean hasSuperPlus = false;
		Boolean hasGas = true;
		Boolean hasMethane = false;
		String carSharing = "";
		double lat = 0.0000;
		double lon = 88.5321;
		double dieselPrice = -1;
		double superPrice = 3.664;
		double superPlusPrice = -1;
		double gasPrice = 0.000;
		double methanePrice = -1;
		Integer reportUser = 4;
		String reportTimestamp = null;
		double reportDependability = 70.75;
		
		GasStationDto dummy = new GasStationDto();
		dummy.setGasStationId(gasStationId);
		dummy.setGasStationName(gasStationName);
		dummy.setGasStationAddress(gasStationAddress);
		dummy.setHasDiesel(hasDiesel);
		dummy.setHasSuper(hasSuper);
		dummy.setHasSuperPlus(hasSuperPlus);
		dummy.setHasGas(hasGas);
		dummy.setHasMethane(hasMethane);
		dummy.setCarSharing(carSharing);
		dummy.setLat(lat);
		dummy.setLon(lon);
		dummy.setDieselPrice(dieselPrice);
		dummy.setSuperPrice(superPrice);
		dummy.setSuperPlusPrice(superPlusPrice);
		dummy.setGasPrice(gasPrice);
		dummy.setMethanePrice(methanePrice);
		dummy.setReportUser(reportUser);
		dummy.setReportTimestamp(reportTimestamp);
		dummy.setReportDependability(reportDependability);
		GasStation ret = GasStationMapper.toGS(dummy);
		
		assertEquals(gasStationId, ret.getGasStationId());
		assertEquals(gasStationName, ret.getGasStationName());
		assertEquals(gasStationAddress, ret.getGasStationAddress());
		assertFalse(ret.getHasDiesel());
		assertTrue(ret.getHasSuper());
		assertFalse(ret.getHasSuperPlus());
		assertTrue(ret.getHasGas());
		assertFalse(ret.getHasMethane());
		assertEquals(carSharing, ret.getCarSharing());
		assertEquals(lat, ret.getLat(), 0.1);
		assertEquals(lon, ret.getLon(), 0.1);
		assertEquals(dieselPrice, ret.getDieselPrice(), 0.1);
		assertEquals(superPrice, ret.getSuperPrice(), 0.1);
		assertEquals(superPlusPrice, ret.getSuperPlusPrice(), 0.1);
		assertEquals(gasPrice, ret.getGasPrice(), 0.1);
		assertEquals(methanePrice, ret.getMethanePrice(), 0.1);
		assertEquals(reportUser, ret.getReportUser());
		assertEquals(reportTimestamp, ret.getReportTimestamp());
		assertEquals(reportDependability, ret.getReportDependability(), 0.1);
	}
	
	@Test
	public void toGSDto1() {
		Integer gasStationId = 119;
		String gasStationName = "Eni Caltanissetta";
		String gasStationAddress = "Viale della Regione 132";
		Boolean hasDiesel = true;
		Boolean hasSuper = false;
		Boolean hasSuperPlus = false;
		Boolean hasGas = true;
		Boolean hasMethane = true;
		Boolean hasPremiumDiesel = false;
		String carSharing = "Enjoy";
		double lat = 45.0004;
		double lon = 67.2345;
		double dieselPrice = 2.44;
		double superPrice = -1;
		double superPlusPrice = -1;
		double gasPrice = 1.67;
		double methanePrice = 2.06;
		double premiumDieselPrice = -1;
		Integer reportUser = 1;
		String reportTimestamp = "Report, 20/05/2020 - 10.42";
		double reportDependability = 40.75;
		
		GasStation dummy = new GasStation(gasStationName, gasStationAddress, hasDiesel, hasSuper, hasSuperPlus, hasGas, hasMethane, hasPremiumDiesel, carSharing, lat, lon, dieselPrice, superPrice, superPlusPrice, gasPrice, methanePrice, premiumDieselPrice, reportUser, reportTimestamp, reportDependability);
		dummy.setGasStationId(gasStationId);
		GasStationDto ret = GasStationMapper.toGSDto(dummy);
		
		assertEquals(gasStationId, ret.getGasStationId());
		assertEquals(gasStationName, ret.getGasStationName());
		assertEquals(gasStationAddress, ret.getGasStationAddress());
		assertTrue(ret.getHasDiesel());
		assertFalse(ret.getHasSuper());
		assertFalse(ret.getHasSuperPlus());
		assertTrue(ret.getHasGas());
		assertTrue(ret.getHasMethane());
		assertFalse(ret.getHasPremiumDiesel());
		assertEquals(carSharing, ret.getCarSharing());
		assertEquals(lat, ret.getLat(), 0.1);
		assertEquals(lon, ret.getLon(), 0.1);
		assertEquals(dieselPrice, ret.getDieselPrice(), 0.1);
		assertEquals(superPrice, ret.getSuperPrice(), 0.1);
		assertEquals(superPlusPrice, ret.getSuperPlusPrice(), 0.1);
		assertEquals(gasPrice, ret.getGasPrice(), 0.1);
		assertEquals(methanePrice, ret.getMethanePrice(), 0.1);
		assertEquals(premiumDieselPrice, ret.getPremiumDieselPrice(), 0.1);
		assertEquals(reportUser, ret.getReportUser());
		assertEquals(reportTimestamp, ret.getReportTimestamp());
		assertEquals(reportDependability, ret.getReportDependability(), 0.1);
	}
	
	@Test
	public void toGSDto2() {
		Integer gasStationId = -20;
		String gasStationName = "Q8 Ventimiglia";
		String gasStationAddress = "Via Dante 18";
		Boolean hasDiesel = true;
		Boolean hasSuper = false;
		Boolean hasSuperPlus = false;
		Boolean hasGas = true;
		Boolean hasMethane = true;
		Boolean hasPremiumDiesel = true;
		String carSharing = "";
		double lat = 0.0000;
		double lon = 0.0000;
		double dieselPrice = 2.44;
		double superPrice = -1;
		double superPlusPrice = -1;
		double gasPrice = 1.67;
		double methanePrice = 2.06;
		double premiumDieselPrice = 1.84;
		Integer reportUser = 1;
		String reportTimestamp = "Report, 20/05/2020 - 9.45";
		double reportDependability = 40.75;
		
		GasStation dummy = new GasStation(gasStationName, gasStationAddress, hasDiesel, hasSuper, hasSuperPlus, hasGas, hasMethane, hasPremiumDiesel, carSharing, lat, lon, dieselPrice, superPrice, superPlusPrice, gasPrice, methanePrice, premiumDieselPrice, reportUser, reportTimestamp, reportDependability);
		dummy.setGasStationId(gasStationId);
		GasStationDto ret = GasStationMapper.toGSDto(dummy);
		
		assertEquals(gasStationId, ret.getGasStationId());
		assertEquals(gasStationName, ret.getGasStationName());
		assertEquals(gasStationAddress, ret.getGasStationAddress());
		assertTrue(ret.getHasDiesel());
		assertFalse(ret.getHasSuper());
		assertFalse(ret.getHasSuperPlus());
		assertTrue(ret.getHasGas());
		assertTrue(ret.getHasMethane());
		assertTrue(ret.getHasPremiumDiesel());
		assertEquals(carSharing, ret.getCarSharing());
		assertEquals(lat, ret.getLat(), 0.1);
		assertEquals(lon, ret.getLon(), 0.1);
		assertEquals(dieselPrice, ret.getDieselPrice(), 0.1);
		assertEquals(superPrice, ret.getSuperPrice(), 0.1);
		assertEquals(superPlusPrice, ret.getSuperPlusPrice(), 0.1);
		assertEquals(gasPrice, ret.getGasPrice(), 0.1);
		assertEquals(methanePrice, ret.getMethanePrice(), 0.1);
		assertEquals(premiumDieselPrice, ret.getPremiumDieselPrice(), 0.1);
		assertEquals(reportUser, ret.getReportUser());
		assertEquals(reportTimestamp, ret.getReportTimestamp());
		assertEquals(reportDependability, ret.getReportDependability(), 0.1);
	}
	
	@Test
	public void toGSDto3() {
		Integer gasStationId = 16;
		String gasStationName = "";
		String gasStationAddress = "Via Dante 18";
		Boolean hasDiesel = false;
		Boolean hasSuper = false;
		Boolean hasSuperPlus = false;
		Boolean hasGas = false;
		Boolean hasMethane = false;
		Boolean hasPremiumDiesel = false;
		String carSharing = "Car2Go";
		double lat = 46.7533;
		double lon = 88.5321;
		double dieselPrice = -1;
		double superPrice = -1;
		double superPlusPrice = -1;
		double gasPrice = -1;
		double methanePrice = -1;
		double premiumDieselPrice = -1;
		Integer reportUser = 0;
		String reportTimestamp = null;
		double reportDependability = 0;
		
		GasStation dummy = new GasStation(gasStationName, gasStationAddress, hasDiesel, hasSuper, hasSuperPlus, hasGas, hasMethane, hasPremiumDiesel, carSharing, lat, lon, dieselPrice, superPrice, superPlusPrice, gasPrice, methanePrice, premiumDieselPrice, reportUser, reportTimestamp, reportDependability);
		dummy.setGasStationId(gasStationId);
		GasStationDto ret = GasStationMapper.toGSDto(dummy);
		
		assertEquals(gasStationId, ret.getGasStationId());
		assertEquals(gasStationName, ret.getGasStationName());
		assertEquals(gasStationAddress, ret.getGasStationAddress());
		assertFalse(ret.getHasDiesel());
		assertFalse(ret.getHasSuper());
		assertFalse(ret.getHasSuperPlus());
		assertFalse(ret.getHasGas());
		assertFalse(ret.getHasMethane());
		assertFalse(ret.getHasPremiumDiesel());
		assertEquals(carSharing, ret.getCarSharing());
		assertEquals(lat, ret.getLat(), 0.1);
		assertEquals(lon, ret.getLon(), 0.1);
		assertEquals(dieselPrice, ret.getDieselPrice(), 0.1);
		assertEquals(superPrice, ret.getSuperPrice(), 0.1);
		assertEquals(superPlusPrice, ret.getSuperPlusPrice(), 0.1);
		assertEquals(gasPrice, ret.getGasPrice(), 0.1);
		assertEquals(methanePrice, ret.getMethanePrice(), 0.1);
		assertEquals(premiumDieselPrice, ret.getPremiumDieselPrice(), 0.1);
		assertEquals(reportUser, ret.getReportUser());
		assertEquals(reportTimestamp, ret.getReportTimestamp());
		assertEquals(reportDependability, ret.getReportDependability(), 0.1);
	}
	
	@Test
	public void toGSDto4() {
		Integer gasStationId = 4;
		String gasStationName = "Q8 Giardini Naxos";
		String gasStationAddress = "Via Schisò 20";
		Boolean hasDiesel = false;
		Boolean hasSuper = true;
		Boolean hasSuperPlus = false;
		Boolean hasGas = true;
		Boolean hasMethane = false;
		String carSharing = "Car2Go";
		double lat = 46.7533;
		double lon = 88.5321;
		double dieselPrice = -1;
		double superPrice = 3.664;
		double superPlusPrice = -1;
		double gasPrice = 2.345;
		double methanePrice = -1;
		Integer reportUser = 4;
		String reportTimestamp = "Report, 20/05/2020 - 10.25";
		double reportDependability = 70.75;
		
		GasStation dummy = new GasStation();
		dummy.setGasStationId(gasStationId);
		dummy.setGasStationName(gasStationName);
		dummy.setGasStationAddress(gasStationAddress);
		dummy.setHasDiesel(hasDiesel);
		dummy.setHasSuper(hasSuper);
		dummy.setHasSuperPlus(hasSuperPlus);
		dummy.setHasGas(hasGas);
		dummy.setHasMethane(hasMethane);
		dummy.setCarSharing(carSharing);
		dummy.setLat(lat);
		dummy.setLon(lon);
		dummy.setDieselPrice(dieselPrice);
		dummy.setSuperPrice(superPrice);
		dummy.setSuperPlusPrice(superPlusPrice);
		dummy.setGasPrice(gasPrice);
		dummy.setMethanePrice(methanePrice);
		dummy.setReportUser(reportUser);
		dummy.setReportTimestamp(reportTimestamp);
		dummy.setReportDependability(reportDependability);
		GasStationDto ret = GasStationMapper.toGSDto(dummy);
		
		assertEquals(gasStationId, ret.getGasStationId());
		assertEquals(gasStationName, ret.getGasStationName());
		assertEquals(gasStationAddress, ret.getGasStationAddress());
		assertFalse(ret.getHasDiesel());
		assertTrue(ret.getHasSuper());
		assertFalse(ret.getHasSuperPlus());
		assertTrue(ret.getHasGas());
		assertFalse(ret.getHasMethane());
		assertEquals(carSharing, ret.getCarSharing());
		assertEquals(lat, ret.getLat(), 0.1);
		assertEquals(lon, ret.getLon(), 0.1);
		assertEquals(dieselPrice, ret.getDieselPrice(), 0.1);
		assertEquals(superPrice, ret.getSuperPrice(), 0.1);
		assertEquals(superPlusPrice, ret.getSuperPlusPrice(), 0.1);
		assertEquals(gasPrice, ret.getGasPrice(), 0.1);
		assertEquals(methanePrice, ret.getMethanePrice(), 0.1);
		assertEquals(reportUser, ret.getReportUser());
		assertEquals(reportTimestamp, ret.getReportTimestamp());
		assertEquals(reportDependability, ret.getReportDependability(), 0.1);
	}
}
