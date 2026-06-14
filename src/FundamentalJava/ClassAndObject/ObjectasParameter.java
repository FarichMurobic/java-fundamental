package FundamentalJava.ClassAndObject;

/*

Using Objects as Parameters

Sejauh ini kita hanya menggunakan tipe data sederhana (simple types) sebagai parameter method.
Contoh:
int
double
boolean

Namun sebenarnya sangat umum dan benar untuk mengirim object ke method sebagai parameter.

Invoking Object
Object yang memanggil method.

Contoh:
ob1.equalTo(ob2)
invoking object → ob1
parameter object → ob2

Method bisa menerima:
primitive type
atau
object

Contoh:
primitive
void tambah(int a)
object
void compare(Test t)

Ini adalah dasar komunikasi antar object di OOP
oject sebagai Parameter Constructor
Buku kemudian menjelaskan penggunaan object sebagai parameter constructor.

Tujuannya:
-> membuat object baru dari object yang sudah ada
Ini disebut Copy Constructor.

Contoh dari Buku
Class Box diperbarui.
Box(Box ob)
Constructor ini menerima object Box lain.

*/

// Contoh objek sebagai parameter di method
class Objek {
    int a, b;

    Objek(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // Object as parameter
    // returnnya harus objek juga!
    boolean equalTo(Objek objek) {
        if (objek.a == a && objek.b == b) {
            return true;
        } else {
            return false;
        }
    }
}

// Contoh objek sebagai parameter di konstruktor
// COPY CONSTRUCTOR
class Bok {
    double panjang;
    double lebar;
    double tinggi;

    // Konstruktor dengan parameter objek
    // COPY CONSTRUCTOR
    Bok(Bok ob) {   // Objek as parameter
        panjang = ob.panjang;
        lebar = ob.lebar;
        tinggi = ob.tinggi;
    }

    // Konstruktor biasa
    Bok(double p, double l, double t) {
        this.panjang = p;
        this.lebar = l;
        this.tinggi = t;
    }

    // Konstruktor kosong (default)
    Bok() {
        panjang = -1;
        lebar = -1;
        tinggi = -1;
    }

    // Konstruktor untuk kubus
    Bok(double len) {
        panjang = lebar = tinggi = len;
    }

    // Method untuk menghitung volume
    double volume() {
        return panjang * lebar * tinggi;
    }
}

public class ObjectasParameter {
    public static void main(String[] args) {
        
        // Membuat object
        Objek objek1 = new Objek(10, 22);
        Objek objek2 = new Objek(10, 22);
        Objek objek3 = new Objek(-1, -1);

        // Ini gunanya object sebagai parameter methode.
        System.out.println("objek1 == objek2: " + objek1.equalTo(objek2)); // true
        System.out.println("objek1 == objek3: " + objek1.equalTo(objek3)); // false

        /**
         * Penjelasan Konsep
         *
         * Di program ini ada method:
         * equalTo(Objek objek)
         * Parameter objek bukan int atau double, tetapi object dari class Objek.
         *
         * Artinya method menerima object sebagai input.
         * 
         * Contoh:
         * Struktur class Test
         * 
         * class Test {
         *
         *   int a, b;
         *
         * Class memiliki dua variabel:
         * a
         * b
         *
         * Constructor
         * Test(int i, int j)
         * Digunakan untuk memberi nilai pada object.
         *
         * Misalnya:
         * Test ob1 = new Test(100,22);
         *
         * Maka:
         * a = 100
         * b = 22
         * 
         * 4. Method equalTo()
         * boolean equalTo(Objek objek)
         *
         * Method ini menerima object Objek lain.
         *
         * Tujuannya:
         * ➡ membandingkan dua object
         *
         * Isi Method
         * if(objek.a == a && objek.b == b)
         *
         * Artinya:
         * nilai a dari object objek == nilai a object sekarang
         * DAN
         * nilai b dari object objek == nilai b object sekarang
         *
         * Jika sama:
         * return true
         *
         * Jika tidak:
         * return false
         */

        System.out.println("--------------------------------");

        // Copy constructor
        // Objek as parameter
        Bok bok1 = new Bok(10, 20, 15);
        Bok bok2 = new Bok();
        Bok kubus = new Bok(7);
        Bok clone = new Bok(bok1); // Copy constructor

        double vol;

        vol = bok1.volume();
        System.out.println("Box 1: " + vol);

        vol = bok2.volume();
        System.out.println("Box 2: " + vol);

        vol = kubus.volume();
        System.out.println("Kubus: " + vol);

        vol = clone.volume();
        System.out.println("Cloning: " + vol);

        /**
         * Penjelasan Copy Constructor
         *
         * Baris ini penting:
         * Box clone = new Bok(bok1);
         *
         * Artinya:
         * buat object baru
         * dengan nilai sama seperti bok1
         *
         * Isi constructor:
         * Bok(Bok ob)
         *
         * Menyalin nilai:
         * panjang = ob.panjang
         * lebar = ob.lebar
         * tinggi = ob.tinggi
         *
         * Jadi:
         * clone == copy bok1
         *
         * Kenapa Ini Penting di Dunia Nyata
         * 
         * Di Java profesional ini sering dipakai untuk:
         * copy object
         * clone data
         * transfer object antar method
         * design pattern
         */
    }
}


