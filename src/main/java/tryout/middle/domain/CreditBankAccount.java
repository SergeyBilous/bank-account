package tryout.middle.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreditBankAccount extends BankAccount{

    private BigDecimal minAmount;

    @Override
    public void debit(BigDecimal sum) {
        if (isValidSum(sum))
            operate(sum);
    }

    @Override
    public void credit(BigDecimal sum) {
        if (isValidSum(sum) && isValidAmmount(sum))
            operate(sum.negate());
    }

    @Override
    public boolean isValidAmmount(BigDecimal sum) {
        return getAmount().add(sum).compareTo(minAmount)!=-1;
    }

}
