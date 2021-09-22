package training.supportbank;

import com.opencsv.CSVReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Account> accountList = new ArrayList<>();
    private static List<Transaction> transactionList = new ArrayList<>();

    public static void main(String args[]) {
        try {
            transactionList = ImportTransactions("Transactions2014.csv");
        } catch (Exception  e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Welcome to SupportBank! You have these command options: \n - List All \n - List [Account]" );
            String command = scanner.nextLine();
            String[] myArgs = command.split(" ", 2);
            if (myArgs[1].equals("All")) {
                System.out.println("You have chosen to list all accounts and their balances...");
            } else {
                System.out.println("You have chosen to list all transactions of account: " + myArgs[1]);
                for (Transaction t : transactionList) {
                    if (t.getFROM().equals(ValidateAccount(myArgs[1])) | t.getTO().equals(ValidateAccount(myArgs[1]))) {
                        System.out.println(t.getDATE() + " " + FindBankID(t.getFROM()) + " " + FindBankID(t.getTO()) + " " + t.getNOTE() + " " + t.getAMOUNT());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("That is an invalide command");
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
                list.add(new Transaction(line[0], ValidateAccount(line[1]), ValidateAccount(line[2]), line[3], new BigDecimal(line[4])));
            }
            count += 1;
        }
        bufferedReader.close();
        csvReader.close();
        return list;
    }

    private static Account ValidateAccount(String input) {
        for (Account a : accountList) {
            if (a.getBANKID().equalsIgnoreCase(input)) {
                return a;
            }
        }
        Account newAccount = new Account(input);
        accountList.add(newAccount);
        return newAccount;
    }

    private static String FindBankID(Account search) {
        for (Account a : accountList) {
            if (a.equals(search)) {
                return a.getBANKID();
            }
        }
        return "Account not found";
    }
}
