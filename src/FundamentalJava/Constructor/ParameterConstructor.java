package FundamentalJava.Constructor;

    /**
     * Walaupun constructor Box() pada contoh sebelumnya memang bisa menginisialisasi objek Box,
     * tetapi sebenarnya tidak terlalu berguna, karena semua box memiliki ukuran yang sama.
     * Yang dibutuhkan adalah cara untuk membuat objek Box dengan berbagai ukuran yang berbeda.
     * Solusi paling mudah adalah menambahkan parameter pada constructor.
     * Seperti yang bisa kamu tebak, hal ini membuat constructor menjadi jauh lebih berguna.
     * Sebagai contoh, versi Box berikut mendefinisikan parameterized constructor yang mengatur
     * dimensi box sesuai dengan nilai parameter yang diberikan.
     *
     * ----------------------------
     * 
     * Definisi
     * Parameterized Constructor adalah constructor yang memiliki parameter.
     * Parameter ini digunakan untuk mengirim nilai saat object dibuat.
     *
     * Contoh konsep:
     * Constructor sebelumnya:
     * Box()
     * Tidak menerima nilai apa pun.
     *
     * Akibatnya semua object:
     * width = 10
     * height = 10
     * depth = 10
     *
     * Semua sama.
     * Dengan Parameterized Constructor
     * Box(double w, double h, double d)
     * Sekarang object bisa punya ukuran berbeda.
     *
     * Contoh:
     * Box(10,20,15)
     * Box(3,6,9)
     * Box(100,200,50)
     *
     * --------------------------------------
     * 
     * Hal Penting yang Harus Dipahami
     * Baris ini sangat penting:
     * Box mybox1 = new Box(10, 20, 15);
     *
     * Yang sebenarnya terjadi:
     * new Box(10,20,15)
     *
     * Java memanggil constructor:
     * Box(double w, double h, double d)
     * Nilai dikirim ke parameter.
     *
     * Parameter
     * Variabel yang ada di method / constructor.
     * Contoh:
     * Box(double w, double h, double d)
     * w h d = parameter
     *
     * Argument
     * Nilai yang dikirim saat method dipanggil.
     * Contoh:
     * new Box(10,20,15)
     * 10 20 15 = argument
     *
     * Hubungannya
     * Argument → Parameter
     * 10 → w
     * 20 → h
     * 15 → d
     *
     * ------------------------------------------
     * 
     * Inti Konsep Parameterized Constructor
     * Tanpa parameter:
     * Box()
     * Semua object sama.
     *
     * Dengan parameter:
     * Box(w,h,d)
     * Setiap object bisa berbeda.
     *
     * Contoh:
     * Box(10,20,30)
     * Box(5,6,7)
     * Box(100,200,300)
     *
     * Ini membuat class lebih fleksibel dan reusable.
     */

public class ParameterConstructor {

    double width;
    double height;
    double depth;

    // membuat konstruktor dengan parameter
    ParameterConstructor(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    // methode return value
    double volume() {
        return width * height * depth;
    }

    public static void main(String[] args) {

        ParameterConstructor myBox1 = new ParameterConstructor(10, 10, 10);
        ParameterConstructor myBox2 = new ParameterConstructor(100, 9, 54);

        double vol = myBox1.volume();
        System.out.println(vol); // 1000.0

        vol = myBox2.volume();
        System.out.println(vol); // 48600.0

        // untuk mengetahui nilai variabel vol di objek kedua setelah dipake objek pertama
        System.out.println(100 * 9 * 54); // 48600

    }
}
