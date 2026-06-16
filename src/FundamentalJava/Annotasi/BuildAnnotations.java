package FundamentalJava.Annotasi;

/**
* ============================================================
* BUILT-IN ANNOTATIONS DI JAVA
* ============================================================
*
* Java menyediakan banyak built-in annotation yang dapat digunakan
* untuk berbagai kebutuhan.
*
* Secara umum, terdapat beberapa annotation yang paling sering
* digunakan dalam pengembangan aplikasi Java modern.
*
* ============================================================
* ANNOTATION UNTUK MEMBUAT ANNOTATION LAIN
* Package: java.lang.annotation
* ============================================================
*
* 1. @Retention
*
* Tipe:
* * Normal Annotation
*
* Target:
* * Annotation Type
*
* Fungsi:
* * Menentukan masa hidup (lifecycle) annotation.
*
* Retention Policy:
* * SOURCE  -> Hanya tersedia saat proses kompilasi.
* * CLASS   -> Disimpan di bytecode.
* * RUNTIME -> Tersedia saat runtime dan dapat dibaca menggunakan Reflection API.
*
* Contoh:
*
* @Retention(RetentionPolicy.RUNTIME)
*
* ---
*
* 2. @Target
*
* Tipe:
* * Normal Annotation
*
* Target:
* * Annotation Type
*
* Fungsi:
* * Menentukan lokasi penggunaan annotation.
*
* Contoh:
*
* @Target(ElementType.METHOD)
*
* Beberapa ElementType yang umum:
*
* TYPE        -> Class, Interface, Enum
* METHOD      -> Method
* FIELD       -> Variabel atau Field
* PARAMETER   -> Parameter Method
* CONSTRUCTOR -> Constructor
*
* ---
*
* 3. @Documented
*
* Tipe:
* * Marker Annotation
*
* Target:
* * Annotation Type
*
* Fungsi:
* * Menyertakan annotation ke dalam dokumentasi JavaDoc.
*
* Contoh:
*
* @Documented
*
* ---
*
* 4. @Inherited
*
* Tipe:
* * Marker Annotation
*
* Target:
* * Annotation Type
*
* Fungsi:
* * Membuat annotation dapat diwariskan ke subclass.
*
* Contoh:
*
* @Inherited
*
* ============================================================
* ANNOTATION UNTUK PENGGUNAAN SEHARI-HARI
* Package: java.lang
* ============================================================
*
* 1. @Override
*
* Tipe:
* * Marker Annotation
*
* Dipakai Pada:
* * Method
*
* Fungsi:
* * Memastikan method benar-benar melakukan override terhadap
* method milik superclass atau interface.
*
* Manfaat:
* * Mencegah kesalahan penulisan nama method.
* * Membantu compiler mendeteksi bug lebih awal.
*
* Contoh:
*
* @Override
* public String toString() {
* ```
  return "Object";
  ```
* }
*
* ---
*
* 2. @Deprecated
*
* Tipe:
* * Marker Annotation
*
* Dipakai Pada:
* * Class
* * Method
* * Field
* * Constructor
*
* Fungsi:
* * Menandai kode yang sudah usang dan sebaiknya tidak digunakan
* lagi.
*
* Contoh:
*
* @Deprecated
* void oldMethod() {
* }
*
* ---
*
* 3. @FunctionalInterface
*
* Tipe:
* * Marker Annotation
*
* Dipakai Pada:
* * Interface
*
* Fungsi:
* * Memastikan interface hanya memiliki satu abstract method.
*
* Sangat penting untuk:
*
* Lambda Expression -> Functional Interface -> Lambda Execution
*
* Contoh:
*
* @FunctionalInterface
* interface MyFunction {
* ```
  void execute();
  ```
* }
*
* ---
*
* 4. @SafeVarargs
*
* Tipe:
* * Marker Annotation
*
* Dipakai Pada:
* * Method
* * Constructor
*
* Fungsi:
* * Memberitahu compiler bahwa penggunaan generic varargs aman.
*
* Tujuan:
* * Menghilangkan warning yang berkaitan dengan varargs generic.
*
* Contoh:
*
* @SafeVarargs
* static void test(List<String>... lists) {
* }
*
* ---
*
* 5. @SuppressWarnings
*
* Tipe:
* * Normal Annotation
*
* Dipakai Pada:
* * Class
* * Method
* * Field
* * Variabel Lokal
*
* Fungsi:
* * Menyembunyikan warning tertentu dari compiler.
*
* Contoh:
*
* @SuppressWarnings("unchecked")
*
* ============================================================
* ANNOTATION TAMBAHAN
* ============================================================
*
* 1. @Repeatable
*
* Tipe:
* * Normal Annotation
*
* Dipakai Pada:
* * Annotation Type
*
* Fungsi:
* * Memungkinkan annotation yang sama digunakan lebih dari satu
* kali pada elemen yang sama.
*
* Contoh:
*
* @Repeatable(Roles.class)
*
* ---
*
* 2. @Native
*
* Tipe:
* * Marker Annotation
*
* Dipakai Pada:
* * Field
*
* Fungsi:
* * Menandai field yang dapat direferensikan oleh native code.
*
* Biasanya digunakan pada integrasi JNI (Java Native Interface).
*
* ============================================================
* ANNOTATION YANG PALING SERING DIGUNAKAN
* ============================================================
*
* Dalam praktik pengembangan aplikasi Java sehari-hari, annotation
* berikut adalah yang paling sering ditemui:
*
* @Override
* -> Mencegah kesalahan override method.
*
* @Deprecated
* -> Menandai API yang sudah tidak direkomendasikan.
*
* @SuppressWarnings
* -> Mengontrol warning compiler.
*
* @Retention
* -> Menentukan apakah annotation tersedia saat runtime.
*
* @Target
* -> Menentukan lokasi penggunaan annotation.
*
* ============================================================
* RINGKASAN
* ============================================================
*
* Annotation Untuk Membuat Annotation:
*
* @Retention
* @Target
* @Documented
* @Inherited
* @Repeatable
*
* Annotation Untuk Coding Sehari-Hari:
*
* @Override
* @Deprecated
* @FunctionalInterface
* @SuppressWarnings
* @SafeVarargs
*
* Annotation Khusus:
*
* @Native
*
* ============================================================
* KESIMPULAN
* ============================================================
*
* Built-in Annotation membantu compiler, framework, tools, dan
* developer dalam memberikan metadata tambahan pada source code.
*
* Dari seluruh annotation yang tersedia, @Override,
* @Deprecated, @SuppressWarnings, @Retention, dan @Target
* merupakan annotation yang paling penting dan paling sering
* dijumpai dalam pengembangan aplikasi Java modern.
  */


public class BuildAnnotations {

    // Menandai kode sudah usang
    @Deprecated
    public void methodLama() {
        System.out.println("Jangan dipakai! (Deprecated (Usang))");
    }

    // Memastikan method override dari superclass
    @Override
    public String toString() {
        return "Test class";
    }

    // Menyembunyikan warning compiler	 
    @SuppressWarnings("unchecked")
    public void demo() {
        java.util.List list = new java.util.ArrayList();
    }
}
