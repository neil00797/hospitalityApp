package org.hospitality.app.controller.utility;

import junit.framework.TestCase;
import org.hospitality.app.entity.user.StayInformation;
import org.hospitality.app.entity.utility.Payment;
import org.hospitality.app.factory.user.StayInformationFactory;
import org.hospitality.app.factory.utility.PaymentFactory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class StayInformationControllerTest
{
    StayInformation stayInformation = StayInformationFactory.createStayInformation( "4 days");
    private static String SECURITY_USERNAME = "root";
    private static String SECURITY_PASSWORD = "password";


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http:/localhost:8080/StayInformation/";

    @Test
    public void testCreate()
    {

        String url = baseURL + "create";
        ResponseEntity<StayInformation> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .postForEntity(url , stayInformation, StayInformation.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println(postResponse);
        System.out.println(postResponse.getBody());
        assertEquals(HttpStatus.FORBIDDEN , postResponse.getStatusCode());
    }

    @Test
    @Ignore
    public void testread() {
        String url = baseURL + "read" + stayInformation.getStayDuration();
        System.out.println("URL: " + url);
        ResponseEntity<StayInformation> response = restTemplate.getForEntity(url, StayInformation.class);

    }

    @Test
    @Ignore
    public void testupdate()
    {

        StayInformation update = new StayInformation.Builder().copy(stayInformation).setStayDuration("14 Days").build();
        String url = baseURL + "update";
        System.out.println("URL: " + url);
        System.out.println("Updated data: " + update);
        ResponseEntity<StayInformation> response = restTemplate.postForEntity(url, update, StayInformation.class);

    }

    @Test
    @Ignore
    public void testdelete()
    {
        String url = baseURL + "delete" + stayInformation.getOccupantId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    @Ignore
    public void testGetAll()
    {
        String url = baseURL + "all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("null", headers);
        ResponseEntity<String> response = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity , String.class);
        System.out.println(response);
        System.out.println(response.getBody());

    }
}