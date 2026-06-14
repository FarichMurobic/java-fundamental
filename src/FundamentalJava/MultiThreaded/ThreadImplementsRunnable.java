package FundamentalJava.MultiThreaded;

/**
     * Creating a Thread (Membuat Thread)
     * Secara umum, kamu membuat thread dengan membuat objek dari tipe Thread.
     *
     * Java menyediakan dua cara:
     * Mengimplementasikan interface Runnable
     * Meng-extends class Thread
     *
     * Implementing Runnable
     * Cara paling mudah adalah membuat class yang mengimplementasikan Runnable.
     * Runnable merepresentasikan sebuah unit kode yang bisa dijalankan.
     * Untuk implement, cukup buat method:
     * public void run()
     *
     * Isi dari run() adalah kode yang akan dijalankan oleh thread baru.
     *
     * Penting:
     * run() bisa melakukan apapun seperti main()
     * Bedanya: run() adalah titik awal thread baru (entry point)
     * Thread akan selesai saat run() selesai.
     *
     * Setelah buat class Runnable, kita bikin object Thread:
     * Thread(Runnable threadOb, String threadName)
     * threadOb → objek yang punya method run()
     * threadName → nama thread
     *
     * Thread tidak langsung jalan!
     *
     * Harus dipanggil:
     * start()
     * start() → akan menjalankan run()
     *
     * Konsep utama di sini:
     * Thread = jalur eksekusi lain dalam program
     * main() = thread utama
     * run() = thread tambahan
     *
     * Jadi program bisa:
     * jalan barengan (concurrent)
     * bukan satu-satu lagi
     *
     * Runnable = “pekerjaan”
     * Lu bikin kerjaan:
     * run()
     *
     * Thread = “pekerja”
     * Thread yang ngejalanin kerjaan itu
     *
     * Analoginya:
     * Runnable → script pekerjaan
     * Thread → orang yang ngerjain
     *
     * Insight penting:
     * t.start();  // BENAR
     * t.run();    // SALAH (kalau mau multithreading)
     *
     * Kenapa?
     * start() → bikin thread baru
     * run() → cuma dipanggil biasa (tidak multithread)
     *
     * Bedah Kode
     * implements Runnable
     *
     * Artinya:
     * “Class ini punya pekerjaan (run) yang bisa dijalankan thread”
     *
     * new Thread(this, "Demo Thread")
     * Ini penting banget:
     * this
     * Artinya:
     * thread akan menjalankan run() dari object ini
     *
     * t.start()
     * Ini yang bikin:
     * thread baru dibuat
     * run() dipanggil secara paralel
     *
     * Thread.sleep(500)
     * Artinya:
     * thread “tidur” 500ms
     * Dipakai biar keliatan efek concurrency
     *
     * Hal yang Sering Bikin Bingung
     * 1. Kenapa output acak?
     *
     * Karena:
     * thread jalan bersamaan
     * CPU bagi waktu
     *
     * Kenapa pakai try-catch?
     * Karena:
     * Thread.sleep()
     * bisa throw:
     * InterruptedException
     *
     * Thread itu bukan jalan paralel 100%, tapi gantian cepat banget (concurrent)
     *
     * Dan ini:
     * Runnable lebih fleksibel daripada extends Thread
     *
     * Kenapa?
     * Java cuma bisa extends 1 class
     * Tapi bisa implement banyak interface
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
     *     new NewThread();
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
     *     System.out.println("Child Thread: " + i);
     *     Thread.sleep(500);
     * }
     * 
     * Yang terjadi:
     * print angka
     * tidur 500ms
     * ulang
     *
     * PERBEDAAN KECEPATAN
     * Thread	    Sleep
     * Child	    500ms
     * Main	        1000ms
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
     * t.run();   // cuma method biasa
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
     * class A extends Thread   // terbatas
     * class A implements Runnable // fleksibel
     *
     * Java cuma bisa extend 1 class
     * tapi bisa implement banyak interface
     *
     * PENUTUP (INTI PALING DALAM)
     *
     * Kalau gue ringkas:
     * Runnable = blueprint kerja
     * Thread = yang ngejalanin
     * start() = tombol hidup
     * run() = isi kerjaan
     */

    }
}
