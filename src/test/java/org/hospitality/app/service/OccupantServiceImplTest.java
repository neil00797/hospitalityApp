package org.hospitality.app.service;

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


    @Test
    public void d_getAll() {
        Set<Occupant> occupants = service.getAll();
        assertEquals(1, occupants.size());
        System.out.println("All Occupants: " + occupants);
    }

    @Test
    public void a_create() {
        Occupant created = service.create(occupant);
        Assert.assertEquals(occupant.getOccupantId(), created.getOccupantId());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Occupant read = service.read(occupant.getOccupantId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Occupant updated = new Occupant.Builder().copy(occupant).setFirstName("Neil").setLastName("Johnson").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void f_delete() {
        boolean deleted = service.delete(occupant.getOccupantId());
        Assert.assertTrue(deleted);
        System.out.println("Successfully deleted!");
    }

    @Test
    public void e_getAllStartingWithN() {
        Set<Occupant> occStartWithN = service.getAllStartingWithN();
        System.out.println("Starting with N: " + occStartWithN);
    }
}