package ExploringJavaLang.AutoClosable;

/**
 * The AutoCloseable Interface
 *
 * AutoCloseable menyediakan dukungan untuk try-with-resources, 
 * yaitu fitur yang mengatur penutupan resource secara otomatis (Automatic Resource Management / ARM).
 *
 * Intinya:
 * Resource seperti:
 * file
 * stream
 * database connection
 *
 * akan otomatis ditutup ketika tidak lagi digunakan.
 * 
 * Syarat:
 * Hanya object dari class yang implement AutoCloseable
 * yang bisa dipakai di try-with-resources
 *
 * Method utama
 * void close() throws Exception
 * Penjelasan:
 * Menutup resource
 * Dipanggil otomatis di akhir try
 *
 * Masalah sebelum AutoCloseable
 * Dulu:
 * FileReader fr = new FileReader("file.txt");
 * // baca file
 * fr.close(); // HARUS manual
 *
 * Masalah:
 * Kalau error terjadi:
 * // close() bisa tidak terpanggil
 *
 * Resource leak (bahaya di backend)
 *
 * SOLUSI: TRY-WITH-RESOURCES
 * 
 * try (FileReader fr = new FileReader("file.txt")) {
 *     // baca file
 * }
 *
 * fr.close() dipanggil otomatis
 *
 * -------------------------------
 * 
 * PERBEDAAN Closeable vs AutoCloseable
 * AutoCloseable	            Closeable
 * throws Exception	            throws IOException
 * lebih general	            khusus I/O
 *
 * HAL PENTING
 * Jangan lupa:
 *
 * Kalau object:
 * pegang resource (file, DB, socket)
 *
 * WAJIB di-close
 *
 * Gunakan try-with-resources
 * Best practice modern
 *
 * Bisa multiple resource
 * 
 * try (
 *     FileReader fr = new FileReader("a.txt");
 *     BufferedReader br = new BufferedReader(fr)
 * ) {
 *     // code
 * }
 *
 * -------------------------------------------
 * 
 * USE CASE DI BACKEND
 * 
 * Dipakai di:
 * File handling
 * Database connection (JDBC)
 * HTTP connection
 * Stream processing
 *
 * Contoh real backend:
 * 
 * try (Connection conn = dataSource.getConnection()) {
 *     // query database
 * }
 *
 * KENAPA INI KRUSIAL
 *
 * Kalau tidak pakai ini:
 * Memory leak
 * Connection leak
 * Server crash
 *
 * KESIMPULAN
 * Inti:
 * AutoCloseable = resource bisa ditutup otomatis
 * Method utama:
 * close()
 *
 * Digunakan di:
 * try-with-resources
 *
 * --------------------
 * 
 * Insight penting:
 * Ini wajib di backend
 * Bikin code:
 * aman
 * clean
 * profesional
 */

import java.io.*;

// CONTOH CUSTOM AUTOCLOSABLE
class MyResource implements AutoCloseable {

    public void doSomething() {
        System.out.println("Sedang menggunakan Resource!");
    }

    // Override methode close dari AutoClosable
    @Override
    public void close() throws Exception {
        System.out.println("ResoUrce close automatic!");
    }
}

public class AutoClosablee {
    public static void main(String[] args) throws Exception { // Exception gak perlu IOException
        
        // CONTOH AutoClosable
        // try with-resource
        try (FileReader fileReader = new FileReader("data//Data3.txt")) {
            int ch;

            // MEMBACA FILE
            while ((ch = fileReader.read()) != -1) {
                System.out.print((char) ch);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // DISINI fileReader sudah otomatis close!        

        /**
         * CARA KERJA DI BELAKANG LAYAR
         *
         * Kode ini:
         * try (FileReader fr = ...)
         *
         * Sebenarnya jadi:
         * FileReader fr = ...;
         * 
         * try {
         *     // code
         * } finally {
         *     fr.close();
         * }
         *
         * Insight penting
         * Java otomatis generate finally
         */

        System.out.println();

        try (MyResource res = new MyResource()) {

            // PANGGIL METHOD
            res.doSomething();

        } // METHOD close() otomatis dipanggil di sini

        /**
         * OUTPUT
         * Sedang menggunakan resource
         * Resource ditutup otomatis
         */
    }
}
