package FundamentalJava.InputOutputIO;

/**
 * The PrintWriter Class
 *
 * Walaupun:
 * System.out.println()
 *
 * itu boleh dipakai…
 * tapi biasanya:
 *
 * lebih cocok untuk:
 * debugging
 * contoh program
 *
 * Untuk real-world
 * Disarankan pakai:
 * PrintWriter
 *
 * karena:
 * dia character-based
 * lebih mudah untuk:
 * internationalization (Unicode, berbagai bahasa)
 *
 * Perbedaan besar
 * System.out	        PrintWriter
 * byte stream	        character stream
 * simpel	            lebih proper
 * basic	            lebih fleksibel
 *
 * Constructor utama
 * PrintWriter(OutputStream outputStream, boolean flushingOn)
 *
 * --------------------------------------
 * 
 * Penjelasan
 * 
 * 1. outputStream
 * tujuan output (contoh: System.out)
 *
 * flushingOn
 * apakah auto flush?
 * Nilai	    Arti
 * true	        otomatis flush
 * false	    harus manual
 *
 * Kalau: true
 * gak perlu \n atau flush() manual
 *
 * ------------------------------------
 * 
 * CARA BUAT PrintWriter
 * PrintWriter pw = new PrintWriter(System.out, true);
 *
 * artinya:
 * output ke console
 * auto flush aktif
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
         * Aspek	        PrintStream (System.out)	        PrintWriter
         * Tipe	            byte stream	                        character stream
         * Encoding 	    terbatas	                        lebih fleksibel
         * International	kurang cocok	                    lebih cocok
         * Real-world	    jarang	                            lebih disarankan
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
