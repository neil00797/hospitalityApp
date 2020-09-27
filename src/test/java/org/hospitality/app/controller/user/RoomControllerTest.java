package org.hospitality.app.controller.user;

import org.hospitality.app.entity.user.Room;
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

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoomControllerTest {

    Room room = RoomFactory.createRoom("Unavailable", "156565");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8080/room/";

    @Test
    public void a_create() {
        String url = baseUrl + "create";
        ResponseEntity<Room> postResponse = restTemplate.postForEntity(url, room, Room.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse);
        System.out.println(postResponse.getBody());
    }

    @Test
    public void b_read() {
        String url = baseUrl + "read/" + room.getAvailability();
        System.out.println("URL: " + url);
        ResponseEntity<Room> response = restTemplate.getForEntity(url, Room.class);

    }

    @Test
    public void c_update() {
        Room updated = new Room.Builder().copy(room).setAvailability("Available").setOccupantId("").build();
        String url = baseUrl + "update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Room> response = restTemplate.postForEntity(url, updated, Room.class);

    }

    @Test
    public void e_delete() {
        String url = baseUrl + "delete/" + room.getAvailability();
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