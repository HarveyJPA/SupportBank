package training.supportbank;

public class Account {
    private static String BANKID;
    private Float balance;
    public Account (String initBankID) {
        BANKID = initBankID;
    }
    public String getBANKID () {
        return BANKID;
    }
    public Float getBalance () {
        return balance;
    }
    public void setBalance (Float newBalance) {
        this.balance += newBalance;
    }
}
