package willjt.banking.transactions.factories;

import willjt.banking.entities.BankAccount;
import willjt.banking.transactions.base.BankAccountTransaction;

public interface BankAccountTransactionFactory {

    public BankAccountTransaction createTransaction(BankAccount accountInvolved, int transactionAmount);
}
