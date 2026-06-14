package FundamentalJava.MultiThreaded.Latihan;

class ThreadBaru implements Runnable {
    
    String namaThread;
    Thread thread;
    boolean aksesKontrol;

    ThreadBaru(String namaThread) {
        this.namaThread = namaThread;
        thread = new Thread(this, namaThread);

        System.out.println("Thread baru: " + thread);
        aksesKontrol = false; // awalnya jalan
        thread.start();
    }

    // methode utama thread
    @Override
    public void run() {
        try {
            for (int i = 10; i > 0; i--) {
                System.out.println(namaThread + ": " + i);
                Thread.sleep(200); // delay
                synchronized (this) {
                    while (aksesKontrol) {
                        wait(); // thread tidur disini
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(namaThread + " keluar...");
    }

    // methode untuk suspend thread
    synchronized void suspendThread() {
        aksesKontrol = true;
    }

    // methode untuk resume thread
    synchronized void resumeThread() {
        aksesKontrol = false;
        notify();
    }
}

public class ThreadBaruMainApps {
    public static void main(String[] args) {

        ThreadBaru threadBaru1 = new ThreadBaru("Thread Satu");
        ThreadBaru threadBaru2 = new ThreadBaru("Thread Dua");

        try {
            Thread.sleep(1000);
            threadBaru1.suspendThread();
            System.out.println("Thread satu suspend...");
            Thread.sleep(1000);
            threadBaru1.resumeThread();
            System.out.println("Thread satu resuming...");

            threadBaru2.suspendThread();
            System.out.println("Thread Dua suspend...");
            Thread.sleep(1000);
            threadBaru2.resumeThread();
            System.out.println("Thread Dua resuming...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Menunggu Thread selesai...");
            threadBaru1.thread.join();
            threadBaru2.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main Thread keluar...");
    }
}
