package FundamentalJava.MultiThreaded;

/**
 * JAVA MEMORY MODEL (JMM) DAN VOLATILE
 *
 * Dalam multithreading:
 *
 * Banyak thread bisa mengakses variabel yang sama.
 *
 * Contoh:
 *
 * int angka = 0;
 *
 * Thread A
 * Thread B
 *
 * Keduanya membaca dan mengubah angka.
 *
 * Masalah:
 *
 * Java tidak menjamin setiap thread selalu membaca nilai terbaru
 * dari main memory.
 *
 * Karena ada optimisasi dari CPU dan JVM.
 */


/**
 * KONSEP DASAR: MAIN MEMORY DAN CPU CACHE
 *
 * Secara sederhana:
 *
 * Main Memory
 *     |
 *     |
 * CPU Cache
 *     |
 *     |
 * Thread
 *
 *
 * CPU punya cache kecil yang jauh lebih cepat dibanding RAM.
 *
 * Untuk performa:
 *
 * CPU tidak selalu mengambil data langsung dari RAM.
 *
 * Bisa terjadi:
 *
 * Main Memory:
 * angka = 0
 *
 *
 * Thread A Cache:
 * angka = 0
 *
 *
 * Thread B Cache:
 * angka = 0
 */


/**
 * MASALAH VISIBILITY
 *
 * Contoh:
 *
 * int angka = 0;
 *
 *
 * Thread A:
 *
 * angka = 10;
 *
 *
 * Thread B:
 *
 * System.out.println(angka);
 *
 *
 * Kita berharap:
 *
 * Output:
 * 10
 *
 *
 * Tapi bisa terjadi:
 *
 * Output:
 * 0
 *
 *
 * Kenapa?
 *
 * Karena perubahan Thread A belum terlihat
 * oleh Thread B.
 *
 * Ini disebut:
 *
 * Visibility Problem
 *
 *
 * Artinya:
 *
 * Satu thread mengubah data,
 * tetapi thread lain belum melihat perubahan tersebut.
 */


/**
 * ANALOGI
 *
 * Tanpa volatile:
 *
 * Ada papan tulis utama.
 *
 * Papan tulis:
 * angka = 0
 *
 *
 * Kamu punya buku catatan:
 * angka = 0
 *
 * Teman kamu punya buku catatan:
 * angka = 0
 *
 *
 * Kamu mengubah buku kamu:
 *
 * angka = 10
 *
 *
 * Tapi teman kamu masih melihat:
 *
 * angka = 0
 *
 *
 * Karena catatan kalian belum sinkron.
 */


/**
 * VOLATILE
 *
 * volatile memberi tahu JVM:
 *
 * "Variabel ini bisa diakses banyak thread.
 * Jangan simpan nilai lama.
 * Selalu baca nilai terbaru."
 *
 *
 * Contoh:
 *
 * volatile boolean running = true;
 *
 *
 * Thread A:
 *
 * running = false;
 *
 *
 * Thread B:
 *
 * while(running){
 *     // kerja
 * }
 *
 *
 * Dengan volatile:
 *
 * Saat Thread A mengubah running:
 *
 * Thread B akan melihat perubahan itu.
 */


/**
 * CONTOH MASALAH TANPA VOLATILE
 */

class Worker {

    boolean running = true;

    void stop() {
        running = false;
    }

    void run() {

        while (running) {

            // melakukan pekerjaan

        }

    }
}


/**
 * Masalah:
 *
 * Thread utama:
 *
 * worker.stop();
 *
 *
 * Mengubah:
 *
 * running = false;
 *
 *
 * Tapi thread worker
 * belum tentu melihat perubahan.
 *
 * Akibatnya:
 *
 * loop bisa terus berjalan.
 */


/**
 * SOLUSI DENGAN VOLATILE
 */

// class Worker {

//     volatile boolean running = true;

//     void stop() {
//         running = false;
//     }

//     void run() {

//         while (running) {

//             // melakukan pekerjaan

//         }

//     }
// }


/**
 * Sekarang:
 *
 * Thread yang menjalankan loop
 * akan melihat perubahan running.
 *
 * Saat:
 *
 * running = false
 *
 * loop berhenti.
 */


/**
 * VOLATILE VS SYNCHRONIZED
 *
 * Ini bagian paling penting.
 *
 *
 * volatile:
 *
 * Fokus:
 * visibility
 *
 * Artinya:
 * semua thread melihat nilai terbaru.
 *
 *
 * synchronized:
 *
 * Fokus:
 * atomicity + locking
 *
 * Artinya:
 * hanya satu thread yang boleh masuk
 * ke bagian kode tertentu.
 */


/**
 * Contoh:
 *
 * count++;
 *
 *
 * Ini terlihat satu operasi.
 *
 * Tapi sebenarnya:
 *
 * 1. baca count
 * 2. tambah 1
 * 3. simpan kembali
 *
 *
 * Misal:
 *
 * Thread A:
 * baca count = 0
 *
 * Thread B:
 * baca count = 0
 *
 * Thread A:
 * simpan 1
 *
 * Thread B:
 * simpan 1
 *
 *
 * Hasil:
 *
 * Harusnya 2
 *
 * Tapi jadi:
 *
 * 1
 *
 *
 * volatile TIDAK bisa memperbaiki ini.
 *
 * Karena masalahnya bukan visibility.
 *
 * Masalahnya:
 * race condition.
 *
 *
 * Solusi:
 *
 * synchronized
 */


/**
 * PERBANDINGAN
 *
 * volatile:
 *
 * "Semua orang harus lihat papan terbaru."
 *
 *
 * synchronized:
 *
 * "Cuma satu orang boleh masuk ruangan."
 */


/**
 * KAPAN MENGGUNAKAN VOLATILE?
 *
 * Cocok untuk:
 *
 * 1. Flag sederhana
 *
 * Contoh:
 *
 * boolean running;
 *
 *
 * 2. Status aplikasi
 *
 * Contoh:
 *
 * serverStarted
 * shutdownRequested
 *
 *
 * 3. Variabel yang hanya satu thread mengubah
 * dan thread lain membaca.
 */


/**
 * KAPAN JANGAN PAKAI VOLATILE?
 *
 * Jangan gunakan untuk:
 *
 * counter
 * transaksi
 * operasi tambah kurang
 * data kompleks
 *
 *
 * Contoh:
 *
 * volatile int count;
 *
 * count++;
 *
 *
 * Tetap tidak aman.
 */


/**
 * HUBUNGAN DENGAN MATERI SEBELUMNYA
 *
 *
 * Race Condition
 *        |
 *        |
 * Synchronization
 *
 *
 * Visibility Problem
 *        |
 *        |
 * volatile
 *
 *
 * Jadi:
 *
 * synchronized = mengatur siapa yang boleh akses
 *
 * volatile = memastikan nilai terlihat antar thread
 */


/**
 * KESIMPULAN SUPER PADAT
 *
 * Multithreading membuat banyak thread mengakses data bersama.
 *
 * CPU punya cache sehingga nilai bisa berbeda antar thread.
 *
 * Masalah:
 *
 * Thread A mengubah data,
 * Thread B belum melihat perubahan.
 *
 * Ini disebut:
 *
 * Visibility Problem.
 *
 *
 * Solusi:
 *
 * volatile:
 * memastikan perubahan terlihat.
 *
 * synchronized:
 * memastikan akses aman.
 *
 *
 * Ingat:
 *
 * volatile = "lihat data terbaru"
 *
 * synchronized = "akses bergantian"
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
