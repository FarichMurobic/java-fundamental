package FundamentalJava.MultiThreaded;

/*
 * ============================================================
 * Mengontrol Thread: suspend(), resume(), stop() vs Cara Modern
 * ============================================================
 *
 * Dalam multithreading, terkadang kita perlu mengontrol thread:
 *
 * - Menjeda sementara.
 * - Melanjutkan kembali.
 * - Menghentikan pekerjaan.
 *
 * Java pernah menyediakan:
 *
 * suspend()
 * resume()
 * stop()
 *
 *
 * Tetapi method tersebut sekarang sudah deprecated karena memiliki
 * masalah desain yang serius.
 *
 * ------------------------------------------------------------
 * Masalah Pada suspend()
 * ------------------------------------------------------------
 *
 * suspend() digunakan untuk menghentikan sementara sebuah thread.
 *
 * Kedengarannya sederhana:
 *
 * "Pause thread sekarang."
 *
 *
 * Tetapi masalahnya:
 *
 * Thread dapat dihentikan ketika sedang memegang lock.
 *
 *
 * Contoh:
 *
 * Thread A:
 *
 * mendapatkan lock object Data
 *
 *        |
 *        v
 *
 * suspend()
 *
 *
 * Akibatnya:
 *
 * Lock tetap dimiliki Thread A.
 *
 *
 * Thread lain yang membutuhkan Data:
 *
 * harus menunggu selamanya.
 *
 *
 * Hasil:
 *
 * DEADLOCK
 *
 * ------------------------------------------------------------
 * Masalah Pada stop()
 * ------------------------------------------------------------
 *
 * stop() menghentikan thread secara paksa.
 *
 *
 * Masalah:
 *
 * Thread mungkin sedang:
 *
 * - Mengubah data.
 * - Menulis file.
 * - Memproses transaksi.
 *
 *
 * Jika dihentikan tiba-tiba:
 *
 * Data dapat berada pada kondisi tidak lengkap.
 *
 *
 * Contoh:
 *
 * Sebelum selesai:
 *
 * saldo = saldo - transfer
 *
 *
 * Thread dihentikan.
 *
 *
 * Data menjadi tidak konsisten.
 *
 * ------------------------------------------------------------
 * Masalah Utama Method Lama
 * ------------------------------------------------------------
 *
 * Metode lama menggunakan pendekatan:
 *
 * "Paksa thread berhenti."
 *
 *
 * Masalahnya:
 *
 * Thread tidak diberi kesempatan untuk:
 *
 * - Membersihkan resource.
 * - Melepaskan lock.
 * - Menyelesaikan pekerjaan aman.
 *
 *
 * Karena itu Java menggunakan pendekatan baru:
 *
 * Cooperative Thread Control
 *
 * ------------------------------------------------------------
 * Konsep Modern: Thread Mengontrol Dirinya Sendiri
 * ------------------------------------------------------------
 *
 * Ide utamanya:
 *
 * Thread tidak dipaksa berhenti dari luar.
 *
 *
 * Thread diberi tanda atau sinyal,
 * kemudian thread tersebut mengecek kondisinya sendiri.
 *
 *
 * Contoh menggunakan flag:
 *
 * boolean suspendFlag;
 *
 *
 * Arti flag:
 *
 * false:
 *
 * Thread berjalan normal.
 *
 *
 * true:
 *
 * Thread harus berhenti sementara.
 *
 * ------------------------------------------------------------
 * Cara Kerja Flag Control
 * ------------------------------------------------------------
 *
 * Alur:
 *
 * Thread bekerja
 *
 *       |
 *       v
 *
 * Mengecek flag
 *
 *       |
 *       v
 *
 * Jika false:
 *
 * lanjut bekerja
 *
 *
 * Jika true:
 *
 * tunggu
 *
 *
 * Jadi thread memiliki kontrol terhadap dirinya sendiri.
 *
 * ------------------------------------------------------------
 * Analisis Kode NewThread
 * ------------------------------------------------------------
 *
 * Variable:
 *
 * boolean suspendFlag;
 *
 *
 * Berfungsi sebagai saklar kontrol thread.
 *
 *
 * Constructor:
 *
 * t = new Thread(this, name);
 *
 * suspendFlag = false;
 *
 * t.start();
 *
 *
 * Artinya:
 *
 * - Membuat object Thread.
 * - Kondisi awal thread aktif.
 * - Thread langsung mulai menjalankan run().
 *
 * ------------------------------------------------------------
 * Method run()
 * ------------------------------------------------------------
 *
 * Contoh:
 *
 * for(int i = 15; i > 0; i--)
 *
 *
 * Thread menjalankan pekerjaan berupa countdown.
 *
 *
 * Setiap iterasi:
 *
 * 1. Menampilkan nilai.
 *
 * System.out.println(name + ": " + i);
 *
 *
 * 2. Memberikan delay.
 *
 * Thread.sleep(200);
 *
 *
 * sleep() hanya digunakan agar proses terlihat.
 *
 *
 * sleep() bukan mekanisme komunikasi thread.
 *
 * ------------------------------------------------------------
 * Bagian Penting: synchronized dan wait()
 * ------------------------------------------------------------
 *
 * Contoh:
 *
 * synchronized(this)
 *
 *
 * Dibutuhkan karena:
 *
 * wait() dan notify()
 *
 * bekerja melalui object monitor.
 *
 *
 * Tanpa synchronized:
 *
 * IllegalMonitorStateException
 *
 * dapat terjadi.
 *
 * ------------------------------------------------------------
 * Mengecek Flag
 * ------------------------------------------------------------
 *
 * Contoh:
 *
 * while(suspendFlag) {
 *
 *     wait();
 *
 * }
 *
 *
 * Artinya:
 *
 * Jika flag bernilai true:
 *
 * Thread masuk kondisi menunggu.
 *
 *
 * Jika flag berubah menjadi false:
 *
 * Thread dapat melanjutkan.
 *
 *
 * Kenapa while?
 *
 * Karena:
 *
 * - Mengantisipasi spurious wakeup.
 * - Kondisi harus selalu dicek ulang.
 *
 * ------------------------------------------------------------
 * Method mysuspend()
 * ------------------------------------------------------------
 *
 * Contoh:
 *
 * mysuspend()
 *
 *
 * Mengubah:
 *
 * suspendFlag = true;
 *
 *
 * Artinya:
 *
 * "Saat thread melakukan pengecekan berikutnya,
 * thread harus berhenti sementara."
 *
 *
 * Penting:
 *
 * Method ini TIDAK langsung menghentikan thread.
 *
 *
 * Thread berhenti ketika mencapai:
 *
 * while(suspendFlag)
 *
 *
 * ------------------------------------------------------------
 * Method myresume()
 * ------------------------------------------------------------
 *
 * Contoh:
 *
 * myresume()
 *
 *
 * Mengubah:
 *
 * suspendFlag = false;
 *
 *
 * Kemudian:
 *
 * notify()
 *
 *
 * Artinya:
 *
 * - Mengubah status agar thread boleh berjalan.
 * - Memberikan sinyal kepada thread yang menunggu.
 *
 *
 * Thread kemudian mendapatkan lock kembali dan melanjutkan.
 *
 * ------------------------------------------------------------
 * Simulasi Eksekusi
 * ------------------------------------------------------------
 *
 * Awal:
 *
 * Thread One
 * Thread Two
 *
 *
 * Berjalan bersamaan:
 *
 * One: 15
 * Two: 15
 *
 * One: 14
 * Two: 14
 *
 *
 * Kemudian:
 *
 * ob1.mysuspend();
 *
 *
 * Yang terjadi:
 *
 * suspendFlag = true
 *
 *
 * Thread One tidak langsung berhenti.
 *
 *
 * Ketika pengecekan berikutnya:
 *
 * while(suspendFlag)
 *
 *
 * Thread One:
 *
 * masuk wait()
 *
 *
 * Hasil:
 *
 * One berhenti sementara.
 *
 * Two tetap berjalan.
 *
 *
 * ------------------------------------------------------------
 * Resume Thread
 * ------------------------------------------------------------
 *
 * Pemanggilan:
 *
 * ob1.myresume();
 *
 *
 * Yang terjadi:
 *
 * suspendFlag = false
 *
 * notify()
 *
 *
 * Thread One dibangunkan.
 *
 *
 * Setelah mendapatkan lock:
 *
 * Thread One melanjutkan pekerjaan.
 *
 * ------------------------------------------------------------
 * Perbandingan Pendekatan Lama dan Modern
 * ------------------------------------------------------------
 *
 * suspend()/resume()/stop()
 *
 * - Thread dipaksa berhenti.
 * - Berbahaya.
 * - Dapat menyebabkan deadlock.
 * - Dapat merusak data.
 *
 *
 * Cooperative Control
 *
 * - Thread berhenti berdasarkan kondisi.
 * - Lebih aman.
 * - Lebih terkontrol.
 *
 *
 * ------------------------------------------------------------
 * Konsep Modern Java: Interrupt
 * ------------------------------------------------------------
 *
 * Dalam Java modern, penghentian thread sering menggunakan:
 *
 * Thread.interrupt()
 *
 *
 * Interrupt bukan mematikan thread secara paksa.
 *
 *
 * Interrupt hanya memberikan sinyal:
 *
 * "Thread, kalau memungkinkan berhentilah."
 *
 *
 * Thread kemudian memutuskan bagaimana menangani sinyal tersebut.
 *
 *
 * Ini memiliki konsep yang sama:
 *
 * Cooperative Thread Control.
 *
 * ------------------------------------------------------------
 * Penggunaan Dunia Nyata
 * ------------------------------------------------------------
 *
 * Konsep ini digunakan pada:
 *
 * - Background worker.
 * - Task processing.
 * - Thread pool.
 * - Server application.
 * - Job scheduler.
 *
 *
 * Pada aplikasi modern biasanya memakai:
 *
 * - ExecutorService.
 * - Future.
 * - CompletableFuture.
 * - BlockingQueue.
 *
 * ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * Method:
 *
 * suspend()
 * resume()
 * stop()
 *
 *
 * sudah deprecated karena berbahaya.
 *
 *
 * Pendekatan yang benar:
 *
 * - Thread mengontrol dirinya sendiri.
 * - Gunakan flag atau interrupt sebagai sinyal.
 * - Gunakan wait() untuk menunggu kondisi.
 * - Gunakan notify() untuk memberi tahu thread lain.
 *
 *
 * Prinsip utama:
 *
 * "Thread yang baik tidak dipaksa berhenti,
 * tetapi diberikan sinyal agar dapat berhenti dengan aman."
 *
 */

class NewThread2 implements Runnable {
    String name; // nama thread
    Thread thread;
    boolean suspendFlag; // flag untuk kontrol suspend

    NewThread2(String threadName) {
        name = threadName;
        thread = new Thread(this, name);

        System.out.println("New Thread: " + thread);
        suspendFlag = false; // awalnya jalan
        thread.start();
    }

    // methode utama thread
    @Override
    public void run() {
        try {
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200); // delay biar keliatan prosesnya

                // bagian penting untuk konstrol suspend
                synchronized (this) {
                    while (suspendFlag) {
                        wait(); // thread tidur disini
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " Interrupted.");
        }
        System.out.println(name + " exiting");
    }

    // methode untuk suspend thread
    synchronized void mysuspend() {
        suspendFlag = true;
    }

    // method untuk resume thread
    synchronized void myresume() {
        suspendFlag = false;
        notify(); // bangunin thread yang lagi nunggu
    }
}

public class KonsepTerdahulu {
    public static void main(String[] args) {
        NewThread2 ob1 = new NewThread2("One");
        NewThread2 ob2 = new NewThread2("Two");

        try {
            Thread.sleep(1000);
            // suspend thread one
            ob1.mysuspend();
            System.out.println("Suspending thread one");

            Thread.sleep(1000);
            // resume thread one
            ob1.myresume();
            System.out.println("Resuming thread one");

            // suspend thread Two
            ob2.mysuspend();
            System.out.println("Suspending thread Two");

            Thread.sleep(1000);

            // resume thread Two
            ob2.myresume();
            System.out.println("Resuming thread Two");
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        // tunggu thread selesai
        try {
            System.out.println("Waiting for threads to finish...");
            ob1.thread.join();
            ob2.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting...");
    }
}
