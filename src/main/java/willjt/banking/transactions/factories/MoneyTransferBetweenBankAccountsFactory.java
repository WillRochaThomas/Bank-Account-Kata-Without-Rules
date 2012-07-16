package willjt.banking.transactions.factories;

import willjt.banking.entities.BankAccount;
import willjt.banking.transactions.MoneyTransferBetweenBankAccounts;
import willjt.banking.transactions.base.BankAccountTransaction;

public class MoneyTransferBetweenBankAccountsFactory implements InterBankAccountTransactionFactory {

    public BankAccountTransaction createTransaction(BankAccount bankAccountToDebit, int amountToTransfer, BankAccount bankAccountToCredit) {
        return new MoneyTransferBetweenBankAccounts(bankAccountToDebit, amountToTransfer, bankAccountToCredit);
    }
}
