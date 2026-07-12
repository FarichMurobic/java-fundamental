package FundamentalJava.MultiThreaded;

/**
 * ------------------------------------------------------------------------
 * EXTENDING THREAD (MEWARISI THREAD)
 * ------------------------------------------------------------------------
 * 
 * Cara kedua untuk membuat thread adalah:
 * - Membuat class baru yang extends Thread
 * - Lalu membuat objek dari class tersebut
 * 
 * Class ini harus:
 * - Meng-override method run() → sebagai titik awal eksekusi thread
 * - Memanggil start() → untuk memulai eksekusi
 * 
 * Pada pendekatan ini:
 * NewThread bukan lagi berupa Runnable,
 * tapi langsung menjadi Thread itu sendiri.
 * 
 * ------------------------------------------------------------------------
 * PERBEDAAN KONSEP (INI INTI BANGET)
 * ------------------------------------------------------------------------
 * 
 * Sebelumnya (dengan Runnable):
 *     class NewThread implements Runnable
 * 
 * Kamu membuat tugas (pekerjaan),
 * lalu menyerahkannya ke Thread untuk dijalankan.
 * 
 * Sekarang (dengan Thread):
 *     class NewThread extends Thread
 * 
 * Kamu membuat thread itu sendiri secara langsung.
 * 
 * ------------------------------------------------------------------------
 * PERBEDAAN KRITIS (Runnable vs Extends Thread)
 * ------------------------------------------------------------------------
 * 
 * Aspek               | Runnable                     | Extends Thread
 * --------------------|------------------------------|-----------------------
 * Desain              | Memisahkan tugas dan thread  | Menyatukan menjadi satu
 * Fleksibilitas       | Tinggi                       | Rendah
 * Inheritance         | Bisa extends class lain      | Tidak bisa (sudah extends Thread)
 * Best Practice       | Disarankan                   | Jarang dipakai
 * 
 * ------------------------------------------------------------------------
 * KENAPA RUNNABLE LEBIH DISARANKAN?
 * ------------------------------------------------------------------------
 * 
 * 1. Java hanya mendukung single inheritance.
 *    Jika class sudah extends Thread, maka tidak bisa extends class lain.
 * 
 * 2. Runnable memisahkan tugas (task) dari mekanisme eksekusi (thread).
 *    Ini sesuai dengan prinsip separation of concerns.
 * 
 * 3. Runnable lebih fleksibel karena bisa digunakan dengan:
 *    - Thread biasa
 *    - ExecutorService
 *    - Thread pool
 * 
 * 4. Pendekatan Runnable mendukung pola desain yang lebih baik
 *    untuk aplikasi skala besar.
 * 
 * ------------------------------------------------------------------------
 * KAPAN MENGGUNAKAN EXTENDS THREAD?
 * ------------------------------------------------------------------------
 * 
 * Hanya dalam kasus tertentu, seperti:
 * - Membuat thread dengan perilaku yang sangat spesifik
 * - Butuh meng-override method lain dari Thread selain run()
 * - Pembuatan aplikasi sederhana atau edukasi
 * 
 * ------------------------------------------------------------------------
 * CONTOH IMPLEMENTASI
 * ------------------------------------------------------------------------
 * 
 *     class NewThread extends Thread {
 *         
 *         NewThread() {
 *             super("Demo Thread");
 *             System.out.println("Child thread: " + this);
 *             start();
 *         }
 *         
 *         public void run() {
 *             try {
 *                 for (int i = 5; i > 0; i--) {
 *                     System.out.println("Child Thread: " + i);
 *                     Thread.sleep(500);
 *                 }
 *             } catch (InterruptedException e) {
 *                 System.out.println("Child interrupted.");
 *             }
 *             System.out.println("Exiting child thread.");
 *         }
 *     }
 * 
 *     public class Main {
 *         public static void main(String[] args) {
 *             new NewThread();
 *             
 *             try {
 *                 for (int i = 5; i > 0; i--) {
 *                     System.out.println("Main Thread: " + i);
 *                     Thread.sleep(1000);
 *                 }
 *             } catch (InterruptedException e) {
 *                 System.out.println("Main thread interrupted.");
 *             }
 *             System.out.println("Main thread exiting.");
 *         }
 *     }
 * 
 * ------------------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------------------
 * 
 * Extends Thread adalah cara membuat thread dengan mewarisi class Thread
 * secara langsung. Namun, pendekatan ini kurang fleksibel dibandingkan
 * dengan Runnable karena keterbatasan single inheritance di Java.
 * 
 * Untuk pengembangan aplikasi nyata, pendekatan Runnable atau
 * Callable + ExecutorService jauh lebih direkomendasikan.
 * 
 * ------------------------------------------------------------------------
 */

// extends Thread
class NewThread1 extends Thread {

    NewThread1() {
        // kasih nama thread
        super("Demo");
        System.out.println("Child thread: " + this);
        start(); // mulai thread
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("child thread: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("child interrupted.");
        }
        System.out.println("exiting child thread");
    }
}

public class ThreadByExtendsThread {
    public static void main(String[] args) {
        new NewThread1(); // bikin thread

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("main thread: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("main thread interrupted.");
        }
        System.out.println("main thread exiting.");

        /**
         * Bedah DALAM (Step-by-step)
         * 
         * 1. Masuk main()
         * new NewThread();
         *
         * object dibuat
         * constructor jalan
         *
         * 2. Constructor NewThread
         * super("Demo Thread");
         *
         * INI PENTING
         *
         * manggil constructor parent (Thread)
         * kasih nama thread
         *
         * 2. Constructor NewThread
         * super("Demo Thread");
         *
         * INI PENTING
         *
         * manggil constructor parent (Thread)
         * kasih nama thread
         *
         * 4. start()
         * start();
         *
         * langsung jalanin thread
         * otomatis manggil run()
         *
         * Insight PALING PENTING
         * Perbedaan this
         * Runnable:
         * new Thread(this)
         *
         * this = objek yang punya run()
         *
         * Extends Thread:
         * this
         *
         * this = thread itu sendiri
         */

    }
}
