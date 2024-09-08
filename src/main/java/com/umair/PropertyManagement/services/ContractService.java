package com.umair.PropertyManagement.services;


import com.umair.PropertyManagement.dto.ContractDTO;
import com.umair.PropertyManagement.model.Contract;

import java.util.List;

public interface ContractService {
    List<ContractDTO> findAllContracts();
    ContractDTO findContractById(Long contractId);
    ContractDTO createContract(ContractDTO contract);
    ContractDTO updateContract(ContractDTO contract);
    Boolean deleteContract(Long contractId);
}
