package FundamentalJava.ExceptionHandling;

/**
 * ------------------------------------------------------------
 * MULTIPLE CATCH CLAUSES
 * ------------------------------------------------------------
 *
 * Dalam Java, satu blok kode sering kali berpotensi menghasilkan
 * lebih dari satu jenis exception.
 *
 * Contoh:
 * - Pembagian dengan nol -> ArithmeticException
 * - Akses index array di luar batas -> ArrayIndexOutOfBoundsException
 * - Parsing angka gagal -> NumberFormatException
 *
 * Untuk menangani kondisi seperti ini, Java mengizinkan penggunaan
 * beberapa blok catch setelah satu blok try.
 *
 * ------------------------------------------------------------
 * CARA KERJA MULTIPLE CATCH
 * ------------------------------------------------------------
 *
 * Ketika exception terjadi di dalam blok try:
 *
 * 1. Eksekusi try langsung berhenti.
 * 2. JVM mencari catch yang cocok.
 * 3. Pencarian dilakukan dari atas ke bawah.
 * 4. Catch pertama yang cocok akan dieksekusi.
 * 5. Catch lainnya dilewati.
 * 6. Program dilanjutkan setelah struktur try-catch selesai.
 *
 * Contoh:
 *
 * try {
 *     int result = 10 / 0;
 * }
 * catch (ArithmeticException e) {
 *     System.out.println("Arithmetic Error");
 * }
 * catch (Exception e) {
 *     System.out.println("General Error");
 * }
 *
 * Output:
 * Arithmetic Error
 *
 * Karena ArithmeticException cocok dengan catch pertama,
 * catch kedua tidak akan dijalankan.
 *
 * ------------------------------------------------------------
 * URUTAN CATCH (SANGAT PENTING)
 * ------------------------------------------------------------
 *
 * Java mengevaluasi catch secara berurutan.
 *
 * Oleh karena itu:
 *
 * Subclass exception HARUS ditempatkan sebelum superclass.
 *
 * Benar:
 *
 * catch (ArithmeticException e) { }
 * catch (RuntimeException e) { }
 * catch (Exception e) { }
 *
 * Salah:
 *
 * catch (Exception e) { }
 * catch (ArithmeticException e) { } // COMPILE ERROR
 *
 * Mengapa?
 *
 * Karena Exception adalah superclass dari
 * ArithmeticException.
 *
 * Jika Exception diletakkan terlebih dahulu,
 * maka semua ArithmeticException sudah tertangkap
 * oleh catch Exception.
 *
 * Akibatnya:
 * catch ArithmeticException tidak akan pernah bisa dijalankan.
 *
 * Java mendeteksi hal ini saat compile dan menghasilkan:
 *
 * unreachable catch block
 *
 * ------------------------------------------------------------
 * HIERARKI EXCEPTION DAN PENGARUHNYA
 * ------------------------------------------------------------
 *
 * Contoh hierarki:
 *
 * Throwable
 *     |
 *     +-- Exception
 *            |
 *            +-- RuntimeException
 *                    |
 *                    +-- ArithmeticException
 *                    +-- NullPointerException
 *                    +-- NumberFormatException
 *
 * Karena pewarisan (inheritance):
 *
 * catch(Exception e)
 *
 * dapat menangkap:
 *
 * - ArithmeticException
 * - NullPointerException
 * - NumberFormatException
 * - IOException
 * - dan semua subclass Exception lainnya
 *
 * Oleh sebab itu:
 * catch yang lebih spesifik sebaiknya ditulis terlebih dahulu.
 *
 * ------------------------------------------------------------
 * MULTI-CATCH (JAVA 7+)
 * ------------------------------------------------------------
 *
 * Sejak Java 7, beberapa exception yang ditangani
 * dengan cara yang sama dapat digabungkan dalam satu catch.
 *
 * Contoh:
 *
 * try {
 *     // kode
 * }
 * catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
 *     System.out.println("Kesalahan operasi");
 * }
 *
 * Keuntungan:
 *
 * - Kode lebih ringkas
 * - Tidak ada duplikasi logika
 * - Lebih mudah dirawat (maintainable)
 *
 * Catatan:
 *
 * Variabel exception pada multi-catch bersifat
 * implicitly final.
 *
 * Artinya:
 *
 * e = new Exception(); // ERROR
 *
 * tidak diperbolehkan.
 *
 * ------------------------------------------------------------
 * KAPAN MENGGUNAKAN BANYAK CATCH?
 * ------------------------------------------------------------
 *
 * Gunakan multiple catch ketika:
 *
 * - Setiap jenis exception membutuhkan penanganan berbeda.
 * - Tindakan pemulihan (recovery) berbeda.
 * - Pesan error yang ditampilkan berbeda.
 *
 * Contoh:
 *
 * DatabaseException
 * -> reconnect database
 *
 * FileNotFoundException
 * -> minta user memilih file lain
 *
 * NumberFormatException
 * -> minta user memasukkan angka yang valid
 *
 * Setiap error memiliki solusi yang berbeda,
 * sehingga sebaiknya dipisahkan ke catch yang berbeda.
 *
 * ------------------------------------------------------------
 * PRAKTIK MODERN JAVA
 * ------------------------------------------------------------
 *
 * Hindari pola berikut:
 *
 * catch (Exception e) {
 *     // diam saja
 * }
 *
 * atau
 *
 * catch (Exception e) {
 * }
 *
 * Karena:
 *
 * - Menyembunyikan bug
 * - Menyulitkan debugging
 * - Membuat error sulit dilacak
 *
 * Lebih baik:
 *
 * - Tangkap exception yang spesifik
 * - Berikan penanganan yang sesuai
 * - Catat (log) error bila diperlukan
 *
 * Contoh:
 *
 * catch (NumberFormatException e) {
 *     System.out.println("Input harus berupa angka.");
 * }
 *
 * ------------------------------------------------------------
 * RINGKASAN
 * ------------------------------------------------------------
 *
 * - Satu try dapat memiliki banyak catch.
 * - Java memeriksa catch dari atas ke bawah.
 * - Hanya satu catch yang akan dieksekusi.
 * - Subclass harus ditulis sebelum superclass.
 * - Java 7+ mendukung multi-catch menggunakan operator |.
 * - Tangkap exception yang spesifik jika memungkinkan.
 * - Hindari catch(Exception) tanpa alasan yang jelas.
 *
 * Mindset OOP:
 *
 * Exception yang berbeda merepresentasikan
 * jenis kegagalan yang berbeda.
 *
 * Karena itu:
 * error yang berbeda seharusnya dapat memiliki
 * strategi penanganan yang berbeda pula.
 */

public class MultipleCatchClauses {
    public static void main(String[] args) {
        
        try {
            int a = args.length;
            System.out.println("a = " + a); // 0

            int b = 42 / a; // Program sampai disini
            // Ini gak di excecute
            int[] c = {1};
            c[42] = 9;
        } catch (ArithmeticException e) {
            System.out.println("Divide by 0: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index oob: " + e);
        }

        System.out.println("After try/catch blocks.");

        /**
         * Output
         * 
         * a = 0
         * Divide by 0: java.lang.ArithmeticException: / by zero
         * After try/catch blockcs.
         *
         * karena:
         * a = 0
         * 42 / 0 → error
         *
         * Dengan argumen:
         * a = 1
         * Array index oob: java.lang.ArrayIndexOutOfBoundsException: 42
         * After try/catch blocks.
         *
         * karena:
         * pembagian aman
         * tapi c[42] → error
         */

        // CONTOH SALAH ERROR
        try {
            int a = args.length; // 0
            int b = 42 / a;
        } catch (Exception e) {
            System.out.println("Generics Exception catch.");
        } // catch (ArithmeticException e) { // ini error
          //     System.out.println("This is never reached.");
          // }

        /**
         * Ini ERROR karena:
         * 
         * Exception sudah menangkap semuanya
         * ArithmeticException jadi tidak pernah dipakai
         *
         * Cara Kerja Multiple Catch
         * Bayangin kayak filter:
         * try → error → cek catch 1 → cocok? ya → stop
         *                           → tidak → cek catch 2
         *
         * Urutan itu KRITIS
         * Contoh:
         * catch(Exception e)
         * catch(ArithmeticException e)
         *
         * Salah 
         *
         * Karena:
         * Exception = induk
         * dia nangkep semua error
         *
         * Yang benar:
         * catch(ArithmeticException e)
         * catch(Exception e)
         *
         * spesifik dulu, baru umum
         */

        System.out.println();

        // CONTOH MULTIPLE CATCTH
        try {
            int a = args.length;
            System.out.println(a);  // 0

            int b = 42 / a; // Error

            int[] c = {1};
            c[42] = 99; // Error
        } catch (ArithmeticException e) { // Spesifik dulu
            System.out.println("Error pembagian: " + e);
        } catch (ArrayIndexOutOfBoundsException e) { // Spesifik dulu
            System.out.println("Error Array: " + e);
        } catch (Exception e) { // Baru superclass
            System.out.println(e);
        }

        System.out.println("Program lanjut!");
 
        int aa = 0;
        System.out.println(aa);
        // Exception in thread "main" java.lang.ArithmeticException: / by zero
        // ERROR RUNTIME
        int bb = 42 / aa;
        System.out.println(bb);

    }
}
