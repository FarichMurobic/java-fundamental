package ClassAndObject;

        /**
         * Object
         *
         * object adalah sesuatu nyata yang dihasilkan dari cetakan class.
         * 
         * Declaring Objects
         * Seperti yang sudah dijelaskan sebelumnya, ketika kamu membuat class, kamu sebenarnya membuat tipe data baru.
         * Tipe data ini bisa digunakan untuk mendeklarasikan object.
         * 
         * Namun, untuk mendapatkan object dari sebuah class ada dua langkah:
         * Langkah 1
         * Deklarasikan variable bertipe class tersebut.
         *
         * Tapi variable ini belum membuat object.
         * Variable ini hanya bisa menunjuk ke object.
         *
         * Langkah 2
         * Buat object sebenarnya menggunakan operator new.
         *
         * Operator new akan:
         * -membuat object di memory
         * -mengalokasikan memory saat program berjalan (runtime)
         * -mengembalikan reference ke object tersebut.
         *
         * Reference ini kira-kira seperti alamat memory object.
         * Reference ini kemudian disimpan di variable.
         *
         * Karena itu di Java:
         * semua object class dibuat secara dynamic allocation menggunakan new.
         *
         * --------------------------------------------------------------------
         * 
         * Contoh sebelumnya:
         * Box mybox = new Box();
         *
         * Ini sebenarnya menggabungkan dua langkah sekaligus.
         * Kalau dipisah menjadi:
         * Box mybox;         // deklarasi reference
         * mybox = new Box(); // membuat object
         *
         * --------------------------------------------------------------------
         * 
         * Ada 3 komponen penting.
         * 1 variable reference
         * 2 object
         * 3 memory
         *
         * Misalnya:
         * Box mybox;
         * 
         * Saat ini:
         * mybox → belum menunjuk apa pun
         * Belum ada object.
         * 
         * Ketika kita jalankan
         * mybox = new Box();
         *
         * Java melakukan:
         * 1️ membuat object Box di memory
         * 2️ mengambil alamat memory object
         * 3️ menyimpannya di mybox
         *
         * Diagram sederhana:
         * mybox ----------> [ Box object ]
         *                      panjang
         *                      lebar
         *                      tinggi
         *
         * Jadi sebenarnya:
         * mybox bukan object
         * mybox hanya reference ke object
         *
         * Ini konsep fundamental Java.
         *
         * Apa Itu Reference
         * Buku bilang:
         * reference kira-kira adalah alamat memory object
         *
         * Misalnya secara ilustrasi:
         * Object Box ada di memory address 0x105A
         *
         * maka:
         * mybox = 0x105A
         *
         * Jadi:
         * mybox → menunjuk ke object
         *
         * Makanya disebut:
         * object reference
         *
         * Kenapa Java Pakai Reference
         * Supaya memory lebih aman.
         *
         * Di Java kita tidak boleh mengutak-atik alamat memory langsung.
         * Ini beda dengan bahasa seperti:
         * C
         * C++
         */

        /**
         * Diagram Memory (Konsep Penting)
         * Ketika program jalan:
         *
         * Stack Memory
         * ----------------
         * mybox
         *   │
         *   │ reference
         *   ▼
         *
         * Heap Memory
         * ----------------
         * Box Object
         * panjang = 10
         *
         * Jadi:
         * mybox → menunjuk ke object di heap
         */

        /**
         * A Closer Look at new
         *
         * Operator new digunakan untuk mengalokasikan memory secara dinamis untuk sebuah object.
         * Bentuk umumnya:
         * classVar = new ClassName();
         *
         * Penjelasan:
         * classVar → variable bertipe class
         * ClassName → nama class yang ingin dibuat objectnya
         * () → memanggil constructor
         *
         * Constructor adalah bagian dari class yang menentukan apa yang terjadi saat object dibuat.
         * Sebagian besar class di dunia nyata memiliki constructor sendiri.
         * Namun jika kita tidak membuat constructor, maka Java akan otomatis membuatkan default constructor.
         * Contoh pada class Box sebelumnya.
         *
         * Kemudian muncul pertanyaan:
         * Kenapa kita tidak memakai new untuk int, char, dll?
         *
         * Jawabannya:
         * Karena primitive type bukan object.
         * Primitive type adalah variable biasa yang dibuat langsung di memory tanpa fitur object.
         * Ini dilakukan agar Java lebih efisien dan cepat.
         *
         * Java juga menyediakan versi object dari primitive type 
         * (misalnya Integer, Double, dll) jika kita membutuhkan fitur object.
         *
         * Hal penting lainnya:
         * new mengalokasikan memory saat program berjalan (runtime).
         * 
         * Artinya program bisa membuat:
         * -sedikit object
         * -atau banyak object
         * sesuai kebutuhan program.
         * 
         * Namun karena memory komputer terbatas, bisa saja new gagal membuat object jika memory habis.
         * Jika ini terjadi, Java akan menghasilkan runtime exception.
         *
         * Terakhir buku mengingatkan lagi:
         * Class vs Object
         * Class
         * hanya konsep logis
         * template atau blueprint
         *
         * Object
         * instance dari class
         * memiliki keberadaan fisik di memory
         *
         * Struktur new
         * Bentuk dasar:
         * variable = new ClassName();
         *
         * Contoh:
         * Box mybox = new Box();
         *
         * Langkah yang terjadi:
         * 1️ Java melihat class Box
         * 2️ Java membuat object Box di heap memory
         * 3️ Constructor dijalankan
         * 4️ Reference ke object diberikan ke mybox
         *
         * Diagram:
         * mybox ─────► [Box Object]
         *               panjang
         *               lebar
         *               tinggi
         *
         * new Mengalokasikan Memory Saat Runtime
         * Artinya object dibuat ketika program berjalan, bukan saat compile.
         * Contoh:
         *
         * for(int i = 0; i < 100; i++){
         *     Box b = new Box();
         * }
         *
         * Program membuat 100 object Box saat runtime.
         *
         * Risiko Memory Habis
         * Karena object dibuat di memory, bisa saja memory habis.
         */
   
        /**
         * PENTING!
         *
         * Object bisa dibuat di method apa saja.
         * Baik itu:
         * -void method
         * -method dengan return value
         * -bahkan constructor
         * -atau main()
         *
         * Yang penting: Java boleh membuat object di dalam method apa pun.
         * 
         * 1. Contoh Object Dibuat di Method void
         * Ini contoh paling sederhana.
         *
         * class Mobil {
         *
         *     void buatMobil() {
         * 
         *         // membuat object
         *         Mesin m = new Mesin();
         *         System.out.println("Object mesin dibuat");
         *     }
         * }
         *
         * class Mesin {}
         *
         * Di sini:
         * Mesin m = new Mesin();
         * Object dibuat di method void.
         * Jadi tidak perlu return object.
         *
         * 2. Object Dibuat di Method yang Mengembalikan Object
         * Ini contoh seperti di buku.
         *
         * class Test {
         *
         *     int a;
         *
         *     Test(int a) {
         *         this.a = a;
         *     }
         *
         *     Test tambahSepuluh() {
         *
         *         Test temp = new Test(a + 10);
         *         return temp;
         *     }
         * }
         *
         * Di sini:
         * object dibuat
         * lalu dikembalikan (return).
         * Ini sering dipakai jika kita ingin method menghasilkan object baru.
         *
         * 3. Object Dibuat di main()
         * Ini juga sangat umum.
         *
         * class Demo {
         *
         *     public static void main(String[] args) {
         *
         *         Test t = new Test(5);
         *
         *     }
         * }
         *
         * Object dibuat langsung di main().
         *
         * 4. Object Dibuat di Constructor
         * Bahkan constructor juga bisa membuat object lain.
         *
         * class A {
         *
         *     B b;
         *
         *     A() {
         *         b = new B();
         *     }
         * }
         *
         * class B {}
         *
         * Saat object A dibuat:
         * A obj = new A();
         *
         * Constructor A akan membuat object B.
         *
         * ----------------------------------------------------------
         * 
         * Ringkasan Cara Membuat Object
         * Object bisa dibuat di mana saja di dalam method.
         *
         * Tempat	                Bisa buat object
         * main()	                ya
         * method void	            ya
         * method return value	    ya
         * constructor	            ya
         * static method	        ya
         *
         * Yang penting hanya satu:
         * new ClassName()
         *
         * Hal Penting yang Perlu Lu Pahami
         * Membuat object = dua langkah
         * 1️ Deklarasi reference
         * Test ob;
         * 
         * 2️ Membuat object
         * ob = new Test();
         *
         * Biasanya digabung:
         * Test ob = new Test();
         *
         * -----------------------------------------------------
         * 
         * Insight Penting (Programmer Java Senior Tahu Ini)
         *
         * Sebenarnya saat lu menulis:
         * Test ob = new Test();
         * Yang terjadi:
         *
         * ob (stack)
         *    ↓
         * object Test (heap memory)
         *
         * Jadi:
         * ob = reference
         * object sebenarnya ada di heap
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
