package tryout.middle.api;

import java.math.BigDecimal;
import tryout.middle.domain.CreditBankAccount;
import tryout.middle.domain.DebitBankAccount;

public class Capitalise {

    public void capitalise(DebitBankAccount ac) {
        ac.debit(new BigDecimal("-10"));
    }
    public void capitalise(CreditBankAccount ac) {
        ac.debit(new BigDecimal("-10"));
    }
}
