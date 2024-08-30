package com.umair.PropertyManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//id bigint [pk, increment]
//listing_date date
//status_id bigint [ref: > ListingStatus.id]
//property_id bigint [ref: > Property.id]

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date listingDate;

    @ManyToOne
    @JoinColumn(name = "listing_status_id")
    ListingStatus listingStatus;

    @OneToOne
    @JoinColumn(name = "property_id", referencedColumnName = "id")
    Property property;
}
