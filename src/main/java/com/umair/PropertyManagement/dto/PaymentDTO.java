package com.umair.PropertyManagement.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {
    private Date paymentDate;
    private String paymentMethod;
    private Double amount;
}
