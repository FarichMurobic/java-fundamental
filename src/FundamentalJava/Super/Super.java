package FundamentalJava.Super;

    /**
     * Di contoh sebelumnya, BoxWeight belum dibuat dengan efisien.
     * Kenapa?
     * Karena:
     * Dia ngisi ulang width, height, depth sendiri
     *
     * Padahal itu sudah ada di superclass (Box)
     * Ini bikin:
     * - duplikasi kode 
     * - tidak efisien 
     * - melanggar encapsulation 
     *
     * Masalah sebelumnya:
     * width = w;
     * height = h;
     * depth = d;
     *
     * Ini seharusnya tugas Box, bukan BoxWeight
     *
     * SOLUSI: super
     * Java menyediakan keyword super untuk:
     * Mengakses superclass dari subclass
     *
     * Ada 2 fungsi super
     * 1. Panggil constructor superclass
     * super(arg);
     * 2. Akses member superclass
     *
     * --------------------------------
     * 
     * ATURAN PALING PENTING
     * super() HARUS jadi baris pertama di constructor
     *
     * CONTOH PERBAIKAN (VERSI BENAR)
     * class BoxWeight extends Box {
     *   double weight;
     *
     *   BoxWeight(double w, double h, double d, double m) {
     *     super(w, h, d); // panggil constructor Box
     *     weight = m;     // hanya isi yang unik
     *   }
     * }
     *
     * Ini yang terjadi:
     * super(w,h,d)
     * ↓
     * masuk ke constructor Box
     * ↓
     * width, height, depth di-set di sana
     *
     * Jadi:
     * BoxWeight TIDAK perlu set ulang
     *
     * KEUNTUNGAN super
     * 1. Tidak duplikasi kode
     * 2. Lebih bersih
     * 3. Mendukung encapsulation
     *
     * ALUR KERJA super()
     * Contoh:
     * BoxWeight mybox = new BoxWeight(10,20,15,34.3);
     * Step-by-step:
     * Masuk constructor BoxWeight
     * Langsung:
     * super(10,20,15);
     * Masuk constructor Box
     * Set:
     * width, height, depth
     * Balik ke BoxWeight
     * Set:
     * weight
     *
     * Kalau superclass tidak punya default constructor:
     * HARUS pakai super(...)
     *
     * RINGKASAN SUPER INTI
     * Fungsi utama super:
     * 1. Panggil constructor superclass
     * 2. Hindari duplikasi kode
     * 3. Jaga encapsulation
     *
     * Aturan emas:
     * super() HARUS di baris pertama
     * Insight penting:
     * Subclass tidak perlu tahu detail superclass
     *
     * Ini inti OOP yang bener.
     */

    /**
     * Bentuk kedua dari super digunakan seperti ini:
     * super.member
     * Di mana member bisa berupa:
     * variabel
     * method
     *
     * Penggunaan ini dipakai ketika:
     * Subclass punya nama variabel/method yang SAMA dengan superclass
     *
     * Ini disebut:
     * name hiding (penyembunyian nama)
     *
     * Masalahnya:
     * Kalau subclass punya nama yang sama:
     *
     * class A {
     *     int i;
     * }
     *
     * class B extends A {
     *     int i; // ❗ menimpa (hide) i dari A
     * }
     *
     * Sekarang ada 2 variabel i:
     * i milik A
     * i milik B
     *
     * Pertanyaannya:
     * Kalau di B kita tulis:
     * i
     *
     * Itu yang mana?
     * Jawab:
     * Yang di B (subclass)
     *
     * Nah di sinilah super dipakai
     * super.i
     *
     * Artinya:
     * Ambil i dari superclass (A)
     *
     * class A {
     *   int i;
     * }
     *
     * class B extends A {
     *   int i; // ini menutupi i dari A
     *
     *   B(int a, int b) {
     *     super.i = a; // isi i milik A
     *     i = b;       // isi i milik B
     *   }
     *
     *   void show() {
     *     System.out.println("i in superclass: " + super.i);
     *     System.out.println("i in subclass: " + i);
     *   }
     * }
     *
     * class UseSuper {
     *   public static void main(String args[]) {
     *     B subOb = new B(1, 2);
     *     subOb.show();
     *   }
     * }
     *
     * ALUR PROGRAM
     * 1. Buat object
     * B subOb = new B(1, 2);
     * 2. Masuk constructor B
     * super.i = 1; // i di A = 1
     * i = 2;       // i di B = 2
     * 3. Output
     * i in superclass: 1
     * i in subclass: 2
     *
     * PERBEDAAN super() vs super.member
     * Bentuk	        Fungsi
     * super()	        panggil constructor
     * super.x	        akses variabel parent
     * super.method()	panggil method parent
     *
     * INTI PALING PENTING
     * super = akses ke versi superclass
     * Insight dalam:
     * Subclass bisa punya "versi sendiri"
     * tapi superclass tetap ada di dalam object
     *
     * KAPAN super.member DIPAKAI?
     * Biasanya dipakai kalau:
     * nama sama (override/hiding)
     * mau akses versi parent
     */

class Box {
    private double width;
    private double height;
    private double depth;

    Box(Box ob) {
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }

    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    Box() {
        width = -1;
        height = -1;
        depth = -1;
    }

    Box(double len) {
        width = height = depth = len;
    }

    double volume() {
        return width * height * depth;
    }

    /**
     * Perubahan penting:
     * private double width;
     * Sekarang:
     * Subclass TIDAK bisa akses langsung
     */
}

class BoxWeight extends Box {
    double weight;

    // clone
    BoxWeight(BoxWeight ob) {
        super(ob); // kirim object ke Box
        weight = ob.weight;
    }

    // full parameter
    BoxWeight(double w, double h, double d, double m) {
        super(w, h, d);
        weight = m;
    }

    // default
    BoxWeight() {
        super();
        weight = -1;
    }

    // cube
    BoxWeight(double len, double m) {
        super(len);
        weight = m;
    }

    /**
     * Ini yang keren:
     * BoxWeight(BoxWeight ob) {
     *     super(ob);
     * }
     *
     * ob itu:
     * BoxWeight
     * 
     * Tapi diterima oleh:
     * Box(Box ob)
     * 
     * Kenapa bisa?
     * Karena:
     * BoxWeight IS-A Box
     * 
     * Jadi:
     * Subclass object bisa dipakai sebagai superclass
     */
}

public class Super {

}
