package MultiThreaded.Latihan;

class Call {

    void call(String callme) {
        System.out.println(Thread.currentThread().getName());
        System.out.println("[" + callme);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("]");
    }
}

class CallThread implements Runnable {
    String callme;
    Call call;
    Thread thread;

    CallThread(Call call, String callme) {
        this.call = call;
        this.callme = callme;

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        synchronized (call) {
            call.call(callme);
        }
    }

    /**
     * Output tanpa Synchrnize
     * Thread Pertama
     * Thread Kedua
     * [Murobic
     * [Farich
     * Thread Ketiga
     * [Ganteng
     * ]
     * ]
     * ]
     *
     * bisa random (race condition)
     *
     * Output dengan Synchronize
     * Thread Pertama
     * [Farich
     * ]
     * Thread Ketiga
     * [Ganteng
     * ]
     * Thread Kedua
     * [Murobic
     * ]
     */
}

public class MainApps4 {
    public static void main(String[] args) {

        Call call = new Call();

        CallThread callThread = new CallThread(call, "Farich");
        callThread.thread.setName("Thread Pertama");
        CallThread callThread1 = new CallThread(call, "Murobic");
        callThread1.thread.setName("Thread Kedua");
        CallThread callThread2 = new CallThread(call, "Ganteng");
        callThread2.thread.setName("Thread Ketiga");

        try {
            callThread.thread.join();
            callThread1.thread.join();
            callThread2.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted Main...");
        }

    }    
}
