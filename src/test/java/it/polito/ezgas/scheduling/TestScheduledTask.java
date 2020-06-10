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
		df = new SimpleDateFormat("MM-dd-yyyy");
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
	public void testComputeNewDependability1() throws ParseException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ScheduledTasks test = new ScheduledTasks(mockUR, mockGSR);
		test.setNow(df.parse("05-25-2020"));
		Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
		func.setAccessible(true);
		double res = (double) func.invoke(test, "05-24-2020", 42);
		assertEquals(50+50*(6.0/7.0), res, 0.001);

	}

	@Test
	public void testComputeNewDependability2() throws ParseException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ScheduledTasks test = new ScheduledTasks(mockUR, mockGSR);
		User dummyU = new User("Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", 5);
		dummyU.setUserId(42);
		dummyU.setAdmin(true);
		Map<Integer, User> users = new HashMap<>();;
		users.put(42,  dummyU);
		test.setSeenUsers(users);

		test.setNow(df.parse("05-25-2020"));
		Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
		func.setAccessible(true);

		double res = (double) func.invoke(test, "05-24-2020", 42);
		assertEquals(50+50*(6.0/7.0), res, 0.001);
		
	}

	@Test
	public void testComputeNewDependability3() throws ParseException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ScheduledTasks test = new ScheduledTasks(mockUR, mockGSR);
		User dummyU = new User("Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", 5);
		dummyU.setUserId(42);
		dummyU.setAdmin(true);
		Map<Integer, User> users = new HashMap<>();;
		users.put(42,  dummyU);
		test.setSeenUsers(users);

		test.setNow(df.parse("05-25-2020"));
		Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
		func.setAccessible(true);

		double res = (double) func.invoke(test, "05-15-2020", 42);
		assertEquals(50, res, 0.001);
	}

	@Test
	public void testComputeNewDependability4() throws ParseException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ScheduledTasks test = new ScheduledTasks(mockUR, mockGSR);

		test.setNow(df.parse("05-25-2020"));
		Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
		func.setAccessible(true);

		double res = (double) func.invoke(test, "05-15-2020", 42);
		assertEquals(50, res, 0.001);
	}

	@Test
	public void testComputeNewDependability5() throws ParseException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ScheduledTasks test = new ScheduledTasks(mockUR, mockGSR);
		User dummyU = new User("Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", 0);
		dummyU.setUserId(42);
		dummyU.setAdmin(true);
		Map<Integer, User> users = new HashMap<>();;
		users.put(42,  dummyU);
		test.setSeenUsers(users);

		test.setNow(df.parse("05-25-2020"));
		Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
		func.setAccessible(true);

		double res = (double) func.invoke(test, "05-23-2020", 42);
		assertEquals(25+50*(5/7.0), res, 0.001);
	}

	@Test
	public void testComputeNewDependability6() throws ParseException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ScheduledTasks test = new ScheduledTasks(mockUR, mockGSR);
		User dummyU = new User("Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", -3);
		dummyU.setUserId(42);
		dummyU.setAdmin(true);
		Map<Integer, User> users = new HashMap<>();;
		users.put(42,  dummyU);
		test.setSeenUsers(users);

		test.setNow(df.parse("05-25-2020"));
		Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
		func.setAccessible(true);

		double res = (double) func.invoke(test, "05-20-2020", 42);
		assertEquals(10+50*(2/7.0), res, 0.001);
	}

	@Test
	public void testComputeNewDependability7() throws ParseException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ScheduledTasks test = new ScheduledTasks(mockUR, mockGSR);
		User dummyU = new User("Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", 5);
		dummyU.setUserId(42);
		dummyU.setAdmin(true);
		Map<Integer, User> users = new HashMap<>();;
		users.put(42,  dummyU);
		test.setSeenUsers(users);

		test.setNow(df.parse("05-25-2020"));
		Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
		func.setAccessible(true);

		double res = (double) func.invoke(test, "05-25-2020", 42);
		assertEquals(100, res, 0.001);
	}

	@Test
	public void testComputeNewDependability8() throws ParseException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ScheduledTasks test = new ScheduledTasks(mockUR, mockGSR);
		User dummyU = new User("Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", -5);
		dummyU.setUserId(42);
		dummyU.setAdmin(true);
		Map<Integer, User> users = new HashMap<>();;
		users.put(42,  dummyU);
		test.setSeenUsers(users);

		test.setNow(df.parse("05-25-2020"));
		Method func = ScheduledTasks.class.getDeclaredMethod("computeNewDependability", String.class, Integer.class);
		func.setAccessible(true);

		double res = (double) func.invoke(test, "05-25-2020", 42);
		assertEquals(50, res, 0.001);
	}
}
