package Enum;

/**
 * Enum adalah Class
 * Seperti yang dijelaskan sebelumnya, enum di Java adalah tipe class.
 *
 * Walaupun:
 * tidak bisa dibuat dengan new
 *
 * Tapi:
 * bisa punya constructor
 * bisa punya variabel (instance variable)
 * bisa punya method
 * bisa implement interface
 *
 * Setiap konstanta enum adalah object
 *
 * ----------------------------------------------------
 * 
 * Ini bagian paling penting:
 * Setiap nilai enum (misalnya Winesap) itu sebenarnya:
 *
 * object dari class enum itu
 *
 * Constructor di enum
 * Kalau lu bikin constructor di enum:
 *
 * constructor akan dipanggil untuk setiap konstanta
 *
 * Setiap konstanta punya data sendiri
 *
 * Setiap enum punya:
 * copy variabel sendiri
 * data masing-masing
 *
 * Bayangin gini bro:
 * 
 * enum Apple {
 *     Jonathan, GoldenDel
 * }
 *
 * itu basic
 *
 * Sekarang kita upgrade:
 *
 * enum Apple {
 *     Jonathan(10),
 *     GoldenDel(9)
 * }
 *
 * ini artinya:
 *
 * Jonathan punya data = 10
 * GoldenDel punya data = 9
 *
 * Jadi:
 * enum sekarang kayak object yang punya property
 *
 * --------------------------------------------------
 * 
 * KONSEP PENTING BANGET 
 *
 * 1. Enum = class
 * Apple.Winesap
 * itu object
 *
 * 2. Constructor dipanggil otomatis
 * Lu gak pernah nulis:
 * new Apple()
 * Tapi Java yang bikinin otomatis
 *
 * 3. Setiap enum punya data sendiri
 * Jonathan.price ≠ Winesap.price
 *
 * beda-beda, gak share
 *
 * ------------------------------------------
 * 
 * BATASAN ENUM
 * 
 * Tidak bisa:
 * 
 * 1. Inherit class lain
 * enum A extends B // ERROR 
 * 
 * 2. Jadi superclass
 * class B extends Apple // ERROR 
 * Tapi bisa:
 * implement interface 
 *
 * INTI YANG HARUS LU “KLIK”
 * enum di Java = class
 * setiap nilai enum = object
 * 
 * bisa punya:
 * constructor
 * variabel
 * method
 * data tiap enum bisa beda-beda
 */

/**
 * Enum mewarisi class Enum
 * 
 * Walaupun enum tidak bisa mewarisi class lain, semua enum di Java otomatis mewarisi:
 * java.lang.Enum
 * Class ini menyediakan beberapa method bawaan untuk enum.
 *
 * Method penting di Enum
 * 
 * 1. ordinal()
 * final int ordinal()
 * Mengembalikan posisi enum dalam daftar
 *
 * Contoh:
 * Jonathan → 0
 * GoldenDel → 1
 * RedDel → 2
 *
 * 2. compareTo()
 * final int compareTo(enum-type e)
 * Membandingkan posisi (ordinal)
 *
 * Hasil:
 * negatif → sebelum
 * 0 → sama
 * positif → sesudah
 *
 * 3. equals()
 * Membandingkan apakah dua enum itu object yang sama
 *
 * 4. ==
 * Cara paling umum & direkomendasikan buat compare enum
 *
 * Intinya gini bro:
 * Enum itu punya “urutan”
 *
 * enum Apple {
 *     Jonathan, GoldenDel, RedDel
 * }
 *
 * otomatis:
 * Jonathan = 0
 * GoldenDel = 1
 * RedDel = 2
 *
 * KONSEP PENTING 
 * 1. ordinal = posisi
 * otomatis dari urutan penulisan enum
 *
 * 2. compareTo = bandingkan posisi
 * RedDel.compareTo(GoldenDel) → positif
 *
 * 3. equals vs ==
 * Cara	                Fungsi
 * ==	                bandingkan referensi (rekomendasi)
 * equals()	            bandingkan object
 *
 * di enum:
 * == sudah cukup dan aman
 *
 * CONTOH SIMPEL
 *
 * enum Level {
 *     LOW, MEDIUM, HIGH
 * }
 *
 * class Test {
 *     public static void main(String[] args) {
 *
 *         System.out.println(Level.LOW.ordinal()); // 0
 *
 *         if(Level.HIGH.compareTo(Level.LOW) > 0) {
 *             System.out.println("HIGH lebih tinggi dari LOW");
 *         }
 *     }
 * }
 *
 * --------------------------------------------------------
 * 
 * INTI YANG HARUS LU PAHAM
 * enum otomatis punya method dari Enum
 * ordinal() = posisi
 * compareTo() = banding posisi
 * equals() & == = banding object
 * enum itu object → bukan sekadar konstanta
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