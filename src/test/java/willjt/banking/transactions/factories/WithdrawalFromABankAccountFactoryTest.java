package willjt.banking.transactions.factories;

import org.junit.Test;
import willjt.banking.entities.BankAccount;
import willjt.banking.transactions.WithdrawalFromABankAccount;
import willjt.banking.transactions.base.BankAccountTransaction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

public class WithdrawalFromABankAccountFactoryTest {

    private static final int POSITIVE_AMOUNT = 103;
    private WithdrawalFromABankAccountFactory theFactory = new WithdrawalFromABankAccountFactory();

    @Test
    public void shouldReturnADepositTransactionWhenGetDepositIsCalled() throws Exception {
        BankAccount bankAccountToWithdrawFrom = givenAMockBankAccount();
        int amountToWithdraw = POSITIVE_AMOUNT;

        BankAccountTransaction transactionReturned = theFactory.createTransaction(bankAccountToWithdrawFrom, amountToWithdraw);

        assertThat(transactionReturned, is(WithdrawalFromABankAccount.class));
    }

    private BankAccount givenAMockBankAccount() {
        return mock(BankAccount.class);
    }

}