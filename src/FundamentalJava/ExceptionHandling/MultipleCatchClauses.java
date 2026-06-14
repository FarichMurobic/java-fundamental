package FundamentalJava.ExceptionHandling;

    /**
     * Multiple catch Clauses
     *
     * Kadang, satu blok kode bisa menghasilkan lebih dari satu jenis exception.
     *
     * Untuk menangani ini:
     * kita bisa pakai lebih dari satu catch
     *
     * Cara kerjanya:
     * Saat exception terjadi
     * Java cek setiap catch dari atas ke bawah
     * catch pertama yang cocok → dijalankan
     * Setelah itu, catch lain di-skip
     * Program lanjut setelah blok try-catch
     *
     * Aturan Penting
     * Subclass harus ditaruh sebelum superclass
     *
     * Kenapa?
     * Karena:
     * superclass bisa menangkap semua subclass
     * kalau superclass duluan → subclass gak pernah kepanggil
     *
     * Kesimpulan Penting (WAJIB INGAT)
     * Intinya:
     * Bisa pakai banyak catch
     * Java cek dari atas ke bawah
     * Hanya 1 catch yang dijalankan
     *
     * ATURAN KERAS:
     * Subclass → di atas
     * Superclass → di bawah
     *
     * Cara pro:
     * catch(ArithmeticException e)
     * catch(ArrayIndexOutOfBoundsException e)
     *
     * beda error → beda solusi
     *
     * Real world
     *
     * Misalnya:
     * database error → reconnect
     * file error → minta ulang
     * input error → validasi ulang
     *
     * tiap error beda penanganan
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
