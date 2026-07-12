package FundamentalJava.Number;

/**
 * ------------------------------------------------------------------------
 * CONVERTING NUMBERS TO AND FROM STRINGS
 * ------------------------------------------------------------------------
 * 
 * Salah satu pekerjaan paling umum dalam pemrograman adalah mengubah
 * representasi angka dalam bentuk string menjadi format biner internal
 * yang bisa diproses oleh program.
 * 
 * Untungnya, Java menyediakan cara yang mudah dan terstandarisasi
 * untuk melakukan konversi ini.
 * 
 * ------------------------------------------------------------------------
 * KONVERSI STRING → NUMBER
 * ------------------------------------------------------------------------
 * 
 * Class-wrapper untuk tipe data primitif menyediakan method parsing:
 * 
 * Class       | Method Parsing       | Return Type
 * ------------|----------------------|-------------
 * Byte        | parseByte()          | byte
 * Short       | parseShort()         | short
 * Integer     | parseInt()           | int
 * Long        | parseLong()          | long
 * Float       | parseFloat()         | float
 * Double      | parseDouble()        | double
 * 
 * Method-method ini akan mengembalikan nilai numerik dari string yang diberikan.
 * 
 * Contoh:
 * 
 *     int angka = Integer.parseInt("123");
 *     double desimal = Double.parseDouble("45.67");
 *     long besar = Long.parseLong("9999999999");
 * 
 * ------------------------------------------------------------------------
 * KONVERSI NUMBER → STRING
 * ------------------------------------------------------------------------
 * 
 * Mengubah number menjadi string bisa dilakukan dengan beberapa cara:
 * 
 * 1. Menggunakan method toString() dari class wrapper:
 * 
 *     String str = Integer.toString(123);    // "123"
 *     String str = Double.toString(45.67);   // "45.67"
 * 
 * 2. Menggunakan method valueOf():
 * 
 *     String str = String.valueOf(123);      // "123"
 *     String str = String.valueOf(45.67);    // "45.67"
 * 
 * 3. Menggunakan string concatenation (otomatis):
 * 
 *     String str = "" + 123;                 // "123" (tidak disarankan)
 * 
 * ------------------------------------------------------------------------
 * KONVERSI DENGAN FORMAT LAIN
 * ------------------------------------------------------------------------
 * 
 * Integer dan Long menyediakan method untuk konversi ke format lain:
 * 
 *     // Desimal ke biner
 *     String biner = Integer.toBinaryString(10);   // "1010"
 * 
 *     // Desimal ke heksadesimal
 *     String hex = Integer.toHexString(255);       // "ff"
 * 
 *     // Desimal ke oktal
 *     String octal = Integer.toOctalString(8);     // "10"
 * 
 *     // String biner ke desimal
 *     int desimal = Integer.parseInt("1010", 2);   // 10
 * 
 * ------------------------------------------------------------------------
 * KESIMPULAN SEDERHANA
 * ------------------------------------------------------------------------
 * 
 * Intinya:
 * - Input dari user biasanya berupa String
 * - Program membutuhkan data dalam bentuk Number
 * - Solusi: gunakan method parseXXX()
 * 
 * WAJIB DIINGAT:
 * - parseInt()   → String ke int
 * - toString()   → int ke String
 * - Selalu gunakan try-catch
 * - Ada format lain: binary, hex, octal
 * 
 * ------------------------------------------------------------------------
 * REAL TALK (INI YANG KEPAKE BANGET)
 * ------------------------------------------------------------------------
 * 
 * Di backend development:
 * 
 * Semua request dari client berupa JSON:
 * 
 *     {
 *         "age": "25",
 *         "salary": "7500000",
 *         "rating": "4.5"
 *     }
 * 
 * Semua nilai datang sebagai String.
 * Harus diubah ke tipe data yang sesuai:
 * 
 *     int age = Integer.parseInt("25");
 *     long salary = Long.parseLong("7500000");
 *     double rating = Double.parseDouble("4.5");
 * 
 * ------------------------------------------------------------------------
 * PENANGANAN EXCEPTION (WAJIB)
 * ------------------------------------------------------------------------
 * 
 * Method parsing bisa melempar NumberFormatException
 * jika string tidak mengandung angka yang valid.
 * 
 * SELALU gunakan try-catch:
 * 
 *     try {
 *         int umur = Integer.parseInt(inputUser);
 *         System.out.println("Umur: " + umur);
 *     } catch (NumberFormatException e) {
 *         System.out.println("Input tidak valid! Harus berupa angka.");
 *     }
 * 
 * ------------------------------------------------------------------------
 * RINGKASAN SUPER PADAT
 * ------------------------------------------------------------------------
 * 
 * - parseXXX()   = String → Number (harus try-catch)
 * - toString()   = Number → String
 * - valueOf()    = Number → String (alternatif)
 * - toBinaryString() / toHexString() / toOctalString() = format lain
 * - parseInt(String, radix) = parsing dengan basis tertentu
 * 
 * ------------------------------------------------------------------------
 */

/**
 * Contoh Program
 * Program berikut menunjukkan penggunaan parseInt().
 * Program ini menjumlahkan angka yang dimasukkan user.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertNumToAndFromString {
    public static void main(String[] args) throws IOException {

        // Membuat BufferedReader untuk membaca input dari user (keyboard)
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String string; // untuk menyimpan input user dalam bentuk string
        int i;         // untuk menyimpan hasil konversi ke int
        int sum = 0;   // untuk menyimpan total jumlah

        System.out.println("Masukkan angka, 0 untuk keluar...");

        do {
            // Membaca input dari user (selalu string)
            string = bufferedReader.readLine();
            try {
                // Mengubah string menjadi int
                i = Integer.parseInt(string);
            } catch (NumberFormatException e) {
                // Jika input bukan angka
                System.out.println("Format tidak valid!");
                i = 0;
            }
            // Menambahkan ke total
            sum += i;
            // Menampilkan hasil sementara
            System.out.println("Total saat ini: " + sum);
        } while (i != 0); // berhenti kalau user input 0

        /**
         * PENJELASAN:
         * 
         * 1. Masalah utama di dunia nyata
         * User input itu SELALU:
         * String
         *
         * Contoh:
         * "10"
         * "25"
         * "100"
         *
         * Tapi program butuh:
         * int
         *
         * 2. Solusi: parseInt()
         * int x = Integer.parseInt("10");
         *
         * hasil:
         * 10 (int)
         *
         * 3. Kenapa ada try-catch?
         * Karena:
         * Integer.parseInt("abc");
         *
         * ERROR:
         * NumberFormatException
         *
         * Makanya:
         * try {
         *     i = Integer.parseInt(str);
         * } catch (NumberFormatException e) {
         *     i = 0;
         * }
         *
         * 4. Alur program ini (WAJIB LO PAHAM)
         * User input angka
         * Dibaca sebagai string
         * Di-convert ke int
         * Dijumlahkan
         * Loop terus sampai input = 0
         */

        /**
         * Program berikut menunjukkan bagaimana mengonversi sebuah bilangan integer menjadi:
         * biner (binary)
         * oktal (octal)
         * heksadesimal (hexadecimal)
         */

        int num = 19648; // angka yang akan dikonversi

        // KE BINARY
        System.out.println(num + " in binary: " +
                Integer.toBinaryString(num));
        // Mengubah angka ke format biner (basis 2)

        // KE OCTAL
        System.out.println(num + " in octal: " +
                Integer.toOctalString(num));
        // Mengubah angka ke format oktal (basis 8)

        // KE HEXADECIMAL
        System.out.println(num + " in hexadecimal: " +
                Integer.toHexString(num));
        // Mengubah angka ke format heksadesimal (basis 16)

        /**
         * OUTPUT:
         * 
         * 19648 in binary: 100110011000000
         * 19648 in octal: 46300
         * 19648 in hexadecimal: 4cc0
         *
         * KESIMPULAN SEDERHANA
         *
         * Intinya:
         * Java bisa convert angka ke:
         * binary
         * octal
         * hex
         * hasilnya selalu String
         *
         * WAJIB LO INGAT:
         * toBinaryString() → basis 2
         * toOctalString() → basis 8
         * toHexString() → basis 16
         */

    }
}
