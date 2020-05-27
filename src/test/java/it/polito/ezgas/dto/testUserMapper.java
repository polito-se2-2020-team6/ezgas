package it.polito.ezgas.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.polito.ezgas.entity.User;


@SpringBootTest
public class testUserMapper {
	
	@Test
	public void testToUser1() {
		Integer userId = 42;
		String userName = "Dummy";
		String password = "qwerty";
		String email = "admin@ezgas.com";
		Integer reputation = 0;
		
		UserDto dummy = new UserDto(userId, userName, password, email, reputation);
		User ret = UserMapper.toUser(dummy);
		
		assertEquals(userId, ret.getUserId());
		assertEquals(userName, ret.getUserName());
		assertEquals(password, ret.getPassword());
		assertEquals(email, ret.getEmail());
		assertEquals(reputation, ret.getReputation());
		assertFalse(ret.getAdmin());
	}
	
	@Test
	public void testToUser2() {
		Integer userId = -15;
		String userName = "";
		String password = "qwerty";
		String email = null;
		Integer reputation = 10;
		
		UserDto dummy = new UserDto(userId, userName, password, email, reputation);
		User ret = UserMapper.toUser(dummy);
		
		assertEquals(userId, ret.getUserId());
		assertEquals(userName, ret.getUserName());
		assertEquals(password, ret.getPassword());
		assertEquals(email, ret.getEmail());
		assertEquals(reputation, ret.getReputation());
		assertFalse(ret.getAdmin());
	}
	
	@Test
	public void testToUser3() {
		Integer userId = -15;
		String userName = "Nino SeiSeiSei";
		String password = null;
		String email = null;
		Integer reputation = -15;
		
		UserDto dummy = new UserDto(userId, userName, password, email, reputation);
		User ret = UserMapper.toUser(dummy);
		
		assertEquals(userId, ret.getUserId());
		assertEquals(userName, ret.getUserName());
		assertEquals(password, ret.getPassword());
		assertEquals(email, ret.getEmail());
		assertEquals(reputation, ret.getReputation());
		assertFalse(ret.getAdmin());
	}
	
	@Test
	public void testToUser4() {
		Integer userId = -15;
		String userName = "Nino SeiSeiSei";
		String password = null;
		String email = null;
		Integer reputation = -15;
		Boolean admin = false;
		
		UserDto dummy = new UserDto(userId, userName, password, email, reputation, admin);
		User ret = UserMapper.toUser(dummy);
		
		assertEquals(userId, ret.getUserId());
		assertEquals(userName, ret.getUserName());
		assertEquals(password, ret.getPassword());
		assertEquals(email, ret.getEmail());
		assertEquals(reputation, ret.getReputation());
		assertEquals(admin, ret.getAdmin());
	}
	
	@Test
	public void testToUser5() {
		Integer userId = -15;
		String userName = "Nino SeiSeiSei";
		String password = null;
		String email = null;
		Integer reputation = -15;
		Boolean admin = new Boolean(true);
		
		UserDto dummy = new UserDto(userId, userName, password, email, reputation, admin);
		User ret = UserMapper.toUser(dummy);
		
		assertEquals(userId, ret.getUserId());
		assertEquals(userName, ret.getUserName());
		assertEquals(password, ret.getPassword());
		assertEquals(email, ret.getEmail());
		assertEquals(reputation, ret.getReputation());
		assertEquals(admin, ret.getAdmin());
	}
	
	@Test
	public void testToUser6() {		
		UserDto dummy = new UserDto();
		User ret = UserMapper.toUser(dummy);
		
		assertEquals(dummy.getUserId(), ret.getUserId());
		assertEquals(dummy.getUserId(), ret.getUserName());
		assertEquals(dummy.getUserId(), ret.getPassword());
		assertEquals(dummy.getUserId(), ret.getEmail());
		assertEquals(dummy.getUserId(), ret.getReputation());
		assertEquals(dummy.getUserId(), ret.getAdmin());
	}
	
	@Test
	public void testToUser7() {
		Integer userId = 42;
		String userName = "Dummy";
		String password = "qwerty";
		String email = "admin@ezgas.com";
		Integer reputation = 0;
		Boolean admin = true;
		
		UserDto dummy = new UserDto();
		dummy.setUserId(userId);
		dummy.setUserName(userName);
		dummy.setPassword(password);
		dummy.setEmail(email);
		dummy.setReputation(reputation);
		dummy.setAdmin(admin);
		User ret = UserMapper.toUser(dummy);
		
		assertEquals(userId, ret.getUserId());
		assertEquals(userName, ret.getUserName());
		assertEquals(password, ret.getPassword());
		assertEquals(email, ret.getEmail());
		assertEquals(reputation, ret.getReputation());
		assertEquals(admin, ret.getAdmin());
	}
	
	@Test
	public void testToUser8() {
		Integer userId = null;
		String userName = null;
		String password = null;
		String email = null;
		Integer reputation = null;
		Boolean admin = null;
		
		UserDto dummy = new UserDto(userId, userName, password, email, reputation, admin);
		User ret = UserMapper.toUser(dummy);
		
		assertEquals(userId, ret.getUserId());
		assertEquals(userName, ret.getUserName());
		assertEquals(password, ret.getPassword());
		assertEquals(email, ret.getEmail());
		assertEquals(reputation, ret.getReputation());
		assertEquals(admin, ret.getAdmin());
	}
	@Test
	public void testToUserDto1(){
		String userName = "Kratos";
		String password = "Atreus";
		String email = "godofwar@libero.it";
		Integer reputation = 0;
		Boolean admin = false;
		Integer userId = 10;

		User user = new User( userName, password, email, reputation );
		user.setAdmin(admin);
		user.setUserId(userId);
		
		UserDto res = UserMapper.toUserDto(user);
		assertEquals(userId, res.getUserId());
		assertEquals(userName, res.getUserName());
		assertEquals(password, res.getPassword());
		assertEquals(email, res.getEmail());
		assertEquals(admin, res.getAdmin());
		assertEquals(reputation, res.getReputation());		
	}
	
	@Test
	public void testToUserDto2(){
		String userName = "Kratos";
		String password = "Atreus";
		String email = "godofwar@libero.it";
		Integer reputation = 3;
		Boolean admin = true;
		Integer userId = -52;

		User user = new User( userName, password, email, reputation );
		user.setAdmin(admin);
		user.setUserId(userId);
		
		UserDto res = UserMapper.toUserDto(user);
		assertEquals(userId, res.getUserId());
		assertEquals(userName, res.getUserName());
		assertEquals(password, res.getPassword());
		assertEquals(email, res.getEmail());
		assertEquals(admin, res.getAdmin());
		assertEquals(reputation, res.getReputation());		
	}
	
	@Test
	public void testToUserDto3(){
		String userName = "Kratos";
		String password = null;
		String email = "godofwar@libero.it";
		Integer reputation = 10;
		Boolean admin = true;
		Integer userId = 24;

		User user = new User( userName, password, email, reputation );
		user.setAdmin(admin);
		user.setUserId(userId);
		
		UserDto res = UserMapper.toUserDto(user);
		assertEquals(userId, res.getUserId());
		assertEquals(userName, res.getUserName());
		assertEquals(password, res.getPassword());
		assertEquals(email, res.getEmail());
		assertEquals(admin, res.getAdmin());
		assertEquals(reputation, res.getReputation());		
	}
	@Test
	public void testToUserDto4(){
		String userName = null;
		String password = null;
		String email = null;
		Integer reputation = null;
		Boolean admin = null;
		Integer userId = null;

		User user = new User( userName, password, email, reputation );
		user.setAdmin(admin);
		user.setUserId(userId);
		
		UserDto res = UserMapper.toUserDto(user);
		assertEquals(userId, res.getUserId());
		assertEquals(userName, res.getUserName());
		assertEquals(password, res.getPassword());
		assertEquals(email, res.getEmail());
		assertEquals(admin, res.getAdmin());
		assertEquals(reputation, res.getReputation());		
	}
}
