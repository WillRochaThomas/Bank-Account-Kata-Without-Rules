package willjt.banking.entities;

import willjt.banking.records.TransactionOnABankStatement;

import java.util.ArrayList;

public class BankStatement {
    private ArrayList<TransactionOnABankStatement> transactionsOnTheStatement = new ArrayList<TransactionOnABankStatement>();

    public void addNewItem(TransactionOnABankStatement newTransaction) {
        transactionsOnTheStatement.add(newTransaction);
    }

    public String generate() {
        StringBuilder generatedStatement = new StringBuilder();

        for (TransactionOnABankStatement transactionOnTheStatement : transactionsOnTheStatement) {
            generatedStatement.append(transactionOnTheStatement.getDateItWasRecorded());
            generatedStatement.append(transactionOnTheStatement.getAmount());
            generatedStatement.append(transactionOnTheStatement.getResultingBalance());
        }

        return generatedStatement.toString();
    }
}
