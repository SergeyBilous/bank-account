package tryout.middle;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tryout.middle.api.AccountInfo;
import tryout.middle.api.BonusBankAccountDecorator;
import tryout.middle.api.Capitalise;
import tryout.middle.api.SuperBonusBankAccountDecorator;
import tryout.middle.domain.BankAccount;
import tryout.middle.domain.CreditBankAccount;
import tryout.middle.domain.DebitBankAccount;
import tryout.middle.factories.AccountsFactory;
import tryout.middle.factories.CreditBankAccountFactory;
import tryout.middle.factories.DebitBankAccountFactory;
import tryout.middle.repository.BankAccountRepository;
import tryout.middle.repository.BankAccountService;

@SpringBootApplication
@EnableJpaRepositories("tryout.middle.repository")
@EntityScan("tryout.middle.domain")
public class Application {

    public static ConfigurableApplicationContext ctx;

    public static void main(String[] args) throws Throwable {
        ctx = SpringApplication.run(Application.class, args);
        System.out.println("Started!");
        // проверяем info
        AccountsFactory af = new AccountsFactory();
        BankAccount da = af.createAccount(new DebitBankAccountFactory());
        BankAccount ca = af.createAccount(new CreditBankAccountFactory());
        ((CreditBankAccount) ca).setMinAmount(new BigDecimal("-10000"));
        ca.setNum("C1000");
        da.setNum("D5000");
        ca.setOpen(new Date());
        da.setOpen(new Date());
        ((CreditBankAccount) ca).setMinAmount(new BigDecimal("-1000"));
        ((DebitBankAccount) da).setAmount(new BigDecimal("-2000"));

        BankAccountRepository br = ctx.getBean(BankAccountRepository.class);
        br.deleteAll();
        br.saveAndFlush(da);
        br.saveAndFlush(ca);
        DebitBankAccount da_clone = (DebitBankAccount) da.clone();
        CreditBankAccount ca_clone = (CreditBankAccount) ca.clone();
        da_clone.setNum(da.getNum() + "-clone");
        ca_clone.setNum(ca.getNum() + "-clone");
        br.saveAndFlush(da_clone);
        br.saveAndFlush(ca_clone);
        List<BankAccount> ls = br.findAll();
        if (ls.isEmpty()) {
            System.out.println("No accounts");
        } else {
            System.out.println(ls.size() + " accounts");
            for (BankAccount cur : ls) {

                BankAccount ac_capitalised = cur.clone();
                ac_capitalised.setNum(cur.getNum() + "-cap");
                new Capitalise().capitalise(ac_capitalised);
                br.saveAndFlush(ac_capitalised);
                BankAccount ac_bonus = cur.clone();
                ac_bonus.setNum(cur.getNum() + "-bonus");
                BonusBankAccountDecorator bonus = new BonusBankAccountDecorator(cur);
                bonus.debit(new BigDecimal("-100"));
                bonus.credit(new BigDecimal("-50"));
                br.saveAndFlush(ac_bonus);

                BankAccount acSuper = cur.clone();
                acSuper.setNum(cur.getNum() + "-superB");
                SuperBonusBankAccountDecorator superBonus = new SuperBonusBankAccountDecorator(cur);
                superBonus.debit(new BigDecimal("-60"));
                superBonus.credit(new BigDecimal("-40"));
                br.saveAndFlush(acSuper);

            }
            System.out.println("Test result");
            ls = br.findAll();
            for (BankAccount cur : ls) {
                System.out.print(cur.getNum() + "\t\t");
                new AccountInfo().info(cur);

            }
        }
        SpringApplication.exit(ctx);
    }

}
