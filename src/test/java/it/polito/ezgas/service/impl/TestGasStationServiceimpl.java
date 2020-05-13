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
}
