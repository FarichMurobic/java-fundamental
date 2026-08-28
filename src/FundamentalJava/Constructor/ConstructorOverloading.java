package FundamentalJava.Constructor;

/**
 * ------------------------------------------------------------------------
 * OVERLOADING CONSTRUCTORS
 * ------------------------------------------------------------------------
 *
 * Selain method biasa, constructor juga dapat di-overload.
 * Bahkan, dalam pengembangan aplikasi nyata, penggunaan beberapa
 * constructor dalam satu class merupakan praktik yang sangat umum..
 *
 * Constructor Overloading memungkinkan sebuah class memiliki
 * lebih dari satu constructor dengan parameter yang berbeda.
 *
 * Perbedaan constructor dapat berupa:
 * - Jumlah parameter yang berbeda.
 * - Tipe parameter yang berbeda.
 * - Urutan parameter yang berbeda.
 *
 * Sama seperti method overloading, Java akan menentukan constructor
 * mana yang harus dipanggil berdasarkan argument yang diberikan saat
 * object dibuat.
 *
 * ------------------------------------------------------------------------
 * MENGAPA CONSTRUCTOR DI-OVERLOAD?
 * ------------------------------------------------------------------------
 *
 * Tujuannya adalah untuk memberikan beberapa cara dalam membuat
 * object sesuai kebutuhan.
 *
 * Misalnya sebuah class Box dapat dibuat dengan:
 *
 * - Tanpa parameter.
 * - Satu parameter.
 * - Tiga parameter.
 *
 * Contoh:
 *
 * new Box();
 * new Box(7);
 * new Box(10, 20, 30);
 *
 * Setiap pemanggilan tersebut dapat menggunakan constructor yang
 * berbeda.
 *
 * Flow:
 *
 * new Box() -> Constructor Tanpa Parameter
 *
 * new Box(7) -> Constructor Satu Parameter
 *
 * new Box(10, 20, 30) -> Constructor Tiga Parameter
 *
 * Java akan memilih constructor yang paling sesuai berdasarkan
 * argument yang diberikan.
 *
 * ------------------------------------------------------------------------
 * CONTOH KONSEP
 * ------------------------------------------------------------------------
 *
 * Misalkan terdapat class Box:
 *
 * class Box {
 *
 * double width;
 * double height;
 * double depth;
 *
 * Box() {
 * width = height = depth = 0;
 * }
 *
 * Box(double len) {
 * width = height = depth = len;
 * }
 *
 * Box(double w, double h, double d) {
 * width = w;
 * height = h;
 * depth = d;
 * }
 * }
 *
 * Cara penggunaan:
 *
 * Box b1 = new Box();
 * Box b2 = new Box(10);
 * Box b3 = new Box(10, 20, 30);
 *
 * Hasilnya:
 *
 * b1 -> menggunakan constructor pertama
 * b2 -> menggunakan constructor kedua
 * b3 -> menggunakan constructor ketiga
 *
 * ------------------------------------------------------------------------
 * BAGAIMANA JAVA MEMILIH CONSTRUCTOR?
 * ------------------------------------------------------------------------
 *
 * Saat object dibuat, Java akan melakukan pencocokan argument
 * dengan parameter constructor yang tersedia.
 *
 * Contoh:
 *
 * new Box()
 * -> cocok dengan Box()
 *
 * new Box(5)
 * -> cocok dengan Box(double len)
 *
 * new Box(10, 20, 30)
 * -> cocok dengan Box(double w, double h, double d)
 *
 * Jika tidak ditemukan constructor yang sesuai:
 *
 * Compile-Time Error
 *
 * ------------------------------------------------------------------------
 * KEUNTUNGAN CONSTRUCTOR OVERLOADING
 * ------------------------------------------------------------------------
 *
 * - Memberikan fleksibilitas saat membuat object.
 *
 * - Mengurangi kebutuhan membuat banyak method inisialisasi.
 *
 * - Membuat object langsung siap digunakan setelah dibuat.
 *
 * - Memungkinkan berbagai cara pembuatan object sesuai kebutuhan.
 *
 * - Meningkatkan keterbacaan dan kemudahan penggunaan class.
 *
 * ------------------------------------------------------------------------
 * KARAKTERISTIK PENTING CONSTRUCTOR
 * ------------------------------------------------------------------------
 *
 * Constructor bukan method biasa.
 *
 * Constructor memiliki karakteristik khusus:
 *
 * - Nama constructor harus sama dengan nama class.
 *
 * - Tidak memiliki return type, termasuk void.
 *
 * - Dipanggil secara otomatis saat object dibuat menggunakan new.
 *
 * - Dapat di-overload seperti method.
 *
 * - Tidak dapat diwariskan (inherited).
 *
 * ------------------------------------------------------------------------
 * HUBUNGAN DENGAN OOP
 * ------------------------------------------------------------------------
 *
 * Constructor Overloading merupakan salah satu bentuk
 * Polymorphism pada saat compile-time (Compile-Time Polymorphism).
 *
 * Java dapat memilih constructor yang berbeda berdasarkan
 * parameter yang diberikan saat proses kompilasi.
 *
 * Flow:
 *
 * Object Creation
 * -> Java Mencocokkan Parameter
 * -> Constructor yang Sesuai Dipilih
 * -> Object Diinisialisasi
 * -> Object Siap Digunakan
 *
 * ------------------------------------------------------------------------
 * PRAKTIK DI DUNIA NYATA
 * ------------------------------------------------------------------------
 *
 * Constructor overloading sangat sering digunakan pada:
 *
 * - Entity class.
 * - DTO (Data Transfer Object).
 * - Library Java.
 * - Framework seperti Spring.
 * - Class utility dan model data.
 *
 * Hampir semua class kompleks biasanya menyediakan beberapa
 * constructor agar object dapat dibuat dengan berbagai cara.
 *
 * ------------------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------------------
 *
 * Constructor Overloading adalah teknik membuat lebih dari satu
 * constructor dalam sebuah class dengan parameter yang berbeda.
 *
 * Java akan memilih constructor yang sesuai berdasarkan argument
 * yang diberikan saat object dibuat.
 *
 * Dengan constructor overloading, sebuah class dapat menyediakan
 * berbagai cara pembuatan object sehingga lebih fleksibel,
 * mudah digunakan, dan sesuai dengan prinsip Object-Oriented
 * Programming (OOP).
 */

public class ConstructorOverloading {
    // variabel instance
    double width;
    double height;
    double depth;

    // Konstruktor dengan parameter w,h,d
    ConstructorOverloading(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    // konstruktor tanpa parameter
    ConstructorOverloading() {
        width = -1;
        height = -1;
        depth = -1;
    }

    // konstruktor dengan parameter len
    ConstructorOverloading(double len) {
        width = height = depth = len;
    }

    // methode return value
    double volume() {
        return width * height * depth;
    }

    public static void main(String[] args) {

        // Membuat objek dan Konstruktor berbeda. ini yang disebut (Konstruktor
        // Overload).
        ConstructorOverloading box1 = new ConstructorOverloading(10, 20, 15);
        ConstructorOverloading box2 = new ConstructorOverloading();
        ConstructorOverloading box3 = new ConstructorOverloading(7);

        double vol;

        // volume box1
        vol = box1.volume();
        System.out.println("Volume box 1: " + vol);

        // volume box2
        vol = box2.volume();
        System.out.println("Volume box 2: " + vol);

        // volume box 3
        vol = box3.volume();
        System.out.println("Volume box 3: " + vol);
    }
}
