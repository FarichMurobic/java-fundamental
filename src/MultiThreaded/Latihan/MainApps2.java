package MultiThreaded.Latihan;

// contoh dengan sychronized
class CallMe {
    synchronized void call(String msg) {
        System.out.print("[" + msg);
        try {
            // pause 1 detik
            // ini bikin thread lain bisa masuk ke methode ini
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted.");
        }
        System.out.println("]");
    }
}

// class yang jadi thread
class Caller implements Runnable {
    String msg;
    CallMe target;
    Thread thread;

    public Caller(CallMe target, String msg) {
        this.target = target;
        this.msg = msg;

        // buat thread baru
        thread = new Thread(this);
        thread.start(); // jalanin
    }

    @Override
    public void run() {
        // semua thread panggil objek yang sama
        target.call(msg);
    }
}

public class MainApps2 {
    public static void main(String[] args) {

        // stu object shared
        CallMe target = new CallMe();

        // tiga thread pakai object yang sama
        Caller t1 = new Caller(target, "Hello");
        Caller t2 = new Caller(target, "Synchronized");
        Caller t3 = new Caller(target, "World");

        // tunggu semua thread selesai
        try {
            t1.thread.join();
            t2.thread.join();
            t3.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Main interrupted...");
        }


    }
}
