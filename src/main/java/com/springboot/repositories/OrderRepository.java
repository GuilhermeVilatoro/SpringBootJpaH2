package com.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}