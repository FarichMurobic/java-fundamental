package FundamentalJava.Final;

/**
 * ------------------------------------------------------------
 * INTRODUCING final
 * ------------------------------------------------------------
 *
 * Keyword final digunakan untuk membatasi perubahan terhadap
 * variabel, parameter, method, maupun class.
 *
 * Arti keyword final bergantung pada tempat penggunaannya.
 *
 * Secara umum:
 *
 * "Setelah sesuatu dinyatakan final, hal tersebut tidak boleh
 * diubah sesuai dengan aturan yang berlaku."
 *
 * ------------------------------------------------------------
 * FINAL PADA FIELD (INSTANCE VARIABLE)
 * ------------------------------------------------------------
 *
 * Sebuah field dapat dideklarasikan sebagai final.
 *
 * Setelah field tersebut diberi nilai, nilainya tidak dapat
 * diubah lagi selama object masih hidup.
 *
 * Contoh:
 *
 * class FileAction {
 *
 *     final int FILE_NEW = 1;
 *     final int FILE_OPEN = 2;
 *     final int FILE_SAVE = 3;
 * }
 *
 * Nilai FILE_NEW, FILE_OPEN, dan FILE_SAVE sekarang menjadi
 * konstanta bagi setiap object dari class tersebut.
 *
 * ------------------------------------------------------------
 * CARA MEMBERI NILAI PADA FINAL FIELD
 * ------------------------------------------------------------
 *
 * Final field hanya boleh diinisialisasi SATU KALI.
 *
 * Ada dua cara:
 *
 * 1. Saat deklarasi
 *
 * final int MAX = 100;
 *
 * 2. Di dalam constructor
 *
 * class Test {
 *
 *     final int max;
 *
 *     Test() {
 *         max = 100;
 *     }
 * }
 *
 * Setelah nilai diberikan,
 * field tersebut tidak boleh diubah lagi.
 *
 * Jika final field tidak pernah diberi nilai,
 * program tidak akan berhasil dikompilasi.
 *
 * ------------------------------------------------------------
 * FINAL PADA PARAMETER METHOD
 * ------------------------------------------------------------
 *
 * Parameter method juga dapat diberi keyword final.
 *
 * Contoh:
 *
 * void print(final int x) {
 *
 *     // x = 20; // Compile Error
 *
 * }
 *
 * Artinya:
 *
 * parameter x tidak boleh diberikan nilai baru
 * di dalam method tersebut.
 *
 * Catatan:
 *
 * final hanya melindungi variabel parameter,
 * bukan object yang direferensikannya.
 *
 * ------------------------------------------------------------
 * FINAL PADA VARIABEL LOKAL
 * ------------------------------------------------------------
 *
 * Variabel lokal juga dapat dibuat final.
 *
 * Contoh:
 *
 * void example() {
 *
 *     final int a = 10;
 *
 *     // a = 20; // Compile Error
 *
 * }
 *
 * Variabel lokal final hanya dapat diinisialisasi sekali.
 *
 * ------------------------------------------------------------
 * EFFECTIVELY FINAL
 * ------------------------------------------------------------
 *
 * Sejak Java 8, terdapat konsep:
 *
 * Effectively Final
 *
 * Artinya:
 *
 * variabel tidak ditulis menggunakan keyword final,
 * tetapi nilainya tidak pernah berubah setelah diinisialisasi.
 *
 * Compiler akan memperlakukannya seperti final
 * pada beberapa kondisi, misalnya saat digunakan
 * di dalam lambda expression atau anonymous class.
 *
 * Contoh:
 *
 * int number = 10;
 *
 * Runnable r = () -> System.out.println(number);
 *
 * number dianggap effectively final karena
 * nilainya tidak pernah diubah.
 *
 * ------------------------------------------------------------
 * FINAL PADA OBJECT
 * ------------------------------------------------------------
 *
 * Bagian ini sering disalahpahami.
 *
 * Misalnya:
 *
 * final Test obj = new Test();
 *
 * Yang menjadi final adalah:
 *
 * reference obj
 *
 * BUKAN object yang ditunjuknya.
 *
 * Artinya:
 *
 * obj = new Test();   // Compile Error
 *
 * tetapi:
 *
 * obj.value = 100;    // Boleh
 *
 * selama field value memang tidak final.
 *
 * Contoh:
 *
 * class Test {
 *     int value;
 * }
 *
 * final Test obj = new Test();
 *
 * obj.value = 50;     // OK
 *
 * // obj = new Test(); // Compile Error
 *
 * Jadi:
 *
 * final object ≠ immutable object
 *
 * Yang tidak boleh berubah adalah referensinya,
 * bukan isi object.
 *
 * ------------------------------------------------------------
 * FINAL PADA METHOD
 * ------------------------------------------------------------
 *
 * Method juga dapat diberi keyword final.
 *
 * Contoh:
 *
 * class Animal {
 *
 *     final void eat() {
 *     }
 *
 * }
 *
 * Method final tidak dapat dioverride
 * oleh subclass.
 *
 * Hal ini biasanya digunakan untuk:
 *
 * - menjaga perilaku method tetap sama
 * - alasan keamanan
 * - menjaga konsistensi API
 *
 * ------------------------------------------------------------
 * FINAL PADA CLASS
 * ------------------------------------------------------------
 *
 * Selain variabel dan method,
 * class juga dapat dibuat final.
 *
 * Contoh:
 *
 * final class Utility {
 * }
 *
 * Class final tidak dapat diwariskan (extends).
 *
 * Contoh:
 *
 * class MyUtility extends Utility {
 * }
 *
 * Compile Error.
 *
 * Contoh class final pada Java:
 *
 * - String
 * - Math
 * - System (tidak bisa di-subclass)
 *
 * ------------------------------------------------------------
 * PENAMAAN KONSTANTA
 * ------------------------------------------------------------
 *
 * Secara konvensi Java,
 * konstanta ditulis menggunakan huruf kapital
 * dengan pemisah underscore (_).
 *
 * Contoh:
 *
 * static final int MAX_SIZE = 100;
 * static final double PI = 3.141592653589793;
 *
 * Ini adalah coding convention,
 * bukan aturan compiler.
 *
 * ------------------------------------------------------------
 * RINGKASAN
 * ------------------------------------------------------------
 *
 * final pada variable
 * -> nilainya hanya dapat diinisialisasi satu kali.
 *
 * final pada parameter
 * -> parameter tidak boleh diberi nilai baru.
 *
 * final pada local variable
 * -> hanya dapat diinisialisasi sekali.
 *
 * final pada object
 * -> referensinya tidak boleh berubah,
 *    tetapi isi object masih dapat berubah.
 *
 * final pada method
 * -> tidak dapat dioverride.
 *
 * final pada class
 * -> tidak dapat diwariskan.
 *
 * Effectively Final
 * -> variabel tidak ditulis final,
 *    tetapi nilainya tidak pernah berubah sehingga
 *    diperlakukan seperti final oleh compiler
 *    pada konteks tertentu.
 *
 * ------------------------------------------------------------
 * INTI YANG HARUS DIPAHAMI
 * ------------------------------------------------------------
 *
 * final bukan berarti object menjadi "tidak bisa diubah".
 *
 * Yang harus dilihat adalah:
 *
 * - final variable   → nilai variabel tidak berubah
 * - final reference  → referensi object tidak berubah
 * - final method     → method tidak bisa dioverride
 * - final class      → class tidak bisa diwariskan
 *
 * Dengan kata lain,
 * final digunakan untuk membatasi perubahan sehingga
 * kode menjadi lebih aman, lebih jelas, dan lebih mudah dipelihara.
 */

/**
 * ------------------------------------------------------------
 * FINAL PADA METHOD DAN CLASS
 * ------------------------------------------------------------
 *
 * Keyword final memiliki beberapa kegunaan penting dalam Java.
 *
 * Secara umum:
 *
 * 1. Membuat nilai tidak dapat diubah (constant variable)
 * 2. Mencegah method dioverride
 * 3. Mencegah class diwariskan (inheritance)
 *
 * Tujuan utama final adalah menjaga agar suatu bagian kode
 * tidak dapat dimodifikasi secara tidak sengaja oleh kode lain.
 *
 * ------------------------------------------------------------
 * FINAL PADA METHOD
 * ------------------------------------------------------------
 *
 * Jika sebuah method dideklarasikan sebagai final,
 * maka method tersebut tidak dapat dioverride oleh subclass.
 *
 * Sintaks:
 *
 * final returnType methodName(...) {
 *     ...
 * }
 *
 * Contoh:
 *
 * class KelasA {
 *
 *     final void tampilkanPesan() {
 *         System.out.println("Ini method final");
 *     }
 * }
 *
 * class KelasB extends KelasA {
 *
 *     // Compile Error
 *     void tampilkanPesan() {
 *         System.out.println("Override");
 *     }
 * }
 *
 * Kenapa terjadi error?
 *
 * Karena method tampilkanPesan() sudah dideklarasikan final,
 * sehingga implementasinya dianggap tetap dan tidak boleh
 * diganti oleh subclass.
 *
 * ------------------------------------------------------------
 * KENAPA METHOD FINAL DIGUNAKAN?
 * ------------------------------------------------------------
 *
 * Biasanya digunakan ketika:
 *
 * - Logika method tidak boleh diubah.
 * - Ingin menjaga konsistensi perilaku class.
 * - Mencegah subclass merusak aturan bisnis.
 * - Alasan keamanan dan stabilitas API.
 *
 * Contoh nyata:
 *
 * class BankAccount {
 *
 *     final void validasiTransaksi() {
 *         // aturan validasi penting
 *     }
 * }
 *
 * Developer lain tidak dapat mengubah proses validasi
 * melalui overriding.
 *
 * ------------------------------------------------------------
 * FINAL PADA CLASS
 * ------------------------------------------------------------
 *
 * Jika sebuah class dideklarasikan sebagai final,
 * maka class tersebut tidak dapat diwariskan.
 *
 * Sintaks:
 *
 * final class NamaClass {
 * }
 *
 * Contoh:
 *
 * final class Kendaraan {
 *
 *     void jalan() {
 *         System.out.println("Kendaraan berjalan");
 *     }
 * }
 *
 * class Mobil extends Kendaraan {
 * }
 *
 * Compile Error.
 *
 * Kenapa?
 *
 * Karena class Kendaraan sudah final,
 * sehingga tidak boleh memiliki subclass.
 *
 * ------------------------------------------------------------
 * KENAPA CLASS FINAL DIGUNAKAN?
 * ------------------------------------------------------------
 *
 * Biasanya digunakan ketika:
 *
 * - Desain class sudah dianggap lengkap.
 * - Perilaku class tidak boleh diubah melalui inheritance.
 * - Menjaga keamanan dan konsistensi implementasi.
 * - Membuat object immutable.
 *
 * Contoh class final pada Java:
 *
 * - String
 * - Math
 * - Integer
 * - Long
 * - Double
 *
 * Class-class tersebut sengaja dibuat final agar
 * perilakunya tidak dapat diubah oleh subclass.
 *
 * ------------------------------------------------------------
 * HUBUNGAN DENGAN INHERITANCE
 * ------------------------------------------------------------
 *
 * Normal:
 *
 * Parent
 *    ↓
 * Child
 *
 * Dengan final class:
 *
 * Parent (final)
 *
 * Tidak boleh ada Child.
 *
 * Dengan final method:
 *
 * Parent.method()
 *      ↓
 * Child.method()
 *
 * Tidak boleh dioverride.
 *
 * ------------------------------------------------------------
 * RINGKASAN
 * ------------------------------------------------------------
 *
 * final variable
 * -> nilai hanya dapat diinisialisasi satu kali.
 *
 * final reference
 * -> referensi object tidak dapat diganti.
 *
 * final method
 * -> tidak dapat dioverride oleh subclass.
 *
 * final class
 * -> tidak dapat diwariskan menggunakan extends.
 *
 * ------------------------------------------------------------
 * INTI YANG HARUS DIINGAT
 * ------------------------------------------------------------
 *
 * final digunakan untuk membatasi perubahan.
 *
 * final variable
 * -> mencegah perubahan nilai.
 *
 * final method
 * -> mencegah perubahan perilaku melalui overriding.
 *
 * final class
 * -> mencegah perluasan class melalui inheritance.
 *
 * Semakin banyak penggunaan final yang tepat,
 * semakin jelas kontrak dan perilaku kode yang dibuat.
 */

/**
 * ------------------------------------------------------------
 * HAL-HAL PENTING TENTANG final
 * ------------------------------------------------------------
 *
 * 1. final TIDAK BISA DIGABUNG DENGAN abstract
 *
 * Contoh:
 *
 * abstract final class A {
 * }
 *
 * Compile Error.
 *
 * Kenapa?
 *
 * abstract berarti:
 * "Class ini BELUM lengkap dan harus diwariskan
 * agar dapat diimplementasikan."
 *
 * Sedangkan final berarti:
 * "Class ini TIDAK BOLEH diwariskan."
 *
 * Kedua keyword tersebut memiliki tujuan yang saling bertentangan,
 * sehingga tidak boleh digunakan bersamaan pada sebuah class.
 *
 * ------------------------------------------------------------
 * 2. final METHOD MASIH BISA DIPANGGIL
 * ------------------------------------------------------------
 *
 * Kesalahan yang sering terjadi:
 *
 * "Method final tidak bisa dipanggil."
 *
 * Itu SALAH.
 *
 * Method final tetap dapat dipanggil seperti method biasa.
 *
 * Contoh:
 *
 * class A {
 *
 *     final void hello() {
 *         System.out.println("Hello");
 *     }
 * }
 *
 * A obj = new A();
 * obj.hello();      // BOLEH
 *
 * Yang tidak diperbolehkan adalah:
 *
 * class B extends A {
 *
 *     // Compile Error
 *     void hello() {
 *     }
 * }
 *
 * Jadi:
 *
 * final method
 * ≠
 * method yang tidak bisa dipanggil
 *
 * final method
 * =
 * method yang tidak dapat dioverride.
 *
 * ------------------------------------------------------------
 * 3. final CLASS MASIH BISA DIBUAT OBJECT
 * ------------------------------------------------------------
 *
 * Kesalahan lain yang sering muncul:
 *
 * "Class final tidak bisa dibuat object."
 *
 * Itu juga SALAH.
 *
 * Contoh:
 *
 * final class A {
 * }
 *
 * A obj = new A();      // BOLEH
 *
 * Yang tidak diperbolehkan adalah:
 *
 * class B extends A {
 * }
 *
 * Compile Error.
 *
 * Jadi:
 *
 * final class
 * ≠
 * class yang tidak bisa diinstansiasi
 *
 * final class
 * =
 * class yang tidak bisa diwariskan.
 *
 * ------------------------------------------------------------
 * KAPAN final DIGUNAKAN?
 * ------------------------------------------------------------
 *
 * Gunakan final ketika suatu perilaku atau aturan
 * memang tidak boleh diubah oleh subclass.
 *
 * Contohnya:
 *
 * - Algoritma keamanan
 * - Validasi data
 * - Aturan bisnis (business rules)
 * - Utility class
 * - Class immutable
 *
 * Dengan begitu, programmer lain tidak dapat
 * mengubah perilaku penting melalui inheritance
 * atau overriding.
 *
 * ------------------------------------------------------------
 * CONTOH DUNIA NYATA
 * ------------------------------------------------------------
 *
 * class Pembayaran {
 *
 *     final void validasi() {
 *         System.out.println("Validasi pembayaran");
 *     }
 * }
 *
 * class PembayaranQR extends Pembayaran {
 *
 *     // Compile Error
 *     void validasi() {
 *     }
 * }
 *
 * Class turunan masih dapat menambahkan method baru,
 * tetapi tidak boleh mengubah proses validasi yang
 * sudah ditetapkan.
 *
 * Hal ini membantu menjaga konsistensi aturan bisnis.
 *
 * ------------------------------------------------------------
 * OPTIMISASI JVM
 * ------------------------------------------------------------
 *
 * Method final memiliki implementasi yang pasti,
 * sehingga JVM dapat melakukan optimisasi pada
 * kondisi tertentu.
 *
 * Contohnya:
 *
 * - Method Inlining
 * - Devirtualization
 *
 * Namun perlu dipahami bahwa:
 *
 * final TIDAK menjamin program akan lebih cepat.
 *
 * JVM modern (HotSpot JVM) mampu melakukan optimisasi
 * yang sama pada banyak method non-final jika compiler
 * dapat membuktikan bahwa method tersebut aman
 * untuk dioptimalkan.
 *
 * Jadi alasan utama menggunakan final adalah:
 *
 * - Kejelasan desain
 * - Keamanan
 * - Konsistensi perilaku
 *
 * Bukan semata-mata untuk meningkatkan performa.
 *
 * ------------------------------------------------------------
 * RINGKASAN
 * ------------------------------------------------------------
 *
 * ✓ final dan abstract tidak bisa digunakan
 *   bersamaan pada class.
 *
 * ✓ final method tetap bisa dipanggil,
 *   tetapi tidak dapat dioverride.
 *
 * ✓ final class tetap bisa dibuat object,
 *   tetapi tidak dapat diwariskan.
 *
 * ✓ final digunakan untuk menjaga agar
 *   perilaku penting tetap konsisten.
 *
 * ✓ JVM dapat melakukan optimisasi terhadap
 *   method final, tetapi peningkatan performa
 *   bukan alasan utama penggunaan final.
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
 