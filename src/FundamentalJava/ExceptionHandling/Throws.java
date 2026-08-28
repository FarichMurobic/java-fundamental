package FundamentalJava.ExceptionHandling;

/**
 * ------------------------------------------------------------
 * THROWS
 * ------------------------------------------------------------
 *
 * Dalam Java, tidak semua method menangani exception yang terjadi
 * di dalam dirinya sendiri...
 *
 * Kadang sebuah method hanya mengetahui bahwa exception dapat terjadi,
 * tetapi tidak memiliki informasi atau konteks yang cukup untuk
 * menanganinya.
 *
 * Dalam kondisi seperti ini, method dapat meneruskan tanggung jawab
 * penanganan exception kepada pemanggilnya menggunakan keyword:
 *
 * throws
 *
 * ------------------------------------------------------------
 * DEFINISI
 * ------------------------------------------------------------
 *
 * throws digunakan pada deklarasi method atau constructor
 * untuk menyatakan bahwa method tersebut dapat menghasilkan
 * satu atau lebih exception.
 *
 * Bentuk umum:
 *
 * returnType methodName(parameters)
 * throws ExceptionType1, ExceptionType2 {
 *
 * // kode
 * }
 *
 * Contoh:
 *
 * void readFile() throws IOException {
 * // baca file
 * }
 *
 * Artinya:
 *
 * "Method ini dapat menghasilkan IOException,
 * sehingga pemanggil harus siap menanganinya."
 *
 * ------------------------------------------------------------
 * TUJUAN THROWS
 * ------------------------------------------------------------
 *
 * throws tidak menangani exception.
 *
 * throws hanya:
 *
 * - Mendeklarasikan kemungkinan exception.
 * - Memberi informasi kepada pemanggil method.
 * - Meneruskan tanggung jawab penanganan exception.
 *
 * Dengan kata lain:
 *
 * throws adalah kontrak antar method.
 *
 * Method berkata:
 *
 * "Saya mungkin gagal dengan exception berikut.
 * Jika kamu memanggil saya,
 * maka kamu harus siap menghadapinya."
 *
 * ------------------------------------------------------------
 * THROWS HANYA DIGUNAKAN DI DEKLARASI
 * ------------------------------------------------------------
 *
 * throws hanya boleh ditulis pada:
 *
 * - Method
 * - Constructor
 *
 * Contoh method:
 *
 * void methodA() throws IOException {
 * }
 *
 * ------------------------------------------------------------
 *
 * Contoh constructor:
 *
 * class DatabaseConnection {
 *
 * DatabaseConnection() throws SQLException {
 * }
 *
 * }
 *
 * Constructor juga dapat menghasilkan exception,
 * sehingga constructor juga boleh menggunakan throws.
 *
 * ------------------------------------------------------------
 * TIDAK BOLEH DIGUNAKAN DI DALAM BODY METHOD
 * ------------------------------------------------------------
 *
 * Salah:
 *
 * void methodA() {
 *
 * throws IOException; // ERROR
 *
 * }
 *
 * Karena:
 *
 * throws bukan perintah eksekusi.
 *
 * throws hanya bagian dari deklarasi method
 * atau constructor.
 *
 * ------------------------------------------------------------
 * CHECKED EXCEPTION DAN THROWS
 * ------------------------------------------------------------
 *
 * Ini adalah aturan terpenting.
 *
 * Untuk Checked Exception:
 *
 * Programmer WAJIB melakukan salah satu:
 *
 * 1. Menangani dengan try-catch
 * atau
 * 2. Mendeklarasikan dengan throws
 *
 * Jika tidak:
 *
 * Compile Error
 *
 * Contoh:
 *
 * void readFile() throws IOException {
 * }
 *
 * atau:
 *
 * void readFile() {
 *
 * try {
 * }
 * catch(IOException e) {
 * }
 *
 * }
 *
 * Salah satu harus dilakukan.
 *
 * ------------------------------------------------------------
 * RUNTIME EXCEPTION DAN THROWS
 * ------------------------------------------------------------
 *
 * RuntimeException dan turunannya
 * tidak wajib dideklarasikan.
 *
 * Contoh:
 *
 * ArithmeticException
 * NullPointerException
 * NumberFormatException
 * IndexOutOfBoundsException
 *
 * Method berikut legal:
 *
 * void test() {
 * int x = 10 / 0;
 * }
 *
 * tanpa:
 *
 * throws ArithmeticException
 *
 * Alasannya:
 *
 * RuntimeException dianggap sebagai
 * kesalahan logika program (programming error),
 * bukan kondisi yang harus dipaksa ditangani.
 *
 * ------------------------------------------------------------
 * THROW VS THROWS
 * ------------------------------------------------------------
 *
 * Ini adalah salah satu perbedaan
 * yang paling sering membingungkan pemula.
 *
 * THROW
 *
 * Digunakan untuk:
 *
 * Melempar exception.
 *
 * Contoh:
 *
 * throw new IOException();
 *
 * ------------------------------------------------------------
 *
 * THROWS
 *
 * Digunakan untuk:
 *
 * Mendeklarasikan kemungkinan exception.
 *
 * Contoh:
 *
 * void methodA() throws IOException {
 * }
 *
 * ------------------------------------------------------------
 *
 * Ringkasan:
 *
 * throw
 * =
 * aksi melempar exception
 *
 * throws
 * =
 * deklarasi bahwa exception mungkin terjadi
 *
 * ------------------------------------------------------------
 * ALUR PROPAGASI EXCEPTION
 * ------------------------------------------------------------
 *
 * Misalnya:
 *
 * methodA()
 * throws IOException
 *
 * dipanggil oleh:
 *
 * methodB()
 *
 * Maka methodB harus memilih:
 *
 * 1. Menangani exception
 *
 * try {
 * methodA();
 * }
 * catch(IOException e) {
 * }
 *
 * ------------------------------------------------------------
 *
 * 2. Meneruskan exception lagi
 *
 * void methodB() throws IOException {
 * methodA();
 * }
 *
 * ------------------------------------------------------------
 *
 * Jika diteruskan lagi:
 *
 * methodB()
 * ↓
 * methodC()
 * ↓
 * main()
 *
 * maka exception akan terus naik
 * sampai ada yang menangani.
 *
 * Proses ini disebut:
 *
 * Exception Propagation
 *
 * ------------------------------------------------------------
 * CONTOH POLA UMUM
 * ------------------------------------------------------------
 *
 * static void methodA() throws IOException {
 * throw new IOException("Gagal membaca file");
 * }
 *
 * static void methodB() throws IOException {
 * methodA();
 * }
 *
 * public static void main(String[] args) {
 *
 * try {
 * methodB();
 * }
 * catch(IOException e) {
 * System.out.println(e.getMessage());
 * }
 *
 * }
 *
 * Alur:
 *
 * methodA()
 * ↓
 * throws IOException
 * ↓
 * methodB()
 * ↓
 * throws IOException
 * ↓
 * main()
 * ↓
 * catch(IOException)
 *
 * ------------------------------------------------------------
 * PRAKTIK MODERN JAVA
 * ------------------------------------------------------------
 *
 * Sebisa mungkin deklarasikan exception
 * yang paling spesifik.
 *
 * Kurang baik:
 *
 * void readFile() throws Exception {
 * }
 *
 * Lebih baik:
 *
 * void readFile() throws IOException {
 * }
 *
 * Karena:
 *
 * - Lebih jelas
 * - Lebih mudah dipahami
 * - Lebih mudah di-maintain
 *
 * Prinsip:
 *
 * "Be as specific as possible."
 *
 * ------------------------------------------------------------
 * INSIGHT PENTING
 * ------------------------------------------------------------
 *
 * throws bukan mekanisme penanganan error.
 *
 * throws adalah mekanisme komunikasi.
 *
 * Method memberitahu caller:
 *
 * "Operasi ini bisa gagal.
 * Jika kamu memanggil saya,
 * maka kamu harus siap menangani kegagalannya."
 *
 * Oleh karena itu,
 * throws sering dianggap sebagai bagian dari
 * kontrak (contract) sebuah method.
 *
 * Dalam API Java modern,
 * deklarasi throws membantu programmer memahami:
 *
 * - Risiko operasi
 * - Jenis kegagalan yang mungkin terjadi
 * - Tanggung jawab penanganan error
 *
 * ------------------------------------------------------------
 * RINGKASAN
 * ------------------------------------------------------------
 *
 * - throws digunakan pada deklarasi method
 * atau constructor.
 * - throws mendeklarasikan kemungkinan exception.
 * - throws tidak menangani exception.
 * - Checked Exception wajib:
 * -> try-catch
 * atau
 * -> throws
 * - RuntimeException tidak wajib dideklarasikan.
 * - throw dan throws memiliki fungsi berbeda.
 * - Exception dapat diteruskan dari satu method
 * ke method lain melalui throws.
 *
 * Mindset OOP:
 *
 * throws adalah kontrak antara method dan caller.
 *
 * Method memberi tahu:
 *
 * "Saya mungkin gagal.
 * Jika kamu menggunakan saya,
 * maka kamu juga bertanggung jawab
 * untuk menangani kemungkinan kegagalan tersebut."
 */

public class Throws {

    // Contoh salah tidak menggunakan throws
    static void throwOne() { // Harusnya throws dideklarasikan disini
        System.out.println("Inside throwOne");

        // ERROR tidak dideklarasikan di methode (oleh throws)
        // throw new NoSuchMethodException("Demo");

        /**
         * Error karena:
         * NoSuchMethodException = checked exception
         * Tidak pakai throws
         */
    }

    // Contoh benar menggunakan throws
    static void throwsDeklarasi() throws IllegalAccessException { // Using throws
        System.out.println("Inside Throws Deklarasi");
        // Membuat error checked Exception
        throw new IllegalAccessException("Demo");
    }

    // Cara 2 — Lempar Lagi (PAKAI throws)
    // Methode 1
    static void methodA() throws Exception {
        throw new Exception("Error");
    }

    // Method yang lempar lagi methodA()
    static void methodB() throws Exception {
        // Panggil methodA()
        methodA(); // Gak ditangkap tapi dilempari lagi
    }

    public static void main(String[] args) throws Exception { // Handle Jvm

        throwOne();

        // Cara 1 — Pakai try-catch (HANDLE LANGSUNG)
        // Ini yang paling umum
        // Error selesai di sini
        try {
            throwsDeklarasi();
        } catch (IllegalAccessException e) {
            // Menangkap exception
            System.out.println("Caught: " + e);
        }

        // Cara 2 — Lempar Lagi (PAKAI throws)
        // Cara 2 ada di methode main (JVM yang handle)
        methodB();

        /**
         * ------------------------------------------------------------
         * THROWS DAN PROPAGASI EXCEPTION
         * ------------------------------------------------------------
         *
         * Jika sebuah method dapat menghasilkan exception tetapi tidak
         * menanganinya sendiri, maka method tersebut harus memberi tahu
         * pemanggilnya mengenai kemungkinan exception tersebut.
         *
         * Hal ini dilakukan menggunakan keyword:
         *
         * throws
         *
         * Contoh:
         *
         * static void methodA() throws Exception {
         * throw new Exception("Error dari methodA");
         * }
         *
         * Artinya:
         *
         * "Method ini mungkin melempar Exception.
         * Pemanggil method harus siap menanganinya."
         *
         * ------------------------------------------------------------
         * THROWS PADA METHOD MAIN
         * ------------------------------------------------------------
         *
         * Method main() juga dapat mendeklarasikan throws:
         *
         * public static void main(String[] args) throws Exception
         *
         * Artinya:
         *
         * main() tidak menangani exception tersebut.
         * Exception diteruskan ke caller berikutnya.
         *
         * Karena main() merupakan entry point aplikasi,
         * caller berikutnya adalah JVM.
         *
         * Dengan kata lain:
         *
         * throws pada main()
         * =
         * menyerahkan penanganan exception kepada JVM.
         *
         * ------------------------------------------------------------
         * APA YANG TERJADI JIKA JVM MENANGANI EXCEPTION?
         * ------------------------------------------------------------
         *
         * Jika exception berhasil mencapai JVM tanpa pernah ditangani,
         * maka JVM akan menjalankan:
         *
         * Default Exception Handler
         *
         * Handler bawaan JVM akan:
         *
         * - Menampilkan tipe exception
         * - Menampilkan pesan exception
         * - Menampilkan stack trace
         * - Menghentikan program
         *
         * Contoh:
         *
         * public class Main {
         *
         * static void methodA() throws Exception {
         * throw new Exception("Error dari methodA");
         * }
         *
         * public static void main(String[] args) throws Exception {
         * methodA();
         * }
         * }
         *
         * Output:
         *
         * Exception in thread "main"
         * java.lang.Exception: Error dari methodA
         * at Main.methodA(Main.java:4)
         * at Main.main(Main.java:8)
         *
         * ------------------------------------------------------------
         * MEMAHAMI STACK TRACE
         * ------------------------------------------------------------
         *
         * Stack trace menunjukkan urutan pemanggilan method
         * sebelum exception terjadi.
         *
         * Contoh:
         *
         * main()
         * ↓
         * methodB()
         * ↓
         * methodA()
         * ↓
         * Exception
         *
         * Informasi ini sangat penting saat debugging karena
         * membantu menemukan lokasi sebenarnya dari masalah.
         *
         * ------------------------------------------------------------
         * KAPAN THROWS DI MAIN BOLEH DIGUNAKAN?
         * ------------------------------------------------------------
         *
         * Umumnya boleh digunakan pada:
         *
         * - Program latihan
         * - Contoh pembelajaran
         * - Utility sederhana
         * - Eksperimen atau debugging
         *
         * Namun pada aplikasi produksi (production application),
         * membiarkan exception sampai ke JVM biasanya tidak disarankan.
         *
         * Alasannya:
         *
         * - Program langsung berhenti
         * - Pengguna melihat error yang tidak ramah
         * - Sulit memberikan recovery atau fallback
         *
         * Pada aplikasi nyata, exception biasanya ditangani
         * sebelum mencapai JVM.
         *
         * ------------------------------------------------------------
         * PROPAGASI EXCEPTION
         * ------------------------------------------------------------
         *
         * Exception dapat bergerak naik melalui rantai pemanggilan
         * method (call stack).
         *
         * Contoh:
         *
         * methodA() throws Exception
         * ↓
         * methodB() throws Exception
         * ↓
         * main()
         *
         * Setiap method dapat memilih:
         *
         * - Menangani exception (try-catch)
         * - Meneruskan exception (throws)
         *
         * Proses ini disebut:
         *
         * Exception Propagation
         *
         * ------------------------------------------------------------
         * BEST PRACTICE
         * ------------------------------------------------------------
         *
         * Pada aplikasi modern, biasanya digunakan pola:
         *
         * Layer bawah:
         * - Repository
         * - DAO
         * - Service
         *
         * Fokus:
         * - Menjalankan logika bisnis
         * - Melempar exception jika terjadi masalah
         *
         * Layer atas:
         * - Controller
         * - UI
         * - Main Program
         *
         * Fokus:
         * - Menangani exception
         * - Menampilkan pesan yang sesuai
         * - Melakukan logging
         *
         * Contoh:
         *
         * Repository
         * ↓ throws
         * Service
         * ↓ throws
         * Controller
         * ↓ catch
         * User
         *
         * Pendekatan ini menghasilkan kode yang:
         *
         * - Lebih bersih
         * - Lebih mudah dipelihara
         * - Lebih fleksibel
         * - Lebih mudah diuji (testable)
         *
         * ------------------------------------------------------------
         * CONTOH POLA YANG DIREKOMENDASIKAN
         * ------------------------------------------------------------
         *
         * public class Main {
         *
         * static void methodA() throws Exception {
         * throw new Exception("Error dari A");
         * }
         *
         * static void methodB() throws Exception {
         * methodA();
         * }
         *
         * public static void main(String[] args) {
         *
         * try {
         * methodB();
         *
         * } catch (Exception e) {
         * System.out.println(
         * "Error ditangani: " + e.getMessage()
         * );
         * }
         * }
         * }
         *
         * Pada contoh ini:
         *
         * methodA() -> menghasilkan exception
         * methodB() -> meneruskan exception
         * main() -> menangani exception
         *
         * Tanggung jawab setiap method menjadi jelas.
         *
         * ------------------------------------------------------------
         * PERBEDAAN THROW DAN THROWS
         * ------------------------------------------------------------
         *
         * throw
         * - Digunakan di dalam body method
         * - Untuk melempar exception
         *
         * Contoh:
         *
         * throw new IllegalArgumentException("Data tidak valid");
         *
         * throws
         * - Digunakan pada deklarasi method/constructor
         * - Untuk mendeklarasikan kemungkinan exception
         *
         * Contoh:
         *
         * void readFile() throws IOException
         *
         * ------------------------------------------------------------
         * KESIMPULAN
         * ------------------------------------------------------------
         *
         * - throws digunakan untuk mendeklarasikan kemungkinan exception
         * - Exception dapat diteruskan ke caller melalui propagasi
         * - Jika exception mencapai main() dan tidak ditangani,
         * JVM akan menggunakan default exception handler
         * - Stack trace membantu proses debugging
         * - Layer bawah biasanya melempar exception
         * - Layer atas biasanya menangani exception
         * - Best practice:
         *
         * throw di tempat error terjadi
         * throws untuk meneruskan
         * try-catch pada titik yang benar-benar dapat menangani error
         *
         * Prinsip penting:
         *
         * "Tangani exception hanya jika Anda benar-benar dapat
         * melakukan sesuatu terhadap exception tersebut."
         */

    }

}
