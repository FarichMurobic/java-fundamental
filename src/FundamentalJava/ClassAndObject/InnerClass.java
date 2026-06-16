package FundamentalJava.ClassAndObject;

/**
 * ---------------------------------------------------------------------------
 * NESTED CLASS (CLASS DI DALAM CLASS)
 * ---------------------------------------------------------------------------
 *
 * Java memungkinkan sebuah class didefinisikan di dalam class
 * lainnya.
 *
 * Class yang didefinisikan di dalam class lain disebut:
 *
 * Nested Class
 *
 * Scope (jangkauan) nested class dibatasi oleh outer class
 * yang membungkusnya.
 *
 * Contoh:
 *
 * class Outer {
 *
 *     class Inner {
 *     }
 *
 * }
 *
 * Pada contoh di atas:
 *
 * - Outer adalah Outer Class.
 * - Inner adalah Nested Class.
 *
 * Flow:
 *
 * Outer Class
 * -> Berisi Nested Class
 * -> Nested Class Berada Dalam Scope Outer Class
 *
 * ---------------------------------------------------------------------------
 * TUJUAN NESTED CLASS
 * ---------------------------------------------------------------------------
 *
 * Nested class digunakan ketika sebuah class hanya memiliki
 * hubungan erat dengan class tertentu dan tidak perlu digunakan
 * secara bebas oleh bagian program lainnya.
 *
 * Keuntungan:
 *
 * - Membuat kode lebih rapi.
 * - Meningkatkan modularitas.
 * - Mengelompokkan class yang saling berhubungan.
 * - Membantu proses encapsulation.
 *
 * ---------------------------------------------------------------------------
 * AKSES ANTARA OUTER DAN NESTED CLASS
 * ---------------------------------------------------------------------------
 *
 * Nested class memiliki akses ke seluruh member milik outer class,
 * termasuk member private.
 *
 * Contoh:
 *
 * class Outer {
 *
 *     private int data = 100;
 *
 *     class Inner {
 *
 *         void show() {
 *             System.out.println(data);
 *         }
 *
 *     }
 * }
 *
 * Pada contoh tersebut:
 *
 * Inner dapat mengakses:
 *
 * - Variable private.
 * - Method private.
 * - Member lainnya milik Outer.
 *
 * ---------------------------------------------------------------------------
 * CATATAN PENTING
 * ---------------------------------------------------------------------------
 *
 * Banyak materi pemula menjelaskan:
 *
 * "Outer class tidak bisa mengakses isi inner class."
 *
 * Penjelasan ini kurang tepat.
 *
 * Faktanya:
 *
 * Outer class dapat mengakses member inner class jika memiliki
 * object inner class yang sesuai.
 *
 * Contoh:
 *
 * class Outer {
 *
 *     class Inner {
 *         int value = 10;
 *     }
 *
 *     void test() {
 *         Inner in = new Inner();
 *         System.out.println(in.value);
 *     }
 * }
 *
 * Jadi:
 *
 * Inner dapat langsung mengakses member Outer.
 *
 * Sedangkan Outer dapat mengakses member Inner melalui object
 * Inner yang dibuat.
 *
 * ---------------------------------------------------------------------------
 * JENIS-JENIS NESTED CLASS
 * ---------------------------------------------------------------------------
 *
 * Secara umum terdapat dua jenis nested class yang paling sering
 * dipelajari:
 *
 * - Static Nested Class.
 * - Inner Class (Non-Static Nested Class).
 *
 * ---------------------------------------------------------------------------
 * STATIC NESTED CLASS
 * ---------------------------------------------------------------------------
 *
 * Static Nested Class adalah nested class yang menggunakan
 * keyword static.
 *
 * Contoh:
 *
 * class Outer {
 *
 *     static class Inner {
 *     }
 *
 * }
 *
 * Karena bersifat static:
 *
 * - Tidak terikat pada object Outer.
 * - Dapat dibuat tanpa membuat object Outer terlebih dahulu.
 *
 * Contoh:
 *
 * Outer.Inner obj = new Outer.Inner();
 *
 * ---------------------------------------------------------------------------
 * AKSES STATIC NESTED CLASS
 * ---------------------------------------------------------------------------
 *
 * Static Nested Class tidak dapat mengakses member instance
 * (non-static) milik outer class secara langsung.
 *
 * Contoh:
 *
 * class Outer {
 *
 *     int x = 10;
 *
 *     static class Inner {
 *
 *         void show() {
 *             // ERROR
 *             // System.out.println(x);
 *         }
 *
 *     }
 * }
 *
 * Mengapa?
 *
 * Karena member instance membutuhkan object Outer.
 *
 * Jika ingin mengaksesnya:
 *
 * Harus menggunakan object Outer.
 *
 * Contoh:
 *
 * Outer outer = new Outer();
 * System.out.println(outer.x);
 *
 * ---------------------------------------------------------------------------
 * KARAKTERISTIK STATIC NESTED CLASS
 * ---------------------------------------------------------------------------
 *
 * - Menggunakan keyword static.
 * - Tidak terikat dengan object Outer.
 * - Tidak dapat mengakses member instance secara langsung.
 * - Dapat mengakses member static Outer.
 * - Cocok untuk helper class yang hanya berhubungan dengan
 *   outer class.
 *
 * ---------------------------------------------------------------------------
 * INNER CLASS (NON-STATIC NESTED CLASS)
 * ---------------------------------------------------------------------------
 *
 * Inner Class adalah nested class yang tidak menggunakan
 * keyword static.
 *
 * Contoh:
 *
 * class Outer {
 *
 *     class Inner {
 *     }
 *
 * }
 *
 * Inner Class selalu terhubung dengan object Outer tertentu.
 *
 * Karena itu:
 *
 * Inner Class dapat mengakses seluruh member milik Outer secara
 * langsung.
 *
 * ---------------------------------------------------------------------------
 * AKSES INNER CLASS
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * class Outer {
 *
 *     private int data = 100;
 *
 *     class Inner {
 *
 *         void show() {
 *             System.out.println(data);
 *         }
 *
 *     }
 *
 * }
 *
 * Pada contoh di atas:
 *
 * Inner dapat mengakses:
 *
 * - Variable private.
 * - Method private.
 * - Member protected.
 * - Member public.
 *
 * tanpa memerlukan object tambahan.
 *
 * Flow:
 *
 * Inner Class
 * -> Langsung Mengakses Outer Class
 * -> Termasuk Member Private
 *
 * ---------------------------------------------------------------------------
 * MEMBUAT OBJECT INNER CLASS
 * ---------------------------------------------------------------------------
 *
 * Karena Inner Class terikat dengan object Outer,
 * object Inner tidak dapat dibuat secara mandiri.
 *
 * Contoh:
 *
 * Outer outer = new Outer();
 * Outer.Inner inner = outer.new Inner();
 *
 * Flow:
 *
 * Buat Object Outer
 * -> Buat Object Inner
 * -> Inner Terhubung Dengan Outer
 *
 * ---------------------------------------------------------------------------
 * MENGAPA INNER CLASS TIDAK BISA BERDIRI SENDIRI?
 * ---------------------------------------------------------------------------
 *
 * Setiap object Inner secara otomatis menyimpan referensi ke
 * object Outer yang membuatnya.
 *
 * Karena itu:
 *
 * Inner membutuhkan konteks Outer agar dapat bekerja.
 *
 * Flow:
 *
 * Object Outer
 * -> Membuat Inner
 * -> Inner Menyimpan Referensi Outer
 *
 * ---------------------------------------------------------------------------
 * MEMBER CLASS
 * ---------------------------------------------------------------------------
 *
 * Nested class yang dideklarasikan langsung di dalam body class
 * disebut:
 *
 * Member Class
 *
 * Baik:
 *
 * - Static Nested Class.
 * - Inner Class.
 *
 * termasuk kategori Member Class.
 *
 * ---------------------------------------------------------------------------
 * LOCAL CLASS
 * ---------------------------------------------------------------------------
 *
 * Selain sebagai member class, nested class juga dapat
 * dideklarasikan di dalam method, constructor, atau block code.
 *
 * Contoh:
 *
 * void test() {
 *
 *     class LocalClass {
 *     }
 *
 * }
 *
 * Class seperti ini disebut:
 *
 * Local Class
 *
 * Scope-nya hanya berlaku di dalam block tersebut.
 *
 * ---------------------------------------------------------------------------
 * ISTILAH PENTING
 * ---------------------------------------------------------------------------
 *
 * Nested Class
 * -> Class yang berada di dalam class lain.
 *
 * Outer Class
 * -> Class pembungkus nested class.
 *
 * Inner Class
 * -> Nested class non-static.
 *
 * Static Nested Class
 * -> Nested class static.
 *
 * Member Class
 * -> Nested class yang ditulis langsung di dalam class.
 *
 * Local Class
 * -> Nested class yang ditulis di dalam method atau block.
 *
 * Scope
 * -> Jangkauan akses suatu elemen program.
 *
 * Instance
 * -> Object yang dibuat dari sebuah class.
 *
 * ---------------------------------------------------------------------------
 * RINGKASAN PERBEDAAN
 * ---------------------------------------------------------------------------
 *
 * Static Nested Class:
 *
 * - Menggunakan static.
 * - Tidak membutuhkan object Outer.
 * - Tidak dapat mengakses member instance secara langsung.
 *
 * Inner Class:
 *
 * - Tidak menggunakan static.
 * - Membutuhkan object Outer.
 * - Dapat mengakses seluruh member Outer secara langsung.
 *
 * Flow:
 *
 * Static Nested Class
 * -> Independen Dari Object Outer
 *
 * Inner Class
 * -> Terikat Pada Object Outer
 *
 * ---------------------------------------------------------------------------
 * KESIMPULAN
 * ---------------------------------------------------------------------------
 *
 * Nested Class adalah class yang didefinisikan di dalam class
 * lain.
 *
 * Java menyediakan dua jenis utama nested class:
 *
 * - Static Nested Class.
 * - Inner Class.
 *
 * Inner Class memiliki akses langsung ke seluruh member milik
 * Outer Class, termasuk member private.
 *
 * Static Nested Class tidak memiliki hubungan langsung dengan
 * object Outer sehingga tidak dapat mengakses member instance
 * secara langsung.
 *
 * Nested Class digunakan untuk:
 *
 * - Mengelompokkan class yang saling berkaitan.
 * - Membuat kode lebih modular.
 * - Meningkatkan encapsulation.
 * - Membantu organisasi kode yang lebih rapi.
 *
 * Yang wajib diingat:
 *
 * Class Biasa
 * -> Bisa Dibuat Langsung
 *
 * Static Nested Class
 * -> Bisa Dibuat Tanpa Object Outer
 *
 * Inner Class
 * -> Harus Dibuat Dalam Konteks Object Outer
 */

// Class luar
class InnerDemo {

    // Variable instance class luar
    int outer = 100;
    String name;

    // Method class luar
    void test() {
        // Membaut object class inner (class dalam)
        Inner inner = new Inner("Farich Murobic");
        // Panggil method inner class
        inner.display();
    }

    // Class Inner (class dalam)
    class Inner {

        // Constructor inner class
        Inner(String nama) {
            name = nama;
            System.out.println(nama);
        }

        // Method milik inner class
        void display() {
            // akses langsung variabel outer class
            System.out.println("display: outer = " + outer);
        }
    }
}

public class InnerClass {
    public static void main(String[] args) {
        
        // Membuat object class luar
        InnerDemo outer = new InnerDemo(); // Buat object outer
        outer.test(); // Method outer

        // Cara membuat objek inner class didalam kelas yang berbeda
        // HARUS dalam konteks outer. classLuar.ClassDalam - typeReferenceOuter.new ClassDalam();
        InnerDemo.Inner inner = outer.new Inner("JANERA"); 
        inner.display(); // jalankan method inner class

    }
}
