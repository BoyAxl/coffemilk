package com.axlboy.coffemilk.model.repo;

import com.axlboy.coffemilk.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository <Account, String> {
}
