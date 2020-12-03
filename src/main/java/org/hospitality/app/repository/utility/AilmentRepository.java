package org.hospitality.app.repository.utility;

import org.hospitality.app.entity.utility.Ailment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
    author: @SenzoMkupa
    date: 31-08-2020
 */


import java.util.Set;

@Repository
public interface AilmentRepository extends JpaRepository<Ailment, String> {
}
