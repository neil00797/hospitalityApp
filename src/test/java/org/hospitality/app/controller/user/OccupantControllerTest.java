package org.hospitality.app.controller.user;

import org.hospitality.app.entity.user.Occupant;
import org.hospitality.app.factory.user.OccupantFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OccupantControllerTest {

    private static Occupant occupant = OccupantFactory.createOccupant("Nail", "Jonson");
    private static String SECURITY_USERNAME = "username";
    private static String SECURITY_PASSWORD ="test";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/occupant/";

    @Test
    public void a_create() {
        String url = baseUrl + "create";
        ResponseEntity<Occupant> postResponse = restTemplate.postForEntity(url, occupant, Occupant.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        occupant = postResponse.getBody();

        System.out.println(postResponse);
        System.out.println(postResponse.getBody());

    }

    @Test
    public void b_read() {
        String url = baseUrl + "read/" + occupant.getOccupantId();
        System.out.println("URL: " + url);
        ResponseEntity<Occupant> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .getForEntity(url, Occupant.class);


    }

    @Test
    public void c_update() {
        Occupant updated = new Occupant.Builder().copy(occupant).setFirstName("Neil").setLastName("Johnson").build();
        String url = baseUrl + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Occupant> response = restTemplate.postForEntity(url, updated, Occupant.class);

    }

    @Test
    public void e_delete() {
        String url = baseUrl + "delete/" + occupant.getOccupantId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    public void d_getAll() {
        String url = baseUrl + "all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("null", headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }
}