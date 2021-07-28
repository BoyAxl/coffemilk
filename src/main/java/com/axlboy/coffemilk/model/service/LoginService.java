package com.axlboy.coffemilk.model.service;

import com.axlboy.coffemilk.model.PostException;
import com.axlboy.coffemilk.model.entity.Account;
import com.axlboy.coffemilk.model.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class LoginService {

    @Autowired
    private AccountRepo repo;

    public Account login(String userId, String password){

        if (ObjectUtils.isEmpty(userId)){
            throw new PostException("Por favor ingrese su nombre de usuario.");
        }

        if (ObjectUtils.isEmpty(password)){
            throw new PostException("Por favor ingrese su contraseña.");
        }

        Account account = repo.findById(userId).orElseThrow(() -> new PostException("Usuario no existe."));

        if(!password.equals(account.getPassword())){
            throw new PostException("Por favor revise su contraseña.");
        }
        return account;
    }
}
