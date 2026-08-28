package FundamentalJava.Annotasi;

/**
 * ---------------------------------------------------------------------------
 * ANNOTATEDELEMENT DAN PEMBACAAN ANNOTATION MELALUI REFLECTION
 * ---------------------------------------------------------------------------
 *
 * Method seperti getAnnotation() dan getAnnotations() berasal dari
 * interface AnnotatedElement yang berada di package:
 *
 * java.lang.reflect
 *
 * Interface ini menyediakan sekumpulan method untuk membaca dan
 * memproses annotation melalui Reflection API.
 *
 * AnnotatedElement diimplementasikan oleh beberapa object reflection,
 * antara lain:
 *
 * - Class
 * - Method
 * - Field
 * - Constructor
 * - Package
 *
 * Karena object-object tersebut mengimplementasikan AnnotatedElement,
 * mereka memiliki kemampuan untuk membaca annotation yang melekat
 * padanya..
 *
 * Flow:
 * Class / Method / Field -> AnnotatedElement
 * -> Reflection API -> Membaca Annotation
 *
 * ---------------------------------------------------------------------------
 * METHOD-METHOD PENTING PADA ANNOTATEDELEMENT
 * ---------------------------------------------------------------------------
 *
 * 1. getAnnotation()
 *
 * Digunakan untuk mengambil satu annotation tertentu.
 *
 * Contoh:
 *
 * MyAnno anno = obj.getAnnotation(MyAnno.class);
 *
 * ---------------------------------------------------------------------------
 *
 * 2. getAnnotations()
 *
 * Digunakan untuk mengambil seluruh annotation yang tersedia.
 *
 * Contoh:
 *
 * Annotation[] annos = obj.getAnnotations();
 *
 * Karakteristik:
 *
 * - Mengambil semua annotation.
 * - Termasuk annotation yang diwariskan (inherited).
 *
 * ---------------------------------------------------------------------------
 *
 * 3. getDeclaredAnnotations()
 *
 * Digunakan untuk mengambil annotation yang secara langsung
 * dideklarasikan pada elemen tersebut.
 *
 * Contoh:
 *
 * Annotation[] annos = obj.getDeclaredAnnotations();
 *
 * Karakteristik:
 *
 * - Hanya mengambil annotation yang langsung ada.
 * - Tidak menyertakan annotation yang diwariskan.
 *
 * ---------------------------------------------------------------------------
 *
 * 4. isAnnotationPresent()
 *
 * Digunakan untuk memeriksa keberadaan annotation tertentu.
 *
 * Signature:
 *
 * boolean isAnnotationPresent(
 *     Class<? extends Annotation> annoType
 * );
 *
 * Return Value:
 *
 * - true  -> Annotation ditemukan.
 * - false -> Annotation tidak ditemukan.
 *
 * Contoh:
 *
 * boolean ada =
 *     obj.isAnnotationPresent(MyAnno.class);
 *
 * Karakteristik:
 *
 * - Cepat dan efisien.
 * - Cocok jika hanya ingin mengetahui ada atau tidaknya annotation.
 *
 * ---------------------------------------------------------------------------
 * METHOD TAMBAHAN
 * ---------------------------------------------------------------------------
 *
 * Selain method-method utama, tersedia juga:
 *
 * - getDeclaredAnnotation()
 * - getAnnotationsByType()
 * - getDeclaredAnnotationsByType()
 *
 * Method-method tersebut sering digunakan dalam kasus yang lebih
 * spesifik, terutama untuk Repeated Annotation.
 *
 * ---------------------------------------------------------------------------
 * REPEATED ANNOTATION (JDK 8+)
 * ---------------------------------------------------------------------------
 *
 * Sejak Java 8, annotation dapat digunakan lebih dari satu kali
 * pada elemen yang sama melalui fitur Repeated Annotation.
 *
 * Contoh:
 *
 * @Tag("A")
 * @Tag("B")
 *
 * Untuk mengambil seluruh annotation tersebut sekaligus, biasanya
 * digunakan:
 *
 * getAnnotationsByType()
 *
 * Flow:
 * Repeated Annotation -> getAnnotationsByType()
 * -> Mengambil Seluruh Annotation Sejenis
 *
 * ---------------------------------------------------------------------------
 * ANALOGI AGAR MUDAH DIPAHAMI
 * ---------------------------------------------------------------------------
 *
 * Misalkan:
 *
 * Parent Class memiliki Annotation A
 * Child Class memiliki Annotation B
 *
 * Maka:
 *
 * getAnnotations()
 * -> A + B
 *
 * getDeclaredAnnotations()
 * -> B saja
 *
 * Karena getAnnotations() memperhitungkan annotation yang
 * diwariskan, sedangkan getDeclaredAnnotations() hanya melihat
 * annotation yang langsung berada pada object tersebut.
 *
 * ---------------------------------------------------------------------------
 * KESIMPULAN
 * ---------------------------------------------------------------------------
 *
 * AnnotatedElement merupakan pusat dari berbagai method yang
 * digunakan untuk membaca annotation melalui Reflection API.
 *
 * Method yang paling penting:
 *
 * - getAnnotation() -> Mengambil satu annotation tertentu.
 * - getAnnotations() -> Mengambil semua annotation.
 * - getDeclaredAnnotations() -> Mengambil annotation tanpa inherited.
 * - isAnnotationPresent() -> Memeriksa keberadaan annotation.
 *
 * Method-method tersebut digunakan oleh berbagai object reflection
 * seperti Class, Method, Field, Constructor, dan Package.
 */

/**
 * ---------------------------------------------------------------------------
 * DEFAULT VALUE PADA ANNOTATION
 * ---------------------------------------------------------------------------
 *
 * Annotation dapat memiliki nilai default pada member yang
 * dimilikinya.
 *
 * Nilai default akan digunakan secara otomatis apabila saat
 * penggunaan annotation tidak diberikan nilai secara eksplisit.
 *
 * ---------------------------------------------------------------------------
 * SINTAKS DEFAULT VALUE
 * ---------------------------------------------------------------------------
 *
 * Format umum:
 *
 * type member() default value;
 *
 * Catatan:
 *
 * - Nilai default harus sesuai dengan tipe datanya.
 * - Default value bersifat opsional.
 * - Tidak semua member annotation harus memiliki default value.
 *
 * ---------------------------------------------------------------------------
 * CONTOH PEMBUATAN DEFAULT VALUE
 * ---------------------------------------------------------------------------
 *
 * @Retention(RetentionPolicy.RUNTIME)
 * @interface MyAnno {
 *     String str() default "Testing";
 *     int val() default 9000;
 * }
 *
 * Pada contoh di atas:
 *
 * - str memiliki nilai default "Testing".
 * - val memiliki nilai default 9000.
 *
 * ---------------------------------------------------------------------------
 * PENGGUNAAN DEFAULT VALUE
 * ---------------------------------------------------------------------------
 *
 * Karena seluruh member memiliki default value, annotation dapat
 * digunakan dalam berbagai cara.
 *
 * Menggunakan seluruh default:
 *
 * @MyAnno()
 *
 * Mengubah sebagian nilai:
 *
 * @MyAnno(str = "some string")
 *
 * Mengubah member lain:
 *
 * @MyAnno(val = 100)
 *
 * Mengubah seluruh nilai:
 *
 * @MyAnno(str = "Testing", val = 100)
 *
 * Flow:
 * Annotation Digunakan -> Member Tidak Diisi
 * -> Java Menggunakan Default Value
 *
 * ---------------------------------------------------------------------------
 * KEUNTUNGAN DEFAULT VALUE
 * ---------------------------------------------------------------------------
 *
 * - Mengurangi penulisan kode yang berulang.
 * - Membuat annotation lebih fleksibel.
 * - Memberikan nilai bawaan yang konsisten.
 * - Mempermudah penggunaan annotation.
 *
 * ---------------------------------------------------------------------------
 * KESIMPULAN
 * ---------------------------------------------------------------------------
 *
 * Default Value merupakan nilai otomatis yang digunakan ketika
 * member annotation tidak diberikan nilai saat pemakaian.
 *
 * Sintaks penulisannya menggunakan keyword:
 *
 * default
 *
 * Dengan adanya default value, annotation dapat digunakan dengan:
 *
 * - Seluruh nilai default.
 * - Sebagian nilai diubah.
 * - Seluruh nilai diubah.
 *
 * Fitur ini membuat annotation menjadi lebih fleksibel dan lebih
 * mudah digunakan.
 */

import java.lang.annotation.*;
import java.lang.reflect.*;

// Annotation dengan default value
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno1 {
    String str() default "Testing"; // default string

    int val() default 9000; // default int
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String value();
}

@MyAnno("Di kelas")
public class MethodAnnotation {

    @MyAnno("Di method")
    public void demo() throws Exception {
        Method method = this.getClass().getMethod("demo");

        // Cek apakah ada annotation
        if (method.isAnnotationPresent(MyAnno.class)) {
            System.out.println("Ada Annotation");
        }

        // Ambil langsung annotation
        MyAnno anno = method.getAnnotation(MyAnno.class);
        System.out.println(anno.value());

        // Ambil semua declared annotation
        Annotation[] annotations = method.getDeclaredAnnotations();
        for (Annotation x : annotations) {
            System.out.println(x);
        }
    }

    // Pakai annotasi tanpa isi -> pakai default semua
    @MyAnno1()
    public static void myMeth() {
        MethodAnnotation methodAnnotation = new MethodAnnotation();

        try {
            // Ambil class
            Class<?> c = methodAnnotation.getClass();
            // Ambil method
            Method method = c.getMethod("myMeth");
            // Ambil annotasi
            MyAnno1 anno1 = method.getAnnotation(MyAnno1.class);
            // Ambil nilai pakai default
            System.out.println(anno1.str() + " " + anno1.val());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        new MethodAnnotation().demo();
        myMeth();

        /**
         * OUTPUT:
         * Ada Annotation
         * Di method
         * 
         * @Annotasi.MyAnno("Di method")
         *                      Testing 9000
         */
    }
}
