package willjt.banking.entities;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BankAccountTest {

    private BankAccount account = new BankAccount();

    @Test
    public void ensureThatADepositIsAddedToTheBalance() throws Exception {
        givenAnAccountWithBalance(0);
        whenADepositIsMadeWithAValueOf(10);
        whenADepositIsMadeWithAValueOf(20);
        thenExpectedBalanceIs(30);
    }

    @Test
    public void ensureThatAWithdrawalIsDeductedFromTheBalance() {
        givenAnAccountWithBalance(10);
        whenAWithdrawalIsMadeWithAValueOf(2);
        whenAWithdrawalIsMadeWithAValueOf(4);
        thenExpectedBalanceIs(4);
    }

    private void givenAnAccountWithBalance(int balance) {
        account.resetBalance(balance);
    }

    private void whenADepositIsMadeWithAValueOf(int amount) {
        account.addToBalance(amount);
    }

    private void whenAWithdrawalIsMadeWithAValueOf(int amount) {
        account.deductFromBalance(amount);
    }

    private void thenExpectedBalanceIs(int expectedBalance) {
        int actualBalance = account.currentBalance();
        assertThat(actualBalance, equalTo(expectedBalance));
    }
}