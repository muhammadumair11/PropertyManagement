package com.umair.PropertyManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.umair.PropertyManagement.Enums.PropertyTypeEnum;
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

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    PropertyTypeEnum name;

    @OneToMany(mappedBy = "propertyType")
    @JsonIgnore
    List<Property> properties;

    public PropertyType(PropertyTypeEnum name) {
        this.name = name;
    }
}
