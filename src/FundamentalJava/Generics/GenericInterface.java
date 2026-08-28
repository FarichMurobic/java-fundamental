package FundamentalJava.Generics;

/* ============================================================
 *                    GENERIC INTERFACE
 * ============================================================
 *
 * Generic interface adalah interface yang memiliki satu atau
 * lebih type parameter..
 *
 * Dengan adanya type parameter, method di dalam interface
 * dapat bekerja dengan berbagai tipe data tanpa kehilangan
 * type safety.
 *
 * Generic interface membuat kode menjadi lebih fleksibel,
 * reusable, dan tetap diperiksa oleh compiler.
 */

/* ------------------------------------------------------------
 * Deklarasi Generic Interface
 * ------------------------------------------------------------
 *
 * Contoh:
 *
 * interface MinMax<T extends Comparable<T>> {
 *     T min();
 *     T max();
 * }
 *
 * Pada deklarasi tersebut:
 *
 * T merupakan type parameter milik interface.
 *
 * Constraint:
 *
 * T extends Comparable<T>
 *
 * berarti T harus mengimplementasikan interface Comparable.
 *
 * Dengan demikian, setiap object bertipe T dijamin memiliki
 * method compareTo().
 */

/* ------------------------------------------------------------
 * Mengapa Menggunakan Comparable?
 * ------------------------------------------------------------
 *
 * Method min() dan max() membutuhkan kemampuan untuk
 * membandingkan dua object.
 *
 * Perbandingan dilakukan menggunakan:
 *
 * compareTo()
 *
 * Method tersebut berasal dari interface Comparable.
 *
 * Tanpa constraint:
 *
 * <T extends Comparable<T>>
 *
 * compiler tidak dapat menjamin bahwa compareTo()
 * tersedia sehingga kode tidak dapat dikompilasi.
 */

/* ------------------------------------------------------------
 * Implementasi Generic Interface
 * ------------------------------------------------------------
 *
 * Contoh:
 *
 * class MyClass<T extends Comparable<T>>
 *         implements MinMax<T> {
 *     ...
 * }
 *
 * MyClass juga harus memiliki type parameter T
 * karena interface menggunakan T.
 *
 * Selain itu, constraint yang sama juga harus diterapkan,
 * yaitu:
 *
 * T extends Comparable<T>
 *
 * agar seluruh kontrak interface tetap terpenuhi.
 */

/* ------------------------------------------------------------
 * Cara Kerja Method min()
 * ------------------------------------------------------------
 *
 * Misalnya terdapat logika:
 *
 * if (vals[i].compareTo(minValue) < 0)
 *
 * Artinya:
 *
 * compareTo() menghasilkan nilai negatif apabila:
 *
 * vals[i] < minValue
 *
 * Jika kondisi tersebut terpenuhi,
 * maka vals[i] menjadi nilai minimum yang baru.
 */

/* ------------------------------------------------------------
 * Cara Kerja Method max()
 * ------------------------------------------------------------
 *
 * Misalnya:
 *
 * if (vals[i].compareTo(maxValue) > 0)
 *
 * Artinya:
 *
 * compareTo() menghasilkan nilai positif apabila:
 *
 * vals[i] > maxValue
 *
 * Jika kondisi tersebut terpenuhi,
 * maka vals[i] menjadi nilai maksimum yang baru.
 */

/* ------------------------------------------------------------
 * Mengapa Dapat Digunakan untuk Berbagai Tipe?
 * ------------------------------------------------------------
 *
 * Constraint:
 *
 * <T extends Comparable<T>>
 *
 * tidak membatasi hanya pada satu tipe data,
 * melainkan menerima semua tipe yang mengimplementasikan
 * Comparable.
 *
 * Contohnya:
 *
 * Integer
 * Long
 * Double
 * Character
 * String
 *
 * Seluruh class tersebut mengimplementasikan Comparable,
 * sehingga dapat digunakan sebagai type argument.
 *
 * Sebaliknya, tipe yang tidak mengimplementasikan Comparable
 * tidak dapat digunakan.
 */

/* ------------------------------------------------------------
 * Kesalahan yang Sering Terjadi
 * ------------------------------------------------------------
 *
 * 1. Menggunakan type parameter yang belum dideklarasikan.
 *
 * Salah:
 *
 * class MyClass implements MinMax<T>
 *
 * Error:
 *
 * T tidak dikenal karena MyClass tidak mendeklarasikan
 * type parameter T.
 *
 *
 * 2. Menuliskan constraint pada implements.
 *
 * Salah:
 *
 * implements MinMax<T extends Comparable<T>>
 *
 * Error:
 *
 * Constraint hanya boleh dideklarasikan pada deklarasi
 * class atau interface, bukan pada bagian implements.
 *
 *
 * 3. Menggunakan type yang tidak memenuhi constraint.
 *
 * Contoh:
 *
 * MyClass<StringBuilder>
 *
 * Error:
 *
 * StringBuilder tidak mengimplementasikan Comparable,
 * sehingga tidak memenuhi syarat sebagai type argument.
 */

/* ------------------------------------------------------------
 * Alternatif: Menggunakan Tipe Konkret
 * ------------------------------------------------------------
 *
 * Class yang mengimplementasikan generic interface
 * tidak selalu harus tetap generic.
 *
 * Contoh:
 *
 * class IntegerMinMax implements MinMax<Integer> {
 *     ...
 * }
 *
 * Pada kasus ini:
 *
 * - Interface menggunakan tipe Integer secara langsung.
 * - Class tidak lagi memiliki type parameter.
 *
 * Pendekatan ini digunakan apabila implementasi hanya
 * ditujukan untuk satu tipe data tertentu.
 */

/* ------------------------------------------------------------
 * Perbandingan dengan Interface Non-Generic
 * ------------------------------------------------------------
 *
 * Tanpa generic:
 *
 * - Biasanya menggunakan Object.
 * - Membutuhkan casting manual.
 * - Lebih berisiko menghasilkan ClassCastException.
 *
 * Dengan generic:
 *
 * - Tidak memerlukan casting manual.
 * - Type safety dijamin oleh compiler.
 * - Kode lebih bersih dan mudah digunakan kembali.
 */

/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * - Generic interface memiliki satu atau lebih type parameter.
 *
 * - Type parameter dapat diberi batas (bound), misalnya:
 *
 *      <T extends Comparable<T>>
 *
 * - Class yang mengimplementasikan generic interface dapat:
 *
 *      • Tetap generic.
 *      • Menggunakan tipe konkret tertentu.
 *
 * - Constraint memastikan bahwa seluruh operasi pada type
 *   parameter dapat dilakukan dengan aman.
 *
 * - Generic interface membuat kode lebih reusable,
 *   fleksibel, dan tetap type-safe.
 */

/* ------------------------------------------------------------
 * Insight
 * ------------------------------------------------------------
 *
 * Generic interface banyak digunakan dalam Java Standard Library,
 * misalnya:
 *
 * Comparable<T>
 * Comparator<T>
 * Iterable<T>
 * Iterator<T>
 * List<E>
 * Set<E>
 * Map<K, V>
 *
 * Hampir seluruh Collection Framework dibangun di atas konsep
 * generic interface agar dapat digunakan untuk berbagai tipe data
 * tanpa mengorbankan keamanan tipe (type safety).
 */

interface MinMax<T extends Comparable<T>> {
    T min();

    T max();
}

class MyClass<T extends Comparable<T>> implements MinMax {

    T[] vals;

    MyClass(T[] o) {
        vals = o;
    }

    // Mengembalikan nilai minimum
    public T min() {
        T v = vals[0];
        for (int i = 1; i < vals.length; i++) {
            if (vals[1].compareTo(v) < 0) {
                v = vals[i];
            }
        }
        return v;
    }

    // Mengembalikan nilai maksimum
    public T max() {
        T v = vals[0];
        for (int i = 1; i < vals.length; i++) {
            if (vals[i].compareTo(v) > 0) {
                v = vals[i];
            }
        }
        return v;
    }
}

public class GenericInterface {
    public static void main(String[] args) {

        Integer inums[] = { 9, 6, 3, 2, 5, 8, 7, 1, 4 };
        Character chas[] = { 'n', 'e', 'j', 'r', 'a' };

        MyClass<Integer> iob = new MyClass<Integer>(inums);
        MyClass<Character> cob = new MyClass<Character>(chas);

        System.out.println("Max value in inums: " + iob.max()); // 9
        System.out.println("Min value in inums: " + iob.min()); // 6

    }
}
