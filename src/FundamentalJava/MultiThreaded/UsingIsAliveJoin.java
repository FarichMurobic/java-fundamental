package FundamentalJava.MultiThreaded;

/**
 * ------------------------------------------------------------------------
 * USING isAlive() AND join()
 * ------------------------------------------------------------------------
 * 
 * Sebelumnya kita menggunakan:
 *     Thread.sleep()
 * 
 * Untuk menahan main thread agar selesai paling terakhir.
 * 
 * Namun itu adalah cara yang buruk karena:
 * - Hanya menebak waktu yang dibutuhkan
 * - Tidak akurat
 * - Tidak fleksibel (waktu eksekusi thread bisa berbeda-beda)
 * 
 * ------------------------------------------------------------------------
 * CARA YANG BENAR
 * ------------------------------------------------------------------------
 * 
 * 1. isAlive()
 * 
 *     final boolean isAlive()
 * 
 * Return value:
 * - true  → thread masih berjalan
 * - false → thread sudah selesai
 * 
 * 2. join()
 * 
 *     final void join()
 * 
 * Artinya:
 * Thread yang memanggil join() akan menunggu
 * sampai thread lain selesai dieksekusi.
 * 
 * Makna "join":
 * "Bergabung setelah thread itu selesai"
 * 
 * ------------------------------------------------------------------------
 * KONSEP INTI (INI WAJIB PAHAM)
 * ------------------------------------------------------------------------
 * 
 * Problem sebelumnya:
 * Bagaimana cara suatu thread mengetahui bahwa thread lain
 * sudah selesai dieksekusi?
 * 
 * Solusi:
 * - isAlive() → mengecek status thread
 * - join()   → menunggu langsung sampai selesai
 * 
 * ------------------------------------------------------------------------
 * INSIGHT PALING PENTING
 * ------------------------------------------------------------------------
 * 
 * join() = sinkronisasi dasar
 * 
 * Ini adalah pertama kalinya kamu:
 * Mengontrol urutan eksekusi antar thread
 * 
 * Tanpa join:
 *     Main thread exiting.
 *     Bisa muncul lebih dulu dari child thread
 * 
 * Dengan join:
 *     Dijamin:
 *     Main thread exiting.
 *     Muncul PALING TERAKHIR
 * 
 * join() dijalankan oleh:
 * Thread yang MENUNGGU (bukan thread yang ditunggu)
 * 
 * Contoh:
 *     childThread.join(); // main thread menunggu childThread
 * 
 * ------------------------------------------------------------------------
 * PERBANDINGAN CARA LAMA VS BARU
 * ------------------------------------------------------------------------
 * 
 * Cara          | Hasil                        | Kualitas
 * --------------|------------------------------|------------------
 * sleep()       | Menebak waktu                | Jelek
 * isAlive()     | Mengecek status              | Terbatas (harus polling)
 * join()        | Menunggu sampai selesai      | Terbaik
 * 
 * ------------------------------------------------------------------------
 * CONTOH IMPLEMENTASI
 * ------------------------------------------------------------------------
 * 
 *     class NewThread implements Runnable {
 *         String name;
 *         Thread t;
 * 
 *         NewThread(String threadName) {
 *             name = threadName;
 *             t = new Thread(this, name);
 *             System.out.println("New thread: " + t);
 *             t.start();
 *         }
 * 
 *         public void run() {
 *             try {
 *                 for (int i = 5; i > 0; i--) {
 *                     System.out.println(name + ": " + i);
 *                     Thread.sleep(1000);
 *                 }
 *             } catch (InterruptedException e) {
 *                 System.out.println(name + " interrupted.");
 *             }
 *             System.out.println(name + " exiting.");
 *         }
 *     }
 * 
 *     public class Main {
 *         public static void main(String[] args) {
 *             NewThread nt1 = new NewThread("One");
 *             NewThread nt2 = new NewThread("Two");
 *             NewThread nt3 = new NewThread("Three");
 * 
 *             System.out.println("Thread One is alive: " + nt1.t.isAlive());
 *             System.out.println("Thread Two is alive: " + nt2.t.isAlive());
 *             System.out.println("Thread Three is alive: " + nt3.t.isAlive());
 * 
 *             // Menunggu semua thread selesai
 *             try {
 *                 nt1.t.join();
 *                 nt2.t.join();
 *                 nt3.t.join();
 *             } catch (InterruptedException e) {
 *                 System.out.println("Main thread interrupted.");
 *             }
 * 
 *             System.out.println("Thread One is alive: " + nt1.t.isAlive());
 *             System.out.println("Thread Two is alive: " + nt2.t.isAlive());
 *             System.out.println("Thread Three is alive: " + nt3.t.isAlive());
 * 
 *             System.out.println("Main thread exiting.");
 *         }
 *     }
 * 
 * ------------------------------------------------------------------------
 * KENAPA join() LEBIH BAIK DARI sleep()?
 * ------------------------------------------------------------------------
 * 
 * 1. Akurasi
 *    join() menunggu sampai benar-benar selesai.
 *    sleep() hanya menebak, bisa terlalu pendek atau terlalu panjang.
 * 
 * 2. Efisiensi
 *    join() tidak membuang waktu sia-sia.
 *    sleep() tetap berjalan meskipun thread sudah selesai lebih cepat.
 * 
 * 3. Maintainability
 *    join() otomatis menyesuaikan dengan waktu eksekusi thread.
 *    sleep() perlu diubah manual jika durasi berubah.
 * 
 * ------------------------------------------------------------------------
 * join() = FONDASI CONCURRENCY CONTROL
 * ------------------------------------------------------------------------
 * 
 * Konsep ini akan dipakai di:
 * - Thread pool
 * - Async programming
 * - Parallel processing
 * - Fork/Join framework
 * 
 * Ini adalah awal dari:
 * Thread coordination (koordinasi antar thread)
 * 
 * ------------------------------------------------------------------------
 * RINGKASAN SUPER DALAM
 * ------------------------------------------------------------------------
 * 
 * - isAlive() = mengecek status thread (masih jalan atau sudah selesai)
 * - join()    = menunggu sampai thread selesai (pasti)
 * - sleep()   = delay (BUKAN solusi untuk menunggu thread lain)
 * 
 * Kapan pakai apa:
 * - Cek status → isAlive()
 * - Tunggu sampai selesai → join()
 * - Delay eksekusi → sleep()
 * 
 * ------------------------------------------------------------------------
 */

class AliveJoine implements Runnable {

    String name;
    Thread thread;

    AliveJoine(String threadName) {
        name = threadName;
        thread = new Thread(this, name);

        System.out.println("New thread: " + thread);
        thread.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " Interrupted.");
        }
        System.out.println(name + " exiting.");
    }
}

public class UsingIsAliveJoin {
    public static void main(String[] args) {

        AliveJoine ob1 = new AliveJoine("one");
        AliveJoine ob2 = new AliveJoine("two");
        AliveJoine ob3 = new AliveJoine("three");

        // cek status awal
        System.out.println("Thread one is alive: " + ob1.thread.isAlive());
        System.out.println("Thread two is alive: " + ob2.thread.isAlive());
        System.out.println("Thread three is alive: " + ob3.thread.isAlive());

        try {
            System.out.println("waiting for threads to finish...");
            ob1.thread.join();
            ob2.thread.join();
            ob3.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted...");
        }

        // cek setelah selesai
        System.out.println("thread one is alive: " + ob1.thread.isAlive());
        System.out.println("thread two is alive: " + ob2.thread.isAlive());
        System.out.println("thread three is alive: " + ob3.thread.isAlive());

        System.out.println("Main threadd exiting");

        /**
         * Bedah DALAM (alur kejadian)
         * 
         * Step 1: Buat 3 thread
         * NewThread ob1 = new NewThread("One");
         *
         * langsung start (karena di constructor ada start())
         *
         * Step 2: Cek status
         * ob1.t.isAlive()
         *
         * hasil:
         * true
         *
         * karena thread masih jalan
         *
         * Step 3: join()
         * ob1.t.join();
         *
         * artinya:
         * main thread berhenti di sini sampai thread "One" selesai
         *
         * Step 4: Semua join
         * ob1.t.join();
         * ob2.t.join();
         * ob3.t.join();
         *
         * main thread nunggu:
         * One selesai
         * Two selesai
         * Three selesai
         *
         * Step 5: Cek lagi
         * isAlive()
         *
         * sekarang:
         * false
         */
    }
}
