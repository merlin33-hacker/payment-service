package com.example.demo.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.client.OrderClient;
import com.example.demo.entity.PaymentEntity;
import com.example.demo.entity.PaymentResponse;
import com.example.demo.entity.Paymentrequest;
import com.example.demo.repository.PaymentRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentService {
@Autowired
private PaymentRepository paymentRepository;
private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PaymentService.class);
@Autowired
private OrderClient orderclient;
@CircuitBreaker(name = "payment-service", fallbackMethod = "paymentFallback")
@Retry(name = "payment-service")
public PaymentResponse paymentProcess(Paymentrequest request) {
	log.info("payment was started");
	boolean paymentsuccess=true;
	String transactionid=UUID.randomUUID().toString();
	PaymentEntity payment=new PaymentEntity();
	payment.setOrderid(request.getOrderId());
	payment.setAmount(request.getAmount());
	payment.setPaymentMethod(request.getPaymentMethod());
	payment.setTransactionId(transactionid);
	payment.setSuccess(paymentsuccess);
	paymentRepository.save(payment);
	log.info("payment was saved in repository");
	if(paymentsuccess) {
		orderclient.updateOrderStatus(request.getOrderId(),"PAID");
		log.info("paymentstatus was updated in order feign client");
	}
		
		 PaymentResponse response = new PaymentResponse();
	        response.setMessage(paymentsuccess ? "Payment Successful" : "Payment Failed");
	        response.setSuccess(paymentsuccess);
	        response.setTransactionId(transactionid);
	        log.info("payment response was done");
	        return response;
	}
public PaymentResponse paymentFallback(Paymentrequest request, Throwable t) {
  
	log.warn("payment fallback");
    PaymentResponse fallback = new PaymentResponse();
    fallback.setMessage("Payment Service temporarily unavailable. Try again later.");
    fallback.setSuccess(false);
    fallback.setTransactionId("N/A");
    return fallback;
}
}

