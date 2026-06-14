package FundamentalJava.ExceptionHandling.Latihan;
import java.util.Random;

public class Training {
    public static void main(String[] args) {
        
        // Mencoba menangani kondisi yang benar
        try {
            int a = 10;
            int b = 20;

            System.out.println(a + b);
            System.out.println("Try");
        } catch (ArithmeticException e) { // karena try tidak error, maka ini tidak di jalankan
            System.out.println("Catch");
        } finally {
            System.out.println("Finaly");
        }

        System.out.println();

        /**
         * Output
         * 30
         * Try
         * Finaly
         */

        // Mencoba menangani yang error
        int d, e;

        try {
            System.out.println("Try bro"); // ini tetep akan dicetak
            d = 0;
            e = d / 42;

            // Tidak dicetak
            System.out.println(e / d);     
            // Tidak dicetak
            System.out.println("Try."); 
        } catch (ArithmeticException ex) {
            System.out.println("Catch.");
        } finally {
            System.out.println("Finally.");
        }

        /**
         * Output
         * Try bro
         * Catch.
         * Finally.
         */

        System.out.println();

        // Contoh Lebih Real (Loop + Random)
        int a = 0, b = 0, c = 0;

        Random random = new Random();
        
        for (int i = 0; i < 32000; i++) {
            try {
                b = random.nextInt();
                c = random.nextInt();
                
                a = 12345 / (b / c);
            } catch (ArithmeticException ee) {
                System.out.println("Division by zero.");
                a = 0; // set ulang supaya program lanjut
            }

            System.out.println("a: " + a);
        }
    }
}
