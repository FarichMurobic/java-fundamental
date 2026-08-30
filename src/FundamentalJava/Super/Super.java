package FundamentalJava.Super;

/**
 * ------------------------------------------------------------------------
 * KEYWORD SUPER
 * ------------------------------------------------------------------------
 * 
 * Java menyediakan keyword super untuk:
 * Mengakses superclass dari subclass...
 * 
 * Ada 2 fungsi utama super:
 * 1. Memanggil constructor superclass → super()
 * 2. Mengakses member superclass → super.member
 * 
 * ------------------------------------------------------------------------
 * MASALAH SEBELUMNYA (TANPA SUPER)
 * ------------------------------------------------------------------------
 * 
 * Pada contoh sebelumnya, BoxWeight dibuat dengan cara yang tidak efisien.
 * 
 * class BoxWeight extends Box {
 * double weight;
 * 
 * BoxWeight(double w, double h, double d, double m) {
 * width = w; // Duplikasi!
 * height = h; // Duplikasi!
 * depth = d; // Duplikasi!
 * weight = m;
 * }
 * }
 * 
 * Kenapa ini buruk?
 * - Duplikasi kode (width, height, depth diisi ulang)
 * - Tidak efisien
 * - Melanggar encapsulation
 * - Superclass seharusnya bertanggung jawab atas member-nya sendiri
 * 
 * Seharusnya tugas Box, bukan BoxWeight.
 * 
 * ------------------------------------------------------------------------
 * SOLUSI: super() UNTUK MEMANGGIL CONSTRUCTOR SUPERCLASS
 * ------------------------------------------------------------------------
 * 
 * class BoxWeight extends Box {
 * double weight;
 * 
 * BoxWeight(double w, double h, double d, double m) {
 * super(w, h, d); // Panggil constructor Box
 * weight = m; // Hanya isi yang unik
 * }
 * }
 * 
 * ATURAN PALING PENTING:
 * super() HARUS menjadi baris PERTAMA di constructor.
 * 
 * ------------------------------------------------------------------------
 * ALUR KERJA super()
 * ------------------------------------------------------------------------
 * 
 * Contoh:
 * BoxWeight mybox = new BoxWeight(10, 20, 15, 34.3);
 * 
 * Step-by-step:
 * 
 * 1. Masuk constructor BoxWeight
 * 2. Langsung jalankan: super(10, 20, 15)
 * 3. Masuk constructor Box
 * 4. Set: width = 10, height = 20, depth = 15
 * 5. Kembali ke BoxWeight
 * 6. Set: weight = 34.3
 * 
 * Keuntungan:
 * - Tidak duplikasi kode
 * - Lebih bersih
 * - Mendukung encapsulation
 * - Subclass tidak perlu tahu detail superclass
 * 
 * ------------------------------------------------------------------------
 * SUPERCLASS TANPA DEFAULT CONSTRUCTOR
 * ------------------------------------------------------------------------
 * 
 * Jika superclass tidak memiliki default constructor (constructor tanpa
 * parameter),
 * maka subclass HARUS memanggil super() secara eksplisit.
 * 
 * class Box {
 * double width, height, depth;
 * 
 * // Hanya ada constructor dengan parameter
 * Box(double w, double h, double d) {
 * width = w;
 * height = h;
 * depth = d;
 * }
 * }
 * 
 * class BoxWeight extends Box {
 * double weight;
 * 
 * BoxWeight(double w, double h, double d, double m) {
 * super(w, h, d); // WAJIB! Karena Box tidak punya default constructor
 * weight = m;
 * }
 * }
 * 
 * ------------------------------------------------------------------------
 * BENTUK KEDUA: super.member UNTUK AKSES MEMBER SUPERCLASS
 * ------------------------------------------------------------------------
 * 
 * Bentuk kedua dari super digunakan seperti ini:
 * super.member
 * 
 * Di mana member bisa berupa:
 * - Variabel
 * - Method
 * 
 * Penggunaan ini dipakai ketika:
 * Subclass punya nama variabel/method yang SAMA dengan superclass.
 * 
 * Ini disebut:
 * name hiding (penyembunyian nama)
 * 
 * ------------------------------------------------------------------------
 * CONTOH NAME HIDING
 * ------------------------------------------------------------------------
 * 
 * class A {
 * int i;
 * }
 * 
 * class B extends A {
 * int i; // Menutupi (hide) i dari A
 * 
 * B(int a, int b) {
 * super.i = a; // Isi i milik A
 * i = b; // Isi i milik B
 * }
 * 
 * void show() {
 * System.out.println("i in superclass: " + super.i);
 * System.out.println("i in subclass: " + i);
 * }
 * }
 * 
 * public class UseSuper {
 * public static void main(String[] args) {
 * B subOb = new B(1, 2);
 * subOb.show();
 * }
 * }
 * 
 * ------------------------------------------------------------------------
 * ALUR PROGRAM
 * ------------------------------------------------------------------------
 * 
 * 1. Buat object:
 * B subOb = new B(1, 2);
 * 
 * 2. Masuk constructor B:
 * super.i = 1; // i di A = 1
 * i = 2; // i di B = 2
 * 
 * 3. Output:
 * i in superclass: 1
 * i in subclass: 2
 * 
 * ------------------------------------------------------------------------
 * PERBEDAAN super() vs super.member
 * ------------------------------------------------------------------------
 * 
 * Bentuk | Fungsi
 * -----------------|------------------------------------------
 * super() | Memanggil constructor superclass
 * super.variabel | Mengakses variabel superclass
 * super.method() | Memanggil method superclass
 * 
 * ------------------------------------------------------------------------
 * INTI PALING PENTING
 * ------------------------------------------------------------------------
 * 
 * super = akses ke versi superclass
 * 
 * Insight dalam:
 * - Subclass bisa punya "versi sendiri" dari variabel/method
 * - Tapi superclass tetap ada di dalam object
 * - super memungkinkan kita mengakses versi superclass
 * 
 * ------------------------------------------------------------------------
 * KAPAN super.member DIGUNAKAN?
 * ------------------------------------------------------------------------
 * 
 * Biasanya dipakai ketika:
 * - Nama sama (override/hiding)
 * - Ingin mengakses versi parent, bukan versi child
 * 
 * Contoh kasus:
 * - Method overriding: ingin memanggil method parent
 * - Name hiding: ingin akses variabel parent yang tertutupi
 * 
 * ------------------------------------------------------------------------
 * RINGKASAN SUPER
 * ------------------------------------------------------------------------
 * 
 * 1. super() → panggil constructor superclass (WAJIB di baris pertama)
 * 2. super.member → akses member superclass
 * 3. Menghindari duplikasi kode
 * 4. Menjaga encapsulation
 * 5. Subclass tidak perlu tahu detail superclass
 * 6. Ini adalah inti OOP yang benar
 * 
 * ------------------------------------------------------------------------
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
     * super(ob);
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
