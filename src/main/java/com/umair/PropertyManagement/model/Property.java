package com.umair.PropertyManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder(toBuilder = true)
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;
    @Column(columnDefinition = "TEXT")
    String description;
    Double price;

    @ManyToOne
    @JoinColumn(name = "property_type_id")
    PropertyType propertyType;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "address_id")
    Address address;

    @OneToMany(mappedBy = "property", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    List<Inquiry> inquiries;

    @OneToOne(mappedBy = "property")
    Contract contract;

    @OneToOne(mappedBy = "property")
    Listing listing;

    @OneToMany(mappedBy = "property", fetch = FetchType.EAGER, orphanRemoval = true)
    List<Image> images;

    @OneToMany(mappedBy = "property", orphanRemoval = true)
    List<Review> reviews;

    @ManyToMany(mappedBy = "favoriteProperties")
    @JsonIgnore
    List<User> users;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "agent_id")
    User agent;

}
