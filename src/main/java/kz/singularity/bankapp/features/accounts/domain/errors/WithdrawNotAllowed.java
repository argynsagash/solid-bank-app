package kz.singularity.bankapp.features.accounts.domain.errors;

public class WithdrawNotAllowed extends RuntimeException{
    public WithdrawNotAllowed(String id) {
        super(String.format("Could not withdraw from FIXED account %s", id));
    }
}
