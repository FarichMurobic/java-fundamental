package FundamentalJava.ExceptionHandling;

/**
 * ------------------------------------------------------------
 * THROW
 * ------------------------------------------------------------
 *
 * Java tidak hanya dapat menghasilkan exception secara otomatis,
 * tetapi programmer juga dapat membuat dan melempar exception
 * secara manual menggunakan keyword:
 *
 * throw
 *
 * Dengan throw, program dapat secara eksplisit memberi tahu
 * bahwa telah terjadi kondisi error atau kondisi yang tidak valid...
 *
 * ------------------------------------------------------------
 * DEFINISI
 * ------------------------------------------------------------
 *
 * throw digunakan untuk melempar sebuah object exception
 * secara manual.
 *
 * Bentuk umum:
 *
 * throw throwableObject;
 *
 * Contoh:
 *
 * throw new ArithmeticException();
 *
 * atau:
 *
 * throw new IllegalArgumentException("Nilai tidak valid");
 *
 * Setelah throw dieksekusi,
 * alur normal program langsung berhenti dan JVM mulai
 * mencari exception handler (catch) yang sesuai.
 *
 * ------------------------------------------------------------
 * APA YANG BOLEH DILEMPAR?
 * ------------------------------------------------------------
 *
 * Object yang dilempar HARUS merupakan:
 *
 * - Throwable
 * - Subclass Throwable
 *
 * Karena seluruh sistem exception Java dibangun
 * di atas class:
 *
 * java.lang.Throwable
 *
 * Hierarki sederhananya:
 *
 * Throwable
 * ├── Exception
 * └── Error
 *
 * Oleh karena itu:
 *
 * Benar:
 *
 * throw new Exception();
 * throw new RuntimeException();
 * throw new IOException();
 *
 * Salah:
 *
 * throw "Error";
 * throw 100;
 * throw new Object();
 *
 * Karena:
 *
 * String, int, dan Object
 * bukan turunan dari Throwable.
 *
 * ------------------------------------------------------------
 * CARA MENDAPATKAN OBJECT EXCEPTION
 * ------------------------------------------------------------
 *
 * Umumnya ada dua cara.
 *
 * 1. Membuat object exception baru
 *
 * Contoh:
 *
 * throw new IllegalArgumentException(
 * "Umur tidak boleh negatif"
 * );
 *
 * Cara ini adalah yang paling sering digunakan.
 *
 * ------------------------------------------------------------
 *
 * 2. Melempar ulang exception yang sudah ada
 *
 * Contoh:
 *
 * catch(Exception e) {
 * throw e;
 * }
 *
 * Teknik ini disebut:
 *
 * Rethrowing Exception
 *
 * yaitu meneruskan exception ke level yang lebih tinggi.
 *
 * ------------------------------------------------------------
 * ALUR EKSEKUSI THROW
 * ------------------------------------------------------------
 *
 * Contoh:
 *
 * System.out.println("A");
 *
 * throw new RuntimeException();
 *
 * System.out.println("B");
 *
 * Yang terjadi:
 *
 * 1. "A" dicetak.
 * 2. Exception dilempar.
 * 3. JVM mulai mencari catch.
 * 4. "B" TIDAK PERNAH dieksekusi.
 *
 * Output:
 *
 * A
 *
 * Hal penting:
 *
 * Setelah throw,
 * alur normal program langsung berhenti.
 *
 * ------------------------------------------------------------
 * PROSES PENCARIAN CATCH
 * ------------------------------------------------------------
 *
 * Setelah exception dilempar:
 *
 * JVM mencari catch yang cocok.
 *
 * Urutannya:
 *
 * Current Try
 * ↓
 * Outer Try
 * ↓
 * Calling Method
 * ↓
 * Main Method
 * ↓
 * JVM Default Handler
 *
 * Jika handler ditemukan:
 *
 * catch dijalankan.
 *
 * Jika tidak ditemukan:
 *
 * JVM menjalankan Default Exception Handler
 * dan program berhenti.
 *
 * ------------------------------------------------------------
 * THROW VS THROWS
 * ------------------------------------------------------------
 *
 * Banyak pemula sering tertukar.
 *
 * throw
 * =
 * melempar exception
 *
 * throws
 * =
 * mendeklarasikan kemungkinan exception
 *
 * Contoh:
 *
 * throw new IOException();
 *
 * artinya:
 *
 * "Lempar exception sekarang."
 *
 * ------------------------------------------------------------
 *
 * void bacaFile() throws IOException {
 * }
 *
 * artinya:
 *
 * "Method ini mungkin menghasilkan IOException."
 *
 * ------------------------------------------------------------
 * KAPAN MENGGUNAKAN THROW?
 * ------------------------------------------------------------
 *
 * Throw biasanya digunakan untuk:
 *
 * - Validasi parameter
 * - Validasi business rule
 * - Menolak kondisi yang tidak valid
 * - Membuat custom exception
 *
 * Contoh:
 *
 * public void setUmur(int umur) {
 *
 * if (umur < 0) {
 * throw new IllegalArgumentException(
 * "Umur tidak boleh negatif"
 * );
 * }
 *
 * this.umur = umur;
 * }
 *
 * Dengan cara ini:
 *
 * object tidak bisa berada pada kondisi yang tidak valid.
 *
 * ------------------------------------------------------------
 * PRAKTIK MODERN JAVA
 * ------------------------------------------------------------
 *
 * Gunakan exception yang paling spesifik.
 *
 * Kurang baik:
 *
 * throw new Exception("Error");
 *
 * Lebih baik:
 *
 * throw new IllegalArgumentException(
 * "Umur tidak boleh negatif"
 * );
 *
 * atau:
 *
 * throw new IllegalStateException(
 * "Koneksi belum dibuka"
 * );
 *
 * atau:
 *
 * throw new UserNotFoundException(id);
 *
 * Semakin spesifik exception,
 * semakin mudah debugging dan maintenance.
 *
 * ------------------------------------------------------------
 * INSIGHT PENTING
 * ------------------------------------------------------------
 *
 * Exception bukan hanya error.
 *
 * Exception adalah cara sebuah object atau method
 * mengkomunikasikan bahwa:
 *
 * "Saya tidak bisa melanjutkan operasi ini
 * karena kondisi tertentu tidak terpenuhi."
 *
 * Dengan throw,
 * programmer dapat mendefinisikan sendiri
 * aturan kegagalan (failure rules)
 * dalam aplikasi.
 *
 * Ini merupakan bagian penting dari:
 *
 * - Defensive Programming
 * - Domain Validation
 * - Robust Software Design
 *
 * ------------------------------------------------------------
 * RINGKASAN
 * ------------------------------------------------------------
 *
 * - throw digunakan untuk melempar exception secara manual.
 * - Object yang dilempar harus turunan Throwable.
 * - Setelah throw, alur normal program berhenti.
 * - JVM akan mencari catch yang sesuai.
 * - Jika tidak ada handler, JVM menjalankan
 * Default Exception Handler.
 * - throw berbeda dengan throws.
 * - throw sering digunakan untuk validasi
 * dan business rules.
 *
 * Mindset OOP:
 *
 * throw adalah mekanisme bagi object atau method
 * untuk menyatakan bahwa operasi tidak dapat
 * dilanjutkan karena terjadi kondisi yang tidak valid.
 */

public class Throw {

    // Static Method
    static void demoproc() {

        try {
            // Membuat dan melempar exception sendiri
            throw new NullPointerException("Demo");

            // Ini akan error
            // System.out.println("Ini gak akan jalan");
        } catch (NullPointerException e) {
            System.out.println("Caught inside demoproc");
            // Lempar lagi keluar
            throw e;
        }
    }

    public static void main(String[] args) {

        try {
            demoproc();
        } catch (NullPointerException e) {
            // Menangkap ulang
            System.out.println("Recaught: " + e);
        }

        /**
         * Output
         * 
         * Caught inside demoproc.
         * Recaught: java.lang.NullPointerException: demo
         *
         * Penjelasan Alur
         * 
         * Step-by-step
         * main() → panggil demoproc()
         * Di dalam demoproc():
         * throw new NullPointerException("demo")
         * langsung masuk catch
         *
         * print:
         * Caught inside demoproc.
         *
         * throw e → lempar lagi ke luar
         * Balik ke main():
         *
         * ditangkap lagi
         * print:
         * Recaught: java.lang.NullPointerException: demo
         *
         * Ini disebut: rethrow
         * nangkap → lempar lagi
         *
         * --------------------------------------------------
         * 
         * Kesimpulan Penting
         *
         * Intinya:
         * throw = lempar exception manual
         * Harus pakai object dari Throwable
         * Setelah throw → kode berhenti
         *
         * Cara bikin exception:
         * throw new ExceptionType("pesan");
         *
         * Alur:
         * throw → cari catch → gak ada → naik → default handler
         */

        /**
         * Insight Tambahan
         * 
         * Kenapa throw penting?
         * Buat kontrol logika program
         *
         * Contoh:
         * if (umur < 0) {
         * throw new IllegalArgumentException("Umur tidak valid");
         * }
         *
         * ini bukan error Java
         * ini error dari logika lu sendiri
         *
         * --------------------------------------------
         *
         * Constructor Exception
         * 
         * Contoh:
         * throw new NullPointerException("demo");
         *
         * "demo" = pesan error
         * Bisa diambil dengan:
         * e.getMessage();
         *
         * Hal penting
         * Setelah:
         * throw ...
         *
         * jangan harap kode bawahnya jalan
         *
         * Contoh salah
         * throw new Exception();
         * System.out.println("Tidak akan jalan"); //
         *
         * Mindset Pro
         * Exception bukan cuma buat nangkep error
         * tapi buat ngontrol alur program
         */
    }
}
