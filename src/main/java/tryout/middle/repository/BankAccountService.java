/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tryout.middle.repository;

import org.springframework.context.ConfigurableApplicationContext;
import tryout.middle.domain.BankAccount;

/**
 *
 * @author serge
 */
public class BankAccountService {

    private BankAccountRepository br;

    public BankAccountService() {
    }

    public BankAccountService(ConfigurableApplicationContext context) {
        br = context.getBean(BankAccountRepository.class);
    }
;
}
