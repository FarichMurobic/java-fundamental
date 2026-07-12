package FundamentalJava.Generics;

/* ============================================================
 *                    BRIDGE METHOD PADA GENERICS
 * ============================================================
 *
 * Bridge method adalah method sintetis (synthetic method) yang dibuat
 * secara otomatis oleh compiler Java untuk menjaga agar mekanisme
 * overriding tetap berjalan dengan benar setelah proses type erasure.
 *
 * Bridge method tidak pernah ditulis secara manual oleh programmer.
 * Method ini hanya ada di bytecode (.class) dan digunakan oleh JVM
 * saat program dijalankan.
 */


/* ------------------------------------------------------------
 * Mengapa Bridge Method Diperlukan?
 * ------------------------------------------------------------
 *
 * Perhatikan class generic berikut:
 *
 * class Gen<T> {
 *     T getObj() {
 *         return obj;
 *     }
 * }
 *
 * Karena Java menerapkan type erasure, informasi generic (<T>)
 * dihapus saat proses kompilasi.
 *
 * Setelah type erasure, method tersebut secara konseptual menjadi:
 *
 * Object getObj()
 *
 * Selanjutnya terdapat subclass:
 *
 * class Gen2 extends Gen<String> {
 *     String getObj() {
 *         return obj;
 *     }
 * }
 *
 * Sekilas terlihat seperti proses overriding biasa.
 *
 * Namun setelah type erasure terjadi:
 *
 * Parent : Object getObj()
 * Child  : String getObj()
 *
 * Signature kedua method tersebut tidak lagi identik.
 * Tanpa mekanisme tambahan, JVM akan menganggap bahwa method pada
 * subclass bukan merupakan override dari method milik parent.
 *
 * Untuk mengatasi masalah tersebut, compiler secara otomatis
 * membuat bridge method.
 */


/* ------------------------------------------------------------
 * Bridge Method yang Dibuat Compiler
 * ------------------------------------------------------------
 *
 * Secara konseptual compiler akan menghasilkan method seperti berikut:
 *
 * Object getObj() {          // Bridge Method
 *     return getObj();       // Memanggil method yang mengembalikan String
 * }
 *
 * Sehingga bytecode class Gen2 secara logis memiliki dua method:
 *
 * String getObj();   // Method asli yang ditulis programmer
 * Object getObj();   // Bridge method buatan compiler
 *
 * Dengan demikian, kontrak inheritance tetap terjaga meskipun
 * generic telah dihapus melalui type erasure.
 */


/* ------------------------------------------------------------
 * Mengapa Bridge Method Penting?
 * ------------------------------------------------------------
 *
 * Misalnya terdapat kode berikut:
 *
 * Gen ref = new Gen2("Hello");
 * Object obj = ref.getObj();
 *
 * Reference bertipe Gen mengharapkan adanya method:
 *
 * Object getObj()
 *
 * Jika bridge method tidak dibuat:
 *
 * - JVM akan mencari Object getObj().
 * - Pada subclass hanya tersedia String getObj().
 * - Kontrak overriding menjadi rusak sehingga polymorphism
 *   tidak dapat berjalan dengan benar.
 *
 * Bridge method memastikan bahwa pemanggilan method tetap valid
 * meskipun tipe generic telah dihapus.
 */


/* ------------------------------------------------------------
 * Analogi Sederhana
 * ------------------------------------------------------------
 *
 * Parent mengatakan:
 * "Saya mengembalikan Object."
 *
 * Child mengatakan:
 * "Saya mengembalikan String."
 *
 * Compiler kemudian membuat "penerjemah" yang mengatakan:
 *
 * "Jika ada yang meminta Object, saya akan memanggil method yang
 * mengembalikan String, lalu mengembalikannya sebagai Object."
 *
 * Dengan demikian parent dan child tetap kompatibel.
 */


/* ------------------------------------------------------------
 * Hal Penting yang Perlu Diketahui
 * ------------------------------------------------------------
 *
 * Bridge method tidak akan terlihat pada source code Java.
 *
 * Method tersebut hanya terdapat pada file bytecode (.class)
 * sebagai synthetic method yang dibuat otomatis oleh compiler.
 *
 * Untuk melihatnya, gunakan perintah:
 *
 * javap -c Gen2
 *
 * Atau agar atribut synthetic juga terlihat:
 *
 * javap -v Gen2
 *
 * Hasilnya akan memperlihatkan dua method, misalnya:
 *
 * String getObj();
 * Object getObj();   // Bridge Method
 */


/* ------------------------------------------------------------
 * Hubungan dengan Type Erasure
 * ------------------------------------------------------------
 *
 * Bridge method merupakan konsekuensi langsung dari type erasure.
 *
 * Pada Java, generic hanya digunakan selama proses kompilasi
 * (compile-time).
 *
 * Saat program dijalankan (runtime), informasi generic seperti:
 *
 * <T>
 * <String>
 * <Integer>
 *
 * sudah tidak ada lagi.
 *
 * Sebagian besar tipe generic dihapus dan diganti dengan batas
 * tipenya (bound), atau Object jika tidak memiliki bound.
 *
 * Karena perubahan inilah compiler perlu membuat bridge method
 * agar inheritance dan polymorphism tetap bekerja sebagaimana mestinya.
 */


/* ------------------------------------------------------------
 * Alur Eksekusi di JVM
 * ------------------------------------------------------------
 *
 * Misalkan terdapat pemanggilan:
 *
 * ref.getObj();
 *
 * Secara konseptual proses yang terjadi adalah:
 *
 * 1. JVM mencari method dengan signature Object getObj().
 * 2. JVM menemukan bridge method yang dibuat compiler.
 * 3. Bridge method memanggil String getObj().
 * 4. Nilai hasil dikembalikan sebagai Object.
 *
 * Seluruh proses ini terjadi secara otomatis tanpa campur tangan
 * programmer.
 */


/* ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * - Java menggunakan type erasure untuk menghapus informasi generic
 *   setelah proses kompilasi.
 *
 * - Type erasure dapat menyebabkan signature method pada parent dan
 *   child tidak lagi identik.
 *
 * - Compiler membuat bridge method secara otomatis untuk menjaga
 *   mekanisme overriding tetap valid.
 *
 * - Bridge method memungkinkan inheritance dan polymorphism tetap
 *   bekerja dengan benar meskipun generic telah dihapus.
 *
 * - Bridge method merupakan implementasi internal compiler dan tidak
 *   pernah ditulis secara langsung oleh programmer.
 */


/* ------------------------------------------------------------
 * Insight
 * ------------------------------------------------------------
 *
 * Bridge method sering dijumpai pada library dan framework yang
 * banyak memanfaatkan generic, inheritance, dan polymorphism,
 * seperti Spring, Hibernate, maupun berbagai library koleksi Java.
 *
 * Meskipun jarang disadari oleh developer, bridge method merupakan
 * salah satu mekanisme penting yang menjaga kompatibilitas antara
 * generic Java dengan JVM yang tidak mengenal generic pada runtime.
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
