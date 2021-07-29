package com.axlboy.coffemilk.model.service;

import com.axlboy.coffemilk.model.entity.Category;
import com.axlboy.coffemilk.model.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepo repo;

    public List<Category> findAll(){
        return repo.findAll();
    }
}
