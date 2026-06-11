package Methods.MethodReference;

/**
 * Intinya:
 *
 * Kita bisa bikin referensi ke constructor
 * Syntax:
 * ClassName::new
 *
 * Sama seperti method reference:
 * dia tidak langsung bikin object
 * tapi jadi implementasi dari functional interface
 *
 * ---------------------------------
 * 
 * Konsep Inti (WAJIB PAHAM)
 * Ini penting banget:
 * MyClass::new
 *
 * artinya:
 * “Kalau nanti dipanggil, bikin object MyClass”
 *
 * Tapi constructor mana?
 * tergantung functional interface
 *
 * Insight DALAM 
 * 1. Constructor reference = factory sederhana
 * bikin object tanpa new secara langsung
 *
 * 2. Banyak dipakai di:
 * Stream API
 * DTO → Entity mapping
 * Spring Boot
 *
 * 3. Lebih clean dari lambda
 * User::new
 * vs
 * name -> new User(name)
 *
 * Kesalahan Umum 
 * Tidak cocok dengan FI
 * interface A {
 *     int func(int x);
 * }
 * 
 * A a = MyClass::new; // ERROR
 *
 * karena return type beda
 *
 * Kesimpulan Super Sederhana
 * Inti:
 * ClassName::new = reference ke constructor
 * Harus cocok dengan functional interface
 * Parameter & return harus match
 * Sama seperti lambda
 *
 * Mapping penting:
 * MyClass::new
 * =
 * (args) -> new MyClass(args)
 */

/**
 * Intinya:
 *
 * Constructor reference juga bisa dipakai ke class generic
 * Caranya sama seperti biasa:
 * ClassName<Type>::new
 *
 * Perbedaannya cuma:
 * sekarang ada type argument <T>
 *
 * Konsep Inti (WAJIB NANGKEP)
 * Ini:
 * MyClass<Integer>::new
 *
 * artinya:
 * “Buat constructor reference untuk MyClass dengan tipe Integer”
 *
 * Ini nyambung ke:
 * interface MyFunc<T> {
 *     MyClass<T> func(T n);
 * }
 *
 * Jadi mapping-nya:
 * FI	Constructor
 * func(T n)	new MyClass<T>(n)
 *
 * Kesimpulan Super Sederhana
 * Inti:
 * Constructor reference bisa dipakai di generic class
 * Bisa pakai:
 * MyClass::new (infer)
 * MyClass<Integer>::new (explicit)
 * Tetap harus cocok dengan functional interface
 *
 * Mapping penting:
 * MyClass<T>::new
 * =
 * (T x) -> new MyClass<T>(x)
 */

// Functional interface
interface MyFunc2 {
    // Method menerima int, return MyClass
    MyClass1 func(int i);
}

// Class tujuan
class MyClass1 {
    private int val;

    // Constructor dengan parameter
    MyClass1(int v) {
        val = v;
    }

    // Constructor default
    MyClass1() {
        val = 0;
    }

    public int getVal() {
        return val;
    }
}

// Constructor reference juga bisa dipakai ke class generic
// Functional interface generic
interface MyFunction<T> {
    // Method menerima T, return MyClass<T>
    Myclass<T> func(T n);
}

// Class generic
class Myclass<T> {
    private T val;

    // Constructor dengan parameter
    Myclass(T v) {
        val = v;
    }

    // Constructor default
    Myclass() {
        val = null;
    }

    // Getter
    T getVal() {
        return val;
    }
}

public class MethodReferenceWithConstructor {
    public static void main(String[] args) {

        // CONSTRUCTOR REFERENCE
        MyFunc2 myClassCons = MyClass1::new;

        // Ini akan memanggil constructor MyClass(int v)
        MyClass1 obj = myClassCons.func(100);
        System.out.println("Nilai: " + obj.getVal());

        System.out.println();

        // CONSTRUCTOR REFERENCE + GENERIC

        // Tentukan tipe Integer
        MyFunction<Integer> myFunction = Myclass<Integer>::new; // method reference

        // Membuat object MyClass<Integer>
        Myclass<Integer> objek = myFunction.func(100);
        System.out.println("Nilai: " + objek.getVal());

        /**
         * Cara Kerja di Balik Layar
         * Ini:
         * MyClass<Integer>::new
         *
         * sama dengan:
         * (n) -> new MyClass<Integer>(n)
         *
         * Dan genericnya:
         * T = Integer
         *
         * Jadi:
         * MyFunc<Integer>
         *
         * berarti:
         * MyClass<Integer> func(Integer n)
         *
         * Apakah <Integer> wajib?
         * Tidak selalu
         *
         * Java sering bisa infer:
         * MyFunc<Integer> f = MyClass::new;
         *
         * tetap jalan
         * Tapi boleh ditulis kalau:
         * mau eksplisit
         * biar lebih jelas
         * atau compiler bingung
         *
         * --------------------------
         * 
         * Insight DALAM 
         * 
         * 1. Ini gabungan 3 konsep besar:
         * Generics
         * Functional Interface
         * Method Reference
         *
         * 2. Ini bikin code reusable banget
         *
         * Lo bisa:
         *
         * MyFunc<String>
         * MyFunc<Integer>
         * MyFunc<Double>
         *
         * tanpa bikin ulang class
         *
         * 3. Ini fondasi:
         * Spring Boot DTO mapping
         * data transformation
         * generic service layer
         */
    }
}
