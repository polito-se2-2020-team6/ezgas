package it.polito.ezgas.dto;

import org.springframework.stereotype.Component;

import it.polito.ezgas.entity.User;

@Component
public class UserMapper {
	    public static UserDto toUserDto(User user) {
	    	UserDto u = new UserDto(user.getUserId(), user.getUserName(), user.getPassword(), user.getEmail(), user.getReputation(), user.getAdmin());
	        return u;	             
	    }
	    public static User toUser (UserDto userDto) {
	    	User user = new User(userDto.getUserName(), userDto.getPassword(), userDto.getEmail(), userDto.getReputation());
	    	user.setAdmin(userDto.getAdmin());
	    	user.setUserId(userDto.getUserId());
	    	return user;
	    }
	    public static LoginDto toLoginDto (User user, String token) {
	    	LoginDto l = new LoginDto(user.getUserId(), user.getUserName(), token, user.getEmail(), user.getReputation());
	    	return l;
	    }
	}

