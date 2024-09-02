package com.umair.PropertyManagement.mapper;

import com.umair.PropertyManagement.model.Contract;
import com.umair.PropertyManagement.model.dto.ContractDTO;

import java.util.stream.Collectors;

public class ContractMapper {

    public static ContractDTO ContractToContractDTO(Contract contract) {
        if (contract == null) return null;

        ContractDTO contractDTO = new ContractDTO();
        contractDTO.setTerms(contract.getTerms());

        // Assuming there is a TransactionMapper to handle conversion of Transaction to TransactionDTO
        if (contract.getTransactions() != null) {
            contractDTO.setTransactions(contract.getTransactions().stream()
                    .map(TransactionMapper::TransactionToTransactionDTO)
                    .collect(Collectors.toList()));
        }

        return contractDTO;
    }

    public static Contract ContractDTOToContract(ContractDTO contractDTO) {
        if (contractDTO == null) return null;

        Contract contract = new Contract();
        contract.setTerms(contractDTO.getTerms());

        // Assuming there is a TransactionMapper to handle conversion of TransactionDTO to Transaction
        if (contractDTO.getTransactions() != null) {
            contract.setTransactions(contractDTO.getTransactions().stream()
                    .map(TransactionMapper::TransactionDTOToTransaction)
                    .collect(Collectors.toList()));
        }

        return contract;
    }
}
