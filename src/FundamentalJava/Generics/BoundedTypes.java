package FundamentalJava.Generics;

/**
 * Bounded Types (Bounded Type Parameters)
 *
 * Secara default, parameter generic dapat merepresentasikan tipe apa pun.
 *
 * Contoh:
 * class Box<T> { }
 *
 * Artinya:
 * T bisa berupa:
 * - Integer
 * - Double
 * - String
 * - Object
 * - atau class apa pun.
 *
 * Fleksibel memang, tetapi kadang justru terlalu bebas.
 *
 * ------------------------------------------------------------
 *
 * Masalah Generic Tanpa Batas
 *
 * Misalkan kita membuat class:
 *
 * class Stats<T> {
 *     T[] nums;
 * }
 *
 * Tujuan class ini adalah menghitung rata-rata angka.
 *
 * Misalnya:
 * Integer[]
 * Double[]
 * Float[]
 *
 * Namun karena T bebas, compiler juga mengizinkan:
 *
 * Stats<String>
 * Stats<Object>
 *
 * Padahal String bukan angka.
 *
 * ------------------------------------------------------------
 *
 * Kenapa Terjadi Error?
 *
 * Misalnya di dalam method kita menulis:
 *
 * nums[i].doubleValue();
 *
 * Compiler akan menolak.
 *
 * Alasannya sederhana:
 *
 * Java hanya tahu bahwa nums[i] bertipe T.
 *
 * Sedangkan T bisa berupa apa saja.
 *
 * Bisa Integer:
 * Integer punya method doubleValue().
 *
 * Bisa Double:
 * Double juga punya doubleValue().
 *
 * Tapi bisa juga:
 * String
 *
 * String tidak memiliki method doubleValue().
 *
 * Jadi compiler tidak bisa menjamin method tersebut selalu ada.
 *
 * ------------------------------------------------------------
 *
 * Solusinya: Bounded Type
 *
 * Kita bisa memberi batas pada generic menggunakan keyword extends.
 *
 * Bentuk umum:
 *
 * <T extends SuperClass>
 *
 * Artinya:
 * parameter generic T hanya boleh berupa:
 * - SuperClass
 * - subclass dari SuperClass
 *
 * ------------------------------------------------------------
 *
 * Contoh
 *
 * class Stats<T extends Number> {
 *     T[] nums;
 * }
 *
 * Sekarang compiler mengetahui bahwa:
 *
 * T pasti merupakan turunan Number.
 *
 * Karena Number memiliki method:
 *
 * doubleValue()
 * intValue()
 * floatValue()
 * longValue()
 *
 * maka seluruh subclass Number juga memilikinya.
 *
 * Akibatnya kode berikut sekarang valid:
 *
 * nums[i].doubleValue();
 *
 * ------------------------------------------------------------
 *
 * Contoh Tipe yang Diizinkan
 *
 * Dengan:
 *
 * <T extends Number>
 *
 * maka tipe berikut valid:
 *
 * - Byte
 * - Short
 * - Integer
 * - Long
 * - Float
 * - Double
 * - BigInteger
 * - BigDecimal
 * - atau subclass lain dari Number
 *
 * Sedangkan ini tidak valid:
 *
 * - String
 * - Object
 * - Character
 * - Boolean
 *
 * Karena bukan turunan Number.
 *
 * ------------------------------------------------------------
 *
 * Keuntungan Bounded Type
 *
 * 1. Bisa memanggil method tertentu
 *
 * Compiler tahu bahwa semua T mempunyai method milik superclass.
 *
 * Contoh:
 *
 * doubleValue()
 *
 * 2. Type Safety
 *
 * Mencegah programmer menggunakan tipe yang tidak sesuai.
 *
 * Contoh:
 *
 * Stats<String> stats = new Stats<>();
 *
 * Compile-time error.
 *
 * Kesalahan langsung diketahui saat kompilasi,
 * bukan saat program dijalankan.
 *
 * 3. API Lebih Jelas
 *
 * Dengan membaca deklarasi:
 *
 * <T extends Number>
 *
 * programmer langsung tahu bahwa class tersebut memang hanya
 * dirancang untuk bekerja dengan tipe numerik.
 *
 * ------------------------------------------------------------
 *
 * Multiple Bounds
 *
 * Generic juga bisa memiliki lebih dari satu batas.
 *
 * Bentuk umum:
 *
 * <T extends ClassA & InterfaceB & InterfaceC>
 *
 * Aturannya:
 *
 * - Maksimal hanya satu class.
 * - Jika ada class, harus ditulis paling depan.
 * - Sisanya harus berupa interface.
 *
 * Contoh:
 *
 * class Demo<T extends Number & Comparable<T>> { }
 *
 * Artinya:
 *
 * T harus:
 * - merupakan turunan Number
 * - sekaligus mengimplementasikan Comparable
 *
 * ------------------------------------------------------------
 *
 * Aturan Penting
 *
 * Keyword yang digunakan selalu extends.
 *
 * Bahkan ketika membatasi interface.
 *
 * Contoh:
 *
 * <T extends Comparable<T>>
 *
 * Bukan:
 *
 * <T implements Comparable<T>> // ERROR
 *
 * Pada generic, keyword implements tidak digunakan.
 *
 * ------------------------------------------------------------
 *
 * Analogi
 *
 * Tanpa bounded type:
 *
 * T = "siapa saja boleh masuk"
 *
 * Dengan bounded type:
 *
 * T = "hanya anggota tertentu yang boleh masuk"
 *
 * Karena semua anggota memenuhi syarat yang sama,
 * compiler tahu kemampuan apa yang pasti dimiliki setiap T.
 *
 * ------------------------------------------------------------
 *
 * Ringkasan
 *
 * • Secara default, generic dapat menerima tipe apa pun.
 * • Bounded type digunakan untuk membatasi tipe generic.
 * • Bentuk umumnya:
 *      <T extends SuperClass>
 * • Compiler menjadi tahu method apa yang tersedia pada T.
 * • Meningkatkan type safety dan mencegah penggunaan tipe yang salah.
 * • Multiple bounds didukung menggunakan operator '&'.
 * • Pada generic selalu menggunakan keyword extends,
 *   baik untuk class maupun interface.
 */

// KODE SALAH jika belum extends
// Kode benar jika sudah extend Number
class Stats<T extends Number> {

    T[] nums;

    Stats(T[] o) {
        this.nums = o;
    }

    // ALWAYS mengembalikan double
    double average() {
        double sum = 0.0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue(); // ERROR. kalo gak extends Number

            /**
             * Kenapa error?
             *
             * Baris ini:
             * nums[i].doubleValue();
             *
             * Java bilang:
             * "T gak punya method doubleValue()!"
             *
             * Padahal:
             * Integer punya doubleValue()
             * Double punya doubleValue()
             *
             * Tapi:
             * Java gak tau itu
             *
             * Karena:
             * T = bebas (bisa String juga)
             *
             * SOLUSI: BOUNDED TYPES
             * Konsepnya
             *
             * Kita kasih batas:
             * "T cuma boleh tipe tertentu"
             *
             * Syntax
             * // T harus turunan dari superclass
             * <T extends SuperClass>
             *
             * Artinya:
             * T cuma boleh:
             * SuperClass
             * turunannya
             */
        }
        return sum / nums.length;
    }

    // EAAAAAAHHHHHHHHHHHHHHHH
    int averageInteger() {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].intValue();
        }
        return sum / nums.length;
    }
}

public class BoundedTypes {
    public static void main(String[] args) {

        Integer integersnums[] = {1,2,3,4,5};
        Stats<Integer> iob = new Stats<Integer>(integersnums);

        // double
        double v = iob.average();
        System.out.println("iob average is " + v);

        int i = iob.averageInteger();
        System.out.println(i);

        Double doublenums[] = {1.1, 2.2, 3.3, 4.4, 5.5};
        Stats<Double> dob = new Stats<Double>(doublenums);

        double w = dob.average();
        System.out.println("dob average is " + w);

        int ww = dob.averageInteger();
        System.out.println(ww);

    }

}
