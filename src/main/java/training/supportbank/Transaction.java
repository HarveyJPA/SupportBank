package training.supportbank;

public class Transaction {
    private static Account FROM;
    private static Account TO;
    private static Float AMOUNT;
    private static String DATE;
    private static String NOTE;
    public Transaction (Account initFROM, Account initTO, Float initAMOUNT, String initDATE, String initNOTE) {
        FROM = initFROM;
        TO = initTO;
        AMOUNT = initAMOUNT;
        DATE = initDATE;
        NOTE = initNOTE;
    }
}
