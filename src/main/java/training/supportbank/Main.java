package training.supportbank;

import com.opencsv.CSVReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<Account> accountList = new ArrayList<>();
    private static List<Transaction> transactionList = new ArrayList<>();

    public static void main(String args[]) {
        try {
            transactionList = ImportTransactions("Transactions2014.csv");
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }

    private static List<Transaction> ImportTransactions(String filePath) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        List<Transaction> list = new ArrayList<>();
        CSVReader csvReader = new CSVReader(bufferedReader);
        String[] line;
        int count = 0;
        while ((line = csvReader.readNext()) != null) {
            if (count >= 1) {
                list.add(new Transaction(line[0], CreateNewAccount(line[1]), CreateNewAccount(line[2]), line[3], new BigDecimal(line[4])));
            }
            count += 1;
        }
        bufferedReader.close();
        csvReader.close();
        return list;
    }

    private static Account CreateNewAccount(String input) {
        for (Account a : accountList) {
            if (a.getBANKID().equals(input)) {
                return a;
            }
        }
        Account newAccount = new Account(input);
        accountList.add(newAccount);
        return newAccount;
    }
}
