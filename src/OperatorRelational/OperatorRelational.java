package OperatorRelational;

public class OperatorRelational {
    public static void main(String[] args) {

        /**
         * Relational Operators
         * Operator relational digunakan untuk menentukan hubungan antara dua operand.
         * Secara khusus operator ini digunakan untuk menentukan:
         * - kesamaan (equality)
         * - urutan (ordering)
         *
         * Operator relational di Java adalah:
         * Operator	    Arti
         * ==	        sama dengan
         * !=	        tidak sama dengan
         * >	        lebih besar
         * <	        lebih kecil
         * >=	        lebih besar atau sama
         * <=	        lebih kecil atau sama
         *
         * Hasil dari operasi ini selalu berupa nilai boolean: true and false
         * Operator relational paling sering dipakai dalam:
         * if
         * while
         * for
         * do-while
         *
         * Tipe Data yang Bisa Dibandingkan
         * Operator == dan != bisa dipakai untuk hampir semua tipe:
         * int
         * double
         * float
         * char
         * boolean
         *
         * Operator Perbandingan Urutan
         * Operator berikut hanya berlaku untuk tipe numerik:
         * >
         * <
         * >=
         * <=
         * Artinya hanya bisa dipakai untuk:
         * int
         * float
         * double
         * char
         */

        int a = 10, b = 20;

        // == Equal to a == b
        System.out.println(a == b); // false
        // != Not equal	a != b
        System.out.println(a != b); // true
        // > Greater than a > b
        System.out.println(a > b); // false
        // < less than a < b
        System.out.println(a < b); // true
        // greater than and equal to a >= b
        System.out.println(a >= b); // false
        // less than and equal to a <= b
        System.out.println(a <= b); // true

    }
}
