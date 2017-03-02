package tryout.middle.domain;

import java.math.BigDecimal;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "DebitBankAccount")
@DiscriminatorValue("Y")

public class DebitBankAccount extends BankAccount {

    public DebitBankAccount() throws Throwable {
        setIsDebt(null);
    }

    @Override
    public void debit(BigDecimal sum) {
        if (isValidSum(sum) && isValidAmmount(sum)) {
            operate(sum);
        }
    }
    
    @Override
    public void credit(BigDecimal sum) {
        if (isValidSum(sum)) {
            operate(sum.negate());
        }
    }
    
    @Override
    public boolean isValidAmmount(BigDecimal sum) {
        return getAmount().compareTo(sum) == -1;
    }

    @Override
    public final void setIsDebt(String val) throws Throwable {
        super.setIsDebt("Y");
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

   
}
