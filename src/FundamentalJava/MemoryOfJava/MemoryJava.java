package FundamentalJava.MemoryOfJava;

public class MemoryJava {

    /*
     * ==========================================================
     * MEMORY DI JAVA
     * ==========================================================
     *
     * Ketika program Java berjalan, program membutuhkan memory dari
     * RAM..
     *
     * Pengelolaan memory tersebut dilakukan oleh:
     *
     * JVM (Java Virtual Machine)
     *
     *
     * JVM membagi memory menjadi beberapa area.
     *
     * Namun untuk memahami dasar kerja Java, ada dua area utama
     * yang wajib dipahami:
     *
     * 1. Stack Memory
     * 2. Heap Memory
     *
     *
     * Mental model sederhana:
     *
     * Stack
     * |
     * | menyimpan aktivitas program
     * |
     * v
     *
     * Heap
     * |
     * | menyimpan object dan data
     * |
     * v
     *
     * ==========================================================
     * HEAP MEMORY
     * (TEMPAT OBJECT HIDUP)
     * ==========================================================
     *
     * Heap adalah area memory yang digunakan untuk menyimpan:
     *
     * - Object.
     * - Instance variable.
     * - Data yang dibuat menggunakan keyword new.
     *
     *
     * Contoh:
     *
     * Person p = new Person();
     *
     *
     * Yang terjadi di memory:
     *
     *
     * STACK:
     *
     * p
     * |
     * v
     * alamat object
     *
     *
     * HEAP:
     *
     * Object Person
     *
     *
     * Variable p bukan menyimpan object secara langsung.
     *
     * Variable p hanya menyimpan reference yang menunjuk ke object
     * di heap.
     *
     * ==========================================================
     * KARAKTERISTIK HEAP
     * ==========================================================
     *
     * Ciri-ciri Heap Memory:
     *
     * - Ukurannya besar.
     * - Menyimpan object.
     * - Dapat diakses melalui reference.
     * - Dikelola oleh Garbage Collector.
     * - Lebih lambat dibandingkan Stack.
     *
     *
     * Karena object berada di heap dan dapat digunakan banyak bagian
     * program, maka heap bersifat:
     *
     * Shared
     *
     * Artinya:
     *
     * Object dapat diakses oleh banyak method atau thread selama
     * masih memiliki reference.
     *
     *
     * Kekurangan:
     *
     * Jika object tidak dikelola dengan baik, dapat terjadi:
     *
     * Memory Leak
     *
     * yaitu kondisi ketika object tidak digunakan lagi tetapi masih
     * memiliki reference sehingga tidak dibersihkan oleh GC.
     *
     * ==========================================================
     * STACK MEMORY
     * (TEMPAT AKTIVITAS PROGRAM)
     * ==========================================================
     *
     * Stack adalah area memory yang digunakan ketika method
     * dijalankan.
     *
     * Stack menyimpan:
     *
     * - Method call.
     * - Parameter method.
     * - Local variable.
     * - Reference variable.
     *
     *
     * Contoh:
     *
     * public static void main(String[] args) {
     *
     * int x = 10;
     * methodA();
     *
     * }
     *
     *
     * Memory:
     *
     * STACK:
     *
     * main()
     * |
     * x = 10
     *
     *
     * ==========================================================
     * CARA KERJA STACK
     * ==========================================================
     *
     * Stack bekerja menggunakan konsep:
     *
     * LIFO
     * (Last In First Out)
     *
     *
     * Artinya:
     *
     * Data yang terakhir masuk akan keluar terlebih dahulu.
     *
     *
     * Contoh pemanggilan method:
     *
     * main()
     * |
     * v
     * methodA()
     * |
     * v
     * methodB()
     *
     *
     * Stack:
     *
     * [ methodB ]
     * [ methodA ]
     * [ main ]
     *
     *
     * Ketika methodB selesai:
     *
     * - Stack frame methodB dihapus.
     * - Memory langsung dibersihkan.
     *
     *
     * Tidak membutuhkan Garbage Collector.
     *
     * ==========================================================
     * KARAKTERISTIK STACK
     * ==========================================================
     *
     * Ciri-ciri Stack:
     *
     * - Sangat cepat.
     * - Ukuran lebih kecil dibanding heap.
     * - Dibersihkan otomatis ketika method selesai.
     * - Tidak menggunakan Garbage Collector.
     * - Setiap thread memiliki stack sendiri.
     *
     *
     * Artinya:
     *
     * Thread A memiliki stack sendiri.
     *
     * Thread B memiliki stack sendiri.
     *
     * ==========================================================
     * PERBEDAAN STACK DAN HEAP
     * ==========================================================
     *
     * Stack Heap
     *
     * Method Object
     * Local variable Instance data
     * Cepat Lebih lambat
     * Ukuran kecil Ukuran besar
     * Otomatis dibersihkan Dibersihkan oleh GC
     * Setiap thread berbeda Shared
     *
     *
     * ==========================================================
     * PRIMITIVE VS REFERENCE VARIABLE
     * ==========================================================
     *
     * Ini adalah konsep yang sangat penting.
     *
     * ----------------------------------------------------------
     *
     * 1. Primitive Type
     *
     * Contoh:
     *
     * int x = 10;
     *
     *
     * Nilai primitive disimpan langsung.
     *
     *
     * Konsep:
     *
     * STACK:
     *
     * x = 10
     *
     *
     * ----------------------------------------------------------
     *
     * 2. Reference Type
     *
     * Contoh:
     *
     * Person p = new Person();
     *
     *
     * Yang terjadi:
     *
     * STACK:
     *
     * p
     * |
     * v
     * reference
     *
     *
     * HEAP:
     *
     * Person Object
     *
     *
     * Jadi:
     *
     * Reference menyimpan alamat menuju object.
     *
     * ==========================================================
     * APA ITU REFERENCE?
     * ==========================================================
     *
     * Reference adalah variabel yang menunjuk ke lokasi object di
     * heap.
     *
     *
     * Contoh:
     *
     * Person p1 = new Person();
     *
     * Person p2 = p1;
     *
     *
     * Banyak pemula salah memahami bagian ini.
     *
     * Kode:
     *
     * Person p2 = p1;
     *
     *
     * TIDAK membuat object baru.
     *
     *
     * Yang terjadi:
     *
     *
     * p1
     * \
     * \
     * ---> Person Object
     * /
     * /
     * p2
     *
     *
     * Kedua reference menunjuk object yang sama.
     *
     * ==========================================================
     * ASSIGNMENT REFERENCE
     * ==========================================================
     *
     * Contoh:
     *
     * p1 = p2;
     *
     *
     * Ini bukan:
     *
     * - Copy object.
     * - Menggabungkan object.
     *
     *
     * Tetapi:
     *
     * Mengubah arah reference.
     *
     *
     * Reference p1 sekarang menunjuk ke object yang sama dengan p2.
     *
     * ==========================================================
     * METHOD CALL DAN STACK FRAME
     * ==========================================================
     *
     * Setiap method yang dipanggil akan membuat:
     *
     * Stack Frame
     *
     *
     * Contoh:
     *
     * void a() {
     * b();
     * }
     *
     * void b() {
     * c();
     * }
     *
     * void c() {
     *
     * }
     *
     *
     * Stack:
     *
     * c()
     * b()
     * a()
     * main()
     *
     *
     * Setiap frame menyimpan informasi method tersebut.
     *
     * Ketika method selesai:
     *
     * Frame dihapus dari stack.
     *
     * ==========================================================
     * PASSING PARAMETER JAVA
     * ==========================================================
     *
     * Java menggunakan:
     *
     * Pass By Value
     *
     *
     * Artinya:
     *
     * Java selalu mengirimkan salinan nilai.
     *
     * ----------------------------------------------------------
     *
     * Primitive:
     *
     * void ubah(int x) {
     *
     * x = 100;
     *
     * }
     *
     *
     * Nilai asli tidak berubah.
     *
     * Karena yang dikirim hanya copy nilai.
     *
     *
     * ----------------------------------------------------------
     *
     * Object:
     *
     * void ubah(Person p) {
     *
     * p.name = "Bro";
     *
     * }
     *
     *
     * Object dapat berubah.
     *
     * Kenapa?
     *
     * Karena yang dikirim adalah:
     *
     * copy dari reference
     *
     *
     * Bukan copy object.
     *
     *
     * Jadi:
     *
     * Reference baru tetap menunjuk ke object yang sama.
     *
     * ==========================================================
     * GARBAGE COLLECTOR (GC)
     * ==========================================================
     *
     * Garbage Collector adalah fitur JVM yang bertugas membersihkan
     * object di heap yang sudah tidak digunakan.
     *
     *
     * Object dianggap tidak digunakan jika:
     *
     * Tidak ada reference yang menunjuk kepadanya.
     *
     *
     * Contoh:
     *
     * Person p = new Person();
     *
     * p = null;
     *
     *
     * Sebelum:
     *
     * p ---> Person Object
     *
     *
     * Setelah:
     *
     * p ---> null
     *
     *
     * Object lama tidak memiliki reference.
     *
     * Maka object tersebut:
     *
     * Eligible for Garbage Collection
     *
     *
     * Penting:
     *
     * Eligible for GC bukan berarti langsung dihapus.
     *
     * JVM menentukan kapan proses GC dijalankan.
     *
     * ==========================================================
     * MENENTUKAN OBJECT HIDUP ATAU MATI
     * ==========================================================
     *
     * JVM menggunakan konsep:
     *
     * Reachability
     *
     *
     * Artinya:
     *
     * Object dianggap hidup jika masih dapat dicapai dari:
     *
     * - Stack reference.
     * - Static reference.
     *
     *
     * Contoh:
     *
     * Person p1 = new Person();
     *
     * Person p2 = p1;
     *
     * p1 = null;
     *
     *
     * Apakah object mati?
     *
     * Tidak.
     *
     * Karena:
     *
     * p2 ---> Person Object
     *
     *
     * Object masih reachable.
     *
     * ==========================================================
     * KESIMPULAN
     * ==========================================================
     *
     * Memory Java dapat dipahami melalui dua area utama:
     *
     *
     * 1. Stack Memory
     *
     * Menyimpan:
     *
     * - Method.
     * - Local variable.
     * - Reference variable.
     *
     *
     * 2. Heap Memory
     *
     * Menyimpan:
     *
     * - Object.
     * - Instance data.
     *
     *
     * Konsep inti:
     *
     * Stack
     * =
     * Aktivitas program
     *
     *
     * Heap
     * =
     * Data object
     *
     *
     * Reference
     * =
     * Penghubung Stack ke Heap
     *
     *
     * Garbage Collector
     * =
     * Membersihkan object yang sudah tidak reachable
     *
     *
     * Mental model:
     *
     * Variable
     * |
     * v
     * Reference
     * |
     * v
     * Object di Heap
     *
     *
     * Object akan tetap hidup selama masih ada reference yang
     * menunjuk kepadanya.
     *
     * ==========================================================
     */

}
