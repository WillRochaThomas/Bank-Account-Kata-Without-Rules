package willjt.banking.transactions;

import willjt.banking.entities.BankAccount;
import willjt.banking.transactions.base.BankAccountTransaction;
import willjt.banking.transactions.base.TransactionWithAPositiveAmount;

public class MoneyTransferBetweenBankAccounts extends TransactionWithAPositiveAmount implements BankAccountTransaction {

    private BankAccount bankAccountToCredit;
    private BankAccount bankAccountToDebit;

    public MoneyTransferBetweenBankAccounts(BankAccount bankAccountToDebit, int transactionAmount, BankAccount bankAccountToCredit) {
        super(transactionAmount);
        this.bankAccountToDebit = bankAccountToDebit;
        this.bankAccountToCredit = bankAccountToCredit;
    }

    public void execute() {
        bankAccountToDebit.deductFromBalance(transactionAmount);
        bankAccountToCredit.addToBalance(transactionAmount);
    }
}
