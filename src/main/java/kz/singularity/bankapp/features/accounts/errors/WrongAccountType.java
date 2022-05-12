package kz.singularity.bankapp.features.accounts.errors;

public class WrongAccountType extends Exception {
    public WrongAccountType(String errorMessage) {
        super(errorMessage);
        System.out.println("Couldn't create account, try again. Choose right account type:\n" +
                "CHECKING\n" +
                "SAVING\n" +
                "FIXED\n");
    }
}