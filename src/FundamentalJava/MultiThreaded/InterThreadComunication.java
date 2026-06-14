package FundamentalJava.MultiThreaded;

/**
     * Interthread Communication (Komunikasi antar Thread)
     *
     * Contoh sebelumnya itu “memblokir” thread lain supaya nggak akses method tertentu secara bersamaan.
     * Itu pakai synchronized.
     * Tapi Java punya cara yang lebih halus & efisien: yaitu komunikasi antar thread.
     *
     * Masalah Polling
     * Dalam multithreading:
     * Kita bagi tugas jadi bagian kecil (thread)
     * Tapi kadang thread harus nunggu thread lain
     *
     * Cara jelek (polling):
     * Thread ngecek kondisi terus-menerus pakai loop
     * Contoh:
     * Consumer nunggu Producer
     * Tapi dia ngecek terus → buang CPU
     *
     * Masalah Producer–Consumer
     * Bayangin:
     * Producer → bikin data
     * Consumer → ambil data
     *
     * Masalah:
     * Producer bisa terlalu cepat (overrun)
     * Consumer bisa baca data yang sama berkali-kali
     *
     * Solusi: wait(), notify(), notifyAll()
     *
     * Java kasih mekanisme komunikasi:
     * wait()
     * → Thread tidur & lepas lock (monitor)
     * notify()
     * → Bangunin 1 thread yang lagi nunggu
     * notifyAll()
     * → Bangunin semua thread yang nunggu
     *
     * HARUS dipanggil di dalam synchronized
     *
     * -----------------------
     * 
     * Spurious Wakeup (rare case)
     * Kadang thread bisa bangun tanpa notify()
     *
     * Makanya:
     * wait() HARUS di dalam while, bukan if
     *
     * -----------
     * 
     * Penjelasan Inti (biar lu bener-bener ngerti)
     * 
     * Kenapa synchronized doang nggak cukup?
     *
     * Lihat versi salah:
     * synchronized int get() { ... }
     * synchronized void put(int n) { ... }
     *
     * Masalah:
     * Memang nggak tabrakan
     * Tapi:
     * Producer bisa jalan terus
     * Consumer bisa baca data lama berkali-kali
     *
     * Jadi:
     * Synchronized = aman
     * tapi belum tentu sinkron (teratur)
     *
     * Konsep penting: “Koordinasi”
     * Dengan wait() & notify():
     *
     * Producer & Consumer saling nunggu
     * Jadi kayak ngobrol:
     *
     * Producer: "Gue tunggu dulu ya sampai data diambil"
     * Consumer: "Oke, gue ambil dulu, nanti gue kasih tau"
     *
     * Insight penting (ini bagian “aha moment”)
     * 1. wait() itu bukan sleep biasa
     * sleep() → tetap pegang lock
     * wait() → lepas lock
     *
     * -------------------------------
     * 
     * Ini krusial banget
     *
     * while, bukan if
     * while (!valueSet) wait();
     *
     * Kenapa?
     *
     * Antisipasi spurious wakeup
     * Jaga kondisi tetap valid
     *
     * notify() = sinyal, bukan langsung jalan
     * Thread yang dibangunin:
     * Harus nunggu lock dulu
     * Baru lanjut
     *
     * Ini contoh real “cooperative threading”
     *
     * Bukan cuma jalan bareng, tapi:
     * saling koordinasi
     *
     * Ringkasan Super Singkat
     * synchronized → cegah tabrakan
     * wait() → thread tidur + lepas lock
     * notify() → bangunin thread lain
     * Gunakan while, bukan if
     * Digunakan untuk sinkronisasi antar thread
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
     * Kondisi	Arti
     * false	Producer boleh jalan
     * true	Consumer boleh jalan
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
