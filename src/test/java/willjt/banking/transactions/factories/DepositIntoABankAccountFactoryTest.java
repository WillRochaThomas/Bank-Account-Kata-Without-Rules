package willjt.banking.transactions.factories;

import org.junit.*;
import willjt.banking.entities.BankAccount;
import willjt.banking.transactions.DepositIntoABankAccount;
import willjt.banking.transactions.base.BankAccountTransaction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

public class DepositIntoABankAccountFactoryTest {

    private static final int POSITIVE_AMOUNT = 103;
    private DepositIntoABankAccountFactory theFactory = new DepositIntoABankAccountFactory();

    @Test
    public void shouldReturnADepositTransactionWhenGetDepositIsCalled() throws Exception {
        BankAccount bankAccountBeingDepositedInto = givenAMockBankAccount();
        int amountToDeposit = POSITIVE_AMOUNT;

        BankAccountTransaction transactionReturned = theFactory.createTransaction(bankAccountBeingDepositedInto, amountToDeposit);

        assertThat(transactionReturned, is(DepositIntoABankAccount.class));
    }

    private BankAccount givenAMockBankAccount() {
        return mock(BankAccount.class);
    }

}