package FundamentalJava.ExceptionHandling;

    /**
     * Displaying a Description of an Exception
     * Class Throwable meng-override method toString() (dari Object),
     * sehingga bisa mengembalikan string yang berisi deskripsi exception.
     * Lu bisa menampilkan deskripsi ini pakai println() dengan cara langsung memasukkan object exception sebagai argumen.
     *
     * Contoh:
     *
     * catch (ArithmeticException e) {
     *   System.out.println("Exception: " + e);
     *   a = 0; // set a jadi nol dan lanjutkan program
     * }
     *
     * Output:
     * Exception: java.lang.ArithmeticException: / by zero
     *
     * Walaupun terlihat sederhana, kemampuan ini sangat berguna:
     * saat eksperimen dengan exception
     * saat debugging
     *
     * Apa itu e?
     * catch (ArithmeticException e)
     *
     * e itu object exception
     *
     * Isi dalamnya:
     * jenis error
     * pesan error
     * informasi tambahan
     *
     * Kenapa bisa langsung di-print?
     * Karena di Java:
     * System.out.println(e);
     *
     * itu otomatis manggil:
     * e.toString();
     * Dan toString() di Throwable sudah di-custom jadi:
     * ngasih deskripsi error
     *
     * Hasilnya jadi kayak gini:
     * java.lang.ArithmeticException: / by zero
     *
     * Artinya:
     *
     * java.lang.ArithmeticException → jenis error
     * / by zero → pesan error
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
            int[] data = {1, 2, 3};
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
         * Terjadi error: java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3
         * Index 5 out of bounds for length 3
         * java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 3
         * 	at ExceptionHandling.Eksperimen.main(Eksperimen.java:76)
         *
         * Kesimpulan Penting (WAJIB INGAT)
         *
         * Intinya:
         *
         * e = object exception
         * System.out.println(e) → otomatis panggil toString()
         * Output berisi:
         * jenis exception
         * pesan error
         *
         * Tips penting
         * Kalau lagi belajar / debugging:
         * SELALU tampilkan exception
         * jangan disembunyiin
         */
    }
}
