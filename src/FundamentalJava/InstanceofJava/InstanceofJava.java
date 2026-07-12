package FundamentalJava.InstanceofJava;

/* ==========================================================
 *                     USING instanceof
 * ==========================================================
 *
 * Operator instanceof digunakan untuk memeriksa apakah sebuah
 * object merupakan instance dari kelas tertentu, subclass,
 * atau interface tertentu pada saat program berjalan (runtime).
 *
 * Pemeriksaan ini sangat berguna ketika tipe asli object tidak
 * diketahui secara pasti hingga runtime.
 *
 * ==========================================================
 *                     MENGAPA DIPERLUKAN?
 * ==========================================================
 *
 * Dalam beberapa kasus, sebuah object dapat dibuat di satu bagian
 * program dan diproses di bagian lain.
 *
 * Contoh:
 * - Thread A membuat berbagai jenis object.
 * - Thread B menerima object tersebut untuk diproses.
 *
 * Karena Thread B hanya menerima referensi object, tipe aslinya
 * belum tentu diketahui. Oleh karena itu, diperlukan pemeriksaan
 * tipe sebelum object diproses lebih lanjut.
 *
 * ==========================================================
 *                     CASTING DAN RISIKONYA
 * ==========================================================
 *
 * Java mengizinkan casting antar kelas yang memiliki hubungan
 * inheritance. Namun, casting yang tidak sesuai akan menyebabkan
 * ClassCastException pada saat runtime.
 *
 * Misalkan terdapat:
 *
 *      A
 *     / \
 *    B   C
 *
 * Casting yang valid:
 * - B -> A (Upcasting)
 * - C -> A (Upcasting)
 *
 * Casting yang berpotensi menyebabkan ClassCastException:
 * - B -> C
 * - C -> B
 *
 * Contoh:
 *
 *     A obj;
 *
 * Referensi di atas dapat menunjuk ke object bertipe A, B, atau C.
 * Jika langsung dilakukan casting tanpa pemeriksaan:
 *
 *     C c = (C) obj;
 *
 * maka program dapat menghasilkan ClassCastException apabila
 * object tersebut ternyata bukan instance dari C.
 *
 * ==========================================================
 *                     SOLUSINYA: instanceof
 * ==========================================================
 *
 * Operator instanceof digunakan untuk memeriksa apakah sebuah
 * object merupakan instance dari tipe tertentu sebelum dilakukan
 * proses casting.
 *
 * Bentuk umum:
 *
 *     objectReference instanceof Type
 *
 * Nilai yang dihasilkan:
 * - true  : object merupakan instance dari tipe tersebut.
 * - false : object bukan instance dari tipe tersebut.
 *
 * ==========================================================
 *                  CASTING YANG AMAN
 * ==========================================================
 *
 * Contoh penggunaan:
 *
 *     if (obj instanceof C) {
 *         C c = (C) obj;
 *     }
 *
 * Dengan melakukan pemeriksaan terlebih dahulu, proses casting
 * menjadi aman dan terhindar dari ClassCastException.
 *
 * Sebaliknya, melakukan casting secara langsung:
 *
 *     C c = (C) obj;
 *
 * dapat menyebabkan exception apabila tipe object tidak sesuai.
 *
 * ==========================================================
 *                     KAPAN DIGUNAKAN?
 * ==========================================================
 *
 * Operator instanceof umum digunakan ketika:
 *
 * - Object berasal dari API atau library.
 * - Object diterima dari thread lain.
 * - Object berasal dari koleksi (Collection) yang berisi berbagai
 *   jenis object.
 * - Object diperoleh melalui mekanisme polymorphism.
 * - Tipe asli object belum diketahui secara pasti hingga runtime.
 *
 * ==========================================================
 *                     CATATAN MODERN JAVA
 * ==========================================================
 *
 * Sejak Java 16, instanceof mendukung Pattern Matching sehingga
 * proses pemeriksaan tipe dan casting dapat dilakukan sekaligus.
 *
 * Contoh:
 *
 *     if (obj instanceof C c) {
 *         // Variabel c sudah otomatis bertipe C
 *     }
 *
 * Pendekatan ini lebih ringkas, lebih aman, dan menjadi gaya
 * penulisan yang direkomendasikan pada Java modern.
 *
 * ==========================================================
 *                         INSIGHT
 * ==========================================================
 *
 * Seluruh class di Java secara langsung maupun tidak langsung
 * mewarisi class Object.
 *
 * Oleh karena itu:
 *
 *     obj instanceof Object
 *
 * akan bernilai true selama obj mengacu pada object yang bukan
 * bernilai null.
 *
 * Perlu diperhatikan bahwa:
 *
 *     null instanceof Object
 *
 * selalu menghasilkan false.
 *
 * ==========================================================
 *                        KESIMPULAN
 * ==========================================================
 *
 * instanceof adalah operator untuk memeriksa tipe object pada
 * saat runtime.
 *
 * Operator ini sangat penting untuk:
 *
 * - Memastikan casting dilakukan dengan aman.
 * - Menghindari ClassCastException.
 * - Mendukung implementasi polymorphism.
 * - Memproses object dengan tipe yang dinamis.
 * - Membangun aplikasi Java yang lebih aman dan fleksibel.
 *
 * ==========================================================
 */

class A {
    int i, j;
}

class B {
    int i, j;
}

class C extends A {
    int k;
}

class D extends A {
    int k;
}

public class InstanceofJava {
    public static void main(String[] args) {
        
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();

        if (a instanceof A)
            System.out.println("a is instcanceof A");

        if (b instanceof B)
            System.out.println("b is instanceof B");

        if (c instanceof C)
            System.out.println("c is instanceof C");

        if (c instanceof A)
            System.out.println("c can be cast to A");

        System.out.println();

        // compare types of derived types
        A ob;

        ob = d; // A reference ke D
        System.out.println("ob now refers to d");

        if (ob instanceof D)
            System.out.println("ob is instance of D");

        System.out.println();

        ob = c; // A reference ke C
        System.out.println("ob now refers to c");

        if (ob instanceof D) {
            System.out.println("ob can be cast to D");
        } else {
            System.out.println("ob cannot be cast to D");
        }

        if (ob instanceof A)
            System.out.println("ob can be cast to A");

        System.out.println();

        // semua objek turunan Object
        if (a instanceof Object)
            System.out.println("a may be cast to Object");
        if (b instanceof Object)
            System.out.println("b may be cast to Object");
        if (c instanceof Object)
            System.out.println("c may be cast to Object");
        if (d instanceof Object)
            System.out.println("d may be cast to Object");

        /**
         * Penjelasan (Bagian Penting)
         *
         * 1. Basic Check
         * if(c instanceof A)
         *
         * Kenapa TRUE?
         * Karena:
         * C adalah turunan A
         *
         * Jadi:
         * C bisa dianggap sebagai A
         *
         * 2. Ini FALSE
         * if(a instanceof C)
         *
         * Kenapa?
         * A bukan turunan C
         *
         * Jadi gak bisa
         *
         * Bagian Paling Penting (Polymorphism)
         * A ob;
         * ob = d;
         *
         * Ini:
         * tipe variabel: A
         * isi sebenarnya: D
         *
         * Cek:
         * if(ob instanceof D)
         *
         * TRUE
         * karena isi aslinya memang D
         *
         * Ganti:
         * ob = c;
         *
         * sekarang isi: C
         *
         * Cek:
         * if(ob instanceof D)
         *
         * FALSE
         * karena sekarang bukan D lagi
         *
         * -----------------------------------
         * 
         * Kenapa instanceof Penting?
         *
         * Dipakai kalau:
         * Object datang dari luar (API, thread, input)
         * Lu gak yakin tipe aslinya
         * Mau casting dengan aman
         *
         * Contoh Aman
         * if(obj instanceof C) {
         *     C c = (C) obj; // aman
         * }
         *
         * Tanpa ini:
         * C c = (C) obj; // bisa error
         *
         * Kesimpulan Santai
         * instanceof = cek tipe object saat runtime
         * Dipakai buat:
         * hindari error casting
         * ngecek tipe object dinamis
         * Penting di:
         * polymorphism
         * OOP kompleks
         * multithread / generic system
         */

    }

}
