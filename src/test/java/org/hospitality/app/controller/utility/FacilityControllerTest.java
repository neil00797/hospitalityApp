package org.hospitality.app.controller.utility;


import org.hospitality.app.entity.utility.Facility;
import org.hospitality.app.factory.utility.FacilityFactory;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import static org.junit.runners.MethodSorters.NAME_ASCENDING;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(NAME_ASCENDING)

class FacilityControllerTest {

    private static Facility service = FacilityFactory.createService("Laundry");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/service/";

    @Test
    void a_create() {
        String url = baseUrl + "create";
        ResponseEntity<Facility> postResponse = restTemplate.postForEntity(url, service, Facility.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println(postResponse);
        System.out.println(postResponse.getBody());
    }

    @Test
    void b_read() {
        String url = baseUrl + "read/" + service.getServiceType();
        System.out.println("URL: " + url);
        ResponseEntity<Facility> response = restTemplate.getForEntity(url, Facility.class);
    }

    @Test
    void c_update() {
        Facility updated = new Facility.Builder().copy(service).setServiceType("Service").build();
        String url = baseUrl + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Facility> response = restTemplate.postForEntity(url, updated, Facility.class);
    }

    @Test
    void e_delete() {
       String url = baseUrl + "delete/" + service.getServiceType();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseUrl + "all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("null", headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }
}