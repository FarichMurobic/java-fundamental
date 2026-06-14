package FundamentalJava.ClassAndObject;

/*

Class adalah inti dari Java.

Class merupakan struktur logis yang menjadi dasar dari seluruh bahasa Java,
karena class menentukan bentuk dan sifat dari sebuah object.

Karena itu, class menjadi dasar dari Object-Oriented Programming (OOP) di Java.
Setiap konsep yang ingin kamu buat di program Java harus dibungkus (encapsulated) di dalam sebuah class.

Class = Blueprint / Cetakan
Object = Barang yang dibuat dari cetakan itu 

Contoh di dunia nyata:
Class  : Cetakan Mobil
Object : Mobil Avanza
Object : Mobil BMW
Object : Mobil Tesla

Semua mobil dibuat dari cetakan mobil.

Di Java:
Class  : Car
Object : car1
Object : car2
Object : car3

Jadi:
Class adalah template untuk membuat object
Dan
Object adalah instance dari class

Class Mendefinisikan Tipe Data Baru
Contoh:
Java punya tipe data bawaan:
int
double
char
boolean

Tapi kalau kita bikin class:
class Car {}

Sekarang Car juga menjadi tipe data baru.

Contoh penggunaan:
Car mobil1;
Car mobil2;

Jadi sekarang Car sama seperti int atau double.

-------------------------------------------------------

Struktur Umum Class
Buku memberi bentuk umum class:

class classname {

    type instance-variable1;
    type instance-variable2;

    type methodname1(parameter-list) {
        // isi method
    }

    type methodname2(parameter-list) {
        // isi method
    }
}

Mari kita pecah.
Bagian 1 — Instance Variable
int speed;
int gear;

Ini disebut:
instance variable

Artinya:
variable yang dimiliki oleh object.

Contoh class:

class Car {

    int speed; // instance variabel
    int gear;  // instance variabel
}

Bagian 2 — Method
Method adalah fungsi di dalam class.

Contoh:

void accelerate() {
    speed = speed + 10;
}

Jadi class bisa punya:
data  → variable
aksi  → method

Member Class

Buku bilang:
variable dan method disebut members of the class
Jadi:

Class member =
variabel
method

class Car {

    int speed; // member class
    int gear;  // member class

    void accelerate() { // member class
        speed++;
    }
}

Kenapa Disebut Instance Variable?
Karena setiap object punya salinan sendiri.

---------------------------------------------------

A Simple Class
Mari mulai mempelajari class dengan contoh sederhana.

Berikut adalah class bernama Box yang memiliki tiga instance variable:
width
height
depth

Untuk saat ini, class Box belum memiliki method.

class Box {
   double width;
   double height;
   double depth;
}

Seperti yang sudah dijelaskan sebelumnya, class mendefinisikan tipe data baru.
Dalam contoh ini tipe data barunya adalah Box.

Nama ini nantinya akan digunakan untuk membuat object bertipe Box.

Hal penting yang harus diingat:
deklarasi class hanya membuat template, bukan object.
Jadi kode di atas belum membuat object apa pun.
Untuk membuat object dari class Box, kita gunakan:

Box mybox = new Box();

Setelah perintah ini dijalankan, mybox menjadi instance dari Box.

Kita bisa membuat kelas dalam satu file.
namun setelah di compile akan ada beberapa file berdasarkan kelasnya.

*/

class Car {    // Deklarasi class
    int speed; // instance variabel
    int gear;  // instance variabel

    void accelerate() { // Method
        speed = speed + 10;
    }

    // Instance variabel dan methode adalah member dari clas
}

class Box {         // Deklarasi class
    double panjang; // instance variabel
    double lebar;   // instance variabel
    double tinggi;  // instance variabel

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
