package it.polito.ezgas.controllertests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestController {
	
	public static final String BASE_URL = "http://localhost:8080";
	
	public static List<User> userDb;
	public static List<GasStation> gsDb;
	
	@Autowired
	public static UserRepository userRepository;
	
	@Autowired
	public static GasStationRepository gasStationRepository;
	
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
	public void testGetAllGasStations() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet(BASE_URL + "/gasstation/getAllGasStations");
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		
		assertTrue(response.getStatusLine().getStatusCode() == 200);
		
		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		GasStationDto[] gasStationArray = mapper.readValue(jsonFromResponse, GasStationDto[].class);
		
		assertEquals(4, gasStationArray.length);
	}
	
	@Test
	public void testSaveGasStation() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpPost(BASE_URL + "/gasstation/saveGasStation");
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		
		// TODO: Add body to be saved		
		
		assertTrue(response.getStatusLine().getStatusCode() == 200);
	}
	
	@Test
	public void testDeleteUser2() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpDelete(BASE_URL + "/gasstation/deleteGasStation/3");
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		
		assertTrue(response.getStatusLine().getStatusCode() == 200);
	}
	
	@Test
	public void testGetGasStationsByGasolineType() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet(BASE_URL + "/gasstation/searchGasStationByGasolineType/Diesel");
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		
		assertTrue(response.getStatusLine().getStatusCode() == 200);
		
		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		GasStationDto[] gasStationArray = mapper.readValue(jsonFromResponse, GasStationDto[].class);
		
		assertEquals(3, gasStationArray.length);
		assertEquals("Q8", gasStationArray[0].getGasStationName());
		assertEquals("Eni", gasStationArray[1].getGasStationName());
		assertEquals("DB Carburanti", gasStationArray[2].getGasStationName());
	}
	
	@Test
	public void testGetGasStationsByProximity() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet(BASE_URL + "/gasstation/searchGasStationByProximity/44.67/7.84");
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		
		assertTrue(response.getStatusLine().getStatusCode() == 200);
		
		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		GasStationDto[] gasStationArray = mapper.readValue(jsonFromResponse, GasStationDto[].class);
		
		assertEquals(3, gasStationArray.length);
		assertEquals("Q8", gasStationArray[0].getGasStationName());
		assertEquals("DB Carburanti", gasStationArray[1].getGasStationName());
		assertEquals("Agip", gasStationArray[2].getGasStationName());
	}
	
	@Test
	public void testGetGasStationsWithCoordinates() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet(BASE_URL + "/gasstation/getGasStationsWithCoordinates/44.67/7.84/Diesel/null");
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		
		assertTrue(response.getStatusLine().getStatusCode() == 200);
		
		String jsonFromResponse = EntityUtils.toString(response.getEntity());
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		GasStationDto[] gasStationArray = mapper.readValue(jsonFromResponse, GasStationDto[].class);
		
		assertEquals(2, gasStationArray.length);
		assertEquals("Q8", gasStationArray[0].getGasStationName());
		assertEquals("DB Carburanti", gasStationArray[1].getGasStationName());
	}
	
	@Test
	public void testSetGasStationReport() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpPost(BASE_URL + "/gasstation/setGasStationReport/3/17/70/-1/13/42/3");
		HttpResponse response = HttpClientBuilder.create().build().execute(request);

		assertTrue(response.getStatusLine().getStatusCode() == 200);
	}
	
}
