package willjt.banking.transactions;

import willjt.banking.entities.BankAccount;
import willjt.banking.transactions.base.BankAccountTransaction;
import willjt.banking.transactions.base.TransactionWithAPositiveAmount;

public class WithdrawalFromABankAccount extends TransactionWithAPositiveAmount implements BankAccountTransaction {

    private BankAccount theBankAccount;

    public WithdrawalFromABankAccount(BankAccount theBankAccount, int withdrawalAmount) {
        super(withdrawalAmount);
        this.theBankAccount = theBankAccount;
    }

    public void execute() {
        theBankAccount.deductFromBalance(transactionAmount);
    }
}
