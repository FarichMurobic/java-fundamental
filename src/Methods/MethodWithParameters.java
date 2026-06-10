package Methods;

    /**
     * Parameter
     *
     * Parameter adalah variabel yang didefinisikan di dalam method.
     * Walaupun beberapa method tidak membutuhkan parameter, kebanyakan method menggunakan parameter.
     * 
     * Parameter memungkinkan sebuah method menjadi lebih umum (generalized).
     * Artinya, method tersebut dapat bekerja dengan berbagai macam data atau digunakan dalam berbagai situasi yang sedikit berbeda.
     * 
     * Untuk menjelaskan hal ini, kita gunakan contoh sederhana.
     * Berikut adalah method yang mengembalikan kuadrat dari angka 10:
     * 
     * int square() {
     *     return 10 * 10;
     * }
     *
     * Walaupun method ini benar-benar mengembalikan nilai 10², penggunaannya sangat terbatas.
     *
     * Namun jika method tersebut dimodifikasi agar menerima parameter, seperti berikut:
     * 
     * int square(int i) {
     *     return i * i;
     * }
     *
     * Sekarang method square() dapat mengembalikan kuadrat dari nilai apa pun yang diberikan.
     * Artinya method tersebut sekarang menjadi general-purpose method 
     * yang bisa menghitung kuadrat dari angka apa pun, bukan hanya 10.
     *
     * --------------------------------------------------------
     * 
     * Konsep Penting: Parameter vs Argument
     * 
     * Parameter
     * Parameter adalah variabel yang didefinisikan di dalam method.
     * Contoh:
     * int square(int i)
     * i adalah parameter.
     *
     * Argument
     * Argument adalah nilai yang dikirim ke method saat method dipanggil.
     * Contoh:
     * square(100)
     * 100 adalah argument.
     *
     * ---------------------------------------------------------
     * 
     * Penjelasan Konsep Parameter
     *
     * Parameter membuat method lebih fleksibel.
     * Tanpa parameter:
     * 
     * int square() {
     *     return 10 * 10;
     * }
     *
     * Hanya bisa menghitung:
     * 100
     *
     * Dengan parameter:
     * 
     * int square(int i) {
     *     return i * i;
     * }
     *
     * Bisa menghitung:
     * square(2)
     * square(5)
     * square(20)
     * square(100)
     */

    /**
     * Penerapan Parameter di Class Box
     * 
     * Di contoh sebelumnya, kita mengatur ukuran box seperti ini:
     * mybox1.width = 10;
     * mybox1.height = 20;
     * mybox1.depth = 15;
     *
     * Walaupun ini bekerja, buku mengatakan ini bukan desain yang baik karena dua alasan.
     *
     * Masalah 1: Tidak praktis
     * Kode jadi panjang.
     * mybox.width = 10;
     * mybox.height = 20;
     * mybox.depth = 15;
     *
     * Masalah 2: Rawan kesalahan
     * Bisa saja lupa set salah satu nilai.
     *
     * Misalnya:
     * mybox.width = 10;
     * mybox.height = 20;
     * // lupa set depth
     *
     * Masalah 3: Melanggar prinsip OOP
     *
     * Dalam program Java yang baik:
     * instance variable seharusnya diakses melalui method
     * Ini adalah bagian dari konsep encapsulation.
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
