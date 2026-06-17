package FundamentalJava.Enum;

/**
 * ENUMERATIONS (ENUM)
 * ------------------------------------------------------------
 *
 * Sebelum JDK 5, Java belum memiliki fitur Enumeration (enum).
 * Untuk merepresentasikan sekumpulan nilai konstan, programmer
 * biasanya menggunakan:
 *
 * - final variable
 * - static final constant
 *
 * Namun pendekatan tersebut kurang aman dan kurang ekspresif.
 *
 * Mulai JDK 5, Java memperkenalkan enum sebagai tipe data khusus
 * untuk merepresentasikan sekumpulan konstanta yang saling
 * berhubungan.
 *
 * Enumeration (enum) adalah kumpulan nilai konstan yang memiliki
 * nama (named constants).
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
 * ------------------------------------------------------------
 * KARAKTERISTIK ENUM
 * ------------------------------------------------------------
 *
 * Berbeda dengan bahasa lain, enum di Java bukan sekadar daftar
 * konstanta.
 *
 * Enum di Java sebenarnya adalah class khusus.
 *
 * Karena merupakan class, enum dapat memiliki:
 *
 * - Constructor
 * - Method
 * - Instance Variable
 * - Static Member
 *
 * Namun enum memiliki beberapa aturan khusus:
 *
 * - Tidak dapat dibuat menggunakan operator new
 * - Semua konstanta dibuat otomatis saat enum dimuat
 * - Constructor enum selalu private secara implisit
 *
 * Flow:
 *
 * Enum Declaration
 *      ↓
 * Enum Constants Dibuat Otomatis
 *      ↓
 * Program Menggunakan Constant Tersebut
 *
 * ------------------------------------------------------------
 * ENUM CONSTANTS
 * ------------------------------------------------------------
 *
 * Pada contoh:
 *
 * enum Apple {
 *     Jonathan,
 *     GoldenDel,
 *     RedDel,
 *     Winesap,
 *     Cortland
 * }
 *
 * Semua nilai berikut:
 *
 * - Jonathan
 * - GoldenDel
 * - RedDel
 * - Winesap
 * - Cortland
 *
 * disebut:
 *
 * Enum Constants
 *
 * Setiap constant secara otomatis bersifat:
 *
 * - public
 * - static
 * - final
 *
 * Artinya:
 *
 * - Bisa diakses dari mana saja
 * - Hanya ada satu instance
 * - Tidak bisa diubah nilainya
 *
 * ------------------------------------------------------------
 * ENUM SEBAGAI TIPE DATA
 * ------------------------------------------------------------
 *
 * Enum mendefinisikan tipe data baru.
 *
 * Contoh:
 *
 * Apple ap;
 *
 * Variabel ap hanya dapat menyimpan nilai dari enum Apple.
 *
 * Contoh:
 *
 * ap = Apple.RedDel;
 *
 * Bukan:
 *
 * ap = 10;          // ERROR
 * ap = "RedDel";    // ERROR
 *
 * Karena tipe data variabel tersebut adalah Apple.
 *
 * ------------------------------------------------------------
 * MENGGUNAKAN ENUM
 * ------------------------------------------------------------
 *
 * Deklarasi:
 *
 * Apple ap;
 *
 * Memberikan nilai:
 *
 * ap = Apple.Winesap;
 *
 * Penulisan wajib menggunakan:
 *
 * NamaEnum.NamaConstant
 *
 * Contoh:
 *
 * Apple.GoldenDel
 * Apple.RedDel
 *
 * ------------------------------------------------------------
 * MEMBANDINGKAN ENUM
 * ------------------------------------------------------------
 *
 * Enum dapat dibandingkan menggunakan operator:
 *
 * ==
 *
 * Contoh:
 *
 * if(ap == Apple.GoldenDel) {
 *     ...
 * }
 *
 * Ini aman karena setiap constant enum hanya memiliki satu
 * instance.
 *
 * Berbeda dengan String yang biasanya dibandingkan menggunakan:
 *
 * equals()
 *
 * ------------------------------------------------------------
 * ENUM DALAM SWITCH
 * ------------------------------------------------------------
 *
 * Enum sangat sering digunakan pada switch.
 *
 * Contoh:
 *
 * switch(ap) {
 *     case Jonathan:
 *         break;
 *
 *     case Winesap:
 *         break;
 * }
 *
 * Perhatikan:
 *
 * Di dalam case TIDAK perlu menulis:
 *
 * Apple.Winesap
 *
 * Cukup:
 *
 * Winesap
 *
 * Karena compiler sudah mengetahui tipe enum yang digunakan.
 *
 * ------------------------------------------------------------
 * MENAMPILKAN ENUM
 * ------------------------------------------------------------
 *
 * Contoh:
 *
 * System.out.println(Apple.Winesap);
 *
 * Output:
 *
 * Winesap
 *
 * Secara otomatis Java akan menampilkan nama constant enum.
 *
 * ------------------------------------------------------------
 * BUILT-IN METHOD ENUM
 * ------------------------------------------------------------
 *
 * Setiap enum otomatis memiliki beberapa method bawaan.
 *
 * Dua yang paling sering digunakan:
 *
 * - values()
 * - valueOf()
 *
 * ------------------------------------------------------------
 * values()
 * ------------------------------------------------------------
 *
 * Signature:
 *
 * public static EnumType[] values()
 *
 * Fungsi:
 *
 * Mengembalikan seluruh constant enum dalam bentuk array.
 *
 * Contoh:
 *
 * for (Apple a : Apple.values()) {
 *     System.out.println(a);
 * }
 *
 * Output:
 *
 * Jonathan
 * GoldenDel
 * RedDel
 * Winesap
 * Cortland
 *
 * Cocok digunakan untuk:
 *
 * - Looping seluruh enum
 * - Menampilkan pilihan menu
 * - Validasi data
 *
 * ------------------------------------------------------------
 * valueOf()
 * ------------------------------------------------------------
 *
 * Signature:
 *
 * public static EnumType valueOf(String name)
 *
 * Fungsi:
 *
 * Mengubah String menjadi enum constant.
 *
 * Contoh:
 *
 * Apple ap = Apple.valueOf("Winesap");
 *
 * Hasil:
 *
 * ap = Apple.Winesap
 *
 * Jika nama tidak ditemukan:
 *
 * IllegalArgumentException
 *
 * akan dilempar oleh JVM.
 *
 * ------------------------------------------------------------
 * PERBEDAAN values() DAN valueOf()
 * ------------------------------------------------------------
 *
 * values()
 *
 * - Mengambil semua constant enum
 * - Return berupa array enum
 *
 * valueOf()
 *
 * - Mengubah String menjadi enum
 * - Return satu constant enum
 *
 * Analogi:
 *
 * values()
 * = "Kasih semua pilihan yang tersedia"
 *
 * valueOf()
 * = "Cari pilihan berdasarkan nama"
 *
 * ------------------------------------------------------------
 * KEUNGGULAN ENUM
 * ------------------------------------------------------------
 *
 * Dibandingkan menggunakan angka atau String biasa:
 *
 * - Lebih aman (type-safe)
 * - Lebih mudah dibaca
 * - Mengurangi bug
 * - Mudah digunakan pada switch
 * - Mendukung method dan constructor
 *
 * Contoh buruk:
 *
 * int status = 1;
 *
 * Sulit dipahami arti angka 1.
 *
 * Contoh lebih baik:
 *
 * Status status = Status.ACTIVE;
 *
 * Langsung jelas maksudnya.
 *
 * ------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------
 *
 * Enumeration (enum) adalah tipe data khusus yang berisi
 * sekumpulan konstanta bernama.
 *
 * Di Java, enum sebenarnya adalah class khusus sehingga dapat
 * memiliki:
 *
 * - Constructor
 * - Method
 * - Variable
 *
 * Method bawaan yang paling penting:
 *
 * - values()
 * - valueOf()
 *
 * Enum sangat sering digunakan untuk:
 *
 * - Status
 * - Role
 * - Kategori
 * - Tipe data tetap
 * - Switch expression
 *
 * Enum merupakan salah satu fitur Java yang membuat kode lebih
 * aman, lebih jelas, dan lebih mudah dipelihara dibandingkan
 * penggunaan angka atau String sebagai representasi nilai tetap.
 */

public enum Enumerations {
    Jonathan, Goldendel, RedDel, Winesap, Cortland
}

enum Status {
    Online, Offline, BUSY
}
