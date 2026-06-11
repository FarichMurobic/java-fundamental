package MultiThreaded;

/**
     * Java menyediakan dukungan bawaan untuk multithreaded programming.
     * Program multithread punya dua atau lebih bagian yang bisa berjalan secara bersamaan (concurrently).
     * Setiap bagian disebut thread, dan setiap thread punya jalur eksekusi sendiri.
     * Jadi, multithreading = bentuk khusus dari multitasking
     *
     * Kita pasti udah familiar sama multitasking, karena semua OS modern pakai ini.
     * Tapi ternyata ada 2 jenis multitasking:
     *
     * 1. Process-based multitasking
     * Process = program yang sedang berjalan
     * Contoh:
     * Lu buka browser
     * Sambil compile Java
     * Sambil buka VS Code
     *
     * Itu semua program beda → masing-masing disebut process
     *
     * 2. Thread-based multitasking
     * Thread = bagian kecil dalam satu program
     * Satu program bisa punya beberapa thread
     *
     * Contoh:
     * Text editor:
     * Thread 1 → ngetik
     * Thread 2 → auto-save
     * Thread 3 → print
     *
     * Semua jalan bersamaan dalam satu program
     *
     * Perbedaan penting:
     * Process	                    Thread
     * Berat (heavyweight)	        Ringan (lightweight)
     * Punya memory sendiri	        Share memory
     * Lambat komunikasi	        Cepat komunikasi
     * Context switch mahal	        Context switch murah
     *
     * Konsep Penting: Idle Time
     * Ini bagian yang sering bikin orang “klik” 💡
     *
     * Contoh:
     * Nunggu input user
     * Nunggu file dibaca
     * Nunggu data dari internet
     *
     * CPU itu sebenarnya lagi nganggur (idle)
     *
     * Single Thread:
     * Ambil data → nunggu → lanjut
     *
     * Selama nunggu → program diem
     *
     * Multithreading:
     * Thread 1: nunggu data
     * Thread 2: kerja hal lain
     *
     * Jadi gak ada waktu kebuang
     *
     * Java itu spesial:
     * Java tidak ngatur process
     * Tapi Java ngatur thread
     *
     * Jadi:
     * Multithreading = full control di Java
     *
     * Cara Penerapan yang Benar
     * Kalau lu bikin program:
     * Gunakan thread saat:
     * Ada proses nunggu (I/O, network, user input)
     * Ada tugas yang bisa dipisah
     * Mau bikin aplikasi responsif
     *
     * ---------------------------------
     * 
     * JANGAN pakai thread kalau:
     * Tugas kecil banget
     * Cuma nambah kompleksitas
     *
     * KESIMPULAN (INI WAJIB NEMPEL)
     * Thread = unit kecil dalam program
     * Multithreading = banyak thread jalan bareng
     * Lebih efisien dibanding process
     * Mengurangi waktu nganggur (idle)
     * Cocok buat:
     * aplikasi interaktif
     * network
     * sistem real-time
     */

    /**
     * Java Thread Model
     *
     * Sistem runtime Java sangat bergantung pada thread untuk banyak hal. Bahkan,
     * hampir semua library di Java dirancang dengan konsep multithreading.
     * Java menggunakan thread supaya seluruh sistem bisa berjalan 
     * secara asynchronous (tidak harus nunggu satu sama lain).
     * 
     * Tujuannya: mengurangi pemborosan CPU
     *
     * Perbandingan dengan Single-thread
     *
     * Sistem single-thread pakai model:
     * event loop + polling
     *
     * Artinya:
     * Satu thread jalan terus (loop tanpa henti)
     * Dia ngecek (polling) apakah ada event
     * Kalau ada → diproses
     *
     * Masalahnya:
     * Selama satu event diproses → yang lain harus nunggu
     * Kalau ada proses lama → seluruh program ketahan
     *
     * Ini bikin CPU kebuang sia-sia
     *
     * Masalah Fatal Single-thread
     *
     * Kalau thread lagi:
     * nunggu network
     * nunggu input user
     * nunggu file
     *
     * Seluruh program ikut berhenti
     *
     * Solusi: Multithreading Java
     * Java menghilangkan konsep event loop tunggal itu.
     *
     * Dengan thread:
     * Satu thread bisa pause
     * Thread lain tetap jalan
     *
     * Contoh:
     * Thread A → nunggu input
     * Thread B → tetap kerja
     *
     * Perbedaan mindset:
     * Single-thread:
     * Kerja A → selesai → kerja B → selesai → kerja C
     *
     * Semua harus antri
     *
     * Multithread:
     * Thread A → jalan
     * Thread B → jalan
     * Thread C → jalan
     *
     * Bisa paralel / bergantian
     *
     * Konsep penting: BLOCKING
     * Blocking = thread berhenti karena nunggu sesuatu
     *
     * Contoh:
     * Scanner.nextLine() → nunggu user
     * read() file → nunggu disk
     * API call → nunggu internet
     *
     * Single-thread:
     * 1 thread block → semua mati
     *
     * Multithread:
     * 1 thread block → yang lain lanjut
     */

    /**
     * Single-core vs Multi-core (PENTING BANGET)
     * 
     * Single-core CPU
     * Thread gak benar-benar jalan bareng
     * Tapi:
     * CPU bagi waktu (time slicing)
     *
     * Kelihatan kayak paralel (padahal gantian cepat banget)
     *
     * Multi-core CPU
     * Thread bisa benar-benar jalan bersamaan
     *
     * Ini namanya parallel execution
     *
     * Insight: Fork/Join Framework
     * Ini disebut di teks:
     * Framework buat:
     * Bagi tugas besar jadi kecil (fork)
     * Gabung lagi hasilnya (join)
     *
     * Cocok untuk:
     * Multi-core CPU
     * Perhitungan berat
     *
     * ----------------------------------
     * 
     * Life Cycle Thread (WAJIB PAHAM)
     * 
     * Thread punya beberapa state:
     * 1. 🟢 Running
     * → lagi jalan
     *
     * 2. 🟡 Ready
     * → siap jalan, nunggu CPU
     *
     * 3. 🟠 Suspended
     * → berhenti sementara (pause)
     *
     * 4. 🔴 Blocked
     * → nunggu resource (file, input, dll)
     *
     * 5. ⚫ Terminated
     * → selesai, gak bisa hidup lagi
     *
     * Visual gampang:
     * Ready → Running → Blocked → Running → Terminated
     *
     * Fakta penting:
     * Thread itu independen
     * Tapi share memory → bisa konflik (nanti: synchronization)
     *
     * Kesalahan pemula:
     * Ngira semua thread benar-benar paralel (padahal tergantung CPU)
     * Gak ngerti blocking → bikin program freeze
     * Overuse thread → malah berat
     *
     * KESIMPULAN
     * Java sangat bergantung pada thread
     * Multithreading menggantikan model event loop lama
     * Thread bisa:
     * pause tanpa ngehentiin program
     * jalan paralel (tergantung CPU)
     * Blocking hanya berhentiin 1 thread, bukan seluruh program
     * Thread punya lifecycle (running, blocked, dll)
     */

    /**
     * PRIORITY
     * 
     * Java ngasih setiap thread sebuah priority (prioritas)
     * yang menentukan bagaimana thread itu diperlakukan dibanding thread lain.
     *
     * Priority itu berupa angka (integer)
     * Tapi angka itu relatif, bukan absolut
     *
     * Artinya:
     *
     * Thread dengan prioritas tinggi tidak otomatis lebih cepat,
     * tapi lebih diprioritaskan untuk dapat CPU
     *
     * Fungsi utama priority
     * Digunakan untuk menentukan:
     * kapan CPU pindah dari satu thread ke thread lain (context switch)
     *
     * Apa itu Context Switch?
     * Perpindahan CPU dari satu thread ke thread lain
     *
     * Contoh:
     * Thread A jalan → CPU pindah → Thread B jalan
     *
     * ATURAN THREAD SWITCHING
     * Ada 2 cara utama:
     *
     * 1. Voluntary (sukarela)
     * Thread sendiri “ngalah”
     *
     * Caranya:
     * yield() → kasih kesempatan ke thread lain
     * sleep() → tidur sementara
     * blocking (nunggu I/O)
     *
     * Setelah itu:
     * Java pilih thread lain
     * Yang dipilih = priority tertinggi yang siap jalan
     *
     * 2. Preemptive (dipaksa)
     * Thread prioritas tinggi bisa nyerobot
     *
     * Artinya:
     * Thread prioritas rendah lagi jalan
     * Tiba-tiba ada thread prioritas tinggi siap
     *
     * CPU langsung pindah ke yang tinggi
     *
     * Ini disebut:
     * Preemptive Multitasking
     *
     * Bayangin antrean dokter:
     * Prioritas tinggi = pasien darurat
     * Prioritas rendah = pasien biasa
     * Kasus 1 (voluntary):
     *
     * Pasien biasa bilang:
     * "Duluan aja bro"
     *
     * Kasus 2 (preemptive):
     * Dokter bilang:
     * "Yang darurat dulu!"
     *
     * Langsung dipotong
     *
     * KASUS PRIORITY SAMA
     * Kalau 2 thread punya priority sama:
     *
     * Di Windows:
     * Pakai round-robin
     *
     * Thread gantian jalan
     * Dibagi waktu
     *
     * Di OS lain:
     * Harus yield manual
     * Kalau gak yield → thread lain bisa kelaparan 
     *
     * PERINGATAN PENTING (INI SERIUS)
     * Portability problem
     *
     * Artinya:
     * Behavior thread bisa beda tergantung OS
     * Kode lu bisa jalan beda di:
     * Windows
     * Linux
     * macOS
     *
     * PRIORITY BUKAN CONTROL YANG PASTI
     * Banyak pemula mikir:
     * “Gua set MAX_PRIORITY = pasti jalan dulu”
     *
     * SALAH
     * JVM + OS scheduler yang nentuin
     *
     * PRIORITY JARANG DIPAKAI DI DUNIA NYATA
     * Kenapa?
     * Tidak konsisten antar OS
     * Sulit diprediksi
     * Bisa bikin bug aneh
     *
     * Yang lebih sering dipakai:
     * Thread pool
     * Executor framework
     * Synchronization
     *
     * Kapan Priority Dipakai?
     *
     * Gunakan kalau:
     * Ada task penting (misalnya UI vs background)
     * Lu ngerti risiko OS behavior
     *
     * Jangan pakai kalau:
     * Masih belajar dasar
     * Program butuh konsistensi
     *
     * KESIMPULAN
     * Thread punya priority (1–10)
     * Priority menentukan siapa dapat CPU duluan
     * Ada 2 cara switching:
     * voluntary (yield, sleep
     * Preemtive multitasking
     */

    /**
     * Karena multithreading itu berjalan secara asynchronous, 
     * kita butuh cara untuk memaksa sinkronisasi saat diperlukan.
     *
     * Contoh:
     * Kalau dua thread:
     * baca & tulis data yang sama (misalnya linked list)
     *
     * Harus dipastikan:
     * Jangan sampai satu thread nulis, sementara thread lain lagi baca di tengah proses
     *
     * Untuk itu, Java pakai konsep:
     * Monitor
     * Monitor ini mekanisme lama (oleh C.A.R. Hoare)
     *
     * Konsep Monitor
     * Bayangin:
     * Monitor = kotak kecil
     * Cuma muat 1 thread
     *
     * Kalau ada thread masuk:
     * Thread lain harus nunggu
     *
     * Di Java:
     * Gak ada class Monitor
     * Tapi:
     * Setiap object punya monitor sendiri
     *
     * Cara pakai:
     * Kalau method dikasih keyword:
     * synchronized
     *
     * Maka:
     * Thread masuk ke monitor object itu
     * Thread lain gak bisa masuk sampai selesai
     *
     * KONSEP INTI (WAJIB BANGET PAHAM)
     * MASALAH BESAR: RACE CONDITION
     * Contoh:
     * Thread A: baca data
     * Thread B: ubah data
     *
     * Bisa jadi:
     * A baca data setengah update 
     * Data jadi kacau
     *
     * Ini disebut:
     * Race Condition
     * Banyak thread “balapan” akses data
     *
     * SOLUSI: SYNCHRONIZATION
     *
     * Tujuannya:
     * Hanya 1 thread boleh akses data penting dalam satu waktu
     * synchronized = KUNCI
     *
     * CONTOH KODE (INI PENTING BANGET)
     * Tanpa Synchronization (Bahaya)
     * 
     * class Counter {
     *     int count = 0;
     *
     *     void increment() {
     *         count++; // tidak aman
     *     }
     * }
     *
     * Kalau banyak thread:
     * hasil bisa salah (harusnya 1000 jadi 873 dll)
     *
     * Dengan Synchronization
     * 
     * class Counter {
     *     int count = 0;
     *
     *     synchronized void increment() {
     *         count++; // aman
     *     }
     * }
     *
     * Penjelasan:
     * synchronized → thread harus “izin dulu”
     * Kalau ada thread di dalam:
     * yang lain nunggu
     *
     * CARA KERJA DI BALIK LAYAR
     * Saat thread masuk method synchronized:
     * Ambil lock (monitor) dari object
     * Jalanin kode
     * Lepas lock
     *
     * Thread lain baru boleh masuk
     *
     * ATURAN PENTING
     * Synchronization itu per OBJECT, bukan per method
     *
     * Contoh:
     * Counter c1 = new Counter();
     * Counter c2 = new Counter();
     *
     * c1 dan c2 punya monitor masing-masing
     * Bisa jalan bersamaan
     *
     * Insight Level Pro
     * Over-synchronization itu bahaya
     *
     * Kalau semua disynchronized:
     * Program jadi lambat
     * Thread ngantri terus
     *
     * Deadlock (nanti bakal lu temui)
     * Thread A nunggu B
     * Thread B nunggu A
     *
     * Stuck selamanya
     *
     * Jangan sembarang sync
     * Hanya sync:
     * bagian kritis (critical section)
     * data yang shared
     *
     * Penerapan Nyata
     * Gunakan synchronization saat:
     * Shared variable
     * Database connection
     * File access
     * Queue / buffer
     *
     * KESIMPULAN (INI WAJIB NANCEP)
     * Multithreading → bisa bikin konflik data
     * Solusinya = synchronization
     * Java pakai monitor (implicit di setiap object)
     * synchronized = kunci akses
     * Hanya 1 thread bisa masuk dalam satu waktu
     */

    /**
     * Setelah program lu dibagi jadi beberapa thread, lu harus nentuin:
     * gimana mereka saling komunikasi
     *
     * Di beberapa bahasa lain:
     * komunikasi antar thread bergantung ke OS
     * ini bikin berat (overhead)
     *
     * Di Java:
     * Java punya cara yang:
     * bersih (clean)
     * ringan (low-cost)
     *
     * Pakai method bawaan dari setiap object
     *
     * Cara kerjanya:
     * Thread masuk ke method synchronized
     *
     * Lalu dia bisa:
     * nunggu (wait)
     *
     * Thread lain nanti:
     * bangunin (notify)
     *
     * KONSEP INTI (INI KUNCI BANGET)
     * Masalah yang diselesaikan:
     *
     * Bukan cuma:
     * “biar gak tabrakan data”
     *
     * Tapi juga:
     * “biar thread bisa koordinasi” 
     *
     * Ini disebut:
     * Inter-thread communication
     *
     * ANALOGI PALING KENA
     * Restoran:
     * Thread 1 = Pelayan
     * Nunggu makanan jadi → wait()
     * Thread 2 = Koki
     * Masak → selesai → notify()
     *
     * Pelayan gak ngecek terus (hemat CPU)
     * Dia tidur sampai dibangunin
     *
     * METHOD PENTING (WAJIB HAFAL)
     * Semua ada di Object class:
     *
     * 1. wait()
     * Thread:
     * berhenti
     * nunggu notifikasi
     *
     * 2. notify()
     * Bangunin 1 thread
     *
     * 3. notifyAll()
     * Bangunin semua thread
     *
     * SYARAT PENTING
     * Harus dipanggil di dalam synchronized
     *
     * Kalau gak:
     * ERROR (IllegalMonitorStateException)
     *
     * KESIMPULAN
     * Thread butuh komunikasi → bukan cuma sinkronisasi
     * Java pakai:
     * wait()
     * notify()
     * notifyAll()
     * Semua berbasis monitor (synchronized)
     * wait() = tidur & lepas lock
     * notify() = bangunin thread lain
     */

    /**
     * Ilustrasi Kode (biar kebayang)
     *
     * Single Thread (masalah klasik)
     * System.out.println("Ambil data...");
     * Thread.sleep(5000); // nunggu 5 detik
     * System.out.println("Selesai");
     *
     * Selama 5 detik → program gak bisa ngapa-ngapain
     */


public class MultiThreadingPerkenalan {
    public static void main(String[] args) {

        Download d = new Download();
        d.start(); // jalan di thread terpisah.

        System.out.println("User masih bisa ngapa-ngapain.");

        /**
         * Penjelasan:
         * start() → bikin thread baru
         * run() → isi kerja thread
         * Main thread tetap jalan
         *
         * Ini inti multithreading
         */

        System.out.println();

        // Contoh priority
        MyThread t1 = new MyThread("Low", Thread.MIN_PRIORITY);
        MyThread t2 = new MyThread("High", Thread.MAX_PRIORITY);

        t1.start();
        t2.start();

        /**
         * Penjelasan:
         * MIN_PRIORITY = 1
         * NORM_PRIORITY = 5 (default)
         * MAX_PRIORITY = 10
         *
         * t2 lebih mungkin jalan dulu
         * TAPI tidak dijamin 100% 
         */
    }
}

// Contoh Multithreaded
class Download extends Thread {

    public void run() {
        try {
            System.out.println("Download mulai");
            Thread.sleep(5000); // simulasi download
            System.out.println("Download selesai.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Contoh Priority
class MyThread extends Thread {
    public MyThread(String nama, int priority) {
        super(nama);
        setPriority(priority); // set priority
    }

    public void run() {
        System.out.println(getName() + " jalan.");
    }
}

// CONTOH KODE (Producer-Consumer sederhana)
class Shared {
    int data;
    boolean hasData = false;

    synchronized void produce(int value) {
        try {
            while (hasData) {
                wait(); // nunggu sampai data diambil
            }
            data = value;
            hasData = true;
            System.out.println("Product: " + value);

            notify(); // bangunin consumer
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void consume() {
        try {
            while (!hasData) {
                wait(); // nunggu data tersedia
            }

            System.out.println("Consume: " + data);
            hasData = false;

            notify(); // bangunin producer
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * PENJELASAN DALAM
     * Kenapa pakai while, bukan if?
     * Untuk safety:
     *
     * thread bisa kebangun tanpa alasan (spurious wakeup)
     *
     * Flow:
     * Producer:
     * Kalau masih ada data → tunggu
     * Kalau kosong → isi → notify
     *
     * Consumer:
     * Kalau belum ada data → tunggu
     * Kalau ada → ambil → notify
     *
     * Insight Level Pro
     * wait() itu:
     * Melepas lock
     * Masuk ke state WAITING
     *
     * Thread lain bisa masuk
     *
     * sleep() vs wait()
     * sleep()	                wait()
     * Tidak lepas lock	        Lepas lock
     * Tidak butuh sync	        Harus di sync
     * Tidak bisa notify	    Bisa notify
     *
     * notify() vs notifyAll()
     * notify() → efisien tapi bisa salah thread
     * notifyAll() → aman tapi lebih berat
     *
     * Kesalahan Fatal Pemula
     * Panggil wait() di luar synchronized
     * Pakai if bukan while
     * Lupa notify() → thread bisa stuck
     * Overuse notifyAll → performa turun
     *
     * Penerapan Nyata
     *
     * Ini dipakai di:
     * Queue system
     * Thread pool
     * Producer-consumer (paling umum)
     * Real-time system
     */
}

