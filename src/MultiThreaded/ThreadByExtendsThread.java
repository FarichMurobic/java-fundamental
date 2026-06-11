package MultiThreaded;

/**
     * Extending Thread (Mewarisi Thread)
     *
     * Cara kedua membuat thread adalah:
     * membuat class baru yang extends Thread
     * lalu membuat object dari class tersebut
     *
     * Class ini harus:
     * override method run() → sebagai titik awal thread
     * memanggil start() → untuk mulai eksekusi
     *
     * Di contoh ini:
     * NewThread sekarang bukan Runnable lagi
     * tapi langsung jadi Thread itu sendiri
     *
     * ---------------------------------
     * 
     * Perbedaan Konsep (INI INTI BANGET)
     * 
     * Sebelumnya (Runnable)
     * class NewThread implements Runnable
     *
     * Lu bikin pekerjaan
     * lalu kasih ke Thread
     *
     * Sekarang (Thread)
     * class NewThread extends Thread
     *
     * Lu bikin thread itu sendiri
     *
     * Perbedaan KRITIS (Runnable vs Thread)
     * Aspek	            Runnable	                Extends Thread
     * Desain	            Pisah tugas & thread	    Jadi satu
     * Fleksibilitas	    Tinggi 	                    Rendah 
     * Inheritance	        Bisa extend class lain	    Gak bisa 
     * Best Practice	    disarankan	                jarang dipakai
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
