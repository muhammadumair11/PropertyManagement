package com.umair.PropertyManagement.services;


import com.umair.PropertyManagement.model.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> findAllContracts();
    Contract findContractById(Long contractId);
    Contract createContract(Contract contract);
    Contract updateContract(Contract contract);
    Boolean deleteContract(Long contractId);
}
