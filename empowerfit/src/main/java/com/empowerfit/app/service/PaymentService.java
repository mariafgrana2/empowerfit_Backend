package com.empowerfit.app.service;

import java.util.Set;

import com.empowerfit.app.model.Payment;


public interface PaymentService {

    
    Payment createPayment(Payment payment);
    Payment getPaymentById(Long id);
    Set<Payment> getAllPayments();
    Payment updatePayment(Payment payment, Long id);
    void deletePayment(Long id);
	Set<Payment> getAllPayments(boolean isActive);
}
