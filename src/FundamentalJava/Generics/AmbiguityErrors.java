package FundamentalJava.Generics;

    /**
     * KODE MASALAHNYA
     *
     * class MyGenClass<T, V> {
     *   T ob1;
     *   V ob2;
     *
     *   void set(T o) {
     *     ob1 = o;
     *   }
     *
     *   void set(V o) {
     *     ob2 = o;
     *   }
     * }
     *
     * Kelihatannya:
     * set(T) dan set(V) beda kan?
     * Harusnya bisa overload?
     *
     * SALAH BESAR (di Java generics)
     *
     * MASALAH UTAMA: ERASURE
     *
     * Ingat ini (WAJIB NANCEP):
     * Generics di Java cuma ada saat compile
     * di runtime → hilang (erasure)
     *
     * Setelah di-compile:
     * class MyGenClass {
     *   Object ob1;
     *   Object ob2;
     *
     *   void set(Object o) {
     *     ob1 = o;
     *   }
     *
     *   void set(Object o) {
     *     ob2 = o;
     *   }
     * }
     *
     * BOOM!
     *
     * Sekarang ada:
     * void set(Object o)
     * void set(Object o)
     *
     * duplicate method → ambiguity error
     *
     * ---------------------------------------------------
     * 
     * MASALAH KEDUA (yang lebih halus)
     *
     * Misalnya ini:
     * MyGenClass<String, String> obj = new MyGenClass<>();
     *
     * Berarti:
     * T = String
     * V = String
     *
     * Jadi:
     * void set(String o)
     * void set(String o)
     *
     * MASIH TABRAKAN
     * 
     * ------------------------------------------------------------
     *
     * INTINYA
     *
     * Overloading di Java ditentukan oleh signature setelah erasure
     *
     * Bukan:
     * bukan dari <T>
     * bukan dari <V>
     *
     * Tapi dari:
     * tipe nyata setelah compile
     *
     * KENAPA INI BAHAYA?
     *
     * Karena keliatan valid:
     * set(T)
     * set(V)
     *
     * Tapi sebenarnya:
     * compiler lihat → sama aja
     */

    /**
     * "SOLUSI" YANG KELIHATAN BENER (TAPI MASIH NGACO)
     *
     * coba:
     * class MyGenClass<T, V extends Number> {
     *
     * Sekarang erasure jadi:
     * void set(Object o)
     * void set(Number o)
     *
     * beda → OK (sementara)
     *
     * Tapi…
     * MyGenClass<Number, Number> x = new MyGenClass<>();
     *
     * Sekarang:
     * T = Number
     * V = Number
     *
     * Jadi:
     * set(Number)
     * set(Number)
     *
     * BALIK ERROR LAGI
     * 
     * KESIMPULAN
     * 
     * Ambiguity terjadi karena:
     * 1. Erasure bikin tipe jadi sama
     * 2. Overloading jadi bentrok
     * 3. Generics gak menjamin tipe beda
     */

    /**
     * CARA BENER (BEST PRACTICE)
     * 
     * Pakai nama method beda
     * void setT(T o) {
     *   ob1 = o;
     * }
     *
     * void setV(V o) {
     *   ob2 = o;
     * }
     *
     * ini yang paling aman
     *
     * Atau satu method saja
     * void set(T o1, V o2) {
     *   ob1 = o1;
     *   ob2 = o2;
     * }
     *
     * JANGAN maksa overload generics kayak gini
     * void set(T o)
     * void set(V o)
     *
     * ini desain jelek di Java
     *
     * -----------------------------------------
     * 
     * CARA MIKIR BIAR GAK KEJEBAK
     * Setiap lu nulis generics:
     * Tanya ke diri sendiri:
     * “Kalau <T> dihapus… jadi apa?”
     *
     * Kalau jawabannya:
     * jadi sama → berarti bakal error
     *
     * ANALOGI SIMPLE
     *
     * Lu kira punya 2 orang:
     * T = Andi
     * V = Budi
     *
     * Tapi di runtime:
     * semuanya jadi “Orang”
     *
     * Jadi:
     * set(Orang)
     * set(Orang)
     *
     * ya jelas tabrakan 
     *
     * --------------------------------------------------
     * 
     * HUBUNGAN SAMA YANG LU PELAJARI SEBELUMNYA
     *
     * Ini nyambung ke:
     * erasure → penyebab utama
     * bridge method → solusi untuk override
     * instanceof → gak bisa cek tipe generic
     * raw type → balik ke Object
     *
     * Semua satu ekosistem
     */


public class AmbiguityErrors {
    public static void main(String[] args) {
        
    }
}
