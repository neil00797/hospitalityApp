package org.hospitality.app.repository.utility;

import org.hospitality.app.entity.utility.Service;
import org.hospitality.app.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ServiceRepository extends JpaRepository<Service, String> {

}




