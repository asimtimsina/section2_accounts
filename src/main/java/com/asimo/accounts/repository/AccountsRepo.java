package com.asimo.accounts.repository;

import com.asimo.accounts.entity.Accounts;
import com.asimo.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepo extends JpaRepository<Accounts, Long> {
    
}
