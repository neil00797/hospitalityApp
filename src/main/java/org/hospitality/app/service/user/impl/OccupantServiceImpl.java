package org.hospitality.app.service.user.impl;

/*
    author: @NeilJohnson
    desc: Occupant service implementation
    date: 01-09-2020
 */

import org.hospitality.app.entity.user.Occupant;
import org.hospitality.app.repository.user.OccupantRepository;
import org.hospitality.app.repository.user.impl.OccupantRepositoryImpl;
import org.hospitality.app.service.user.OccupantService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class OccupantServiceImpl implements OccupantService {
    private static OccupantService service = null;
    private OccupantRepository repository;

    private OccupantServiceImpl() {
        this.repository = OccupantRepositoryImpl.getRepository();
    }

    public static OccupantService getService(){
        if (service == null) service = new OccupantServiceImpl();
        return service;
    }

    @Override
    public Set<Occupant> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Occupant create(Occupant occupant) {
        return this.repository.create(occupant);
    }

    @Override
    public Occupant read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Occupant update(Occupant occupant) {
        return this.repository.update(occupant);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }

    @Override
    public Set<Occupant> getByFirstName() {
        Set<Occupant> occupants = getAll();
        Set<Occupant> occupantsByFirstName = new HashSet<>();

        for (Occupant occupant: occupants){
            if (occupant.getFirstName().equalsIgnoreCase("Neil")){
                occupantsByFirstName.add(occupant);
            }
        }
        return occupantsByFirstName;
    }

    @Override
    public Set<Occupant> getByLastName() {
        Set<Occupant> occupants = getAll();
        Set<Occupant> occupantsByLastName = new HashSet<>();

        for (Occupant occupant: occupants){
            if (occupant.getLastName().equalsIgnoreCase("Johnson")){
                occupantsByLastName.add(occupant);
            }
        }
        return occupantsByLastName;
    }
    }
