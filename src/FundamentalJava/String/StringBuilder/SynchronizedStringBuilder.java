package FundamentalJava.String.StringBuilder;

import java.util.concurrent.locks.ReentrantLock;

class SafeStringBuilder {

    private StringBuilder sb = new StringBuilder();

    // Method synchronized → otomatis lock object ini
    public synchronized void append(String str) {
        sb.append(str);
    }

    public synchronized int length() {
        return sb.length();
    }

    public synchronized String get() {
        return sb.toString();
    }
}

public class SynchronizedStringBuilder {
    public static void main(String[] args) throws InterruptedException {

        // 1. Pakai synchronized block (PALING UMUM)
        StringBuilder stringBuilder = new StringBuilder();

        // Object sebagai lock
        Object object = new Object();

        // Thread 1
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                // LOCK dimulai
                synchronized (object) {
                    stringBuilder.append("A");
                }
                // LOCK selesai
            }
        });

        // Thread 2
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (object) {
                    stringBuilder.append("B");
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Length: " + stringBuilder.length()); // 2000

        /**
         * Penjelasan
         * synchronized (lock)
         *
         * artinya:
         * cuma 1 thread boleh masuk
         * thread lain harus nunggu
         *
         * Hasil:
         * Length: 2000
         *
         * Aman seperti StringBuffer
         */

        // 2. Pakai synchronized method
        SafeStringBuilder safeStringBuilder = new SafeStringBuilder();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                safeStringBuilder.append("A");
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                safeStringBuilder.append("B");
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Length: " + safeStringBuilder.length()); // 2000

        /**
         * Penjelasan
         * 
         * public synchronized void append(...)
         *
         * artinya:
         * method ini otomatis dikunci
         * hanya 1 thread boleh akses
         */

        // 3. Pakai ReentrantLock (LEVEL LANJUT)
        StringBuilder stringBuilder01 = new StringBuilder();
        ReentrantLock lock = new ReentrantLock();

        Thread th1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                lock.lock(); // kunci
                try {
                    stringBuilder01.append("A");
                } finally {
                    lock.unlock(); // wajib dilepas
                }
            }
        });

        Thread th2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                lock.lock();  // kunci
                try {
                    stringBuilder01.append("B");
                } finally {
                    lock.unlock(); // wajib dilepas
                }
            }
        });

        th1.start();
        th2.start();

        th1.join();
        th2.join();

        System.out.println("Length: " + stringBuilder01.length()); // 2000

        /**
         * Penjelasan
         * 
         * lock.lock() → ambil kunci
         * lock.unlock() → lepas kunci
         *
         * Lebih fleksibel dari synchronized
         */

        /**
         * PERBANDINGAN 3 CARA
         * Cara	                Mudah	     Fleksibel	    Rekomendasi
         * synchronized block	ya	         tidak	        paling umum
         * synchronized method	ya	         tidak          bagus untuk OOP
         * ReentrantLock	    tidak	     ya	            advanced
         *
         * Insight penting (level expert)
         * StringBuffer = auto synchronized
         * StringBuilder = manual control
         *
         * Jadi:
         * StringBuilder + manual lock = StringBuffer versi custom
         *
         * INTI PALING DALAM:
         * Thread-safety bukan soal class, tapi soal cara lo mengontrol akses data
         */

    }
}
