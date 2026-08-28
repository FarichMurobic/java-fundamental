package FundamentalJava.Array.Latihan;

// Latihan

import java.util.ArrayList;
import java.util.Scanner;

public class ReadStringsWithArrayList {

    public static void main(String[] args) {

        ArrayList<String> array = getStrings();
        for (int i = 0; i < array.size(); i++)
            System.out.println(array.get(i));
    }

    public static ArrayList<String> getStrings() {
        Scanner in = new Scanner(System.in);
        ArrayList<String> array = new ArrayList<>();

        System.out.println("Enter any number of strings, one per line; ");
        System.out.println("Terminate with empty line: ");

        while (in.hasNextLine()) {
            String oneLine = in.nextLine();
            if (oneLine.equals(""))
                break;
            array.add(oneLine);
        }
        System.out.println("Done reading");
        return array;
    }
}
