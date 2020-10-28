package org.hospitality.app.repository.user;
/*
    author: @NeilJohnson
    desc: Occupant Implementation Test for create, read, update and deleting user
    date: 29-06-2020
 */

import org.hospitality.app.entity.user.Occupant;
import org.hospitality.app.factory.user.OccupantFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OccupantRepositoryImplTest {
    @Autowired
    private static OccupantRepository repository;
    private static Occupant occupant = OccupantFactory.createOccupant("Nail", "Jonson");

    @Test
    public void a_create(){
        Occupant created = repository.save(occupant);
        Assert.assertEquals(occupant.getOccupantId(), created.getOccupantId());
        System.out.println("Created ID: " + created);
    }

    @Test
    public void b_read(){
        Occupant read = repository.findById(occupant.getOccupantId()).orElseGet(null);
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update(){
        Occupant updated = new Occupant.Builder().copy(occupant).setFirstName("Neil").setLastName("Johnson").build();
        updated = repository.save(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete(){
        repository.deleteById(occupant.getOccupantId());
    }

    @Test
    public void d_getAll(){
        System.out.println("Get all: " + repository.findAll().stream().collect(Collectors.toSet()));
    }
}
