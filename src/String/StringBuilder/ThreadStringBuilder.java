package String.StringBuilder;

/**
 * Penjelasan 
 * 
 * StringBuffer
 * Aman dipakai banyak thread
 * Ada “kunci” (synchronized)
 * Tapi jadi lebih lambat
 *
 * StringBuilder
 * Tidak aman untuk multi-thread
 * Tidak ada kunci
 * Jadi jauh lebih cepat
 *
 * Kenapa StringBuilder cepat?
 *
 * Karena:
 * // TANPA synchronized
 * public StringBuilder append(String str)
 *
 * tidak ada lock → lebih cepat
 *
 * ------------------------------
 * 
 * Kapan pakai yang mana?
 * 
 * Pakai StringBuilder (99% kasus)
 * aplikasi biasa
 * backend normal
 * tidak multi-thread shared
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

public class ThreadStringBuilder {
    public static void main(String[] args) throws InterruptedException {

        // StringBuilder (BISA ERROR / DATA KACAU)
        // StringBuilder TIDAK thread-safe
        StringBuilder stringBuilder = new StringBuilder();

        // Thread 1
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                stringBuilder.append("A");  // banyak thread akses bersamaan
            }
        });

        // Thread 2
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                stringBuilder.append("B");
            }
        });

        // Jalankan thread
        thread1.start();
        thread2.start();

        // Tunggu selesai
        thread1.join();
        thread2.join();

        // Harusnya panjang = 2000
        System.out.println("Length: " + stringBuilder.length());
        System.out.println(stringBuilder);

        /**
         * Kemungkinan hasil:
         * Panjang tidak 2000
         * Isi bisa kacau
         *
         * karena:
         * race condition
         */

    }
}
