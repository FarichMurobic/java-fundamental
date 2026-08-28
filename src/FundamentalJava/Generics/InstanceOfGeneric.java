package FundamentalJava.Generics;

/* ============================================================
 *          PENGGUNAAN instanceof PADA GENERIC CLASS
 * ============================================================
 *
 * Operator instanceof dapat digunakan untuk memeriksa apakah
 * suatu object merupakan instance dari generic class..
 *
 * Namun, instanceof tidak dapat memeriksa type argument
 * tertentu, seperti:
 *
 * Gen<Integer>
 * List<String>
 *
 * Hal ini disebabkan oleh mekanisme type erasure pada Java.
 */

/* ------------------------------------------------------------
 * Mengapa Menggunakan Wildcard (<?>)
 * ------------------------------------------------------------
 *
 * Contoh:
 *
 * obj instanceof Gen2<?>
 *
 * Wildcard (<?>) berarti:
 *
 * "Periksa apakah object merupakan Gen2 dengan tipe apa pun."
 *
 * Type argument tidak diperhatikan.
 *
 * Misalnya:
 *
 * Gen2<Integer>
 * Gen2<String>
 * Gen2<Double>
 *
 * Seluruhnya akan memenuhi pemeriksaan tersebut
 * karena yang diperiksa hanyalah class Gen2.
 */

/* ------------------------------------------------------------
 * instanceof dengan Inheritance
 * ------------------------------------------------------------
 *
 * Misalnya:
 *
 * obj instanceof Gen<?>
 *
 * Jika Gen2 merupakan subclass dari Gen:
 *
 * class Gen2<T> extends Gen<T>
 *
 * maka object bertipe Gen2 juga merupakan instance dari Gen.
 *
 * Oleh karena itu, pemeriksaan tersebut akan bernilai true
 * apabila object memang berasal dari Gen2 atau subclass lain
 * yang mewarisi Gen.
 */

/* ------------------------------------------------------------
 * Mengapa Tidak Bisa Memeriksa Type Argument?
 * ------------------------------------------------------------
 *
 * Contoh yang tidak valid:
 *
 * obj instanceof List<String>
 *
 * atau:
 *
 * obj instanceof Gen<Integer>
 *
 * Compiler akan menghasilkan error.
 *
 * Penyebabnya adalah Java menggunakan
 * type erasure.
 *
 * Setelah proses kompilasi, informasi mengenai
 * type argument dihapus sehingga JVM tidak lagi
 * mengetahui apakah object tersebut merupakan:
 *
 * List<String>
 * List<Integer>
 * Gen<Double>
 *
 * Yang diketahui JVM hanyalah class dasarnya,
 * misalnya:
 *
 * List
 * Gen
 */

/* ------------------------------------------------------------
 * Type Erasure dan instanceof
 * ------------------------------------------------------------
 *
 * Pada saat runtime:
 *
 * List<String>
 *
 * dan:
 *
 * List<Integer>
 *
 * direpresentasikan sebagai:
 *
 * List
 *
 * Karena informasi generic tidak tersedia lagi,
 * JVM tidak memiliki dasar untuk membedakan
 * parameterized type yang berbeda.
 *
 * Inilah alasan mengapa instanceof hanya dapat
 * memeriksa class, bukan type argument.
 */

/* ------------------------------------------------------------
 * Contoh Penggunaan yang Benar
 * ------------------------------------------------------------
 *
 * if (obj instanceof List<?>) {
 *     ...
 * }
 *
 * atau:
 *
 * if (obj instanceof Gen<?>) {
 *     ...
 * }
 *
 * Wildcard menunjukkan bahwa pemeriksaan hanya
 * dilakukan terhadap generic class tanpa
 * memperhatikan type argument-nya.
 */

/* ------------------------------------------------------------
 * Contoh Penggunaan yang Tidak Valid
 * ------------------------------------------------------------
 *
 * if (obj instanceof List<String>) {
 *     ...
 * }
 *
 * atau:
 *
 * if (obj instanceof Gen<Integer>) {
 *     ...
 * }
 *
 * Kode tersebut menghasilkan compile-time error
 * karena parameterized type tidak dapat digunakan
 * pada operator instanceof.
 */

/* ------------------------------------------------------------
 * Hubungan dengan Type Safety
 * ------------------------------------------------------------
 *
 * Meskipun informasi generic dihapus saat runtime,
 * Java tetap menjaga type safety melalui pemeriksaan
 * pada compile-time.
 *
 * Compiler memastikan bahwa penggunaan generic sudah
 * benar sebelum program dijalankan.
 *
 * Setelah itu, JVM hanya bekerja dengan class hasil
 * type erasure.
 */

/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * - Operator instanceof dapat digunakan pada generic class.
 *
 * - instanceof hanya memeriksa class, bukan
 *   type argument.
 *
 * - Gunakan wildcard (<?>) apabila ingin memeriksa
 *   object dari generic class.
 *
 * - Parameterized type seperti List<String>
 *   atau Gen<Integer> tidak dapat digunakan
 *   dengan instanceof.
 *
 * - Aturan ini merupakan konsekuensi langsung dari
 *   mekanisme type erasure pada Java.
 */

/* ------------------------------------------------------------
 * Insight
 * ------------------------------------------------------------
 *
 * Pola berikut sangat umum dijumpai pada kode Java modern:
 *
 * if (obj instanceof List<?>) { ... }
 * if (obj instanceof Map<?, ?>) { ... }
 * if (obj instanceof Optional<?>) { ... }
 *
 * Sebaliknya, pemeriksaan seperti:
 *
 * List<String>
 * Map<String, Integer>
 * Optional<Integer>
 *
 * tidak dapat dilakukan menggunakan instanceof,
 * karena informasi mengenai type argument tidak lagi
 * tersedia saat runtime akibat type erasure.
 */

class One<T> {
    T ob;

    One(T ob) {
        this.ob = ob;
    }

    T ambil() {
        return ob;
    }
}

class Two<T> extends One<T> {

    Two(T ob) {
        super(ob);
    }
}

public class InstanceOfGeneric {
    public static void main(String[] args) {

        One<Integer> ob1 = new One<>(20);
        Two<Integer> ob2 = new Two<>(50);

        Two<String> stringTwo = new Two<>("Test");

        // CEK APKAKAH OB2 ADALAH TWO (TIPE APAPUN)
        if (ob2 instanceof Two<?>) {
            System.out.println("ob2 is instance Two");
        }

        // CEK APKAKAH OB2 ADALAH ONE (TIPE APAPUN)
        if (ob2 instanceof One<?>) {
            System.out.println("ob2 is instance One");
        }

        System.out.println();

        // ob1 bukan Two
        if (ob1 instanceof Two<?>) // false
            System.out.println("ob1 adalah instance Two");

        if (ob1 instanceof One<?>) // true
            System.out.println("ob1 adalah instance One");

        if (ob2 instanceof Two<Integer>) // true
            System.out.println("ob2 adalah instance Two<Integer>");

        if (stringTwo instanceof Two<String>) // true
            System.out.println("stringtwo instance Two<String>");

        // INI AKAN ERROR
        // if (ob2 instanceof Two<String>) KARENA OB2 ADALAH INTEGER
        // System.out.println("INI HARUSNYA GAK MASUK!");

    }
}
