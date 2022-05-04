package kz.singularity.bankapp.features.accounts.presentation;

import kz.singularity.bankapp.*;
import kz.singularity.bankapp.features.accounts.domain.errors.WrongOperationNumber;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Application {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("props.xml");
        System.out.println("Welcome to CLI bank service. Enter operation number\n" +
                "1 - show accounts\n" +
                "2 - create account\n" +
                "3 - deposit\n" +
                "4 - withdraw\n" +
                "5 - transfer\n" +
                "6 - this message\n" +
                "7 - exit\n");




        //MemoryAccountDAO memoryAccountDAO = new MemoryAccountDAO();
        MemoryAccountDAO memoryAccountDAO = context.getBean("memoryAccountDAO", MemoryAccountDAO.class);
        //AccountCreationServiceImpl accountCreationServiceImpl = new AccountCreationServiceImpl(memoryAccountDAO);
        AccountCreationServiceImpl accountCreationServiceImpl = context.getBean("accountCreationServiceImpl", AccountCreationServiceImpl.class);
        //AccountListingServiceImpl accountListingService = new AccountListingServiceImpl();
        AccountListingServiceImpl accountListingService = context.getBean("accountListingService",AccountListingServiceImpl.class);
        //BankCore bankCore = new BankCore(accountCreationServiceImpl);
        BankCore bankCore = context.getBean("bankCore", BankCore.class);

        Scanner scanner = new Scanner(System.in);

        MyCLI myCLI = new MyCLI(scanner);
        //AccountBasicCLI accountBasicCLI = new AccountBasicCLI(myCLI, bankCore, accountListingService);


        while (true) {
            String line = scanner.nextLine();
            if (line.equals("1")) {
                System.out.println(memoryAccountDAO.getClientAccounts(myCLI.requestClientAccountNumber()));
            } else if (line.equals("2")) {
                bankCore.createNewAccount(myCLI.requestAccountType(), myCLI.requestClientAccountNumber());
            } else if (line.equals("3")) {

                System.out.println("Application Closed");
                return;
            } else if (line.equals("4")) {
                System.out.println("Application Closed");
                return;
            } else if (line.equals("5")) {
                System.out.println("Application Closed");
                return;
            } else if (line.equals("6")) {
                System.out.println("Application Closed");
                return;
            } else if (line.equals("7")) {
                System.out.println("Application Closed");
                return;
            } else try {
                throw new WrongOperationNumber("Wrong Operation Number");
            } catch (WrongOperationNumber e) {
                e.printStackTrace();
            }
        }
    }
}