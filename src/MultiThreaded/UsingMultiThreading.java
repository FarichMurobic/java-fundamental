package MultiThreaded;

    /**
     * Using Multithreading
     *
     * Kunci pakai multithreading secara efektif:
     * berpikir secara paralel (concurrent), bukan berurutan (serial)
     *
     * Contoh:
     * Kalau program punya 2 bagian yang bisa jalan bareng:
     * jadikan thread terpisah
     *
     * Tapi hati-hati:
     * Terlalu banyak thread → performa malah turun
     * Karena ada context switching (ganti-ganti thread)
     *
     * Catatan penting:
     * Kalau mau program berat (compute-intensive):
     * pakai Fork/Join Framework (Java modern)
     *
     * -------------------------------------
     * 
     * PENJELASAN DALAM (INI YANG PENTING BANGET)
     * 
     * 1. SERIAL vs CONCURRENT
     * Cara SERIAL (biasa)
     * task1();
     * task2();
     *
     * Urutan:
     * task1 → selesai → task2
     * Lama
     *
     * Cara CONCURRENT
     * new Thread(task1).start();
     * new Thread(task2).start();
     *
     * Urutan:
     * task1 & task2 jalan bareng
     * Lebih cepat (kalau cocok)
     *
     * INTUISI PALING PENTING
     * Multithreading bukan:
     * “biar semua jadi cepat”
     *
     * Tapi:
     * “jalankan yang bisa barengan”
     *
     * CONTOH NYATA (BIAR KEBAYANG)
     * Kasus: Download + Play Musik
     * Tanpa thread
     * Download selesai → baru play
     *
     * Dengan thread
     * Download jalan
     * Play jalan
     *
     * Lebih smooth
     *
     * BAHAYA TERLALU BANYAK THREAD
     * Context Switching
     *
     * CPU itu cuma bisa fokus 1 thread per core.
     *
     * Kalau banyak thread:
     * Thread A → B → C → D → ...
     *
     * CPU harus:
     * simpan state
     * load state baru
     *
     * Ini mahal (overhead)
     *
     * Jadi:
     * Thread	            Hasil
     * sedikit & tepat	    cepat
     * terlalu banyak	    lambat
     *
     * KAPAN HARUS PAKAI MULTITHREADING?
     * Cocok:
     * 1. I/O (nunggu)
     * download
     * database
     * file
     *
     * karena:
     * CPU bisa kerja lain
     *
     * 2. Task independen
     * render UI
     * background process
     *
     * 3. Multi-core processing
     * CPU banyak core → manfaatin
     *
     * INSIGHT DALAM (LEVEL LANJUT)
     * Multithreading itu trade-off
     * Untung	            Rugi
     * lebih cepat	        lebih kompleks
     * responsive	        rawan bug
     * manfaatin CPU	    overhead
     *
     * Rule of thumb:
     * Jangan pakai thread kalau:
     * “lu nggak butuh”
     *
     * RINGKASAN SUPER PADAT
     * Berpikir concurrent, bukan serial
     * Thread cocok untuk task independen
     * Terlalu banyak thread = performa turun
     * Gunakan bijak
     * Untuk heavy compute → Fork/Join
     */

// Contoh Multithread
class MyTask implements Runnable {
    String name;

    MyTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class UsingMultiThreading {
    public static void main(String[] args) {
        // contoh kode serial (synchronous)
        task("A");
        task("B");

        /**
         * 0UTPUT
         * A: 1
         * A: 2
         * A: 3
         * A: 4
         * A: 5
         * B: 1
         * B: 2
         * B: 3
         * B: 4
         * B: 5
         *
         * B nunggu A selesai.
         * A selesai dulu → baru B
         */

        System.out.println();

        // contoh dengan multithread
        Thread t1 = new Thread(new MyTask("A"));
        Thread t2 = new Thread(new MyTask("B"));

        t1.start();
        t2.start();

        /**
         * Output
         * B: 1
         * A: 1
         * B: 2
         * A: 2
         * B: 3
         * A: 3
         * A: 4
         * B: 4
         * A: 5
         * B: 5
         *
         * jalan bergantian
         */
    }

    // contoh tanpa thread
    static void task(String name) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}
