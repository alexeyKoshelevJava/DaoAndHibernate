package com.example.daoAndHibernate.controller;

import com.example.daoAndHibernate.POJO.Persons;
import com.example.daoAndHibernate.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class PersonsController {

    @Autowired
    private PersonsService service;

    @GetMapping("/person/by_city")
    public List<Persons> findByCity(@RequestParam(value = "city") String city) {
        return service.findByCity(city);

    }

    @GetMapping("/person/by_age_less_than")
    public List<Persons> findByPersonsId_ageLessThanOrderByPersonsId_age(@RequestParam(value = "age") int age) {
        return service.findByPersonsId_ageLessThanOrderByPersonsId_age(age);
    }

    @GetMapping("/person/by_name_and_surname")
    public Persons findByPersonsId_nameAndPersonsId_surname(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname) {
        return service.findByPersonsId_nameAndPersonsId_surname(name, surname).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }


}

