package FundamentalJava.ClassAndObject;

/**
 * ------------------------------------------------------------
 * ASSIGNING OBJECT REFERENCE VARIABLES
 * ------------------------------------------------------------
 *
 * Salah satu konsep yang paling penting untuk dipahami dalam Java
 * adalah bagaimana assignment bekerja pada variable object.
 *
 * Banyak programmer pemula mengira bahwa ketika sebuah variable
 * object di-assign ke variable lain, Java akan membuat salinan
 * (copy) object tersebut..
 *
 * Padahal yang sebenarnya terjadi tidak demikian.
 *
 * Java tidak menyalin object.
 * Java hanya menyalin reference yang menunjuk ke object tersebut.
 *
 * ------------------------------------------------------------
 * CONTOH DASAR
 * ------------------------------------------------------------
 *
 * Misalkan:
 *
 * Box b1 = new Box();
 * Box b2 = b1;
 *
 * Banyak orang membayangkan hasilnya seperti ini:
 *
 * b1 -> Object A
 *
 * b2 -> Object B (Copy)
 *
 * Namun anggapan tersebut salah.
 *
 * Yang sebenarnya terjadi:
 *
 * b1 -> Object A
 * b2 -> Object A
 *
 * Kedua variable menunjuk ke object yang sama.
 *
 * ------------------------------------------------------------
 * APA YANG SEBENARNYA DICOPY?
 * ------------------------------------------------------------
 *
 * Saat assignment dilakukan:
 *
 * Box b2 = b1;
 *
 * Java tidak membuat object baru.
 *
 * Java tidak menyalin isi object.
 *
 * Java hanya menyalin nilai reference yang dimiliki b1
 * ke dalam b2.
 *
 * Flow:
 *
 * b1 Menyimpan Reference
 * -> Reference Disalin
 * -> Disimpan Ke b2
 *
 * Hasil:
 *
 * b1 Dan b2
 * -> Menunjuk Object Yang Sama
 *
 * ------------------------------------------------------------
 * VISUALISASI MEMORY
 * ------------------------------------------------------------
 *
 * Sebelum assignment:
 *
 * Box b1 = new Box();
 *
 * Memory:
 *
 * b1
 * |
 * v
 * [ Box Object ]
 *
 * Setelah:
 *
 * Box b2 = b1;
 *
 * Memory:
 *
 * b1 ----+
 * |
 * v
 * [ Box Object ]
 * ^
 * |
 * b2 -----+
 *
 * Sekarang:
 *
 * - b1 menunjuk object yang sama.
 * - b2 menunjuk object yang sama.
 *
 * Tidak ada object baru yang dibuat.
 *
 * ------------------------------------------------------------
 * DAMPAKNYA TERHADAP PERUBAHAN DATA
 * ------------------------------------------------------------
 *
 * Karena kedua reference menunjuk object yang sama,
 * perubahan yang dilakukan melalui salah satu reference
 * akan terlihat oleh reference lainnya.
 *
 * Contoh:
 *
 * Box b1 = new Box();
 *
 * b1.width = 100;
 *
 * Box b2 = b1;
 *
 * b2.width = 200;
 *
 * Maka:
 *
 * b1.width = 200
 *
 * Kenapa?
 *
 * Karena:
 *
 * b1 dan b2 menunjuk object yang sama.
 *
 * Flow:
 *
 * b2 Mengubah Object
 * -> Object Berubah
 * -> b1 Melihat Perubahan Yang Sama
 *
 * ------------------------------------------------------------
 * REFERENCE SHARING (ALIASING)
 * ------------------------------------------------------------
 *
 * Kondisi ketika beberapa reference menunjuk ke object yang sama
 * disebut:
 *
 * - Reference Sharing
 *
 * atau
 *
 * - Aliasing
 *
 * Contoh:
 *
 * b1 ----+
 * |
 * v
 * [ Box Object ]
 * ^
 * |
 * b2 -----+
 *
 * Kedua variable menjadi alias untuk object yang sama.
 *
 * ------------------------------------------------------------
 * PERBEDAAN DENGAN PRIMITIVE TYPE
 * ------------------------------------------------------------
 *
 * Primitive type berperilaku berbeda.
 *
 * Contoh:
 *
 * int a = 10;
 * int b = a;
 *
 * Yang dicopy adalah nilai:
 *
 * a = 10
 * b = 10
 *
 * Setelah:
 *
 * b = 20;
 *
 * Hasil:
 *
 * a = 10
 * b = 20
 *
 * Karena:
 *
 * Primitive menyimpan value secara langsung.
 *
 * Sedangkan object:
 *
 * Menyimpan reference.
 *
 * ------------------------------------------------------------
 * PRIMITIVE VS OBJECT
 * ------------------------------------------------------------
 *
 * Primitive:
 *
 * int a = 10;
 * int b = a;
 *
 * Flow:
 *
 * Value
 * -> Disalin
 * -> Menjadi Independent
 *
 * Object:
 *
 * Box b1 = new Box();
 * Box b2 = b1;
 *
 * Flow:
 *
 * Reference
 * -> Disalin
 * -> Menunjuk Object Yang Sama
 *
 * ------------------------------------------------------------
 * MENGUBAH REFERENCE KE OBJECT LAIN
 * ------------------------------------------------------------
 *
 * Misalkan:
 *
 * Box b1 = new Box();
 * Box b2 = b1;
 *
 * Kemudian:
 *
 * b2 = new Box();
 *
 * Sekarang:
 *
 * b1 -> Object Lama
 *
 * b2 -> Object Baru
 *
 * Visualisasi:
 *
 * Sebelum:
 *
 * b1 ----+
 * |
 * v
 * [ Object A ]
 * ^
 * |
 * b2 -----+
 *
 * Sesudah:
 *
 * b1 ------> [ Object A ]
 *
 * b2 ------> [ Object B ]
 *
 * Kedua reference sekarang menunjuk object yang berbeda.
 *
 * ------------------------------------------------------------
 * null DAN OBJECT REFERENCE
 * ------------------------------------------------------------
 *
 * Sebuah reference dapat bernilai:
 *
 * null
 *
 * Artinya:
 *
 * Reference tersebut tidak menunjuk object apa pun.
 *
 * Contoh:
 *
 * Box b1 = null;
 *
 * Visualisasi:
 *
 * b1
 * |
 * v
 * null
 *
 * Jika mencoba mengakses member object:
 *
 * b1.width;
 *
 * Maka JVM akan menghasilkan:
 *
 * NullPointerException
 *
 * Karena tidak ada object yang dapat diakses.
 *
 * ------------------------------------------------------------
 * HUBUNGAN DENGAN GARBAGE COLLECTOR
 * ------------------------------------------------------------
 *
 * Object akan tetap hidup selama masih ada minimal satu
 * reference yang menunjuk kepadanya.
 *
 * Contoh:
 *
 * b1 ----+
 * |
 * v
 * [ Box Object ]
 * ^
 * |
 * b2 -----+
 *
 * Object belum bisa dibersihkan karena masih memiliki
 * reference aktif.
 *
 * Namun jika:
 *
 * b1 = null;
 * b2 = null;
 *
 * Maka:
 *
 * Tidak ada reference yang tersisa.
 *
 * Object tersebut menjadi:
 *
 * Eligible For Garbage Collection
 *
 * dan dapat dibersihkan oleh JVM ketika diperlukan.
 *
 * ------------------------------------------------------------
 * ISTILAH PENTING
 * ------------------------------------------------------------
 *
 * Reference Variable
 * -> Variable yang menyimpan reference object.
 *
 * Assignment
 * -> Proses menyalin nilai dari satu variable ke variable lain.
 *
 * Reference Sharing
 * -> Beberapa reference menunjuk object yang sama.
 *
 * Aliasing
 * -> Nama lain untuk reference sharing.
 *
 * null
 * -> Tidak menunjuk object apa pun.
 *
 * Garbage Collection
 * -> Mekanisme JVM untuk membersihkan object yang
 * sudah tidak digunakan.
 *
 * ------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------
 *
 * Variable object di Java sebenarnya menyimpan reference,
 * bukan object secara langsung.
 *
 * Ketika assignment dilakukan:
 *
 * b2 = b1;
 *
 * yang disalin adalah:
 *
 * - Reference
 *
 * bukan:
 *
 * - Object
 *
 * Akibatnya:
 *
 * b1 dan b2 dapat menunjuk object yang sama.
 *
 * Flow utama:
 *
 * Object Dibuat
 * -> Reference Disimpan Di b1
 * -> Reference Disalin Ke b2
 * -> b1 Dan b2 Menunjuk Object Yang Sama
 *
 * Konsep ini merupakan fondasi penting untuk memahami:
 *
 * - Method Parameter
 * - Returning Objects
 * - Composition
 * - Collections Framework
 * - Spring Dependency Injection
 * - Hibernate Entity Management
 */

class ReferenceObject {
    String nama;
    String usia;
    String city;

    ReferenceObject(String nama, String usia, String city) {
        this.nama = nama;
        this.usia = usia;
        this.city = city;
    }

    void biodata() {
        System.out.println("Nama: " + nama);
        System.out.println("Usia: " + usia);
        System.out.println("City: " + city);
    }
}

public class VariableReferenceObject {
    public static void main(String[] args) {

        // Membuat reference object1
        ReferenceObject object1 = new ReferenceObject("Farich Murobic", "24", "California");
        object1.biodata();

        // Membaut reference object2
        // Reference object2 dan object1 menunjuk ke object yang sama di memory
        ReferenceObject object2 = object1;

        // CEK REFERENCE
        // cek object1
        if (object1 instanceof ReferenceObject) // TRUE
            System.out.println("True");
        else {
            System.out.println("False");
        }

        // cek object2
        if (object2 instanceof ReferenceObject) { // TRUE
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        // Karena menunjuk ke memory yang sama
        // hasilnya sama dengan object1
        object2.biodata();

        System.out.println("-----------------");

        object1.nama = "JANERA";
        System.out.println(object1.nama); // JANERA
        System.out.println(object2.nama); // JANERA

        /**
         * Output:
         * JANERA
         *
         * Kenapa? Karena:
         * object1 dan object2 = object yang sama
         */

        // Mengubah Lewat Reference object2
        object2.nama = "Murobic";
        System.out.println(object1.nama); // Murobic
        System.out.println(object2.nama); // Murobic

        // Ketika Reference Diputus
        object1 = null;
        // System.out.println(object1.nama); // Exception in thread "main"
        // java.lang.NullPointerException
        System.out.println(object2.nama); // object2 Masih aman

        // Cek object1
        // Sekarang false
        // Karena null
        if (object1 instanceof ReferenceObject) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        /**
         * Kenapa object2 Masih Bisa Dipakai
         * Karena memory masih seperti ini:
         * 
         * Memory menjadi:
         * object1 → null
         * object2 ───► [ Box Object ]
         *
         * Artinya:
         * object1 tidak lagi menunjuk object
         * tetapi object masih ada
         * karena object2 masih menunjuknya
         *
         * Jadi:
         * System.out.println(object2.nama);
         * masih aman.
         *
         * -------------------------------------
         * 
         * Apa Itu null
         * null artinya:
         * tidak menunjuk object apa pun
         *
         * Contoh:
         * Box b1 = null;
         *
         * Artinya:
         * b1 → tidak menunjuk object
         *
         * Jika kita lakukan:
         * b1.width = 10;
         *
         * akan terjadi error:
         * NullPointerException
         */

        System.out.println("----------------------------");

        // Perbandingan dengan primitive
        int a = 10;
        int b = a;

        System.out.println(a); // 10
        System.out.println(b); // 10

        b = 20;
        System.out.println(a); // 10
        System.out.println(b); // 20

        /**
         * Primitive
         * int a = 10;
         * int b = a;
         *
         * Memory:
         * a = 10
         * b = 10
         *
         * Jika:
         * b = 20;
         *
         * hasilnya:
         * a = 10
         * b = 20
         *
         * Karena primitive benar-benar di-copy.
         * atau membuat object baru
         */

    }
}
