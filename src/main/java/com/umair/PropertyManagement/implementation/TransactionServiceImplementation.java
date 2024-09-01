package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.model.Transaction;
import com.umair.PropertyManagement.repository.TransactionRepository;
import com.umair.PropertyManagement.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImplementation implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> findAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction findTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId).orElse(null);
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Transaction transaction) {
        Transaction existingTransaction = findTransactionById(transaction.getId());
        if(existingTransaction != null) {
            transaction.setId(existingTransaction.getId());
            return transactionRepository.save(transaction);
        }
        return null;
    }

    @Override
    public Boolean deleteTransaction(Long transactionId) {
        transactionRepository.deleteById(transactionId);

        if(findTransactionById(transactionId) == null)
            return true;
        return false;
    }
}
