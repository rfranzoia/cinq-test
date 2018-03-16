package br.com.cinq.spring.data.sample.rest;

import static org.assertj.core.api.Assertions.assertThat;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cinq.spring.data.sample.entity.City;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class EndpointTest {
    Logger logger = LoggerFactory.getLogger(EndpointTest.class);

    private final String localhost = "http://localhost:";

    @Value("${local.server.port}")
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testGetCities() throws InterruptedException {
        String country = "France";

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.localhost + this.port + "/rest/cities/")
                .queryParam("country", country);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<City[]> response = this.restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, City[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        Thread.sleep(2000L);

        City[] cities = response.getBody();

        assertThat(cities.length).isEqualTo(2);

    }
}
