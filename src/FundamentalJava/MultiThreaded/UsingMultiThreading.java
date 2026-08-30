package FundamentalJava.MultiThreaded;

/**
 * ------------------------------------------------------------------------
 * USING MULTITHREADING
 * ------------------------------------------------------------------------
 * 
 * Kunci menggunakan multithreading secara efektif adalah:
 * Berpikir secara paralel (concurrent), bukan berurutan (serial)..
 * 
 * ------------------------------------------------------------------------
 * SERIAL vs CONCURRENT
 * ------------------------------------------------------------------------
 * 
 * Cara SERIAL (biasa):
 * 
 * task1();
 * task2();
 * 
 * Urutan eksekusi:
 * task1 → selesai → task2
 * 
 * Total waktu = waktu task1 + waktu task2
 * 
 * Cara CONCURRENT:
 * 
 * new Thread(task1).start();
 * new Thread(task2).start();
 * 
 * Urutan eksekusi:
 * task1 dan task2 berjalan bersamaan
 * 
 * Total waktu ≈ max(waktu task1, waktu task2)
 * 
 * ------------------------------------------------------------------------
 * INTUISI PALING PENTING
 * ------------------------------------------------------------------------
 * 
 * Multithreading BUKAN:
 * "Membuat semua menjadi lebih cepat"
 * 
 * TAPI:
 * "Menjalankan bagian-bagian yang bisa berjalan bersamaan"
 * 
 * ------------------------------------------------------------------------
 * CONTOH NYATA (BIAR KEBAYANG)
 * ------------------------------------------------------------------------
 * 
 * Kasus: Download File + Memutar Musik
 * 
 * Tanpa thread:
 * Download selesai → baru bisa play musik
 * 
 * Dengan thread:
 * Download berjalan di background
 * Musik berjalan di foreground
 * 
 * Hasil: Pengalaman pengguna lebih smooth
 * 
 * ------------------------------------------------------------------------
 * BAHAYA TERLALU BANYAK THREAD
 * ------------------------------------------------------------------------
 * 
 * Context Switching
 * 
 * CPU hanya bisa fokus pada satu thread per core dalam satu waktu.
 * 
 * Jika terlalu banyak thread:
 * Thread A → Thread B → Thread C → Thread D → ...
 * 
 * CPU harus melakukan:
 * - Menyimpan state thread saat ini
 * - Memuat state thread berikutnya
 * 
 * Proses ini memakan waktu dan sumber daya (overhead).
 * 
 * Hubungan jumlah thread dengan performa:
 * 
 * Jumlah Thread | Hasil
 * ----------------------|-----------------------------------------------
 * Sedikit dan tepat | Cepat dan efisien
 * Terlalu banyak | Lambat karena overhead context switching
 * 
 * ------------------------------------------------------------------------
 * KAPAN HARUS MENGGUNAKAN MULTITHREADING?
 * ------------------------------------------------------------------------
 * 
 * COCOK digunakan untuk:
 * 
 * 1. Operasi I/O (menunggu)
 * - Download file
 * - Query database
 * - Baca/tulis file
 * - Network request
 * 
 * Karena:
 * CPU bisa mengerjakan hal lain sambil menunggu I/O selesai.
 * 
 * 2. Task independen
 * - Render UI
 * - Background process
 * - Logging
 * - Notifikasi
 * 
 * 3. Multi-core processing
 * - Memanfaatkan CPU dengan banyak core
 * - Komputasi berat yang bisa dipecah
 * 
 * ------------------------------------------------------------------------
 * INSIGHT DALAM (LEVEL LANJUT)
 * ------------------------------------------------------------------------
 * 
 * Multithreading adalah trade-off:
 * 
 * Keuntungan | Kerugian
 * -------------------------------|-----------------------------------------
 * Eksekusi lebih cepat | Kode lebih kompleks
 * Aplikasi lebih responsif | Rawan bug (race condition, deadlock)
 * Memanfaatkan CPU secara maksimal | Overhead manajemen thread
 * 
 * ------------------------------------------------------------------------
 * RULE OF THUMB
 * ------------------------------------------------------------------------
 * 
 * Jangan menggunakan thread jika:
 * "Kamu tidak benar-benar membutuhkannya"
 * 
 * Multithreading menambah kompleksitas secara signifikan.
 * Gunakan hanya jika ada benefit nyata.
 * 
 * ------------------------------------------------------------------------
 * CATATAN PENTING UNTUK APLIKASI BERAT
 * ------------------------------------------------------------------------
 * 
 * Jika aplikasi bersifat compute-intensive (banyak perhitungan berat):
 * 
 * Jangan gunakan Thread manual.
 * 
 * Gunakan:
 * - Fork/Join Framework (Java 7+)
 * - Parallel Streams (Java 8+)
 * - ExecutorService dengan Thread Pool
 * 
 * Framework ini mengelola thread secara otomatis dan lebih efisien.
 * 
 * ------------------------------------------------------------------------
 * RINGKASAN SUPER PADAT
 * ------------------------------------------------------------------------
 * 
 * 1. Berpikir concurrent, bukan serial
 * 2. Thread cocok untuk task yang independen
 * 3. Terlalu banyak thread = performa turun
 * 4. Gunakan multithreading dengan bijak
 * 5. Untuk komputasi berat → gunakan Fork/Join Framework
 * 
 * ------------------------------------------------------------------------
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
            } catch (Exception e) {
            }
        }
    }
}
