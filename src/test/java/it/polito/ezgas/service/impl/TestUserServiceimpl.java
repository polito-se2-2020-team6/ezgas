package it.polito.ezgas.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.mockito.Mock;

import it.polito.ezgas.dto.LoginDto;
import it.polito.ezgas.dto.LoginMapper;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.dto.UserMapper;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.UserRepository;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestUserServiceimpl {
	
	@Mock
	UserMapper mockUM;
	
	@Mock
	LoginMapper mockLM;
	
	@Mock
	UserRepository mockUR;
	
	@BeforeEach
	public void setUp() {
		
		User dummyU = new User("Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", 5);
		dummyU.setUserId(42);
		dummyU.setAdmin(true);
		
		LoginDto dummyL = new LoginDto(42, "Cloud Strife", "Mysterious Token", "SOLDIERguy@avalanche.com", 5);
		dummyL.setAdmin(true);
		
		List<User> al = new ArrayList<>();
		al.add(dummyU);
		
		mockUM = mock(UserMapper.class);
			
		when(mockUM.toUser(any(UserDto.class)))
			.thenReturn(dummyU);
		
		when(mockUM.toUserDto(any(User.class)))
			.thenReturn(new UserDto(42, "Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", 5, true));;

		mockLM = mock(LoginMapper.class);
		
		when(mockLM.toLoginDto(any(User.class), anyString()))
			.thenReturn(dummyL);
		
		mockUR = mock(UserRepository.class);
		
		when(mockUR.findAll())
			.thenReturn(al);
		
		when(mockUR.findOne(anyInt()))
			.thenReturn(dummyU);
		
		when(mockUR.findByEmail(anyString()))
			.thenReturn(dummyU);
		
		when(mockUR.save(any(User.class)))
			.thenReturn(dummyU);
	}
	
	@Test
	public void testGetUserById1() {
		
	}

}
