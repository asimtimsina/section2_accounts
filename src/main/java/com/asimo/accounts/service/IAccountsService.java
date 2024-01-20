package com.asimo.accounts.service;

import com.asimo.accounts.dto.CustomerDto;
import com.asimo.accounts.entity.Accounts;
import com.asimo.accounts.entity.Customer;

public interface IAccountsService {

    /**
     *
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param customer - Customer Object
     * @return the new account details
     */
    Accounts createNewAccount(Customer customer);


    /**
     *
     * @param mobileNum - Mobile Number
     * @return Customer Details related with the mobile Number
     */
    CustomerDto fetchAccount(String mobileNum);


    /**
     *
     * @param customerDto - CustomerDto Object
     * @return returns if update is sucessfull
     */
    boolean updateAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNum - Mobile Number
     * @return returns if account deletion is successful or not
     */
    boolean deleteAccount(String mobileNum);
}
