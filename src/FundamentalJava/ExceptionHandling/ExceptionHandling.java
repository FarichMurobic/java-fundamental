package FundamentalJava.ExceptionHandling;

/**
 * ------------------------------------------------------------
 * EXCEPTION HANDLING
 * ------------------------------------------------------------
 *
 * Exception Handling adalah mekanisme Java untuk mendeteksi,
 * melaporkan, dan menangani kondisi abnormal (exception)
 * yang terjadi saat program berjalan (runtime)..
 *
 * Exception bukan selalu berarti program rusak total.
 * Banyak exception masih bisa ditangani sehingga program
 * tetap dapat berjalan atau memberikan respons yang tepat.
 *
 * Sebelum adanya mekanisme exception handling,
 * penanganan error biasanya dilakukan menggunakan:
 *
 * - kode error (error code)
 * - nilai khusus sebagai penanda kegagalan
 * - pengecekan manual setelah setiap operasi
 *
 * Pendekatan tersebut membuat kode:
 *
 * - sulit dibaca
 * - sulit dipelihara
 * - rentan kesalahan
 *
 * Java mengatasi masalah tersebut dengan menjadikan
 * error sebagai object yang dapat dilempar (throw)
 * dan ditangani (catch).
 *
 * ------------------------------------------------------------
 * DASAR EXCEPTION HANDLING
 * ------------------------------------------------------------
 *
 * Di Java, exception adalah object yang merepresentasikan
 * suatu kondisi error atau kondisi tidak normal.
 *
 * Ketika sebuah masalah terjadi:
 *
 * 1. Object exception dibuat.
 * 2. Exception dilempar (throw).
 * 3. JVM mencari handler yang sesuai.
 * 4. Jika ditemukan, exception ditangani.
 * 5. Jika tidak ditemukan, program berhenti dan
 * stack trace ditampilkan.
 *
 * Secara sederhana:
 *
 * Error terjadi
 * ↓
 * Exception dibuat
 * ↓
 * Exception dilempar (throw)
 * ↓
 * Exception ditangkap (catch)
 * ↓
 * Error ditangani
 *
 * ------------------------------------------------------------
 * SUMBER EXCEPTION
 * ------------------------------------------------------------
 *
 * Exception dapat berasal dari:
 *
 * 1. JVM / Java Runtime
 * (System-Generated Exceptions)
 *
 * Contoh:
 * - ArithmeticException
 * - NullPointerException
 * - ArrayIndexOutOfBoundsException
 *
 * 2. Programmer
 * (Custom Exceptions)
 *
 * Contoh:
 * - InvalidEmailException
 * - PaymentFailedException
 * - UserNotFoundException
 *
 * Custom exception biasanya digunakan untuk
 * merepresentasikan aturan bisnis (business rules)
 * dalam aplikasi.
 *
 * ------------------------------------------------------------
 * KEYWORD PENTING DALAM EXCEPTION HANDLING
 * ------------------------------------------------------------
 *
 * Java menyediakan lima keyword utama:
 *
 * try
 * catch
 * throw
 * throws
 * finally
 *
 * Penjelasan:
 *
 * try
 * Tempat kode yang berpotensi menghasilkan exception.
 *
 * catch
 * Menangkap dan menangani exception.
 *
 * throw
 * Melempar exception secara manual.
 *
 * throws
 * Mendeklarasikan bahwa method dapat menghasilkan exception.
 *
 * finally
 * Blok yang akan dijalankan setelah try/catch selesai,
 * baik terjadi exception maupun tidak.
 *
 * ------------------------------------------------------------
 * BENTUK UMUM
 * ------------------------------------------------------------
 *
 * try {
 * // kode yang dipantau
 * }
 * catch (ExceptionType ex) {
 * // penanganan error
 * }
 * finally {
 * // selalu dieksekusi
 * }
 *
 * ------------------------------------------------------------
 * HIERARKI EXCEPTION
 * ------------------------------------------------------------
 *
 * Semua exception dan error di Java berasal dari:
 *
 * Throwable
 *
 * Throwable merupakan root class untuk seluruh
 * mekanisme error handling Java.
 *
 * Hierarkinya:
 *
 * Throwable
 * ├── Exception
 * │ └── RuntimeException
 * └── Error
 *
 * ------------------------------------------------------------
 * CABANG EXCEPTION
 * ------------------------------------------------------------
 *
 * Exception digunakan untuk kondisi yang masih mungkin
 * ditangani oleh aplikasi.
 *
 * Contoh:
 *
 * - file tidak ditemukan
 * - koneksi database gagal
 * - input tidak valid
 * - jaringan terputus
 *
 * Exception sering dibagi menjadi dua kelompok:
 *
 * 1. Checked Exception
 * 2. Unchecked Exception
 *
 * ------------------------------------------------------------
 * CHECKED EXCEPTION
 * ------------------------------------------------------------
 *
 * Checked Exception adalah exception yang
 * WAJIB ditangani atau dideklarasikan dengan throws.
 *
 * Compiler akan memaksa programmer untuk
 * memikirkan cara menanganinya.
 *
 * Contoh:
 *
 * - IOException
 * - SQLException
 * - ClassNotFoundException
 *
 * Biasanya mewakili kondisi eksternal
 * yang tidak sepenuhnya dapat dikontrol program.
 *
 * ------------------------------------------------------------
 * RUNTIME EXCEPTION (UNCHECKED EXCEPTION)
 * ------------------------------------------------------------
 *
 * RuntimeException adalah subclass khusus dari Exception.
 *
 * Exception jenis ini TIDAK wajib ditangani.
 *
 * Contoh:
 *
 * - NullPointerException
 * - ArithmeticException
 * - IllegalArgumentException
 * - ArrayIndexOutOfBoundsException
 *
 * Umumnya menunjukkan:
 *
 * - bug
 * - kesalahan logika program
 * - penggunaan API yang salah
 *
 * Contoh:
 *
 * int result = 10 / 0;
 *
 * menghasilkan:
 *
 * ArithmeticException
 *
 * Biasanya solusi terbaik bukan menangkap exception,
 * melainkan memperbaiki logika program.
 *
 * ------------------------------------------------------------
 * CABANG ERROR
 * ------------------------------------------------------------
 *
 * Error digunakan untuk kondisi kegagalan serius
 * pada JVM atau lingkungan runtime.
 *
 * Contoh:
 *
 * - OutOfMemoryError
 * - StackOverflowError
 * - VirtualMachineError
 *
 * Error umumnya:
 *
 * - tidak diharapkan untuk ditangani aplikasi
 * - menunjukkan masalah serius pada sistem
 * - sering membuat aplikasi tidak dapat melanjutkan proses
 *
 * Karena itu Error biasanya tidak di-catch.
 *
 * ------------------------------------------------------------
 * PERBEDAAN PENTING
 * ------------------------------------------------------------
 *
 * Checked Exception
 * -> kondisi yang diperkirakan dapat terjadi
 * -> wajib dipikirkan cara menanganinya
 *
 * RuntimeException
 * -> biasanya bug atau kesalahan logika
 * -> sebaiknya diperbaiki, bukan disembunyikan
 *
 * Error
 * -> kegagalan serius pada JVM atau sistem
 * -> umumnya tidak ditangani aplikasi
 *
 * ------------------------------------------------------------
 * BEST PRACTICE MODERN JAVA
 * ------------------------------------------------------------
 *
 * 1. Tangani exception jika memang bisa dipulihkan.
 *
 * 2. Jangan menangkap Exception secara berlebihan.
 *
 * Hindari:
 *
 * catch (Exception e) {
 * }
 *
 * karena dapat menyembunyikan bug.
 *
 * 3. Tangkap exception yang spesifik.
 *
 * Lebih baik:
 *
 * catch (IOException e)
 *
 * daripada:
 *
 * catch (Exception e)
 *
 * 4. Jangan menggunakan try-catch untuk
 * menyembunyikan kesalahan logika.
 *
 * RuntimeException biasanya harus diperbaiki,
 * bukan ditutup dengan catch.
 *
 * ------------------------------------------------------------
 * POLA PIKIR YANG BENAR
 * ------------------------------------------------------------
 *
 * Error karena input, file, jaringan,
 * atau sistem eksternal:
 *
 * -> HANDLE
 *
 * Error karena bug atau logika program:
 *
 * -> FIX
 *
 * Error fatal dari JVM:
 *
 * -> biasanya biarkan JVM menanganinya
 *
 * ------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------
 *
 * Exception Handling adalah mekanisme Java untuk
 * mengelola kondisi error secara terstruktur.
 *
 * Root hierarchy:
 *
 * Throwable
 * ├── Exception
 * │ ├── Checked Exception
 * │ └── RuntimeException
 * └── Error
 *
 * Keyword utama:
 *
 * - try
 * - catch
 * - throw
 * - throws
 * - finally
 *
 * Tujuan utama exception handling bukan hanya
 * mencegah program crash, tetapi juga membuat
 * aplikasi lebih aman, lebih mudah dipelihara,
 * dan lebih mudah di-debug.
 */

public class ExceptionHandling {

    // Methode error dibagi dengan nol.
    static void subroutine() {
        int d = 0;
        int a = 10 / d; // Program berhenti disini

        // INI gak bakal di eksekusi!
        System.out.println(a);
    }

    public static void main(String[] args) {

        // INI CONTOH RUNTIMEEXCEPTION (UNCHECKED EXCEPTION)
        // BUKAN ERROR COMPILE
        // TAPI ERROR SAAT PROGRAM BERJALAN
        // BIASANYA LOGIKA PROGRAM BERMASALAH
        // (KESALAHAN PROGRAMER)

        try {
            int angka = 10;
            int hasil = angka / 0; // Error runtime (dibagi dengan nol)
            System.out.println("Hasil: " + hasil);
        } catch (ArithmeticException e) {
            // Menangkap error pembagian dengan 0
            System.out.println("Terjadi error, tidak bisa dibagi dengan nol!");
        } finally {
            // Selalu dijalankan baik error maupun tidak
            System.out.println("Program selesai dijalankan.");
        }

        /**
         * Output
         * Terjadi error: tidak bisa dibagi dengan nol!
         * Program selesai dijalankan.
         *
         * Penjelasan Kode
         * try → tempat kode rawan error
         * angka / 0 → bikin exception
         * catch → nangkap error tersebut
         * finally → tetap dijalankan
         */

        /**
         * Jika program ini dijalankan tanpa exception handling
         * int angka = 10;
         * int hasil = angka / 0;
         *
         * System.out.println(hasil);
         *
         * Akan menghasilkan error:
         * Exception in thread "main" java.lang.ArithmeticException: / by zero
         * at ExceptionHandling.ExceptionHandling.main(ExceptionHandling.java:101)
         */

        try {
            int[] data = { 1, 2, 3 };
            System.out.println(data[5]); // Error index tidak sampe 5
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index tidak tersedia.");
        }

        // Contoh pertama
        // Mengenal lebih dekat jika program tidak ditangani
        int angka = 6;
        int hasil = angka / 0;
        System.out.println(hasil);

        /**
         * Uncaught Exceptions (Exception yang Tidak Ditangani)
         * Sebelum belajar cara menangani exception, penting untuk melihat apa yang
         * terjadi
         * kalau exception tidak ditangani.
         * 
         * Program berikut sengaja membuat error pembagian dengan nol:
         *
         * int angka = 6;
         * int hasil = angka / 0;
         *
         * Ketika Java mendeteksi pembagian dengan nol:
         * Java membuat object exception baru
         * Lalu melempar (throw) exception tersebut
         *
         * Akibatnya:
         * Eksekusi program langsung berhenti
         * Karena exception harus segera ditangani
         *
         * Karena kita tidak membuat handler:
         * Exception ditangani oleh default handler dari Java
         *
         * Default handler akan:
         * Menampilkan pesan error
         * Menampilkan stack trace (alur error)
         * Menghentikan program
         *
         * Output Error
         * java.lang.ArithmeticException: / by zero
         * at Exc0.main(Exc0.java:4)
         *
         * Informasi yang ditampilkan:
         * Nama class → Exc0
         * Method → main
         * File → Exc0.java
         * Baris → 4
         */

        // Contoh kedua dengan Methode
        // Method yang memicu error
        subroutine(); // Panggil method

        /**
         * Output:
         * java.lang.ArithmeticException: / by zero
         * at Exc1.subroutine(Exc1.java:4)
         * at Exc1.main(Exc1.java:7)
         *
         * Stack Trace
         * Stack trace menunjukkan:
         * urutan pemanggilan method sebelum error terjadi
         *
         * Dalam contoh:
         * main() memanggil subroutine()
         * error terjadi di subroutine()
         *
         * ----------------------------------------------
         * 
         * Apa itu Uncaught Exception?
         * Exception yang tidak lu tangkap pakai try-catch
         *
         * Akibatnya:
         * Java ambil alih
         * Program langsung CRASH
         *
         * Alur yang Terjadi
         * Kalau gak ditangani:
         * error → throw → (gak ada catch) → default handler → program mati
         *
         * Default Handler (Si Penyelamat Terakhir)
         * Kalau lu gak handle:
         * Java bilang:
         * "Yaudah gue yang handle, tapi program lu gue matiin"
         *
         * Yang dia lakukan:
         * print error
         * print stack trace
         * stop program
         *
         * -----------------------------------------------------
         * 
         * Stack Trace (INI PENTING BANGET)
         * Ini kayak jejak kejadian sebelum error.
         *
         * Contoh:
         * main() → subroutine() → ERROR
         *
         * Jadi bisa tahu:
         * error terjadi di mana
         * dipanggil dari mana
         *
         * Contoh Kode
         *
         * Contoh 1 (Tanpa Handler → Crash)
         *
         * public class Exc0 {
         *
         * public static void main(String[] args) {
         *
         * int d = 0;
         * int a = 42 / d; // ERROR: pembagian nol
         * // Program langsung berhenti di sini
         * }
         * }
         *
         * Contoh 2 (Dengan Method → Lihat Stack Trace)
         *
         * public class Exc1 {
         * static void subroutine() {
         * int d = 0;
         * int a = 10 / d; // ERROR terjadi di sini
         * }
         * public static void main(String[] args) {
         * subroutine(); // method ini memicu error
         * }
         * }
         *
         * Penjelasan Stack Trace
         * Exc1.main() → manggil subroutine()
         * subroutine() → error di line 4
         *
         * Jadi Java kasih tahu:
         * error asalnya dari mana
         * jalur lengkapnya
         *
         * Stack Trace = Alat Debugging
         * nunjukin urutan method
         * bantu cari bug dengan cepat
         *
         * Programmer jago itu:
         * gak panik lihat error
         * langsung baca:
         * jenis error
         * line number
         * alur method
         *
         * Cara bener:
         * Lihat error type → ArithmeticException
         * Lihat baris → line 4
         * Lihat alur → siapa manggil siapa
         */
    }
}
