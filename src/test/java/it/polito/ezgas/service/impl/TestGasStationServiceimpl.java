package it.polito.ezgas.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
}
