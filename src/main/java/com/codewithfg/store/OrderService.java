package com.codewithfg.store;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class OrderService {

    private PaymentService paymentService;

    public OrderService() {
        System.out.println("OrderService created");
    }

    public OrderService(PaymentService paymentService, String name) {
        System.out.println("OrderService created");
        System.out.println(paymentService + name);
    }

    @Autowired //if we have a constructor with arguments, we need to use @Autowired
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("OrderService constructor created");
    }

    @PostConstruct
    public void init() {}

    public void placeOrder() {
//        var paymentService = new StripePaymentService();
        paymentService.processPayment(10);
    }

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
