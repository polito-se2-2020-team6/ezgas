package it.polito.ezgas.service.impl;

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
}
