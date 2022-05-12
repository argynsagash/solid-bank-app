package kz.singularity.bankapp.features.accounts;

import kz.singularity.bankapp.features.accounts.domain.AccountBasicCLI;
import kz.singularity.bankapp.features.accounts.domain.BankCore;
import kz.singularity.bankapp.features.accounts.errors.WrongOperationNumber;
import kz.singularity.bankapp.features.accounts.domain.MyCLI;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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


//        MemoryAccountDAO memoryAccountDAO = new MemoryAccountDAO();
//        AccountCreationServiceImpl accountCreationServiceImpl = new AccountCreationServiceImpl(memoryAccountDAO);
//        BankCore bankCore = new BankCore(accountCreationServiceImpl);
//        MyCLI myCLI = new MyCLI();
        //AccountListingServiceImpl accountListingService = new AccountListingServiceImpl();
        //AccountBasicCLI accountBasicCLI = new AccountBasicCLI(myCLI, bankCore, accountListingService);


       // MemoryAccountDAO memoryAccountDAO = context.getBean("memoryAccountDAO", MemoryAccountDAO.class);
        BankCore bankCore = context.getBean("bankCore", BankCore.class);
        MyCLI myCLI = context.getBean("myCLI",MyCLI.class);
        AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);
//        MemoryAccountDAO memoryAccountDAO = context.getBean(MemoryAccountDAO.class);
//        BankCore bankCore = context.getBean(BankCore.class);
//        MyCLI myCLI = context.getBean(MyCLI.class);
//        AccountCreationServiceImpl accountCreationServiceImpl = context.getBean("accountCreationServiceImpl", AccountCreationServiceImpl.class);
//        AccountListingServiceImpl accountListingService = context.getBean("accountListingService",AccountListingServiceImpl.class);


        while (true) {
            String line = myCLI.getScanner().nextLine();
            if (line.equals("1")) {
                accountBasicCLI.getAccounts("1");
               // System.out.println(memoryAccountDAO.getClientAccounts(myCLI.requestClientAccountNumber()));
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