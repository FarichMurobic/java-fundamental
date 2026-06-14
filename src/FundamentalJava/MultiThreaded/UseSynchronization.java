package FundamentalJava.MultiThreaded;

/**
     * Synchronization
     *
     * Ketika dua atau lebih thread ingin mengakses resource yang sama, 
     * mereka butuh cara agar resource itu hanya dipakai
     * oleh satu thread dalam satu waktu. Proses ini disebut synchronization.
     *
     * Konsep utama dari synchronization adalah monitor.
     * Monitor adalah object yang berfungsi sebagai kunci (lock).
     *
     * Hanya 1 thread yang bisa pegang monitor dalam satu waktu
     * Saat thread dapat lock → dia “masuk monitor”
     * Thread lain yang mau masuk → ditahan (waiting)
     * Setelah thread keluar → thread lain boleh masuk
     *
     * Synchronized Methods
     * Di Java, setiap object otomatis punya monitor sendiri.
     *
     * Cara pakainya:
     * Tambahkan keyword synchronized ke method
     * Kalau satu thread lagi jalan di method itu → thread lain harus nunggu
     *
     * Masalah Tanpa Synchronization (Race Condition)
     *
     * Program contoh:
     * Ada class Callme
     * Method call() print string dalam bracket [msg]
     * Tapi ada Thread.sleep(1000) → bikin thread pause
     *
     * Karena pause ini:
     * Thread lain bisa masuk
     * Output jadi acak / campur
     *
     * Contoh output:
     * Hello[Synchronized[World]
     * ]
     * ]
     *
     * Ini disebut race condition
     * → karena thread “balapan” akses method yang sama
     *
     * Solusinya
     * Tambahin:
     * synchronized void call(String msg)
     *
     * Hasil:
     * [Hello]
     * [Synchronized]
     * [World]
     *
     * Sekarang:
     * Thread masuk satu per satu
     * Output rapi
     *
     * Race Condition
     * Terjadi saat banyak thread akses data yang sama
     * Hasil bisa random / tidak konsisten
     *
     * Monitor (Lock)
     * Setiap object punya “kunci”
     * Dipakai untuk kontrol akses thread
     *
     * synchronized
     * Fungsi:
     * Bikin method hanya bisa dipakai 1 thread dalam satu waktu
     *
     * Behavior penting
     *
     * Kalau ada:
     * synchronized void A()
     * synchronized void B()
     *
     * Thread yang masuk A
     * Thread lain TIDAK bisa masuk B juga
     *
     * karena lock-nya di object yang sama
     *
     * Non-synchronized method
     * Masih bisa dipanggil bebas:
     * void biasa()
     *
     * synchronized itu bukan soal method, tapi soal:
     * “SIAPA YANG MEGANG LOCK OBJECT”
     *
     * Masalah concurrency itu:
     * kadang tidak kelihatan
     * bisa jalan normal → tiba-tiba bug
     *
     * Makanya:
     * race condition itu salah satu bug paling bahaya di programming
     *
     * Kesimpulan Singkat
     * Banyak thread = potensi konflik
     * Konflik = race condition
     * Solusi = synchronized
     * synchronized = lock object → satu thread saja
     */

    /**
     * Dalam multithreading, masalah utama adalah:
     * Banyak thread akses object yang sama secara bersamaan
     *
     * Contoh sederhana:
     * balance = balance - 100;
     *
     * Kelihatannya aman, tapi sebenarnya ini bukan 1 langkah. Di dalam CPU, itu jadi:
     * Ambil nilai balance
     * Kurangi 100
     * Simpan lagi
     *
     * Kalau ada 2 thread:
     * Thread A & B baca balance = 1000
     * A simpan 900
     * B juga simpan 900
     *
     * Harusnya 800, tapi jadi 900 → ERROR
     *
     * Ini disebut:
     * Race Condition
     *
     * KONSEP DASAR: MONITOR (LOCK)
     *
     * Di Java:
     * Setiap object punya lock (monitor)
     * Lock ini seperti kunci pintu
     * Aturan:
     * Hanya 1 thread boleh pegang lock
     * Thread lain → nunggu
     *
     * SYNCHRONIZED = NGUNCI OBJECT
     *
     * Ada 2 cara:
     * synchronized method
     * synchronized block (nanti kita bahas kalau lanjut)
     *
     * Sekarang fokus ke method dulu.
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
