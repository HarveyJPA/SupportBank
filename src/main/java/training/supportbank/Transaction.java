package training.supportbank;

import java.math.BigDecimal;

public class Transaction {
    private final String DATE;
    private final Account FROM;
    private final Account TO;
    private final String NOTE;
    private final BigDecimal AMOUNT;

    public Transaction (String initDATE, Account initFROM, Account initTO, String initNOTE, BigDecimal initAMOUNT) {
        DATE = initDATE;
        FROM = initFROM;
        TO = initTO;
        NOTE = initNOTE;
        AMOUNT = initAMOUNT;
    }

    public String getNOTE() {
        return NOTE;
    }

    public Account getTO() {
        return TO;
    }

    public Account getFROM() {
        return FROM;
    }

    public String getDATE() {
        return DATE;
    }

    public BigDecimal getAMOUNT() {
        return AMOUNT;
    }
}
