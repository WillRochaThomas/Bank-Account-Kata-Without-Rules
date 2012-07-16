package willjt.banking.transactions;

import org.junit.Test;
import willjt.banking.entities.BankAccount;

import static org.mockito.Mockito.*;

public class MoneyTransferBetweenBankAccountsTest {

    private static final int SOME_TRANSFER_AMOUNT = 43;


    @Test
    public void shouldDeductTheCorrectAmountFromTheBalanceOfThePayingAccountWhenExecuted() throws Exception {
        BankAccount payingAccount = mock(BankAccount.class);
        BankAccount receivingAccount = mock(BankAccount.class);
        MoneyTransferBetweenBankAccounts theTransfer = new MoneyTransferBetweenBankAccounts(payingAccount, SOME_TRANSFER_AMOUNT, receivingAccount);

        theTransfer.execute();

        verify(payingAccount, times(1)).deductFromBalance(SOME_TRANSFER_AMOUNT);
    }

    @Test
    public void shouldAddTheCorrectAmountToTheBalanceOfTheReceivingAccountWhenExecuted() throws Exception {
        BankAccount payingAccount = mock(BankAccount.class);
        BankAccount receivingAccount = mock(BankAccount.class);
        MoneyTransferBetweenBankAccounts theTransfer = new MoneyTransferBetweenBankAccounts(payingAccount, SOME_TRANSFER_AMOUNT, receivingAccount);

        theTransfer.execute();

        verify(receivingAccount, times(1)).addToBalance(SOME_TRANSFER_AMOUNT);
    }
}