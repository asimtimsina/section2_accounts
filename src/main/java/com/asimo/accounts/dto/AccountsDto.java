package com.asimo.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountsDto {

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account Number must be 10 digits")
    @NotEmpty(message = "Account Number cannot be null or Empty")
    @Schema(description = "Account Number of Eazy Bank account", example = "3454433243")
    private Long accountNumber;

    @NotEmpty(message = "Account Type cannot be null or Empty")
    @Schema(description = "Account type of Eazy Bank account", example = "Savings")
    private String accountType;

    @NotEmpty(message = "Branch Address cannot be null or Empty")
    @Schema(description = "Eazy Bank branch address", example = "123 NewYork")
    private String branchAddress;


}
