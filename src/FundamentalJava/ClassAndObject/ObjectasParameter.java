package FundamentalJava.ClassAndObject;

/**
 * ---------------------------------------------------------------------------
 * USING OBJECTS AS PARAMETERS
 * ---------------------------------------------------------------------------
 *
 * Sejauh ini kita sering menggunakan tipe data sederhana
 * (primitive types) sebagai parameter method..
 *
 * Contoh:
 *
 * - int
 * - double
 * - char
 * - boolean
 *
 * Namun dalam Object-Oriented Programming (OOP), sangat umum dan
 * merupakan praktik yang benar untuk mengirim object sebagai
 * parameter method.
 *
 * Karena object merupakan representasi dari data dan perilaku,
 * object dapat berinteraksi dengan object lainnya melalui method.
 *
 * Flow:
 *
 * Object A
 * -> Memanggil Method
 * -> Mengirim Object B Sebagai Parameter
 * -> Method Memproses Object B
 *
 * ---------------------------------------------------------------------------
 * OBJECT SEBAGAI PARAMETER METHOD
 * ---------------------------------------------------------------------------
 *
 * Method di Java dapat menerima:
 *
 * - Primitive Type
 * - Object Reference
 *
 * Contoh parameter primitive:
 *
 * void tambah(int a) {
 * ...
 * }
 *
 * Contoh parameter object:
 *
 * void compare(Test t) {
 * ...
 * }
 *
 * Pada parameter object, yang sebenarnya dikirim bukan object
 * secara langsung, melainkan reference (referensi) ke object
 * tersebut.
 *
 * Karena Java menggunakan Call-by-Value:
 *
 * - Primitive -> Nilainya yang dicopy.
 * - Object -> Referencenya yang dicopy.
 *
 * Flow:
 *
 * Object Reference
 * -> Dicopy Ke Parameter Method
 * -> Kedua Reference Menunjuk Object Yang Sama
 *
 * ---------------------------------------------------------------------------
 * INVOKING OBJECT
 * ---------------------------------------------------------------------------
 *
 * Invoking Object adalah object yang digunakan untuk memanggil
 * suatu method.
 *
 * Contoh:
 *
 * ob1.equalTo(ob2);
 *
 * Pada contoh tersebut:
 *
 * - ob1 = Invoking Object
 * - ob2 = Parameter Object
 *
 * Visualisasi:
 *
 * ob1
 * -> Memanggil Method equalTo()
 * -> Mengirim ob2 Sebagai Parameter
 *
 * Flow:
 *
 * ob1
 * -> equalTo(ob2)
 * -> Method Menerima ob2
 * -> Melakukan Proses Perbandingan
 *
 * ---------------------------------------------------------------------------
 * KOMUNIKASI ANTAR OBJECT
 * ---------------------------------------------------------------------------
 *
 * Pengiriman object sebagai parameter merupakan salah satu dasar
 * komunikasi antar object dalam OOP.
 *
 * Dengan cara ini:
 *
 * - Object dapat membandingkan object lain.
 * - Object dapat memodifikasi object lain.
 * - Object dapat mengambil data dari object lain.
 * - Object dapat bekerja sama untuk menyelesaikan suatu tugas.
 *
 * Contoh:
 *
 * Rekening
 * -> Transfer Ke Rekening Lain
 *
 * Mahasiswa
 * -> Membandingkan Data Mahasiswa Lain
 *
 * Box
 * -> Membandingkan Ukuran Dengan Box Lain
 *
 * ---------------------------------------------------------------------------
 * OBJECT SEBAGAI PARAMETER CONSTRUCTOR
 * ---------------------------------------------------------------------------
 *
 * Selain digunakan pada method biasa, object juga dapat
 * digunakan sebagai parameter constructor.
 *
 * Tujuannya:
 *
 * - Membuat object baru berdasarkan object yang sudah ada.
 * - Menyalin nilai dari object lain.
 *
 * Teknik ini dikenal sebagai:
 *
 * Copy Constructor
 *
 * Flow:
 *
 * Object Lama
 * -> Dikirim Ke Constructor
 * -> Constructor Menyalin Data
 * -> Terbentuk Object Baru
 *
 * ---------------------------------------------------------------------------
 * COPY CONSTRUCTOR
 * ---------------------------------------------------------------------------
 *
 * Copy Constructor adalah constructor yang menerima object
 * dengan tipe yang sama sebagai parameter.
 *
 * Contoh:
 *
 * class Box {
 *
 * double width;
 * double height;
 * double depth;
 *
 * Box(Box ob) {
 * width = ob.width;
 * height = ob.height;
 * depth = ob.depth;
 * }
 *
 * }
 *
 * Pada contoh di atas:
 *
 * Constructor menerima object Box lain dan menyalin seluruh
 * nilai instance variable miliknya.
 *
 * ---------------------------------------------------------------------------
 * CARA KERJA COPY CONSTRUCTOR
 * ---------------------------------------------------------------------------
 *
 * Misalnya terdapat object:
 *
 * Box box1 = new Box();
 *
 * Kemudian:
 *
 * Box box2 = new Box(box1);
 *
 * Maka:
 *
 * - box1 sudah ada terlebih dahulu.
 * - box1 dikirim ke constructor.
 * - Constructor membaca data box1.
 * - Data disalin ke box2.
 *
 * Hasilnya:
 *
 * box1 dan box2 memiliki isi yang sama,
 * tetapi merupakan object yang berbeda.
 *
 * Visualisasi:
 *
 * box1
 * -> width = 10
 * -> height = 20
 * -> depth = 30
 *
 * Constructor Box(Box ob)
 * -> Menyalin Nilai
 *
 * box2
 * -> width = 10
 * -> height = 20
 * -> depth = 30
 *
 * ---------------------------------------------------------------------------
 * COPY CONSTRUCTOR BUKAN MENYALIN OBJECT
 * ---------------------------------------------------------------------------
 *
 * Hal penting yang sering disalahpahami:
 *
 * Copy Constructor tidak menyalin reference object.
 *
 * Copy Constructor menyalin isi data object.
 *
 * Contoh:
 *
 * Box box2 = new Box(box1);
 *
 * Setelah proses tersebut:
 *
 * box1 != box2
 *
 * karena keduanya adalah object yang berbeda.
 *
 * Yang sama hanyalah nilai dari instance variable-nya.
 *
 * ---------------------------------------------------------------------------
 * MANFAAT COPY CONSTRUCTOR
 * ---------------------------------------------------------------------------
 *
 * Copy Constructor sering digunakan untuk:
 *
 * - Membuat duplikat object.
 * - Mencegah perubahan pada object asli.
 * - Membuat salinan data sebelum diproses.
 * - Mendukung prinsip encapsulation.
 *
 * Dalam aplikasi nyata, Copy Constructor sering digunakan
 * ketika sebuah object perlu disalin tanpa membagikan reference
 * yang sama.
 *
 * ---------------------------------------------------------------------------
 * HUBUNGAN DENGAN CALL-BY-VALUE
 * ---------------------------------------------------------------------------
 *
 * Walaupun object dikirim sebagai parameter constructor,
 * Java tetap menggunakan mekanisme Call-by-Value.
 *
 * Yang dicopy adalah:
 *
 * - Reference Object
 *
 * Bukan:
 *
 * - Object Fisiknya
 *
 * Flow:
 *
 * Reference Object
 * -> Dicopy Ke Parameter Constructor
 * -> Constructor Mengakses Object Asli
 * -> Menyalin Data Ke Object Baru
 *
 * ---------------------------------------------------------------------------
 * ISTILAH PENTING
 * ---------------------------------------------------------------------------
 *
 * Invoking Object
 * -> Object yang memanggil method.
 *
 * Parameter Object
 * -> Object yang dikirim sebagai parameter.
 *
 * Object Reference
 * -> Alamat yang menunjuk ke object.
 *
 * Constructor
 * -> Method khusus untuk membuat object.
 *
 * Copy Constructor
 * -> Constructor yang menerima object sejenis
 * untuk menyalin data.
 *
 * Call-by-Value
 * -> Mekanisme pengiriman parameter di Java.
 *
 * ---------------------------------------------------------------------------
 * KESIMPULAN
 * ---------------------------------------------------------------------------
 *
 * Java memungkinkan object digunakan sebagai parameter method
 * maupun parameter constructor.
 *
 * Ketika object dikirim sebagai parameter:
 *
 * - Yang dikirim adalah reference object.
 * - Reference tersebut dicopy ke parameter method.
 * - Java tetap menggunakan Call-by-Value.
 *
 * Penggunaan object sebagai parameter merupakan dasar penting
 * dalam komunikasi antar object pada OOP.
 *
 * Salah satu penerapan paling umum adalah Copy Constructor,
 * yaitu constructor yang menerima object sejenis untuk
 * membuat salinan data dari object yang sudah ada.
 *
 * Flow utama materi ini:
 *
 * Object
 * -> Dikirim Sebagai Parameter
 * -> Method / Constructor Memproses Object
 * -> Terjadi Interaksi Antar Object
 *
 * Ini merupakan salah satu fondasi terpenting dalam
 * Object-Oriented Programming (OOP) di Java.
 */

// Contoh objek sebagai parameter di method
class Objek {
    int a, b;

    Objek(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // Object as parameter
    // returnnya harus objek juga!
    boolean equalTo(Objek objek) {
        if (objek.a == a && objek.b == b) {
            return true;
        } else {
            return false;
        }
    }
}

// Contoh objek sebagai parameter di konstruktor
// COPY CONSTRUCTOR
class Bok {
    double panjang;
    double lebar;
    double tinggi;

    // Konstruktor dengan parameter objek
    // COPY CONSTRUCTOR
    Bok(Bok ob) { // Objek as parameter
        panjang = ob.panjang;
        lebar = ob.lebar;
        tinggi = ob.tinggi;
    }

    // Konstruktor biasa
    Bok(double p, double l, double t) {
        this.panjang = p;
        this.lebar = l;
        this.tinggi = t;
    }

    // Konstruktor kosong (default)
    Bok() {
        panjang = -1;
        lebar = -1;
        tinggi = -1;
    }

    // Konstruktor untuk kubus
    Bok(double len) {
        panjang = lebar = tinggi = len;
    }

    // Method untuk menghitung volume
    double volume() {
        return panjang * lebar * tinggi;
    }
}

public class ObjectasParameter {
    public static void main(String[] args) {

        // Membuat object
        Objek objek1 = new Objek(10, 22);
        Objek objek2 = new Objek(10, 22);
        Objek objek3 = new Objek(-1, -1);

        // Ini gunanya object sebagai parameter methode.
        System.out.println("objek1 == objek2: " + objek1.equalTo(objek2)); // true
        System.out.println("objek1 == objek3: " + objek1.equalTo(objek3)); // false

        /**
         * Penjelasan Konsep
         *
         * Di program ini ada method:
         * equalTo(Objek objek)
         * Parameter objek bukan int atau double, tetapi object dari class Objek.
         *
         * Artinya method menerima object sebagai input.
         * 
         * Contoh:
         * Struktur class Test
         * 
         * class Test {
         *
         * int a, b;
         *
         * Class memiliki dua variabel:
         * a
         * b
         *
         * Constructor
         * Test(int i, int j)
         * Digunakan untuk memberi nilai pada object.
         *
         * Misalnya:
         * Test ob1 = new Test(100,22);
         *
         * Maka:
         * a = 100
         * b = 22
         * 
         * 4. Method equalTo()
         * boolean equalTo(Objek objek)
         *
         * Method ini menerima object Objek lain.
         *
         * Tujuannya:
         * membandingkan dua object
         *
         * Isi Method
         * if(objek.a == a && objek.b == b)
         *
         * Artinya:
         * nilai a dari object objek == nilai a object sekarang
         * DAN
         * nilai b dari object objek == nilai b object sekarang
         *
         * Jika sama:
         * return true
         *
         * Jika tidak:
         * return false
         */

        System.out.println("--------------------------------");

        // Copy constructor
        // Objek as parameter
        Bok bok1 = new Bok(10, 20, 15);
        Bok bok2 = new Bok();
        Bok kubus = new Bok(7);
        Bok clone = new Bok(bok1); // Copy constructor

        double vol;

        vol = bok1.volume();
        System.out.println("Box 1: " + vol);

        vol = bok2.volume();
        System.out.println("Box 2: " + vol);

        vol = kubus.volume();
        System.out.println("Kubus: " + vol);

        vol = clone.volume();
        System.out.println("Cloning: " + vol);

        /**
         * Penjelasan Copy Constructor
         *
         * Baris ini penting:
         * Box clone = new Bok(bok1);
         *
         * Artinya:
         * buat object baru
         * dengan nilai sama seperti bok1
         *
         * Isi constructor:
         * Bok(Bok ob)
         *
         * Menyalin nilai:
         * panjang = ob.panjang
         * lebar = ob.lebar
         * tinggi = ob.tinggi
         *
         * Jadi:
         * clone == copy bok1
         *
         * Kenapa Ini Penting di Dunia Nyata
         * 
         * Di Java profesional ini sering dipakai untuk:
         * copy object
         * clone data
         * transfer object antar method
         * design pattern
         */
    }
}
