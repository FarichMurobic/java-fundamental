package FundamentalJava.Methods.MethodOverloading;

/*
 * ============================================================
 * Method Overloading Pada Java
 * ============================================================
 *
 * Java memungkinkan sebuah class memiliki beberapa method dengan
 * nama yang sama selama method tersebut memiliki parameter yang
 * berbeda.
 *
 * Konsep ini disebut:
 *
 * Method Overloading
 *
 * Method overloading terjadi ketika beberapa method memiliki:
 *
 * - Nama method yang sama.
 * - Parameter yang berbeda.
 *
 * Contoh:
 *
 * void print() {
 * }
 *
 * void print(int angka) {
 * }
 *
 * void print(int angka1, int angka2) {
 * }
 *
 * Ketiga method tersebut memiliki nama yang sama yaitu print(),
 * tetapi Java dapat membedakannya berdasarkan parameter yang
 * diberikan.
 *
 * ------------------------------------------------------------
 * Pengertian Method Overloading
 * ------------------------------------------------------------
 *
 * Method overloading adalah kemampuan Java untuk memiliki
 * beberapa method dengan nama yang sama tetapi memiliki signature
 * method yang berbeda.
 *
 * Method signature terdiri dari:
 *
 * - Nama method.
 * - Jumlah parameter.
 * - Tipe data parameter.
 * - Urutan parameter.
 *
 * Return type tidak termasuk dalam method signature.
 *
 * ------------------------------------------------------------
 * Contoh Method Overloading
 * ------------------------------------------------------------
 *
 * class Calculator {
 *
 *     int tambah(int a, int b) {
 *         return a + b;
 *     }
 *
 *     double tambah(double a, double b) {
 *         return a + b;
 *     }
 *
 *     int tambah(int a, int b, int c) {
 *         return a + b + c;
 *     }
 * }
 *
 * Semua method memiliki nama:
 *
 * tambah()
 *
 * Tetapi Java membedakannya berdasarkan parameter.
 *
 * ------------------------------------------------------------
 * Bagaimana Java Menentukan Method Yang Dipanggil?
 * ------------------------------------------------------------
 *
 * Java menentukan method yang cocok berdasarkan:
 *
 * 1. Jumlah parameter.
 *
 * Contoh:
 *
 * test()
 *
 * Berbeda dengan:
 *
 * test(int a)
 *
 *
 * 2. Tipe parameter.
 *
 * Contoh:
 *
 * test(int angka)
 *
 * Berbeda dengan:
 *
 * test(double angka)
 *
 *
 * 3. Urutan parameter.
 *
 * Contoh:
 *
 * test(int a, double b)
 *
 * Berbeda dengan:
 *
 * test(double a, int b)
 *
 * ------------------------------------------------------------
 * Return Type Tidak Menentukan Overloading
 * ------------------------------------------------------------
 *
 * Return type tidak dapat digunakan sebagai pembeda method
 * overloading.
 *
 * Contoh salah:
 *
 * int test(int a) {
 *     return a;
 * }
 *
 * double test(int a) {
 *     return a;
 * }
 *
 * Error:
 *
 * Karena parameter kedua method sama.
 *
 * Java tidak dapat menentukan method mana yang harus dipanggil
 * hanya berdasarkan return type.
 *
 * ------------------------------------------------------------
 * Automatic Type Conversion Dalam Overloading
 * ------------------------------------------------------------
 *
 * Java dapat melakukan konversi tipe data otomatis ketika mencari
 * method yang paling sesuai.
 *
 * Contoh:
 *
 * class Demo {
 *
 *     void test(double angka) {
 *         System.out.println(angka);
 *     }
 * }
 *
 *
 * Pemanggilan:
 *
 * int nilai = 88;
 *
 * demo.test(nilai);
 *
 * Tidak terdapat method:
 *
 * test(int)
 *
 * Tetapi Java dapat melakukan widening conversion:
 *
 * int
 *  |
 *  v
 * double
 *
 * Sehingga method:
 *
 * test(double)
 *
 * tetap dapat dipanggil.
 *
 * Output:
 *
 * 88.0
 *
 * ------------------------------------------------------------
 * Urutan Pemilihan Method Overloading
 * ------------------------------------------------------------
 *
 * Ketika Java mencari method yang cocok, compiler mencoba
 * mencari kecocokan terbaik.
 *
 * Prioritas umum:
 *
 * 1. Exact match
 *
 * Contoh:
 *
 * test(int)
 *
 * dipanggil dengan:
 *
 * test(10)
 *
 *
 * 2. Widening conversion
 *
 * Contoh:
 *
 * int -> double
 *
 *
 * 3. Boxing / unboxing
 *
 * Contoh:
 *
 * int -> Integer
 *
 *
 * 4. Varargs
 *
 * Contoh:
 *
 * test(int...)
 *
 * ------------------------------------------------------------
 * Parameter dan Argument
 * ------------------------------------------------------------
 *
 * Parameter dan argument memiliki perbedaan.
 *
 * Parameter:
 *
 * Variabel yang ditulis dalam deklarasi method.
 *
 * Contoh:
 *
 * void test(int angka) {
 * }
 *
 * angka adalah parameter.
 *
 *
 * Argument:
 *
 * Nilai yang dikirim ketika method dipanggil.
 *
 * Contoh:
 *
 * test(10);
 *
 * 10 adalah argument.
 *
 * Alur:
 *
 * argument
 *      |
 *      v
 * parameter
 *      |
 *      v
 * proses method
 *
 * ------------------------------------------------------------
 * Method Overloading dan Polymorphism
 * ------------------------------------------------------------
 *
 * Method overloading merupakan salah satu bentuk polymorphism
 * dalam Java.
 *
 * Lebih tepatnya:
 *
 * Method overloading disebut:
 *
 * Compile-time polymorphism
 *
 * Karena keputusan method mana yang dipanggil dilakukan oleh
 * compiler sebelum program dijalankan.
 *
 * Contoh:
 *
 * print()
 * print(int)
 * print(double)
 *
 * Satu nama method memiliki beberapa bentuk perilaku.
 *
 * ------------------------------------------------------------
 * Perbedaan Overloading dan Overriding
 * ------------------------------------------------------------
 *
 * Method Overloading:
 *
 * - Terjadi dalam class yang sama.
 * - Nama method sama.
 * - Parameter berbeda.
 * - Diputuskan saat compile time.
 *
 *
 * Method Overriding:
 *
 * - Terjadi ketika subclass mengganti implementasi method dari
 *   parent class.
 * - Nama dan parameter harus sama.
 * - Berkaitan dengan runtime polymorphism.
 *
 * ------------------------------------------------------------
 * Catatan Penting
 * ------------------------------------------------------------
 *
 * Hati-hati dengan overloading menggunakan null.
 *
 * Contoh:
 *
 * void test(String value) {
 * }
 *
 * void test(Integer value) {
 * }
 *
 * Pemanggilan:
 *
 * test(null);
 *
 * Akan menyebabkan ambiguity karena Java tidak tahu method mana
 * yang harus dipilih.
 *
 * ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * Method overloading memungkinkan Java memiliki beberapa method
 * dengan nama yang sama dalam satu class.
 *
 * Aturan utama:
 *
 * - Nama method boleh sama.
 * - Parameter harus berbeda.
 * - Perbedaan dapat berupa jumlah, tipe, atau urutan parameter.
 * - Return type tidak dapat digunakan untuk overloading.
 * - Java menentukan method berdasarkan parameter saat compile.
 *
 * Method overloading membantu membuat kode lebih:
 *
 * - Fleksibel.
 * - Mudah digunakan.
 * - Mendukung konsep polymorphism dalam OOP.
 *
 */

public class MethodOverloading {

    void test() { // no parameter
        System.out.println("Tanpa parameter.");
    }

    void test(int a) { // dengan parameter int a
        System.out.println("a: " + a);
    }

    void  test(int a, int b) { // dengan parameter int a dan b
        System.out.println("a dan b" + a + " " + b);
    }

    double test(double a) { // dengan parameter double a
        System.out.println("double a: " + a);
        return a;
    }

    public static void main(String[] args) {

        MethodOverloading overload = new MethodOverloading();
        double hasil;

        // Memanggil semua versi methode. ini yang disebut (Methode Overloading)
        overload.test(); // Methode tanpa parameter
        overload.test(10); // Methode dengan parameter int a
        overload.test(10, 20); // Methode dengan parameter int a dan b
        // Return value double
        hasil = overload.test(1000.0);

    }
}
