package FundamentalJava.FunctionalInterface;

    /**
     * Functional interface = SEMUA interface yang punya 1 abstract method
     * SAM Single Abstract Method
     * Mau:
     * lo bikin sendiri 
     * atau bawaan Java 
     *
     * Ada 2 jenis Functional Interface
     *
     * 1. Custom (yang lo bikin sendiri)
     * // Ini yang sering di buku
     * interface MyFunc {
     *     int apply(int x);
     * }
     *
     * 2. Built-in (yang disediain Java)
     *
     * ini yang sering dipakai di real project
     *
     * Contoh:
     * Function
     * Function<String, Integer> f = String::length;
     * Predicate
     * Predicate<Integer> p = (n) -> n > 10;
     * Consumer
     * Consumer<String> c = System.out::println;
     * Supplier
     * Supplier<Double> s = Math::random;
     *
     * Kenapa Java nyediain built-in?
     * Karena kalau gak…
     * lo bakal bikin ini terus:
     *
     * interface MyStringToInt {
     *     int convert(String s);
     * }
     *
     * padahal udah ada:
     * Function<String, Integer>
     *
     * Jadi:
     * Built-in = biar gak reinvent the wheel
     * 
     * ---------------------------------------
     *
     * Kapan pakai custom vs built-in?
     * Pakai built-in kalau:
     * cuma transform data
     * filter
     * consume
     * supply
     *
     * 90% kasus real project
     *
     * Pakai custom kalau:
     * logic spesifik
     * parameter aneh / banyak
     * butuh nama method yang meaningful
     * Contoh custom:
     * interface PaymentValidator {
     *     boolean validate(User user, double amount);
     * }
     *
     * Functional interface itu konsep, bukan syntax
     * bukan soal:
     * harus bikin interface sendiri 
     *
     * tapi soal:
     * “kontrak 1 method” 
     *
     * Lambda & Method Reference itu implementasi
     * Function<String, String> f = String::toUpperCase;
     *
     * di sini:
     * FI = Function
     * implementasi = method reference
     *
     * Kesimpulan Super Padat
     * Inti:
     * Functional interface ≠ harus bikin sendiri
     * Yang penting: 1 abstract method
     * Java udah nyediain banyak (Function, Predicate, dll)
     * Lambda & method reference butuh ini
     */

    /**
     * Sampai sekarang:
     *
     * kita bikin sendiri interface kayak:
     * NumericFunc
     * StringFunc
     *
     * Konsep Inti (WAJIB BANGET PAHAM)
     * Intinya:
     * “Gak perlu bikin interface sendiri lagi, Java udah sediain”
     *
     * Kenapa ini penting?
     *
     * Karena:
     * lebih cepat
     * lebih standar
     * dipakai di Stream API
     * dipakai di Spring Boot
     *
     * Daftar Interface Penting
     * Tabel Predefined Functional Interfaces (Java)
     * Interface	         Bentuk Umum	   Method	             Deskripsi (Bahasa Indo)
     * Function<T, R>	     T → R	           apply(T t)	         Mengubah (transform) satu data menjadi data lain. Contoh: String jadi Integer, objek jadi DTO
     * Predicate<T>	         T → boolean	   test(T t)	         Mengecek kondisi / filter. Hasilnya true atau false
     * Consumer<T>	         T → void          accept(T t)	         Menggunakan data tanpa mengembalikan nilai. Biasanya buat print, save, log
     * Supplier<T>	         void → T	       get()	             Menghasilkan data tanpa input. Contoh: random number, object baru
     * UnaryOperator<T>	     T → T	           apply(T t)	         Mengubah data tapi tipe tetap sama. Contoh: angka diubah tapi tetap Integer
     * BinaryOperator<T>	 (T, T) → T	       apply(T t1, T t2)	 Operasi dua data dengan tipe sama, hasilnya juga sama. Contoh: penjumlahan
     *
     * 1. Function<T, R>
     * Function<T, R>
     * dari T → jadi R
     * Contoh:
     * Integer → String
     * Method:
     * apply()
     * Analoginya:
     * mesin transformasi
     *
     * 2. Predicate<T>
     * Predicate<T>
     * ngecek kondisi → hasil boolean
     *
     * Method:
     * test()
     * Analoginya:
     * filter / if condition
     *
     * 3. Consumer<T>
     * Consumer<T>
     * menerima data, tapi tidak return
     *
     * Method:
     * accept()
     * Analoginya:
     * printer (cuma pakai, gak balikin)
     *
     * 4. Supplier<T>
     * Supplier<T>
     * tidak ada input, tapi return data
     *
     * Method:
     * get()
     * Analoginya:
     * mesin vending (keluarin sesuatu)
     *
     * 5. UnaryOperator<T>
     * UnaryOperator<T>
     *
     * T → T
     *
     * Contoh:
     * Integer → Integer
     *
     * 6. BinaryOperator<T>
     * BinaryOperator<T>
     *
     * T + T → T
     *
     * Contoh:
     * int + int → int
     *
     * Ringkasan Kilat (Versi Hafalan)
     * Interface	    Fungsi Cepat
     * Function	        Ubah data
     * Predicate	    Cek kondisi
     * Consumer	        Pakai data
     * Supplier	        Hasilkan data
     * UnaryOperator	Ubah tipe sama
     * BinaryOperator	Operasi 2 data
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
         *     int func(int n);
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
        Supplier<Double> random =() -> Math.random();
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
