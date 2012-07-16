package willjt.banking.records;

import willjt.banking.entities.BankAccount;

import java.util.Date;

public class TransactionOnABankStatement implements RecordOfABankAccountTransaction {

    public String getDescription() {
        return "";
    }

    public Date getDateItWasRecorded() {
        return null;
    }

    public BankAccount getBankAccountTheTransactionBelongsTo() {
        return null;
    }

    public int getAmount() {
        return 0;
    }

    public int getResultingBalance() {
        return 0;
    }
}
