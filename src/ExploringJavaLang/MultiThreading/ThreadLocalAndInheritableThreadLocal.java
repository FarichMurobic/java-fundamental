package ExploringJavaLang.MultiThreading;

/**
 * ThreadLocal dan InheritableThreadLocal
 *
 * Java menyediakan dua class tambahan terkait thread di package java.lang:
 *
 * ThreadLocal
 * Digunakan untuk membuat variabel khusus untuk thread.
 * Setiap thread akan memiliki salinan (copy) sendiri dari variabel tersebut.
 * InheritableThreadLocal
 * Digunakan untuk membuat variabel thread local yang bisa diwariskan ke thread anak (child thread).
 *
 * Masalah yang ingin diselesaikan
 * Bayangin lo punya:
 *
 * int data;
 *
 * Kalau dipakai banyak thread:
 * Semua thread pakai variabel yang sama
 *
 * Bahaya:
 * Data ketimpa
 * Race condition
 * Bug random
 *
 * Solusi: ThreadLocal
 *
 * ThreadLocal =
 * Setiap thread punya variabel sendiri-sendiri
 *
 * Analoginya:
 * Thread biasa:
 * Semua orang nulis di 1 buku 
 *
 * ThreadLocal:
 * Setiap orang punya buku sendiri 
 *
 * Cara kerja ThreadLocal
 * Thread A → punya nilai sendiri
 * Thread B → punya nilai sendiri
 * Tidak saling ganggu
 *
 * --------------------------------
 *
 * InheritableThreadLocal
 * Bedanya apa?
 *
 * ThreadLocal:
 * Tidak diwariskan ke thread anak
 *
 * InheritableThreadLocal:
 * Bisa diwariskan ke child thread
 *
 * Analoginya
 * ThreadLocal:
 * Anak tidak tahu data orang tua 
 *
 * InheritableThreadLocal:
 * Anak mewarisi data orang tua 
 *
 * KAPAN DIPAKAI DI DUNIA NYATA?
 * ThreadLocal sering dipakai di:
 * Web request (user session)
 * Database connection per thread
 * Logging context
 * Security context
 *
 * Contoh real di backend:
 *
 * Misalnya:
 * User login
 * Simpan user di ThreadLocal
 *
 * Semua method dalam request bisa akses user itu
 *
 * PERINGATAN PENTING
 * ThreadLocal itu powerful tapi berbahaya kalau salah pakai
 *
 * Masalah umum:
 * Memory leak
 * Data nyangkut di thread pool
 *
 * Kenapa bisa bahaya?
 *
 * Karena di server:
 * Thread itu dipakai ulang (thread pool)
 *
 * Jadi:
 * Data lama bisa kebawa ke request baru
 *
 * SOLUSI WAJIB:
 * Selalu:
 *
 * try {
 *     threadLocal.set(data);
 * } finally {
 *     threadLocal.remove(); // WAJIB!
 * }
 *
 * KESIMPULAN (CHEAT SHEET)
 * Inti:
 * ThreadLocal → variabel khusus tiap thread
 * InheritableThreadLocal → bisa diwariskan ke child thread
 *
 * Perbedaan utama:
 * Fitur	        ThreadLocal	        InheritableThreadLocal
 * Scope	        Thread sendiri	    Thread + child
 * Warisan	        tidak	            ya
 *
 * Wajib ingat:
 * Selalu remove() setelah pakai
 * Hati-hati di thread pool
 *
 * Insight backend
 * ThreadLocal itu:
 * Fondasi dari:
 *
 * Spring Security Context
 * Request Context
 * Logging MDC
 */

public class ThreadLocalAndInheritableThreadLocal {

    // Contoh penggunaan ThreadLocal
    // Membuat ThreadLocal variable
    // Setiap thread punya copy sendiri
    static ThreadLocal<Integer> threadLocalValue = new ThreadLocal<>();

    // Contoh InheritableThreadLocal
    // Membuat InheritableThreadLocal
    static InheritableThreadLocal<String> inheritableThreadLocalValue = new InheritableThreadLocal<>();


    public static void main(String[] args) {
        // Thread pertama
        Thread thread1 = new Thread(() -> {
            // Set nilai untuk thread ini
            threadLocalValue.set(100);
            // Ambil nilai (khusus thread ini)
            System.out.println("Thread 1: " + threadLocalValue.get());
        });
        // Thread kedua
        Thread thread2 = new Thread(() -> {
            // Set nilai berbeda
            threadLocalValue.set(200);
            // Ambil nilai (tidak bentrok dengan t1)
            System.out.println("Thread 2: " + threadLocalValue.get());
        });

        thread1.start();
        thread2.start();

        /**
         * utput (konsepnya):
         * Thread 1: 100
         * Thread 2: 200
         *
         * Walaupun variabel sama, nilainya beda
         * Karena tiap thread punya copy sendiri
         *
         * HAL PENTING (SERING JADI BUG DI BACKEND)
         * Kalau pakai ThreadLocal:
         * threadLocalValue.set(value);
         *
         * WAJIB dihapus setelah selesai:
         * threadLocalValue.remove();
         *
         * Kalau tidak:
         * Bisa memory leak (parah di server)
         */

        System.out.println();

        // Set nilai di thread utama
        inheritableThreadLocalValue.set("Data dari parent");

        // Membuat child thread
        Thread child = new Thread(() -> {

            // Child bisa akses data parent
            System.out.println("Child Thread: " + inheritableThreadLocalValue.get());
        });

        child.start();

        /**
         * Output:
         * Child thread: Data dari parent
         */
    }
}

