package willjt.banking.records;

import willjt.banking.entities.BankAccount;

public interface RecordOfABankAccountTransaction {

    BankAccount getBankAccountTheTransactionBelongsTo();

    public int getAmount();

    public int getResultingBalance();


}
