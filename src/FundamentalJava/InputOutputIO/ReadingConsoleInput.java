package FundamentalJava.InputOutputIO;

/**
 * ============================================================
 *                    Reading Console Input
 * ============================================================
 *
 * Pada Java versi awal, pembacaan input dari console dilakukan
 * menggunakan byte stream melalui System.in..
 *
 * Hingga saat ini pendekatan tersebut masih didukung. Namun,
 * untuk membaca data berupa teks, Java menyediakan character
 * stream yang lebih nyaman digunakan karena mendukung Unicode
 * secara langsung dan lebih mudah dipelihara.
 *
 * Untuk aplikasi modern, pembacaan input teks umumnya dilakukan
 * menggunakan character stream seperti BufferedReader atau
 * Scanner, tergantung kebutuhan aplikasi.
 *
 * ------------------------------------------------------------
 *
 * System.in
 *
 * Input standar (standard input) pada Java disediakan oleh
 * field:
 *
 *     System.in
 *
 * Secara default, System.in terhubung ke keyboard dan bertipe:
 *
 *     InputStream
 *
 * Karena InputStream merupakan byte stream, diperlukan proses
 * konversi apabila data akan diproses sebagai karakter.
 *
 * ------------------------------------------------------------
 *
 * Mengubah Byte Stream Menjadi Character Stream
 *
 * Java menyediakan class InputStreamReader sebagai jembatan
 * antara byte stream dan character stream.
 *
 * Contoh:
 *
 * BufferedReader br =
 *     new BufferedReader(
 *         new InputStreamReader(System.in)
 *     );
 *
 * Pada contoh di atas:
 *
 * - System.in menyediakan data dalam bentuk byte.
 * - InputStreamReader mengubah byte menjadi karakter Unicode.
 * - BufferedReader memberikan mekanisme pembacaan yang lebih
 *   efisien serta mendukung pembacaan per karakter maupun
 *   per baris.
 *
 * Alur pembacaan data menjadi:
 *
 * Keyboard
 *      ↓
 * System.in
 *      ↓
 * InputStreamReader
 *      ↓
 * BufferedReader
 *      ↓
 * Program
 *
 * ------------------------------------------------------------
 *
 * Peran Masing-Masing Class
 *
 * System.in
 *     Sumber input standar berupa byte stream.
 *
 * InputStreamReader
 *     Mengonversi data dari byte stream menjadi character stream.
 *
 * BufferedReader
 *     Menambahkan buffering agar proses pembacaan lebih efisien
 *     serta menyediakan method seperti read() dan readLine().
 *
 * ------------------------------------------------------------
 *
 * Line Buffering
 *
 * Secara default, input dari console bersifat line-buffered.
 *
 * Artinya, data baru dikirimkan ke program setelah pengguna
 * menekan tombol Enter.
 *
 * Oleh karena itu, pembacaan input dari keyboard umumnya tidak
 * terjadi secara real-time untuk setiap penekanan tombol.
 *
 * ------------------------------------------------------------
 *
 * Method read()
 *
 * Method:
 *
 *     read()
 *
 * digunakan untuk membaca satu karakter dari stream.
 *
 * Method ini mengembalikan nilai bertipe int.
 *
 * Nilai yang dikembalikan dapat berupa:
 *
 * - Nilai Unicode dari karakter yang berhasil dibaca.
 * - -1 apabila telah mencapai akhir stream (End Of File / EOF).
 *
 * Karena hanya membaca satu karakter setiap pemanggilan,
 * method ini kurang praktis untuk membaca input berupa satu
 * baris teks.
 *
 * ------------------------------------------------------------
 *
 * Method readLine()
 *
 * Untuk membaca satu baris teks sekaligus, BufferedReader
 * menyediakan method:
 *
 *     readLine()
 *
 * Contoh:
 *
 * String input = br.readLine();
 *
 * Method ini mengembalikan sebuah String yang berisi seluruh
 * karakter hingga pengguna menekan tombol Enter.
 *
 * Dalam banyak kasus, readLine() lebih nyaman digunakan
 * dibandingkan read() untuk menerima input dari pengguna.
 *
 * ------------------------------------------------------------
 *
 * Penggunaan di Java Modern
 *
 * Dalam aplikasi modern, terdapat dua pendekatan yang paling
 * umum digunakan untuk membaca input dari console:
 *
 * - BufferedReader
 *   Memberikan performa yang baik dan sering digunakan ketika
 *   memerlukan pembacaan teks secara efisien.
 *
 * - Scanner
 *   Menyediakan API yang lebih sederhana untuk membaca berbagai
 *   tipe data seperti int, double, String, dan lain-lain.
 *
 * Pemilihan class bergantung pada kebutuhan aplikasi.
 *
 * ------------------------------------------------------------
 *
 * Ringkasan
 *
 * - System.in merupakan standard input bertipe InputStream.
 * - InputStreamReader mengubah byte stream menjadi character
 *   stream.
 * - BufferedReader menambahkan buffering dan menyediakan method
 *   read() serta readLine().
 * - read() membaca satu karakter dan mengembalikan nilai int.
 * - readLine() membaca satu baris teks dan mengembalikan String.
 * - Input console umumnya bersifat line-buffered sehingga data
 *   baru diterima setelah pengguna menekan Enter.
 */

import java.io.*;

public class ReadingConsoleInput {
    public static void main(String[] args) throws IOException {

        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter characters, 'q' to quit!");

        // BACA CHARACTERS
        // JIKA q QUIT
        do {
            c = (char) br.read();
            System.out.print(c);
        } while (c != 'q');
    }

}
