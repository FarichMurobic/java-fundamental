package FundamentalJava.Generics;

/**
 * Overloading Method pada Generic Class
 *
 * Salah satu keterbatasan Generic di Java adalah:
 * method tidak dapat dioverload hanya berdasarkan
 * parameter bertipe generic yang berbeda.
 *
 * Penyebab utamanya adalah:
 * Type Erasure..
 *
 * ------------------------------------------------------------
 *
 * Contoh
 *
 * class MyGenClass<T, V> {
 *
 * T ob1;
 * V ob2;
 *
 * void set(T value) {
 * ob1 = value;
 * }
 *
 * void set(V value) {
 * ob2 = value;
 * }
 * }
 *
 * Sekilas terlihat valid karena:
 *
 * set(T)
 * set(V)
 *
 * tampak seperti dua method yang berbeda.
 *
 * Namun sebenarnya kode di atas TIDAK bisa dikompilasi.
 *
 * Compiler akan menghasilkan error seperti:
 *
 * name clash:
 * set(V) and set(T) have the same erasure
 *
 * ------------------------------------------------------------
 *
 * Penyebab Utama: Type Erasure
 *
 * Generic di Java hanya digunakan saat proses kompilasi
 * (compile-time).
 *
 * Setelah proses kompilasi selesai,
 * informasi tipe generic akan dihapus (type erasure).
 *
 * Secara konsep,
 * compiler mengubah class di atas menjadi kira-kira seperti ini:
 *
 * class MyGenClass {
 *
 * Object ob1;
 * Object ob2;
 *
 * void set(Object value) {
 * ob1 = value;
 * }
 *
 * void set(Object value) {
 * ob2 = value;
 * }
 * }
 *
 * Sekarang terlihat masalahnya:
 *
 * Kedua method memiliki signature yang sama:
 *
 * set(Object)
 * set(Object)
 *
 * Java tidak mengizinkan dua method dengan signature identik,
 * sehingga terjadi name clash.
 *
 * ------------------------------------------------------------
 *
 * Mengapa Overloading Gagal?
 *
 * Di Java,
 * overloading ditentukan berdasarkan method signature,
 * yaitu:
 *
 * - nama method
 * - jumlah parameter
 * - tipe parameter
 *
 * Return type maupun parameter generic
 * tidak ikut menentukan overload.
 *
 * Setelah type erasure,
 * parameter generic biasanya berubah menjadi:
 *
 * Object
 *
 * atau
 *
 * bound type (jika menggunakan extends).
 *
 * Akibatnya,
 * dua method yang awalnya tampak berbeda
 * bisa berubah menjadi identik.
 *
 * ------------------------------------------------------------
 *
 * Bagaimana Jika Generic Memiliki Bound?
 *
 * Misalnya:
 *
 * class MyGenClass<T, V extends Number> {
 *
 * void set(T value) { }
 *
 * void set(V value) { }
 * }
 *
 * Setelah type erasure,
 * compiler melihatnya sebagai:
 *
 * void set(Object value)
 * void set(Number value)
 *
 * Karena Object dan Number berbeda,
 * contoh di atas VALID dan dapat dikompilasi.
 *
 * Namun hal ini hanya berlaku karena hasil erasure
 * menghasilkan tipe parameter yang berbeda.
 *
 * ------------------------------------------------------------
 *
 * Kesalahpahaman yang Sering Terjadi
 *
 * Banyak yang mengira:
 *
 * MyGenClass<Number, Number>
 *
 * akan membuat dua method berubah menjadi:
 *
 * set(Number)
 * set(Number)
 *
 * lalu menjadi error.
 *
 * Itu tidak benar.
 *
 * Yang menentukan valid atau tidaknya overload
 * adalah proses compile pada generic class,
 * bukan saat generic diinstansiasi.
 *
 * Setelah class berhasil dikompilasi,
 * instansiasi generic tidak akan mengubah
 * method signature yang sudah dihasilkan compiler.
 *
 * ------------------------------------------------------------
 *
 * Best Practice
 *
 * Hindari membuat overload seperti:
 *
 * void set(T value)
 * void set(V value)
 *
 * karena mudah menimbulkan konflik akibat type erasure.
 *
 * Sebaiknya gunakan nama method yang berbeda,
 * misalnya:
 *
 * void setFirst(T value) {
 * ob1 = value;
 * }
 *
 * void setSecond(V value) {
 * ob2 = value;
 * }
 *
 * atau gunakan satu method:
 *
 * void set(T first, V second) {
 * ob1 = first;
 * ob2 = second;
 * }
 *
 * Pendekatan ini lebih jelas,
 * lebih aman,
 * dan menghindari masalah name clash.
 *
 * ------------------------------------------------------------
 *
 * Cara Berpikir yang Benar
 *
 * Saat membuat Generic,
 * biasakan bertanya:
 *
 * "Setelah type erasure, parameter method ini menjadi apa?"
 *
 * Jika dua method menghasilkan signature yang sama
 * setelah type erasure,
 * maka overload tersebut tidak valid.
 *
 * ------------------------------------------------------------
 *
 * Hubungan dengan Materi Generic Lainnya
 *
 * Masalah ini berkaitan langsung dengan:
 *
 * - Type Erasure
 * - Raw Type
 * - Bridge Method
 * - Batasan instanceof pada Generic
 *
 * Semuanya berasal dari fakta bahwa
 * informasi tipe generic tidak dipertahankan saat runtime.
 *
 * ------------------------------------------------------------
 *
 * Ringkasan
 *
 * - Overloading ditentukan berdasarkan method signature.
 * - Generic tidak ikut menentukan overload.
 * - Setelah type erasure, parameter generic biasanya menjadi
 * Object atau bound type.
 * - Jika dua method memiliki signature yang sama setelah erasure,
 * compiler akan menghasilkan name clash.
 * - Gunakan nama method yang berbeda apabila method menerima
 * parameter generic yang berbeda untuk menghindari konflik.
 */

public class AmbiguityErrors {
    public static void main(String[] args) {

    }
}
