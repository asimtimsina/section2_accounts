package com.asimo.accounts.service;

import com.asimo.accounts.dto.AccountsDto;
import com.asimo.accounts.dto.CustomerDto;
import com.asimo.accounts.repository.AccountsRepo;
import com.asimo.accounts.repository.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountsService implements  IAccountsService{

    private AccountsRepo accountsRepo;
    private CustomerRepo customerRepo;


    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
