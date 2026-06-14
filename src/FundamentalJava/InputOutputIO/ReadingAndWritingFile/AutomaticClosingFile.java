package FundamentalJava.InputOutputIO.ReadingAndWritingFile;

/**
 * KONSEP UTAMA: AUTOMATICALLY CLOSING FILE
 *
 * Di bagian sebelumnya, file ditutup secara manual menggunakan close(). 
 * Itu adalah cara lama sebelum Java versi JDK 7.
 * 
 * Sekarang, Java punya fitur baru:
 * Automatic Resource Management (ARM)
 *
 * Fitur ini:
 * otomatis menutup file
 * mencegah lupa close()
 * menghindari memory leak
 *
 * Dulu:
 * fin.close();
 * kalau lupa → masalah
 *
 * Sekarang:
 * try (...) { }
 * otomatis ditutup
 *
 * ---------------------------------------
 * 
 * BENTUK DASAR (WAJIB PAHAM)
 * try (resource-specification) {
 *    // pakai resource
 * }
 *
 * Artinya:
 * try (FileInputStream fin = new FileInputStream("test.txt")) {
 *     // pakai file
 * }
 *
 * setelah keluar dari try
 * file otomatis di-close
 *
 * --------------------
 * 
 * KELEBIHAN BESAR
 * 1. Gak bisa lupa close
 * 2. Lebih pendek
 * 3. Lebih aman
 * 4. Standard modern Java
 *
 * HAL PENTING (ADVANCED)
 * Exception tambahan
 *
 * Kalau:
 * error di dalam try
 * lalu error juga saat close
 *
 * cara lama:
 * error pertama hilang
 *
 * try-with-resources:
 * error kedua disimpan (suppressed)
 *
 * bisa diambil pakai:
 * getSuppressed()
 *
 * ---------------------
 * 
 * KAPAN PAKAI INI?
 * 
 * WAJIB:
 * file
 * stream
 * database connection
 * network
 *
 * TIDAK BISA:
 * kalau object tidak implement:
 * AutoCloseable
 *
 * KESIMPULAN BESAR
 * INTI PALING PENTING:
 * dulu: manual close()
 * sekarang: otomatis pakai try-with-resources
 *
 * REKOMENDASI DUNIA NYATA:
 * Pakai try-with-resources untuk code baru
 * Tapi tetap pahami cara lama (legacy code)
 */

import java.io.*;

public class AutomaticClosingFile {
    public static void main(String[] args) {
        
        int i;
        
        // CEK ARGUMEN
        if (args.length != 1) {
            System.out.println("Usage: showfile filename...");
            return;
        } 

        // CARA MODERN CLOSING AUTOMATIC
        // PAKAI TRY WITH RESOURCES
        try (FileInputStream fin = new FileInputStream(args[0])) {
            do {
                // BACA FILE
                i = fin.read();

                if (i != -1)
                    System.out.print((char) i);
            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.out.println("File not Found...");
        } catch (IOException e) {
            System.out.println("An I/O Error Ocurred.");
        }

        /**
         * PENJELASAN DALAM
         * 
         * bagian penting:
         * try(FileInputStream fin = new FileInputStream(args[0]))
         *
         * ini artinya:
         * buka file
         * daftarkan sebagai resource
         * Java akan auto close
         *
         * scope:
         * fin
         * hanya hidup di dalam try
         *
         * final otomatis:
         * fin gak bisa diubah lagi
         *
         * --------------------------------
         * 
         * PERBANDINGAN LAMA VS BARU
         * 
         * Cara lama:
         * FileInputStream fin = new FileInputStream("test.txt");
         *
         * try {
         *    // baca file
         * } finally {
         *    fin.close();
         * }
         *
         * Cara baru:
         * try(FileInputStream fin = new FileInputStream("test.txt")) {
         *    // baca file
         * }
         *
         * Lebih:
         * pendek
         * aman
         * modern
         */
    }
}
