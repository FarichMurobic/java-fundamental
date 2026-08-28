package FundamentalJava.Generics;

/* ============================================================
 *          GENERIC CLASS DENGAN BANYAK TYPE PARAMETER
 * ============================================================
 *
 * Sebuah generic class tidak terbatas hanya memiliki
 * satu type parameter..
 *
 * Java memungkinkan sebuah generic class memiliki
 * dua atau lebih type parameter sesuai kebutuhan.
 *
 * Contoh:
 *
 * class TwoGen<T, V> {
 *     ...
 * }
 *
 * Pada contoh tersebut:
 *
 * T dan V merupakan dua type parameter yang berbeda.
 */

/* ------------------------------------------------------------
 * Perbedaan dengan Satu Type Parameter
 * ------------------------------------------------------------
 *
 * Sebelumnya:
 *
 * class Gen<T>
 *
 * hanya memiliki satu type parameter.
 *
 * Sekarang:
 *
 * class TwoGen<T, V>
 *
 * memiliki dua type parameter.
 *
 * Artinya, class tersebut dapat bekerja dengan
 * dua tipe data yang dapat berbeda satu sama lain.
 */

/* ------------------------------------------------------------
 * Penulisan Multiple Type Parameter
 * ------------------------------------------------------------
 *
 * Jika terdapat lebih dari satu type parameter,
 * penulisannya dipisahkan menggunakan tanda koma.
 *
 * Bentuk umum:
 *
 * class ClassName<T, V> {
 *     ...
 * }
 *
 * Masing-masing type parameter bersifat independen
 * dan dapat digunakan untuk member yang berbeda.
 */

/* ------------------------------------------------------------
 * Arti Masing-Masing Type Parameter
 * ------------------------------------------------------------
 *
 * Misalnya:
 *
 * class TwoGen<T, V>
 *
 * Maka:
 *
 * T = type parameter pertama.
 *
 * V = type parameter kedua.
 *
 * Nama T dan V hanyalah konvensi penamaan.
 * Programmer dapat menggunakan nama lain,
 * meskipun penggunaan T, K, V, atau E
 * merupakan praktik yang umum di Java.
 */

/* ------------------------------------------------------------
 * Membuat Object
 * ------------------------------------------------------------
 *
 * Karena TwoGen memiliki dua type parameter,
 * maka object juga harus memberikan
 * dua type argument.
 *
 * Contoh:
 *
 * TwoGen<Integer, String> obj =
 *         new TwoGen<>(10, "Halo");
 *
 * Compiler menetapkan:
 *
 * T → Integer
 * V → String
 */

/* ------------------------------------------------------------
 * Type Argument Boleh Berbeda
 * ------------------------------------------------------------
 *
 * Type argument tidak harus sama.
 *
 * Contoh:
 *
 * TwoGen<Integer, String>
 *
 * Pada kasus tersebut:
 *
 * T menggunakan Integer.
 * V menggunakan String.
 *
 * Inilah salah satu keuntungan utama
 * multiple type parameter.
 */

/* ------------------------------------------------------------
 * Type Argument Juga Boleh Sama
 * ------------------------------------------------------------
 *
 * Tidak ada aturan bahwa seluruh type argument
 * harus berbeda.
 *
 * Contoh:
 *
 * TwoGen<String, String> obj =
 *         new TwoGen<>("A", "B");
 *
 * Kode tersebut valid karena:
 *
 * T → String
 * V → String
 *
 * Kedua type parameter dapat menggunakan
 * tipe data yang sama apabila memang diperlukan.
 */

/* ------------------------------------------------------------
 * Jumlah dan Urutan Type Argument
 * ------------------------------------------------------------
 *
 * Jumlah type argument harus sama dengan jumlah
 * type parameter yang dideklarasikan.
 *
 * Misalnya:
 *
 * class TwoGen<T, V>
 *
 * Maka object harus dibuat seperti:
 *
 * TwoGen<Integer, String>
 *
 * Selain itu, urutan type argument juga penting.
 *
 * Contoh:
 *
 * TwoGen<Integer, String>
 *
 * berbeda dengan:
 *
 * TwoGen<String, Integer>
 *
 * karena masing-masing type argument
 * akan dipetakan sesuai urutannya.
 */

/* ------------------------------------------------------------
 * Kapan Menggunakan Banyak Type Parameter?
 * ------------------------------------------------------------
 *
 * Multiple type parameter digunakan ketika sebuah class
 * perlu menyimpan atau memproses beberapa tipe data
 * yang memiliki peran berbeda.
 *
 * Contohnya:
 *
 * - Key dan Value
 * - Nama dan Nilai
 * - Data dan Metadata
 * - Request dan Response
 *
 * Pendekatan ini membuat class lebih fleksibel
 * tanpa mengurangi type safety.
 */

/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * - Generic class dapat memiliki lebih dari satu
 *   type parameter.
 *
 * - Type parameter ditulis menggunakan tanda koma.
 *
 *      <T, V>
 *
 * - Jumlah type argument harus sesuai dengan jumlah
 *   type parameter.
 *
 * - Urutan type argument harus sesuai dengan deklarasi.
 *
 * - Type argument dapat berbeda maupun sama,
 *   tergantung kebutuhan.
 *
 * - Multiple type parameter membuat generic class
 *   lebih fleksibel tanpa mengorbankan type safety.
 */

/* ------------------------------------------------------------
 * Insight
 * ------------------------------------------------------------
 *
 * Generic dengan banyak type parameter banyak digunakan
 * pada Java Standard Library, misalnya:
 *
 * Map<K, V>
 * Map.Entry<K, V>
 * Dictionary<K, V>
 *
 * Pola ini juga sangat umum ditemukan pada framework
 * dan aplikasi enterprise untuk merepresentasikan
 * pasangan data yang memiliki tipe berbeda namun saling
 * berkaitan dalam satu object.
 */

class GenMul<T, V> {
    T ob1;
    V ob2;

    GenMul(T a, V b) {
        ob1 = a;
        ob2 = b;
    }

    void show() {
        System.out.println("Type of T is: " + ob1.getClass().getName());
        System.out.println("Type of V is: " + ob2.getClass().getName());
    }

    T getOb1() {
        return ob1;
    }

    V getOb2() {
        return ob2;
    }
}

public class MultipleTypeParameterGenerics {
    public static void main(String[] args) {

        GenMul<Integer, String> genMul1 = new GenMul<Integer, String>(88, "Generics");

        // menampilkan tipe data
        genMul1.show();

        // mengambil dan menampilkan nilai
        int v = genMul1.getOb1();
        System.out.println("value: " + v);

        String string = genMul1.getOb2();
        System.out.println("value: " + string);

        /*
         * ============================================================
         * ANALISIS KODE TwoGen<T, V>
         * ============================================================
         *
         * Class TwoGen<T, V> merupakan generic class yang memiliki
         * dua type parameter.
         *
         * Kedua type parameter tersebut dapat menggunakan tipe data
         * yang sama maupun berbeda, tergantung saat object dibuat.
         */

        /*
         * ------------------------------------------------------------
         * 1. Deklarasi Class
         * ------------------------------------------------------------
         *
         * class TwoGen<T, V>
         *
         * Keterangan:
         *
         * T = type parameter pertama.
         *
         * V = type parameter kedua.
         *
         * Keduanya berfungsi sebagai placeholder yang akan diganti
         * dengan type argument ketika object dibuat.
         */

        /*
         * ------------------------------------------------------------
         * 2. Deklarasi Field
         * ------------------------------------------------------------
         *
         * T ob1;
         * V ob2;
         *
         * Artinya:
         *
         * ob1 menggunakan tipe T.
         *
         * ob2 menggunakan tipe V.
         *
         * Karena masih berupa type parameter,
         * tipe sebenarnya belum diketahui pada saat class
         * dideklarasikan.
         */

        /*
         * ------------------------------------------------------------
         * 3. Constructor
         * ------------------------------------------------------------
         *
         * TwoGen(T o1, V o2)
         *
         * Constructor menerima dua parameter:
         *
         * o1 bertipe T.
         *
         * o2 bertipe V.
         *
         * Nilai yang diterima kemudian disimpan ke field
         * yang memiliki tipe yang sesuai.
         */

        /*
         * ------------------------------------------------------------
         * 4. Method Getter
         * ------------------------------------------------------------
         *
         * T getOb1()
         *
         * Method ini mengembalikan nilai bertipe T.
         *
         * V getOb2()
         *
         * Method ini mengembalikan nilai bertipe V.
         *
         * Karena return type mengikuti type parameter,
         * compiler dapat menjaga type safety tanpa
         * memerlukan casting manual.
         */

        /*
         * ------------------------------------------------------------
         * 5. Method showTypes()
         * ------------------------------------------------------------
         *
         * Misalnya digunakan:
         *
         * ob1.getClass().getName();
         *
         * Method getClass() mengembalikan class sebenarnya
         * dari object yang tersimpan.
         *
         * Sedangkan:
         *
         * getName()
         *
         * mengembalikan nama lengkap (fully qualified name)
         * dari class tersebut.
         *
         * Contoh hasil:
         *
         * java.lang.Integer
         * java.lang.String
         *
         * Perlu diperhatikan bahwa informasi ini berasal dari
         * object yang disimpan, bukan dari type parameter T atau V.
         */

        /*
         * ------------------------------------------------------------
         * Pembuatan Object
         * ------------------------------------------------------------
         *
         * TwoGen<Integer, String> tgObj =
         * new TwoGen<>(88, "Generics");
         *
         * Compiler mengganti:
         *
         * T → Integer
         *
         * V → String
         *
         * Akibatnya:
         *
         * ob1 bertipe Integer dan bernilai 88.
         *
         * ob2 bertipe String dan bernilai "Generics".
         */

        /*
         * ------------------------------------------------------------
         * Pemanggilan Method
         * ------------------------------------------------------------
         *
         * int value = tgObj.getOb1();
         *
         * Method getOb1() mengembalikan Integer.
         *
         * Nilai tersebut kemudian diubah secara otomatis menjadi
         * int melalui mekanisme autounboxing.
         *
         *
         * String text = tgObj.getOb2();
         *
         * Method getOb2() langsung mengembalikan String,
         * sehingga tidak memerlukan konversi tambahan.
         */

        /*
         * ------------------------------------------------------------
         * Alur Kerja Program
         * ------------------------------------------------------------
         *
         * 1. Object dibuat dengan:
         *
         * T → Integer
         * V → String
         *
         * 2. Constructor menyimpan:
         *
         * ob1 = 88
         * ob2 = "Generics"
         *
         * 3. showTypes() menampilkan tipe object yang tersimpan.
         *
         * 4. getOb1() mengembalikan Integer.
         *
         * 5. getOb2() mengembalikan String.
         *
         * 6. Program menampilkan seluruh informasi ke layar.
         */

        /*
         * ------------------------------------------------------------
         * Hasil Program
         * ------------------------------------------------------------
         *
         * Output:
         *
         * Type of T is java.lang.Integer
         * Type of V is java.lang.String
         *
         * Value: 88
         * Value: Generics
         *
         * Output tersebut menunjukkan bahwa setiap type parameter
         * telah diganti dengan type argument yang diberikan saat
         * object dibuat.
         */

        /*
         * ------------------------------------------------------------
         * Ringkasan
         * ------------------------------------------------------------
         *
         * - TwoGen<T, V> memiliki dua type parameter.
         *
         * - Tipe sebenarnya ditentukan saat object dibuat.
         *
         * - Constructor menerima parameter sesuai dengan
         * masing-masing type parameter.
         *
         * - Getter mengembalikan nilai sesuai tipe yang telah
         * ditentukan tanpa casting manual.
         *
         * - showTypes() menggunakan reflection melalui
         * getClass() untuk menampilkan tipe object
         * yang tersimpan saat runtime.
         *
         * - Generic memastikan seluruh proses tetap
         * type-safe selama compile-time.
         */

        /*
         * ------------------------------------------------------------
         * Insight
         * ------------------------------------------------------------
         *
         * Class dengan banyak type parameter seperti TwoGen<T, V>
         * menjadi dasar bagi banyak struktur data di Java,
         * misalnya:
         *
         * Map<K, V>
         * Map.Entry<K, V>
         * Pair<L, R>
         *
         * Konsep ini memungkinkan satu object menyimpan beberapa
         * data dengan tipe yang berbeda secara aman, fleksibel,
         * dan tanpa memerlukan casting manual.
         */

    }
}
