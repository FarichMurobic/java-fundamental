package FundamentalJava.ClassAndObject;

/*

Kita bisa mendefinisikan sebuah class di dalam class lain. 
Class seperti ini disebut nested class.
Scope (jangkauan) nested class dibatasi oleh class luar yang membungkusnya.

Jadi kalau class B ada di dalam class A:
B tidak bisa berdiri sendiri tanpa A
B bisa akses semua member A (termasuk private)
Tapi A tidak bisa akses langsung isi B

Nested class yang ditulis langsung di dalam class disebut member class.
Selain itu, nested class juga bisa dibuat di dalam blok (misalnya dalam method atau loop).

---------------------------------------------------------------------------------

Ada 2 jenis nested class:
Static nested class
Non-static nested class

1.
Static nested class:
Pakai keyword static
Tidak bisa langsung akses member non-static dari outer class
Harus lewat object

Karena ribet → jarang dipakai
Static nested class itu:

class Outer {
    static class Inner { }
}

Gak bisa langsung akses:
outer_x

Harus:
new Outer().outer_x

2.
Inner class adalah nested class yang tidak static.
Dia:
Bisa akses semua variable dan method outer class
Bisa langsung akses tanpa object tambahan

Intinya
Ini yang sering dipakai:

class Outer {
    class Inner { }
}

Inner = punya akses penuh ke Outer

---------------------------------------------------------------------

ISTILAH PENTING
Istilah	            Arti
Nested Class	    Class di dalam class
Inner Class	        Nested class non-static
Outer Class	        Class luar
Scope	            Jangkauan akses
Instance	        Object dari class

INTI DARI MATERI INI
Class bisa ada di dalam class
Inner class bisa akses semua isi outer
Outer class tidak bisa akses isi inner langsung
Inner class harus dibuat dalam konteks outer
Bisa dipakai buat bikin kode lebih rapi & modular

Kesimpulan Penting
Object bisa dibuat:
Di luar class 
Di dalam class 
Di dalam method

Tapi:
Inner class harus dalam konteks outer
Gak bisa berdiri sendiri

Cara gampang nginget
Kondisi	                        Boleh bikin object?
Class biasa	                    Bebas
Inner class dari luar	        Harus lewat Outer class
Inner class di dalam Outer	    Bebas

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
