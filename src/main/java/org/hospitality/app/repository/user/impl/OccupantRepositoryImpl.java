package org.hospitality.app.repository.user.impl;

import org.hospitality.app.entity.user.Occupant;
import org.hospitality.app.repository.user.OccupantRepository;

import java.util.HashSet;
import java.util.Set;

public class OccupantRepositoryImpl implements OccupantRepository {
    private static OccupantRepository repository = null;
    private Set<Occupant> occupantDB;

    private OccupantRepositoryImpl() {this.occupantDB = new HashSet<>();}

    public static OccupantRepository getRepository(){
        if (repository == null) repository = new OccupantRepositoryImpl();
        return repository;
    }

    @Override
    public Occupant create(Occupant occupant){
        this.occupantDB.add(occupant);
        return occupant;
    }

    @Override
    public Occupant read(String id){

        for (Occupant occupant: this.occupantDB){
            if (occupant.getOccupantId().equalsIgnoreCase(id));
        }

        return null;
    }

    @Override
    public Occupant update(Occupant occupant){
        boolean deleteOccupant = delete(occupant.getOccupantId());
        if (deleteOccupant){
            this.occupantDB.add(occupant);
            return occupant;
        }
        return null;
    }

    @Override
    public boolean delete(String id){
        Occupant occupant = read(id);

        if(occupant != null){
            this.occupantDB.remove(occupant);
            return true;
        }
        return false;
    }

    @Override
    public Set<Occupant> getAll(){
        return this.occupantDB;
    }
}
