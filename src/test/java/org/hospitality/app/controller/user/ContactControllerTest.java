package org.hospitality.app.controller.user;

import org.hospitality.app.entity.user.Contact;
import org.hospitality.app.entity.user.Room;
import org.hospitality.app.factory.user.ContactFactory;
import org.hospitality.app.factory.user.RoomFactory;
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

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContactControllerTest {

    Contact conatct = ContactFactory.createContact("thoko@gmail.com", "071");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/hospitality_db/contact/";
    private static String SECURITY_USERNAME = "root";
    private static String SECURITY_PASSWORD = "password";

    @org.junit.Test
    public void a_create() {
        String url = baseUrl + "create";
        ResponseEntity<Contact> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, conatct, Contact.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse);
        System.out.println(postResponse.getBody());
    }

    @Test
    public void c_update() {
        Contact updated = new Contact.Builder().setContactNumber("071 55 566").build();
        String url = baseUrl + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Contact> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, updated, Contact.class);
        assertEquals(conatct.getContactNumber(), response.getBody().getContactNumber());
    }

    @org.junit.Test
    public void e_delete() {
        String url = baseUrl + "delete/" + conatct.toString();
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

    @org.junit.Test
    public void b_read() {
        String url = baseUrl + "read/" + conatct.toString();
        System.out.println("URL: " + url);
        ResponseEntity<Contact> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .getForEntity(url, Contact.class);
        assertEquals(conatct.getContactNumber(), response.getBody().getContactNumber());

    }

}
