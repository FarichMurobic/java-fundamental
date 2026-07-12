package FundamentalJava.Methods.MethodReference;

/*
 * ============================================================
 * Instance Method Reference Pada Java
 * ============================================================
 *
 * Method reference adalah fitur Java yang memungkinkan kita
 * mereferensikan sebuah method tanpa langsung menjalankannya.
 *
 * Method reference diperkenalkan pada Java 8 dan sering digunakan
 * bersama:
 *
 * - Lambda Expression.
 * - Functional Interface.
 * - Stream API.
 *
 * Bentuk umum method reference:
 *
 * object::methodName
 *
 * atau:
 *
 * ClassName::methodName
 *
 * Method reference merupakan bentuk penulisan yang lebih singkat
 * dari lambda expression ketika lambda hanya memanggil sebuah
 * method.
 *
 * ------------------------------------------------------------
 * Hubungan Lambda dan Method Reference
 * ------------------------------------------------------------
 *
 * Contoh lambda:
 *
 * (String text) -> text.toUpperCase()
 *
 * Dapat ditulis lebih sederhana menjadi:
 *
 * String::toUpperCase
 *
 * Karena Java sudah mengetahui bahwa method toUpperCase()
 * dipanggil dari object String yang diberikan.
 *
 * ------------------------------------------------------------
 * Jenis Instance Method Reference
 * ------------------------------------------------------------
 *
 * Instance method reference memiliki dua bentuk utama:
 *
 * 1. Reference ke Object Tertentu
 *
 * Bentuk:
 *
 * objectReference::methodName
 *
 *
 * Method akan dipanggil dari object yang sudah ada.
 *
 * Contoh:
 *
 * String nama = "java";
 *
 * Supplier<String> supplier = nama::toUpperCase;
 *
 *
 * Sama seperti:
 *
 * () -> nama.toUpperCase()
 *
 *
 * Pada contoh tersebut:
 *
 * - Object String sudah diketahui.
 * - Method dipanggil dari object tersebut.
 *
 * ------------------------------------------------------------
 * 2. Reference ke Class Dengan Instance Method
 * ------------------------------------------------------------
 *
 * Bentuk:
 *
 * ClassName::methodName
 *
 *
 * Bentuk ini terlihat seperti pemanggilan static method, tetapi
 * sebenarnya mengacu kepada instance method.
 *
 * Object yang akan digunakan diberikan nanti sebagai parameter.
 *
 * Contoh:
 *
 * Function<String, String> converter =
 *         String::toUpperCase;
 *
 *
 * Sama seperti:
 *
 * text -> text.toUpperCase()
 *
 *
 * Java memahami bahwa object String akan menjadi target dari
 * method toUpperCase().
 *
 * ------------------------------------------------------------
 * Perbedaan Dua Bentuk Instance Method Reference
 * ------------------------------------------------------------
 *
 * Object::method
 *
 * - Object sudah tersedia.
 * - Method dipanggil dari object tertentu.
 *
 * Contoh:
 *
 * myObject::method
 *
 *
 * Class::method
 *
 * - Object belum diberikan saat membuat reference.
 * - Object diberikan ketika functional interface dijalankan.
 *
 * Contoh:
 *
 * String::toUpperCase
 *
 * ------------------------------------------------------------
 * Penggunaan Dalam Stream API
 * ------------------------------------------------------------
 *
 * Method reference sangat sering digunakan pada Stream API karena
 * membuat kode lebih ringkas dan mudah dibaca.
 *
 * Contoh:
 *
 * list.stream()
 *     .map(String::toUpperCase);
 *
 *
 * Setara dengan:
 *
 * list.stream()
 *     .map(text -> text.toUpperCase());
 *
 *
 * Proses:
 *
 * Setiap element String dari stream akan dikirim ke method
 * toUpperCase().
 *
 * ------------------------------------------------------------
 * Contoh Real Project Style
 * ------------------------------------------------------------
 *
 * Misalnya terdapat list User:
 *
 * users.stream()
 *      .filter(User::isActive)
 *      .map(User::getName)
 *      .forEach(System.out::println);
 *
 *
 * Penjelasan:
 *
 * User::isActive
 *
 * Sama seperti:
 *
 * user -> user.isActive()
 *
 *
 * User::getName
 *
 * Sama seperti:
 *
 * user -> user.getName()
 *
 *
 * System.out::println
 *
 * Sama seperti:
 *
 * name -> System.out.println(name)
 *
 * ------------------------------------------------------------
 * Method Reference Untuk Sorting
 * ------------------------------------------------------------
 *
 * Method reference juga sering digunakan pada Comparator.
 *
 * Contoh:
 *
 * list.sort(String::compareToIgnoreCase);
 *
 *
 * Setara dengan:
 *
 * (a, b) -> a.compareToIgnoreCase(b)
 *
 *
 * Java akan menggunakan method compareToIgnoreCase() untuk
 * membandingkan dua object String.
 *
 * ------------------------------------------------------------
 * Method Reference super::methodName
 * ------------------------------------------------------------
 *
 * Java juga menyediakan method reference menggunakan keyword
 * super.
 *
 * Bentuk:
 *
 * super::methodName
 *
 *
 * Digunakan untuk mereferensikan method milik superclass.
 *
 * Contoh:
 *
 * super::show
 *
 *
 * Konsepnya mirip dengan:
 *
 * super.show()
 *
 *
 * Tetapi digunakan ketika membutuhkan method reference, bukan
 * langsung menjalankan method.
 *
 * ------------------------------------------------------------
 * Aturan Method Reference
 * ------------------------------------------------------------
 *
 * Method reference hanya dapat digunakan jika signature method
 * sesuai dengan functional interface yang digunakan.
 *
 * Contoh:
 *
 * Function<String, Integer> parser =
 *         String::length;
 *
 *
 * Setara:
 *
 * text -> text.length()
 *
 *
 * Karena:
 *
 * Input:
 * String
 *
 * Output:
 * Integer
 *
 * Sesuai dengan Function<T, R>.
 *
 * ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * Instance method reference memiliki dua bentuk utama:
 *
 * 1. Object reference:
 *
 * object::methodName
 *
 * Object sudah tersedia.
 *
 *
 * 2. Class reference:
 *
 * ClassName::methodName
 *
 * Object diberikan saat method dijalankan.
 *
 *
 * Konsep penting:
 *
 * Lambda:
 *
 * value -> value.method()
 *
 *
 * Dapat disederhanakan menjadi:
 *
 * ClassName::method
 *
 *
 * Method reference sering digunakan pada:
 *
 * - Stream API.
 * - Filtering.
 * - Mapping.
 * - Sorting.
 * - Functional programming.
 *
 * Keuntungan:
 *
 * - Kode lebih singkat.
 * - Lebih mudah dibaca.
 * - Lebih sesuai dengan gaya Java modern.
 *
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
