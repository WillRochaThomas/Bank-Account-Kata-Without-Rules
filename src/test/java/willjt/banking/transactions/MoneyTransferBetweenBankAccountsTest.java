package willjt.banking.transactions;

import org.junit.Test;
import willjt.banking.entities.BankAccount;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MoneyTransferBetweenBankAccountsTest {

    private BankAccount mockPayingAccount;
    private BankAccount mockReceivingAccount;
    private int theAmount;
    private static final int AN_AMOUNT = 43;


    @Test
    public void shouldDeductTheCorrectAmountFromTheBalanceOfThePayingAccountWhenExecuted() throws Exception {
        givenAPayingAccount();
        givenAReceivingAccount();
        givenAnAmount(AN_AMOUNT);

        whenTheTransferIsExecuted();

        thenTheFollowingAmountIsDeductedFromTheBalanceOfThePayingAccount(AN_AMOUNT);
    }

    @Test
    public void shouldAddTheCorrectAmountToTheBalanceOfTheReceivingAccountWhenExecuted() throws Exception {
        givenAPayingAccount();
        givenAReceivingAccount();
        givenAnAmount(AN_AMOUNT);

        whenTheTransferIsExecuted();

        thenTheFollowingAmountIsAddedToTheBalanceOfTheReceivingAccount(AN_AMOUNT);
    }


    private void givenAnAmount(int anAmount) {
        theAmount = anAmount;
    }

    private void givenAPayingAccount() {
        mockPayingAccount = mock(BankAccount.class);
    }

    private void givenAReceivingAccount() {
        mockReceivingAccount = mock(BankAccount.class);
    }

    private void whenTheTransferIsExecuted() {
        MoneyTransferBetweenBankAccounts theTransfer = new MoneyTransferBetweenBankAccounts(mockPayingAccount, theAmount, mockReceivingAccount);
        theTransfer.execute();
    }

    private void thenTheFollowingAmountIsDeductedFromTheBalanceOfThePayingAccount(int amountThatShouldHaveBeenDeducted) {
        verify(mockPayingAccount, times(1)).deductFromBalance(amountThatShouldHaveBeenDeducted);
    }

    private void thenTheFollowingAmountIsAddedToTheBalanceOfTheReceivingAccount(int amountThatShouldHaveBeenAdded) {
        verify(mockReceivingAccount, times(1)).addToBalance(amountThatShouldHaveBeenAdded);
    }
}