package it.polito.ezgas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.*;

@SpringBootApplication
public class BootEZGasApplication {

	@Autowired
	UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BootEZGasApplication.class, args);
	}

	@PostConstruct
	public void setupDbWithData() throws SQLException{
		Connection conn = DriverManager.getConnection("jdbc:h2:./data/memo", "sa", "password");
		conn.close();
		initializationAdmin();
	}



	private void initializationAdmin() {
		List<User> userList = repository.findAll();
		for(User user:userList) {
			System.out.println(String.format("'%s', '%d', '%s', '%s', '%d'", user.getAdmin() ? "admin" : "user", user.getUserId(), user.getUserName(), user.getEmail(), user.getReputation() ));
		}
		int admin = repository.countByAdmin(true);
		//System.out.println("Number of admins: " + admin);
		if(admin == 0) {
			User user= new User("admin", "admin", "admin@ezgas.com", 5);
			user.setAdmin(true);
			repository.save(user);

		};
	}

}
