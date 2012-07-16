package willjt.banking.entities;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import willjt.banking.records.TransactionOnABankStatement;

import java.util.Date;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;

public class BankStatementTest {

    BankStatement statement = new BankStatement();
    private String generatedStatement;
    private static final int TRANSACTION_AMOUNT = 20;
    private static final int RESULTING_BALANCE = 100;
    @Mock private Date DATE_TRANSACTION_WAS_RECORDED;
    @Mock private TransactionOnABankStatement mockRecordOfABankAccountTransaction;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(DATE_TRANSACTION_WAS_RECORDED.toString()).thenReturn("12/02/2008");
    }

    @Test
    public void ensureThatIfNoTransactionsHaveBeenAddedThenAnEmptyStatementIsGenerated() {
        givenAStatementWithNoTransactions();
        whenTheStatementIsGenerated();
        thenTheStatementShouldBeEmpty();
    }

    @Test
    public void ensureThatATransactionAddedToTheStatementIsIncludedWhenItIsGenerated() {
        givenATransactionIsAddedWithDetails(DATE_TRANSACTION_WAS_RECORDED, TRANSACTION_AMOUNT, RESULTING_BALANCE);
        whenTheStatementIsGenerated();
        thenATransactionIsIncludedInTheStatementWithDetails(DATE_TRANSACTION_WAS_RECORDED, TRANSACTION_AMOUNT, RESULTING_BALANCE);
    }

    @Test
    public void ensureThatOnlyAddedTransactionsAreIncludedInAStatementGenerated() {
        givenATransactionIsAddedWithDetails(DATE_TRANSACTION_WAS_RECORDED, TRANSACTION_AMOUNT, RESULTING_BALANCE);
        whenTheStatementIsGenerated();
        thenNoTransactionsAreIncludedInTheStatementOtherThanOneWithDetails(
                DATE_TRANSACTION_WAS_RECORDED, TRANSACTION_AMOUNT, RESULTING_BALANCE);
    }

    private void givenAStatementWithNoTransactions() {
        statement = new BankStatement();
    }

    private void givenATransactionIsAddedWithDetails(Date date, int amount, int resultingBalance) {
        when(mockRecordOfABankAccountTransaction.getDateItWasRecorded()).thenReturn(date);
        when(mockRecordOfABankAccountTransaction.getAmount()).thenReturn(amount);
        when(mockRecordOfABankAccountTransaction.getResultingBalance()).thenReturn(resultingBalance);
        statement.addNewItem(mockRecordOfABankAccountTransaction);
    }

    private void whenTheStatementIsGenerated() {
        generatedStatement = statement.generate();
    }

    private void thenATransactionIsIncludedInTheStatementWithDetails(
            Date expectedTransactionDate, int expectedAmount, int expectedResultingBalance) {
        assertThat(generatedStatement, containsString(expectedTransactionDate.toString()));
        assertThat(generatedStatement, containsString(String.valueOf(expectedAmount)));
        assertThat(generatedStatement, containsString(String.valueOf(expectedResultingBalance)));
    }

    private void thenTheStatementShouldBeEmpty() {
        assertTrue(generatedStatement.isEmpty());
    }

    private void thenNoTransactionsAreIncludedInTheStatementOtherThanOneWithDetails(
            Date transactionDateInStatement, int transactionAmountInStatement, int resultingBalanceInStatement) {
        String remainderOfStatement = removeTheFollowingTransactionDetailsFromTheStatement(transactionDateInStatement,
                transactionAmountInStatement, resultingBalanceInStatement);
        assertTrue(remainderOfStatement.isEmpty());
    }

    private String removeTheFollowingTransactionDetailsFromTheStatement(
            Date transactionDateToRemove, int transactionAmountToRemove, int resultingBalanceToRemove) {
        String dateToRemove = transactionDateToRemove.toString();
        String amountToRemove = String.valueOf(transactionAmountToRemove);
        String balanceToRemove = String.valueOf(resultingBalanceToRemove);

        String statementWithTransactionDetailsRemoved = generatedStatement;
        statementWithTransactionDetailsRemoved = statementWithTransactionDetailsRemoved.replace(dateToRemove, "");
        statementWithTransactionDetailsRemoved = statementWithTransactionDetailsRemoved.replace(amountToRemove, "");
        statementWithTransactionDetailsRemoved = statementWithTransactionDetailsRemoved.replace(balanceToRemove, "");

        return statementWithTransactionDetailsRemoved;
    }
}