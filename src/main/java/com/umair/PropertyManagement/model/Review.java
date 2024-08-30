package com.umair.PropertyManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//id bigint [pk, increment]
//rating int
//comment text
//user_id bigint [ref: > User.id]
//property_id bigint [ref: > Property.id]

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer rating;
    @Lob
    String comment;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "property_id")
    Property property;
}
