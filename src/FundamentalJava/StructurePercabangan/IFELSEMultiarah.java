package FundamentalJava.StructurePercabangan;

/**
 * ------------------------------------------------------------------------
 * THE IF-ELSE-IF LADDER
 * ------------------------------------------------------------------------
 * 
 * Salah satu struktur pemrograman yang paling umum digunakan adalah
 * if-else-if ladder (tangga if-else-if)..
 * 
 * Struktur ini berdasarkan serangkaian if yang bersarang (nested),
 * namun ditulis secara berurutan dan rapi.
 * 
 * ------------------------------------------------------------------------
 * BENTUK UMUM
 * ------------------------------------------------------------------------
 * 
 * if (kondisi1) {
 * // statement jika kondisi1 true
 * } else if (kondisi2) {
 * // statement jika kondisi2 true
 * } else if (kondisi3) {
 * // statement jika kondisi3 true
 * } else {
 * // statement default jika semua kondisi false
 * }
 * 
 * ------------------------------------------------------------------------
 * CARA KERJA
 * ------------------------------------------------------------------------
 * 
 * 1. Kondisi dievaluasi dari ATAS ke BAWAH (secara berurutan)
 * 2. Begitu ada kondisi yang bernilai TRUE:
 * - Statement yang terkait akan DIJALANKAN
 * - Sisa kondisi di bawahnya TIDAK diperiksa lagi
 * - Program LANGSUNG KELUAR dari struktur if-else-if
 * 3. Jika TIDAK ADA kondisi yang bernilai TRUE:
 * - Blok else terakhir akan dijalankan (jika ada)
 * - else berfungsi sebagai DEFAULT condition
 * 
 * ------------------------------------------------------------------------
 * CONTOH SEDERHANA
 * ------------------------------------------------------------------------
 * 
 * int nilai = 85;
 * 
 * if (nilai >= 90) {
 * System.out.println("Nilai A");
 * } else if (nilai >= 80) {
 * System.out.println("Nilai B");
 * } else if (nilai >= 70) {
 * System.out.println("Nilai C");
 * } else {
 * System.out.println("Nilai D");
 * }
 * 
 * // Output: Nilai B
 * // Karena nilai 85 memenuhi kondisi kedua (nilai >= 80)
 * // Kondisi ketiga (nilai >= 70) TIDAK diperiksa lagi
 * 
 * ------------------------------------------------------------------------
 * PENTING! BEGITU SATU KONDISI BENAR, BERHENTI
 * ------------------------------------------------------------------------
 * 
 * Program LANGSUNG berhenti mengecek kondisi yang lain
 * begitu satu kondisi bernilai true.
 * 
 * Ini adalah perilaku yang HARUS dipahami:
 * 
 * int x = 5;
 * 
 * if (x > 0) {
 * System.out.println("Positif"); // Ini yang dijalankan
 * } else if (x > 10) {
 * System.out.println("Lebih dari 10"); // TIDAK diperiksa
 * }
 * 
 * // Output: Positif
 * // Meskipun x > 10 juga false, tapi karena kondisi pertama sudah true,
 * // kondisi kedua tidak pernah diperiksa
 * 
 * ------------------------------------------------------------------------
 * URUTAN LOGIKA SANGAT PENTING
 * ------------------------------------------------------------------------
 * 
 * Dalam if-else-if ladder, URUTAN kondisi sangat menentukan hasil.
 * 
 * Aturan utama:
 * Susun kondisi dari yang PALING SPESIFIK ke yang PALING UMUM.
 * 
 * Contoh SALAH (urutan salah):
 * 
 * int nilai = 85;
 * 
 * if (nilai >= 70) { // Terlalu umum di posisi pertama
 * System.out.println("Lulus");
 * } else if (nilai >= 90) { // Tidak akan pernah dieksekusi!
 * System.out.println("Nilai A");
 * }
 * 
 * // Output: Lulus
 * // Meskipun nilai 85 seharusnya mendapat "Nilai A"
 * // Tapi karena kondisi "nilai >= 70" lebih dulu true,
 * // kondisi "nilai >= 90" tidak pernah diperiksa
 * 
 * Contoh BENAR (urutan benar):
 * 
 * int nilai = 85;
 * 
 * if (nilai >= 90) { // Paling spesifik (tertinggi)
 * System.out.println("Nilai A");
 * } else if (nilai >= 80) { // Lebih umum
 * System.out.println("Nilai B");
 * } else if (nilai >= 70) { // Lebih umum lagi
 * System.out.println("Nilai C");
 * } else { // Paling umum (default)
 * System.out.println("Nilai D");
 * }
 * 
 * // Output: Nilai B (benar)
 * 
 * ------------------------------------------------------------------------
 * ANALOGI URUTAN (BIAR KEBAYANG)
 * ------------------------------------------------------------------------
 * 
 * Bayangkan seperti antrian prioritas:
 * 
 * 1. Yang paling spesifik/prioritas tinggi dicek dulu
 * 2. Baru turun ke yang lebih umum
 * 3. Kalau yang spesifik terpenuhi, yang lain tidak dicek
 * 
 * Seperti:
 * "Apakah ini emergency?" → "Apakah ini serius?" → "Apakah ini ringan?"
 * Bukan sebaliknya!
 * 
 * ------------------------------------------------------------------------
 * KASUS NILAI (DARI TERTINGGI KE TERENDAH)
 * ------------------------------------------------------------------------
 * 
 * Untuk kasus penilaian, urutan harus dari nilai tertinggi ke terendah:
 * 
 * // BENAR
 * if (nilai >= 90) { ... }
 * else if (nilai >= 80) { ... }
 * else if (nilai >= 70) { ... }
 * else { ... }
 * 
 * // SALAH
 * if (nilai >= 70) { ... }
 * else if (nilai >= 80) { ... }
 * else if (nilai >= 90) { ... }
 * 
 * ------------------------------------------------------------------------
 * IF-ELSE-IF vs SWITCH
 * ------------------------------------------------------------------------
 * 
 * Gunakan if-else-if jika:
 * - Kondisi bersifat kompleks (>, <, >=, <=, !=, kombinasi logika)
 * - Mengecek rentang nilai
 * - Kondisi menggunakan tipe data boolean atau non-primitif
 * 
 * Gunakan switch jika:
 * - Kondisi hanya mengecek kesetaraan (==)
 * - Mengecek satu variabel dengan banyak nilai fixed
 * - Tipe data: byte, short, int, char, String, enum
 * 
 * ------------------------------------------------------------------------
 * KESIMPULAN WAJIB
 * ------------------------------------------------------------------------
 * 
 * 1. if-else-if ladder mengecek kondisi dari ATAS ke BAWAH
 * 2. Begitu true, LANGSUNG KELUAR (kondisi bawah tidak dicek)
 * 3. URUTAN SANGAT PENTING!
 * 4. Susun dari PALING SPESIFIK ke PALING UMUM
 * 5. Untuk nilai: dari TERTINGGI ke TERENDAH
 * 6. else terakhir = default (jika semua kondisi false)
 * 7. Jika tidak ada else dan semua false → TIDAK ADA yang dijalankan
 * 
 * ------------------------------------------------------------------------
 */

public class IFELSEMultiarah {
    public static void main(String[] args) {

        int wats = 95;
        String gradeAssigned;

        if (wats >= 90)
            gradeAssigned = "A";
        else if (wats >= 85)
            gradeAssigned = "A-";
        else if (wats >= 80)
            gradeAssigned = "B";
        else if (wats >= 75)
            gradeAssigned = "B-";
        else if (wats >= 70)
            gradeAssigned = "C";
        else if (wats >= 60)
            gradeAssigned = "D";
        else
            gradeAssigned = "F";

        System.out.println(gradeAssigned);

        // Efisiensi: Jika wats adalah 95, program akan mengecek if pertama, melihat itu
        // true, lalu langsung memberikan nilai "A", dan berhenti.
        // Tidak ada pengecekan yg sia-sia.

        // Latihan
        String[] nameDrink = { "Fanta", "Kopi", "Aqua" };
        int number1 = 5;

        if (number1 == 1) {
            System.out.println(nameDrink[0]);
        } else if (number1 == 2) {
            System.out.println(nameDrink[1]);
        } else if (number1 == 3) {
            System.out.println(nameDrink[2]);
        } else {
            System.out.println("Number tidak valid");
        }

    }
}
