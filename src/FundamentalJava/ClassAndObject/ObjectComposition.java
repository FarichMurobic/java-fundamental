package FundamentalJava.ClassAndObject;

/**
 * ---------------------------------------------------------------------------
 * OBJECT SEBAGAI PARAMETER CONSTRUCTOR
 * ---------------------------------------------------------------------------
 *
 * Secara umum, constructor biasanya menerima nilai-nilai sederhana
 * (primitive type) atau data lain yang digunakan untuk
 * menginisialisasi object..
 *
 * Contoh:
 *
 * String nama
 * int umur
 * double gaji
 *
 * Namun, constructor juga dapat menerima object lain sebagai
 * parameter.
 *
 * Contoh:
 *
 * class Mobil {
 *
 * Engine engine;
 *
 * Mobil(Engine engine) {
 * this.engine = engine;
 * }
 *
 * }
 *
 * Pada contoh tersebut, constructor Mobil menerima sebuah object
 * Engine sebagai parameter.
 *
 * Flow:
 *
 * Object Engine
 * -> Dikirim Ke Constructor Mobil
 * -> Disimpan Ke Instance Variable
 * -> Mobil Memiliki Engine
 *
 * ---------------------------------------------------------------------------
 * KONSEP UTAMA
 * ---------------------------------------------------------------------------
 *
 * Ketika sebuah object dikirim ke constructor, yang dikirim
 * sebenarnya bukan object fisiknya.
 *
 * Java selalu menggunakan mekanisme:
 *
 * Call-by-Value
 *
 * Artinya:
 *
 * Yang dicopy adalah reference object.
 *
 * Bukan:
 *
 * Object itu sendiri.
 *
 * Misalnya:
 *
 * Engine e = new Engine();
 *
 * Mobil m = new Mobil(e);
 *
 * Visualisasi:
 *
 * e
 * -> Engine Object
 *
 * Constructor Mobil(e)
 * -> Reference Dicopy
 *
 * m.engine
 * -> Menunjuk Engine Object Yang Sama
 *
 * ---------------------------------------------------------------------------
 * HAL PENTING YANG SERING MEMBINGUNGKAN
 * ---------------------------------------------------------------------------
 *
 * Banyak programmer pemula mengira bahwa saat object dikirim ke
 * constructor, Java otomatis membuat salinan object tersebut.
 *
 * Kenyataannya:
 *
 * Tidak ada proses copy object yang terjadi.
 *
 * Yang terjadi hanyalah:
 *
 * Reference object dikirim ke constructor dan disimpan.
 *
 * Akibatnya:
 *
 * e dan m.engine menunjuk object yang sama.
 *
 * Contoh:
 *
 * Engine e = new Engine();
 *
 * Mobil m = new Mobil(e);
 *
 * e.tenaga = 200;
 *
 * Maka:
 *
 * m.engine.tenaga = 200;
 *
 * karena keduanya menunjuk object Engine yang sama.
 *
 * Flow:
 *
 * e
 * -> Engine Object
 *
 * m.engine
 * -> Engine Object Yang Sama
 *
 * Ubah Engine
 * -> Perubahan Terlihat Dari Keduanya
 *
 * ---------------------------------------------------------------------------
 * JAVA BUKAN PASS-BY-REFERENCE
 * ---------------------------------------------------------------------------
 *
 * Ini merupakan salah satu konsep yang sering disalahpahami.
 *
 * Java bukan bahasa pemrograman Pass-by-Reference.
 *
 * Java selalu:
 *
 * Call-by-Value
 *
 * Namun untuk object:
 *
 * Yang dicopy adalah reference object.
 *
 * Karena reference hasil copy tetap menunjuk object yang sama,
 * perubahan pada object akan terlihat dari semua reference yang
 * mengarah ke object tersebut.
 *
 * Istilah yang lebih tepat:
 *
 * Reference Value
 *
 * atau
 *
 * Copy of Reference
 *
 * ---------------------------------------------------------------------------
 * OBJECT COMPOSITION (HAS-A RELATIONSHIP)
 * ---------------------------------------------------------------------------
 *
 * Penggunaan object sebagai parameter constructor sering digunakan
 * untuk membentuk hubungan antar object.
 *
 * Konsep ini disebut:
 *
 * Object Composition
 *
 * atau
 *
 * HAS-A Relationship
 *
 * Artinya:
 *
 * Sebuah object memiliki object lain sebagai bagian dari dirinya.
 *
 * Contoh:
 *
 * Mobil HAS-A Engine
 *
 * Game HAS-A Player
 *
 * Kasir HAS-A Transaksi
 *
 * Universitas HAS-A Mahasiswa
 *
 * Flow:
 *
 * Object A
 * -> Memiliki Object B
 * -> Membentuk HAS-A Relationship
 *
 * ---------------------------------------------------------------------------
 * CONTOH COMPOSITION
 * ---------------------------------------------------------------------------
 *
 * class Engine {
 *
 * int tenaga;
 * String tipe;
 * boolean turbo;
 *
 * }
 *
 * class Mobil {
 *
 * Engine engine;
 *
 * Mobil(Engine engine) {
 * this.engine = engine;
 * }
 *
 * }
 *
 * Pada contoh tersebut:
 *
 * Mobil tidak menyimpan detail mesin secara langsung.
 *
 * Mobil menyimpan object Engine.
 *
 * ---------------------------------------------------------------------------
 * MENGAPA TIDAK MENYIMPAN DATA LANGSUNG?
 * ---------------------------------------------------------------------------
 *
 * Pendekatan kurang fleksibel:
 *
 * class Mobil {
 *
 * int tenaga;
 *
 * }
 *
 * Pendekatan yang lebih baik:
 *
 * class Mobil {
 *
 * Engine engine;
 *
 * }
 *
 * Mengapa?
 *
 * Karena Engine dapat berkembang tanpa mengubah struktur Mobil.
 *
 * Contoh:
 *
 * class Engine {
 *
 * int tenaga;
 * String tipe;
 * boolean turbo;
 * double kapasitasMesin;
 * int jumlahSilinder;
 *
 * }
 *
 * Mobil tetap menggunakan object Engine yang sama tanpa perlu
 * menambah banyak variable baru.
 *
 * ---------------------------------------------------------------------------
 * KEUNTUNGAN COMPOSITION
 * ---------------------------------------------------------------------------
 *
 * - Kode lebih modular.
 * - Lebih mudah dikembangkan.
 * - Mengurangi duplikasi data.
 * - Meningkatkan reusability.
 * - Lebih sesuai dengan desain OOP.
 *
 * Composition merupakan salah satu teknik yang paling sering
 * digunakan dalam aplikasi Java modern.
 *
 * ---------------------------------------------------------------------------
 * COMPOSITION VS INHERITANCE
 * ---------------------------------------------------------------------------
 *
 * Inheritance:
 *
 * IS-A Relationship
 *
 * Contoh:
 *
 * MobilListrik IS-A Kendaraan
 *
 * Composition:
 *
 * HAS-A Relationship
 *
 * Contoh:
 *
 * Mobil HAS-A Engine
 *
 * Flow:
 *
 * Inheritance
 * -> Pewarisan
 * -> IS-A
 *
 * Composition
 * -> Kepemilikan Object
 * -> HAS-A
 *
 * ---------------------------------------------------------------------------
 * ISTILAH PENTING
 * ---------------------------------------------------------------------------
 *
 * Constructor
 * -> Method khusus untuk membuat object.
 *
 * Object Reference
 * -> Referensi yang menunjuk ke object.
 *
 * Call-by-Value
 * -> Mekanisme pengiriman parameter Java.
 *
 * Composition
 * -> Hubungan kepemilikan object.
 *
 * HAS-A Relationship
 * -> Sebuah object memiliki object lain.
 *
 * Engine
 * -> Komponen yang dimiliki Mobil.
 *
 * ---------------------------------------------------------------------------
 * KESIMPULAN
 * ---------------------------------------------------------------------------
 *
 * Constructor dapat menerima object sebagai parameter sama
 * seperti menerima primitive type.
 *
 * Ketika object dikirim ke constructor:
 *
 * - Java tidak membuat copy object secara otomatis.
 * - Yang dikirim adalah copy dari reference object.
 * - Reference tersebut tetap menunjuk object yang sama.
 *
 * Teknik ini sering digunakan untuk membangun hubungan antar
 * object yang disebut:
 *
 * Composition (HAS-A Relationship)
 *
 * Composition memungkinkan suatu class memiliki object lain
 * sebagai bagian dari dirinya sehingga desain program menjadi
 * lebih modular, fleksibel, dan mudah dikembangkan.
 *
 * Flow utama:
 *
 * Object Dibuat
 * -> Dikirim Ke Constructor
 * -> Reference Disimpan
 * -> Terbentuk HAS-A Relationship
 * -> Object Bekerja Sama Dalam OOP
 */

class Engine {
    int tenaga;

    Engine(int tenaga) {
        this.tenaga = tenaga;
    }
}

class Mobil {

    // Objek sebagai atribut
    Engine engine;

    Mobil(Engine engine) { // Objek as parameter
        this.engine = engine;
    }

    void tampilkan() {
        System.out.println("Tenaga: " + engine.tenaga);
    }
}

public class ObjectComposition {
    public static void main(String[] args) {

        Engine e = new Engine(150); // Buat objek Engine
        Mobil m = new Mobil(e); // Kirim objek ke constructor

        m.tampilkan(); // 150

        // Ubah tenaga
        e.tenaga = 200;
        m.tampilkan(); // 200

        // Ubah tenaga
        m.engine.tenaga = 100;
        m.tampilkan(); // 100

        /**
         * Penjelasan
         * 
         * Alurnya:
         * Buat Engine → tenaga = 150
         * Kirim e ke constructor Mobil
         * Mobil simpan object itu
         *
         * Bisa akses:
         * engine.tenaga
         */
    }
}
