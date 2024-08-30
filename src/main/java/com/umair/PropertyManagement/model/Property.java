package com.umair.PropertyManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

//id bigint [pk, increment]
//title varchar
//description text
//price decimal
//property_type_id bigint [ref: > PropertyType.id]
//address_id bigint [ref: > Address.id]
//agent_id bigint [ref: > User.id]

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;
    @Lob
    String description;
    Double price;

    @ManyToOne
    @JoinColumn(name = "property_type_id")
    PropertyType propertyType;

    @ManyToOne
    @JoinColumn(name = "address_id")
    Address address;

    @OneToMany(mappedBy = "property")
    List<Inquiry> inquiries;

    @OneToOne(mappedBy = "property")
    Contract contract;

    @OneToOne(mappedBy = "property")
    Listing listing;

    @OneToMany(mappedBy = "property")
    List<Image> images;

    @OneToMany(mappedBy = "property")
    List<Review> reviews;

    @ManyToMany(mappedBy = "favoriteProperties")
    @JsonIgnore
    List<User> users;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "agent_id")
    User agent;

}
