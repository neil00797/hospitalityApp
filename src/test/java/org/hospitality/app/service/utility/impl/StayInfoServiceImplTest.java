package org.hospitality.app.service.utility.impl;

import org.hospitality.app.entity.user.StayInformation;
import org.hospitality.app.factory.user.StayInformationFactory;
import org.hospitality.app.service.utility.StayInfoService;
import org.junit.Assert;
import org.junit.Test;

/*
    Thaakir Ajouhaar - 217244394

 */

public class StayInfoServiceImplTest {

    private static StayInfoService service = StayInfoServiceImpl.getService();
    private static StayInformation stayInformation = StayInformationFactory.createStayInformation("5 days");
    private static StayInformation StayInformation2 = StayInformationFactory.createStayInformation("14 Days" );

    @Test
    public void getAll() {

        System.out.println("Get all: " + service.getAll() + "\n");
    }

    @Test
    public void create()
    {
        StayInformation created1 = service.create(stayInformation);
        Assert.assertEquals(stayInformation.getStayDuration(), created1.getStayDuration());

        StayInformation created2 = service.create(StayInformation2);
        Assert.assertEquals(StayInformation2.getStayDuration(), created2.getStayDuration());
        System.out.println("Created Record1: " + created1 + "\n" + "Created Record2: " + created2 + "\n");
    }

    @Test
    public void read()
    {
        StayInformation read1 = service.read(stayInformation.getStayDuration());
        StayInformation read2 = service.read(StayInformation2.getStayDuration());
            System.out.println("Read Record1: " + read1 + "\n" + "Read Record2: " + read2 + "\n");
    }

    @Test
    public void c_update() {
        StayInformation updated1 = new StayInformation.Builder().copy(stayInformation).setStayDuration("4 days").build();
        StayInformation updated2 = new StayInformation.Builder().copy(StayInformation2).setStayDuration("17 Days").build();
        updated1 = service.update(updated1);
        updated2 = service.update(updated2);
        System.out.println("Updated: " + updated1 + "\n" + "Updated2: " + updated2 + "\n");
    }

    @Test
    public void f_delete() {
        boolean deleted = service.delete(stayInformation.getStayDuration());
        Assert.assertTrue(deleted);
        boolean deleted2 = service.delete(StayInformation2.getStayDuration());
        Assert.assertTrue(deleted2);
        System.out.println("Records Deleted Successfully");
    }
}

