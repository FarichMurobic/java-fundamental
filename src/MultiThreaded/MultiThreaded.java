package MultiThreaded;

/**
     * Sistem multithreading di Java dibangun dari:
     *
     * class Thread
     * interface Runnable
     *
     * Apa itu Thread?
     *
     * Thread itu:
     * representasi (proxy) dari thread yang lagi jalan
     *
     * Karena:
     * Thread asli itu gak bisa kita pegang langsung
     * Kita kontrol lewat object Thread
     *
     * Cara bikin thread:
     * Ada 2 cara:
     *
     * Extend Thread
     * Implement Runnable
     *
     * Method penting di Thread
     * Method	        Fungsi
     * getName()	    ambil nama thread
     * getPriority()	ambil prioritas
     * isAlive()	    cek thread masih jalan
     * join()	        tunggu thread selesai
     * run()	        isi kerja thread
     * sleep()	        delay
     * start()	        mulai thread
     *
     * Catatan penting:
     * Semua program Java:
     * selalu punya 1 thread awal → main thread
     *
     * ============================================
     * 
     * KONSEP INTI
     * run() vs start() (INI WAJIB BANGET PAHAM)
     * Salah (pemula sering banget):
     * t.run();
     *
     * Ini BUKAN thread baru
     * Cuma method biasa
     *
     * Benar:
     * t.start();
     *
     * Ini:
     * bikin thread baru
     * lalu otomatis panggil run()
     *
     * -----------------------------
     * 
     * Penjelasan:
     * extends Thread → class lu jadi thread
     * override run() → isi kerja
     * start() → mulai thread
     * Kekurangan:
     * Java gak bisa multiple inheritance
     * Lu jadi “keikat” sama Thread
     *
     * -----------------------
     * 
     * Insight Level Pro
     * 
     * Kenapa Runnable lebih disarankan?
     * Bisa extend class lain
     * Lebih fleksibel
     * Dipakai di:
     * Thread pool
     * Executor framework
     *
     * Thread itu mahal
     * Jangan bikin thread sembarangan
     *
     * Makanya di dunia nyata:
     * pakai ExecutorService (nanti kita bahas)
     *
     * Penerapan Nyata
     * Dipakai di:
     *
     * Server (handle banyak user)
     * Game loop
     * Background task
     * Download manager
     *
     * ----------------------------------------------------
     * 
     * KESIMPULAN
     * Thread = representasi eksekusi
     * Ada 2 cara bikin:
     * extend Thread
     * implement Runnable (lebih baik)
     * start() = mulai thread
     * run() = isi kerja
     * Java selalu punya main thread
     */

    /**
     * Saat program Java mulai:
     * 
     * 1 thread langsung jalan otomatis
     *
     * Ini disebut:
     * main thread
     *
     * Kenapa main thread penting?
     * Tempat lahir thread lain
     * → semua thread lain dibuat dari sini
     * Biasanya yang terakhir selesai
     * → handle shutdown program
     *
     * Cara akses main thread
     * Gunakan:
     * Thread.currentThread()
     *
     * Ini akan:
     * ngasih referensi ke thread yang lagi jalan sekarang
     *
     * KONSEP INTI
     * Fakta penting:
     * Semua program Java:
     * Selalu dimulai dari main thread
     * Bahkan sebelum lu bikin thread sendiri
     */

// CARA 1: EXTEND THREAD
// class jadi Thread
class MyThreadd extends java.lang.Thread {

    // override run (isi kerja)
    @Override
    public void run() {
        System.out.println("Thread jalan...");
    }
}

// CARA 2: IMPLEMENT RUNNABLE (INI LEBIH SERING DIPAKAI
class MyRunnable implements Runnable {

    // override run (isi kerja)
    @Override
    public void run() {
        System.out.println("Thread dari Runnable");
    }
}

// CONTOH KOMBINASI (REAL BANGET)
class Worker extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Mulai kerja.");
            Thread.sleep(2000);
            System.out.println("Selesai kerja.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
 
public class MultiThreaded {
    public static void main(String[] args) throws InterruptedException {

        MyThreadd t = new MyThreadd();
        t.start(); // wajib pakai ini.

        /**
         * Penjelasan:
         * extends Thread → class lu jadi thread
         * override run() → isi kerja
         * start() → mulai thread
         */

        // objec Myrunnable class
        MyRunnable r = new MyRunnable();
        Thread thread = new Thread(r); // dibungkus Thread
        thread.start(); // mulai thread

        /**
         * Penjelasan:
         * Runnable → cuma definisi kerja
         * Thread → yang ngejalanin
         *
         * Lebih fleksibel
         */

        /**
         * METHOD PENTING (BEDAH DALAM)
         * 
         * start()
         *
         * bikin thread baru + panggil run()
         *
         * run()
         *
         * isi logic thread
         *
         * sleep(ms)
         * Thread.sleep(1000);
         *
         * thread tidur 1 detik
         *
         * join()
         * t.join();
         *
         * thread lain nunggu sampai t selesai
         *
         * isAlive()
         *
         * cek thread masih hidup
         */

        // Object worker class
        Worker w = new Worker();
        w.start(); // mulai thread (run)
        w.join(); // tunggu sampai selesai

        System.out.println("Main lanjut");

        /**
         * Flow:
         * Worker jalan → sleep → selesai
         * Main nunggu → lanjut
         */

        // Cara akses main thread
        // ambil thread yang lagi jalan (main thread)
        Thread thread1 = Thread.currentThread();

        // print info thread
        System.out.println("Current thread: " + thread1);

        // ubah nama Thread
        thread1.setName("MyThread");

        System.out.println("After name change: " + thread1);

        try {
            for (int n = 5; n > 0; n--) {
                System.out.println(n);
                Thread.sleep(1000); // pause 1 detik.
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        /**
         * PENJELASAN DETAIL
         * 
         * Thread.currentThread()
         * Thread t = Thread.currentThread();
         *
         * Ambil thread yang lagi jalan
         * Dalam kasus ini = main thread
         *
         * Print thread
         * System.out.println(t);
         *
         * Output:
         * Thread[main,5,main]
         *
         * Artinya:
         *
         * Thread[nama, priority, group]
         * main → nama thread
         * 5 → priority default
         * main → thread group
         *
         * setName()
         * t.setName("My Thread");
         *
         * Ganti nama thread
         *
         * Output berubah:
         * Thread[My Thread,5,main]
         *
         * Loop + sleep
         * Thread.sleep(1000);
         *
         * Thread:
         *
         * berhenti 1 detik
         * lalu lanjut lagi
         *
         * Kenapa pakai try-catch?
         * Karena:
         * sleep() throws InterruptedException
         * Bisa terjadi kalau:
         * thread lain nge-interrupt thread ini
         *
         * Insight:
         * sleep() itu bisa “diganggu” thread lain
         * Makanya harus di-handle
         *
         * METHOD YANG DIPAKAI
         * currentThread()
         * ambil thread sekarang
         *
         * sleep(ms)
         * pause thread
         *
         * setName()
         * ubah nama thread
         *
         * getName()
         * ambil nama thread
         *
         * Game:
         * Main thread = game engine utama
         * Thread lain = AI, rendering, physics
         *
         * Semua lahir dari main thread
         *
         * HAL PENTING YANG SERING DISALAHPAHAMI
         * Main thread juga thread biasa
         *
         * Bisa:
         * di-sleep
         * di-rename
         * di-interrupt
         * Kalau main thread selesai duluan?
         *
         * Program bisa ikut selesai
         * (kecuali ada thread lain yang masih jalan)
         *
         * sleep() itu static
         * Thread.sleep(1000);
         *
         * Dipanggil dari class, bukan object
         *
         * Insight Level Pro
         * Main thread = “boss”
         * Dia yang spawn thread lain
         * Dia juga yang biasanya nunggu (join())
         *
         * Debugging jadi lebih gampang kalau rename thread
         * Makanya setName() itu berguna banget
         *
         * Penerapan Nyata
         *
         * Dipakai untuk:
         * Logging thread
         * Debug multithreading
         * Kontrol flow program
         *
         * KESIMPULAN
         * Java selalu mulai dari main thread
         * Bisa diakses dengan currentThread()
         * Bisa dikontrol seperti thread lain
         * sleep() = pause
         * setName() = ubah identitas thread
         */
    }
}


