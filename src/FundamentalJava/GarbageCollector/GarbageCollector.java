package FundamentalJava.GarbageCollector;

/**
 * Garbage Collection (GC)
 *
 * Garbage Collection adalah mekanisme otomatis pada Java
 * yang bertugas membebaskan memori dari object yang sudah
 * tidak lagi digunakan oleh program.
 *
 * Berbeda dengan bahasa seperti C atau C++ yang mengharuskan
 * programmer mengelola memori secara manual (misalnya menggunakan
 * free() atau delete), Java menyerahkan tugas tersebut kepada
 * Java Virtual Machine (JVM).
 *
 * Dengan adanya Garbage Collection, programmer dapat lebih fokus
 * pada logika program tanpa harus mengelola alokasi dan pelepasan
 * memori secara manual..
 *
 * ------------------------------------------------------------
 *
 * Konsep Dasar
 *
 * Object di Java dibuat menggunakan operator:
 *
 * new
 *
 * Contoh:
 *
 * Box box = new Box();
 *
 * Object tersebut akan disimpan di Heap Memory,
 * sedangkan variabel "box" hanyalah reference yang berada di Stack Memory.
 *
 * Ilustrasi:
 *
 * Stack Memory Heap Memory
 * ---------------------- -----------------
 * box ----------------------> Box Object
 *
 * Selama masih ada reference yang menunjuk ke object,
 * object tersebut dianggap masih digunakan.
 *
 * ------------------------------------------------------------
 *
 * Kapan Object Menjadi Garbage?
 *
 * Sebuah object menjadi garbage apabila
 * sudah tidak dapat dijangkau (unreachable)
 * oleh reference mana pun.
 *
 * Dengan kata lain:
 *
 * Tidak ada lagi reference yang menunjuk ke object tersebut.
 *
 * Saat kondisi ini terjadi,
 * object menjadi kandidat untuk dibersihkan oleh Garbage Collector.
 *
 * Perlu diingat:
 * Menjadi garbage TIDAK berarti object langsung dihapus.
 *
 * ------------------------------------------------------------
 *
 * Contoh 1
 *
 * Test t = new Test();
 * t = null;
 *
 * Setelah reference diubah menjadi null,
 * object tidak lagi memiliki reference sehingga menjadi garbage.
 *
 * ------------------------------------------------------------
 *
 * Contoh 2
 *
 * Test t1 = new Test();
 * Test t2 = t1;
 *
 * t1 = null;
 *
 * Object BELUM menjadi garbage,
 * karena masih ada reference:
 *
 * t2 ---> object
 *
 * ------------------------------------------------------------
 *
 * Contoh 3
 *
 * Test t1 = new Test();
 * Test t2 = new Test();
 *
 * t1 = t2;
 *
 * Reference lama milik t1 hilang.
 *
 * Jika tidak ada reference lain yang menunjuk object pertama,
 * maka object tersebut menjadi garbage.
 *
 * ------------------------------------------------------------
 *
 * Garbage Collection Tidak Berjalan Seketika
 *
 * Banyak pemula mengira:
 *
 * t = null;
 *
 * langsung menghapus object.
 *
 * Itu tidak benar.
 *
 * Yang sebenarnya terjadi:
 *
 * 1. Reference hilang.
 * 2. Object menjadi unreachable.
 * 3. Object menjadi kandidat Garbage Collection.
 * 4. JVM menentukan sendiri kapan object akan dibersihkan.
 *
 * Jadi:
 *
 * "Garbage" bukan berarti langsung dihapus,
 * melainkan menunggu Garbage Collector bekerja.
 *
 * ------------------------------------------------------------
 *
 * Bagaimana Garbage Collector Bekerja?
 *
 * JVM secara berkala memeriksa object yang masih dapat dijangkau
 * (reachable) dari program.
 *
 * Object yang tidak lagi dapat dijangkau
 * akan dianggap sebagai garbage dan memorinya
 * dapat digunakan kembali.
 *
 * Algoritma Garbage Collection berbeda-beda tergantung JVM,
 * misalnya:
 *
 * - G1 Garbage Collector (default pada Java modern)
 * - Z Garbage Collector (ZGC)
 * - Shenandoah Garbage Collector
 * - Serial Garbage Collector
 * - Parallel Garbage Collector
 *
 * Sebagai programmer,
 * biasanya kita tidak perlu mengetahui detail algoritmanya,
 * karena semuanya dikelola otomatis oleh JVM.
 *
 * ------------------------------------------------------------
 *
 * Area Memori Java
 *
 * Secara sederhana, memori Java terdiri dari dua area utama:
 *
 * 1. Stack Memory
 *
 * Digunakan untuk:
 * - local variable
 * - parameter method
 * - pemanggilan method (call stack)
 * - reference object
 *
 * Stack bersifat otomatis.
 * Saat method selesai, isi stack akan dilepas.
 *
 * ------------------------------------------------------------
 *
 * 2. Heap Memory
 *
 * Digunakan untuk menyimpan:
 * - object
 * - array
 * - instance variable
 *
 * Semua object yang dibuat menggunakan operator new
 * dialokasikan di Heap Memory.
 *
 * Heap dikelola oleh Garbage Collector.
 *
 * ------------------------------------------------------------
 *
 * System.gc()
 *
 * Java menyediakan method:
 *
 * System.gc();
 *
 * Method ini HANYA memberikan permintaan (request)
 * kepada JVM agar menjalankan Garbage Collection.
 *
 * JVM tidak wajib menjalankannya.
 *
 * Artinya:
 *
 * System.gc();
 *
 * bukan berarti Garbage Collector langsung bekerja.
 *
 * Keputusan akhir tetap berada pada JVM.
 *
 * Oleh karena itu,
 * System.gc() jarang digunakan dalam aplikasi modern.
 *
 * ------------------------------------------------------------
 *
 * Kenapa Java Menggunakan Garbage Collection?
 *
 * Pada bahasa yang menggunakan manajemen memori manual,
 * programmer harus menghapus object sendiri.
 *
 * Misalnya di C++:
 *
 * delete object;
 *
 * Jika lupa menghapus:
 *
 * -> Memory Leak
 *
 * Jika menghapus dua kali:
 *
 * -> Undefined Behavior / Crash
 *
 * Java mengurangi risiko tersebut dengan
 * mengelola memori secara otomatis menggunakan
 * Garbage Collection.
 *
 * ------------------------------------------------------------
 *
 * Best Practice
 *
 * - Jangan memanggil System.gc() tanpa alasan yang jelas.
 * - Jangan mengandalkan kapan Garbage Collector dijalankan.
 * - Fokuslah menghilangkan reference yang sudah tidak diperlukan.
 * - Gunakan struktur data dan object secara efisien agar beban GC tidak
 * berlebihan.
 *
 * ------------------------------------------------------------
 *
 * Ringkasan
 *
 * Alur Garbage Collection:
 *
 * 1. Object dibuat menggunakan new.
 * 2. Object digunakan oleh program.
 * 3. Semua reference ke object hilang.
 * 4. Object menjadi unreachable (garbage).
 * 5. Garbage Collector membebaskan memori saat JVM menganggap waktunya tepat.
 *
 * Inti yang harus dipahami:
 *
 * - Object hidup selama masih memiliki reference.
 * - Object tanpa reference menjadi kandidat Garbage Collection.
 * - Garbage Collector bekerja secara otomatis.
 * - Waktu eksekusinya ditentukan oleh JVM, bukan oleh programmer.
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
