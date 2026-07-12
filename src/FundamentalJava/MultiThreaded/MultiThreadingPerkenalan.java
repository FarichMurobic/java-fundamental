package FundamentalJava.MultiThreaded;

/**
 * ============================================================
 * MULTITHREADING PROGRAMMING DI JAVA
 * ============================================================
 *
 * Java menyediakan dukungan bawaan untuk membuat program
 * multithreaded.
 *
 * Program multithread adalah program yang memiliki dua atau lebih
 * bagian pekerjaan yang dapat berjalan secara concurrent.
 *
 * Concurrent berarti beberapa pekerjaan dapat berjalan secara
 * bersamaan atau bergantian dengan cepat tergantung bagaimana
 * JVM dan Operating System mengatur thread tersebut.
 *
 * Setiap bagian pekerjaan tersebut disebut thread.
 *
 * Setiap thread memiliki jalur eksekusi sendiri, tetapi thread
 * dalam satu program dapat berbagi resource yang sama seperti
 * memory.
 *
 * Konsep utama:
 *
 * Multithreading adalah salah satu bentuk dari multitasking,
 * yaitu kemampuan sistem untuk mengerjakan beberapa tugas dalam
 * waktu yang sama.
 *
 * ============================================================
 *
 * MULTITASKING
 * ============================================================
 *
 * Hampir semua Operating System modern mendukung multitasking.
 *
 * Multitasking dapat dibagi menjadi dua jenis utama:
 *
 * ------------------------------------------------------------
 *
 * 1. PROCESS-BASED MULTITASKING
 * ------------------------------------------------------------
 *
 * Process adalah sebuah program yang sedang berjalan.
 *
 * Setiap process memiliki:
 *
 * - Memory sendiri
 * - Resource sendiri
 * - Lingkungan eksekusi sendiri
 *
 * Contoh:
 *
 * Membuka browser.
 * Sambil melakukan compile program Java.
 * Sambil membuka Visual Studio Code.
 *
 * Ketiga aktivitas tersebut merupakan process yang berbeda.
 *
 * Setiap process berjalan secara independen dari process lainnya.
 *
 * ------------------------------------------------------------
 *
 * 2. THREAD-BASED MULTITASKING
 * ------------------------------------------------------------
 *
 * Thread adalah bagian kecil dari sebuah process yang memiliki
 * jalur eksekusi sendiri.
 *
 * Satu program dapat memiliki banyak thread yang bekerja
 * secara bersamaan.
 *
 * Contoh pada aplikasi text editor:
 *
 * Thread 1:
 * Menangani input keyboard saat user mengetik.
 *
 * Thread 2:
 * Menjalankan fitur auto-save.
 *
 * Thread 3:
 * Menangani proses printing.
 *
 * Semua thread tersebut berada dalam satu aplikasi yang sama.
 *
 * ============================================================
 *
 * PERBEDAAN PROCESS DAN THREAD
 * ============================================================
 *
 * Process:
 *
 * - Memiliki memory sendiri.
 * - Lebih berat (heavyweight).
 * - Komunikasi antar process lebih kompleks.
 * - Context switching lebih mahal.
 *
 *
 * Thread:
 *
 * - Berbagi memory dalam satu process.
 * - Lebih ringan (lightweight).
 * - Komunikasi antar thread lebih cepat.
 * - Context switching lebih murah.
 *
 * ============================================================
 *
 * KONSEP PENTING: IDLE TIME
 * ============================================================
 *
 * Salah satu alasan utama penggunaan multithreading adalah untuk
 * mengurangi waktu CPU menganggur (idle time).
 *
 * Dalam sebuah program, banyak operasi membutuhkan waktu tunggu.
 *
 * Contoh:
 *
 * - Menunggu input user.
 * - Membaca file dari disk.
 * - Mengambil data dari internet.
 * - Menunggu response dari database.
 *
 * Saat operasi tersebut berlangsung, CPU sebenarnya tidak selalu
 * bekerja penuh karena program sedang menunggu hasil.
 *
 * ------------------------------------------------------------
 *
 * Single Thread:
 *
 * Ambil data
 *      ->
 * Tunggu response
 *      ->
 * Lanjut proses berikutnya
 *
 * Selama proses menunggu:
 * Program tidak dapat melakukan pekerjaan lain.
 *
 *
 * Multithreading:
 *
 * Thread 1:
 * Menunggu data dari internet.
 *
 * Thread 2:
 * Tetap melakukan pekerjaan lain.
 *
 * Hasil:
 *
 * Waktu tunggu dapat dimanfaatkan untuk menjalankan tugas lain.
 *
 * ============================================================
 *
 * JAVA THREAD MODEL
 * ============================================================
 *
 * Dalam Java, programmer mengontrol thread melalui JVM.
 *
 * Java tidak secara langsung mengatur process Operating System,
 * tetapi menyediakan API untuk membuat dan mengelola thread.
 *
 * Contoh:
 *
 * - class Thread
 * - interface Runnable
 * - Executor Framework
 * - Concurrent API
 *
 * Jadi konsep utama dalam concurrency Java adalah:
 *
 * Program Java bekerja dengan banyak thread yang dikelola
 * oleh JVM dan Operating System.
 *
 * ============================================================
 *
 * KAPAN MENGGUNAKAN THREAD?
 * ============================================================
 *
 * Thread cocok digunakan ketika:
 *
 * - Ada proses yang membutuhkan waktu tunggu.
 *
 *   Contoh:
 *   I/O operation, network request, user input.
 *
 * - Ada pekerjaan yang dapat dipisahkan menjadi beberapa tugas.
 *
 * - Membutuhkan aplikasi yang tetap responsif.
 *
 *
 * Contoh penggunaan nyata:
 *
 * - Server menangani banyak pengguna.
 * - Download manager.
 * - Background processing.
 * - Game loop.
 * - Aplikasi yang membutuhkan respon cepat.
 *
 * ------------------------------------------------------------
 *
 * KAPAN TIDAK MENGGUNAKAN THREAD?
 * ------------------------------------------------------------
 *
 * Hindari membuat thread jika:
 *
 * - Tugas sangat kecil dan cepat selesai.
 * - Penggunaan thread hanya menambah kompleksitas.
 *
 * Thread memiliki overhead sehingga pembuatan thread harus
 * dilakukan dengan pertimbangan yang tepat.
 *
 * Pada aplikasi modern, biasanya programmer menggunakan:
 *
 * - Thread Pool
 * - ExecutorService
 *
 * daripada membuat thread secara manual terus-menerus.
 *
 * ============================================================
 *
 * KESIMPULAN
 * ============================================================
 *
 * - Thread adalah unit kecil dalam sebuah program yang memiliki
 *   jalur eksekusi sendiri.
 *
 * - Multithreading memungkinkan satu program menjalankan beberapa
 *   pekerjaan secara concurrent.
 *
 * - Process memiliki memory sendiri, sedangkan thread berbagi
 *   memory dalam satu process.
 *
 * - Tujuan utama multithreading adalah meningkatkan efisiensi
 *   program dan mengurangi waktu CPU menganggur.
 *
 * - Multithreading banyak digunakan pada:
 *
 *   - Aplikasi interaktif.
 *   - Network programming.
 *   - Server.
 *   - Sistem yang membutuhkan respons cepat.
 *
 * ============================================================
 */

/**
 * Java Thread Model
 *
 * Java Runtime sangat bergantung pada konsep thread.
 * Banyak fitur internal Java dan library Java modern dirancang
 * dengan asumsi bahwa program dapat menjalankan beberapa thread
 * secara concurrent.
 *
 * Tujuan utama penggunaan thread:
 * - Membuat program lebih responsif
 * - Mengurangi waktu CPU menganggur (idle time)
 * - Memungkinkan beberapa pekerjaan berjalan tanpa harus saling menunggu
 *
 * ------------------------------------------------------------
 *
 * Konsep Asynchronous Execution
 *
 * Multithreading memungkinkan program berjalan secara asynchronous.
 *
 * Artinya:
 * Sebuah pekerjaan tidak harus menunggu pekerjaan lain selesai
 * sebelum bisa berjalan.
 *
 * Contoh:
 *
 * Thread A:
 * Mengambil data dari internet
 *
 * Thread B:
 * Tetap memproses data lain
 *
 * Thread C:
 * Menampilkan UI
 *
 * Ketiga pekerjaan bisa berjalan secara bersamaan
 * atau bergantian tergantung kemampuan CPU dan scheduler OS.
 *
 * ------------------------------------------------------------
 *
 * SINGLE THREAD MODEL
 *
 * Sistem single-thread hanya memiliki satu jalur eksekusi.
 *
 * Alurnya:
 *
 * Kerja A
 *   ↓
 * Selesai
 *   ↓
 * Kerja B
 *   ↓
 * Selesai
 *   ↓
 * Kerja C
 *
 * Semua pekerjaan harus berjalan secara berurutan.
 *
 * Jika satu pekerjaan membutuhkan waktu lama,
 * pekerjaan lain harus menunggu.
 *
 * ------------------------------------------------------------
 *
 * Event Loop dan Polling
 *
 * Banyak sistem single-thread menggunakan konsep:
 *
 * Event Loop + Polling
 *
 * Artinya:
 *
 * Satu thread berjalan dalam loop terus-menerus.
 *
 * Thread tersebut akan mengecek:
 *
 * "Apakah ada event baru?"
 *
 * Jika ada:
 * - Event diproses
 *
 * Jika tidak:
 * - Thread kembali mengecek
 *
 * Contoh event:
 * - Input user
 * - Request network
 * - File selesai dibaca
 *
 * ------------------------------------------------------------
 *
 * Masalah Single Thread
 *
 * Masalah terbesar terjadi ketika thread melakukan blocking.
 *
 * Contoh:
 *
 * Scanner.nextLine()
 *
 * Thread harus menunggu user memasukkan data.
 *
 * Atau:
 *
 * Membaca file:
 *
 * read()
 *
 * Thread harus menunggu disk selesai bekerja.
 *
 * Atau:
 *
 * API Call:
 *
 * Thread harus menunggu response dari server.
 *
 * Selama proses menunggu:
 *
 * CPU tidak melakukan pekerjaan yang berguna.
 *
 * ------------------------------------------------------------
 *
 * Konsep BLOCKING
 *
 * Blocking adalah kondisi ketika sebuah thread berhenti sementara
 * karena menunggu sesuatu.
 *
 * Contoh:
 *
 * Thread A:
 * Menunggu database response
 *
 * Selama menunggu:
 * Thread A tidak bisa melanjutkan pekerjaan.
 *
 * Pada sistem single-thread:
 *
 * 1 thread mengalami blocking
 *        ↓
 * Seluruh program ikut berhenti
 *
 * ------------------------------------------------------------
 *
 * SOLUSI: MULTITHREADING JAVA
 *
 * Dengan multithreading:
 *
 * Jika satu thread berhenti karena menunggu,
 * thread lain tetap dapat berjalan.
 *
 * Contoh:
 *
 * Thread A:
 * Menunggu data internet
 *
 * Thread B:
 * Menghitung sesuatu
 *
 * Thread C:
 * Memproses input user
 *
 * Hasil:
 * Program tetap responsif.
 *
 * ------------------------------------------------------------
 *
 * Perbandingan Cara Berpikir
 *
 * Single Thread:
 *
 * Kerja A
 * selesai
 * lalu Kerja B
 * selesai
 * lalu Kerja C
 *
 * Semua pekerjaan harus antre.
 *
 *
 * Multithread:
 *
 * Thread A berjalan
 * Thread B berjalan
 * Thread C berjalan
 *
 * Pekerjaan dapat berjalan bersamaan
 * atau bergantian dengan cepat.
 *
 * ------------------------------------------------------------
 *
 * Single Core vs Multi Core
 *
 * Pada CPU single-core:
 *
 * Thread tidak benar-benar berjalan bersamaan.
 *
 * CPU menggunakan:
 *
 * Time Slicing
 *
 * CPU membagi waktu sangat cepat
 * antara beberapa thread.
 *
 * Sehingga terlihat seperti paralel.
 *
 *
 * Pada CPU multi-core:
 *
 * Beberapa thread dapat benar-benar berjalan
 * secara bersamaan.
 *
 * Ini disebut:
 *
 * Parallel Execution
 *
 * ------------------------------------------------------------
 *
 * Kesimpulan
 *
 * - Java menggunakan thread sebagai dasar eksekusi modern
 * - Multithreading membantu mengurangi waktu CPU idle
 * - Single-thread mudah dibuat tetapi mudah mengalami blocking
 * - Blocking pada single-thread dapat menghentikan seluruh program
 * - Multithreading memungkinkan thread lain tetap berjalan
 * - Concurrent execution tidak selalu berarti parallel execution
 * - Parallel execution membutuhkan dukungan multi-core CPU
 *
 * Inti utama:
 *
 * Thread membuat program tidak harus berhenti hanya karena
 * satu pekerjaan sedang menunggu.
 */

/**
 * Single-core vs Multi-core CPU
 *
 * Salah satu konsep penting dalam multithreading adalah memahami
 * perbedaan antara concurrency dan parallel execution.
 *
 * Banyak orang mengira:
 *
 * "Kalau punya banyak thread berarti semuanya berjalan bersamaan."
 *
 * Itu tidak selalu benar.
 *
 * Tergantung pada jumlah core CPU yang tersedia.
 *
 * ------------------------------------------------------------
 *
 * SINGLE-CORE CPU
 *
 * Pada CPU yang hanya memiliki satu core:
 *
 * Thread tidak benar-benar berjalan secara bersamaan.
 *
 * Karena hanya ada satu unit eksekusi yang tersedia.
 *
 * Lalu bagaimana banyak thread bisa berjalan?
 *
 * Jawabannya:
 *
 * Time Slicing
 *
 * CPU membagi waktu eksekusi menjadi bagian kecil.
 *
 * Contoh:
 *
 * Thread A → berjalan 5 ms
 * Thread B → berjalan 5 ms
 * Thread C → berjalan 5 ms
 *
 * CPU berpindah sangat cepat antar thread.
 *
 * Akibatnya:
 *
 * Manusia melihatnya seperti berjalan bersamaan,
 * padahal sebenarnya thread berjalan bergantian.
 *
 * Konsep ini disebut:
 *
 * Concurrent Execution
 *
 * ------------------------------------------------------------
 *
 * MULTI-CORE CPU
 *
 * Pada CPU dengan banyak core:
 *
 * Beberapa thread dapat benar-benar berjalan
 * pada waktu yang sama.
 *
 * Contoh:
 *
 * Core 1:
 * Thread A berjalan
 *
 * Core 2:
 * Thread B berjalan
 *
 * Core 3:
 * Thread C berjalan
 *
 * Ini disebut:
 *
 * Parallel Execution
 *
 * Jadi:
 *
 * Concurrency:
 * Banyak pekerjaan dikelola dalam satu periode waktu.
 *
 * Parallelism:
 * Banyak pekerjaan benar-benar dieksekusi bersamaan.
 *
 * ------------------------------------------------------------
 *
 * Insight: Fork/Join Framework
 *
 * Java menyediakan Fork/Join Framework untuk memanfaatkan
 * kemampuan multi-core CPU.
 *
 * Konsepnya:
 *
 * Fork:
 * Membagi pekerjaan besar menjadi beberapa tugas kecil.
 *
 * Join:
 * Menggabungkan kembali hasil dari tugas-tugas kecil tersebut.
 *
 * Contoh:
 *
 * Mengurutkan array besar.
 *
 * Sebelum:
 *
 * Satu thread mengerjakan seluruh data.
 *
 * Dengan Fork/Join:
 *
 * Data besar
 *       |
 *       ↓
 * Dibagi menjadi bagian kecil
 *       |
 *       ↓
 * Banyak thread mengerjakan bagian masing-masing
 *       |
 *       ↓
 * Hasil digabung kembali
 *
 * Cocok digunakan untuk:
 *
 * - Perhitungan berat
 * - Pemrosesan data besar
 * - Program yang berjalan pada multi-core CPU
 *
 * ------------------------------------------------------------
 *
 * Thread Life Cycle
 *
 * Thread tidak selalu dalam kondisi berjalan.
 *
 * Sebuah thread memiliki beberapa keadaan (state)
 * selama hidupnya.
 *
 * ------------------------------------------------------------
 *
 * 1. NEW
 *
 * Thread sudah dibuat tetapi belum dimulai.
 *
 * Contoh:
 *
 * Thread t = new Thread();
 *
 * Thread belum berjalan sampai:
 *
 * t.start();
 *
 * ------------------------------------------------------------
 *
 * 2. RUNNABLE
 *
 * Thread siap berjalan atau sedang berjalan.
 *
 * Pada Java, state:
 *
 * RUNNABLE
 *
 * mencakup:
 *
 * - Ready
 * - Running
 *
 * Ready:
 * Thread sudah siap tetapi menunggu CPU.
 *
 * Running:
 * Thread sedang mendapatkan CPU dan menjalankan kode.
 *
 * Scheduler JVM/OS yang menentukan kapan thread berjalan.
 *
 * ------------------------------------------------------------
 *
 * 3. BLOCKED
 *
 * Thread berhenti sementara karena menunggu resource.
 *
 * Contoh:
 *
 * Thread ingin masuk ke synchronized block,
 * tetapi lock sedang digunakan thread lain.
 *
 * Kondisi:
 *
 * Thread A:
 * Memegang lock
 *
 * Thread B:
 * Menunggu lock dilepas
 *
 * Thread B berada dalam kondisi BLOCKED.
 *
 * ------------------------------------------------------------
 *
 * 4. WAITING / TIMED_WAITING
 *
 * Thread berhenti karena menunggu sinyal
 * atau waktu tertentu.
 *
 * Contoh:
 *
 * wait()
 *
 * Thread menunggu thread lain melakukan notify().
 *
 *
 * sleep(1000)
 *
 * Thread berhenti selama waktu tertentu.
 *
 * ------------------------------------------------------------
 *
 * 5. TERMINATED
 *
 * Thread sudah selesai menjalankan tugasnya.
 *
 * Thread yang sudah terminated:
 *
 * - Tidak bisa dijalankan kembali
 * - Tidak bisa dipanggil start() lagi
 *
 * ------------------------------------------------------------
 *
 * Visual sederhana:
 *
 * NEW
 *  |
 *  ↓
 * RUNNABLE
 *  |
 *  ↓
 * RUNNING
 *  |
 *  ├── BLOCKED
 *  |
 *  ├── WAITING
 *  |
 *  ↓
 * TERMINATED
 *
 * ------------------------------------------------------------
 *
 * Fakta Penting Tentang Thread
 *
 * 1. Thread bersifat independen
 *
 * Setiap thread memiliki jalur eksekusi sendiri.
 *
 *
 * 2. Thread berbagi memory yang sama
 *
 * Karena thread dalam satu process berbagi memory,
 * maka bisa terjadi konflik data.
 *
 * Contoh:
 *
 * Thread A mengubah data
 * Thread B membaca data yang sama
 *
 * Masalah ini disebut:
 *
 * Race Condition
 *
 * Solusinya:
 *
 * Synchronization
 *
 * ------------------------------------------------------------
 *
 * Kesalahan Umum Pemula
 *
 * 1. Mengira semua thread berjalan benar-benar paralel
 *
 * Faktanya:
 *
 * Parallel execution tergantung jumlah core CPU.
 *
 *
 * 2. Tidak memahami blocking
 *
 * Satu thread yang berhenti belum tentu
 * membuat seluruh program berhenti.
 *
 *
 * 3. Membuat terlalu banyak thread
 *
 * Thread memiliki biaya:
 *
 * - Memory tambahan
 * - Context switching
 * - Scheduling overhead
 *
 * Terlalu banyak thread malah bisa membuat program lambat.
 *
 * ------------------------------------------------------------
 *
 * Kesimpulan
 *
 * - Single-core menggunakan time slicing untuk menjalankan banyak thread
 * - Multi-core dapat menjalankan thread secara parallel
 * - Concurrency tidak selalu berarti parallelism
 * - Fork/Join Framework membantu memanfaatkan multi-core CPU
 * - Thread memiliki lifecycle dari dibuat sampai selesai
 * - Thread dapat berhenti karena blocking atau waiting
 * - Thread berbagi memory sehingga membutuhkan synchronization
 *
 * Inti utama:
 *
 * Multithreading bukan hanya membuat banyak thread,
 * tetapi bagaimana mengatur thread agar bekerja efisien
 * sesuai kemampuan CPU dan desain program.
 */

/**
 * Thread Priority
 *
 * Java menyediakan fitur Thread Priority untuk memberikan tingkat
 * prioritas kepada setiap thread.
 *
 * Priority digunakan sebagai informasi tambahan bagi JVM dan OS scheduler
 * untuk menentukan thread mana yang lebih diprioritaskan mendapatkan CPU.
 *
 * ------------------------------------------------------------
 *
 * Konsep Dasar Priority
 *
 * Setiap thread memiliki nilai priority berupa integer.
 *
 * Range priority Java:
 *
 * MIN_PRIORITY    = 1
 * NORM_PRIORITY   = 5
 * MAX_PRIORITY    = 10
 *
 * Contoh:
 *
 * Thread A:
 * priority = 10
 *
 * Thread B:
 * priority = 1
 *
 * Artinya:
 *
 * Thread A memiliki prioritas lebih tinggi dibanding Thread B.
 *
 * Tetapi:
 *
 * Priority tinggi TIDAK berarti thread pasti berjalan lebih cepat.
 *
 * Priority hanya memberikan "petunjuk" kepada scheduler.
 *
 * JVM dan Operating System tetap menentukan
 * kapan thread mendapatkan CPU.
 *
 * ------------------------------------------------------------
 *
 * Kesalahan Pemahaman Umum
 *
 * Banyak programmer pemula berpikir:
 *
 * "Kalau saya kasih MAX_PRIORITY,
 * thread ini pasti berjalan duluan."
 *
 * Ini SALAH.
 *
 * Karena:
 *
 * Thread scheduling bergantung pada:
 *
 * - JVM implementation
 * - Operating System
 * - CPU scheduler
 *
 * Jadi hasilnya tidak selalu sama
 * di Windows, Linux, atau macOS.
 *
 * ------------------------------------------------------------
 *
 */

/**
 * Thread Synchronization
 *
 * Karena multithreading berjalan secara concurrent/asynchronous,
 * beberapa thread dapat mengakses data yang sama pada waktu yang hampir
 * bersamaan.
 *
 * Hal ini dapat menyebabkan masalah ketika beberapa thread:
 *
 * - Membaca data
 * - Mengubah data
 * - Mengakses resource yang sama
 *
 * Oleh karena itu Java menyediakan mekanisme:
 *
 * Synchronization
 *
 * Tujuannya:
 *
 * Mengatur akses thread terhadap resource bersama
 * agar data tetap konsisten dan aman.
 *
 * ------------------------------------------------------------
 *
 * Masalah Utama: Race Condition
 *
 * Race Condition terjadi ketika hasil program bergantung pada
 * urutan eksekusi beberapa thread yang tidak dapat diprediksi.
 *
 * Contoh:
 *
 * Thread A:
 * Membaca nilai counter
 *
 * Thread B:
 * Mengubah nilai counter
 *
 * Jika terjadi bersamaan:
 *
 * Thread A bisa membaca data ketika Thread B
 * belum selesai melakukan perubahan.
 *
 * Akibatnya:
 *
 * - Data tidak sesuai
 * - Nilai bisa salah
 * - Program menjadi tidak konsisten
 *
 * Kondisi ini disebut:
 *
 * Race Condition
 *
 * ------------------------------------------------------------
 *
 * Contoh Tanpa Synchronization
 *
 * class Counter {
 *
 *     int count = 0;
 *
 *     void increment() {
 *         count++;
 *     }
 * }
 *
 *
 * Sekilas terlihat aman.
 *
 * Tetapi operasi:
 *
 * count++
 *
 * sebenarnya terdiri dari beberapa langkah:
 *
 * 1. Membaca nilai count
 * 2. Menambah nilai
 * 3. Menyimpan kembali nilai
 *
 * Jika dua thread menjalankan proses ini bersamaan,
 * hasil akhirnya bisa salah.
 *
 * Contoh:
 *
 * Seharusnya:
 *
 * 1000
 *
 * Tetapi hasil:
 *
 * 873
 *
 * karena beberapa update tertimpa.
 *
 * ------------------------------------------------------------
 *
 * Solusi: synchronized
 *
 * Java menyediakan keyword:
 *
 * synchronized
 *
 * untuk membuat bagian kode menjadi:
 *
 * Critical Section
 *
 * Critical Section adalah bagian program
 * yang hanya boleh diakses satu thread dalam satu waktu.
 *
 *
 * Contoh:
 *
 * class Counter {
 *
 *     int count = 0;
 *
 *     synchronized void increment() {
 *         count++;
 *     }
 * }
 *
 *
 * Dengan synchronized:
 *
 * Thread yang masuk akan mendapatkan lock.
 *
 * Thread lain yang ingin masuk harus menunggu
 * sampai lock dilepas.
 *
 * ------------------------------------------------------------
 *
 * Konsep Monitor
 *
 * Synchronization pada Java menggunakan konsep:
 *
 * Monitor
 *
 * Monitor adalah mekanisme penguncian yang memastikan
 * hanya satu thread yang dapat menjalankan kode tertentu
 * pada waktu yang sama.
 *
 * Analogi:
 *
 * Monitor = ruangan kecil
 *
 * Kapasitas:
 *
 * 1 thread
 *
 * Jika Thread A masuk:
 *
 * Thread B, C, D harus menunggu di luar.
 *
 * Setelah Thread A selesai:
 *
 * Thread lain boleh masuk.
 *
 * ------------------------------------------------------------
 *
 * Monitor Pada Java
 *
 * Java tidak memiliki class bernama Monitor.
 *
 * Tetapi:
 *
 * Setiap object Java memiliki monitor internal.
 *
 * Contoh:
 *
 * Counter counter = new Counter();
 *
 * Object counter memiliki lock sendiri.
 *
 * Ketika method synchronized dipanggil:
 *
 * Thread mengambil monitor object tersebut.
 *
 * Setelah selesai:
 *
 * Monitor dilepas.
 *
 * ------------------------------------------------------------
 *
 * Cara Kerja synchronized
 *
 * Saat thread masuk ke synchronized method:
 *
 * 1. Thread mencoba mengambil lock object
 *
 * 2. Jika lock tersedia:
 *
 *    Thread masuk dan menjalankan kode
 *
 * 3. Jika lock sedang digunakan:
 *
 *    Thread menunggu
 *
 * 4. Setelah selesai:
 *
 *    Lock dilepas
 *
 * 5. Thread lain dapat masuk
 *
 * ------------------------------------------------------------
 *
 * Synchronization Berlaku Per Object
 *
 * Ini konsep penting.
 *
 * Lock dimiliki oleh object,
 * bukan oleh method.
 *
 * Contoh:
 *
 * Counter c1 = new Counter();
 * Counter c2 = new Counter();
 *
 *
 * c1 dan c2 memiliki monitor berbeda.
 *
 * Maka:
 *
 * Thread yang menggunakan c1
 * tidak memblokir thread yang menggunakan c2.
 *
 * Contoh:
 *
 * Thread A:
 * c1.increment()
 *
 * Thread B:
 * c2.increment()
 *
 * Bisa berjalan bersamaan.
 *
 * ------------------------------------------------------------
 *
 * Over-Synchronization
 *
 * Synchronization memang membuat data aman,
 * tetapi terlalu banyak synchronization dapat menjadi masalah.
 *
 * Jika semua kode dibuat synchronized:
 *
 * - Banyak thread harus antre
 * - Performa menurun
 * - Program kehilangan keuntungan multithreading
 *
 * Oleh karena itu:
 *
 * Synchronization hanya digunakan pada bagian penting.
 *
 * Fokus pada:
 *
 * - Shared variable
 * - Critical section
 * - Resource yang digunakan bersama
 *
 * ------------------------------------------------------------
 *
 * Hubungan Dengan Deadlock
 *
 * Synchronization yang salah dapat menyebabkan:
 *
 * Deadlock
 *
 * Contoh:
 *
 * Thread A memegang lock A
 * tetapi membutuhkan lock B
 *
 * Thread B memegang lock B
 * tetapi membutuhkan lock A
 *
 * Akhirnya:
 *
 * Thread A menunggu Thread B
 * Thread B menunggu Thread A
 *
 * Program berhenti selamanya.
 *
 * ------------------------------------------------------------
 *
 * Penerapan Synchronization Dalam Dunia Nyata
 *
 * Synchronization digunakan ketika banyak thread
 * mengakses resource yang sama.
 *
 * Contoh:
 *
 * - Shared variable
 * - Database connection
 * - File access
 * - Queue / Buffer
 * - Cache
 *
 * ------------------------------------------------------------
 *
 * Kesimpulan
 *
 * - Multithreading dapat menyebabkan konflik data
 * - Konflik data disebut Race Condition
 * - Synchronization digunakan untuk menghindari race condition
 * - Java menggunakan Monitor untuk mekanisme lock
 * - synchronized membuat hanya satu thread masuk dalam satu waktu
 * - Lock dimiliki oleh object, bukan method
 * - Jangan menggunakan synchronization secara berlebihan
 * - Synchronization yang salah dapat menyebabkan deadlock
 *
 * Inti utama:
 *
 * Synchronization bukan membuat thread berjalan lebih cepat,
 * tetapi memastikan banyak thread dapat bekerja bersama
 * tanpa merusak data.
 */

/**
 * Inter-Thread Communication
 *
 * Setelah program dibagi menjadi beberapa thread,
 * masalah berikutnya adalah:
 *
 * Bagaimana thread-thread tersebut saling berkomunikasi?
 *
 * Multithreading bukan hanya tentang menjalankan banyak thread,
 * tetapi juga tentang bagaimana thread tersebut berkoordinasi.
 *
 * ------------------------------------------------------------
 *
 * Masalah Yang Diselesaikan
 *
 * Synchronization menyelesaikan masalah:
 *
 * "Bagaimana agar thread tidak mengakses data bersamaan?"
 *
 * Tetapi masih ada masalah lain:
 *
 * "Bagaimana agar thread bisa saling memberi tahu?"
 *
 * Contoh:
 *
 * Producer:
 * Membuat data
 *
 * Consumer:
 * Mengambil data
 *
 * Consumer harus menunggu sampai Producer selesai membuat data.
 *
 * Consumer tidak boleh mengambil data kosong.
 *
 * Inilah yang disebut:
 *
 * Inter-thread Communication
 *
 * ------------------------------------------------------------
 *
 * Konsep Dasar
 *
 * Java menyediakan mekanisme komunikasi antar thread
 * menggunakan method bawaan dari class Object.
 *
 * Method tersebut:
 *
 * - wait()
 * - notify()
 * - notifyAll()
 *
 * Method ini bekerja menggunakan konsep:
 *
 * Monitor
 *
 * yang berhubungan langsung dengan:
 *
 * synchronized
 *
 * ------------------------------------------------------------
 *
 * Cara Kerja Sederhana
 *
 * Thread masuk ke synchronized block atau synchronized method.
 *
 * Kemudian thread dapat melakukan:
 *
 * wait()
 *
 * Artinya:
 *
 * "Saya berhenti sementara dan menunggu kondisi terpenuhi."
 *
 * Saat wait() dipanggil:
 *
 * - Thread masuk keadaan waiting
 * - Thread melepaskan lock monitor
 *
 * Kemudian thread lain dapat mengambil lock tersebut.
 *
 *
 * Thread lain ketika kondisi sudah terpenuhi dapat memanggil:
 *
 * notify()
 *
 * atau:
 *
 * notifyAll()
 *
 * untuk membangunkan thread yang sedang menunggu.
 *
 * ------------------------------------------------------------
 *
 * Analogi Restoran
 *
 * Producer = Koki
 *
 * Consumer = Pelayan
 *
 *
 * Kondisi:
 *
 * Pelayan ingin mengambil makanan,
 * tetapi makanan belum selesai dibuat.
 *
 * Cara buruk:
 *
 * Pelayan mengecek terus:
 *
 * "Sudah jadi belum?"
 * "Sudah jadi belum?"
 * "Sudah jadi belum?"
 *
 * Ini disebut:
 *
 * Polling
 *
 * Masalah:
 *
 * - Memboroskan CPU
 * - Tidak efisien
 *
 *
 * Cara Java:
 *
 * Pelayan:
 *
 * wait()
 *
 * Tidur menunggu makanan selesai.
 *
 *
 * Koki:
 *
 * Selesai memasak:
 *
 * notify()
 *
 * Memberi tahu bahwa makanan sudah tersedia.
 *
 * Hasil:
 *
 * CPU tidak terbuang untuk pengecekan terus-menerus.
 *
 * ------------------------------------------------------------
 *
 * Method Penting
 *
 * 1. wait()
 *
 * Fungsi:
 *
 * Membuat thread berhenti sementara
 * sampai thread lain memberikan sinyal.
 *
 * Efek:
 *
 * - Thread masuk waiting state
 * - Lock monitor dilepas
 *
 *
 * Contoh:
 *
 * synchronized(object) {
 *
 *     while(!dataReady) {
 *         object.wait();
 *     }
 *
 * }
 *
 * ------------------------------------------------------------
 *
 * 2. notify()
 *
 * Fungsi:
 *
 * Membangunkan satu thread yang sedang menunggu
 * pada monitor object yang sama.
 *
 * Contoh:
 *
 * synchronized(object) {
 *
 *     dataReady = true;
 *     object.notify();
 *
 * }
 *
 *
 * Jika ada banyak thread yang menunggu:
 *
 * Hanya satu yang dibangunkan.
 *
 * ------------------------------------------------------------
 *
 * 3. notifyAll()
 *
 * Fungsi:
 *
 * Membangunkan semua thread yang sedang menunggu
 * pada monitor object yang sama.
 *
 * Digunakan ketika:
 *
 * Banyak thread mungkin bisa melanjutkan pekerjaan.
 *
 * ------------------------------------------------------------
 *
 * Aturan Penting
 *
 * wait(), notify(), dan notifyAll()
 *
 * HARUS dipanggil di dalam:
 *
 * synchronized block
 *
 * Contoh benar:
 *
 * synchronized(lock) {
 *
 *     lock.wait();
 *
 * }
 *
 *
 * Contoh salah:
 *
 * lock.wait();
 *
 *
 * Jika tidak menggunakan synchronized:
 *
 * Java akan melempar:
 *
 * IllegalMonitorStateException
 *
 * Karena thread tidak memiliki monitor object tersebut.
 *
 * ------------------------------------------------------------
 *
 * Kenapa wait() Bukan sleep()?
 *
 * Banyak pemula mengira keduanya sama.
 *
 * Padahal berbeda.
 *
 *
 * sleep():
 *
 * - Menghentikan thread sementara
 * - Tidak melepas lock
 *
 *
 * wait():
 *
 * - Menghentikan thread sementara
 * - Melepas lock monitor
 *
 *
 * Contoh:
 *
 * Thread A memegang lock.
 *
 * Jika menggunakan sleep():
 *
 * Thread lain tetap tidak bisa masuk.
 *
 *
 * Jika menggunakan wait():
 *
 * Lock dilepas.
 *
 * Thread lain dapat bekerja.
 *
 * ------------------------------------------------------------
 *
 * Hubungan Dengan Synchronization
 *
 * Synchronization:
 *
 * "Siapa yang boleh masuk?"
 *
 *
 * Inter-thread communication:
 *
 * "Kapan thread harus menunggu dan kapan harus lanjut?"
 *
 *
 * Jadi:
 *
 * synchronized = pengaturan akses
 *
 * wait/notify = komunikasi dan koordinasi
 *
 * ------------------------------------------------------------
 *
 * Penerapan Nyata
 *
 * Konsep ini digunakan pada:
 *
 * - Producer Consumer Pattern
 * - Queue / Buffer
 * - Task Scheduler
 * - Thread Pool
 * - Background Processing
 *
 * Contoh dunia nyata:
 *
 * Server menerima request.
 *
 * Thread worker menunggu pekerjaan.
 *
 * Ketika ada request baru:
 *
 * Thread diberi notifikasi untuk bekerja.
 *
 * ------------------------------------------------------------
 *
 * Kesimpulan
 *
 * - Thread tidak hanya membutuhkan synchronization
 * - Thread juga membutuhkan komunikasi
 * - Java menyediakan wait(), notify(), notifyAll()
 * - Semua method bekerja berdasarkan monitor object
 * - wait() membuat thread menunggu dan melepas lock
 * - notify() membangunkan satu thread
 * - notifyAll() membangunkan semua thread
 * - Method tersebut harus digunakan dalam synchronized
 *
 * Inti utama:
 *
 * Synchronization membuat thread aman.
 *
 * Inter-thread communication membuat thread dapat bekerja sama.
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
         * 
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
         * 
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
     * PENJELASAN:
     * 
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
     * sleep() wait()
     * Tidak lepas lock Lepas lock
     * Tidak butuh sync Harus di sync
     * Tidak bisa notify Bisa notify
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
