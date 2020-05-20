package it.polito.ezgas.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;

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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestUserServiceimpl {

	//	@Mock
	//	UserMapper mockUM;
	//	
	//	@Mock
	//	LoginMapper mockLM;

	List<User> al;

	@Mock
	UserRepository mockUR;

	@BeforeEach
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

//		LoginDto dummyL = new LoginDto(42, "Cloud Strife", "Mysterious Token", "SOLDIERguy@avalanche.com", 5);
//		dummyL.setAdmin(true);
		
		al = new ArrayList<>();
		al.add(dummyU);
		al.add(dummyU2);
		al.add(dummyU3);

		//		mockUM = mock(UserMapper.class);
		//			
		//		verify(mockUM.toUser(any()))
		//			.thenReturn(dummyU);
		//		
		//		verify(mockUM.toUserDto(any(User.class)))
		//			.thenReturn(new UserDto(42, "Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", 5, true));;
		//
		//		mockLM = mock(LoginMapper.class);
		//		
		//		when(mockLM.toLoginDto(any(User.class), anyString()))
		//			.thenReturn(dummyL); 

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
		
//		Mockito.doNothing().when(mockUR.delete(anyInt()));
	}


	@Test
	public void testGetUserById1() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		try {
			UserDto res = userService.getUserById(42);
			assertEquals(new Integer(42), res.getUserId());
		}
		catch(InvalidUserException e){
			fail("exception not expected");
		}
	}

	@Test
	public void testGetUserById2() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		assertThrows(InvalidUserException.class, ()->userService.getUserById(-3));
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
		
		assertNull(userService.saveUser(new UserDto(42, "Cloud Strife", "Shinra_sucks", "badEmailemail.com", 5)));
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
	public void testDeleteUser1() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		
		try {
			assertTrue(userService.deleteUser(42));
		} catch (InvalidUserException e) {
			fail();
		}
	}

	@Test
	public void testDeleteUser2() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		
		assertThrows(InvalidUserException.class, () -> userService.deleteUser(-3), "Expected fail");
	}

	@Test
	public void testLogin1() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);		
		IdPw credentials = new IdPw("SOLDIERguy@avalanche.com", "Shinra_sucks");

		try {
			LoginDto login = userService.login(credentials);
			assertEquals(credentials.getUser(), login.getEmail());
		} catch (InvalidLoginDataException e) {
			fail("User expected to exist");
		}
	}

	@Test
	public void testLogin2() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);		
		IdPw credentials = new IdPw("SOLDIERguy@avalanche.com", "wrong password");

		assertThrows(InvalidLoginDataException.class, () -> userService.login(credentials), "Wrong password, test expected to fail");
	}
	
	@Test
	public void testLogin3() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);		
		IdPw credentials = new IdPw("badEmailemail.com", "wrong password");

		assertThrows(InvalidLoginDataException.class, () -> userService.login(credentials), "Wrong email, test expected to fail");
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
	public void testIncreaseReputation1() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		try {
			Integer res = userService.increaseUserReputation(42);
			assertEquals(new Integer(5), res);
		} catch (InvalidUserException e) {
			fail("exception not expected");		
		}
		
	}
	
	@Test
	public void testIncreaseReputation2() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		try {
			Integer res = userService.increaseUserReputation(35);
			assertEquals(new Integer(1), res);
		} catch (InvalidUserException e) {
			fail("exception not expected");		
		}
		
	}
	
	@Test
	public void testIncreaseReputation3() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		try {
			Integer res = userService.increaseUserReputation(7);
			assertEquals(new Integer(-4), res);
		} catch (InvalidUserException e) {
			fail("exception not expected");		
		}
		
	}
	
	@Test
	public void testIncreaseReputation4() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		
			 assertThrows(InvalidUserException.class, () -> userService.increaseUserReputation(-3), "Expected fail");
			
		
	}
	
	public void testDecreaseUserReputation1() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		
		try {
			Integer res = userService.decreaseUserReputation(42);
			assertEquals(new Integer(4), res);
		} catch (InvalidUserException e) {
			fail("User expected to exist");
		}
	}

	@Test
	public void testDecreaseUserReputation2() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		
		try {
			Integer res = userService.decreaseUserReputation(35);
			assertEquals(new Integer(-1), res);
		} catch (InvalidUserException e) {
			fail("User expected to exist");
		}
	}
	
	@Test
	public void testDecreaseUserReputation3() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);
		
		try {
			Integer res = userService.decreaseUserReputation(7);
			assertEquals(new Integer(-5), res);
		} catch (InvalidUserException e) {
			fail("User expected to exist");
		}
	}
	
	@Test
	public void testDecreaseUserReputation4() {
		UserServiceimpl userService = new UserServiceimpl(mockUR);

		assertThrows(InvalidUserException.class, () -> userService.decreaseUserReputation(-3), "Expected exception");
	}
}
