/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tryout.middle.factories;

import java.util.logging.Level;
import java.util.logging.Logger;
import tryout.middle.domain.BankAccount;
import tryout.middle.domain.CreditBankAccount;

/**
 *
 * @author serge
 */
public class CreditBankAccountFactory extends AbstractBankAccountFactory{

    @Override
    public BankAccount createAccount() {
        try {
            return new CreditBankAccount();
        } catch (Throwable ex) {
            Logger.getLogger(CreditBankAccountFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
