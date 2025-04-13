package com.mystore.orders.service;

import com.mystore.orders.dto.OrderRequest;
import com.mystore.orders.dto.OrderResponse;
import com.mystore.orders.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class OrderService {

    String GET_PROD_URL  = "http://product-service/products/{id}";


    @Autowired
    private DiscoveryClient discoveryClient ;

	 @Autowired
	  private RestTemplate restTemplate;
    public OrderResponse placeOrder(OrderRequest orderRequest) {
		        Product product = restTemplate.getForObject(GET_PROD_URL, Product.class, orderRequest.getProductId());

		        if (product == null) {
		            throw new RuntimeException("Product not found for ID: " + orderRequest.getProductId());
		        }

		        // Step 2: Calculate total price
		        double totalPrice = product.getPrice() * orderRequest.getQty();
		        // Step 3: Create and return order response
		        return new OrderResponse(
		        		ThreadLocalRandom.current().nextLong(100000, 999999), // generate unique order ID
		                product.getId(),
		                orderRequest.getQty(),
		                product.getName(),
		                totalPrice
		        );

    }

}
