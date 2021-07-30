package com.axlboy.coffemilk;

import com.axlboy.coffemilk.model.entity.Account;
import com.axlboy.coffemilk.model.entity.Category;
import com.axlboy.coffemilk.model.entity.Product;
import com.axlboy.coffemilk.model.repo.AccountRepo;
import com.axlboy.coffemilk.model.repo.CategoryRepo;
import com.axlboy.coffemilk.model.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private ProductRepo productRepo;

    @Bean
    public CommandLineRunner getCommandLineRunner(){
        return args -> {
            categoryRepo.save(new Category("Pasteles"));
            categoryRepo.save(new Category("Cupcakes"));
            categoryRepo.save(new Category("Bebestibles"));

            productRepo.save(new Product(categoryRepo.getById(1),"Pastel de Maracuyá",8000,"Pastel de Maracuyá relleno con crema"));

            Account admin = new Account("admin","Axel",Account.Role.Admin,"1234");
            accountRepo.save(admin);
        };
    }
}
