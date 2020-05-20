package it.polito.ezgas.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import exception.InvalidGasStationException;
import exception.InvalidUserException;
import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.repository.UserRepository;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestGasStationServiceimpl {

	@Test
	public void testIsGasolineTypeValid1() {
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("isGasolineTypeValid", String.class);
			example.setAccessible(true);
			
			boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), "");
			assertFalse(res);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}
	
	@Test
	public void testIsGasolineTypeValid2() {
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("isGasolineTypeValid", String.class);
			example.setAccessible(true);
			
			boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), "ciao");
			assertFalse(res);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}
	
	@Test
	public void testIsGasolineTypeValid3() {
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("isGasolineTypeValid", String.class);
			example.setAccessible(true);
			
			boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), "Methane");
			assertTrue(res);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}
	
	@Test
	public void testIsGasolineTypeValid4() {
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("isGasolineTypeValid", String.class);
			example.setAccessible(true);
			
			boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), "Gas");
			assertTrue(res);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}
	
	@Test
	public void testIsGasolineTypeValid5() {
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("isGasolineTypeValid", String.class);
			example.setAccessible(true);
			
			boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), "Diesel");
			assertTrue(res);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}
	
	@Test
	public void testIsGasolineTypeValid6() {
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("isGasolineTypeValid", String.class);
			example.setAccessible(true);
			
			boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), "Super");
			assertTrue(res);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}
	
	@Test
	public void testIsGasolineTypeValid7() {
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("isGasolineTypeValid", String.class);
			example.setAccessible(true);
			
			boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), "SuperPlus");
			assertTrue(res);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}
	
	@Test
	public void testIsGasolineTypeValid8() {
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("isGasolineTypeValid", String.class);
			example.setAccessible(true);
			
			boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), "null");
			assertTrue(res);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}
	
	@Test
	public void testIsGasolineTypeValid9() {
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("isGasolineTypeValid", String.class);
			example.setAccessible(true);
			
			boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), (String)null);
			assertFalse(res);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}
	
	@Test

	public void testGeoPointDistance1(){
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
			example.setAccessible(true);			
			double res = (double) example.invoke(new GasStationServiceimpl(null, null), -30.10,-100.2,-40.6,20.3);
			assertEquals(10051.81,res,1);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}	
	@Test
	public void testGeoPointDistance2(){
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
			example.setAccessible(true);
			
			double res = (double) example.invoke(new GasStationServiceimpl(null, null), Math.nextAfter(-90,Double.POSITIVE_INFINITY),-100.4,20.43,61.6);
			assertEquals(12278.67,res,1);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}	
	@Test
	public void testGeoPointDistance3(){
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
			example.setAccessible(true);
			
			double res = (double) example.invoke(new GasStationServiceimpl(null, null), Math.nextAfter(90,Double.NEGATIVE_INFINITY),65.21,-25.6,120.34);
			assertEquals(12853.52,res,1);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}	
	@Test
	public void testGeoPointDistance4(){
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
			example.setAccessible(true);
			
			double res = (double) example.invoke(new GasStationServiceimpl(null, null), 90,89.90,-26.7,55.7);
			assertEquals(12975.82,res,1);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}	
	@Test
	public void testGeoPointDistance5(){
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
			example.setAccessible(true);
			
			double res = (double) example.invoke(new GasStationServiceimpl(null, null), -30.4,Math.nextAfter(-180,Double.POSITIVE_INFINITY),36.43,-100.4);
			assertEquals(11129.19,res,1);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}	
	@Test
	public void testGeoPointDistance6(){
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
			example.setAccessible(true);
			
			double res = (double) example.invoke(new GasStationServiceimpl(null, null), 29.09,Math.nextAfter(180,Double.NEGATIVE_INFINITY),-50.34,-103.34);
			assertEquals(11587.9,res,1);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}
	@Test
	public void testGeoPointDistance7(){
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
			example.setAccessible(true);
			
			double res = (double) example.invoke(new GasStationServiceimpl(null, null), -45.54,180,-21.43,103.54);
			assertEquals(7291.82,res,1);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}	
	}
	@Test
	public void testGeoPointDistance8(){
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
			example.setAccessible(true);
			
			double res = (double) example.invoke(new GasStationServiceimpl(null, null), 22.22,-102.34,Math.nextAfter(-90,Double.POSITIVE_INFINITY),27.76);
			assertEquals(12477.69,res,1);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}							
	}	
	@Test
	public void testGeoPointDistance9(){
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
			example.setAccessible(true);
			
			double res = (double) example.invoke(new GasStationServiceimpl(null, null), -80.76,-170.54,Math.nextAfter(90,Double.NEGATIVE_INFINITY),102.54);
			assertEquals(18986.73,res,1);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}	
	}
	@Test
	public void testGeoPointDistance10(){
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
			example.setAccessible(true);
			
			double res = (double) example.invoke(new GasStationServiceimpl(null, null), -43.56,109.34,90,99.09);
			assertEquals(14850.48,res,1);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}	
	}
	@Test
	public void testGeoPointDistance11(){
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
			example.setAccessible(true);
			
			double res = (double) example.invoke(new GasStationServiceimpl(null, null), -30.54,103.54,-76.76,Math.nextAfter(-180,Double.POSITIVE_INFINITY));
			assertEquals(6366.8,res,1);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}	
	}	
	@Test
	public void testGeoPointDistance12(){
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
			example.setAccessible(true);
			
			double res = (double) example.invoke(new GasStationServiceimpl(null, null), 31.67,66.78,89.43,Math.nextAfter(180,Double.NEGATIVE_INFINITY));
			assertEquals(6510.84,res,1);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}	
	}
	@Test
	public void testGeoPointDistance13(){
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("geoPointDistance", double.class, double.class, double.class, double.class);
			example.setAccessible(true);
			
			double res = (double) example.invoke(new GasStationServiceimpl(null, null), 55.76,-59.76,30.88,180);
			assertEquals(8846.99,res,1);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}	
	}	
	@Test
	public void testLatLonCorrect1() {
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("latLonCorrect", double.class, double.class);
			example.setAccessible(true);
			
			boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), -90.0, -180.0);
			assertFalse(res);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}
	@Test
	public void testLatLonCorrect2() {
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("latLonCorrect", double.class, double.class);
			example.setAccessible(true);
			
			boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), Math.nextAfter(-90, Double.NEGATIVE_INFINITY), 150.0);
			assertFalse(res);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}
	@Test
	public void testLatLonCorrect3() {
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("latLonCorrect", double.class, double.class);
			example.setAccessible(true);
			
			boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), Math.nextAfter(-90, Double.POSITIVE_INFINITY), Math.nextAfter(-180, Double.NEGATIVE_INFINITY));
			assertFalse(res);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}
	@Test
	public void testLatLonCorrect4() {
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("latLonCorrect", double.class, double.class);
			example.setAccessible(true);
			
			boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), 0.0, -180.0);
			assertFalse(res);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}
	@Test
	public void testLatLonCorrect5() {
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("latLonCorrect", double.class, double.class);
			example.setAccessible(true);
			
			boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), 90.0, 180.0);
			assertTrue(res);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}
	@Test
	public void testLatLonCorrect6() {
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("latLonCorrect", double.class, double.class);
			example.setAccessible(true);
			
			boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), Math.nextAfter(90, Double.NEGATIVE_INFINITY), Math.nextAfter(180, Double.NEGATIVE_INFINITY));
			assertTrue(res);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}
	@Test
	public void testLatLonCorrect7() {
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("latLonCorrect", double.class, double.class);
			example.setAccessible(true);
			
			boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), Math.nextAfter(-90.0, Double.POSITIVE_INFINITY), Math.nextAfter(-180.0, Double.POSITIVE_INFINITY));
			assertTrue(res);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}
	@Test
	public void testLatLonCorrect8() {
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("latLonCorrect", double.class, double.class);
			example.setAccessible(true);
			
			boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), 0.0, 0.0);
			assertTrue(res);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}
	@Test
	public void testLatLonCorrect9() {
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("latLonCorrect", double.class, double.class);
			example.setAccessible(true);
			
			boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), 0.0, Math.nextAfter(180.0, Double.POSITIVE_INFINITY));
			assertFalse(res);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			fail("Method not found");
		}
	}
	@Test
	public void testLatLonCorrect10() {
		try {
			Method example = GasStationServiceimpl.class.getDeclaredMethod("latLonCorrect", double.class, double.class);
			example.setAccessible(true);
			
			boolean res = (boolean) example.invoke(new GasStationServiceimpl(null, null), Math.nextAfter(90.0, Double.POSITIVE_INFINITY), 50.0);
			assertFalse(res);
		}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			fail("Method not found " );
		}
	}
	List <GasStation>  al;
	
	@Mock 
	GasStationRepository mockGSR;
	UserRepository mockUR;
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();		
	
	@BeforeEach
	public void setUp() {
		GasStation dummyGS1 = new GasStation("DB Carburanti", "Viale Trieste 135", true, true, false, false, true, "Enjoy", -25.789, 45.785, 1.229, 1.456, -1, -1, 1.0345, 23, "19/05/2020, 11:24", 25.6);
		dummyGS1.setGasStationId(120);
		GasStation dummyGS2 = new GasStation("Agip", "Viale Della Rinascita 12", false, true, false, false, true, "Enjoy", 25.789, -45.785, -1, 1.756, -1, -1, 1.3345, 2, "18/05/2020, 14:24", 29.6);
		dummyGS1.setGasStationId(121);
		GasStation dummyGS3 = new GasStation("Q8", "Viale Luigi Monaco 62", true, true, false, true, true, "Enjoy", -56.789, 86.785, 1.529, 1.856, -1, 1.567, 1.0345, 3, "18/05/2020, 09:24", 43.6);
		dummyGS1.setGasStationId(122);
		
		al = new ArrayList<>();
		al.add(dummyGS1);
		al.add(dummyGS2);
		al.add(dummyGS3);
		
		mockUR = Mockito.mock(UserRepository.class);
		mockGSR = Mockito.mock(GasStationRepository.class);
		Mockito.when(mockGSR.findAll()).thenAnswer(new Answer <List<GasStation>>(){
			@Override
			public List <GasStation> answer (InvocationOnMock invocation)throws Throwable {
				return al;
			}		
		});
		
		Mockito.when(mockGSR.findOne(Mockito.eq(120))).thenReturn(dummyGS1);
		//Mockito.when(mockGSR.findOne(Mockito.eq(121))).thenReturn(dummyGS2);
		//Mockito.when(mockGSR.findOne(Mockito.eq(122))).thenReturn(dummyGS3);
		//Mockito.when(mockGSR.findOne(Mockito.eq(-5))).thenReturn(null);
	}	
	
	
	@Test
	public void testGetGasStationById1() {
		GasStationServiceimpl GsService = new GasStationServiceimpl(mockGSR, mockUR);
		Integer prov = 1;
		try {
			GasStationDto res = GsService.getGasStationById(120);
			System.out.println("EEEEEEEE" + res.getGasStationId());
			prov=res.getGasStationId();
			assertEquals(new Integer(120), res.getGasStationId());
		}
		catch(InvalidGasStationException e) {
			fail("exception not expected " + prov);
		}
	}
	
	
	
	
}
