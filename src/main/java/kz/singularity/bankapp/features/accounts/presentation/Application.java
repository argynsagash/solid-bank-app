package kz.singularity.bankapp.features.accounts.presentation;

import kz.singularity.bankapp.AccountBasicCLI;
import kz.singularity.bankapp.AccountDAO;
import kz.singularity.bankapp.MemoryAccountDAO;
import kz.singularity.bankapp.MyCLI;
import kz.singularity.bankapp.features.accounts.domain.errors.WrongOperationNumber;
import kz.singularity.bankapp.features.accounts.domain.models.Account;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
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
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("7")) {
                System.out.println("Application Closed");
                return;
            } else if (line.equals("1")) {
                MemoryAccountDAO memoryAccountDAO = new MemoryAccountDAO();
                System.out.println(memoryAccountDAO.getClientAccounts("1"));
            } else if (line.equals("2")) {
                MemoryAccountDAO memoryAccountDAO = new MemoryAccountDAO();
                MyCLI myCLI = new MyCLI(scanner);
                myCLI.requestAccountType();
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
            } else try {
                throw new WrongOperationNumber("Wrong Operation Number");
            } catch (WrongOperationNumber e) {
                e.printStackTrace();
            }
        }
    }
}