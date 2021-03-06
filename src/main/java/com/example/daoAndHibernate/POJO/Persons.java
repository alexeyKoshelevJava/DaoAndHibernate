package com.example.daoAndHibernate.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "persons")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persons {
    @EmbeddedId
    private PersonsId personsId;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "city_of_living",nullable = false)
    private String city;


}

