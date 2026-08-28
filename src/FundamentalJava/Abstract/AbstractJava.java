package FundamentalJava.Abstract;

/**
 * ============================================================
 * ABSTRACT CLASS DAN ABSTRACT METHOD
 * ============================================================
 *
 * Dalam beberapa kasus, kita ingin membuat superclass (kelas induk)
 * yang hanya menyediakan struktur atau kerangka umum, tetapi belum
 * dapat memberikan implementasi lengkap untuk seluruh method yang
 * dimilikinya.
 *
 * Artinya:
 * Superclass hanya mendefinisikan konsep dasar, sedangkan detail
 * implementasinya diserahkan kepada subclass.
 *
 * Contoh:
 * Class Figure memiliki method area(), tetapi superclass tidak
 * mengetahui cara menghitung luas untuk semua jenis bangun.
 *
 * Setiap bangun memiliki rumus yang berbeda:
 * Circle -> Menggunakan rumus luas lingkaran
 * Triangle -> Menggunakan rumus luas segitiga
 * Rectangle -> Menggunakan rumus luas persegi panjang
 *
 * Karena itu, superclass hanya mendefinisikan kontrak method
 * yang nantinya dapat diimplementasikan oleh subclass..
 *
 * ============================================================
 * ABSTRACT METHOD
 * ============================================================
 *
 * Abstract Method adalah method yang tidak memiliki body
 * (implementasi).
 *
 * Contoh:
 *
 * abstract double area();
 *
 * Method ini hanya mendefinisikan:
 * - Nama method
 * - Return type
 * - Parameter (jika ada)
 *
 * Tanpa menyediakan implementasi.
 *
 * Artinya:
 * Class turunan harus menyediakan implementasi method tersebut,
 * kecuali class turunan tersebut juga dideklarasikan sebagai
 * abstract class.
 *
 * Dengan kata lain:
 * Superclass menentukan apa yang harus ada,
 * sedangkan subclass menentukan bagaimana cara kerjanya.
 *
 * ============================================================
 * ABSTRACT CLASS
 * ============================================================
 *
 * Jika sebuah class memiliki minimal satu abstract method,
 * maka class tersebut wajib dideklarasikan sebagai abstract class.
 *
 * Contoh:
 *
 * abstract class Figure
 *
 * Abstract class merupakan blueprint yang belum lengkap dan
 * tidak dapat diinstansiasi secara langsung menggunakan operator
 * new.
 *
 * Namun perlu diketahui bahwa abstract class tidak wajib memiliki
 * abstract method. Sebuah class dapat dideklarasikan abstract
 * hanya untuk mencegah pembuatan object secara langsung atau
 * untuk menyediakan fondasi bagi class turunannya.
 *
 * ============================================================
 * MENGAPA ABSTRACT DIPERLUKAN?
 * ============================================================
 *
 * Bayangkan Figure merepresentasikan konsep umum "bangun".
 *
 * Namun superclass tidak dapat menentukan implementasi area()
 * secara universal karena setiap bangun memiliki cara perhitungan
 * luas yang berbeda.
 *
 * Flow:
 * Figure (Abstract Class) -> Circle / Triangle / Rectangle -> area()
 * masing-masing sesuai rumus yang dimiliki
 *
 * Jika area() dipaksakan memiliki implementasi di superclass:
 *
 * - Implementasinya dapat menjadi tidak tepat secara konsep.
 * - Subclass dapat mewarisi perilaku yang tidak sesuai.
 * - Desain program menjadi kurang fleksibel.
 *
 * Dengan abstract method, Java memastikan bahwa implementasi
 * perilaku diserahkan kepada class yang benar-benar memahami
 * cara kerjanya.
 *
 * ============================================================
 * ATURAN PENTING ABSTRACT
 * ============================================================
 *
 * 1. Abstract class tidak dapat dibuat object menggunakan new.
 *
 * 2. Constructor tidak boleh dideklarasikan sebagai abstract.
 *
 * 3. Method tidak boleh menggunakan kombinasi static dan abstract
 *    secara bersamaan.
 *
 * 4. Abstract class dapat memiliki:
 *    - Abstract method
 *    - Concrete method
 *    - Constructor
 *    - Field atau atribut
 *
 * 5. Subclass wajib mengimplementasikan seluruh abstract method,
 *    kecuali subclass tersebut juga dideklarasikan sebagai
 *    abstract class.
 *
 * ============================================================
 * KESIMPULAN
 * ============================================================
 *
 * Abstract Class digunakan untuk mendefinisikan fondasi atau
 * kerangka umum yang akan diwariskan kepada subclass.
 *
 * Abstract Method digunakan ketika superclass mengetahui bahwa
 * suatu perilaku harus ada, tetapi tidak mengetahui bagaimana
 * implementasi yang tepat untuk seluruh subclass.
 *
 * Dengan menggunakan abstract, Java memaksa implementasi perilaku
 * dilakukan oleh class yang paling memahami logika bisnisnya,
 * sehingga desain program menjadi lebih konsisten, fleksibel,
 * dan sesuai dengan prinsip Object-Oriented Programming (OOP).
 */

/**
 * ============================================================
 * KONSEP INTI
 * ============================================================
 *
 * Beberapa konsep penting yang harus dipahami:
 *
 * - Abstract class tidak dapat dibuat object secara langsung
 *   menggunakan operator new.
 *
 * - Abstract method tidak memiliki body (implementasi).
 *
 * - Subclass harus mengimplementasikan abstract method agar dapat
 *   menjadi class konkret (non-abstract).
 *
 * - Jika subclass belum mengimplementasikan abstract method,
 *   maka subclass tersebut juga harus dideklarasikan sebagai
 *   abstract class.
 *
 * Abstract class dapat memiliki:
 *
 * - Abstract method
 * - Concrete method (method biasa)
 * - Constructor
 * - Field atau atribut
 *
 * ============================================================
 * ABSTRACT METHOD VS CONCRETE METHOD
 * ============================================================
 *
 * Concrete Method:
 * - Memiliki implementasi (body).
 * - Dapat langsung digunakan oleh subclass.
 * - Override bersifat opsional.
 *
 * Abstract Method:
 * - Tidak memiliki implementasi (body).
 * - Hanya mendefinisikan kontrak perilaku.
 * - Harus diimplementasikan oleh subclass konkret.
 *
 * Flow:
 * Abstract Method -> Subclass Implementasi -> Digunakan oleh Program
 *
 * ============================================================
 * CONTOH DALAM DUNIA NYATA
 * ============================================================
 *
 * Misalkan terdapat abstract class:
 *
 * abstract class Pembayaran {
 *     abstract void bayar();
 * }
 *
 * Kemudian terdapat beberapa implementasi:
 *
 * Pembayaran -> QRIS
 * Pembayaran -> Cash
 * Pembayaran -> EWallet
 *
 * Setiap metode pembayaran memiliki proses pembayaran yang
 * berbeda-beda.
 *
 * QRIS    -> Scan kode QR
 * Cash    -> Bayar dengan uang tunai
 * EWallet -> Potong saldo digital
 *
 * Namun sistem tidak perlu mengetahui detail implementasinya.
 *
 * Sistem cukup memanggil:
 *
 * pembayaran.bayar();
 *
 * Java akan menjalankan implementasi yang sesuai dengan object
 * sebenarnya (polymorphism).
 *
 * ============================================================
 * KESIMPULAN
 * ============================================================
 *
 * Abstract class digunakan untuk mendefinisikan konsep umum yang
 * akan diwariskan kepada subclass.
 *
 * Abstract method digunakan untuk mendefinisikan perilaku yang
 * wajib tersedia, tetapi implementasinya diserahkan kepada class
 * turunannya.
 *
 * Pendekatan ini menghasilkan desain yang lebih fleksibel,
 * konsisten, dan mendukung penerapan polymorphism dalam
 * Object-Oriented Programming (OOP).
 */

/**
 * ============================================================
 * ABSTRACT METHOD DENGAN PARAMETER
 * ============================================================
 *
 * Abstract method tidak memiliki body (implementasi), tetapi tetap
 * dapat memiliki parameter seperti method pada umumnya.
 *
 * Parameter digunakan untuk mendefinisikan data yang dibutuhkan
 * ketika method tersebut diimplementasikan oleh subclass.
 *
 * Contoh:
 *
 * abstract class BangunDatar {
 *     abstract double luas(double a, double b);
 * }
 *
 * Method di atas mendefinisikan sebuah kontrak yang menyatakan
 * bahwa setiap subclass harus menyediakan implementasi untuk
 * method luas() yang menerima dua parameter bertipe double.
 *
 * Dalam contoh ini:
 * - a -> Nilai pertama yang dibutuhkan untuk perhitungan.
 * - b -> Nilai kedua yang dibutuhkan untuk perhitungan.
 *
 * Arti dari deklarasi tersebut:
 *
 * "Setiap subclass yang ingin menjadi class konkret harus
 * menyediakan implementasi method luas(double a, double b)."
 *
 * ============================================================
 * IMPLEMENTASI PADA SUBCLASS
 * ============================================================
 *
 * Ketika mengimplementasikan abstract method, subclass harus
 * menggunakan method signature yang sama.
 *
 * Method signature terdiri dari:
 * - Nama method
 * - Jumlah parameter
 * - Tipe parameter
 * - Urutan parameter
 *
 * Contoh:
 *
 * abstract double luas(double a, double b);
 *
 * Implementasi yang benar:
 *
 * double luas(double a, double b)
 *
 * Implementasi yang tidak valid:
 *
 * double luas(double a)
 * double luas(int a, int b)
 * double luas(double panjang, double lebar, double tinggi)
 *
 * Flow:
 * Abstract Method -> Mendefinisikan Parameter -> Subclass
 * Mengimplementasikan Method -> Method Digunakan oleh Program
 *
 * ============================================================
 * ATURAN PENTING
 * ============================================================
 *
 * Saat melakukan override terhadap abstract method:
 *
 * - Nama method harus sama.
 * - Jumlah parameter harus sama.
 * - Tipe parameter harus sama.
 * - Urutan parameter harus sama.
 * - Return type harus kompatibel dengan method induknya.
 *
 * Jika salah satu aturan tersebut dilanggar, maka method tersebut
 * tidak dianggap sebagai implementasi dari abstract method yang
 * diwariskan.
 *
 * ============================================================
 * KESIMPULAN
 * ============================================================
 *
 * Abstract method dapat memiliki parameter meskipun tidak memiliki
 * body.
 *
 * Parameter menjadi bagian dari kontrak yang harus dipatuhi oleh
 * subclass saat mengimplementasikan method tersebut.
 *
 * Dengan menjaga kesesuaian method signature, Java dapat
 * memastikan bahwa seluruh subclass menyediakan perilaku yang
 * konsisten sesuai dengan kontrak yang telah ditentukan oleh
 * abstract class.
 */

/**
 * ============================================================
 * SYARAT-SYARAT ABSTRACT METHOD
 * ============================================================
 *
 * Abstract method memiliki beberapa aturan penting yang wajib
 * dipahami karena menjadi dasar penggunaan abstract class dan
 * polymorphism dalam Object-Oriented Programming (OOP).
 *
 * ============================================================
 * 1. ABSTRACT METHOD TIDAK MEMILIKI BODY
 * ============================================================
 *
 * Abstract method hanya mendefinisikan kontrak perilaku tanpa
 * menyediakan implementasi.
 *
 * Contoh yang benar:
 *
 * abstract void test();
 *
 * Contoh yang tidak valid:
 *
 * abstract void test() { }
 *
 * Karena abstract method tidak boleh memiliki body.
 *
 * ============================================================
 * 2. ABSTRACT METHOD HARUS BERADA DI ABSTRACT CLASS
 * ============================================================
 *
 * Jika menggunakan abstract class, abstract method hanya dapat
 * dideklarasikan di dalam abstract class.
 *
 * Contoh:
 *
 * abstract class A {
 * abstract void x();
 * }
 *
 * Catatan:
 * Selain pada abstract class, abstract method juga dapat
 * dideklarasikan di dalam interface.
 *
 * ============================================================
 * 3. ABSTRACT METHOD HARUS DIIMPLEMENTASIKAN
 * ============================================================
 *
 * Jika sebuah class mewarisi abstract method, maka class tersebut
 * harus:
 *
 * - Mengimplementasikan abstract method tersebut.
 * - Atau dideklarasikan sebagai abstract class.
 *
 * Contoh:
 *
 * abstract class A {
 * abstract void x();
 * }
 *
 * Implementasi:
 *
 * class B extends A {
 * 
 * @Override
 *           void x() {
 *           // implementasi
 *           }
 *           }
 *
 *           Jika B tidak mengimplementasikan x(), maka B harus
 *           dideklarasikan sebagai abstract class.
 *
 *           Flow:
 *           Abstract Class -> Abstract Method -> Implementasi Subclass
 *           atau -> Subclass Tetap Abstract
 *
 *           ============================================================
 *           4. METHOD SIGNATURE HARUS SESUAI
 *           ============================================================
 *
 *           Saat mengimplementasikan abstract method, method signature
 *           harus tetap sesuai dengan method yang diwariskan.
 *
 *           Contoh:
 *
 *           abstract class A {
 *           abstract void test(int a);
 *           }
 *
 *           class B extends A {
 * @Override
 *           void test(int a) {
 *           System.out.println(a);
 *           }
 *           }
 *
 *           Hal yang harus sesuai:
 *           - Nama method
 *           - Jumlah parameter
 *           - Tipe parameter
 *           - Urutan parameter
 *
 *           Return type juga harus kompatibel dengan method induknya.
 *
 *           ============================================================
 *           5. ABSTRACT DAN STATIC TIDAK DAPAT DIGABUNGKAN
 *           ============================================================
 *
 *           Contoh:
 *
 *           abstract static void test();
 *
 *           Tidak valid karena:
 *
 *           - Abstract method membutuhkan implementasi dari subclass.
 *           - Static method milik class, bukan milik object.
 *
 *           Kedua konsep tersebut saling bertentangan sehingga tidak dapat
 *           digunakan secara bersamaan.
 *
 *           ============================================================
 *           6. ABSTRACT DAN FINAL TIDAK DAPAT DIGABUNGKAN
 *           ============================================================
 *
 *           Contoh:
 *
 *           abstract final void test();
 *
 *           Tidak valid karena:
 *
 *           - Abstract method harus dapat dioverride.
 *           - Final method tidak boleh dioverride.
 *
 *           Kedua aturan tersebut saling bertentangan sehingga compiler
 *           akan menghasilkan error.
 *
 *           ============================================================
 *           RINGKASAN
 *           ============================================================
 *
 *           - Abstract method tidak memiliki body.
 *           - Abstract method dapat memiliki parameter.
 *           - Abstract method dapat dideklarasikan di abstract class
 *           maupun interface.
 *           - Subclass konkret wajib mengimplementasikan abstract method.
 *           - Method signature harus sesuai saat implementasi.
 *           - Abstract method tidak dapat digabung dengan static.
 *           - Abstract method tidak dapat digabung dengan final.
 *
 *           ============================================================
 *           KESIMPULAN
 *           ============================================================
 *
 *           Abstract method digunakan untuk mendefinisikan kontrak perilaku
 *           yang wajib dipenuhi oleh class turunannya.
 *
 *           Dengan aturan-aturan tersebut, Java dapat memastikan bahwa
 *           setiap implementasi mengikuti struktur yang konsisten dan
 *           sesuai dengan desain yang telah ditentukan oleh superclass
 *           atau interface.
 */

@Anotasi("Anotasi")
@interface Anotasi {
    String value();
}

@Anotasi("Deklarasi Abstract class")
// Class abstract (tidak bisa dibuat object)
abstract class A {

    @Anotasi("Constructor Abstract")
    // Bisa punya constructor
    A() {
        System.out.println("Abstract class bisa punya constructor.");
    }

    @Anotasi("Method Abstract")
    // Method abstract tidak punya body/isi
    abstract void display();

    @Anotasi("Method Biasa dalam Class Abstract")
    // Class abstract bisa punya method biasa
    void methodBiasa() {
        System.out.println("class Abstract bisa punya method biasa!");
    }
}

@Anotasi("Subclass dari abstrac class A")
// Subclass dari class abstract (wajib implement method abstract)
class B extends A {

    @Anotasi("Constructor dari Subclass")
    // Constructor
    B() {
        System.out.println("Constructor Class B");
    }

    @Anotasi("Implement dari method abstract")
    // Implement method abstract dari class A
    @Override
    void display() {
        System.out.println("Hello ini implementasi method abstract dari class A.");
    }

    @Anotasi("Method Biasa")
    void methodB() {
        System.out.println("Ini method biasa class B");
    }
}

@Anotasi("Class Main App")
public class AbstractJava {
    public static void main(String[] args) {

        // class abstract tidak bisa dibuat objek!
        // A objectA = new A();
        @Anotasi("Buat objek dari Subclass (class B)")
        B objectB = new B();

        objectB.display();
        objectB.methodBiasa();
        objectB.methodB();

        /**
         * OUTPUT:
         * 
         * Abstract class bisa punya constructor.
         * Constructor Class B
         * Hello ini implementasi method abstract dari class A.
         * class Abstract bisa punya method biasa!
         * Ini method biasa class B
         */

    }
}
