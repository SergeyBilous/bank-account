package tryout.middle.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public abstract class BankAccount implements IBankAccount{

    private Long id;
    private String num;
    private BigDecimal amount;
    private LocalDate open;
    private LocalDate close;
    private LocalDate end;

    protected final void operate(BigDecimal sum){
        amount = amount.add(sum);
    }

    public abstract boolean isValidAmmount(BigDecimal sum);

    public static boolean isValidSum(BigDecimal sum){
        return sum.signum()==-1;
    }
}
