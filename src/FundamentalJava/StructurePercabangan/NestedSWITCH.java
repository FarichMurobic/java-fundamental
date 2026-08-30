package FundamentalJava.StructurePercabangan;

/**
 * ------------------------------------------------------------------------
 * NESTED SWITCH STATEMENTS
 * ------------------------------------------------------------------------
 * 
 * Kita bisa menaruh sebuah switch di dalam switch lain.
 * Ini disebut nested switch..
 * 
 * Karena setiap switch memiliki bloknya sendiri { },
 * tidak ada konflik antara nilai case di switch luar dan switch dalam.
 * 
 * ------------------------------------------------------------------------
 * KONSEP DASAR
 * ------------------------------------------------------------------------
 * 
 * Program bekerja seperti dua tahap pengecekan.
 * 
 * Urutannya:
 * 
 * cek switch pertama (luar)
 * ↓
 * jika cocok → masuk ke blok case
 * ↓
 * cek switch kedua (dalam)
 * ↓
 * jika cocok → jalankan statement
 * 
 * Jadi seperti pintu dua lapis.
 * 
 * ------------------------------------------------------------------------
 * BENTUK UMUM
 * ------------------------------------------------------------------------
 * 
 * switch (variabelLuar) {
 * case nilai1:
 * // kode di sini
 * 
 * switch (variabelDalam) {
 * case nilaiA:
 * // statement
 * break;
 * case nilaiB:
 * // statement
 * break;
 * default:
 * // statement default
 * }
 * break;
 * 
 * case nilai2:
 * // kode di sini
 * break;
 * 
 * default:
 * // statement default
 * }
 * 
 * ------------------------------------------------------------------------
 * CONTOH KASUS NYATA
 * ------------------------------------------------------------------------
 * 
 * Kasus: Menu berdasarkan department dan level
 * 
 * String department = "IT";
 * int level = 2;
 * 
 * switch (department) {
 * case "IT":
 * System.out.println("Department: IT");
 * 
 * switch (level) {
 * case 1:
 * System.out.println("Level 1: Support IT");
 * break;
 * case 2:
 * System.out.println("Level 2: Junior Developer");
 * break;
 * case 3:
 * System.out.println("Level 3: Senior Developer");
 * break;
 * default:
 * System.out.println("Level tidak valid di IT");
 * }
 * break;
 * 
 * case "HR":
 * System.out.println("Department: HR");
 * 
 * switch (level) {
 * case 1:
 * System.out.println("Level 1: HR Staff");
 * break;
 * case 2:
 * System.out.println("Level 2: HR Supervisor");
 * break;
 * default:
 * System.out.println("Level tidak valid di HR");
 * }
 * break;
 * 
 * default:
 * System.out.println("Department tidak dikenal");
 * }
 * 
 * // Output:
 * // Department: IT
 * // Level 2: Junior Developer
 * 
 * ------------------------------------------------------------------------
 * TIGA HAL PENTING TENTANG SWITCH
 * ------------------------------------------------------------------------
 * 
 * 1. Switch Hanya Bisa Cek KESAMAAN (Equality)
 * 
 * Switch hanya bisa membandingkan:
 * nilai == case
 * 
 * Sedangkan if lebih fleksibel:
 * >, <, >=, <=, !=, &&, ||, dll.
 * 
 * Perbandingan:
 * 
 * if | switch
 * ---------------------------|-----------------------
 * Bisa semua kondisi | Hanya equality (==)
 * Fleksibel | Terbatas
 * 
 * 2. Case Tidak Boleh Sama dalam Satu Switch
 * 
 * SALAH (error):
 * 
 * switch (x) {
 * case 1: ...
 * case 1: ... // ERROR! Duplikat case
 * }
 * 
 * BENAR (boleh, karena beda switch):
 * 
 * switch (x) {
 * case 1:
 * switch (y) {
 * case 1: ... // Boleh, beda switch
 * case 2: ...
 * }
 * break;
 * case 2: ...
 * }
 * 
 * 3. Switch Biasanya Lebih Cepat dari If Bertingkat
 * 
 * Kenapa?
 * Karena compiler Java membuat sesuatu yang disebut:
 * JUMP TABLE (Tabel Lompat)
 * 
 * ------------------------------------------------------------------------
 * APA ITU JUMP TABLE?
 * ------------------------------------------------------------------------
 * 
 * Ketika Java mengcompile switch, compiler membuat tabel lompat.
 * 
 * Contoh:
 * 
 * switch (x) {
 * case 1: // kode A
 * case 2: // kode B
 * case 3: // kode C
 * case 4: // kode D
 * }
 * 
 * Compiler membuat tabel seperti ini:
 * 
 * 1 → lompat ke kode A
 * 2 → lompat ke kode B
 * 3 → lompat ke kode C
 * 4 → lompat ke kode D
 * 
 * Program langsung lompat ke case yang cocok,
 * tanpa mengecek satu per satu.
 * 
 * ------------------------------------------------------------------------
 * KENAPA IF LEBIH LAMBAT?
 * ------------------------------------------------------------------------
 * 
 * Jika memakai:
 * 
 * if (x == 1) {
 * // kode A
 * } else if (x == 2) {
 * // kode B
 * } else if (x == 3) {
 * // kode C
 * } else if (x == 4) {
 * // kode D
 * }
 * 
 * Program harus mengecek satu per satu:
 * 
 * cek 1 → tidak
 * cek 2 → tidak
 * cek 3 → ya! jalankan
 * 
 * Sedangkan switch bisa langsung lompat.
 * 
 * Makanya untuk BANYAK PILIHAN nilai,
 * switch lebih cepat dari if-else-if.
 * 
 * ------------------------------------------------------------------------
 * KAPAN PAKAI SWITCH VS IF?
 * ------------------------------------------------------------------------
 * 
 * Gunakan SWITCH jika:
 * - Mengecek satu variabel
 * - Nilai yang dicek FIXED (konstan)
 * - Banyak pilihan (lebih dari 3-4)
 * - Tipe data: byte, short, int, char, String, enum
 * 
 * Gunakan IF jika:
 * - Kondisi kompleks (>, <, >=, <=, &&, ||)
 * - Mengecek rentang nilai
 * - Kondisi boolean
 * - Hanya 1-2 pilihan
 * 
 * ------------------------------------------------------------------------
 * RINGKASAN NESTED SWITCH
 * ------------------------------------------------------------------------
 * 
 * Konsep | Penjelasan
 * ------------------|---------------------------------------------------
 * nested switch | Switch di dalam switch
 * scope | Setiap switch punya blok sendiri { }
 * case | Tidak konflik antar switch (boleh sama)
 * break | Keluar dari switch yang sedang berjalan
 * jump table | Membuat switch lebih cepat dari if bertingkat
 * 
 * ------------------------------------------------------------------------
 */

public class NestedSWITCH {
    public static void main(String[] args) {

        int count = 1;
        int target = 0;

        switch (count) { // perhatikan variabel count
            case 1: // case 1 awal
                switch (target) { // perhatikan variabel target
                    case 0:
                        System.out.println("target is zero");
                        break;
                    case 1:
                        System.out.println("target is one");
                        break;
                }
                break; // break dari case 1 awal
            case 2:
                System.out.println("Freedom");
                break;
            default:
                System.out.println("Free");
        }

        /**
         * Output
         * target is zero
         *
         * Penjelasan:
         * switch pertama akan dijalankan dulu jika true.
         * kemudian menjalankan switch kedua jika ada yang true.
         */

    }
}
