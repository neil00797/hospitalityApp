/*
package org.hospitality.app.repository.utility;

import org.hospitality.app.entity.user.StayInformation;
import org.hospitality.app.factory.user.StayInformationFactory;
import org.hospitality.app.repository.utility.StayInfoRepository;
import org.hospitality.app.repository.utility.impl.StayInfoRepositoryImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StayInfoRepositoryImplTest
{
    @Autowired
    private static StayInfoRepository repository;
    private static StayInformation stayInformation = StayInformationFactory.createStayInformation("3weeks");

    @Test
    public void a_create(){
        StayInformation created = repository.create(stayInformation);
        Assert.assertEquals(stayInformation.getStayDuration(), created.getStayDuration());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read(){
        StayInformation read = repository.read(stayInformation.getStayDuration());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update(){
        StayInformation updated = new StayInformation.Builder().copy(stayInformation).setStayDuration("5 Weeks").build();;
        updated = repository.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void e_delete(){
        boolean deleted = repository.delete(stayInformation.getStayDuration());
        Assert.assertTrue(deleted);
    }

    @Test
    public void d_getAll(){
        System.out.println("Get all: " + repository.findAll());
    }
}

*/
