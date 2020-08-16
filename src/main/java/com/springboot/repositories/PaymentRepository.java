package com.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}