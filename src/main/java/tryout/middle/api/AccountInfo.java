/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tryout.middle.api;

import tryout.middle.domain.CreditBankAccount;
import tryout.middle.domain.DebitBankAccount;
import tryout.middle.domain.Visitor;

/**
 *
 * @author serge
 */
public class AccountInfo implements Visitor {

    @Override
    public void visit(DebitBankAccount ac) {
        System.out.println("Debit acc info " + ac.getAmount().toString());
    }

    @Override
    public void visit(CreditBankAccount ac) {
        System.out.println("Credit acc info " + ac.getMinAmount().toString());
    }

}
