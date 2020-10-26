package org.hospitality.app.repository;
/*
    author: @NeilJohnson
    desc: IRepository for create, read, update and delete
    date: 29-06-2020
 */

@Deprecated
public interface IRepository <U, ID>{
    U create(U u);
    U read(ID id);
    U update(U u);
    boolean delete(ID id);
}
