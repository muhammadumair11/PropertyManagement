package com.umair.PropertyManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


//id bigint [pk, increment]
//transaction_id bigint [ref: > Transaction.id]
//payment_date date
//payment_method varchar
//amount decimal

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Date paymentDate;
    String paymentMethod;
    Double amount;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "transaction_id")
    Transaction transaction;
}
