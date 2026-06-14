package FundamentalJava.MultiThreaded.Latihan;

class ImplementsThread implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(Thread.currentThread().getName() + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread Implements selesai...");
    }
}

class ExtendsThread extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(Thread.currentThread().getName() + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " Selesai...");
    }
}

public class MainApps1 {
    public static void main(String[] args) {

        // cara 1 - thread exxtends Thread
        ExtendsThread extends1 = new ExtendsThread();
        extends1.setName("Thread Extends 1: ");
        try {
            extends1.start();
            System.out.println("----- Status Extends 1: " + extends1.isAlive());
            extends1.join();
            System.out.println("----- Status Extends 1: " + extends1.isAlive());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ExtendsThread extends2 = new ExtendsThread();
        extends2.setName("Thread Extends 2: ");
        extends2.start();
        System.out.println("----- Status Exxtends 2: " + extends2.isAlive());

        // cara 2 - thread implements Runnable
        ImplementsThread implementsThread1 = new ImplementsThread();
        Thread implements1 = new Thread(implementsThread1);
        implements1.setName("Thread Implements: ");
        implements1.start();

    }
}
