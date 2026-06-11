package MultiThreaded;

/**
     * KONSEP BESAR DULU
     * 
     * Problem utama:
     * Dulu Java punya:
     * suspend()
     * resume()
     * stop()
     *
     * Kedengerannya enak kan?
     * Tapi ternyata BERBAHAYA BANGET
     *
     * Kenapa suspend() bahaya?
     * Bayangin:
     *
     * Thread A:
     * - lagi pegang lock data penting
     * - tiba-tiba disuspend 
     *
     * Masalah:
     * lock nggak dilepas
     * thread lain nunggu lock itu
     *
     * HASIL:
     * DEADLOCK
     *
     * Kenapa stop() bahaya?
     * Thread lagi ubah data (belum selesai)
     * → tiba-tiba di-stop 
     *
     * Data jadi:
     * setengah jadi
     * rusak (corrupted)
     *
     * SOLUSI MODERN (WAJIB PAHAM)
     * Jangan pakai method itu
     * Tapi:
     * Thread harus mengontrol dirinya sendiri
     *
     * Ide utamanya:
     * Gunakan flag (variabel kontrol)
     *
     * boolean suspendFlag;
     *
     * Artinya:
     * Flag	    Arti
     * false	jalan terus
     * true	    pause
     */

    /**
     * BEDAH KODE DALAM (PELAAAN)
     *
     * CLASS NewThread
     * boolean suspendFlag;
     *
     * Ini “saklar” thread
     *
     * Constructor
     * t = new Thread(this, name);
     * suspendFlag = false;
     * t.start();
     *
     * Artinya:
     * thread langsung jalan
     * awalnya tidak disuspend
     *
     * BAGIAN PALING PENTING: run()
     * for(int i = 15; i > 0; i--)
     *
     * Thread kerja: countdown
     *
     * STEP PER ITERASI
     * 1. Print
     * System.out.println(name + ": " + i);
     *
     * 2. Delay
     * Thread.sleep(200);
     * biar keliatan prosesnya
     *
     * 3. MASUK BLOK KRUSIAL
     * synchronized(this)
     *
     * Kenapa?
     * karena pakai wait() nanti
     * wait() HARUS dalam synchronized
     *
     * 4. CEK FLAG
     * while(suspendFlag)
     * Kalau true:
     * berarti harus pause
     *
     * 5. PAUSE
     * wait();
     *
     * Ini penting:
     * thread tidur
     * lepas lock
     * Jadi alurnya:
     * loop →
     * cek suspendFlag →
     * kalau true → tidur →
     * kalau false → lanjut
     *
     * METHOD CONTROL
     * mysuspend()
     * suspendFlag = true;
     *
     * Artinya:
     * "Thread, nanti kalau cek, lu harus berhenti ya"
     *
     * Dia TIDAK langsung berhenti!
     * Tapi berhenti di loop berikutnya
     *
     * myresume()
     * suspendFlag = false;
     * notify();
     *
     * Artinya:
     * ubah flag jadi jalan lagi
     * bangunin thread
     */

    /**
     * SIMULASI REAL (STEP BY STEP)
     *
     * Awal
     * Main:
     * NewThread ob1 = new NewThread("One");
     * NewThread ob2 = new NewThread("Two");
     *
     * 2 thread jalan bersamaan
     *
     * Kedua thread mulai:
     * One: 15
     * Two: 15
     * One: 14
     * Two: 14
     * ...
     *
     * STEP: Suspend Thread One
     * ob1.mysuspend();
     *
     * Yang terjadi:
     * suspendFlag = true
     * Thread BELUM berhenti sekarang
     * Dia lanjut sampai:
     *
     * while(suspendFlag)
     * Masuk wait()
     * Thread tidur total
     *
     * Jadi:
     * One → berhenti
     * Two → lanjut sendiri
     *
     * STEP: Resume Thread One
     * ob1.myresume();
     *
     * Yang terjadi:
     *
     * suspendFlag = false
     * notify() → bangunin thread
     * Thread lanjut dari wait()
     *
     * Sama untuk thread Two
     *
     * PART 4 — INTUISI DALAM
     * Ini BEDA BANGET sama suspend() lama
     * Cara lama	                Cara sekarang
     * Thread dipaksa berhenti	    Thread berhenti sendiri
     * Bahaya	                    Aman
     * Tidak terkontrol	            Terstruktur
     *
     * Konsep penting:
     * Thread harus cooperative
     *
     * Bukan:
     * "Eh berhenti sekarang!"
     *
     * Tapi:
     * "Kalau lu lihat flag ini, berhenti ya"
     *
     * DETAIL KRUSIAL (LEVEL LANJUT)
     * 1. Kenapa while, bukan if?
     * while(suspendFlag)
     *
     * karena:
     * bisa ada spurious wakeup
     * harus cek ulang
     *
     * 2. Kenapa notify() cukup?
     * Karena:
     * cuma 1 thread yang nunggu
     *
     * 3. Kenapa synchronized(this)?
     * Karena:
     * wait() dan notify() kerja di object monitor
     *
     * RINGKASAN SUPER DALAM
     * suspend()/resume()/stop() → deprecated (bahaya)
     * pakai flag + wait/notify
     * thread:
     * cek kondisi sendiri
     * pause dengan wait()
     * lanjut dengan notify()
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
