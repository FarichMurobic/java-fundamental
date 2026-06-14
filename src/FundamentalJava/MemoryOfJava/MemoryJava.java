package FundamentalJava.MemoryOfJava;

public class MemoryJava {

    /**
     * Apa itu Memory di Java?
     *
     * Saat program Java jalan, dia pakai memory dari RAM yang diatur oleh JVM (Java Virtual Machine).
     * Memory ini dibagi jadi beberapa bagian, tapi yang PALING penting buat lo pahami dulu:
     * Stack Memory
     * Heap Memory
     *
     * Heap Memory (TEMPAT OBJECT HIDUP)
     * Definisi
     *
     * Heap adalah tempat semua object dan data besar disimpan
     *
     * Contoh:
     * Person p = new Person();
     *
     * Yang terjadi:
     * Stack:
     * p → (alamat object)
     * Heap:
     * Object Person dibuat di sini
     *
     * ------------------------
     * 
     * Intinya:
     * Heap = tempat object
     * Semua yang pakai new masuk sini
     * Shared (bisa diakses banyak method / thread)
     *
     * Ciri-ciri Heap:
     * Ukuran besar
     * Lebih lambat dari stack
     * Diatur oleh Garbage Collector
     * Bisa terjadi memory leak
     *
     * Stack Memory (TEMPAT AKTIVITAS JALAN)
     * Definisi
     * Stack adalah tempat method dijalankan dan variabel lokal disimpan
     *
     * Contoh:
     * public static void main(String[] args) {
     *     int x = 10;
     *     methodA();
     * }
     * 
     * Isi Stack:
     * Method call (frame)
     * Parameter
     * Variabel lokal
     * Reference ke object
     * 
     * Cara kerja Stack:
     *
     * LIFO (Last In First Out)
     *
     * Contoh:
     * main() → methodA() → methodB()
     *
     * Stack:
     * [ methodB ]
     * [ methodA ]
     * [ main    ]
     *
     * Kalau methodB selesai:
     * langsung dihapus
     *
     * ------------------------------
     * 
     * Ciri-ciri Stack:
     * Sangat cepat 
     * Ukuran kecil
     * Otomatis bersih (tidak pakai GC)
     * Per thread (setiap thread punya stack sendiri)
     *
     * Perbedaan PALING PENTING
     * Stack	                        Heap
     * Method & variabel lokal	        Object
     * Cepat	                        Lebih lambat
     * Kecil	                        Besar
     * Auto clear	                    Pakai GC
     * Per thread	                    Shared
     *
     * Primitive vs Reference (INI KUNCI BANGET)
     * Primitive:
     * int x = 10;
     *
     * disimpan langsung di stack
     *
     * Object:
     * Person p = new Person();
     *
     * Stack:
     * p → alamat
     *
     * Heap:
     * object Person
     *
     * Reference itu apa?
     * Reference = penunjuk ke object di heap
     *
     * Contoh:
     * Person p1 = new Person();
     * Person p2 = p1;
     *
     * BUKAN buat object baru
     *
     * Tapi:
     * p1 → object
     * p2 → object (yang sama)
     *
     * Assignment itu MENIPU
     * p1 = p2;
     *
     * bukan copy object
     * bukan gabung object
     *
     * cuma mindahin arah pointer
     *
     * Method Call & Stack Frame
     *
     * Setiap method dipanggil:
     * dibuat stack frame baru
     *
     * Contoh:
     * void a() { b(); }
     * void b() { c(); }
     * void c() { }
     *
     * Stack:
     * c()
     * b()
     * a()
     * main()
     *
     * ----------------------------------
     * 
     * Passing Parameter (PENTING)
     * Java itu pass by value
     *
     * Primitive:
     * void ubah(int x) {
     *     x = 100;
     * }
     *
     * tidak mengubah luar
     *
     * Object:
     * void ubah(Person p) {
     *     p.name = "Bro";
     * }
     *
     * object berubah
     *
     * Kenapa?
     * karena yang dikirim adalah copy reference
     *
     * Garbage Collector (GC)
     * Tugas:
     *
     * Membersihkan object di heap yang tidak punya reference
     *
     * Contoh:
     * Person p = new Person();
     * p = null;
     *
     * object lama:
     * tidak direferensikan
     * siap dihapus GC
     *
     * Penting:
     * Tidak langsung dihapus
     * Hanya eligible for GC
     *
     * Cara JVM Menentukan "Hidup / Mati"
     * Pakai konsep: Reachability
     * Artinya:
     * Object hidup kalau masih bisa “dicapai” dari:
     * stack
     * static reference
     *
     * Contoh:
     * Person p1 = new Person();
     * Person p2 = p1;
     * p1 = null;
     *
     * object masih hidup karena:
     * p2 → object
     *
     * Ringkasan SUPER INTI
     * Stack = aktivitas (method, variabel lokal)
     * Heap = data (object)
     * Reference = penghubung
     * GC = pembersih
     * Object mati kalau tidak ada yang menunjuk
     */

}
