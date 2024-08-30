package com.umair.PropertyManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


//id bigint [pk, increment]
//status_name varchar

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListingStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String statusName;

    @OneToMany(mappedBy = "listingStatus")
    @JsonIgnore
    List<Listing> listings;
}
