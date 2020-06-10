package it.polito.ezgas.dto;

import org.springframework.stereotype.Component;

import it.polito.ezgas.entity.User;

@Component
public class UserMapper {
	    public static UserDto toUserDto(User user) {
	    	if (user == null) {
	    		return null;
	    	}
	    	UserDto u = new UserDto(user.getUserId(), user.getUserName(), user.getPassword(), user.getEmail(), user.getReputation(), user.getAdmin());
	        return u;	             
	    }
	    public static User toUser (UserDto userDto) {
	    	if (userDto == null) {
	    		return null;
	    	}
	    	
	    	User user = new User(userDto.getUserName(), userDto.getPassword(), userDto.getEmail(), userDto.getReputation());
	    	user.setAdmin(userDto.getAdmin());
	    	user.setUserId(userDto.getUserId());
	    	return user;
	    }
	}

