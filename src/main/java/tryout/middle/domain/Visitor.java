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
    abstract void visit(DebitBankAccount ac);
    abstract void visit(CreditBankAccount ac);
    
}
