package com.umair.PropertyManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

//id bigint [pk, increment]
//contract_id bigint [ref: > Contract.id]
//transaction_date date
//amount decimal

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date transactionDate;
    Double amount;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "contract_id")
    Contract contract;

    @OneToMany(mappedBy = "transaction")
    List<Payment> payments;
}
