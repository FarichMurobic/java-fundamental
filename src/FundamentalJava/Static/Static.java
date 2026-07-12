package FundamentalJava.Static;

/**
 * ------------------------------------------------------------------------
 * UNDERSTANDING STATIC
 * ------------------------------------------------------------------------
 * 
 * Ada kalanya kamu ingin membuat member class yang dapat digunakan
 * tanpa harus membuat object dari class tersebut.
 * 
 * Biasanya, member dari class hanya bisa diakses melalui object dari class itu.
 * Namun, Java memungkinkan kita membuat member yang bisa digunakan
 * secara langsung tanpa object.
 * 
 * Untuk membuat member seperti ini, kita menggunakan keyword:
 *     static
 * 
 * Jika sebuah member dideklarasikan sebagai static, maka:
 * - Member tersebut bisa diakses sebelum object dibuat
 * - Bisa digunakan tanpa reference ke object
 * 
 * Baik method maupun variable bisa dibuat static.
 * 
 * ------------------------------------------------------------------------
 * CONTOH PALING UMUM: METHOD main()
 * ------------------------------------------------------------------------
 * 
 * Method main() dibuat static karena harus dipanggil oleh JVM
 * sebelum ada object yang dibuat.
 * 
 *     public static void main(String[] args) {
 *         // ...
 *     }
 * 
 * ------------------------------------------------------------------------
 * STATIC VARIABLE
 * ------------------------------------------------------------------------
 * 
 * Jika sebuah instance variable dibuat static, maka variabel itu
 * pada dasarnya menjadi seperti global variable untuk class tersebut.
 * 
 * Ketika object dari class dibuat:
 * - Tidak dibuat salinan baru dari static variable
 * - Semua object berbagi satu static variable yang SAMA
 * 
 * Contoh:
 * 
 *     class Counter {
 *         static int count = 0;  // static variable
 *         int instanceId;
 * 
 *         Counter() {
 *             count++;           // semua object berbagi count yang sama
 *             instanceId = count;
 *         }
 *     }
 * 
 *     Counter c1 = new Counter(); // count = 1
 *     Counter c2 = new Counter(); // count = 2
 *     Counter c3 = new Counter(); // count = 3
 * 
 *     // count bernilai 3 untuk SEMUA object
 * 
 * ------------------------------------------------------------------------
 * STATIC METHOD
 * ------------------------------------------------------------------------
 * 
 * Method static bisa dipanggil tanpa membuat object.
 * 
 *     class MathUtils {
 *         static int tambah(int a, int b) {
 *             return a + b;
 *         }
 * 
 *         static double kuadrat(double x) {
 *             return x * x;
 *         }
 *     }
 * 
 *     // Pemanggilan tanpa object
 *     int hasil = MathUtils.tambah(5, 3);
 *     double pangkat = MathUtils.kuadrat(4.0);
 * 
 * ------------------------------------------------------------------------
 * PEMBATASAN METHOD STATIC
 * ------------------------------------------------------------------------
 * 
 * Method yang dideklarasikan sebagai static memiliki beberapa batasan:
 * 
 * 1. Method static hanya bisa langsung memanggil method static lain
 * 
 *     static void methodA() {
 *         methodB();        // BISA (static memanggil static)
 *         methodC();        // ERROR! Tidak bisa memanggil non-static
 *     }
 * 
 *     static void methodB() { }
 *     void methodC() { }
 * 
 * 2. Method static hanya bisa langsung mengakses data static
 * 
 *     static int dataStatic = 10;
 *     int dataNonStatic = 20;
 * 
 *     static void tampilkan() {
 *         System.out.println(dataStatic);   // BISA
 *         System.out.println(dataNonStatic); // ERROR!
 *     }
 * 
 * 3. Method static tidak bisa menggunakan this atau super
 * 
 *     static void method() {
 *         this.xxx = 10;   // ERROR! this tidak ada di konteks static
 *         super.xxx();     // ERROR! super tidak ada di konteks static
 *     }
 * 
 * ------------------------------------------------------------------------
 * STATIC BLOCK
 * ------------------------------------------------------------------------
 * 
 * Jika kamu perlu melakukan perhitungan atau proses tertentu untuk
 * menginisialisasi static variable, kamu bisa menggunakan static block.
 * 
 * Static block akan dijalankan SEKALI saja saat class pertama kali
 * dimuat oleh JVM (saat class loading).
 * 
 * Contoh:
 * 
 *     class DatabaseConfig {
 *         static String url;
 *         static String username;
 *         static String password;
 * 
 *         // Static block untuk inisialisasi
 *         static {
 *             url = "jdbc:mysql://localhost:3306/db";
 *             username = "root";
 *             password = "secret123";
 *             System.out.println("Static block dijalankan!");
 *         }
 *     }
 * 
 *     // Saat class DatabaseConfig pertama kali diakses,
 *     // static block akan dijalankan otomatis.
 * 
 * ------------------------------------------------------------------------
 * STATIC BISA DIPANGGIL TANPA OBJECT
 * ------------------------------------------------------------------------
 * 
 * Biasanya method dipanggil seperti ini:
 *     object.method();
 * 
 * Tapi kalau static:
 *     ClassName.method();
 * 
 * Contoh:
 * 
 *     // Non-static (butuh object)
 *     User user = new User();
 *     user.tampilkan();
 * 
 *     // Static (tanpa object)
 *     MathUtils.tambah(5, 3);
 * 
 * ------------------------------------------------------------------------
 * PERBEDAAN STATIC vs NON-STATIC
 * ------------------------------------------------------------------------
 * 
 * Fitur                 | Static                    | Non-Static
 * ----------------------|---------------------------|-----------------------------
 * Milik                 | Class                     | Object (instance)
 * Butuh object          | Tidak                     | Ya
 * Jumlah di memori      | 1 saja (shared)           | Tiap object punya sendiri
 * Cara akses            | ClassName.member          | object.member
 * Bisa akses non-static | Tidak langsung             | Bisa (via object)
 * Bisa akses static     | Bisa                      | Bisa
 * 
 * ------------------------------------------------------------------------
 * KAPAN MENGGUNAKAN STATIC?
 * ------------------------------------------------------------------------
 * 
 * Gunakan static jika:
 * 
 * 1. Data atau behavior bersifat SHARED untuk semua object
 *    - Counter, konfigurasi global
 * 
 * 2. Method tidak bergantung pada state object
 *    - Utility method (Math, Collections)
 * 
 * 3. Factory method (untuk membuat object)
 *    - getInstance(), create()
 * 
 * 4. Konstantanta yang tidak berubah
 *    - public static final int MAX_SIZE = 100;
 * 
 * ------------------------------------------------------------------------
 * STATIC vs INSTANCE: ANALOGI
 * ------------------------------------------------------------------------
 * 
 * Static = properti/cara class secara keseluruhan
 * Instance = properti/cara setiap object
 * 
 * Analogi:
 * - Class = cetakan kue
 * - Object = kue hasil cetakan
 * 
 * Static = resep kue (milik cetakan, sama untuk semua kue)
 * Non-static = topping kue (milik setiap kue, bisa beda-beda)
 * 
 * ------------------------------------------------------------------------
 * KESIMPULAN PENTING
 * ------------------------------------------------------------------------
 * 
 * Keyword static berarti:
 * - Member tersebut milik CLASS, bukan milik OBJECT
 * 
 * Karakteristik:
 * - Bisa diakses tanpa object
 * - Hanya ada satu di memori (shared)
 * - Dibagikan oleh semua object
 * - Dieksekusi/diinisialisasi saat class loading
 * 
 * ------------------------------------------------------------------------
 */

public class Static {

    // Demonstrasi static variable, method, dan block
    // static instance variabel
    static int a = 3;
    static int b;
    int c = 10;

    // contoh error karena mengakses c yang bukan static oleh methode static
    static void tampilkan() {
    //    c = 0; ini akan error, karena c bukan static
    }

    // methode static
    static void meth(int x) {

        System.out.println("x = " + x);
        System.out.println("x = " + a);
        System.out.println("x = " + b);
    }

    // static block
    static {

        System.out.println("Static block initialized.");
        b = a * 4;
    }

    public static void main(String[] args) {

        // memanggil methode static
        meth(42); // bisa dipanggil tanpa objek di buat

        /**
         * Penjelasan Kode
         * 
         * static int a = 3;
         * Variable a adalah static variable.
         * Artinya:
         * milik class
         * bukan milik object
         *
         * static int b;
         * Variable static lain.
         * Belum diberi nilai.
         *
         * static void meth(int x)
         * Method static.
         * Bisa dipanggil tanpa object.
         *
         * static {
         *    System.out.println("Static block initialized.");
         *    b = a * 4;
         * }
         * 
         * Ini disebut static initialization block.
         * Block ini akan dijalankan:
         * sekali saja
         * ketika class pertama kali di-load oleh JVM
         *
         * main() juga static.
         * Karena JVM harus bisa menjalankannya tanpa membuat object terlebih dahulu.
         *
         * Alur Eksekusi Program
         * Urutan yang terjadi saat program dijalankan:
         * 1-Class di-load oleh JVM
         * Semua static dieksekusi.
         *
         * 2-Static variable diinisialisasi
         * a = 3
         *
         * 3-Static block dijalankan
         * Static block initialized.
         *
         * lalu
         * b = a * 4
         * b = 12
         *
         * 4-Method main() dipanggil
         * meth(42)
         *
         * 5-Method meth() berjalan
         * Output:
         * x = 42
         * a = 3
         * b = 12
         *
         * Output Program
         * Static block initialized.
         * x = 42
         * a = 3
         * b = 12
         */

        /**
         * Contoh Penting Supaya Benar-Benar Paham
         *
         * Misalnya kita punya class Mahasiswa.
         * class Mahasiswa {
         *
         *     String nama;
         *     static String kampus = "Universitas Indonesia";
         *
         * }
         *
         * Program:
         * Mahasiswa m1 = new Mahasiswa();
         * Mahasiswa m2 = new Mahasiswa();
         * m1.nama = "Andi";
         * m2.nama = "Budi";
         *
         * Memory:
         * m1.nama = Andi
         * m2.nama = Budi
         *
         * kampus = Universitas Indonesia
         * kampus hanya satu untuk semua object.
         */
    }
}
