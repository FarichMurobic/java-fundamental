package Abstract;

/*

Kadang lu pengen bikin superclass (kelas induk) yang cuma ngasih struktur umum,
tapi belum bisa ngasih implementasi lengkap untuk semua method.

Artinya:
Superclass cuma bikin “kerangka”
Detailnya diserahkan ke subclass

Contoh:
Class Figure punya method area(), tapi:
Dia gak tau cara hitung luas semua bentuk
Jadi dia cuma jadi “placeholder”

Kadang ada method yang:
gak masuk akal kalau diimplement di superclass
tapi WAJIB ada di subclass

Solusinya di Java → pakai abstract method

Abstract Method
Method tanpa isi (tanpa body):
abstract double area();
Artinya:
"Subclass WAJIB bikin implementasinya sendiri!"

Abstract Class
Kalau ada method abstract → class-nya HARUS abstract:
abstract class Figure

Aturan Penting abstract:
-Tidak bisa dibuat object (new)
-Tidak boleh ada constructor abstract
-Tidak boleh static abstract
-Bisa punya method biasa (concrete)

Intinya:
Abstract class = Blueprint setengah jadi

Bayangin:
Figure = konsep “bentuk”
Tapi:
luas lingkaran beda
luas segitiga beda
luas persegi panjang beda

Jadi superclass gak bisa define area() secara umum

Kenapa gak dikasih isi aja?
Kalau dikasih isi di superclass:
Bisa jadi salah konsep
Subclass bisa lupa override
 
Abstract = maksa subclass untuk implement

*/

/*

KONSEP INTI

Ini yang HARUS DI inget:
-abstract class = tidak bisa dibuat object
-abstract method = tidak punya body
-Subclass WAJIB override abstract method

Abstract class bisa punya:
-method biasa 
-constructor

Abstract vs Method Biasa:
Method biasa	        Abstract method
Ada isi	                Tidak ada isi
Optional override	    WAJIB override
Bisa dipakai langsung	Harus diimplement

Hubungan ke dunia nyata (biar kebayang)

Misal:
abstract class Pembayaran {
abstract void bayar();
}

Subclass:
QRIS
Cash
E-Wallet

Semua punya cara bayar beda

Tapi sistem kasir cukup panggil:
pembayaran.bayar();

Ini powerful banget bro

*/

/*

Abstract Method dengan Parameter

Abstract method itu cuma:
gak punya body
tapi boleh punya parameter

Contoh:
abstract class BangunDatar {
abstract double luas(double a, double b); // pakai parameter
}

Artinya:
"Siapapun subclass-nya, harus implement method ini dengan parameter a dan b"

Implementasi di Subclass
Subclass WAJIB:
nama method sama
jumlah & tipe parameter sama

*/

/**
 * Syarat-Syarat Abstract Method (WAJIB TAU)
 * 
 * 1. Tidak punya body
 * abstract void tes(); // benar
 * 
 * Salah:
 * abstract void tes() { } // ERROR
 * 
 * 2. Harus di dalam abstract class
 * abstract class A {
 *      abstract void x();
 * }
 * 
 * 3. Harus dioverride subclass
 * Kalau tidak:
 * class B extends A {
 * // ERROR kalau gak implement x()
 * }
 * 
 * Solusi:
 * implement
 * ATAU 
 * jadikan subclass abstract juga!
 * 
 * 4. Signature HARUS sama
 * 
 * abstract class A {
 *      abstract void test(int a);
 * }
 * 
 * Subclass:
 * class B extends A {
 *      void test(int a) { // HARUS sama
 *          System.out.println(a);
 *     }
 * }
 * 
 * 5. Tidak boleh abstract + static
 * abstract static void test(); // ERROR
 * 
 * 6. Tidak boleh abstract + final
 * abstract final void test(); // ERROR
 * Kenapa?
 * abstract → harus dioverride
 * final → tidak boleh dioverride
 * jadi konflik!
 * 
 * Ringkasan:
 * -Abstract method boleh punya parameter
 * -Subclass HARUS implement dengan signature sama
 * -Tidak boleh punya body
 * -Tidak bisa static/final
 */

@Anotasi("Anotasi")
@interface Anotasi {
    String value();
}

@Anotasi("Deklarasi Abstract class")
// Class abstract (tidak bisa dibuat object)
abstract class A {

    @Anotasi("Constructor Abstract")
    // Bisa punya constructor
    A() {
        System.out.println("Abstract class bisa punya constructor.");
    }

    @Anotasi("Method Abstract")
    // Method abstract tidak punya body/isi
    abstract void display();
    
    @Anotasi("Method Biasa dalam Class Abstract")
    // Class abstract bisa punya method biasa
    void methodBiasa() {
        System.out.println("class Abstract bisa punya method biasa!");
    }
}

@Anotasi("Subclass dari abstrac class A")
// Subclass dari class abstract (wajib implement method abstract)
class B extends A {

    @Anotasi("Constructor dari Subclass")
    // Constructor
    B() {
        System.out.println("Constructor Class B");
    }

    @Anotasi("Implement dari method abstract")
    // Implement method abstract dari class A
    @Override
    void display() {
        System.out.println("Hello ini implementasi method abstract dari class A.");
    }

    @Anotasi("Method Biasa")
    void methodB() {
        System.out.println("Ini method biasa class B");
    }
}

@Anotasi("Class Main App")
public class AbstractJava {
    public static void main(String[] args) {

        // class abstract tidak bisa dibuat objek!
        // A objectA = new A();
        @Anotasi("Buat objek dari Subclass (class B)")
        B objectB = new B();

        objectB.display();
        objectB.methodBiasa();
        objectB.methodB();

        /**
         * OUTPUT:
         * 
         * Abstract class bisa punya constructor.
         * Constructor Class B
         * Hello ini implementasi method abstract dari class A.
         * class Abstract bisa punya method biasa!
         * Ini method biasa class B
         */
        
    }
}
