package com.example.demo.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "order-service")
public interface OrderClient {

    @PutMapping("/order/update-status/{orderId}")
    String updateOrderStatus(@PathVariable("orderId") Long orderId,
                             @RequestParam("status") String status);
}
