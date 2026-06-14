package FundamentalJava.MultiThreaded;

/**
 * Deadlock
 *
 * Deadlock adalah error khusus di multitasking yang terjadi ketika:
 * Dua thread saling nunggu satu sama lain selamanya
 *
 * Contoh:
 * Thread 1 pegang lock di object X
 * Thread 2 pegang lock di object Y
 *
 * Lalu:
 * Thread 1 butuh Y → nunggu
 * Thread 2 butuh X → nunggu
 *
 * Hasilnya: dua-duanya stuck selamanya
 *
 * --------------
 * 
 * Kenapa Deadlock susah dideteksi?
 * Jarang terjadi
 * Harus timing-nya pas banget
 * Bisa kompleks
 * Bisa lebih dari 2 thread & 2 object
 *
 * -----------------------------
 * 
 * Penjelasan Inti (biar kebayang jelas)
 * 
 * Inti Deadlock = Circular Waiting
 *
 * Bayangin:
 * Thread A → pegang kunci A → butuh kunci B
 * Thread B → pegang kunci B → butuh kunci A
 *
 * Jadinya:
 * A nunggu B
 * B nunggu A
 *
 * Nggak ada yang bisa jalan lagi
 */

/**
 * BEDAH CONTOH KODE PROGRAM
 *
 * Apa yang terjadi step-by-step?
 * MainThread
 * masuk A.foo()
 * pegang lock A
 *
 * RacingThread
 * masuk B.bar()
 * pegang lock B
 *
 * Lanjut:
 * MainThread mau akses B.last() → harus nunggu B
 * RacingThread mau akses A.last() → harus nunggu A
 *
 * BOOM → DEADLOCK
 * Output:
 * MainThread entered A.foo
 * RacingThread entered B.bar
 * MainThread trying to call B.last()
 * RacingThread trying to call A.last()
 *
 * Program freeze selamanya
 *
 * -----------------------------------------
 * 
 * Insight penting (ini yang bikin lu “naik level”)
 * 
 * 1. Deadlock = bukan error biasa
 * Nggak ada exception
 * Program cuma diam 
 *
 * 2. sleep() di sini cuma pemancing
 * Thread.sleep(1000);
 *
 * Tujuannya:
 * Biar timing bentrok
 * Deadlock jadi konsisten
 *
 * 3. Ini masalah desain, bukan syntax
 * Kode lu bisa:
 * Compile 
 * Run 
 * Tapi tetep salah 
 *
 * ------------------
 * 
 * Cara Menghindari Deadlock (WAJIB TAU)
 * 
 * 1. Lock Order (paling penting)
 * Selalu ambil lock dengan urutan yang sama:
 *
 * SALAH:
 * Thread A: lock A → lock B
 * Thread B: lock B → lock A
 *
 * BENAR:
 * Semua thread: lock A → lock B
 *
 * 2. Hindari nested synchronized berlebihan
 * synchronized(a) {
 *     synchronized(b) {
 *         ...
 *     }
 * }
 *
 * Ini rawan banget deadlock
 *
 * 3. Gunakan higher-level tools
 * Di Java modern:
 * Lock (ReentrantLock)
 * tryLock()
 * Concurrent Collections
 *
 * 4. Timeout (advanced)
 * Kalau nunggu terlalu lama:
 * batalin
 *
 * Perbandingan sama materi sebelumnya
 * Konsep	                Fungsi
 * synchronized	            cegah tabrakan
 * wait/notify	            koordinasi
 * deadlock	                kegagalan koordinasi
 *
 * Ringkasan Super Padat
 * Deadlock = thread saling nunggu selamanya
 * Terjadi karena circular lock
 * Sulit dideteksi
 * Solusi utama: lock ordering
 *
 * “Thread bukan cuma jalan bareng, tapi harus didesain bener”
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
