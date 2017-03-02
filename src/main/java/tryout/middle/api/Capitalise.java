package tryout.middle.api;

import java.math.BigDecimal;
import tryout.middle.domain.BankAccount;
import tryout.middle.domain.CreditBankAccount;
import tryout.middle.domain.DebitBankAccount;
import tryout.middle.domain.Visitor;

public class Capitalise implements Visitor{

    @Override
    public void visit(DebitBankAccount ac) {
        ac.debit(BigDecimal.valueOf(10d));
    }

    @Override
    public void visit(CreditBankAccount ac) {
        ac.credit(BigDecimal.valueOf(10d));
    }

    @Override
    public void info(DebitBankAccount ac) {
         System.out.println("Debit acc info " + ac.getAmount().toString());
    }

    @Override
    public void info(CreditBankAccount ac) {
        System.out.println("Credit acc info " + ac.getMinAmount().toString());
    }

    
}
