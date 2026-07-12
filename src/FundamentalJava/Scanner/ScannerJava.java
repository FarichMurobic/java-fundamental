package FundamentalJava.Scanner;

import java.util.Scanner;

public class ScannerJava {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int x, y;

        System.out.println("Enter 2 ints: ");

        if (in.hasNextInt()) {
            x = in.nextInt();
            if (in.hasNextInt()) {
                y = in.nextInt();
                System.out.println("Max: " + Math.max(x, y));
                return;
            }
        }
        System.err.println("Error: need two ints");
    }
}
