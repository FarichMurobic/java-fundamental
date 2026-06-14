package FundamentalJava.Constructor;

/**
 * Invoking Overloaded Constructors with this()
 *
 * Kalau kita punya beberapa constructor (overloading),
 * kita bisa bikin satu constructor memanggil constructor lain.
 *
 * Caranya:
 * this(arg-list);
 *
 * Aturan penting:
 * this() HARUS jadi baris pertama di constructor
 *
 * ----------------------------
 * 
 * Konsep Inti
 *
 * Daripada:
 * ulang-ulang kode di banyak constructor
 *
 * kita bisa:
 * pusatkan logic di satu constructor utama
 *
 * Versi TANPA this()
 * 
 * class MyClass {
 *   int a;
 *   int b;
 *
 *   // isi manual
 *   MyClass(int i, int j) {
 *     a = i;
 *     b = j;
 *   }
 *
 *   // isi sama
 *   MyClass(int i) {
 *     a = i;
 *     b = i;
 *   }
 *
 *   // default
 *   MyClass() {
 *     a = 0;
 *     b = 0;
 *   }
 * }
 *
 * Masalah:
 * kode duplikat
 * susah maintain
 *
 * ------------------------------------
 * 
 * Analogi Biar Kebayang
 *
 * Bayangin:
 * Tanpa this()
 * lu isi form 3 kali dari awal
 *
 * Dengan this()
 * ada 1 form utama
 *
 * form lain tinggal:
 * “copy & kirim ke form utama”
 *
 * Kenapa this() Berguna?
 * 1. Hindari duplikasi kode
 * lebih rapi
 * lebih mudah maintenance
 * 2. Centralized logic
 * semua init ada di satu tempat
 *
 * ------------------------------------
 * 
 * Kekurangan
 * Ada sedikit overhead
 * karena ada pemanggilan constructor lain
 *
 * tapi:
 * biasanya gak terlalu berasa kecuali object banyak banget
 *
 * Rule Penting (WAJIB TAU)
 * 1. Harus di baris pertama
 * MyClass(int i) {
 *     this(i, i); // WAJIB di atas
 * }
 *
 * salah:
 * MyClass(int i) {
 *     a = 5;
 *     this(i, i); // ERROR
 * }
 *
 * 2. Tidak boleh pakai this variable dulu
 * salah:
 * MyClass(int i) {
 *     this(a, i); // ERROR
 * }
 *
 * 3. Tidak bisa bareng super()
 * salah:
 * MyClass() {
 *     super();
 *     this(0); // ERROR
 * }
 *
 * karena:
 * dua-duanya harus di baris pertama
 *
 * Insight Penting
 * this() = panggil constructor di class yang sama
 * super() = panggil constructor parent
 *
 * ----------------------------------------------
 * 
 * Kesimpulan Santai
 * 
 * this() dipakai buat:
 * panggil constructor lain dalam class yang sama
 *
 * Manfaat:
 * kode lebih rapi
 * gak duplikat
 * lebih maintainable
 *
 * Tapi:
 * ada sedikit overhead
 * harus dipakai dengan aturan ketat
 *
 * Insight Level Pro
 *
 * Gunakan this() kalau:
 * constructor banyak
 * ada logic yang sama
 *
 * Hindari kalau:
 * constructor sangat simpel
 */

class Myclass {

    int a;
    int b;

    // konstruktor utama
    Myclass(int i, int j) {
        a = i;
        b = j;
    }

    // panggil konstruktor lain
    Myclass(int i) {
        this(i, i);
    }

    // default
    Myclass() {
        this(0);
    }

    // methode untuk menampilkan nilai
    void show() {
        System.out.println("a = " + a + ", b = " + b);
    }
}

public class InvokingOverloadedConstructorWithThis {
    public static void main(String[] args) {

        Myclass myclass1 = new Myclass(8);

        /**
         * Case 1:
         * MyClass mc = new MyClass(8);
         *
         * Alurnya:
         * MyClass(8)
         * → this(8, 8)
         * → MyClass(8, 8)
         *
         * yang jalan beneran cuma:
         * MyClass(int i, int j)
         */

        Myclass myclass2 = new Myclass();

        /**
         * Case 2:
         * MyClass mc2 = new MyClass();
         *
         * Alurnya:
         * MyClass()
         * → this(0)
         * → MyClass(0)
         * → this(0,0)
         * → MyClass(0,0)
         *
         * berantai
         */
        
        // pakai konstruktor (int, int)
        Myclass obj1 = new Myclass(5, 10);
        obj1.show();

        // pakai konstruktor (int)
        Myclass obj2 = new Myclass(7);
        obj2.show();

        // pakai konstruktor default
        Myclass obj3 = new Myclass();
        obj3.show();

        /**
         * Penjelasan Output
         * 
         * obj1
         * MyClass obj1 = new MyClass(5, 10);
         *
         * langsung ke:
         * MyClass(int i, int j)
         *
         * Output:
         * a = 5, b = 10
         *
         * obj2
         * MyClass obj2 = new MyClass(7);
         *
         * Alur:
         * MyClass(7)
         * → this(7,7)
         * → MyClass(7,7)
         *
         * Output:
         * a = 7, b = 7
         *
         * obj3
         * MyClass obj3 = new MyClass();
         *
         * Alur:
         * MyClass()
         * → this(0)
         * → MyClass(0)
         * → this(0,0)
         * → MyClass(0,0)
         *
         * Output:
         * a = 0, b = 0
         *
         * Output Lengkap
         * a = 5, b = 10
         * a = 7, b = 7
         * a = 0, b = 0
         *
         * ----------------------------------------------
         * 
         * Insight Penting
         * Semua constructor akhirnya ngumpul ke satu constructor utama
         *
         * Ini bikin:
         * kode rapi
         * gak duplikat
         * gampang maintain
         */

    }
}
