package FundamentalJava.Methods.MethodOverriding;

/*
 * ============================================================
 * Method Overriding Pada Java
 * ============================================================
 *
 * Method overriding adalah konsep ketika sebuah subclass
 * menyediakan implementasi baru untuk method yang sudah dimiliki
 * oleh superclass...
 *
 * Method overriding terjadi dalam hubungan inheritance
 * (pewarisan).
 *
 * Syarat utama:
 *
 * - Nama method pada subclass sama dengan superclass.
 * - Parameter method sama.
 * - Return type kompatibel.
 *
 * Dengan overriding, subclass dapat mengubah behavior atau
 * perilaku dari method yang diwarisi dari superclass.
 *
 * ------------------------------------------------------------
 * Konsep Dasar Method Overriding
 * ------------------------------------------------------------
 *
 * Misalkan terdapat class hierarchy:
 *
 *        A
 *        |
 *        v
 *        B
 *
 * Class B mewarisi class A.
 *
 * Jika class A memiliki method:
 *
 * void show()
 *
 * Kemudian class B membuat method:
 *
 * void show()
 *
 * Dengan nama dan parameter yang sama, maka method pada class B
 * melakukan override terhadap method milik class A.
 *
 * ------------------------------------------------------------
 * Contoh Method Overriding
 * ------------------------------------------------------------
 *
 * class A {
 *
 *     int i;
 *     int j;
 *
 *     void show() {
 *         System.out.println("i and j: " + i + " " + j);
 *     }
 * }
 *
 *
 * class B extends A {
 *
 *     int k;
 *
 *     @Override
 *     void show() {
 *         System.out.println("k: " + k);
 *     }
 * }
 *
 *
 * Class B memiliki method show() sendiri sehingga implementasi
 * dari class A digantikan oleh implementasi class B.
 *
 * ------------------------------------------------------------
 * Proses Override Terjadi
 * ------------------------------------------------------------
 *
 * 1. Class A memiliki method:
 *
 * void show()
 *
 * Method tersebut menampilkan nilai i dan j.
 *
 *
 * 2. Class B extends A
 *
 * Artinya:
 *
 * - B mewarisi anggota dari A.
 * - B dapat menggunakan method dari A.
 *
 *
 * 3. Class B membuat method dengan signature yang sama:
 *
 * @Override
 * void show()
 *
 * Karena:
 *
 * Nama sama.
 * Parameter sama.
 *
 * Maka terjadi:
 *
 * Method overriding.
 *
 * ------------------------------------------------------------
 * Pemanggilan Method Override
 * ------------------------------------------------------------
 *
 * Contoh:
 *
 * B subObject = new B();
 *
 * subObject.show();
 *
 *
 * Walaupun class A memiliki method show(), Java akan menjalankan
 * method milik B.
 *
 * Output:
 *
 * k: 3
 *
 * Karena object yang digunakan adalah object B.
 *
 * ------------------------------------------------------------
 * Keyword @Override
 * ------------------------------------------------------------
 *
 * Pada Java modern, sangat disarankan menggunakan annotation:
 *
 * @Override
 *
 * Contoh:
 *
 * @Override
 * void show() {
 *     System.out.println("k: " + k);
 * }
 *
 * Fungsi @Override:
 *
 * - Memberitahu compiler bahwa method ini menggantikan method
 *   superclass.
 * - Membantu mendeteksi kesalahan penulisan method.
 *
 * Contoh:
 *
 * Jika nama method salah atau parameter berbeda, compiler akan
 * memberikan error.
 *
 * ------------------------------------------------------------
 * Mengakses Method Parent Dengan super
 * ------------------------------------------------------------
 *
 * Terkadang subclass tidak ingin mengganti seluruh behavior
 * superclass.
 *
 * Subclass dapat menggunakan keyword super untuk memanggil method
 * milik parent class.
 *
 * Contoh:
 *
 * @Override
 * void show() {
 *
 *     super.show();
 *
 *     System.out.println("k: " + k);
 * }
 *
 *
 * Penjelasan:
 *
 * super.show()
 *
 * berarti:
 *
 * "Panggil method show() milik superclass."
 *
 * Kemudian subclass dapat menambahkan behavior sendiri.
 *
 * Output:
 *
 * i and j: 1 2
 * k: 3
 *
 * ------------------------------------------------------------
 * Aturan Penting Method Overriding
 * ------------------------------------------------------------
 *
 * 1. Nama Method Harus Sama
 *
 * Contoh:
 *
 * Parent:
 *
 * void tampil()
 *
 * Child:
 *
 * void tampil()
 *
 *
 * 2. Parameter Harus Sama
 *
 * Parent:
 *
 * void tampil(int angka)
 *
 * Child:
 *
 * void tampil(int angka)
 *
 *
 * Jika parameter berbeda:
 *
 * void tampil(double angka)
 *
 * Maka bukan overriding.
 *
 * Itu adalah method overloading.
 *
 *
 * 3. Return Type Harus Kompatibel
 *
 * Override dapat menggunakan:
 *
 * - Return type yang sama.
 * - Covariant return type (subclass dari return type parent).
 *
 *
 * 4. Access Modifier Tidak Boleh Lebih Ketat
 *
 * Contoh:
 *
 * Parent:
 *
 * public void show()
 *
 * Child:
 *
 * private void show()
 *
 * Error.
 *
 * Karena subclass tidak boleh mengurangi akses method parent.
 *
 * ------------------------------------------------------------
 * Perbedaan Method Overriding vs Overloading
 * ------------------------------------------------------------
 *
 * Method Overriding:
 *
 * - Nama method sama.
 * - Parameter sama.
 * - Terjadi antara parent dan child class.
 * - Mengubah behavior dari parent.
 * - Berkaitan dengan runtime polymorphism.
 *
 *
 * Method Overloading:
 *
 * - Nama method sama.
 * - Parameter berbeda.
 * - Dapat terjadi dalam class yang sama.
 * - Membuat variasi method.
 * - Berkaitan dengan compile-time polymorphism.
 *
 * ------------------------------------------------------------
 * Cara Cepat Membedakan
 * ------------------------------------------------------------
 *
 * Jika:
 *
 * Signature sama persis
 *        |
 *        v
 * Override
 *
 *
 * Jika:
 *
 * Parameter berbeda
 *        |
 *        v
 * Overload
 *
 * ------------------------------------------------------------
 * Hubungan Dengan Polymorphism
 * ------------------------------------------------------------
 *
 * Method overriding menjadi dasar dari runtime polymorphism.
 *
 * Contoh:
 *
 * Animal animal = new Dog();
 *
 * animal.sound();
 *
 * Walaupun reference bertipe Animal, method yang dijalankan
 * adalah implementasi Dog karena object sebenarnya adalah Dog.
 *
 * ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * Method overriding adalah mekanisme Java yang memungkinkan
 * subclass mengganti implementasi method dari superclass.
 *
 * Poin penting:
 *
 * - Override terjadi pada hubungan inheritance.
 * - Nama dan parameter harus sama.
 * - Gunakan @Override untuk keamanan.
 * - Keyword super digunakan untuk mengakses method parent.
 * - Override adalah dasar runtime polymorphism.
 *
 * Prinsip sederhana:
 *
 * "Parent menyediakan aturan,
 * Child dapat memberikan implementasi baru."
 *
 */

// class parent
class A {
    int i, j;

    // Konstruktor parent
    A(int i, int j) {
        this.i = i;
        this.j = j;
    }

    // Methode parent
    void show() {
        System.out.println("i and j: " + i + " " + j);
    }
}

// class turunan (child)
class B extends A {
    int k;

    // konstruktor class child
    B(int a, int b, int c) {
        super(a, b);
        this.k = c;
    }

    // methode class child
    // methode overriding, menimpa methode yang sama di kelas parent
    void show() {
        super.show(); // super untuk memanggil methode milik class parent A
        System.out.println("k: " + k);
    }
}

public class MethodOverriding {
    public static void main(String[] args) {

        // membuat objek class child
        B subOb = new B(1, 2, 3);
        subOb.show();
    }
}
