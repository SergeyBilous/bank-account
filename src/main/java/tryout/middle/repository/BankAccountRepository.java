package tryout.middle.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tryout.middle.domain.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    @Query(value = "select b from BankAccount b", nativeQuery = false)
    public List<BankAccount> getAllAccounts();

}
