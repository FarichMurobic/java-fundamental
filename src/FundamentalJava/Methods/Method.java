package FundamentalJava.Methods;

/*
 * ============================================================
 * Method Pada Java
 * ============================================================
 *
 * Method adalah sekumpulan instruksi atau blok kode yang dibuat
 * untuk melakukan tugas tertentu.
 *
 * Dengan menggunakan method, kode dapat dibuat lebih:
 * - Terstruktur.
 * - Mudah dibaca.
 * - Dapat digunakan kembali (reusable).
 * - Lebih mudah dipelihara.
 *
 * Dalam konsep Object-Oriented Programming (OOP):
 *
 * class  -> blueprint atau rancangan sebuah object.
 * object -> hasil nyata dari sebuah class.
 * method -> perilaku atau kemampuan yang dimiliki object/class.
 *
 * Contoh analogi:
 *
 * Mesin = class
 * Tombol fungsi pada mesin = method
 *
 * Sebuah mesin kopi dapat memiliki beberapa method:
 *
 * buatKopi()
 * buatTeh()
 * buatCoklat()
 *
 * Setiap method memiliki tugas tertentu yang dapat dijalankan.
 *
 * Dalam Java:
 *
 * Object dapat menjalankan method untuk melakukan suatu aksi.
 *
 * Contoh:
 *
 * myBox.volume();
 *
 * Artinya:
 *
 * Object myBox memanggil method volume() untuk menjalankan
 * proses yang sudah didefinisikan di dalam method tersebut.
 *
 * ------------------------------------------------------------
 * Struktur Dasar Method
 * ------------------------------------------------------------
 *
 * Bentuk umum method pada Java:
 *
 * returnType methodName(parameterList) {
 *     // body method
 * }
 *
 * Contoh:
 *
 * int tambah(int a, int b) {
 *     return a + b;
 * }
 *
 * ------------------------------------------------------------
 * Komponen Method
 * ------------------------------------------------------------
 *
 * 1. Return Type
 *
 * Return type menentukan tipe data nilai yang dikembalikan oleh
 * sebuah method setelah selesai dijalankan.
 *
 * Contoh:
 *
 * int tambah(int a, int b)
 *
 * Method tambah() akan mengembalikan nilai bertipe int.
 *
 * Return type dapat berupa:
 *
 * - Primitive type seperti int, double, boolean, char.
 * - Reference type seperti String atau object dari class tertentu.
 * - void jika method tidak mengembalikan nilai.
 *
 * Contoh method tanpa nilai kembali:
 *
 * void tampilkanPesan() {
 *     System.out.println("Hello Java");
 * }
 *
 * ------------------------------------------------------------
 *
 * 2. Method Name
 *
 * Method name adalah nama yang digunakan untuk memanggil method.
 *
 * Nama method harus mengikuti aturan identifier Java:
 *
 * - Tidak boleh menggunakan keyword Java.
 * - Tidak boleh mengandung spasi.
 * - Harus memiliki nama yang unik dalam scope tertentu.
 *
 * Contoh:
 *
 * hitungTotal()
 * tampilkanData()
 * simpanCustomer()
 *
 * Konvensi penamaan method pada Java menggunakan camelCase.
 *
 * ------------------------------------------------------------
 *
 * 3. Parameter List
 *
 * Parameter adalah variabel yang digunakan untuk menerima nilai
 * ketika method dipanggil.
 *
 * Parameter ditulis di dalam tanda kurung setelah nama method.
 *
 * Contoh:
 *
 * int tambah(int a, int b) {
 *     return a + b;
 * }
 *
 * Pada contoh tersebut:
 *
 * a dan b adalah parameter method.
 *
 * Ketika method dipanggil:
 *
 * tambah(5, 3);
 *
 * Nilai 5 akan dikirim ke parameter a.
 * Nilai 3 akan dikirim ke parameter b.
 *
 * Jika sebuah method tidak membutuhkan parameter, maka bagian
 * parameter dikosongkan.
 *
 * Contoh:
 *
 * void tampilkanMenu() {
 *     System.out.println("Menu");
 * }
 *
 * ------------------------------------------------------------
 * Return Statement
 * ------------------------------------------------------------
 *
 * Method yang memiliki return type selain void harus
 * mengembalikan sebuah nilai menggunakan keyword return.
 *
 * Bentuk umum:
 *
 * return value;
 *
 * value adalah nilai yang akan dikirim kembali kepada kode yang
 * memanggil method tersebut.
 *
 * Contoh:
 *
 * int tambah(int a, int b) {
 *     return a + b;
 * }
 *
 * Pemanggilan:
 *
 * int hasil = tambah(5, 3);
 *
 * Alur proses:
 *
 * 5 + 3
 *   |
 *   v
 * 8
 *   |
 *   v
 * return 8
 *   |
 *   v
 * variabel hasil menerima nilai 8
 *
 * ------------------------------------------------------------
 * Method Tanpa Return Value (void)
 * ------------------------------------------------------------
 *
 * Jika method hanya menjalankan suatu proses tanpa menghasilkan
 * nilai kembali, gunakan keyword void.
 *
 * Contoh:
 *
 * void cetakNama(String nama) {
 *     System.out.println(nama);
 * }
 *
 * Method tersebut hanya melakukan aksi mencetak data dan tidak
 * mengembalikan nilai.
 *
 * ------------------------------------------------------------
 * Mengakses Instance Variable Dalam Class
 * ------------------------------------------------------------
 *
 * Instance variable adalah variable yang dimiliki oleh object.
 *
 * Jika mengakses instance variable dari luar class, maka harus
 * melalui object.
 *
 * Contoh:
 *
 * myBox.width = 10;
 *
 * Karena kode tersebut berada di luar class Box, maka harus
 * menggunakan referensi object myBox.
 *
 * ------------------------------------------------------------
 *
 * Jika mengakses instance variable dari dalam class yang sama,
 * variable dapat dipanggil langsung tanpa menuliskan object.
 *
 * Contoh:
 *
 * class Box {
 *
 *     int width;
 *     int height;
 *     int depth;
 *
 *     void setSize(int width, int height, int depth) {
 *         this.width = width;
 *         this.height = height;
 *         this.depth = depth;
 *     }
 * }
 *
 * Keyword this digunakan untuk membedakan antara:
 *
 * - Instance variable milik object.
 * - Parameter method.
 *
 * Contoh:
 *
 * this.width
 *
 * Mengacu kepada variable width milik object.
 *
 * width
 *
 * Mengacu kepada parameter method.
 *
 * ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * Method adalah bagian penting dalam Java yang digunakan untuk
 * membungkus logika program menjadi sebuah fungsi yang dapat
 * dipanggil kembali.
 *
 * Sebuah method terdiri dari:
 *
 * - Return type.
 * - Nama method.
 * - Parameter.
 * - Body method.
 *
 * Dengan memahami method, program Java dapat dibuat lebih
 * modular, rapi, dan mudah dikembangkan.
 *
 */

// This program includes a method inside the box class.
class Box {
    double panjang; // instance variabel
    double lebar; // instance variabel
    double tinggi; // instance variabel
    String nama; // instance variabel

    // jika ingin mengakses instance variabel dari luar class, harus menggunakan objek
    // contoh: myBox1.panjang = 10;

    // methode menampilkan string
    void sayHello() {
        nama = "\tFarich \n\t\tMurobiq";
        System.out.println(nama);
    }

    // method untuk menampilkan volume box
    void volume() {
        System.out.print("Volume is ");
        System.out.println(panjang * lebar * tinggi);
    }
}

public class Method {
    public static void main(String[] args) {
        
        // membuat objek dari kelas box
        Box myBox1 = new Box(); // membuat object box pertama
        Box myBox2 = new Box(); // membuat object box kedua

        // memberikan nilai pada objek pertama
        myBox1.panjang = 10;
        myBox1.lebar = 20;
        myBox1.tinggi = 15;

        // memberikan nilai pada objek kedua
        myBox2.panjang = 3;
        myBox2.lebar = 6;
        myBox2.tinggi = 9;

        // memanggil metode volume untuk objek pertana
        myBox1.volume();
        // memanggil metode volume untuk objek pertana
        myBox2.volume();

        /**
         * Output Program
         * 
         * Volume is 3000.0
         * Volume is 162.0
         *
         * Perhitungan:
         * 10 × 20 × 15 = 3000
         * 3 × 6 × 9 = 162
         *
         * Cara Memanggil Method
         * Baris penting:
         * mybox1.volume();
         * mybox2.volume();
         *
         * Artinya:
         * object.method() atau mybox1 menjalankan method volume()
         *
         * Operator . disebut:
         * Dot Operator
         * Digunakan untuk mengakses member dari object
         *
         * Contoh:
         * object.variable
         * object.method()
         *
         * ------------------------------------
         * 
         * Alur Eksekusi Program
         * Ketika program dijalankan:
         * Step 1
         * Object dibuat
         * Box mybox1 = new Box();
         * Box mybox2 = new Box();
         *
         * Memory kira-kira:
         * mybox1 → object Box
         * mybox2 → object Box
         *
         * Step 2
         * Isi data object
         * mybox1
         * width = 10
         * height = 20
         * depth = 15
         * mybox2
         * width = 3
         * height = 6
         * depth = 9
         *
         * Step 3
         * Method dipanggil
         * mybox1.volume();
         *
         * Java:
         * pindah ke method volume()
         * jalankan kode
         * width * height * depth
         * tampilkan hasil
         *
         * Step 4
         * Kembali ke main method.
         */

        // membuat objek
        Box nameBox = new Box();
        nameBox.sayHello();

    }
}
