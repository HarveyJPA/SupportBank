package training.supportbank;

import com.opencsv.CSVReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private List<Account> accountList;
    private List<Transaction> transactionList;

    public static void main(String args[]) {
        try {
            System.out.println(importTransactions());
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }

    private static List<String[]> importTransactions() throws Exception {
        String filePath = "Transactions2014.csv";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        List<String[]> list = new ArrayList<>();
        CSVReader csvReader = new CSVReader(bufferedReader);
        String[] line;
        while ((line = csvReader.readNext()) != null) {
            list.add(line);
        }
        bufferedReader.close();
        csvReader.close();
        return list;
    }
}
