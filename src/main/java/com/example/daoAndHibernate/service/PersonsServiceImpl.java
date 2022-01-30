package com.example.daoAndHibernate.service;

import com.example.daoAndHibernate.POJO.Persons;
import com.example.daoAndHibernate.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonsServiceImpl implements PersonsService {
    @Autowired
    private PersonsRepository repository;

    @Override
    public List<Persons> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }
}
