package com.axlboy.coffemilk.repos;

import com.axlboy.coffemilk.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRep extends JpaRepository <Cliente, String> {

}
