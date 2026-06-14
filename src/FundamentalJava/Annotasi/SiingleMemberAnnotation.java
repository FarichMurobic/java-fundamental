package FundamentalJava.Annotasi;

/**
 * Single-member annotation adalah annotation yang hanya punya satu member.
 * Bedanya, kita bisa pakai shortcut (shorthand) saat ngisi nilainya.
 * Tapi syaratnya:
 *
 * nama member HARUS = value
 *
 * (Contoh)
 * @Retention(RetentionPolicy.RUNTIME)
 * @interface MySingle {
 *   int value();
 * }
 *
 * cuma 1 member: value
 *
 * Penggunaan
 * @MySingle(100)
 *
 * gak perlu:
 * @MySingle(value = 100)
 *
 * ---------------------------------------------------
 * 
 * PENJELASAN INTI
 * Kenapa bisa tanpa value =?
 *
 * Karena:
 * int value();
 *
 * Java punya rule khusus:
 * kalau cuma ada value, boleh langsung isi
 *
 * Pakai shorthand:
 * @SomeAnno(88)
 *
 * artinya:
 * value = 88
 * xyz = 0 (default)
 *
 * Kalau mau ubah xyz:
 * @SomeAnno(value = 88, xyz = 99)
 * harus lengkap
 *
 * INSIGHT DUNIA NYATA
 * Ini sering banget dipakai:
 * @RequestMapping("/home")
 *
 * sebenarnya:
 * @RequestMapping(value = "/home")
 *
 * PERBANDINGAN SEMUA JENIS ANNOTATION
 * Jenis	            Contoh	            Ciri
 * Normal	            @A(x=1, y=2)	    lengkap
 * Marker	            @A	                kosong
 * Single-member	    @A(10)	            shortcut
 *
 * KESIMPULAN
 * Single-member = 1 member
 * Nama HARUS value
 *
 * Bisa pakai shortcut:
 * @Anno(10)
 * Bisa digabung dengan default member lain
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
