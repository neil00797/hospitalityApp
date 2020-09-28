package org.hospitality.app.controller.utility;


import org.hospitality.app.entity.utility.Service;
import org.hospitality.app.factory.utility.ServiceFactory;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
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
import static org.junit.runners.MethodSorters.NAME_ASCENDING;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(NAME_ASCENDING)

class ServiceControllerTest {

    private static Service service = ServiceFactory.createService("Laundry");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/service/";

    @Test
    void a_create() {
        String url = baseUrl + "create";
        ResponseEntity<Service> postResponse = restTemplate.postForEntity(url, service, Service.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println(postResponse);
        System.out.println(postResponse.getBody());
    }

    @Test
    void b_read() {
        String url = baseUrl + "read/" + service.getServiceType();
        System.out.println("URL: " + url);
        ResponseEntity<Service> response = restTemplate.getForEntity(url, Service.class);
    }

    @Test
    void c_update() {
        Service updated = new Service.Builder().copy(service).setserviceType("Service").build();
        String url = baseUrl + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Service> response = restTemplate.postForEntity(url, updated, Service.class);
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