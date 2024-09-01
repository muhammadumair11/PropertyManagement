package com.umair.PropertyManagement.services;

import com.umair.PropertyManagement.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> findAllTransactions();
    Transaction findTransactionById(Long transactionId);
    Transaction createTransaction(Transaction transaction);
    Transaction updateTransaction(Transaction transaction);
    Boolean deleteTransaction(Long transactionId);
}
