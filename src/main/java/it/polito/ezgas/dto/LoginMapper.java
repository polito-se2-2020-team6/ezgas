package it.polito.ezgas.dto;

import org.springframework.stereotype.Component;

import it.polito.ezgas.entity.User;

@Component
public class LoginMapper {
    public static LoginDto toLoginDto (User user, String token) {
    	LoginDto l = new LoginDto(user.getUserId(), user.getUserName(), token, user.getEmail(), user.getReputation());
    	l.setAdmin(user.getAdmin());
    	return l;
    }		
}
