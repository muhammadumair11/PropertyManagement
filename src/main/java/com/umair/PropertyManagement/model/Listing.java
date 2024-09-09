package com.umair.PropertyManagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

//id bigint [pk, increment]
//listing_date date
//status_id bigint [ref: > ListingStatus.id]
//property_id bigint [ref: > Property.id]

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
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
