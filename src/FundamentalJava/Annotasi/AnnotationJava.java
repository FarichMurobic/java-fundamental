package FundamentalJava.Annotasi;

/**

* ============================================================
* INTRODUCING ANNOTATIONS
* ============================================================
*
* Sejak JDK 5, Java menyediakan fitur yang memungkinkan
* pengembang menambahkan informasi tambahan ke dalam source code.
*
* Informasi tambahan ini disebut Annotation.
*
* Annotation tidak secara langsung mengubah logika atau perilaku
* program yang sedang berjalan.
*
* Sebaliknya, annotation berfungsi sebagai metadata, yaitu
* informasi yang menjelaskan atau memberikan keterangan tambahan
* mengenai elemen program.
*
* Metadata tersebut dapat digunakan oleh:
*
* * Compiler
* * Development Tools
* * Build Tools
* * Framework
* * Reflection API
*
* Contohnya:
*
* * Validasi konfigurasi
* * Code Generation
* * Dependency Injection
* * Mapping Database
* * Konfigurasi Framework
*
* Saat ini annotation merupakan salah satu fitur yang paling
* banyak digunakan dalam framework modern seperti Spring,
* Jakarta EE, Hibernate, dan berbagai library Java lainnya.
*
* ============================================================
* APA ITU METADATA?
* ============================================================
*
* Metadata adalah "data yang menjelaskan data lainnya".
*
* Dalam konteks Java:
*
* Source Code -> Annotation -> Metadata
*
* Annotation memberikan informasi tambahan mengenai class,
* method, field, parameter, atau elemen program lainnya.
*
* ============================================================
* DASAR PEMBUATAN ANNOTATION
* ============================================================
*
* Annotation dibuat menggunakan sintaks khusus yang menyerupai
* interface.
*
* Contoh:
*
* @interface MyAnno {
* ```
  String str();
  ```
* ```
  int val();
  ```
* }
*
* Perhatikan simbol '@' sebelum keyword interface.
*
* Simbol tersebut memberitahu compiler bahwa deklarasi tersebut
* merupakan Annotation Type, bukan interface biasa.
*
* ============================================================
* MEMBER ANNOTATION
* ============================================================
*
* Pada contoh sebelumnya terdapat dua member:
*
* * str()
* * val()
*
* Secara sintaks, keduanya ditulis seperti method.
*
* Namun secara konsep, member annotation lebih menyerupai
* properti atau field yang menyimpan nilai metadata.
*
* Semua member annotation:
*
* * Tidak memiliki body.
* * Tidak memiliki implementasi.
* * Nilainya diberikan saat annotation digunakan.
*
* Implementasi internal akan ditangani oleh Java Runtime.
*
* ============================================================
* HUBUNGAN DENGAN INTERFACE Annotation
* ============================================================
*
* Annotation tidak dapat melakukan inheritance menggunakan
* keyword extends seperti class biasa.
*
* Namun seluruh annotation secara otomatis merupakan turunan
* dari interface:
*
* java.lang.annotation.Annotation
*
* Interface tersebut menyediakan beberapa method penting:
*
* * equals()
* * hashCode()
* * toString()
* * annotationType()
*
* annotationType() digunakan untuk memperoleh object Class
* yang merepresentasikan annotation tersebut.
*
* ============================================================
* TARGET PENGGUNAAN ANNOTATION
* ============================================================
*
* Setelah annotation dibuat, annotation dapat digunakan untuk
* menandai berbagai elemen program.
*
* Contoh target annotation:
*
* * Class
* * Interface
* * Enum
* * Method
* * Field
* * Constructor
* * Parameter
* * Package
*
* Sejak Java 8, annotation juga dapat diterapkan pada type use
* tertentu sehingga penggunaannya menjadi lebih fleksibel
* dibandingkan versi Java sebelumnya.
*
* Bahkan sebuah annotation dapat diberikan annotation lain.
*
* Konsep ini dikenal sebagai Meta-Annotation.
*
* ============================================================
* CONTOH PENGGUNAAN ANNOTATION
* ============================================================
*
* @MyAnno(
* ```
  str = "Annotation Example",
  ```
* ```
  val = 100
  ```
* )
* public static void myMeth() {
* }
*
* Pada contoh tersebut, annotation MyAnno terhubung dengan
* method myMeth().
*
* Nilai metadata yang diberikan:
*
* str -> "Annotation Example"
* val -> 100
*
* Cara penulisannya:
*
* @NamaAnnotation(member = value)
*
* Contoh:
*
* @MyAnno(str = "Hello", val = 10)
*
* Perhatikan bahwa:
*
* Kita menuliskan:
*
* str = "Hello"
*
* Bukan:
*
* str() = "Hello"
*
* ============================================================
* ALUR KERJA ANNOTATION
* ============================================================
*
* Source Code -> Compiler -> Annotation Disimpan Sebagai Metadata
* -> Program Berjalan Normal
*
* Annotation tidak mengubah jalannya program secara langsung.
*
* Namun metadata yang tersimpan dapat dibaca oleh:
*
* Reflection -> Framework -> Tools
*
* Untuk melakukan berbagai tugas otomatis.
*
* Contoh:
*
* Annotation -> Spring Framework -> Dependency Injection
*
* Annotation -> Hibernate -> Mapping Database
*
* Annotation -> Validation Framework -> Validasi Data
*
* ============================================================
* ISTILAH PENTING
* ============================================================
*
* Annotation
* -> Metadata atau informasi tambahan pada source code.
*
* Metadata
* -> Data yang menjelaskan data lainnya.
*
* @interface
* -> Sintaks untuk membuat annotation baru.
*
* Annotation Member
* -> Properti yang menyimpan nilai metadata pada annotation.
*
* Meta-Annotation
* -> Annotation yang digunakan untuk mengatur annotation lain.
*
* ============================================================
* KESIMPULAN
* ============================================================
*
* Annotation merupakan mekanisme metadata yang diperkenalkan
* sejak JDK 5 untuk menambahkan informasi tambahan ke dalam
* source code Java.
*
* Annotation tidak mengubah perilaku program secara langsung,
* tetapi menyediakan informasi yang dapat dimanfaatkan oleh
* compiler, tools, framework, maupun Reflection API.
*
* Annotation dibuat menggunakan keyword @interface dan
* berisi member yang menyerupai method tanpa body.
*
* Dalam pengembangan Java modern, annotation menjadi fondasi
* penting bagi berbagai framework seperti Spring, Hibernate,
* Jakarta EE, serta berbagai mekanisme otomatisasi lainnya.
*/

@interface Info {
    String author();
}

// Pakai annotation
// Ini cuma nempelin label ke class
@Info(author = "Farich Murobic")
class Nama {

}

// Mendefinisikan annotation
@interface Informasi {
    String string(); // member str (kayak field)
    int val(); // member val

    /**
     * PENJELASAN:
     * @interface → bukan interface biasa
     * str() & val() → bukan method beneran, tapi kayak "field wajib"
     */
}

public class AnnotationJava {

    // Penggunaan
    // Menggunakan annotasi pada method
    @Informasi(string = "Belajar annotation", val = 10)
    public static void myMeth() {
        System.out.println("HELLO Annotation...");
    }

    public static void main(String[] args) {
        myMeth();
    }
}
