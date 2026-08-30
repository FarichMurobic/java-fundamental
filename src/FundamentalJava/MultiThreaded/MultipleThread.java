package FundamentalJava.MultiThreaded;

/*
 * ============================================================
 * Creating Multiple Threads (Membuat Banyak Thread)
 * ============================================================
 *
 * Pada materi sebelumnya, program hanya menggunakan:
 *
 * - 1 main thread
 * - 1 child thread
 *
 *
 * Tetapi Java sebenarnya memungkinkan sebuah program membuat
 * banyak thread secara bersamaan..
 *
 *
 * Contoh:
 *
 * Thread utama:
 *
 * main()
 *
 *
 * Membuat thread tambahan:
 *
 * Thread A
 * Thread B
 * Thread C
 *
 *
 * Semua thread tersebut dapat berjalan secara concurrent.
 *
 * ------------------------------------------------------------
 * Konsep Dasar Multiple Thread
 * ------------------------------------------------------------
 *
 * Setiap object dari class Thread merepresentasikan satu thread
 * yang dapat menjalankan tugas secara independen.
 *
 *
 * Contoh:
 *
 * Thread t1 = new Thread();
 * Thread t2 = new Thread();
 * Thread t3 = new Thread();
 *
 *
 * Artinya:
 *
 * Dibuat tiga object Thread.
 *
 * Maka terdapat tiga alur eksekusi tambahan.
 *
 * ------------------------------------------------------------
 * Hubungan Object Thread dan Eksekusi
 * ------------------------------------------------------------
 *
 * Penting:
 *
 * Tidak semua object Java membuat thread.
 *
 *
 * Contoh:
 *
 * User user = new User();
 *
 *
 * Object User hanya object biasa.
 *
 *
 * Sedangkan:
 *
 * Thread t = new Thread();
 *
 *
 * Object Thread memiliki kemampuan membuat alur eksekusi baru.
 *
 *
 * Jadi:
 *
 * 1 object Thread
 *        |
 *        v
 * 1 execution path
 *
 * ------------------------------------------------------------
 * Banyak Thread Dalam Satu Program
 * ------------------------------------------------------------
 *
 * Contoh struktur:
 *
 *
 * Main Thread
 *      |
 *      +---- Thread A
 *      |
 *      +---- Thread B
 *      |
 *      +---- Thread C
 *
 *
 * Semua thread tersebut berada dalam satu JVM process.
 *
 *
 * Mereka:
 *
 * - Menggunakan memory yang sama.
 * - Berbagi resource program.
 * - Berkompetisi menggunakan CPU.
 *
 * ------------------------------------------------------------
 * Cara CPU Menjalankan Banyak Thread
 * ------------------------------------------------------------
 *
 * Pada komputer dengan banyak core:
 *
 * Beberapa thread dapat benar-benar berjalan paralel.
 *
 *
 * Contoh:
 *
 * Core 1 → Thread A
 *
 * Core 2 → Thread B
 *
 *
 * Tetapi pada komputer dengan satu core:
 *
 * CPU melakukan switching sangat cepat antar thread.
 *
 *
 * Teknik ini disebut:
 *
 * Context Switching
 *
 *
 * Sehingga terlihat seperti banyak pekerjaan berjalan bersamaan.
 *
 * ------------------------------------------------------------
 * Output Multiple Thread
 * ------------------------------------------------------------
 *
 * Ketika banyak thread berjalan:
 *
 * Urutan output tidak selalu sama.
 *
 *
 * Contoh:
 *
 * Thread A:
 *
 * A1
 * A2
 * A3
 *
 *
 * Thread B:
 *
 * B1
 * B2
 * B3
 *
 *
 * Output bisa:
 *
 * A1
 * B1
 * A2
 * B2
 * B3
 * A3
 *
 *
 * Atau:
 *
 * B1
 * B2
 * A1
 * A2
 * B3
 * A3
 *
 *
 * Karena:
 *
 * Thread scheduler menentukan kapan sebuah thread mendapat
 * kesempatan berjalan.
 *
 * ------------------------------------------------------------
 * Kenapa Output Tidak Bisa Diprediksi?
 * ------------------------------------------------------------
 *
 * Karena setiap thread memiliki lifecycle sendiri:
 *
 *
 * New
 *  |
 *  v
 * Runnable
 *  |
 *  v
 * Running
 *  |
 *  v
 * Terminated
 *
 *
 * Perpindahan antar state bergantung pada:
 *
 * - JVM scheduler.
 * - Operating system scheduler.
 * - Kondisi CPU.
 * - Beban komputer.
 *
 *
 * Oleh karena itu:
 *
 * Program multithreading tidak boleh bergantung pada urutan
 * eksekusi tertentu.
 *
 * ------------------------------------------------------------
 * Masalah Yang Bisa Muncul
 * ------------------------------------------------------------
 *
 * Semakin banyak thread:
 *
 * Semakin besar kemungkinan terjadi:
 *
 * - Race condition.
 * - Data inconsistency.
 * - Deadlock.
 * - Thread starvation.
 *
 *
 * Karena itu diperlukan:
 *
 * - synchronized.
 * - Lock.
 * - Concurrent Collection.
 * - ExecutorService.
 *
 * ------------------------------------------------------------
 * Ringkasan Konsep Utama
 * ------------------------------------------------------------
 *
 * Multiple Thread:
 *
 * - Program dapat memiliki banyak thread.
 * - Setiap object Thread memiliki satu jalur eksekusi.
 * - Semua thread berbagi resource JVM.
 * - CPU mengatur pergantian eksekusi thread.
 * - Urutan output antar thread tidak dijamin.
 *
 *
 * Konsep inti:
 *
 * "Banyak thread tidak berarti banyak CPU,
 * tetapi banyak pekerjaan yang dapat dijadwalkan secara concurrent."
 *
 */

class ThreadOne implements Runnable {
    String name;
    Thread thread;

    ThreadOne(String threadName) {
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
        System.out.println(name + " Exiting..");
    }
}

public class MultipleThread {
    public static void main(String[] args) {

        new ThreadOne("One");
        new ThreadOne("two");
        new ThreadOne("three");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread exiting..");
    }
}
