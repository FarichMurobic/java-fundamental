package FundamentalJava.MultiThreaded;

/**
 * ------------------------------------------------------------------------
 * SYNCHRONIZATION (SINKRONISASI)
 * ------------------------------------------------------------------------
 * 
 * Ketika dua atau lebih thread ingin mengakses resource yang sama,
 * mereka membutuhkan mekanisme agar resource tersebut hanya digunakan
 * oleh satu thread dalam satu waktu. Proses ini disebut synchronization..
 * 
 * ------------------------------------------------------------------------
 * KONSEP DASAR: MONITOR (LOCK)
 * ------------------------------------------------------------------------
 * 
 * Konsep utama dari synchronization adalah monitor.
 * 
 * Monitor adalah objek yang berfungsi sebagai kunci (lock).
 * - Hanya 1 thread yang bisa memegang monitor dalam satu waktu
 * - Saat thread mendapatkan lock → dia "masuk monitor"
 * - Thread lain yang ingin masuk → ditahan (waiting)
 * - Setelah thread keluar → thread lain boleh masuk
 * 
 * Di Java:
 * Setiap objek secara otomatis memiliki monitor sendiri.
 * Lock ini seperti kunci pintu.
 * Aturan: Hanya 1 thread yang boleh memegang lock.
 * 
 * ------------------------------------------------------------------------
 * SYNCHRONIZED METHODS
 * ------------------------------------------------------------------------
 * 
 * Cara penggunaan:
 * Tambahkan keyword synchronized ke method.
 * 
 * Jika satu thread sedang menjalankan method tersebut,
 * thread lain harus menunggu.
 * 
 * synchronized void call(String msg) {
 * // kode kritis
 * }
 * 
 * ------------------------------------------------------------------------
 * MASALAH TANPA SYNCHRONIZATION (RACE CONDITION)
 * ------------------------------------------------------------------------
 * 
 * Program contoh:
 * Ada class Callme dengan method call() yang mencetak string dalam bracket.
 * 
 * void call(String msg) {
 * System.out.print("[" + msg);
 * Thread.sleep(1000);
 * System.out.println("]");
 * }
 * 
 * Karena ada Thread.sleep(1000) yang membuat thread pause,
 * thread lain bisa masuk di tengah-tengah eksekusi.
 * 
 * Contoh output yang salah:
 * Hello[Synchronized[World]
 * ]
 * ]
 * 
 * Ini disebut race condition.
 * Terjadi karena thread "balapan" mengakses method yang sama secara bersamaan.
 * 
 * ------------------------------------------------------------------------
 * SOLUSI DENGAN SYNCHRONIZED
 * ------------------------------------------------------------------------
 * 
 * Tambahkan keyword synchronized:
 * 
 * synchronized void call(String msg) {
 * System.out.print("[" + msg);
 * Thread.sleep(1000);
 * System.out.println("]");
 * }
 * 
 * Hasil output yang benar:
 * [Hello]
 * [Synchronized]
 * [World]
 * 
 * Sekarang:
 * - Thread masuk satu per satu
 * - Output rapi dan konsisten
 * 
 * ------------------------------------------------------------------------
 * RACE CONDITION
 * ------------------------------------------------------------------------
 * 
 * Terjadi saat banyak thread mengakses data yang sama secara bersamaan
 * tanpa sinkronisasi yang tepat.
 * 
 * Hasilnya bisa:
 * - Random
 * - Tidak konsisten
 * - Sulit direproduksi
 * 
 * Contoh klasik:
 * 
 * balance = balance - 100;
 * 
 * Kelihatannya aman, tapi sebenarnya ini bukan 1 langkah.
 * Di dalam CPU, operasi ini terbagi menjadi:
 * 1. Ambil nilai balance dari memory
 * 2. Kurangi dengan 100
 * 3. Simpan kembali ke memory
 * 
 * Masalah terjadi ketika ada 2 thread:
 * 
 * Thread A dan B sama-sama membaca balance = 1000
 * Thread A menyimpan 900
 * Thread B juga menyimpan 900
 * 
 * Seharusnya balance menjadi 800, tapi malah 900.
 * Ini adalah ERROR akibat race condition.
 * 
 * ------------------------------------------------------------------------
 * BEHAVIOR PENTING SYNCHRONIZED
 * ------------------------------------------------------------------------
 * 
 * Jika sebuah class memiliki:
 * 
 * synchronized void methodA()
 * synchronized void methodB()
 * 
 * Thread yang masuk ke methodA,
 * thread lain TIDAK bisa masuk ke methodB juga.
 * 
 * Karena lock-nya ada di objek yang SAMA.
 * 
 * Method non-synchronized:
 * void methodBiasa()
 * 
 * Masih bisa dipanggil dengan bebas oleh thread mana pun,
 * meskipun ada thread lain yang sedang memegang lock.
 * 
 * ------------------------------------------------------------------------
 * PENTING!
 * ------------------------------------------------------------------------
 * 
 * synchronized bukan tentang method, tapi tentang:
 * "SIAPA YANG MEMEGANG LOCK OBJECT"
 * 
 * ------------------------------------------------------------------------
 * BAHAYA RACE CONDITION
 * ------------------------------------------------------------------------
 * 
 * Masalah concurrency:
 * - Kadang tidak terlihat
 * - Bisa berjalan normal → tiba-tiba bug
 * - Sulit dilacak dan direproduksi
 * 
 * Race condition adalah salah satu bug paling berbahaya
 * dalam pemrograman multithread.
 * 
 * ------------------------------------------------------------------------
 * KESIMPULAN SINGKAT
 * ------------------------------------------------------------------------
 * 
 * - Banyak thread → potensi konflik
 * - Konflik → race condition
 * - Solusi → synchronized
 * - synchronized = lock object → hanya 1 thread yang boleh masuk
 * - Hati-hati dengan race condition, sulit dilacak dan berbahaya
 * 
 * ------------------------------------------------------------------------
 */

// contoh sederhana syncronized
class CallMe {
    // METHODE SYNCHRONIZE
    synchronized void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("]");
    }
}

public class UseSynchronization {
    public static void main(String[] args) {

        CallMe callMe = new CallMe();
        callMe.call("Farich");

        CallMe callme1 = new CallMe();
        callme1.call("Murobic");

    }
}
