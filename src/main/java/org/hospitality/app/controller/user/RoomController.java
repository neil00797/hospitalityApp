package org.hospitality.app.controller.user;

import org.hospitality.app.entity.user.Room;
import org.hospitality.app.factory.user.RoomFactory;
import org.hospitality.app.service.user.impl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/hospitality_db/room")
public class RoomController {

    @Autowired
    private RoomServiceImpl roomService;

    @PostMapping("/create")
    public Room create(@RequestBody Room room) {
        Room newRoom = RoomFactory.createRoom(room.getOccupantId(), room.getAvailability());
        return roomService.create(newRoom);
    }

    @GetMapping("/read/{occupantId}")
    public Room read(@PathVariable String occupantId){
        return roomService.read(occupantId);
    }

    @PostMapping("/update")
    public Room update(@RequestBody Room s){
        return roomService.update(s);
    }

    @GetMapping("/all")
    public Set<Room> getAll(){
        return roomService.getAll();
    }

    @DeleteMapping("/delete/{occupantId}")
    public void delete(@PathVariable String occupantId){
        roomService.delete(occupantId);
    }
}
