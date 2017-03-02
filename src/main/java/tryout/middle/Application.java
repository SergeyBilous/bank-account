package tryout.middle;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tryout.middle.domain.BankAccount;
import tryout.middle.domain.CreditBankAccount;
import tryout.middle.repository.BankAccountRepository;
import tryout.middle.repository.BankAccountService;

@SpringBootApplication
@EnableJpaRepositories("tryout.middle.repository")
@EntityScan("tryout.middle.domain")
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        System.out.println("Started!");
        BankAccountRepository ba = ctx.getBean(BankAccountRepository.class);
        List<BankAccount> ls = ba.findAll();
        if (ls.isEmpty()) {
            System.out.println("No accounts");
        } else {
            System.out.println(ls.size() + " accounts");
            for (int i = 0; i < ls.size(); i++) {
                System.out.print(i);
                if (ls.get(i) instanceof CreditBankAccount) {
                    
                    System.out.println(" Кредит");
                }else{
                    
                    System.out.println(" Дебет");
                }
            }
        }
        SpringApplication.exit(ctx);
    }

}
