package com.umair.PropertyManagement.mapper;

import com.umair.PropertyManagement.model.Transaction;
import com.umair.PropertyManagement.dto.TransactionDTO;

import java.util.stream.Collectors;

public class TransactionMapper {

    public static TransactionDTO TransactionToTransactionDTO(Transaction transaction) {
        if (transaction == null) return null;

        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setTransactionDate(transaction.getTransactionDate());
        transactionDTO.setAmount(transaction.getAmount());

        // Assuming there is a PaymentMapper to handle conversion of Payment to PaymentDTO
        if (transaction.getPayments() != null) {
            transactionDTO.setPayments(transaction.getPayments().stream()
                    .map(PaymentMapper::PaymentToPaymentDTO)
                    .collect(Collectors.toList()));
        }

        return transactionDTO;
    }

    public static Transaction TransactionDTOToTransaction(TransactionDTO transactionDTO) {
        if (transactionDTO == null) return null;

        Transaction transaction = new Transaction();
        transaction.setTransactionDate(transactionDTO.getTransactionDate());
        transaction.setAmount(transactionDTO.getAmount());

        // Assuming there is a PaymentMapper to handle conversion of PaymentDTO to Payment
        if (transactionDTO.getPayments() != null) {
            transaction.setPayments(transactionDTO.getPayments().stream()
                    .map(PaymentMapper::PaymentDTOToPayment)
                    .collect(Collectors.toList()));
        }

        return transaction;
    }
}
