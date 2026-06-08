package Annotasi;

/*

Java punya banyak annotation bawaan, tapi ada 9 yang umum dipakai:

TABEL BUILT-IN ANNOTATIONS (JAVA)

Dari java.lang.annotation (untuk bikin annotation)
Annotation	    Tipe	    Dipakai di	    Fungsi Utama	                                        Contoh
@Retention      Normal      Annotation	    Menentukan umur annotation (SOURCE, CLASS, RUNTIME)	    @Retention(RetentionPolicy.RUNTIME)
@Target         Normal      Annotation	    Menentukan annotation boleh dipakai di mana	            @Target(ElementType.METHOD)
@Documented     Marker      Annotation	    Menyertakan annotation di JavaDoc	                    @Documented
@Inherited      Marker      Annotation	    Membuat annotation diwariskan ke subclass	            @Inherited

Dari java.lang (dipakai langsung di coding)
Annotation	            Tipe	    Dipakai di	        Fungsi Utama	                                        Contoh
@Override               Marker      Method	            Memastikan method override dari superclass	            @Override public String toString()
@Deprecated             Marker      Semua deklarasi	    Menandai kode sudah usang	                            @Deprecated void old()
@FunctionalInterface    Marker      Interface	        Memastikan hanya 1 abstract method	                    @FunctionalInterface interface A {}
@SafeVarargs            Marker      Method/Constructor	Menjamin varargs aman (hindari warning)	                @SafeVarargs static void test(List<String>... l)
@SuppressWarnings       Normal      Semua deklarasi	    Menyembunyikan warning compiler	                        @SuppressWarnings("unchecked")

Tambahan (JDK 8+ yang disebut di materi)
Annotation	    Tipe	    Dipakai di	        Fungsi
@Repeatable     Normal      Annotation	        Memungkinkan annotation dipakai berulang
@Native         Marker      Field	            Menandai field bisa diakses native code

---------------------------------------------------------------------------------------------

RINGKASAN SUPER PADAT
Kategori besar:
1. Buat bikin annotation:
@Retention
@Target
@Documented
@Inherited

2. Buat coding sehari-hari:
@Override
@Deprecated
@FunctionalInterface
@SuppressWarnings
@SafeVarargs

YANG PALING SERING DIPAKAI (WAJIB HAFAL)

Kalau disaring jadi inti banget:
Annotation	             Kenapa penting
@Override                Hindari bug
@Deprecated              Tanda kode lama
@SuppressWarnings        Bersihin warning
@Retention               Biar annotation bisa dibaca runtime
@Target                  Biar gak salah tempat

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
