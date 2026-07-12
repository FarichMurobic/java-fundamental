package FundamentalJava.StructurePercabangan;

/**
 * ------------------------------------------------------------------------
 * NESTED IF (IF BERSARANG)
 * ------------------------------------------------------------------------
 * 
 * Nested if artinya if di dalam if.
 * 
 * Dalam Java, kita boleh menaruh sebuah if di dalam blok if lain.
 * 
 * ------------------------------------------------------------------------
 * BENTUK UMUM
 * ------------------------------------------------------------------------
 * 
 *     if (kondisi1) {
 *         // Kode di sini hanya dijalankan jika kondisi1 true
 * 
 *         if (kondisi2) {
 *             // Statement hanya dijalankan jika:
 *             // kondisi1 true DAN kondisi2 true
 *         }
 *     }
 * 
 * Artinya:
 * 1. Program mengecek kondisi1 terlebih dahulu
 * 2. Jika kondisi1 TRUE → program masuk ke dalam blok if
 * 3. Di dalamnya, program mengecek kondisi2
 * 4. Jika kondisi1 FALSE → kondisi2 TIDAK PERNAH diperiksa
 * 
 * ------------------------------------------------------------------------
 * CONTOH SEDERHANA
 * ------------------------------------------------------------------------
 * 
 *     int umur = 20;
 *     boolean punyaKTP = true;
 * 
 *     if (umur >= 17) {
 *         System.out.println("Umur cukup");
 * 
 *         if (punyaKTP) {
 *             System.out.println("Boleh masuk");
 *         } else {
 *             System.out.println("Tidak boleh masuk, KTP tidak ada");
 *         }
 *     } else {
 *         System.out.println("Umur belum cukup");
 *     }
 * 
 *     // Output:
 *     // Umur cukup
 *     // Boleh masuk
 * 
 * ------------------------------------------------------------------------
 * TINGKAT NESTING (BERSARANG)
 * ------------------------------------------------------------------------
 * 
 * Kita sudah tahu:
 * - if = keputusan tunggal
 * - if-else = keputusan bercabang dua
 * - Nested if = keputusan bercabang di dalam keputusan lain
 * 
 * Nesting adalah saat kita menempatkan satu struktur kontrol if atau if-else
 * di dalam struktur kontrol lainnya.
 * 
 * Action statement di dalam if atau if-else bisa berupa APAPUN,
 * termasuk if atau if-else lain.
 * Inilah yang memungkinkan nesting terjadi.
 * 
 * ------------------------------------------------------------------------
 * CONTOH NESTING BERTINGKAT
 * ------------------------------------------------------------------------
 * 
 *     if (kondisiA) {
 *         // Level 1
 * 
 *         if (kondisiB) {
 *             // Level 2
 * 
 *             if (kondisiC) {
 *                 // Level 3 - sangat dalam
 *             }
 *         }
 *     }
 * 
 * ------------------------------------------------------------------------
 * CONTOH KASUS NYATA
 * ------------------------------------------------------------------------
 * 
 * Kasus: Validasi login dengan role
 * 
 *     String username = "admin";
 *     String password = "12345";
 *     String role = "superadmin";
 * 
 *     if (username.equals("admin")) {
 *         System.out.println("Username ditemukan");
 * 
 *         if (password.equals("12345")) {
 *             System.out.println("Password benar");
 * 
 *             if (role.equals("superadmin")) {
 *                 System.out.println("Selamat datang Super Admin!");
 *                 System.out.println("Anda memiliki akses penuh");
 *             } else {
 *                 System.out.println("Hanya user biasa");
 *             }
 * 
 *         } else {
 *             System.out.println("Password salah!");
 *         }
 * 
 *     } else {
 *         System.out.println("Username tidak ditemukan");
 *     }
 * 
 * Output:
 *     Username ditemukan
 *     Password benar
 *     Selamat datang Super Admin!
 *     Anda memiliki akses penuh
 * 
 * ------------------------------------------------------------------------
 * ATURAN PENTING: ELSE BERPASANGAN DENGAN IF TERDEKAT
 * ------------------------------------------------------------------------
 * 
 * Aturan ini WAJIB diingat:
 * 
 * Setiap else akan berpasangan dengan if TERDEKAT di atasnya
 * yang BELUM memiliki pasangan else.
 * 
 * Contoh 1 (jelas):
 * 
 *     if (a > 0) {
 *         if (b > 0) {
 *             System.out.println("a dan b positif");
 *         } else {
 *             System.out.println("b tidak positif");
 *         }
 *     }
 * 
 *     // else di sini berpasangan dengan if (b > 0)
 *     // karena itu adalah if terdekat di atasnya
 * 
 * Contoh 2 (membingungkan, tanpa kurung):
 * 
 *     if (a > 0)
 *         if (b > 0)
 *             System.out.println("a dan b positif");
 *     else
 *         System.out.println("a tidak positif");
 * 
 *     // Awas! else di sini berpasangan dengan if (b > 0),
 *     // BUKAN dengan if (a > 0)
 *     // Karena else berpasangan dengan if terdekat!
 * 
 * Contoh 3 (perbaikan dengan kurung kurawal):
 * 
 *     if (a > 0) {
 *         if (b > 0) {
 *             System.out.println("a dan b positif");
 *         }
 *     } else {
 *         System.out.println("a tidak positif");
 *     }
 * 
 *     // Sekarang else jelas berpasangan dengan if (a > 0)
 *     // karena kita menggunakan kurung kurawal
 * 
 * ------------------------------------------------------------------------
 * REKOMENDASI BEST PRACTICE
 * ------------------------------------------------------------------------
 * 
 * 1. SELALU gunakan kurung kurawal { } untuk setiap if dan else
 *    - Menghindari kebingungan pasangan else
 *    - Memudahkan pembacaan kode
 *    - Menghindari bug yang sulit dilacak
 * 
 * 2. Batasi tingkat nesting maksimal 3-4 level
 *    - Terlalu dalam membuat kode sulit dibaca
 *    - Pertimbangkan untuk refactor jika terlalu dalam
 * 
 * 3. Gunakan indentasi yang konsisten
 *    - Menandakan level nesting secara visual
 * 
 * ------------------------------------------------------------------------
 * KAPAN MENGGUNAKAN NESTED IF?
 * ------------------------------------------------------------------------
 * 
 * Cocok digunakan ketika:
 * - Ada kondisi yang hanya perlu diperiksa jika kondisi sebelumnya true
 * - Validasi bertahap (step by step validation)
 * - Kondisi bersifat hierarkis
 * 
 * Contoh:
 * - Login: cek username dulu, baru password
 * - Pembelian: cek stok dulu, baru saldo
 * - Akses: cek login dulu, baru role
 * 
 * ------------------------------------------------------------------------
 * KESIMPULAN WAJIB
 * ------------------------------------------------------------------------
 * 
 * 1. Nested if = if di dalam if
 * 2. kondisi di luar harus true dulu, baru kondisi di dalam diperiksa
 * 3. Tingkat nesting bisa banyak (tapi jangan berlebihan)
 * 4. Setiap else berpasangan dengan if TERDEKAT di atasnya
 * 5. SELALU gunakan kurung kurawal { } untuk menghindari ambiguitas
 * 6. Batasi nesting agar kode tetap mudah dibaca
 * 
 * ------------------------------------------------------------------------
 */

import java.util.Scanner;

public class NestedIFELSE {
    public static void main(String[] args) {

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
