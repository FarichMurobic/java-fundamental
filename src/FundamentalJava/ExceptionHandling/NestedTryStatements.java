package FundamentalJava.ExceptionHandling;

/**
 * ------------------------------------------------------------
 * NESTED TRY STATEMENTS
 * ------------------------------------------------------------
 *
 * Java mengizinkan sebuah blok try ditempatkan
 * di dalam blok try lainnya.
 *
 * Teknik ini disebut:
 *
 * Nested Try Statements
 *
 * atau
 *
 * Nested Exception Handling
 *
 * Contoh sederhana:
 *
 * try {
 *
 *     try {
 *         // inner try
 *     }
 *
 * } catch(Exception e) {
 *     // outer catch
 * }
 *
 * ------------------------------------------------------------
 * KONSEP DASAR
 * ------------------------------------------------------------
 *
 * Saat sebuah exception terjadi,
 * Java akan mencari handler (catch)
 * yang paling dekat terlebih dahulu.
 *
 * Artinya:
 *
 * Inner try
 *     ↓
 * Outer try
 *     ↓
 * Method pemanggil
 *     ↓
 * JVM Default Exception Handler
 *
 * Java selalu mencari dari level terdalam
 * menuju level terluar.
 *
 * Prinsipnya:
 *
 * "Handle sedekat mungkin dengan sumber masalah."
 *
 * ------------------------------------------------------------
 * ALUR EKSEKUSI
 * ------------------------------------------------------------
 *
 * Misalnya:
 *
 * try {
 *
 *     try {
 *         int a = 10 / 0;
 *     }
 *
 *     catch(ArrayIndexOutOfBoundsException e) {
 *         System.out.println("Array Error");
 *     }
 *
 * }
 *
 * catch(ArithmeticException e) {
 *     System.out.println("Divide By Zero");
 * }
 *
 * Yang terjadi:
 *
 * 1. Exception muncul:
 *
 *    ArithmeticException
 *
 * 2. Java cek inner catch:
 *
 *    ArrayIndexOutOfBoundsException
 *
 *    Tidak cocok.
 *
 * 3. Exception diteruskan ke outer try.
 *
 * 4. Java cek outer catch:
 *
 *    ArithmeticException
 *
 *    Cocok.
 *
 * 5. Outer catch dijalankan.
 *
 * Output:
 *
 * Divide By Zero
 *
 * ------------------------------------------------------------
 * EXCEPTION PROPAGATION
 * ------------------------------------------------------------
 *
 * Proses naiknya exception dari satu level
 * ke level yang lebih tinggi disebut:
 *
 * Exception Propagation
 *
 * atau
 *
 * Exception Bubbling
 *
 * Alurnya:
 *
 * Inner Try
 *      ↓
 * Outer Try
 *      ↓
 * Calling Method
 *      ↓
 * JVM Handler
 *
 * Exception akan terus "naik"
 * sampai menemukan handler yang cocok.
 *
 * ------------------------------------------------------------
 * HUBUNGAN DENGAN CALL STACK
 * ------------------------------------------------------------
 *
 * Saat program berjalan,
 * JVM menyimpan informasi method yang aktif
 * dalam sebuah struktur bernama:
 *
 * Call Stack
 *
 * Setiap kali masuk ke:
 *
 * - method
 * - try block
 *
 * JVM menyimpan konteks eksekusi.
 *
 * Ketika exception muncul:
 *
 * JVM melakukan proses:
 *
 * Stack Unwinding
 *
 * yaitu membongkar stack satu per satu
 * sambil mencari handler yang cocok.
 *
 * Contoh:
 *
 * main()
 *    ↓
 * methodA()
 *    ↓
 * methodB()
 *    ↓
 * methodC()
 *    ↓
 * Exception
 *
 * Jika methodC tidak menangani:
 *
 * naik ke methodB
 *
 * Jika methodB tidak menangani:
 *
 * naik ke methodA
 *
 * Jika methodA tidak menangani:
 *
 * naik ke main
 *
 * Jika main tidak menangani:
 *
 * JVM Default Exception Handler
 *
 * ------------------------------------------------------------
 * KAPAN NESTED TRY DIGUNAKAN?
 * ------------------------------------------------------------
 *
 * Nested try biasanya digunakan ketika:
 *
 * - Sebagian kode memiliki risiko exception berbeda.
 * - Sebagian exception ingin ditangani secara lokal.
 * - Sebagian exception ingin diteruskan ke level lebih tinggi.
 *
 * Contoh:
 *
 * try {
 *
 *     // koneksi database
 *
 *     try {
 *         // parsing data
 *     }
 *     catch(NumberFormatException e) {
 *         // tangani parsing
 *     }
 *
 * }
 * catch(SQLException e) {
 *     // tangani database
 * }
 *
 * Dengan cara ini:
 *
 * Error parsing dan error database
 * memiliki penanganan yang berbeda.
 *
 * ------------------------------------------------------------
 * PRAKTIK MODERN JAVA
 * ------------------------------------------------------------
 *
 * Walaupun nested try legal,
 * penggunaan berlebihan biasanya tidak disarankan.
 *
 * Contoh buruk:
 *
 * try {
 *     try {
 *         try {
 *             try {
 *             }
 *         }
 *     }
 * }
 *
 * Kode seperti ini:
 *
 * - Sulit dibaca
 * - Sulit dipelihara
 * - Sulit di-debug
 *
 * Pada aplikasi modern,
 * biasanya lebih baik:
 *
 * - Memecah logika ke method terpisah
 * - Menggunakan exception propagation
 * - Menangani exception pada level yang tepat
 *
 * daripada membuat nested try terlalu dalam.
 *
 * ------------------------------------------------------------
 * INSIGHT PENTING
 * ------------------------------------------------------------
 *
 * Nested try menunjukkan salah satu konsep utama
 * exception handling Java:
 *
 * Exception tidak harus ditangani
 * di tempat exception itu muncul.
 *
 * Exception bisa diteruskan ke level yang
 * lebih tinggi sampai ditemukan bagian program
 * yang benar-benar tahu cara menanganinya.
 *
 * Ini membuat kode:
 *
 * - lebih modular
 * - lebih fleksibel
 * - lebih mudah dirawat
 *
 * ------------------------------------------------------------
 * RINGKASAN
 * ------------------------------------------------------------
 *
 * - try dapat berada di dalam try lain.
 * - Java selalu mencari catch dari level terdalam.
 * - Jika inner try tidak bisa menangani exception,
 *   exception akan diteruskan ke outer try.
 * - Proses naiknya exception disebut:
 *   Exception Propagation.
 * - Jika tidak ada handler yang cocok,
 *   JVM akan menjalankan Default Exception Handler.
 * - Nested try berguna untuk penanganan error
 *   yang bertingkat.
 * - Hindari nested try yang terlalu dalam karena
 *   membuat kode sulit dibaca dan dipelihara.
 *
 * Mindset OOP:
 *
 * Exception adalah objek yang dapat "berjalan"
 * naik melalui call stack sampai menemukan
 * bagian program yang mampu menanganinya.
 */

public class NestedTryStatements {

    // Nested via Method (Lebih Dalam Lagi)
    static void nesttry(int a) {
        try {
            if (a == 1) {
                a = a / (a -a); // ERROR
            }

            if (a == 2) {
                int[] c = {1};
                c[42] = 99; // ERROR
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array error: " + e);
        }
    }
    
    public static void main(String[] args) {
        
        // OUTER try
        try {
            int a = args.length; // 0
            int b = 42 / a; // bisa error outer try
            System.out.println(a);

            // Inner try
            try {
                if (a == 1) {
                    // ERROR pembagian 0
                    a = a / (a - a);
                }

                if (a == 2) {
                    int[] c = {1};
                    // Error index out of boundss
                    c[42] = 99;
                }
            } catch (ArrayIndexOutOfBoundsException e) { // Catch inner
                // Hanya handle error array
                System.out.println("Array error: " + e);
            }
        } catch (ArithmeticException e) { // catch outer
            // Handle pembagian 0 dari luar (outer try)
            System.out.println("Divide by 0: " + e);
        }

        /**
         * Skenario Jalan Program
         * 
         * 1. Tanpa argumen
         * a = 0 → 42/0 → ERROR
         *
         * ditangkap outer catch
         *
         * 2. 1 argumen
         * a = 1 → masuk inner try
         * a / (a-a) = 1 / 0 → ERROR
         *
         * inner tidak handle
         * naik ke outer
         * outer handle
         *
         * 3. 2 argumen
         * a = 2 → masuk inner try
         * c[42] → ERROR
         *
         * inner handle langsung
         * outer gak ikut
         * 
         * -----------------------------------
         *
         * Pola Penting
         *
         * Ini inti nested try:
         *
         * Inner try → gak bisa handle → naik ke outer try
         * Alur lengkap
         * try dalam → catch cocok? → ya → selesai
         *                          → tidak → lempar ke luar
         * outer try → catch cocok? → ya → selesai
         *                          → tidak → lanjut keluar
         */

        // Nested via Method (Lebih Dalam Lagi)
        try {
            int a = args.length;
            int b = 42 / a; // Error bisa disini
            System.out.println(a);
            // Panggil method
            nesttry(a);
        } catch (ArithmeticException e) {
            System.out.println("Divide by 0: " + e);
        }

        /**
         * Walaupun beda method, tetap dianggap nested
         * main() → manggil method → di dalam method ada try
         * tetap satu “alur stack”
         *
         * ----------------------------------
         * 
         * Kesimpulan Penting 
         *
         * Ini inti kerasnya:
         * try bisa di dalam try
         * Exception akan naik kalau tidak ditangani
         * Java cek dari dalam ke luar
         *
         * Pola utama:
         * Inner → Outer → Default Handler
         *
         * Kapan pakai nested try?
         * Saat:
         * bagian dalam punya error spesifik
         * bagian luar handle error umum
         *
         * Cara pro
         * inner try → error spesifik
         * outer try → error umum
         */

    }
}
