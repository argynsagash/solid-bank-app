package kz.singularity.bankapp;

import kz.singularity.bankapp.features.accounts.domain.errors.WrongAccountType;
import kz.singularity.bankapp.features.accounts.domain.models.AccountType;

import java.util.Scanner;


public class MyCLI implements CLIUI {
    private Scanner scanner;

    public MyCLI(Scanner scanner) {
        this.scanner = scanner;
    }

    public double requestClientAmount() {
        return 0.0;
    }

    public String requestClientAccountNumber() {
        return "1";
    }

    public AccountType requestAccountType() {
        System.out.println("Choose account type\n" +
                "[CHECKING, SAVING, FIXED]");
        String accountType = scanner.nextLine();
        if (accountType.equals("CHECKING")) {
            return AccountType.CHECKING;
        } else if (accountType.equals("SAVING")) {
            return AccountType.SAVING;
        } else if (accountType.equals("FIXED")) {
            return AccountType.FIXED;
        } else try {
            throw new WrongAccountType("Wrong Account Type");
        } catch (WrongAccountType e) {
            e.printStackTrace();
            return null;
        }
    }
}
