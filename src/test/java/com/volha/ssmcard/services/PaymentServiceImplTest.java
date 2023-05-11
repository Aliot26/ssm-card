package com.volha.ssmcard.services;

import com.volha.ssmcard.domain.Payment;
import com.volha.ssmcard.domain.PaymentEvent;
import com.volha.ssmcard.domain.PaymentState;
import com.volha.ssmcard.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PaymentServiceImplTest {

    @Autowired
    PaymentService paymentService;
    @Autowired
    PaymentRepository paymentRepository;
    Payment payment;

    @BeforeEach
    void setUp(){
        payment = Payment.builder().amount(new BigDecimal("12.99")).build();
    }

    @Transactional
    @Test
    void preAuth() {
        Payment savedPayment = paymentService.newPayment(payment);
        System.out.println(savedPayment.getState());
        StateMachine<PaymentState, PaymentEvent> sm = paymentService.preAuth(savedPayment.getId());

        Payment preAuthedPayment = paymentRepository.getReferenceById(savedPayment.getId());

        System.out.println("+++++++++++++++"  + preAuthedPayment);
        System.out.println(sm.getState().getId());
    }
}