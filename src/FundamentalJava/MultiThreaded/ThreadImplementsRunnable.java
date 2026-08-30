package FundamentalJava.MultiThreaded;

/**
 * ------------------------------------------------------------------------
 * CREATING A THREAD (MEMBUAT THREAD)
 * ------------------------------------------------------------------------
 * 
 * Secara umum, kamu membuat thread dengan membuat objek dari tipe Thread..
 * 
 * Java menyediakan dua cara:
 * 1. Mengimplementasikan interface Runnable
 * 2. Meng-extends class Thread
 * 
 * ------------------------------------------------------------------------
 * IMPLEMENTING RUNNABLE (CARA PERTAMA)
 * ------------------------------------------------------------------------
 * 
 * Cara paling umum dan direkomendasikan adalah membuat class yang
 * mengimplementasikan Runnable.
 * 
 * Runnable merepresentasikan sebuah unit kode yang bisa dijalankan.
 * Untuk mengimplementasikannya, cukup buat method:
 * public void run()
 * 
 * Isi dari run() adalah kode yang akan dieksekusi oleh thread baru.
 * 
 * Penting:
 * - run() bisa melakukan apapun seperti main()
 * - Bedanya: run() adalah titik awal thread baru (entry point)
 * - Thread akan selesai saat run() selesai dieksekusi
 * 
 * Setelah membuat class Runnable, kita buat objek Thread:
 * Thread(Runnable threadOb, String threadName)
 * 
 * - threadOb → objek yang memiliki method run()
 * - threadName → nama thread (opsional)
 * 
 * ------------------------------------------------------------------------
 * THREAD TIDAK LANGSUNG BERJALAN!
 * ------------------------------------------------------------------------
 * 
 * Setelah objek Thread dibuat, thread belum berjalan.
 * Harus dipanggil method:
 * start()
 * 
 * start() → akan menjalankan run() di dalam thread baru secara concurrent.
 * 
 * ------------------------------------------------------------------------
 * KONSEP UTAMA
 * ------------------------------------------------------------------------
 * 
 * - Thread = jalur eksekusi lain dalam program
 * - main() = thread utama
 * - run() = thread tambahan (child thread)
 * 
 * Jadi program bisa:
 * - Berjalan bersamaan (concurrent)
 * - Tidak lagi berurutan satu per satu
 * 
 * ------------------------------------------------------------------------
 * ANALOGI RUNNABLE DAN THREAD
 * ------------------------------------------------------------------------
 * 
 * Runnable = "pekerjaan"
 * Kamu buat pekerjaan di dalam run()
 * 
 * Thread = "pekerja"
 * Thread yang menjalankan pekerjaan tersebut
 * 
 * Analogi sederhana:
 * - Runnable → script pekerjaan / daftar tugas
 * - Thread → orang yang mengerjakan tugas tersebut
 * 
 * ------------------------------------------------------------------------
 * INSIGHT PENTING
 * ------------------------------------------------------------------------
 * 
 * t.start(); // BENAR - membuat thread baru
 * t.run(); // SALAH - hanya dipanggil biasa, TIDAK multithread
 * 
 * Kenapa?
 * - start() → membuat thread baru secara native, lalu menjalankan run()
 * - run() → hanya dipanggil seperti method biasa, tetap di thread yang sama
 * 
 * ------------------------------------------------------------------------
 * BEDAH KODE
 * ------------------------------------------------------------------------
 * 
 * implements Runnable
 * 
 * Artinya:
 * "Class ini memiliki pekerjaan (run) yang bisa dijalankan oleh thread"
 * 
 * new Thread(this, "Demo Thread")
 * 
 * Ini penting banget:
 * keyword this merujuk ke objek saat ini
 * Artinya: thread akan menjalankan run() dari objek ini
 * 
 * t.start()
 * 
 * Inilah yang membuat:
 * - Thread baru dibuat di level sistem operasi
 * - run() dipanggil secara paralel dengan main()
 * 
 * Thread.sleep(500)
 * 
 * Artinya:
 * Thread "tidur" selama 500 milidetik
 * Digunakan agar efek concurrency terlihat lebih jelas
 * 
 * ------------------------------------------------------------------------
 * HAL YANG SERING MEMBUAT BINGUNG
 * ------------------------------------------------------------------------
 * 
 * 1. Kenapa output bisa acak?
 * 
 * Karena:
 * - Thread berjalan bersamaan
 * - CPU membagi waktu secara bergantian
 * - Tidak ada jaminan urutan eksekusi
 * 
 * 2. Kenapa pakai try-catch?
 * 
 * Karena:
 * - Thread.sleep() bisa melempar InterruptedException
 * - Ini adalah checked exception, wajib ditangani
 * 
 * 3. Apakah thread berjalan paralel 100%?
 * 
 * Tidak selalu. Pada umumnya:
 * - Di CPU single core: bergantian cepat (concurrent)
 * - Di CPU multi core: bisa benar-benar paralel (parallel)
 * 
 * ------------------------------------------------------------------------
 * KENAPA RUNNABLE LEBIH DISARANKAN?
 * ------------------------------------------------------------------------
 * 
 * 1. Java hanya mendukung single inheritance
 * - Jika extends Thread, tidak bisa extends class lain
 * - Jika implements Runnable, masih bisa extends class lain
 * 
 * 2. Runnable memisahkan tugas dari mekanisme eksekusi
 * 
 * 3. Runnable lebih fleksibel untuk digunakan dengan:
 * - ExecutorService
 * - Thread pool
 * - Lambda expression (Java 8+)
 * 
 * ------------------------------------------------------------------------
 * CONTOH IMPLEMENTASI RUNNABLE (JAVA MODERN)
 * ------------------------------------------------------------------------
 * 
 * // Cara klasik
 * class MyRunnable implements Runnable {
 * public void run() {
 * System.out.println("Thread running: " + Thread.currentThread().getName());
 * }
 * }
 * 
 * // Cara lambda (Java 8+)
 * Runnable task = () -> {
 * System.out.println("Running in: " + Thread.currentThread().getName());
 * };
 * 
 * Thread t = new Thread(task, "MyThread");
 * t.start();
 * 
 * ------------------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------------------
 * 
 * - Runnable = interface yang mendefinisikan tugas (run)
 * - Thread = class yang menjalankan tugas tersebut
 * - start() = method untuk memulai thread baru
 * - run() = method yang berisi kode eksekusi
 * - Jangan panggil run() langsung, selalu gunakan start()
 * - Runnable lebih fleksibel daripada extends Thread
 * 
 * ------------------------------------------------------------------------
 */

// Contoh cara ke 2 dengan implements Runnable
class NewThread implements Runnable {

    // buat objek thread
    Thread thread;

    // constructor
    NewThread() {
        // buat thread baru
        thread = new Thread(this, "Demo Thread");
        System.out.println("Child Thread: " + thread);
        thread.start(); // mulai thread
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Child Thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Child Interrupted.");
        }
        System.out.println("Exiting Child Thread.");
    }
}

public class ThreadImplementsRunnable {
    public static void main(String[] args) {

        new NewThread(); // buat thread anak

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main Thread Exiting.");

        /**
         * Dalam kode tadi ada 2 thread:
         *
         * Main Thread → dari main()
         * Child Thread → dari NewThread
         *
         * Mereka jalan barengan (concurrent)
         *
         * PENJELASAN KODE
         *
         * 1. Program mulai dari main()
         * public static void main(String[] args) {
         * new NewThread();
         *
         * Di sini:
         * lu bikin object NewThread
         * constructor langsung jalan
         *
         * 2. Masuk ke constructor NewThread
         * t = new Thread(this, "Demo Thread");
         *
         * INI KRITIS:
         * this = object NewThread
         * karena dia implement Runnable, dia punya run()
         *
         * Artinya:
         * Thread ini nanti akan menjalankan run() milik object ini
         *
         * 3. Print info thread
         * System.out.println("Child thread: " + t);
         *
         * Output contoh:
         * Thread[Demo Thread,5,main]
         *
         * 4. Thread dimulai
         * t.start();
         *
         * INI MOMEN PALING PENTING
         * Yang terjadi:
         * JVM bikin thread baru
         *
         * Thread baru langsung panggil:
         * run()
         *
         * Tapi dipanggil di jalur berbeda dari main()
         *
         * SEKARANG ADA 2 ALUR SEKALIGUS
         * 
         * MAIN THREAD lanjut:
         * for (int i = 5; i > 0; i--) {
         * CHILD THREAD mulai:
         * public void run()
         *
         * INI YANG BIKIN “ACAK”
         * Karena dua thread jalan barengan:
         *
         * Contoh real:
         * Main Thread: 5
         * Child Thread: 5
         * Child Thread: 4
         * Main Thread: 4
         *
         * Urutan tidak dijamin
         *
         * BEDAH BAGIAN RUN()
         * for(int i = 5; i > 0; i--) {
         * System.out.println("Child Thread: " + i);
         * Thread.sleep(500);
         * }
         * 
         * Yang terjadi:
         * print angka
         * tidur 500ms
         * ulang
         *
         * PERBEDAAN KECEPATAN
         * Thread Sleep
         * Child 500ms
         * Main 1000ms
         *
         * Jadi:
         * child lebih cepat selesai
         * makanya keluar duluan
         *
         * TITIK PALING KRITIS (WAJIB PAHAM)
         * 1. this di Thread constructor
         * new Thread(this, "Demo Thread");
         *
         * Artinya:
         * “Thread ini pakai run() dari object ini”
         *
         * Kalau lu gak kasih this, thread gak tau mau jalanin apa
         *
         * start() vs run()
         * t.start(); // bikin thread baru
         * t.run(); // cuma method biasa
         *
         * Ini kesalahan paling umum
         *
         * run() = entry point thread
         * Bukan main() lagi
         *
         * ATURAN PENTING RUNNABLE
         * RULE 1: Runnable cuma punya 1 tugas
         * public void run()
         * Semua logic thread harus mulai dari sini
         *
         * RULE 2: Runnable = “apa yang dikerjakan”
         * Thread = “siapa yang ngerjain”
         * Jangan kebalik
         *
         * RULE 3: SELALU pakai start()
         * Kalau lu tulis:
         * t.run();
         * LU GAGAL MULTITHREADING
         *
         * RULE 4: Jangan expect urutan output
         * Thread itu:
         * nondeterministic (tidak bisa ditebak)
         *
         * RULE 5: Hati-hati shared data
         * Kalau nanti lu pakai variabel bareng:
         * bisa chaos (race condition)
         * (kita bahas nanti di synchronization)
         *
         * RULE 6: sleep() bukan wajib
         * Dia cuma:
         * simulasi delay
         * bantu lihat efek concurrency
         *
         * RULE 7: Thread tidak langsung jalan saat dibuat
         * new Thread(...)
         * belum jalan
         * harus start()
         *
         * Kenapa Java pakai Runnable?
         *
         * Karena:
         * class A extends Thread // terbatas
         * class A implements Runnable // fleksibel
         *
         * Java cuma bisa extend 1 class
         * tapi bisa implement banyak interface
         *
         * PENUTUP:
         *
         * Kalau di ringkas:
         * Runnable = blueprint kerja
         * Thread = yang ngejalanin
         * start() = tombol hidup
         * run() = isi kerjaan
         */

    }
}
