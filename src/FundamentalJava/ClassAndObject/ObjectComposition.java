package FundamentalJava.ClassAndObject;

    /**
     * Konsep Intinya
     *
     * Biasanya konstruktor nerima:
     * String nama, int umur
     *
     * Tapi kita juga bisa nerima:
     * ObjekLain obj
     *
     * Artinya:
     * Kita ngirim satu objek utuh ke dalam objek lain
     *
     * Hal Penting yang Sering Bikin Bingung
     * Ini bukan copy object
     * 
     * Contoh:
     * Mobil m = new Mobil(e);
     * m.engine itu referensi ke object yang sama
     *
     * Jadi kalau diubah:
     * e.tenaga = 200;
     *
     * otomatis:
     * m.engine.tenaga = 200;
     * Ini penting banget → pass by reference (lebih tepatnya reference value di Java)
     *
     * -----------------------------------------------------
     * 
     * Kesimpulan Penting
     * Konstruktor bisa nerima object sebagai parameter
     * Ini dipakai untuk:
     * menghubungkan class
     * bikin relasi antar object
     * Ini disebut:
     * composition (HAS-A)
     * Yang dikirim itu:
     * referensi, bukan copy
     */

    /**
     * Ini Namanya Apa?
     *
     * Ini disebut:
     * Object Composition (HAS-A relationship)
     *
     * Contoh:
     * Mobil punya Engine
     * Game punya Player
     * Kasir punya Transaksi
     *
     * Kenapa Gak Langsung Aja Int?
     * Misalnya:
     * jelek:
     *
     * class Mobil {
     *     int tenaga;
     * }
     *
     * lebih fleksibel:
     *
     * class Mobil {
     *     Engine engine;
     * }
     *
     * Kenapa?
     * Karena Engine bisa punya banyak data:
     * int tenaga;
     * String tipe;
     * boolean turbo;
     *
     * Jadi lebih scalable bro
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
