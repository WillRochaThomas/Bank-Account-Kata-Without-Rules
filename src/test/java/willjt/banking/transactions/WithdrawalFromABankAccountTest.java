package willjt.banking.transactions;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import willjt.banking.entities.BankAccount;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class WithdrawalFromABankAccountTest {

    private WithdrawalFromABankAccount withdrawal;
    private static final int AMOUNT_TO_WITHDRAW = 3;
    private static final int NEGATIVE_AMOUNT = -7;
    private static final int ZERO_AMOUNT = 0;
    @Mock private BankAccount account;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldDeductedTheCorrectAmountFromTheAccountBalanceWhenAWithdrawalIsExecuted() throws Exception {
        givenAWithdrawalFromABankAccountOfTheAmount(AMOUNT_TO_WITHDRAW);
        whenTheWithdrawalIsExecuted();
        thenTheAmountDeductedFromTheAccountBalanceIs(AMOUNT_TO_WITHDRAW);
    }

    private void givenAWithdrawalFromABankAccountOfTheAmount(int amountToWithdraw) {
        withdrawal = new WithdrawalFromABankAccount(account, amountToWithdraw);
    }

    private void whenTheWithdrawalIsExecuted() {
        withdrawal.execute();
    }

    private void thenTheAmountDeductedFromTheAccountBalanceIs(int amountThatShouldBeDeducted) {
        verify(account, times(1)).deductFromBalance(amountThatShouldBeDeducted);
    }
}