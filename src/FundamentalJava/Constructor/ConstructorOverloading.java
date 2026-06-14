package FundamentalJava.Constructor;

     /**
     * Overloading Constructors
     * Selain melakukan overloading pada method biasa, kita juga bisa melakukan overloading pada constructor.
     * Bahkan, dalam kebanyakan class dunia nyata, constructor yang di-overload adalah hal yang normal, bukan pengecualian.
     *
     * Artinya kita bisa membuat beberapa konstruktor dengan nama parameter berbeda.
     *
     * Konsep Penting dari Materi Ini
     * Constructor juga bisa di-overload
     * 1. Sama seperti method.
     * 2. Constructor dipilih berdasarkan parameter
     * Contoh:
     * new Box()
     * new Box(7)
     * new Box(10,20,30)
     * Java memilih constructor yang sesuai.
     * 3. Overloaded constructor sangat sering digunakan
     * Di dunia nyata hampir semua class punya beberapa constructor.
     *
     * Constructor bukan method biasa.
     * Ciri-ciri constructor:
     * Nama sama dengan class
     * Tidak punya return type
     * Dipanggil saat object dibuat
     */

public class ConstructorOverloading {
    // variabel instance
    double width;
    double height;
    double depth;

    // Konstruktor dengan parameter w,h,d
    ConstructorOverloading(double w, double h, double d) {
        width = w;
        height = h;
        depth = d;
    }

    // konstruktor tanpa parameter
    ConstructorOverloading() {
        width = -1;
        height = -1;
        depth = -1;
    }

    // konstruktor dengan parameter len
    ConstructorOverloading(double len) {
        width = height = depth = len;
    }

    // methode return value
    double volume() {
        return width * height * depth;
    }

    public static void main(String[] args) {

        // Membuat objek dan Konstruktor berbeda. ini yang disebut (Konstruktor Overload).
        ConstructorOverloading box1 = new ConstructorOverloading(10, 20, 15);
        ConstructorOverloading box2 = new ConstructorOverloading();
        ConstructorOverloading box3 = new ConstructorOverloading(7);

        double vol;

        // volume box1
        vol = box1.volume();
        System.out.println("Volume box 1: " + vol);

        // volume box2
        vol = box2.volume();
        System.out.println("Volume box 2: " + vol);

        // volume box 3
        vol = box3.volume();
        System.out.println("Volume box 3: " + vol);
    }
}
