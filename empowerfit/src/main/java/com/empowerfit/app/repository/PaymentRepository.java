package com.empowerfit.app.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.empowerfit.app.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {


    List<Payment> findByAmount(String amount);

   
    Payment findById(long id);

    Set<Payment> findAllByAmount(String amount);
    Set<Payment> findAllByActiveTrue();
    Set<Payment> findAllByActiveFalse(); 
}
