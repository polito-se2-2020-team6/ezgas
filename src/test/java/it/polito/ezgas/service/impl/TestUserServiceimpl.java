package it.polito.ezgas.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import exception.InvalidLoginDataException;
import exception.InvalidUserException;
import it.polito.ezgas.dto.IdPw;
import it.polito.ezgas.dto.LoginDto;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.UserRepository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;


public class TestUserServiceimpl {


	//	@Mock
	//	UserMapper mockUM;
	//	
	//	@Mock
	//	LoginMapper mockLM;

	@Mock
	UserRepository mockUR;

	@BeforeEach
	public void setUp() {

		List<User> al = new ArrayList<>();
		User dummyU = new User("Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", 5);
		dummyU.setUserId(42);
		dummyU.setAdmin(true);

		LoginDto dummyL = new LoginDto(42, "Cloud Strife", "Mysterious Token", "SOLDIERguy@avalanche.com", 5);
		dummyL.setAdmin(true);

		al.add(dummyU);

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
		.thenReturn(al);

		when(mockUR.findOne(eq(42)))
		.thenReturn(dummyU);

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
		
		userService.saveUser(new UserDto());
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


}
