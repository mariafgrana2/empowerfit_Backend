package com.empowerfit.app.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.empowerfit.app.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

    // SELECT * FROM payment WHERE amount = ?
    List<Payment> findByAmount(String amount);

    // SELECT * FROM payment WHERE id = ?
    Optional<Payment> findById(Long id);

    // Sobrecarga para obtener todos los pagos con un monto específico
    Set<Payment> findAllByAmount(String amount);
}
