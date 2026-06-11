package MultiThreaded;

/**
     * The synchronized Statement
     *
     * Walaupun membuat method dengan synchronized itu gampang dan efektif, tapi tidak selalu bisa dipakai.
     *
     * Bayangin:
     * Lu mau sync sebuah class
     * Tapi class itu:
     * dibuat oleh orang lain (third party)
     * lu tidak punya source code-nya
     *
     * Jadi lu tidak bisa tambah keyword synchronized di method-nya
     *
     * Solusinya gimana?
     * Gunakan:
     *
     * synchronized(objRef) {
     *     // kode yang mau disinkronisasi
     * }
     *
     * Ini disebut synchronized block
     *
     * Artinya:
     * Lu “ngunci” object objRef
     * Semua kode di dalam block:
     * hanya bisa dijalankan oleh 1 thread dalam satu waktu
     *
     * Perbedaan besar:
     * synchronized method:
     * synchronized void call() {}
     * Lock otomatis = this (object sekarang)
     * Lu tidak bisa kontrol lock object lain
     *
     * synchronized block:
     * synchronized(target) {
     *     target.call(msg);
     * }
     *
     * Lu bebas milih:
     * object mana yang mau dijadikan lock
     *
     * Karena di dunia nyata:
     * Banyak class dari library
     * Lu gak bisa ubah kodenya
     *
     * Contoh:
     * ArrayList
     * HashMap
     *
     * Kalau mau thread-safe:
     * lu harus sync dari luar
     *
     * APA YANG TERJADI DI BALIK LAYAR?
     * Saat thread masuk:
     * synchronized(target)
     *
     * Java melakukan:
     * Cek: apakah target sedang dikunci?
     * Kalau tidak:
     * thread ambil lock
     * masuk block
     * Kalau iya:
     * thread nunggu (blocked)
     *
     * Flow:
     * Thread 1:
     * ambil lock target
     * jalan call()
     * keluar → lepas lock
     *
     * Thread 2:
     * nunggu
     * baru jalan setelah Thread 1 selesai
     *
     * PERBANDINGAN: METHOD vs BLOCK
     * Fitur	                                synchronized method	            synchronized block
     * Lock object	                            otomatis (this)	                bisa pilih
     * Fleksibel	                            tidak	                        ya
     * Bisa dipakai di class orang lain	        tidak                           ya
     * Granularity (kontrol detail)	            kasar	                        halus
     *
     * Lock tidak harus "this"
     * Object lock = new Object();
     *
     * synchronized(lock) {
     *     // critical section
     * }
     *
     * Ini sering dipakai di real-world
     *
     * Lu bisa lock sebagian kecil kode
     * void method() {
     *
     *     // tidak perlu lock
     *     doSomething();
     *
     *     synchronized(this) {
     *         // hanya bagian penting yang dikunci
     *         criticalSection();
     *     }
     * }
     *
     * Ini bikin:
     * program lebih cepat
     * tidak semua dikunci
     *
     * KESIMPULAN DALAM
     * synchronized block = versi fleksibel dari synchronization
     *
     * Dipakai kalau:
     * gak bisa ubah class
     * butuh kontrol lock lebih detail
     * Lock = object
     * Thread lain = harus nunggu
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
