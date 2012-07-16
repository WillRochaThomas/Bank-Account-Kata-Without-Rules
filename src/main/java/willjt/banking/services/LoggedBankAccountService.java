package willjt.banking.services;

import willjt.banking.entities.BankAccount;
import willjt.banking.records.BankAccountTransactionLog;

public class LoggedBankAccountService {
    private BankAccountTransactionLog transactionLog;
    private BankAccountTransactionService bankAccountTransactionService;

    public LoggedBankAccountService(BankAccount bankAccountToService) {
        transactionLog = new BankAccountTransactionLog();
    }

    public void executeATransactionAndLogItInTheTransactionLog(int transactionAmount) {
        bankAccountTransactionService.executeATransactionForAmount(transactionAmount);
    }

    public void setTransactionLog(BankAccountTransactionLog transactionLog) {
        this.transactionLog = transactionLog;
    }

    public void setBankAccountTransactionService(BankAccountTransactionService bankAccountTransactionService) {
        this.bankAccountTransactionService = bankAccountTransactionService;
    }
}
