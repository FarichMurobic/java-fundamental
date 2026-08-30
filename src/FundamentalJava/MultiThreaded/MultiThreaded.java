package FundamentalJava.MultiThreaded;

/*
 * ============================================================
 * Thread Fundamental Java
 * ============================================================
 *
 * Sistem multithreading pada Java dibangun menggunakan dua
 * komponen utama:
 *
 * - Class Thread
 * - Interface Runnable
 *
 *
 * Keduanya digunakan untuk membuat dan menjalankan pekerjaan
 * secara concurrent..
 *
 * ------------------------------------------------------------
 * Apa Itu Thread?
 * ------------------------------------------------------------
 *
 * Thread adalah jalur eksekusi independen di dalam sebuah
 * program.
 *
 *
 * Dalam Java, kita tidak mengontrol thread OS secara langsung.
 *
 * Sebagai gantinya, Java menyediakan object Thread sebagai
 * representasi untuk membuat dan mengontrol sebuah thread.
 *
 *
 * Alurnya:
 *
 * Object Thread
 *        |
 *        v
 * JVM
 *        |
 *        v
 * OS Thread
 *
 *
 * Jadi:
 *
 * Object Thread adalah jembatan antara program Java dengan
 * mekanisme thread yang dikelola JVM dan Operating System.
 *
 * ------------------------------------------------------------
 * Cara Membuat Thread
 * ------------------------------------------------------------
 *
 * Java menyediakan dua pendekatan utama:
 *
 *
 * 1. Extend class Thread
 *
 * class MyThread extends Thread {
 *
 *     public void run() {
 *
 *         // pekerjaan thread
 *
 *     }
 *
 * }
 *
 *
 *
 * 2. Implement interface Runnable
 *
 * class MyTask implements Runnable {
 *
 *     public void run() {
 *
 *         // pekerjaan thread
 *
 *     }
 *
 * }
 *
 *
 * Keduanya dapat digunakan untuk membuat thread baru.
 *
 * ------------------------------------------------------------
 * Method Penting Pada Class Thread
 * ------------------------------------------------------------
 *
 * Method              Fungsi
 *
 * start()
 *
 * Memulai thread baru.
 * JVM kemudian menjalankan method run().
 *
 *
 * run()
 *
 * Berisi pekerjaan yang akan dilakukan thread.
 *
 *
 * sleep()
 *
 * Menghentikan sementara thread selama waktu tertentu.
 *
 *
 * join()
 *
 * Membuat thread menunggu thread lain selesai.
 *
 *
 * getName()
 *
 * Mengambil nama thread.
 *
 *
 * getPriority()
 *
 * Mengambil prioritas thread.
 *
 *
 * isAlive()
 *
 * Mengecek apakah thread masih berjalan.
 *
 * ------------------------------------------------------------
 * Main Thread
 * ------------------------------------------------------------
 *
 * Ketika program Java dimulai:
 *
 * JVM otomatis membuat satu thread pertama.
 *
 *
 * Thread tersebut disebut:
 *
 * main thread
 *
 *
 * Contoh:
 *
 * public static void main(String[] args)
 *
 *
 * Method main() selalu dijalankan oleh main thread.
 *
 *
 * Alur:
 *
 * JVM Start
 *     |
 *     v
 * Main Thread dibuat
 *     |
 *     v
 * Method main() dijalankan
 *     |
 *     v
 * Membuat thread tambahan jika diperlukan
 *
 * ------------------------------------------------------------
 * Cara Mengakses Main Thread
 * ------------------------------------------------------------
 *
 * Java menyediakan:
 *
 * Thread.currentThread()
 *
 *
 * Method ini mengembalikan referensi ke thread yang sedang
 * menjalankan kode saat itu.
 *
 *
 * Contoh:
 *
 * Thread t = Thread.currentThread();
 *
 *
 * Hasil:
 *
 * Kita mendapatkan object Thread dari thread aktif.
 *
 * ------------------------------------------------------------
 * Konsep Paling Penting:
 * run() vs start()
 * ------------------------------------------------------------
 *
 * Ini adalah kesalahan paling umum programmer pemula.
 *
 *
 * Salah:
 *
 * t.run();
 *
 *
 * Kenapa salah?
 *
 * Karena run() hanyalah method biasa.
 *
 *
 * Ketika dipanggil langsung:
 *
 * Tidak membuat thread baru.
 *
 *
 * Kode tetap berjalan pada thread yang sedang aktif.
 *
 *
 * ------------------------------------------------------------
 * Cara Yang Benar
 * ------------------------------------------------------------
 *
 * Benar:
 *
 * t.start();
 *
 *
 * Yang terjadi:
 *
 * start()
 *    |
 *    v
 * JVM membuat thread baru
 *    |
 *    v
 * Thread baru menjalankan run()
 *
 *
 * Jadi:
 *
 * start() = membuat jalur eksekusi baru
 *
 * run() = pekerjaan yang dijalankan oleh thread tersebut
 *
 * ------------------------------------------------------------
 * Extend Thread vs Implement Runnable
 * ------------------------------------------------------------
 *
 * Extend Thread:
 *
 * Kelebihan:
 *
 * - Sederhana untuk dipahami.
 * - Langsung menjadi object Thread.
 *
 *
 * Kekurangan:
 *
 * Java tidak mendukung multiple inheritance.
 *
 * Jika class sudah extends Thread:
 *
 * tidak bisa extends class lain.
 *
 *
 * ------------------------------------------------------------
 *
 * Implement Runnable:
 *
 * Kelebihan:
 *
 * - Memisahkan task dan thread.
 * - Class masih bisa extends class lain.
 * - Lebih fleksibel.
 *
 *
 * Contoh konsep:
 *
 * Runnable
 *    |
 *    v
 * Task / pekerjaan
 *
 *
 * Thread
 *    |
 *    v
 * Menjalankan task
 *
 *
 * ------------------------------------------------------------
 * Kenapa Runnable Lebih Banyak Dipakai?
 * ------------------------------------------------------------
 *
 * Dalam aplikasi modern:
 *
 * Kita biasanya tidak membuat thread secara manual.
 *
 *
 * Contoh:
 *
 * ExecutorService
 *
 *
 * ExecutorService menggunakan konsep:
 *
 * Task (Runnable/Callable)
 *
 *
 * kemudian menjalankannya menggunakan:
 *
 * Thread Pool
 *
 *
 * Jadi kode lebih aman dan efisien.
 *
 * ------------------------------------------------------------
 * Thread Itu Resource Yang Mahal
 * ------------------------------------------------------------
 *
 * Membuat terlalu banyak thread dapat menyebabkan:
 *
 * - Penggunaan memory meningkat.
 * - Context switching berlebihan.
 * - Performa turun.
 *
 *
 * Karena itu:
 *
 * Jangan membuat thread baru untuk setiap pekerjaan kecil.
 *
 *
 * Gunakan:
 *
 * - ExecutorService
 * - Thread Pool
 * - Concurrent API
 *
 *
 * ------------------------------------------------------------
 * Contoh Penggunaan Thread Dunia Nyata
 * ------------------------------------------------------------
 *
 * Thread digunakan pada:
 *
 * - Server menangani banyak request.
 * - Background processing.
 * - Download manager.
 * - Game loop.
 * - Pemrosesan data.
 *
 *
 * Dalam backend:
 *
 * Request masuk
 *      |
 *      v
 * Thread menangani pekerjaan
 *      |
 *      v
 * Response dikirim
 *
 * ------------------------------------------------------------
 * Ringkasan Konsep Utama
 * ------------------------------------------------------------
 *
 * Thread:
 *
 * Jalur eksekusi independen dalam program.
 *
 *
 * Java membuat thread melalui:
 *
 * - Extend Thread
 * - Implement Runnable
 *
 *
 * Perbedaan penting:
 *
 * start()
 *
 * Membuat thread baru dan menjalankan run().
 *
 *
 * run()
 *
 * Berisi pekerjaan thread.
 *
 *
 * Main thread:
 *
 * Thread pertama yang dibuat JVM saat program dimulai.
 *
 *
 * Prinsip utama:
 *
 * "Thread adalah cara Java menjalankan beberapa pekerjaan
 * secara concurrent, tetapi pengelolaannya harus dilakukan
 * dengan desain yang benar."
 *
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
         * PENJELASAN
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
