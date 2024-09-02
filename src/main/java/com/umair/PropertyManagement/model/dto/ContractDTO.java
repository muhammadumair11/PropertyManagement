package com.umair.PropertyManagement.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractDTO {
    private String terms;
    private List<TransactionDTO> transactions;
}