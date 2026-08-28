package FundamentalJava.Annotasi;

/**
 * ---------------------------------------------------------------------------
 * RETENTION POLICY
 * ---------------------------------------------------------------------------
 *
 * Sebelum membahas annotation lebih jauh, penting untuk memahami
 * Retention Policy..
 *
 * Retention Policy menentukan sampai kapan sebuah annotation
 * "hidup" dan dapat digunakan oleh compiler, JVM, atau program.
 *
 * Java menyediakan tiga jenis Retention Policy yang didefinisikan
 * dalam enum RetentionPolicy:
 *
 * - SOURCE
 * - CLASS
 * - RUNTIME
 *
 * ---------------------------------------------------------------------------
 * RETENTIONPOLICY.SOURCE
 * ---------------------------------------------------------------------------
 *
 * Annotation dengan retention SOURCE hanya tersedia pada source
 * code (.java).
 *
 * Annotation akan dibuang saat proses kompilasi sehingga tidak
 * disimpan ke dalam file .class.
 *
 * Flow:
 * Source Code -> Compiler -> Annotation Dibuang
 *
 * Umumnya digunakan untuk:
 *
 * - Validasi saat compile-time.
 * - Membantu developer.
 * - Dukungan tool tertentu.
 *
 * Contoh:
 *
 * @Override
 *
 * ---------------------------------------------------------------------------
 * RETENTIONPOLICY.CLASS
 * ---------------------------------------------------------------------------
 *
 * Annotation dengan retention CLASS disimpan ke dalam file .class.
 *
 * Namun annotation tersebut tidak tersedia saat program berjalan
 * sehingga tidak dapat dibaca menggunakan Reflection API.
 *
 * Flow:
 * Source Code -> Compiler -> File .class
 * -> Annotation Disimpan -> Runtime Tidak Bisa Membaca
 *
 * Jika Retention Policy tidak ditentukan secara eksplisit,
 * Java menggunakan:
 *
 * RetentionPolicy.CLASS
 *
 * sebagai default.
 *
 * ---------------------------------------------------------------------------
 * RETENTIONPOLICY.RUNTIME
 * ---------------------------------------------------------------------------
 *
 * Annotation dengan retention RUNTIME:
 *
 * - Disimpan ke dalam file .class.
 * - Tetap tersedia saat program berjalan.
 * - Dapat dibaca menggunakan Reflection API.
 *
 * Flow:
 * Source Code -> Compiler -> File .class
 * -> JVM -> Reflection API -> Annotation Dapat Dibaca
 *
 * Retention Policy ini merupakan yang paling penting dalam
 * pengembangan Java modern.
 *
 * Digunakan oleh:
 *
 * - Spring Framework
 * - Spring Boot
 * - Hibernate
 * - Jakarta EE
 * - Berbagai framework modern lainnya
 *
 * ---------------------------------------------------------------------------
 * MENENTUKAN RETENTION POLICY
 * ---------------------------------------------------------------------------
 *
 * Untuk menentukan Retention Policy digunakan annotation bawaan:
 *
 * @Retention(...)
 *
 * Contoh:
 *
 * @Retention(RetentionPolicy.RUNTIME)
 * @interface MyAnno {
 *     String str();
 *     int val();
 * }
 *
 * Artinya:
 *
 * Annotation MyAnno akan tetap tersedia saat runtime dan dapat
 * dibaca menggunakan Reflection API.
 *
 * ---------------------------------------------------------------------------
 * ANALOGI RETENTION POLICY
 * ---------------------------------------------------------------------------
 *
 * Bayangkan annotation adalah sticky note yang ditempel pada buku.
 *
 * SOURCE
 * -> Catatan dihapus sebelum buku dicetak.
 *
 * CLASS
 * -> Catatan ikut dicetak tetapi pembaca tidak bisa melihatnya.
 *
 * RUNTIME
 * -> Catatan ikut dicetak dan dapat dibaca kapan saja.
 *
 * ---------------------------------------------------------------------------
 * ALUR KERJA RETENTIONPOLICY.RUNTIME
 * ---------------------------------------------------------------------------
 *
 * Saat program dijalankan:
 *
 * Compiler Membaca Annotation
 * -> Annotation Disimpan Ke File .class
 * -> JVM Memuat Class
 * -> Reflection Membaca Annotation
 * -> Program Menggunakan Metadata Annotation
 *
 * Karena menggunakan RetentionPolicy.RUNTIME, annotation dapat
 * diakses saat aplikasi sedang berjalan.
 *
 * ---------------------------------------------------------------------------
 * CONTOH DI DUNIA NYATA
 * ---------------------------------------------------------------------------
 *
 * Framework seperti Spring menggunakan annotation:
 *
 * - @Controller
 * - @Service
 * - @Autowired
 *
 * Annotation tersebut menggunakan:
 *
 * RetentionPolicy.RUNTIME
 *
 * sehingga Spring dapat membaca dan memproses annotation saat
 * aplikasi berjalan.
 *
 * ---------------------------------------------------------------------------
 * INSIGHT PENTING
 * ---------------------------------------------------------------------------
 *
 * Retention Policy menentukan apakah annotation:
 *
 * - Hanya digunakan saat compile-time.
 * - Disimpan ke bytecode (.class).
 * - Dapat digunakan oleh program saat runtime.
 *
 * Jika mempelajari:
 *
 * - Reflection
 * - Spring Framework
 * - Spring Boot
 * - Hibernate
 *
 * Maka sebagian besar annotation yang digunakan memakai:
 *
 * RetentionPolicy.RUNTIME
 *
 * ---------------------------------------------------------------------------
 * REFLECTION DAN ANNOTATION
 * ---------------------------------------------------------------------------
 *
 * Walaupun annotation sering digunakan oleh framework atau tools,
 * annotation dengan RetentionPolicy.RUNTIME dapat dibaca langsung
 * oleh program menggunakan Reflection API.
 *
 * Reflection adalah fitur Java yang memungkinkan program
 * memperoleh informasi mengenai class saat runtime.
 *
 * Package utama Reflection:
 *
 * java.lang.reflect
 *
 * ---------------------------------------------------------------------------
 * MENDAPATKAN OBJECT CLASS
 * ---------------------------------------------------------------------------
 *
 * Langkah pertama dalam Reflection biasanya adalah memperoleh
 * object Class yang merepresentasikan sebuah class.
 *
 * Salah satu cara paling mudah:
 *
 * getClass()
 *
 * Signature:
 *
 * final Class<?> getClass()
 *
 * Return:
 *
 * Object Class yang merepresentasikan object tersebut.
 *
 * Catatan:
 *
 * <?> merupakan wildcard pada Java Generics.
 *
 * ---------------------------------------------------------------------------
 * INFORMASI YANG DAPAT DIAMBIL MELALUI CLASS
 * ---------------------------------------------------------------------------
 *
 * Setelah mendapatkan object Class, kita dapat memperoleh
 * berbagai informasi:
 *
 * - Method
 * - Field
 * - Constructor
 * - Annotation
 *
 * Flow:
 * Object -> Class -> Reflection
 * -> Method / Field / Constructor / Annotation
 *
 * ---------------------------------------------------------------------------
 * MENGAMBIL METHOD
 * ---------------------------------------------------------------------------
 *
 * Method yang sering digunakan:
 *
 * getMethod(String methName, Class<?>... paramTypes)
 *
 * Parameter:
 *
 * - methName -> Nama method.
 * - paramTypes -> Tipe parameter method.
 *
 * Return:
 *
 * Object Method.
 *
 * Jika method tidak ditemukan:
 *
 * NoSuchMethodException
 *
 * akan dilempar.
 *
 * ---------------------------------------------------------------------------
 * MENGAMBIL ANNOTATION
 * ---------------------------------------------------------------------------
 *
 * Method yang sering digunakan:
 *
 * getAnnotation(Class<A> annoType)
 *
 * Return:
 *
 * - Object Annotation jika ditemukan.
 * - null jika tidak ditemukan.
 * - null jika annotation bukan RUNTIME retention.
 *
 * Flow:
 * Class -> Method -> Annotation
 * -> getAnnotation() -> Metadata Annotation
 *
 * ---------------------------------------------------------------------------
 * HUBUNGAN ANNOTATION DAN REFLECTION
 * ---------------------------------------------------------------------------
 *
 * Annotation menyimpan metadata.
 *
 * Reflection menyediakan mekanisme untuk membaca metadata tersebut
 * saat runtime.
 *
 * Flow:
 * Annotation -> Metadata
 * Reflection -> Membaca Metadata
 * Program -> Menggunakan Metadata
 *
 * ---------------------------------------------------------------------------
 * ISTILAH PENTING
 * ---------------------------------------------------------------------------
 *
 * - Reflection
 *   -> Mekanisme untuk memperoleh informasi class saat runtime.
 *
 * - Class Object
 *   -> Representasi sebuah class di dalam JVM.
 *
 * - Method Object
 *   -> Representasi method yang diperoleh melalui Reflection.
 *
 * - getAnnotation()
 *   -> Mengambil annotation tertentu.
 *
 * - Class Literal
 *   -> Bentuk seperti MyAnno.class.
 *
 * ---------------------------------------------------------------------------
 * KESIMPULAN
 * ---------------------------------------------------------------------------
 *
 * Retention Policy menentukan sampai kapan annotation tersedia
 * dan dapat digunakan.
 *
 * Java menyediakan tiga Retention Policy:
 *
 * - SOURCE
 * - CLASS
 * - RUNTIME
 *
 * RetentionPolicy.RUNTIME merupakan yang paling penting karena
 * memungkinkan annotation dibaca saat program berjalan.
 *
 * Untuk membaca annotation saat runtime digunakan Reflection API.
 *
 * Langkah umumnya:
 *
 * Ambil Class
 * -> Ambil Method
 * -> Ambil Annotation
 * -> Ambil Nilai Annotation
 *
 * Konsep ini menjadi fondasi bagi berbagai framework modern
 * seperti Spring Framework, Spring Boot, dan Hibernate.
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
         * Kamu bisa mengambil semua annotation yang punya retention RUNTIME dengan
         * method:
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
            // Karena ada parameter dan ini method Overload! jadi pakai String.class dan
            // int.class

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
         * Tapi kalau method punya parameter, kita HARUS menyertakan tipe parameter
         * tersebut dalam getMethod().
         * Program mirip sebelumnya, tapi sekarang method punya parameter.
         *
         * Karena method punya parameter String dan int, maka getMethod() harus
         * dipanggil seperti ini:
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
         * int.class // benar
         * Integer.class // beda!
         *
         * Hati-hati banget di sini bro
         *
         * CONTOH BIAR MAKIN NGERTI
         * 
         * class Test {
         *
         * public void demo(String s) {}
         *
         * public void run() throws Exception {
         * Method m = this.getClass().getMethod("demo", String.class);
         * System.out.println("Method ketemu!");
         * }
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
