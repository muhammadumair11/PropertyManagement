package com.umair.PropertyManagement.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private Date transactionDate;
    private Double amount;
    private List<PaymentDTO> payments;
}
