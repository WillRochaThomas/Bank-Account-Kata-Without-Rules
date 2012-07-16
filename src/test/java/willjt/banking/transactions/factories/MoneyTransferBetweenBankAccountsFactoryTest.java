package willjt.banking.transactions.factories;

import org.junit.Test;
import willjt.banking.entities.BankAccount;
import willjt.banking.transactions.MoneyTransferBetweenBankAccounts;
import willjt.banking.transactions.base.BankAccountTransaction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

public class MoneyTransferBetweenBankAccountsFactoryTest {

    private static final int POSITIVE_AMOUNT = 103;
    private MoneyTransferBetweenBankAccountsFactory theFactory = new MoneyTransferBetweenBankAccountsFactory();

    @Test
    public void shouldReturnADepositTransactionWhenGetDepositIsCalled() throws Exception {
        BankAccount bankAccountToDebit = givenAMockBankAccount();
        BankAccount bankAccountToCredit = givenAMockBankAccount();
        int amountToPay = POSITIVE_AMOUNT;

        BankAccountTransaction transactionReturned = theFactory.createTransaction(bankAccountToCredit, amountToPay, bankAccountToDebit);

        assertThat(transactionReturned, is(MoneyTransferBetweenBankAccounts.class));
    }

    private BankAccount givenAMockBankAccount() {
        return mock(BankAccount.class);
    }

}