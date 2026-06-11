package OperatorAritmatika;

public class UnaryAndBinary {
    public static void main(String[] args) {

        /**
         * Operator Binary dan Unary
         * Jika sebuah operator memiliki dua operand, itu disebut operator binary.
         * Contoh: a + b - c * d
         * operator unary atau operator dengan satu operand.
         * Contoh: -a, ++a
         */

        int a = 10;
        int b = 3;

        System.out.println("--- Operator Binary ---");

        // Aritmatika
        System.out.println("a + b = " + (a + b)); // 13
        System.out.println("a - b = " + (a - b)); // 7
        System.out.println("a * b = " + (a * b)); // 30
        System.out.println("a / b = " + (a / b)); // 3
        System.out.println("a % b = " + (a % b)); // 1

        // Relasional
        System.out.println("a > b = " + (a > b));
        System.out.println("a == b = " + (a == b));

        // Logika
        boolean p = true;
        boolean q = false;

        System.out.println("p && q = " + (p && q)); // true
        System.out.println("p || q = " + (p || q)); // false

        // Bitwise
        System.out.println("a & b = " + (a & b));
        System.out.println("a | b = " + (a | b));
        System.out.println("a ^ b = " + (a ^ b));

        System.out.println("---------------------\n");

        System.out.println("--- Operator Unary ---");
        int x = 5;
        boolean flag = false;
        System.out.println("x = " + x);
        System.out.println("Negasi angka: -x = " + (-a));
        System.out.println("Increment prefix: ++a = " + (++a));
        System.out.println("Decrement prefix: --a = " + (--a));
        System.out.println("Logika negasi: !flag = " + (!flag));

    }
}
