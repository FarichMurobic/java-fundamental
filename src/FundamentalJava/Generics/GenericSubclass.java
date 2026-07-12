package FundamentalJava.Generics;

/* ============================================================
 *          GENERIC SUBCLASS DARI NON-GENERIC SUPERCLASS
 * ============================================================
 *
 * Sebuah generic class dapat mewarisi (extends) class biasa
 * yang tidak menggunakan generic.
 *
 * Artinya:
 *
 * - Superclass tidak memiliki type parameter.
 * - Subclass memiliki satu atau lebih type parameter.
 *
 * Seluruh mekanisme inheritance tetap bekerja sebagaimana
 * inheritance pada class biasa.
 */


/* ------------------------------------------------------------
 * Struktur Inheritance
 * ------------------------------------------------------------
 *
 * Contoh:
 *
 * class NonGen {
 *     ...
 * }
 *
 * class Gen<T> extends NonGen {
 *     ...
 * }
 *
 * Pada contoh tersebut:
 *
 * - NonGen merupakan non-generic superclass.
 * - Gen<T> merupakan generic subclass.
 *
 * Type parameter T hanya dimiliki oleh Gen
 * dan tidak berhubungan dengan superclass.
 */


/* ------------------------------------------------------------
 * Mengapa Superclass Tidak Memiliki <T>?
 * ------------------------------------------------------------
 *
 * Perhatikan deklarasi berikut:
 *
 * class Gen<T> extends NonGen
 *
 * NonGen bukan generic class,
 * sehingga tidak memiliki type parameter.
 *
 * Oleh karena itu, superclass tidak dapat dituliskan sebagai:
 *
 * NonGen<T>
 *
 * karena deklarasi tersebut memang tidak tersedia.
 *
 * Generic hanya berlaku pada class yang memang
 * mendeklarasikan type parameter.
 */


/* ------------------------------------------------------------
 * Alur Type Parameter
 * ------------------------------------------------------------
 *
 * Misalnya dibuat object:
 *
 * Gen<String> obj = new Gen<>("Hello", 47);
 *
 * Compiler menetapkan:
 *
 * T = String
 *
 * Akibatnya:
 *
 * ob  = "Hello"
 * num = 47
 *
 * Ketika dipanggil:
 *
 * obj.getOb();   // Mengembalikan "Hello"
 * obj.getNum();  // Mengembalikan 47
 *
 * Type parameter T hanya memengaruhi member yang
 * dideklarasikan di dalam Gen.
 *
 * Superclass tetap tidak mengetahui keberadaan T.
 */


/* ------------------------------------------------------------
 * Mengapa Hal Ini Valid?
 * ------------------------------------------------------------
 *
 * Generic merupakan fitur yang dimiliki oleh class yang
 * mendeklarasikan type parameter.
 *
 * Karena superclass tidak memiliki generic,
 * maka superclass tidak memiliki kewajiban untuk mengetahui
 * ataupun menggunakan type parameter milik subclass.
 *
 * Dengan kata lain:
 *
 * - Superclass hanya menyediakan perilaku umum.
 * - Subclass dapat menambahkan kemampuan generic
 *   sesuai kebutuhannya.
 */


/* ------------------------------------------------------------
 * Perbedaan dengan Generic Superclass
 * ------------------------------------------------------------
 *
 * Kasus 1:
 *
 * class A<T> { }
 *
 * class B<T> extends A<T> { }
 *
 * Karena superclass memiliki type parameter,
 * subclass harus menentukan atau meneruskan
 * type argument yang digunakan oleh superclass.
 *
 *
 * Kasus 2:
 *
 * class A { }
 *
 * class B<T> extends A { }
 *
 * Karena superclass bukan generic,
 * subclass tidak perlu meneruskan type parameter apa pun.
 *
 * Type parameter hanya berlaku di dalam subclass.
 */


/* ------------------------------------------------------------
 * Kapan Pola Ini Digunakan?
 * ------------------------------------------------------------
 *
 * Pola ini umum digunakan ketika superclass berisi
 * perilaku atau data yang bersifat umum,
 * sedangkan subclass membutuhkan fleksibilitas
 * melalui generic.
 *
 * Contohnya:
 *
 * - Superclass menyimpan informasi dasar.
 * - Subclass menambahkan data dengan tipe yang dapat
 *   ditentukan saat object dibuat.
 */


/* ------------------------------------------------------------
 * Contoh di Dunia Nyata
 * ------------------------------------------------------------
 *
 * Misalnya:
 *
 * class BaseEntity {
 *     int id;
 * }
 *
 * class Response<T> extends BaseEntity {
 *     T data;
 * }
 *
 * Pada contoh tersebut:
 *
 * BaseEntity menangani data umum,
 * seperti id atau informasi dasar lainnya.
 *
 * Response<T> menambahkan data yang fleksibel
 * menggunakan generic.
 *
 * Pendekatan seperti ini banyak digunakan pada
 * framework dan aplikasi enterprise.
 */


/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * - Generic class dapat mewarisi non-generic superclass.
 *
 * - Superclass tidak perlu mengetahui adanya
 *   type parameter milik subclass.
 *
 * - Type parameter hanya berlaku pada class yang
 *   mendeklarasikannya.
 *
 * - Aturan inheritance Java tetap berlaku seperti biasa.
 *
 * - Pola ini sangat umum digunakan untuk memisahkan
 *   data umum pada superclass dan data fleksibel
 *   pada subclass.
 */


/* ------------------------------------------------------------
 * Insight
 * ------------------------------------------------------------
 *
 * Kombinasi antara non-generic superclass dan generic subclass
 * banyak dijumpai dalam pengembangan aplikasi Java modern.
 *
 * Contohnya dapat ditemukan pada:
 *
 * - Response<T>
 * - Result<T>
 * - ApiResponse<T>
 * - BaseEntity dan turunannya
 * - Berbagai framework seperti Spring dan Hibernate
 *
 * Pendekatan ini memungkinkan perilaku umum diwariskan
 * melalui superclass, sementara subclass tetap fleksibel
 * dalam menentukan tipe data yang digunakan.
 */

// superclass biasa
class Father {
    int num;

    Father(int i) {
        num = i;
    }

    int ambilNilai() {
        return num;
    }
}

// subclass Generic
class Son<T> extends Father {
    T ob;

    Son(T a, int i) {
        super(i);
        ob = a;
    }

    T ambilT() {
        return ob;
    }
}

public class GenericSubclass {
    public static void main(String[] args) {
        
        // T STRING
        Son<String> object1 = new Son<String>("Janera Farich M.u", 22);

        System.out.println(object1.ambilT()); // DARI SON
        System.out.println(object1.ambilNilai()); // DARI FATHER

    }
}
