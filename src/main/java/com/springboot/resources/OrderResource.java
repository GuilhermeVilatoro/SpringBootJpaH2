package com.springboot.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entities.Order;
import com.springboot.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService OrderService;

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> orders = OrderService.findAll();
		return ResponseEntity.ok().body(orders);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Order>> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(OrderService.findById(id));
	}
}
