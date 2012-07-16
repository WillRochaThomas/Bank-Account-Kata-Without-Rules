package willjt.banking.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import willjt.banking.entities.BankAccount;
import willjt.banking.records.BankAccountTransactionLog;
import willjt.banking.transactions.factories.BankAccountTransactionFactory;

import static org.mockito.Mockito.*;

public class LoggedBankAccountServiceTest {

    private LoggedBankAccountService theLoggedService;
    private static final int AN_AMOUNT = 10001;
    @Mock BankAccountTransactionFactory transactionFactory;
    @Mock private BankAccount theBankAccountBeingServiced;
    @Mock private BankAccountTransactionLog transactionLog;
    @Mock private BankAccountTransactionService bankAccountTransactionService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        theLoggedService = new LoggedBankAccountService(theBankAccountBeingServiced);
        theLoggedService.setTransactionLog(transactionLog);
        theLoggedService.setBankAccountTransactionService(bankAccountTransactionService);
    }

    @Test
    public void shouldExecuteATransactionUsingTheConfiguredBankAccountTransactionService() throws Exception {
        BankAccountTransactionService bankAccountTransactionService = givenTheBankAccountServiceBeingUsedIs();

        theLoggedService.executeATransactionAndLogItInTheTransactionLog(AN_AMOUNT);

        verify(bankAccountTransactionService, times(1)).executeATransactionForAmount(AN_AMOUNT);
    }

    private BankAccountTransactionService givenTheBankAccountServiceBeingUsedIs() {
        return bankAccountTransactionService;
    }

}