package com.axlboy.coffemilk.model.repo;

import com.axlboy.coffemilk.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
