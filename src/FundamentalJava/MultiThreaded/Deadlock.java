package FundamentalJava.MultiThreaded;

/*
 * ============================================================
 * Deadlock Pada Multithreading Java
 * ============================================================
 *
 * Deadlock adalah kondisi ketika dua atau lebih thread saling
 * menunggu resource yang sedang dikunci oleh thread lain,
 * sehingga semua thread tersebut tidak dapat melanjutkan eksekusi..
 *
 * Berbeda dengan exception:
 *
 * Deadlock tidak menyebabkan program crash.
 *
 * Program tetap berjalan, tetapi thread berhenti bekerja karena
 * semuanya menunggu satu sama lain.
 *
 * ------------------------------------------------------------
 * Contoh Sederhana Deadlock
 * ------------------------------------------------------------
 *
 * Misalkan terdapat dua object:
 *
 * Object X
 * Object Y
 *
 *
 * Thread 1:
 *
 * Mengunci X
 * Membutuhkan Y
 *
 *
 * Thread 2:
 *
 * Mengunci Y
 * Membutuhkan X
 *
 *
 * Kondisi:
 *
 * Thread 1:
 * "Saya menunggu Y."
 *
 * Thread 2:
 * "Saya menunggu X."
 *
 *
 * Karena:
 *
 * Thread 1 menunggu Thread 2
 * Thread 2 menunggu Thread 1
 *
 *
 * Maka keduanya tidak pernah selesai.
 *
 * ------------------------------------------------------------
 * Inti Deadlock: Circular Waiting
 * ------------------------------------------------------------
 *
 * Penyebab utama deadlock adalah:
 *
 * Circular waiting
 *
 *
 * Contoh:
 *
 * Thread A
 *
 * Memegang lock A
 *        |
 *        v
 * Membutuhkan lock B
 *
 *
 * Thread B
 *
 * Memegang lock B
 *        |
 *        v
 * Membutuhkan lock A
 *
 *
 * Hasil:
 *
 * A menunggu B
 * B menunggu A
 *
 *
 * Tidak ada thread yang dapat melanjutkan.
 *
 * ------------------------------------------------------------
 * Empat Kondisi Terjadinya Deadlock
 * ------------------------------------------------------------
 *
 * Deadlock dapat terjadi jika empat kondisi berikut terpenuhi:
 *
 * 1. Mutual Exclusion
 *
 * Resource hanya dapat digunakan oleh satu thread pada satu
 * waktu.
 *
 *
 * Contoh:
 *
 * synchronized(object)
 *
 *
 * 2. Hold and Wait
 *
 * Thread sudah memegang satu lock dan menunggu lock lain.
 *
 *
 * 3. No Preemption
 *
 * Lock tidak dapat dipaksa diambil dari thread lain.
 *
 *
 * 4. Circular Waiting
 *
 * Thread saling menunggu membentuk lingkaran.
 *
 *
 * Jika empat kondisi ini terjadi bersamaan,
 * deadlock dapat terjadi.
 *
 * ------------------------------------------------------------
 * Analisis Contoh Program Deadlock
 * ------------------------------------------------------------
 *
 * Misalkan terdapat:
 *
 * Class A
 * Class B
 *
 *
 * MainThread:
 *
 * Memanggil:
 *
 * A.foo()
 *
 *
 * Kemudian:
 *
 * MainThread mendapatkan lock object A.
 *
 *
 * RacingThread:
 *
 * Memanggil:
 *
 * B.bar()
 *
 *
 * RacingThread mendapatkan lock object B.
 *
 *
 * Selanjutnya:
 *
 * MainThread ingin menjalankan:
 *
 * B.last()
 *
 *
 * Tetapi B sedang dikunci RacingThread.
 *
 *
 * Maka:
 *
 * MainThread menunggu B.
 *
 *
 * Di sisi lain:
 *
 * RacingThread ingin menjalankan:
 *
 * A.last()
 *
 *
 * Tetapi A sedang dikunci MainThread.
 *
 *
 * Maka:
 *
 * RacingThread menunggu A.
 *
 *
 * Kondisi akhir:
 *
 * MainThread menunggu RacingThread
 *
 * RacingThread menunggu MainThread
 *
 *
 * DEADLOCK terjadi.
 *
 * ------------------------------------------------------------
 * Contoh Alur Eksekusi
 * ------------------------------------------------------------
 *
 * MainThread
 *      |
 *      v
 * Masuk A.foo()
 *      |
 *      v
 * Mendapatkan lock A
 *
 *
 * RacingThread
 *      |
 *      v
 * Masuk B.bar()
 *      |
 *      v
 * Mendapatkan lock B
 *
 *
 * Kemudian:
 *
 * MainThread membutuhkan B
 *
 * RacingThread membutuhkan A
 *
 *
 * Program berhenti selamanya.
 *
 * ------------------------------------------------------------
 * Kenapa Deadlock Sulit Dideteksi?
 * ------------------------------------------------------------
 *
 * Deadlock sering sulit ditemukan karena:
 *
 * - Tidak selalu terjadi.
 * - Bergantung pada timing thread.
 * - Bisa muncul hanya pada kondisi tertentu.
 * - Bisa melibatkan banyak thread dan banyak resource.
 *
 *
 * Program dapat:
 *
 * Compile berhasil
 *
 * Run berhasil
 *
 * Tetapi memiliki desain concurrency yang salah.
 *
 * ------------------------------------------------------------
 * Peran Thread.sleep()
 * ------------------------------------------------------------
 *
 * Contoh deadlock sering menggunakan:
 *
 * Thread.sleep()
 *
 *
 * Tujuannya bukan menyebabkan deadlock.
 *
 * sleep() hanya memberikan waktu agar thread lain berjalan dan
 * mendapatkan lock yang berbeda.
 *
 *
 * Dengan begitu kondisi deadlock lebih mudah terjadi dan
 * diamati.
 *
 * ------------------------------------------------------------
 * Cara Menghindari Deadlock
 * ------------------------------------------------------------
 *
 * 1. Gunakan Lock Ordering
 *
 * Ini adalah cara paling penting.
 *
 *
 * Semua thread harus mengambil lock dengan urutan yang sama.
 *
 *
 * Buruk:
 *
 * Thread A:
 * lock A -> lock B
 *
 *
 * Thread B:
 * lock B -> lock A
 *
 *
 * Baik:
 *
 * Semua thread:
 *
 * lock A -> lock B
 *
 *
 * Tidak ada circular waiting.
 *
 * ------------------------------------------------------------
 * 2. Hindari Nested Synchronization Berlebihan
 * ------------------------------------------------------------
 *
 * Contoh:
 *
 * synchronized(a) {
 *
 *     synchronized(b) {
 *
 *     }
 *
 * }
 *
 *
 * Semakin banyak lock bertingkat,
 * semakin besar kemungkinan deadlock.
 *
 * ------------------------------------------------------------
 * 3. Gunakan Concurrency Utility Modern
 * ------------------------------------------------------------
 *
 * Java menyediakan API concurrency yang lebih fleksibel.
 *
 * Contoh:
 *
 * - ReentrantLock
 * - tryLock()
 * - Concurrent Collections
 * - ExecutorService
 *
 *
 * Contoh:
 *
 * tryLock()
 *
 * memungkinkan thread mencoba mendapatkan lock tanpa harus
 * menunggu selamanya.
 *
 * ------------------------------------------------------------
 * 4. Gunakan Timeout
 * ------------------------------------------------------------
 *
 * Pada sistem tertentu, thread tidak boleh menunggu selamanya.
 *
 * Jika lock tidak tersedia dalam waktu tertentu:
 *
 * - Batalkan operasi.
 * - Lakukan recovery.
 *
 * ------------------------------------------------------------
 * Cara Mendeteksi Deadlock
 * ------------------------------------------------------------
 *
 * Dalam aplikasi Java nyata, deadlock dapat dianalisis menggunakan:
 *
 * Thread Dump
 *
 *
 * Tools:
 *
 * - jstack
 * - Java Flight Recorder
 * - VisualVM
 *
 *
 * Thread dump dapat menunjukkan:
 *
 * "Thread A menunggu lock yang dimiliki Thread B."
 *
 * ------------------------------------------------------------
 * Perbandingan Konsep Concurrency
 * ------------------------------------------------------------
 *
 * synchronized
 *
 * Tujuan:
 *
 * Mencegah beberapa thread mengakses data bersamaan secara
 * tidak aman.
 *
 *
 * wait()/notify()
 *
 * Tujuan:
 *
 * Komunikasi dan koordinasi antar thread.
 *
 *
 * Deadlock
 *
 * Masalah:
 *
 * Thread gagal berkoordinasi sehingga saling menunggu.
 *
 * ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * Deadlock adalah kondisi ketika thread saling menunggu lock
 * sehingga program berhenti berjalan.
 *
 *
 * Konsep penting:
 *
 * - Deadlock bukan exception.
 * - Penyebab utama adalah circular waiting.
 * - Dapat terjadi walaupun kode berhasil compile dan run.
 * - sleep() hanya membantu memunculkan kondisi deadlock.
 * - Solusi utama adalah lock ordering.
 * - Gunakan concurrency utility modern jika memungkinkan.
 *
 *
 * Prinsip utama:
 *
 * "Dalam multithreading, bukan hanya membuat thread berjalan
 * bersamaan, tetapi juga harus mengatur bagaimana mereka
 * berbagi resource dengan aman."
 *
 */

// class A
class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered A.foo");

        try {
            Thread.sleep(1000); // biar deadlock kejadian
        } catch (Exception e) {
            System.out.println("A interrupted.");
        }

        System.out.println(name + " trying to call B.last().");
        b.last(); // butuh lock b
    }

    synchronized void last() {
        System.out.println("Inside A.last");
    }
}

// class B
class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " entered B.bar");

        try {
            Thread.sleep(1000); // biar deadlock kejadian
        } catch (Exception e) {
            System.out.println("B interrupted");
        }

        System.out.println(name + " trying to call A.last()");
        a.last(); // butuh lock a
    }

    synchronized void last() {
        System.out.println("Inside B.last");
    }
}

// CLASS UTAMAN MAIN TRIGGER
public class Deadlock implements Runnable {
    A a = new A();
    B b = new B();

    Deadlock() {
        Thread.currentThread().setName("MainThread");
        Thread thread = new Thread(this, "RacingThread");
        thread.start();

        a.foo(b); // mainthread pegang A
        System.out.println("Back in main thread.");
    }

    @Override
    public void run() {
        b.bar(a); // racingThread pegang B. ini akan deadlock
        // a.foo(b); ini gak akan deadlock
        System.out.println("Back in other thread");
    }

    public static void main(String[] args) {
        new Deadlock();
    }
}
