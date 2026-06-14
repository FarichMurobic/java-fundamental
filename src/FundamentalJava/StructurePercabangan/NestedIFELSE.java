package FundamentalJava.StructurePercabangan;

import java.util.Scanner;

public class NestedIFELSE {
    public static void main(String[] args) {

        /**
         * Nested if artinya if di dalam if.
         * Dalam Java, kita boleh menaruh sebuah if di dalam blok if lain.
         * Bentuk umumnya seperti ini:
         * if(condition1) {
         *
         *     if(condition2) {
         *         statement1;
         *     }
         *
         * }
         * Artinya:
         * Program mengecek condition1 dulu
         * Jika condition1 true, maka program masuk ke dalam blok if
         * Di dalamnya program mengecek condition2
         * Jika condition1 false, maka condition2 tidak pernah diperiksa.
         *
         * kita sudah tau cara membuat keputusan tunggal dengan if, dan keputusan bercabang dua dengan if else.
         * sekarang adalah keputusan yang bercabang lagi didalamnya. itu adalah nested structure (nesting)
         *
         * Nesting adalah saat kita menempatkan satustruktur kontrol if atau if else didalam struktur kontrol lainnya.
         * ActionStetement didalam if atau if else, bisa berupa apapun, termasuk if atau if else lain. ini adalah aturan yang memungkinkan nesting terjadi.
         *
         * Aturan penting
         * setiap else akan berpasangan dengan if terdekat di atasnya yang belum punya pasangan  else.
         */

        // Aplikasi kalkulator pajak penghasilan

        // Deklarasi konstanta
        final double BRACKET_1 = 25000.00;
        final double BRACKET_2 = 100000.00;
        final double TAX_RATE_1 = 0.15; // 15%
        final double TAX_RATE_2 = 0.25; // 25%

        double totalIncome;
        double incomeTax;

        Scanner input = new Scanner(System.in);

        System.out.println("--- Kalkulator Pajak Penghasilan ---");
        System.out.print("Masukkan total penghasilan tahunan Anda: $");
        totalIncome = input.nextDouble();

        // ini adalah struktur if else bersarang nested
        if (totalIncome > BRACKET_1) {
            // Ini adalah branch pertama: Penghasilan di atas $25,000
            if (totalIncome > BRACKET_2) {
                // Ini adalah branch bersarang: penghasilan di atas $100,000
                System.out.println("\nPenghasilan Anda di atas $" + BRACKET_2);
                double taxOnBracket2 = (BRACKET_2 - BRACKET_1) * TAX_RATE_1; // Pajak untuk bracket kedua.
                double taxOnExcess = (totalIncome - BRACKET_2) * TAX_RATE_2; // Pajak untuk kelebihan.
                incomeTax = taxOnBracket2 + taxOnExcess;
            } else {
                // Ini adalah branch bersarang: penghasilan di atas $25,000 tapi dibawah $100,000
                System.out.println("\nPenghasilan Anda di antara $" + BRACKET_1 + " dan $" + BRACKET_2);
                incomeTax = (totalIncome - BRACKET_1) * TAX_RATE_1;
            }
        } else {
            // Ini adalah branch pertama: Ppenghasilan kurang dari atau sama dengan $25,000
            System.out.println("\nPenghasilan Anda kurang dari atau sama dengan $" + BRACKET_1);
            incomeTax = 0.0;
        }

        System.out.println("Pajak yang harus dibayarkan: $" + incomeTax);
        System.out.println("------------------------------");

        input.close();

    }
}
