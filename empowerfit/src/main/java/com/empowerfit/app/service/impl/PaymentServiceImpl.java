package com.empowerfit.app.service.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.empowerfit.app.model.Payment;
import com.empowerfit.app.repository.PaymentRepository;
import com.empowerfit.app.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {	
	
	public PaymentRepository paymentRepository;
/* La inyeccion de dependencia por constructor*/
	public PaymentServiceImpl(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	
	@Override
	public Payment createPayment(Payment payment) {
		//verificar si existe una payment
		if (payment.getId() != null && paymentRepository.existsById(payment.getId())) {
		    throw new IllegalStateException("Ya existe un pago con el ID: " + payment.getId());
		}
		//verificar si los atributos son validos
		if (payment.getAmount() == null || payment.getAmount().isEmpty()) {
		    throw new IllegalArgumentException("El monto no puede estar vacío.");
		}

		// Si hay más validaciones específicas
		try {
		    Double.parseDouble(payment.getAmount());
		} catch (NumberFormatException e) {
		    throw new IllegalArgumentException("El monto debe ser un número válido.");
		}

		payment.setActive(true);
		payment.setId(null);
		Payment newPayment =paymentRepository.save(payment);
		return newPayment;
	}

	@Override
	public Payment getPaymentById(Long id) {
		Optional<Payment> optionalPayment = paymentRepository.findById(id);
		if (optionalPayment.isEmpty()) {
			throw new IllegalStateException("El ID " + id + " no existe");
		}
		Payment existingPayment =optionalPayment.get();
		return existingPayment;
	}

	
	@Override
	public Set<Payment> getAllPayments(boolean isActive) {
	    if (isActive) {
	        return new HashSet<>(paymentRepository.findAllByActiveTrue());
	    } else {
	        return new HashSet<>(paymentRepository.findAllByActiveFalse());
	    }
	}


	@Override
	public Payment updatePayment(Payment payment, Long id) {
		Payment existingPayment= getPaymentById(id);
		 existingPayment.setAmount(payment.getAmount());
	     return paymentRepository.save(existingPayment);
	}
	@Override
	public void deletePayment(Long id) {
		Payment existingPayment =getPaymentById(id);
		existingPayment.setActive(false);
		paymentRepository.save(existingPayment);
	}


	@Override
	public Set<Payment> getAllPayments() {
		// TODO Auto-generated method stub
		return null;
	}



   
}
