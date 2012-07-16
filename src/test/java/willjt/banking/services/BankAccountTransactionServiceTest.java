package willjt.banking.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import willjt.banking.entities.BankAccount;
import willjt.banking.transactions.base.BankAccountTransaction;
import willjt.banking.transactions.factories.BankAccountTransactionFactory;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class BankAccountTransactionServiceTest {

    @Mock private BankAccountTransactionFactory transactionFactory;
    @Mock private BankAccount bankAccountBeingServiced;
    @Mock private BankAccountTransaction aTransaction;
    private static final int AN_AMOUNT = 9;
    private BankAccountTransactionService theService;

    @Before
    public void setup() {
        initMocks(this);
        theService = new BankAccountTransactionService(bankAccountBeingServiced, transactionFactory);
    }

    @Test
    public void shouldExecuteTheTransactionReturnedByTheTransactionFactory() {
        given(transactionFactory.createTransaction(bankAccountBeingServiced, AN_AMOUNT)).willReturn(aTransaction);

        theService.executeATransactionForAmount(AN_AMOUNT);

        verify(aTransaction, times(1)).execute();
    }
}
