package org.hospitality.app.controller.utility;

import junit.framework.TestCase;
import org.hospitality.app.entity.user.StayInformation;
import org.hospitality.app.factory.user.StayInformationFactory;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class StayInformationControllerTest
{
    private TestRestTemplate restTemplate;
    private String baseURL = "http:/localhost:8080/StayInformation";

    public void testCreate()
    {
        StayInformation stayInformation = StayInformationFactory.createStayInformation("4 days");
        String url = baseURL + "create";
        ResponseEntity<StayInformation> postResponse = restTemplate.postForEntity(url , stayInformation, StayInformation.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println(postResponse.getBody());
    }

    public void testGetAll()
    {
        String url = baseURL + "all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>("null", headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity , String.class);
        System.out.println(response);
        System.out.println(response.getBody());

    }
}