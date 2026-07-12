package FundamentalJava.Generics;

/* ============================================================
 *                         GENERICS
 * ============================================================
 *
 * Generics adalah fitur Java yang memungkinkan class,
 * interface, dan method bekerja dengan berbagai tipe data
 * secara fleksibel tanpa mengorbankan type safety.
 *
 * Generics diperkenalkan pada JDK 5 dan menjadi salah satu
 * fitur terpenting dalam perkembangan Java modern.
 *
 * Konsep utama generics adalah:
 *
 * Parameterized Type
 *
 * yaitu menjadikan tipe data sebagai parameter sehingga
 * kode yang sama dapat digunakan untuk berbagai jenis data.
 */


/* ------------------------------------------------------------
 * Mengapa Generics Dibutuhkan?
 * ------------------------------------------------------------
 *
 * Sebelum generics diperkenalkan, banyak class umum dibuat
 * menggunakan Object sebagai tipe data.
 *
 * Contoh:
 *
 * class Box {
 *     Object data;
 * }
 *
 * Pendekatan ini memungkinkan object menyimpan berbagai
 * jenis data:
 *
 * Integer
 * String
 * Double
 * dan lain-lain
 *
 * Namun fleksibilitas tersebut memiliki kelemahan karena
 * compiler tidak dapat memverifikasi tipe data yang sebenarnya.
 */


/* ------------------------------------------------------------
 * Masalah Sebelum Generics
 * ------------------------------------------------------------
 *
 * Misalnya:
 *
 * Box box = new Box();
 *
 * Integer value = (Integer) box.data;
 *
 * Untuk mengambil data, programmer harus melakukan
 * casting secara manual.
 *
 * Jika casting dilakukan terhadap tipe yang salah:
 *
 * String text = (String) box.data;
 *
 * maka kesalahan baru akan diketahui saat program berjalan
 * (runtime) melalui ClassCastException.
 *
 * Pendekatan seperti ini berisiko karena bug tidak terdeteksi
 * sejak proses kompilasi.
 */


/* ------------------------------------------------------------
 * Solusi: Generics
 * ------------------------------------------------------------
 *
 * Dengan generics:
 *
 * class Box<T> {
 *     T data;
 * }
 *
 * T merupakan type parameter yang berfungsi sebagai
 * placeholder untuk tipe data sebenarnya.
 *
 * Ketika object dibuat:
 *
 * Box<Integer> box = new Box<>();
 *
 * maka compiler mengganti:
 *
 * T → Integer
 *
 * sehingga seluruh operasi menjadi lebih aman.
 */


/* ------------------------------------------------------------
 * Fungsi Generics
 * ------------------------------------------------------------
 *
 * Generics dapat digunakan pada:
 *
 * - Class
 * - Interface
 * - Method
 * - Constructor
 *
 * Tujuannya adalah membuat kode yang:
 *
 * - Fleksibel
 * - Reusable
 * - Type-safe
 *
 * tanpa perlu membuat implementasi terpisah untuk setiap tipe data.
 */


/* ------------------------------------------------------------
 * Satu Implementasi untuk Banyak Tipe
 * ------------------------------------------------------------
 *
 * Misalnya terdapat struktur data Stack.
 *
 * Tanpa generics mungkin diperlukan:
 *
 * StackInteger
 * StackString
 * StackDouble
 *
 * Dengan generics cukup dibuat:
 *
 * Stack<T>
 *
 * sehingga satu implementasi dapat digunakan untuk
 * berbagai tipe data.
 *
 * Pendekatan ini mengurangi duplikasi kode secara signifikan.
 */


/* ------------------------------------------------------------
 * Dampak Besar pada Collections Framework
 * ------------------------------------------------------------
 *
 * Salah satu bagian Java yang paling banyak memanfaatkan
 * generics adalah Collections Framework.
 *
 * Contohnya:
 *
 * List<E>
 * Set<E>
 * Queue<E>
 * Map<K, V>
 *
 * Dengan generics, collection dapat menentukan tipe data
 * yang boleh disimpan sejak awal.
 *
 * Contoh:
 *
 * List<String>
 *
 * berarti collection tersebut hanya menerima String.
 *
 * Compiler akan menolak penambahan tipe yang tidak sesuai.
 */


/* ------------------------------------------------------------
 * Generics = Parameterized Type
 * ------------------------------------------------------------
 *
 * Contoh:
 *
 * class Gen<T>
 *
 * T bukanlah tipe data sebenarnya.
 *
 * T hanya merupakan parameter tipe yang akan diganti
 * saat object dibuat.
 *
 * Misalnya:
 *
 * Gen<Integer>
 *
 * maka:
 *
 * T → Integer
 *
 * Atau:
 *
 * Gen<String>
 *
 * maka:
 *
 * T → String
 */


/* ------------------------------------------------------------
 * Type Safety
 * ------------------------------------------------------------
 *
 * Salah satu manfaat terbesar generics adalah type safety.
 *
 * Contoh:
 *
 * Gen<Integer> obj =
 *         new Gen<Integer>(88);
 *
 * Compiler menjamin bahwa object tersebut hanya bekerja
 * dengan Integer.
 *
 * Kesalahan seperti:
 *
 * Gen<Integer> obj =
 *         new Gen<Double>(88.0);
 *
 * akan ditolak saat compile-time.
 *
 * Dengan demikian banyak bug dapat dicegah sebelum
 * program dijalankan.
 */


/* ------------------------------------------------------------
 * Tidak Perlu Casting Manual
 * ------------------------------------------------------------
 *
 * Sebelum generics:
 *
 * Integer value = (Integer) obj;
 *
 * Setelah generics:
 *
 * Integer value = box.getData();
 *
 * Compiler sudah mengetahui tipe yang dikembalikan sehingga
 * casting manual tidak diperlukan.
 *
 * Kode menjadi lebih bersih dan lebih mudah dibaca.
 */


/* ------------------------------------------------------------
 * Autoboxing dan Generics
 * ------------------------------------------------------------
 *
 * Generic hanya menerima reference type.
 *
 * Oleh karena itu:
 *
 * Gen<int>
 *
 * tidak diperbolehkan.
 *
 * Sebagai gantinya digunakan:
 *
 * Gen<Integer>
 *
 * Ketika menulis:
 *
 * new Gen<Integer>(88)
 *
 * compiler secara otomatis melakukan autoboxing:
 *
 * int → Integer
 *
 * sehingga penggunaan generic menjadi lebih nyaman.
 */


/* ------------------------------------------------------------
 * Type Erasure
 * ------------------------------------------------------------
 *
 * Secara internal, Java mengimplementasikan generics melalui
 * mekanisme yang disebut type erasure.
 *
 * Setelah proses kompilasi:
 *
 * - Sebagian besar informasi generic dihapus.
 * - Type parameter diganti menjadi Object atau bound-nya.
 * - Compiler menambahkan cast yang diperlukan.
 *
 * Akibatnya, JVM tidak menyimpan sebagian besar informasi
 * generic saat runtime.
 *
 * Meskipun demikian, type safety tetap terjaga karena
 * seluruh pengecekan telah dilakukan pada compile-time.
 */


/* ------------------------------------------------------------
 * Analogi Sederhana
 * ------------------------------------------------------------
 *
 * Bayangkan:
 *
 * Gen<T>
 *
 * adalah sebuah kotak fleksibel.
 *
 * Kotak tersebut dapat digunakan untuk menyimpan:
 *
 * Integer
 * String
 * Double
 *
 * Namun setelah tipe ditentukan:
 *
 * Gen<Integer>
 *
 * maka kotak tersebut hanya boleh menyimpan Integer.
 *
 * Compiler akan menjaga konsistensi tipe tersebut
 * selama program dikompilasi.
 */


/* ------------------------------------------------------------
 * Keuntungan Generics
 * ------------------------------------------------------------
 *
 * - Dapat digunakan untuk berbagai tipe data.
 *
 * - Mengurangi duplikasi kode.
 *
 * - Tidak memerlukan casting manual.
 *
 * - Meningkatkan type safety.
 *
 * - Membuat API lebih fleksibel.
 *
 * - Membantu menemukan kesalahan sejak compile-time.
 *
 * - Sangat cocok untuk struktur data dan library umum.
 */


/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * - Generics adalah mekanisme parameterized type di Java.
 *
 * - Type parameter bertindak sebagai placeholder untuk tipe
 *   yang ditentukan kemudian.
 *
 * - Generics memungkinkan satu implementasi bekerja untuk
 *   banyak tipe data.
 *
 * - Compiler menggunakan generics untuk menjaga type safety.
 *
 * - Generics mengurangi kebutuhan casting manual.
 *
 * - Java mengimplementasikan generics menggunakan
 *   type erasure.
 *
 * - Generics merupakan fondasi penting bagi Collections
 *   Framework dan banyak library Java modern.
 */


/* ------------------------------------------------------------
 * Insight
 * ------------------------------------------------------------
 *
 * Hampir seluruh pengembangan Java modern memanfaatkan
 * generics, baik secara langsung maupun tidak langsung.
 *
 * Memahami generics dengan baik akan mempermudah dalam
 * mempelajari:
 *
 * - Collections Framework
 * - Stream API
 * - Functional Programming
 * - Spring Framework
 * - Hibernate
 * - Jakarta EE
 *
 * karena konsep generic menjadi fondasi bagi banyak API
 * dan framework yang digunakan dalam dunia kerja.
 */

// Class Generic
// T adalah parameter type yang akan diganti dengan type asli saat objek Gen dibuat!
class Gen<T> {
    T ob; // Mendeklarasikan objek dengan type T

    // Constructor menerima objek bertipe T
    Gen(T o) { 
        ob = o;
    }

    // Mengembalikan nilai ob
    T getOb() {
        return ob;
    }

    // Menampilkan nilai dari T
    void showType() {
        System.out.println("Type of T is: " + ob.getClass().getName());
    }
}

public class Generics {
    public static void main(String[] args) {
        
        // Membuat reference Gen untuk Integer
        Gen<Integer> iob;

        // Membuat objek Gen<Integer> dan assign ke iob
        iob = new Gen<Integer>(88);

        // Menampilkan data dalam iob
        iob.showType(); // Type of T is: java.lang.Integer

        // Mengambil nilai dario iob tanpa casting
        int v = iob.getOb();
        System.out.println("Value: " + v);

        System.out.println();

        // MEMBUAT OBJEK GEN<> UNTUK STRING
        Gen<String> strOb = new Gen<String>("Janera F.m.J");

        // Menampilkan data
        strOb.showType(); // Type of T is: java.lang.String

        // Ambil nilai dari objek Gen<String>
        String str = strOb.getOb();
        System.out.println("My Name's: " + str);

        /**
         * 1. class Gen<T>
         * class Gen<T>
         *
         * T itu:
         * bukan tipe asli
         * placeholder
         *
         * Contoh nanti:
         * Gen<Integer>
         * Gen<String>
         *
         * 2. Variabel
         * T ob;
         * Artinya:
         * ob bisa jadi apa aja tergantung T
         *
         * 3. Constructor
         * Gen(T o) {
         *   ob = o;
         * }
         *
         * Input dan isi harus tipe yang sama
         *
         * 4. Method getob
         * T getob() {
         *   return ob;
         * }
         *
         * Return sesuai tipe T
         *
         * 5. showType()
         * ob.getClass().getName()
         * Ambil nama tipe asli saat runtime
         *
         * -----------------------------------------
         * 
         * DI MAIN (INI BAGIAN PENTING)
         * Integer Version
         * Gen<Integer> iOb;
         * iOb = new Gen<Integer>(88);
         *
         * Artinya:
         * T diganti jadi Integer
         *
         * Ambil data
         * int v = iOb.getob();
         *
         * Gak perlu cast lagi
         * otomatis jadi int (auto-unboxing)
         *
         * String Version
         * Gen<String> strOb = new Gen<String>("Generics Test");
         *
         * Sekarang T = String
         *
         * OUTPUT
         * Type of T is java.lang.Integer
         * value: 88
         *
         * Type of T is java.lang.String
         * value: Generics Test
         */

    }
}
