package kz.singularity.bankapp.features.accounts.domain.errors;

public class WrongAccountType extends Exception {
    public WrongAccountType(String errorMessage) {
        super(errorMessage);
        System.out.println("Choose right account type:\n" +
                "CHECKING\n" +
                "SAVING\n" +
                "FIXED\n");
    }
}