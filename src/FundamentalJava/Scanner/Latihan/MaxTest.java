package FundamentalJava.Scanner.Latihan;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MaxTest {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        System.out.println("Enter 2 ints: ");
        try {
            int x = in.nextInt();
            int y = in.nextInt();

            System.out.println("Max: " + Math.max(x, y));
        } catch (NoSuchElementException e) {
            System.out.println("Error: nedd two ints");
        }
    }
}
