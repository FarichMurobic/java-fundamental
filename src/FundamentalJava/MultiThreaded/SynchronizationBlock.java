package FundamentalJava.MultiThreaded;

/**
 * ------------------------------------------------------------------------
 * PERNYATAAN SYNCHRONIZED
 * ------------------------------------------------------------------------
 * 
 * Walaupun membuat method dengan kata kunci synchronized itu mudah dan
 * efektif, tapi tidak selalu bisa diterapkan di semua situasi.
 * 
 * Coba bayangkan skenario ini:
 * Kamu ingin mensinkronisasi akses ke sebuah class,
 * tapi class tersebut:
 * - Dibuat oleh pihak ketiga (third party)
 * - Kamu tidak memiliki akses ke source code-nya
 * 
 * Jadi, kamu tidak bisa menambahkan kata kunci synchronized ke method-method
 * yang ada di dalam class tersebut.
 * 
 * Lalu, apa solusinya?
 * Gunakan synchronized block:
 * 
 *     synchronized(objRef) {
 *         // kode yang ingin disinkronisasi
 *     }
 * 
 * Konstruk inilah yang disebut dengan synchronized block.
 * 
 * Artinya:
 * Kamu mengunci objek yang dirujuk oleh objRef.
 * Semua kode di dalam blok ini:
 * hanya bisa dijalankan oleh satu thread dalam satu waktu.
 * 
 * ------------------------------------------------------------------------
 * PERBEDAAN UTAMA: METHOD vs BLOCK
 * ------------------------------------------------------------------------
 * 
 * Synchronized method:
 *     synchronized void call() { ... }
 *     Lock secara otomatis adalah this (instance objek saat ini).
 *     Kamu tidak bisa mengontrol objek mana yang dijadikan lock.
 * 
 * Synchronized block:
 *     synchronized(target) {
 *         target.call(msg);
 *     }
 *     Kamu bebas memilih:
 *     objek mana pun yang ingin dijadikan lock.
 * 
 * Di dunia nyata:
 * Banyak class berasal dari library eksternal,
 * dan kamu tidak bisa mengubah kode sumbernya.
 * 
 * Contoh:
 * - ArrayList
 * - HashMap
 * 
 * Untuk membuatnya thread-safe:
 * kamu harus mengatur sinkronisasi dari luar.
 * 
 * ------------------------------------------------------------------------
 * APA YANG TERJADI DI BALIK LAYAR?
 * ------------------------------------------------------------------------
 * 
 * Ketika sebuah thread mencoba masuk ke:
 *     synchronized(target)
 * 
 * Java melakukan proses berikut:
 * 1. Mengecek apakah objek target sedang dikunci oleh thread lain
 * 2. Jika tidak dikunci:
 *    - Thread mengambil lock
 *    - Masuk ke dalam blok
 * 3. Jika sedang dikunci:
 *    - Thread akan menunggu (berada dalam status blocked)
 * 
 * Alur eksekusi:
 * 
 * Thread 1:
 * - Mengambil lock pada target
 * - Menjalankan call()
 * - Keluar dari blok → melepas lock
 * 
 * Thread 2:
 * - Menunggu
 * - Baru berjalan setelah Thread 1 selesai
 * 
 * ------------------------------------------------------------------------
 * PERBANDINGAN: METHOD vs BLOCK
 * ------------------------------------------------------------------------
 * 
 * Fitur                    | Synchronized Method   | Synchronized Block
 * -------------------------|-----------------------|--------------------
 * Objek lock               | Otomatis (this)       | Bisa dipilih sendiri
 * Fleksibilitas            | Tidak                 | Ya
 * Bisa dipakai di class    | Tidak                 | Ya
 * pihak ketiga             |                       |
 * Tingkat kontrol          | Kasar (coarse)        | Halus (fine-grained)
 * 
 * ------------------------------------------------------------------------
 * LOCK TIDAK HARUS "this"
 * ------------------------------------------------------------------------
 * 
 * Kamu bisa membuat objek lock khusus:
 * 
 *     Object lock = new Object();
 * 
 *     synchronized(lock) {
 *         // bagian kritis (critical section)
 *     }
 * 
 * Pola ini sering digunakan di aplikasi dunia nyata.
 * 
 * Kamu bisa mengunci hanya sebagian kecil dari sebuah method:
 * 
 *     void method() {
 *         // Tidak perlu lock di sini
 *         doSomething();
 * 
 *         synchronized(this) {
 *             // Hanya bagian penting yang dikunci
 *             criticalSection();
 *         }
 *     }
 * 
 * Pendekatan ini menghasilkan:
 * - Performa yang lebih baik
 * - Tidak semua bagian method terkunci tanpa perlu
 * 
 * ------------------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------------------
 * 
 * Synchronized block adalah versi fleksibel dari sinkronisasi tingkat method.
 * 
 * Gunakan ketika:
 * - Kamu tidak bisa mengubah class target
 * - Kamu butuh kontrol yang lebih detail terhadap objek lock
 * - Lock bisa berupa objek apa pun yang kamu tentukan
 * - Thread lain hanya perlu menunggu jika benar-benar diperlukan
 * 
 * ------------------------------------------------------------------------
 */

class CallmeOne {

    // tidak pakai synchronized
    void call(String msg) {
        System.out.println("[" + msg);
        try {
            Thread.sleep(1000); // simulasi delay
        } catch (InterruptedException e) {
            System.out.println("Interrupted...");
        }
        System.out.println("]");
    }
}

class Caller1 implements Runnable {

    String msg;
    CallmeOne target;
    Thread thread;

    public Caller1(CallmeOne target, String msg) {
        this.target = target;
        this.msg = msg;

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        // lock dimulai disini
        synchronized (target) {
            // hanya 1 thread boleh masuk kesini
            target.call(msg);
        }
        // lock dilepas disini
    }
}

public class SynchronizationBlock {
    public static void main(String[] args) {

        // shared object
        CallmeOne target = new CallmeOne();

        // 3 thread pakai objek yang sama
        Caller1 t1 = new Caller1(target, "Hello");
        Caller1 t2 = new Caller1(target, "Synchronized");
        Caller1 t3 = new Caller1(target, "World");

        // tunggu selesai
        try {
            t1.thread.join();
            t2.thread.join();
            t3.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main interrupted...");
        }
    }
}
