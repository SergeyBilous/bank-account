package tryout.middle.domain;

import java.math.BigDecimal;

public class DebitBankAccount extends BankAccount {

    @Override
    public void debit(BigDecimal sum) {
        if (isValidSum(sum) && isValidAmmount(sum))
            operate(sum);
    }

    @Override
    public void credit(BigDecimal sum) {
        if (isValidSum(sum))
            operate(sum.negate());
    }

    @Override
    public boolean isValidAmmount(BigDecimal sum) {
        return getAmount().compareTo(sum)==-1;
    }
}
