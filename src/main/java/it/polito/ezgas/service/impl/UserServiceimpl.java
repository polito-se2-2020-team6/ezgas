package it.polito.ezgas.service.impl;

import java.util.List;

//import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.InvalidLoginDataException;
import exception.InvalidUserException;
import it.polito.ezgas.dto.IdPw;
import it.polito.ezgas.dto.LoginDto;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.dto.UserMapper;
import it.polito.ezgas.repository.UserRepository;
import it.polito.ezgas.service.UserService;
import it.polito.ezgas.entity.User;

/**
 * Created by softeng on 27/4/2020.
 */

@Service
public class UserServiceimpl implements UserService {

	@Autowired 	UserRepository repository;
	@Override 
	public UserDto getUserById(Integer userId) throws InvalidUserException {
		User user = repository.findOne(userId);
		if(user==null) {
			throw new InvalidUserException("Error, userId not found");
		}
		UserDto u_dto = UserMapper.toUserDto(user);
		return u_dto;
		//return null;
	}
	
	@Override
	public UserDto saveUser(UserDto userDto) {
		User user = UserMapper.toUser(userDto);
		repository.save(user);
		return userDto;
		//return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<UserDto> listUserDto=null; 
		List <User> listUser;
		listUser = repository.findAll();
		for (User user : listUser) {
			listUserDto.add(UserMapper.toUserDto(user));
		}
		return listUserDto;
		//return null;
	}

	@Override
	public Boolean deleteUser(Integer userId) throws InvalidUserException {
		User user = repository.findOne(userId);
		boolean value = false;
		if(user==null) {
			throw new InvalidUserException("Error, userId not found");
		} else {
			repository.deleteById(userId);
			value=true;
		}
		return value;
		//return null;
	}

	@Override
	public LoginDto login(IdPw credentials) throws InvalidLoginDataException {
		User user=repository.findOne(credentials.getUser());
		LoginDto log;
		if (user==null) {
			throw new InvalidLoginDataException("Error, user doesn't exist");
		} else {
			log = UserMapper.toLoginDto(user, "Success");
		}
		return log;
		//return null;
	}

	@Override
	public Integer increaseUserReputation(Integer userId) throws InvalidUserException {
		User user = repository.findOne(userId);
		int reputation;
		if(user==null) {
			throw new InvalidUserException("Error, userId not found");
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
			throw new InvalidUserException("Error, userId not found");
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
