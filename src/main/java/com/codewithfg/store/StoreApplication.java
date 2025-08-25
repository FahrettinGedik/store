package com.codewithfg.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var orderService = context.getBean(OrderService.class);
//        var orderService = new OrderService(new StripePaymentService());
//        var orderService = new OrderService();
//        orderService.setPaymentService(new PayPalPaymentService());
        orderService.placeOrder();
        orderService.setPaymentService(new StripePaymentService());
	}

}
// open close principle: software entities should be open for extension but closed for modification
// a class should be open for extension but closed for modification
// it's a tool, not a rule