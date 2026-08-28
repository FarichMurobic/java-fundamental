package FundamentalJava.FunctionalInterface;

/**
 * Functional Interface
 *
 * Functional Interface adalah interface yang hanya memiliki
 * SATU abstract method (Single Abstract Method / SAM)..
 *
 * Functional interface merupakan fondasi utama fitur:
 * - Lambda Expression
 * - Method Reference
 * - Stream API
 * - Banyak API modern di Java
 *
 * Walaupun hanya boleh memiliki satu abstract method,
 * functional interface tetap boleh memiliki:
 *
 * - default method
 * - static method
 * - private method (Java 9+)
 *
 * Method-method tersebut tidak dihitung sebagai abstract method.
 *
 * Contoh:
 *
 * interface MyFunction {
 *
 *     int apply(int x);      // abstract method (SATU)
 *
 *     default void info() {}
 *
 *     static void print() {}
 *
 *     private void helper() {}
 * }
 *
 * Karena hanya ada satu abstract method,
 * interface di atas tetap termasuk Functional Interface.
 *
 * ------------------------------------------------------------
 *
 * @FunctionalInterface
 *
 * Java menyediakan anotasi:
 *
 * @FunctionalInterface
 *
 * Anotasi ini bersifat opsional tetapi sangat disarankan.
 *
 * Fungsinya:
 * Memberi tahu compiler bahwa interface tersebut memang
 * dimaksudkan sebagai functional interface.
 *
 * Jika tanpa sengaja menambahkan abstract method kedua,
 * compiler akan menghasilkan error.
 *
 * Contoh:
 *
 * @FunctionalInterface
 * interface MyFunction {
 *     void execute();
 * }
 *
 * Salah:
 *
 * @FunctionalInterface
 * interface MyFunction {
 *     void execute();
 *     void run();      // ERROR
 * }
 *
 * ------------------------------------------------------------
 *
 * Kenapa Functional Interface Penting?
 *
 * Sebelum Java 8:
 *
 * Untuk mengimplementasikan interface,
 * kita harus membuat class baru atau anonymous class.
 *
 * Contoh:
 *
 * interface Printer {
 *     void print(String text);
 * }
 *
 * Printer p = new Printer() {
 *     @Override
 *     public void print(String text) {
 *         System.out.println(text);
 *     }
 * };
 *
 * Setelah Java 8:
 *
 * Printer p = text -> System.out.println(text);
 *
 * Jauh lebih singkat dan mudah dibaca.
 *
 * ------------------------------------------------------------
 *
 * Jenis Functional Interface
 *
 * Functional Interface dibagi menjadi dua kelompok:
 *
 * 1. Custom Functional Interface
 *    Interface yang dibuat sendiri.
 *
 * 2. Built-in Functional Interface
 *    Interface bawaan Java pada package:
 *
 *    java.util.function
 *
 * Hampir semua project Java modern menggunakan interface bawaan ini.
 *
 * ------------------------------------------------------------
 *
 * Custom Functional Interface
 *
 * Digunakan ketika kebutuhan aplikasi sangat spesifik.
 *
 * Contoh:
 *
 * @FunctionalInterface
 * interface PaymentValidator {
 *     boolean validate(User user, double amount);
 * }
 *
 * Kelebihan:
 * - Nama method lebih bermakna
 * - Lebih mudah dipahami sesuai domain aplikasi
 * - Cocok untuk business logic khusus
 *
 * ------------------------------------------------------------
 *
 * Built-in Functional Interface
 *
 * Java menyediakan banyak functional interface bawaan
 * agar programmer tidak perlu membuat interface sederhana berulang kali.
 *
 * Contoh:
 *
 * Function<String, Integer> length = String::length;
 *
 * Predicate<Integer> positive = n -> n > 0;
 *
 * Consumer<String> printer = System.out::println;
 *
 * Supplier<Double> random = Math::random;
 *
 * Keuntungan:
 * - Lebih standar
 * - Lebih konsisten
 * - Terintegrasi dengan Stream API
 * - Banyak digunakan di library modern seperti Spring Framework
 *
 * ------------------------------------------------------------
 *
 * Kapan Menggunakan Custom atau Built-in?
 *
 * Gunakan Built-in apabila:
 *
 * - transformasi data
 * - filtering
 * - operasi sederhana
 * - consume data
 * - menghasilkan data
 *
 * Ini mencakup sebagian besar kebutuhan pada project nyata.
 *
 * Gunakan Custom apabila:
 *
 * - business logic sangat spesifik
 * - nama method harus lebih deskriptif
 * - parameter atau return type tidak cocok dengan interface bawaan
 *
 * ------------------------------------------------------------
 *
 * Functional Interface Adalah Konsep
 *
 * Functional Interface bukan syntax khusus.
 *
 * Yang terpenting hanyalah:
 *
 * "Interface memiliki tepat satu abstract method."
 *
 * Implementasinya bisa menggunakan:
 *
 * - Anonymous Class
 * - Lambda Expression
 * - Method Reference
 *
 * Contoh:
 *
 * Function<String, String> upper = String::toUpperCase;
 *
 * Pada contoh di atas:
 *
 * Functional Interface : Function
 * Implementasi         : Method Reference
 *
 * ------------------------------------------------------------
 *
 * Predefined Functional Interfaces (java.util.function)
 *
 * 1. Function<T, R>
 *
 * Bentuk:
 * T -> R
 *
 * Method:
 * apply(T value)
 *
 * Digunakan untuk mengubah suatu data menjadi data lain.
 *
 * Contoh:
 *
 * String -> Integer
 * User -> UserDTO
 *
 * Analogi:
 * Mesin transformasi.
 *
 * ------------------------------------------------------------
 *
 * 2. Predicate<T>
 *
 * Bentuk:
 * T -> boolean
 *
 * Method:
 * test(T value)
 *
 * Digunakan untuk melakukan pengecekan kondisi.
 *
 * Sangat sering dipakai pada:
 * - filter()
 * - removeIf()
 * - validasi
 *
 * Analogi:
 * Penyaring (filter).
 *
 * ------------------------------------------------------------
 *
 * 3. Consumer<T>
 *
 * Bentuk:
 * T -> void
 *
 * Method:
 * accept(T value)
 *
 * Menerima data tanpa mengembalikan hasil.
 *
 * Contoh:
 *
 * - print
 * - logging
 * - save data
 *
 * Analogi:
 * Mesin yang hanya menggunakan data.
 *
 * ------------------------------------------------------------
 *
 * 4. Supplier<T>
 *
 * Bentuk:
 * () -> T
 *
 * Method:
 * get()
 *
 * Tidak menerima parameter,
 * tetapi menghasilkan sebuah nilai.
 *
 * Contoh:
 *
 * - random number
 * - object baru
 * - timestamp
 *
 * Analogi:
 * Mesin penyuplai.
 *
 * ------------------------------------------------------------
 *
 * 5. UnaryOperator<T>
 *
 * Bentuk:
 *
 * T -> T
 *
 * Method:
 * apply(T value)
 *
 * Digunakan ketika tipe input dan output sama.
 *
 * Contoh:
 *
 * Integer -> Integer
 * String -> String
 *
 * Analogi:
 * Mengubah sesuatu tanpa mengubah jenisnya.
 *
 * ------------------------------------------------------------
 *
 * 6. BinaryOperator<T>
 *
 * Bentuk:
 *
 * (T, T) -> T
 *
 * Method:
 * apply(T a, T b)
 *
 * Digunakan untuk operasi dua objek
 * dengan tipe yang sama dan menghasilkan tipe yang sama.
 *
 * Contoh:
 *
 * Integer + Integer -> Integer
 * String + String -> String
 *
 * Sering digunakan pada:
 * - reduce()
 * - operasi matematika
 * - penggabungan data
 *
 * ------------------------------------------------------------
 *
 * Ringkasan Cepat
 *
 * Interface               Fungsi
 * ---------------------------------------------------------
 * Function<T, R>          Mengubah data menjadi tipe lain
 * Predicate<T>            Mengecek kondisi (boolean)
 * Consumer<T>             Menggunakan data tanpa return
 * Supplier<T>             Menghasilkan data tanpa input
 * UnaryOperator<T>        Mengubah data dengan tipe yang sama
 * BinaryOperator<T>       Mengolah dua data bertipe sama
 *
 * ------------------------------------------------------------
 *
 * Best Practice
 *
 * - Gunakan functional interface bawaan jika sudah sesuai kebutuhan.
 * - Buat custom functional interface hanya jika benar-benar diperlukan.
 * - Tambahkan @FunctionalInterface agar compiler membantu menjaga aturan SAM.
 * - Gunakan lambda expression atau method reference untuk implementasi sederhana.
 *
 * Intinya:
 * Functional Interface adalah kontrak yang memiliki satu abstract method.
 * Kontrak inilah yang memungkinkan Java menjalankan Lambda Expression,
 * Method Reference, Stream API, serta banyak API modern lainnya secara ringkas
 * dan tetap memiliki type safety.
 */

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterface {
    public static void main(String[] args) {

        // FUNCTION INTERFACE

        // Function<T, R>
        // T = input
        // R = output
        Function<Integer, Integer> factorial = n -> {
            int result = -1;

            for (int i = 1; i <= n; i++) {
                result = i * result;
            }
            return result;
        };

        System.out.println("Faktorial 3: " + factorial.apply(3));
        System.out.println("Faktorial 5: " + factorial.apply(5));

        /**
         * Cara Kerja
         * Ini:
         * Function<Integer, Integer> factorial
         *
         * artinya:
         * Integer → Integer
         *
         * Ini:
         * factorial.apply(3)
         *
         * sama dengan:
         * factorial(3)
         *
         * Bandingkan dengan Cara Lama
         * Cara lama:
         * interface NumericFunc {
         * int func(int n);
         * }
         * 
         * Cara modern:
         * Function<Integer, Integer>
         *
         * Lebih simpel, reusable, standar
         */

        // CASE: Transform Data
        Function<String, Integer> lengthFunc = str -> str.length();
        System.out.println(lengthFunc.apply("Hello")); // 5

        // CASE: Filter Data
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(10)); // true

        // CASE: Consumer
        Consumer<String> printer = str -> System.out.println(str); // Hello bro!
        printer.accept("Hello bro!");

        // CASE: Supplier
        Supplier<Double> random = () -> Math.random();
        System.out.println(random.get()); // 0.2165845578942216

        /**
         * Insight DALAM
         * 1. Ini dipakai di mana-mana
         * Stream API
         * Spring Boot
         * Reactive programming
         * Data processing
         *
         * 2. Ini bikin Java jadi semi-functional language
         * 3. 90% lambda di dunia nyata pakai ini
         *
         * Kesimpulan SUPER SEDERHANA
         * 
         * Inti:
         * Java sudah punya functional interface bawaan
         * Tidak perlu bikin sendiri
         * Yang paling sering:
         * Function → transform
         * Predicate → kondisi
         * Consumer → pakai data
         * Supplier → hasilkan data
         */
    }
}
