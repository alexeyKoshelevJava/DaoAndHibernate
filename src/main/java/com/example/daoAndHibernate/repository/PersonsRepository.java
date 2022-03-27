package com.example.daoAndHibernate.repository;

import com.example.daoAndHibernate.POJO.Persons;
import com.example.daoAndHibernate.POJO.PersonsId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonsRepository extends JpaRepository<Persons, PersonsId> {

    Optional<Persons> findByPersonsId_name(String name);
    List<Persons> findByCity(String city);

    List<Persons> findByPersonsId_ageLessThanOrderByPersonsId_age(int age);

    Optional<Persons> findByPersonsId_nameAndPersonsId_surname(String name, String surname);
}

