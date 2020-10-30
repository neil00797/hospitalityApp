package org.hospitality.app.service.user.impl;

/*
    author: @NeilJohnson
    desc: Occupant service implementation
    date: 01-09-2020
 */

import org.hospitality.app.entity.user.Occupant;
import org.hospitality.app.repository.user.OccupantRepository;
import org.hospitality.app.service.user.OccupantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OccupantServiceImpl implements OccupantService {
    @Autowired
    private OccupantRepository repository;

    @Override
    public Set<Occupant> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Occupant create(Occupant occupant) {
        return this.repository.save(occupant);
    }

    @Override
    public Occupant read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Occupant update(Occupant occupant) {
        if (this.repository.existsById(occupant.getOccupantId())) {
            return this.repository.save(occupant);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if (this.repository.existsById(s))
        {
            return false;
        }

        return true;
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
