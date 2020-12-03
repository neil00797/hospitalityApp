package org.hospitality.app.controller.utility;

import org.hospitality.app.entity.utility.Delivery;
import org.hospitality.app.entity.utility.Payment;
import org.hospitality.app.factory.utility.DeliveryFactory;
import org.hospitality.app.factory.utility.PaymentFactory;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/*
    author: Shaun Donnelly
    desc: Test for PaymentController
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class PaymentControllerTest {

    Payment payment = PaymentFactory.createPayment("Card",1000,500, 1500);
    private static String SECURITY_USERNAME = "username";
    private static String SECURITY_PASSWORD ="test";
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/payment/";

    @Test
    public void a_create() {
        String url = baseUrl + "create";
        ResponseEntity<Payment> postResponse = restTemplate.postForEntity(url, payment, Payment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse);
        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_read() {
        String url = baseUrl + "read/" + payment.getReceiptNumber();
        System.out.println("URL: " + url);
        ResponseEntity<Payment> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .getForEntity(url, Payment.class);

    }

    @Test
    public void c_update() {
        Payment updated = new Payment.Builder().copy(payment).setPaymentMethod("Cash").build();
        String url = baseUrl + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Payment> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .postForEntity(url, updated, Payment.class);

    }

    @Test
    public void e_delete() {
        String url = baseUrl + "delete/" + payment.getServiceCost();
        System.out.println("URL: " + url);
        restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .delete(url);
    }

    @Test
    public void d_getAll() {
        String url = baseUrl + "all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("null", headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity,String.class);
        System.out.println(response);
        System.out.println(response.getBody());
    }
}