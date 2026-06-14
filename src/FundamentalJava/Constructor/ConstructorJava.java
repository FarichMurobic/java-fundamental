package FundamentalJava.Constructor;

     /**
     * Constructor adalah method khusus yang otomatis dijalankan saat object dibuat.
     * Constructor menginisialisasi sebuah objek segera setelah objek tersebut dibuat.
     * Constructor memiliki nama yang sama dengan class tempat ia berada dan secara sintaks mirip dengan sebuah method.
     *
     * Setelah constructor didefinisikan, constructor akan dipanggil secara otomatis ketika objek dibuat,
     * yaitu sebelum operator new selesai dieksekusi.
     * Constructor terlihat sedikit aneh karena tidak memiliki tipe nilai kembali (return type), bahkan tidak menggunakan void.
     * Hal ini karena tipe pengembalian implisit dari constructor sebenarnya adalah tipe class itu sendiri.
     * Tugas utama constructor adalah menginisialisasi keadaan internal (internal state) dari sebuah objek,
     * sehingga kode yang membuat instance akan langsung mendapatkan objek yang sudah siap digunakan.
     *
     * ===========================================
     * 
     * Contoh analogi:
     * Bayangkan lu bikin mobil di pabrik.
     * Saat mobil dibuat:
     * mesin dipasang
     * roda dipasang
     * bensin diisi
     *
     * Proses itu sama seperti constructor.
     *
     * Saat object dibuat:
     * variabel diisi
     * nilai awal ditentukan
     * object siap dipakai
     *
     * Constructor punya aturan khusus:
     * 1, Namanya harus sama dengan class
     * class Box
     * Box() 
     *
     * 2, Tidak memiliki return type
     * SALAH 
     * void Box() { }
     *
     * BENAR 
     * Box() { }
     *
     * 3, Dipanggil otomatis saat object dibuat
     * Box mybox = new Box();
     * Saat baris ini dijalankan:
     * new Box()
     * Java akan memanggil:
     * Box()
     * constructor.
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
         * Output
         * Constructing box
         * Constructing box
         * 1000.0
         * 1000.0
         *
         * Alur Eksekusi Program (Step-by-step)
         *
         * Saat program dijalankan:
         * 1-Program mulai dari
         * main()
         * 2-Object pertama dibuat
         * Box mybox1 = new Box();
         *
         * Yang terjadi:
         * new Box()
         *
         * Java memanggil constructor
         * Box()
         *
         * Output:
         * Constructing Box
         *
         * Variabel diisi:
         * width = 10
         * height = 10
         * depth = 10
         *
         * 3-Object kedua dibuat
         * Box mybox2 = new Box();
         *
         * Constructor dipanggil lagi.
         * Output:
         * Constructing Box
         *
         * 4-Hitung volume box1
         * 10 × 10 × 10 = 1000
         *
         * Output:
         * 1000
         *
         * 5-Hitung volume box2
         * Hasilnya sama:
         * 1000
         *
         * Kenapa Constructor Dipanggil 2 Kali?
         * Karena ada 2 object:
         * Box mybox1 = new Box();
         * Box mybox2 = new Box();
         *
         * Setiap object punya constructor sendiri.
         * Jadi:
         * Object	Constructor
         * mybox1	dipanggil
         * mybox2	dipanggil
         *
         * Penjelasan Operator new
         * Buku juga menjelaskan ini.
         *
         * Saat kita menulis:
         * Box mybox1 = new Box();
         *
         * Yang terjadi sebenarnya:
         * -Java alokasi memory untuk object
         * -Java memanggil constructor
         * -object siap digunakan
         *
         * ------------------------------------
         * 
         * Default Constructor
         * 
         * Jika kita tidak membuat constructor, Java otomatis membuat default constructor.
         * Contoh:
         * class Box {
         *     double width;
         *     double height;
         *     double depth;
         * }
         *
         * Java otomatis membuat:
         * Box() {
         * }
         *
         * Nilai default variabel
         * Tipe	        Nilai default
         * int	        0
         * double	    0.0
         * boolean	    false
         * object	    null
         *
         * Contoh:
         * class Test {
         *     int a;
         * }
         *
         * public class Demo {
         *     public static void main(String[] args) {
         *
         *         Test t = new Test();
         *
         *         System.out.println(t.a);
         *     }
         * }
         *
         * Output
         * 0
         *
         * Hal Penting: Default Constructor Hilang
         * Jika kita membuat constructor sendiri:
         * class Box {
         *
         *     Box() {
         *     }
         *
         * }
         *
         * Maka default constructor Java tidak dibuat lagi.
         */

        /**
         * Inti Konsep Constructor
         *
         * Singkatnya:
         * Constructor digunakan untuk:
         * mengisi nilai awal object
         * mempersiapkan object
         * memastikan object siap digunakan
         * Dan dipanggil otomatis saat object dibuat.
         */

    }
}
