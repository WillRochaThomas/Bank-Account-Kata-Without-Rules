package willjt.banking.entities;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BankAccountTest {

    private BankAccount account = new BankAccount();

    @Test
    public void ensureThatADepositIsAddedToTheBalance() throws Exception {
        account.resetBalanceTo(0);
        account.addToBalance(10);
        account.addToBalance(20);
        assertThat(account.currentBalance(), equalTo(30));
    }

    @Test
    public void ensureThatAWithdrawalIsDeductedFromTheBalance() {
        account.resetBalanceTo(10);
        account.deductFromBalance(2);
        account.deductFromBalance(4);
        assertThat(account.currentBalance(), equalTo(4));
    }
}