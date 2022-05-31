package kz.singularity.bankapp.features.accounts.domain.errors;

public class WrongAccountType extends RuntimeException {
    public WrongAccountType(String errorMessage) {
        super(errorMessage);
        System.out.println("Couldn't create account, try again. Choose right account type:\n" +
                "CHECKING\n" +
                "SAVING\n" +
                "FIXED\n");
    }
}