package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.model.Contract;
import com.umair.PropertyManagement.repository.ContractRepository;
import com.umair.PropertyManagement.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImplementation implements ContractService {

    @Autowired
    ContractRepository contractRepository;

    @Override
    public List<Contract> findAllContracts() {
        return contractRepository.findAll();
    }

    @Override
    public Contract findContractById(Long contractId) {
        return contractRepository.findById(contractId).orElse(null);
    }

    @Override
    public Contract createContract(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Contract updateContract(Contract contract) {
        Contract contract1 = findContractById(contract.getId());

        if(contract1 != null) {
            contract.setId(contract1.getId());
            return contractRepository.save(contract);
        }
        return null;
    }

    @Override
    public Boolean deleteContract(Long contractId) {
        contractRepository.deleteById(contractId);
        if(findContractById(contractId) == null)
            return true;
        return false;
    }
}
