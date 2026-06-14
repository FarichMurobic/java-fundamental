package FundamentalJava.Methods.MethodReference;

/**
 * Apa itu Method Reference?
 *
 * Cara untuk mereferensikan method TANPA mengeksekusinya
 *
 * Hubungannya dengan lambda:
 * Method reference itu:
 * versi lebih singkat & clean dari lambda
 *
 * Contoh konsep:
 * Lambda:
 * (str) -> MyStringOps.strReverse(str)
 *
 * Method Reference:
 * MyStringOps::strReverse
 *
 * Lebih clean 
 * 
 * -------------------------------------
 *
 * Sintaks Dasar
 * 
 * Static Method Reference
 * ClassName::methodName
 *
 * Contoh:
 * MyStringOps::strReverse
 *
 * Insight Mentor
 * 1. Method reference = lambda versi clean
 *
 * Gunakan kalau:
 * lambda cuma manggil method
 *
 * 2. Ini sering banget dipakai di dunia nyata
 *
 * Contoh:
 * list.forEach(System.out::println);
 *
 * 3. Ini bikin code lebih readable
 * Lambda:
 * (str) -> MyStringOps.strReverse(str)
 * Method reference:
 * MyStringOps::strReverse
 *
 * 4. Ini bukan cuma shortcut
 *
 * Tapi juga:
 * lebih deklaratif
 * lebih clean
 * lebih modern
 *
 * -----------------------------------------------
 * 
 * Jenis Method Reference (preview)
 * Static method
 * ClassName::methodName
 *
 * Yang akan datang:
 * instance method
 * constructor reference (::new)
 *
 * Kesimpulan Super Sederhana
 * 1. Method reference = referensi method
 * ClassName::methodName
 * 2. Lebih clean dari lambda
 * 3. Harus cocok dengan functional interface
 * 4. Tidak langsung dieksekusi
 * 5. Dipakai saat lambda cuma panggil method
 */

/**
 * Method reference SELALU butuh functional interface
 * sama seperti lambda
 *
 * Kenapa harus?
 *
 * Karena:
 * Method reference itu bukan pemanggilan method
 * tapi “cara mengisi implementasi method abstract”
 *
 * Contoh:
 * String::toUpperCase
 *
 * ini belum jelas maksudnya kalau berdiri sendiri
 *
 * Java butuh konteks:
 * Function<String, String> f = String::toUpperCase;
 *
 * baru jelas:
 * input: String
 * output: String
 *
 * Analogi biar nempel
 * Lambda:
 * (str) -> str.toUpperCase()
 * Method reference:
 * String::toUpperCase
 *
 * dua-duanya:
 * butuh “wadah” = functional interface
 */

/**
 * Contoh VALID (pakai functional interface)
 * 
 * Contoh 1
 * import java.util.function.Function;
 *
 * Function<String, String> f = String::toUpperCase;
 *
 * System.out.println(f.apply("halo"));
 *
 * Contoh 2 (stream)
 * list.stream()
 *     .map(String::toUpperCase)
 *
 * map() itu expect:
 *
 * Function<T, R>
 *
 * Contoh TIDAK VALID 
 * String::toUpperCase;
 *
 * ERROR
 *
 * Kenapa?
 * gak ada functional interface sebagai target type
 *
 * Semua method reference butuh ini
 * Jenis	            Contoh	            Butuh FI?
 * Static	            Integer::parseInt	ya
 * Object	            obj::method	        ya
 * Class instance	    String::toUpperCase	ya
 * Constructor	        User::new	        ya
 *
 * ---------------------------------------
 * 
 * Insight penting (ini bikin lo naik level)
 * 
 * 1. Method reference bukan “function”
 * Java bukan functional language full
 *
 * 2. Dia cuma shortcut lambda
 * (str) -> str.toUpperCase()
 * jadi:
 * String::toUpperCase
 *
 * 3. Functional interface = “kontrak”
 * Tanpa itu:
 * Java gak tau:
 * parameter apa?
 * return apa?
 *
 * Kesimpulan Super Sederhana
 * Inti:
 * Method reference = versi singkat lambda
 * HARUS punya functional interface
 * tidak bisa berdiri sendiri
 * selalu butuh target type
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
