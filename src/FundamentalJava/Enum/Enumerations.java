package FundamentalJava.Enum;

    /**
     * Enumerations
     *
     * Sebelum Java versi JDK 5, Java tidak punya fitur enumeration.
     * Padahal banyak programmer merasa fitur ini penting.
     *
     * Enumeration = daftar konstanta yang punya nama.
     *
     * Walaupun Java punya alternatif seperti final, tapi:
     * enum lebih “bersih secara konsep”
     * dan sudah umum di bahasa lain
     *
     * Mulai JDK 5, enum ditambahkan dan sekarang jadi bagian penting Java.
     *
     * Hal penting tentang enum di Java
     * Di Java, enum itu bukan cuma daftar biasa
     * Tapi sebuah class (tipe kelas)
     *
     * Artinya:
     * Bisa punya constructor
     * Bisa punya method
     * Bisa punya variabel
     *
     * Ini yang bikin enum Java powerful banget.
     * 
     * -------------------------------------------------------
     * 
     * ENUM FUNDAMENTALS
     * Cara bikin enum
     * CONTOH:
     *
     * enum Apple {
     *     Jonathan, GoldenDel, RedDel, Winesap, Cortland
     * }
     *
     * Penjelasan:
     * Jonathan, GoldenDel, dll → disebut enum constants
     * otomatis:
     * public
     * static
     * final
     *
     * Artinya:
     * bisa diakses
     * nilainya tetap (konstan)
     *
     * Tipe enum
     * Semua constant itu bertipe:
     * Apple
     *
     * disebut self-typed
     *
     * ----------------------------------------
     * 
     * CARA PAKAI ENUM
     * Deklarasi variabel
     * Apple ap;
     *
     * Kasih nilai
     * ap = Apple.RedDel;
     *
     * HARUS pakai:
     * NamaEnum.Nilai
     *
     * Perbandingan
     * if(ap == Apple.GoldenDel)
     *
     * enum bisa dibandingin pakai ==
     * (ini aman, beda sama object biasa)
     *
     * Dipakai di switch
     * switch(ap) {
     *     case Jonathan:
     *     case Winesap:
     * }
     *
     * Penting:
     * di dalam case → TIDAK perlu Apple.
     *
     * cukup:
     * case Winesap:
     *
     * Kalau lu tulis:
     * case Apple.Winesap:
     *
     * ERROR 
     *
     * OUTPUT ENUM
     * System.out.println(Apple.Winesap);
     *
     * Output:
     * Winesap
     *
     * enum gak bisa dibuat pakai new
     * 
     * --------------------------------------
     *
     * INTI YANG HARUS LU PAHAM
     * enum = daftar pilihan tetap
     * di Java = class
     * lebih aman daripada pakai angka/string
     * bisa dipakai:
     * variable
     * if
     * switch
     */

    /**
     * values() dan valueOf()
     *
     * Semua enum di Java otomatis punya 2 method bawaan:
     * public static enum-type[] values()
     * public static enum-type valueOf(String str)
     *
     * Penjelasan:
     * values() → mengembalikan array berisi semua konstanta enum
     * valueOf(String str) → mengembalikan konstanta enum yang sesuai dengan string
     *
     * enum-type = tipe enum itu sendiri
     *
     * Contoh:
     * Apple.valueOf("Winesap")
     *
     * hasilnya:
     * Winesap
     *
     * ---------------------------------------------------------------
     * 
     * Intinya:
     * values() = “ambil semua isi enum”
     * Kayak:
     * "Kasih gua semua jenis apel yang ada"
     *
     * valueOf() = “cari enum dari nama (String)”
     * Kayak:
     * "Gua punya tulisan 'Winesap', ubah jadi enum"
     *
     * ---------------------------------------------------------------
     * 
     * INTI YANG HARUS NANCEP
     * values() → ambil semua enum
     * valueOf() → ubah String jadi enum
     * enum itu:
     * punya method bawaan
     * bukan cuma konstanta biasa
     */

public enum Enumerations {
    Jonathan, Goldendel, RedDel, Winesap, Cortland
}

enum Status {
    Online, Offline, BUSY
}
