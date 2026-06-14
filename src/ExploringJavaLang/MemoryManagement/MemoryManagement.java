package ExploringJavaLang.MemoryManagement;

/**
 * Memory Management
 *
 * Walaupun Java menyediakan garbage collection otomatis, kadang lo ingin tahu:
 *
 * seberapa besar heap object
 * dan berapa banyak memori yang masih tersedia
 *
 * Lo bisa menggunakan informasi ini untuk:
 *
 * mengecek efisiensi kode
 * memperkirakan berapa banyak object lagi yang bisa dibuat
 *
 * Untuk mendapatkan nilai tersebut, gunakan:
 * totalMemory()
 * freeMemory()
 *
 * Seperti yang sudah dijelaskan sebelumnya, garbage collector Java berjalan secara berkala untuk membersihkan object yang tidak terpakai.
 * Namun, terkadang lo ingin menjalankan garbage collector sebelum waktunya.
 *
 * Lo bisa menjalankannya dengan method:
 * gc()
 *
 * Cara yang bagus untuk dicoba:
 * Panggil gc()
 * Panggil freeMemory() → dapat baseline
 * Jalankan kode lo
 * Panggil freeMemory() lagi → lihat berapa memori terpakai
 *
 * Program berikut menunjukkan konsep ini.
 *
 * Konsep Utama
 * Java pakai:
 * Heap Memory = tempat object disimpan
 *
 * 1. totalMemory()
 * Total memory yang JVM siap pakai
 *
 * Contoh:
 * Total memory is: 1048568
 *
 * 2. freeMemory()
 * Memory yang masih kosong
 *
 * 3. gc() (Garbage Collector)
 * Bersihin object yang:
 * sudah tidak punya referensi
 * gak dipakai lagi
 *
 * Insight Penting
 * gc() TIDAK DIJAMIN jalan langsung
 *
 * JVM bisa ignore
 *
 * new Integer(i) sekarang sudah deprecated
 * harusnya pakai:
 * Integer.valueOf(i)
 *
 * atau:
 * int i = 5; // auto-boxing
 *
 * Memory bukan selalu akurat 100%
 *
 * karena:
 * JVM punya optimasi
 * GC behavior beda-beda
 *
 * Analogi Biar Nempel
 *
 * Bayangin:
 * Heap = gudang
 * Object = barang
 * GC = tukang bersih-bersih
 *
 * Kalau:
 * barang gak dipakai → dibuang
 * tapi tukangnya gak selalu langsung bersihin 
 *
 * Relevansi ke Backend / Spring Boot
 * Ini kepake banget buat:
 * monitoring memory server
 * hindari memory leak
 * optimasi performa API
 * scaling system
 *
 * Kesimpulan Simpel
 * Java otomatis ngatur memory (GC)
 * Tapi lo tetap bisa:
 *
 * cek memory (freeMemory, totalMemory)
 * minta GC (gc())
 *
 * Flow penting:
 * GC → baseline
 * jalanin code
 * cek memory → lihat penggunaan
 *
 * Ini penting buat:
 * efisiensi
 * performa
 * backend system
 */

public class MemoryManagement {
    public static void main(String[] args) {
        
        // Demonstrasi totalMemory(), freeMemory(), dan gc()

        // Ambil instance Runtime (Akses ke JVM)
        Runtime runtime = Runtime.getRuntime();

        // Variabel untuk menyimpan nilai memory
        long memory1, memory2;

        // Membuat array Integer dengan kapasitas 1000
        Integer[] someInt = new Integer[1000];

        // Menampilkan total memory yang tersedia di JVM
        System.out.println("Total memory is: " + runtime.totalMemory());

        // Ambil memory bebas awal
        memory1 = runtime.freeMemory();
        System.out.println("Initial free memory: " + memory1);

        // Jalankan Garbage Collector (bersihin object gak kepake)
        runtime.gc();

        // Ambil memory setelah gc
        memory1 = runtime.freeMemory();
        System.out.println("Free memory after GC: " + memory1);

        // Alokasi object Integer sebanyak 1000
        for (int i = 0; i < 1000; i++) {
            someInt[i] = Integer.valueOf(i);
        }

        // Ambil memory setelah alokasi object
        memory2 = runtime.freeMemory();
        System.out.println("Free Memory after allocation: " + memory2);

        // Hitung berapa memory yang dipakai
        System.out.println("Memory used by allocation: " + (memory1 - memory2));

        // Buang referensi object (biar bisa di-GC)
        for (int i = 0; i < 1000; i++) {
            someInt[i] = null; // object jadi "tidak terpakai"
        }

        // Minta GC untuk bersihin object tadi
        runtime.gc();
        // Ambil memory setelah dibersihkan
        memory2 = runtime.freeMemory();
        System.out.println("Free memory after collecting discarded Integers: " + memory2);

        /**
         * Flow Program Ini
         * 
         * STEP 1 — Cek memory awal
         * mem1 = r.freeMemory();
         * STEP 2 — Jalankan GC
         * r.gc();
         *
         * biar dapet baseline memory bersih
         *
         * STEP 3 — Alokasi object
         * someints[i] = new Integer(i);
         *
         * bikin 1000 object baru
         *
         * STEP 4 — Lihat memory turun
         * mem2 = r.freeMemory();
         *
         * karena kepake
         *
         * STEP 5 — Buang referensi
         * someints[i] = null;
         *
         * object jadi "sampah"
         *
         * STEP 6 — GC lagi
         * r.gc();
         *
         * memory balik naik
         *
         * Sample Output
         * 
         * Total memory is: 1048568
         * Initial free memory: 751392
         * Free memory after garbage collection: 841424
         * Free memory after allocation: 824000
         * Memory used by allocation: 17424
         * Free memory after collecting discarded Integers: 842640
         */

    }

}
