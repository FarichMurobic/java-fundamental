package FundamentalJava.Lambda;

/**
 * Generic Functional Interfaces
 * Lambda expression tidak bisa punya generic sendiri
 *
 * Contoh (TIDAK ADA di Java):
 * <T> (x) -> x
 * Tapi…
 *
 * Functional interface-nya bisa generic
 *
 * Artinya:
 * Lambda tetap biasa
 * Tapi “wadahnya” (interface) bisa fleksibel
 *
 * Kenapa ini penting?
 * Di contoh sebelumnya:
 * NumericFunc → buat int
 * StringFunc → buat String
 *
 * Padahal logic sama:
 * 1 parameter
 * 1 return
 *
 * Solusi:
 * Bikin 1 interface generic
 *
 * -----------------------------------
 * 
 * Penjelasan 
 * 
 * 1. Interface Generic
 * interface SomeFunc<T> {
 *     T func(T t);
 * }
 *
 * T = tipe bebas
 * Artinya:
 * input = T
 * output = T
 *
 * bisa:
 * String → String
 * Integer → Integer
 * dll
 *
 * 2. Saat dipakai
 * SomeFunc<String> reverse
 * T = String
 *
 * SomeFunc<Integer> factorial
 * T = Integer
 *
 * 3. Lambda tetap sama
 * (str) -> { ... }
 * (n) -> { ... }
 *
 * Tapi tipe ditentukan dari:
 * SomeFunc<T>
 *
 * 4. Type inference bekerja lagi
 * (str) -> ...
 *
 * Java tau:
 * str = String
 *
 * 5. Reusability 
 * 1 interface bisa dipakai:
 * reverse string
 * factorial
 * operasi lain
 *
 * ------------------------------------
 * 
 * Insight Mentor (Ini penting banget bro)
 * 
 * 1. Ini solusi dari duplikasi code
 *
 * Dari:
 * interface StringFunc
 * interface NumericFunc
 *
 * Jadi:
 * interface SomeFunc<T>
 *
 * 2. Generic + Lambda = powerful banget
 *
 * Lo bisa bikin:
 * reusable logic
 * fleksibel
 * scalable
 *
 * 3. Ini konsep besar di Java modern:
 * “Write once, use everywhere”
 *
 * 4. Ini dasar ke:
 * Function<T, R>
 * Predicate<T>
 * Consumer<T>
 *
 * (built-in Java, WAJIB nanti)
 *
 * 5. Batasan penting 
 * T func(T t);
 *
 * Parameter & return HARUS sama tipe
 *
 * gak bisa:
 * input String → output int
 *
 * [[[[[[[[[[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]]]]]]]]]
 * 
 * Kesimpulan Super Sederhana
 * 1. Lambda tidak bisa generic
 * tapi interface-nya bisa
 *
 * 2. Generic bikin fleksibel
 * SomeFunc<String>
 * SomeFunc<Integer>
 *
 * 3. 1 interface bisa dipakai banyak lambda
 * 4. Tipe ditentukan saat dipakai
 *
 * 5. Parameter & return harus sama tipe
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
