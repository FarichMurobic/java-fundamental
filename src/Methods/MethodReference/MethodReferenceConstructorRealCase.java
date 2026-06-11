package Methods.MethodReference;

/**
 * Intinya:
 *
 * Contoh sebelumnya cuma nunjukin cara kerja
 * Tapi belum ada manfaat nyata
 *
 * Nah di sini mulai masuk USE CASE REAL:
 * bikin factory method generic
 * yang bisa bikin object apa pun
 *
 * Konsep Besar (WAJIB PAHAM)
 * Ini inti dari semuanya:
 * static <R,T> R myClassFactory(MyFunc<R, T> cons, T v)
 *
 * artinya:
 * “Kasih gue constructor (cons), gue bakal bikin object dari situ”
 *
 * Jadi ini:
 * MyClass<Double>::new
 *
 * dikirim sebagai parameter
 *
 * Jadi constructor = first-class citizen
 *
 * bisa dipassing kayak:
 * variable
 * parameter
 * return value
 *
 * Cara Kerja
 * Ini:
 * MyFunc<MyClass<Double>, Double> cons1 = MyClass<Double>::new;
 *
 * artinya:
 * (n) -> new MyClass<Double>(n)
 *
 * Masuk ke factory:
 * myClassFactory(cons1, 100.1);
 *
 * Di dalam:
 * return cons.func(v);
 *
 * jadi:
 * return new MyClass<Double>(100.1);
 *
 * BOOM — object dibuat tanpa new langsung
 *
 * --------------------------------------------
 * 
 * Insight DALAM
 * 1. Ini adalah DESIGN PATTERN: Factory
 * lo bikin object tanpa tahu class detail
 *
 * 2. SUPER reusable
 * Satu method:
 * myClassFactory(...)
 *
 * bisa bikin:
 * MyClass<Integer>
 * MyClass<Double>
 * MyClass2
 * dll
 *
 * 3. Ini dipakai di dunia nyata:
 * Spring Bean Factory
 * Dependency Injection
 * Object Mapper
 * Framework internal
 *
 * Analoginya Biar Nempel
 *
 * Bayangin:
 * MyFunc = blueprint mesin
 * MyClass::new = mesin pembuat object
 * myClassFactory = operator
 *
 * lo tinggal bilang:
 * “buatkan gue object ini dengan mesin ini”
 */

// Functional interface generic
interface Fungsi<R, T> {

    // R = return type (object yg dibuat)
    // T = parameter constructor
    R fungsi(T n);
}

// Class generic
class Kelas<T> {
    private T val;

    // Constructor dengan parameter
    Kelas(T v) {
        val = v;
    }

    // Default constructor (tidak dipakai di sini)
    Kelas() {
        val = null;
    }

    T getVal() {
        return val;
    }
}

// Class non-generic
class Kelas2 {
    String str;

    // Constructor dengan parameter
    Kelas2(String s) {
        str = s;
    }

    // Default constructor
    Kelas2() {
        str = "";
    }

    String getStr() {
        return str;
    }
}

public class MethodReferenceConstructorRealCase {
    // FACTORY METHOD GENERIC
    static <R, T> R myClassFactory(Fungsi<R, T> cons, T v) {
        // Memanggil constructor lewat lambda/method reference
        return cons.fungsi(v);
    }

    public static void main(String[] args) {

        // CASE 1: MyClass<Double>
        Fungsi<Kelas, Double> cons1 = Kelas<Double>::new;
        Kelas<Double> obj1 = myClassFactory(cons1, 100.1);
        System.out.println("val in obj1 = " + obj1.getVal());

        System.out.println();

        // CASE 2: MyClass2
        Fungsi<Kelas2, String> cons2 = Kelas2::new;
        Kelas2 obj2 = myClassFactory(cons2, "Lambda");
        System.out.println("val in obj2 = " + obj2.getStr());

    }
}
