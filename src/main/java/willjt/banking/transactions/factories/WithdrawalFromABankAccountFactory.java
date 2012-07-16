package willjt.banking.transactions.factories;

import willjt.banking.entities.BankAccount;
import willjt.banking.transactions.WithdrawalFromABankAccount;
import willjt.banking.transactions.base.BankAccountTransaction;

public class WithdrawalFromABankAccountFactory implements BankAccountTransactionFactory {

    public BankAccountTransaction createTransaction(BankAccount bankAccountWithdrawingFrom, int amountToWithdraw) {
        return new WithdrawalFromABankAccount(bankAccountWithdrawingFrom, amountToWithdraw);
    }
}
