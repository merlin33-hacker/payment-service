package com.example.demo.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.PaymentResponse;
import com.example.demo.entity.Paymentrequest;
import com.example.demo.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/pay")
    public ResponseEntity<PaymentResponse> pay(@RequestBody Paymentrequest request) {
        return ResponseEntity.ok(paymentService.paymentProcess(request));
    }
}

