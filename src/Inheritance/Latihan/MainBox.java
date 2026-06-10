package Inheritance.Latihan;

/**
 * Sekarang kita lihat contoh yang lebih praktis untuk menunjukkan kekuatan inheritance.
 * Di sini, class Box dari chapter sebelumnya akan diperluas dengan menambahkan komponen keempat yaitu weight (berat).
 * Jadi class baru akan punya:
 * width (lebar)
 * height (tinggi)
 * depth (kedalaman)
 * weight (berat)
 *
 * Penjelasan
 * Ini inti inheritance:
 * Class lama → ditambah fitur baru tanpa ubah kode lama
 */

// SUPERCLASS
class Box {
    double width;
    double height;
    double depth;

    // constructor clone (copy object)
    Box(Box ob) {
        width = ob.width;
        height = ob.height;
        depth = ob.depth;
    }

    // constructor isi semua nilai
    Box(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    // constructor kososng
    Box() {
        width = -1;
        height = -1;
        depth = -1;
    }

    // construktor cube, semua sisi sama
    Box(double len) {
        width = height = depth = len;
    }

    // hitung volume
    double volume() {
        return width * height * depth;
    }

    /**
     * Penjelasan Penting
     * 
     * 1. Constructor Overloading
     * Box punya banyak constructor:
     * - Box()
     * - Box(w, h, d)
     * - Box(len)
     * - Box(Box ob)
     * Ini namanya overloading
     *
     * 2. Method volume()
     * return width * height * depth;
     *
     * Semua subclass nanti bisa pakai ini tanpa nulis ulang
     */

}

// Subclass
class BoxWeight extends Box {
    double weight; // berat box

    // constructor
    BoxWeight(double w, double h, double d, double m) {
        width = w;
        height = h;
        depth = d;
        weight = m;
    }

    /**
     * Penjelasan
     * 
     * Ini kunci penting:
     * class BoxWeight extends Box
     * 
     * Artinya:
     * BoxWeight = Box + tambahan weight
     * 
     * Hal penting:
     * Subclass tidak perlu bikin ulang:
     * - width
     * - height
     * - depth
     * - volume()
     *
     * Karena sudah diwarisi dari Box
     */
}

public class MainBox {
    public static void main(String[] args) {
        
        // MEMBUAT objek clas Boxweight
        BoxWeight myBox1 = new BoxWeight(10,20,15,34.3);
        BoxWeight myBox2 = new BoxWeight(2,3,4,0.076);

        double vol;

        vol = myBox1.volume();
        System.out.println("Volume of mybox1 is " + vol);
        System.out.println("Weight of mybox1 is " + myBox1.weight);

        System.out.println();

        vol = myBox2.volume();
        System.out.println("Volume of mybox2 is " + vol);
        System.out.println("Weight of mybox2 is " + myBox2.weight);

        /**
         * INTI KONSEP YANG HARUS LO PAHAM
         * 
         * 1. Reusability (guna ulang)
         * Nggak perlu bikin ulang kode lama
         * 
         * 2. Extend, bukan modify
         * Box tetap sama
         * BoxWeight nambah fitur
         *
         * Ini penting di dunia real project
         *
         * 3. Hierarki
         * Box → BoxWeight
         *
         * Bisa lanjut:
         * Box → BoxWeight → BoxShipping → dll
         *
         * Keuntungan besar dari inheritance adalah setelah kita membuat superclass yang mendefinisikan atribut umum,
         * kita bisa membuat banyak subclass yang lebih spesifik.
         * Setiap subclass bisa menambahkan fitur uniknya sendiri. Inilah inti dari inheritance.
         *
         * ----------------------------------------------------------------------
         * 
         * RINGKASAN SUPER INTI
         * 
         * Inheritance itu:
         * Bikin class umum → turunin jadi class khusus
         * Superclass = general
         * Subclass = spesifik
         */

        /**
         * Variabel referensi dari superclass bisa menyimpan referensi ke objek subclass.
         * 
         * Artinya:
         * Superclass ref = object subclass
         * Ini sangat berguna dalam banyak situasi.
         *
         * BAGIAN PALING PENTING
         * 
         * Baris kunci:
         * plainbox = weightbox;
         *
         * Artinya:
         * Box (superclass) ← BoxWeight (subclass)
         * 
         * ------------------------------------
         * 
         * Analogi biar kebayang
         *
         * Bayangin:
         * Box = Kendaraan
         * BoxWeight = Mobil
         * Kendaraan kendaraan = Mobil;
         * Masuk akal kan? Mobil itu kendaraan.
         *
         * ----------------------------------------
         * 
         * ATURAN PENTING BANGET
         * 
         * Yang menentukan akses itu:
         * TIPE REFERENSI, bukan tipe objek
         * 
         * Ini inti banget:
         * Box plainbox = weightbox;
         * 
         * Walaupun:
         * object = BoxWeight
         * 
         * Tapi:
         * yang dilihat Java = Box
         *
         * KENAPA volume() BISA, weight TIDAK?
         * 
         * Ini boleh:
         * plainbox.volume();
         *
         * Karena:
         * volume() ada di class Box
         *
         * Ini tidak boleh:
         * plainbox.weight;
         *
         * Karena:
         * Box TIDAK punya weight
         *
         * ---------------------------------
         * 
         * ALUR KERJA DI PROGRAM
         * 
         * 1. Buat object
         * weightbox = BoxWeight
         * plainbox = Box
         *
         * 2. Assign
         * plainbox = weightbox;
         * 
         * Sekarang:
         * plainbox → menunjuk ke object BoxWeight
         *
         * 3. Akses method
         * plainbox.volume(); 
         * plainbox.weight 
         *
         * -------------------------------------
         * 
         * RINGKASAN SUPER INTI
         *
         * Rumus yang harus lo inget:
         * Superclass ref = Subclass object 
         * Yang bisa diakses = milik superclass
         *
         * INTI PALING DALAM
         * 
         * Java itu:
         * "Melihat dari tipe variabel, bukan isi objek"
         *
         * Bukan superclass-nya yang tidak bisa akses,
         * tapi REFERENSI bertipe superclass tidak bisa mengakses member milik subclass.
         * Referensi bertipe superclass hanya bisa akses member milik superclass
         *
         * INTI PALING DALAM (WAJIB NANCEP)
         * Object = apa yang sebenarnya ada
         * Reference = cara kita melihat object itu
         *
         * Java pakai:
         * Reference untuk menentukan akses
         *
         * -----------------------------------------------
         * 
         * RINGKASAN FINAL
         * 
         * Boleh:
         * Superclass ref = Subclass object
         *
         * Tidak boleh:
         * Akses member subclass lewat reference superclass
         */

        // MEMBUAT objek kelas Box
        Box plainbox = new Box();

        double voll;

        // PAKAI object BoxWeight
        voll = myBox1.volume();
        System.out.println("volume of weight box is: " + voll);
        System.out.println("weight of weightbox is: " + myBox1.weight);

        System.out.println();

        // ini bagian penting
        plainbox = myBox1;

        voll = plainbox.volume(); // boleh
        System.out.println("volume of plain box is: " + voll);

        // ERROR kalau diaktifkan
        // System.out.println(plainbox.weight);

    }
}
