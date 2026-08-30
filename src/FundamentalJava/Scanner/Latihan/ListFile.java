package FundamentalJava.Scanner.Latihan;

// LATIHAN

import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class ListFile {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("No file specified");
        }
        for (String fileName : args)
            listFile(fileName);
    }

    public static void listFile(String fileName) {
        Scanner fileIn = null;

        System.out.println("FILE: " + fileName);
        try {
            fileIn = new Scanner(new FileReader(fileName));
            while (fileIn.hasNext()) {
                String onLine = fileIn.nextLine();
                System.out.println(onLine);
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (fileIn != null)
                fileIn.close();
        }
    }
}
