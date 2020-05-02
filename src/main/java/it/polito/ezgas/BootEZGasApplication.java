package it.polito.ezgas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.polito.ezgas.entity.User;

@SpringBootApplication
public class BootEZGasApplication {
	
	Connection conn;

	public static void main(String[] args) {
		SpringApplication.run(BootEZGasApplication.class, args);
	}
	
	@PostConstruct
	public void setupDbWithData() throws SQLException{
		conn = DriverManager.getConnection("jdbc:h2:./data/memo", "sa", "password");
		
		String selectSql = "SELECT * FROM User u"  ;
		String selectSql2 = "SELECT COUNT (*) FROM User u WHERE u.Admin='TRUE'";

		try {	
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(selectSql);
			Statement statement2 = conn.createStatement();
			ResultSet resultSet2 = statement2.executeQuery(selectSql2);

			// Print results from select statement
			while (resultSet.next())
			{
				System.out.println(resultSet.getInt(1) + " "
						+ resultSet.getBoolean(2) + " "
						+ resultSet.getString(3) + " "
						+ resultSet.getString(4) + " "
						+ resultSet.getInt(5) + " "
						+ resultSet.getString(6) );
			}
			
			
			if(resultSet2.next()) {
				if(resultSet2.getInt(1) == 0) {
					User user= new User("admin", "admin", "admin@ezgas.com", 5);
					user.setAdmin(true);
					String insertSql = "INSERT INTO User(ADMIN,EMAIL,PASSWORD,REPUTATION,USER_NAME)" +  "VALUES(" + String.format("'%s', '%s', '%s', '%d', '%s'", user.getAdmin(), user.getEmail(), user.getPassword(), user.getReputation(), user.getUserName()) + ")";
					Statement statement3 = conn.createStatement();
					int resultSet3 = statement3.executeUpdate(insertSql);
					System.out.println("GGGGGGGGGGG" + resultSet3);
				}
			}
			
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
	@PreDestroy
	public void closeDbConnection() throws SQLException {
		conn.close();
	}

}
