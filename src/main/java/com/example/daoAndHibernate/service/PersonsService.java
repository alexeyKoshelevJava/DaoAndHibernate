package com.example.daoAndHibernate.service;

import com.example.daoAndHibernate.POJO.Persons;

import java.util.List;

public interface PersonsService {
   List<Persons> getPersonsByCity(String city);
}
