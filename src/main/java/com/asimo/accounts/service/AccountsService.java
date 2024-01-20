package com.asimo.accounts.service;

import com.asimo.accounts.constants.AccountConstants;
import com.asimo.accounts.dto.AccountsDto;
import com.asimo.accounts.dto.CustomerDto;
import com.asimo.accounts.entity.Accounts;
import com.asimo.accounts.entity.Customer;
import com.asimo.accounts.exception.CustomerAlreadyExistsException;
import com.asimo.accounts.exception.ResourceNotFoundException;
import com.asimo.accounts.mapper.AccountsMapper;
import com.asimo.accounts.mapper.CustomerMapper;
import com.asimo.accounts.repository.AccountsRepo;
import com.asimo.accounts.repository.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsService implements  IAccountsService{

    private AccountsRepo accountsRepo;
    private CustomerRepo customerRepo;


    /**
     *
     * @param customerDto - CustomerDto Object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());

        Optional<Customer> customerExists = customerRepo.findByMobileNumber(customer.getMobileNumber());
        if(customerExists.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already exists with given mobileNumber"
                    + customer.getMobileNumber());
        }

        customer.setCreatedBy("Tester");
        customer.setCreatedAt(LocalDateTime.now());

        customerRepo.save(customer);
        accountsRepo.save(createNewAccount(customer));
    }

    /**
     *
     * @param customer - Customer Object
     * @return the new account details
     */
    @Override
    public Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setCreatedBy("Tester");
        newAccount.setCreatedAt(LocalDateTime.now());


        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        return newAccount;
    }

    /**
     *
     * @param mobileNum - Mobile Number
     * @return Customer Details related with the mobile Number
     */
    @Override
    public CustomerDto fetchAccount(String mobileNum) {
       Customer customer =  customerRepo.findByMobileNumber(mobileNum).orElseThrow(
               ()-> new ResourceNotFoundException("Customer", "mobileNumber", mobileNum)
       );

        Accounts accounts =  accountsRepo.findByCustomerId(customer.getCustomerId()).orElseThrow(
                ()-> new ResourceNotFoundException("Accounts", "mobileNumber", mobileNum)
        );

        //first set all the fields
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        //set AccountsDto inside the customerDto
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        return customerDto;
    }


}
