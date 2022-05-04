package kz.singularity.bankapp;

import kz.singularity.bankapp.features.accounts.domain.models.AccountType;

public interface CreateAccountOperationUI {
    AccountType requestAccountType();
}
