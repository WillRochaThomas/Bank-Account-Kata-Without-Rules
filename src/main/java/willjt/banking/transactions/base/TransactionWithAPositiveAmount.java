package willjt.banking.transactions.base;

import org.springframework.util.Assert;

public class TransactionWithAPositiveAmount {
    protected int transactionAmount;

    public TransactionWithAPositiveAmount(int transactionAmount) {
        Assert.isTrue(transactionAmount > 0, "A transaction can only be made for an amount greater than 0");
        this.transactionAmount = transactionAmount;
    }
}
