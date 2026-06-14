package FundamentalJava.String.StringBuilder;

public class ThreadStringBuffer {
    public static void main(String[] args) throws InterruptedException {

        // StringBuffer (AMAN)
        // StringBuffer THREAD-SAFE
        StringBuffer stringBuffer = new StringBuffer();

        // Thread 1
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                stringBuffer.append("A");
            }
            System.out.println("Thread 1 selesai.");
        });

        // Thread 2
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                stringBuffer.append("B");
            }
            System.out.println("Thread 2 selesai.");
        });

        // Jalankan thread
        thread1.start();
        thread2.start();

        // Tunggu selesai
        thread1.join();
        thread2.join();

        // SELALU benar
        System.out.println("Length: " + stringBuffer.length()); // 2000
        System.out.println(stringBuffer);

        /**
         * Hasil:
         * Length: 2000
         *
         * karena:
         * tiap operasi di-lock
         * tidak ada tabrakan data
         */

        /**
         * Kenapa StringBuffer aman?
         *
         * Karena method-nya:
         * public synchronized StringBuffer append(String str)
         *
         * artinya:
         * hanya 1 thread boleh akses dalam satu waktu
         *
         * Pakai StringBuffer
         * multi-thread
         * data diakses bersama
         * butuh safety
         *
         * Insight penting (level expert)
         * Java modern jarang pakai StringBuffer
         * Lebih sering:
         * StringBuilder + manual synchronization (kalau perlu)
         *
         * INTI PALING DALAM:
         * Bedanya cuma synchronized vs tidak, tapi efeknya besar ke performa & keamanan
         */

    }
}
