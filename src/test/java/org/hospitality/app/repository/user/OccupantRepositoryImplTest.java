/*
package org.hospitality.app.repository.user;
*/
/*
    author: @NeilJohnson
    desc: Occupant Implementation Test for create, read, update and deleting user
    date: 29-06-2020
 *//*


import org.hospitality.app.entity.user.Occupant;
import org.hospitality.app.factory.user.OccupantFactory;
import org.hospitality.app.repository.user.OccupantRepository;
import org.hospitality.app.repository.user.impl.OccupantRepositoryImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OccupantRepositoryImplTest {
    private static OccupantRepository repository = OccupantRepositoryImpl.getRepository();
    private static Occupant occupant = OccupantFactory.createOccupant("Nail", "Jonson");

    @Test
    public void a_create(){
        Occupant created = repository.create(occupant);
        Assert.assertEquals(occupant.getOccupantId(), created.getOccupantId());
        System.out.println("Created ID: " + created);
    }

    @Test
    public void b_read(){
        Occupant read = repository.read(occupant.getOccupantId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update(){
        Occupant updated = new Occupant.Builder().copy(occupant).setFirstName("Neil").setLastName("Johnson").build();
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete(){
        boolean deleted = repository.delete(occupant.getOccupantId());
        Assert.assertTrue(deleted);
        System.out.println("Successfully deleted!");
    }

    @Test
    public void d_getAll(){
        System.out.println("Get all: " + repository.getAll());
    }
}
*/
