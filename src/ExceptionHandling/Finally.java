package ExceptionHandling;

    /**
     * finally
     *
     * Saat exception terjadi, alur program bisa berubah drastis (tidak normal).
     * Bahkan bisa bikin method berhenti sebelum waktunya.
     *
     * Contoh masalah:
     * method buka file di awal
     * tapi karena error, bagian tutup file tidak dijalankan 
     *
     * Di sinilah finally dipakai
     *
     * -----------------------------------
     * 
     * Fungsi finally
     *
     * finally adalah blok kode yang:
     * dijalankan setelah try/catch selesai
     * selalu dijalankan, apapun yang terjadi
     *
     * Kondisi finally tetap jalan:
     *
     * Ada exception
     * Tidak ada exception
     * Ada return di dalam try
     * Bahkan kalau exception tidak tertangkap
     *
     * Catatan:
     * finally itu opsional
     * Tapi setiap try harus punya:
     * catch, atau
     * finally
     *
     * --------------------------------------
     * 
     * Intinya
     * finally = “kode yang pasti dijalankan”
     *
     * Analogi
     * Bayangin:
     * try     = kerja
     * catch   = kalau ada masalah
     * finally = beres-beres sebelum pulang
     *
     * Mau kerja lancar atau kacau,
     * tetap harus beres-beres 
     *
     * Kesimpulan Penting (WAJIB INGAT)
     *
     * Ini inti kerasnya:
     * finally SELALU dijalankan
     * Bahkan kalau:
     * ada error
     * ada return
     * tidak ada catch
     *
     * Urutan eksekusi:
     * try → catch (kalau ada) → finally → lanjut
     *
     * -------------------------------------------------
     * 
     * Insight Tambahan (Level Up)
     * Kapan pakai finally?
     *
     * Saat lu butuh “cleanup”
     *
     * Contoh:
     * tutup file
     * tutup database
     * tutup koneksi network
     * 
     * Contoh real
     * try {
     *     // buka file
     * } finally {
     *     // tutup file (WAJIB)
     * }
     *
     * Cara pro
     * cleanup di finally
     *
     * finally itu soal keamanan resource
     *
     * Kalau gak pakai:
     * memory leak
     * file gak ketutup
     * koneksi numpuk
     *
     * Ringkasan SUPER SINGKAT
     * try     = coba jalanin
     * catch   = tangkap error
     * finally = selalu dijalankan
     */

public class Finally {

    // Contoh 1 ada 1 error
    static void procA() {

        try {
            System.out.println("inside procA");
            throw new RuntimeException("Demo"); // ERROR
        } finally {
            // Tetap dijalankan meskipun ada error
            System.out.println("procA's finally");
        }
    }

    // Contoh 2 ada retur
    static void procB() {

        try {
            System.out.println("inside procB");
            return; // Keluar method
        } finally {
            // Tetap dijalankan sebelum return
            System.out.println("procB's finally");
        }
    }

    // Contoh 3 normal
    static void procC() {

        try {
            System.out.println("inside proc'C");
        } finally {
            // Tetp dijalankan
            System.out.println("proC's finally");
        }
    }

    public static void main(String[] args) {

        // Method 1
        try {
            procA();
        } catch (Exception e) {
            System.out.println("Exception caught");
        } 

        System.out.println();

        // Method 2
        procB();

        System.out.println();

        // Method 3
        procC();

        /**
         * Output
         * inside procA
         * procA's finally
         * Exception caught
         *
         * inside procB
         * procB's finally
         *
         * inside procC
         * procC's finally
         * 
         * ---------------------------------
         *
         * Penjelasan Per Kasus
         * procA (Ada Exception)
         * throw → finally → catch
         *
         * walaupun error, finally tetap jalan dulu
         *
         * procB (Ada return)
         * return → finally → keluar method
         *
         * finally tetap jalan sebelum keluar
         *
         * procC (Normal)
         * try selesai → finally jalan
         *
         * tetap dieksekusi
         */
       
    }
}
