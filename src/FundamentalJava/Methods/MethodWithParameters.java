package FundamentalJava.Methods;

/*
 * ============================================================
 * Parameter Pada Method Java
 * ============================================================
 *
 * Parameter adalah variabel yang didefinisikan di dalam deklarasi
 * sebuah method dan digunakan untuk menerima data dari pemanggil
 * method.
 *
 * Parameter membuat sebuah method menjadi lebih fleksibel karena
 * method tidak hanya bekerja dengan satu nilai tetap, tetapi dapat
 * menerima berbagai nilai yang berbeda.
 *
 * Dengan parameter:
 *
 * - Method dapat digunakan kembali (reusable).
 * - Method menjadi lebih umum (general-purpose).
 * - Logika program menjadi lebih fleksibel.
 *
 * ------------------------------------------------------------
 * Contoh Method Tanpa Parameter
 * ------------------------------------------------------------
 *
 * Contoh:
 *
 * int square() {
 *     return 10 * 10;
 * }
 *
 * Method tersebut selalu menghasilkan nilai:
 *
 * 10 x 10 = 100
 *
 * Masalah:
 *
 * Method ini hanya dapat menghitung kuadrat angka 10.
 *
 * Jika ingin menghitung angka lain, kita harus membuat method
 * baru atau mengubah isi method tersebut.
 *
 * ------------------------------------------------------------
 * Contoh Method Dengan Parameter
 * ------------------------------------------------------------
 *
 * Method dapat dibuat lebih fleksibel menggunakan parameter.
 *
 * Contoh:
 *
 * int square(int i) {
 *     return i * i;
 * }
 *
 * Sekarang method square() dapat menerima nilai apa pun.
 *
 * Contoh pemanggilan:
 *
 * square(2);
 * square(5);
 * square(20);
 * square(100);
 *
 * Hasil:
 *
 * square(2)   -> 4
 * square(5)   -> 25
 * square(20)  -> 400
 * square(100) -> 10000
 *
 * Method tersebut sekarang menjadi general-purpose method karena
 * dapat digunakan untuk berbagai nilai.
 *
 * ------------------------------------------------------------
 * Parameter vs Argument
 * ------------------------------------------------------------
 *
 * Parameter dan argument sering dianggap sama, tetapi sebenarnya
 * memiliki perbedaan.
 *
 * ------------------------------------------------------------
 *
 * Parameter:
 *
 * Parameter adalah variabel yang ditulis pada deklarasi method.
 *
 * Contoh:
 *
 * int square(int i) {
 *     return i * i;
 * }
 *
 * Pada contoh tersebut:
 *
 * i adalah parameter.
 *
 * Parameter berfungsi sebagai tempat menerima nilai yang dikirim
 * ketika method dipanggil.
 *
 * ------------------------------------------------------------
 *
 * Argument:
 *
 * Argument adalah nilai nyata yang dikirimkan ketika method
 * dipanggil.
 *
 * Contoh:
 *
 * square(100);
 *
 * Pada contoh tersebut:
 *
 * 100 adalah argument.
 *
 * Nilai argument akan dimasukkan ke dalam parameter i.
 *
 * Alur:
 *
 * argument
 *    |
 *    v
 * parameter
 *    |
 *    v
 * proses method
 *
 * ------------------------------------------------------------
 * Parameter Membuat Method Lebih Fleksibel
 * ------------------------------------------------------------
 *
 * Tanpa parameter:
 *
 * int square() {
 *     return 10 * 10;
 * }
 *
 * Hanya dapat menghasilkan:
 *
 * 100
 *
 *
 * Dengan parameter:
 *
 * int square(int i) {
 *     return i * i;
 * }
 *
 * Dapat digunakan untuk berbagai nilai.
 *
 * Contoh:
 *
 * square(3)
 * square(8)
 * square(50)
 *
 * ------------------------------------------------------------
 * Penerapan Parameter Pada Class Box
 * ============================================================
 *
 * Sebelumnya, ukuran object Box dapat diberikan secara langsung:
 *
 * myBox.width = 10;
 * myBox.height = 20;
 * myBox.depth = 15;
 *
 * Cara tersebut memang dapat berjalan, tetapi dalam desain OOP
 * yang baik cara tersebut memiliki beberapa masalah.
 *
 * ------------------------------------------------------------
 * Masalah 1: Tidak Praktis
 * ------------------------------------------------------------
 *
 * Jika object memiliki banyak attribute, pemberian nilai satu
 * per satu dapat membuat kode menjadi panjang.
 *
 * Contoh:
 *
 * myBox.width = 10;
 * myBox.height = 20;
 * myBox.depth = 15;
 *
 * Akan sulit dipelihara jika jumlah attribute semakin banyak.
 *
 * ------------------------------------------------------------
 * Masalah 2: Rawan Kesalahan
 * ------------------------------------------------------------
 *
 * Programmer dapat lupa memberikan nilai pada salah satu variable.
 *
 * Contoh:
 *
 * myBox.width = 10;
 * myBox.height = 20;
 *
 * // lupa memberikan nilai depth
 *
 * Akibatnya object dapat berada dalam kondisi data yang tidak
 * lengkap.
 *
 * ------------------------------------------------------------
 * Masalah 3: Melanggar Konsep Encapsulation
 * ------------------------------------------------------------
 *
 * Dalam konsep Object-Oriented Programming, data internal object
 * sebaiknya tidak diubah secara langsung dari luar class.
 *
 * Contoh yang kurang baik:
 *
 * myBox.width = 10;
 *
 * Karena kode luar dapat mengubah data object tanpa kontrol.
 *
 * Desain yang lebih baik adalah menggunakan method untuk mengatur
 * nilai tersebut.
 *
 * Contoh:
 *
 * class Box {
 *
 *     private int width;
 *     private int height;
 *     private int depth;
 *
 *     void setSize(int width, int height, int depth) {
 *         this.width = width;
 *         this.height = height;
 *         this.depth = depth;
 *     }
 * }
 *
 * Pemanggilan:
 *
 * myBox.setSize(10, 20, 15);
 *
 * Keuntungan:
 *
 * - Data object lebih terkontrol.
 * - Validasi dapat ditambahkan di dalam method.
 * - Mengurangi kemungkinan kesalahan.
 *
 * ------------------------------------------------------------
 * Parameter Dalam Constructor
 * ------------------------------------------------------------
 *
 * Selain method biasa, parameter juga sering digunakan pada
 * constructor untuk memastikan object dibuat dengan data awal
 * yang lengkap.
 *
 * Contoh:
 *
 * class Box {
 *
 *     private int width;
 *     private int height;
 *     private int depth;
 *
 *     Box(int width, int height, int depth) {
 *         this.width = width;
 *         this.height = height;
 *         this.depth = depth;
 *     }
 * }
 *
 * Pembuatan object:
 *
 * Box box = new Box(10, 20, 15);
 *
 * Object langsung memiliki data ketika dibuat.
 *
 * ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * Parameter adalah mekanisme yang memungkinkan method menerima
 * data dari luar sehingga method menjadi lebih fleksibel.
 *
 * Konsep penting:
 *
 * - Parameter adalah variabel pada deklarasi method.
 * - Argument adalah nilai yang dikirim saat pemanggilan method.
 * - Parameter membuat method dapat digunakan kembali untuk banyak
 *   kondisi.
 * - Parameter sering digunakan bersama encapsulation untuk membuat
 *   desain class yang lebih aman.
 *
 * Dengan memahami parameter, kita dapat membuat method yang lebih
 * reusable, fleksibel, dan sesuai dengan prinsip OOP Java.
 *
 */

public class MethodWithParameters {
    // variabel instance
    double width;
    double height;
    double depth;

    // menghitung dan mengembalikan volume
    double volume() {
        return width * height * depth;
    }

    // method untuk mengatur ukuran box
    // menggunakan parameter
    void setDim(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    // contoh sederhana
    // return value pake parameter
    int tambah(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {

        MethodWithParameters myBox1 = new MethodWithParameters();
        MethodWithParameters myBox2 = new MethodWithParameters();

        double vol;

        // mengatur ukuran box menggunakan methode
        myBox1.setDim(10, 20, 15); // liat parameter ini berfungsi
        myBox2.setDim(3, 6, 9); // liat parameter ini berfungsi

        // menghitung volume box pertama
        vol = myBox1.volume();
        System.out.println("Volume is " + vol);

        // menghitung box volume kedua
        vol = myBox2.volume();
        System.out.println("Volume is " + vol);

        /**
         * Alur Eksekusi Program
         * 
         * Ketika kode ini dijalankan:
         * mybox1.setDim(10, 20, 15);
         * 
         * Langkah yang terjadi:
         * Step 1
         * Argument dikirim:
         * 10 → w
         * 20 → h
         * 15 → d
         * Step 2
         *
         * Method dijalankan
         * width = w;
         * height = h;
         * depth = d;
         * Step 3
         *
         * Nilai object berubah
         * Object mybox1 menjadi:
         * width = 10
         * height = 20
         * depth = 15
         *
         * Visualisasi Memory
         * Sebelum:
         * mybox1
         * width = 0
         * height = 0
         * depth = 0
         *
         * Setelah:
         * mybox1.setDim(10,20,15)
         *
         * mybox1
         * width = 10
         * height = 20
         * depth = 15
         */

        // Membuat objek untuk akses methode pertambahan
        MethodWithParameters kalkulator = new MethodWithParameters();

        int hasil;

        // return value lebih fleksibel
        hasil = kalkulator.tambah(50, 20);
        System.out.println(hasil); // 50 + 20 = 70
        System.out.println(kalkulator.tambah(50, 22)); // 50 + 22 = 72

    }
}
