package com.umair.PropertyManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//id bigint [pk, increment]
//url varchar
//property_id bigint [ref: > Property.id]

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String url;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "property_id")
    Property property;
}
