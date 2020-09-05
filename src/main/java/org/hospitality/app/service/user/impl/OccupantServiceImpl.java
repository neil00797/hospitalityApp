package org.hospitality.app.service.user.impl;

import org.hospitality.app.entity.user.Occupant;
import org.hospitality.app.repository.user.OccupantRepository;
import org.hospitality.app.repository.user.impl.OccupantRepositoryImpl;
import org.hospitality.app.service.user.OccupantService;

import java.util.HashSet;
import java.util.Set;

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
    public Set<Occupant> getAllStartingWithN() {
        Set<Occupant> occupants = getAll();
        Set<Occupant> occupantsStartingWithN = new HashSet<>();

        for (Occupant occupant: occupants){
            if (occupant.getFirstName().trim().toLowerCase().startsWith("N")){
                occupantsStartingWithN.add(occupant);
            }
        }
        return occupantsStartingWithN;
    }
}
