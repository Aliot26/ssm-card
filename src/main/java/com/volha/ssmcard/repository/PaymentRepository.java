package com.volha.ssmcard.repository;

import com.volha.ssmcard.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
