package FundamentalJava.Methods.MethodOverriding;

    /**
     * Why Overridden Methods?
     * Seperti yang sudah dijelaskan sebelumnya,
     * method overriding memungkinkan Java mendukung runtime polymorphism.
     *
     * Kenapa polymorphism penting?
     * Karena:
     * Polymorphism memungkinkan class umum (superclass)
     * mendefinisikan method yang sama untuk semua turunannya,
     * tapi subclass bisa bikin implementasi sendiri
     *
     * Intinya:
     * Satu interface → banyak implementasi
     *
     * Tentang Hierarki
     * Superclass → lebih umum
     * Subclass → lebih spesifik
     *
     * Peran masing-masing
     * Superclass:
     * nyediain method umum
     * jadi “template”
     *
     * Subclass:
     * implementasi detail
     * bisa override sesuai kebutuhan
     *
     * Kalimat paling penting:
     * “Superclass menentukan APA yang harus dilakukan
     * Subclass menentukan BAGAIMANA melakukannya”
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
