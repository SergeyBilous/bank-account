package tryout.middle.api;

import java.math.BigDecimal;
import tryout.middle.domain.BankAccount;
import tryout.middle.domain.CreditBankAccount;
import tryout.middle.domain.DebitBankAccount;
import tryout.middle.domain.Visitor;

public class BonusBankAccountDecorator extends BankAccountDecorator {

    public BonusBankAccountDecorator(BankAccount acc) {
        super(acc);

    }

    @Override
    public void debit(BigDecimal sum) {
        if (account instanceof DebitBankAccount) {

            ((DebitBankAccount) account).debit(sum);
            if (account.getBonus() == null) {
                account.setBonus(BigDecimal.ZERO);
            }
            account.setBonus(account.getBonus().add(new BigDecimal("100")));
        } else {
            ((CreditBankAccount) account).debit(sum);
        }
    }

    

    @Override
    public void credit(BigDecimal sum) {
        if (account instanceof CreditBankAccount) {

            ((CreditBankAccount) account).debit(sum);
            if (account.getBonus() == null) {
                account.setBonus(BigDecimal.ZERO);
            }
            account.setBonus(account.getBonus().add(new BigDecimal("100")));
        } else {
            ((DebitBankAccount) account).debit(sum);
        }
    }

    @Override
    public void accept(Visitor v) {
        return;
    }

    @Override
    public void info(Visitor v) {
        
    }

}
