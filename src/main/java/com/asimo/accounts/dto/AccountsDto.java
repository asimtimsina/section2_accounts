package com.asimo.accounts.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class AccountsDto {

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account Number must be 10 digits")
    @NotEmpty(message = "Account Number cannot be null or Empty")
    private Long accountNumber;

    @NotEmpty(message = "Account Type cannot be null or Empty")
    private String accountType;

    @NotEmpty(message = "Branch Address cannot be null or Empty")
    private String branchAddress;


}
