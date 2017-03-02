/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tryout.middle.domain;

/**
 *
 * @author serge
 */
public interface Visitor {
    void visit(DebitBankAccount ac);
    void visit(CreditBankAccount ac);
    void info(DebitBankAccount ac);
    void info(CreditBankAccount ac);
}
