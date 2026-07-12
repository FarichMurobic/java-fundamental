package FundamentalJava.Methods.MethodReference;

/*
 * ============================================================
 * Constructor Reference Sebagai Factory Method
 * ============================================================
 *
 * Contoh sebelumnya hanya menunjukkan cara kerja constructor
 * reference.
 *
 * Namun manfaat sebenarnya terlihat ketika constructor reference
 * digunakan untuk membuat object secara fleksibel.
 *
 * Salah satu penggunaan nyata adalah membuat:
 *
 * Generic Factory Method
 *
 * Yaitu sebuah method yang dapat membuat berbagai jenis object
 * tanpa harus mengetahui detail pembuatan object tersebut.
 *
 * ------------------------------------------------------------
 * Konsep Besar
 * ------------------------------------------------------------
 *
 * Perhatikan method berikut:
 *
 * static <R, T> R myClassFactory(
 *         MyFunc<R, T> cons,
 *         T value
 * )
 *
 *
 * Artinya:
 *
 * "Berikan saya sebuah constructor,
 * kemudian saya akan menggunakan constructor tersebut untuk
 * membuat object."
 *
 *
 * Constructor dikirim sebagai parameter:
 *
 * MyClass<Double>::new
 *
 *
 * Jadi factory tidak perlu tahu bagaimana object dibuat.
 *
 * Factory hanya menjalankan constructor yang diberikan.
 *
 * ------------------------------------------------------------
 * Constructor Reference
 * ------------------------------------------------------------
 *
 * Contoh:
 *
 * MyFunc<MyClass<Double>, Double> cons1 =
 *         MyClass<Double>::new;
 *
 *
 * Constructor reference tersebut setara dengan lambda:
 *
 * value -> new MyClass<Double>(value)
 *
 *
 * Artinya:
 *
 * Jika diberikan sebuah nilai Double,
 * buat object MyClass<Double>.
 *
 * ------------------------------------------------------------
 * Cara Kerja Factory Method
 * ------------------------------------------------------------
 *
 * Pemanggilan:
 *
 * myClassFactory(cons1, 100.1);
 *
 *
 * Data yang dikirim:
 *
 * Constructor:
 *
 * MyClass<Double>::new
 *
 *
 * Nilai:
 *
 * 100.1
 *
 *
 * Di dalam factory:
 *
 * return cons.func(value);
 *
 *
 * Maka yang sebenarnya terjadi:
 *
 * return new MyClass<Double>(100.1);
 *
 *
 * Object berhasil dibuat tanpa menulis keyword new secara
 * langsung di kode pemanggil.
 *
 * ------------------------------------------------------------
 * Gambaran Alur
 * ------------------------------------------------------------
 *
 * Constructor Reference:
 *
 * MyClass::new
 *
 *        |
 *        v
 *
 * Functional Interface
 *
 *        |
 *        v
 *
 * Factory Method
 *
 *        |
 *        v
 *
 * Object baru dibuat
 *
 * ------------------------------------------------------------
 * Kenapa Ini Berguna?
 * ------------------------------------------------------------
 *
 * Tanpa factory:
 *
 * MyClass<Integer> a =
 *         new MyClass<>(10);
 *
 * MyClass<Double> b =
 *         new MyClass<>(10.5);
 *
 *
 * Kode pemanggil harus mengetahui detail pembuatan object.
 *
 *
 * Dengan factory:
 *
 * MyClass<Integer> a =
 *         create(MyClass<Integer>::new, 10);
 *
 *
 * Factory menangani proses pembuatan object.
 *
 * ------------------------------------------------------------
 * Konsep Factory Method
 * ------------------------------------------------------------
 *
 * Factory method adalah metode yang bertugas membuat object.
 *
 * Keuntungan:
 *
 * - Proses pembuatan object terpusat.
 * - Kode lebih fleksibel.
 * - Detail implementasi object dapat disembunyikan.
 *
 *
 * Factory dapat menerima berbagai constructor.
 *
 * Contoh:
 *
 * MyClass<Integer>::new
 *
 * atau:
 *
 * MyClass<Double>::new
 *
 *
 * Dengan method factory yang sama.
 *
 * ------------------------------------------------------------
 * Apakah Constructor Adalah First-Class Citizen?
 * ------------------------------------------------------------
 *
 * Dalam Java, constructor bukan first-class citizen secara
 * langsung.
 *
 * Java tidak memperlakukan constructor sebagai object yang dapat
 * disimpan secara bebas.
 *
 * Tetapi Java menyediakan:
 *
 * Constructor Reference
 *
 * menggunakan:
 *
 * ::
 *
 *
 * Constructor reference dapat diperlakukan sebagai nilai karena
 * disimpan melalui functional interface.
 *
 * Contoh:
 *
 * Function<String, User> creator =
 *         User::new;
 *
 *
 * Di sini yang disimpan bukan constructor secara langsung,
 * melainkan implementasi Function yang tahu cara memanggil
 * constructor tersebut.
 *
 * ------------------------------------------------------------
 * Hubungan Dengan Functional Interface
 * ------------------------------------------------------------
 *
 * Constructor reference selalu membutuhkan functional interface.
 *
 * Contoh:
 *
 * Function<Integer, User> factory =
 *         User::new;
 *
 *
 * Functional interface menjadi kontrak:
 *
 * Input:
 *
 * Integer
 *
 * Output:
 *
 * User
 *
 *
 * Tanpa functional interface Java tidak tahu bagaimana constructor
 * tersebut digunakan.
 *
 * ------------------------------------------------------------
 * Insight Dunia Nyata
 * ------------------------------------------------------------
 *
 * Konsep seperti ini banyak digunakan dalam framework modern.
 *
 * Contoh penggunaan:
 *
 * - Factory object creation.
 * - Dependency Injection.
 * - Object mapping.
 * - Framework internal.
 *
 *
 * Dalam Spring Boot, konsep serupa terlihat ketika framework
 * membuat dan mengelola object melalui:
 *
 * - Bean creation.
 * - Application context.
 * - Dependency injection container.
 *
 * ------------------------------------------------------------
 * Analogi Sederhana
 * ------------------------------------------------------------
 *
 * Functional Interface:
 *
 * Blueprint atau aturan mesin.
 *
 *
 * Constructor Reference:
 *
 * Mesin pembuat object.
 *
 *
 * Factory Method:
 *
 * Operator yang menggunakan mesin tersebut.
 *
 *
 * Kita cukup mengatakan:
 *
 * "Gunakan mesin ini untuk membuat object dengan data ini."
 *
 *
 * Factory yang menangani proses pembuatannya.
 *
 * ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * Constructor reference memungkinkan constructor digunakan
 * sebagai referensi melalui functional interface.
 *
 * Dengan konsep ini kita dapat membuat factory method yang:
 *
 * - Generic.
 * - Reusable.
 * - Tidak bergantung pada class tertentu.
 *
 * Konsep penting:
 *
 * - Class dapat dikirim sebagai pembuat object melalui constructor
 *   reference.
 * - Factory dapat membuat object tanpa mengetahui detail class.
 * - Functional interface menjadi penghubung antara constructor
 *   dan factory.
 *
 * Prinsip utama:
 *
 * "Berikan cara membuat object, bukan beri tahu bagaimana cara
 * membuatnya."
 *
 */

// Functional interface generic
interface Fungsi<R, T> {

    // R = return type (object yg dibuat)
    // T = parameter constructor
    R fungsi(T n);
}

// Class generic
class Kelas<T> {
    private T val;

    // Constructor dengan parameter
    Kelas(T v) {
        val = v;
    }

    // Default constructor (tidak dipakai di sini)
    Kelas() {
        val = null;
    }

    T getVal() {
        return val;
    }
}

// Class non-generic
class Kelas2 {
    String str;

    // Constructor dengan parameter
    Kelas2(String s) {
        str = s;
    }

    // Default constructor
    Kelas2() {
        str = "";
    }

    String getStr() {
        return str;
    }
}

public class MethodReferenceConstructorRealCase {
    // FACTORY METHOD GENERIC
    static <R, T> R myClassFactory(Fungsi<R, T> cons, T v) {
        // Memanggil constructor lewat lambda/method reference
        return cons.fungsi(v);
    }

    public static void main(String[] args) {

        // CASE 1: MyClass<Double>
        Fungsi<Kelas, Double> cons1 = Kelas<Double>::new;
        Kelas<Double> obj1 = myClassFactory(cons1, 100.1);
        System.out.println("val in obj1 = " + obj1.getVal());

        System.out.println();

        // CASE 2: MyClass2
        Fungsi<Kelas2, String> cons2 = Kelas2::new;
        Kelas2 obj2 = myClassFactory(cons2, "Lambda");
        System.out.println("val in obj2 = " + obj2.getStr());

    }
}
