package FundamentalJava.ClassAndObject;

/**
 * ---------------------------------------------------------------------------
 * CLASS (DASAR OBJECT-ORIENTED PROGRAMMING DI JAVA)
 * ---------------------------------------------------------------------------
 *
 * Class merupakan konsep paling fundamental dalam Java.
 *
 * Seluruh program Java dibangun menggunakan class karena class
 * menjadi dasar dari paradigma Object-Oriented Programming (OOP)..
 *
 * Secara sederhana:
 *
 * - Class mendefinisikan bentuk dan perilaku object.
 * - Object merupakan instance (wujud nyata) dari class.
 *
 * Karena itu, hampir semua konsep yang dibuat dalam Java akan
 * dibungkus (encapsulated) ke dalam sebuah class.
 *
 * ---------------------------------------------------------------------------
 * CLASS DAN OBJECT
 * ---------------------------------------------------------------------------
 *
 * Hubungan antara class dan object sering dijelaskan sebagai:
 *
 * Class -> Blueprint / Cetakan
 * Object -> Hasil yang dibuat dari blueprint tersebut
 *
 * Analogi dunia nyata:
 *
 * Class -> Cetakan Mobil
 * Object -> Mobil Avanza
 * Object -> Mobil BMW
 * Object -> Mobil Tesla
 *
 * Semua mobil memiliki karakteristik dasar yang sama karena
 * dibuat dari cetakan yang sama, tetapi setiap mobil tetap
 * merupakan object yang berbeda.
 *
 * Analogi dalam Java:
 *
 * Class -> Car
 * Object -> car1
 * Object -> car2
 * Object -> car3
 *
 * Flow:
 *
 * Class
 * -> Membuat Object
 * -> Object Menjadi Instance Dari Class
 *
 * ---------------------------------------------------------------------------
 * CLASS ADALAH TIPE DATA BARU
 * ---------------------------------------------------------------------------
 *
 * Java memiliki tipe data bawaan (primitive type), seperti:
 *
 * - byte
 * - short
 * - int
 * - long
 * - float
 * - double
 * - char
 * - boolean
 *
 * Selain tipe bawaan tersebut, programmer dapat membuat tipe data
 * baru menggunakan class.
 *
 * Contoh:
 *
 * class Car {
 * }
 *
 * Setelah class dibuat, Car menjadi tipe data baru yang dapat
 * digunakan seperti tipe data lainnya.
 *
 * Contoh:
 *
 * Car mobil1;
 * Car mobil2;
 *
 * Pada contoh di atas:
 *
 * - mobil1 bertipe Car.
 * - mobil2 bertipe Car.
 *
 * Dengan demikian:
 *
 * Class mendefinisikan tipe data baru yang dapat digunakan untuk
 * membuat object.
 *
 * ---------------------------------------------------------------------------
 * STRUKTUR UMUM CLASS
 * ---------------------------------------------------------------------------
 *
 * Bentuk umum sebuah class:
 *
 * class ClassName {
 *
 * type instanceVariable1;
 * type instanceVariable2;
 *
 * returnType method1(parameterList) {
 * // isi method
 * }
 *
 * returnType method2(parameterList) {
 * // isi method
 * }
 * }
 *
 * Sebuah class umumnya terdiri dari:
 *
 * - Instance Variable (data).
 * - Method (perilaku/aksi).
 *
 * ---------------------------------------------------------------------------
 * INSTANCE VARIABLE
 * ---------------------------------------------------------------------------
 *
 * Instance Variable adalah variabel yang dimiliki oleh object.
 *
 * Contoh:
 *
 * class Car {
 * int speed;
 * int gear;
 * }
 *
 * Pada contoh di atas:
 *
 * - speed adalah instance variable.
 * - gear adalah instance variable.
 *
 * Instance variable digunakan untuk menyimpan state atau kondisi
 * object.
 *
 * ---------------------------------------------------------------------------
 * METHOD
 * ---------------------------------------------------------------------------
 *
 * Method adalah fungsi yang berada di dalam class.
 *
 * Method digunakan untuk mendefinisikan perilaku (behavior)
 * object.
 *
 * Contoh:
 *
 * void accelerate() {
 * speed = speed + 10;
 * }
 *
 * Method di atas bertugas menambah kecepatan object.
 *
 * Dengan demikian:
 *
 * Data
 * -> Instance Variable
 *
 * Perilaku
 * -> Method
 *
 * ---------------------------------------------------------------------------
 * CLASS MEMBER
 * ---------------------------------------------------------------------------
 *
 * Instance variable dan method secara umum disebut:
 *
 * Class Member
 *
 * atau:
 *
 * Members of the Class
 *
 * Contoh:
 *
 * class Car {
 *
 * int speed; // Class Member
 * int gear; // Class Member
 *
 * void accelerate() { // Class Member
 * speed++;
 * }
 * }
 *
 * Jadi:
 *
 * Class Member
 * -> Variable
 * -> Method
 *
 * ---------------------------------------------------------------------------
 * MENGAPA DISEBUT INSTANCE VARIABLE?
 * ---------------------------------------------------------------------------
 *
 * Disebut Instance Variable karena setiap object memiliki salinan
 * (copy) variabelnya sendiri.
 *
 * Contoh:
 *
 * Car car1 = new Car();
 * Car car2 = new Car();
 *
 * Flow:
 *
 * car1
 * -> speed milik car1
 * -> gear milik car1
 *
 * car2
 * -> speed milik car2
 * -> gear milik car2
 *
 * Perubahan pada car1 tidak otomatis mempengaruhi car2.
 *
 * Setiap object memiliki state yang terpisah.
 *
 * ---------------------------------------------------------------------------
 * SIMPLE CLASS (CLASS SEDERHANA)
 * ---------------------------------------------------------------------------
 *
 * Contoh class sederhana:
 *
 * class Box {
 * double width;
 * double height;
 * double depth;
 * }
 *
 * Class Box memiliki tiga instance variable:
 *
 * - width
 * - height
 * - depth
 *
 * Pada tahap ini, Box belum memiliki method.
 *
 * Class tersebut hanya mendefinisikan struktur data.
 *
 * ---------------------------------------------------------------------------
 * DEKLARASI CLASS BUKAN MEMBUAT OBJECT
 * ---------------------------------------------------------------------------
 *
 * Salah satu hal yang sangat penting untuk dipahami:
 *
 * Deklarasi class tidak membuat object.
 *
 * Contoh:
 *
 * class Box {
 * double width;
 * double height;
 * double depth;
 * }
 *
 * Kode di atas hanya membuat blueprint atau template.
 *
 * Belum ada object yang dibuat.
 *
 * ---------------------------------------------------------------------------
 * MEMBUAT OBJECT DARI CLASS
 * ---------------------------------------------------------------------------
 *
 * Untuk membuat object digunakan operator:
 *
 * new
 *
 * Contoh:
 *
 * Box myBox = new Box();
 *
 * Flow:
 *
 * Class Box
 * -> Operator new
 * -> Object Dibuat
 * -> Reference Disimpan Ke myBox
 *
 * Setelah perintah tersebut dijalankan:
 *
 * - Object Box dibuat di memory.
 * - myBox menyimpan reference ke object tersebut.
 * - myBox menjadi instance dari Box.
 *
 * ---------------------------------------------------------------------------
 * CLASS DAN OBJECT DI MEMORY
 * ---------------------------------------------------------------------------
 *
 * Contoh:
 *
 * Box myBox = new Box();
 *
 * Secara konseptual:
 *
 * myBox
 * -> Reference
 * -> Object Box
 *
 * Object Box:
 *
 * width = 0.0
 * height = 0.0
 * depth = 0.0
 *
 * Nilai default diberikan secara otomatis oleh Java.
 *
 * ---------------------------------------------------------------------------
 * SATU FILE DAN HASIL COMPILATION
 * ---------------------------------------------------------------------------
 *
 * Dalam Java, kita dapat menulis beberapa class dalam satu file
 * source code.
 *
 * Contoh:
 *
 * class A {
 * }
 *
 * class B {
 * }
 *
 * class C {
 * }
 *
 * Setelah proses compile:
 *
 * javac Main.java
 *
 * Java akan menghasilkan file:
 *
 * A.class
 * B.class
 * C.class
 *
 * Setiap class akan dikompilasi menjadi bytecode tersendiri.
 *
 * ---------------------------------------------------------------------------
 * CATATAN JAVA MODERN
 * ---------------------------------------------------------------------------
 *
 * Pada Java modern, sebuah class biasanya berisi:
 *
 * - Field (instance variable).
 * - Constructor.
 * - Method.
 *
 * Contoh sederhana:
 *
 * class Car {
 *
 * private String brand;
 *
 * public Car(String brand) {
 * this.brand = brand;
 * }
 *
 * public void start() {
 * System.out.println("Car started");
 * }
 * }
 *
 * Namun konsep dasarnya tetap sama:
 *
 * Class
 * -> Mendefinisikan Data dan Perilaku Object
 *
 * ---------------------------------------------------------------------------
 * KESIMPULAN
 * ---------------------------------------------------------------------------
 *
 * Class adalah blueprint atau cetakan yang digunakan untuk
 * membuat object.
 *
 * Object adalah instance dari sebuah class.
 *
 * Class mendefinisikan:
 *
 * - Data (Instance Variable).
 * - Perilaku (Method).
 *
 * Instance variable dan method disebut:
 *
 * Class Member.
 *
 * Deklarasi class hanya membuat template dan tidak membuat object.
 *
 * Untuk membuat object digunakan operator:
 *
 * new
 *
 * Flow utama:
 *
 * Class
 * -> Blueprint
 * -> new
 * -> Object
 * -> Instance Dari Class
 *
 * Karena seluruh konsep OOP dibangun di atas class, memahami
 * class dengan baik merupakan fondasi penting untuk mempelajari
 * Java, OOP, Collection Framework, Spring Framework, dan berbagai
 * teknologi Java lainnya.
 */

class Car { // Deklarasi class
    int speed; // instance variabel
    int gear; // instance variabel

    void accelerate() { // Method
        speed = speed + 10;
    }

    // Instance variabel dan methode adalah member dari clas
}

class Box { // Deklarasi class
    double panjang; // instance variabel
    double lebar; // instance variabel
    double tinggi; // instance variabel

    void volumeDimensi() { // Method
        // Rumus volume barang di JNE
        double volume = panjang * lebar * tinggi / 6000;
        System.out.println(volume);
    }
}

public class ClassJava { // Deklarasi class
    public static void main(String[] args) {

        // Membuat objek dari kelas Car
        // Car menjadi tipe data dari mobil untuk membuat objek.
        Car car = new Car();

        // Type reference (car)
        car.speed = 50;
        car.accelerate();
        System.out.println(car.speed); // 60

        System.out.println("-----------------------");

        // Membuat objek dari kelas Box
        Box box = new Box();

        // Type reference (box)
        box.panjang = 50.4;
        box.lebar = 47.6;
        box.tinggi = 78.2;

        box.volumeDimensi(); // 31.267488000000004

    }
}
