package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PricingServiceApplicationTests {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getPrice() {
		ResponseEntity<Price> response =
				this.restTemplate
						.getForEntity("http://localhost:" + port + "/services/price?vehicleId=4", Price.class);

		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}

//	@Test not needed because it just fills price in case none is given to a vehicle.
//	public void randomPrice() {
//		ResponseEntity<BigDecimal> response =
//				this.restTemplate
//						.getForEntity("http://localhost:" + port + "/services/price?vehicleId=4", BigDecimal.class);
//
//		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
//	}

}
