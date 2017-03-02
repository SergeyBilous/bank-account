/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tryout.middle.factories;

import tryout.middle.domain.BankAccount;

/**
 *
 * @author serge
 */
public class AccountsFactory {

    public BankAccount createAccount(AbstractBankAccountFactory factory) {
        return factory.createAccount();
    }
}
