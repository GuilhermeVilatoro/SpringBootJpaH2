package com.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}