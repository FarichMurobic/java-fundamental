package FundamentalJava.MultiThreaded;

/**
     * Java punya method:
     *
     * Thread.State getState()
     * Dipakai buat lihat status thread saat ini
     * Return-nya berupa enum Thread.State
     *
     * Daftar State
     * State	            Arti
     * NEW	                Thread belum mulai
     * RUNNABLE	            Lagi jalan / siap jalan
     * BLOCKED	            Nunggu lock
     * WAITING	            Nunggu tanpa batas
     * TIMED_WAITING	    Nunggu dengan waktu
     * TERMINATED	        Sudah selesai
     *
     * PENJELASAN DALAM (INTUISI)
     * 1. NEW
     * Thread dibuat, tapi belum start()
     * Thread t = new Thread(...);
     *
     * Masih “calon thread”
     *
     * 2. RUNNABLE
     * Thread siap jalan / sedang jalan
     *
     * Penting:
     * Ini bukan berarti selalu jalan
     * Tapi:
     * bisa jalan kapan saja (nunggu CPU)
     *
     * Jadi:
     * RUNNABLE = “siap tempur”
     *
     * 3. BLOCKED
     * Thread nunggu lock (synchronized)
     *
     * Contoh:
     * synchronized(obj) {
     *    ...
     * }
     *
     * Kalau ada thread lain pegang lock:
     * thread ini → BLOCKED
     *
     * 4. WAITING
     * Thread nunggu tanpa batas
     *
     * Biasanya karena:
     * wait();
     * join();
     *
     * Dia nunggu:
     * sampai ada notify()
     * atau thread lain selesai
     *
     * 5. TIMED_WAITING
     * Thread nunggu dengan waktu
     *
     * Contoh:
     * Thread.sleep(1000);
     * wait(1000);
     * join(1000);
     *
     * Setelah waktu habis → lanjut
     *
     * 6. TERMINATED
     * Thread sudah selesai
     *
     * run() selesai
     *
     * GAMBARAN ALUR (BIAR KEBAYANG)
     * NEW → RUNNABLE → RUNNING
     *              ↓
     *         WAITING / BLOCKED / TIMED_WAITING
     *              ↓
     *         RUNNABLE lagi
     *              ↓
     *         TERMINATED
     *
     * HAL PENTING (WAJIB PAHAM)
     * 1. State bisa berubah cepat banget
     * Thread.State ts = t.getState();
     *
     * Bisa aja:
     * lu cek RUNNABLE
     * 1ms kemudian → WAITING
     *
     * 2. getState() bukan buat sinkronisasi
     * Ini penting banget dari teks:
     *
     * Bukan untuk kontrol thread
     * Untuk debugging
     *
     * 3. RUNNABLE ≠ selalu jalan
     * Ini kesalahan umum
     *
     * RUNNABLE =
     * bisa jalan
     * belum tentu lagi jalan
     *
     * ANALOGI PALING NGENA
     *
     * Bayangin thread kayak orang:
     * State	            Analoginya
     * NEW	                belum mulai kerja
     * RUNNABLE	            siap kerja / lagi kerja
     * BLOCKED	            nunggu kunci ruangan
     * WAITING	            nunggu orang lain
     * TIMED_WAITING	    lagi tidur
     * TERMINATED	        sudah selesai kerja
     *
     * RINGKASAN SUPER PADAT
     * getState() → lihat status thread
     * Ada 6 state utama
     * State bisa berubah cepat
     * Dipakai untuk debugging, bukan kontrol
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
