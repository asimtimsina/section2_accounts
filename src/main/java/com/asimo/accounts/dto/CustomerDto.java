package com.asimo.accounts.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data @AllArgsConstructor @NoArgsConstructor
public class CustomerDto {

    @NotEmpty(message = "Name cannot be null or Empty")
    @Size(min = 4, max = 30, message = "The length of customer name should be between 5 and 30.")
    private String name;

    @NotEmpty(message = "Email cannot be null or Empty")
    @Email
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    private AccountsDto accountsDto;


}
