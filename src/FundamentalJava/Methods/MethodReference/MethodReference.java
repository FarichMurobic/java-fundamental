package FundamentalJava.Methods.MethodReference;

/*
 * ============================================================
 * Method Reference Pada Java
 * ============================================================
 *
 * Method reference adalah fitur Java yang memungkinkan kita
 * memberikan referensi terhadap sebuah method tanpa langsung
 * menjalankan method tersebut.
 *
 * Method reference tidak melakukan pemanggilan method saat
 * ditulis.
 *
 * Method tersebut baru akan digunakan ketika functional interface
 * menjalankannya.
 *
 * Bentuk umum:
 *
 * ClassName::methodName
 *
 * atau:
 *
 * object::methodName
 *
 * atau:
 *
 * ClassName::new
 *
 * ------------------------------------------------------------
 * Hubungan Method Reference Dengan Lambda
 * ------------------------------------------------------------
 *
 * Method reference merupakan bentuk penulisan yang lebih singkat
 * dari lambda expression ketika lambda hanya memanggil sebuah
 * method.
 *
 * Contoh menggunakan lambda:
 *
 * (str) -> MyStringOps.strReverse(str)
 *
 *
 * Dapat ditulis menggunakan method reference:
 *
 * MyStringOps::strReverse
 *
 *
 * Keduanya memiliki tujuan yang sama.
 *
 * Perbedaannya:
 *
 * Lambda:
 *
 * Menjelaskan proses yang dilakukan.
 *
 *
 * Method reference:
 *
 * Langsung menunjuk method yang sudah tersedia.
 *
 * ------------------------------------------------------------
 * Kenapa Method Reference Lebih Clean?
 * ------------------------------------------------------------
 *
 * Jika lambda hanya meneruskan parameter ke method lain, maka
 * method reference membuat kode lebih sederhana.
 *
 * Contoh:
 *
 * Lambda:
 *
 * (value) -> process(value)
 *
 *
 * Method reference:
 *
 * this::process
 *
 *
 * Keuntungan:
 *
 * - Lebih singkat.
 * - Lebih mudah dibaca.
 * - Lebih deklaratif.
 *
 * ------------------------------------------------------------
 * Sintaks Dasar
 * ------------------------------------------------------------
 *
 * Static Method Reference
 *
 * Bentuk:
 *
 * ClassName::staticMethodName
 *
 *
 * Contoh:
 *
 * MyStringOps::strReverse
 *
 *
 * Jika terdapat method:
 *
 * class MyStringOps {
 *
 *     static String strReverse(String str) {
 *         return new StringBuilder(str)
 *                 .reverse()
 *                 .toString();
 *     }
 * }
 *
 *
 * Maka:
 *
 * MyStringOps::strReverse
 *
 * sama dengan:
 *
 * str -> MyStringOps.strReverse(str)
 *
 * ------------------------------------------------------------
 * Method Reference Membutuhkan Functional Interface
 * ------------------------------------------------------------
 *
 * Method reference tidak dapat berdiri sendiri.
 *
 * Contoh:
 *
 * String::toUpperCase;
 *
 * Tidak valid.
 *
 * Compiler tidak tahu:
 *
 * - Parameter method apa?
 * - Return type apa?
 * - Method tersebut digunakan untuk apa?
 *
 *
 * Java membutuhkan konteks berupa functional interface.
 *
 * Contoh:
 *
 * Function<String, String> converter =
 *         String::toUpperCase;
 *
 *
 * Sekarang Java mengetahui:
 *
 * Input:
 *
 * String
 *
 * Output:
 *
 * String
 *
 *
 * Method reference tersebut setara dengan:
 *
 * str -> str.toUpperCase()
 *
 * ------------------------------------------------------------
 * Apa Itu Target Type?
 * ------------------------------------------------------------
 *
 * Target type adalah tipe yang memberikan konteks kepada lambda
 * atau method reference.
 *
 * Contoh:
 *
 * Function<String, String> function =
 *         String::toUpperCase;
 *
 *
 * Target type:
 *
 * Function<String, String>
 *
 *
 * Dari sini compiler mengetahui bahwa:
 *
 * Method harus menerima:
 *
 * String
 *
 * Dan menghasilkan:
 *
 * String
 *
 * ------------------------------------------------------------
 * Analogi Lambda dan Method Reference
 * ------------------------------------------------------------
 *
 * Lambda:
 *
 * (str) -> str.toUpperCase()
 *
 *
 * Method Reference:
 *
 * String::toUpperCase
 *
 *
 * Keduanya memiliki arti:
 *
 * "Ambil sebuah String, lalu jalankan method
 * toUpperCase()."
 *
 *
 * Tetapi method reference lebih ringkas.
 *
 * ------------------------------------------------------------
 * Contoh Valid Method Reference
 * ------------------------------------------------------------
 *
 * Contoh 1:
 * Function<String, String> f =
 *         String::toUpperCase;
 *
 *
 * Pemanggilan:
 *
 * System.out.println(
 *         f.apply("halo")
 * );
 *
 *
 * Output:
 *
 * HALO
 *
 * ------------------------------------------------------------
 *
 * Contoh 2:
 *
 * Stream API
 *
 * list.stream()
 *     .map(String::toUpperCase);
 *
 *
 * Method map() membutuhkan:
 *
 * Function<T, R>
 *
 *
 * Sehingga:
 *
 * String::toUpperCase
 *
 * dapat digunakan sebagai implementasi Function.
 *
 * ------------------------------------------------------------
 * Contoh Tidak Valid
 * ------------------------------------------------------------
 *
 * String::toUpperCase;
 *
 *
 * Error.
 *
 * Alasannya:
 *
 * Tidak ada functional interface yang menjadi target.
 *
 * Method reference hanya sebuah referensi, bukan object function
 * yang berdiri sendiri.
 *
 * ------------------------------------------------------------
 * Semua Jenis Method Reference Membutuhkan Functional Interface
 * ------------------------------------------------------------
 *
 * Jenis Method Reference:
 *
 * 1. Static Method
 *
 * Contoh:
 *
 * Integer::parseInt
 *
 *
 * Membutuhkan functional interface.
 *
 *
 * 2. Instance Method Object Tertentu
 *
 * Contoh:
 *
 * object::method
 *
 *
 * Membutuhkan functional interface.
 *
 *
 * 3. Instance Method Class
 *
 * Contoh:
 *
 * String::toUpperCase
 *
 *
 * Membutuhkan functional interface.
 *
 *
 * 4. Constructor Reference
 *
 * Contoh:
 *
 * User::new
 *
 *
 * Membutuhkan functional interface.
 *
 * ------------------------------------------------------------
 * Insight Penting
 * ------------------------------------------------------------
 *
 * 1. Method Reference Bukan Function
 *
 * Java bukan functional programming language murni.
 *
 * Method reference hanyalah cara untuk menyediakan perilaku
 * kepada functional interface.
 *
 *
 * 2. Method Reference Adalah Shortcut Lambda
 *
 * Contoh:
 *
 * Lambda:
 *
 * (str) -> str.toUpperCase()
 *
 *
 * Method reference:
 *
 * String::toUpperCase
 *
 *
 * 3. Functional Interface Adalah Kontrak
 *
 * Functional interface menentukan:
 *
 * - Parameter input.
 * - Return value.
 * - Bentuk method yang harus tersedia.
 *
 *
 * Tanpa functional interface Java tidak tahu bagaimana method
 * reference tersebut harus digunakan.
 *
 * ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * Method reference adalah fitur Java untuk mereferensikan method
 * tanpa langsung mengeksekusinya.
 *
 * Konsep utama:
 *
 * - Method reference adalah versi singkat dari lambda expression.
 * - Method reference tidak dapat berdiri sendiri.
 * - Selalu membutuhkan functional interface sebagai target type.
 * - Compiler menggunakan target type untuk menentukan parameter
 *   dan return value.
 *
 * Prinsip sederhana:
 *
 * Lambda:
 *
 * "Bagaimana cara melakukan sesuatu."
 *
 *
 * Method Reference:
 *
 * "Gunakan method yang sudah ada untuk melakukan sesuatu."
 *
 */

// Functional interface
interface StringFunc {

    // Method menerima String dan return String
    String func(String n);
}

// Class yang punya static method
class MyStringOps {

    // Static method untuk membalik string
    static String strReverse(String str) {

        String result = "";
        int i;
        for (i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}

public class MethodReference {
    // Method yang menerima functional interface
    static String stringOp(StringFunc sf, String s) {
        // Memanggil method dari interface
        return sf.func(s);
    }

    public static void main(String[] args) {

        String inStr = "Lambdas add power to Java";
        String outStr;

        // METHOD REFERENCE
        // Mengirim referensi method (BUKAN memanggil langsung)
        outStr = stringOp(MyStringOps::strReverse, inStr);

        System.out.println("Original String: " + inStr);
        System.out.println("String Reversed: " + outStr);

        /**
         * 1. Perhatikan baris ini
         * MyStringOps::strReverse
         *
         * Ini BUKAN:
         * MyStringOps.strReverse() 
         *
         * Ini:
         * referensi method, bukan eksekusi
         *
         * 2. Cara kerja di balik layar
         * stringOp(MyStringOps::strReverse, inStr);
         *
         * Java:
         * bikin object dari StringFunc
         *
         * isi method func() dengan:
         * return MyStringOps.strReverse(str);
         *
         * adi setara dengan:
         * stringOp((str) -> MyStringOps.strReverse(str), inStr);
         *
         * Kenapa ini bisa?
         * Karena cocok dengan:
         * String func(String n);
         * Dan:
         * static String strReverse(String str)
         *
         * Cocok:
         * parameter: String
         * return: String
         */

    }
}
