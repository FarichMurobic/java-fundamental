package FundamentalJava.Methods.MethodReference;

/**
 * Ada 2 jenis instance method reference:
 *
 * 1. Object tertentu (fixed object)
 * objRef::methodName
 *
 * method dipanggil dari object spesifik
 *
 * 2. Class (object belum diketahui)
 * ClassName::methodName
 *
 * method dipanggil dari object yang dikirim nanti
 *
 * Ini beda walaupun bentuknya mirip!
 *
 * Real Project Insight
 * 1. Ini sering banget di Stream API
 * list.stream()
 *     .map(String::toUpperCase)
 *
 * sama dengan:
 * (str) -> str.toUpperCase()
 *
 * 2. Contoh real Spring Boot style
 * users.stream()
 *      .filter(User::isActive)
 *      .map(User::getName)
 *      .forEach(System.out::println);
 *
 * 3. Contoh compare object
 * list.sort(String::compareToIgnoreCase);
 *
 * ini instance method reference tipe ke-2
 *
 * Bonus: super::method
 * super::methodName
 *
 * buat panggil method parent class
 *
 * ----------------------------------
 * 
 * Kesimpulan 
 * 1. Ada 2 jenis instance method reference:
 * obj::method
 * Class::method
 *
 * 2. Mapping penting:
 * (v1, v2) -> v1.method(v2)
 *
 * 3. Dipakai di:
 * Stream API
 * sorting
 * filtering
 * mapping
 *
 * 4. Bikin code:
 * lebih clean
 * lebih readable
 * lebih profesional
 */

// CASE 1 — Object tertentu (objRef::method)
// Functional interface
interface StringFunct {
    String func(String n);
}

// CASE 1 — Object tertentu (objRef::method)
// Class dengan instance method
class MyString {

    // BUKAN static
    String strReverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}

// CASE 2 — Object belum diketahui (ClassName::method)
// Functional interface generic
interface MyFunc<T> {
    boolean func(T v1, T v2);
}

// CASE 2 — Object belum diketahui (ClassName::method)
// Class data
class HighTemp {
    private int htemp;

    HighTemp(int ht) {
        htemp = ht;
    }

    // Method instance
    boolean sameTemp(HighTemp other) {
        return htemp == other.htemp;
    }
}

public class InstanceMethodReference {

    // CASE 1 — Object tertentu (objRef::method)
    static String stringOp(StringFunct sf, String s) {
        return sf.func(s);
    }

    // CASE 2 — Object belum diketahui (ClassName::method)
    // Method generic
    static <T> int counter(T[] vals, MyFunc<T> f, T v) {

        int count = 0;
        for (int i = 0; i < vals.length; i++) {
            // Lambda/method reference dieksekusi di sini
            if (f.func(vals[i], v))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {

        // CASE 1 — Object tertentu (objRef::method)

        String string = "Lambda add power to java";

        // BUAT OBJECT
        MyString strops = new MyString();

        // METHOD REFERENCE ke object tertentu
        String outStr = stringOp(strops::strReverse, string);

        System.out.println(outStr);

        /**
         * Cara mikirnya:
         * strOps::strReverse
         *
         * artinya:
         * “Pakai method ini dari object strOps”
         *
         * Equivalent lambda:
         * (str) -> strOps.strReverse(str)
         */

        System.out.println();

        // CASE 2 — Object belum diketahui (ClassName::method)
        HighTemp[] data = {
                new HighTemp(10),
                new HighTemp(20),
                new HighTemp(10)
        };

        // METHOD REFERENCE (class-level instance method)
        int result = counter(data, HighTemp::sameTemp, new HighTemp(10));

        System.out.println(result);

        /**
         * CASE 2 — Object belum diketahui (ClassName::method)
         * 
         * Ini yang lebih advance & sering dipakai di real project
         * Interface
         * interface MyFunc<T> {
         *     boolean func(T v1, T v2);
         * }
         *
         * Method reference:
         * HighTemp::sameTemp
         *
         * Cara bacanya:
         * v1.sameTemp(v2)
         *
         * Mapping penting:
         * Functional               Interface	Method
         * v1 (parameter 1)	        object pemanggil
         * v2 (parameter 2)	        parameter method
         *
         * Cara kerja di balik layar
         * HighTemp::sameTemp
         *
         * jadi:
         * (v1, v2) -> v1.sameTemp(v2)
         *
         * Perbedaan Dua Jenis Ini (WAJIB NANGKEP)
         * Jenis	        Bentuk	                Makna
         * Object	        obj::method	method      milik object itu
         * Class	        Class::method	        method dipanggil dari object parameter
         *
         * Contoh cepat:
         * Object:
         * strOps::strReverse
         * strOps.strReverse(x)
         *
         * Class:
         * String::toUpperCase
         * x.toUpperCase()
         */
    }
}
