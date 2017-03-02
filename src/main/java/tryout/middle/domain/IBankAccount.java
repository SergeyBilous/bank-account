package tryout.middle.domain;

import java.math.BigDecimal;

public interface IBankAccount {
    
    void debit(BigDecimal sum);
    void credit(BigDecimal sum);

}
