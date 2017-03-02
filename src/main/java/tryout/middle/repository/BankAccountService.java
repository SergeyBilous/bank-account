/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tryout.middle.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tryout.middle.domain.BankAccount;

/**
 *
 * @author serge
 */
@Service
@Repository
public class BankAccountService {

    @Autowired
    private BankAccountRepository ba;

    @Transactional(readOnly = true)
    public List<BankAccount> getAll() {
        return ba.findAll();
    }
}
