package kz.singularity.bankapp.features.accounts.domain.errors;

public class WrongOperationNumber extends Exception{
    public WrongOperationNumber(String errorMessage) {
        super(errorMessage);
        System.out.println("Try to use these commands:\n"+
                "1 - show accounts\n" +
                "2 - create account\n" +
                "3 - deposit\n" +
                "4 - withdraw\n" +
                "5 - transfer\n" +
                "6 - this message\n" +
                "7 - exit\n");
    }
}
