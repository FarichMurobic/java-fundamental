package Number;

/**
 * Converting Numbers to and from Strings
 * Salah satu pekerjaan paling umum dalam pemrograman adalah mengubah representasi angka dalam bentuk string menjadi format biner internal.
 *
 * Untungnya, Java menyediakan cara yang mudah untuk melakukan hal ini.
 *
 * Class:
 * Byte
 * Short
 * Integer
 * Long
 *
 * menyediakan method:
 * parseByte()
 * parseShort()
 * parseInt()
 * parseLong()
 *
 * Method-method ini akan mengembalikan nilai angka (byte, short, int, long) dari string yang diberikan.
 * (Method serupa juga ada untuk Float dan Double.)
 *
 * KESIMPULAN SEDERHANA
 *
 * Intinya:
 * Input user = String
 * Program butuh = Number
 * Solusi = parseXXX()
 *
 * WAJIB LO INGAT:
 * parseInt() → string ke int
 * toString() → int ke string
 * selalu pakai try-catch
 * format lain: binary, hex, octal
 *
 * REAL TALK (INI YANG KEPAKE BANGET)
 * Di backend:
 * Semua request:
 *
 * {
 *   "age": "25"
 * }
 *
 * Harus diubah ke:
 * int age = Integer.parseInt("25");
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
         * PENJELASAN DALAM
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
         * OUTPUT
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
