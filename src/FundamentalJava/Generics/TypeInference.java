package FundamentalJava.Generics;

/* ============================================================
 *                    DIAMOND OPERATOR (<>)
 * ============================================================
 *
 * Sebelum Java 7, saat membuat object dari generic class,
 * type argument harus ditulis secara lengkap pada kedua sisi
 * assignment...
 *
 * Sejak Java 7, compiler dapat menyimpulkan (infer)
 * type argument secara otomatis berdasarkan konteks.
 *
 * Fitur ini dikenal sebagai:
 *
 * - Type Inference
 * - Diamond Operator (<>)
 */

/* ------------------------------------------------------------
 * Sebelum Java 7
 * ------------------------------------------------------------
 *
 * Penulisan lama:
 *
 * MyClass<Integer, String> obj =
 *     new MyClass<Integer, String>(98, "A String");
 *
 * Type argument harus ditulis dua kali:
 *
 * - Pada deklarasi variabel.
 * - Pada pembuatan object.
 *
 * Penulisan ini benar, tetapi cukup verbose
 * (terlalu panjang dan repetitif).
 */

/* ------------------------------------------------------------
 * Sejak Java 7
 * ------------------------------------------------------------
 *
 * Penulisan modern:
 *
 * MyClass<Integer, String> obj =
 *     new MyClass<>(98, "A String");
 *
 * Tanda <> disebut Diamond Operator.
 *
 * Compiler akan menyimpulkan bahwa:
 *
 * T → Integer
 * V → String
 *
 * berdasarkan type argument yang terdapat
 * pada sisi kiri assignment.
 */

/* ------------------------------------------------------------
 * Cara Kerja Diamond Operator
 * ------------------------------------------------------------
 *
 * Misalnya:
 *
 * MyClass<Integer, String> obj =
 *     new MyClass<>(98, "A String");
 *
 * Compiler melihat deklarasi variabel:
 *
 * MyClass<Integer, String>
 *
 * sehingga compiler mengetahui bahwa constructor
 * harus menghasilkan object bertipe:
 *
 * MyClass<Integer, String>
 *
 * Oleh karena itu, type argument di sisi kanan
 * tidak perlu ditulis kembali.
 */

/* ------------------------------------------------------------
 * Type Inference pada Method
 * ------------------------------------------------------------
 *
 * Type inference tidak hanya digunakan saat membuat object,
 * tetapi juga ketika memanggil method generic.
 *
 * Contoh:
 *
 * obj1.isSame(new MyClass<>(10, "Hello"));
 *
 * Compiler menggunakan parameter method sebagai konteks
 * untuk menentukan type argument yang sesuai.
 *
 * Selama informasi tipe dapat disimpulkan dengan jelas,
 * penulisan type argument secara eksplisit tidak diperlukan.
 */

/* ------------------------------------------------------------
 * Hubungan dengan Type Erasure
 * ------------------------------------------------------------
 *
 * Diamond Operator hanya mempermudah proses kompilasi.
 *
 * Setelah proses kompilasi selesai,
 * informasi generic tetap akan dihapus melalui
 * mekanisme type erasure.
 *
 * Dengan kata lain:
 *
 * - Compile-time  → compiler mengetahui type argument.
 * - Runtime       → type argument sudah tidak tersedia.
 */

/* ------------------------------------------------------------
 * Praktik Terbaik
 * ------------------------------------------------------------
 *
 * Diamond Operator membuat kode menjadi lebih ringkas
 * tanpa mengurangi type safety.
 *
 * Namun, tetap gunakan secara bijak.
 *
 * Pada deklarasi yang terlalu kompleks,
 * penulisan yang lebih eksplisit terkadang lebih mudah
 * dipahami oleh pengembang lain.
 *
 * Tujuan utamanya bukan sekadar menyingkat kode,
 * tetapi menjaga keterbacaan (readability).
 */

/* ------------------------------------------------------------
 * Contoh Penggunaan pada Java Collections Framework
 * ------------------------------------------------------------
 *
 * Diamond Operator sangat umum digunakan
 * pada class-class koleksi Java.
 *
 * Contoh:
 *
 * List<String> list = new ArrayList<>();
 *
 * Map<String, Integer> map = new HashMap<>();
 *
 * Set<Double> set = new HashSet<>();
 *
 * Penulisan seperti ini merupakan standar
 * dalam pengembangan aplikasi Java modern.
 */

/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * - Diamond Operator ditulis menggunakan <>.
 *
 * - Diperkenalkan pada Java 7.
 *
 * - Memanfaatkan mekanisme type inference untuk
 *   menyimpulkan type argument secara otomatis.
 *
 * - Mengurangi penulisan type argument yang berulang
 *   tanpa mengurangi type safety.
 *
 * - Sangat umum digunakan pada generic class maupun
 *   Java Collections Framework.
 */

/* ------------------------------------------------------------
 * Insight
 * ------------------------------------------------------------
 *
 * Diamond Operator merupakan fitur sintaksis
 * (syntactic sugar) yang membuat penulisan generic
 * lebih sederhana.
 *
 * Meskipun terlihat berbeda pada source code,
 * hasil kompilasi tetap memiliki perilaku yang sama
 * dengan penulisan generic secara lengkap.
 *
 * Dengan kata lain, Diamond Operator meningkatkan
 * keterbacaan kode tanpa mengubah cara kerja
 * generics di dalam JVM.
 */

class BedRoom<T, V> {
    T badroom1;
    V badroom2;

    BedRoom(T a, V b) {
        badroom1 = a;
        badroom2 = b;
    }

    // method untuk cek apakah isi method sama
    boolean isSame(BedRoom<T, V> o) {
        // bandingkan isi object
        if (badroom1.equals(o.badroom1) && badroom2.equals(o.badroom2)) {
            return true;
        }
        return false;
    }
}

public class TypeInference {
    public static void main(String[] args) {

        // Cara lama panjang
        BedRoom<Integer, String> objek1 = new BedRoom<Integer, String>(10, "Hello");
        // cara baru lebih clean
        BedRoom<Integer, String> objek2 = new BedRoom<>(10, "Hello"); // type inference

        // CEK apakah sama?
        if (objek1.isSame(objek2)) {
            System.out.println("objek sama");
        }

        // Langsung buat objek tanpa nulis tipe di kanan
        if (objek1.isSame(new BedRoom<>(10, "Hello"))) {
            System.out.println("object sama juga (langsung new)");
        }
    }
}
