package FundamentalJava.Generics;

/* ============================================================
 *                GENERIC CLASS HIERARCHIES
 * ============================================================
 *
 * Generic class dapat berpartisipasi dalam mekanisme inheritance
 * (pewarisan) sebagaimana class biasa..
 *
 * Artinya, generic class dapat berperan sebagai:
 *
 * - Superclass (parent)
 * - Subclass (child)
 *
 * Seluruh aturan inheritance di Java tetap berlaku, dengan
 * tambahan aturan mengenai type parameter.
 */

/* ------------------------------------------------------------
 * Generic Sebagai Parent dan Child
 * ------------------------------------------------------------
 *
 * Misalnya terdapat class generic:
 *
 * class Gen<T> {
 *     ...
 * }
 *
 * Kemudian dibuat subclass:
 *
 * class Gen2<T> extends Gen<T> {
 *     ...
 * }
 *
 * Pada contoh tersebut, Gen2 juga memiliki type parameter T
 * dan meneruskannya ke superclass Gen.
 *
 * Dengan demikian, parent dan child menggunakan tipe data
 * yang sama untuk parameter T.
 */

/* ------------------------------------------------------------
 * Mengapa Type Parameter Harus Diteruskan?
 * ------------------------------------------------------------
 *
 * Superclass Gen<T> membutuhkan informasi mengenai tipe
 * yang akan digunakan sebagai T.
 *
 * Ketika subclass mewarisi Gen, informasi tersebut harus
 * diteruskan agar compiler mengetahui tipe yang digunakan.
 *
 * Contoh:
 *
 * class Gen2<T> extends Gen<T>
 *
 * Pada deklarasi di atas:
 *
 * - T milik Gen2 diteruskan ke Gen.
 * - Parent dan child berbagi type parameter yang sama.
 *
 * Jika type parameter tidak diteruskan (atau tidak ditentukan),
 * maka compiler tidak memiliki informasi yang cukup mengenai
 * tipe generic superclass.
 *
 * Catatan:
 * Subclass memang dapat menggunakan raw type (extends Gen),
 * tetapi praktik tersebut tidak direkomendasikan karena
 * menghilangkan type safety dan akan menghasilkan warning.
 */

/* ------------------------------------------------------------
 * Contoh Penggunaan
 * ------------------------------------------------------------
 *
 * Gen2<Integer> number = new Gen2<>(100);
 *
 * Saat object dibuat:
 *
 * T = Integer
 *
 * Karena Gen2 meneruskan T ke superclass:
 *
 * class Gen2<T> extends Gen<T>
 *
 * maka pada object tersebut:
 *
 * Parent (Gen) menggunakan Integer.
 * Child  (Gen2) juga menggunakan Integer.
 *
 * Seluruh object dalam hierarki inheritance tetap konsisten
 * menggunakan type argument yang sama.
 */

/* ------------------------------------------------------------
 * Subclass Dapat Menambahkan Type Parameter Baru
 * ------------------------------------------------------------
 *
 * Subclass tidak harus memiliki jumlah type parameter
 * yang sama dengan superclass.
 *
 * Contoh:
 *
 * class Gen<T> {
 *     ...
 * }
 *
 * class Gen2<T, V> extends Gen<T> {
 *     ...
 * }
 *
 * Pada contoh tersebut:
 *
 * T digunakan oleh parent dan child.
 * V hanya dimiliki oleh Gen2.
 *
 * Hal ini sangat umum dijumpai pada library Java maupun
 * framework modern.
 */

/* ------------------------------------------------------------
 * Contoh Instansiasi
 * ------------------------------------------------------------
 *
 * Gen2<String, Integer> obj =
 *         new Gen2<>("Value is:", 99);
 *
 * Maka compiler menetapkan:
 *
 * T = String
 * V = Integer
 *
 * Akibatnya:
 *
 * - Seluruh member bertipe T pada superclass Gen
 *   menggunakan String.
 *
 * - Seluruh member bertipe V pada Gen2
 *   menggunakan Integer.
 */

/* ------------------------------------------------------------
 * Hubungan Type Parameter dalam Inheritance
 * ------------------------------------------------------------
 *
 * Hierarki berikut:
 *
 * Gen<T>
 *    ↑
 * Gen2<T, V>
 *
 * dapat dibaca sebagai:
 *
 * - Gen memiliki satu type parameter (T).
 * - Gen2 memiliki dua type parameter (T dan V).
 * - T diteruskan ke superclass.
 * - V hanya digunakan oleh subclass.
 *
 * Dengan demikian, setiap object memiliki hubungan tipe
 * yang tetap konsisten di seluruh hierarki inheritance.
 */

/* ------------------------------------------------------------
 * Konsep-Konsep Penting
 * ------------------------------------------------------------
 *
 * 1. Generic mengikuti aturan inheritance Java.
 *
 *    Generic class dapat diwariskan sebagaimana class biasa.
 *
 *
 * 2. Type parameter dapat diteruskan ke superclass.
 *
 *    Contoh:
 *
 *    class Gen2<T> extends Gen<T>
 *
 *    Hal ini menjaga konsistensi tipe antara parent
 *    dan child.
 *
 *
 * 3. Subclass dapat menambahkan type parameter baru.
 *
 *    Contoh:
 *
 *    class Gen2<T, V>
 *
 *    Pendekatan ini sering digunakan untuk menyimpan
 *    lebih dari satu jenis data.
 *
 *
 * 4. Parent dan child tetap saling terhubung melalui
 *    type parameter yang sama.
 *
 *    Contoh:
 *
 *    Gen2<Integer, String>
 *
 *    berarti:
 *
 *    T = Integer  → digunakan oleh parent dan child.
 *    V = String   → hanya digunakan oleh child.
 */

/* ------------------------------------------------------------
 * Contoh di Dunia Nyata
 * ------------------------------------------------------------
 *
 * Pola seperti ini banyak digunakan pada class generic,
 * misalnya:
 *
 * Pair<K, V>
 * Map<K, V>
 * Response<T>
 * ApiResponse<T, E>
 *
 * Framework seperti Spring, Hibernate, Jakarta EE,
 * maupun Android SDK juga banyak memanfaatkan pola
 * inheritance pada generic class.
 */

/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * - Generic class dapat menjadi superclass maupun subclass.
 *
 * - Type parameter dapat diteruskan ke superclass agar
 *   parent dan child menggunakan tipe yang konsisten.
 *
 * - Subclass dapat menambahkan type parameter baru
 *   sesuai kebutuhannya.
 *
 * - Seluruh mekanisme tersebut tetap diperiksa oleh compiler,
 *   sehingga type safety tetap terjaga.
 *
 * - Inheritance dan generic merupakan kombinasi yang sangat
 *   umum digunakan dalam pengembangan aplikasi Java modern.
 */

// Class generics 
class Parent<T> {
    T objek;

    Parent(T o) {
        objek = o;
    }

    T getObjek() {
        return objek;
    }
}

// Subclass dari Parent yang generic
// Wajib nerusin (Child<T> extends Parent<T>)
class Child<T> extends Parent<T> {

    Child(T o) {
        super(o); // Kirim Parent
    }
}

// Subclass Parent dengan type tambahan V
class Child2<T, V> extends Parent<T> {
    V ob2;

    Child2(T a, V b) {
        super(a);
        ob2 = b;
    }

    V getOb2() {
        return ob2;
    }
}

public class GenericClassHierarchies {
    public static void main(String[] args) {

        Child<String> name = new Child("Farich Murobic");
        System.out.println(name.getObjek());

        Child2<String, Integer> biodata = new Child2("JaneRa F.M", 22);
        System.out.println(biodata.getObjek()); // Dari Parent
        System.out.println(biodata.getOb2()); // Dari Child2
    }

}
