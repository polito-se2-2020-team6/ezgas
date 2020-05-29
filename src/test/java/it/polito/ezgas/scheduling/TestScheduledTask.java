package it.polito.ezgas.scheduling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.repository.UserRepository;

@SpringBootTest
public class TestScheduledTask {

	@Mock 
	GasStationRepository mockGSR;
	@Mock
	UserRepository mockUR;

	static DateFormat df;

	@BeforeClass
	public static void setUpClass() {
		df = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss", Locale.ENGLISH);
	}

	@Before
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
		try {
			test.setNow(df.parse("2020-05-25 21:00:00"));
			Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
			func.setAccessible(true);

			double res = (double) func.invoke(test, "Mon May 24 21:00:00 CEST 2020", 42);
			assertEquals(50+50*(6.0/7.0), res, 0.001);
		} catch ( IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ParseException e) {
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
		try {
			test.setNow(df.parse("2020-05-25 21:00:00"));
			Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
			func.setAccessible(true);

			double res = (double) func.invoke(test, "Mon May 24 21:00:00 CEST 2020", 42);
			assertEquals(50+50*(6.0/7.0), res, 0.001);
		} catch ( IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ParseException e) {
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
		try {
			test.setNow(df.parse("2020-05-25 21:00:00"));
			Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
			func.setAccessible(true);

			double res = (double) func.invoke(test, "Mon May 15 17:08:15 CEST 2020", 42);
			assertEquals(50, res, 0.001);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ParseException e) {
			fail("error");
		}
	}

	@Test
	public void testComputeNewDependability4() {
		ScheduledTasks test = new ScheduledTasks(mockUR, mockGSR);

		try {
			test.setNow(df.parse("2020-05-25 21:00:00"));
			Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
			func.setAccessible(true);

			double res = (double) func.invoke(test, "Mon May 15 17:08:15 CEST 2020", 42);
			assertEquals(50, res, 0.001);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ParseException e) {
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

		try {
			test.setNow(df.parse("2020-05-25 21:00:00"));
			Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
			func.setAccessible(true);

			double res = (double) func.invoke(test, "Mon May 23 21:00:00 CEST 2020", 42);
			assertEquals(25+50*(5/7.0), res, 0.001);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ParseException e) {
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

		try {
			test.setNow(df.parse("2020-05-25 21:00:00"));
			Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
			func.setAccessible(true);

			double res = (double) func.invoke(test, "Mon May 20 21:00:00 CEST 2020", 42);
			assertEquals(10+50*(2/7.0), res, 0.001);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ParseException e) {
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

		try {
			test.setNow(df.parse("2020-05-25 21:00:00"));
			Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
			func.setAccessible(true);

			double res = (double) func.invoke(test, "Mon May 25 21:00:00 CEST 2020", 42);
			assertEquals(100, res, 0.001);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ParseException e) {
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

		try {
			test.setNow(df.parse("2020-05-25 21:00:00"));
			Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
			func.setAccessible(true);

			double res = (double) func.invoke(test, "Mon May 25 21:00:00 CEST 2020", 42);
			assertEquals(50, res, 0.001);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ParseException e) {
			fail("error");
		}
	}
}
