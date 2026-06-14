package FundamentalJava.Methods.MethodOverriding;

    /**
     * Method Overriding
     *
     * Dalam sebuah class hierarchy (pewarisan), kalau method di subclass punya:
     * -nama yang sama
     * -parameter (type signature) yang sama
     * 
     * dengan method di superclass,
     * maka method di subclass itu disebut override (menimpa) method di superclass.
     * 
     * Kalau method yang sudah di-override dipanggil dari objek subclass,
     * yang dipakai SELALU versi subclass, bukan superclass.
     * Versi superclass akan tersembunyi (hidden).
     *
     * Penjelasan 
     * 
     * 1. Class A
     * int i, j;
     *
     * punya 2 variabel
     * void show()
     * method untuk nampilin i dan j
     *
     * 2. Class B extends A
     * class B extends A
     *
     * B mewarisi semua dari A
     *
     * 3. Override Terjadi Di Sini
     * void show() {
     *     System.out.println("k: " + k);
     * }
     *
     * Ini NAMA SAMA + PARAMETER SAMA
     * Maka: OVERRIDE
     *
     * 4. Pemanggilan
     * subOb.show();
     * Walaupun A punya show(),
     * yang dipanggil = punya B
     * Output
     * k: 3
     *
     * Versi Dengan super (Ngambil Method Parent)
     * Kadang kita mau:
     * pakai method parent + tambahan dari child
     *
     * Kode
     * void show() {
     *     super.show(); // panggil method milik A
     *     System.out.println("k: " + k);
     * }
     * 
     * Penjelasan
     * 
     * super.show() = pakai method dari A
     * lalu B nambah output sendiri
     * Output
     * i and j: 1 2
     * k: 3
     *
     * Syarat Override (PENTING BANGET)
     * Override cuma terjadi kalau:
     * Nama method sama
     * Parameter sama
     * Kalau beda dikit aja → bukan override
     *
     * Perbandingan Override vs Overload
     * Fitur	        Override	        Overload
     * Nama method	    Sama	            Sama
     * Parameter	    Sama	            Berbeda
     * Lokasi	        Parent & Child	    Bisa di class sama
     * Tujuan	        Ganti behavior	    Variasi method
     *
     * Cara Cepat Ngebedain
     * Kalau lu lihat:
     * Signature sama persis → Override
     * Ada parameter beda → Overload
     *
     * Kesimpulan Inti
     * Override = menimpa method parent
     * Yang dipakai = versi subclass
     * Bisa akses parent pakai super
     * Kalau parameter beda = bukan override, tapi overload
     */

// class parent
class A {
    int i, j;

    // Konstruktor parent
    A(int i, int j) {
        this.i = i;
        this.j = j;
    }

    // Methode parent
    void show() {
        System.out.println("i and j: " + i + " " + j);
    }
}

// class turunan (child)
class B extends A {
    int k;

    // konstruktor class child
    B(int a, int b, int c) {
        super(a, b);
        this.k = c;
    }

    // methode class child
    // methode overriding, menimpa methode yang sama di kelas parent
    void show() {
        super.show(); // super untuk memanggil methode milik class parent A
        System.out.println("k: " + k);
    }
}

public class MethodOverriding {
    public static void main(String[] args) {

        // membuat objek class child
        B subOb = new B(1,2,3);
        subOb.show();
    }
}
