package FundamentalJava.Constructor;

/**
 * ------------------------------------------------------------------------
 * INVOKING OVERLOADED CONSTRUCTORS WITH this()
 * ------------------------------------------------------------------------
 *
 * Ketika sebuah class memiliki beberapa constructor
 * (Constructor Overloading), Java menyediakan mekanisme
 * untuk memanggil constructor lain yang berada dalam
 * class yang sama..
 *
 * Mekanisme tersebut menggunakan:
 *
 * this(argument-list);
 *
 * Penggunaan this() memungkinkan sebuah constructor
 * mendelegasikan proses inisialisasi kepada constructor
 * lain sehingga kode menjadi lebih ringkas dan mudah
 * dikelola.
 *
 * ------------------------------------------------------------------------
 * KONSEP DASAR this()
 * ------------------------------------------------------------------------
 *
 * this() digunakan untuk memanggil constructor lain
 * yang berada dalam class yang sama.
 *
 * Flow:
 *
 * Constructor A
 * -> Memanggil Constructor B dengan this(...)
 * -> Constructor B Melakukan Inisialisasi
 * -> Kembali ke Constructor A
 * -> Object Selesai Dibuat
 *
 * Dengan kata lain:
 *
 * this() = Memanggil Constructor Dalam Class Yang Sama
 *
 * Berbeda dengan:
 *
 * super() = Memanggil Constructor Milik Parent Class
 *
 * ------------------------------------------------------------------------
 * MENGAPA this() DIPERLUKAN?
 * ------------------------------------------------------------------------
 *
 * Tanpa this(), sering terjadi duplikasi kode pada
 * beberapa constructor yang memiliki proses inisialisasi
 * yang mirip.
 *
 * Contoh masalah:
 *
 * class MyClass {
 *
 * int a;
 * int b;
 *
 * MyClass(int i, int j) {
 * a = i;
 * b = j;
 * }
 *
 * MyClass(int i) {
 * a = i;
 * b = i;
 * }
 *
 * MyClass() {
 * a = 0;
 * b = 0;
 * }
 * }
 *
 * Pada contoh di atas:
 *
 * - Logic inisialisasi tersebar di beberapa constructor.
 * - Kode menjadi lebih panjang.
 * - Maintenance menjadi lebih sulit.
 * - Perubahan harus dilakukan di banyak tempat.
 *
 * ------------------------------------------------------------------------
 * SOLUSI MENGGUNAKAN this()
 * ------------------------------------------------------------------------
 *
 * Dengan this(), seluruh proses inisialisasi dapat
 * dipusatkan pada satu constructor utama.
 *
 * Contoh:
 *
 * class MyClass {
 *
 * int a;
 * int b;
 *
 * MyClass(int i, int j) {
 * a = i;
 * b = j;
 * }
 *
 * MyClass(int i) {
 * this(i, i);
 * }
 *
 * MyClass() {
 * this(0, 0);
 * }
 * }
 *
 * Flow:
 *
 * new MyClass()
 * -> this(0, 0)
 * -> MyClass(int i, int j)
 * -> Inisialisasi Object
 *
 * new MyClass(5)
 * -> this(5, 5)
 * -> MyClass(int i, int j)
 * -> Inisialisasi Object
 *
 * Dengan pendekatan ini:
 *
 * - Seluruh logic inisialisasi berada di satu tempat.
 * - Mengurangi duplikasi kode.
 * - Mempermudah maintenance.
 * - Mengurangi risiko bug.
 *
 * ------------------------------------------------------------------------
 * ANALOGI DUNIA NYATA
 * ------------------------------------------------------------------------
 *
 * Bayangkan sebuah formulir pendaftaran.
 *
 * Tanpa this():
 *
 * - Mengisi formulir lengkap berkali-kali.
 *
 * Dengan this():
 *
 * - Ada satu formulir utama.
 * - Formulir lain cukup meneruskan data ke formulir utama.
 *
 * Flow:
 *
 * Form Sederhana
 * -> Kirim Data Ke Form Utama
 * -> Proses Dilakukan Sekali
 * -> Hasil Digunakan Bersama
 *
 * ------------------------------------------------------------------------
 * KEUNTUNGAN MENGGUNAKAN this()
 * ------------------------------------------------------------------------
 *
 * - Mengurangi duplikasi kode (Code Duplication).
 *
 * - Memusatkan logic inisialisasi (Centralized Initialization).
 *
 * - Meningkatkan keterbacaan kode.
 *
 * - Mempermudah maintenance.
 *
 * - Mengurangi kemungkinan inkonsistensi antar constructor.
 *
 * ------------------------------------------------------------------------
 * RULE PENTING this() (WAJIB PAHAM)
 * ------------------------------------------------------------------------
 *
 * 1. this() HARUS menjadi statement pertama
 * di dalam constructor.
 *
 * Benar:
 *
 * MyClass(int i) {
 * this(i, i);
 * }
 *
 * Salah:
 *
 * MyClass(int i) {
 * a = 5;
 * this(i, i); // Compile-Time Error
 * }
 *
 * ------------------------------------------------------------------------
 *
 * 2. Tidak boleh ada statement sebelum this().
 *
 * Karena constructor tujuan harus dijalankan terlebih dahulu
 * sebelum constructor saat ini melanjutkan eksekusi.
 *
 * ------------------------------------------------------------------------
 *
 * 3. Constructor tidak boleh memanggil dirinya sendiri.
 *
 * Salah:
 *
 * MyClass() {
 * this();
 * }
 *
 * Hal ini menyebabkan:
 *
 * Recursive Constructor Invocation
 *
 * yang menghasilkan Compile-Time Error.
 *
 * ------------------------------------------------------------------------
 *
 * 4. this() dan super() tidak dapat digunakan
 * secara bersamaan dalam constructor yang sama.
 *
 * Salah:
 *
 * MyClass() {
 * super();
 * this(0);
 * }
 *
 * Karena:
 *
 * - super() harus menjadi statement pertama.
 * - this() juga harus menjadi statement pertama.
 *
 * Akibatnya keduanya tidak bisa digunakan bersama.
 *
 * ------------------------------------------------------------------------
 *
 * 5. this() hanya dapat digunakan di constructor.
 *
 * Tidak dapat digunakan di method biasa.
 *
 * ------------------------------------------------------------------------
 * HUBUNGAN DENGAN super()
 * ------------------------------------------------------------------------
 *
 * this()
 * -> Memanggil Constructor Dalam Class Yang Sama
 *
 * super()
 * -> Memanggil Constructor Parent Class
 *
 * Flow:
 *
 * Child Constructor
 * -> super(...)
 * -> Parent Constructor
 *
 * atau
 *
 * Child Constructor
 * -> this(...)
 * -> Constructor Lain Dalam Child
 *
 * ------------------------------------------------------------------------
 * PERFORMA DAN OVERHEAD
 * ------------------------------------------------------------------------
 *
 * Secara teknis, penggunaan this() menambahkan satu
 * pemanggilan constructor tambahan.
 *
 * Namun pada JVM modern, overhead ini sangat kecil
 * dan hampir tidak pernah menjadi masalah nyata.
 *
 * Dalam praktik pengembangan profesional:
 *
 * - Keterbacaan kode jauh lebih penting.
 * - Maintainability jauh lebih penting.
 *
 * Karena itu penggunaan this() sangat dianjurkan
 * ketika terdapat logic inisialisasi yang berulang.
 *
 * ------------------------------------------------------------------------
 * PRAKTIK MODERN JAVA
 * ------------------------------------------------------------------------
 *
 * Dalam Java modern, penggunaan this() merupakan
 * praktik yang umum dan direkomendasikan ketika:
 *
 * - Class memiliki banyak constructor.
 *
 * - Terdapat logic inisialisasi yang sama.
 *
 * - Ingin menghindari code duplication.
 *
 * - Ingin menerapkan prinsip DRY
 * (Don't Repeat Yourself).
 *
 * ------------------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------------------
 *
 * this() digunakan untuk memanggil constructor lain
 * dalam class yang sama.
 *
 * Tujuan utamanya adalah:
 *
 * - Mengurangi duplikasi kode.
 * - Memusatkan logic inisialisasi.
 * - Mempermudah maintenance.
 * - Membuat constructor lebih konsisten.
 *
 * Rule paling penting:
 *
 * - this() harus menjadi statement pertama
 * di dalam constructor.
 *
 * - Tidak dapat digunakan bersama super().
 *
 * - Tidak boleh menyebabkan pemanggilan constructor
 * secara rekursif.
 *
 * Dalam praktik OOP modern, this() merupakan teknik
 * yang sangat umum digunakan untuk membuat desain
 * constructor yang lebih bersih, fleksibel, dan
 * mudah dipelihara.
 */

class Myclass {

    int a;
    int b;

    // konstruktor utama
    Myclass(int i, int j) {
        a = i;
        b = j;
    }

    // panggil konstruktor lain
    Myclass(int i) {
        this(i, i);
    }

    // default
    Myclass() {
        this(0);
    }

    // methode untuk menampilkan nilai
    void show() {
        System.out.println("a = " + a + ", b = " + b);
    }
}

public class InvokingOverloadedConstructorWithThis {
    public static void main(String[] args) {

        Myclass myclass1 = new Myclass(8);

        /**
         * Case 1:
         * MyClass mc = new MyClass(8);
         *
         * Alurnya:
         * MyClass(8)
         * → this(8, 8)
         * → MyClass(8, 8)
         *
         * yang jalan beneran cuma:
         * MyClass(int i, int j)
         */

        Myclass myclass2 = new Myclass();

        /**
         * Case 2:
         * MyClass mc2 = new MyClass();
         *
         * Alurnya:
         * MyClass()
         * → this(0)
         * → MyClass(0)
         * → this(0,0)
         * → MyClass(0,0)
         *
         * berantai
         */

        // pakai konstruktor (int, int)
        Myclass obj1 = new Myclass(5, 10);
        obj1.show();

        // pakai konstruktor (int)
        Myclass obj2 = new Myclass(7);
        obj2.show();

        // pakai konstruktor default
        Myclass obj3 = new Myclass();
        obj3.show();

        /**
         * Penjelasan Output
         * 
         * obj1
         * MyClass obj1 = new MyClass(5, 10);
         *
         * langsung ke:
         * MyClass(int i, int j)
         *
         * Output:
         * a = 5, b = 10
         *
         * obj2
         * MyClass obj2 = new MyClass(7);
         *
         * Alur:
         * MyClass(7)
         * → this(7,7)
         * → MyClass(7,7)
         *
         * Output:
         * a = 7, b = 7
         *
         * obj3
         * MyClass obj3 = new MyClass();
         *
         * Alur:
         * MyClass()
         * → this(0)
         * → MyClass(0)
         * → this(0,0)
         * → MyClass(0,0)
         *
         * Output:
         * a = 0, b = 0
         *
         * Output Lengkap
         * a = 5, b = 10
         * a = 7, b = 7
         * a = 0, b = 0
         *
         * ----------------------------------------------
         * 
         * Insight Penting
         * 
         * Semua constructor akhirnya ngumpul ke satu constructor utama
         *
         * Ini bikin:
         * kode rapi
         * gak duplikat
         * gampang maintain
         */

    }
}
