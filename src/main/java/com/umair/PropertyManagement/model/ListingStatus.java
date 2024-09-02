package com.umair.PropertyManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.umair.PropertyManagement.Enums.ListingStatusesEnum;
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
    @Enumerated(EnumType.STRING)
    ListingStatusesEnum name;

    @OneToMany(mappedBy = "listingStatus")
    @JsonIgnore
    List<Listing> listings;

    public ListingStatus(ListingStatusesEnum name) {
        this.name = name;
    }
}
