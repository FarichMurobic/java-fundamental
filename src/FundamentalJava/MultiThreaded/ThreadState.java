package FundamentalJava.MultiThreaded;

/**
 * ------------------------------------------------------------------------
 * THREAD STATE (STATUS THREAD)
 * ------------------------------------------------------------------------
 * 
 * Java memiliki method:
 * Thread.State getState()
 * 
 * Digunakan untuk melihat status thread saat ini.
 * Return value berupa enum Thread.State..
 * 
 * ------------------------------------------------------------------------
 * DAFTAR STATE LENGKAP
 * ------------------------------------------------------------------------
 * 
 * State | Arti
 * --------------------|---------------------------------------------------
 * NEW | Thread belum dimulai
 * RUNNABLE | Sedang berjalan atau siap berjalan
 * BLOCKED | Menunggu lock (synchronized)
 * WAITING | Menunggu tanpa batas waktu
 * TIMED_WAITING | Menunggu dengan batas waktu
 * TERMINATED | Sudah selesai dieksekusi
 * 
 * ------------------------------------------------------------------------
 * PENJELASAN MENDALAM
 * ------------------------------------------------------------------------
 * 
 * 1. NEW
 * 
 * Thread baru saja dibuat, tapi belum dipanggil start().
 * 
 * Thread t = new Thread(...);
 * // Statusnya: NEW
 * 
 * Masih "calon thread" atau thread dalam bentuk objek saja.
 * 
 * 2. RUNNABLE
 * 
 * Thread sudah siap berjalan atau sedang berjalan.
 * 
 * Penting:
 * Ini bukan berarti thread selalu berjalan secara aktif.
 * Artinya: thread siap dieksekusi kapan saja oleh CPU.
 * 
 * Jadi:
 * RUNNABLE = "siap tempur"
 * 
 * 3. BLOCKED
 * 
 * Thread sedang menunggu lock (synchronized) yang sedang dipegang
 * oleh thread lain.
 * 
 * Contoh:
 * synchronized(obj) {
 * // kode kritis
 * }
 * 
 * Jika ada thread lain memegang lock pada obj:
 * thread ini akan masuk ke status BLOCKED.
 * 
 * 4. WAITING
 * 
 * Thread menunggu tanpa batas waktu.
 * 
 * Biasanya terjadi karena pemanggilan:
 * - wait() tanpa parameter
 * - join() tanpa parameter
 * 
 * Thread akan menunggu sampai:
 * - Ada notifikasi (notify() / notifyAll())
 * - Thread lain selesai (join())
 * 
 * 5. TIMED_WAITING
 * 
 * Thread menunggu dengan batas waktu tertentu.
 * 
 * Contoh pemanggilan:
 * - Thread.sleep(1000)
 * - wait(1000)
 * - join(1000)
 * 
 * Setelah waktu habis, thread akan kembali ke status RUNNABLE.
 * 
 * 6. TERMINATED
 * 
 * Thread sudah selesai dieksekusi.
 * 
 * Terjadi ketika:
 * - Method run() selesai dieksekusi
 * - Thread keluar karena exception yang tidak tertangani
 * 
 * ------------------------------------------------------------------------
 * GAMBARAN ALUR PERUBAHAN STATE
 * ------------------------------------------------------------------------
 * 
 * NEW
 * ↓
 * start()
 * ↓
 * RUNNABLE ←←←←←←←←←←←←←←←←←←←←←←←←←←←←←←←←←←
 * ↓ ↑
 * | (butuh resource) |
 * | (scheduler memilih) |
 * ↓ |
 * RUNNING (konseptual, tetap RUNNABLE di Java) |
 * ↓ |
 * | (thread.sleep / wait / join / lock) |
 * ↓ |
 * ┌───┴───────┬────────────┬──────────────┐ |
 * ↓ ↓ ↓ ↓ |
 * WAITING TIMED_WAITING BLOCKED TERMINATED |
 * ↓ ↓ ↓ ↓ |
 * └───┬───────┴────────────┴──────────────┘ |
 * | (notify / waktu habis / lock tersedia) |
 * └─────────────────────────────────────────────┘
 * 
 * ------------------------------------------------------------------------
 * HAL PENTING (WAJIB PAHAM)
 * ------------------------------------------------------------------------
 * 
 * 1. State bisa berubah sangat cepat
 * 
 * Thread.State ts = t.getState();
 * 
 * Bisa saja:
 * - Saat dicek statusnya RUNNABLE
 * - 1 milidetik kemudian berubah menjadi WAITING
 * 
 * Oleh karena itu, getState() hanya untuk keperluan debugging,
 * BUKAN untuk logika sinkronisasi.
 * 
 * 2. getState() BUKAN untuk kontrol thread
 * 
 * Ini sangat penting:
 * - Jangan gunakan getState() untuk mengatur alur program
 * - Gunakan untuk debugging dan monitoring saja
 * 
 * 3. RUNNABLE ≠ selalu berjalan
 * 
 * Ini adalah kesalahan umum pemula.
 * 
 * RUNNABLE artinya:
 * - Thread siap dijalankan oleh scheduler
 * - Bisa saja sedang menunggu giliran CPU
 * - Belum tentu sedang berjalan secara aktif
 * 
 * ------------------------------------------------------------------------
 * ANALOGI PALING NGENA
 * ------------------------------------------------------------------------
 * 
 * Bayangkan thread seperti orang yang sedang bekerja:
 * 
 * State | Analogi
 * --------------------|---------------------------------------------------
 * NEW | Belum mulai kerja (masih di rumah)
 * RUNNABLE | Siap kerja / sedang kerja (di kantor)
 * BLOCKED | Nunggu kunci ruangan (pintu terkunci)
 * WAITING | Nunggu orang lain (menunggu rekan)
 * TIMED_WAITING | Lagi tidur siang (istirahat sebentar)
 * TERMINATED | Pulang kerja (selesai)
 * 
 * ------------------------------------------------------------------------
 * CONTOH IMPLEMENTASI
 * ------------------------------------------------------------------------
 * 
 * Thread t = new Thread(() -> {
 * try {
 * Thread.sleep(1000);
 * } catch (InterruptedException e) {
 * Thread.currentThread().interrupt();
 * }
 * });
 * 
 * System.out.println("State: " + t.getState()); // NEW
 * 
 * t.start();
 * System.out.println("State: " + t.getState()); // RUNNABLE
 * 
 * // Tunggu sebentar agar thread masuk ke TIMED_WAITING
 * Thread.sleep(100);
 * System.out.println("State: " + t.getState()); // TIMED_WAITING
 * 
 * t.join();
 * System.out.println("State: " + t.getState()); // TERMINATED
 * 
 * ------------------------------------------------------------------------
 * RINGKASAN SUPER PADAT
 * ------------------------------------------------------------------------
 * 
 * - getState() → melihat status thread saat ini
 * - Ada 6 state utama: NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING,
 * TERMINATED
 * - State bisa berubah cepat, gunakan untuk debugging
 * - RUNNABLE ≠ sedang berjalan, hanya siap dijalankan
 * - Jangan gunakan getState() untuk logika kontrol thread
 * 
 * ------------------------------------------------------------------------
 */

// contoh kode lengkap
// Ini contoh biar lu lihat state berubah real-time:
class ThreadState1 implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Thread Started");
            Thread.sleep(500); // Timed wait
            synchronized (this) {
                wait(); // waiting
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("Thread finished");
    }
}

public class ThreadState {
    public static void main(String[] args) throws Exception {

        ThreadState1 threadState = new ThreadState1();
        Thread thread = new Thread(threadState);

        // 1. New
        System.out.println("State: " + thread.getState());
        thread.start();

        // 2. Runnable / Timed waiting
        Thread.sleep(100);
        System.out.println("State: " + thread.getState());

        // tunggu dia masuk waiting
        Thread.sleep(600);
        System.out.println("State: " + thread.getState());

        // bangunin thread
        synchronized (threadState) {
            threadState.notify();
        }

        // tunggu selesai
        Thread.sleep(100);
        System.out.println("State: " + thread.getState());

        /**
         * Output
         * State: NEW
         * Thread Started
         * State: TIMED_WAITING
         * State: WAITING
         * Thread finished
         * State: TERMINATED
         */

        /**
         * PENJELASAN STEP-BY-STEP
         * 
         * Step 1
         * Thread t = new Thread(mt);
         *
         * State:
         * NEW
         *
         * Step 2
         * t.start();
         *
         * Thread mulai:
         * masuk RUNNABLE
         * langsung sleep → TIMED_WAITING
         *
         * Step 3
         * Thread.sleep(500);
         *
         * State:
         * TIMED_WAITING
         *
         * Step 4
         * wait();
         *
         * State:
         * WAITING
         *
         * Step 5
         * notify();
         *
         * Thread bangun → lanjut → selesai
         *
         * Step 6
         * State:
         * TERMINATED
         */
    }

}
