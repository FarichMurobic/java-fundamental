package FundamentalJava.MultiThreaded;

/*
 * ============================================================
 * Interthread Communication (Komunikasi Antar Thread)
 * ============================================================
 *
 * Dalam multithreading, terkadang masalahnya bukan hanya:
 *
 * "Bagaimana mencegah thread mengakses data bersamaan?"
 *
 * Tetapi juga:
 *
 * "Bagaimana membuat thread saling menunggu dan memberi tahu?"
 *
 *
 * synchronized menyelesaikan masalah akses bersamaan..
 *
 * Tetapi synchronized saja belum cukup untuk mengatur urutan
 * kerja antar thread.
 *
 * Untuk itu Java menyediakan:
 *
 * Interthread Communication
 *
 * menggunakan:
 *
 * - wait()
 * - notify()
 * - notifyAll()
 *
 * ------------------------------------------------------------
 * Perbedaan Synchronization dan Communication
 * ------------------------------------------------------------
 *
 * synchronized:
 *
 * Tujuan:
 *
 * Mencegah beberapa thread mengakses resource yang sama secara
 * bersamaan.
 *
 *
 * Contoh masalah:
 *
 * Dua thread mengubah data yang sama.
 *
 *
 * wait()/notify():
 *
 * Tujuan:
 *
 * Membuat thread saling berkoordinasi.
 *
 *
 * Contoh masalah:
 *
 * Consumer harus menunggu Producer menghasilkan data.
 *
 *
 * Kesimpulan:
 *
 * synchronized = keamanan data
 *
 * wait/notify = komunikasi antar thread
 *
 * ------------------------------------------------------------
 * Masalah Polling
 * ------------------------------------------------------------
 *
 * Salah satu cara sederhana untuk menunggu kondisi adalah
 * polling.
 *
 *
 * Contoh:
 *
 * while(dataBelumAda) {
 *
 *     // cek terus
 *
 * }
 *
 *
 * Masalah:
 *
 * - CPU tetap bekerja.
 * - Memboroskan resource.
 * - Tidak efisien.
 *
 *
 * Thread hanya berulang kali bertanya:
 *
 * "Sudah ada data?"
 *
 * "Sudah ada data?"
 *
 * "Sudah ada data?"
 *
 *
 * Padahal tidak ada pekerjaan yang dilakukan.
 *
 * ------------------------------------------------------------
 * Masalah Producer - Consumer
 * ------------------------------------------------------------
 *
 * Contoh klasik komunikasi antar thread:
 *
 *
 * Producer:
 *
 * Bertugas membuat data.
 *
 *
 * Consumer:
 *
 * Bertugas mengambil dan menggunakan data.
 *
 *
 * Masalah:
 *
 * Producer terlalu cepat:
 *
 * Data lama belum diproses, tetapi data baru sudah dibuat.
 *
 *
 * Consumer terlalu cepat:
 *
 * Consumer mencoba mengambil data ketika belum tersedia.
 *
 *
 * Solusi:
 *
 * Producer dan Consumer harus saling memberi sinyal.
 *
 * ------------------------------------------------------------
 * wait(), notify(), notifyAll()
 * ------------------------------------------------------------
 *
 * Java menyediakan mekanisme komunikasi:
 *
 *
 * wait()
 *
 * Fungsi:
 *
 * Membuat thread berhenti sementara dan melepaskan lock yang
 * sedang dimiliki.
 *
 *
 * notify()
 *
 * Fungsi:
 *
 * Memberikan sinyal kepada satu thread yang sedang menunggu pada
 * object monitor yang sama.
 *
 *
 * notifyAll()
 *
 * Fungsi:
 *
 * Memberikan sinyal kepada semua thread yang sedang menunggu pada
 * object monitor yang sama.
 *
 *
 * ------------------------------------------------------------
 * Syarat Menggunakan wait() dan notify()
 * ------------------------------------------------------------
 *
 * wait(), notify(), dan notifyAll()
 *
 * HARUS dipanggil di dalam:
 *
 * synchronized block
 *
 * atau
 *
 * synchronized method
 *
 *
 * Contoh:
 *
 * synchronized(this) {
 *
 *     wait();
 *
 * }
 *
 *
 * Karena method tersebut bekerja menggunakan:
 *
 * intrinsic lock / monitor
 *
 *
 * Jika dipanggil di luar synchronized:
 *
 * IllegalMonitorStateException
 *
 * akan terjadi.
 *
 * ------------------------------------------------------------
 * Perbedaan wait() dan sleep()
 * ------------------------------------------------------------
 *
 * Banyak programmer pemula mengira:
 *
 * wait() = sleep()
 *
 *
 * Padahal berbeda.
 *
 *
 * Thread.sleep()
 *
 * - Menghentikan thread sementara.
 * - Tidak melepaskan lock.
 *
 *
 * Object.wait()
 *
 * - Menghentikan thread sementara.
 * - Melepaskan lock yang dimiliki.
 *
 *
 * Contoh:
 *
 * Thread A:
 *
 * synchronized(object) {
 *
 *     object.wait();
 *
 * }
 *
 *
 * Saat wait():
 *
 * Lock object dilepas.
 *
 *
 * Sehingga thread lain bisa masuk.
 *
 * ------------------------------------------------------------
 * Konsep Guarded Block
 * ------------------------------------------------------------
 *
 * Pola umum penggunaan wait() adalah:
 *
 *
 * while(conditionTidakTerpenuhi) {
 *
 *     wait();
 *
 * }
 *
 *
 * Disebut:
 *
 * Guarded Block
 *
 *
 * Artinya:
 *
 * Thread hanya boleh lanjut jika kondisi yang dibutuhkan sudah
 * terpenuhi.
 *
 * ------------------------------------------------------------
 * Kenapa Harus while, Bukan if?
 * ------------------------------------------------------------
 *
 * Salah:
 *
 * if(!dataReady) {
 *
 *     wait();
 *
 * }
 *
 *
 * Benar:
 *
 * while(!dataReady) {
 *
 *     wait();
 *
 * }
 *
 *
 * Alasannya:
 *
 * 1. Spurious Wakeup
 *
 * Thread dapat terbangun tanpa adanya notify().
 *
 *
 * 2. Kondisi bisa berubah sebelum thread mendapatkan lock kembali.
 *
 *
 * Maka setelah bangun:
 *
 * Thread harus mengecek kondisi lagi.
 *
 * ------------------------------------------------------------
 * notify() Bukan Berarti Thread Langsung Jalan
 * ------------------------------------------------------------
 *
 * Kesalahpahaman umum:
 *
 * notify()
 *
 * dianggap:
 *
 * "Thread langsung aktif."
 *
 *
 * Yang benar:
 *
 * notify()
 *
 * hanya memberikan sinyal.
 *
 *
 * Alurnya:
 *
 * Thread A:
 *
 * wait()
 *    |
 *    v
 * Menunggu
 *
 *
 * Thread B:
 *
 * notify()
 *    |
 *    v
 * Memberikan sinyal
 *
 *
 * Thread A:
 *
 * Bangun
 *    |
 *    v
 * Menunggu mendapatkan lock kembali
 *    |
 *    v
 * Lanjut eksekusi
 *
 * ------------------------------------------------------------
 * Kenapa synchronized Saja Tidak Cukup?
 * ------------------------------------------------------------
 *
 * synchronized hanya memastikan:
 *
 * "Tidak ada dua thread masuk bersamaan."
 *
 *
 * Tetapi synchronized tidak mengatur:
 *
 * "Kapan thread harus berhenti dan kapan harus lanjut."
 *
 *
 * Contoh:
 *
 * Producer:
 *
 * synchronized put()
 *
 *
 * Consumer:
 *
 * synchronized get()
 *
 *
 * Data mungkin aman dari race condition.
 *
 * Tetapi:
 *
 * Consumer bisa membaca data lama berulang kali.
 *
 * Producer bisa terus membuat data tanpa kontrol.
 *
 *
 * Jadi:
 *
 * synchronized = aman
 *
 * wait/notify = terkoordinasi
 *
 * ------------------------------------------------------------
 * Analogi Sederhana
 * ------------------------------------------------------------
 *
 * Producer:
 *
 * "Saya belum punya tempat kosong untuk data baru.
 * Saya tunggu dulu."
 *
 *
 * Consumer:
 *
 * "Saya sudah mengambil data.
 * Saya beri tahu Producer."
 *
 *
 * Producer:
 *
 * "Oke, saya lanjut bekerja."
 *
 *
 * Inilah komunikasi antar thread.
 *
 * ------------------------------------------------------------
 * Konsep Cooperative Threading
 * ------------------------------------------------------------
 *
 * Dengan wait() dan notify(), thread tidak hanya berjalan
 * bersamaan.
 *
 * Mereka bekerja sama.
 *
 *
 * Thread:
 *
 * - Menunggu kondisi tertentu.
 * - Memberikan sinyal.
 * - Melanjutkan ketika kondisi terpenuhi.
 *
 *
 * Ini disebut:
 *
 * Cooperative Threading
 *
 * ------------------------------------------------------------
 * Penggunaan Dunia Nyata
 * ------------------------------------------------------------
 *
 * Konsep komunikasi thread digunakan pada:
 *
 * - Thread pool.
 * - Task queue.
 * - Producer-consumer system.
 * - Message processing.
 * - Background worker.
 *
 *
 * Pada Java modern, banyak kasus sudah digantikan oleh API
 * tingkat tinggi seperti:
 *
 * - BlockingQueue
 * - ExecutorService
 * - CompletableFuture
 *
 *
 * Tetapi memahami wait/notify tetap penting karena menjadi dasar
 * concurrency Java.
 *
 * ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * Interthread Communication digunakan ketika thread perlu saling
 * berkoordinasi.
 *
 *
 * Konsep utama:
 *
 * synchronized:
 *
 * Mencegah tabrakan akses data.
 *
 *
 * wait():
 *
 * Thread berhenti sementara dan melepas lock.
 *
 *
 * notify():
 *
 * Memberi sinyal kepada satu thread yang menunggu.
 *
 *
 * notifyAll():
 *
 * Memberi sinyal kepada semua thread yang menunggu.
 *
 *
 * Aturan penting:
 *
 * - wait/notify harus berada dalam synchronized.
 * - Gunakan while, bukan if.
 * - notify bukan berarti thread langsung berjalan.
 *
 *
 * Prinsip utama:
 *
 * "Multithreading bukan hanya menjalankan banyak thread,
 * tetapi membuat mereka bekerja sama dengan aturan yang benar."
 *
 */

// Contoh
class Q {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        // tunggu kalau belum ada data
        while (!valueSet) {
            try {
                wait(); // tidur
            } catch (InterruptedException e) {
                System.out.println("Interruptedexception caugh");
            }
        }
        System.out.println("Got : " + n);

        valueSet = false; // data sudah diambil
        notify(); // kasih tau producer
        return n;
    }

    synchronized void put(int n) {
        // tunggu kalau data belum diambil
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        this.n = n;
        valueSet = true;

        System.out.println("Put: " + n);
        notify(); // kasih tau consumer
    }
}

// class producer
class Producer implements Runnable {
    Q q;

    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    @Override
    public void run() {
        int i = 1;
        while (true) {
            q.put(i++);
        }
    }
}

// class Consumer
class Consumer implements Runnable {
    Q q;

    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {
        while (true) {
            q.get();
        }
    }

    /**
     * Oke bro, kita pelan-pelan banget ya. Anggap ini kayak dua orang kerja bareng:
     *
     * Producer = yang MASAK (buat data)
     * Consumer = yang MAKAN (ambil data)
     *
     * Dan Q itu kayak piring cuma 1
     *
     * Gambaran Besar Dulu (WAJIB PAHAM)
     * Di Q ada 2 hal penting:
     * int n;
     * boolean valueSet = false;
     *
     * Artinya:
     * n → isi data
     * valueSet:
     * false → piring kosong
     * true → ada makanan
     *
     * ------------------------------------
     * 
     * ALUR BESAR PROGRAM
     * 
     * Producer jalan → put()
     * Consumer jalan → get()
     *
     * Mereka gantian (tidak boleh bersamaan)
     *
     * KITA BEDAH PER METHOD (PELAAAN)
     * 
     * METHOD put(int n) (Producer)
     * synchronized void put(int n)
     *
     * Artinya:
     * Producer masuk ke “ruangan terkunci” (lock object Q)
     *
     * LANGKAH-LANGKAH put()
     * 1. CEK: apakah data lama sudah diambil?
     * while (valueSet)
     *
     * Kalau true:
     * berarti masih ada data lama
     * TIDAK BOLEH overwrite
     *
     * 2. Kalau masih ada data → TIDUR
     * wait();
     *
     * Ini penting banget:
     * Producer:
     * tidur
     * lepas kunci (lock)
     *
     * Jadi Consumer bisa masuk
     *
     * 3. Kalau sudah kosong → isi data
     * this.n = n;
     * valueSet = true;
     *
     * Sekarang:
     * data tersedia
     * piring sudah terisi
     *
     * 4. Print
     * System.out.println("Put: " + n);
     *
     * 5. Bangunin Consumer
     * notify();
     *
     * "Woy, udah ada makanan!"
     *
     * METHOD get() (Consumer)
     * synchronized int get()
     *
     * Consumer juga masuk ruangan terkunci
     *
     * -------------------------
     * 
     * LANGKAH-LANGKAH get()
     * 
     * 1. CEK: apakah ada data?
     * while (!valueSet)
     *
     * Kalau false:
     * berarti kosong
     * nggak bisa ambil
     *
     * 2. Kalau kosong → TIDUR
     * wait();
     *
     * Consumer:
     * tidur
     * lepas lock
     *
     * Jadi Producer bisa masuk
     *
     * 3. Kalau ada → ambil data
     * System.out.println("Got: " + n);
     *
     * 4. Tandai kosong
     * valueSet = false;
     *
     * Piring sekarang kosong lagi
     *
     * 5. Bangunin Producer
     * notify();
     *
     * "Udah gue makan, masak lagi!"
     *
     * ----------------------------------
     * 
     * SEKARANG KITA SIMULASI STEP-BY-STEP
     * AWAL PROGRAM
     * valueSet = false
     *
     * Artinya:
     *
     * piring kosong
     * STEP 1: Producer jalan
     *
     * Masuk put(1)
     *
     * valueSet = false → lanjut
     * isi data → n = 1
     * valueSet = true
     * print → Put: 1
     * notify() (bangunin consumer)
     *
     * STEP 2: Consumer jalan
     *
     * Masuk get()
     *
     * valueSet = true → lanjut
     * print → Got: 1
     * valueSet = false
     * notify() (bangunin producer)
     *
     * STEP 3: Producer lagi
     *
     * Masuk put(2)
     *
     * valueSet = false → lanjut
     * isi data → n = 2
     * valueSet = true
     * print → Put: 2
     * TERUS BERULANG
     *
     * Hasil:
     * Put: 1
     * Got: 1
     * Put: 2
     * Got: 2
     * Put: 3
     * Got: 3
     *
     * RAPI & BERGANTIAN
     *
     * ----------------
     * 
     * SEKARANG YANG PALING PENTING (INTUISI)
     * valueSet itu “lampu traffic”
     *
     * Kondisi Arti
     * false Producer boleh jalan
     * true Consumer boleh jalan
     *
     * wait() itu:
     * tidur
     * lepas kunci
     *
     * notify() itu:
     * bangunin thread lain
     *
     * KENAPA HARUS while, BUKAN if?
     * while (!valueSet)
     *
     * Karena:
     *
     * thread bisa bangun tiba-tiba (spurious wakeup)
     * harus cek ulang kondisi
     *
     * GAMBARAN PALING SIMPLE
     * Bayangin:
     *
     * Producer → isi → bilang "udah"
     * Consumer → ambil → bilang "udah"
     *
     * Mereka ngobrol pakai:
     *
     * wait() = "gue tunggu"
     * notify() = "udah bro"
     *
     * ------------------------------------
     * 
     * LEVEL DALAM (biar lu bener-bener ngerti)
     * Kenapa tanpa ini kacau?
     *
     * Tanpa wait():
     *
     * Producer spam data
     * Consumer baca data lama berkali-kali
     *
     * Kenapa ini keren?
     *
     * Karena:
     * tidak polling
     * tidak buang CPU
     * sinkron sempurna
     * 
     * RINGKASAN FINAL
     *
     * valueSet → penentu siapa jalan
     * wait() → tidur + lepas lock
     * notify() → bangunin
     * Producer & Consumer → saling koordinasi
     */
}

public class InterThreadComunication {
    public static void main(String[] args) {

        Q q = new Q();

        new Producer(q);
        new Consumer(q);

        System.out.println("Press ctrl+C to stop.");
    }
}
