package FundamentalJava.ExceptionHandling;

    /**
     * throw
     *
     * Selama ini lu cuma menangkap exception dari Java.
     * Tapi sebenarnya, lu juga bisa melempar exception sendiri pakai throw.
     *
     * Bentuk umum:
     * throw ThrowableInstance;
     *
     * ThrowableInstance harus:
     * object dari Throwable atau turunannya
     *
     * Tidak boleh:
     * int, char
     * String, Object
     *
     * Cara mendapatkan object exception
     * Ada 2 cara:
     * Dari parameter catch
     * Buat sendiri pakai new
     *
     * Behavior throw
     * Setelah throw:
     * kode setelahnya tidak dijalankan
     * langsung lompat ke catch
     *
     * Alur
     * Java cari catch terdekat
     * Kalau gak ketemu → naik ke luar
     * Kalau tetap gak ada → default handler (program mati)
     *
     * Intinya
     * throw = “lempar error secara sengaja”
     */

public class Throw {

    // Static Method
    static void demoproc() {
        
        try {
            // Membuat dan melempar exception sendiri
            throw new NullPointerException("Demo");

            // Ini akan error
            // System.out.println("Ini gak akan jalan");
        } catch (NullPointerException e) {
            System.out.println("Caught inside demoproc");
            // Lempar lagi keluar
            throw e;
        }
    }

    public static void main(String[] args) {
        
        try {
            demoproc();
        } catch (NullPointerException e) {
            // Menangkap ulang
            System.out.println("Recaught: " + e);
        }

        /**
         * Output
         * Caught inside demoproc.
         * Recaught: java.lang.NullPointerException: demo
         *
         * Penjelasan Alur (WAJIB PAHAM)
         * Step-by-step
         * main() → panggil demoproc()
         * Di dalam demoproc():
         * throw new NullPointerException("demo")
         * langsung masuk catch
         *
         * print:
         * Caught inside demoproc.
         *
         * throw e → lempar lagi ke luar
         * Balik ke main():
         *
         * ditangkap lagi
         * print:
         * Recaught: java.lang.NullPointerException: demo
         *
         * Ini disebut: rethrow
         * nangkap → lempar lagi
         *
         * --------------------------------------------------
         * 
         * Kesimpulan Penting (WAJIB INGAT)
         *
         * Intinya:
         * throw = lempar exception manual
         * Harus pakai object dari Throwable
         * Setelah throw → kode berhenti
         *
         * Cara bikin exception:
         * throw new ExceptionType("pesan");
         *
         * Alur:
         * throw → cari catch → gak ada → naik → default handler
         */

        /**
         * Insight Tambahan (Level Up)
         * Kenapa throw penting?
         * Buat kontrol logika program
         *
         * Contoh:
         * if (umur < 0) {
         *     throw new IllegalArgumentException("Umur tidak valid");
         * }
         *
         * ini bukan error Java
         * ini error dari logika lu sendiri
         *
         * Constructor Exception
         * Contoh:
         * throw new NullPointerException("demo");
         *
         * "demo" = pesan error
         * Bisa diambil dengan:
         * e.getMessage();
         *
         * ------------------------------------
         * 
         * Hal penting
         * Setelah:
         * throw ...
         *
         * jangan harap kode bawahnya jalan 
         *
         * Contoh salah
         * throw new Exception();
         * System.out.println("Tidak akan jalan"); // 
         *
         * Mindset Pro
         * Exception bukan cuma buat nangkep error
         * tapi buat ngontrol alur program
         */
    }
}
