package Lambda;

/**
 * Intinya:
 *
 * Lambda bisa akses:
 * variable di luar dirinya (enclosing scope)
 *
 * Contoh:
 * variable lokal
 * variable instance (object)
 * variable static
 *
 * Tapi ada aturan penting:
 * Kalau lambda pakai variable lokal
 * variable itu harus effectively final
 *
 * ------------------------------------
 * 
 * Apa itu effectively final?
 * Variable yang nilainya tidak berubah setelah di-set
 *
 * Contoh:
 * int num = 10; // ini effectively final
 *
 * Kalau diubah:
 * num = 20; // sekarang TIDAK effectively final
 *
 * Maka:
 * tidak bisa dipakai di lambda
 */

/**
 * Perbedaan penting (INI KRUSIAL)
 *
 * Local Variable
 * int num = 10;
 *
 * tidak boleh diubah
 *
 * Instance Variable
 * class Test {
 *     int num = 10;
 * }
 *
 * BOLEH diubah di lambda
 *
 * Static Variable
 * static int num = 10;
 *
 * BOLEH diubah
 *
 * Tentang this (bonus penting)
 * Di lambda:
 * this
 *
 * mengacu ke:
 * object dari class luar
 *
 * BEDA dengan:
 * anonymous class (punya this sendiri)
 *
 * -------------------------------------------
 * 
 * Insight Mentor
 * 1. Lambda bukan scope baru seperti method
 * dia “numpang” ke scope luar
 *
 * 2. Ini alasan kenapa ada restriction
 * untuk:
 * thread safety
 * konsistensi data
 *
 * 3. Ini sering kepake di:
 * Stream API
 * loop processing
 * filter/map
 *
 * 4. Ini konsep “closure”
 * lambda membawa:
 * code
 * data dari luar
 *
 * -------------------------------------
 * 
 * Kesimpulan Super Sederhana
 * 1. Lambda bisa akses variable luar
 *
 * 2. Local variable harus effectively final
 *
 * 3. Tidak boleh diubah
 * di dalam lambda
 * atau setelah lambda dibuat
 *
 * 4. Instance & static boleh diubah
 *
 * 5. Ini disebut variable capture (closure)
 */

// functional interface
interface Nomor {
    // methode menerima int
    int nomor(int n);
}
public class VariableCaptureClosure {
    public static void main(String[] args) {

        int num = 10;
        int num2 = 20;
        num2 = 50;

        Nomor myLambda = (n) -> {
            // ini boleh
            int v = num + n;

            // ini tidak boleh
            // Ini TIDAK BOLEH (modifikasi variable luar)
            // num = 20;

            // ini tidak boleh
            // Ini TIDAK BOLEH (modifikasi variable luar)
            // num++;

            // ini tidak boleh
            // Ini TIDAK BOLEH (modifikasi variable luar)
            // v = num + num2;

            return v;
        };

        // ini juga tidak boleh, meski diluar block lambda
        // karena mengubah num setelah dipakai lambda
        // num = 100;

        /**
         * 1. Variable capture itu apa?
         * int num = 10;
         *
         * (n) -> num + n
         * Lambda “mengambil” num dari luar
         *
         * ini disebut:
         * Variable Capture
         *
         * 2. Kenapa harus effectively final?
         * Karena:
         * Java mau jaga konsistensi data
         * biar gak terjadi bug aneh saat runtime
         *
         * Analogi:
         * Bayangin:
         * lambda “foto” variable saat dibuat
         *
         * kalau variable berubah:
         * “foto” jadi gak valid
         *
         * 3. Ini yang BOLEH
         * int num = 10;
         *
         * (n) -> num + n;
         * cuma baca → aman
         *
         * 4. Ini yang TIDAK BOLEH
         * int num = 10;
         *
         * (n) -> {
         *     num++; // ERROR
         *     return num + n;
         * };
         *
         * 5. Ini juga ERROR
         * int num = 10;
         *
         * MyFunc f = (n) -> num + n;
         *
         * num = 20; // ERROR
         *
         * walaupun di luar lambda
         * tetap bikin num gak final
         */
    }
}
