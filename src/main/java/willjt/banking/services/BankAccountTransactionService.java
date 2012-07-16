package willjt.banking.services;

import willjt.banking.entities.BankAccount;
import willjt.banking.transactions.base.BankAccountTransaction;
import willjt.banking.transactions.factories.BankAccountTransactionFactory;

public class BankAccountTransactionService {
    private BankAccountTransactionFactory transactionFactory;
    private BankAccount theBankAccountToService;

    public BankAccountTransactionService(BankAccount theBankAccountToService, BankAccountTransactionFactory transactionFactory) {
        this.theBankAccountToService = theBankAccountToService;
        this.transactionFactory = transactionFactory;
    }

    public void executeATransactionForAmount(int transactionAmount) {
        BankAccountTransaction transaction = transactionFactory.createTransaction(theBankAccountToService, transactionAmount);
        transaction.execute();
    }
}
