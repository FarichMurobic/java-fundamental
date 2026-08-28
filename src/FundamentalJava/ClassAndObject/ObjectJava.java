package FundamentalJava.ClassAndObject;

/**
 * ---------------------------------------------------------------------------
 * OBJECT (INSTANCE DARI CLASS)
 * ---------------------------------------------------------------------------
 *
 * Object adalah wujud nyata (instance) yang dibuat berdasarkan
 * sebuah class..
 *
 * Jika class diibaratkan sebagai blueprint atau cetakan,
 * maka object adalah hasil nyata yang dibuat dari blueprint
 * tersebut.
 *
 * Analogi:
 *
 * Class
 * -> Cetakan Mobil
 *
 * Object
 * -> Mobil Avanza
 * -> Mobil BMW
 * -> Mobil Tesla
 *
 * Flow:
 *
 * Class (Blueprint)
 * -> Pembuatan Object
 * -> Object (Instance)
 *
 * ---------------------------------------------------------------------------
 * DECLARING OBJECTS
 * ---------------------------------------------------------------------------
 *
 * Seperti yang telah dipelajari sebelumnya, ketika kita membuat
 * sebuah class, kita sebenarnya sedang membuat tipe data baru.
 *
 * Contoh:
 *
 * class Box {
 * }
 *
 * Setelah class Box dibuat, Box dapat digunakan seperti tipe data
 * lainnya untuk mendeklarasikan variable.
 *
 * Contoh:
 *
 * Box mybox;
 *
 * Namun perlu dipahami:
 *
 * Deklarasi variable object tidak membuat object.
 *
 * Variable tersebut hanya mampu menyimpan reference yang nantinya
 * akan menunjuk ke object.
 *
 * ---------------------------------------------------------------------------
 * DUA LANGKAH MEMBUAT OBJECT
 * ---------------------------------------------------------------------------
 *
 * Untuk mendapatkan object dari sebuah class, terdapat dua langkah:
 *
 * Langkah 1:
 *
 * Deklarasikan reference variable.
 *
 * Contoh:
 *
 * Box mybox;
 *
 * Pada tahap ini:
 *
 * - Belum ada object yang dibuat.
 * - mybox hanya sebuah reference variable.
 *
 * Langkah 2:
 *
 * Buat object menggunakan operator new.
 *
 * Contoh:
 *
 * mybox = new Box();
 *
 * Setelah baris tersebut dijalankan:
 *
 * - Object dibuat di memory.
 * - Constructor dijalankan.
 * - Reference object disimpan ke mybox.
 *
 * Flow:
 *
 * Deklarasi Reference
 * -> Membuat Object Dengan new
 * -> Constructor Dijalankan
 * -> Reference Disimpan
 *
 * ---------------------------------------------------------------------------
 * OPERATOR new
 * ---------------------------------------------------------------------------
 *
 * Operator new digunakan untuk membuat object secara dinamis
 * saat program berjalan (runtime).
 *
 * Bentuk umum:
 *
 * variable = new ClassName();
 *
 * Contoh:
 *
 * Box mybox = new Box();
 *
 * Ketika perintah tersebut dijalankan, Java akan:
 *
 * - Mengalokasikan memory untuk object.
 * - Menjalankan constructor.
 * - Mengembalikan reference ke object.
 * - Menyimpan reference ke dalam variable.
 *
 * Flow:
 *
 * new
 * -> Alokasi Memory
 * -> Menjalankan Constructor
 * -> Mengembalikan Reference
 * -> Disimpan Ke Variable
 *
 * ---------------------------------------------------------------------------
 * TIGA KOMPONEN PENTING
 * ---------------------------------------------------------------------------
 *
 * Dalam proses pembuatan object terdapat tiga komponen utama:
 *
 * - Reference Variable
 * - Object
 * - Memory
 *
 * Contoh:
 *
 * Box mybox;
 *
 * Pada tahap ini:
 *
 * mybox
 * -> Belum menunjuk object apa pun.
 *
 * Ketika:
 *
 * mybox = new Box();
 *
 * Java melakukan:
 *
 * - Membuat object Box di memory.
 * - Menghasilkan reference object.
 * - Menyimpan reference ke mybox.
 *
 * Diagram:
 *
 * mybox
 * |
 * v
 * [ Box Object ]
 * width
 * height
 * depth
 *
 * ---------------------------------------------------------------------------
 * APA ITU OBJECT REFERENCE?
 * ---------------------------------------------------------------------------
 *
 * Reference adalah nilai yang digunakan untuk menunjuk ke object
 * yang berada di memory.
 *
 * Secara konseptual, reference dapat dianggap sebagai alamat
 * object di memory.
 *
 * Namun Java tidak memperbolehkan programmer mengakses atau
 * memanipulasi alamat memory secara langsung seperti pada
 * bahasa C atau C++.
 *
 * Karena itu:
 *
 * mybox bukan object.
 *
 * mybox adalah reference yang menunjuk ke object.
 *
 * Flow:
 *
 * Reference Variable
 * -> Menunjuk Object
 * -> Mengakses Data Dan Method Object
 *
 * ---------------------------------------------------------------------------
 * DIAGRAM MEMORY (KONSEP PENTING)
 * ---------------------------------------------------------------------------
 *
 * Saat program berjalan:
 *
 * Stack Memory
 * -------------------------
 * mybox
 * |
 * | reference
 * v
 *
 * Heap Memory
 * -------------------------
 * Box Object
 * width = 10
 * height = 20
 * depth = 30
 *
 * Kesimpulan:
 *
 * - Reference biasanya berada di Stack.
 * - Object berada di Heap.
 *
 * Catatan:
 *
 * Ini adalah model konseptual untuk memahami cara kerja Java.
 * Implementasi JVM sebenarnya dapat berbeda tergantung vendor
 * dan optimisasi yang digunakan.
 *
 * ---------------------------------------------------------------------------
 * CLASS VS OBJECT
 * ---------------------------------------------------------------------------
 *
 * Salah satu konsep paling penting dalam OOP adalah membedakan
 * antara class dan object.
 *
 * Class:
 *
 * - Template.
 * - Blueprint.
 * - Konsep logis.
 *
 * Object:
 *
 * - Instance dari class.
 * - Memiliki data nyata.
 * - Menempati memory saat runtime.
 *
 * Flow:
 *
 * Class
 * -> Blueprint
 *
 * Object
 * -> Hasil Dari Blueprint
 *
 * ---------------------------------------------------------------------------
 * MENGAPA PRIMITIVE TYPE TIDAK MEMAKAI new?
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * int x = 10;
 * double y = 20.5;
 *
 * Primitive type tidak menggunakan operator new karena
 * primitive bukan object.
 *
 * Primitive dibuat untuk:
 *
 * - Lebih sederhana.
 * - Lebih cepat.
 * - Lebih efisien.
 *
 * Jika dibutuhkan versi object, Java menyediakan Wrapper Class.
 *
 * Contoh:
 *
 * int -> Integer
 * double -> Double
 * char -> Character
 * boolean -> Boolean
 *
 * ---------------------------------------------------------------------------
 * MEMORY DAN RUNTIME
 * ---------------------------------------------------------------------------
 *
 * Operator new bekerja saat runtime.
 *
 * Artinya jumlah object yang dibuat dapat berubah sesuai
 * kebutuhan program.
 *
 * Contoh:
 *
 * for (int i = 0; i < 100; i++) {
 * Box b = new Box();
 * }
 *
 * Saat program berjalan:
 *
 * - 100 object Box dibuat.
 *
 * Flow:
 *
 * Runtime
 * -> Menjalankan Loop
 * -> Membuat Object
 * -> Mengalokasikan Memory
 *
 * ---------------------------------------------------------------------------
 * RISIKO MEMORY HABIS
 * ---------------------------------------------------------------------------
 *
 * Karena setiap object membutuhkan memory,
 * pembuatan object dalam jumlah besar dapat menyebabkan
 * kehabisan memory.
 *
 * Jika JVM tidak dapat menyediakan memory yang cukup,
 * maka Java dapat menghasilkan:
 *
 * OutOfMemoryError
 *
 * Catatan:
 *
 * Ini bukan Exception.
 *
 * OutOfMemoryError termasuk kategori Error yang menunjukkan
 * masalah serius pada JVM.
 *
 * ---------------------------------------------------------------------------
 * OBJECT BISA DIBUAT DI MANA SAJA
 * ---------------------------------------------------------------------------
 *
 * Object dapat dibuat di berbagai tempat dalam program.
 *
 * Contohnya:
 *
 * - main()
 * - Method biasa
 * - Method yang mengembalikan nilai
 * - Constructor
 * - Static Method
 *
 * Selama menggunakan operator new, object dapat dibuat
 * di mana pun sesuai kebutuhan.
 *
 * ---------------------------------------------------------------------------
 * OBJECT DI DALAM METHOD void
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * class Mobil {
 *
 * void buatMesin() {
 *
 * Mesin m = new Mesin();
 *
 * System.out.println("Object Mesin Dibuat");
 * }
 *
 * }
 *
 * class Mesin {
 * }
 *
 * Pada contoh tersebut:
 *
 * Object Mesin dibuat di dalam method void.
 *
 * ---------------------------------------------------------------------------
 * OBJECT DI DALAM METHOD YANG MENGEMBALIKAN OBJECT
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * class Test {
 *
 * int a;
 *
 * Test(int a) {
 * this.a = a;
 * }
 *
 * Test tambahSepuluh() {
 *
 * Test temp = new Test(a + 10);
 *
 * return temp;
 * }
 *
 * }
 *
 * Pada contoh ini:
 *
 * - Object baru dibuat.
 * - Object dikembalikan menggunakan return.
 *
 * Teknik ini sangat umum dalam OOP modern.
 *
 * ---------------------------------------------------------------------------
 * OBJECT DI DALAM main()
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * public static void main(String[] args) {
 *
 * Test t = new Test(5);
 *
 * }
 *
 * Ini adalah tempat paling umum untuk membuat object
 * saat pertama kali belajar Java.
 *
 * ---------------------------------------------------------------------------
 * OBJECT DI DALAM CONSTRUCTOR
 * ---------------------------------------------------------------------------
 *
 * Constructor juga dapat membuat object lain.
 *
 * Contoh:
 *
 * class A {
 *
 * B b;
 *
 * A() {
 * b = new B();
 * }
 *
 * }
 *
 * class B {
 * }
 *
 * Saat object A dibuat:
 *
 * A obj = new A();
 *
 * Constructor A otomatis membuat object B.
 *
 * ---------------------------------------------------------------------------
 * RINGKASAN TEMPAT MEMBUAT OBJECT
 * ---------------------------------------------------------------------------
 *
 * Tempat Bisa Membuat Object
 *
 * main() Ya
 * Method void Ya
 * Method return value Ya
 * Constructor Ya
 * Static Method Ya
 *
 * Syarat utamanya:
 *
 * new ClassName()
 *
 * ---------------------------------------------------------------------------
 * INSIGHT PENTING
 * ---------------------------------------------------------------------------
 *
 * Saat menulis:
 *
 * Test ob = new Test();
 *
 * Banyak pemula mengira ob adalah object.
 *
 * Padahal:
 *
 * ob hanyalah reference.
 *
 * Visualisasi:
 *
 * ob (Reference)
 * |
 * v
 * Test Object (Heap)
 *
 * Yang benar:
 *
 * ob
 * -> Reference Variable
 *
 * Test Object
 * -> Object Sebenarnya
 *
 * Ini merupakan salah satu konsep paling fundamental
 * dalam Java dan Object-Oriented Programming.
 *
 * ---------------------------------------------------------------------------
 * ISTILAH PENTING
 * ---------------------------------------------------------------------------
 *
 * Class
 * -> Blueprint untuk membuat object.
 *
 * Object
 * -> Instance dari class.
 *
 * Reference
 * -> Penunjuk ke object.
 *
 * Heap Memory
 * -> Area memory tempat object disimpan.
 *
 * Stack Memory
 * -> Area memory tempat reference lokal biasanya disimpan.
 *
 * Constructor
 * -> Method khusus yang dijalankan saat object dibuat.
 *
 * Dynamic Allocation
 * -> Alokasi memory saat runtime menggunakan new.
 *
 * ---------------------------------------------------------------------------
 * KESIMPULAN
 * ---------------------------------------------------------------------------
 *
 * Object adalah instance nyata dari sebuah class yang dibuat
 * menggunakan operator new.
 *
 * Untuk membuat object terdapat dua langkah:
 *
 * - Mendeklarasikan reference variable.
 * - Membuat object menggunakan new.
 *
 * Java menggunakan reference untuk mengakses object sehingga
 * variable object sebenarnya tidak menyimpan object secara
 * langsung.
 *
 * Flow utama:
 *
 * Class
 * -> Deklarasi Reference
 * -> new
 * -> Object Dibuat Di Memory
 * -> Reference Menunjuk Ke Object
 *
 * Memahami hubungan antara:
 *
 * - Class
 * - Object
 * - Reference
 * - Memory
 *
 * merupakan fondasi paling penting dalam pemrograman Java
 * berbasis Object-Oriented Programming (OOP).
 */

// class Boxx
class Boxx {

    // INSTANCE VARIABEL
    double panjang;
    double lebar;
    double tinggi;

    // CONSTRUCTOR
    Boxx(double p, double l, double t) {
        panjang = p;
        lebar = l;
        tinggi = t;
    }

    // METHOD VOID
    void volume() {
        double hasil;
        hasil = panjang * lebar * tinggi / 6000;
        System.out.println(hasil);
    }
}

public class ObjectJava {
    public static void main(String[] args) {

        // MEMBUAT OBJEK
        Boxx box = new Boxx(17.1, 44.7, 78.9);
        // PANGGIL METHOD
        box.volume();

    }
}
