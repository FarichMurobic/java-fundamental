package FundamentalJava.Constructor;

/**
 * ------------------------------------------------------------------------
 * KEYWORD this
 * ------------------------------------------------------------------------
 *
 * this adalah reference yang menunjuk ke object yang sedang aktif
 * (current object).
 *
 * Setiap object memiliki reference this sendiri yang secara otomatis
 * disediakan oleh Java.
 *
 * Ketika sebuah method dipanggil melalui object, keyword this akan
 * mengacu pada object yang memanggil method tersebut.
 *
 * Dengan kata lain:
 *
 * this
 * -> Reference Ke Current Object
 *
 * Karena this merupakan reference object, maka this dapat digunakan
 * di mana saja reference terhadap object dari class yang sama
 * diperbolehkan.
 *
 * ------------------------------------------------------------------------
 * BAGAIMANA this BEKERJA?
 * ------------------------------------------------------------------------
 *
 * Misalkan terdapat object:
 *
 * Mahasiswa m1 = new Mahasiswa("Farich");
 * Mahasiswa m2 = new Mahasiswa("Budi");
 *
 * Ketika method dipanggil:
 *
 * m1.tampilkan();
 *
 * maka:
 *
 * this
 * -> m1
 *
 * Ketika method dipanggil:
 *
 * m2.tampilkan();
 *
 * maka:
 *
 * this
 * -> m2
 *
 * Flow:
 *
 * m1.tampilkan()
 * -> this mengacu ke m1
 *
 * m2.tampilkan()
 * -> this mengacu ke m2
 *
 * Oleh karena itu, nilai this selalu bergantung pada object yang
 * sedang memanggil method.
 *
 * ------------------------------------------------------------------------
 * PENGGUNAAN PALING UMUM this
 * ------------------------------------------------------------------------
 *
 * Salah satu penggunaan this yang paling sering ditemukan adalah
 * untuk membedakan instance variable dengan parameter yang memiliki
 * nama yang sama.
 *
 * Contoh:
 *
 * class Box {
 *
 *     double width;
 *
 *     Box(double width) {
 *         this.width = width;
 *     }
 * }
 *
 * Pada contoh di atas:
 *
 * - this.width mengacu pada instance variable.
 * - width mengacu pada parameter constructor.
 *
 * Flow:
 *
 * Argument
 * -> Parameter width
 * -> this.width (Instance Variable)
 *
 * ------------------------------------------------------------------------
 * MENGAPA this DIPERLUKAN?
 * ------------------------------------------------------------------------
 *
 * Perhatikan contoh berikut:
 *
 * class Box {
 *
 *     double width;
 *
 *     Box(double width) {
 *         width = width;
 *     }
 * }
 *
 * Sekilas terlihat benar, tetapi sebenarnya salah.
 *
 * Yang terjadi:
 *
 * width (Parameter)
 * = width (Parameter)
 *
 * Instance variable tidak pernah mendapatkan nilai.
 *
 * Akibatnya:
 *
 * this.width
 * tetap memiliki nilai default.
 *
 * Solusi:
 *
 * this.width = width;
 *
 * Artinya:
 *
 * this.width (Instance Variable)
 * = width (Parameter)
 *
 * ------------------------------------------------------------------------
 * this UNTUK MENGAKSES MEMBER OBJECT
 * ------------------------------------------------------------------------
 *
 * this juga dapat digunakan untuk mengakses instance variable
 * maupun method milik object saat ini.
 *
 * Contoh:
 *
 * class Test {
 *
 *     int a;
 *
 *     void setA(int a) {
 *         this.a = a;
 *     }
 *
 *     void tampilkan() {
 *         System.out.println(this.a);
 *     }
 * }
 *
 * Pada praktiknya, penulisan this.a di dalam method sering kali
 * bersifat opsional selama tidak terjadi konflik nama.
 *
 * Contoh:
 *
 * System.out.println(a);
 *
 * dan
 *
 * System.out.println(this.a);
 *
 * menghasilkan perilaku yang sama.
 *
 * ------------------------------------------------------------------------
 * this UNTUK MEMANGGIL CONSTRUCTOR LAIN
 * ------------------------------------------------------------------------
 *
 * this juga dapat digunakan untuk memanggil constructor lain
 * dalam class yang sama.
 *
 * Contoh:
 *
 * class Box {
 *
 *     double width;
 *     double height;
 *     double depth;
 *
 *     Box() {
 *         this(0, 0, 0);
 *     }
 *
 *     Box(double w, double h, double d) {
 *         width = w;
 *         height = h;
 *         depth = d;
 *     }
 * }
 *
 * Flow:
 *
 * Box()
 * -> this(0, 0, 0)
 * -> Box(double w, double h, double d)
 * -> Object Diinisialisasi
 *
 * Catatan:
 *
 * Jika digunakan untuk memanggil constructor lain,
 * this(...) harus menjadi statement pertama dalam constructor.
 *
 * ------------------------------------------------------------------------
 * this SEBAGAI ARGUMENT METHOD
 * ------------------------------------------------------------------------
 *
 * Current object juga dapat dikirim ke method lain menggunakan
 * keyword this.
 *
 * Contoh:
 *
 * class Test {
 *
 *     void show() {
 *         display(this);
 *     }
 *
 *     void display(Test obj) {
 *         // proses object
 *     }
 * }
 *
 * Flow:
 *
 * Current Object
 * -> this
 * -> Dikirim Ke Method
 *
 * ------------------------------------------------------------------------
 * this SEBAGAI RETURN VALUE
 * ------------------------------------------------------------------------
 *
 * Sebuah method juga dapat mengembalikan current object menggunakan
 * keyword this.
 *
 * Contoh:
 *
 * class Test {
 *
 *     Test getObject() {
 *         return this;
 *     }
 * }
 *
 * Teknik ini banyak digunakan dalam:
 *
 * - Method Chaining
 * - Builder Pattern
 * - Fluent API
 *
 * Contoh modern:
 *
 * builder
 *     .setName("Farich")
 *     .setAge(20)
 *     .build();
 *
 * ------------------------------------------------------------------------
 * ISTILAH PENTING
 * ------------------------------------------------------------------------
 *
 * - Current Object
 *   Object yang sedang menjalankan method.
 *
 * - Instance Variable
 *   Variabel yang dimiliki oleh setiap object.
 *
 * - Parameter
 *   Variabel penerima nilai pada method atau constructor.
 *
 * - Argument
 *   Nilai yang dikirim saat method atau constructor dipanggil.
 *
 * ------------------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------------------
 *
 * this adalah reference yang menunjuk ke current object
 * (object yang sedang aktif).
 *
 * Penggunaan utama this:
 *
 * - Mengakses instance variable milik object saat ini.
 *
 * - Membedakan instance variable dengan parameter yang memiliki
 *   nama yang sama.
 *
 * - Memanggil constructor lain dalam class yang sama melalui
 *   this(...).
 *
 * - Mengirim current object sebagai argument method.
 *
 * - Mengembalikan current object dari method.
 *
 * Flow utama:
 *
 * Method Dipanggil
 * -> this Mengacu Ke Current Object
 * -> Akses Data / Method Object
 * -> Eksekusi Selesai
 *
 * Keyword this merupakan salah satu fitur dasar OOP di Java yang
 * sangat penting karena membantu object mengenali dirinya sendiri
 * selama program berjalan.
 */

public class ThisJava {

    double width;
    double height;
    double depth;

    /**
     * contoh program redudant.
     *
     * This(double w, double h, double d) {
     *
     * this menunjuk ke object yang sedang dibuat
     * this disini sebenarnya redudant, Tanpa this. Java tetap mengerti bahwa width adalah instance variable.
     * this.width = w;
     * this.height = h;
     * this.depth = d;
     * }
     */

    // Contoh this yang benar, saat nama variabel instance dan nama variabel parameter sama.
    ThisJava(double width, double height, double depth) {
        // artinya this disini merujuk instance. meskipun namanya sama dengan nama parameter
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    /**
     * Alur Eksekusi Program
     *
     * Misalnya kita jalankan:
     * Box box1 = new Box(5,6,7);
     * Saat constructor berjalan:
     * Parameter:
     * width  = 5
     * height = 6
     * depth  = 7
     *
     * this menunjuk ke object:
     * box1
     *
     * Eksekusi:
     * this.width  = width  → box1.width = 5
     * this.height = height → box1.height = 6
     * this.depth  = depth  → box1.depth = 7
     *
     * Object selesai dibuat.
     */


    double volume() {
        return width * height * depth;
    }

    public static void main(String[] args) {

        ThisJava objek1 = new ThisJava(20, 20, 50);
        System.out.println(objek1.volume());

        /**
         * Apa Arti this Sebenarnya?
         * 
         * this adalah reference ke object yang sedang aktif.
         * Misalnya kita punya:
         * Box mybox1 = new Box(10,20,30);
         * Saat constructor berjalan:
         * this → mybox1
         *
         * Jadi:
         * this.width = w;
         * artinya:
         * mybox1.width = w
         *
         * --------------------------------
         * 
         * Ilustrasi Memory Object
         * 
         * Ketika object dibuat:
         * Box mybox1 = new Box(10,20,30);
         *
         * Memory object:
         * mybox1
         *  ├── width  = 10
         *  ├── height = 20
         *  └── depth  = 30
         *
         * Saat constructor berjalan:
         * this → object mybox1
         */

    }
}
