package FundamentalJava.ExceptionHandling;

/**
 * ------------------------------------------------------------
 * Creating Your Own Exception Subclasses
 * ------------------------------------------------------------
 *
 * Java menyediakan banyak exception bawaan seperti:
 * - IOException
 * - SQLException
 * - NullPointerException
 * - IllegalArgumentException
 *
 * Namun pada aplikasi nyata sering kali dibutuhkan jenis exception
 * yang lebih spesifik sesuai kebutuhan domain aplikasi..
 *
 * Untuk itu Java memungkinkan kita membuat custom exception,
 * yaitu exception yang didefinisikan sendiri oleh programmer.
 *
 * Contoh:
 *
 * class InvalidEmailException extends Exception {
 * }
 *
 * Setelah sebuah class mewarisi Exception (atau RuntimeException),
 * class tersebut dapat digunakan dengan mekanisme exception Java,
 * seperti:
 *
 * - throw
 * - try-catch
 * - throws
 *
 * ------------------------------------------------------------
 * Mengapa Harus extends Exception?
 * ------------------------------------------------------------
 *
 * Java hanya mengizinkan object yang merupakan turunan dari:
 *
 * Throwable
 *
 * untuk digunakan sebagai exception.
 *
 * Hirarki sederhananya:
 *
 * Throwable
 * ├── Exception
 * │    ├── IOException
 * │    ├── SQLException
 * │    └── CustomException
 * │
 * └── Error
 *
 * Karena itu:
 *
 * class MyException extends Exception { }
 *
 * valid digunakan sebagai exception.
 *
 * Sedangkan:
 *
 * class MyError { }
 *
 * bukan exception dan tidak dapat dilempar (throw).
 *
 * ------------------------------------------------------------
 * Constructor Exception
 * ------------------------------------------------------------
 *
 * Class Exception menyediakan beberapa constructor bawaan,
 * yang paling sering digunakan adalah:
 *
 * Exception()
 * Exception(String message)
 *
 * Constructor dengan parameter message digunakan untuk
 * memberikan informasi tambahan mengenai penyebab kegagalan.
 *
 * Contoh:
 *
 * throw new InvalidEmailException(
 *     "Format email tidak valid"
 * );
 *
 * Informasi tersebut nantinya dapat diambil melalui:
 *
 * getMessage()
 *
 * ------------------------------------------------------------
 * Method Penting yang Diwarisi dari Throwable
 * ------------------------------------------------------------
 *
 * Semua custom exception otomatis mewarisi method-method penting
 * dari class Throwable, antara lain:
 *
 * - getMessage()
 * - printStackTrace()
 * - toString()
 * - getCause()
 *
 * Karena itu biasanya custom exception tidak memerlukan
 * implementasi tambahan kecuali memang dibutuhkan.
 *
 * ------------------------------------------------------------
 * Override toString()
 * ------------------------------------------------------------
 *
 * Jika diperlukan, custom exception dapat mengubah format output
 * dengan melakukan override terhadap method toString().
 *
 * Contoh:
 *
 * @Override
 * public String toString() {
 *     return "InvalidEmailException";
 * }
 *
 * Namun dalam praktik modern, penggunaan message melalui
 * constructor biasanya lebih umum dibanding override toString().
 *
 * ------------------------------------------------------------
 * Checked Exception vs Unchecked Exception
 * ------------------------------------------------------------
 *
 * Secara umum custom exception dapat dibuat melalui dua cara:
 *
 * 1. extends Exception
 *
 * Disebut Checked Exception.
 * Compiler memaksa programmer untuk menangani exception
 * menggunakan try-catch atau throws.
 *
 * Contoh:
 *
 * class DatabaseException extends Exception {
 * }
 *
 * 2. extends RuntimeException
 *
 * Disebut Unchecked Exception.
 * Tidak wajib ditangani oleh compiler.
 *
 * Contoh:
 *
 * class InvalidEmailException
 *         extends RuntimeException {
 * }
 *
 * Pada aplikasi Java modern, termasuk Spring Boot,
 * custom exception lebih sering dibuat dengan
 * mewarisi RuntimeException.
 *
 * ------------------------------------------------------------
 * Best Practice
 * ------------------------------------------------------------
 *
 * Berikan nama exception yang spesifik sesuai domain aplikasi.
 *
 * Contoh:
 *
 * - UserNotFoundException
 * - InvalidPasswordException
 * - PaymentFailedException
 * - ProductNotFoundException
 *
 * Hindari nama yang terlalu umum seperti:
 *
 * - DataException
 * - ErrorException
 * - MyException
 *
 * karena kurang menjelaskan jenis kegagalan yang terjadi.
 *
 * ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * - Custom Exception adalah exception yang dibuat sendiri.
 * - Dibuat dengan mewarisi Exception atau RuntimeException.
 * - Semua exception harus merupakan turunan dari Throwable.
 * - Custom exception membantu mendefinisikan jenis kegagalan
 *   yang spesifik dalam aplikasi.
 * - Checked Exception menggunakan extends Exception.
 * - Unchecked Exception menggunakan extends RuntimeException.
 * - Pada Java modern dan Spring Boot, RuntimeException
 *   lebih sering digunakan untuk custom exception.
 */

/**
 * ------------------------------------------------------------
 * Method Penting pada Throwable
 * ------------------------------------------------------------
 *
 * Throwable adalah root class dari seluruh mekanisme error handling
 * di Java.
 *
 * Semua turunan:
 *
 * - Exception
 * - RuntimeException
 * - Error
 *
 * secara otomatis mewarisi method-method yang didefinisikan oleh
 * class Throwable.
 *
 * Karena itu, seluruh exception di Java memiliki kemampuan untuk:
 *
 * - menyimpan pesan error
 * - menyimpan penyebab error (cause)
 * - merekam stack trace
 * - menampilkan detail error
 * - menyimpan exception tambahan (suppressed exceptions)
 *
 * ------------------------------------------------------------
 * Method yang Paling Sering Digunakan
 * ------------------------------------------------------------
 *
 * getMessage()
 *
 * Mengembalikan pesan error yang diberikan saat exception dibuat.
 *
 * Contoh:
 *
 * throw new Exception("Data tidak ditemukan");
 *
 * e.getMessage();
 *
 * Hasil:
 *
 * Data tidak ditemukan
 *
 * ------------------------------------------------------------
 *
 * printStackTrace()
 *
 * Menampilkan detail exception beserta stack trace ke console.
 *
 * Method ini sangat membantu saat debugging karena menunjukkan:
 *
 * - jenis exception
 * - lokasi error terjadi
 * - urutan pemanggilan method
 *
 * Contoh:
 *
 * e.printStackTrace();
 *
 * ------------------------------------------------------------
 *
 * getCause()
 *
 * Mengembalikan penyebab utama (root cause) dari sebuah exception.
 *
 * Berguna ketika sebuah exception membungkus exception lain.
 *
 * Contoh:
 *
 * DatabaseException
 * -> SQLException
 *
 * Dengan getCause() kita dapat mengetahui penyebab aslinya.
 *
 * ------------------------------------------------------------
 *
 * getStackTrace()
 *
 * Mengembalikan array berisi objek StackTraceElement.
 *
 * Digunakan ketika kita ingin memproses stack trace secara
 * programatik tanpa langsung mencetaknya ke console.
 *
 * Contoh penggunaan umum:
 *
 * - logging framework
 * - monitoring system
 * - debugging tools
 *
 * ------------------------------------------------------------
 *
 * toString()
 *
 * Mengembalikan representasi string dari exception.
 *
 * Secara default formatnya:
 *
 * NamaException: pesan
 *
 * Contoh:
 *
 * java.lang.Exception: Data tidak ditemukan
 *
 * Method ini otomatis dipanggil ketika exception dicetak:
 *
 * System.out.println(e);
 *
 * ------------------------------------------------------------
 * Method Tingkat Lanjut (Jarang Dipakai Langsung)
 * ------------------------------------------------------------
 *
 * addSuppressed(Throwable exception)
 *
 * Menambahkan exception ke daftar suppressed exceptions.
 *
 * Umumnya digunakan secara otomatis oleh mekanisme:
 *
 * try-with-resources
 *
 * ------------------------------------------------------------
 *
 * getSuppressed()
 *
 * Mengembalikan seluruh suppressed exceptions yang tersimpan.
 *
 * ------------------------------------------------------------
 *
 * initCause(Throwable cause)
 *
 * Mengaitkan penyebab (cause) ke sebuah exception secara manual.
 *
 * Digunakan jika constructor exception tidak menerima parameter
 * cause.
 *
 * ------------------------------------------------------------
 *
 * fillInStackTrace()
 *
 * Membuat ulang informasi stack trace pada exception.
 *
 * Jarang digunakan secara langsung karena biasanya dilakukan
 * otomatis oleh JVM saat exception dibuat.
 *
 * ------------------------------------------------------------
 *
 * setStackTrace(StackTraceElement[] trace)
 *
 * Mengubah stack trace secara manual.
 *
 * Biasanya hanya digunakan oleh:
 *
 * - framework
 * - testing tools
 * - debugging tools
 *
 * Hampir tidak pernah digunakan dalam aplikasi sehari-hari.
 *
 * ------------------------------------------------------------
 *
 * getLocalizedMessage()
 *
 * Mengembalikan pesan error yang telah disesuaikan dengan locale
 * (bahasa atau wilayah tertentu).
 *
 * Pada sebagian besar aplikasi Java modern, method ini jarang
 * digunakan secara langsung.
 *
 * ------------------------------------------------------------
 *
 * printStackTrace(PrintStream stream)
 * printStackTrace(PrintWriter writer)
 *
 * Variasi dari printStackTrace() yang memungkinkan output
 * dikirim ke lokasi lain, misalnya:
 *
 * - file log
 * - network stream
 * - custom writer
 *
 * ------------------------------------------------------------
 * Ringkasan Method Penting
 * ------------------------------------------------------------
 *
 * Method Kegunaan
 * ------------------------------------------------------------
 * getMessage() Ambil pesan error
 * printStackTrace() Tampilkan detail error
 * getCause() Ambil penyebab error
 * getStackTrace() Ambil stack trace
 * toString() Representasi string exception
 *
 * ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * Throwable adalah fondasi sistem error handling Java.
 *
 * Seluruh exception mewarisi kemampuan untuk:
 *
 * - menyimpan pesan error
 * - menyimpan penyebab error
 * - merekam stack trace
 * - menampilkan informasi debugging
 *
 * Dalam praktik sehari-hari, method yang paling sering digunakan:
 *
 * - getMessage()
 * - printStackTrace()
 * - getCause()
 * - toString()
 *
 * Sedangkan method lain umumnya lebih banyak digunakan oleh
 * framework, library, atau tool internal Java.
 *
 * Error handling di Java bukan hanya tentang menangkap error,
 * tetapi juga menyediakan informasi yang cukup untuk melakukan
 * analisis, debugging, dan pelacakan sumber masalah secara
 * sistematis.
 */

// Custome Exception
// extends Exception
// ini yang bikin class jadi exception
class MyException extends Throwable {

    private int detail; // Menyimpan data tambahan

    // Constructor
    MyException(int a) {
        detail = a;
    }

    // Override toString untuk costum output
    @Override
    public String toString() {
        return "MyException[" + detail + "]";
    }

    /**
     * PENJELASAN
     * 
     * Kenapa toString() di override?
     * Default:
     * MyException: null
     *
     * Custom:
     * MyException[20]
     * lebih clean & controlled
     */
}

public class BikinExceptionSendiri {

    // Method yang bisa melempar exception
    static void compute(int a) throws MyException { // Method bilang: “gua bisa error, siap-siap ya”

        System.out.println("Called Compute(" + a + ")");
        // KONDISI ERROR
        if (a > 10)
            // MyException Error yang kita but
            throw new MyException(a); // Lempar error

        System.out.println("Normal Exit...");
    }

    public static void main(String[] args) {

        // HANDLE THROWS
        try {
            compute(1); // aman
            System.out.println("Ini tetep diproses."); // tetep jalan
            System.out.println();
            compute(20); // error! dijalankan, karena a > 10
        } catch (MyException e) { // TANGKAP ERROR YANG KITA BUAT
            System.out.println("Caught: " + e);
        }
    }
}
