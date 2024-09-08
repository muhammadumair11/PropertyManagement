package com.umair.PropertyManagement.mapper;

import com.umair.PropertyManagement.model.Payment;
import com.umair.PropertyManagement.dto.PaymentDTO;

public class PaymentMapper {

    public static PaymentDTO PaymentToPaymentDTO(Payment payment) {
        if (payment == null) return null;

        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setPaymentDate(payment.getPaymentDate());
        paymentDTO.setPaymentMethod(payment.getPaymentMethod());
        paymentDTO.setAmount(payment.getAmount());

        return paymentDTO;
    }

    public static Payment PaymentDTOToPayment(PaymentDTO paymentDTO) {
        if (paymentDTO == null) return null;

        Payment payment = new Payment();
        payment.setPaymentDate(paymentDTO.getPaymentDate());
        payment.setPaymentMethod(paymentDTO.getPaymentMethod());
        payment.setAmount(paymentDTO.getAmount());

        return payment;
    }
}
