package org.hospitality.app.service.utility.impl;
/*
    author: @SenzoMkupa
    date: 06-09-2020
 */

import org.hospitality.app.entity.utility.Ailment;
import org.hospitality.app.repository.utility.AilmentRepository;
import org.hospitality.app.repository.utility.impl.AilmentRepositoryImpl;
import org.hospitality.app.service.utility.AilmentService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class AilmentServiceImpl implements AilmentService {
    private  static AilmentService service = null;
    private AilmentRepository repository;

    private AilmentServiceImpl()
    {
        this.repository = AilmentRepositoryImpl.getRepository();
    }

    public static AilmentService getService(){
        if (service==null)
            service = new AilmentServiceImpl();
        return service;
    }
    @Override
    public Set<Ailment> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Set<Ailment> findByDesc(String s) {
        Set<Ailment> ailments = getAll();
        Set<Ailment> ailmentsByDescription = new HashSet<>();

        for (Ailment ailment: ailments){
            if(ailment.getAilmentDesc().toLowerCase().contentEquals(s)){
                ailmentsByDescription.add(ailment);
            }
        }
        return ailmentsByDescription;
    }


    @Override
    public Ailment create(Ailment ailment) {
        return this.repository.create(ailment);
    }

    @Override
    public Ailment read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Ailment update(Ailment ailment) {
        return this.repository.update(ailment);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
