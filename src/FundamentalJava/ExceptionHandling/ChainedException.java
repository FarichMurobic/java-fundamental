package FundamentalJava.ExceptionHandling;

/**
 * ------------------------------------------------------------
 * CHAINED EXCEPTIONS (EXCEPTION CHAINING)
 * ------------------------------------------------------------
 *
 * Java menyediakan mekanisme Chained Exceptions untuk
 * menyimpan hubungan antara sebuah exception dengan
 * penyebab sebenarnya (root cause) yang memicu exception tersebut.
 *
 * Tujuannya:
 * agar informasi error tidak hilang saat exception
 * diteruskan ke layer lain dalam aplikasi..
 *
 * ------------------------------------------------------------
 * KENAPA CHAINED EXCEPTION DIBUTUHKAN?
 * ------------------------------------------------------------
 *
 * Bayangkan ada alur seperti ini:
 *
 * File dibaca
 * ↓
 * IOException
 * ↓
 * Service Layer
 * ↓
 * DataProcessingException
 *
 * Jika IOException langsung diganti dengan
 * DataProcessingException tanpa menyimpan penyebabnya,
 * maka informasi sumber masalah akan hilang.
 *
 * Dengan Chained Exception:
 *
 * DataProcessingException
 * ↓
 * cause = IOException
 *
 * sehingga root cause tetap bisa ditelusuri.
 *
 * ------------------------------------------------------------
 * CONSTRUCTOR PENTING PADA THROWABLE
 * ------------------------------------------------------------
 *
 * Sejak Java 1.4, Throwable menyediakan constructor
 * untuk mendukung exception chaining:
 *
 * Throwable(Throwable cause)
 *
 * Throwable(String message, Throwable cause)
 *
 * Contoh:
 *
 * throw new RuntimeException(
 * "Gagal memproses data",
 * ioException
 * );
 *
 * Di sini:
 *
 * message = "Gagal memproses data"
 * cause = ioException
 *
 * ------------------------------------------------------------
 * METHOD PENTING
 * ------------------------------------------------------------
 *
 * Throwable getCause()
 *
 * Mengembalikan penyebab (cause) dari exception.
 *
 * Contoh:
 *
 * Exception e = ...
 *
 * Throwable cause = e.getCause();
 *
 *
 * Throwable initCause(Throwable cause)
 *
 * Menetapkan penyebab exception setelah object dibuat.
 *
 * Contoh:
 *
 * Exception e = new Exception("Wrapper");
 * e.initCause(originalException);
 *
 * ------------------------------------------------------------
 * ATURAN PENTING
 * ------------------------------------------------------------
 *
 * Cause hanya boleh ditetapkan SATU KALI.
 *
 * Jika cause sudah diberikan melalui constructor:
 *
 * new Exception("msg", cause)
 *
 * maka pemanggilan:
 *
 * initCause(...)
 *
 * akan menghasilkan IllegalStateException.
 *
 * ------------------------------------------------------------
 * STRUKTUR EXCEPTION CHAIN
 * ------------------------------------------------------------
 *
 * Exception Utama
 * ↓
 * Cause
 * ↓
 * Cause Berikutnya
 * ↓
 * Root Cause
 *
 * Contoh:
 *
 * ServiceException
 * ↓
 * RepositoryException
 * ↓
 * SQLException
 *
 * Root cause:
 * SQLException
 *
 * ------------------------------------------------------------
 * KEUNTUNGAN CHAINED EXCEPTIONS
 * ------------------------------------------------------------
 *
 * - Menjaga informasi penyebab error.
 * - Mempermudah debugging.
 * - Cocok untuk aplikasi berlapis (layered architecture).
 * - Error dapat dibungkus (wrapped) tanpa kehilangan root cause.
 * - Sangat umum digunakan di framework modern:
 * Spring Framework
 * Spring Boot
 * Hibernate
 * Jakarta EE
 *
 * ------------------------------------------------------------
 * BEST PRACTICE MODERN JAVA
 * ------------------------------------------------------------
 *
 * Saat membuat exception baru,
 * lebih disarankan menggunakan constructor:
 *
 * public MyException(String message, Throwable cause) {
 * super(message, cause);
 * }
 *
 * daripada menggunakan initCause().
 *
 * Karena:
 *
 * - lebih jelas
 * - immutable setelah dibuat
 * - menjadi standar pada Java modern
 *
 * ------------------------------------------------------------
 * HAL YANG PERLU DIHINDARI
 * ------------------------------------------------------------
 *
 * Jangan membungkus exception tanpa menyimpan cause:
 *
 * SALAH:
 *
 * catch(IOException e) {
 * throw new RuntimeException("Gagal");
 * }
 *
 * Karena root cause hilang.
 *
 * BENAR:
 *
 * catch(IOException e) {
 * throw new RuntimeException("Gagal", e);
 * }
 *
 * ------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------
 *
 * Chained Exception adalah mekanisme untuk
 * menghubungkan exception dengan penyebab aslinya.
 *
 * Method utama:
 * - getCause()
 * - initCause()
 *
 * Constructor utama:
 * - Throwable(Throwable cause)
 * - Throwable(String message, Throwable cause)
 *
 * Dalam Java modern, penyebab error biasanya
 * diteruskan melalui constructor dan diambil
 * menggunakan getCause().
 *
 * Tujuan utamanya:
 * mempertahankan root cause agar proses
 * debugging dan maintenance menjadi lebih mudah.
 */

class ChainException {
    static void demoProc() {
        // Buat exception utama
        NullPointerException exception = new NullPointerException("top layer");

        // Tambahin penyebab
        exception.initCause(new ArithmeticException("cause"));

        // Lempar Exception
        throw exception;
    }
}

public class ChainedException {
    public static void main(String[] args) {

        // Menangkap method error yang dilempar
        try {
            // Panggil method berpotensi error
            ChainException.demoProc();
        } catch (NullPointerException e) {
            // Tampilkan error utama
            System.out.println("Caught: " + e);

            // Tampilkan error penyebabnya
            System.out.println("Original cause: " + e.getCause());
        }
    }

    /**
     * output
     * Caught: java.lang.NullPointerException: top layer
     * Original Cause: java.lang.ArithmeticException: cause
     *
     * POIN PENTING
     * exception bisa punya penyebab (cause)
     * gunakan constructor atau initCause()
     * getCause() untuk ambil penyebab
     * cause hanya bisa di-set sekali
     * chain bisa panjang (multi-layer)
     *
     * Chained Exception =
     * cara Java menyimpan “cerita lengkap” dari error
     *
     * Bukan cuma:
     * apa errornya
     *
     * Tapi:
     * kenapa error itu terjadi
     */
}
