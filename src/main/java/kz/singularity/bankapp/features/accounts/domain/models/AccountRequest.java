package kz.singularity.bankapp.features.accounts.domain.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountRequest {
    private AccountType accountType;
}
