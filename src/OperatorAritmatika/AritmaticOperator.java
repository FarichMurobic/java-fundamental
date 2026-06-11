package OperatorAritmatika;

/**
 * Operator aritmatika digunakan untuk melakukan operasi matematika umum.
 * Operator ini tidak bisa digunakan pada boolean.
 * Namun boleh digunakan pada char, karena char sebenarnya angka Unicode.
 *
 * Semua lima operasi (+, -, *, /, %) dapat digunakan pada:
 * Dua bilangan bulat (integer)
 * Dua bilangan floating point
 *
 * Operator modulus jarang digunakan bersama dengan operand floating point dan karena itu dihilangkan
 * !Ini adalah poin yang sangat penting: aritmatika floating point tidak selalu tepat (exact).
 *
 * Aturan Prioritas Operator (Operator Precedence Rules)
 *
 * Operator Unary (+, -): Memiliki prioritas tertinggi.
 * Dievaluasi dari kanan ke kiri (right to left). (Ini disebut asivitas.)
 *
 * Operator Binary (*, /, %): Memiliki prioritas yang lebih rendah dari operator unary,
 * tetapi lebih tinggi dari operator binary + dan -.
 * Memiliki prioritas yang sama di antara mereka.
 * Dievaluasi dari kiri ke kanan (left to right).
 *
 * Operator Binary (+, -): Memiliki prioritas terendah di antara operator aritmatika.
 * Memiliki prioritas yang sama di antara mereka.
 * Dievaluasi dari kiri ke kanan (left to right).
 *
 * Dalam sebuah ekspresi aritmatika, tanda kurung (()) dapat digunakan untuk memodifikasi urutan eksekusi.
 * Tanda kurung juga bisa digunakan untuk keterbacaan yang lebih baik,
 * bahkan jika tidak mengubah urutan eksekusi berdasarkan aturan prioritas.
 */

public class AritmaticOperator {
    public static void main(String[] args) {

        /**
         * Arithmetic Operators
         * Arithmetic operators are used in mathematical expressions in the same way that they are
         * used in algebra. The following table lists the arithmetic operators:
         */

        /**
         * Operator     -   Result
         * +                Addition (also unary plus)
         * –                Subtraction (also unary minus)
         * *                Multiplication
         * /                Division
         * %                Modulus
         * ++               Increment
         * +=               Addition assignment
         * –=               Subtraction assignment
         * *=               Multiplication assignment
         * /=               Division assignment
         * %=               Modulus assignment
         * ––               Decrement
         */

        // Operasi Aritmatika Basic (Bilangan bulat)
        int a = 5 + 5; // 10
        int b = 5 - 5; // 0
        int c = 5 * 5; // 25
        int d = 5 / 5; // 1
        int e = 5 % 5; // 0

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

        // Operasi Aritmatika Basic (Bilangan desimal)
        double num1 = 50 + 50; // 100.0
        double num2 = 50 - 50; // 0.0
        double num3 = 50 * 50; // 2500.0
        double num4 = 50 / 50; // 1.0
        double num5 = 50 % 50; // 0.0

        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);
        System.out.println(num5);

        // Assignment Arithmetic
        int x = 10; // Nilai awal
        x += 10;
        System.out.println("x: " + x); // x: 20
        x -= 10;
        System.out.println("x: " + x); // x: 10
        x *= 10;
        System.out.println("x: " + x); // x: 100
        x /= 5;
        System.out.println("x: " + x); // x: 20
        x %= 2;
        System.out.println("x: " + x); // x: 0

        // Hal menarik compound assignment
        byte compoundAssignment = 10;
        // compoundAssignment = compoundAssignment + 10; ini akan error
        compoundAssignment += 10; // ini gak akan error, karena compound assignment akan otomatis menjadikan byte ke int

        /**
         * Unary artinya operator dengan 1 operand.
         * Operator unary minus (-) akan membuat nilai operand menjadi negatif.
         * Operator unary plus (+) hanya mengembalikan nilai operand tanpa mengubahnya.
         */

        // Unary minus
        int unaryMinus = 10; // -10
        int hasil1 = -unaryMinus;
        System.out.println(hasil1);

        // Unary plus
        int unaryPlus = -10; // Tidak mengubah nilai. tetap -10
        int hasil2 = +unaryPlus;
        System.out.println(hasil2);

        /**
         * The Modulus Operator
         * Operator modulus (%) mengembalikan sisa dari operasi pembagian.
         * Operator ini dapat digunakan pada:
         * - tipe integer
         * - tipe floating-point
         */

        int number1 = 42; // Number1 mod 10: 2
        double number2 = 42.25; // Number2 mod 10: 2.25

        System.out.println("Number1 mod 10: " + number1 % 10);
        System.out.println("Number2 mod 10: " + number2 % 10);

    }
}
