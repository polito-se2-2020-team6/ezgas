package it.polito.ezgas.service.impl;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

//import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.InvalidLoginDataException;
import exception.InvalidUserException;
import it.polito.ezgas.dto.IdPw;
import it.polito.ezgas.dto.LoginDto;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.dto.UserMapper;
import it.polito.ezgas.dto.LoginMapper;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.UserService;
import it.polito.ezgas.entity.User;

/**
 * Created by softeng on 27/4/2020.
 */

@Service
public class UserServiceimpl implements UserService {

	//@Autowired 	UserRepository repository;
	
	 private UserRepository repository;
	 public UserServiceimpl(UserRepository userRepository) {
		 this.repository = userRepository;
	 }
	
	@Override 
	public UserDto getUserById(Integer userId) throws InvalidUserException {
		User user = repository.findOne(userId);
		if(user==null) {
			throw new InvalidUserException("ERROR: user " + userId + " not found");
		}
		UserDto u_dto = UserMapper.toUserDto(user);
		return u_dto;
		//return null;
	}
	
	@Override
	public UserDto saveUser(UserDto userDto) {
		User user2 = repository.findByEmail(userDto.getEmail());
		if (userDto.getUserId()==null) {	// CASE SAVE: 
			if (user2 != null) // account with same mail already existing -> reject
				return null;
		} else {	// CASE UPDATE:
			if ((user2 != null) && (user2.getUserId() != userDto.getUserId()))
				return null; //other user with new email -> reject
		}
		
		User user = UserMapper.toUser(userDto);
		user=repository.save(user);
		return UserMapper.toUserDto(user);
		//return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		//List<UserDto> listUserDto; 
		return repository.findAll().parallelStream().map(UserMapper::toUserDto).collect(Collectors.toList());
		//return null;
	}

	@Override
	public Boolean deleteUser(Integer userId) throws InvalidUserException {
		User user = repository.findOne(userId);
		boolean value = false;
		if(user==null) {
			throw new InvalidUserException("ERROR: user " + userId + " not found");
		} else {
			repository.delete(userId);
			value=true;
		}
		return value;
		//return null;
	}

	@Override
	public LoginDto login(IdPw credentials) throws InvalidLoginDataException {
		User user = repository.findByEmail(credentials.getUser());
		LoginDto log;
		if (user == null || !user.getPassword().equals(credentials.getPw())) {
			throw new InvalidLoginDataException("Email or password wrong.");
		} else {
			log = LoginMapper.toLoginDto(user, user.getEmail() + new Date().toString());
		}
		return log;
		//return null;
	}

	@Override
	public Integer increaseUserReputation(Integer userId) throws InvalidUserException {
		User user = repository.findOne(userId);
		int reputation;
		if(user==null) {
			throw new InvalidUserException("ERROR: user " + userId + " not found");
		}else {
			reputation = user.getReputation();
			if(reputation<5){
				reputation++;
				user.setReputation(reputation);
				repository.save(user);
			}
		}
		return reputation;
		//return null;
	}

	@Override
	public Integer decreaseUserReputation(Integer userId) throws InvalidUserException {
		User user = repository.findOne(userId);
		int reputation;
		if(user==null) {
			throw new InvalidUserException("ERROR: user " + userId + " not found");
		}else {
			reputation = user.getReputation();
			if(reputation>-5){
				reputation--;
				user.setReputation(reputation);
				repository.save(user);
			}
		}
		return reputation;
		//return null;
	}
	
}
