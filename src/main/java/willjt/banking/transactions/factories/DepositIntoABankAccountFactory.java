package willjt.banking.transactions.factories;

import willjt.banking.entities.BankAccount;
import willjt.banking.transactions.DepositIntoABankAccount;
import willjt.banking.transactions.base.BankAccountTransaction;

public class DepositIntoABankAccountFactory implements BankAccountTransactionFactory {

    public BankAccountTransaction createTransaction(BankAccount bankAccountDepositingInto, int amountToDeposit) {
        return new DepositIntoABankAccount(bankAccountDepositingInto, amountToDeposit);
    }
}
