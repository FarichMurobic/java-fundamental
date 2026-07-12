package FundamentalJava.StructurePercabangan;

/**
 * ------------------------------------------------------------------------
 * SWITCH EXPRESSION (MODERN SWITCH) - JAVA 14+
 * ------------------------------------------------------------------------
 * 
 * Switch expression mulai diperkenalkan di Java 12 (sebagai preview)
 * dan resmi stabil di Java 14.
 * 
 * Syntax ini dibuat supaya:
 * - Kode lebih pendek dan bersih
 * - Tidak perlu break
 * - Tidak ada bug fall-through
 * - Bisa mengembalikan nilai seperti expression
 * 
 * ------------------------------------------------------------------------
 * SWITCH MODERN (ARROW SYNTAX)
 * ------------------------------------------------------------------------
 * 
 * Java modern memperkenalkan arrow -> syntax.
 * 
 *     int day = 3;
 * 
 *     switch (day) {
 *         case 1 -> System.out.println("Monday");
 *         case 2 -> System.out.println("Tuesday");
 *         case 3 -> System.out.println("Wednesday");
 *         case 4 -> System.out.println("Thursday");
 *         case 5 -> System.out.println("Friday");
 *         case 6 -> System.out.println("Saturday");
 *         case 7 -> System.out.println("Sunday");
 *         default -> System.out.println("Unknown");
 *     }
 * 
 * Perubahan penting:
 * 
 * Switch Lama         | Switch Modern
 * --------------------|------------------------------------------
 * Menggunakan :       | Menggunakan ->
 * Wajib break         | Tidak perlu break
 * Bisa fall-through   | Tidak bisa fall-through
 * 
 * Karena setiap case langsung selesai (tidak jatuh ke case berikutnya).
 * 
 * ------------------------------------------------------------------------
 * MULTIPLE CASE (MENGGABUNGKAN BEBERAPA CASE)
 * ------------------------------------------------------------------------
 * 
 * Sekarang kita bisa menggabungkan beberapa case dalam satu baris.
 * 
 *     int day = 6;
 * 
 *     switch (day) {
 *         case 1, 2, 3, 4, 5 -> System.out.println("Weekday");
 *         case 6, 7 -> System.out.println("Weekend");
 *         default -> System.out.println("Invalid day");
 *     }
 * 
 *     // Output: Weekend
 * 
 * ------------------------------------------------------------------------
 * SWITCH SEBAGAI EXPRESSION (MENGHASILKAN NILAI)
 * ------------------------------------------------------------------------
 * 
 * Inilah fitur paling powerful dari switch modern.
 * Switch bisa LANGSUNG menghasilkan nilai.
 * 
 *     int day = 3;
 * 
 *     String name = switch (day) {
 *         case 1 -> "Monday";
 *         case 2 -> "Tuesday";
 *         case 3 -> "Wednesday";
 *         case 4 -> "Thursday";
 *         case 5 -> "Friday";
 *         case 6 -> "Saturday";
 *         case 7 -> "Sunday";
 *         default -> "Unknown";
 *     };
 * 
 *     System.out.println(name); // Output: Wednesday
 * 
 * Perhatikan:
 * String name = switch(...)
 * 
 * Switch sekarang bisa mengembalikan nilai secara langsung.
 * 
 * ------------------------------------------------------------------------
 * SWITCH EXPRESSION DENGAN MULTIPLE CASE
 * ------------------------------------------------------------------------
 * 
 *     int day = 6;
 * 
 *     String tipeHari = switch (day) {
 *         case 1, 2, 3, 4, 5 -> "Hari Kerja";
 *         case 6, 7 -> "Akhir Pekan";
 *         default -> "Tidak Valid";
 *     };
 * 
 *     System.out.println(tipeHari); // Output: Akhir Pekan
 * 
 * ------------------------------------------------------------------------
 * MULTI STATEMENT CASE (BLOCK CASE)
 * ------------------------------------------------------------------------
 * 
 * Jika dalam case ada BANYAK statement, kita pakai block { }.
 * 
 *     int day = 2;
 * 
 *     String result = switch (day) {
 * 
 *         case 1 -> {
 *             System.out.println("Processing Monday...");
 *             yield "Monday";
 *         }
 * 
 *         case 2 -> {
 *             System.out.println("Processing Tuesday...");
 *             yield "Tuesday";
 *         }
 * 
 *         case 3 -> {
 *             System.out.println("Processing Wednesday...");
 *             yield "Wednesday";
 *         }
 * 
 *         default -> "Unknown";
 *     };
 * 
 *     System.out.println(result);
 * 
 *     // Output:
 *     // Processing Tuesday...
 *     // Tuesday
 * 
 * ------------------------------------------------------------------------
 * KEYWORD YIELD
 * ------------------------------------------------------------------------
 * 
 * Di sini muncul keyword baru:
 * yield
 * 
 * Fungsi yield:
 * Mengembalikan nilai dari switch expression.
 * 
 *     yield "Monday"
 * 
 * Artinya:
 * Nilai switch = "Monday"
 * 
 * Kenapa Tidak Pakai return?
 * 
 *     return value → keluar dari METHOD (seluruh method)
 *     yield value  → keluar dari SWITCH EXPRESSION (hanya switch)
 * 
 * Jadi fungsi mereka BERBEDA!
 * 
 * ------------------------------------------------------------------------
 * PERBANDINGAN SWITCH LAMA VS BARU
 * ------------------------------------------------------------------------
 * 
 * Fitur              | Switch Lama           | Switch Baru
 * -------------------|-----------------------|-------------------------------
 * Syntax             | :                     | ->
 * break              | WAJIB                 | TIDAK perlu
 * fall-through       | BISA                  | TIDAK bisa
 * Return value       | TIDAK bisa            | BISA (switch expression)
 * Multiple case      | SULIT                 | MUDAH (case 1,2,3)
 * Block case         | Bisa tapi berantakan  | Rapi dengan {}
 * 
 * ------------------------------------------------------------------------
 * SWITCH SEBAGAI STATEMENT vs EXPRESSION
 * ------------------------------------------------------------------------
 * 
 * 1. Switch sebagai Statement (tidak perlu ;)
 * 
 *    switch (day) {
 *        case 1 -> System.out.println("Monday");
 *        default -> System.out.println("Unknown");
 *    }
 *    // Tidak ada ; di akhir (ini statement)
 * 
 *    Switch hanya dipakai untuk menjalankan aksi,
 *    tidak menghasilkan nilai.
 * 
 * 2. Switch sebagai Expression (harus ada ;)
 * 
 *    String name = switch (day) {
 *        case 1 -> "Monday";
 *        default -> "Unknown";
 *    };   // <- WAJIB ada ; di sini!
 * 
 *    Switch menghasilkan nilai yang disimpan ke variabel.
 *    Karena expression berada di assignment,
 *    maka harus diakhiri dengan ;.
 * 
 *    Kenapa?
 *    Karena sebenarnya yang terjadi adalah:
 *    String name = (hasil switch);
 *    Dan assignment statement selalu diakhiri ;.
 * 
 * ------------------------------------------------------------------------
 * CONTOH LENGKAP DENGAN YIELD
 * ------------------------------------------------------------------------
 * 
 *     enum Status {
 *         SUCCESS, ERROR, PENDING
 *     }
 * 
 *     Status status = Status.PENDING;
 * 
 *     String pesan = switch (status) {
 *         case SUCCESS -> {
 *             log("Proses berhasil");
 *             yield "Berhasil!";
 *         }
 *         case ERROR -> {
 *             log("Terjadi error");
 *             yield "Gagal!";
 *         }
 *         case PENDING -> {
 *             log("Masih diproses");
 *             yield "Menunggu...";
 *         }
 *     };
 * 
 *     System.out.println(pesan);
 * 
 * ------------------------------------------------------------------------
 * KESIMPULAN SWITCH MODERN
 * ------------------------------------------------------------------------
 * 
 * 1. Gunakan -> bukan :
 * 2. Tidak perlu break
 * 3. Tidak ada fall-through
 * 4. Bisa langsung menghasilkan nilai (switch expression)
 * 5. Multiple case dengan koma: case 1, 2, 3 ->
 * 6. Untuk block case, gunakan { } dan yield untuk mengembalikan nilai
 * 7. Switch expression harus diakhiri dengan ;
 * 8. return untuk keluar dari method, yield untuk keluar dari switch
 * 
 * ------------------------------------------------------------------------
 */

public class SwitchModern {
    public static void main(String[] args) {

        int day = 3;
        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            default -> System.out.println("Unknown");
        }

        // Multiple Case dalam Modern Switch
        day = 6; // reset nilai
        switch (day) {
            case 1,2,3 -> System.out.println("Weekday");
            case 4,5,6 -> System.out.println("Weekend");
        }

        // Switch Sebagai Expression
        day = 3; // reset nilai
        String name = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Unknown";
        };

        System.out.println(name);

        // Multi Statement Case (Block Case)
        day = 2;
        String result = switch (day) {
            case 1 -> {
                System.out.println("Processing monday");
                yield "Monday"; // yield keyword baru untuk return value ke result
            }
            case 2 -> {
                System.out.println("Processing tuesday");
                yield "Tuesday";
            }
            default -> "Unknown";
        };

        System.out.println(result); // nilai didapat dari keyword yield

        // Contoh Switch dengan String (Modern)
        String command = "start";
        switch (command) {
            case "start" -> System.out.println("Starting");
            case "stop" -> System.out.println("Starting");
            case "restart" -> System.out.println("Starting");
            case "restaer" -> System.out.println("Starting");
            default -> System.out.println("Unknown command");
        }

        // Latihan
        int bulan = 2;
        boolean tahunKabisat = true; // ubah ke false kalau bukan kabisat
        int nomorHari = switch (bulan) {
            case 1, 3 -> {
                System.out.println("bulan 1 dan 3");
                yield 31;
            }
            case 5, 7, 8, 10, 12 -> 31;
            case 2 -> (tahunKabisat) ? 29 : 28; // operasi ternary dalam kurung opsional
            case 4, 6, 9, 11 -> 30;
            default -> 0;
        }; // titik koma akhir statement

    }
}
