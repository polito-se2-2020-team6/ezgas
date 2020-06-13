package it.polito.ezgas.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import exception.GPSDataException;
import exception.InvalidCarSharingException;
import exception.InvalidGasStationException;
import exception.InvalidGasTypeException;
import exception.InvalidUserException;
import exception.PriceException;
import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.dto.GasStationMapper;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.repository.UserRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@SpringBootTest
public class TestGasStationServiceimpl {

	@Test
	public void testIsGasolineTypeValid1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("isGasolineTypeValid", String.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), "");
		assertFalse(res);
	}

	@Test
	public void testIsGasolineTypeValid2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("isGasolineTypeValid", String.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), "ciao");
		assertFalse(res);
	}

	@Test
	public void testIsGasolineTypeValid3() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("isGasolineTypeValid", String.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), "Methane");
		assertTrue(res);
	}

	@Test
	public void testIsGasolineTypeValid4() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("isGasolineTypeValid", String.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), "Gas");
		assertTrue(res);
	}

	@Test
	public void testIsGasolineTypeValid5() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("isGasolineTypeValid", String.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), "Diesel");
		assertTrue(res);
	}

	@Test
	public void testIsGasolineTypeValid6() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("isGasolineTypeValid", String.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), "Super");
		assertTrue(res);
	}

	@Test
	public void testIsGasolineTypeValid7() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("isGasolineTypeValid", String.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), "SuperPlus");
		assertTrue(res);
	}

	@Test
	public void testIsGasolineTypeValid8() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("isGasolineTypeValid", String.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), "null");
		assertTrue(res);
	}

	@Test
	public void testIsGasolineTypeValid9() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("isGasolineTypeValid", String.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), (String)null);
		assertFalse(res);
	}

	@Test
	public void testGeoPointDistance1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
		example.setAccessible(true);			
		double res = (double) example.invoke(new GasStationServiceimpl(null, null), -30.10,-100.2,-40.6,20.3);
		assertEquals(10051.81,res,1);
	}	

	@Test
	public void testGeoPointDistance2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
		example.setAccessible(true);

		double res = (double) example.invoke(new GasStationServiceimpl(null, null), Math.nextAfter(-90,Double.POSITIVE_INFINITY),-100.4,20.43,61.6);
		assertEquals(12278.67,res,1);
	}

	@Test
	public void testGeoPointDistance3() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
		example.setAccessible(true);

		double res = (double) example.invoke(new GasStationServiceimpl(null, null), Math.nextAfter(90,Double.NEGATIVE_INFINITY),65.21,-25.6,120.34);
		assertEquals(12853.52,res,1);
	}

	@Test
	public void testGeoPointDistance4() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
		example.setAccessible(true);

		double res = (double) example.invoke(new GasStationServiceimpl(null, null), 90,89.90,-26.7,55.7);
		assertEquals(12975.82,res,1);
	}

	@Test
	public void testGeoPointDistance5() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
		example.setAccessible(true);

		double res = (double) example.invoke(new GasStationServiceimpl(null, null), -30.4,Math.nextAfter(-180,Double.POSITIVE_INFINITY),36.43,-100.4);
		assertEquals(11129.19,res,1);
	}

	@Test
	public void testGeoPointDistance6() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
		example.setAccessible(true);

		double res = (double) example.invoke(new GasStationServiceimpl(null, null), 29.09,Math.nextAfter(180,Double.NEGATIVE_INFINITY),-50.34,-103.34);
		assertEquals(11587.9,res,1);
	}

	@Test
	public void testGeoPointDistance7() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
		example.setAccessible(true);

		double res = (double) example.invoke(new GasStationServiceimpl(null, null), -45.54,180,-21.43,103.54);
		assertEquals(7291.82,res,1);
	}

	@Test
	public void testGeoPointDistance8() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
		example.setAccessible(true);

		double res = (double) example.invoke(new GasStationServiceimpl(null, null), 22.22,-102.34,Math.nextAfter(-90,Double.POSITIVE_INFINITY),27.76);
		assertEquals(12477.69,res,1);
	}

	@Test
	public void testGeoPointDistance9() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
		example.setAccessible(true);

		double res = (double) example.invoke(new GasStationServiceimpl(null, null), -80.76,-170.54,Math.nextAfter(90,Double.NEGATIVE_INFINITY),102.54);
		assertEquals(18986.73,res,1);
	}

	@Test
	public void testGeoPointDistance10() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
		example.setAccessible(true);

		double res = (double) example.invoke(new GasStationServiceimpl(null, null), -43.56,109.34,90,99.09);
		assertEquals(14850.48,res,1);
	}

	@Test
	public void testGeoPointDistance11() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
		example.setAccessible(true);

		double res = (double) example.invoke(new GasStationServiceimpl(null, null), -30.54,103.54,-76.76,Math.nextAfter(-180,Double.POSITIVE_INFINITY));
		assertEquals(6366.8,res,1);
	}

	@Test
	public void testGeoPointDistance12() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
		example.setAccessible(true);

		double res = (double) example.invoke(new GasStationServiceimpl(null, null), 31.67,66.78,89.43,Math.nextAfter(180,Double.NEGATIVE_INFINITY));
		assertEquals(6510.84,res,1);
	}

	@Test
	public void testGeoPointDistance13() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
		example.setAccessible(true);

		double res = (double) example.invoke(new GasStationServiceimpl(null, null), 55.76,-59.76,30.88,180);
		assertEquals(8846.99,res,1);
	}

	@Test
	public void testLatLonCorrect1() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("latLonCorrect", double.class, double.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), -90.0, -180.0);
		assertFalse(res);
	}

	@Test
	public void testLatLonCorrect2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("latLonCorrect", double.class, double.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), Math.nextAfter(-90, Double.NEGATIVE_INFINITY), 150.0);
		assertFalse(res);
	}

	@Test
	public void testLatLonCorrect3() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("latLonCorrect", double.class, double.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), Math.nextAfter(-90, Double.POSITIVE_INFINITY), Math.nextAfter(-180, Double.NEGATIVE_INFINITY));
		assertFalse(res);
	}

	@Test
	public void testLatLonCorrect4() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("latLonCorrect", double.class, double.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), 0.0, -180.0);
		assertFalse(res);
	}

	@Test
	public void testLatLonCorrect5() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("latLonCorrect", double.class, double.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), 90.0, 180.0);
		assertTrue(res);
	}

	@Test
	public void testLatLonCorrect6() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("latLonCorrect", double.class, double.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), Math.nextAfter(90, Double.NEGATIVE_INFINITY), Math.nextAfter(180, Double.NEGATIVE_INFINITY));
		assertTrue(res);
	}

	@Test
	public void testLatLonCorrect7() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("latLonCorrect", double.class, double.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), Math.nextAfter(-90.0, Double.POSITIVE_INFINITY), Math.nextAfter(-180.0, Double.POSITIVE_INFINITY));
		assertTrue(res);
	}

	@Test
	public void testLatLonCorrect8() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("latLonCorrect", double.class, double.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), 0.0, 0.0);
		assertTrue(res);
	}

	@Test
	public void testLatLonCorrect9() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Method example = GasStationServiceimpl.class.getDeclaredMethod("latLonCorrect", double.class, double.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), 0.0, Math.nextAfter(180.0, Double.POSITIVE_INFINITY));
		assertFalse(res);
	}

	@Test
	public void testLatLonCorrect10() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("latLonCorrect", double.class, double.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), Math.nextAfter(90.0, Double.POSITIVE_INFINITY), 50.0);
		assertFalse(res);
	}

	List <GasStation>  al;
	List <GasStation> alE;
	List <GasStation> alC;

	@Mock 
	GasStationRepository mockGSR;
	UserRepository mockUR;
	GasStationServiceimpl mockGSSI;


	@Before
	public void setUp() {
		GasStation dummyGS1 = new GasStation("DB Carburanti", "Viale Trieste 135", true, true, false, false, true, true, "Enjoy", -25.789, 45.785, 0.0, 0.0, null, null, 0.0, 0.0, 23, "19/05/2020, 11:24", 25.6);
		dummyGS1.setGasStationId(120);
		GasStation dummyGS2 = new GasStation("Agip", "Viale Della Rinascita 12", false, true, false, false, true, false, "Car2Go", 25.789, -45.785, null, null, null, null, 0.0, null, 2, "18/05/2020, 14:24", 29.6);
		dummyGS2.setGasStationId(121);
		GasStation dummyGS3 = new GasStation("Q8", "Viale Luigi Monaco 62", true, true, false, true, true, false, "Enjoy", -56.789, 86.785, 0.0, 0.0, null, 0.0, 0.0, null, 3, "18/05/2020, 09:24", 43.6);
		dummyGS3.setGasStationId(122);
		GasStation dummyGS4 = new GasStation("Eni", "Via Garibaldi 33", true, true, false, true, true, false, "Car2Go", 11.233, 47.304, 1.225, 2.553, null, 2.098, 1.003, null, 42, "18/05/2020, 19:00", 23.6);
		dummyGS4.setGasStationId(123);

		User dummyU = new User("Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", 5);
		dummyU.setUserId(42);
		dummyU.setAdmin(true);


		al = new ArrayList<>();
		alE = new ArrayList<>();
		alC = new ArrayList<>();
		al.add(dummyGS1);
		al.add(dummyGS2);
		al.add(dummyGS3);
		al.add(dummyGS4);
		alE.add(dummyGS1);
		alE.add(dummyGS3);
		alC.add(dummyGS2);
		alC.add(dummyGS4);

		mockUR = mock(UserRepository.class);
		mockGSR = mock(GasStationRepository.class);
		mockGSSI = mock(GasStationServiceimpl.class);

		when(mockGSR.findOne(eq(120))).thenReturn(dummyGS1);
		when(mockGSR.findOne(eq(121))).thenReturn(dummyGS2);
		when(mockGSR.findOne(eq(122))).thenReturn(dummyGS3).thenReturn(null);
		when(mockGSR.findOne(eq(123))).thenReturn(dummyGS4);
		when(mockGSR.findOne(eq(-5))).thenReturn(null);
		when(mockGSR.save(any(GasStation.class))).thenReturn(dummyGS4);
		when(mockGSR.findByCarSharing("Enjoy")).thenReturn(alE);
		when(mockGSR.findByCarSharing("Car2Go")).thenReturn(alC);
		when(mockGSR.findByCarSharing("null")).thenReturn(al);
		when(mockGSR.findByGasStationAddress("Viale Della Rinascita 12")).thenReturn(dummyGS2);
		when(mockGSR.findByGasStationAddress("Via Garibaldi 33")).thenReturn(dummyGS4);
		when(mockGSR.findByGasStationAddress("Indirizzo Fake")).thenReturn(null);
		when(mockUR.findOne(eq(42))).thenReturn(dummyU);
		when(mockGSR.findAll())
		.thenAnswer(new Answer<List<GasStation>>() {

			@Override
			public List<GasStation> answer(InvocationOnMock invocation) throws Throwable {

				return al;
			}
		});


	}	


	@Test
	public void testGetGasStationById1() {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		try {
			GasStationDto res = GsService.getGasStationById(120);
			assertEquals(new Integer(120), res.getGasStationId());
		}
		catch(InvalidGasStationException e) {
			fail("exception not expected ");
		}
	}

	@Test(expected = InvalidGasStationException.class)
	public void testGetGasStationById2() throws InvalidGasStationException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		GsService.getGasStationById(-5);
	}
	@Test
	public void testSaveGasStation1() {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		try {
			GasStationDto res = GsService.saveGasStation(new GasStationDto(123, "Eni", "Via Garibaldi 33", true, true, false, true, true, false, "Car2Go", 11.233, 47.304, 1.225, 2.553, null, 2.098, 1.003, null, 42, "18/05/2020, 19:00", 23.6));
			assertEquals(new Integer(123), res.getGasStationId());
			assertEquals("Eni", res.getGasStationName());
			assertEquals("Via Garibaldi 33", res.getGasStationAddress());
			assertTrue(res.getHasDiesel());
			assertTrue(res.getHasSuper());
			assertFalse(res.getHasSuperPlus());
			assertTrue(res.getHasGas());
			assertTrue(res.getHasMethane());
			assertFalse(res.getHasPremiumDiesel());
			assertEquals("Car2Go",res.getCarSharing());
			assertEquals(11.233, res.getLat(),0.1);
			assertEquals(47.304, res.getLon(),0.1);
			assertEquals(1.225,res.getDieselPrice(),0.1);
			assertEquals(2.553,res.getSuperPrice(),0.1);
			assertNull(res.getSuperPlusPrice());
			assertEquals(2.098,res.getGasPrice(),0.1);
			assertEquals(1.003,res.getMethanePrice(),0.1);
			assertNull(res.getPremiumDieselPrice());
			assertEquals(new Integer(42),res.getReportUser());
			assertEquals("18/05/2020, 19:00", res.getReportTimestamp());
			assertEquals(23.6,res.getReportDependability(),0.1);
		} catch (PriceException e) {
			fail("Price Exception");
		} catch (GPSDataException e) {
			fail("GPS Data Exception");
		}

	}

	@Test(expected = GPSDataException.class)
	public void testSaveGasStation2() throws PriceException, GPSDataException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		GsService.saveGasStation(new GasStationDto(120,"DB Carburanti", "Viale Trieste 135", true, true, false, false, true, true, "Enjoy", 280, 45.785, 0.0, 0.0, null, null, 0.0, 0.0, 23, "19/05/2020, 11:24", 25.6));	
	}

	@Test(expected = GPSDataException.class)
	public void testSaveGasStation3() throws PriceException, GPSDataException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		GsService.saveGasStation(new GasStationDto(120,"DB Carburanti", "Viale Trieste 135", true, true, false, false, true, true, "Enjoy", 45.785, 1024, 0.0, 0.0, null, null, 0.0, 0.0, 23, "19/05/2020, 11:24", 25.6));	
	}

	@Test
	public void testSaveGasStation4() throws PriceException, GPSDataException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		GasStationDto res = GsService.saveGasStation(new GasStationDto(null, "Agip", "Viale Della Rinascita 12", false, true, false, false, true, true, "Car2Go", 25.789, -45.785, null, null, null, null, 0.0, 0.0, 2, "18/05/2020, 14:24", 29.6));
		assertNull(res);
	}
	@Test
	public void testSaveGasStation5() throws PriceException, GPSDataException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		GasStationDto res = GsService.saveGasStation(new GasStationDto(121, "Agip", "Viale Della Rinascita 12", false, true, false, false, true, false, "Car2Go", 25.789, -45.785, null, null, null, null, 0.0, null, 2, "18/05/2020, 14:24", 29.6));
		assertEquals(new Integer(123), res.getGasStationId());
		assertEquals("Eni", res.getGasStationName());
		assertEquals("Via Garibaldi 33", res.getGasStationAddress());
		assertTrue(res.getHasDiesel());
		assertTrue(res.getHasSuper());
		assertFalse(res.getHasSuperPlus());
		assertTrue(res.getHasGas());
		assertTrue(res.getHasMethane());
		assertFalse(res.getHasPremiumDiesel());
		assertEquals("Car2Go",res.getCarSharing());
		assertEquals(11.233, res.getLat(),0.1);
		assertEquals(47.304, res.getLon(),0.1);
		assertEquals(1.225,res.getDieselPrice(),0.1);
		assertEquals(2.553,res.getSuperPrice(),0.1);
		assertNull(res.getSuperPlusPrice());
		assertEquals(2.098,res.getGasPrice(),0.1);
		assertEquals(1.003,res.getMethanePrice(),0.1);
		assertNull(res.getPremiumDieselPrice());
		assertEquals(new Integer(42),res.getReportUser());
		assertEquals("18/05/2020, 19:00", res.getReportTimestamp());
		assertEquals(23.6,res.getReportDependability(),0.1);

	}
	@Test
	public void testSaveGasStation6() throws PriceException, GPSDataException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		GasStationDto res = GsService.saveGasStation(new GasStationDto(null, "Agip", "Indirizzo Fake", false, true, false, false, true, false, "Car2Go", 25.789, -45.785, null, null, null, null, 0.0, null, 2, "18/05/2020, 14:24", 29.6));
		assertEquals(new Integer(123), res.getGasStationId());
		assertEquals("Eni", res.getGasStationName());
		assertEquals("Via Garibaldi 33", res.getGasStationAddress());
		assertTrue(res.getHasDiesel());
		assertTrue(res.getHasSuper());
		assertFalse(res.getHasSuperPlus());
		assertTrue(res.getHasGas());
		assertTrue(res.getHasMethane());
		assertFalse(res.getHasPremiumDiesel());
		assertEquals("Car2Go",res.getCarSharing());
		assertEquals(11.233, res.getLat(),0.1);
		assertEquals(47.304, res.getLon(),0.1);
		assertEquals(1.225,res.getDieselPrice(),0.1);
		assertEquals(2.553,res.getSuperPrice(),0.1);
		assertNull(res.getSuperPlusPrice());
		assertEquals(2.098,res.getGasPrice(),0.1);
		assertEquals(1.003,res.getMethanePrice(),0.1);
		assertNull(res.getPremiumDieselPrice());
		assertEquals(new Integer(42),res.getReportUser());
		assertEquals("18/05/2020, 19:00", res.getReportTimestamp());
		assertEquals(23.6,res.getReportDependability(),0.1);

	}

	@Test
	public void testGetAllGasStations1() {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		List<GasStationDto> res = GsService.getAllGasStations();
		assertEquals(new Integer(120), res.get(0).getGasStationId());
		assertEquals("DB Carburanti", res.get(0).getGasStationName());
		assertEquals("Viale Trieste 135", res.get(0).getGasStationAddress());
		assertTrue(res.get(0).getHasDiesel());
		assertTrue(res.get(0).getHasSuper());
		assertFalse(res.get(0).getHasSuperPlus());
		assertFalse(res.get(0).getHasGas());
		assertTrue(res.get(0).getHasMethane());
		assertEquals("Enjoy",res.get(0).getCarSharing());
		assertEquals(-25.789, res.get(0).getLat(),0.1);
		assertEquals(45.785, res.get(0).getLon(),0.1);
		assertEquals(0,res.get(0).getDieselPrice(),0.1);
		assertEquals(0,res.get(0).getSuperPrice(),0.1);
		assertNull(res.get(0).getSuperPlusPrice());
		assertNull(res.get(0).getGasPrice());
		assertEquals(0,res.get(0).getMethanePrice(),0.1);
		assertEquals(new Integer(23),res.get(0).getReportUser());
		assertEquals("19/05/2020, 11:24", res.get(0).getReportTimestamp());
		assertEquals(25.6,res.get(0).getReportDependability(),0.1);
	}

	@Test
	public void testGetAllGasStations2() {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		List<GasStationDto> res = GsService.getAllGasStations();
		assertEquals(new Integer(4), res.size(),0.1);
	}

	@Test
	public void deleteGasStation1() {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		try {
			assertTrue(GsService.deleteGasStation(122)); 
		} catch (InvalidGasStationException e) {
			fail();
		}
	}

	@Test(expected = InvalidGasStationException.class)
	public void testDeleteGasStation2() throws InvalidGasStationException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		GsService.deleteGasStation(-5);
	}

	@Test
	public void testGetGasStationsByGasolineType1() throws InvalidGasTypeException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		List<GasStationDto> res = GsService.getGasStationsByGasolineType("Diesel");
		assertEquals(new Integer(120), res.get(0).getGasStationId());
		assertEquals("DB Carburanti", res.get(0).getGasStationName());
		assertEquals("Viale Trieste 135", res.get(0).getGasStationAddress());
		assertTrue(res.get(0).getHasDiesel());
		assertTrue(res.get(0).getHasSuper());
		assertFalse(res.get(0).getHasSuperPlus());
		assertFalse(res.get(0).getHasGas());
		assertTrue(res.get(0).getHasMethane());
		assertEquals("Enjoy",res.get(0).getCarSharing());
		assertEquals(-25.789, res.get(0).getLat(),0.1);
		assertEquals(45.785, res.get(0).getLon(),0.1);
		assertEquals(0,res.get(0).getDieselPrice(),0.1);
		assertEquals(0,res.get(0).getSuperPrice(),0.1);
		assertNull(res.get(0).getSuperPlusPrice());
		assertNull(res.get(0).getGasPrice());
		assertEquals(0,res.get(0).getMethanePrice(),0.1);
		assertEquals(new Integer(23),res.get(0).getReportUser());
		assertEquals("19/05/2020, 11:24", res.get(0).getReportTimestamp());
		assertEquals(25.6,res.get(0).getReportDependability(),0.1);
	}

	@Test(expected = InvalidGasTypeException.class)
	public void testGetGasStationsByGasolineType2() throws InvalidGasTypeException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		GsService.getGasStationsByGasolineType("ciao");
	}

	@Test
	public void testGetGasStationsByGasolineType3() {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		List<GasStationDto> res;
		try {
			res = GsService.getGasStationsByGasolineType("Diesel");
			assertEquals(3,res.size());
		} catch (InvalidGasTypeException e) {
			fail();
		}
	}

	@Test
	public void testGetGasStationsByProximity1() {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		try {
			List<GasStationDto> res = GsService.getGasStationsByProximity(-25.789, 45.785); //attenzione, vedere quanto vale la distanza
			assertEquals(new Integer(120), res.get(0).getGasStationId());
			assertEquals("DB Carburanti", res.get(0).getGasStationName());
			assertEquals("Viale Trieste 135", res.get(0).getGasStationAddress());
			assertTrue(res.get(0).getHasDiesel());
			assertTrue(res.get(0).getHasSuper());
			assertFalse(res.get(0).getHasSuperPlus());
			assertFalse(res.get(0).getHasGas());
			assertTrue(res.get(0).getHasMethane());
			assertEquals("Enjoy",res.get(0).getCarSharing());
			assertEquals(-25.789, res.get(0).getLat(),0.1);
			assertEquals(45.785, res.get(0).getLon(),0.1);
			assertEquals(0,res.get(0).getDieselPrice(),0.1);
			assertEquals(0,res.get(0).getSuperPrice(),0.1);
			assertNull(res.get(0).getSuperPlusPrice());
			assertNull(res.get(0).getGasPrice());
			assertEquals(0,res.get(0).getMethanePrice(),0.1);
			assertEquals(new Integer(23),res.get(0).getReportUser());
			assertEquals("19/05/2020, 11:24", res.get(0).getReportTimestamp());
			assertEquals(25.6,res.get(0).getReportDependability(),0.1);
		} catch (GPSDataException e) {
			fail();
		}
	}

	@Test(expected = GPSDataException.class)
	public void testGetGasStationsByProximity2() throws GPSDataException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		GsService.getGasStationsByProximity(-2000, 67.44);
	}

	@Test(expected = GPSDataException.class)
	public void testGetGasStationsByProximity3() throws GPSDataException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		GsService.getGasStationsByProximity(-33.555, 854);
	}

	@Test
	public void testGetGasStationsByProximity4() {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);

		try {
			List<GasStationDto> res = GsService.getGasStationsByProximity(-25.789, 45.785);
			assertEquals(1, res.size());
		} catch (GPSDataException e) {
			fail();
		}
	}

	@Test
	public void testGetGasStationsByCarSharing1() {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		List<GasStationDto> res = GsService.getGasStationByCarSharing("Enjoy");
		assertEquals(new Integer(120), res.get(0).getGasStationId());
		assertEquals("DB Carburanti", res.get(0).getGasStationName());
		assertEquals("Viale Trieste 135", res.get(0).getGasStationAddress());
		assertTrue(res.get(0).getHasDiesel());
		assertTrue(res.get(0).getHasSuper());
		assertFalse(res.get(0).getHasSuperPlus());
		assertFalse(res.get(0).getHasGas());
		assertTrue(res.get(0).getHasMethane());
		assertEquals("Enjoy",res.get(0).getCarSharing());
		assertEquals(-25.789, res.get(0).getLat(),0.1);
		assertEquals(45.785, res.get(0).getLon(),0.1);
		assertEquals(0,res.get(0).getDieselPrice(),0.1);
		assertEquals(0,res.get(0).getSuperPrice(),0.1);
		assertNull(res.get(0).getSuperPlusPrice());
		assertNull(res.get(0).getGasPrice());
		assertEquals(0,res.get(0).getMethanePrice(),0.1);
		assertEquals(new Integer(23),res.get(0).getReportUser());
		assertEquals("19/05/2020, 11:24", res.get(0).getReportTimestamp());
		assertEquals(25.6,res.get(0).getReportDependability(),0.1);
	}

	@Test
	public void testGetGasStationsByCarSharing2() {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		List<GasStationDto> res = GsService.getGasStationByCarSharing("null");
		assertEquals(4, res.size());
	}

	@Test
	public void testGetGasStationsByCarSharing3() {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		List<GasStationDto> res = GsService.getGasStationByCarSharing("Car2Go");
		assertEquals(2, res.size());
	}


	@Test
	public void testGetGasStationsWithoutCoordinates1() {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		try {
			List<GasStationDto> res = GsService.getGasStationsWithoutCoordinates("Diesel", "Enjoy");
			assertEquals(new Integer(120), res.get(0).getGasStationId());
			assertEquals("DB Carburanti", res.get(0).getGasStationName());
			assertEquals("Viale Trieste 135", res.get(0).getGasStationAddress());
			assertTrue(res.get(0).getHasDiesel());
			assertTrue(res.get(0).getHasSuper());
			assertFalse(res.get(0).getHasSuperPlus());
			assertFalse(res.get(0).getHasGas());
			assertTrue(res.get(0).getHasMethane());
			assertEquals("Enjoy",res.get(0).getCarSharing());
			assertEquals(-25.789, res.get(0).getLat(),0.1);
			assertEquals(45.785, res.get(0).getLon(),0.1);
			assertEquals(0,res.get(0).getDieselPrice(),0.1);
			assertEquals(0,res.get(0).getSuperPrice(),0.1);
			assertNull(res.get(0).getSuperPlusPrice());
			assertNull(res.get(0).getGasPrice());
			assertEquals(0,res.get(0).getMethanePrice(),0.1);
			assertEquals(new Integer(23),res.get(0).getReportUser());
			assertEquals("19/05/2020, 11:24", res.get(0).getReportTimestamp());
			assertEquals(25.6,res.get(0).getReportDependability(),0.1);
		} catch (InvalidGasTypeException | InvalidCarSharingException e) {
			fail();
		}
	}

	@Test(expected = InvalidGasTypeException.class)
	public void testGetGasStationsWithoutCoordinates2() throws InvalidGasTypeException, InvalidCarSharingException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		GsService.getGasStationsWithoutCoordinates("ciao", "enjoy");
	}

	@Test
	public void testGasStationsWithoutCoordinates3() {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		try {
			List<GasStationDto> res = GsService.getGasStationsWithoutCoordinates("Gas", "Enjoy");
			assertEquals(1, res.size());
		} catch (InvalidGasTypeException | InvalidCarSharingException e) {
			fail();
		}
	}
	
	/*V2*/
	@Test(expected = InvalidCarSharingException.class)
	public void testGetGasStationsWithoutCoordinates4() throws InvalidGasTypeException, InvalidCarSharingException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		GsService.getGasStationsWithoutCoordinates("Diesel", "AAAAAAAAAA");
	}

	@Test
	public void testGetGasStationsWithCoordinates1() throws InvalidGasTypeException, GPSDataException, InvalidCarSharingException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);

		List<GasStationDto> res = GsService.getGasStationsWithCoordinates(-25.789, 45.785, 1, "Diesel", "Enjoy");	 
		assertEquals(new Integer(120), res.get(0).getGasStationId());
		assertEquals("DB Carburanti", res.get(0).getGasStationName());
		assertEquals("Viale Trieste 135", res.get(0).getGasStationAddress());
		assertTrue(res.get(0).getHasDiesel());
		assertTrue(res.get(0).getHasSuper());
		assertFalse(res.get(0).getHasSuperPlus());
		assertFalse(res.get(0).getHasGas());
		assertTrue(res.get(0).getHasMethane());
		assertEquals("Enjoy",res.get(0).getCarSharing());
		assertEquals(-25.789, res.get(0).getLat(),0.1);
		assertEquals(45.785, res.get(0).getLon(),0.1);
		assertEquals(0,res.get(0).getDieselPrice(),0.1);
		assertEquals(0,res.get(0).getSuperPrice(),0.1);
		assertNull(res.get(0).getSuperPlusPrice());
		assertNull(res.get(0).getGasPrice());
		assertEquals(0,res.get(0).getMethanePrice(),0.1);
		assertEquals(new Integer(23),res.get(0).getReportUser());
		assertEquals("19/05/2020, 11:24", res.get(0).getReportTimestamp());
		assertEquals(25.6,res.get(0).getReportDependability(),0.1);
	}

	@Test(expected = GPSDataException.class)
	public void testGetGasStationsWithCoordinates2() throws InvalidGasTypeException, GPSDataException, InvalidCarSharingException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		GsService.getGasStationsWithCoordinates(-2000, 45.785, 1, "Diesel", "Enjoy");
	}

	@Test(expected = GPSDataException.class)
	public void testGetGasStationsWithCoordinates3() throws InvalidGasTypeException, GPSDataException, InvalidCarSharingException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		GsService.getGasStationsWithCoordinates(-25.789, 420, 1, "Diesel", "Enjoy");
	}

	@Test(expected = InvalidGasTypeException.class)
	public void testGetGasStationsWithCoordinates4() throws InvalidGasTypeException, GPSDataException, InvalidCarSharingException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		GsService.getGasStationsWithCoordinates(-25.789, 45.785, 1, "ciao", "Enjoy");
	}

	@Test
	public void testGetGasStationsWithCoordinates5() throws InvalidGasTypeException, GPSDataException, InvalidCarSharingException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);

		List<GasStationDto> res = GsService.getGasStationsWithCoordinates(-25.789, 45.785, 1, "Gas", "Enjoy");
		assertEquals(0, res.size());
	}

	@Test
	public void testGetGasStationsWithCoordinates6() throws InvalidGasTypeException, GPSDataException, InvalidCarSharingException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);

		List<GasStationDto> res = GsService.getGasStationsWithCoordinates(-25.789, 45.785, 1, "Diesel", "Enjoy");
		assertEquals(1, res.size());
	}
	
	/*V2*/
	@Test(expected = InvalidCarSharingException.class)
	public void testGetGasStationsWithCoordinates7() throws InvalidGasTypeException, GPSDataException, InvalidCarSharingException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		GsService.getGasStationsWithCoordinates(-25.789, 12.66, 1, "Diesel", "AAAAAAAAAAAA");
	}


	@Test
	public void testSetReport1() throws InvalidGasStationException, PriceException, InvalidUserException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		UserServiceimpl UserServ = new UserServiceimpl(mockUR);

		GsService.setReport(123, 1.225, 2.553, null, 2.098, 1.003, null, 42);
		GasStationDto res = GsService.getGasStationById(123);
		UserDto uRes = UserServ.getUserById(42);
		assertTrue(res.getHasDiesel());
		assertTrue(res.getHasSuper());
		assertFalse(res.getHasSuperPlus());
		assertTrue(res.getHasGas());
		assertTrue(res.getHasMethane());
		assertFalse(res.getHasPremiumDiesel());
		assertEquals(1.225,res.getDieselPrice(),0.1);
		assertEquals(2.553,res.getSuperPrice(),0.1);
		assertNull(res.getSuperPlusPrice());
		assertEquals(2.098,res.getGasPrice(),0.1);
		assertEquals(1.003,res.getMethanePrice(),0.1);
		assertNull(res.getPremiumDieselPrice());
		assertEquals(new Integer(42),uRes.getUserId());
		assertEquals("Cloud Strife", uRes.getUserName());
		assertEquals("Shinra_sucks",uRes.getPassword());
		assertEquals("SOLDIERguy@avalanche.com", uRes.getEmail());
		assertEquals(new Integer(5),uRes.getReputation());
		assertTrue(uRes.getAdmin());
		//assertEquals(new Date().toString(), res.getReportTimestamp()); A volte c'è differenza tra i due timeStamp di un secondo
		assertEquals(100,res.getReportDependability(),0.1);
		assertEquals(new Integer(42), res.getReportUser());

	}

	@Test(expected = InvalidGasStationException.class)
	public void testSetReport2() throws InvalidGasStationException, PriceException, InvalidUserException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		GsService.setReport(12, 1.225, 2.553, null, 2.098, 1.003, null, 42);
	}

	@Test(expected = PriceException.class)
	public void testSetReport3() throws InvalidGasStationException, PriceException, InvalidUserException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		GsService.setReport(121, null, null, null, null, 0.0, null, 42);
	}

	@Test(expected = InvalidUserException.class)
	public void testSetReport4() throws InvalidGasStationException, PriceException, InvalidUserException {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		GsService.setReport(123, 1.225, 2.553, null, 2.098, 1.003, null, 13);
	}

	@Test
	public void mapGasolineTypeToMethod1() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method example = GasStationServiceimpl.class.getDeclaredMethod("mapGasolineTypeToMethod", String.class);
		example.setAccessible(true);

		Predicate<GasStationDto> res = (Predicate<GasStationDto>) example.invoke(new GasStationServiceimpl(mockGSR, mockUR), "Diesel");
		assertTrue(res.test(GasStationMapper.toGSDto(new GasStation("DB Carburanti", "Viale Trieste 135", true, true, false, false, true, false, "Enjoy", -25.789, 45.785, 0.0, 0.0, null, null, 0.0, null, 23, "19/05/2020, 11:24", 25.6))));
		assertFalse(res.test(GasStationMapper.toGSDto(new GasStation("DB Carburanti", "Viale Trieste 135", false, true, false, false, true, false, "Enjoy", -25.789, 45.785, 0.0, 0.0, null, null, 0.0, null, 23, "19/05/2020, 11:24", 25.6))));
	}

	@Test
	public void testPriceCorrect1() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		GasStationDto gsDto = new GasStationDto(123,"Eni", "Via Garibaldi 33", true, true, false, true, true, false, "Car2Go", 11.233, 47.304, 1.225, 2.553, null, 2.098, 1.003, null, 42, "18/05/2020, 19:00", 23.6);
		Method example = GasStationServiceimpl.class.getDeclaredMethod("priceCorrect", GasStationDto.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(mockGSR, mockUR), gsDto);
		assertTrue(res);
	}

	@Test
	public void testPriceCorrect2() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		GasStationDto gsDto = new GasStationDto(123,"Eni", "Via Garibaldi 33", true, true, false, true, true, false, "Car2Go", 11.233, 47.304, null, 2.553, null, 2.098, 1.003, null, 42, "18/05/2020, 19:00", 23.6);
		Method example = GasStationServiceimpl.class.getDeclaredMethod("priceCorrect", GasStationDto.class);
		example.setAccessible(true);

		boolean res = (boolean) example.invoke(new GasStationServiceimpl(mockGSR, mockUR), gsDto);
		assertFalse(res);
	}
}
