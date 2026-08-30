package FundamentalJava.Methods.MethodOverriding;

/*
 * ============================================================
 * Dynamic Method Dispatch Pada Java
 * ============================================================
 *
 * Dynamic Method Dispatch adalah mekanisme Java yang menentukan
 * method overriding mana yang akan dijalankan pada saat runtime
 * (program sedang berjalan)..
 *
 * Konsep ini merupakan bagian penting dari:
 *
 * Runtime Polymorphism
 *
 * Dynamic Method Dispatch terjadi ketika:
 *
 * - Sebuah reference superclass menunjuk object subclass.
 * - Subclass melakukan override method dari superclass.
 * - Method tersebut dipanggil melalui reference superclass.
 *
 * ------------------------------------------------------------
 * Kenapa Method Overriding Penting?
 * ------------------------------------------------------------
 *
 * Method overriding bukan hanya sekadar membuat method dengan
 * nama yang sama pada subclass.
 *
 * Kekuatan sebenarnya adalah:
 *
 * Satu reference dapat memiliki banyak bentuk perilaku tergantung
 * object yang sebenarnya digunakan.
 *
 * Contoh:
 *
 * Animal animal;
 *
 * animal = new Dog();
 *
 * animal.sound();
 *
 * Walaupun variable animal bertipe Animal, object sebenarnya
 * adalah Dog.
 *
 * Maka method sound() milik Dog yang akan dijalankan.
 *
 * ------------------------------------------------------------
 * Prinsip Utama Dynamic Method Dispatch
 * ------------------------------------------------------------
 *
 * Dalam Java terdapat dua tipe yang perlu dibedakan:
 *
 * 1. Reference Type
 *
 * Tipe variable yang digunakan untuk menyimpan object.
 *
 * Contoh:
 *
 * Animal animal;
 *
 *
 * 2. Runtime Object Type
 *
 * Object sebenarnya yang dibuat menggunakan keyword new.
 *
 * Contoh:
 *
 * new Dog();
 *
 *
 * Dalam Dynamic Method Dispatch:
 *
 * Reference type menentukan:
 *
 * - Method apa yang boleh dipanggil oleh compiler.
 *
 *
 * Runtime object type menentukan:
 *
 * - Implementasi method override mana yang dijalankan.
 *
 * ------------------------------------------------------------
 * Contoh Dasar Dynamic Method Dispatch
 * ------------------------------------------------------------
 *
 * class A {
 *
 *     void callme() {
 *         System.out.println("Method A");
 *     }
 * }
 *
 *
 * class B extends A {
 *
 *     @Override
 *     void callme() {
 *         System.out.println("Method B");
 *     }
 * }
 *
 *
 * Pemanggilan:
 *
 * A reference;
 *
 * reference = new B();
 *
 * reference.callme();
 *
 *
 * Analisis:
 *
 * Reference type:
 *
 * A
 *
 * Runtime object:
 *
 * B
 *
 *
 * Hasil:
 *
 * Method B
 *
 * ------------------------------------------------------------
 * Bagaimana Java Menentukan Method?
 * ------------------------------------------------------------
 *
 * Saat compile time:
 *
 * Compiler melihat reference type.
 *
 * Contoh:
 *
 * A reference;
 *
 * Compiler memastikan bahwa class A memiliki method:
 *
 * callme()
 *
 *
 * Saat runtime:
 *
 * JVM melihat object sebenarnya.
 *
 * Object:
 *
 * new B()
 *
 * Karena B melakukan override method callme(), maka JVM
 * menjalankan implementasi milik B.
 *
 * Flow:
 *
 * Compile Time:
 *
 * reference type
 *        |
 *        v
 * menentukan method yang tersedia
 *
 *
 * Runtime:
 *
 * object sebenarnya
 *        |
 *        v
 * menentukan implementasi method
 *
 * ------------------------------------------------------------
 * Contoh Dengan Banyak Subclass
 * ------------------------------------------------------------
 *
 * class Animal {
 *
 *     void sound() {
 *         System.out.println("Animal sound");
 *     }
 * }
 *
 *
 * class Cat extends Animal {
 *
 *     @Override
 *     void sound() {
 *         System.out.println("Meow");
 *     }
 * }
 *
 *
 * class Dog extends Animal {
 *
 *     @Override
 *     void sound() {
 *         System.out.println("Bark");
 *     }
 * }
 *
 *
 * Pemanggilan:
 *
 * Animal animal;
 *
 * animal = new Cat();
 * animal.sound();
 *
 * Output:
 *
 * Meow
 *
 *
 * animal = new Dog();
 * animal.sound();
 *
 * Output:
 *
 * Bark
 *
 *
 * Satu reference Animal dapat menghasilkan perilaku berbeda
 * tergantung object yang diberikan.
 *
 * Inilah konsep polymorphism.
 *
 * ------------------------------------------------------------
 * Dynamic Method Dispatch vs Method Overloading
 * ------------------------------------------------------------
 *
 * Kedua konsep ini sama-sama berhubungan dengan method, tetapi
 * waktunya berbeda.
 *
 * Method Overloading:
 *
 * - Nama method sama.
 * - Parameter berbeda.
 * - Ditentukan oleh compiler.
 * - Disebut compile-time polymorphism.
 *
 *
 * Dynamic Method Dispatch:
 *
 * - Method override.
 * - Parameter sama.
 * - Ditentukan saat runtime.
 * - Disebut runtime polymorphism.
 *
 * ------------------------------------------------------------
 * Batasan Dynamic Method Dispatch
 * ------------------------------------------------------------
 *
 * Dynamic Method Dispatch hanya berlaku untuk method instance.
 *
 * Tidak berlaku untuk:
 *
 * - static method.
 * - private method.
 * - final method.
 *
 * Karena method tersebut tidak dapat dioverride secara normal.
 *
 * Contoh:
 *
 * static method tidak mengikuti polymorphism runtime karena
 * pemilihannya berdasarkan reference type.
 *
 * ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * Dynamic Method Dispatch adalah mekanisme Java yang membuat
 * method override dipilih berdasarkan object sebenarnya saat
 * runtime.
 *
 * Konsep penting:
 *
 * - Reference superclass dapat menyimpan object subclass.
 * - Method yang dipanggil ditentukan oleh runtime object type.
 * - Override menjadi dasar runtime polymorphism.
 * - Reference type menentukan method yang tersedia.
 * - Object type menentukan implementasi yang dijalankan.
 *
 * Prinsip sederhana:
 *
 * "Reference menentukan apa yang bisa dipanggil,
 * object menentukan apa yang dijalankan."
 *
 */

// class A (parent)
class AA {

    void callMe() {
        System.out.println("Inside A's callme method");
    }
}

// class B turunan dari class A
class BB extends AA {

    @Override
    void callMe() {
        System.out.println("Inside B's callme method");
    }
}

// class C turunan dari class A
class CC extends AA {

    @Override
    void callMe() {
        System.out.println("Inside C's callme method");
    }
}

public class DynamicMethodDispatch {
    public static void main(String[] args) {

        // membuat objek dari berbagai class
        AA a = new AA();
        BB b = new BB();
        CC c = new CC();

        // mendeklarasikan variabel class (reference) dari class A (Parent)
        AA r;

        r = a;
        r.callMe();

        r = b;
        r.callMe();

        r = c;
        r.callMe();

        /**
         * Output:
         * 
         * Inside A's callme method
         * Inside B's callme method
         * Inside C's callme method
         *
         * Bedah Step-by-Step
         * 
         * 1. Class A
         * 
         * void callme()
         * method default
         *
         * 2. Class B & C
         * 
         * void callme()
         * override method dari A
         *
         * 3. Ini Bagian Penting
         * 
         * A r;
         * reference bertipe A
         *
         * 4. Kasus 1
         * 
         * r = a;
         * r.callme();
         * object = A
         * 
         * output:
         * Inside A's callme method
         *
         * 5. Kasus 2
         * 
         * r = b;
         * r.callme();
         *
         * reference = A
         * object = B
         * output:
         * Inside B's callme method
         *
         * 6. Kasus 3
         * 
         * r = c;
         * r.callme();
         * output:
         * Inside C's callme method
         */

        /**
         * Kenapa Ini Powerful?
         *
         * Bayangin tanpa dynamic dispatch:
         * Semua bakal manggil method A
         * Override jadi gak ada gunanya
         *
         * Tapi dengan ini:
         * Satu reference bisa punya banyak behavior
         *
         * Kenapa Disebut “Dynamic”?
         * Karena:
         * Diputuskan saat program jalan (runtime)
         * Bukan saat compile
         *
         * Hubungan ke Polymorphism
         * Dynamic Dispatch = implementasi:
         * Runtime Polymorphism
         *
         * Kesimpulan Inti (WAJIB NGENA)
         * Override → bikin versi baru method
         * Dynamic dispatch → milih method saat runtime
         * Yang menentukan = object
         * Ini dasar dari polymorphism
         */

    }
}
