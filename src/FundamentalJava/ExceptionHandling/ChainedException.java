package FundamentalJava.ExceptionHandling;

    /**
     * Kenapa Java punya banyak method ini?
     *
     * Karena:
     * error handling di Java itu bukan cuma nangkep error, tapi ANALISA error
     *
     * Konsepnya
     *
     * Misalnya:
     * method lempar ArithmeticException (bagi 0)
     * tapi penyebab aslinya: error I/O
     *
     * Jadi:
     * error utama: ArithmeticException
     * penyebab: IOException
     *
     * Ini yang disebut chain
     *
     * Constructor baru
     * Throwable(Throwable causeExc)
     * Throwable(String msg, Throwable causeExc)
     *
     * bisa langsung set:
     * pesan
     * penyebab
     *
     * Method penting
     * getCause()
     * initCause(Throwable causeExc)
     * getCause() → ambil penyebab
     * initCause() → set penyebab (setelah object dibuat)
     *
     * Aturan:
     * cause cuma bisa di-set 1 kali
     * kalau sudah di constructor → gak bisa pakai initCause() lagi
     *
     * ------------------------------------------------------------------
     * 
     * INTI BESAR
     * Chained exception itu:
     * menyimpan “akar masalah” dari sebuah error
     *
     * Bayangin:
     * Program error → ArithmeticException
     *         ↓
     * Kenapa? → karena input salah
     *         ↓
     * Kenapa? → karena file gagal dibaca
     *
     * itu chain 
     *
     * Struktur Chain
     * Exception utama
     *     ↓
     * Cause
     *     ↓
     * Cause lagi (opsional)
     *
     * Kenapa ini penting?
     * Tanpa chain:
     * lu cuma tau “error terjadi”
     *
     * Dengan chain:
     * lu tau:
     * error apa
     * kenapa terjadi
     * asal masalah
     *
     * “Chain terlalu panjang = desain jelek”
     *
     * kenapa?
     * terlalu banyak layer
     * susah dipahami
     * indikasi code berantakan
     *
     * KESIMPULAN
     * Chained exception = hubungan antar error
     * membantu debugging
     * bikin error lebih informatif
     * jangan overuse
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
