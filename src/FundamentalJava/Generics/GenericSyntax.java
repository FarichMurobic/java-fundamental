package FundamentalJava.Generics;

/* ============================================================
 *              DEKLARASI DAN PENGGUNAAN GENERIC CLASS
 * ============================================================
 *
 * Generic class dideklarasikan dengan menambahkan
 * satu atau lebih type parameter setelah nama class.
 *
 * Bentuk umum:
 *
 * class ClassName<TypeParameter> {
 *     ...
 * }
 *
 * Type parameter berfungsi sebagai placeholder yang akan
 * diganti dengan tipe data sebenarnya saat object dibuat.
 */


/* ------------------------------------------------------------
 * Deklarasi Generic Class
 * ------------------------------------------------------------
 *
 * Bentuk umum:
 *
 * class ClassName<T> {
 *     ...
 * }
 *
 * Keterangan:
 *
 * ClassName
 *     Nama class.
 *
 * T
 *     Type parameter yang mewakili tipe data dan akan
 *     ditentukan ketika object dibuat.
 *
 * Nama type parameter tidak harus menggunakan huruf T,
 * tetapi Java memiliki konvensi penamaan seperti:
 *
 * T  = Type
 * E  = Element
 * K  = Key
 * V  = Value
 * N  = Number
 */


/* ------------------------------------------------------------
 * Generic Class dengan Banyak Type Parameter
 * ------------------------------------------------------------
 *
 * Sebuah generic class dapat memiliki lebih dari satu
 * type parameter.
 *
 * Contoh:
 *
 * class ClassName<T, V> {
 *     ...
 * }
 *
 * Pada contoh tersebut:
 *
 * T dan V merupakan dua type parameter yang berbeda.
 *
 * Masing-masing akan diganti dengan tipe data yang sesuai
 * ketika object dibuat.
 */


/* ------------------------------------------------------------
 * Membuat Object dari Generic Class
 * ------------------------------------------------------------
 *
 * Bentuk umum:
 *
 * ClassName<TypeArgument> variable =
 *         new ClassName<TypeArgument>(constructorArgument);
 *
 * Keterangan:
 *
 * TypeArgument
 *     Tipe data sebenarnya, misalnya Integer atau String.
 *
 * constructorArgument
 *     Nilai yang diteruskan ke constructor.
 */


/* ------------------------------------------------------------
 * Contoh dengan Satu Type Parameter
 * ------------------------------------------------------------
 *
 * Gen<Integer> obj =
 *         new Gen<Integer>(10);
 *
 * Compiler mengganti:
 *
 * T → Integer
 *
 * sehingga seluruh member yang menggunakan T
 * akan bertipe Integer.
 */


/* ------------------------------------------------------------
 * Contoh dengan Dua Type Parameter
 * ------------------------------------------------------------
 *
 * TwoGen<Integer, String> obj =
 *         new TwoGen<Integer, String>(10, "Halo");
 *
 * Compiler mengganti:
 *
 * T → Integer
 * V → String
 *
 * Akibatnya:
 *
 * Semua penggunaan T menjadi Integer.
 * Semua penggunaan V menjadi String.
 */


/* ------------------------------------------------------------
 * Diamond Operator
 * ------------------------------------------------------------
 *
 * Sejak Java 7, type argument pada sisi kanan
 * dapat dihilangkan menggunakan diamond operator (<>).
 *
 * Contoh:
 *
 * Gen<Integer> obj = new Gen<>(10);
 *
 * Compiler akan melakukan type inference sehingga
 * hasilnya setara dengan:
 *
 * Gen<Integer> obj =
 *         new Gen<Integer>(10);
 *
 * Penulisan dengan diamond operator lebih ringkas
 * dan menjadi gaya penulisan yang umum digunakan
 * pada Java modern.
 */


/* ------------------------------------------------------------
 * Pola Dasar Generic Class
 * ------------------------------------------------------------
 *
 * Hampir seluruh generic class mengikuti pola berikut:
 *
 * 1. Deklarasi
 *
 *      class ClassName<T>
 *
 * 2. Membuat object
 *
 *      ClassName<TypeArgument> variable =
 *              new ClassName<>(...);
 *
 * Pola ini merupakan dasar penggunaan seluruh
 * generic class di Java.
 */


/* ------------------------------------------------------------
 * Hal Penting yang Perlu Diperhatikan
 * ------------------------------------------------------------
 *
 * Type argument pada deklarasi variabel dan object
 * harus konsisten.
 *
 * Contoh yang tidak valid:
 *
 * Gen<Integer> obj =
 *         new Gen<String>("Test");
 *
 * Compiler menghasilkan compile-time error karena:
 *
 * Integer ≠ String
 *
 * Contoh yang benar:
 *
 * Gen<Integer> obj =
 *         new Gen<Integer>(10);
 *
 * atau:
 *
 * Gen<Integer> obj =
 *         new Gen<>(10);
 */


/* ------------------------------------------------------------
 * Jumlah dan Urutan Type Argument
 * ------------------------------------------------------------
 *
 * Jika generic class memiliki beberapa type parameter,
 * maka jumlah dan urutannya harus sesuai.
 *
 * Contoh:
 *
 * class Pair<K, V>
 *
 * Maka object harus dibuat seperti:
 *
 * Pair<String, Integer>
 *
 * Bukan:
 *
 * Pair<String>
 *
 * ataupun:
 *
 * Pair<Integer, String>
 *
 * apabila urutan tipe yang diharapkan berbeda.
 */


/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * - Generic class dideklarasikan menggunakan
 *   satu atau lebih type parameter.
 *
 * - Type parameter merupakan placeholder
 *   yang diganti dengan tipe sebenarnya
 *   saat object dibuat.
 *
 * - Object dibuat menggunakan type argument
 *   yang sesuai dengan deklarasi generic class.
 *
 * - Type argument harus konsisten pada deklarasi
 *   variabel dan object.
 *
 * - Jika terdapat lebih dari satu type parameter,
 *   jumlah dan urutannya harus sesuai.
 *
 * - Diamond operator (<>) dapat digunakan untuk
 *   memanfaatkan type inference sehingga penulisan
 *   menjadi lebih ringkas.
 */


/* ------------------------------------------------------------
 * Insight
 * ------------------------------------------------------------
 *
 * Deklarasi generic class merupakan fondasi seluruh
 * mekanisme generics di Java.
 *
 * Konsep ini digunakan hampir di seluruh Java Standard Library,
 * seperti:
 *
 * List<E>
 * Set<E>
 * Queue<E>
 * Map<K, V>
 * Optional<T>
 *
 * Oleh karena itu, memahami pola deklarasi dan penggunaan
 * generic class merupakan langkah awal untuk menguasai
 * fitur generics secara menyeluruh.
 */

class Animal<F, U> {
    F inisial;
    U usia;

    Animal(F inisial, U usia) {
        this.inisial = inisial;
        this.usia = usia;
    }

    // SETTER
    public void setInisial() {
        System.out.println("Inisial " + inisial.getClass().getName()); 
        System.out.println("Usia " + usia.getClass().getName());
    }

    // GETTER
    public F getInisial() {
        return inisial;
    }

    // GETTER
    public U getUsia() {
        return usia;
    }
}

public class GenericSyntax {
    public static void main(String[] args) {
        
        Animal<String, Integer> name = new Animal<String, Integer>("Janera", 22);
        name.setInisial();

        String string = name.getInisial();
        System.out.println(string);

        int usia = name.getUsia();
        System.out.println(usia);
    }
}
