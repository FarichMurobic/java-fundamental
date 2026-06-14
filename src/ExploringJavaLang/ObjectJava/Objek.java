package ExploringJavaLang.ObjectJava;

/**
 * Object
 *
 * Seperti dijelaskan sebelumnya, class Object adalah superclass dari semua class di Java.
 *
 * Artinya:
 * semua class otomatis mewarisi Object
 *
 * Class Object mendefinisikan method-method (lihat tabel 17-14) yang tersedia untuk semua object.
 *
 * Tentang clone()
 * Method clone() digunakan untuk:
 * membuat duplikat object
 *
 * Tapi:
 * hanya class yang implement Cloneable yang bisa di-clone
 * kalau tidak → akan terjadi CloneNotSupportedException
 *
 * Cloneable Interface
 * tidak punya method (marker interface)
 * hanya sebagai tanda:
 * “class ini boleh di-clone”
 *
 * Penting
 * Saat clone dibuat:
 * constructor tidak dipanggil
 * object baru = copy dari object lama
 *
 * Bahaya Cloning
 * Kalau object punya reference:
 * Object obRef;
 *
 * maka:
 * clone dan original akan menunjuk ke object yang sama
 *
 * efek:
 * perubahan di clone → mempengaruhi original
 *
 * Contoh masalah
 * buka file stream
 * clone object
 * satu close stream
 * yang lain masih pakai → ERROR
 *
 * clone() itu protected
 *
 * artinya:
 * hanya bisa dipanggil dalam class itu sendiri
 * atau harus di-override jadi public
 *
 * Method	                    Description
 * Object clone()	            Membuat copy object
 * boolean equals(Object)	    Membandingkan object
 * void finalize()	            Dipanggil sebelum GC
 * Class<?> getClass()	        Mendapatkan info class
 * int hashCode()	            Hash code object
 * void notify()	            Bangunin thread
 * void notifyAll()	            Bangunin semua thread
 * String toString()	        Representasi string
 * void wait()	                Menunggu thread
 * void wait(long)	            Tunggu dengan waktu
 * void wait(long, int)	        Tunggu lebih detail
 *
 * Apa itu Object?
 * Semua di Java itu object (kecuali primitive)
 *
 * Contoh:
 * String s = "Hello";
 * String → turunan dari Object
 *
 * Konsep Cloning
 * clone = copy object
 *
 * api ada 2 jenis:
 * 1. Shallow Copy (default)
 * copy nilai
 * reference tetap sama
 * 
 * 2. Deep Copy
 * copy semua object di dalamnya
 *
 * clone() default = shallow copy
 *
 * Insight Penting (INI KRITIS)
 * clone() = shallow copy
 *
 * Kalau ada object di dalam:
 *
 * class A {
 *   B obj;
 * }
 *
 * clone A:
 * obj tetap sama reference 
 *
 * Problem nyata
 * shared data
 * memory bug
 * race condition
 *
 * Best Practice Modern
 *
 * jarang pakai clone()
 * lebih sering:
 *
 * constructor copy
 * builder pattern
 * serialization
 *
 * Relevansi Backend
 * Biasanya dipakai di:
 * DTO duplication
 * caching
 * snapshot object
 *
 * tapi modern Java:
 * jarang pakai clone()
 *
 * Kesimpulan Simpel
 *
 * Object = root semua class
 *
 * clone():
 * buat copy object
 * harus implement Cloneable
 * default = shallow copy
 *
 * hati-hati:
 * reference bisa shared
 * bisa bikin bug
 *
 * Warning dari Materi (PENTING BANGET)
 * Cloning itu berbahaya
 *
 * Kenapa?
 * efek samping susah kelihatan
 * reference bisa shared
 * bug bisa muncul diam-diam
 *
 * Kalimat penting dari buku:
 * Jangan implement Cloneable tanpa alasan kuat
 *
 * Analogi
 *
 * Bayangin:
 * clone() = copy rumah 
 * tapi listrik & air masih nyambung 
 *
 * jadi kalau satu rusak → dua-duanya kena 
 *
 * Best Practice Modern
 *
 * Daripada clone():
 *
 * lebih baik:
 * // copy constructor
 * public TestClone(TestClone other) {
 *   this.a = other.a;
 *   this.b = other.b;
 * }
 *
 * atau:
 * builder pattern
 * manual copy
 *
 * Kesimpulan Simpel
 * clone() di Object itu protected
 * supaya bisa dipakai luar → harus di-override jadi public
 *
 * tetap:
 * harus implement Cloneable
 * tetap shallow copy
 *
 * hati-hati:
 * bisa bikin bug
 * jarang dipakai di Java modern
 */

// Demonstrasi clone()
class TestClone implements Cloneable {
    int a;
    double b;

    // Method untuk cloning object
    TestClone cloneTest() {
        try {
            // Memanggil clone() dari Object
            return (TestClone) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("cloning tidak diizinkan!.");
            return this;
        }
    }
}

// Contoh berikut melakukan override method clone() supaya bisa dipanggil dari luar class.
// Override method clone()
class Testclone implements Cloneable {
    int a;
    double b;

    // clone() sekarang di-override dan dibuat public
    @Override
    public Object clone() {
        try {
            // Memanggil clone() dari class Object
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning tidak diizinkan!.");
            return this;
        }
    }
}

public class Objek {
    public static void main(String[] args) {

        // Membuat object pertama
        TestClone x1 = new TestClone();
        TestClone x2;

        // Set nilai
        x1.a = 10;
        x1.b = 20.98;

        // Clone object
        x2 = x1.cloneTest();

        // Tampilkan hasil
        System.out.println("x1: " + x1.a + " " + x1.b);
        System.out.println("x2: " + x2.a + " " + x2.b);

        /**
         * STEP 1 — Implement Cloneable
         * class TestClone implements Cloneable
         *
         * kalau gak ada ini → error
         *
         * STEP 2 — Panggil super.clone()
         * super.clone();
         *
         * ini clone asli dari Object
         *
         * STEP 3 — Casting
         * (TestClone)
         *
         * karena return type = Object
         *
         * STEP 4 — Hasil
         * x1: 10 20.98
         * x2: 10 20.98
         *
         * sama persis
         *
         */

        System.out.println();

        // Membuat object pertama
        Testclone a = new Testclone();
        Testclone b;

        // Set nilai
        a.a = 10;
        a.b = 20.98;

        // clone() dipanggil langsung dari luar class
        b = (Testclone) a.clone();

        System.out.println("a: " + a.a + " " + a.b);
        System.out.println("b: " + b.a + " " + b.b);

        /**
         * Apa bedanya sama sebelumnya?
         *
         * Sebelumnya:
         *
         * clone() dipanggil lewat method wrapper (cloneTest())
         *
         * Sekarang:
         * langsung panggil:
         * x1.clone();
         *
         * Kenapa harus override?
         * Karena di class Object:
         * protected Object clone()
         *
         * artinya:
         * tidak bisa dipanggil dari luar class
         *
         * Solusi
         * Override jadi:
         * public Object clone()
         *
         * sekarang bisa diakses dari mana saja
         *
         * Flow Program
         * STEP 1 — Object dibuat
         * TestClone x1 = new TestClone();
         *
         * STEP 2 — Set nilai
         * x1.a = 10;
         * x1.b = 20.98;
         *
         * STEP 3 — Clone langsung
         * x2 = (TestClone) x1.clone();
         *
         * STEP 4 — Output
         * x1: 10 20.98
         * x2: 10 20.98
         *
         * hasil sama persis
         *
         * Insight Penting (INI KRITIS)
         * 1. clone() tetap shallow copy
         *
         * Walaupun di-override:
         * masih shallow copy 
         *
         * 2. Tetap butuh Cloneable
         *
         * Kalau gak:
         * CloneNotSupportedException
         *
         * 3. Return type Object
         *
         * Makanya harus:
         * (TestClone)
         *
         * 4. Ini cara "resmi" Java lama
         *
         * Tapi sekarang:
         * jarang dipakai di production modern
         */

    }
}
