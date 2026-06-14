package FundamentalJava.MultiThreaded.Latihan;

class Worker implements Runnable {

    Thread other;

    Worker(Thread other) {
        this.other = other;
    }

    @Override
    public void run() {
        try {
            System.out.println(
                    Thread.currentThread().getName() + " mulai dan akan nunggu " + other.getName());
            other.join();
            System.out.println(Thread.currentThread() + " lanjut setelah " + other.getName() + " selesai.");
        } catch (InterruptedException e) {
            System.out.println("Terjadi Interrupt");
        }
    }
}

public class MainApps3 {
    public static void main(String[] args) {

        // thread pertama
        Thread t1 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " mulai kerja");
                for (int i = 1; i <= 3; i++) {
                    System.out.println(Thread.currentThread().getName() + " proses " + i);
                    Thread.sleep(1000);
                }
                System.out.println(Thread.currentThread().getName() + " selesai.");
            } catch (InterruptedException e) {
                System.out.println("t1 Interrupted.");
            }
        }, "Thread-1");

        // thread kedua t2 yang nunggu t1
        Thread t2 = new Thread(new Worker(t1), "Thread-2");

        // start
        t1.start();
        t2.start();

    }
}
