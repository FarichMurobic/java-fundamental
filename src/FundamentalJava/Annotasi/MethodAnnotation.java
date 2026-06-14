package FundamentalJava.Annotasi;

/*

Method getAnnotation() dan getAnnotations() sebenarnya berasal dari interface AnnotatedElement, 
yang ada di package java.lang.reflect.
Interface ini dipakai untuk mendukung reflection pada annotation, dan diimplementasikan oleh:
-Method
-Field
-Constructor
-Class
-Package

Selain dua method tadi, ada method lain:
getDeclaredAnnotations()
Annotation[] getDeclaredAnnotations()
Mengembalikan semua annotation yang langsung ada di object tersebut (tidak termasuk yang diwariskan / inherited)

isAnnotationPresent()
boolean isAnnotationPresent(Class<? extends Annotation> annoType)
Mengembalikan:
true → kalau annotation ada
false → kalau tidak ada

Ada tambahan method:
getDeclaredAnnotation()
getAnnotationsByType()
getDeclaredAnnotationsByType()

Dua terakhir dipakai untuk repeated annotation (annotation yang bisa dipakai berkali-kali)

PENJELASAN SEDERHANA
Intinya:
AnnotatedElement = “tempat semua method buat baca annotation”

Semua ini:
Class 
Method
Field

punya kemampuan baca annotation karena:
implements AnnotatedElement

PERBEDAAN METHOD (WAJIB PAHAM)
1. getAnnotations()
Annotation[] annos = obj.getAnnotations();
Ambil:
semua annotation
termasuk yang diwariskan (inherited)

2. getDeclaredAnnotations()
Annotation[] annos = obj.getDeclaredAnnotations();
Ambil:
hanya yang langsung ada
tidak termasuk inherited

3. isAnnotationPresent()
boolean ada = obj.isAnnotationPresent(MyAnno.class);
Cuma ngecek:
ada atau tidak
Cepat & efisien

ANALOGI BIAR NGUNCI
Bayangin class = anak
 
Orang tua punya annotation A
Anak punya annotation B
getAnnotations()
dapet:
A + B

getDeclaredAnnotations()
dapet:
B saja

KESIMPULAN
AnnotatedElement = pusat method annotation
Method penting:
getAnnotation() → satu
getAnnotations() → semua
getDeclaredAnnotations() → tanpa inherited
isAnnotationPresent() → cek cepat
Dipakai di semua object reflection

METHOD BARU (JDK 8) – SINGKAT AJA
getAnnotationsByType()
buat annotation yang bisa dipakai berkali-kali

Contoh:
@Tag("A")
@Tag("B")

bisa ambil semua sekaligus

*/

/**
 * Kamu bisa memberi nilai default pada member annotation.
 * Nilai ini akan dipakai kalau saat pemakaian annotation tidak diisi.
 *
 * (Syntax)
 * type member() default value;
 *
 * value harus sesuai tipe datanya
 *
 * (Contoh)
 * @Retention(RetentionPolicy.RUNTIME)
 * @interface MyAnno {
 *   String str() default "Testing";
 *   int val() default 9000;
 * }
 *
 * default:
 * str = "Testing"
 * val = 9000
 *
 * Karena ada default:
 * boleh gak ngisi apa-apa
 *
 * @MyAnno() // pakai semua default
 * @MyAnno(str = "some string") // val default
 * @MyAnno(val = 100) // str default
 * @MyAnno(str = "Testing", val = 100) // semua diisi
 *
 * KESIMPULAN
 * Default value = nilai otomatis kalau gak diisi
 *
 * Ditulis pakai:
 * default value
 * Bisa isi sebagian / semua / kosong
 * Bikin annotation lebih fleksibel
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
            Class<?> c =  methodAnnotation.getClass();
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
         * @Annotasi.MyAnno("Di method")
         * Testing 9000
         */
    }
}
