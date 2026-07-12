package FundamentalJava.Methods.MethodOverriding;

/*
 * ============================================================
 * Why Overridden Methods?
 * Mengapa Method Overriding Dibutuhkan?
 * ============================================================
 *
 * Method overriding bukan hanya fitur untuk mengganti isi method
 * dari parent class.
 *
 * Tujuan utama method overriding adalah memungkinkan Java
 * menerapkan:
 *
 * Runtime Polymorphism
 *
 * Dengan overriding, sebuah superclass dapat mendefinisikan
 * perilaku umum, sementara subclass dapat memberikan implementasi
 * yang lebih spesifik sesuai kebutuhannya.
 *
 * ------------------------------------------------------------
 * Mengapa Polymorphism Penting?
 * ------------------------------------------------------------
 *
 * Polymorphism berarti:
 *
 * "Satu bentuk dapat memiliki banyak perilaku."
 *
 * Dalam OOP Java, polymorphism memungkinkan kita menggunakan
 * reference dengan tipe yang sama untuk menangani berbagai object
 * yang berbeda.
 *
 * Contoh:
 *
 * Animal animal;
 *
 * animal = new Cat();
 * animal.sound();
 *
 * animal = new Dog();
 * animal.sound();
 *
 *
 * Walaupun reference tetap bertipe Animal, perilaku method sound()
 * dapat berbeda tergantung object yang digunakan.
 *
 * ------------------------------------------------------------
 * Konsep Utama Polymorphism
 * ------------------------------------------------------------
 *
 * Inti dari polymorphism:
 *
 * Satu kontrak
 *      |
 *      v
 * Banyak implementasi
 *
 *
 * Contoh:
 *
 * Animal
 *    |
 *    +-- Cat
 *    |
 *    +-- Dog
 *
 *
 * Semua object tersebut memiliki method:
 *
 * sound()
 *
 * Tetapi implementasinya berbeda.
 *
 * Cat:
 *
 * sound() -> Meow
 *
 * Dog:
 *
 * sound() -> Bark
 *
 * ------------------------------------------------------------
 * Peran Superclass dan Subclass
 * ------------------------------------------------------------
 *
 * Dalam inheritance terdapat hubungan:
 *
 * Superclass
 *       |
 *       v
 * Subclass
 *
 * ------------------------------------------------------------
 * Superclass
 * ------------------------------------------------------------
 *
 * Superclass adalah class yang lebih umum.
 *
 * Tugas superclass:
 *
 * - Menyediakan struktur dasar.
 * - Mendefinisikan behavior umum.
 * - Menjadi aturan atau kontrak bagi subclass.
 *
 * Contoh:
 *
 * class Animal {
 *
 *     void sound() {
 *         System.out.println("Animal sound");
 *     }
 * }
 *
 *
 * Animal mendefinisikan bahwa setiap animal memiliki kemampuan
 * untuk menghasilkan suara.
 *
 * ------------------------------------------------------------
 * Subclass
 * ------------------------------------------------------------
 *
 * Subclass adalah class yang lebih spesifik.
 *
 * Tugas subclass:
 *
 * - Mewarisi fitur superclass.
 * - Memberikan implementasi yang lebih detail.
 * - Melakukan override jika behavior parent tidak sesuai.
 *
 * Contoh:
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
 * Cat memiliki perilaku suara yang berbeda dari Animal secara
 * umum.
 *
 * ------------------------------------------------------------
 * Hubungan Abstraction Dengan Overriding
 * ------------------------------------------------------------
 *
 * Superclass biasanya tidak perlu mengetahui detail bagaimana
 * subclass bekerja.
 *
 * Superclass hanya mendefinisikan:
 *
 * "Apa yang harus tersedia."
 *
 * Sedangkan subclass menentukan:
 *
 * "Bagaimana cara menjalankannya."
 *
 * Contoh:
 *
 * Animal:
 *
 * "Semua hewan harus memiliki method sound()."
 *
 *
 * Cat:
 *
 * "Cara kucing menghasilkan suara adalah Meow."
 *
 *
 * Dog:
 *
 * "Cara anjing menghasilkan suara adalah Bark."
 *
 * ------------------------------------------------------------
 * Kalimat Kunci Dalam Overriding
 * ------------------------------------------------------------
 *
 * "Superclass menentukan APA yang harus dilakukan.
 *
 * Subclass menentukan BAGAIMANA cara melakukannya."
 *
 *
 * Contoh:
 *
 * Superclass:
 *
 * void pembayaran();
 *
 * Artinya:
 *
 * Setiap jenis pembayaran harus memiliki proses pembayaran.
 *
 *
 * Subclass:
 *
 * CreditCardPayment:
 *
 * melakukan pembayaran menggunakan kartu kredit.
 *
 *
 * EWalletPayment:
 *
 * melakukan pembayaran menggunakan e-wallet.
 *
 * ------------------------------------------------------------
 * Keuntungan Menggunakan Overriding
 * ------------------------------------------------------------
 *
 * Dengan method overriding:
 *
 * - Kode menjadi lebih fleksibel.
 * - Program lebih mudah dikembangkan.
 * - Class baru dapat ditambahkan tanpa mengubah banyak kode lama.
 * - Mendukung prinsip Open/Closed Principle dalam desain OOP.
 *
 * ------------------------------------------------------------
 * Contoh Penggunaan Nyata
 * ------------------------------------------------------------
 *
 * Misalnya dalam aplikasi:
 *
 * Payment payment;
 *
 * payment = new CreditCardPayment();
 * payment.process();
 *
 * atau:
 *
 * payment = new PaypalPayment();
 * payment.process();
 *
 *
 * Method process() tetap sama,
 * tetapi implementasinya berbeda.
 *
 * Inilah kekuatan polymorphism.
 *
 * ------------------------------------------------------------
 * Kesimpulan
 * ------------------------------------------------------------
 *
 * Method overriding dibutuhkan karena menjadi dasar runtime
 * polymorphism dalam Java.
 *
 * Dengan overriding:
 *
 * - Superclass menyediakan aturan umum.
 * - Subclass memberikan implementasi spesifik.
 * - Satu reference dapat memiliki banyak perilaku.
 *
 * Prinsip utama:
 *
 * "Program terhadap kontrak, bukan terhadap implementasi."
 *
 */

// class Hewan (parent)
class Hewan {
    void suara() {
        System.out.println("Hewan bersuara.");
    }
}

// class Kucing
class Kucing extends Hewan {
    void suara() {
        System.out.println("Meong-meong.");
    }
}

// class Anjing
class Anjing extends Hewan {
    @Override
    void suara() {
        super.suara(); // pakai super untuk menggunakan methode parent
        System.out.println("Guk-guk.");
    }
}

public class WhyOverriddenMethod {

    public static void main(String[] args) {

        Hewan hewan;

        hewan = new Kucing();
        hewan.suara(); // Meong-meong

        hewan = new Anjing();
        hewan.suara(); // Guk-guk

        /**
         * Code Reuse (Dipakai ulang)
         * 
         * Lu cukup bikin:
         * Hewan h;
         * Tanpa harus:
         * Kucing k;
         * Anjing a;
         * Burung b;
         *
         * yang menentukan methode mana yang dipanggil adalah Object
         * Ini yang disebut:
         * One Interface, Multiple Methods
         *
         * Kesimpulan Super Kuat
         * Override → memungkinkan polymorphism
         * Superclass → define struktur umum
         * Subclass → define detail
         * Dynamic dispatch → memilih method saat runtime
         * Hasilnya:
         * fleksibel
         * reusable
         * scalable
         */
    }
}
