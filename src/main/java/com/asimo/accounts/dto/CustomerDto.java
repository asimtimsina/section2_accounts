package com.asimo.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data @AllArgsConstructor @NoArgsConstructor
@Schema(name = "Customer",description = "Schema to hold Customer information")
public class CustomerDto {

    @NotEmpty(message = "Name cannot be null or Empty")
    @Size(min = 4, max = 30, message = "The length of customer name should be between 5 and 30.")
    @Schema(description = "Customer Name", example = "Asimo")
    private String name;

    @NotEmpty(message = "Email cannot be null or Empty")
    @Email
    @Schema(description = "Customer Email", example = "asimo@gmail.com")
    private String email;

    @Schema(description = "Customer Mobile Number", example = "1234567890")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(description = "Account Info")
    private AccountsDto accountsDto;


}
