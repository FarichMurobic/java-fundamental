package FundamentalJava.Generics;

/* ============================================================
 *                     GENERIC METHOD
 * ============================================================
 *
 * Generic method adalah method yang memiliki satu atau lebih
 * type parameter sendiri.
 *
 * Berbeda dengan generic class, type parameter pada generic
 * method hanya berlaku di dalam method tersebut.
 *
 * Dengan demikian, sebuah class tidak harus menjadi generic
 * untuk dapat memiliki generic method.
 */


/* ------------------------------------------------------------
 * Perbedaan Generic Class dan Generic Method
 * ------------------------------------------------------------
 *
 * Generic class:
 *
 * class Box<T> {
 *     ...
 * }
 *
 * Type parameter T berlaku untuk seluruh anggota class,
 * seperti field, constructor, maupun method.
 *
 * Generic method:
 *
 * <T> void method(T value) {
 *     ...
 * }
 *
 * Pada kasus ini, T hanya berlaku di dalam method tersebut.
 * Method lain di class yang sama tidak dapat menggunakan
 * type parameter tersebut kecuali mendeklarasikannya sendiri.
 */


/* ------------------------------------------------------------
 * Bentuk Umum Generic Method
 * ------------------------------------------------------------
 *
 * Generic method selalu menuliskan type parameter sebelum
 * return type.
 *
 * Bentuk umum:
 *
 * <T> ReturnType methodName(Parameter)
 *
 * Contoh:
 *
 * <T> void print(T value)
 *
 * Generic method juga dapat memiliki lebih dari satu
 * type parameter.
 *
 * Contoh:
 *
 * <T, V> void process(T first, V second)
 */


/* ------------------------------------------------------------
 * Mengapa Menggunakan Generic Method?
 * ------------------------------------------------------------
 *
 * Generic method memungkinkan satu method digunakan untuk
 * berbagai tipe data tanpa kehilangan type safety.
 *
 * Compiler akan memverifikasi bahwa seluruh tipe yang digunakan
 * sesuai dengan deklarasi generic.
 *
 * Kesalahan tipe dapat dideteksi sejak compile-time,
 * sehingga mengurangi kemungkinan terjadinya
 * ClassCastException saat runtime.
 */


/* ------------------------------------------------------------
 * Type Inference
 * ------------------------------------------------------------
 *
 * Salah satu keunggulan generic method adalah compiler mampu
 * menentukan type argument secara otomatis.
 *
 * Mekanisme ini disebut:
 *
 * Type Inference
 *
 * Contoh:
 *
 * isIn(2, nums);
 *
 * Compiler menyimpulkan:
 *
 * T = Integer
 * V = Integer
 *
 * Contoh lain:
 *
 * isIn("two", strs);
 *
 * Compiler menyimpulkan:
 *
 * T = String
 * V = String
 *
 * Programmer tidak perlu menentukan type argument secara manual.
 */


/* ------------------------------------------------------------
 * Type Inference Secara Eksplisit
 * ------------------------------------------------------------
 *
 * Meskipun jarang diperlukan, type argument juga dapat
 * ditentukan secara eksplisit.
 *
 * Contoh:
 *
 * GenMethDemo.<Integer, Integer>isIn(2, nums);
 *
 * Namun pada hampir semua kasus,
 * compiler mampu melakukan type inference secara otomatis,
 * sehingga penulisan yang umum digunakan adalah:
 *
 * isIn(2, nums);
 */


/* ------------------------------------------------------------
 * Contoh Kesalahan Type
 * ------------------------------------------------------------
 *
 * Misalkan terdapat pemanggilan:
 *
 * isIn("two", nums);
 *
 * Jika:
 *
 * nums bertipe Integer[]
 *
 * maka compiler akan menyimpulkan:
 *
 * T = String
 * V = Integer
 *
 * Kedua type argument tersebut tidak memenuhi hubungan
 * yang diharapkan oleh method, sehingga compiler akan
 * menghasilkan compile-time error.
 *
 * Inilah salah satu bentuk perlindungan type safety
 * yang diberikan oleh generic.
 */


/* ------------------------------------------------------------
 * Generic Method dengan Bound
 * ------------------------------------------------------------
 *
 * Sama seperti generic class,
 * generic method juga dapat menggunakan bounded type parameter.
 *
 * Contoh:
 *
 * <T extends Number>
 *
 * atau:
 *
 * <T extends Comparable<T>>
 *
 * Constraint tersebut membatasi tipe yang dapat digunakan
 * sebagai type argument sekaligus memungkinkan method
 * mengakses operasi yang dimiliki oleh bound tersebut.
 */


/* ------------------------------------------------------------
 * Keunggulan Generic Method
 * ------------------------------------------------------------
 *
 * Generic method memberikan beberapa keuntungan, antara lain:
 *
 * - Satu method dapat digunakan untuk berbagai tipe data.
 *
 * - Tidak memerlukan casting manual.
 *
 * - Type safety diperiksa oleh compiler.
 *
 * - Kode menjadi lebih reusable.
 *
 * - Dapat dikombinasikan dengan bounded type parameter
 *   untuk membatasi tipe yang diperbolehkan.
 */


/* ------------------------------------------------------------
 * Analogi
 * ------------------------------------------------------------
 *
 * Tanpa generic method,
 * sebuah method biasanya hanya dirancang untuk satu tipe data.
 *
 * Dengan generic method,
 * method yang sama dapat digunakan untuk berbagai tipe,
 * misalnya:
 *
 * Integer
 * String
 * Double
 * Character
 *
 * selama seluruh syarat generic yang ditentukan
 * tetap terpenuhi.
 */


/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * - Generic method memiliki type parameter sendiri.
 *
 * - Type parameter ditulis sebelum return type.
 *
 *      <T> void method(...)
 *
 * - Generic method dapat memiliki lebih dari satu
 *   type parameter.
 *
 *      <T, V>
 *
 * - Generic method dapat menggunakan bounded type parameter.
 *
 *      <T extends Number>
 *
 * - Compiler melakukan type inference secara otomatis
 *   pada sebagian besar pemanggilan method.
 *
 * - Generic method meningkatkan fleksibilitas,
 *   reusability, dan type safety.
 */


/* ------------------------------------------------------------
 * Insight
 * ------------------------------------------------------------
 *
 * Generic method banyak digunakan pada Java Standard Library
 * maupun framework modern.
 *
 * Contohnya dapat ditemukan pada:
 *
 * - Collections
 * - Arrays
 * - Optional
 * - Stream API
 * - Utility class lainnya
 *
 * Dengan generic method, satu implementasi method dapat
 * digunakan oleh berbagai tipe data tanpa perlu membuat
 * versi method yang berbeda untuk setiap tipe.
 */

class GenericMethods {

    // 1
    // Method generic untuk mengecek apakah suatu method ada di dalam array
    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (int i = 0; i < y.length; i++) {
            if (x.equals(y[i])) {
                return true;
            }
        }
        return false;
    }

    // SINGLE WKWKWK
    static <T> void print(T data) {
        System.out.println(data);
    }

    // 2 
    // Buat method:  balikin nilai terbesar dari 2 angka
    // pakai comparable
    // method generic untuk mencari nilai terbesar
    static <T extends Comparable<T>> T max(T a, T b) {
        if (a.compareTo(b) > 0) {
            return a;
        } else {
            return b;
        }
    }

    // 3 (ARRAY)
    // Buat method: cek apakah suatu value ada di array
    // Method generic untuk cek apakah value ada di array
    static <T> boolean contains(T x, T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (x.equals(arr[i])) {
                return true;
            }
        }
        return false;
    }

    // 4 (DUA TYPE PARAMETER)
    // Buat method: print 2 data dengan tipe berbeda
    // Method generic dengan dua tipe
    static <T, V> void printDuaData(T a, V b) {
        System.out.println(a);
        System.out.println(b);
    }

    // 5
    // Buat method: cek apakah value ada di array, tapi array boleh subtype dari value
    // Method generic dengan hubungan antar tipe
    static <T, V extends T> boolean isIn(T x, V[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (x.equals(arr[i])) {
                return true;
            }
        }
        return false;
    }

    // 6
    // Buat method: cari nilai terkecil dari array
    // Method generic untuk mencari nilai terkecil
    static <T extends Comparable<T>> T min(T[] arr) {
        T min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(min) < 0) {
                min = arr[i];
            }
        }
        return min;
    }
}

public class GenericMethod {
    public static void main(String[] args) {
        
        // Menggunakan isIn untuk Integer
        Integer[] nums = {1,2,3,4,5};

        if (GenericMethods.isIn(2, nums)) {
            System.out.println("2 ada di nums!");
        }

        if (!GenericMethods.isIn(7, nums)) {
            System.out.println("7 tidak ada di nums");
        }

        System.out.println();

        // Menggunakan isIn() untuk String
        String strs[] = {"one", "two", "three", "four", "five"};

        if (GenericMethods.isIn("two", nums)) {
            System.out.println("two ada di strs");
        }

        if (!GenericMethods.isIn("seven", nums)) {
            System.out.println("seven tidak ada di strs");
        }

        /**
         * if(GenericsMethods.isIn("two", nums)) {
         * System.out.println("two ada di nums");
         * }
         *
         * ini akan error - data tidak kompatibel
         *
         * OUTPUT
         * 2 ada di nums
         * 7 tidak ada di nums
         *
         * two ada di strs
         * seven tidak ada di strs
         */

        /**
         * BEDAH PALING PENTING (INI INTI BANGET)
         * 
         * Method ini:
         * static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y)
         *
         * Pecah satu-satu:
         * 1. <T extends Comparable<T>>
         *
         * Artinya:
         * T harus bisa dibandingkan
         *
         * Contoh:
         * Integer (punya equals & Comparable)
         * String 
         * Object biasa 
         *
         * 2. <V extends T>
         *
         * Artinya:
         * V harus:
         * sama dengan T
         * atau turunan dari T
         *
         * Jadi:
         * T = String
         * V = String 
         * V = Integer 
         *
         * 3. Parameter method
         * T x      // nilai yang dicari
         * V[] y    // array tempat mencari
         */

        System.out.println();
        
        GenericMethods.print("Data");
        GenericMethods.print(22);
        GenericMethods.print("Janera " + 22);

        System.out.println();

        int nilaiInteger = GenericMethods.max(10, 20);
        System.out.println(nilaiInteger);
        double nilaiDouble = GenericMethods.max(3.5,2.1);
        System.out.println(nilaiDouble);

        System.out.println();

        Integer dataArray[] = {1,2,3,4,5};
        String dataString[] = {"apel", "jeruk", "mangga"};

        boolean hasil;
        hasil = GenericMethods.contains(3, dataArray);
        System.out.println(hasil);
        hasil = GenericMethods.contains(7, dataArray);
        System.out.println(hasil);
        hasil = GenericMethods.contains("semangka", dataString);
        System.out.println(hasil);
        hasil = GenericMethods.contains("jeruk", dataString);
        System.out.println(hasil);
        hasil = GenericMethods.contains("Jeruk", dataString);
        System.out.println(hasil);

        System.out.println();

        GenericMethods.printDuaData("Januar June", 22);

        System.out.println();

        Integer angka[] = {25,24,65,74,65};
        boolean apakahAda;
        apakahAda = GenericMethods.isIn(41, angka);
        System.out.println(apakahAda);
        apakahAda = GenericMethods.isIn(25, angka);
        System.out.println(apakahAda);

        System.out.println();
        int nilaiMax = GenericMethods.min(angka);
        System.out.println(nilaiMax);

    }
}
