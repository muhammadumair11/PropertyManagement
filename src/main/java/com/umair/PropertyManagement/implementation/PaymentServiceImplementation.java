package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.model.Payment;
import com.umair.PropertyManagement.repository.PaymentRepository;
import com.umair.PropertyManagement.services.PaymentService;
import com.umair.PropertyManagement.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImplementation implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public List<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        Payment payment1 = findPaymentById(payment.getId());
        if(payment1 != null) {
            payment.setId(payment1.getId());
            return paymentRepository.save(payment);
        }
        return null;
    }

    @Override
    public Boolean deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
        if(findPaymentById(paymentId) == null)
            return true;
        return false;
    }
}
