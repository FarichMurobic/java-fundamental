package FundamentalJava.Generics;

/* ============================================================
 *                        TYPE ERASURE
 * ============================================================
 *
 * Type erasure adalah mekanisme yang digunakan oleh compiler Java
 * untuk menghapus informasi generic setelah proses compile-time.
 *
 * Artinya, saat program dijalankan (runtime), JVM tidak lagi
 * mengetahui informasi generic seperti:
 *
 * <T>
 * <Integer>
 * <String>
 *
 * Sebagian besar informasi tersebut telah dihapus dan diganti
 * dengan Object atau tipe batasnya (bound).
 *
 * Oleh karena itu, generic merupakan fitur yang bekerja
 * terutama pada saat compile-time.
 */

/* ------------------------------------------------------------
 * Bagaimana Proses Type Erasure Bekerja?
 * ------------------------------------------------------------
 *
 * Misalkan terdapat class generic berikut:
 *
 * class Box<T> {
 *     T data;
 *
 *     Box(T data) {
 *         this.data = data;
 *     }
 *
 *     T getData() {
 *         return data;
 *     }
 * }
 *
 * Setelah melalui proses type erasure, bentuk konseptualnya
 * menjadi:
 *
 * class Box {
 *     Object data;
 *
 *     Box(Object data) {
 *         this.data = data;
 *     }
 *
 *     Object getData() {
 *         return data;
 *     }
 * }
 *
 * Terlihat bahwa seluruh penggunaan T telah dihapus dan
 * diganti menjadi Object karena T tidak memiliki bound.
 *
 * Catatan:
 * Bentuk di atas merupakan ilustrasi konseptual untuk membantu
 * memahami proses type erasure. Bytecode yang sebenarnya
 * dihasilkan compiler tidak persis sama dengan contoh tersebut.
 */

/* ------------------------------------------------------------
 * Jika Generic Memiliki Bound
 * ------------------------------------------------------------
 *
 * Misalnya:
 *
 * class Box<T extends Number> {
 *     T data;
 * }
 *
 * Karena T memiliki upper bound Number,
 * maka setelah type erasure:
 *
 * T
 *
 * tidak diganti menjadi Object, melainkan:
 *
 * Number
 *
 * Jadi aturan sederhananya adalah:
 *
 * - Tanpa bound  → Object
 * - Dengan bound → Bound tersebut
 */

/* ------------------------------------------------------------
 * Mengapa Nilainya Tetap Menjadi Integer atau String?
 * ------------------------------------------------------------
 *
 * Misalnya terdapat kode:
 *
 * Box<Integer> box = new Box<>(10);
 * Integer value = box.getData();
 *
 * Setelah type erasure, secara konseptual compiler mengubahnya
 * menjadi:
 *
 * Box box = new Box(10);
 * Integer value = (Integer) box.getData();
 *
 * Perhatikan bahwa compiler secara otomatis menambahkan
 * proses casting yang diperlukan.
 *
 * Programmer tidak perlu menuliskan casting tersebut secara manual.
 */

/* ------------------------------------------------------------
 * Peran Compiler
 * ------------------------------------------------------------
 *
 * Generic bekerja terutama pada saat compile-time.
 *
 * Compiler bertugas untuk:
 *
 * - Memeriksa type safety.
 * - Menolak penggunaan generic yang tidak valid.
 * - Menambahkan cast yang diperlukan setelah type erasure.
 *
 * Setelah proses tersebut selesai, bytecode yang dihasilkan
 * tidak lagi menyimpan sebagian besar informasi generic.
 */

/* ------------------------------------------------------------
 * Mengapa Java Menggunakan Type Erasure?
 * ------------------------------------------------------------
 *
 * Salah satu alasan utama adalah backward compatibility.
 *
 * Ketika generic diperkenalkan pada Java 5,
 * sudah terdapat sangat banyak aplikasi dan library Java
 * yang tidak menggunakan generic.
 *
 * Dengan menggunakan type erasure:
 *
 * - JVM tidak perlu diubah untuk memahami generic.
 * - Bytecode lama tetap dapat dijalankan.
 * - Library lama tetap kompatibel dengan kode yang
 *   menggunakan generic.
 *
 * Pendekatan ini memungkinkan generic ditambahkan ke Java
 * tanpa merusak ekosistem yang sudah ada.
 */

/* ------------------------------------------------------------
 * Dampak Type Erasure
 * ------------------------------------------------------------
 *
 * Karena informasi generic dihapus saat runtime:
 *
 * - JVM tidak mengetahui tipe generic sebenarnya.
 *
 * - Object seperti Box<Integer> dan Box<String> pada dasarnya
 *   menggunakan representasi runtime yang sama.
 *
 * - Operasi tertentu yang membutuhkan informasi generic
 *   saat runtime menjadi tidak memungkinkan secara langsung.
 *
 * Inilah alasan mengapa beberapa fitur generic memiliki
 * keterbatasan, seperti tidak dapat membuat instance T secara
 * langsung atau melakukan pengecekan instanceof terhadap
 * parameterized type tertentu.
 */

/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * - Generic merupakan fitur yang bekerja pada compile-time.
 *
 * - Compiler menerapkan type erasure dengan menghapus sebagian
 *   besar informasi generic.
 *
 * - Type parameter tanpa bound diganti menjadi Object.
 *
 * - Type parameter yang memiliki bound diganti menjadi
 *   tipe bound tersebut.
 *
 * - Compiler secara otomatis menambahkan cast yang diperlukan
 *   agar program tetap type-safe.
 *
 * - JVM menjalankan bytecode yang sebagian besar sudah tidak
 *   mengandung informasi generic.
 */

/* ------------------------------------------------------------
 * Insight
 * ------------------------------------------------------------
 *
 * Type erasure merupakan fondasi dari implementasi generic
 * di Java.
 *
 * Mekanisme ini juga menjadi alasan munculnya berbagai konsep
 * penting lainnya, seperti:
 *
 * - Bridge Method
 * - Type Safety
 * - Bounded Type Parameter
 * - Bounded Wildcard
 *
 * Memahami type erasure akan memudahkan dalam memahami
 * cara kerja generic secara menyeluruh serta menjelaskan
 * mengapa beberapa batasan generic memang dirancang
 * seperti itu.
 */

// ini contoh kode BRIDGE METHOD
class BapakKucing<T> {
    T ob;

    BapakKucing(T ob) {
        this.ob = ob;
    }

    // methode generic
    T getOb() {
        System.out.println("Bapak kucing getOb()");
        return ob;
    }
}

// subclass spesific string
class Kucing extends BapakKucing<String> {

    Kucing(String o) {
        super(o);
    }

    // override versi string
    @Override
    String getOb() {
        System.out.println("Gen2 getOb()");
        return ob;
    }
}

public class Erasure {
    public static void main(String[] args) {

        Kucing g2 = new Kucing("Hello");

        // panggil langsung
        String s = g2.getOb();
        System.out.println("value dari s: " + s);

        System.out.println();

        // polymorphism (INI KUNCI NYA)
        BapakKucing ref = g2; // RAW TYPE SENGAJA
        Object o = ref.getOb();
        System.out.println("value dari ref: " + o);
    }

}
