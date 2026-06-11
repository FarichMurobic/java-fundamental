package MultiThreaded.Latihan;

class MyThread1 extends Thread {

    @Override
    public void run() {
            for (int i = 5; i > 0; i--) {
                System.out.println("Thread 1-" + i);
            }
        System.out.println("Berjalan...");
    }
}

public class Mainapps {
    public static void main(String[] args) {
        
        // System.out.println(Thread.activeCount());
        // Thread.currentThread().setName("Thread Main");
        // System.out.println(Thread.currentThread().getName());
        // Thread.currentThread().setPriority(10);
        // System.out.println(Thread.currentThread().getPriority());
        // System.out.println(Thread.currentThread().isAlive());

        //       try {
        //           for (int i = 3; i > 0; i--) {
        //               System.out.println(i);
        //               Thread.sleep(1000);
        //           }
        //       } catch (InterruptedException e) {
        //       }
        //        System.out.println("Selesai...");

        // MyThread thread = new MyThread();
        // thread.start();
        // MyThread thread1 = new MyThread();
        // thread1.start();
        // System.out.println(thread.isAlive());
        // thread.setName("Thread 1");
        // System.out.println(thread.getName());

        // System.out.println(Thread.activeCount());
        // System.out.println(Thread.currentThread().getName());

        // System.out.println(Thread.activeCount());
        // Thread.currentThread().setName("Thread Main");
        // System.out.println(Thread.currentThread().getName());
        // Thread.currentThread().setPriority(10);
        // System.out.println(Thread.currentThread().getPriority());
        // System.out.println(Thread.currentThread().isAlive());

        //       try {
        //           for (int i = 3; i > 0; i--) {
        //               System.out.println(i);
        //               Thread.sleep(1000);
        //           }
        //       } catch (InterruptedException e) {
        //       }
        //        System.out.println("Selesai...");

    }
}
