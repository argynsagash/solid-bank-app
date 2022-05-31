package kz.singularity.bankapp.features.accounts.domain.errors;

public class AccountNotFound extends RuntimeException{
    public AccountNotFound(String id) {
        super(String.format("Could not find account %s", id));
    }
}
