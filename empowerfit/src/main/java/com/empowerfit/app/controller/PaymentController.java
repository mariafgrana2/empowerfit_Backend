package com.empowerfit.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.empowerfit.app.model.Payment;
import com.empowerfit.app.service.PaymentService;

import java.util.Set;

@Controller
@ResponseBody
@RequestMapping("/api/v1/payments")  
public class PaymentController {
    PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    
    // Obtener un pago por ID (GET)
    @GetMapping("/{id}") // http:localhost:8080/api/v1/payments/{id}
    ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        return ResponseEntity.ok(payment);
    }
    
    
    // Crear un nuevo pago (POST)
    @PostMapping // http:localhost:8080/api/v1/payments
    ResponseEntity<Payment> createPayment(@RequestBody Payment newPayment) {
        Payment createdPayment = paymentService.createPayment(newPayment);
        return ResponseEntity.status(201).body(createdPayment);
    }

   

    // Obtener todos los pagos (GET)
    @GetMapping // http:localhost:8080/api/v1/payments
    ResponseEntity<Set<Payment>> getAllPayments() {
        Set<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    // Actualizar un pago por ID (PUT)
    @PutMapping("/{id}") // http:localhost:8080/api/v1/payments/{id}
    ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
        Payment payment = paymentService.updatePayment(updatedPayment, id);
        return ResponseEntity.ok(payment);
    }

    // Eliminar un pago por ID (DELETE)
    @DeleteMapping("/{id}") // http:localhost:8080/api/v1/payments/{id}
    ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}
