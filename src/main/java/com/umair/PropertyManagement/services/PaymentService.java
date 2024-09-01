package com.umair.PropertyManagement.services;

import com.umair.PropertyManagement.model.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> findAllPayments();
    Payment findPaymentById(Long paymentId);
    Payment createPayment(Payment payment);
    Payment updatePayment(Payment payment);
    Boolean deletePayment(Long paymentId);
}
