package it.polito.ezgas.controllertests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.polito.ezgas.dto.GasStationDto;
import it.polito.ezgas.dto.UserDto;
import it.polito.ezgas.entity.GasStation;
import it.polito.ezgas.entity.User;
import it.polito.ezgas.repository.GasStationRepository;
import it.polito.ezgas.repository.UserRepository;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@DataJpaTest
@Transactional(rollbackOn = TestController.class)
public class TestController {

	public static final String BASE_URL = "http://localhost:8080";
	

	@Test
	public void testGetUserById() throws ClientProtocolException, IOException {
		HttpUriRequest req =  new HttpGet(BASE_URL+"user/getUser/3");
		HttpResponse res = HttpClientBuilder.create().build().execute(req);

		String jsonFromResponse = EntityUtils.toString(res.getEntity());

		ObjectMapper mapper = new ObjectMapper ().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		UserDto uDto = mapper.readValue(jsonFromResponse, UserDto.class);

		assertEquals(200, res.getStatusLine().getStatusCode());
		assertEquals(new Integer(3), uDto.getUserId());
		assertEquals("Sephiroth", uDto.getUserName());
		assertEquals("FF7", uDto.getUserName());
		assertEquals("BestSong@battle.net", uDto.getEmail());
		assertEquals(new Integer(-5), uDto.getReputation());
	}

	@Test
	public void testGetAllUsers() throws ClientProtocolException, IOException {
		HttpUriRequest req =  new HttpGet(BASE_URL + "/user/getAllUsers");
		HttpResponse res = HttpClientBuilder.create().build().execute(req);

		String jsonFromResponse = EntityUtils.toString(res.getEntity());

		ObjectMapper mapper = new ObjectMapper ().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		UserDto[] userArray = mapper.readValue(jsonFromResponse, UserDto[].class);


		assertEquals(200, res.getStatusLine().getStatusCode());
		assertEquals(3, userArray.length);
	}

	@Test
	public void testSaveUser() throws ClientProtocolException, IOException {
		HttpPost req =  new HttpPost(BASE_URL + "/user/saveUser");
		/*UserDto u = new UserDto();
		u.setUserName("Jill");
		u.setPassword("Va11 hall-a");
		u.setEmail("fore@city.it");
		u.setReputation(3);

		ObjectMapper mapper = new ObjectMapper ().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		 */

		String json = "{\"userName\": \"Jill\",\"password\": \"Va11 hall-a\", \"email\":\"fore@city.it\", \"reputation\": \"5\"}";

		StringEntity entity = new StringEntity(json);
		entity.setContentType(ContentType.APPLICATION_JSON.getMimeType());

		req.setEntity(entity);
		req.setHeader("Content-type", "application/json");

		HttpResponse res = HttpClientBuilder.create().build().execute(req);

		assertEquals(200, res.getStatusLine().getStatusCode());

	}

	@Test
	public void testDeleteUser() throws ClientProtocolException, IOException {
		HttpUriRequest req =  new HttpDelete(BASE_URL + "/user/delete/2");
		HttpResponse res = HttpClientBuilder.create().build().execute(req);		

		assertEquals(200, res.getStatusLine().getStatusCode());
	}

	@Test
	public void testIncreaseUserReputation() throws ClientProtocolException, IOException {
		HttpUriRequest req =  new HttpPost(BASE_URL + "/user/increaseUserReputation/2");
		HttpResponse res = HttpClientBuilder.create().build().execute(req);


		assertEquals(200, res.getStatusLine().getStatusCode());
	}

	@Test
	public void testDecreaseUserReputation() throws ClientProtocolException, IOException {
		HttpUriRequest req =  new HttpPost(BASE_URL + "/user/decreaseUserReputation/2");
		HttpResponse res = HttpClientBuilder.create().build().execute(req);


		assertEquals(200, res.getStatusLine().getStatusCode());
	}

	@Test
	public void testLogin() throws ClientProtocolException, IOException {
		HttpPost req =  new HttpPost(BASE_URL + "/user/saveUser");
		String json = "{\"user\": \"SOLDIERguy@avalanche.com\",\"pw\": \"Shinra_sucks\"}";

		StringEntity entity = new StringEntity(json);
		entity.setContentType(ContentType.APPLICATION_JSON.getMimeType());

		req.setEntity(entity);
		req.setHeader("Content-type", "application/json");

		HttpResponse res = HttpClientBuilder.create().build().execute(req);

		assertEquals(200, res.getStatusLine().getStatusCode());
	}

	@Test
	public void testGetGasStationById() throws ClientProtocolException, IOException {
		HttpUriRequest req =  new HttpGet(BASE_URL+"gasstation/getGasStation/0");
		HttpResponse res = HttpClientBuilder.create().build().execute(req);

		String jsonFromResponse = EntityUtils.toString(res.getEntity());

		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		GasStationDto gsDto = mapper.readValue(jsonFromResponse, GasStationDto.class);

		assertEquals(200, res.getStatusLine().getStatusCode());
		assertEquals("DB Carburanti", gsDto.getGasStationName());
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
		request.setHeader("Content-Type", "application/json");

		HttpResponse response = HttpClientBuilder.create().build().execute(request);
		assertEquals(200, response.getStatusLine().getStatusCode());
	}

	@Test
	public void testDeleteUser2() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpDelete(BASE_URL + "/gasstation/deleteGasStation/3");
		HttpResponse response = HttpClientBuilder.create().build().execute(request);

		assertEquals(200, response.getStatusLine().getStatusCode());
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

		assertEquals(200, response.getStatusLine().getStatusCode());
	}

}
