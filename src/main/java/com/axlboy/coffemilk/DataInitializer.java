package com.axlboy.coffemilk;

import com.axlboy.coffemilk.model.entity.Account;
import com.axlboy.coffemilk.model.entity.Category;
import com.axlboy.coffemilk.model.repo.AccountRepo;
import com.axlboy.coffemilk.model.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Autowired
    private CategoryRepo repo;
    @Autowired
    private AccountRepo accountRepo;

    @Bean
    public CommandLineRunner getCommandLineRunner(){
        return args -> {
            repo.save(new Category("Pasteles"));
            repo.save(new Category("Cupcakes"));
            repo.save(new Category("Bebestibles"));

            Account admin = new Account("admin","Axel",Account.Role.Admin,"1234");
            accountRepo.save(admin);
        };
    }
}
