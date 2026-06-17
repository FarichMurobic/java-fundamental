package FundamentalJava.Enum;

/**
 * ENUM SEBAGAI CLASS
 * ------------------------------------------------------------
 *
 * Seperti yang telah dijelaskan sebelumnya, enum di Java bukan
 * sekadar kumpulan konstanta biasa.
 *
 * Enum sebenarnya adalah sebuah class khusus yang disediakan oleh
 * Java untuk merepresentasikan sekumpulan nilai tetap yang saling
 * berhubungan.
 *
 * Karena enum merupakan class, enum dapat memiliki:
 *
 * - Constructor
 * - Instance Variable
 * - Method
 * - Static Member
 * - Implementasi Interface
 *
 * Namun enum memiliki beberapa aturan khusus yang membedakannya
 * dari class biasa.
 *
 * ------------------------------------------------------------
 * ENUM CONSTANT ADALAH OBJECT
 * ------------------------------------------------------------
 *
 * Konsep paling penting yang harus dipahami adalah:
 *
 * Setiap konstanta enum sebenarnya merupakan object yang dibuat
 * dari class enum tersebut.
 *
 * Contoh:
 *
 * enum Apple {
 *     Jonathan,
 *     GoldenDel,
 *     RedDel,
 *     Winesap,
 *     Cortland
 * }
 *
 * Maka:
 *
 * - Apple.Jonathan adalah object
 * - Apple.GoldenDel adalah object
 * - Apple.RedDel adalah object
 * - Apple.Winesap adalah object
 * - Apple.Cortland adalah object
 *
 * Flow:
 *
 * Enum Declaration
 *      ↓
 * Java Membuat Object Untuk Setiap Constant
 *      ↓
 * Program Menggunakan Object Tersebut
 *
 * Karena setiap constant adalah object, maka setiap constant dapat
 * memiliki data dan perilakunya sendiri.
 *
 * ------------------------------------------------------------
 * CONSTRUCTOR PADA ENUM
 * ------------------------------------------------------------
 *
 * Enum dapat memiliki constructor.
 *
 * Contoh:
 *
 * enum Apple {
 *     Jonathan(10),
 *     GoldenDel(9),
 *     RedDel(12);
 *
 *     private int price;
 *
 *     Apple(int p) {
 *         price = p;
 *     }
 * }
 *
 * Pada contoh di atas:
 *
 * - Jonathan memanggil constructor dengan nilai 10
 * - GoldenDel memanggil constructor dengan nilai 9
 * - RedDel memanggil constructor dengan nilai 12
 *
 * Constructor akan dipanggil otomatis saat enum dimuat oleh JVM.
 *
 * Berbeda dengan class biasa:
 *
 * Apple a = new Apple(); // ERROR
 *
 * Enum tidak bisa dibuat menggunakan operator new.
 *
 * Java secara otomatis membuat seluruh object enum ketika enum
 * pertama kali dimuat ke dalam memori.
 *
 * ------------------------------------------------------------
 * SETIAP ENUM MEMILIKI DATA SENDIRI
 * ------------------------------------------------------------
 *
 * Karena setiap constant adalah object, maka setiap constant dapat
 * menyimpan data yang berbeda.
 *
 * Contoh:
 *
 * enum Apple {
 *     Jonathan(10),
 *     GoldenDel(9),
 *     Winesap(15);
 * }
 *
 * Maka:
 *
 * - Jonathan memiliki nilai 10
 * - GoldenDel memiliki nilai 9
 * - Winesap memiliki nilai 15
 *
 * Data tersebut tidak saling berbagi (share).
 *
 * Setiap object enum memiliki salinan variabelnya sendiri.
 *
 * Analogi:
 *
 * enum Apple
 *      ↓
 * Object Jonathan → price = 10
 * Object GoldenDel → price = 9
 * Object Winesap → price = 15
 *
 * Masing-masing object menyimpan datanya sendiri.
 *
 * ------------------------------------------------------------
 * ENUM DAPAT MEMILIKI METHOD
 * ------------------------------------------------------------
 *
 * Karena enum adalah class, enum juga dapat memiliki method.
 *
 * Contoh:
 *
 * enum Apple {
 *     Jonathan(10),
 *     GoldenDel(9);
 *
 *     private int price;
 *
 *     Apple(int p) {
 *         price = p;
 *     }
 *
 *     int getPrice() {
 *         return price;
 *     }
 * }
 *
 * Pemakaian:
 *
 * System.out.println(Apple.Jonathan.getPrice());
 *
 * Output:
 *
 * 10
 *
 * Dengan demikian enum dapat menyimpan data sekaligus menyediakan
 * perilaku (behavior).
 *
 * ------------------------------------------------------------
 * ENUM DAPAT IMPLEMENT INTERFACE
 * ------------------------------------------------------------
 *
 * Enum tidak bisa mewarisi class lain.
 *
 * Tetapi enum dapat mengimplementasikan interface.
 *
 * Contoh:
 *
 * interface Printable {
 *     void print();
 * }
 *
 * enum Apple implements Printable {
 *     Jonathan;
 *
 *     public void print() {
 *         System.out.println("Apple");
 *     }
 * }
 *
 * Hal ini memungkinkan enum digunakan dalam berbagai desain OOP.
 *
 * ------------------------------------------------------------
 * BATASAN ENUM
 * ------------------------------------------------------------
 *
 * Enum memiliki beberapa batasan penting:
 *
 * - Tidak bisa menggunakan extends ke class lain
 * - Tidak bisa menjadi superclass
 * - Tidak bisa dibuat menggunakan operator new
 *
 * Contoh:
 *
 * enum A extends B { }     // ERROR
 *
 * class B extends Apple { } // ERROR
 *
 * Tetapi:
 *
 * enum Apple implements Serializable {
 * }
 *
 * Valid.
 *
 * ------------------------------------------------------------
 * ENUM SECARA OTOMATIS MEWARISI java.lang.Enum
 * ------------------------------------------------------------
 *
 * Walaupun enum tidak bisa melakukan inheritance terhadap class
 * lain, semua enum secara otomatis mewarisi:
 *
 * java.lang.Enum
 *
 * Hierarki sederhananya:
 *
 * Apple
 *      ↓
 * Enum<Apple>
 *      ↓
 * Object
 *
 * Karena itulah semua enum memiliki beberapa method bawaan.
 *
 * ------------------------------------------------------------
 * METHOD ordinal()
 * ------------------------------------------------------------
 *
 * Signature:
 *
 * final int ordinal()
 *
 * Fungsi:
 *
 * Mengembalikan posisi enum berdasarkan urutan deklarasi.
 *
 * Contoh:
 *
 * enum Apple {
 *     Jonathan,
 *     GoldenDel,
 *     RedDel
 * }
 *
 * Nilai ordinal:
 *
 * - Jonathan = 0
 * - GoldenDel = 1
 * - RedDel = 2
 *
 * Contoh:
 *
 * System.out.println(Apple.RedDel.ordinal());
 *
 * Output:
 *
 * 2
 *
 * ------------------------------------------------------------
 * METHOD compareTo()
 * ------------------------------------------------------------
 *
 * Signature:
 *
 * final int compareTo(E obj)
 *
 * Fungsi:
 *
 * Membandingkan posisi ordinal antar enum.
 *
 * Return:
 *
 * - Negatif  → sebelum
 * - Nol      → sama
 * - Positif  → sesudah
 *
 * Contoh:
 *
 * Apple.RedDel.compareTo(Apple.GoldenDel)
 *
 * Hasil:
 *
 * positif
 *
 * Karena:
 *
 * RedDel berada setelah GoldenDel.
 *
 * Flow:
 *
 * ordinal(RedDel) = 2
 * ordinal(GoldenDel) = 1
 *
 * 2 - 1 = 1
 *
 * ------------------------------------------------------------
 * METHOD equals()
 * ------------------------------------------------------------
 *
 * Signature:
 *
 * boolean equals(Object obj)
 *
 * Fungsi:
 *
 * Membandingkan apakah dua reference menunjuk object enum yang
 * sama.
 *
 * Contoh:
 *
 * Apple.Jonathan.equals(Apple.Jonathan)
 *
 * Hasil:
 *
 * true
 *
 * ------------------------------------------------------------
 * OPERATOR ==
 * ------------------------------------------------------------
 *
 * Cara yang paling umum dan direkomendasikan untuk membandingkan
 * enum adalah menggunakan operator:
 *
 * ==
 *
 * Contoh:
 *
 * if (ap == Apple.Winesap) {
 *     ...
 * }
 *
 * Ini aman karena:
 *
 * - Setiap constant enum hanya memiliki satu instance
 * - Enum bersifat singleton per constant
 *
 * Oleh karena itu:
 *
 * == lebih sederhana
 * == lebih cepat
 * == lebih sering digunakan
 *
 * dibanding:
 *
 * equals()
 *
 * ------------------------------------------------------------
 * PERBEDAAN ordinal(), compareTo(), DAN ==
 * ------------------------------------------------------------
 *
 * Method / Operator    Fungsi
 * ------------------------------------------------------------
 * ordinal()            Mengambil posisi enum
 * compareTo()          Membandingkan posisi enum
 * equals()             Membandingkan object enum
 * ==                   Membandingkan reference enum
 *
 * Pada enum:
 *
 * - equals() aman
 * - == juga aman
 * - == lebih direkomendasikan
 *
 * ------------------------------------------------------------
 * CONTOH SEDERHANA
 * ------------------------------------------------------------
 *
 * enum Level {
 *     LOW,
 *     MEDIUM,
 *     HIGH
 * }
 *
 * public class Demo {
 *
 *     public static void main(String[] args) {
 *
 *         System.out.println(Level.LOW.ordinal());
 *
 *         if (Level.HIGH.compareTo(Level.LOW) > 0) {
 *             System.out.println("HIGH lebih tinggi dari LOW");
 *         }
 *
 *         if (Level.HIGH == Level.HIGH) {
 *             System.out.println("Sama");
 *         }
 *     }
 * }
 *
 * Output:
 *
 * 0
 * HIGH lebih tinggi dari LOW
 * Sama
 *
 * ------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------
 *
 * Enum di Java adalah class khusus yang digunakan untuk
 * merepresentasikan sekumpulan konstanta tetap.
 *
 * Konsep penting yang harus dipahami:
 *
 * - Enum adalah class
 * - Setiap constant enum adalah object
 * - Enum dapat memiliki constructor
 * - Enum dapat memiliki variable
 * - Enum dapat memiliki method
 * - Enum dapat mengimplementasikan interface
 *
 * Semua enum secara otomatis mewarisi:
 *
 * java.lang.Enum
 *
 * Method bawaan yang paling penting:
 *
 * - ordinal()
 * - compareTo()
 * - equals()
 * - values()
 * - valueOf()
 *
 * Karena setiap constant enum sebenarnya adalah object,
 * enum di Java jauh lebih powerful dibandingkan sekadar
 * kumpulan konstanta biasa.
 */

// Enum dengan constructor, variabel dan methode
public enum EnumIsClass {
    Jonathan(10),
    GoldenDel(9),
    RedDel(12),
    Winesap(15),
    Cortland(8); // Titik koma diakhir

    // Variabel untuk menyimpan harga
    private int price;

    // Constructor di enum
    EnumIsClass(int price) {
        this.price = price;
    }

    // Method getter
    int getPrice() {
        return price;
    }
}

class MainEnum {
    public static void main(String[] args) {
        
        // Ambil harga Winesap
        System.out.println("Winesap costs: " + EnumIsClass.Winesap.getPrice() + " cents.\n");

        // Loop semua enum 
        System.out.println("All prices");
        for (EnumIsClass a : EnumIsClass.values()) {
            System.out.println(a + " costs " + a.getPrice() + " cents.");
        }

        /**
         * ALUR PROGRAM
         * 
         * Saat program mulai:
         *
         * Java akan:
         * Membuat object untuk setiap enum:
         * Jonathan
         * GoldenDel
         * dst
         *
         * Memanggil constructor:
         * EnumIsClass(int p)
         *
         * Contoh:
         * Jonathan(10) → price = 10
         * Winesap(15) → price = 15
         * Saat main() jalan:
         *
         * Ambil:
         * EnumIsClass.Winesap.getPrice()
         *
         * Loop semua enum:
         * for(EnumIsClass a : EnumIsClasss.values())
         * Cetak nama + harga
         *
         * OUTPUT
         * Winesap costs 15 cents.
         *
         * All prices:
         * Jonathan costs 10 cents.
         * GoldenDel costs 9 cents.
         * RedDel costs 12 cents.
         * Winesap costs 15 cents.
         * Cortland costs 8 cents.
         */

        System.out.println();

        EnumIsClass enum1, enum2, enum3;
        // Tampilkan semua enum + posisi
        System.out.println("Here are all enum constants and their ordinal values:");

        for (EnumIsClass  a : EnumIsClass.values()) {
            System.out.println(a + " " + a.ordinal());
        }

        System.out.println();

        // Assign nilai
        enum1 = EnumIsClass.RedDel;
        enum2 = EnumIsClass.GoldenDel;
        enum3 = EnumIsClass.RedDel;

        // Compare to
        if (enum1.compareTo(enum2) < 0) {
            System.out.println(enum1 + " comes before " + enum2);
        }

        if (enum2.compareTo(enum2) > 0) {
            System.out.println(enum2 + " comes before " + enum1);
        }

        System.out.println();

        // Equals
        if (enum1.equals(enum2)) {
            System.out.println("Error!");
        }

        if (enum1.equals(enum3)) {
            System.out.println(enum1 + " equals " + enum3);
        }

        // ==
        if (enum1 == enum3) {
            System.out.println(enum1 + " == " + enum3);
        }

         /**
         * ALUR PROGRAM
         *
         * Bagian 1: ordinal()
         * Loop semua enum:
         * a.ordinal()
         *
         * hasil:
         * Jonathan 0
         * GoldenDel 1
         * ...
         *
         * Bagian 2: compareTo()
         * enum1 = RedDel (2)
         * enum2 = GoldenDel (1)
         *
         * karena 2 > 1:
         * GoldenDel comes before RedDel
         *
         * Bagian 3: equals & ==
         * enum1 = RedDel
         * enum3 = RedDel
         *
         * sama object:
         *
         * equals() → true
         * == → true
         *
         * OUTPUT
         * Here are all enum constants and their ordinal values:
         * Jonathan 0
         * GoldenDel 1
         * RedDel 2
         * Winesap 3
         * Cortland 4
         *
         * GoldenDel comes before RedDel
         * RedDel equals RedDel
         *
         * RedDel equals RedDel
         * RedDel == RedDel
         */

    }
}