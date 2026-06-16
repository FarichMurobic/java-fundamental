package FundamentalJava.Annotasi;

/**
 * ---------------------------------------------------------------------------
 * SINGLE-MEMBER ANNOTATION
 * ---------------------------------------------------------------------------
 *
 * Single-Member Annotation adalah annotation yang hanya memiliki
 * satu member.
 *
 * Keunggulan utamanya adalah Java menyediakan penulisan singkat
 * (shorthand syntax) sehingga nilai dapat diberikan tanpa harus
 * menuliskan nama member secara eksplisit.
 *
 * Namun terdapat syarat penting:
 *
 * - Nama member harus bernama value.
 *
 * ---------------------------------------------------------------------------
 * MEMBUAT SINGLE-MEMBER ANNOTATION
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * @Retention(RetentionPolicy.RUNTIME)
 * @interface MySingle {
 *     int value();
 * }
 *
 * Pada contoh di atas:
 *
 * - Annotation hanya memiliki satu member.
 * - Nama member adalah value.
 * - Karena bernama value, Java mengizinkan penggunaan shorthand.
 *
 * ---------------------------------------------------------------------------
 * PENGGUNAAN SINGLE-MEMBER ANNOTATION
 * ---------------------------------------------------------------------------
 *
 * Penulisan normal:
 *
 * @MySingle(value = 100)
 *
 * Penulisan shorthand:
 *
 * @MySingle(100)
 *
 * Kedua penulisan tersebut memiliki arti yang sama:
 *
 * value = 100
 *
 * Java secara otomatis memahami bahwa nilai yang diberikan
 * ditujukan untuk member bernama value.
 *
 * ---------------------------------------------------------------------------
 * MENGAPA BISA TANPA value = ?
 * ---------------------------------------------------------------------------
 *
 * Java memiliki aturan khusus:
 *
 * Jika annotation hanya memiliki satu member atau terdapat
 * member utama yang bernama value, maka penulisan dapat
 * disederhanakan.
 *
 * Contoh:
 *
 * @SomeAnno(88)
 *
 * Secara implisit berarti:
 *
 * value = 88
 *
 * ---------------------------------------------------------------------------
 * SINGLE-MEMBER DENGAN MEMBER LAIN
 * ---------------------------------------------------------------------------
 *
 * Sebuah annotation tetap dapat menggunakan shorthand untuk
 * member value meskipun memiliki member lain yang memiliki
 * default value.
 *
 * Contoh:
 *
 * @interface SomeAnno {
 *     int value();
 *     int xyz() default 0;
 * }
 *
 * Penggunaan:
 *
 * @SomeAnno(88)
 *
 * Artinya:
 *
 * value = 88
 * xyz = 0
 *
 * Jika ingin mengubah member lainnya:
 *
 * @SomeAnno(value = 88, xyz = 99)
 *
 * Maka penulisan harus dilakukan secara lengkap.
 *
 * ---------------------------------------------------------------------------
 * CONTOH DI DUNIA NYATA
 * ---------------------------------------------------------------------------
 *
 * Konsep ini sangat sering digunakan dalam berbagai framework
 * Java modern.
 *
 * Contoh:
 *
 * @RequestMapping("/home")
 *
 * Sebenarnya setara dengan:
 *
 * @RequestMapping(value = "/home")
 *
 * Java mengizinkan bentuk singkat karena member utama pada
 * annotation tersebut bernama value.
 *
 * ---------------------------------------------------------------------------
 * PERBANDINGAN JENIS-JENIS ANNOTATION
 * ---------------------------------------------------------------------------
 *
 * Normal Annotation:
 * -> @A(x = 1, y = 2)
 * -> Memiliki satu atau lebih member yang diisi secara eksplisit.
 *
 * Marker Annotation:
 * -> @A
 * -> Tidak memiliki member sama sekali.
 *
 * Single-Member Annotation:
 * -> @A(10)
 * -> Memiliki member bernama value sehingga dapat menggunakan
 *    shorthand syntax.
 *
 * ---------------------------------------------------------------------------
 * KESIMPULAN
 * ---------------------------------------------------------------------------
 *
 * Single-Member Annotation adalah annotation yang memiliki satu
 * member utama bernama value.
 *
 * Karena menggunakan member bernama value, Java menyediakan
 * shorthand syntax sehingga dapat ditulis:
 *
 * @Anno(10)
 *
 * sebagai pengganti:
 *
 * @Anno(value = 10)
 *
 * Fitur ini membuat penulisan annotation menjadi lebih ringkas,
 * mudah dibaca, dan banyak digunakan dalam framework Java modern.
 */

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Single {
    int value(); // harus bernama value (shorthand)
    int val() default 22; // bisa digabung dengan default member
}

@Single(100)
public class SiingleMemberAnnotation {

    @Single(1)
    public static void myMeth() {
        // Membaut objek
        SiingleMemberAnnotation single = new SiingleMemberAnnotation();
        // Cek apakah anotasi ada?
        if (single.getClass().isAnnotationPresent(Single.class)) {
            System.out.println("Ada");
        }

        // Value anotasi di class
        Single singleClass = single.getClass().getAnnotation(Single.class);
        System.out.println(singleClass.value()); // 100

        // Tampilkan semua value anotasi cara - 1
        Class clas = single.getClass();
        System.out.println(clas.getAnnotation(Single.class));
        // @Annotasi.Single(val=22, value=100)

        try {
            // Ambil method
            Method method = single.getClass().getMethod("myMeth");

            // Ambil value anotasi di method
            Single singleMember = method.getAnnotation(Single.class);
            System.out.println(singleMember.value()); // 1

            // Ambil semua anotasi di method
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation x : annotations) {
                System.out.println(x); // @Annotasi.Single(val=22, value=1)
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }   
    }

    public static void main(String[] args) {
        
        myMeth();

    }
}
