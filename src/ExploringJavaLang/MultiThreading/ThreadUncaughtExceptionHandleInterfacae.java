package ExploringJavaLang.MultiThreading;

/**
 * The Thread.UncaughtExceptionHandler Interface
 *
 * Interface Thread.UncaughtExceptionHandler digunakan oleh class yang ingin menangani exception yang tidak tertangkap
 * (uncaught exception).
 *
 * Interface ini juga diimplementasikan oleh ThreadGroup.
 *
 * Method utama
 * void uncaughtException(Thread thrd, Throwable exc)
 * Penjelasan:
 * thrd → thread yang menghasilkan error
 * exc → object exception yang terjadi
 *
 * Masalah utama di thread
 *
 * Di main thread:
 * try {
 *     // code
 * } catch (Exception e) {
 *     // aman
 * }
 *
 * Tapi di thread:
 * new Thread(() -> {
 *     int x = 10 / 0;
 * }).start();
 *
 * Kalau tidak ditangkap:
 * error langsung keluar ke console
 * tidak bisa dikontrol
 *
 * Solusi:
 * UncaughtExceptionHandler
 *
 * Inti konsep
 * UncaughtExceptionHandler =
 * “last defense” kalau exception tidak ditangani
 *
 * PRIORITAS HANDLER
 * Urutan:
 * Thread-specific handler
 * ThreadGroup handler
 * Default handler
 *
 * USE CASE DI BACKEND
 * Dipakai untuk:
 * Logging error thread
 * Monitoring system
 * Crash handling
 * Thread pool error tracking
 *
 * Contoh real:
 * Logging ke file
 * Kirim error ke monitoring system
 * Restart thread
 *
 * HAL PENTING
 * Ini bukan pengganti try-catch
 *
 * Gunakan untuk fallback
 * Jangan jadi primary handling
 *
 * Tidak bisa recover logic
 *
 * hanya untuk:
 * log
 * alert
 *
 * CONTOH ADVANCED (LOGGING STYLE)
 * // Simulasi logging
 * class LoggingHandler implements Thread.UncaughtExceptionHandler {
 *
 *     @Override
 *     public void uncaughtException(Thread t, Throwable e) {
 *
 *         System.out.println("[ERROR]");
 *         System.out.println("Thread: " + t.getName());
 *         System.out.println("Message: " + e.getMessage());
 *     }
 * }
 *
 * public class AdvancedHandler {
 *
 *     public static void main(String[] args) {
 *
 *         Thread t = new Thread(() -> {
 *             throw new RuntimeException("Simulasi error");
 *         });
 *
 *         t.setUncaughtExceptionHandler(new LoggingHandler());
 *
 *         t.start();
 *     }
 * }
 *
 * KESIMPULAN
 * Inti:
 * UncaughtExceptionHandler = penangkap error terakhir di thread
 * Method utama:
 * uncaughtException(Thread, Throwable)
 *
 * Fungsi:
 * Logging
 * Monitoring
 * Debugging
 *
 * Insight penting:
 *
 * Ini wajib di sistem multithread
 * Dipakai di backend production
 */

public class ThreadUncaughtExceptionHandleInterfacae {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            // Error tanpa try-catch
            int x = 10 / 0;
        });

        // Set handler
        thread.setUncaughtExceptionHandler((t, exception) -> {
            System.out.println("Thread error: " + thread.getName());
            System.out.println("Exception: " + exception);
        });

        thread.start();

        /**
         * OUTPUT
         * Thread error: Thread-0
         * Exception: java.lang.ArithmeticException: / by zero
         *
         * CARA KERJA
         * Flow:
         * Thread jalan →
         * Error terjadi →
         * Tidak ada try-catch →
         * UncaughtExceptionHandler dipanggil
         */

        // CONTOH GLOBAL HANDLER (REAL BACKEND)
        // Global handler untuk semua thread

        // Set global handler
        Thread.setDefaultUncaughtExceptionHandler((thread1, e) -> {
            System.out.println("Global handler catch:");
            System.out.println(thread1.getName());
            System.out.println(e);
        });

        // Thread tanpa handler khusus
        new Thread(() -> {
            int x = 5 / 0;
        }).start();

    }
}
