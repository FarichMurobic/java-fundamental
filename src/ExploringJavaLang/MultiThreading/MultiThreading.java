package ExploringJavaLang.MultiThreading;

/**
 * Thread, ThreadGroup, dan Runnable
 *
 * Ketiga ini dipakai untuk:
 * menjalankan banyak proses secara bersamaan (multithreading)
 *
 * Komponen utama:
 * Komponen	            Fungsi
 * Runnable	            Blueprint pekerjaan
 * Thread	            Mesin yang menjalankan
 * ThreadGroup	        Pengelompokan thread
 *
 * Runnable (PALING DASAR)
 * Interface Runnable harus diimplementasikan oleh class yang ingin dijalankan sebagai thread.
 *
 * hanya punya 1 method:
 * void run()
 *
 * ini adalah:
 * titik awal eksekusi thread
 *
 * Thread Class
 * Fungsi
 *
 * Membuat thread baru
 * Mengimplementasikan Runnable
 *
 * CONSTRUCTOR THREAD (FULL)
 * Constructor	                                            Deskripsi
 * Thread()	                                                Thread kosong
 * Thread(Runnable r)	                                    Thread dengan task
 * Thread(Runnable r, String name)	                        + nama thread
 * Thread(String name)	                                    Thread dengan nama
 * Thread(ThreadGroup g, Runnable r)	                    Dengan group
 * Thread(ThreadGroup g, Runnable r, String name)	        Full
 * Thread(ThreadGroup g, String name)	                    Group + nama
 *
 * Penjelasan
 * threadOb → object Runnable
 * threadName → nama thread
 * groupOb → grup thread
 *
 * PRIORITY CONSTANT
 * Konstanta	                Nilai
 * MIN_PRIORITY	                prioritas rendah
 * NORM_PRIORITY	            default
 * MAX_PRIORITY	                tinggi
 *
 * METHOD THREAD (TABLE 17-18 FULL)
 * Thread Info
 * Method	                    Deskripsi
 * currentThread()	            Ambil thread sekarang
 * getName()	                Nama thread
 * getId()	                    ID thread
 * getPriority()	            Prioritas
 * getState()	                Status thread
 * getThreadGroup()	            Group thread
 *
 * Thread Status
 * Method	                    Deskripsi
 * isAlive()	                Masih jalan?
 * isDaemon()	                Thread background?
 * isInterrupted()	            Sudah di-interrupt?
 *
 * Execution Control
 * Method	                    Deskripsi
 * start()	                    Mulai thread
 * run()	                    Isi kerja thread
 * sleep(ms)	                Pause
 * yield()	                    Kasih CPU ke thread lain
 * join()	                    Tunggu thread selesai
 *
 * Interrupt
 * Method	                    Deskripsi
 * interrupt()	                Hentikan thread
 * interrupted()	            Cek interrupt
 *
 * Setting
 * Method	                    Deskripsi
 * setName()	                Set nama
 * setPriority()	            Set prioritas
 * setDaemon()	                Set daemon
 *
 * Debugging
 * Method	                    Deskripsi
 * dumpStack()	                Print stack
 * getStackTrace()	            Ambil stack trace
 * getAllStackTraces()	        Semua thread
 *
 * Exception Handling
 * Method	                        Deskripsi
 * setUncaughtExceptionHandler()	Handle error
 * getUncaughtExceptionHandler()	Ambil handler
 *
 * Lainnya
 * Method	                    Deskripsi
 * activeCount()	            Jumlah thread aktif
 * enumerate()	                Ambil semua thread
 *
 * ️METHOD YANG SUDAH DEPRECATED
 * Method	    Kenapa
 * stop()	    Tidak aman
 * suspend()	Deadlock
 * resume()	    Tidak stabil
 * destroy()	Bisa crash
 *
 * Insight Penting (INI WAJIB PAHAM)
 * 1. start() ≠ run()
 * t.start(); // thread baru
 * t.run();   // cuma method biasa 
 *
 * 2. Thread = concurrent (bukan parallel selalu)
 * CPU bisa switch cepat
 *
 * 3. Shared memory = bahaya
 *
 * bisa:
 * race condition
 * data corrupt
 *
 * Analogi
 * Runnable = tugas 
 * Thread = pekerja 
 * CPU = bos 
 *
 * Relevansi Backend (PENTING BANGET)
 *
 * Dipakai di:
 * server request handling
 * async processing
 * Spring Boot (@Async)
 * thread pool
 *
 * Kesimpulan Simpel
 *
 * Runnable = apa yang dikerjakan
 * Thread = siapa yang menjalankan
 *
 * method penting:
 * start() → mulai
 * run() → isi kerja
 * sleep() → pause
 * join() → tunggu
 *
 * Deprecated (JANGAN DIPAKAI):
 * stop()
 * suspend()
 * resume()
 * destroy()
 * countStackFrames()
 */

// Contoh penggunaan Runnable + Thread
class MyThread implements Runnable {

    public void run() {

        for (int i = 0; i < 5; i++) {
            System.out.println("Thread jalan: " + i);

            try {
                Thread.sleep(500); // pause 0.5 detik
            } catch (InterruptedException e) {
                System.out.println("Thread terganggu");
            }
        }
    }
}

public class MultiThreading {
    public static void main(String[] args) {

        // Membuat object runnable
        MyThread task = new MyThread();

        // Membuat thread
        Thread t = new Thread(task, "Thread-1");

        // Menjalankan thread
        t.start();

        System.out.println("Main thread jalan...");

        // Flow Eksekusi
        // main thread → start() → thread baru → run()
    }
}
