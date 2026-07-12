package FundamentalJava.Interface;

/* ==========================================================
 *                         INTERFACES
 * ==========================================================
 *
 * Interface adalah mekanisme di Java yang digunakan untuk
 * mendefinisikan kontrak (contract) yang harus dipenuhi oleh
 * class yang mengimplementasikannya.
 *
 * Dengan menggunakan keyword interface, kita dapat membuat
 * abstraksi penuh terhadap perilaku (behavior) tanpa menentukan
 * bagaimana perilaku tersebut diimplementasikan.
 *
 * Artinya:
 * - Interface menentukan "apa yang harus dilakukan".
 * - Class menentukan "bagaimana cara melakukannya".
 *
 * ==========================================================
 *                   KARAKTERISTIK INTERFACE
 * ==========================================================
 *
 * Interface memiliki sintaks yang mirip dengan class, tetapi
 * memiliki karakteristik yang berbeda.
 *
 * Secara umum:
 *
 * - Tidak memiliki constructor.
 * - Tidak dapat diinstansiasi menggunakan keyword new.
 * - Tidak memiliki instance variable (field non-static).
 * - Method secara default bersifat abstract (kecuali method
 *   default, static, dan private yang diperkenalkan pada
 *   Java versi modern).
 *
 * Karena hanya mendefinisikan kontrak, interface tidak
 * berfokus pada implementasi, melainkan pada perilaku yang
 * harus dimiliki oleh sebuah class.
 *
 * ==========================================================
 *                  IMPLEMENTASI INTERFACE
 * ==========================================================
 *
 * Sebuah class menggunakan keyword implements untuk
 * mengimplementasikan sebuah interface.
 *
 * Contoh:
 *
 *     class Car implements Vehicle {
 *         ...
 *     }
 *
 * Class yang mengimplementasikan interface wajib menyediakan
 * implementasi untuk seluruh abstract method yang terdapat
 * pada interface tersebut.
 *
 * Jika tidak, class tersebut harus dideklarasikan sebagai
 * abstract.
 *
 * ==========================================================
 *                  SATU INTERFACE, BANYAK IMPLEMENTASI
 * ==========================================================
 *
 * Salah satu kekuatan utama interface adalah mendukung
 * polymorphism.
 *
 * Satu interface dapat diimplementasikan oleh banyak class
 * dengan cara yang berbeda.
 *
 * Sebaliknya, satu class juga dapat mengimplementasikan lebih
 * dari satu interface.
 *
 * Contoh:
 *
 *     class SmartPhone
 *             implements Camera, MusicPlayer, GPS { ... }
 *
 * Hal ini memungkinkan sebuah object memiliki berbagai
 * kemampuan (behavior) tanpa dibatasi oleh inheritance class.
 *
 * ==========================================================
 *                  MENGAPA INTERFACE PENTING?
 * ==========================================================
 *
 * Tanpa interface, class sering kali memiliki ketergantungan
 * (coupling) yang tinggi terhadap implementasi tertentu.
 *
 * Akibatnya:
 *
 * - Sulit mengganti implementasi.
 * - Sulit melakukan pengembangan.
 * - Sulit melakukan pengujian (testing).
 *
 * Interface mengatasi masalah tersebut dengan memisahkan
 * definisi perilaku dari implementasinya.
 *
 * Class yang tidak memiliki hubungan inheritance sekalipun
 * dapat memiliki kemampuan yang sama melalui interface.
 *
 * ==========================================================
 *                BENTUK UMUM INTERFACE
 * ==========================================================
 *
 * accessModifier interface InterfaceName {
 *
 *     ReturnType method1(Parameter);
 *     ReturnType method2(Parameter);
 *
 *     DataType CONSTANT = value;
 * }
 *
 * Karakteristik:
 *
 * - Abstract method tidak memiliki body.
 * - Method diakhiri dengan tanda ';'.
 * - Konstanta harus langsung diberi nilai.
 *
 * ==========================================================
 *                 MODIFIER PADA INTERFACE
 * ==========================================================
 *
 * Interface dapat menggunakan modifier:
 *
 * - public
 *      Dapat diakses dari package mana pun.
 *
 * - (default/package-private)
 *      Hanya dapat diakses dari package yang sama.
 *
 * ==========================================================
 *                  METHOD PADA INTERFACE
 * ==========================================================
 *
 * Pada Java modern, interface dapat memiliki beberapa jenis
 * method:
 *
 * - abstract method
 *      Method tanpa implementasi yang wajib diimplementasikan
 *      oleh class.
 *
 * - default method (Java 8+)
 *      Method yang sudah memiliki implementasi bawaan.
 *
 * - static method (Java 8+)
 *      Method yang dimiliki oleh interface itu sendiri.
 *
 * - private method (Java 9+)
 *      Digunakan untuk membantu implementasi default method
 *      di dalam interface.
 *
 * Dengan demikian, pernyataan bahwa semua method interface
 * selalu abstract sudah tidak berlaku pada Java modern.
 *
 * ==========================================================
 *                FIELD (VARIABLE) PADA INTERFACE
 * ==========================================================
 *
 * Semua field pada interface secara otomatis bersifat:
 *
 * - public
 * - static
 * - final
 *
 * Artinya:
 *
 * - Menjadi konstanta.
 * - Nilainya tidak dapat diubah.
 * - Harus langsung diinisialisasi.
 *
 * Contoh:
 *
 *     int MAX_SPEED = 120;
 *
 * Secara otomatis diperlakukan sebagai:
 *
 *     public static final int MAX_SPEED = 120;
 *
 * ==========================================================
 *                 INTERFACE SEBAGAI KONTRAK
 * ==========================================================
 *
 * Konsep utama interface adalah sebagai kontrak (contract).
 *
 * Misalnya terdapat interface Vehicle yang mendefinisikan
 * method:
 *
 *     start();
 *
 * Semua class yang mengimplementasikan Vehicle wajib memiliki
 * method start(), meskipun cara implementasinya berbeda.
 *
 * Contoh:
 *
 * - Mobil menjalankan start() dengan menyalakan mesin.
 * - Sepeda listrik menjalankan start() dengan mengaktifkan
 *   motor listrik.
 * - Drone menjalankan start() dengan menyalakan baling-baling.
 *
 * Interface hanya menentukan bahwa perilaku tersebut harus
 * ada, bukan bagaimana cara melaksanakannya.
 *
 * ==========================================================
 *               KEUNTUNGAN MENGGUNAKAN INTERFACE
 * ==========================================================
 *
 * 1. Fleksibel
 *    Implementasi dapat diganti tanpa mengubah kode yang
 *    menggunakan interface.
 *
 * 2. Mendukung Polymorphism
 *    Satu referensi interface dapat menunjuk ke berbagai
 *    implementasi.
 *
 *    Contoh:
 *
 *        Callback callback;
 *
 *        callback = new Client();
 *        callback = new AnotherClient();
 *
 *    Referensi yang sama dapat menghasilkan perilaku yang
 *    berbeda sesuai object yang digunakan.
 *
 * 3. Loose Coupling
 *    Class bergantung pada kontrak (interface), bukan pada
 *    implementasi tertentu.
 *
 *    Pendekatan ini membuat aplikasi lebih mudah dikembangkan,
 *    diuji, dan dipelihara.
 *
 * ==========================================================
 *                         KESIMPULAN
 * ==========================================================
 *
 * Interface merupakan salah satu fondasi utama dalam Object-
 * Oriented Programming (OOP) di Java.
 *
 * Interface mengajarkan cara berpikir berbasis kontrak:
 *
 * - Fokus pada apa yang harus dilakukan.
 * - Bukan pada bagaimana implementasinya.
 *
 * Pendekatan ini menghasilkan kode yang:
 *
 * - Fleksibel.
 * - Mudah dikembangkan (scalable).
 * - Mudah diuji (testable).
 * - Mudah dipelihara (maintainable).
 * - Memiliki desain yang lebih bersih (clean architecture).
 *
 * Oleh karena itu, interface menjadi komponen penting dalam
 * pengembangan aplikasi Java modern, mulai dari aplikasi
 * desktop hingga enterprise framework seperti Spring.
 *
 * ==========================================================
 */

/* ==========================================================
 *                  IMPLEMENTING INTERFACES
 * ==========================================================
 *
 * Setelah sebuah interface didefinisikan, satu atau lebih class
 * dapat mengimplementasikan interface tersebut menggunakan
 * keyword implements.
 *
 * Dengan mengimplementasikan interface, sebuah class menyatakan
 * bahwa dirinya akan memenuhi seluruh kontrak (contract) yang
 * telah ditetapkan oleh interface tersebut.
 *
 * ==========================================================
 *                     BENTUK UMUM
 * ==========================================================
 *
 * class ClassName
 *         [extends SuperClass]
 *         [implements Interface1, Interface2, ...] {
 *
 *     // isi class
 * }
 *
 * Penjelasan:
 *
 * - Sebuah class hanya dapat mewarisi satu superclass
 *   menggunakan keyword extends.
 *
 * - Sebuah class dapat mengimplementasikan satu atau lebih
 *   interface menggunakan keyword implements.
 *
 * - Jika terdapat lebih dari satu interface, pisahkan dengan
 *   tanda koma (,).
 *
 * ==========================================================
 *                ATURAN IMPLEMENTASI INTERFACE
 * ==========================================================
 *
 * Saat sebuah class mengimplementasikan interface, berlaku
 * beberapa aturan penting:
 *
 * 1. Seluruh abstract method pada interface wajib
 *    diimplementasikan.
 *
 * 2. Method implementasi harus memiliki modifier public,
 *    karena seluruh abstract method pada interface secara
 *    otomatis bersifat public.
 *
 * 3. Signature method harus sama persis, meliputi:
 *    - Nama method.
 *    - Parameter.
 *    - Return type.
 *
 * Jika salah satu aturan tersebut tidak dipenuhi, program
 * tidak akan berhasil dikompilasi.
 *
 * ==========================================================
 *             MENGAPA METHOD HARUS public?
 * ==========================================================
 *
 * Misalkan pada interface terdapat method:
 *
 *     void callback(int param);
 *
 * Compiler akan memperlakukannya sebagai:
 *
 *     public abstract void callback(int param);
 *
 * Oleh karena itu, implementasi berikut tidak valid:
 *
 *     void callback(int param) { ... }
 *
 * karena aksesnya lebih sempit daripada method pada interface.
 *
 * Compiler akan menghasilkan error seperti:
 *
 *     attempting to assign weaker access privileges
 *
 * Implementasi yang benar:
 *
 *     public void callback(int param) { ... }
 *
 * ==========================================================
 *              JIKA ADA METHOD YANG SAMA
 * ==========================================================
 *
 * Apabila beberapa interface memiliki abstract method dengan
 * signature yang sama, class cukup mengimplementasikan method
 * tersebut satu kali.
 *
 * Satu implementasi tersebut akan memenuhi kontrak dari semua
 * interface yang memiliki method yang sama.
 *
 * ==========================================================
 *          CLASS BOLEH MEMILIKI ANGGOTA TAMBAHAN
 * ==========================================================
 *
 * Interface hanya menentukan method yang wajib dimiliki.
 *
 * Class yang mengimplementasikan interface tetap bebas
 * memiliki:
 *
 * - Field (instance variable) sendiri.
 * - Constructor.
 * - Method tambahan.
 * - Logic bisnis yang tidak terdapat pada interface.
 *
 * Dengan demikian, interface tidak membatasi isi class selain
 * kontrak yang harus dipenuhi.
 *
 * ==========================================================
 *            MENGIMPLEMENTASIKAN BANYAK INTERFACE
 * ==========================================================
 *
 * Java mendukung Multiple Interface Implementation.
 *
 * Contoh:
 *
 *     class SmartDevice
 *             implements Camera, GPS, MusicPlayer {
 *         ...
 *     }
 *
 * Hal ini memungkinkan sebuah class memiliki berbagai macam
 * kemampuan (behavior) dari beberapa interface sekaligus.
 *
 * Berbeda dengan inheritance class:
 *
 * - extends hanya boleh satu superclass.
 * - implements dapat terdiri dari banyak interface.
 *
 * Inilah salah satu alasan interface menjadi mekanisme utama
 * untuk mencapai multiple inheritance of type di Java.
 *
 * ==========================================================
 *             INTERFACE SEBAGAI TIPE REFERENSI
 * ==========================================================
 *
 * Interface juga dapat digunakan sebagai tipe referensi.
 *
 * Contoh:
 *
 *     Callback callback;
 *
 * Referensi tersebut dapat menunjuk ke berbagai object yang
 * mengimplementasikan Callback.
 *
 * Contoh:
 *
 *     callback = new Client();
 *     callback = new AnotherClient();
 *
 * Method yang dipanggil akan ditentukan berdasarkan object
 * sebenarnya saat runtime (dynamic method dispatch).
 *
 * Inilah salah satu bentuk penerapan polymorphism.
 *
 * ==========================================================
 *      IMPLEMENTASI DAPAT DITUNDA DENGAN ABSTRACT CLASS
 * ==========================================================
 *
 * Sebuah class yang mengimplementasikan interface tidak wajib
 * langsung mengimplementasikan seluruh abstract method apabila
 * class tersebut dideklarasikan sebagai abstract.
 *
 * Contoh:
 *
 *     abstract class BaseClass implements MyInterface {
 *         // belum mengimplementasikan seluruh method
 *     }
 *
 * Selanjutnya, class turunan bertanggung jawab untuk
 * mengimplementasikan sisa abstract method tersebut.
 *
 * ==========================================================
 *         INTERFACE vs ABSTRACT CLASS
 * ==========================================================
 *
 * Interface:
 *
 * - Mendefinisikan kontrak.
 * - Menentukan perilaku yang harus dimiliki.
 * - Tidak menyimpan state object.
 *
 * Abstract Class:
 *
 * - Menyediakan kerangka dasar implementasi.
 * - Dapat memiliki field, constructor, dan method yang sudah
 *   memiliki implementasi.
 * - Dapat menunda implementasi sebagian abstract method.
 *
 * Keduanya sering digunakan secara bersamaan untuk membangun
 * desain aplikasi yang fleksibel.
 *
 * ==========================================================
 *                       KESIMPULAN
 * ==========================================================
 *
 * Saat sebuah class mengimplementasikan interface, class
 * tersebut menyatakan kesediaannya untuk memenuhi seluruh
 * kontrak yang ditetapkan oleh interface.
 *
 * Poin-poin penting:
 *
 * - Semua abstract method wajib diimplementasikan.
 * - Method implementasi harus bersifat public.
 * - Signature method harus sama persis.
 * - Satu class dapat mengimplementasikan banyak interface.
 * - Interface dapat digunakan sebagai tipe referensi untuk
 *   mendukung polymorphism.
 * - Jika implementasi belum lengkap, class harus dideklarasikan
 *   sebagai abstract agar implementasi dapat diteruskan oleh
 *   class turunannya.
 *
 * Konsep ini merupakan salah satu fondasi utama dalam
 * pengembangan aplikasi Java yang modular, fleksibel, dan
 * mudah dikembangkan.
 *
 * ==========================================================
 */    

public interface Callback {
    // METHOD di interface
    void callback(int param); // DEKLARASI method tanpa isi
    // METHOD TANPA isi → cuma aturan

}
