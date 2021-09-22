package training.supportbank;

import com.opencsv.CSVReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) {
        try {
            System.out.print(importCSV());
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }

    private static List<String[]> readCSV(Reader reader) throws Exception {
        List<String[]> list = new ArrayList<>();
        CSVReader csvReader = new CSVReader(reader);
        String[] line;
        while ((line = csvReader.readNext()) != null) {
            list.add(line);
        }
        reader.close();
        csvReader.close();
        return list;
    }

    private static String importCSV() throws Exception {
        String filePath = "Transactions2014.csv";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        return readCSV(bufferedReader).toString();
    }

}
