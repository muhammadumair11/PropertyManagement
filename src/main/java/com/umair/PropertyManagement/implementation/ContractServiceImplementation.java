package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.dto.ContractDTO;
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
    public List<ContractDTO> findAllContracts() {
        return List.of();
    }

    @Override
    public ContractDTO findContractById(Long contractId) {
        return null;
    }

    @Override
    public ContractDTO createContract(ContractDTO contract) {
        return null;
    }

    @Override
    public ContractDTO updateContract(ContractDTO contract) {
        return null;
    }

    @Override
    public Boolean deleteContract(Long contractId) {
        contractRepository.deleteById(contractId);
        if(contractRepository.findById(contractId).orElse(null) == null)
            return true;
        return false;
    }
}
