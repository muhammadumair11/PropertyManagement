package com.umair.PropertyManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//id bigint [pk, increment]
//buyer_id bigint [ref: > User.id]
//seller_id bigint [ref: > User.id]
//property_id bigint [ref: > Property.id]
//terms text

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Lob
    String terms;

    @OneToMany(mappedBy = "contract")
    List<Transaction> transactions;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "buyer_id")
    User buyer;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "seller_id")
    User seller;

    @OneToOne
    @JoinColumn(name = "property_id", referencedColumnName = "id")
    Property property;
}
