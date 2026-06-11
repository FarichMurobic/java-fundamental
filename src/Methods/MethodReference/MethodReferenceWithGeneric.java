package Methods.MethodReference;

/**
 * Intinya:
 *
 * Method reference bisa dipakai ke:
 * generic class 
 * generic method 
 * Type generic bisa:
 * ditulis manual
 * atau di-infer otomatis sama Java
 *
 * Konsep Inti (WAJIB PAHAM)
 * 
 * Perhatikan ini:
 * MyArrayOps::<Integer>countMatching
 *
 * Artinya:
 * “Pakai method generic countMatching dengan tipe Integer”
 *
 * Struktur:
 * ClassName::<Type>methodName
 *
 * Tapi biasanya:
 * Java AUTO ngerti
 *
 * Jadi ini cukup:
 * MyArrayOps::countMatching
 *
 * Insight DALAM (ini yang bikin lo beda)
 * 1. Generic + Lambda = powerful banget
 *
 * lo bikin code reusable tanpa duplicate
 *
 * 2. Ini fondasi:
 * Stream API
 * Collections
 * Spring Data
 *
 * 3. Pattern yang terjadi:
 * <T> → type fleksibel
 * MyFunc<T> → kontrak
 * Method reference → implementasi
 *
 * Kesimpulan Super Sederhana
 * Inti:
 * Method reference bisa dipakai di generic method
 * Type bisa otomatis (inference)
 * Bisa manual pakai <T> (jarang)
 * Tetap butuh functional interface
 */

import java.util.List;

// Functional interface generic
interface MyFunc1<T> {
    // Method menerima array T dan value T
    int func(T[] vals, T v);
}

// Class NON-generic
class MyArrayOps {
    // Method GENERIC
    static <T> int countMatching(T[] vals, T v) {
        int count = 0;
        // Bandingkan isi array dengan value
        for (int i =0; i < vals.length; i++) {
            if (vals[i].equals(v)) // pakai equals biar aman
                count++;
        }
        return count;
    }
}

public class MethodReferenceWithGeneric {
    // Method generic yang menerima lambda / method reference
    static <T> int myOp(MyFunc1<T> f, T[] vals, T v) {
        // Eksekusi functional interface
        return f.func(vals, v);
    }

    // CONTOH REAL PROJECT
    // Generic method + functional interface
    static <T> long count(List<T> list, T value) {
        return list.stream()
                .filter(value::equals) // method reference instance
                .count();

    }

    public static void main(String[] args) {

        Integer[] nums = {1,2,3,2,2,5};
        String[] words = {"A", "B", "A", "C"};

        // METHOD REFERENCE + GENERIC
        int count1 = myOp(MyArrayOps::countMatching, nums, 2);
        System.out.println("Jumlah angka 2: " + count1);

        int count2 = myOp(MyArrayOps::countMatching, words, "A");
        System.out.println("Jumlah kata A: " + count2);

        /**
         * Cara Kerja di Balik Layar
         *
         * Ini:
         * MyArrayOps::countMatching
         *
         * sama dengan:
         * (vals, v) -> MyArrayOps.countMatching(vals, v)
         *
         * Dan genericnya:
         * otomatis jadi:
         *
         * Integer saat pakai array Integer
         * String saat pakai array String
         *
         * Kapan Harus Tulis <T> Manual?
         * Jarang banget, tapi perlu kalau:
         * Java gak bisa infer type
         * ada ambiguity (bingung milih tipe)
         *
         * Contoh manual:
         * MyArrayOps::<Integer>countMatching
         *
         * Tapi 90% kasus:
         * MyArrayOps::countMatching
         *
         * cukup
         */

        System.out.println();

        List<String> data = List.of("A", "B", "A", "C");
        System.out.println(count(data, "A"));

        /**
         * Di sini:
         * value::equals
         *
         * sama dengan:
         * (x) -> value.equals(x)
         */
    }
}
