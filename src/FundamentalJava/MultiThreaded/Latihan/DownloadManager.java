package FundamentalJava.MultiThreaded.Latihan;

class DownlaodTask implements Runnable {

    String filname;
    Thread thread;

    DownlaodTask(String filname) {
        this.filname = filname;
        thread = new Thread(this, filname);
        thread.start();
    }

    @Override
    public void run() {
        try {
            System.out.println(
                    Thread.currentThread().getName() + " mulai download " + filname);
            for (int i = 1; i <= 5; i++) {
                System.out.println(
                        Thread.currentThread().getName() + " download " + filname + " " + (i * 20));
                Thread.sleep(500);
            }
            System.out.println(
                    Thread.currentThread().getName() + " selesai download " + filname);
        } catch (InterruptedException e) {
            System.out.println(filname + " gagal downlaod...");
        }
    }
}

public class DownloadManager {
    public static void main(String[] args) {

        // bikin 3 download sekaligus
        DownlaodTask d1 = new DownlaodTask("File-A");
        DownlaodTask d2 = new DownlaodTask("File-B");
        DownlaodTask d3 = new DownlaodTask("File-C");

        try {
            System.out.println("Menunggu semua download selesai...\n");

            d1.thread.join();
            d2.thread.join();
            d3.thread.join();

        } catch (InterruptedException e) {
            System.out.println("Main thread terganggu...");
        }
        System.out.println("\nSemua download selesai!.");
    }
}
