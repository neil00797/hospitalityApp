package org.hospitality.app.controller.utility;

import org.hospitality.app.entity.utility.Delivery;
import org.hospitality.app.factory.utility.DeliveryFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.*;


import static org.junit.jupiter.api.Assertions.*;

/*
    author: Shaun Donnelly
    desc: Test for DeliveryController
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class DeliveryControllerTest {

    private static Delivery delivery = DeliveryFactory.createDelivery("0001","Laundry");
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/hospitality_db/delivery/";
    private static String SECURITY_USERNAME = "root";
    private static String SECURITY_PASSWORD = "password";

    @Test
    public void a_create() {
        String url = baseUrl + "create";
        ResponseEntity<Delivery> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, delivery, Delivery.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println(postResponse);
        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_read() {
        String url = baseUrl + "read/" + delivery.getDeliveryNumber();
        System.out.println("URL: " + url);
        ResponseEntity<Delivery> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Delivery.class);
        assertEquals(delivery.getDeliveryNumber(), response.getBody().getDeliveryNumber());


    }

    @Test
    public void c_update() {
        Delivery updated = new Delivery.Builder().copy(delivery).setRoomNumber("9999").setServiceType("Delivery").build();
        String url = baseUrl + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Delivery> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, updated, Delivery.class);
        assertEquals(delivery.getDeliveryNumber(), response.getBody().getDeliveryNumber());

    }

    @Test
    public void e_delete() {
        String url = baseUrl + "delete/" + delivery.getServiceType();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    public void d_getAll() {
        String url = baseUrl + "all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("null", headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }
}