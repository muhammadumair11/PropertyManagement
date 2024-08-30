package com.umair.PropertyManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//id bigint [pk, increment]
//street varchar
//city varchar
//state varchar
//country varchar
//zip_code varchar

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String street;
    String city;
    String state;
    String country;
    String zipCode;

    @OneToMany(mappedBy = "address")
    @JsonIgnore
    List<Property> properties;
}
