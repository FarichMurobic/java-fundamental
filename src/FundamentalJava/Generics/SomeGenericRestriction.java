package FundamentalJava.Generics;

/* ============================================================
 *             BATASAN (RESTRICTIONS) PADA GENERICS
 * ============================================================
 *
 * Meskipun generics memberikan fleksibilitas dan type safety,
 * terdapat beberapa batasan dalam penggunaannya...
 *
 * Sebagian besar batasan tersebut berasal dari mekanisme
 * type erasure, yaitu proses penghapusan informasi generic
 * setelah program selesai dikompilasi.
 */

/* ============================================================
 * 1. TYPE PARAMETER TIDAK DAPAT DI-INSTANTIATE
 * ============================================================
 *
 * Contoh yang tidak valid:
 *
 * class Gen<T> {
 *     T obj;
 *
 *     Gen() {
 *         obj = new T();   // Compile-time error
 *     }
 * }
 *
 * Compiler tidak mengetahui tipe sebenarnya dari T.
 *
 * Misalnya, T dapat berupa:
 *
 * Integer
 * String
 * Double
 *
 * Karena tipe sebenarnya baru ditentukan saat object dibuat,
 * compiler tidak dapat menghasilkan kode:
 *
 * new Integer()
 * new String()
 * new Double()
 *
 * secara otomatis.
 *
 * Setelah type erasure, T tidak lagi tersedia sebagai tipe
 * konkret sehingga proses instansiasi menjadi mustahil.
 */

/* ------------------------------------------------------------
 * Solusi
 * ------------------------------------------------------------
 *
 * Cara yang paling umum adalah menerima object melalui
 * constructor atau method.
 *
 * Contoh:
 *
 * class Gen<T> {
 *     T obj;
 *
 *     Gen(T obj) {
 *         this.obj = obj;
 *     }
 * }
 *
 * Dengan cara ini, object dibuat di luar generic class,
 * kemudian diteruskan melalui constructor.
 *
 *
 * Untuk kasus tertentu, object juga dapat dibuat menggunakan
 * reflection.
 *
 * Contoh:
 *
 * class Gen<T> {
 *
 *     Gen(Class<T> clazz) throws Exception {
 *         T obj =
 *             clazz.getDeclaredConstructor().newInstance();
 *     }
 * }
 *
 * Pendekatan ini digunakan apabila class dari T
 * memang diketahui saat runtime.
 */

/* ============================================================
 * 2. STATIC TIDAK DAPAT MENGGUNAKAN TYPE PARAMETER CLASS
 * ============================================================
 *
 * Contoh yang tidak valid:
 *
 * class Wrong<T> {
 *
 *     static T obj;          // Compile-time error
 *
 *     static T getObj() {    // Compile-time error
 *         return obj;
 *     }
 * }
 *
 * Type parameter T merupakan bagian dari object
 * (instance), sedangkan member static merupakan
 * bagian dari class.
 *
 * Karena hanya ada satu copy member static untuk seluruh
 * object, compiler tidak dapat menentukan T mana
 * yang harus digunakan.
 *
 * Misalnya:
 *
 * Wrong<Integer>
 * Wrong<String>
 *
 * Keduanya berbagi member static yang sama,
 * sehingga penggunaan T menjadi ambigu.
 */

/* ------------------------------------------------------------
 * Solusi
 * ------------------------------------------------------------
 *
 * Gunakan generic method yang bersifat static.
 *
 * Contoh:
 *
 * class Test {
 *
 *     static <T> void print(T data) {
 *         System.out.println(data);
 *     }
 * }
 *
 * Type parameter tersebut milik method,
 * bukan milik class, sehingga aman digunakan.
 */

/* ============================================================
 * 3. TIDAK DAPAT MEMBUAT ARRAY DARI TYPE PARAMETER
 * ============================================================
 *
 * Contoh yang tidak valid:
 *
 * T[] values = new T[10];
 *
 * Array di Java mengetahui tipe komponennya
 * pada saat runtime.
 *
 * Sebaliknya, type parameter dihapus setelah
 * proses kompilasi (type erasure).
 *
 * Akibatnya, JVM tidak mengetahui tipe nyata
 * yang harus digunakan untuk membuat array.
 */

/* ------------------------------------------------------------
 * Solusi
 * ------------------------------------------------------------
 *
 * Array dapat dibuat di luar generic class,
 * kemudian diteruskan sebagai parameter.
 *
 * Contoh:
 *
 * T[] values;
 *
 * Gen(T[] array) {
 *     values = array;
 * }
 *
 * Pada kasus ini, array sudah memiliki tipe konkret
 * sehingga aman digunakan.
 */

/* ============================================================
 * 4. TIDAK DAPAT MEMBUAT ARRAY DARI PARAMETERIZED TYPE
 * ============================================================
 *
 * Contoh yang tidak valid:
 *
 * Gen<Integer>[] array =
 *         new Gen<Integer>[10];
 *
 * Compiler menolak kode tersebut karena dapat
 * menyebabkan heap pollution dan merusak type safety.
 *
 * Misalnya, apabila array diperlakukan sebagai Object[],
 * object dengan parameterized type berbeda dapat
 * dimasukkan ke dalam array tersebut.
 */

/* ------------------------------------------------------------
 * Solusi
 * ------------------------------------------------------------
 *
 * Gunakan wildcard.
 *
 * Contoh:
 *
 * Gen<?>[] array = new Gen<?>[10];
 *
 * Wildcard menunjukkan bahwa array dapat menyimpan
 * object Gen dengan type argument apa pun,
 * tanpa mengorbankan type safety.
 */

/* ============================================================
 * 5. GENERIC CLASS TIDAK DAPAT MEWARISI Throwable
 * ============================================================
 *
 * Contoh yang tidak valid:
 *
 * class MyException<T> extends Exception {
 * }
 *
 * atau:
 *
 * class MyError<T> extends Throwable {
 * }
 *
 * Java tidak mengizinkan generic class menjadi
 * turunan Throwable, Exception, maupun Error.
 *
 * Alasannya, mekanisme exception handling
 * bergantung pada informasi tipe saat runtime,
 * sedangkan type argument sudah dihapus
 * oleh type erasure.
 */

/* ------------------------------------------------------------
 * Solusi
 * ------------------------------------------------------------
 *
 * Gunakan exception biasa tanpa generic.
 *
 * Contoh:
 *
 * class MyException extends Exception {
 * }
 */

/* ============================================================
 * Ringkasan
 * ============================================================
 *
 * Operasi                                  Status
 * ------------------------------------------------------------
 * new T()                                  Tidak dapat dilakukan
 * static T                                 Tidak diperbolehkan
 * new T[]                                  Tidak diperbolehkan
 * new Gen<Integer>[...]                    Tidak diperbolehkan
 * new Gen<?>[...]                          Diperbolehkan
 * class MyException<T> extends Exception   Tidak diperbolehkan
 *
 * Seluruh batasan tersebut merupakan konsekuensi dari
 * mekanisme type erasure.
 */

/* ============================================================
 * Insight
 * ============================================================
 *
 * Hampir seluruh pembatasan pada generics berasal dari satu
 * prinsip utama:
 *
 * - Generics bekerja pada compile-time.
 * - Informasi type argument dihapus setelah kompilasi
 *   melalui type erasure.
 *
 * Oleh karena itu, setiap operasi yang membutuhkan informasi
 * tipe secara eksplisit pada saat runtime umumnya tidak dapat
 * dilakukan secara langsung menggunakan type parameter generic.
 */

public class SomeGenericRestriction {

}
