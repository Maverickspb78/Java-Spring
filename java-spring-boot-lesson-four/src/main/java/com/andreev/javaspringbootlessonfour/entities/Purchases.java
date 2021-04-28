package com.andreev.javaspringbootlessonfour.entities;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "purchases")
//@Component
public class Purchases {

//    @OneToMany(mappedBy = "purchases")
    private Long id;




}
