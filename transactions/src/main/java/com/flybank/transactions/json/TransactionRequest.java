package com.flybank.transactions.json;

import java.math.BigDecimal;

public class TransactionRequest {

    Long accountNumber;
    String transactionType;
    BigDecimal amount;
    Long targetAccount;

    public Long getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(Long targetAccount) {
        this.targetAccount = targetAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }
}
