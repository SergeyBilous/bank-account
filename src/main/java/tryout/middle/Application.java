package tryout.middle;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tryout.middle.api.AccountInfo;
import tryout.middle.domain.BankAccount;
import tryout.middle.domain.CreditBankAccount;
import tryout.middle.domain.DebitBankAccount;
import tryout.middle.factories.AccountsFactory;
import tryout.middle.factories.CreditBankAccountFactory;
import tryout.middle.factories.DebitBankAccountFactory;
import tryout.middle.repository.BankAccountService;

@SpringBootApplication
@EnableJpaRepositories("tryout.middle.repository")
@EntityScan("tryout.middle.domain")
public class Application {

    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) throws Throwable {
        ctx = SpringApplication.run(Application.class, args);
        System.out.println("Started!");
       
        AccountsFactory af = new AccountsFactory();
        BankAccount da = af.createAccount(new DebitBankAccountFactory());
        BankAccount ca = af.createAccount(new CreditBankAccountFactory());
        ((CreditBankAccount) ca).setMinAmount(new BigDecimal("-10000"));
        ca.setNum("C1000");
        da.setNum("D5000");
        BankAccount bac=new BankAccount() {
            @Override
            public boolean isValidAmmount(BigDecimal sum) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void debit(BigDecimal sum) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void credit(BigDecimal sum) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
       bac.setNum("A123450");
        ((CreditBankAccount)ca).setMinAmount(new BigDecimal("-1000"));
        ((DebitBankAccount)da).setAmount(new BigDecimal("-2000"));
        
       new AccountInfo().info((CreditBankAccount)ca);
       new AccountInfo().info((DebitBankAccount)da);
       new AccountInfo().info(bac);
       BankAccountService ba = new BankAccountService(ctx);
        List<BankAccount> ls = ba.getAll();
        if (ls.isEmpty()) {
            System.out.println("No accounts");
        } else {
            System.out.println(ls.size() + " accounts");
            for (int i = 0; i < ls.size(); i++) {
                System.out.print(i);
                if (ls.get(i) instanceof CreditBankAccount) {

                    System.out.println(" Кредит");
                } else {

                    System.out.println(" Дебет");
                }
            }
        }
        SpringApplication.exit(ctx);
    }

    private static class BankAccountImpl extends BankAccount {

        public BankAccountImpl() {
        }

        @Override
        public boolean isValidAmmount(BigDecimal sum) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void debit(BigDecimal sum) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void credit(BigDecimal sum) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
