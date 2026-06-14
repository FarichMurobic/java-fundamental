package FundamentalJava.MultiThreaded;

/**
 * Dalam multithreading:
 *
 * Satu variabel bisa diakses banyak thread
 * TAPI…
 * Setiap thread kadang nyimpen versi sendiri dari variabel itu (di CPU cache)
 *
 * Nah di sinilah masalah mulai muncul
 *
 * Step by Step (Visualisasi)
 * Misal kita punya variabel:
 * int angka = 0;
 *
 * Dan ada:
 * Thread A
 * Thread B
 *
 * Yang lu kira terjadi:
 * Semua thread pakai 1 variabel yang sama
 *
 * Thread A ─┐
 *           ├── angka = 0 (1 sumber)
 * Thread B ─┘
 *
 * Yang sebenarnya bisa terjadi:
 * Setiap thread punya salinan sendiri
 *
 * Main Memory (asli)
 * angka = 0
 *
 * Thread A (copy sendiri) → angka = 0
 * Thread B (copy sendiri) → angka = 0
 *
 * Masalahnya mulai di sini
 * Step 1:
 * Thread A ubah nilai:
 * angka = 10;
 *
 * TAPI…
 * yang berubah cuma copy milik Thread A
 *
 * Thread A → angka = 10
 * Thread B → angka = 0 (belum tau perubahan)
 * Main Memory → mungkin masih 0
 *
 * Step 2:
 * Thread B baca nilai:
 * System.out.println(angka);
 *
 * Outputnya bisa:
 * 0
 *
 * Padahal harusnya:
 * 10
 *
 * Kenapa bisa gitu?
 * Karena:
 * CPU nyimpen data di cache (memori cepat)
 *
 * Jadi:
 * Thread gak selalu langsung baca dari "memori utama"
 * Dia baca dari cache sendiri
 *
 * Analogi Paling Gampang
 *
 * Bayangin lu dan temen lu kerja bareng:
 * Tanpa volatile
 *
 * Ada papan tulis utama (data asli)
 * Tapi kalian nyatet di buku masing-masing
 * Papan tulis: angka = 0
 *
 * Lu (Thread A): catatan = 0
 * Temen (Thread B): catatan = 0
 *
 * Lu ubah:
 * catatan lu = 10
 *
 * Temen lu?
 * masih lihat = 0
 *
 * Gak sinkron 
 *
 * Perbaikan Analogi (Lebih Akurat)
 * Tanpa volatile (yang bener-bener terjadi)
 *
 * Bayangin:
 * Ada papan tulis utama (Main Memory)
 * Tapi tiap orang punya buku catatan sendiri (CPU Cache)
 * Papan tulis: angka = 0
 *
 * Thread A: catatan = 0
 * Thread B: catatan = 0
 *
 * Masalahnya di sini:
 * Thread A ubah nilai:
 * Thread A: catatan = 10
 *
 * Tapi:
 * Dia BELUM tentu langsung nulis ke papan tulis
 * Jadi papan tulis masih:
 * Papan tulis: angka = 0
 * Thread B baca:
 * Thread B baca dari catatan sendiri → 0
 *
 * Jadi:
 * Thread A lihat: 10
 * Thread B lihat: 0
 *
 * Nah ini baru "data beda antar thread"
 *
 * Jadi inti koreksinya:
 *
 * Masalah BUKAN:
 *
 * semua thread lihat papan tulis
 *
 * Masalahnya:
 *
 * thread bisa baca dari cache masing-masing, bukan dari sumber utama
 *
 * Dengan volatile
 *
 * Semua orang:
 * HARUS lihat langsung ke papan tulis
 * Papan tulis: angka = 10
 * Semua thread baca ini langsung
 *
 * Jadi selalu update 
 *
 * Kenapa Java bikin sistem kayak gini?
 *
 * Karena:
 * Performance (kecepatan)
 *
 * Akses RAM lambat
 * Cache CPU cepat
 *
 * Jadi Java (dan CPU) mikir:
 * “Gua simpen copy aja biar cepat”
 *
 * TAPI…
 * efek sampingnya: data bisa beda-beda antar thread
 *
 * Kesimpulan Super Simpel
 * Banyak thread = banyak yang akses variabel
 * Setiap thread bisa punya copy sendiri
 * Copy ini bisa ketinggalan update
 *
 * Akibatnya:
 * data gak sinkron
 * bug aneh
 * hasil tidak konsisten
 *
 * Solusi (nyambung ke materi)
 * volatile → paksa semua thread pakai data terbaru
 * synchronized → kontrol akses biar aman
 */

// TANPA VOLATILE
class TanpaVolatile {
    static boolean running = true;
}

public class MultiThreadVolatile {
    public static void main(String[] args) {

        TanpaVolatile tanpaVolatile = new TanpaVolatile();

        // Thread 1
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 mulai...");
            while (TanpaVolatile.running) {
                // loop terus nunggu running false
            }
            System.out.println("Thread 1 berhenti.");
        });

        // Thread 2
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Thread 2 ubah running jadi false
            System.out.println("Thread 2 ubah running jadi false");
            TanpaVolatile.running = false;
        });
 
        thread1.start();
        thread2.start();

        /**
         * Yang BISA TERJADI
         *
         * Output:
         * Thread 1 mulai...
         * Thread 2 ubah running jadi false
         *
         * Tapi...
         * Thread 1 berhenti!
         *
         * TIDAK MUNCUL
         */


    }
}
