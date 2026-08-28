package FundamentalJava.ExceptionHandling;

/**
 * ------------------------------------------------------------
 * DISPLAYING A DESCRIPTION OF AN EXCEPTION
 * ------------------------------------------------------------
 *
 * Setiap exception di Java adalah object yang merupakan
 * turunan dari class Throwable..
 *
 * Karena Throwable meng-override method:
 *
 * toString()
 *
 * maka object exception dapat langsung ditampilkan
 * menggunakan System.out.println().
 *
 * Contoh:
 *
 * catch (ArithmeticException e) {
 * System.out.println(e);
 * }
 *
 * Output:
 *
 * java.lang.ArithmeticException: / by zero
 *
 * ------------------------------------------------------------
 * APA YANG TERJADI DI BELAKANG LAYAR?
 * ------------------------------------------------------------
 *
 * Saat menulis:
 *
 * System.out.println(e);
 *
 * Java secara otomatis memanggil:
 *
 * e.toString();
 *
 * sehingga sebenarnya setara dengan:
 *
 * System.out.println(e.toString());
 *
 * ------------------------------------------------------------
 * APA ITU e?
 * ------------------------------------------------------------
 *
 * Pada kode:
 *
 * catch (ArithmeticException e)
 *
 * variable e adalah reference yang menunjuk
 * object exception yang baru saja dilempar (thrown).
 *
 * Object tersebut menyimpan informasi seperti:
 *
 * - jenis exception
 * - pesan error
 * - stack trace
 * - cause (penyebab error)
 * - suppressed exceptions
 *
 * Contoh:
 *
 * catch (ArithmeticException e) {
 * ...
 * }
 *
 * e menunjuk object:
 *
 * ArithmeticException
 *
 * yang dibuat JVM saat error terjadi.
 *
 * ------------------------------------------------------------
 * HASIL METHOD toString()
 * ------------------------------------------------------------
 *
 * Secara umum:
 *
 * NamaException: PesanError
 *
 * Contoh:
 *
 * java.lang.ArithmeticException: / by zero
 *
 * Penjelasan:
 *
 * java.lang.ArithmeticException
 * -> tipe exception
 *
 * / by zero
 * -> pesan exception
 *
 * ------------------------------------------------------------
 * PERBEDAAN toString() DAN getMessage()
 * ------------------------------------------------------------
 *
 * Misalkan:
 *
 * try {
 * int x = 10 / 0;
 * }
 * catch (ArithmeticException e) {
 *
 * System.out.println(e);
 * System.out.println(e.getMessage());
 *
 * }
 *
 * Output:
 *
 * java.lang.ArithmeticException: / by zero
 * / by zero
 *
 * Perbedaannya:
 *
 * e.toString()
 * -> nama exception + pesan
 *
 * e.getMessage()
 * -> hanya pesan exception
 *
 * ------------------------------------------------------------
 * MENAMPILKAN DETAIL ERROR LENGKAP
 * ------------------------------------------------------------
 *
 * Untuk debugging biasanya digunakan:
 *
 * e.printStackTrace();
 *
 * Contoh output:
 *
 * java.lang.ArithmeticException: / by zero
 * at Demo.main(Demo.java:10)
 *
 * Stack trace menunjukkan:
 *
 * - exception apa yang terjadi
 * - file mana yang error
 * - baris berapa yang error
 * - urutan pemanggilan method
 *
 * Informasi ini jauh lebih berguna
 * dibandingkan hanya menampilkan getMessage().
 *
 * ------------------------------------------------------------
 * PRAKTIK MODERN JAVA
 * ------------------------------------------------------------
 *
 * Untuk pembelajaran:
 *
 * System.out.println(e);
 *
 * cukup untuk melihat deskripsi exception.
 *
 * Untuk debugging:
 *
 * e.printStackTrace();
 *
 * lebih informatif.
 *
 * Untuk aplikasi production modern
 * (Spring Boot, Jakarta EE, Microservices):
 *
 * biasanya exception dicatat menggunakan
 * framework logging seperti:
 *
 * - Logback
 * - SLF4J
 * - Log4j2
 *
 * sehingga stack trace tersimpan ke log file.
 *
 * ------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------
 *
 * Object exception dapat langsung ditampilkan
 * karena Throwable meng-override method toString().
 *
 * System.out.println(e)
 *
 * sebenarnya memanggil:
 *
 * e.toString()
 *
 * Method penting yang perlu diketahui:
 *
 * - toString()
 * -> tipe exception + pesan
 *
 * - getMessage()
 * -> hanya pesan error
 *
 * - printStackTrace()
 * -> detail lengkap lokasi error
 *
 * Untuk debugging, printStackTrace() biasanya
 * lebih berguna daripada hanya menampilkan pesan error.
 */

public class Experiments {
    public static void main(String[] args) {

        try {
            int a = 10 / 0; // ERROR
        } catch (ArithmeticException e) {
            // Menampilkan object exception (otomatis toString())
            System.out.println("Exception: " + e);

            // Sama dengan
            // System.out.println("Exception: " + e.to.String());
        }

        /**
         * Outpur
         * Exception: java.lang.ArithmeticException: / by zero
         */

        // Versi Lebih Berguna (Debugging)
        try {
            int[] data = { 1, 2, 3 };
            System.out.println(data[5]); // ERROR

        } catch (Exception e) {

            // Menampilkan detail error
            System.out.println("Terjadi error: " + e);
            // coba lebih tricky
            System.out.println(e.getMessage()); // ambil pesan saja
            e.printStackTrace(); // tampilkan full trace

        }

        /**
         * Output
         * 
         * Terjadi error: java.lang.ArrayIndexOutOfBoundsException: Index 5 out of
         * bounds for length 3
         * Index 5 out of bounds for length 3
         * java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3
         * at ExceptionHandling.Eksperimen.main(Eksperimen.java:76)
         *
         * ----------------------------------------------
         * 
         * Kesimpulan Penting
         *
         * Intinya:
         *
         * e = object exception
         * System.out.println(e) → otomatis panggil toString()
         * Output berisi:
         * jenis exception
         * pesan error
         *
         * ----------------------------------------------
         * 
         * Tips penting
         * 
         * Kalau lagi belajar / debugging:
         * SELALU tampilkan exception
         * jangan disembunyiin
         */
    }
}
