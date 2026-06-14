package FundamentalJava.GarbageCollector;

    /**
     * Konsep Dasar Garbage Collection
     * Definisi sederhana
     * Garbage Collection adalah proses otomatis Java untuk membersihkan objek yang tidak lagi digunakan.
     *
     * Analogi sederhana
     * Bayangkan meja kerja.
     * Lu buat banyak kertas.
     * Sebagian dipakai.
     *
     * Sebagian dibuang.
     * Petugas kebersihan datang dan mengambil kertas yang tidak dipakai lagi.
     * Petugas itu adalah Garbage Collector.
     *
     * Karena objek dibuat secara dinamis menggunakan operator new,
     * mungkin kamu bertanya-tanya bagaimana objek tersebut dihancurkan dan bagaimana memori yang digunakan dilepaskan agar bisa dipakai kembali.
     * Dalam beberapa bahasa pemrograman seperti C++, objek yang dialokasikan secara dinamis harus dibebaskan secara manual menggunakan operator delete.
     *
     * Java menggunakan pendekatan yang berbeda. Java mengurus pelepasan memori secara otomatis untuk programmer.
     * Teknik yang melakukan hal ini disebut garbage collection.
     *
     * Cara kerjanya adalah sebagai berikut:
     * Jika tidak ada lagi reference yang menunjuk ke sebuah objek, maka objek tersebut dianggap tidak lagi dibutuhkan.
     * Akibatnya, memori yang digunakan oleh objek tersebut dapat dibebaskan dan digunakan kembali.
     * Tidak perlu menghancurkan objek secara eksplisit seperti di C++.
     *
     * Garbage collection tidak langsung terjadi hanya karena ada objek yang sudah tidak digunakan.
     * Java menentukan sendiri kapan waktu terbaik untuk membersihkan memori.
     *
     * Berbagai implementasi Java runtime bisa menggunakan algoritma garbage collection yang berbeda.
     * Namun biasanya programmer tidak perlu memikirkan hal ini saat menulis program.
     *
     * Memory di Java
     * Java memiliki dua area utama memory:
     * Stack Memory
     * Untuk:
     * local variable
     * method call
     *
     * Heap Memory
     * Untuk:
     * object
     * instance variable
     *
     * Object yang dibuat dengan new masuk ke Heap.
     *
     * Memory:
     * Stack          Heap
     * -----          ----
     * b --------->   Box Object
     *
     * Kapan Object Menjadi Garbage?
     * Object menjadi garbage jika tidak ada reference yang menunjuk ke object itu
     * Contoh:
     * Case 1
     * Test t = new Test();
     * t = null;
     * Object lama menjadi garbage.
     *
     * Case 2
     * Test t1 = new Test();
     * Test t2 = t1;
     * t1 = null;
     * Object tidak menjadi garbage.
     * Karena masih ada reference:
     * t2 → object
     *
     * Case 3
     * Test t1 = new Test();
     * Test t2 = new Test();
     * t1 = t2;
     * Object pertama menjadi garbage.
     * Karena reference hilang.
     *
     * Penting: Garbage Collector Tidak Langsung Jalan
     * Banyak pemula mengira:
     * t1 = null;
     *
     * Object langsung dihapus.
     * SALAH.
     * Java hanya menandai object sebagai garbage.
     * GC akan membersihkan kapan saja saat runtime memutuskan perlu.
     *
     * System.gc()
     * Kadang kita lihat kode:
     * System.gc();
     * Ini hanya request ke JVM untuk menjalankan GC.
     * Bukan jaminan.
     * JVM bisa saja mengabaikannya.
     *
     * Kenapa Java Pakai Garbage Collection?
     * Di bahasa seperti C++:
     * Programmer harus menulis:
     * delete object;
     * Kalau lupa:
     * ➡ memory leak.
     * Kalau delete dua kali:
     * ➡ crash.
     *
     * Java menghindari masalah ini dengan GC.
     *
     * Ringkasan Konsep
     * Garbage Collection bekerja seperti ini:
     * 1️ Object dibuat dengan new
     * 2️ Object digunakan
     * 3️ Reference hilang
     * 4️ Object menjadi garbage
     * 5️ Garbage Collector membersihkan memori
     *
     * Yang penting dipahami:
     * Object tanpa reference → Garbage
     * Garbage → dibersihkan GC
     */

public class GarbageCollector {
    // instance variabel
    int a;

    public static void main(String[] args) {

        GarbageCollector t1 = new GarbageCollector();
        GarbageCollector t2 = new GarbageCollector();

        t1 = null;

        System.gc();

        /**
         * Penjelasan Kode
         * Test t1 = new Test();
         * Object dibuat.
         * t1 → Object1
         *
         * Test t2 = new Test();
         * Object kedua dibuat.
         * t2 → Object2
         *
         * t1 = null;
         * Reference ke object pertama hilang.
         * Object1 → tidak ada reference
         * Sekarang object ini menjadi garbage.
         *
         * Garbage Collector nanti akan membersihkannya.
         */
    }
}
