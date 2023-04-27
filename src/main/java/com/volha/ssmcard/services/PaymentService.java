package com.volha.ssmcard.services;

import com.volha.ssmcard.domain.Payment;
import com.volha.ssmcard.domain.PaymentEvent;
import com.volha.ssmcard.domain.PaymentState;
import org.springframework.statemachine.StateMachine;

public interface PaymentService {

    Payment newPayment(Payment payment);
    StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId);
    StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId);
    StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId);

}
