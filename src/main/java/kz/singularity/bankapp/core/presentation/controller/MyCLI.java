package kz.singularity.bankapp.core.presentation.controller;

import kz.singularity.bankapp.features.accounts.domain.errors.WrongAccountType;
import kz.singularity.bankapp.features.accounts.domain.models.AccountType;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MyCLI implements CLIUI {
    private Scanner scanner;

    public MyCLI() {
        this.scanner = new Scanner(System.in);


    }

    public MyCLI(Scanner scanner) {
        this.scanner = scanner;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public double requestClientAmount() {
        System.out.println("Type Amount of money");
        return Double.parseDouble(scanner.nextLine());
    }

    public String requestClientAccountNumber() {
        System.out.println("Type account ID");
        return scanner.nextLine();
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
