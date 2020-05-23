package it.polito.ezgas.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.polito.ezgas.entity.User;

public class testLoginMapper {
	@Test
	public void testToLoginDto1(){
		String userName = "Nathan";
		String password = "Drake";
		String email = "uncharted@libero.it";
		Integer reputation = 0;
		Boolean admin = false;
		Integer userId = 10;
		String token = "misterious token";

		User user = new User( userName, password, email, reputation );
		user.setAdmin(admin);
		user.setUserId(userId);
		
		LoginDto res = LoginMapper.toLoginDto(user, token);
		assertEquals(userId, res.getUserId());
		assertEquals(userName, res.getUserName());
		assertEquals(token, res.getToken());
		assertEquals(email, res.getEmail());
		assertEquals(admin, res.getAdmin());
		assertEquals(reputation, res.getReputation());		
	}
	
	@Test
	public void testToLoginDto2(){
		String userName = "Nathan";
		String password = "Drake";
		String email = "uncharted@libero.it";
		Integer reputation = 3;
		Boolean admin = true;
		Integer userId = -52;
		String token = "misterious token";

		User user = new User( userName, password, email, reputation );
		user.setAdmin(admin);
		user.setUserId(userId);
		
		LoginDto res = LoginMapper.toLoginDto(user, token);
		assertEquals(userId, res.getUserId());
		assertEquals(userName, res.getUserName());
		assertEquals(token, res.getToken());
		assertEquals(email, res.getEmail());
		assertEquals(admin, res.getAdmin());
		assertEquals(reputation, res.getReputation());			
	}
	
	@Test
	public void testToLoginDto3(){
		String userName = "Nathan";
		String password = null;
		String email = "uncharted@libero.it";
		Integer reputation = 10;
		Boolean admin = true;
		Integer userId = 24;
		String token = "misterious token";

		User user = new User( userName, password, email, reputation );
		user.setAdmin(admin);
		user.setUserId(userId);
		
		LoginDto res = LoginMapper.toLoginDto(user, token);
		assertEquals(userId, res.getUserId());
		assertEquals(userName, res.getUserName());
		assertEquals(token, res.getToken());
		assertEquals(email, res.getEmail());
		assertEquals(admin, res.getAdmin());
		assertEquals(reputation, res.getReputation());		
	}
	@Test
	public void testToLoginDto4(){
		String userName = null;
		String password = null;
		String email = null;
		Integer reputation = null;
		Boolean admin = null;
		Integer userId = null;
		String token = null;

		User user = new User( userName, password, email, reputation );
		user.setAdmin(admin);
		user.setUserId(userId);
		
		LoginDto res = LoginMapper.toLoginDto(user, token);
		assertEquals(userId, res.getUserId());
		assertEquals(userName, res.getUserName());
		assertEquals(token, res.getToken());
		assertEquals(email, res.getEmail());
		assertEquals(admin, res.getAdmin());
		assertEquals(reputation, res.getReputation());		
	}
}
