package MultiThreaded;

/**
     * Using isAlive() dan join()
     *
     * Sebelumnya kita pakai:
     * Thread.sleep()
     *
     * buat nahan main thread supaya selesai terakhir
     * 
     * Tapi itu cara jelek, karena:
     * cuma nebak waktu
     * gak akurat
     *
     * Cara yang benar:
     * 1. isAlive()
     * final boolean isAlive()
     *
     * return:
     * true → thread masih jalan
     * false → thread sudah selesai
     *
     * join()
     * final void join()
     *
     * artinya:
     * thread sekarang nunggu thread lain selesai
     *
     * Makna “join”:
     * “gabung setelah thread itu selesai”
     *
     * Konsep Inti (INI WAJIB PAHAM)
     * Problem sebelumnya:
     *
     * Gimana cara thread tau thread lain udah selesai?
     * Solusinya:
     * isAlive() → ngecek status
     * join() → nunggu langsung
     *
     * Insight PALING PENTING
     * join() = sinkronisasi dasar
     *
     * Ini pertama kali lu:
     * ngontrol urutan thread
     *
     * Tanpa join:
     * Main thread exiting.
     * bisa muncul duluan 
     *
     * Dengan join:
     * dijamin:
     *
     * Main thread exiting.
     * PALING TERAKHIR 
     *
     * join() dijalankan oleh:
     * thread yang MENUNGGU
     *
     * Perbandingan Cara Lama vs Baru
     * Cara	            Hasil	            Kualitas
     * sleep	        nebak waktu	        jelek
     * isAlive	        cek status	        terbatas
     * join	            nunggu pasti	    terbaik
     *
     * join() = fondasi concurrency control
     * Ini bakal kepake di:
     * Thread pool
     * Async programming
     * Parallel processing
     *
     * Ini juga awal dari:
     * Thread coordination
     *
     * Ringkasan SUPER DALAM
     * isAlive() = cek
     * join() = nunggu
     * sleep() = delay (bukan solusi)
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
