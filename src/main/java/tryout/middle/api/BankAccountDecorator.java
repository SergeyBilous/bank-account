package tryout.middle.api;

import java.math.BigDecimal;
import tryout.middle.domain.BankAccount;
import tryout.middle.domain.CreditBankAccount;
import tryout.middle.domain.DebitBankAccount;

public abstract class BankAccountDecorator extends BankAccount{
    protected final BankAccount account;
    public BankAccountDecorator(BankAccount acc){account=acc;}
    @Override
    public boolean isValidAmmount(BigDecimal sum) {
        boolean ret = false;
        if (account instanceof DebitBankAccount) {
            ret = ((DebitBankAccount) account).isValidAmmount(sum);
        }
        if (account instanceof CreditBankAccount) {
            ret = ((CreditBankAccount) account).isValidAmmount(sum);
        }
        return ret;
    }
}
