package com.asimo.accounts.controller;

import com.asimo.accounts.constants.AccountConstants;
import com.asimo.accounts.dto.CustomerDto;
import com.asimo.accounts.dto.ResponseDto;
import com.asimo.accounts.entity.Customer;
import com.asimo.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountsController {

    private IAccountsService accountsService;


    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){

        accountsService.createAccount(customerDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccount(@RequestParam String mobileNum){
        CustomerDto customerDto = accountsService.fetchAccount(mobileNum);
        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

}
