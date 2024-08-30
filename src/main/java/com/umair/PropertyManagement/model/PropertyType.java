package com.umair.PropertyManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//id bigint [pk, increment]
//type_name varchar
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String propertyType;

    @OneToMany(mappedBy = "propertyType")
    @JsonIgnore
    List<Property> properties;
}
