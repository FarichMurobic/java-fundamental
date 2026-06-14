package FundamentalJava.Inheritance;

/**
     * Inheritance (pewarisan) adalah salah satu dasar utama dalam pemrograman berorientasi objek
     * karena memungkinkan kita membuat klasifikasi yang bertingkat (hierarki).
     * 
     * Dengan inheritance, kita bisa membuat sebuah class umum yang mendefinisikan sifat-sifat yang
     * dimiliki oleh beberapa objek yang mirip. Class ini kemudian bisa diwariskan ke class lain yang lebih spesifik,
     * di mana class turunan tersebut menambahkan hal-hal unik miliknya sendiri.
     * 
     * Dalam istilah Java:
     * Class yang diwariskan disebut superclass
     * Class yang mewarisi disebut subclass
     *
     * Jadi, subclass adalah versi yang lebih spesifik dari superclass.
     * Subclass mewarisi semua anggota (variabel & method) dari superclass dan bisa menambahkan fitur baru.
     *
     * -------------------------------------------------
     * 
     * Penjelasan
     * 
     * Bayangin gini bro:
     * Superclass = Induk
     * Subclass = Anak
     *
     * Contoh real:
     * Superclass: Kendaraan
     * Subclass: Motor, Mobil
     * Semua kendaraan punya:
     * roda
     * mesin
     *
     * Tapi:
     * Motor punya stang
     * Mobil punya pintu
     * Nah ini konsep inheritance.
     *
     * -------------------------------------------
     * 
     * Cara Pakai Inheritance
     * Untuk mewarisi class, kamu cukup memasukkan definisi class lain menggunakan keyword extends.
     * 
     * Penjelasan
     * Keyword penting:
     * extends
     * Artinya:
     * “Class ini mewarisi dari class lain”
     *
     * ------------------------------------------------
     * 
     * ISTILAH PENTING
     * Istilah	                Arti
     * superclass	            class induk
     * subclass	                class turunan
     * extends	                keyword untuk mewarisi
     * inheritance	            pewarisan
     * member	                variabel + method
     *
     * -------------------------------------
     * 
     * HAL PENTING YANG HARUS DIPAHAMI
     * 
     * 1. Subclass mewarisi semua
     * B punya:
     * - i
     * - j
     * - showij()
     * + k
     * + showk()
     * + sum()
     *
     * 2. Superclass tetap bisa berdiri sendiri
     * A superOb = new A();
     * Ini tetap valid walaupun A punya anak (B)
     *
     * 3. Java TIDAK support multiple inheritance
     * Tidak bisa:
     * class C extends A, B // SALAH
     * Hanya boleh:
     * class C extends A
     *
     * 4. Bisa bikin rantai inheritance
     * A → B → C
     *
     * -------------------------------------
     * 
     * INTINYA
     * 
     * Inheritance itu:
     * cara reuse kode
     * bikin hubungan antar class
     * bikin code lebih rapih & scalable
     *
     * Walaupun subclass mewarisi semua anggota (member) dari superclass, 
     * subclass tidak bisa mengakses member yang dideklarasikan sebagai private.
     * 
     * Penjelasan Sederhana
     * Inheritance ≠ bebas akses semua
     * Ada aturan:
     * private = cuma bisa dipakai di class itu sendiri
     *
     * ----------------------------------
     * 
     * KONSEP PENTING (WAJIB PAHAM)
     * 
     * 1. private = TERKUNCI
     * private = hanya class itu sendiri yang boleh akses
     * Bahkan:
     * Subclass (anak) TIDAK boleh akses
     *
     * 2. Inheritance TIDAK mengubah private
     * Walaupun diwariskan:
     * private tetap private
     *
     * 3. Cara mengakses private (SOLUSI)
     * Gunakan method (getter/setter)
     * Contoh dari kode tadi:
     * void setij(int x, int y) {
     *     i = x;
     *     j = y;
     * }
     * 
     * Ini cara “resmi” untuk akses j
     *
     * RINGKASAN SUPER PENTING
     * Aturan emas:
     * Modifier	        Bisa diakses subclass?
     * public	        ya
     * default	        ya (satu package)
     * protected	    ya
     * private	        TIDAK
     *
     * "Member yang dideklarasikan sebagai private akan tetap private dan tidak bisa diakses dari luar class, termasuk subclass."
     */

// CLASS INDUK (A)
// SUPERCLASS
class A {
    int i, j; // variabel milik class A
    private  int a;

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
