package it.polito.ezgas.controllertests;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.repository.UserRepository;

@SpringBootTest
public class TestController {
	
	public static final String BASE_URL = "http://localhost:8080/";
	
	public static List<User> userDb;
	public static List<GasStation> gsDb;
	
	@Autowired
	static UserRepository userRepository;
	
	@Autowired
	static GasStationRepository gasStationRepository;
	
	@BeforeAll
	public static void setUpClass() {
		userDb = userRepository.findAll();
		gsDb = gasStationRepository.findAll();
		
		userRepository.deleteAll();
		gasStationRepository.deleteAll();
	}
	
	@BeforeEach
	public void setUp() {		
		User dummyU = new User("Cloud Strife", "Shinra_sucks", "SOLDIERguy@avalanche.com", 5);
		dummyU.setAdmin(true);
		User dummyU2 = new User("Lara Croft", "Tomb Raider", "lara.Croft@polito.it", 0);
		User dummyU3 = new User("Sephiroth", "FF7", "BestSong@battle.net", -5);
		
		userRepository.deleteAll();		
		
		userRepository.save(dummyU);
		userRepository.save(dummyU2);
		userRepository.save(dummyU3);
		
		GasStation dummyGS1 = new GasStation("DB Carburanti", "Viale Trieste 135", true, true, false, false, true, "Enjoy", 44.6903938, 7.8240318, 1.452, 1.234, -1, -1, 0.989, 1, "19/02/2020, 11:24", 50);
		GasStation dummyGS2 = new GasStation("Agip", "Viale Della Rinascita 12", false, true, false, false, true, "Car2Go", 44.692909, 7.8519551, -1, 0, -1, -1, 0, -1, null, 0);
		GasStation dummyGS3 = new GasStation("Q8", "Viale Luigi Monaco 62", true, true, false, true, true, "Enjoy", 44.6665252, 7.8345161, 0, 0, -1, 0, 0, -1, null, 0);
		GasStation dummyGS4 = new GasStation("Eni", "Via Garibaldi 33", true, true, false, true, true, "Car2Go", 11.233, 47.304, 1.225, 2.553, -1, 2.098, 1.003, 2, "18/02/2020, 19:00", 25);
		
		gasStationRepository.deleteAll();
		
		gasStationRepository.save(dummyGS1);
		gasStationRepository.save(dummyGS2);
		gasStationRepository.save(dummyGS3);
		gasStationRepository.save(dummyGS4);
	}
	
	@AfterAll
	public static void tearDownClass() {
		userRepository.deleteAll();
		gasStationRepository.deleteAll();
		
		userRepository.save(userDb);
		gasStationRepository.save(gsDb);
	}

	@Test
	public void testGetUserById() {
		
	}
	
	@Test
	public void testGetAllUsers() {
		
	}
	
	@Test
	public void testSaveUser() {
		
	}
	
	@Test
	public void testDeleteUser() {
		
	}
	
	
	@Test
	public void testIncreaseUserReputation() {
		
	}
	
	@Test
	public void testDecreaseUserReputation() {
		
	}
	
	@Test
	public void testLogin() {
		
	}
	
	
	
	@Test
	public void testGetGasStationById() {
		
	}
	
	@Test
	public void testGetAllGasStations() {
		
	}
	
	@Test
	public void testSaveGasStation() {
		
	}
	
	@Test
	public void testDeleteUser2() {
		
	}
	
	@Test
	public void testGetGasStationsByGasolineType() {
		
	}
	
	@Test
	public void testGetGasStationsByProximity() {
		
	}
	
	@Test
	public void testGetGasStationsWithCoordinates() {
		
	}
	
	@Test
	public void testSetGasStationReport() {
		
	}
	
}
