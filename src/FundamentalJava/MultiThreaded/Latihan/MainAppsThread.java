package FundamentalJava.MultiThreaded.Latihan;

class Counter {
    int count = 0;

    // dengan synchronized hasil ini tetap benar 2000
    synchronized void increment() {
        int temp = count; // ambil nilai
        try {
            Thread.sleep(1); // paksa delay
        } catch (InterruptedException e) {
        }
        count = temp + 1; // simpan lagi
    }
}

class MyThread extends Thread {
    Counter counter;

    MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        // tiap thread nambah 1000x
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class MainAppsThread {
    public static void main(String[] args) throws Exception {

        Counter counter = new Counter();

        MyThread thread1 = new MyThread(counter);
        MyThread thread2 = new MyThread(counter);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Hasil: " + counter.count);

    }
}
