package tryout.middle.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.hibernate.annotations.DiscriminatorFormula;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "CreditBankAccount")
@DiscriminatorValue("N")
public class CreditBankAccount extends BankAccount {

    private BigDecimal minAmount;

    public void setMinAmount(BigDecimal v) {
        minAmount = v;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public CreditBankAccount() throws Throwable {
        setIsDebt(null);
    }

    @Override
    public void debit(BigDecimal sum) {
        if (isValidSum(sum)) {
            operate(sum);
        }
    }

    @Override
    public void credit(BigDecimal sum) {
        if (isValidSum(sum) && isValidAmmount(sum)) {
            operate(sum.negate());
        }
    }

    @Override
    public boolean isValidAmmount(BigDecimal sum) {
        return getAmount().add(sum).compareTo(minAmount) != -1;
    }

    @Override
    public final void setIsDebt(String val) throws Throwable {
        super.setIsDebt("N");
    }

}
