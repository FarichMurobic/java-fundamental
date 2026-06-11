package Rekursion.Latihan;

public class FaktorialSederhana {
    // methode rekursif
    static int factorial(int n) {
        // base case
        if (n == 0)
            return 1;

        return n * factorial(n - 1); // rekursif case

        /**
         * Cara Kerja Rekursi (Step by Step)
         * Misalnya:
         * factorial(3)
         *
         * Langkah pemanggilan:
         * factorial(3)
         * = 3 * factorial(2)
         *
         * factorial(2)
         * = 2 * factorial(1)
         *
         * factorial(1)
         * = 1 * factorial(0)
         *
         * factorial(0)
         * = 1
         *
         * Sekarang stack dibongkar:
         * factorial(1) = 1 * 1 = 1
         * factorial(2) = 2 * 1 = 2
         * factorial(3) = 3 * 2 = 6
         *
         * Output
         * 6
         *
         * Visualisasi Call Stack
         * Bayangin seperti tumpukan piring
         *
         * main()
         *   └ factorial(3)
         *       └ factorial(2)
         *           └ factorial(1)
         *               └ factorial(0)
         *
         * Setelah base case:
         * factorial(0) selesai
         * factorial(1) lanjut
         * factorial(2) lanjut
         * factorial(3) lanjut
         *
         * Ini disebut unwinding the stack.
         */
    }

    public static void main(String[] args) {

        int hasil = factorial(5);
        System.out.println(hasil);

        hasil = factorial(3);
        System.out.println(hasil);

    }
}
