package kz.singularity.bankapp.features.accounts;

import kz.singularity.bankapp.features.accounts.domain.AccountBasicCLI;
import kz.singularity.bankapp.features.accounts.domain.MyCLI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class);
    }

    @Override
    public void run(String... arg0) throws Exception {
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
        System.out.printf("Welcome to CLI bank service\n");
        System.out.printf("Enter operation number: \n");
        System.out.printf(helpMessage);

        while(running){
            switch(myCLI.getScanner().nextLine()){

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
                    System.out.printf(helpMessage);
                    break;

                case "7":
                    System.out.printf("Application Closed\n");
                    running = false;
                    break;

                default:
                    System.out.printf("Command not recognized!\n");
                    break;
            }
        }
        myCLI.getScanner().close();
    }
}