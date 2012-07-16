package willjt.banking.transactions;

import willjt.banking.entities.BankAccount;
import willjt.banking.transactions.base.BankAccountTransaction;
import willjt.banking.transactions.base.TransactionWithAPositiveAmount;

public class WithdrawalFromABankAccount extends TransactionWithAPositiveAmount implements BankAccountTransaction {

    private BankAccount bankAccountBeingWithdrawnFrom;

    public WithdrawalFromABankAccount(BankAccount bankAccountBeingWithdrawnFrom, int transactionAmount) {
        super(transactionAmount);
        this.bankAccountBeingWithdrawnFrom = bankAccountBeingWithdrawnFrom;
    }

    public void execute() {
        bankAccountBeingWithdrawnFrom.deductFromBalance(transactionAmount);
    }
}
