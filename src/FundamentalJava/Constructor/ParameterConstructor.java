package FundamentalJava.Constructor;

/**
 * ------------------------------------------------------------------------
 * PARAMETERIZED CONSTRUCTOR
 * ------------------------------------------------------------------------
 *
 * Pada contoh sebelumnya, constructor tanpa parameter (Default
 * Constructor) memang dapat menginisialisasi object Box.
 *
 * Namun pendekatan tersebut memiliki keterbatasan karena setiap
 * object yang dibuat akan memiliki nilai awal yang sama.
 *
 * Contoh:
 *
 * Box() {
 *     width = 10;
 *     height = 10;
 *     depth = 10;
 * }
 *
 * Akibatnya:
 *
 * Box box1 = new Box();
 * Box box2 = new Box();
 * Box box3 = new Box();
 *
 * Seluruh object memiliki dimensi yang sama.
 *
 * Dalam aplikasi nyata, biasanya kita membutuhkan object yang
 * memiliki nilai awal berbeda-beda.
 *
 * Untuk mengatasi hal tersebut, digunakan Parameterized
 * Constructor.
 *
 * ------------------------------------------------------------------------
 * DEFINISI PARAMETERIZED CONSTRUCTOR
 * ------------------------------------------------------------------------
 *
 * Parameterized Constructor adalah constructor yang memiliki
 * parameter.
 *
 * Parameter tersebut digunakan untuk menerima nilai saat object
 * dibuat sehingga setiap object dapat memiliki state yang berbeda.
 *
 * Contoh:
 *
 * Box(double w, double h, double d) {
 *     width = w;
 *     height = h;
 *     depth = d;
 * }
 *
 * Pada constructor di atas:
 *
 * - w mewakili width.
 * - h mewakili height.
 * - d mewakili depth.
 *
 * Nilai yang diterima akan digunakan untuk menginisialisasi
 * object yang sedang dibuat.
 *
 * ------------------------------------------------------------------------
 * MENGAPA PARAMETERIZED CONSTRUCTOR DIPERLUKAN?
 * ------------------------------------------------------------------------
 *
 * Tanpa parameter:
 *
 * Box()
 * -> Semua Object Memiliki Nilai Yang Sama
 *
 * Dengan parameter:
 *
 * Box(w, h, d)
 * -> Setiap Object Dapat Memiliki Nilai Berbeda
 *
 * Contoh:
 *
 * Box(10, 20, 15);
 * Box(3, 6, 9);
 * Box(100, 200, 50);
 *
 * Setiap object akan memiliki ukuran yang berbeda sesuai nilai
 * yang diberikan saat pembuatan object.
 *
 * Hal ini membuat class menjadi lebih fleksibel dan reusable.
 *
 * ------------------------------------------------------------------------
 * PROSES PEMBUATAN OBJECT
 * ------------------------------------------------------------------------
 *
 * Perhatikan kode berikut:
 *
 * Box myBox = new Box(10, 20, 15);
 *
 * Yang sebenarnya terjadi:
 *
 * new Box(10, 20, 15)
 * -> Java Mengalokasikan Memory Untuk Object
 * -> Java Memanggil Constructor
 * -> Nilai Argument Dikirim Ke Parameter
 * -> Instance Variable Diinisialisasi
 * -> Object Siap Digunakan
 *
 * Flow:
 *
 * new Box(10, 20, 15)
 * -> Box(double w, double h, double d)
 * -> width = 10
 * -> height = 20
 * -> depth = 15
 * -> Object Siap Digunakan
 *
 * ------------------------------------------------------------------------
 * PARAMETER VS ARGUMENT
 * ------------------------------------------------------------------------
 *
 * Salah satu konsep yang sering membingungkan pemula adalah
 * perbedaan antara Parameter dan Argument.
 *
 * ------------------------------------------------------------------------
 * PARAMETER
 * ------------------------------------------------------------------------
 *
 * Parameter adalah variabel yang dideklarasikan pada method
 * atau constructor.
 *
 * Contoh:
 *
 * Box(double w, double h, double d)
 *
 * Parameter:
 *
 * - w
 * - h
 * - d
 *
 * Parameter hanya berfungsi sebagai penampung nilai yang akan
 * diterima saat constructor dipanggil.
 *
 * ------------------------------------------------------------------------
 * ARGUMENT
 * ------------------------------------------------------------------------
 *
 * Argument adalah nilai yang dikirim ketika method atau
 * constructor dipanggil.
 *
 * Contoh:
 *
 * new Box(10, 20, 15);
 *
 * Argument:
 *
 * - 10
 * - 20
 * - 15
 *
 * ------------------------------------------------------------------------
 * HUBUNGAN PARAMETER DAN ARGUMENT
 * ------------------------------------------------------------------------
 *
 * Argument
 * -> Parameter
 *
 * 10
 * -> w
 *
 * 20
 * -> h
 *
 * 15
 * -> d
 *
 * Flow:
 *
 * Argument
 * -> Parameter
 * -> Instance Variable
 *
 * 10
 * -> w
 * -> width
 *
 * 20
 * -> h
 * -> height
 *
 * 15
 * -> d
 * -> depth
 *
 * ------------------------------------------------------------------------
 * CONTOH HASIL PEMBUATAN OBJECT
 * ------------------------------------------------------------------------
 *
 * Box box1 = new Box(10, 20, 30);
 * Box box2 = new Box(5, 6, 7);
 * Box box3 = new Box(100, 200, 300);
 *
 * Hasil:
 *
 * box1
 * -> width = 10
 * -> height = 20
 * -> depth = 30
 *
 * box2
 * -> width = 5
 * -> height = 6
 * -> depth = 7
 *
 * box3
 * -> width = 100
 * -> height = 200
 * -> depth = 300
 *
 * Setiap object memiliki state yang berbeda walaupun dibuat
 * dari class yang sama.
 *
 * ------------------------------------------------------------------------
 * KEUNTUNGAN PARAMETERIZED CONSTRUCTOR
 * ------------------------------------------------------------------------
 *
 * - Membuat object lebih fleksibel.
 *
 * - Mengurangi kebutuhan mengubah nilai setelah object dibuat.
 *
 * - Membuat object langsung siap digunakan.
 *
 * - Memungkinkan setiap object memiliki state berbeda.
 *
 * - Meningkatkan reusability class.
 *
 * ------------------------------------------------------------------------
 * HUBUNGAN DENGAN OOP
 * ------------------------------------------------------------------------
 *
 * Parameterized Constructor mendukung konsep Encapsulation
 * karena object dapat diinisialisasi langsung melalui
 * constructor tanpa harus mengakses field satu per satu.
 *
 * Selain itu, constructor membantu memastikan object berada
 * dalam kondisi valid sejak pertama kali dibuat.
 *
 * ------------------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------------------
 *
 * Parameterized Constructor adalah constructor yang memiliki
 * parameter untuk menerima nilai saat object dibuat.
 *
 * Dengan parameterized constructor:
 *
 * - Setiap object dapat memiliki nilai awal yang berbeda.
 *
 * - Class menjadi lebih fleksibel dan reusable.
 *
 * - Object dapat langsung berada dalam kondisi yang siap
 *   digunakan setelah dibuat.
 *
 * Konsep penting yang harus dipahami:
 *
 * Parameter
 * -> Variabel yang menerima nilai.
 *
 * Argument
 * -> Nilai yang dikirim saat constructor dipanggil.
 *
 * Flow utama:
 *
 * Argument
 * -> Parameter
 * -> Inisialisasi Object
 * -> Object Siap Digunakan
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
