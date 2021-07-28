package com.axlboy.coffemilk;

import com.axlboy.coffemilk.model.entity.Category;
import com.axlboy.coffemilk.model.entity.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Autowired
    private CategoryRepo repo;

    @Bean
    public CommandLineRunner getCommandLineRunner(){
        return args -> {
            repo.save(new Category("Pasteles"));
            repo.save(new Category("Cupcakes"));
            repo.save(new Category("Bebestibles"));
        };
    }
}
