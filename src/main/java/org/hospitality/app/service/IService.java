package org.hospitality.app.service;

public interface IService<U, ID>{
    U create(U u);
    U read(ID id);
    U update(U u);
    boolean delete(ID id);
}
