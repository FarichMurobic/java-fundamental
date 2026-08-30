package FundamentalJava.Methods.MethodReference;

/*
 * ============================================================
 * Generic Method Reference Pada Java
 * ============================================================
 *
 * Method reference tidak hanya dapat digunakan pada class biasa,
 * tetapi juga dapat digunakan bersama:
 *
 * - Generic class.
 * - Generic method.
 *
 * Dengan kombinasi generic dan method reference, kita dapat
 * membuat kode yang lebih reusable tanpa harus membuat banyak
 * versi method untuk tipe data yang berbeda..
 *
 * ------------------------------------------------------------
 * Konsep Dasar Generic Method Reference
 * ------------------------------------------------------------
 *
 * Generic memungkinkan sebuah method bekerja dengan berbagai
 * macam tipe data.
 *
 * Contoh generic method:
 *
 * static <T> boolean compare(T a, T b) {
 *     return a.equals(b);
 * }
 *
 *
 * Method tersebut dapat digunakan untuk:
 *
 * String
 * Integer
 * Double
 * Object
 *
 *
 * Karena tipe T akan ditentukan ketika method digunakan.
 *
 * ------------------------------------------------------------
 * Method Reference Ke Generic Method
 * ------------------------------------------------------------
 *
 * Method reference dapat menunjuk ke generic method.
 *
 * Bentuk umum:
 *
 * ClassName::methodName
 *
 *
 * Contoh:
 *
 * MyArrayOps::countMatching
 *
 *
 * Java akan mencoba menentukan tipe generic berdasarkan target
 * functional interface.
 *
 * ------------------------------------------------------------
 * Explicit Type Argument Pada Generic Method Reference
 * ------------------------------------------------------------
 *
 * Dalam kondisi tertentu, kita dapat menuliskan tipe generic
 * secara eksplisit.
 *
 * Bentuk:
 *
 * ClassName::<Type>methodName
 *
 *
 * Contoh:
 *
 * MyArrayOps::<Integer>countMatching
 *
 *
 * Artinya:
 *
 * "Gunakan method generic countMatching dengan tipe Integer."
 *
 *
 * Jadi:
 *
 * T generic
 *        |
 *        v
 * Integer
 *
 *
 * Namun penggunaan seperti ini jarang diperlukan karena biasanya
 * compiler dapat melakukan inference.
 *
 * ------------------------------------------------------------
 * Type Inference Pada Java
 * ------------------------------------------------------------
 *
 * Java memiliki kemampuan untuk menentukan generic type secara
 * otomatis berdasarkan konteks.
 *
 * Contoh:
 *
 * MyFunc<Integer> func =
 *         MyArrayOps::countMatching;
 *
 *
 * Compiler mengetahui bahwa method yang digunakan harus cocok
 * dengan:
 *
 * MyFunc<Integer>
 *
 *
 * Sehingga tipe generic dapat ditentukan otomatis.
 *
 * ------------------------------------------------------------
 * Perbandingan Manual vs Inference
 * ------------------------------------------------------------
 *
 * Manual:
 *
 * MyArrayOps::<Integer>countMatching
 *
 *
 * Compiler diberi tahu secara langsung:
 *
 * "Gunakan Integer."
 *
 *
 * Inference:
 *
 * MyArrayOps::countMatching
 *
 *
 * Compiler mencari tahu berdasarkan target type.
 *
 *
 * Pada Java modern, inference lebih sering digunakan karena kode
 * lebih bersih.
 *
 * ------------------------------------------------------------
 * Hubungan Generic Dengan Functional Interface
 * ------------------------------------------------------------
 *
 * Pola yang sering terjadi:
 *
 * Generic Type
 *
 * <T>
 *
 *        |
 *        v
 *
 * Functional Interface
 *
 * MyFunc<T>
 *
 *        |
 *        v
 *
 * Method Reference
 *
 * Class::genericMethod
 *
 *
 * Functional interface memberikan kontrak tentang:
 *
 * - Parameter.
 * - Return value.
 * - Tipe data yang digunakan.
 *
 * ------------------------------------------------------------
 * Contoh Konsep Lengkap
 * ------------------------------------------------------------
 *
 * Misalkan:
 *
 * interface MyFunc<T> {
 *
 *     boolean func(T[] array, T value);
 *
 * }
 *
 *
 * Generic method:
 *
 * static <T> boolean countMatching(
 *         T[] array,
 *         T value
 * ) {
 *
 *     // proses pencarian
 *
 * }
 *
 *
 * Method reference:
 *
 * MyFunc<Integer> finder =
 *         MyArrayOps::countMatching;
 *
 *
 * Java memahami:
 *
 * T = Integer
 *
 *
 * Sehingga method yang digunakan menjadi:
 *
 * countMatching(Integer[], Integer)
 *
 * ------------------------------------------------------------
 * Kenapa Generic + Method Reference Powerful?
 * ------------------------------------------------------------
 *
 * Kombinasi generic dan method reference membuat kode:
 *
 * - Reusable.
 * - Tidak perlu duplicate logic.
 * - Mendukung banyak tipe data.
 *
 *
 * Contoh:
 *
 * Tanpa generic:
 *
 * countInteger()
 * countDouble()
 * countString()
 *
 *
 * Dengan generic:
 *
 * countMatching<T>()
 *
 *
 * Satu method dapat digunakan untuk berbagai tipe.
 *
 * ------------------------------------------------------------
 * Penggunaan Pada Dunia Nyata
 * ------------------------------------------------------------
 *
 * Konsep ini menjadi fondasi dari banyak API Java modern.
 *
 * Contoh penggunaan:
 *
 * - Stream API.
 * - Collections.
 * - Comparator.
 * - Function processing.
 * - Spring Data.
 *
 *
 * Banyak API Java menerima functional interface generic seperti:
 *
 * Function<T, R>
 *
 * Predicate<T>
 *
 * Comparator<T>
 *
 * Supplier<T>
 *
 *
 * Kemudian implementasinya dapat diberikan melalui lambda atau
 * method reference.
 *
 * ------------------------------------------------------------
 * Insight Penting
 * ------------------------------------------------------------
 *
 * Pattern yang harus dipahami:
 *
 * Generic:
 *
 * <T>
 *
 * berarti:
 *
 * "Tipe data masih fleksibel."
 *
 *
 * Functional Interface:
 *
 * MyFunc<T>
 *
 * berarti:
 *
 * "Aturan bagaimana tipe tersebut digunakan."
 *
 *
 * Method Reference:
 *
 * Class::method
 *
 * berarti:
 *
 * "Gunakan method ini sebagai implementasi."
 *
 * ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * Method reference dapat digunakan bersama generic method dan
 * generic class.
 *
 * Poin penting:
 *
 * - Generic membuat kode dapat digunakan untuk banyak tipe data.
 * - Method reference dapat menunjuk generic method.
 * - Type generic dapat ditulis manual atau diinfer otomatis.
 * - Java biasanya lebih memilih type inference.
 * - Method reference tetap membutuhkan functional interface.
 *
 *
 * Prinsip sederhana:
 *
 * <T>
 *     membuat tipe fleksibel.
 *
 * Functional Interface
 *     memberikan kontrak.
 *
 * Method Reference
 *     memberikan implementasi.
 *
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
        for (int i = 0; i < vals.length; i++) {
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

        Integer[] nums = { 1, 2, 3, 2, 2, 5 };
        String[] words = { "A", "B", "A", "C" };

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
