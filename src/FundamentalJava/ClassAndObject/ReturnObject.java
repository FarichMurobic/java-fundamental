package FundamentalJava.ClassAndObject;

/**
 * ------------------------------------------------------------
 * RETURNING OBJECTS
 * ------------------------------------------------------------
 *
 * Sebuah method di Java dapat mengembalikan berbagai jenis nilai,
 * termasuk object yang dibuat dari class buatan kita sendiri..
 *
 * Selama sebuah class merupakan tipe data yang valid, object dari
 * class tersebut dapat digunakan sebagai return value dari method.
 *
 * Contoh sederhana:
 *
 * class Test {
 * int a;
 *
 * Test(int i) {
 * a = i;
 * }
 *
 * Test incrByTen() {
 * Test temp = new Test(a + 10);
 * return temp;
 * }
 * }
 *
 * Pada contoh di atas, method incrByTen() tidak mengembalikan
 * primitive type seperti int atau double, tetapi mengembalikan
 * object bertipe Test.
 *
 * ------------------------------------------------------------
 * KONSEP DASAR RETURN OBJECT
 * ------------------------------------------------------------
 *
 * Ketika sebuah method mengembalikan object:
 *
 * - Method membuat object baru.
 * - Method mengembalikan reference object tersebut.
 * - Pemanggil menerima reference yang dikembalikan.
 *
 * Yang sebenarnya dikembalikan bukan object secara langsung,
 * melainkan reference yang menunjuk ke object tersebut.
 *
 * Flow:
 *
 * Method Dipanggil
 * -> Object Baru Dibuat
 * -> Reference Object Dikembalikan
 * -> Reference Diterima Pemanggil
 *
 * ------------------------------------------------------------
 * ALUR KERJA CONTOH incrByTen()
 * ------------------------------------------------------------
 *
 * Misalkan:
 *
 * Test ob1 = new Test(2);
 *
 * Nilai awal:
 *
 * ob1.a = 2
 *
 * Kemudian:
 *
 * Test ob2 = ob1.incrByTen();
 *
 * Yang terjadi:
 *
 * - Method incrByTen() dijalankan.
 * - Object baru dibuat dengan nilai a + 10.
 * - Object baru memiliki nilai 12.
 * - Reference object baru dikembalikan.
 * - Reference disimpan ke ob2.
 *
 * Visualisasi:
 *
 * ob1
 * -> a = 2
 *
 * incrByTen()
 * -> Membuat Object Baru
 * -> a = 12
 * -> return reference
 *
 * ob2
 * -> a = 12
 *
 * ------------------------------------------------------------
 * SETIAP PEMANGGILAN MEMBUAT OBJECT BARU
 * ------------------------------------------------------------
 *
 * Hal penting yang harus dipahami:
 *
 * Setiap kali method incrByTen() dipanggil,
 * object baru akan dibuat.
 *
 * Contoh:
 *
 * Test ob1 = new Test(2);
 *
 * Test ob2 = ob1.incrByTen();
 *
 * Test ob3 = ob2.incrByTen();
 *
 * Hasil:
 *
 * ob1.a = 2
 * ob2.a = 12
 * ob3.a = 22
 *
 * Flow:
 *
 * ob1 (2)
 * -> incrByTen()
 * -> Object Baru (12)
 *
 * ob2 (12)
 * -> incrByTen()
 * -> Object Baru (22)
 *
 * ob3 (22)
 *
 * Setiap pemanggilan menghasilkan object baru yang berbeda.
 *
 * ------------------------------------------------------------
 * VISUALISASI MEMORY
 * ------------------------------------------------------------
 *
 * Kondisi Awal:
 *
 * ob1
 * |
 * v
 * [ Test ]
 * a = 2
 *
 * Setelah:
 *
 * Test ob2 = ob1.incrByTen();
 *
 * ob1
 * |
 * v
 * [ Test ]
 * a = 2
 *
 * ob2
 * |
 * v
 * [ Test ]
 * a = 12
 *
 * Sekarang terdapat dua object berbeda di memory.
 *
 * ------------------------------------------------------------
 * OBJECT ASLI TIDAK BERUBAH
 * ------------------------------------------------------------
 *
 * Method incrByTen() tidak mengubah object yang memanggilnya.
 *
 * Method tersebut membuat object baru dan mengembalikannya.
 *
 * Karena itu:
 *
 * ob1.a tetap 2
 *
 * sedangkan:
 *
 * ob2.a menjadi 12
 *
 * Ini berbeda dengan method yang langsung memodifikasi state
 * object saat ini.
 *
 * Flow:
 *
 * Object Lama
 * -> Tetap Ada
 *
 * Object Baru
 * -> Dibuat
 * -> Dikembalikan
 *
 * ------------------------------------------------------------
 * HUBUNGAN DENGAN HEAP MEMORY
 * ------------------------------------------------------------
 *
 * Semua object di Java dibuat menggunakan operator:
 *
 * new
 *
 * Contoh:
 *
 * Test temp = new Test(a + 10);
 *
 * Saat perintah tersebut dijalankan:
 *
 * - JVM mengalokasikan memory.
 * - Object dibuat di Heap Memory.
 * - Reference object dikembalikan.
 *
 * Flow:
 *
 * new
 * -> Heap Memory
 * -> Object Dibuat
 * -> Reference Dikembalikan
 *
 * ------------------------------------------------------------
 * GARBAGE COLLECTION
 * ------------------------------------------------------------
 *
 * Object akan tetap hidup selama masih ada reference yang
 * menunjuk kepadanya.
 *
 * Contoh:
 *
 * ob1
 * ob2
 * ob3
 *
 * Selama reference-reference tersebut masih ada,
 * object tidak akan dihapus.
 *
 * Namun jika sebuah object tidak lagi memiliki reference,
 * object tersebut menjadi eligible for garbage collection.
 *
 * Artinya:
 *
 * Object tersebut dapat dibersihkan oleh Garbage Collector
 * ketika JVM membutuhkannya.
 *
 * ------------------------------------------------------------
 * CONTOH OBJECT MENJADI TIDAK TERPAKAI
 * ------------------------------------------------------------
 *
 * Misalkan:
 *
 * Test ob2 = ob1.incrByTen();
 *
 * Kemudian:
 *
 * ob2 = ob2.incrByTen();
 *
 * Yang terjadi:
 *
 * Awalnya:
 *
 * ob2
 * -> Object (a = 12)
 *
 * Setelah assignment kedua:
 *
 * ob2
 * -> Object Baru (a = 22)
 *
 * Object lama:
 *
 * a = 12
 *
 * tidak lagi memiliki reference.
 *
 * Akibatnya:
 *
 * Object tersebut menjadi kandidat untuk dibersihkan oleh
 * Garbage Collector.
 *
 * Flow:
 *
 * Object Lama
 * -> Tidak Memiliki Reference
 * -> Eligible For Garbage Collection
 *
 * ------------------------------------------------------------
 * JENIS RETURN VALUE DI JAVA
 * ------------------------------------------------------------
 *
 * Method Java dapat mengembalikan:
 *
 * - Primitive Type
 * - Object
 * - Array
 * - Enum
 * - Interface Type
 * - Class Type
 * - Record (Java Modern)
 *
 * Contoh:
 *
 * int getNumber()
 *
 * String getName()
 *
 * int[] getNumbers()
 *
 * Test getObject()
 *
 * Semua bentuk tersebut valid sebagai return value.
 *
 * ------------------------------------------------------------
 * INSIGHT OOP
 * ------------------------------------------------------------
 *
 * Mengembalikan object merupakan salah satu teknik yang sangat
 * penting dalam Object-Oriented Programming.
 *
 * Teknik ini sering digunakan untuk:
 *
 * - Factory Method
 * - Builder Pattern
 * - Method Chaining
 * - Immutable Object
 * - Functional Programming Style
 *
 * Banyak framework modern seperti Spring dan Hibernate
 * juga sering menggunakan konsep return object.
 *
 * ------------------------------------------------------------
 * ISTILAH PENTING
 * ------------------------------------------------------------
 *
 * Return Value
 * -> Nilai yang dikembalikan method.
 *
 * Reference
 * -> Penunjuk ke object.
 *
 * Heap Memory
 * -> Area memory tempat object disimpan.
 *
 * Garbage Collector (GC)
 * -> Mekanisme otomatis JVM untuk membersihkan object
 * yang tidak lagi digunakan.
 *
 * Eligible For Garbage Collection
 * -> Object sudah tidak memiliki reference dan dapat
 * dibersihkan oleh JVM.
 *
 * ------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------
 *
 * Method di Java dapat mengembalikan object sebagaimana
 * mengembalikan tipe data lainnya.
 *
 * Dalam proses ini:
 *
 * - Object baru biasanya dibuat menggunakan new.
 * - Reference object dikembalikan oleh method.
 * - Pemanggil menerima reference tersebut.
 *
 * Flow utama:
 *
 * Method Dipanggil
 * -> Object Baru Dibuat
 * -> Reference Dikembalikan
 * -> Reference Disimpan Pemanggil
 *
 * Setiap pemanggilan method dapat menghasilkan object baru
 * yang berbeda, dan object akan tetap hidup selama masih ada
 * reference yang menunjuk kepadanya.
 *
 * Jika tidak ada reference yang tersisa:
 *
 * Object
 * -> Eligible For Garbage Collection
 * -> Dibersihkan Oleh JVM (Saat Diperlukan)
 */

public class ReturnObject {

    // Instance variabe;
    int a;

    // Constructor
    ReturnObject(int i) {
        this.a = i;
    }

    // Method return Objek
    ReturnObject incrByTen() {

        // Buat objek di dalam method
        ReturnObject temp = new ReturnObject(this.a + 10);
        return temp;
    }

    public static void main(String[] args) {

        ReturnObject ob1 = new ReturnObject(2);
        ReturnObject ob2;

        // Memanggil method objek
        ob2 = ob1.incrByTen();

        System.out.println("ob1.a: " + ob1.a); // 2
        System.out.println("ob2.a: " + ob2.a); // 12

        ob2 = ob2.incrByTen();
        System.out.println("ob.2.a after second increase: " + ob2.a); // 22

        /**
         * Output
         * ob1.a: 2
         * ob2.a: 12
         * ob2.a after second increase: 22
         *
         * Penjelasan Konsep
         * Di program ini:
         * Method:
         * incrByTen()
         * mengembalikan object bertipe ReturnObject.
         * 
         * Perhatikan deklarasi methodnya:
         * ReturnObject incrByTen()
         * 
         * Artinya:
         * method ini mengembalikan object ReturnObject
         *
         * Analisis Method incrByTen()
         * Isi method:
         * ReturnObject temp = new ReturnObject(a + 10);
         * 
         * Object baru dibuat dengan nilai:
         * a + 10
         *
         * Misalnya object awal punya:
         * a = 2
         *
         * Maka object baru:
         * a = 12
         *
         * Kemudian method mengembalikan object tersebut:
         * return temp;
         *
         * Yang dikembalikan sebenarnya adalah reference object temp.
         *
         * --------------------------------------------------
         * 
         * Alur Program Saat Dijalankan
         * 
         * 1️ Membuat object pertama
         * ReturnObject ob1 = new ReturnObject(2);
         * 
         * Isi object:
         * ob1
         * a = 2
         *
         * 2️ Memanggil method
         * ob2 = ob1.incrByTen();
         * 
         * Java menjalankan:
         * incrByTen()
         * 
         * Langkah di dalam method:
         * temp = new ReturObject(2 + 10)
         * 
         * Object baru dibuat:
         * temp
         * a = 12
         * 
         * Kemudian:
         * return temp
         * Sehingga:
         * ob2 → object baru
         * a = 12
         *
         * 3️ Print nilai
         * ob1.a: 2
         * ob2.a: 12
         *
         * Perhatikan:
         * ob1 tidak berubah
         * Karena method membuat object baru.
         *
         * 4️ Pemanggilan kedua
         * ob2 = ob2.incrByTen();
         * Sekarang:
         * ob2.a = 12
         * 
         * Method membuat object baru:
         * 12 + 10 = 22
         * Object baru:
         * a = 22
         */
    }
}
