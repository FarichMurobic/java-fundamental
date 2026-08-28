package FundamentalJava.Generics;

/* ============================================================
 *             GENERICS DAN REFERENCE TYPE
 * ============================================================
 *
 * Pada Java, type argument yang digunakan pada generic
 * harus berupa reference type (tipe referensi).
 *
 * Primitive type tidak dapat digunakan secara langsung
 * sebagai type argument..
 *
 * Primitive type:
 *
 * int
 * long
 * short
 * byte
 * float
 * double
 * char
 * boolean
 *
 * Seluruh tipe di atas tidak dapat ditulis di dalam
 * parameter generic.
 */

/* ------------------------------------------------------------
 * Contoh yang Tidak Valid
 * ------------------------------------------------------------
 *
 * Gen<int> obj = new Gen<int>(53);
 *
 * Kode tersebut menghasilkan compile-time error karena
 * int merupakan primitive type.
 *
 * Generic di Java hanya menerima object (reference type),
 * bukan primitive type.
 */

/* ------------------------------------------------------------
 * Solusinya: Wrapper Class
 * ------------------------------------------------------------
 *
 * Setiap primitive type memiliki pasangan berupa wrapper class.
 *
 * Primitive        Wrapper
 * --------------------------------
 * byte             Byte
 * short            Short
 * int              Integer
 * long             Long
 * float            Float
 * double           Double
 * char             Character
 * boolean          Boolean
 *
 * Wrapper class merupakan reference type sehingga dapat
 * digunakan sebagai type argument pada generic.
 */

/* ------------------------------------------------------------
 * Contoh yang Valid
 * ------------------------------------------------------------
 *
 * Gen<Integer> obj = new Gen<>(53);
 *
 * Pada contoh tersebut:
 *
 * Integer merupakan wrapper class sehingga dapat digunakan
 * sebagai type argument.
 *
 * Penulisan diamond operator (<>) juga memungkinkan compiler
 * melakukan type inference terhadap type argument.
 */

/* ------------------------------------------------------------
 * Autoboxing dan Unboxing
 * ------------------------------------------------------------
 *
 * Perhatikan kode berikut:
 *
 * Gen<Integer> obj = new Gen<>(53);
 *
 * Meskipun nilai yang diberikan adalah primitive int,
 * compiler secara otomatis melakukan:
 *
 * Autoboxing
 *
 * yaitu mengubah:
 *
 * int
 *
 * menjadi:
 *
 * Integer
 *
 * Sebaliknya, ketika object Integer digunakan sebagai int,
 * compiler akan melakukan:
 *
 * Unboxing
 *
 * Kedua proses tersebut berlangsung secara otomatis sehingga
 * programmer tidak perlu melakukan konversi secara manual.
 */

/* ------------------------------------------------------------
 * Generic dengan Type Argument Berbeda
 * ------------------------------------------------------------
 *
 * Walaupun berasal dari generic class yang sama,
 * setiap type argument menghasilkan tipe yang berbeda.
 *
 * Contoh:
 *
 * Gen<Integer>
 * Gen<String>
 *
 * Kedua tipe tersebut tidak memiliki hubungan inheritance
 * hanya karena menggunakan generic class yang sama.
 *
 * Artinya:
 *
 * Gen<Integer>
 *
 * bukan merupakan subtype maupun supertype dari:
 *
 * Gen<String>
 */

/* ------------------------------------------------------------
 * Contoh yang Tidak Valid
 * ------------------------------------------------------------
 *
 * Gen<Integer> intObj = new Gen<>(10);
 * Gen<String> strObj = new Gen<>("Hello");
 *
 * intObj = strObj;
 *
 * Compiler akan menghasilkan compile-time error karena:
 *
 * Gen<Integer>
 *
 * dan:
 *
 * Gen<String>
 *
 * merupakan dua parameterized type yang berbeda.
 *
 * Java menjaga agar object dengan type argument berbeda
 * tidak dapat dipertukarkan secara sembarangan.
 */

/* ------------------------------------------------------------
 * Mengapa Aturan Ini Penting?
 * ------------------------------------------------------------
 *
 * Salah satu tujuan utama generic adalah menjaga
 * type safety.
 *
 * Dengan membedakan setiap parameterized type,
 * compiler dapat mencegah penggunaan object yang
 * tidak sesuai sejak proses kompilasi.
 *
 * Hal ini mengurangi kemungkinan terjadinya
 * ClassCastException saat program dijalankan.
 */

/* ------------------------------------------------------------
 * Generic Mengubah Runtime Error Menjadi Compile-Time Error
 * ------------------------------------------------------------
 *
 * Sebelum generic diperkenalkan,
 * collection umumnya menggunakan Object.
 *
 * Akibatnya programmer harus melakukan casting manual
 * ketika mengambil data.
 *
 * Kesalahan casting sering kali baru diketahui
 * saat program dijalankan (runtime).
 *
 * Dengan generic:
 *
 * - Type diperiksa oleh compiler.
 * - Casting dilakukan secara otomatis jika diperlukan.
 * - Kesalahan tipe dapat ditemukan lebih awal,
 *   yaitu saat compile-time.
 *
 * Pendekatan ini membuat program menjadi lebih aman
 * dan lebih mudah dipelihara.
 */

/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * - Generic hanya menerima reference type sebagai
 *   type argument.
 *
 * - Primitive type harus menggunakan wrapper class.
 *
 * - Autoboxing dan unboxing memungkinkan konversi otomatis
 *   antara primitive type dan wrapper class.
 *
 * - Setiap parameterized type merupakan tipe yang berbeda.
 *
 *      Gen<Integer> ≠ Gen<String>
 *
 * - Generic membantu memindahkan banyak kesalahan tipe
 *   dari runtime ke compile-time.
 *
 * - Tujuan utama generic adalah menjaga type safety
 *   sekaligus membuat kode lebih fleksibel dan reusable.
 */

/* ------------------------------------------------------------
 * Insight
 * ------------------------------------------------------------
 *
 * Aturan bahwa generic hanya menerima reference type
 * merupakan konsekuensi dari implementasi generic
 * melalui type erasure.
 *
 * Dengan mengombinasikan wrapper class, autoboxing,
 * dan compile-time type checking, Java mampu menyediakan
 * generic yang tetap kompatibel dengan JVM lama sekaligus
 * memberikan keamanan tipe yang jauh lebih baik dibandingkan
 * pendekatan berbasis Object.
 */

// CONTOH TANPA GENERICS
// class non generics secara fungsi sama seperti Gen
// tetapi tidak menggunakan generics
class NonGenerics {
    Object object; // object bertipe Object

    // konstruktor menerima object bertipe Object
    NonGenerics(Object object) {
        this.object = object;
    }

    // mengembalikan Object
    Object getObject() {
        return object;
    }

    // menampilkan tipe dari object
    void show() {
        System.out.println("Type of object is " + object.getClass().getName());
    }
}

public class GenericReferenceType {
    public static void main(String[] args) {

        NonGenerics ob;

        // MEMBAUT objek NonGenerics dan menyimpan Integer
        // autoboxing tetap terjadi
        ob = new NonGenerics(88);

        // MENAMPILKAN tipe data
        ob.show();

        // MENGAMBIL nilai harus casting
        int v = (Integer) ob.getObject();
        System.out.println("value " + v);

        System.out.println();

        // MEMBUAT object lain dan menyimpan string
        NonGenerics stringObjek = new NonGenerics("Non generics Test");

        // MENAMPILKAN tipe data
        stringObjek.show();

        // MENGAMBIL nilai harus casting
        String str = (String) stringObjek.getObject();
        System.out.println("value: " + str);

        // ini boleh secara syntaks, tapi salah secara konsep!
        ob = stringObjek;
        // ERROR saat runtime
        v = (Integer) ob.getObject();

        /**
         * BEDAH MASALAH (INI BAGIAN KRUSIAL)
         *
         * MASALAH 1: HARUS CASTING
         * int v = (Integer) iOb.getob();
         *
         * Kenapa?
         *
         * karena return = Object
         * Java gak tau isi aslinya
         *
         * MASALAH 2: RAWAN ERROR
         * Perhatikan ini:
         * iOb = strOb;
         *
         * Ini BOLEH di Java lama
         *
         * Tapi isinya:
         * strOb → String
         * iOb → dianggap Integer
         *
         * Lalu ini:
         * v = (Integer) iOb.getob();
         *
         * BOOM! ERROR RUNTIME
         *
         * Kenapa bisa kejadian?
         *
         * Karena:
         * Semua dianggap Object
         *
         * Java gak bisa ngecek:
         * isi sebenarnya apa
         *
         * GENERICS MENYELESAIKAN INI
         *
         * Kalau pakai generics:
         * Gen<Integer> iOb;
         * Gen<String> strOb;
         *
         * iOb = strOb; // ERROR SAAT COMPILE
         * Langsung ditolak
         *
         * Ini keunggulan utama
         *
         * Tanpa generics
         * Error muncul saat:
         * program jalan (bahaya)
         *
         * Dengan generics
         * Error muncul saat:
         * compile (AMAN)
         */
    }
}
