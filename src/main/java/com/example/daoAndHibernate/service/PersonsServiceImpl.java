package com.example.daoAndHibernate.service;

import com.example.daoAndHibernate.POJO.Persons;
import com.example.daoAndHibernate.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonsServiceImpl implements PersonsService {
    @Autowired
    private PersonsRepository repository;


    @Override
    public List<Persons> findByCity(String city) {
        return repository.findByCity(city);
    }

    @Override
    public List<Persons> findByPersonsId_ageLessThanOrderByPersonsId_age(int age) {
        return repository.findByPersonsId_ageLessThanOrderByPersonsId_age(age);
    }

    @Override
    public Optional<Persons> findByPersonsId_nameAndPersonsId_surname(String name, String surname) {
        return repository.findByPersonsId_nameAndPersonsId_surname(name, surname);
    }
}
