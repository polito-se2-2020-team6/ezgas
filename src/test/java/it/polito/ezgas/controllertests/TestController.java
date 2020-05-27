package it.polito.ezgas.controllertests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
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
import it.polito.ezgas.dto.UserDto;
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
	public void testGetUserById() throws ClientProtocolException, IOException {
		HttpUriRequest req =  new HttpGet(BASE_URL+"user/getUser/3");
		HttpResponse res = HttpClientBuilder.create().build().execute(req);
		
		String jsonFromResponse = EntityUtils.toString(res.getEntity());
		
		ObjectMapper mapper = new ObjectMapper ().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		UserDto[] userArray = mapper.readValue(jsonFromResponse, UserDto[].class);
		
		assert (jsonFromResponse.contains("3"));
		assert (jsonFromResponse.contains("Sephiroth"));
		assert (jsonFromResponse.contains("FF7"));
		assert (jsonFromResponse.contains("BestSong@battle.net"));
		assert (jsonFromResponse.contains("-5"));
		assert (res.getStatusLine().getStatusCode() == 200);
		assert (userArray.length ==1);
	}
	
	@Test
	public void testGetAllUsers() throws ClientProtocolException, IOException {
		HttpUriRequest req =  new HttpGet(BASE_URL + "/user/getAllUsers");
		HttpResponse res = HttpClientBuilder.create().build().execute(req);
		
		String jsonFromResponse = EntityUtils.toString(res.getEntity());
		
		ObjectMapper mapper = new ObjectMapper ().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		UserDto[] userArray = mapper.readValue(jsonFromResponse, UserDto[].class);
		
		
		assert (res.getStatusLine().getStatusCode() == 200);
		assert (userArray.length ==3);
	}
	
	@Test
	public void testSaveUser() throws ClientProtocolException, IOException {
		
	}
	
	@Test
	public void testDeleteUser() throws ClientProtocolException, IOException {
		HttpUriRequest req =  new HttpDelete(BASE_URL + "/user/delete/2");
		HttpResponse res = HttpClientBuilder.create().build().execute(req);		
		
		assert (res.getStatusLine().getStatusCode() == 200);
	}
	
	@Test
	public void testIncreaseUserReputation() throws ClientProtocolException, IOException {
		HttpUriRequest req =  new HttpPost(BASE_URL + "/user/increaseUserReputation/2");
		HttpResponse res = HttpClientBuilder.create().build().execute(req);
		
		
		assert (res.getStatusLine().getStatusCode() == 200);
	}
	
	@Test
	public void testDecreaseUserReputation() throws ClientProtocolException, IOException {
		HttpUriRequest req =  new HttpPost(BASE_URL + "/user/decreaseUserReputation/2");
		HttpResponse res = HttpClientBuilder.create().build().execute(req);
		
		
		assert (res.getStatusLine().getStatusCode() == 200);
	}
	
	@Test
	public void testLogin() {
		
	}
	
	@Test
	public void testGetGasStationById() throws ClientProtocolException, IOException {
		HttpUriRequest req =  new HttpGet(BASE_URL+"gasstation/getGasStation/0");
		HttpResponse res = HttpClientBuilder.create().build().execute(req);
		
		String jsonFromResponse = EntityUtils.toString(res.getEntity());
		
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		GasStationDto[] userArray = mapper.readValue(jsonFromResponse, GasStationDto[].class);
		
		assert (jsonFromResponse.contains("DB Carburanti"));
		assert (jsonFromResponse.contains("Viale Trieste 135"));
		assert (res.getStatusLine().getStatusCode() == 200);
		assert (userArray.length ==1);
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
		HttpPost request = new HttpPost(BASE_URL + "/gasstation/saveGasStation");
		// TODO: Add body to be saved
		GasStationDto dummy = new GasStationDto();
		dummy.setGasStationName("DummyName");
		dummy.setGasStationAddress("Dummy Address");
		dummy.setHasDiesel(true);
		dummy.setHasSuper(false);
		dummy.setHasSuper(true);
		dummy.setHasGas(true);
		dummy.setHasMethane(false);
		dummy.setCarSharing("Car2Go");
		dummy.setLat(13.878652);
		dummy.setLon(-15.123875);
		
		ObjectMapper mapper = new ObjectMapper();
		String entityAsString = mapper.writeValueAsString(dummy);
		
		HttpEntity entity = new StringEntity(entityAsString);
		
		request.setEntity(entity);
		
		HttpResponse response = HttpClientBuilder.create().build().execute(request);
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
