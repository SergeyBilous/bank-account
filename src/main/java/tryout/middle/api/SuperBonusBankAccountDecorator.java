package tryout.middle.api;

import java.math.BigDecimal;
import tryout.middle.domain.BankAccount;
import tryout.middle.domain.CreditBankAccount;
import tryout.middle.domain.DebitBankAccount;
import tryout.middle.domain.Visitor;

public class SuperBonusBankAccountDecorator extends BankAccountDecorator {
    
    public SuperBonusBankAccountDecorator(BankAccount acc) {
        super(acc);
        
    }
    
    @Override
    public void debit(BigDecimal sum) {
        if (account instanceof DebitBankAccount) {
            BigDecimal bonusSum = sum.multiply(new BigDecimal("2"));
            ((DebitBankAccount) account).debit(bonusSum);
            
        } else {
            ((CreditBankAccount) account).debit(sum);
        }
    }
    
    @Override
    public void credit(BigDecimal sum) {
        if (account instanceof CreditBankAccount) {
            BigDecimal bonusSum = sum.multiply(new BigDecimal("2"));
            ((CreditBankAccount) account).debit(sum);
            
        }else{((DebitBankAccount)account).credit(sum);}
    }

    @Override
    public void accept(Visitor v) {
        return;
    }

   
}
