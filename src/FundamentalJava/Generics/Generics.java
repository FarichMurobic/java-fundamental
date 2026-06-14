package FundamentalJava.Generics;

/**
 * Apa itu Generics?
 * Generics = cara bikin kode yang fleksibel + aman untuk berbagai tipe data
 * Kenapa generics penting?
 *
 * Sebelum generics (Java lama):
 * Semua pakai Object
 * Harus casting manual
 * Rawan error
 *
 * Setlah generics:
 * Bisa tentuin tipe dari awal
 * Gak perlu casting
 * Aman (type-safe)
 *
 * ------------------------------------------------
 * 
 * MASALAH SEBELUM GENERICS (INI PENTING BANGET)
 * 
 * Dulu orang bikin class umum kayak gini:
 * 
 * class Box {
 *   Object data;
 * }
 *
 * Bisa simpan apa aja:
 * Integer 
 * String 
 * Double 
 *
 * Tapi masalahnya:
 * Integer x = (Integer) box.data; // HARUS casting
 *
 * Kalau salah cast → error runtime
 * Baru ketahuan pas program jalan (bahaya)
 *
 * ---------------------------------------------
 * 
 * SOLUSI: GENERICS
 * 
 * Dengan generics:
 *
 * class Box<T> {
 *   T data;
 * }
 *
 * T = tipe yang nanti ditentukan
 *
 * Sejak Java pertama rilis tahun 1995, banyak fitur baru ditambahkan. Salah satu yang paling berpengaruh adalah Generics.
 * Generics diperkenalkan di JDK 5, dan mengubah Java dalam dua hal:
 *
 * Nambah syntax baru
 * Mengubah banyak class & method di API Java
 * Sekarang, generics jadi bagian penting banget dalam Java. Wajib ngerti.
 *
 * ----------------------------------------------------------
 * 
 * Fungsi Generics
 * Dengan generics, kita bisa bikin:
 * class
 * interface
 * method
 *
 * yang bisa bekerja dengan berbagai tipe data, tapi tetap aman (type-safe).
 *
 * Contoh konsep
 * Misalnya:
 * Stack Integer
 * Stack String
 * Stack Object
 *
 * Cara kerjanya sama!
 *
 * Dengan generics:
 * Kita cukup bikin 1 algoritma
 * Bisa dipakai ke banyak tipe data tanpa nulis ulang
 *
 * Pengaruh besar generics
 *
 * Yang paling kena dampak:
 * Collections Framework
 *
 * Contoh:
 * List
 * Map
 * Set
 *
 * Dulu bisa simpan apa aja, tapi:
 * gak aman (bisa salah tipe)
 *
 * Sekarang:
 * aman (type-safe)
 *
 * ------------------------------------------
 * 
 * INTI GENERICS
 * Generics = Parameterized Type
 *
 * Artinya:
 * Tipe data dijadikan parameter
 *
 * Contoh:
 * class Gen<T>
 *
 * T = placeholder (pengganti tipe asli nanti)
 *
 * Sebelum Generics
 * Dulu pakai:
 * Object
 *
 * Masalahnya:
 * Harus casting manual
 * Bisa error runtime
 *
 * Setelah Generics
 * Gak perlu casting
 * Lebih aman
 * Lebih rapi
 *
 * --------------------------------------------------------------
 * 
 * KONSEP DALAM YANG WAJIB LU PAHAM
 * 1. Type Safety
 * Gen<Integer> iOb = new Gen<Double>(88.0); // ERROR
 *
 * Ini ditolak compile
 * Generics jaga supaya gak salah tipe
 *
 * 2. Autoboxing
 * new Gen<Integer>(88);
 *
 * 88 otomatis jadi Integer
 *
 * 3. No Casting
 * Dulu:
 * (Integer) obj
 *
 * Sekarang:
 * int v = iOb.getob();
 *
 * 4. Type Erasure (ini advance dikit)
 * Java sebenarnya:
 * hapus info generic saat compile
 *
 * Jadi:
 * cuma ada 1 class Gen
 * bukan banyak versi
 *
 * ---------------------------------------
 * 
 * ANALOGI BIAR MASUK
 * Bayangin Gen<T> itu kayak:
 * "Kotak fleksibel"
 *
 * Bisa isi Integer
 * Bisa isi String
 * Tapi sekali isi → harus konsisten
 *
 * ---------------------------------------------
 * 
 * KESIMPULAN
 * 
 * Generics = cara bikin kode fleksibel + aman
 *
 * Keuntungan:
 * Bisa dipakai banyak tipe data
 * Gak perlu casting
 * Lebih aman (type-safe)
 * Kode lebih rapi & reusable
 *
 * KESIMPULAN (SUPER JELAS)
 * Generics itu:
 * Cara bikin class fleksibel tapi tetap aman
 *
 * Hal penting:
 * T = placeholder
 * Tipe asli ditentukan saat object dibuat
 * Java pakai type erasure
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
