package FundamentalJava.Generics;

/* ============================================================
 *                   GENERIC CONSTRUCTOR
 * ============================================================
 *
 * Generic constructor adalah constructor yang memiliki
 * type parameter sendiri.
 *
 * Berbeda dengan generic class, type parameter pada generic
 * constructor hanya berlaku di dalam constructor tersebut.
 *
 * Oleh karena itu, sebuah class tidak harus menjadi generic
 * untuk memiliki generic constructor.
 */


/* ------------------------------------------------------------
 * Bentuk Umum
 * ------------------------------------------------------------
 *
 * class GenCons {
 *
 *     <T> GenCons(T arg) {
 *         ...
 *     }
 *
 * }
 *
 * Perhatikan bahwa type parameter (<T>) ditulis sebelum
 * nama constructor.
 *
 * Type parameter tersebut hanya berlaku pada constructor,
 * bukan pada keseluruhan class.
 */


/* ------------------------------------------------------------
 * Generic Constructor dengan Bound
 * ------------------------------------------------------------
 *
 * Generic constructor juga dapat menggunakan bounded type
 * parameter.
 *
 * Contoh:
 *
 * <T extends Number> GenCons(T arg)
 *
 * Artinya:
 *
 * T harus bertipe Number atau subclass dari Number.
 *
 * Dengan demikian constructor dapat menerima:
 *
 * Integer
 * Long
 * Float
 * Double
 *
 * Namun tidak dapat menerima:
 *
 * String
 *
 * karena String bukan turunan dari Number.
 */


/* ------------------------------------------------------------
 * Type Inference pada Generic Constructor
 * ------------------------------------------------------------
 *
 * Misalnya terdapat kode berikut:
 *
 * GenCons obj = new GenCons(100);
 *
 * Compiler secara otomatis melakukan type inference sehingga:
 *
 * T = Integer
 *
 * Contoh lain:
 *
 * GenCons obj = new GenCons(123.5F);
 *
 * Compiler akan menyimpulkan bahwa:
 *
 * T = Float
 *
 * Programmer tidak perlu menentukan type argument secara
 * eksplisit karena compiler mampu menginferensikannya
 * dari argumen yang diberikan.
 */


/* ------------------------------------------------------------
 * Mengapa Menggunakan Generic Constructor?
 * ------------------------------------------------------------
 *
 * Tujuan utama generic constructor adalah memberikan
 * fleksibilitas terhadap tipe argumen yang diterima,
 * tanpa mengorbankan type safety.
 *
 * Generic constructor memungkinkan constructor menerima
 * berbagai tipe data yang masih memenuhi batas (bound)
 * yang telah ditentukan.
 */


/* ------------------------------------------------------------
 * Perbedaan dengan Constructor Biasa
 * ------------------------------------------------------------
 *
 * Misalnya constructor biasa ditulis seperti berikut:
 *
 * GenCons(Number arg)
 *
 * Constructor tersebut memang dapat menerima berbagai
 * subclass Number.
 *
 * Namun generic constructor memberikan keuntungan tambahan,
 * yaitu:
 *
 * - Memanfaatkan mekanisme generic pada compile-time.
 * - Dapat menggunakan bounded type parameter.
 * - Lebih fleksibel ketika dikombinasikan dengan generic method
 *   atau generic class.
 * - Menjaga type safety tanpa perlu melakukan casting manual.
 *
 * Oleh karena itu, generic constructor sering digunakan
 * dalam library maupun framework Java.
 */


/* ------------------------------------------------------------
 * Kapan Generic Constructor Digunakan?
 * ------------------------------------------------------------
 *
 * Generic constructor umumnya digunakan ketika:
 *
 * - Class bukan merupakan generic class, tetapi constructor
 *   perlu menerima berbagai tipe data.
 *
 * - Constructor ingin membatasi tipe tertentu menggunakan
 *   bounded type parameter.
 *
 * - Constructor melakukan proses inisialisasi yang bergantung
 *   pada parameter generic.
 */


/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * - Constructor dapat memiliki type parameter sendiri.
 *
 * - Type parameter ditulis sebelum nama constructor.
 *
 *      <T> NamaConstructor(...)
 *
 * - Generic constructor dapat menggunakan bound.
 *
 *      <T extends Number>
 *
 * - Class tidak harus menjadi generic agar dapat memiliki
 *   generic constructor.
 *
 * - Compiler melakukan type inference secara otomatis terhadap
 *   type parameter constructor.
 *
 * - Generic constructor memberikan fleksibilitas sekaligus
 *   menjaga type safety selama proses compile-time.
 */


/* ------------------------------------------------------------
 * Insight
 * ------------------------------------------------------------
 *
 * Generic constructor tidak digunakan sesering generic class
 * atau generic method, tetapi tetap memiliki peran penting
 * dalam pembuatan API yang fleksibel.
 *
 * Konsep ini banyak dijumpai pada library Java maupun framework
 * modern yang membutuhkan proses inisialisasi object dengan
 * berbagai tipe data tanpa mengorbankan keamanan tipe (type safety).
 */

// Class bukan generic
class GenCons {
    private double val;

    // Constructor Generic 
    // Menerima semua tipe turunan NUMBER
    <T extends Number> GenCons(T arg) { 
        val = arg.doubleValue();
    }

    void showVal() {
        System.out.println("Val: " + val);
    }
}

public class GenericConstructor {
    public static void main(String[] args) {
        
        // Test kirim integer
        GenCons test = new GenCons(180);
        
        // Test kirim float
        GenCons testing = new GenCons(10.0F);

        // TAMPILKAN
        test.showVal();
        testing.showVal();


        // Testing String
        // ERROR WKWK
        // GenCons testString = new GenCons("JANERA"); // UNDEFINED

        // Test char
        // ERROR 
        // GenCons cons = new GenCons('J'); // UNDEFINED
    }

}
