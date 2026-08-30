package FundamentalJava.Lambda;

/* ==========================================================
 *               GENERIC FUNCTIONAL INTERFACES
 * ==========================================================
 *
 * Lambda expression di Java tidak dapat mendeklarasikan generic
 * type parameter secara langsung..
 *
 * Contoh yang TIDAK valid:
 *
 *     <T> (x) -> x
 *
 * Java tidak menyediakan sintaks seperti itu untuk lambda.
 *
 * Namun, functional interface yang menjadi target lambda dapat
 * menggunakan generic type.
 *
 * Artinya:
 *
 * - Lambda expression tetap ditulis seperti biasa.
 * - Fleksibilitas tipe data ditentukan oleh functional interface.
 *
 * ==========================================================
 *              KONSEP DASAR GENERIC LAMBDA
 * ==========================================================
 *
 * Sebuah lambda expression selalu membutuhkan target type.
 *
 * Target type tersebut biasanya berasal dari functional
 * interface yang memiliki satu abstract method.
 *
 * Contoh:
 *
 *     interface StringFunc {
 *         String func(String value);
 *     }
 *
 *     interface NumericFunc {
 *         Integer func(Integer value);
 *     }
 *
 * Kedua interface tersebut memiliki konsep yang sama:
 *
 * - Menerima satu parameter.
 * - Mengembalikan satu nilai.
 *
 * Perbedaannya hanya pada tipe data.
 *
 * Masalah:
 *
 * Kita membuat banyak interface yang sebenarnya memiliki pola
 * logic yang sama.
 *
 * Solusinya:
 *
 * Gunakan generic functional interface.
 *
 * ==========================================================
 *              MEMBUAT FUNCTIONAL INTERFACE GENERIC
 * ==========================================================
 *
 * Contoh:
 *
 *     @FunctionalInterface
 *     interface SomeFunc<T> {
 *
 *         T func(T value);
 *
 *     }
 *
 * Penjelasan:
 *
 * T adalah generic type parameter yang dapat diganti dengan
 * tipe data apa pun ketika interface digunakan.
 *
 * Method:
 *
 *     T func(T value);
 *
 * berarti:
 *
 * Input  = T
 * Output = T
 *
 * Contoh:
 *
 *     String -> String
 *     Integer -> Integer
 *     Double -> Double
 *
 * ==========================================================
 *                  MENGGUNAKAN GENERIC INTERFACE
 * ==========================================================
 *
 * Saat interface digunakan, tipe T ditentukan.
 *
 * Contoh:
 *
 *     SomeFunc<String> reverse;
 *
 * Maka:
 *
 *     T = String
 *
 * Method berubah menjadi:
 *
 *     String func(String value);
 *
 *
 * Contoh lain:
 *
 *     SomeFunc<Integer> factorial;
 *
 * Maka:
 *
 *     T = Integer
 *
 * Method berubah menjadi:
 *
 *     Integer func(Integer value);
 *
 * ==========================================================
 *                  LAMBDA TETAP SEDERHANA
 * ==========================================================
 *
 * Lambda tidak perlu mengetahui generic type secara langsung.
 *
 * Contoh:
 *
 *     SomeFunc<String> reverse = str -> {
 *         return new StringBuilder(str)
 *                 .reverse()
 *                 .toString();
 *     };
 *
 *
 *     SomeFunc<Integer> square = n -> {
 *         return n * n;
 *     };
 *
 * Lambda tetap menggunakan parameter biasa.
 *
 * Tipe parameter ditentukan berdasarkan generic type pada
 * functional interface.
 *
 * ==========================================================
 *                  TYPE INFERENCE PADA LAMBDA
 * ==========================================================
 *
 * Java memiliki kemampuan type inference, yaitu kemampuan
 * compiler untuk menentukan tipe data secara otomatis.
 *
 * Contoh:
 *
 *     SomeFunc<String> func = str -> str.length();
 *
 * Java mengetahui:
 *
 * - str bertipe String.
 * - Method yang dipanggil harus sesuai dengan String.
 *
 * Developer tidak perlu menulis tipe parameter secara eksplisit.
 *
 * ==========================================================
 *                    KEUNTUNGAN GENERIC
 * ==========================================================
 *
 * Generic functional interface memberikan:
 *
 * 1. Reusability
 *
 * Satu interface dapat digunakan untuk berbagai tipe data.
 *
 * Contoh:
 *
 *     SomeFunc<String>
 *     SomeFunc<Integer>
 *     SomeFunc<Double>
 *
 *
 * 2. Mengurangi duplikasi kode
 *
 * Sebelum generic:
 *
 *     StringFunc
 *     NumericFunc
 *
 * Setelah generic:
 *
 *     SomeFunc<T>
 *
 * Satu desain dapat menangani banyak kebutuhan.
 *
 *
 * 3. Type Safety
 *
 * Compiler dapat memastikan tipe data tetap konsisten.
 *
 * ==========================================================
 *             GENERIC + LAMBDA DI JAVA MODERN
 * ==========================================================
 *
 * Kombinasi generic dan lambda menjadi salah satu konsep penting
 * dalam Java modern.
 *
 * Dengan kombinasi ini, developer dapat membuat:
 *
 * - Logic yang reusable.
 * - Komponen yang fleksibel.
 * - Kode yang mudah dikembangkan.
 *
 * Prinsipnya:
 *
 * "Write once, use everywhere."
 *
 * Tulis satu kali, gunakan dengan berbagai tipe data.
 *
 * ==========================================================
 *                  DASAR FUNCTIONAL INTERFACE JAVA
 * ==========================================================
 *
 * Konsep generic functional interface menjadi dasar dari
 * functional interface bawaan Java seperti:
 *
 * - Function<T, R>
 * - Predicate<T>
 * - Consumer<T>
 * - Supplier<T>
 *
 * Functional interface tersebut banyak digunakan dalam:
 *
 * - Stream API.
 * - Collection processing.
 * - Functional programming style.
 *
 * ==========================================================
 *                  BATASAN GENERIC INTERFACE
 * ==========================================================
 *
 * Perhatikan deklarasi:
 *
 *     T func(T value);
 *
 * Input dan output harus memiliki tipe yang sama.
 *
 * Contoh:
 *
 *     String -> String
 *
 * valid.
 *
 *     Integer -> Integer
 *
 * valid.
 *
 * Tetapi:
 *
 *     String -> Integer
 *
 * tidak dapat dilakukan dengan desain interface tersebut.
 *
 * Untuk kebutuhan input dan output dengan tipe berbeda,
 * gunakan generic dengan dua parameter seperti:
 *
 *     Function<T, R>
 *
 * Contoh:
 *
 *     Function<String, Integer>
 *
 * Input:
 * String
 *
 * Output:
 * Integer
 *
 * ==========================================================
 *                       KESIMPULAN
 * ==========================================================
 *
 * Generic functional interface memungkinkan lambda expression
 * digunakan secara fleksibel dengan berbagai tipe data.
 *
 * Poin penting:
 *
 * - Lambda tidak dapat memiliki generic type sendiri.
 * - Functional interface dapat menggunakan generic.
 * - Tipe data ditentukan ketika interface digunakan.
 * - Satu interface dapat digunakan oleh banyak lambda.
 * - Generic mengurangi duplikasi dan meningkatkan reusability.
 *
 * Konsep ini menjadi dasar penting sebelum memahami functional
 * interface bawaan Java seperti Function, Predicate, dan
 * Consumer.
 *
 * ==========================================================
 */

// Generic functional interface
interface SomeFunc<T> {

    // T = tipe data fleksibel
    // parameter dan return harus tipe yang sama
    T func(T t);
}

public class GenericFunctionalInterface {
    public static void main(String[] args) {

        // LAMBDA 1: String (reverse)

        // T = String
        SomeFunc<String> reverse = (str) -> {
            String result = "";
            int i;

            // Membalik string
            for (i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };

        System.out.println("Lambda menjadi " + reverse.func("Lambda"));
        System.out.println();

        // LAMBDA 2: Integer (factorial)

        // T = Integer
        SomeFunc<Integer> faktorial = (lambda) -> {
            int result = 1;

            // Logika faktorial
            for (int i = 1; i <= lambda; i++) {
                result = i * result;
            }
            return result;
        };

        System.out.println(faktorial.func(10));
        System.out.println(faktorial.func(3));
    }
}
