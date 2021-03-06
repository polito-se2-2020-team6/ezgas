package it.polito.ezgas.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import exception.InvalidLoginDataException;
import exception.InvalidUserException;
import it.polito.ezgas.dto.IdPw;
import it.polito.ezgas.dto.LoginDto;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.UserRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

@SpringBootTest
public class TestUserServiceimpl {

	List<User> al;

	@Mock
	UserRepository mockUR;

	@Before
	public void setUp() {

		User dummyU = new User("Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", 5);
		dummyU.setUserId(42);
		dummyU.setAdmin(true);
		
		User dummyU2 = new User("Lara Croft", "Tomb Raider", "lara.Croft@polito.it", 0);
		dummyU2.setUserId(35);
		dummyU2.setAdmin(true);
		
		User dummyU3 = new User("Sephiroth", "FF7", "BestSong@battle.net", -5);
		dummyU3.setUserId(7);
		dummyU3.setAdmin(true);

		al = new ArrayList<>();
		al.add(dummyU);
		al.add(dummyU2);
		al.add(dummyU3);

		mockUR = mock(UserRepository.class);

		when(mockUR.findAll())
			.thenAnswer(new Answer<List<User>>() {

				@Override
				public List<User> answer(InvocationOnMock invocation) throws Throwable {
					// TODO Auto-generated method stub
					return al;
				}
			});
		
		when(mockUR.findOne(eq(42)))
		.thenReturn(dummyU);
		
		when(mockUR.findOne(eq(35)))
		.thenReturn(dummyU2);
		
		when(mockUR.findOne(eq(7)))
		.thenReturn(dummyU3);

		when(mockUR.findOne(eq(-3)))
		.thenReturn(null);

		when(mockUR.findByEmail(eq("SOLDIERguy@avalanche.com")))
		.thenReturn(dummyU);

		when(mockUR.findByEmail(eq("badEmailemail.com")))
		.thenReturn(null);

		when(mockUR.save(any(User.class)))
		.thenReturn(dummyU);
		
	}

	@Test
	public void testGetUserById1() throws InvalidUserException {
		UserServiceimpl userService = new UserServiceimpl(mockUR);

		UserDto res = userService.getUserById(42);
			assertEquals(new Integer(42), res.getUserId());
	}

	@Test(expected = InvalidUserException.class)
	public void testGetUserById2() throws InvalidUserException {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		userService.getUserById(-3);
	}

	@Test
	public void testSaveUser1() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		
		UserDto res = userService.saveUser(new UserDto(42, "Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", 5));
		
		assertEquals(new Integer(42), res.getUserId());
		assertEquals("Cloud Strife", res.getUserName());
		assertEquals("Shinra_sucks", res.getPassword());
		assertEquals("SOLDIERguy@avalanche.com", res.getEmail());
		assertEquals(new Integer(5), res.getReputation());
		assertEquals(true, res.getAdmin());
	}
	
	@Test
	public void testSaveUser2() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		
		assertNull(userService.saveUser(new UserDto(-3, "Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", 5)));
	}

	@Test
	public void testSaveUser3() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		
		UserDto res = userService.saveUser(new UserDto(42, "Cloud Strife", "Shinra_sucks", "badEmailemail.com", 5));
		assertEquals(new Integer(42), res.getUserId());
		assertEquals("Cloud Strife", res.getUserName());
		assertEquals("Shinra_sucks", res.getPassword());
		assertEquals("SOLDIERguy@avalanche.com", res.getEmail());
		assertEquals(new Integer(5), res.getReputation());
		assertEquals(true, res.getAdmin());
	}
	
	@Test
	public void testSaveUser4() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		
		UserDto res = userService.saveUser(new UserDto(null, "Cloud Strife", "Shinra_sucks", "badEmailemail.com", 5));
		
		assertEquals(new Integer(42), res.getUserId());
		assertEquals("Cloud Strife", res.getUserName());
		assertEquals("Shinra_sucks", res.getPassword());
		assertEquals("SOLDIERguy@avalanche.com", res.getEmail());
		assertEquals(new Integer(5), res.getReputation());
		assertEquals(true, res.getAdmin());
	}

	@Test
	public void testSaveUser5() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		
		assertNull(userService.saveUser(new UserDto(null, "Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", 5)));
	}

	@Test
	public void testDeleteUser1() throws InvalidUserException {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		
			assertTrue(userService.deleteUser(42));
	}

	@Test(expected = InvalidUserException.class)
	public void testDeleteUser2() throws InvalidUserException {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		
		userService.deleteUser(-3);
	}

	@Test
	public void testLogin1() throws InvalidLoginDataException {
		UserServiceimpl userService = new UserServiceimpl(mockUR);		
		IdPw credentials = new IdPw("SOLDIERguy@avalanche.com", "Shinra_sucks");

			LoginDto login = userService.login(credentials);
			assertEquals(credentials.getUser(), login.getEmail());
	}

	@Test(expected = InvalidLoginDataException.class)
	public void testLogin2() throws InvalidLoginDataException {
		UserServiceimpl userService = new UserServiceimpl(mockUR);		
		IdPw credentials = new IdPw("SOLDIERguy@avalanche.com", "wrong password");

		userService.login(credentials);
	}
	
	@Test(expected = InvalidLoginDataException.class)
	public void testLogin3() throws InvalidLoginDataException {
		UserServiceimpl userService = new UserServiceimpl(mockUR);		
		IdPw credentials = new IdPw("badEmailemail.com", "wrong password");

		userService.login(credentials);
	}

	@Test
	public void testGetAllUsers1() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);

		List<UserDto> res = userService.getAllUsers();
		assertEquals(new Integer(42), res.get(0).getUserId());
		assertEquals(new Boolean("True"), res.get(0).getAdmin());
		assertEquals(new String("SOLDIERguy@avalanche.com"), res.get(0).getEmail());
		assertEquals(new String("Shinra_sucks"), res.get(0).getPassword());
		assertEquals(new String("Cloud Strife"), res.get(0).getUserName());
		assertEquals(new Integer(5), res.get(0).getReputation());
		
	}
	
	@Test
	public void testGetAllUsers2() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		al = new ArrayList<>();
		List<UserDto> res2 = userService.getAllUsers();
		assertTrue( res2.isEmpty());
	}
	
	@Test
	public void testIncreaseReputation1() throws InvalidUserException {
		UserServiceimpl userService = new UserServiceimpl(mockUR);

		Integer res = userService.increaseUserReputation(42);
			assertEquals(new Integer(5), res);
		
	}
	
	@Test
	public void testIncreaseReputation2() throws InvalidUserException {
		UserServiceimpl userService = new UserServiceimpl(mockUR);

		Integer res = userService.increaseUserReputation(35);
			assertEquals(new Integer(1), res);
		
	}
	
	@Test
	public void testIncreaseReputation3() throws InvalidUserException {
		UserServiceimpl userService = new UserServiceimpl(mockUR);

		Integer res = userService.increaseUserReputation(7);
			assertEquals(new Integer(-4), res);
	}
	
	@Test(expected = InvalidUserException.class)
	public void testIncreaseReputation4() throws InvalidUserException {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		
			 userService.increaseUserReputation(-3);
			
		
	}
	
	@Test
	public void testDecreaseUserReputation1() throws InvalidUserException {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		
			Integer res = userService.decreaseUserReputation(42);
			assertEquals(new Integer(4), res);
	}

	@Test
	public void testDecreaseUserReputation2() throws InvalidUserException {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		
			Integer res = userService.decreaseUserReputation(35);
			assertEquals(new Integer(-1), res);
	}
	
	@Test
	public void testDecreaseUserReputation3() throws InvalidUserException {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		
			Integer res = userService.decreaseUserReputation(7);
			assertEquals(new Integer(-5), res);
	}
	
	@Test(expected = InvalidUserException.class)
	public void testDecreaseUserReputation4() throws InvalidUserException {
		UserServiceimpl userService = new UserServiceimpl(mockUR);

		userService.decreaseUserReputation(-3);
	}
}
