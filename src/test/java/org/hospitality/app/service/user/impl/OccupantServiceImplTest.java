package org.hospitality.app.service.user.impl;

/*
    author: @NeilJohnson
    desc: Occupant service implementation test
    date: 01-09-2020
 */

import org.hospitality.app.entity.user.Occupant;
import org.hospitality.app.factory.user.OccupantFactory;
import org.hospitality.app.service.user.OccupantService;
import org.hospitality.app.service.user.impl.OccupantServiceImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OccupantServiceImplTest {
    private static OccupantService service = OccupantServiceImpl.getService();
    private static Occupant occupant = OccupantFactory.createOccupant("Nail", "Jonson");
    private static Occupant occupant2 = OccupantFactory.createOccupant("Jak", "Swager");


    @Test
    public void e_getAll() {
        Set<Occupant> occupants = service.getAll();

        System.out.println("All Occupants: " + occupants + "\n");
    }

    @Test
    public void a_create() {
        Occupant created = service.create(occupant);
        Assert.assertEquals(occupant.getOccupantId(), created.getOccupantId());

        Occupant created2 = service.create(occupant2);
        Assert.assertEquals(occupant2.getOccupantId(), created2.getOccupantId());

        System.out.println("Created: " + created + "\n" + "Created2: " + created2 + "\n");
    }

    @Test
    public void b_read() {
        Occupant read = service.read(occupant.getOccupantId());
        Occupant read2 = service.read(occupant2.getOccupantId());
        System.out.println("Read: " + read + "\n" + "Read2: " + read2 + "\n");
    }

    @Test
    public void c_update() {
        Occupant updated = new Occupant.Builder().copy(occupant).setFirstName("Neil").setLastName("Johnson").build();
        updated = service.update(updated);

        Occupant updated2 = new Occupant.Builder().copy(occupant2).setFirstName("Jack").setLastName("Swagger").build();

        System.out.println("Updated: " + updated + "\n" + "Updated2: " + updated2 + "\n");
    }

    @Test
    public void f_delete() {
        boolean deleted = service.delete(occupant.getOccupantId());
        Assert.assertTrue(deleted);
        boolean deleted2 = service.delete(occupant2.getOccupantId());
        Assert.assertTrue(deleted2);

        System.out.println("Successfully deleted!");
    }

    @Test
    public void d_getByFirstName() {
        Set<Occupant> occByFirstName = service.getByFirstName();
        System.out.println("Occupants named Neil: " + occByFirstName + "\n");
    }
}