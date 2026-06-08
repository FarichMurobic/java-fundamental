package Annotasi;

/*

Sejak JDK 5, Java mendukung fitur yang memungkinkan kita menyisipkan informasi tambahan ke dalam source code.
Informasi ini disebut annotation. Annotation tidak mengubah perilaku program, 
jadi tidak mempengaruhi cara program berjalan.

Namun, informasi ini bisa digunakan oleh berbagai tools saat proses development maupun deployment.
Misalnya, annotation bisa dipakai oleh generator kode otomatis. Istilah metadata juga sering digunakan,
tapi annotation lebih umum dipakai.

Annotation Basics
Annotation dibuat menggunakan mekanisme yang berbasis interface. 
Contohnya seperti ini:

@interface MyAnno {
    String str();
    int val();
}

Perhatikan tanda @ sebelum keyword interface. 
Itu memberi tahu compiler bahwa ini adalah annotation, bukan interface biasa.
Lalu ada dua member: str() dan val().

Semua annotation hanya berisi deklarasi method tanpa isi (body).
Java yang akan meng-handle implementasinya.
Method ini sebenarnya berperan seperti field (variabel), bukan method biasa.

Annotation tidak bisa pakai extends.
Tapi semua annotation otomatis mewarisi interface Annotation dari package java.lang.annotation.

Interface ini punya method seperti:
hashCode()
equals()
toString()
annotationType() → mengembalikan object Class dari annotation tersebut

Setelah annotation dibuat, kamu bisa menggunakannya untuk "menandai" sesuatu.
Sebelum JDK 8, annotation hanya bisa dipakai di deklarasi (class, method, dll).

Contoh yang bisa dikasih annotation:
class
method
field (variabel)
parameter
enum

Bahkan annotation bisa dikasih annotation juga! 

*/

/*

Contoh penggunaan annotation:

@MyAnno(str = "Annotation Example", val = 100)
public static void myMeth() {}

Annotation di atas terhubung ke method myMeth().

Cara nulisnya:
pakai @NamaAnnotation
lalu isi nilai member di dalam kurung

Contoh:
str = "Annotation Example"
val = 100

Tidak pakai str() tapi cukup str

INTINYA:
Annotation itu = catatan tambahan di kode

Kayak nulis komentar, tapi:
bukan sekadar komentar
bisa dibaca oleh program atau tools lain

ISTILAH PENTING
Istilah	            Arti
Annotation	        Metadata / info tambahan di kode
Metadata	        Data tentang data
@interface           Cara bikin annotation
Member annotation	Properti di dalam annotation (str, val)

ALUR KERJA
Saat program dijalankan:
Java compile code
Annotation disimpan sebagai metadata
Program tetap jalan normal

Tapi:

Tools (kayak framework, reflection) bisa baca annotation
Bisa dipakai untuk:
validasi
generate code
konfigurasi

KESIMPULAN
Annotation = metadata (info tambahan)
Tidak mengubah jalannya program
Dibuat pakai @interface
Isinya "method tanpa body"
Dipakai dengan @NamaAnnotation(...)
Banyak dipakai di framework (Spring, dll)

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
