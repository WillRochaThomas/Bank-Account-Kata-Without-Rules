package willjt.banking.transactions;

import org.junit.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import willjt.banking.entities.BankAccount;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DepositIntoABankAccountTest {

    private DepositIntoABankAccount deposit;
    private static final int AMOUNT_TO_DEPOSIT = 13;
    private static final int NEGATIVE_AMOUNT = -7;
    private static final int ZERO_AMOUNT = 0;
    @Mock private BankAccount account;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldAddTheCorrectAmountToTheAccountBalanceWhenADepositIsExecuted() throws Exception {
        givenADepositIntoABankAccountOfTheAmount(AMOUNT_TO_DEPOSIT);
        whenTheDepositIsExecuted();
        thenTheAmountAddedToTheAccountBalanceIs(AMOUNT_TO_DEPOSIT);
    }

    private void givenADepositIntoABankAccountOfTheAmount(int amountToWithdraw) {
        deposit = new DepositIntoABankAccount(account, amountToWithdraw);
    }

    private void whenTheDepositIsExecuted() {
        deposit.execute();
    }

    private void thenTheAmountAddedToTheAccountBalanceIs(int amountThatShouldBeAdded) {
        verify(account, times(1)).addToBalance(amountThatShouldBeAdded);
    }
}