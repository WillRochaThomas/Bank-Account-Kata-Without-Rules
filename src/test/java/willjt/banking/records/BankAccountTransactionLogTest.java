package willjt.banking.records;

import org.junit.Test;
import willjt.banking.entities.BankAccount;
import willjt.banking.transactions.base.BankAccountTransaction;

import java.util.List;

import static org.mockito.Mockito.mock;

public class BankAccountTransactionLogTest {

    private BankAccountTransactionLog theLog = new BankAccountTransactionLog();

    @Test
    public void shouldReturnAllTransactionsAddedForABankAccountWhenPerformingALookup() throws Exception {
        BankAccount aBankAccount = mock(BankAccount.class);
        BankAccountTransaction theLoggedTransaction = mock(BankAccountTransaction.class);

        List<RecordOfABankAccountTransaction> transactionRecordsReturned = theLog.lookupTransactions(aBankAccount);


    }
}