package FundamentalJava.Methods.MethodReference;

/*
 * ============================================================
 * Constructor Reference Pada Java
 * ============================================================
 *
 * Constructor reference adalah fitur Java yang memungkinkan kita
 * membuat referensi terhadap constructor sebuah class.
 *
 * Syntax:
 *
 * ClassName::new
 *
 *
 * Constructor reference tidak langsung membuat object ketika
 * ditulis.
 *
 * Constructor tersebut baru dijalankan ketika functional interface
 * memanggilnya.
 *
 * ------------------------------------------------------------
 * Konsep Dasar Constructor Reference
 * ------------------------------------------------------------
 *
 * Contoh:
 *
 * User::new
 *
 *
 * Artinya:
 *
 * "Jika nanti diperlukan, gunakan constructor User untuk membuat
 * object baru."
 *
 *
 * Tetapi Java masih membutuhkan informasi:
 *
 * - Constructor dengan parameter apa yang digunakan?
 * - Return object tipe apa?
 *
 *
 * Informasi tersebut diberikan oleh functional interface.
 *
 * ------------------------------------------------------------
 * Hubungan Constructor Reference Dengan Functional Interface
 * ------------------------------------------------------------
 *
 * Constructor reference selalu membutuhkan target type berupa
 * functional interface.
 *
 * Contoh:
 *
 * Function<String, User> creator =
 *         User::new;
 *
 *
 * Artinya:
 *
 * Input:
 *
 * String
 *
 * Output:
 *
 * User
 *
 *
 * Sama dengan lambda:
 *
 * name -> new User(name)
 *
 *
 * Ketika:
 *
 * creator.apply("Farich");
 *
 *
 * Java menjalankan:
 *
 * new User("Farich");
 *
 * ------------------------------------------------------------
 * Constructor Mana Yang Digunakan?
 * ------------------------------------------------------------
 *
 * Jika sebuah class memiliki beberapa constructor, Java memilih
 * constructor berdasarkan functional interface.
 *
 * Contoh:
 *
 * class User {
 *
 *     User() {
 *     }
 *
 *     User(String name) {
 *     }
 * }
 *
 *
 * Constructor reference:
 *
 * Supplier<User> a =
 *         User::new;
 *
 *
 * Mengarah ke:
 *
 * new User()
 *
 *
 * Sedangkan:
 *
 * Function<String, User> b =
 *         User::new;
 *
 *
 * Mengarah ke:
 *
 * new User(String)
 *
 *
 * Jadi functional interface menentukan constructor yang cocok.
 *
 * ------------------------------------------------------------
 * Constructor Reference Sebagai Factory Sederhana
 * ------------------------------------------------------------
 *
 * Constructor reference sering digunakan sebagai cara sederhana
 * untuk membuat object secara fleksibel.
 *
 * Contoh:
 *
 * Function<String, User> factory =
 *         User::new;
 *
 *
 * Kita tidak menulis:
 *
 * new User()
 *
 * secara langsung di bagian pemanggilan.
 *
 * Namun proses pembuatan object tetap menggunakan constructor.
 *
 * ------------------------------------------------------------
 * Perbandingan Dengan Lambda
 * ------------------------------------------------------------
 *
 * Constructor reference:
 *
 * User::new
 *
 *
 * Sama dengan:
 *
 * name -> new User(name)
 *
 *
 * Constructor reference lebih singkat karena hanya menunjuk
 * constructor yang sudah tersedia.
 *
 * ------------------------------------------------------------
 * Kesalahan Umum Constructor Reference
 * ------------------------------------------------------------
 *
 * Constructor reference harus cocok dengan functional interface.
 *
 * Contoh:
 *
 * interface MyInterface {
 *
 *     int func(int x);
 *
 * }
 *
 *
 * Jika:
 *
 * MyInterface a =
 *         MyClass::new;
 *
 *
 * Bisa error jika:
 *
 * Constructor MyClass tidak menghasilkan object MyClass yang
 * sesuai dengan return type functional interface.
 *
 *
 * Functional interface:
 *
 * Input:
 * int
 *
 * Output:
 * int
 *
 *
 * Sedangkan constructor:
 *
 * new MyClass(int)
 *
 * menghasilkan:
 *
 * MyClass
 *
 *
 * Return type tidak cocok.
 *
 * ------------------------------------------------------------
 * Constructor Reference Pada Generic Class
 * ------------------------------------------------------------
 *
 * Constructor reference juga dapat digunakan pada generic class.
 *
 * Bentuk:
 *
 * ClassName<Type>::new
 *
 *
 * Contoh:
 *
 * MyClass<Integer>::new
 *
 *
 * Artinya:
 *
 * "Gunakan constructor MyClass dengan tipe parameter Integer."
 *
 * ------------------------------------------------------------
 * Contoh Generic Constructor Reference
 * ------------------------------------------------------------
 *
 * Misalkan:
 *
 * class MyClass<T> {
 *
 *     T value;
 *
 *     MyClass(T value) {
 *         this.value = value;
 *     }
 * }
 *
 *
 * Functional interface:
 *
 * interface MyFunc<T> {
 *
 *     MyClass<T> func(T value);
 *
 * }
 *
 *
 * Constructor reference:
 *
 * MyFunc<Integer> creator =
 *         MyClass<Integer>::new;
 *
 *
 * Sama dengan lambda:
 *
 * value -> new MyClass<Integer>(value)
 *
 * ------------------------------------------------------------
 * Mapping Generic Constructor Reference
 * ------------------------------------------------------------
 *
 * Functional Interface:
 *
 * MyClass<T> func(T value)
 *
 *
 * Constructor:
 *
 * new MyClass<T>(value)
 *
 *
 * Hubungan:
 *
 * func(T value)
 *        |
 *        v
 * new MyClass<T>(value)
 *
 * ------------------------------------------------------------
 * Type Inference Pada Constructor Reference
 * ------------------------------------------------------------
 *
 * Java sering dapat menentukan generic type secara otomatis.
 *
 * Contoh:
 *
 * Function<Integer, MyClass<Integer>> creator =
 *         MyClass::new;
 *
 *
 * Java mengetahui bahwa:
 *
 * MyClass
 *
 * harus berupa:
 *
 * MyClass<Integer>
 *
 *
 * Karena ditentukan oleh target type.
 *
 * ------------------------------------------------------------
 * MyClass::new vs MyClass<Integer>::new
 * ------------------------------------------------------------
 *
 * MyClass::new
 *
 * - Menggunakan type inference.
 * - Lebih ringkas.
 * - Sering digunakan pada kode modern.
 *
 *
 * MyClass<Integer>::new
 *
 * - Menentukan generic type secara eksplisit.
 * - Berguna ketika compiler membutuhkan informasi tambahan.
 *
 * ------------------------------------------------------------
 * Penggunaan Dunia Nyata
 * ------------------------------------------------------------
 *
 * Constructor reference banyak digunakan pada:
 *
 * - Factory method.
 * - Stream API.
 * - DTO mapping.
 * - Entity creation.
 * - Dependency Injection framework.
 *
 *
 * Contoh mapping:
 *
 * userRepository.findAll()
 *     .stream()
 *     .map(UserDTO::new);
 *
 *
 * Artinya:
 *
 * Setiap User akan dibuat menjadi UserDTO menggunakan constructor
 * UserDTO.
 *
 * ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * Constructor reference adalah referensi terhadap constructor
 * menggunakan syntax:
 *
 * ClassName::new
 *
 *
 * Konsep penting:
 *
 * - Tidak langsung membuat object ketika ditulis.
 * - Membutuhkan functional interface.
 * - Constructor dipilih berdasarkan parameter functional interface.
 * - Parameter dan return type harus cocok.
 * - Dapat digunakan pada generic class.
 *
 *
 * Mapping penting:
 *
 * ClassName::new
 *
 * sama dengan:
 *
 * args -> new ClassName(args)
 *
 *
 * Untuk generic:
 *
 * MyClass<T>::new
 *
 * sama dengan:
 *
 * value -> new MyClass<T>(value)
 *
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
