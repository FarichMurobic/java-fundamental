package FundamentalJava.Inheritance;

/* ============================================================
 *                     INHERITANCE (PEWARISAN)
 * ============================================================
 *
 * Inheritance merupakan salah satu konsep fundamental dalam
 * Object-Oriented Programming (OOP)..
 *
 * Konsep ini memungkinkan sebuah class mewarisi atribut
 * (field) dan perilaku (method) dari class lain sehingga
 * membentuk hubungan hierarkis antar class.
 *
 * Dengan inheritance, kode dapat digunakan kembali (code
 * reuse), lebih mudah dikembangkan, dan lebih terstruktur.
 */

/* ------------------------------------------------------------
 * Konsep Dasar
 * ------------------------------------------------------------
 *
 * Dalam inheritance terdapat dua istilah utama:
 *
 * Superclass
 * Merupakan class induk yang berisi karakteristik umum
 * yang dapat diwariskan.
 *
 * Subclass
 * Merupakan class turunan yang mewarisi anggota dari
 * superclass, kemudian dapat menambahkan atau
 * memodifikasi perilaku sesuai kebutuhannya.
 *
 * Dengan kata lain, subclass adalah bentuk yang lebih
 * spesifik dari superclass.
 */

/* ------------------------------------------------------------
 * Contoh Konsep
 * ------------------------------------------------------------
 *
 * Misalkan terdapat class:
 *
 * Kendaraan
 *
 * yang memiliki karakteristik umum:
 *
 * - roda
 * - mesin
 *
 * Class tersebut kemudian dapat diturunkan menjadi:
 *
 * Motor
 * Mobil
 *
 * Keduanya mewarisi karakteristik dasar dari Kendaraan,
 * tetapi masing-masing dapat memiliki karakteristik
 * tambahan.
 *
 * Contoh:
 *
 * Motor:
 * - stang
 *
 * Mobil:
 * - pintu
 *
 * Dengan demikian, fitur umum cukup ditulis satu kali
 * pada superclass, sedangkan fitur khusus ditambahkan
 * pada subclass.
 */

/* ------------------------------------------------------------
 * Mendeklarasikan Inheritance
 * ------------------------------------------------------------
 *
 * Di Java, inheritance menggunakan keyword:
 *
 * extends
 *
 * Bentuk umum:
 *
 * class Subclass extends Superclass {
 *     ...
 * }
 *
 * Keyword extends menyatakan bahwa subclass mewarisi
 * seluruh anggota yang dapat diwariskan dari superclass.
 */

/* ------------------------------------------------------------
 * Apa yang Diwarisi?
 * ------------------------------------------------------------
 *
 * Subclass mewarisi seluruh field dan method dari
 * superclass yang dapat diakses sesuai aturan
 * access modifier.
 *
 * Selain mewarisi anggota superclass,
 * subclass juga dapat:
 *
 * - Menambahkan field baru.
 * - Menambahkan method baru.
 * - Melakukan overriding terhadap method tertentu.
 *
 * Hal ini memungkinkan subclass memiliki perilaku
 * yang lebih spesifik dibandingkan superclass.
 */

/* ------------------------------------------------------------
 * Superclass Tetap Dapat Digunakan
 * ------------------------------------------------------------
 *
 * Keberadaan subclass tidak memengaruhi superclass.
 *
 * Superclass tetap dapat dibuat object secara langsung,
 * misalnya:
 *
 * A obj = new A();
 *
 * selama class tersebut memang dapat diinstansiasi.
 */

/* ------------------------------------------------------------
 * Single Inheritance
 * ------------------------------------------------------------
 *
 * Java hanya mendukung single inheritance untuk class.
 *
 * Artinya, satu subclass hanya dapat mewarisi
 * satu superclass secara langsung.
 *
 * Contoh yang valid:
 *
 * class B extends A
 *
 * Contoh yang tidak valid:
 *
 * class C extends A, B
 *
 * Multiple inheritance pada class tidak didukung
 * untuk menghindari ambiguitas, seperti Diamond Problem.
 *
 * Apabila membutuhkan pewarisan dari beberapa tipe,
 * Java menyediakan interface sebagai alternatif.
 */

/* ------------------------------------------------------------
 * Multilevel Inheritance
 * ------------------------------------------------------------
 *
 * Inheritance dapat membentuk hierarki yang lebih panjang.
 *
 * Contoh:
 *
 * A
 * ↑
 * B
 * ↑
 * C
 *
 * Pada hierarki tersebut:
 *
 * - B mewarisi A.
 * - C mewarisi B.
 *
 * Secara tidak langsung, C juga memperoleh anggota
 * yang diwariskan dari A.
 */

/* ============================================================
 * Access Modifier dan Inheritance
 * ============================================================
 *
 * Meskipun subclass mewarisi anggota superclass,
 * tidak semua anggota dapat diakses secara langsung.
 *
 * Hak akses tetap ditentukan oleh access modifier.
 */

/* ------------------------------------------------------------
 * Private Tidak Dapat Diakses
 * ------------------------------------------------------------
 *
 * Member yang dideklarasikan sebagai private
 * hanya dapat diakses dari dalam class tempat
 * member tersebut dideklarasikan.
 *
 * Subclass tetap mewarisi keberadaan member private,
 * tetapi tidak dapat mengaksesnya secara langsung.
 *
 * Oleh karena itu, inheritance tidak mengubah
 * aturan access modifier private.
 */

/* ------------------------------------------------------------
 * Cara Mengakses Data Private
 * ------------------------------------------------------------
 *
 * Praktik yang umum digunakan adalah menyediakan
 * method sebagai perantara, misalnya:
 *
 * - getter
 * - setter
 *
 * Dengan pendekatan ini, superclass tetap dapat
 * mengontrol bagaimana data private dibaca
 * maupun diubah.
 */

/* ------------------------------------------------------------
 * Hak Akses terhadap Member
 * ------------------------------------------------------------
 *
 * Access Modifier      Dapat Diakses oleh Subclass?
 * ------------------------------------------------------------
 * public              Ya
 * protected           Ya
 * default             Ya, jika berada dalam package yang sama
 * private             Tidak
 *
 * Access modifier tetap berlaku meskipun terjadi
 * hubungan inheritance.
 */

/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * - Inheritance memungkinkan subclass mewarisi
 *   field dan method dari superclass.
 *
 * - Hubungan inheritance dibentuk menggunakan
 *   keyword extends.
 *
 * - Subclass dapat menambahkan field maupun method
 *   baru, serta melakukan method overriding.
 *
 * - Java hanya mendukung single inheritance
 *   untuk class.
 *
 * - Inheritance dapat membentuk hierarki bertingkat
 *   (multilevel inheritance).
 *
 * - Member private tidak dapat diakses secara langsung
 *   oleh subclass.
 *
 * - Access modifier tetap menentukan hak akses
 *   terhadap setiap member.
 */

/* ------------------------------------------------------------
 * Insight
 * ------------------------------------------------------------
 *
 * Tujuan utama inheritance bukan hanya mengurangi
 * penulisan kode yang berulang (code reuse), tetapi juga
 * membangun hubungan "is-a" antar class.
 *
 * Contohnya:
 *
 * Motor is a Kendaraan.
 * Mobil is a Kendaraan.
 *
 * Hubungan inilah yang menjadi dasar berbagai konsep
 * penting dalam OOP, seperti polymorphism dan
 * dynamic method dispatch.
 */

// CLASS INDUK (A)
// SUPERCLASS
class A {
    int i, j; // variabel milik class A
    private int a;

    void showIJ() {
        System.out.println("i dan j: " + i + " " + j);
    }

    void setA(int a) {
        this.a = a;
    }

    int getA() {
        return a;
    }
}

// CLASS ANAK (B)
// SUBCLASS
class B extends A {
    int k; // variabel milik class B
    int total;

    void showK() {
        System.out.println("k: " + k);
    }

    void sum() {
        // bisa akses i dan j dari class A
        System.out.println("i + j + k: " + (i + j + k));
        // System.out.println(a); ini akan error karena a private
        // caranya lewat getter
        total = k + getA(); // total k dan a di class A
    }
}

public class Inheritance {
    public static void main(String[] args) {

        // MEMBUAT objek dari super class (A)
        A superOb = new A();

        // MEMBUAT objek dari sub class (B)
        B subOb = new B();

        // ISI nilai untuk superclass
        superOb.i = 10;
        superOb.j = 20;
        superOb.setA(50);

        System.out.println("Contents of superOb: ");
        superOb.showIJ();

        System.out.println();

        // SUBCLASS bisa akses i dan j dari superclass, kalo bukan private
        subOb.i = 7;
        subOb.j = 8;
        subOb.k = 9;

        System.out.println("Contents of subOb: ");
        subOb.showIJ(); // dari A
        subOb.showK(); // dari B

        System.out.println();

        System.out.println("Sum of i, j and k in subOb:");
        subOb.sum();
    }

}
