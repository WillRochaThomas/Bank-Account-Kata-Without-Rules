package willjt.banking.transactions;

import org.junit.Test;
import willjt.banking.entities.BankAccount;

import static org.mockito.Mockito.*;

public class DepositIntoABankAccountTest {

    private static final int AMOUNT_TO_DEPOSIT = 13;

    @Test
    public void shouldAddTheCorrectAmountToTheAccountBalanceWhenADepositIsExecuted() throws Exception {
        BankAccount ourBankAccount = mock(BankAccount.class);
        DepositIntoABankAccount deposit = new DepositIntoABankAccount(ourBankAccount, AMOUNT_TO_DEPOSIT);

        deposit.execute();

        verify(ourBankAccount, times(1)).addToBalance(AMOUNT_TO_DEPOSIT);
    }
}