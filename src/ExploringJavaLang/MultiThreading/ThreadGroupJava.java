package ExploringJavaLang.MultiThreading;

/**
 * ThreadGroup
 *
 * Class ThreadGroup digunakan untuk membuat kelompok (group) dari thread.
 *
 * Constructor yang tersedia:
 * ThreadGroup(String groupName)
 * ThreadGroup(ThreadGroup parentOb, String groupName)
 *
 * Penjelasan:
 * groupName → nama grup thread
 * Constructor pertama → parent = thread saat ini
 * Constructor kedua → parent ditentukan oleh parentOb
 *
 * Penjelasan umum
 *
 * ThreadGroup menyediakan cara mudah untuk:
 * Mengelola beberapa thread sekaligus sebagai satu unit
 *
 * Contoh use case:
 * Thread untuk print
 * Thread untuk display
 * Thread untuk save file
 *
 * Kalau proses print dibatalkan:
 * Semua thread terkait print bisa dihentikan sekaligus
 *
 * TABEL METHOD THREADGROUP (LENGKAP)
 * Bagian 1
 * Method	                                            Deskripsi
 * int activeCount()	                                Mengembalikan perkiraan jumlah thread aktif dalam group (termasuk sub-group)
 * int activeGroupCount()	                            Mengembalikan jumlah group aktif (termasuk subgroup)
 * checkAccess()	                                    Mengecek apakah thread punya akses ke group
 * destroy()	                                        Menghapus thread group dan child group
 *
 * destroy() → berbahaya kalau masih ada thread aktif
 *
 * Bagian 2
 * Method	                                            Deskripsi
 * enumerate(Thread group[])	                        Memasukkan thread aktif ke array
 * enumerate(Thread group[], boolean all)	            Jika all=true, termasuk sub-group
 * enumerate(ThreadGroup group[])	                    Memasukkan subgroup ke array
 * enumerate(ThreadGroup group[], boolean all)	        Termasuk subgroup lebih dalam
 *
 * Bagian 3
 * Method	                                            Deskripsi
 * getMaxPriority()	                                    Prioritas maksimal group
 * getName()	                                        Nama group
 * getParent()	                                        Parent group
 * interrupt()	                                        Meng-interrupt semua thread dalam group
 * isDaemon()	                                        Apakah group daemon
 * isDestroyed()	                                    Apakah sudah dihancurkan
 * list()	                                            Menampilkan info group
 * parentOf(ThreadGroup group)	                        Cek apakah parent dari group lain
 * setDaemon(boolean)	                                Set daemon
 * setMaxPriority(int)	                                Set prioritas maksimum
 * toString()	                                        Representasi string
 * uncaughtException(Thread t, Throwable e)	            Handle error yang tidak tertangani
 *
 * Inti konsep ThreadGroup
 * ThreadGroup = wadah untuk kumpulan thread
 *
 * Analoginya:
 * Thread = karyawan
 * ThreadGroup = tim/divisi
 *
 * Kenapa ini penting?
 *
 * Bayangin:
 * Lu punya 10 thread
 * Semua buat "download file"
 *
 * Kalau user cancel:
 * Tanpa group → stop satu-satu
 * Dengan group → stop semua sekaligus
 *
 * Kenyataan di dunia modern
 *
 * Jujur bro:
 * ThreadGroup jarang dipakai di real project modern
 * Diganti sama:
 * ExecutorService
 * ThreadPool
 *
 * Tapi:
 * Konsepnya tetap penting buat ngerti concurrency
 *
 * KESIMPULAN
 * Inti:
 * ThreadGroup = kumpulan thread
 * Bisa kontrol banyak thread sekaligus
 * Cocok untuk sistem kompleks
 *
 * Realita:
 * Jarang dipakai di project modern
 * Diganti:
 * ThreadPool
 * ExecutorService
 *
 * Mindset Backend
 *
 * ThreadGroup ini konsep lama dari:
 * "mengelola banyak worker"
 *
 * Sekarang diganti dengan:
 * Thread Pool (lebih scalable & aman)
 */

// Demonstrasi penggunaan ThreadGroup
// Class thread custom
class NewThread extends Thread {

    // Flag untuk pause/resume thread
    boolean suspendFlag;

    // Constructor
    NewThread(String threadname, ThreadGroup tgOb) {

        // Memanggil constructor Thread dengan group dan nama
        super(tgOb, threadname);

        // Menampilkan info thread
        System.out.println("New thread: " + this);

        suspendFlag = false;

        // Langsung menjalankan thread
        start();
    }

    // Method utama thread (entry point)
    public void run() {

        try {
            // Loop 5 kali
            for (int i = 5; i > 0; i--) {

                System.out.println(getName() + ": " + i);

                // Delay 1 detik
                Thread.sleep(1000);

                // Sinkronisasi untuk pause/resume
                synchronized (this) {

                    // Jika suspendFlag true → thread pause
                    while (suspendFlag) {
                        wait(); // thread menunggu
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Exception in " + getName());
        }

        System.out.println(getName() + " exiting.");
    }

    // Method untuk pause thread
    synchronized void mysuspend() {
        suspendFlag = true;
    }

    // Method untuk resume thread
    synchronized void myresume() {
        suspendFlag = false;
        notify(); // membangunkan thread
    }
}

public class ThreadGroupJava {
    public static void main(String[] args) {

        // Membuat dua group
        ThreadGroup groupA = new ThreadGroup("Group A");
        ThreadGroup groupB = new ThreadGroup("Group B");

        // Membuat thread dalam group A
        NewThread ob1 = new NewThread("One", groupA);
        NewThread ob2 = new NewThread("Two", groupA);

        // Membuat thread dalam group B
        NewThread ob3 = new NewThread("Three", groupB);
        NewThread ob4 = new NewThread("Four", groupB);

        // Menampilkan isi group
        System.out.println("\nHere is output from list():");
        groupA.list();
        groupB.list();

        System.out.println();

        // Suspend semua thread di group A
        System.out.println("Suspending Group A");

        // Ambil semua thread dalam group A
        Thread tga[] = new Thread[groupA.activeCount()];
        groupA.enumerate(tga);

        // Pause semua thread di group A
        for (int i = 0; i < tga.length; i++) {
            ((NewThread) tga[i]).mysuspend();
        }

        try {
            // Tunggu 4 detik
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        // Resume semua thread di group A
        System.out.println("Resuming Group A");

        for (int i = 0; i < tga.length; i++) {
            ((NewThread) tga[i]).myresume();
        }

        // Tunggu semua thread selesai
        try {
            System.out.println("Waiting for threads to finish.");

            ob1.join();
            ob2.join();
            ob3.join();
            ob4.join();

        } catch (Exception e) {
            System.out.println("Exception in Main thread");
        }

        System.out.println("Main thread exiting.");

        /**
         * PENJELASAN KODE
         * 
         * Flow penting
         * 
         * Buat 2 group:
         * Group A
         * Group B
         * Setiap group punya 2 thread
         * Pause hanya Group A
         *
         * Thread di Group B tetap jalan
         *
         * Setelah 4 detik:
         * Resume Group A
         *
         * Diganti dengan:
         * wait()
         * notify()
         * flag boolean
         *
         * Ini cara modern & aman
         */

    }
}
