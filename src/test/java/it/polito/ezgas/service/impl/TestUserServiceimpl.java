package it.polito.ezgas.service.impl;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;

import exception.InvalidUserException;
import it.polito.ezgas.dto.LoginDto;
import it.polito.ezgas.dto.LoginMapper;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.dto.UserMapper;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TestUserServiceimpl {
	
	List<User> al;
//	@Mock
//	UserMapper mockUM;
//	
//	@Mock
//	LoginMapper mockLM;
	
	@Mock
	UserRepository mockUR;
	
	@BeforeEach
	public void setUp() {
		
		User dummyU = new User("Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", 5);
		dummyU.setUserId(42);
		dummyU.setAdmin(true);
		
		LoginDto dummyL = new LoginDto(42, "Cloud Strife", "Mysterious Token", "SOLDIERguy@avalanche.com", 5);
		dummyL.setAdmin(true);
		
		al = new ArrayList<>();
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
			.thenAnswer(new Answer<List<User>>() {

				@Override
				public List<User> answer(InvocationOnMock invocation) throws Throwable {
					// TODO Auto-generated method stub
					return al;
				}
			});
		
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
	
	
}
