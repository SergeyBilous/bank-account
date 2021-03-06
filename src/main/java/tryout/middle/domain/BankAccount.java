package tryout.middle.domain;

import java.io.Serializable;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Data
@Entity(name = "BankAccount")
@Table(name = "bankaccount", schema = "public")
@DiscriminatorColumn(name = "is_debt", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("A")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class BankAccount implements IBankAccount, Serializable, Cloneable,Visitable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String num;
    private BigDecimal amount;
    private Date open;
    private Date close;
    private Date enddate;
    private BigDecimal bonus;
    private String isDebt;

    public BankAccount() {
        isDebt = "A";
        amount = BigDecimal.ZERO;
        bonus = BigDecimal.ZERO;
    }

    protected final void operate(BigDecimal sum) {
        amount = amount.add(sum);
    }

    public void setIsDebt(String isDebt) throws Throwable {
        if (isDebt.equals("A") || isDebt.equals("Y") || isDebt.equals("N")) {
            this.isDebt = isDebt;
        } else {
            throw new Throwable("Неизвестный тип счета");
        }
    }

    public abstract boolean isValidAmmount(BigDecimal sum);

    public static boolean isValidSum(BigDecimal sum) {
        return sum.signum() == -1;
    }

    @Override
    public BankAccount clone() throws CloneNotSupportedException {
        BankAccount ret = (BankAccount) super.clone();
        ret.id = null;
        ret.num = "";
        ret.open = new Date();
        return ret;
    }
}
