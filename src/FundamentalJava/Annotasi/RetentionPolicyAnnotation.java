package FundamentalJava.Annotasi;

/*

Sebelum membahas annotation lebih jauh, penting untuk memahami retention policy.
Retention policy menentukan kapan sebuah annotation akan dibuang.
Java punya 3 jenis retention policy, yang ada di enum RetentionPolicy:

SOURCE
CLASS
RUNTIME

SOURCE
Annotation dengan retention SOURCE hanya ada di source code (.java)
dan akan hilang saat proses compile.

CLASS
Annotation dengan retention CLASS disimpan di file .class
tapi tidak bisa diakses saat program dijalankan (runtime).

RUNTIME
Annotation dengan retention RUNTIME:
disimpan di .class
DAN bisa diakses saat program berjalan (oleh JVM)

Ini retention paling "kuat"

NOTE
Annotation pada variabel lokal tidak disimpan di .class

Untuk menentukan retention policy, digunakan annotation bawaan Java:
@Retention(retention-policy)

Kalau tidak ditentukan, default-nya adalah:
CLASS

(Contoh)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
String str();
int val();
}

Ini berarti annotation bisa dibaca saat runtime

----------------------------------------------------------------

PENJELASAN SEDERHANA
Intinya:
Retention policy = berapa lama annotation “hidup”

Bayangin annotation itu kayak sticky note di buku:
Tipe	        Analogi
SOURCE	    Catatan yang dihapus sebelum buku dicetak
CLASS	    Dicetak di buku, tapi gak bisa dibaca saat dibaca orang
RUNTIME	    Dicetak dan bisa dibaca kapan saja

SOURCE
@Retention(RetentionPolicy.SOURCE)
Cuma buat compiler / tools
Contoh: @Override

Dipakai untuk:
validasi compile
bantu developer

CLASS (DEFAULT)
@Retention(RetentionPolicy.CLASS)
Disimpan di .class
Tapi JVM gak bisa akses

Jarang dipakai langsung oleh kita

RUNTIME (PALING PENTING)
@Retention(RetentionPolicy.RUNTIME)
Bisa dibaca saat program jalan

Ini yang dipakai di:
Spring Framework
Hibernate
dll

*/

/**
 * ALUR KERJA
 * Saat program jalan:
 * Compiler baca annotation
 * Karena RUNTIME → disimpan ke .class
 * JVM bisa baca annotation saat program berjalan
 * Program bisa ambil info annotation pakai reflection
 *
 * Contoh real:
 * Framework kayak Spring baca annotation:
 * @Controller
 * @Service
 * @Autowired
 *
 * Semua ini pakai RUNTIME retention
 * Annotation ini bisa dibaca saat program jalan
 *
 * INSIGHT PENTING (LEVEL NAIK)
 * Retention ini yang nentuin:
 * annotation cuma buat compile?
 * atau bisa dipakai program?
 *
 * Kalau lu nanti belajar:
 * Reflection
 * Spring Boot
 *
 * 90% pakai:
 * RetentionPolicy.RUNTIME
 */

/**
 * Walaupun annotation biasanya dipakai oleh tools (bukan program utama), kalau retention-nya RUNTIME,
 * maka annotation bisa dibaca saat program berjalan menggunakan reflection.
 * Reflection adalah fitur Java untuk mendapatkan informasi tentang class saat runtime. API-nya ada di java.lang.reflect.
 *
 * Langkah pertama pakai reflection adalah mendapatkan object Class yang merepresentasikan sebuah class.
 * Salah satu cara paling gampang:
 * getClass()
 *
 * Method:
 * final Class<?> getClass()
 * mengembalikan object Class dari object yang memanggilnya.
 *
 * <?> itu generics 
 *
 * Setelah dapat Class, kita bisa ambil info dari class itu:
 * method
 * field
 * constructor
 * annotation
 *
 * Untuk ambil method:
 * getMethod(String methName, Class<?> ... paramTypes)
 *
 * paramTypes = tipe parameter method (bisa kosong)
 *
 * Method ini mengembalikan object Method.
 * Kalau method gak ditemukan → error:
 * NoSuchMethodException
 *
 * Untuk ambil annotation:
 * getAnnotation(Class<A> annoType)
 *
 * Return:
 * object annotation (kalau ada)
 * null (kalau gak ada / bukan RUNTIME)
 *
 * Ini yang sebenarnya terjadi:
 * Annotation = data
 * Reflection = cara baca data itu saat runtime
 *
 * ISTILAH PENTING
 * Istilah	            Arti
 * Reflection	        Ngintip isi class saat runtime
 * Class object	        Representasi class di memori
 * Method object	    Representasi method
 * getAnnotation()	    Ambil annotation
 * class literal	    MyAnno.class
 *
 * KESIMPULAN FINAL
 * Annotation bisa dibaca saat runtime kalau pakai RUNTIME
 * Reflection = alat buat baca annotation
 * Step utama:
 * Ambil Class
 * Ambil Method
 * Ambil Annotation
 * Ambil nilainya
 */

import java.lang.annotation.*;
import java.lang.reflect.*;

// Membuat anotasi
// Menentukan annotation ini tersedia saat runtime
@Retention(RetentionPolicy.RUNTIME)
@interface Bayar {
    String string();
    int val();
}

@Retention(RetentionPolicy.RUNTIME)
@interface What {
    String description();
}

// Menempelkan 2 anotasi ke class
@Bayar(string = "Farich Murobic", val = 22)
@What(description = "Handsome")
public class RetentionPolicyAnnotation {

    // 2 anotasi di method
    @Bayar(string = "Januar", val = 1)
    @What(description = "Heaven")
    public static void myMeth() {

        // Membuat objek
        RetentionPolicyAnnotation retention = new RetentionPolicyAnnotation();

        try {
            // Ambil class dari objek
            Class<?> kelas = retention.getClass();
            System.out.println(kelas.getAnnotation(Bayar.class));
            // @Annotasi.Bayar(string="Farich Murobic", val=22)

            Bayar bayar = kelas.getAnnotation(Bayar.class);
            System.out.println(bayar.string() + " " + bayar.val());
            // Farich Murobic 22

        } catch (Exception e) {
            e.printStackTrace();
        } 

        try {
            // 1. Ambil Class object dari object 
            Class<?> kelas1 = retention.getClass();
            System.out.println(kelas1.getAnnotation(Bayar.class));
            // @Annotasi.Bayar(string="Farich Murobic", val=22)

            // 2. Ambil Method object dari method "myMeth"
            Method method = kelas1.getMethod("myMeth");

            // 3. Ambil annotation dari method tersebut
            Bayar bayar = method.getAnnotation(Bayar.class);

            // 4. Ambil nilai dari annotation
            System.out.println(bayar.string() + " " + bayar.val());
            // Januar 1
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        /**
         * ALUR KERJA (INI YANG WAJIB NGERTI)
         * Saat program jalan:
         * Method myMeth() dipanggil
         * Java bikin object Meta
         * getClass() → dapet info class
         * getMethod("myMeth") → dapet method itu
         * getAnnotation(Bayar.class) → ambil annotation
         *
         * Ambil nilai:
         * bayar.string()
         * bayar.val()
         */

        System.out.println();

        // Untuk semua ANNOTASI
        RetentionPolicyAnnotation retention1 = new RetentionPolicyAnnotation();

        try {
            // Ambil semua annotation di class
            Annotation[] annotations = retention1.getClass().getAnnotations();
            System.out.println("All annotations for this class.");

            // loop semua annotasi di kelas
            for (Annotation x : annotations) {
                System.out.println(x);
            }

            /**
             * @Annotasi.Bayar(string="Farich Murobic", val=22)
             * @Annotasi.What(description="Handsome")
             */

            System.out.println();

            // Ambil semua annotasi di method
            Method method = retention1.getClass().getMethod("myMeth");
            annotations = method.getAnnotations();
            System.out.println("All annotations in method myMeth.");

            for (Annotation x : annotations) {
                System.out.println(x);
            }

            /**
             * @Annotasi.Bayar(string="Januar", val=1)
             * @Annotasi.What(description="Heaven")
             */

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        /**
         * Kamu bisa mengambil semua annotation yang punya retention RUNTIME dengan method:
         * Annotation[] getAnnotations()
         * Return: array annotation
         *
         * Method ini bisa dipanggil dari:
         * Class
         * Method
         * Constructor
         * Field
         *
         * Contoh ini:
         * bikin 2 annotation (Bayar, What)
         * dipakai di class dan method
         * lalu diambil semua annotation-nya
         *
         * getAnnotations() return array Annotation
         * Annotation itu super-interface dari semua annotation
         * Saat di-print → otomatis pakai toString()
         *
         * PENJELASAN INTI
         * Perbedaan penting:
         * Sebelumnya:
         * getAnnotation(MyAnno.class)
         *
         * ambil SATU annotation
         *
         * Sekarang:
         * getAnnotations()
         *
         * ambil SEMUA annotation
         */
    }

    // Menempelkan anotasi ke method dengan parameter
    @Bayar(string = "Anotasi 2 parameter", val = 2)
    public static void myMeth(String str, int i) {

        RetentionPolicyAnnotation retention = new RetentionPolicyAnnotation();
        try {
            // Ambil class objek
            Class<?> clas = retention.getClass();

            // Ambil method + parameternya
            Method method = clas.getMethod("myMeth", String.class, int.class);
            // Karena ada parameter dan ini method Overload! jadi pakai String.class dan int.class

            // Ambil anotasi dari method
            Bayar bayar = method.getAnnotation(Bayar.class);

            // Print nilai anotasi
            System.out.println(bayar.string() + " " + bayar.val());
            // Anotasi 2 parameter 2
        
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        /**
         * Pada contoh sebelumnya, myMeth() tidak punya parameter.
         * Jadi saat getMethod() dipanggil, cukup kasih nama method saja.
         *
         * Tapi kalau method punya parameter, kita HARUS menyertakan tipe parameter tersebut dalam getMethod().
         * Program mirip sebelumnya, tapi sekarang method punya parameter.
         *
         * Karena method punya parameter String dan int, maka getMethod() harus dipanggil seperti ini:
         * Method m = c.getMethod("myMeth", String.class, int.class);
         *
         * Kita kirim tipe parameter sebagai Class object
         *
         * BAGIAN PALING KRUSIAL
         * Class Literal untuk parameter
         * String.class
         * int.class
         *
         * Ini representasi tipe data
         *
         * Khusus primitive:
         * int.class    // benar
         * Integer.class // beda!
         *
         * Hati-hati banget di sini bro
         *
         * CONTOH BIAR MAKIN NGERTI
         * 
         * class Test {
         *
         *     public void demo(String s) {}
         *
         *     public void run() throws Exception {
         *         Method m = this.getClass().getMethod("demo", String.class);
         *         System.out.println("Method ketemu!");
         *     }
         * }
         *
         * INSIGHT LEVEL LANJUT
         * Reflection itu kerja berdasarkan:
         * method signature = nama + parameter
         *
         * KESIMPULAN
         * Kalau method ada parameter → HARUS ditulis di getMethod()
         *
         * Gunakan Class literal:
         * String.class
         * int.class
         * 
         * Java butuh ini untuk bedain method (overloading)
         * Salah sedikit → method gak ketemu
         */
    }

    public static void main(String[] args) {
        
        // Panggil myMeth()
        myMeth();

        // Panggil myMeth() berparameter!
        myMeth("test", 1);
    }
}
