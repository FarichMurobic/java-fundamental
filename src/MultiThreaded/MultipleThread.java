package MultiThreaded;

    /**
     * Creating Multiple Threads (Membuat Banyak Thread)
     *
     * Sejauh ini kamu cuma pakai:
     * 1 main thread
     * 1 child thread
     *
     * Tapi sebenarnya:
     * Program bisa membuat sebanyak mungkin thread
     *
     * Ringkasan DALAM
     *
     * 1 object = 1 thread
     * banyak object = banyak thread
     * semua thread = share CPU
     * output = tidak bisa diprediksi
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
