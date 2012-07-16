package willjt.banking.transactions;

import willjt.banking.entities.BankAccount;
import willjt.banking.transactions.base.BankAccountTransaction;
import willjt.banking.transactions.base.TransactionWithAPositiveAmount;

public class DepositIntoABankAccount extends TransactionWithAPositiveAmount implements BankAccountTransaction {

    private BankAccount bankAccountBeingDepositedInto;

    public DepositIntoABankAccount(BankAccount bankAccountBeingDepositedInto, int transactionAmount) {
        super(transactionAmount);
        this.bankAccountBeingDepositedInto = bankAccountBeingDepositedInto;
    }

    public void execute() {
        bankAccountBeingDepositedInto.addToBalance(transactionAmount);
    }
}
