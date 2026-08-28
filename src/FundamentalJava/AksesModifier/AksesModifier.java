package FundamentalJava.AksesModifier;

/**
 * ============================================================
 * INTRODUCING ACCESS CONTROL
 * ============================================================
 *
 * Salah satu manfaat utama dari encapsulation adalah kemampuan
 * untuk mengontrol akses terhadap data dan method yang dimiliki
 * oleh sebuah class..
 *
 * Encapsulation tidak hanya menghubungkan data dengan kode yang
 * memanipulasinya, tetapi juga menyediakan mekanisme access
 * control (pengendalian akses).
 *
 * Melalui access control, kita dapat menentukan bagian mana dari
 * program yang diperbolehkan untuk mengakses member tertentu dari
 * sebuah class.
 *
 * Dengan membatasi akses secara tepat, kita dapat mencegah
 * penyalahgunaan data dan menjaga integritas object.
 *
 * Sebagai contoh, jika sebuah atribut hanya boleh diakses melalui
 * method tertentu yang telah ditentukan, maka perubahan data dapat
 * dikontrol dan divalidasi dengan lebih baik.
 *
 * Jika diterapkan dengan benar, sebuah class dapat berperan
 * sebagai "black box".
 *
 * Artinya:
 * Class dapat digunakan dari luar -> Implementasi internal tetap
 * tersembunyi dan tidak dapat dimanipulasi secara sembarangan.
 *
 * ============================================================
 * APA ITU ACCESS CONTROL?
 * ============================================================
 *
 * Access Control adalah mekanisme yang menentukan siapa yang
 * diperbolehkan mengakses field, method, constructor, atau nested
 * class yang berada di dalam sebuah class.
 *
 * Tujuannya:
 *
 * * Melindungi data dari akses yang tidak semestinya.
 * * Menjaga konsistensi object.
 * * Mendukung prinsip encapsulation.
 * * Mengurangi ketergantungan antar class.
 *
 * ============================================================
 * ACCESS MODIFIER
 * ============================================================
 *
 * Tingkat akses suatu member ditentukan oleh access modifier yang
 * diletakkan pada deklarasinya.
 *
 * Access control di Java sangat erat kaitannya dengan:
 *
 * * Inheritance (Pewarisan)
 * * Package (Pengelompokan Class)
 *
 * Package merupakan mekanisme untuk mengelompokkan class yang
 * saling berhubungan ke dalam satu namespace.
 *
 * Flow:
 * Package -> Class -> Member (Field / Method / Constructor)
 * -> Access Modifier -> Hak Akses
 *
 * ============================================================
 * JENIS ACCESS MODIFIER DI JAVA
 * ============================================================
 *
 * Java menyediakan empat tingkat akses:
 *
 * 1. public
 * 2. protected
 * 3. default (package-private)
 * 4. private
 *
 * Catatan:
 * Default bukan keyword khusus. Access level ini digunakan ketika
 * tidak ada access modifier yang dituliskan.
 *
 * Modifier protected biasanya digunakan ketika konsep inheritance
 * mulai diterapkan.
 *
 * ============================================================
 * CARA MENULIS ACCESS MODIFIER
 * ============================================================
 *
 * Access modifier ditulis sebelum tipe data atau deklarasi member.
 *
 * Contoh:
 *
 * public int i;
 *
 * private double j;
 *
 * private int myMethod(int a, char b) {
 * ```
 * return a;
 * ```
 * }
 *
 * Access modifier dapat diterapkan pada:
 *
 * * Field
 * * Method
 * * Constructor
 * * Nested Class
 *
 * ============================================================
 * PUBLIC DAN PRIVATE
 * ============================================================
 *
 * public:
 *
 * Member yang menggunakan modifier public dapat diakses dari
 * mana saja selama class tersebut dapat dijangkau oleh program.
 *
 * Flow:
 * Package A -> Package B -> Public Member -> Dapat Diakses
 *
 * private:
 *
 * Member yang menggunakan modifier private hanya dapat diakses
 * oleh kode yang berada di dalam class yang sama.
 *
 * Flow:
 * Class Sendiri -> Private Member -> Dapat Diakses
 *
 * Class Lain -> Private Member -> Tidak Dapat Diakses
 *
 * ============================================================
 * MENGAPA METHOD main() BERSIFAT PUBLIC?
 * ============================================================
 *
 * Method main() biasanya dideklarasikan sebagai:
 *
 * public static void main(String[] args)
 *
 * Hal ini karena method main() dipanggil oleh Java Virtual Machine
 * (JVM), yaitu komponen yang berada di luar class yang kita buat.
 *
 * Jika main() tidak dapat diakses oleh JVM, maka program tidak
 * dapat dijalankan sebagai entry point aplikasi.
 *
 * ============================================================
 * DEFAULT ACCESS (PACKAGE-PRIVATE)
 * ============================================================
 *
 * Jika sebuah member tidak memiliki access modifier, maka Java
 * akan memberikan access level default yang disebut
 * package-private.
 *
 * Contoh:
 *
 * int age;
 *
 * Artinya:
 *
 * * Dapat diakses oleh class lain dalam package yang sama.
 * * Tidak dapat diakses oleh class yang berada pada package
 * berbeda.
 *
 * Flow:
 * Package Sama -> Dapat Diakses
 *
 * Package Berbeda -> Tidak Dapat Diakses
 *
 * ============================================================
 * RINGKASAN ACCESS MODIFIER
 * ============================================================
 *
 * Modifier -> Hak Akses
 *
 * public -> Dapat diakses dari mana saja
 * protected -> Package yang sama dan subclass
 * default -> Hanya package yang sama
 * private -> Hanya class yang sama
 *
 * ============================================================
 * PRAKTIK OOP YANG UMUM DIGUNAKAN
 * ============================================================
 *
 * Dalam penerapan encapsulation, pola yang paling sering
 * digunakan adalah:
 *
 * Field (Variable) -> private
 * Method Akses -> public
 *
 * Contoh:
 *
 * private String name;
 *
 * public String getName() {
 * ```
 * return name;
 * ```
 * }
 *
 * public void setName(String name) {
 * ```
 * this.name = name;
 * ```
 * }
 *
 * Pendekatan ini memungkinkan class untuk mengontrol bagaimana
 * data dibaca dan diubah oleh kode dari luar class.
 *
 * ============================================================
 * KESIMPULAN
 * ============================================================
 *
 * Access Control merupakan mekanisme yang digunakan untuk
 * mengatur tingkat akses terhadap member sebuah class.
 *
 * Melalui access modifier, Java memungkinkan pengembang untuk
 * melindungi data, menerapkan encapsulation, dan membangun desain
 * program yang lebih aman serta mudah dipelihara.
 *
 * Praktik yang paling umum dalam OOP modern adalah menyembunyikan
 * field menggunakan private dan menyediakan akses yang terkontrol
 * melalui method public.
 */

@Anotasi("Anotasi")
@interface Anotasi {
    String value();
}

@Anotasi("Deklarasi class")
class AksesKontrol {

    @Anotasi("Akses Modifier in variabel instance")
    // Contoh program public vs private
    int a; // default akses
    public int b; // public akses
    private int c; // private akses

    @Anotasi("Setter untuk set c (private)")
    // Method untuk mengubah nilai c
    public void setC(int i) {
        c = i;
    }

    @Anotasi("Getter untuk ambil nilai c (private)")
    // Method untuk mengambil nilai c
    public int getC() {
        return c;
    }
}

public class AksesModifier {
    public static void main(String[] args) {

        @Anotasi("Buat objek AksesKontrol")
        AksesKontrol akses = new AksesKontrol();

        // Mengakses variabel instance
        akses.a = 100; // a bisa diakses karena default modifier
        akses.b = 500; // b bida diakses karena public modifier
        // akses.c = 20 0; // akan error, karena private modifier

        // Akses c harus melalui method
        akses.setC(20);

        System.out.println("a: " + akses.a + " b: " + akses.b + " c: " + akses.getC());

        /**
         * OUTPUT
         * a: 100 b: 500 c: 20
         */
    }
}
