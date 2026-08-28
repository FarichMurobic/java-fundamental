package FundamentalJava.InputOutputIO.ReadingAndWritingFile;

/**
 * ================================================================
 * TRY-WITH-RESOURCES - AUTOMATIC RESOURCE MANAGEMENT (ARM)
 * ================================================================
 * 
 * Sejak Java 7, Java memperkenalkan fitur Automatic Resource
 * Management (ARM) atau try-with-resources untuk menangani
 * resource seperti file, stream, database connection, dan network.
 * 
 * -----------------------------------------------------------------
 * 1. KONSEP DASAR - MANUAL CLOSE VS AUTOMATIC CLOSE
 * -----------------------------------------------------------------
 * 
 * CARA LAMA (SEBELUM JAVA 7) - Manual close:
 * 
 * FileInputStream fin = null;
 * try {
 *     fin = new FileInputStream("test.txt");
 *     // Proses file
 * } catch (IOException e) {
 *     e.printStackTrace();
 * } finally {
 *     if (fin != null) {
 *         try {
 *             fin.close(); // HARUS manual!
 *         } catch (IOException e) {
 *             e.printStackTrace();
 *         }
 *     }
 * }
 * 
 * MASALAH:
 * 1. Kode panjang dan berantakan
 * 2. Mudah lupa panggil close()
 * 3. Resource leak jika exception terjadi
 * 4. Kode repetitive (boilerplate)
 * 
 * 
 * CARA BARU (JAVA 7+) - Automatic close:
 * 
 * try (FileInputStream fin = new FileInputStream("test.txt")) {
 *     // Proses file
 * } catch (IOException e) {
 *     e.printStackTrace();
 * }
 * // File otomatis ditutup setelah keluar dari try
 * 
 * KEUNTUNGAN:
 * 1. Kode lebih pendek dan bersih
 * 2. Tidak mungkin lupa close
 * 3. Otomatis handle exception
 * 4. Resource leak tercegah
 * 
 * -----------------------------------------------------------------
 * 2. BENTUK DASAR - SYNTAX
 * -----------------------------------------------------------------
 * 
 * try (resource-specification) {
 *     // Gunakan resource
 * } catch (ExceptionType e) {
 *     // Handle exception
 * }
 * 
 * 
 * Contoh dengan multiple resources:
 * 
 * try (
 *     FileInputStream fin = new FileInputStream("input.txt");
 *     FileOutputStream fout = new FileOutputStream("output.txt")
 * ) {
 *     // Baca dari fin, tulis ke fout
 *     int data;
 *     while ((data = fin.read()) != -1) {
 *         fout.write(data);
 *     }
 * } catch (IOException e) {
 *     e.printStackTrace();
 * }
 * // Kedua file otomatis ditutup (urutan reverse dari deklarasi)
 * 
 * -----------------------------------------------------------------
 * 3. SYARAT - OBJECT HARUS IMPLEMENT AutoCloseable
 * -----------------------------------------------------------------
 * 
 * Try-with-resources hanya bisa digunakan untuk object yang
 * mengimplementasikan interface AutoCloseable (Java 7+) atau
 * Closeable (Java 5+, turunan dari AutoCloseable).
 * 
 * // AutoCloseable interface
 * public interface AutoCloseable {
 *     void close() throws Exception;
 * }
 * 
 * 
 * Class yang mengimplementasikan AutoCloseable:
 * - Semua stream I/O (FileInputStream, FileOutputStream, dll)
 * - Reader/Writer (FileReader, BufferedReader, dll)
 * - Database Connection (Connection, Statement, ResultSet)
 * - Socket, ServerSocket
 * - Dan banyak lagi
 * 
 * 
 * // Contoh dengan custom class:
 * class MyResource implements AutoCloseable {
 *     public void doWork() {
 *         System.out.println("Working...");
 *     }
 *     
 *     @Override
 *     public void close() {
 *         System.out.println("Resource closed!");
 *     }
 * }
 * 
 * public class CustomResourceDemo {
 *     public static void main(String[] args) {
 *         try (MyResource resource = new MyResource()) {
 *             resource.doWork();
 *         } // Otomatis panggil close()
 *     }
 * }
 * 
 * Output:
 * Working...
 * Resource closed!
 * 
 * -----------------------------------------------------------------
 * 4. SUPPRESSED EXCEPTIONS - ERROR YANG "DITELAN"
 * -----------------------------------------------------------------
 * 
 * MASALAH DENGAN CARA LAMA:
 * 
 * // Cara lama: exception pertama hilang
 * try {
 *     // Error di sini
 * } finally {
 *     // Error di sini juga
 *     fin.close(); // Exception di sini menimpa exception sebelumnya
 * }
 * // Exception pertama HILANG!
 * 
 * 
 * TRY-WITH-RESOURCES SOLUSI:
 * 
 * try (FileInputStream fin = new FileInputStream("test.txt")) {
 *     // Error di dalam try
 *     int data = fin.read(); // Mungkin throw exception
 * } catch (IOException e) {
 *     // Exception dari try
 *     System.out.println("Main exception: " + e);
 *     
 *     // Exception dari close() disimpan sebagai suppressed
 *     Throwable[] suppressed = e.getSuppressed();
 *     for (Throwable t : suppressed) {
 *         System.out.println("Suppressed: " + t);
 *     }
 * }
 * 
 * 
 // Contoh lengkap suppressed exception:

 * import java.io.*;
 * 
 * class CustomResource implements AutoCloseable {
 *     public void doWork() throws IOException {
 *         throw new IOException("Error in doWork");
 *     }
 *     
 *     @Override
 *     public void close() throws IOException {
 *         throw new IOException("Error in close");
 *     }
 * }
 * 
 * public class SuppressedDemo {
 *     public static void main(String[] args) {
 *         try (CustomResource resource = new CustomResource()) {
 *             resource.doWork(); // Exception pertama
 *         } catch (IOException e) {
 *             // Exception utama (dari doWork)
 *             System.out.println("Main: " + e.getMessage());
 *             
 *             // Exception dari close (disimpan)
 *             Throwable[] suppressed = e.getSuppressed();
 *             for (Throwable t : suppressed) {
 *                 System.out.println("Suppressed: " + t.getMessage());
 *             }
 *         }
 *     }
 * }
 * 
 * Output:
 * Main: Error in doWork
 * Suppressed: Error in close
 * 
 * -----------------------------------------------------------------
 * 5. PERBANDINGAN - CARA LAMA VS CARA BARU
 * -----------------------------------------------------------------
 * 
 * | Aspek              | Cara Lama (Manual)          | Cara Baru (try-with-resources) |
 * |--------------------|-----------------------------|--------------------------------|
 * | Syntax             | Panjang, berantakan         | Pendek, bersih                 |
 * | Risiko lupa close  | Tinggi                      | Tidak ada (otomatis)           |
 * | Exception handling | Rumit (nested try-catch)    | Sederhana                      |
 * | Suppressed exception| Tidak ada support          | Didukung penuh                 |
 * | Code readability   | Buruk                       | Baik                           |
 * | Standard modern    | Tidak                       | Ya (Java 7+)                   |
 * 
 * -----------------------------------------------------------------
 * 6. CONTOH LENGKAP - FILE COPY DENGAN TRY-WITH-RESOURCES
 * -----------------------------------------------------------------
 * 
 * import java.io.*;
 * 
 * public class TryWithResourcesDemo {
 *     public static void main(String[] args) {
 *         // Contoh 1: Satu resource
 *         try (BufferedReader reader = new BufferedReader(
 *                 new FileReader("input.txt"))) {
 *             String line;
 *             while ((line = reader.readLine()) != null) {
 *                 System.out.println(line);
 *             }
 *         } catch (FileNotFoundException e) {
 *             System.out.println("File tidak ditemukan: " + e.getMessage());
 *         } catch (IOException e) {
 *             System.out.println("Error membaca file: " + e.getMessage());
 *         }
 * 
 *         // Contoh 2: Multiple resources (file copy)
 *         String sourceFile = "source.txt";
 *         String destFile = "dest.txt";
 * 
 *         try (
 *             FileInputStream fin = new FileInputStream(sourceFile);
 *             FileOutputStream fout = new FileOutputStream(destFile)
 *         ) {
 *             byte[] buffer = new byte[1024];
 *             int bytesRead;
 *             
 *             while ((bytesRead = fin.read(buffer)) != -1) {
 *                 fout.write(buffer, 0, bytesRead);
 *             }
 *             
 *             System.out.println("File berhasil di-copy!");
 *         } catch (FileNotFoundException e) {
 *             System.out.println("File tidak ditemukan: " + e.getMessage());
 *         } catch (IOException e) {
 *             System.out.println("Error I/O: " + e.getMessage());
 *         }
 *         
 *         // Contoh 3: Resource dengan close order
 *         // Resource ditutup dalam urutan REVERSE dari deklarasi
 *         try (
 *             FileInputStream fin = new FileInputStream("a.txt");  // Ditutup kedua
 *             FileOutputStream fout = new FileOutputStream("b.txt") // Ditutup pertama
 *         ) {
 *             // Proses file
 *         }
 *     }
 * }
 * 
 * -----------------------------------------------------------------
 * 7. KAPAN MENGGUNAKAN TRY-WITH-RESOURCES
 * -----------------------------------------------------------------
 * 
 * WAJIB PAKAI TRY-WITH-RESOURCES untuk:
 * 
 * 1. File I/O
 *    - FileInputStream, FileOutputStream
 *    - FileReader, FileWriter
 *    - BufferedReader, BufferedWriter
 * 
 * 2. Network
 *    - Socket, ServerSocket
 *    - URLConnection, HttpURLConnection
 * 
 * 3. Database
 *    - Connection, Statement, PreparedStatement
 *    - ResultSet
 * 
 * 4. Stream lainnya
 *    - Semua subclass dari InputStream/OutputStream
 *    - Semua subclass dari Reader/Writer
 * 
 * 5. Custom resource
 *    - Class yang implement AutoCloseable
 * 
 * 
 * TIDAK BISA DIGUNAKAN jika:
 * 
 * 1. Object tidak implement AutoCloseable atau Closeable
 *    - Tidak semua class bisa ditutup otomatis
 * 
 * 2. Java versi < 7
 *    - Gunakan try-catch-finally manual
 * 
 * -----------------------------------------------------------------
 * 8. BEST PRACTICES - TIPS DUNIA NYATA
 * -----------------------------------------------------------------
 * 
 * 1. Deklarasikan multiple resources dalam satu try
 *    // BAIK
 *    try (Reader r = new FileReader("a.txt");
 *         Writer w = new FileWriter("b.txt")) {
 *        // ...
 *    }
 * 
 *    // BURUK (bikin nested try)
 *    try (Reader r = new FileReader("a.txt")) {
 *        try (Writer w = new FileWriter("b.txt")) {
 *            // ...
 *        }
 *    }
 * 
 * 2. Gunakan resource yang sudah ada
 *    // BISA
 *    BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
 *    try (reader) {
 *        // Pakai reader
 *    }
 *    // reader otomatis ditutup
 * 
 * 3. Jangan deklarasikan resource di luar try jika tidak perlu
 *    // BURUK
 *    BufferedReader reader = null;
 *    try {
 *        reader = new BufferedReader(new FileReader("file.txt"));
 *        // ...
 *    } finally {
 *        if (reader != null) reader.close();
 *    }
 * 
 *    // BAIK
 *    try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
 *        // ...
 *    }
 * 
 * 4. Handle exception dengan tepat
 *    try (FileInputStream fin = new FileInputStream("file.txt")) {
 *        // Proses file
 *    } catch (FileNotFoundException e) {
 *        // File tidak ada
 *        System.out.println("File not found!");
 *    } catch (IOException e) {
 *        // Error I/O lainnya
 *        System.out.println("I/O error!");
 *    }
 * 
 * 5. Gunakan getSuppressed() untuk debugging
 *    try (MyResource resource = new MyResource()) {
 *        resource.doWork();
 *    } catch (Exception e) {
 *        System.out.println("Main: " + e);
 *        for (Throwable t : e.getSuppressed()) {
 *            System.out.println("Suppressed: " + t);
 *        }
 *    }
 * 
 * -----------------------------------------------------------------
 * 9. PERFORMANCE INSIGHT - LEVEL UP
 * -----------------------------------------------------------------
 * 
 * Try-with-resources memiliki overhead yang sangat kecil:
 * 
 * 1. Compiler mengubah try-with-resources menjadi try-catch-finally
 *    - Tidak ada runtime overhead signifikan
 * 
 * 2. Close dipanggil secara otomatis di finally block
 *    - Sama seperti manual close
 * 
 * 3. Suppressed exceptions disimpan dalam array
 *    - Overhead kecil, hanya jika exception terjadi
 * 
 * 4. Multiple resources ditutup dalam urutan reverse
 *    - Memastikan dependency terpenuhi
 * 
 * 
 * KESIMPULAN PERFORMANCE:
 * - Try-with-resources ≈ Manual try-catch-finally
 * - Tidak ada penalti performa berarti
 * - Digunakan di production code secara luas
 * 
 * -----------------------------------------------------------------
 * 10. CONTOH DENGAN DATABASE CONNECTION
 * -----------------------------------------------------------------
 * 
 * import java.sql.*;
 * 
 * public class DatabaseTryWithResourcesDemo {
 *     public static void main(String[] args) {
 *         String url = "jdbc:mysql://localhost:3306/mydb";
 *         String user = "root";
 *         String password = "password";
 *         
 *         // Multiple resources: Connection, Statement, ResultSet
 *         try (Connection conn = DriverManager.getConnection(url, user, password);
 *              Statement stmt = conn.createStatement();
 *              ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {
 *             
 *             while (rs.next()) {
 *                 System.out.println("ID: " + rs.getInt("id"));
 *                 System.out.println("Name: " + rs.getString("name"));
 *             }
 *             
 *         } catch (SQLException e) {
 *             System.out.println("Database error: " + e.getMessage());
 *             
 *             // Cek suppressed exceptions
 *             for (Throwable t : e.getSuppressed()) {
 *                 System.out.println("Suppressed: " + t.getMessage());
 *             }
 *         }
 *         // Semua resource (ResultSet, Statement, Connection) otomatis ditutup!
 *         // Urutan close: ResultSet → Statement → Connection
 *     }
 * }
 * 
 * -----------------------------------------------------------------
 * 11. SUPPRESSED EXCEPTIONS - PENJELASAN DETAIL
 * -----------------------------------------------------------------
 * 
 * KONSEP SUPPRESSED EXCEPTIONS:
 * 
 * // Scenario:
 * try (Resource r = new Resource()) {
 *     // EXCEPTION A terjadi di sini
 * } catch (Exception e) {
 *     // e = EXCEPTION A
 *     // EXCEPTION B dari close() disimpan di e
 * }
 * 
 * 
 * Kenapa ini penting?
 * 
 * // Cara lama (sebelum Java 7):
 * Exception pertama hilang!
 * 
 * try {
 *     // EXCEPTION A
 * } finally {
 *     resource.close(); // EXCEPTION B
 *     // EXCEPTION A hilang, hanya EXCEPTION B yang terlihat
 * }
 * 
 * 
 * // Cara baru (try-with-resources):
 * Kedua exception tersimpan!
 * 
 * try (Resource r = new Resource()) {
 *     // EXCEPTION A
 * } catch (Exception e) {
 *     // e = EXCEPTION A (exception utama)
 *     // e.getSuppressed() = EXCEPTION B (dari close)
 * }
 * 
 * 
 * Cara mengakses suppressed exception:
 * 
 * catch (Exception e) {
 *     System.out.println("Main: " + e.getMessage());
 *     
 *     Throwable[] suppressed = e.getSuppressed();
 *     if (suppressed.length > 0) {
 *         System.out.println("Suppressed exceptions:");
 *         for (Throwable t : suppressed) {
 *             System.out.println("  - " + t.getMessage());
 *         }
 *     }
 * }
 * 
 * -----------------------------------------------------------------
 * 12. CATATAN JAVA MODERN (17+)
 * -----------------------------------------------------------------
 * 
 * 1. Try-with-resources tetap sama di Java 17+
 *    - Tidak ada perubahan signifikan
 * 
 * 2. Java 9+ mendukung resource yang sudah dideklarasi
 *    // Java 7: hanya deklarasi di dalam try
 *    try (FileReader fr = new FileReader("file.txt")) { }
 * 
 *    // Java 9+: bisa pakai resource yang sudah ada
 *    FileReader fr = new FileReader("file.txt");
 *    try (fr) { // fr harus effectively final
 *        // ...
 *    }
 * 
 * 3. Interface AutoCloseable memiliki method close() yang
 *    throws Exception (generik)
 * 
 * 4. Interface Closeable (turunan AutoCloseable) memiliki
 *    method close() yang throws IOException (spesifik)
 * 
 * 5. Best practice: gunakan Closeable jika bisa,
 *    karena lebih spesifik untuk I/O
 * 
 * ================================================================
 * KESIMPULAN - VERSI PADAT
 * ================================================================
 * 
 * 1. Try-with-resources = auto close resource setelah selesai
 * 2. Pengganti manual close() di finally block
 * 3. Hanya untuk class yang implement AutoCloseable
 * 4. Syntax: try (resource-declaration) { ... }
 * 5. Multiple resources: pisahkan dengan titik koma (;)
 * 6. Resource ditutup dalam urutan REVERSE dari deklarasi
 * 7. Suppressed exceptions: exception dari close() disimpan
 * 8. Gunakan getSuppressed() untuk akses exception yang ditelan
 * 9. Wajib untuk: File I/O, Stream, Database, Network
 * 10. Standard modern Java (Java 7+)
 * 
 * ================================================================
 * INTI PALING DALAM
 * ================================================================
 * 
 * Try-with-resources adalah salah satu fitur paling praktis
 * yang diperkenalkan Java 7, yang secara drastis mengurangi
 * boilerplate code dan menghilangkan resource leak.
 * 
 * Ini adalah contoh sempurna bagaimana Java terus berevolusi
 * untuk membuat kode lebih aman, lebih bersih, dan lebih mudah
 * dipelihara.
 * 
 * ================================================================
 * REKOMENDASI DUNIA NYATA
 * ================================================================
 * 
 * 1. UNTUK CODE BARU:
 *    - WAJIB pakai try-with-resources untuk semua resource
 *    - Tidak ada alasan untuk pakai cara lama
 * 
 * 2. UNTUK LEGACY CODE:
 *    - Pahami cara lama (bisa ditemui di codebase lama)
 *    - Refactor ke try-with-resources jika memungkinkan
 * 
 * 3. UNTUK CUSTOM CLASS:
 *    - Implementasikan AutoCloseable
 *    - Definisikan logic close() dengan benar
 * 
 * 4. UNTUK EXCEPTION:
 *    - Selalu cek getSuppressed() untuk debugging
 *    - Jangan abaikan exception dari close()
 * 
 * ================================================================
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
         * // baca file
         * } finally {
         * fin.close();
         * }
         *
         * Cara baru:
         * try(FileInputStream fin = new FileInputStream("test.txt")) {
         * // baca file
         * }
         *
         * Lebih:
         * pendek
         * aman
         * modern
         */
    }
}
