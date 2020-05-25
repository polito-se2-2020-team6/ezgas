package it.polito.ezgas.scheduling;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.repository.UserRepository;

@SpringBootTest
public class TestScheduledTask {
	
	@Mock 
	GasStationRepository mockGSR;
	UserRepository mockUR;
	
	@BeforeEach
	public void setUp() {
		User dummyU = new User("Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", 5);
		dummyU.setUserId(42);
		dummyU.setAdmin(true);

		mockUR = mock(UserRepository.class);
		mockGSR = mock(GasStationRepository.class);
		
		when(mockUR.findOne(eq(42))).thenReturn(dummyU);

	}

	@Test
	public void testComputeNewDependability1() {
		ScheduledTasks test = new ScheduledTasks(mockUR, mockGSR);
		test.setNow(new Date(2020-1900, 4, 25, 20, 00, 00));
		try {
			Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
			func.setAccessible(true);

			double res = (double) func.invoke(test, "Mon May 24 17:08:15 CEST 2020", 42);
			assertEquals( 50+50*(6.0/7.0), res);
		} catch ( IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			fail("error");
		}

		}
		
		
	
	
	@Test
	public void testComputeNewDependability2() {
		ScheduledTasks test = new ScheduledTasks(mockUR, mockGSR);
		User dummyU = new User("Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", 5);
		dummyU.setUserId(42);
		dummyU.setAdmin(true);
		Map<Integer, User> users = new HashMap<>();;
		users.put(42,  dummyU);
		test.setSeenUsers(users);
		test.setNow(new Date(2020-1900, 4, 25, 20, 00, 00));
		try {
			Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
			func.setAccessible(true);

			double res = (double) func.invoke(test, "Mon May 24 17:08:15 CEST 2020", 42);
			assertEquals(50+50*(6/7.0), res);
		} catch ( IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			fail("error");
		}
	}
	
	@Test
	public void testComputeNewDependability3() {
		ScheduledTasks test = new ScheduledTasks(mockUR, mockGSR);
		User dummyU = new User("Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", 5);
		dummyU.setUserId(42);
		dummyU.setAdmin(true);
		Map<Integer, User> users = new HashMap<>();;
		users.put(42,  dummyU);
		test.setSeenUsers(users);
		test.setNow(new Date(2020-1900, 4, 25, 20, 00, 00));
		try {
			Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
			func.setAccessible(true);

			double res = (double) func.invoke(test, "Mon May 15 17:08:15 CEST 2020", 42);
			assertEquals(50, res);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			fail("error");
		}
	}
		
		@Test
		public void testComputeNewDependability4() {
			ScheduledTasks test = new ScheduledTasks(mockUR, mockGSR);
			test.setNow(new Date(2020-1900, 4, 25, 20, 00, 00));

			try {
				Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
				func.setAccessible(true);

				double res = (double) func.invoke(test, "Mon May 15 17:08:15 CEST 2020", 42);
				assertEquals(50, res);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				fail("error");
			}
	}
		
		@Test
		public void testComputeNewDependability5() {
			ScheduledTasks test = new ScheduledTasks(mockUR, mockGSR);
			User dummyU = new User("Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", 0);
			dummyU.setUserId(42);
			dummyU.setAdmin(true);
			Map<Integer, User> users = new HashMap<>();;
			users.put(42,  dummyU);
			test.setSeenUsers(users);
			test.setNow(new Date(2020-1900, 4, 25, 20, 00, 00));

			try {
				Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
				func.setAccessible(true);

				double res = (double) func.invoke(test, "Mon May 23 17:08:15 CEST 2020", 42);
				assertEquals(25+50*(5/7.0), res);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				fail("error");
			}

		}
		@Test
		public void testComputeNewDependability6() {
			ScheduledTasks test = new ScheduledTasks(mockUR, mockGSR);
			User dummyU = new User("Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", -3);
			dummyU.setUserId(42);
			dummyU.setAdmin(true);
			Map<Integer, User> users = new HashMap<>();;
			users.put(42,  dummyU);
			test.setSeenUsers(users);
			test.setNow(new Date(2020-1900, 4, 25, 20, 00, 00));

			try {
				Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
				func.setAccessible(true);

				double res = (double) func.invoke(test, "Mon May 20 17:08:15 CEST 2020", 42);
				assertEquals(10+50*(2/7.0), res);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				fail("error");
			}

		}
		@Test
		public void testComputeNewDependability7() {
			ScheduledTasks test = new ScheduledTasks(mockUR, mockGSR);
			User dummyU = new User("Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", 5);
			dummyU.setUserId(42);
			dummyU.setAdmin(true);
			Map<Integer, User> users = new HashMap<>();;
			users.put(42,  dummyU);
			test.setSeenUsers(users);
			test.setNow(new Date(2020-1900, 4, 25, 20, 00, 00));

			try {
				Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
				func.setAccessible(true);

				double res = (double) func.invoke(test, "Mon May 25 17:08:15 CEST 2020", 42);
				assertEquals( 100, res);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				fail("error");
			}

		}
		@Test
		public void testComputeNewDependability8() {
			ScheduledTasks test = new ScheduledTasks(mockUR, mockGSR);
			User dummyU = new User("Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", -5);
			dummyU.setUserId(42);
			dummyU.setAdmin(true);
			Map<Integer, User> users = new HashMap<>();;
			users.put(42,  dummyU);
			test.setSeenUsers(users);
			test.setNow(new Date(2020-1900, 4, 25, 20, 00, 00));

			try {
				Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
				func.setAccessible(true);

				double res = (double) func.invoke(test, "Mon May 25 17:08:15 CEST 2020", 42);
				assertEquals( 50, res);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				fail("error");
			}

		}
}
		
