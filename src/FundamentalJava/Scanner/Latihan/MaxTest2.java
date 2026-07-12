package FundamentalJava.Scanner.Latihan;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MaxTest2 {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        System.out.println("Enter 2 ints on one line: ");
        try {
            String oneLine = in.nextLine();
            Scanner str = new Scanner(oneLine);

            int x = str.nextInt();
            int y = str.nextInt();

            if (!str.hasNext()) {
                System.out.println("Max: " + Math.max(x, y));
            } else {
                System.out.println("Error: extraneous data on the line.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Error: need two ints");
        }
    }
}
