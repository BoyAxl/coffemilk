package com.axlboy.coffemilk.model.repo;

import com.axlboy.coffemilk.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository <Product, Integer> {
}
