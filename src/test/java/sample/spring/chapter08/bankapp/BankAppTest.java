package sample.spring.chapter08.bankapp;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sample.spring.chapter08.bankapp.domain.BankAccountDetails;
import sample.spring.chapter08.bankapp.service.BankAccountService;

import java.util.Date;

public class BankAppTest {

    private static Logger logger = Logger.getLogger(BankAppTest.class);

    @Test
    public void testCreateBankAccount(){
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/applicationContext.xml");

        BankAccountService bankAccountService = context.getBean(BankAccountService.class);
        BankAccountDetails bankAccountDetails = new BankAccountDetails();
        bankAccountDetails.setBalanceAmount(1100);
        bankAccountDetails.setLastTransactionTimestamp(new Date());

        int bankAccountId = bankAccountService.createBankAccount(bankAccountDetails);

        logger.info("Created bank account with id - " + bankAccountId);
    }
}
