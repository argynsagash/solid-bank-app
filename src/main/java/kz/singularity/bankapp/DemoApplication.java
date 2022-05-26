package kz.singularity.bankapp;

import kz.singularity.bankapp.core.presentation.controller.MyCLI;
import kz.singularity.bankapp.features.accounts.data.entities.Account;
import kz.singularity.bankapp.features.accounts.data.repositories.AccountRepository;
import kz.singularity.bankapp.features.accounts.presentation.controller.AccountBasicCLI;
import kz.singularity.bankapp.features.transactions.presentation.controller.TransactionDepositCLI;
import kz.singularity.bankapp.features.transactions.presentation.controller.TransactionWithdrawCLI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication

public class DemoApplication implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    @Autowired
    private AccountRepository accountRepository;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class);
    }

    @Override
    public void run(String... arg0) {

        //System.out.println(accountRepository.findByClientIDAndId());
        for (Account i : accountRepository.findAll()) {
            System.out.println(i.toString());
        }

        boolean running = true;
        String clientID = "1";

        MyCLI myCLI = context.getBean(MyCLI.class);
        AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);
        TransactionDepositCLI transactionDepositCLI = context.getBean(TransactionDepositCLI.class);
        TransactionWithdrawCLI transactionWithdrawCLI = context.getBean(TransactionWithdrawCLI.class);

        String helpMessage =
                "1 - show accounts\n" +
                        "2 - create account\n" +
                        "3 - deposit\n" +
                        "4 - withdraw\n" +
                        "5 - transfer\n" +
                        "6 - this message\n" +
                        "7 - exit\n";
        System.out.print("Welcome to CLI bank service\n");
        System.out.print("Enter operation number: \n");
        System.out.print(helpMessage);

        while (running) {
            switch (myCLI.getScanner().nextLine()) {

                case "1":
                    accountBasicCLI.getAccounts(clientID);
                    break;

                case "2":
                    accountBasicCLI.createAccountRequest(clientID);
                    break;

                case "3":
                    transactionDepositCLI.depositMoney(clientID);
                    break;

                case "4":
                    transactionWithdrawCLI.withdrawMoney(clientID);
                    break;

                case "6":
                    System.out.print(helpMessage);
                    break;

                case "7":
                    System.out.print("Application Closed\n");
                    running = false;
                    break;

                default:
                    System.out.print("Command not recognized!\n");
                    break;
            }
        }
        myCLI.getScanner().close();
    }
}