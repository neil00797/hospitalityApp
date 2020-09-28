package org.hospitality.app.controller.user;

import org.hospitality.app.entity.user.Room;
import org.hospitality.app.factory.user.RoomFactory;
import org.hospitality.app.service.user.impl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomServiceImpl roomService;

    @PostMapping("/create")
    public Room create(@RequestBody Room room) {
        Room newRoom = RoomFactory.createRoom(room.getOccupantId(), room.getAvailability());
        return roomService.create(newRoom);
    }

    @GetMapping("/read/{id}")
    public Room read(@PathVariable String id){
        return roomService.read(id);
    }

    @PostMapping("/update")
    public Room update(@RequestBody Room room){
        return roomService.update(room);
    }

    @GetMapping("/all")
    public Set<Room> getAll(){
        return roomService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        roomService.delete(id);
    }
}
