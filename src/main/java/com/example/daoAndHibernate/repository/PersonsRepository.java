package com.example.daoAndHibernate.repository;

import com.example.daoAndHibernate.POJO.Persons;

import java.util.List;

public interface PersonsRepository {
   List<Persons>  getPersonsByCity(String city);

}

