package FundamentalJava.ExceptionHandling.Latihan;

import java.util.Scanner;

public class DivideByTwo {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int x;

        System.out.println("Enter an integer: ");
        try {
            String onleLine = in.nextLine();
            x = Integer.parseInt(onleLine);
            System.out.println("Halp of x is " + (x / 2));
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
}
