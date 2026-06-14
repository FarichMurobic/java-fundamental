package FundamentalJava.Final;

     /**
     * Introducing final
     *
     * Sebuah field (variabel dalam class) bisa dideklarasikan sebagai final.
     * Jika dilakukan, maka nilainya tidak bisa diubah lagi, sehingga pada dasarnya menjadi konstanta (constant).
     * 
     * Artinya:
     * Kamu harus memberikan nilai pada final field saat deklarasi atau saat pembuatan object.
     * Ada dua cara untuk memberi nilai pada final field:
     * Memberi nilai langsung saat deklarasi
     * Memberi nilai di dalam constructor
     *
     * Cara pertama adalah yang paling umum digunakan.
     * Contoh
     * final int FILE_NEW = 1;
     * final int FILE_OPEN = 2;
     * final int FILE_SAVE = 3;
     * final int FILE_SAVEAS = 4;
     * final int FILE_QUIT = 5;
     *
     * Bagian lain dari program bisa menggunakan nilai seperti FILE_OPEN tanpa takut nilainya berubah.
     * Biasanya, penamaan variabel final menggunakan huruf besar semua (uppercase).
     *
     * Final pada Parameter dan Variabel Lokal
     * Selain field, keyword final juga bisa digunakan pada:
     * parameter method
     * variabel lokal
     *
     * Jika parameter dibuat final:
     * nilainya tidak bisa diubah di dalam method
     * Jika variabel lokal dibuat final:
     * nilainya hanya bisa diisi sekali
     *
     * Final pada Method
     * Keyword final juga bisa digunakan pada method.
     * Namun artinya berbeda dengan final pada variabel.
     *
     * ------------------------------------------------
     * 
     * Apa itu final?
     * final = nilai tidak bisa diubah setelah diisi
     * Analogi Sederhana
     * Bayangin:
     * Umur lahir = 2005
     * Itu tidak bisa diubah.
     * Nah itu seperti:
     * final int TAHUN_LAHIR = 2005;
     *
     * Kenapa final penting?
     * Tanpa final:
     * data bisa berubah sembarangan
     * bisa bikin bug susah dicari
     * 
     * Dengan final:
     * -data aman
     * -program lebih stabil
     * -jelas bahwa nilai itu konstan
     *
     * Constant (Konstanta)
     * Variabel yang nilainya tidak berubah
     *
     * Field
     * Variabel yang ada di dalam class
     *
     * Constructor
     * Method khusus untuk inisialisasi object
     *
     * --------------------------------------------
     * 
     * Cara Memberi Nilai ke final
     * Cara 1 (Paling umum)
     * final int A = 10;
     *
     * Cara 2 (Lewat Constructor)
     * class Test {
     *
     *     final int A;
     *
     *     Test() {
     *         A = 10;
     *     }
     *
     * }
     *
     * Final pada Parameter
     * void test(final int x) {
     *
     *     // x = 20; ERROR
     *
     * }
     * 
     * Artinya:
     * parameter x tidak boleh diubah di dalam method
     *
     * Final pada Variabel Lokal
     * void contoh() {
     *
     *     final int a = 10;
     *
     *     // a = 20; ERROR
     *
     * }
     *
     * Alur Kerja Final
     * Step:
     * final int a = 10;
     * Memory:
     * a -> 10 (LOCKED)
     *
     * Jika ada:
     * a = 20;
     * compiler langsung nolak
     *
     * -----------------------------------------
     * 
     * Salah paham final pada object
     * Ini penting banget 
     *
     * final Test t = new Test();
     *
     * Artinya:
     * object tidak bisa diganti
     * isi object masih bisa diubah
     *
     * Contoh:
     * class Test {
     *     int x;
     * }
     *
     * final Test t = new Test();
     * t.x = 10; // BOLEH
     * t = new Test(); // ERROR
     *
     * Perbandingan
     * Keyword	                        Fungsi
     * final variable	                nilai tidak bisa diubah
     * final parameter	                parameter tidak bisa diubah
     * final object	                    reference tidak bisa diganti
     * final method	                    tidak bisa di-override (nanti)
     */

    /**
     * Keyword final punya 3 fungsi:
     * 1, Jadi konstanta 
     * 2, Mencegah method dioverride
     * 3, Mencegah class diwariskan (inheritance)
     *
     * 1. final untuk Mencegah Override
     * Kalau method dikasih final:
     * Subclass TIDAK BOLEH override
     *
     * 2. final untuk Mencegah Inheritance
     * Kalau class dikasih final:
     * Tidak bisa diwariskan (extends)
     * 
     * -----------------------------------------------------------
     *
     * A. final pada METHOD
     * Intinya:
     * “Method ini udah final — gak boleh diubah lagi oleh turunan”
     * Kenapa perlu?
     * Biar logic tetap aman
     * Biar gak dirusak subclass
     *
     * Contoh
     *
     * class KelasA {
     *
     *     // Method final
     *     final void tampilkanPesan() {
     *         System.out.println("Ini method final");
     *     }
     * }
     *
     * class KelasB extends KelasA {
     *
     *     // ERROR: gak boleh override
     *     void tampilkanPesan() {
     *         System.out.println("Mencoba override");
     *     }
     * }
     *
     * Kenapa ERROR?
     * Karena:
     * final void tampilkanPesan()
     * Artinya:
     * “Method ini FIX — gak boleh diubah”
     */

    /**
     * B. final pada CLASS
     * Intinya:
     * “Class ini gak boleh punya anak”
     *
     * Contoh
     *
     * // Class final
     * final class Kendaraan {
     *     void jalan() {
     *         System.out.println("Kendaraan berjalan");
     *     }
     * }
     *
     * // ERROR: tidak bisa diwariskan
     * class Mobil extends Kendaraan {
     * }
     *
     * Kenapa ERROR?
     * Karena:
     * final class Kendaraan
     * Artinya:
     * “Stop di sini, gak boleh ada turunan”
     * 
     * ----------------------------------------------------
     *
     * Konsep Inti (WAJIB Nempel)
     * Ini ringkasan paling penting:
     * Penggunaan	        Efek
     * final variable	    tidak bisa diubah
     * final method	        tidak bisa dioverride
     * final class	        tidak bisa diwariskan
     */

    /**
     * Hal Penting 
     * 
     * 1. final vs abstract (INI SERING BANGET KELUAR)
     * 
     * abstract final class A {} // ERROR
     * Kenapa?
     * abstract → harus diwariskan
     * final → tidak boleh diwariskan
     * Konflik 
     *
     * 2. final method ≠ tidak bisa dipanggil
     * SALAH 
     * obj.methodFinal(); // boleh
     * Yang gak boleh:
     * override
     *
     * 3. final class masih bisa punya object
     * final class A {}
     * A obj = new A(); // BOLEH
     * 
     * ----------------------------------------
     *
     * Insight Penting (Level Naik)
     * A. final = Proteksi
     *
     * Dipakai kalau:
     * logic penting
     * gak boleh diubah (security / rule bisnis)
     */

    /**
     * Contoh Dunia Nyata
     * Misal di sistem kasir lu:
     *
     * class Pembayaran {
     *
     *     final void validasi() {
     *         System.out.println("Validasi pembayaran");
     *     }
     * }
     *
     * Semua turunan:
     * boleh tambah fitur
     * tapi tidak boleh ubah validasi
     *
     * Kenapa bisa lebih cepat?
     * Karena Java tahu:
     * method final tidak akan berubah
     *
     * Jadi bisa pakai:
     * early binding (compile-time)
     * bukan:
     * late binding (runtime)
     *
     * Lebih efisien 
     */

// class ini tidak bisa diwariskan (tidak bisa di-extends)
final class Mobil {

    String merk = "Toyota";

    public void jalan() {
        System.out.println("Mobil sedang berjalan...");
    }
}

// ERROR GAK BISA EXTENDS CLASS FINAL
// class MobilBalap extends Mobil {}

public class FinalFundamental {
    
    // Final variable instance
    final int MAX_SPEED = 200;
    // Bisa juga final tapi belum langsung di inisialisasi
    final String nama;

    // Constructor wajib mengisi final variabel kalo belum di inisialisasi
    FinalFundamental(String nama) {
        this.nama = nama;
    }

    // Final method
    final void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("Maxx speed: " + MAX_SPEED);
    }

    public static void main(String[] args) {
        
        // Final object reference
        FinalFundamental finalDemo = new FinalFundamental("Janera F.m.J");

        // Boleh dipakai
        finalDemo.tampilkanInfo();

        // Antara error atau tidak: tidak boleh ganti referensi object
        finalDemo = new FinalFundamental("BMW");

        // Boleh dipakai
        finalDemo.tampilkanInfo();

        // FINAL immutable Object
        final StringBuilder sb = new StringBuilder("Hello");

        // isi dalam object MASIH bisa berubah
        sb.append(" World");
        System.out.println(sb); // Output: Hello World

        // ERROR: tidak bisa assign ulang referensi
        // sb = new StringBuilder("Baru");
    }   
}
 