package willjt.banking.transactions;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import willjt.banking.entities.BankAccount;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class WithdrawalFromABankAccountTest {

    @Mock private BankAccount mockAccount;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldDeductedTheCorrectAmountFromTheAccountBalanceWhenAWithdrawalIsExecuted() throws Exception {
        WithdrawalFromABankAccount withdrawal = new WithdrawalFromABankAccount(mockAccount, 3);

        withdrawal.execute();

        verify(mockAccount, times(1)).deductFromBalance(3);
    }
}