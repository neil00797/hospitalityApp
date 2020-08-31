package org.hospitality.app.repository.service.impl;
/*
    author: @SenzoMkupa
    date: 31-08-2020
 */


import org.hospitality.app.entity.service.Ailment;
import org.hospitality.app.repository.service.AilmentRepository;


import java.util.HashSet;
import java.util.Set;

public class AilmentRepositoryImpl implements AilmentRepository {

    private static AilmentRepository repository = null;
    private Set<Ailment> ailmentDB;

    private AilmentRepositoryImpl() {this.ailmentDB = new HashSet<>();}

    public static AilmentRepository getRepository(){
        if (repository == null) repository = new AilmentRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Ailment> getAll() {
        return this.ailmentDB;
    }

    @Override
    public Ailment create(Ailment ailment) {
        this.ailmentDB.add(ailment);
        return ailment;

    }

    @Override
    public Ailment read(String s) {
        for (Ailment ailment: this.ailmentDB){
            if (ailment.getAilmentID().equalsIgnoreCase(s));
            return ailment;
        }

        return null;
    }

    @Override
    public Ailment update(Ailment ailment) {
        boolean deleteAilment = delete(ailment.getAilmentID());
        if (deleteAilment){
            this.ailmentDB.add(ailment);
            return ailment;
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        Ailment ailment = read(s);

        if(ailment != null){
            this.ailmentDB.remove(ailment);
            return true;
        }
        return false;

    }
}
