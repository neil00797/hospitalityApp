package org.hospitality.app.controller.utility;

import jdk.nashorn.internal.runtime.Source;
import org.hospitality.app.entity.user.Contact;
import org.hospitality.app.entity.utility.Delivery;
import org.hospitality.app.entity.utility.Payment;
import org.hospitality.app.factory.user.ContactFactory;
import org.hospitality.app.factory.utility.DeliveryFactory;
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class ContactControllerTest {

    private static Contact contact = ContactFactory.createContact("thokozilesno@gmail.com","073");
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/contact/";

    @Test
    public void create() {
        String url = baseUrl + "create";
        ResponseEntity< Contact > postResponse = restTemplate.postForEntity(url, contact, Contact.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println(postResponse);
        System.out.println(postResponse.getBody());
    }

    @Test
    public void getAll() {
        String url = baseUrl + "all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("null", headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity,String.class);

        System.out.println(response);
        System.out.println(response.getBody());
    }
}