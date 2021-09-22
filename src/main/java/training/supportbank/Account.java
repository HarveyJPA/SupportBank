package training.supportbank;

import java.math.BigDecimal;

public class Account {
    private final String BANKID;
    private BigDecimal balance;

    public Account (String initBankID) {
        BANKID = initBankID;
    }
    public String getBANKID () {
        return BANKID;
    }
    public BigDecimal getBalance () {
        return balance;
    }
    public void setBalance (BigDecimal balanceChange) {
        balance = balance.add(balanceChange);
    }
}
