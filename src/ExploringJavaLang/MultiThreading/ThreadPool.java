package ExploringJavaLang.MultiThreading;

/**
 * KONSEP DASAR: THREAD POOL
 *
 * Masalah Thread Biasa
 * Kalau lo bikin thread manual:
 * new Thread(...).start();
 *
 * Masalah:
 * Mahal (buat thread itu berat)
 * Boros memory
 * Susah dikontrol
 * Bisa crash kalau kebanyakan thread
 *
 * Solusi: Thread Pool
 *
 * Thread Pool =
 * kumpulan thread yang dibuat sekali, lalu dipakai ulang
 *
 * Analogi
 * Thread biasa:
 * Buat karyawan → kerja → dipecat 
 *
 * Thread Pool:
 * Punya karyawan tetap → dipakai terus 
 *
 * Kenapa ini dipakai di backend?
 *
 * Karena:
 * Request banyak (ribuan)
 * Harus efisien
 * Harus scalable
 *
 * CORE API (YANG WAJIB LO KUASAI)
 *
 * Thread pool di Java pakai:
 * ExecutorService
 * Ini pengganti modern dari Thread
 *
 * METHOD PENTING ExecutorService (LENGKAP + PENJELASAN)
 * Submit & Execute
 * Method	                Deskripsi
 * execute(Runnable)	    Jalankan task tanpa return
 * submit(Runnable)	        Jalankan task (return Future)
 * submit(Callable)	        Jalankan task + return value
 *
 * Shutdown
 * Method	                Deskripsi
 * shutdown()	            Stop menerima task baru
 * shutdownNow()	        Stop paksa semua thread
 * isShutdown()	            Cek apakah sudah shutdown
 * isTerminated()	        Cek apakah semua thread selesai
 *
 * Control
 * Method	                    Deskripsi
 * awaitTermination(timeout)	Tunggu semua thread selesai
 * invokeAll(Collection)	    Jalankan banyak task sekaligus
 * invokeAny(Collection)	    Ambil hasil pertama yang selesai
 *
 * PERBEDAAN DENGAN THREAD BIASA
 *
 * Thread biasa:
 * Thread t = new Thread();
 * t.start();
 *
 * Thread pool:
 * ExecutorService executor = Executors.newFixedThreadPool(5);
 * executor.submit(task);
 *
 * Perbedaan utama
 * Thread	            Thread Pool
 * Manual	            Dikelola otomatis
 * Tidak reusable	    Reusable
 * Susah scaling	    Mudah scaling
 * Boros	            Efisien
 *
 * JENIS THREAD POOL (WAJIB TAU)
 * 1. Fixed Thread Pool
 * Executors.newFixedThreadPool(5);
 *
 * Thread tetap
 *
 * 2. Cached Thread Pool
 * Executors.newCachedThreadPool();
 *
 * Thread fleksibel (auto nambah)
 *
 * 3. Single Thread
 * Executors.newSingleThreadExecutor();
 *
 * Hanya 1 thread (queue)
 *
 * 4. Scheduled Thread Pool
 * Executors.newScheduledThreadPool(2);
 *
 * Untuk task berkala (cron-like)
 *
 * BEST PRACTICE (INI YANG DIPAKAI DI REAL PROJECT)
 * Jangan pakai langsung:
 * Executors.newFixedThreadPool()
 *
 * Kenapa?
 * Tidak bisa kontrol queue → bisa OOM
 *
 * Gunakan:
 * new ThreadPoolExecutor(...)
 */

/**
 * CONTOH REAL (THREADPOOL MODERN)
 *
 * import java.util.concurrent.*;
 *
 * // ThreadPool modern (recommended)
 * public class CustomThreadPool {
 *
 *     public static void main(String[] args) {
 *
 *         ThreadPoolExecutor executor = new ThreadPoolExecutor(
 *
 *                 2, // core thread
 *                 4, // max thread
 *                 60, // idle time
 *                 TimeUnit.SECONDS,
 *
 *                 // Queue task
 *                 new LinkedBlockingQueue<>(10)
 *         );
 *
 *         // Submit task
 *         executor.execute(() -> {
 *             System.out.println("Task jalan di " +
 *                     Thread.currentThread().getName());
 *         });
 *
 *         executor.shutdown();
 *     }
 * }
 *
 * KAITAN KE SPRING BOOT
 *
 * Di Spring Boot:
 * @Async
 * public void process() { }
 *
 * Di belakang layar:
 * Pakai thread pool
 *
 * KESIMPULAN
 * Inti:
 * Thread pool = kumpulan thread reusable
 * Lebih efisien daripada thread biasa
 *
 * API utama:
 * ExecutorService
 * ThreadPoolExecutor
 * Future
 * Callable
 *
 * Perbedaan penting:
 * Thread biasa → manual
 * Thread pool → otomatis & scalable
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {

        // Contoh penggunaan Thread Pool
        // Membuat thread pool dengan 3 thread
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Membuat 5 task
        for (int i = 1; i <= 5; i++) {
            int taskId = i;

            executorService.execute(() -> {
                // Ini task yang dijalankan oleh thread pool
                System.out.println("Menjalankan task " + taskId + " oleh " + Thread.currentThread().getName());
                
                try {
                    // Simulasi kerja
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Task terganggu");
                }
                System.out.println("Selesai task " + taskId);
            });
        }
        // Shutdown pool
        executorService.shutdown();

        /**
         * Output konsep:
         * Task 1 → Thread-1
         * Task 2 → Thread-2
         * Task 3 → Thread-3
         * Task 4 → nunggu thread kosong
         */
    }
}
