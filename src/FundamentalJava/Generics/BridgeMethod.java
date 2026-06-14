package FundamentalJava.Generics;

/**
 * Inti Masalahnya: Kenapa Perlu Bridge Method?
 *
 * Liat ini:
 * class Gen<T> {
 *   T getob() { return ob; }
 * }
 *
 * Kalau di-compile (karena type erasure), jadi:
 *
 * Object getob()
 *
 * Terus subclass:
 * class Gen2 extends Gen<String> {
 *   String getob() { return ob; }
 * }
 *
 * Sekilas keliatan override normal.
 *
 * TAPI MASALAHNYA:
 * Parent: Object getob()
 * Child: String getob()
 *
 * Secara Java biasa → ini bukan override, karena return type beda
 * Tapi Java generics mengizinkan ini (covariant return type)
 *
 * Solusi dari Compiler: Bridge Method
 *
 * Compiler diam-diam bikin method tambahan:
 * Object getob() {   // bridge method
 *   return getob();  // panggil versi String
 * }
 *
 * Jadi di bytecode, Gen2 punya:
 * String getob()        // versi asli lu
 * Object getob()        // bridge method (dibuat compiler)
 *
 * Kenapa Ini Penting?
 *
 * Supaya ini tetap jalan:
 * Gen ref = new Gen2("Hello");
 * Object obj = ref.getob(); // harus tetap valid!
 *
 * Kalau gak ada bridge method:
 * JVM bakal cari Object getob()
 * Tapi cuma ada String getob()
 * ERROR
 *
 * --------------------------------------------------------------
 * 
 * Analoginya (biar kebayang)
 *
 * Lu punya:
 * Parent ngomong: “gue balikin Object”
 * Child bilang: “gue balikin String”
 *
 * Compiler bikin penerjemah:
 * “Kalau ada yang minta Object → gue ambil dari String terus kasih”
 *
 * Hal Penting yang Sering Bikin Bingung
 * 1. Lu GAK AKAN LIAT bridge method di kode
 *
 * Karena dia cuma ada di:
 * bytecode (.class)
 * bukan di source code
 *
 * Bisa dicek pakai javap
 *
 * Kalau lu jalanin:
 * javap -c Gen2
 *
 * lu bakal lihat:
 * java.lang.String getob();
 * java.lang.Object getob(); // bridge method
 *
 * Ini efek dari ERASURE
 *
 * Ingat:
 * Generics di Java itu cuma "ilusi compile-time"
 *
 * Saat runtime:
 * semua <T> hilang
 * jadi Object
 *
 * Makanya perlu “jembatan” (bridge)
 *
 * Kesimpulan Gampangnya
 * Generics dihapus saat runtime (type erasure)
 * Override jadi “gak cocok” karena beda tipe return
 * Compiler bikin bridge method biar tetap nyambung
 * Ini semua terjadi otomatis
 *
 * Insight level pro (ini yang dipakai di dunia kerja)
 *
 * Bridge method sering muncul di:
 * framework (Spring, Hibernate)
 * override method generic
 * polymorphism + generics
 *
 * Lu gak nulis dia… tapi dia ngejaga sistem tetap konsisten
 *
 * FLOW ASLI DI JVM
 * Pas ini dipanggil:
 * ref.getob();
 *
 * Yang terjadi:
 * 1. JVM cari method → Object getob()
 * 2. nemu bridge method
 * 3. bridge method panggil → String getob()
 * 4. hasil dikembalikan sebagai Object
 */

class Utama<T> {
    T objek; // ini kalo erasure = Object objek;

    Utama(T objek) {
        this.objek = objek;
    }

    // METHOD ini bertipe Objek
    T getObjek() {
        System.out.println("Kelas utama getOb()");
        return objek;
    }
}

class Kedua extends Utama<String> {

    Kedua(String o) {
        super(o);
    }

    // Override versi string
    @Override
    String getObjek() {
        System.out.println("Kelas Kedua getOb()");
        return objek;
    }
}

public class BridgeMethod {
    public static void main(String[] args) {
        
        Kedua objek1 = new Kedua("Hello");

        // panggil langsung
        String s = objek1.getObjek();
        System.out.println("value s: " + s);

        System.out.println();

        // polymorphism (INI KUNCI NYA)
        Utama ref = objek1; // RAW TYPE SENGAJA
        Object o = ref.getObjek(); // ini penting
        System.out.println("value o: " + o);
    }
}
