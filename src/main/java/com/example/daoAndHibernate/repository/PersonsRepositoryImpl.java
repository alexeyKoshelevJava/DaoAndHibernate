package com.example.daoAndHibernate.repository;

import ch.qos.logback.classic.spi.EventArgUtil;
import com.example.daoAndHibernate.POJO.Persons;
import com.example.daoAndHibernate.POJO.PersonsId;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
@Transactional
@Repository

public class PersonsRepositoryImpl implements PersonsRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Persons> getPersonsByCity(String city) {
        createPersons();
        Query query = entityManager.createQuery("select p from Persons p where p.city= :city",Persons.class);
        query.setParameter("city",city);
        var resultList = query.getResultList();
        return resultList;


    }

    public void createPersons() {
        List<Persons> personsList = new ArrayList<>();
        Persons persons1 = new Persons(new PersonsId("Alexey", "Alexeev", 20), "9874566", "Moscow");
        Persons persons2 = new Persons(new PersonsId("Ivan", "Ivanov", 15), "8523657", "Tambov");
        Persons persons3 = new Persons(new PersonsId("Sergey", "Sergeev", 31), "245896", "Saratov");
        Persons persons4 = new Persons(new PersonsId("Petr", "Petrov", 28), "12596358", "Moscow");
        Persons persons5 = new Persons(new PersonsId("Sidor", "sidorov", 61), "321456", "New-wasuki");
        Persons persons6 = new Persons(new PersonsId("Kolivan", "Kolivanov", 39), "8579658", "St-Peterburg");
        Persons persons7 = new Persons(new PersonsId("Inokentiy", "Smoktunovsky", 93), "365241", "Moscow");
        Persons persons8 = new Persons(new PersonsId("Isaak", "Nyuton", 65), "1478596", "St_Peterburg");
        Persons persons9 = new Persons(new PersonsId("Rodion", "Radionov", 58), "784589", "New-wasuki");
        Persons persons10 = new Persons(new PersonsId("Gerar", "Depardie", 65), "5487693", "Tambov");
        personsList.add(persons1);
        personsList.add(persons2);
        personsList.add(persons3);
        personsList.add(persons4);
        personsList.add(persons5);
        personsList.add(persons6);
        personsList.add(persons7);
        personsList.add(persons8);
        personsList.add(persons9);
        personsList.add(persons10);
        for (Persons persons : personsList) {
            entityManager.persist(persons);
        }

    }
}
