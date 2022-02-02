package com.example.daoAndHibernate.service;

import com.example.daoAndHibernate.POJO.Persons;

import java.util.List;
import java.util.Optional;

public interface PersonsService {
    List<Persons> findByCity(String city);

    List<Persons> findByPersonsId_ageLessThanOrderByPersonsId_age(int age);

    Optional<Persons> findByPersonsId_nameAndPersonsId_surname(String name, String surname);
}
