package FundamentalJava.InputOutputIO;

/* ============================================================
 *                     THE PrintWriter CLASS
 * ============================================================
 *
 * PrintWriter adalah class Character Stream yang digunakan
 * untuk menghasilkan output teks..
 *
 * Class ini berada dalam package java.io dan merupakan salah
 * satu pilihan utama ketika bekerja dengan output berbasis
 * karakter (teks).
 *
 * PrintWriter menyediakan method yang familier, seperti:
 *
 * - print()
 * - println()
 * - printf()
 * - format()
 *
 * sehingga sangat nyaman digunakan untuk menghasilkan output.
 */

/* ------------------------------------------------------------
 * Mengapa Menggunakan PrintWriter?
 * ------------------------------------------------------------
 *
 * System.out.println() tetap valid dan masih banyak digunakan,
 * terutama untuk:
 *
 * - Contoh program
 * - Pembelajaran
 * - Debugging sederhana
 * - Aplikasi console
 *
 * Namun, ketika bekerja dengan Character Stream atau ingin
 * menghasilkan output teks secara lebih fleksibel, PrintWriter
 * sering menjadi pilihan yang lebih tepat.
 *
 * Karena berbasis Character Stream, PrintWriter menangani
 * karakter Unicode dengan lebih alami melalui mekanisme
 * Writer.
 */

/* ------------------------------------------------------------
 * System.out vs PrintWriter
 * ------------------------------------------------------------
 *
 * System.out
 * - Bertipe PrintStream.
 * - Turunan dari OutputStream (Byte Stream).
 *
 * PrintWriter
 * - Turunan dari Writer (Character Stream).
 * - Dirancang khusus untuk menghasilkan output teks.
 *
 * Keduanya sama-sama menyediakan method:
 *
 * - print()
 * - println()
 * - printf()
 *
 * Namun, PrintWriter lebih sesuai ketika aplikasi memang
 * bekerja dengan Character Stream.
 */

/* ------------------------------------------------------------
 * Constructor yang Sering Digunakan
 * ------------------------------------------------------------
 *
 * Salah satu constructor yang umum digunakan adalah:
 *
 * PrintWriter(OutputStream out, boolean autoFlush)
 *
 * Parameter:
 *
 * out
 * - Menentukan tujuan output, misalnya:
 *   System.out atau FileOutputStream.
 *
 * autoFlush
 * - Menentukan apakah buffer akan dikosongkan (flush)
 *   secara otomatis pada kondisi tertentu.
 *
 * Nilai:
 *
 * true
 * - Flush dilakukan otomatis setelah pemanggilan
 *   println(), printf(), atau format().
 *
 * false
 * - Flush dilakukan secara manual menggunakan flush()
 *   atau saat stream ditutup.
 */

/* ------------------------------------------------------------
 * Membuat Object PrintWriter
 * ------------------------------------------------------------
 *
 * Contoh:
 *
 * PrintWriter pw =
 *     new PrintWriter(System.out, true);
 *
 * Artinya:
 *
 * - Output diarahkan ke console melalui System.out.
 * - Auto flush diaktifkan.
 *
 * Dengan demikian, output akan segera dikirim tanpa perlu
 * memanggil flush() secara manual setelah println(),
 * printf(), atau format().
 */

/* ------------------------------------------------------------
 * Tentang flush()
 * ------------------------------------------------------------
 *
 * PrintWriter menggunakan buffer untuk meningkatkan efisiensi
 * proses output.
 *
 * Method flush() berfungsi memaksa seluruh data yang masih
 * berada di dalam buffer agar segera dikirim ke tujuan output.
 *
 * Biasanya flush dilakukan:
 *
 * - Secara otomatis (jika autoFlush = true dan menggunakan
 *   println(), printf(), atau format()).
 *
 * - Secara manual dengan memanggil flush().
 *
 * - Otomatis saat stream ditutup menggunakan close().
 */

/* ------------------------------------------------------------
 * Kapan Menggunakan PrintWriter?
 * ------------------------------------------------------------
 *
 * PrintWriter sering digunakan untuk:
 *
 * - Menulis file teks.
 * - Menghasilkan output Character Stream.
 * - Menulis data ke socket sebagai teks.
 * - Membuat laporan atau log berbasis teks.
 * - Aplikasi yang memproses data Unicode.
 */

/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * - PrintWriter merupakan Character Stream untuk menghasilkan
 *   output teks.
 *
 * - PrintWriter menyediakan method print(), println(),
 *   printf(), dan format().
 *
 * - Constructor yang sering digunakan:
 *   PrintWriter(OutputStream out, boolean autoFlush).
 *
 * - Jika autoFlush bernilai true, flush otomatis terjadi
 *   setelah pemanggilan println(), printf(), atau format().
 *
 * - PrintWriter sangat cocok digunakan ketika bekerja dengan
 *   Character Stream dan pengolahan data teks.
 */

import java.io.*;

public class PrintWritter {
    public static void main(String[] args) {

        PrintWriter printWriter = new PrintWriter(System.out, true);
        printWriter.println("Hello UNIVERSE!");

        int i = -7;
        printWriter.println(i);

        double d = 4.5e-7;
        printWriter.println(d);
        printWriter.println(i + " " + d);
        printWriter.println(22);
        printWriter.println("Hello Janera!");
        printWriter.println("Hello Farich!");

        // MENCOBA
        printWriter.println("こんにちは");
        System.out.println("こんにちは");

        /**
         * 1. Buat object
         * PrintWriter pw = new PrintWriter(System.out, true);
         *
         * ini:
         * pakai console sebagai output
         * auto flush aktif
         *
         * 2. Print string
         * pw.println("This is a string");
         *
         * langsung tampil
         *
         * 3. Print int
         * pw.println(i);
         *
         * otomatis convert ke string
         *
         * 4. Print double
         * pw.println(d);
         *
         * hasil:
         * 4.5E-7
         *
         * ---------------------------------
         * 
         * HAL PENTING BANGET
         * 
         * Kalau bukan tipe sederhana?
         * Misal:
         * pw.println(obj);
         *
         * Java akan:
         * obj.toString()
         *
         * Artinya:
         * Semua object bisa diprint selama punya toString()
         *
         * PERBANDINGAN DALAM
         * Aspek PrintStream (System.out) PrintWriter
         * Tipe byte stream character stream
         * Encoding terbatas lebih fleksibel
         * International kurang cocok lebih cocok
         * Real-world jarang lebih disarankan
         *
         * KENAPA PrintWriter LEBIH BAGUS?
         * Karena dia:
         * character-based
         * support Unicode penuh
         * lebih “future-proof”
         *
         * Contoh penting
         * Kalau lu print:
         * pw.println("こんにちは");
         *
         * PrintWriter lebih aman untuk encoding
         *
         * ----------------------
         * 
         * Ini mindset penting:
         * System.out = buat belajar
         * PrintWriter = buat production
         *
         * Di dunia nyata:
         * PrintWriter sering dipakai di:
         * file writing
         * web response (servlet)
         * logging system
         *
         * --------------------------
         * 
         * KESIMPULAN SUPER SEDERHANA
         * 
         * PrintWriter = versi lebih proper dari System.out
         * berbasis character stream
         * lebih cocok untuk aplikasi nyata
         *
         * Inti penting:
         * auto flush bisa diatur
         * bisa print semua tipe data
         * lebih fleksibel & modern
         */
    }
}
