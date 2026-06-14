package FundamentalJava.Interface;

    /**
     * Interfaces
     *
     * Dengan menggunakan keyword interface, kamu bisa membuat abstraksi penuh dari sebuah class.
     *
     * Artinya:
     * Kamu bisa menentukan apa yang harus dilakukan class
     * Tapi tidak menentukan bagaimana cara melakukannya
     *
     * Interface mirip secara sintaks dengan class, tapi:
     * Tidak punya instance variable (variabel biasa)
     * Method biasanya tidak punya body (isi)
     *
     * Artinya:
     *
     * Interface tidak peduli implementasinya
     * Banyak class bisa mengimplementasikan satu interface
     * Satu class juga bisa mengimplementasikan banyak interface
     *
     * -----------------------------------------------------------------
     * 
     * Implementasi Interface
     * 
     * Kalau sebuah class mau pakai interface:
     * Dia WAJIB mengimplementasikan semua method
     *
     * Tapi:
     * Cara implementasinya bebas (tergantung class)
     * Ini mendukung konsep:
     * "one interface, multiple methods" (polymorphism)
     *
     * ----------------------------------------------------------
     * 
     * Kenapa Interface penting?
     * Biasanya:
     *
     * Method antar class harus dicek saat compile (ketergantungan tinggi)
     * Ini bikin sistem jadi kaku
     *
     * Interface menyelesaikan ini:
     *
     * Memisahkan definisi method dari implementasi
     * Class yang tidak berhubungan bisa punya "kemampuan" yang sama
     *
     * Ini kekuatan utama interface 
     *
     * Definisi Interface (bentuk umum)
     * access interface NamaInterface {
     *
     *     returnType method1(parameter);
     *     returnType method2(parameter);
     *
     *     type NAMA_CONSTANT = value;
     *
     * }
     *
     * Penjelasan:
     *
     * Method tidak punya body
     * Diakhiri ;
     * Semua method = abstract secara otomatis
     * Semua variable = public static final
     *
     * Akses Modifier
     * default → hanya dalam package
     * public → bisa dipakai di mana saja
     *
     * Variable dalam Interface
     * Otomatis:
     * public
     * static
     * final
     *
     * Artinya:
     * Nilainya tidak bisa diubah
     * Harus langsung diisi
     *
     * --------------------------------------
     * 
     * Inti Interface itu apa sih?
     * Interface = kontrak
     *
     * Analoginya:
     * Bayangin lu bikin aturan:
     *
     * "Semua kendaraan HARUS punya method jalan()"
     *
     * Tapi lu gak peduli:
     * Mobil jalan pakai mesin
     * Sepeda jalan pakai kaki
     *
     * Kenapa Interface itu powerful?
     * 1. Fleksibel
     *
     * Lu bisa ganti implementasi tanpa ubah sistem
     * 2. Polymorphism
     *
     * Contoh:
     * Callback obj;
     * obj = new Client();
     * obj = new AnotherClient();
     *
     * Satu tipe, banyak perilaku 
     *
     * Loose Coupling (penting di dunia kerja)
     * Class gak saling bergantung terlalu kuat
     *
     * Interface itu bukan sekadar fitur…
     * Tapi cara berpikir dalam desain sistem
     *
     * Lu mulai:
     *
     * Fokus ke "apa yang dilakukan"
     * Bukan "bagaimana caranya"
     *
     * Ini yang bikin code scalable & clean
     */

    

    /**
     * Implementing Interfaces
     *
     * Setelah sebuah interface didefinisikan, satu atau lebih class bisa mengimplementasikan interface tersebut.
     * Untuk melakukannya:
     * Tambahkan keyword implements di class
     * Lalu buat semua method yang diminta oleh interface
     *
     * Bentuk umum:
     * class NamaClass [extends SuperClass] [implements Interface1, Interface2, ...] {
     *     // isi class
     * }
     *
     * Penjelasan:
     * Bisa extends (inheritance)
     * Bisa implements banyak interface sekaligus
     * Interface dipisah dengan koma
     *
     * -------------------------------------------
     * 
     * Aturan penting:
     * Method dari interface HARUS dibuat
     * Method tersebut HARUS public
     * Signature method harus SAMA PERSIS
     * nama
     * parameter
     * return type
     * 
     * Kalau ada method sama di beberapa interface?
     * Cukup implementasikan sekali saja
     * Akan dipakai oleh semua interface
     * Class boleh punya method tambahan
     *
     * Class yang implement interface:
     * Boleh punya method lain di luar interface
     *
     * =================================================
     * 
     * Intinya apa?
     *
     * Kalau tadi:
     * Interface = kontrak
     * Sekarang:
     * Class yang implements = yang menandatangani dan menjalankan kontrak
     *
     * Kenapa harus public?
     * Karena di interface:
     * void callback(int param);
     *
     * Secara default itu:
     * public abstract void callback(int param);
     *
     * Jadi kalau lu tulis:
     * void callback(int p) // SALAH
     *
     * Error:
     * attempting to assign weaker access privileges
     *
     * Penjelasan
     * Interface cuma “maksa” method tertentu
     * Tapi class bebas punya:
     *
     * variable sendiri
     * method lain
     * logic tambahan
     *
     * --------------------------------
     * 
     * Bisa Multiple Interface
     * class A implements X, Y, Z {
     *
     * Ini gak bisa dilakukan dengan class (extends)
     * Java cuma boleh 1 parent class, tapi:
     *
     * bisa banyak interface
     *
     * ------------------------------------------------
     * 
     * Kesimpulan inti (WAJIB NANGKAP)
     * Interface dipakai sebagai tipe referensi
     * Object bisa berubah-ubah
     * Method yang jalan ditentukan saat runtime
     * Ini = polymorphism + fleksibilitas tinggi
     *
     * 1. Interface = harus diimplementasikan (100%)
     *
     * TAPI…
     *
     * 2. Boleh "ditunda" pakai abstract class
     *
     * Jadi:
     *
     * Interface → kontrak
     * Abstract class → “kerangka setengah jadi”
     *
     * Kesimpulan inti (WAJIB NANGKAP)
     * Kalau class tidak implement semua method interface → HARUS abstract
     * Abstract class bisa “nunda” implementasi
     * Class turunan harus menyelesaikan kontrak
     * Ini bikin desain jadi fleksibel dan modular
     */

public interface Callback {
    // METHOD di interface
    void callback(int param); // DEKLARASI method tanpa isi
    // METHOD TANPA isi → cuma aturan

}
