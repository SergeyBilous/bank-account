/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tryout.middle.api;

import tryout.middle.domain.BankAccount;
import tryout.middle.domain.CreditBankAccount;
import tryout.middle.domain.DebitBankAccount;

/**
 *
 * @author serge
 */
public class AccountInfo {

    public void info(DebitBankAccount acc) {
        System.out.println("Debit acc info " + acc.getAmount().toString());
    }

    public void info(CreditBankAccount acc) {
        System.out.println("Credit acc info " + acc.getMinAmount().toString());
    }

    public void info(BankAccount acc) {
        if (acc instanceof DebitBankAccount) {
            info((DebitBankAccount) acc);
            return;
        }
        if (acc instanceof CreditBankAccount) {
            info((CreditBankAccount) acc);
            return;
        }
        System.out.println("Acc num " + acc.getNum());
    }
}
