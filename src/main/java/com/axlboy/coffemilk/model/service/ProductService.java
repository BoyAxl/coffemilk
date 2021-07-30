package com.axlboy.coffemilk.model.service;

import com.axlboy.coffemilk.model.PostException;
import com.axlboy.coffemilk.model.entity.Category;
import com.axlboy.coffemilk.model.entity.Product;
import com.axlboy.coffemilk.model.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public List<Product> search(Category value, String name) {
        return productRepo.findAll();
    }

    public void save(Product product) {
        if(null == product.getCategory()){
            throw new PostException("Por favor seleccione una categoría.");
        }
        if(ObjectUtils.isEmpty(product.getName())){
            throw new PostException("Por favor ingrese un producto.");
        }
        if(product.getPrice() == 0 ){
            throw new PostException("Por favor ingrese un precio.");
        }

        productRepo.save(product);
    }
}
