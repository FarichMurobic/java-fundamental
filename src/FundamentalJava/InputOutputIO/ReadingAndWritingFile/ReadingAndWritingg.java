package FundamentalJava.InputOutputIO.ReadingAndWritingFile;

/**
 * ================================================================
 * READING AND WRITING FILES - DASAR-DASAR I/O
 * ================================================================
 * 
 * Java menyediakan banyak class dan method untuk operasi
 * membaca dan menulis file. Topik ini sangat luas dan
 * dibahas lebih detail di bagian lain.
 * 
 * Di sini kita fokus pada dasar-dasar menggunakan byte stream:
 * FileInputStream dan FileOutputStream.
 * 
 * -----------------------------------------------------------------
 * 1. DUA CLASS UTAMA - FILEINPUTSTREAM & FILEOUTPUTSTREAM
 * -----------------------------------------------------------------
 * 
 * FileInputStream  : Membaca data dari file (byte-oriented)
 * FileOutputStream : Menulis data ke file (byte-oriented)
 * 
 * 
 * // Membuka file untuk dibaca
 * FileInputStream fin = new FileInputStream("input.txt");
 * 
 * // Membuka file untuk ditulis
 * FileOutputStream fout = new FileOutputStream("output.txt");
 * 
 * 
 * CONSTRUCTOR:
 * 
 * FileInputStream(String fileName)
 * - Membuka file dengan nama fileName untuk dibaca
 * - FileNotFoundException jika file tidak ditemukan
 * 
 * FileOutputStream(String fileName)
 * - Membuka file dengan nama fileName untuk ditulis
 * - Jika file tidak ada → dibuat baru
 * - Jika file sudah ada → isinya ditimpa (OVERWRITE)
 * 
 * -----------------------------------------------------------------
 * 2. EXCEPTION - FILE NOT FOUND
 * -----------------------------------------------------------------
 * 
 * FileNotFoundException adalah turunan dari IOException.
 * 
 * // FileNotFoundException terjadi jika:
 * // 1. File tidak ditemukan (untuk membaca)
 * // 2. Path tidak valid
 * // 3. Izin akses tidak cukup
 * 
 * try {
 *     FileInputStream fin = new FileInputStream("tidak_ada.txt");
 * } catch (FileNotFoundException e) {
 *     System.out.println("File tidak ditemukan: " + e.getMessage());
 * }
 * 
 * 
 * HIERARCHY EXCEPTION:
 * 
 * Throwable
 *   └── Exception
 *         └── IOException
 *               ├── FileNotFoundException  ← turunan dari IOException
 *               ├── EOFException
 *               └── ... (dan lainnya)
 * 
 * 
 * Kenapa ini penting?
 * Karena catch (IOException e) akan menangkap semua turunannya,
 * termasuk FileNotFoundException.
 * 
 * // Bisa ditangkap spesifik
 * try {
 *     FileInputStream fin = new FileInputStream("file.txt");
 * } catch (FileNotFoundException e) {
 *     // Handle file not found
 * } catch (IOException e) {
 *     // Handle I/O error lainnya
 * }
 * 
 * // Atau langsung tangkap IOException
 * try {
 *     FileInputStream fin = new FileInputStream("file.txt");
 * } catch (IOException e) {
 *     // Handle semua error I/O
 * }
 * 
 * -----------------------------------------------------------------
 * 3. MEMBACA FILE - FILEINPUTSTREAM
 * -----------------------------------------------------------------
 * 
 * Method utama untuk membaca:
 * 
 * int read()
 * - Membaca satu byte dari file
 * - Return: byte yang dibaca (0-255) atau -1 jika EOF (End of File)
 * - Throws: IOException
 * 
 * int read(byte[] buffer)
 * - Membaca byte ke dalam array buffer
 * - Return: jumlah byte yang berhasil dibaca
 * - Return -1 jika EOF
 * 
 * 
 * CONTOH 1: Membaca file byte per byte (cara sederhana):
 * 
 * import java.io.*;
 * 
 * public class ReadFileDemo {
 *     public static void main(String[] args) {
 *         FileInputStream fin = null;
 *         
 *         try {
 *             fin = new FileInputStream("test.txt");
 *             int data;
 *             
 *             // Baca satu per satu sampai akhir file
 *             while ((data = fin.read()) != -1) {
 *                 System.out.print((char) data);
 *             }
 *             
 *         } catch (FileNotFoundException e) {
 *             System.out.println("File tidak ditemukan: " + e.getMessage());
 *         } catch (IOException e) {
 *             System.out.println("Error membaca file: " + e.getMessage());
 *         } finally {
 *             try {
 *                 if (fin != null) {
 *                     fin.close(); // WAJIB: tutup file!
 *                 }
 *             } catch (IOException e) {
 *                 System.out.println("Error menutup file: " + e.getMessage());
 *             }
 *         }
 *     }
 * }
 * 
 * 
 * CONTOH 2: Membaca file dengan buffer (lebih cepat):
 * 
 * import java.io.*;
 * 
 * public class ReadFileBufferDemo {
 *     public static void main(String[] args) {
 *         FileInputStream fin = null;
 *         
 *         try {
 *             fin = new FileInputStream("test.txt");
 *             byte[] buffer = new byte[1024]; // Buffer 1KB
 *             int bytesRead;
 *             
 *             while ((bytesRead = fin.read(buffer)) != -1) {
 *                 // Proses bytes yang terbaca
 *                 System.out.write(buffer, 0, bytesRead);
 *             }
 *             
 *         } catch (FileNotFoundException e) {
 *             System.out.println("File tidak ditemukan: " + e.getMessage());
 *         } catch (IOException e) {
 *             System.out.println("Error membaca file: " + e.getMessage());
 *         } finally {
 *             try {
 *                 if (fin != null) {
 *                     fin.close();
 *                 }
 *             } catch (IOException e) {
 *                 System.out.println("Error menutup file: " + e.getMessage());
 *             }
 *         }
 *     }
 * }
 * 
 * -----------------------------------------------------------------
 * 4. MENULIS FILE - FILEOUTPUTSTREAM
 * -----------------------------------------------------------------
 * 
 * Method utama untuk menulis:
 * 
 * void write(int b)
 * - Menulis satu byte ke file
 * - Throws: IOException
 * 
 * void write(byte[] buffer)
 * - Menulis seluruh array byte ke file
 * 
 * void write(byte[] buffer, int offset, int length)
 * - Menulis sebagian array byte (dari offset sepanjang length)
 * 
 * 
 * CONTOH 1: Menulis byte per byte:
 * 
 * import java.io.*;
 * 
 * public class WriteFileDemo {
 *     public static void main(String[] args) {
 *         FileOutputStream fout = null;
 *         
 *         try {
 *             fout = new FileOutputStream("output.txt");
 *             
 *             // Tulis string sebagai byte
 *             String data = "Hello, World!";
 *             for (int i = 0; i < data.length(); i++) {
 *                 fout.write(data.charAt(i)); // Write satu byte
 *             }
 *             
 *             System.out.println("File berhasil ditulis!");
 *             
 *         } catch (IOException e) {
 *             System.out.println("Error menulis file: " + e.getMessage());
 *         } finally {
 *             try {
 *                 if (fout != null) {
 *                     fout.close(); // WAJIB: tutup file!
 *                 }
 *             } catch (IOException e) {
 *                 System.out.println("Error menutup file: " + e.getMessage());
 *             }
 *         }
 *     }
 * }
 * 
 * 
 * CONTOH 2: Menulis dengan buffer (lebih cepat):
 * 
 * import java.io.*;
 * 
 * public class WriteFileBufferDemo {
 *     public static void main(String[] args) {
 *         FileOutputStream fout = null;
 *         
 *         try {
 *             fout = new FileOutputStream("output.txt");
 *             
 *             // Data yang akan ditulis
 *             String data = """
 *                 Baris 1: Hello
 *                 Baris 2: World
 *                 Baris 3: Java Programming
 *                 """;
 *             
 *             // Konversi ke byte array dan tulis
 *             byte[] buffer = data.getBytes();
 *             fout.write(buffer);
 *             
 *             System.out.println("File berhasil ditulis!");
 *             
 *         } catch (IOException e) {
 *             System.out.println("Error menulis file: " + e.getMessage());
 *         } finally {
 *             try {
 *                 if (fout != null) {
 *                     fout.close();
 *                 }
 *             } catch (IOException e) {
 *                 System.out.println("Error menutup file: " + e.getMessage());
 *             }
 *         }
 *     }
 * }
 * 
 * -----------------------------------------------------------------
 * 5. OVERWRITE - PERILAKU FILEOUTPUTSTREAM
 * -----------------------------------------------------------------
 * 
 * PENTING: FileOutputStream dengan satu parameter akan
 * MENIMPA (overwrite) isi file yang sudah ada.
 * 
 * // File "data.txt" berisi "Old content"
 * FileOutputStream fout = new FileOutputStream("data.txt");
 * fout.write("New content".getBytes());
 * // "data.txt" sekarang berisi "New content" (lama hilang!)
 * 
 * 
 * UNTUK APPEND (tambah di akhir), gunakan constructor dua parameter:
 * 
 * FileOutputStream(String fileName, boolean append)
 * 
 * // append = true → tambah di akhir
 * FileOutputStream fout = new FileOutputStream("data.txt", true);
 * fout.write("Appended content".getBytes());
 * // Isi file menjadi: "Old contentAppended content"
 * 
 * 
 * PERBANDINGAN:
 * 
 * | Constructor                          | Perilaku                     |
 * |--------------------------------------|------------------------------|
 * | FileOutputStream("file.txt")         | Overwrite (timpa)            |
 * | FileOutputStream("file.txt", false)  | Overwrite (timpa)            |
 * | FileOutputStream("file.txt", true)   | Append (tambah di akhir)     |
 * 
 * -----------------------------------------------------------------
 * 6. WAJIB: CLOSE() - MENUTUP FILE
 * -----------------------------------------------------------------
 * 
 * Setelah selesai menggunakan file, WAJIB memanggil close().
 * 
 * Kenapa WAJIB?
 * 
 * 1. Membebaskan resource system (file handle)
 * 2. Mencegah memory leak
 * 3. Memastikan data benar-benar tertulis ke disk (flush)
 * 4. Mencegah file lock yang berlebihan
 * 
 * 
 * KALAU LUPA CLOSE:
 * 
 * // ❌ BURUK - lupa close
 * FileInputStream fin = new FileInputStream("test.txt");
 * // Baca file...
 * // Tidak ada fin.close()!
 * // Resource tidak dibebaskan!
 * 
 * // Masalah yang terjadi:
 * // 1. File handle tetap terbuka
 * // 2. Memory leak
 * // 3. Aplikasi bisa kehabisan file descriptor
 * // 4. Data mungkin tidak terflush ke disk (untuk output)
 * // 5. Error "Too many open files"
 * 
 * 
 * CARA CLOSE YANG AMAN:
 * 
 * // Cara 1: Manual di finally block
 * FileInputStream fin = null;
 * try {
 *     fin = new FileInputStream("test.txt");
 *     // Proses file...
 * } catch (IOException e) {
 *     e.printStackTrace();
 * } finally {
 *     if (fin != null) {
 *         try {
 *             fin.close();
 *         } catch (IOException e) {
 *             e.printStackTrace();
 *         }
 *     }
 * }
 * 
 * // Cara 2: Try-with-resources (JAVA 7+) - REKOMENDASI
 * try (FileInputStream fin = new FileInputStream("test.txt")) {
 *     // Proses file...
 *     // Otomatis ditutup!
 * } catch (IOException e) {
 *     e.printStackTrace();
 * }
 * 
 * -----------------------------------------------------------------
 * 7. PERBANDINGAN - BYTE STREAM VS CHARACTER STREAM
 * -----------------------------------------------------------------
 * 
 * | Aspek           | Byte Stream               | Character Stream          |
 * |-----------------|---------------------------|---------------------------|
 * | Class           | InputStream/OutputStream  | Reader/Writer             |
 * | Contoh          | FileInputStream           | FileReader                |
 * | Unit            | Byte (8-bit)              | Character (16-bit)        |
 * | Cocok untuk     | Binary files (gambar, dll)| Text files                |
 * | Encoding        | Tidak peduli encoding     | Menggunakan encoding      |
 * 
 * 
 * KAPAN PAKAI YANG MANA?
 * 
 * // Byte Stream untuk binary files
 * // - Gambar (JPG, PNG, GIF)
 * // - Audio (MP3, WAV)
 * // - Video (MP4, AVI)
 * // - File executable
 * FileInputStream fin = new FileInputStream("image.jpg");
 * 
 * // Character Stream untuk text files
 * // - File teks (.txt)
 * // - File konfigurasi
 * // - File source code
 * FileReader reader = new FileReader("document.txt");
 * 
 * 
 * CONTOH BYTE STREAM (FILEINPUTSTREAM):
 * // Baca dan tulis gambar (binary)
 * try (
 *     FileInputStream fin = new FileInputStream("input.jpg");
 *     FileOutputStream fout = new FileOutputStream("output.jpg")
 * ) {
 *     byte[] buffer = new byte[1024];
 *     int bytesRead;
 *     while ((bytesRead = fin.read(buffer)) != -1) {
 *         fout.write(buffer, 0, bytesRead);
 *     }
 *     System.out.println("Image copied successfully!");
 * }
 * 
 * 
 * CONTOH CHARACTER STREAM (FILEREADER):
 * // Baca dan tulis teks
 * try (
 *     FileReader reader = new FileReader("input.txt");
 *     FileWriter writer = new FileWriter("output.txt")
 * ) {
 *     char[] buffer = new char[1024];
 *     int charsRead;
 *     while ((charsRead = reader.read(buffer)) != -1) {
 *         writer.write(buffer, 0, charsRead);
 *     }
 *     System.out.println("Text copied successfully!");
 * }
 * 
 * -----------------------------------------------------------------
 * 8. CONTOH LENGKAP - COPY FILE
 * -----------------------------------------------------------------
 * 
 * import java.io.*;
 * 
 * public class FileCopyDemo {
 *     public static void main(String[] args) {
 *         // Cara 1: Manual try-catch-finally (cara lama)
 *         FileInputStream fin = null;
 *         FileOutputStream fout = null;
 *         
 *         try {
 *             fin = new FileInputStream("source.txt");
 *             fout = new FileOutputStream("dest.txt");
 *             
 *             byte[] buffer = new byte[1024];
 *             int bytesRead;
 *             
 *             while ((bytesRead = fin.read(buffer)) != -1) {
 *                 fout.write(buffer, 0, bytesRead);
 *             }
 *             
 *             System.out.println("File copied successfully!");
 *             
 *         } catch (FileNotFoundException e) {
 *             System.out.println("File not found: " + e.getMessage());
 *         } catch (IOException e) {
 *             System.out.println("I/O error: " + e.getMessage());
 *         } finally {
 *             // Close resources in reverse order
 *             try {
 *                 if (fout != null) fout.close();
 *             } catch (IOException e) {
 *                 System.out.println("Error closing output: " + e.getMessage());
 *             }
 *             
 *             try {
 *                 if (fin != null) fin.close();
 *             } catch (IOException e) {
 *                 System.out.println("Error closing input: " + e.getMessage());
 *             }
 *         }
 *     }
 * }
 * 
 * 
 * // Cara 2: Try-with-resources (cara modern - REKOMENDASI)
 * public class FileCopyModernDemo {
 *     public static void main(String[] args) {
 *         try (
 *             FileInputStream fin = new FileInputStream("source.txt");
 *             FileOutputStream fout = new FileOutputStream("dest.txt")
 *         ) {
 *             byte[] buffer = new byte[1024];
 *             int bytesRead;
 *             
 *             while ((bytesRead = fin.read(buffer)) != -1) {
 *                 fout.write(buffer, 0, bytesRead);
 *             }
 *             
 *             System.out.println("File copied successfully!");
 *             
 *         } catch (FileNotFoundException e) {
 *             System.out.println("File not found: " + e.getMessage());
 *         } catch (IOException e) {
 *             System.out.println("I/O error: " + e.getMessage());
 *         }
 *         // File otomatis ditutup!
 *     }
 * }
 * 
 * -----------------------------------------------------------------
 * 9. KENAPA BELAJAR CARA LAMA?
 * -----------------------------------------------------------------
 * 
 * Meskipun try-with-resources (Java 7+) adalah cara modern,
 * penting untuk memahami cara lama karena:
 * 
 * 1. LEGACY CODE
 *    - Banyak kode produksi masih menggunakan cara lama
 *    - Perusahaan besar dengan codebase lama
 *    - Maintenance kode yang sudah berjalan
 * 
 * 2. PEMAHAMAN DASAR
 *    - Memahami lifecycle resource
 *    - Memahami exception handling
 *    - Memahami pentingnya finally block
 * 
 * 3. FLEKSIBILITAS
 *    - Beberapa scenario tidak bisa pakai try-with-resources
 *    - Resource dengan logic close yang kompleks
 *    - Versi Java < 7
 * 
 * 4. INTERVIEW
 *    - Pertanyaan tentang I/O sering muncul
 *    - Pewawancara ingin melihat pemahaman dasar
 * 
 * -----------------------------------------------------------------
 * 10. BEST PRACTICES - TIPS DUNIA NYATA
 * -----------------------------------------------------------------
 * 
 * 1. SELALU close resource
 *    // BAIK
 *    try (Resource r = new Resource()) { ... }
 * 
 *    // BURUK
 *    // Tidak menutup resource sama sekali
 * 
 * 2. Gunakan buffer untuk performa
 *    // BAIK (buffer 1KB - 8KB)
 *    byte[] buffer = new byte[8192];
 * 
 *    // BURUK (baca per byte)
 *    int data;
 *    while ((data = fin.read()) != -1) { ... }
 * 
 * 3. Tutup resource di finally atau try-with-resources
 *    // BAIK
 *    try { ... } finally { if (r != null) r.close(); }
 * 
 *    // BURUK
 *    try { ... } // Tidak ada finally
 * 
 * 4. Tangkap exception dengan tepat
 *    // BAIK
 *    catch (FileNotFoundException e) { ... }
 *    catch (IOException e) { ... }
 * 
 *    // BURUK
 *    catch (Exception e) { ... } // Terlalu umum
 * 
 * 5. Gunakan try-with-resources jika memungkinkan (Java 7+)
 *    // BAIK (modern)
 *    try (Resource r = new Resource()) { ... }
 * 
 *    // TIDAK REKOMENDASI (kecuali Java < 7)
 *    // Manual finally block
 * 
 * ================================================================
 * KESIMPULAN - VERSI PADAT
 * ================================================================
 * 
 * 1. FileInputStream  = baca file (byte-oriented)
 * 2. FileOutputStream = tulis file (byte-oriented)
 * 3. FileNotFoundException = turunan dari IOException
 * 4. FileOutputStream secara default OVERWRITE file lama
 * 5. FileOutputStream("file.txt", true) = APPEND
 * 6. WAJIB close() untuk membebaskan resource
 * 7. Cara lama: manual close di finally block
 * 8. Cara modern: try-with-resources (Java 7+)
 * 9. Byte stream untuk binary files
 * 10. Character stream untuk text files
 * 
 * ================================================================
 * INTI PALING DALAM
 * ================================================================
 * 
 * Operasi file I/O adalah fondasi dari banyak aplikasi Java.
 * 
 * Memahami FileInputStream dan FileOutputStream adalah
 * langkah pertama untuk menguasai I/O di Java.
 * 
 * Meskipun ada cara modern (try-with-resources) dan cara
 * lama (manual close), kedua-duanya penting untuk dipahami
 * karena lo akan menemui keduanya di dunia nyata.
 * 
 * ================================================================
 * CATATAN JAVA MODERN (17+)
 * ================================================================
 * 
 * 1. FileInputStream dan FileOutputStream tetap sama di Java 17+
 * 
 * 2. NIO (New I/O) dan NIO.2 (Java 7+) menyediakan alternatif
 *    - Files.readAllBytes()
 *    - Files.write()
 *    - Path dan Files class
 * 
 * 3. Contoh dengan NIO.2 (lebih modern dan sederhana):
 *    import java.nio.file.*;
 * 
 *    // Baca semua bytes
 *    byte[] data = Files.readAllBytes(Path.of("file.txt"));
 * 
 *    // Tulis semua bytes
 *    Files.write(Path.of("output.txt"), data);
 * 
 *    // Copy file
 *    Files.copy(Path.of("source.txt"), Path.of("dest.txt"));
 * 
 * 4. Rekomendasi modern:
 *    - Gunakan NIO.2 (Files class) untuk operasi file sederhana
 *    - Gunakan FileInputStream/FileOutputStream untuk streaming
 *    - Gunakan try-with-resources di semua kasus
 * 
 * ================================================================
 */

/* Display a Data2 file.
   Cara pakai:
   java InputOutputIO.ReadingAndWritingFile.ReadingAndWritingg ../data/Data2.txt
*/

import java.io.*;

public class ReadingAndWritingg {
    public static void main(String[] args) {

        int i; // untuk menyimpan byte yang dibaca
        FileInputStream fileInputStream; // stream untuk membca file

        System.out.println("Masuk Program");

        // cek apakah user memasukan nama file
        if (args.length != 1) {
            System.out.println("Usage: showfile Data2.txt");
            return;
        }

        // DEBUG
        System.out.println("Mau buka file");

        File file = new File(args[0]);

        System.out.println("Path: " + args[0]);
        System.out.println("Absolute: " + file.getAbsolutePath());
        System.out.println("Exist: " + file.exists());

        // coba buka file
        try {
            fileInputStream = new FileInputStream(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("cannot open file");
            return;
        }

        // file berhasil dibuka, sekarang dibaca
        try {
            do {
                i = fileInputStream.read(); // baca 1 byte
                if (i != -1) // kalau belum EOF
                    System.out.print((char) i); // tampilkan sebagai karakter
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("error reading file.");
        }

        // tutup file
        try {
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("error closing file");
        }

        /**
         * BEDAH DALAM PROGRAM 1
         *
         * Alur kerja
         * Buka file → baca byte → tampilkan → ulang → tutup file
         *
         * read() penting
         * i = fin.read();
         * baca 1 byte
         * return:
         * data
         * atau -1 → EOF
         *
         * Kenapa cast ke char?
         * (char) i
         *
         * karena:
         * data masih byte
         * kita ubah jadi karakter
         *
         * EXCEPTION HANDLING
         * 
         * Kenapa banyak try-catch?
         *
         * Karena:
         * file bisa gagal dibuka
         * bisa error saat dibaca
         * bisa error saat ditutup
         */

    }
}
