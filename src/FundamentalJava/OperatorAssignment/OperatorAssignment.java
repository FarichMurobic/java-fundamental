package FundamentalJava.OperatorAssignment;

public class OperatorAssignment {
    public static void main(String[] args) {

        /**
         * Assignment operator adalah operator untuk memberikan nilai ke variabel.
         * Operatornya adalah:
         * =
         *
         * Bentuk Umum:
         * variabel = ekspresi
         *
         * contoh sederhana
         * int a = 10;
         * artinya nilai 10 dimasukkan ke variabel a
         *
         * Compound Assignment Operator:
         * += aritmatika
         * -= aritmatika
         * *= aritmatika
         * /= aritmatika
         * %= aritmatika
         *
         * &= bitwise
         * |= bitwise
         * ^= bitwise
         * <<= bitwise
         * >>= bitwise
         * >>>= bitwise
         */


        // Contoh Program Assignment Operator
        int a;
        a = 10;
        System.out.println("Nilai a: " + a);

        // Nilai a = 10
        // variabel a diberi nilai 10

        // Assignment dengan Ekspresi
        // Nilai yang dimasukkan ke variabel bisa berupa perhitungan.
        a = 0; // reset
        int b = 5;
        int c = 10;
        a = b + c;
        System.out.println("Nilai a: " + a);

        // Chain Assignment (Assignment Berantai)
        // Java mengizinkan assignment berantai.
        int x, y, z;
        x = y = z = 100; // Artinya: z = 100, y = 100, x = 100
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("z = " + z);
        // Kenapa bisa?
        // Karena operator = menghasilkan nilai dari sisi kanan.

        // Contoh Chain Assignment dengan Perhitungan
        int e, f, g;
        e = f = g = 10 + 5;
        System.out.println("e = " + e);
        System.out.println("f = " + f);
        System.out.println("g = " + g);

        // Contoh Kasus Nyata
        int width, height, depth;

        width = height = depth = 50;

        System.out.println("width = " + width);
        System.out.println("height = " + height);
        System.out.println("depth = " + depth);


    }
}
