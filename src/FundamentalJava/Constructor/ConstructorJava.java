package FundamentalJava.Constructor;

/**
 * CONSTRUCTOR
 * ------------------------------------------------------------
 *
 * Constructor adalah member khusus dalam sebuah class yang
 * dijalankan secara otomatis ketika object dibuat.
 *
 * Tujuan utama constructor adalah menginisialisasi keadaan
 * awal (initial state) dari object sehingga object tersebut
 * langsung siap digunakan setelah proses pembuatan selesai.
 *
 * Constructor merupakan salah satu konsep paling penting dalam
 * Object-Oriented Programming (OOP) karena memungkinkan setiap
 * object memiliki nilai awal yang sesuai sejak pertama kali
 * dibuat.
 *
 * ------------------------------------------------------------
 * TUJUAN CONSTRUCTOR
 * ------------------------------------------------------------
 *
 * Constructor digunakan untuk:
 *
 * - Menginisialisasi instance variable.
 * - Menentukan nilai awal object.
 * - Menyiapkan object agar langsung siap digunakan.
 * - Memastikan object berada dalam kondisi yang valid setelah
 * dibuat.
 *
 * Flow:
 *
 * Object Dibuat
 * -> Constructor Dipanggil
 * -> Instance Variable Diinisialisasi
 * -> Object Siap Digunakan
 *
 * ------------------------------------------------------------
 * KAPAN CONSTRUCTOR DIJALANKAN?
 * ------------------------------------------------------------
 *
 * Setelah constructor didefinisikan, constructor akan dipanggil
 * secara otomatis saat object dibuat menggunakan operator:
 *
 * new
 *
 * Contoh:
 *
 * Box myBox = new Box();
 *
 * Flow:
 *
 * new Box()
 * -> Java Mengalokasikan Memory
 * -> Constructor Box() Dipanggil
 * -> Object Diinisialisasi
 * -> Reference Dikembalikan Ke myBox
 *
 * Constructor dieksekusi sebelum proses pembuatan object
 * benar-benar selesai.
 *
 * ------------------------------------------------------------
 * KARAKTERISTIK CONSTRUCTOR
 * ------------------------------------------------------------
 *
 * Constructor memiliki beberapa karakteristik khusus:
 *
 * - Nama constructor HARUS sama dengan nama class.
 * - Tidak memiliki return type.
 * - Tidak menggunakan keyword void.
 * - Dipanggil otomatis saat object dibuat.
 * - Dapat menerima parameter.
 * - Dapat di-overload (memiliki banyak versi constructor).
 *
 * ------------------------------------------------------------
 * ATURAN PENULISAN CONSTRUCTOR
 * ------------------------------------------------------------
 *
 * 1. Nama Constructor Harus Sama Dengan Nama Class
 *
 * Contoh:
 *
 * class Box {
 *
 * Box() {
 * }
 *
 * }
 *
 * Jika nama berbeda:
 *
 * class Box {
 *
 * Boxx() {
 * }
 *
 * }
 *
 * Maka itu bukan constructor,
 * melainkan method biasa.
 *
 * ------------------------------------------------------------
 * 2. Constructor Tidak Memiliki Return Type
 * ------------------------------------------------------------
 *
 * Salah:
 *
 * class Box {
 *
 * void Box() {
 * }
 *
 * }
 *
 * Karena:
 *
 * void Box()
 * -> Method Biasa
 *
 * Bukan constructor.
 *
 * Benar:
 *
 * class Box {
 *
 * Box() {
 * }
 *
 * }
 *
 * Constructor tidak memiliki:
 *
 * - int
 * - double
 * - String
 * - void
 *
 * ataupun tipe return lainnya.
 *
 * ------------------------------------------------------------
 * MENGAPA CONSTRUCTOR TIDAK MEMILIKI RETURN TYPE?
 * ------------------------------------------------------------
 *
 * Secara konsep, constructor tidak digunakan untuk
 * mengembalikan nilai seperti method biasa.
 *
 * Tugas constructor adalah:
 *
 * - Menginisialisasi object.
 * - Menyiapkan object.
 *
 * Setelah constructor selesai dijalankan,
 * Java akan mengembalikan reference object yang baru dibuat.
 *
 * Oleh karena itu constructor tidak membutuhkan
 * return type secara eksplisit.
 *
 * Catatan:
 *
 * Secara teknis constructor bukan method biasa dan tidak
 * memiliki return type sama sekali.
 *
 * Walaupun sering dijelaskan bahwa constructor memiliki
 * "implicit return type berupa class itu sendiri",
 * penjelasan modern Java lebih tepat menyatakan bahwa:
 *
 * Constructor bukan method dan tidak memiliki return type.
 *
 * ------------------------------------------------------------
 * ANALOGI DUNIA NYATA
 * ------------------------------------------------------------
 *
 * Bayangkan sebuah pabrik mobil.
 *
 * Saat mobil dibuat:
 *
 * - Mesin dipasang.
 * - Roda dipasang.
 * - Bensin diisi.
 * - Sistem elektronik diaktifkan.
 *
 * Setelah semua selesai:
 *
 * Mobil siap digunakan.
 *
 * Flow:
 *
 * Mobil Dibuat
 * -> Mesin Dipasang
 * -> Roda Dipasang
 * -> Bensin Diisi
 * -> Mobil Siap Digunakan
 *
 * Constructor bekerja dengan cara yang sama pada object.
 *
 * Saat object dibuat:
 *
 * - Variable diinisialisasi.
 * - Nilai awal diberikan.
 * - Kondisi object disiapkan.
 *
 * Sehingga object langsung siap digunakan.
 *
 * ------------------------------------------------------------
 * CONTOH SEDERHANA
 * ------------------------------------------------------------
 *
 * class Box {
 *
 * double width;
 * double height;
 * double depth;
 *
 * Box() {
 * width = 10;
 * height = 10;
 * depth = 10;
 * }
 *
 * }
 *
 * Saat object dibuat:
 *
 * Box myBox = new Box();
 *
 * Flow:
 *
 * new Box()
 * -> Constructor Box()
 * -> width = 10
 * -> height = 10
 * -> depth = 10
 * -> Object Siap Digunakan
 *
 * ------------------------------------------------------------
 * ISTILAH PENTING
 * ------------------------------------------------------------
 *
 * Constructor
 * -> Member khusus yang dijalankan saat object dibuat.
 *
 * Initialization
 * -> Proses memberikan nilai awal pada object.
 *
 * new
 * -> Operator untuk membuat object.
 *
 * Instance Variable
 * -> Variable yang dimiliki setiap object.
 *
 * Internal State
 * -> Kondisi atau data yang dimiliki object.
 *
 * ------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------
 *
 * Constructor adalah member khusus yang dipanggil secara
 * otomatis saat object dibuat menggunakan operator new.
 *
 * Tujuan utamanya adalah menginisialisasi keadaan awal object
 * sehingga object langsung siap digunakan.
 *
 * Aturan penting constructor:
 *
 * - Nama harus sama dengan nama class.
 * - Tidak memiliki return type.
 * - Tidak menggunakan void.
 * - Dipanggil otomatis saat object dibuat.
 *
 * Flow:
 *
 * new
 * -> Constructor Dipanggil
 * -> Object Diinisialisasi
 * -> Object Siap Digunakan
 *
 * Constructor merupakan mekanisme utama Java untuk memastikan
 * setiap object memiliki kondisi awal yang valid sejak pertama
 * kali dibuat.
 */

public class ConstructorJava {
    // Instance variabel
    double width;
    double height;
    double depth;

    // CONSTRUCTOR
    // Method khusus yang dijalankan saat object dibuat
    ConstructorJava() {
        System.out.println("Constructing box");

        // Menginisialisasi nilai variabel atau objek
        width = 10;
        height = 10;
        depth = 10;
    }

    // Method untuk menghitung volume
    double volume() {
        // rumus volume
        return width * height * depth;
    }

    public static void main(String[] args) {

        // Membuat object pertama
        ConstructorJava myBox1 = new ConstructorJava();
        // Membuat object kedua
        ConstructorJava myBox2 = new ConstructorJava();

        // Variabel untuk menampung nilai
        double vol;

        // Menghitung volume box pertama
        vol = myBox1.volume();
        System.out.println(vol);

        // Menghitung volume box kedua
        vol = myBox2.volume();
        System.out.println(vol);

        /**
         * EKSEKUSI CONSTRUCTOR DAN DEFAULT CONSTRUCTOR
         * ------------------------------------------------------------
         *
         * Output:
         *
         * Constructing Box
         * Constructing Box
         * 1000.0
         * 1000.0
         *
         * Output tersebut menunjukkan bahwa constructor dipanggil
         * setiap kali object baru dibuat menggunakan operator new.
         *
         * ------------------------------------------------------------
         * ALUR EKSEKUSI PROGRAM
         * ------------------------------------------------------------
         *
         * Saat program dijalankan, proses yang terjadi adalah:
         *
         * 1. Program mulai dari method:
         *
         * main()
         *
         * ------------------------------------------------------------
         *
         * 2. Object pertama dibuat:
         *
         * Box myBox1 = new Box();
         *
         * Flow:
         *
         * new Box()
         * -> Java Mengalokasikan Memory Untuk Object
         * -> Constructor Box() Dipanggil
         * -> Instance Variable Diinisialisasi
         * -> Object Siap Digunakan
         *
         * Output:
         *
         * Constructing Box
         *
         * Nilai instance variable:
         *
         * - width = 10
         * - height = 10
         * - depth = 10
         *
         * ------------------------------------------------------------
         *
         * 3. Object kedua dibuat:
         *
         * Box myBox2 = new Box();
         *
         * Flow:
         *
         * new Box()
         * -> Java Mengalokasikan Memory Untuk Object Baru
         * -> Constructor Box() Dipanggil
         * -> Instance Variable Diinisialisasi
         * -> Object Siap Digunakan
         *
         * Output:
         *
         * Constructing Box
         *
         * Nilai instance variable:
         *
         * - width = 10
         * - height = 10
         * - depth = 10
         *
         * ------------------------------------------------------------
         *
         * 4. Menghitung volume myBox1
         *
         * Rumus:
         *
         * width × height × depth
         *
         * Perhitungan:
         *
         * 10 × 10 × 10
         * -> 1000
         *
         * Output:
         *
         * 1000.0
         *
         * ------------------------------------------------------------
         *
         * 5. Menghitung volume myBox2
         *
         * Perhitungan:
         *
         * 10 × 10 × 10
         * -> 1000
         *
         * Output:
         *
         * 1000.0
         *
         * ------------------------------------------------------------
         * MENGAPA CONSTRUCTOR DIPANGGIL DUA KALI?
         * ------------------------------------------------------------
         *
         * Karena terdapat dua object yang dibuat:
         *
         * Box myBox1 = new Box();
         * Box myBox2 = new Box();
         *
         * Setiap object yang dibuat menggunakan operator new akan
         * memanggil constructor masing-masing.
         *
         * Flow:
         *
         * myBox1 Dibuat
         * -> Constructor Dipanggil
         *
         * myBox2 Dibuat
         * -> Constructor Dipanggil
         *
         * Jumlah object yang dibuat akan menentukan berapa kali
         * constructor dijalankan.
         *
         * ------------------------------------------------------------
         * APA YANG DILAKUKAN OPERATOR new?
         * ------------------------------------------------------------
         *
         * Saat menulis:
         *
         * Box myBox = new Box();
         *
         * Sebenarnya Java melakukan beberapa langkah:
         *
         * - Mengalokasikan memory untuk object di heap memory.
         * - Memanggil constructor yang sesuai.
         * - Menginisialisasi object.
         * - Mengembalikan reference object.
         * - Menyimpan reference tersebut ke variabel myBox.
         *
         * Flow:
         *
         * new
         * -> Alokasi Memory
         * -> Constructor Dipanggil
         * -> Object Diinisialisasi
         * -> Reference Dikembalikan
         * -> Disimpan Ke Variabel
         *
         * ------------------------------------------------------------
         * DEFAULT CONSTRUCTOR
         * ------------------------------------------------------------
         *
         * Jika sebuah class tidak memiliki constructor sama sekali,
         * maka compiler Java akan membuat constructor default secara
         * otomatis.
         *
         * Contoh:
         *
         * class Box {
         *
         * double width;
         * double height;
         * double depth;
         *
         * }
         *
         * Compiler Java akan menambahkan constructor seperti berikut:
         *
         * Box() {
         * }
         *
         * Constructor ini disebut:
         *
         * Default Constructor
         *
         * ------------------------------------------------------------
         * NILAI DEFAULT INSTANCE VARIABLE
         * ------------------------------------------------------------
         *
         * Ketika constructor tidak memberikan nilai awal,
         * Java akan mengisi instance variable menggunakan
         * nilai default sesuai tipe datanya.
         *
         * - byte -> 0
         * - short -> 0
         * - int -> 0
         * - long -> 0L
         * - float -> 0.0f
         * - double -> 0.0
         * - char -> '\u0000'
         * - boolean -> false
         * - Reference/Object -> null
         *
         * Contoh:
         *
         * class Test {
         * int a;
         * }
         *
         * public class Demo {
         *
         * public static void main(String[] args) {
         *
         * Test t = new Test();
         *
         * System.out.println(t.a);
         *
         * }
         * }
         *
         * Output:
         *
         * 0
         *
         * Karena instance variable int secara otomatis diberi
         * nilai default 0 oleh Java.
         *
         * ------------------------------------------------------------
         * DEFAULT CONSTRUCTOR AKAN HILANG
         * ------------------------------------------------------------
         *
         * Jika kita membuat constructor sendiri:
         *
         * class Box {
         *
         * Box() {
         * }
         *
         * }
         *
         * Maka compiler Java tidak akan membuat default constructor
         * secara otomatis.
         *
         * Artinya:
         *
         * - Tidak ada lagi constructor buatan compiler.
         * - Yang tersedia hanya constructor yang kita buat sendiri.
         *
         * Ini adalah salah satu penyebab error yang paling sering
         * ditemui pemula saat belajar constructor.
         *
         * ------------------------------------------------------------
         * CATATAN PENTING
         * ------------------------------------------------------------
         *
         * Default Constructor berbeda dengan Constructor Kosong.
         *
         * Constructor Kosong:
         *
         * Box() {
         * }
         *
         * Dibuat oleh programmer.
         *
         * Default Constructor:
         *
         * Box() {
         * }
         *
         * Dibuat otomatis oleh compiler Java.
         *
         * Secara bentuk terlihat sama, tetapi asal pembuatannya
         * berbeda.
         *
         * ------------------------------------------------------------
         * INTI KONSEP CONSTRUCTOR
         * ------------------------------------------------------------
         *
         * Constructor digunakan untuk:
         *
         * - Menginisialisasi object.
         * - Memberikan nilai awal pada instance variable.
         * - Menyiapkan object agar langsung siap digunakan.
         * - Memastikan object berada dalam kondisi yang valid.
         *
         * Constructor akan dipanggil secara otomatis setiap kali
         * object dibuat menggunakan operator:
         *
         * new
         *
         * Flow:
         *
         * Object Dibuat
         * -> Constructor Dipanggil
         * -> Nilai Awal Diinisialisasi
         * -> Object Siap Digunakan
         *
         * Constructor merupakan mekanisme utama Java untuk
         * mempersiapkan object sejak pertama kali dibuat.
         */

    }
}
