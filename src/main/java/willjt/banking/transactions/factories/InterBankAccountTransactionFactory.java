package willjt.banking.transactions.factories;

import willjt.banking.entities.BankAccount;
import willjt.banking.transactions.base.BankAccountTransaction;

public interface InterBankAccountTransactionFactory {

    public BankAccountTransaction createTransaction(BankAccount firstAccountInvolved, int transactionAmount, BankAccount secondAccountInvolved);
}
