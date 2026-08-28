package FundamentalJava.Annotasi;

/**
 * ---------------------------------------------------------------------------
 * MARKER ANNOTATION
 * ---------------------------------------------------------------------------
 *
 * Marker Annotation adalah jenis annotation yang tidak memiliki
 * member (elemen) sama sekali..
 *
 * Tujuan utamanya adalah untuk memberikan tanda (marker) pada
 * suatu elemen program tanpa menyimpan informasi tambahan.
 *
 * Berbeda dengan Normal Annotation yang dapat memiliki member
 * seperti:
 *
 * @MyAnno(name = "Java")
 *
 * Marker Annotation tidak memiliki member sehingga hanya berfungsi
 * sebagai penanda keberadaan annotation tersebut.
 *
 * ---------------------------------------------------------------------------
 * KARAKTERISTIK MARKER ANNOTATION
 * ---------------------------------------------------------------------------
 *
 * - Tidak memiliki member (elemen).
 * - Tidak menyimpan nilai atau konfigurasi tambahan.
 * - Digunakan sebagai penanda (marker).
 * - Sering digunakan bersama Reflection API.
 * - Umumnya diperiksa berdasarkan keberadaannya saja.
 *
 * Flow:
 * Marker Annotation -> Ditempel Pada Class / Method
 * -> Reflection Memeriksa Keberadaan Annotation
 * -> Menjalankan Logic Tertentu
 *
 * ---------------------------------------------------------------------------
 * MEMBUAT MARKER ANNOTATION
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * @Retention(RetentionPolicy.RUNTIME)
 * @interface MyMarker {
 * }
 *
 * Pada contoh di atas:
 *
 * - MyMarker merupakan Marker Annotation.
 * - Tidak memiliki member sama sekali.
 * - Annotation tersedia saat runtime karena menggunakan
 *   RetentionPolicy.RUNTIME.
 *
 * ---------------------------------------------------------------------------
 * MEMERIKSA MARKER ANNOTATION
 * ---------------------------------------------------------------------------
 *
 * Marker Annotation biasanya diperiksa menggunakan Reflection API.
 *
 * Salah satu method yang paling sering digunakan adalah:
 *
 * isAnnotationPresent()
 *
 * Karena Marker Annotation tidak memiliki member, pemeriksaan
 * biasanya hanya berfokus pada keberadaannya.
 *
 * Flow:
 * Annotation Ada -> Jalankan Logic
 *
 * Annotation Tidak Ada -> Abaikan
 *
 * Contoh:
 *
 * if (obj.getClass().isAnnotationPresent(MyMarker.class)) {
 *     // Jalankan proses tertentu
 * }
 *
 * ---------------------------------------------------------------------------
 * PENULISAN MARKER ANNOTATION
 * ---------------------------------------------------------------------------
 *
 * Karena tidak memiliki member, Marker Annotation ditulis tanpa
 * parameter.
 *
 * Contoh:
 *
 * @MyMarker
 *
 * Berbeda dengan Normal Annotation:
 *
 * @MyAnno(name = "Java")
 *
 * Marker Annotation tidak memerlukan pasangan tanda kurung ()
 * karena tidak ada nilai yang perlu diberikan.
 *
 * ---------------------------------------------------------------------------
 * CONTOH BUILT-IN MARKER ANNOTATION
 * ---------------------------------------------------------------------------
 *
 * Java menyediakan beberapa Marker Annotation bawaan yang sering
 * digunakan:
 *
 * - @Override
 * - @Deprecated
 * - @Documented
 * - @Inherited
 * - @FunctionalInterface
 *
 * Annotation-annotation tersebut digunakan sebagai penanda bagi
 * compiler, framework, atau tools tertentu.
 *
 * ---------------------------------------------------------------------------
 * KEGUNAAN MARKER ANNOTATION
 * ---------------------------------------------------------------------------
 *
 * Marker Annotation sering digunakan untuk:
 *
 * - Menandai class tertentu.
 * - Menandai method tertentu.
 * - Mengaktifkan fitur otomatis pada framework.
 * - Memberikan informasi tambahan kepada compiler.
 * - Menjalankan proses berbasis Reflection.
 *
 * Dalam framework modern seperti Spring, konsep Marker Annotation
 * sering digunakan sebagai dasar untuk mendeteksi dan memproses
 * komponen secara otomatis.
 *
 * ---------------------------------------------------------------------------
 * KESIMPULAN
 * ---------------------------------------------------------------------------
 *
 * Marker Annotation adalah annotation yang tidak memiliki member
 * atau nilai tambahan.
 *
 * Tujuannya adalah untuk memberikan tanda pada suatu elemen
 * program sehingga dapat dikenali oleh compiler, Reflection API,
 * framework, atau tools lainnya.
 *
 * Marker Annotation biasanya diperiksa menggunakan method:
 *
 * isAnnotationPresent()
 *
 * Karena tidak memiliki data tambahan, proses pemeriksaannya
 * hanya berfokus pada keberadaan annotation tersebut.
 *
 * Meskipun sederhana, Marker Annotation merupakan salah satu
 * mekanisme penting yang banyak digunakan dalam berbagai library
 * dan framework Java modern.
 */

import java.lang.annotation.*;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Merker {
} // tanpa isi

public class MerkerAnnotation {

    @Merker
    public static void myMeth() {
        MerkerAnnotation ma = new MerkerAnnotation();
        try {
            // Ambil method
            Method method = ma.getClass().getMethod("myMeth");
            // Cek apakah anotasi ada
            if (method.isAnnotationPresent(Merker.class))
                System.out.println("Merker is present");

            // Ambil value anotasi
            Merker merker = method.getClass().getAnnotation(Merker.class);
            System.out.println(merker); // null
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        myMeth();

    }
}
