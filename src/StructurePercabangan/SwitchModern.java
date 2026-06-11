package StructurePercabangan;

public class SwitchModern {
    public static void main(String[] args) {

        /**
         * Switch expression / modern switch di Java.
         * 
         * Ini mulai diperkenalkan di Java 12 (preview) dan resmi stabil di Java 14.
         *
         * Syntax ini dibuat supaya:
         * -kode lebih pendek
         * -tidak perlu break
         * -tidak ada bug fall-through
         * -bisa mengembalikan nilai seperti expression
         *
         * Switch Modern (Arrow Syntax)
         * Java modern memperkenalkan arrow -> syntax.
         * Contoh:
         * int day = 3;
         * switch(day) {
         *     case 1 -> System.out.println("Monday");
         *     case 2 -> System.out.println("Tuesday");
         *     case 3 -> System.out.println("Wednesday");
         *     default -> System.out.println("Unknown");
         * }
         *
         * Perubahan penting:
         * Lama	                Baru
         * :	                ->
         * perlu break	        tidak perlu
         * bisa fall-through	tidak bisa
         *
         * Karena setiap case langsung selesai.
         *
         * Multiple Case dalam Modern Switch
         * Sekarang kita bisa gabungkan case.
         * Contoh:
         * int day = 6;
         * switch(day) {
         *     case 1,2,3,4,5 -> System.out.println("Weekday");
         *     case 6,7 -> System.out.println("Weekend");
         * }
         *
         * Switch Sebagai Expression
         * Inilah fitur paling powerful.
         * Switch bisa langsung menghasilkan nilai.
         * Contoh:
         * int day = 3;
         * String name = switch(day) {
         *     case 1 -> "Monday";
         *     case 2 -> "Tuesday";
         *     case 3 -> "Wednesday";
         *     default -> "Unknown";
         * };
         *
         * System.out.println(name);
         * Perhatikan:
         * String name = switch(...)
         * Switch sekarang return value.
         *
         * Multi Statement Case (Block Case)
         * Kalau dalam case ada banyak statement, kita pakai block {}.
         * Contoh:
         * int day = 2;
         *
         * String result = switch(day) {
         *
         *     case 1 -> {
         *         System.out.println("processing monday");
         *         yield "Monday";
         *     }
         *
         *     case 2 -> {
         *         System.out.println("processing tuesday");
         *         yield "Tuesday";
         *     }
         *
         *     default -> "Unknown";
         * };
         *
         * System.out.println(result);
         *
         * Di sini muncul keyword baru:
         * yield
         * Fungsi yield
         * yield digunakan untuk:
         * mengembalikan nilai dari switch expression
         * Contoh:
         * yield "Monday"
         * Artinya:
         * nilai switch = "Monday"
         *
         * Perbandingan Switch Lama vs Baru
         * Fitur	        Switch Lama	        Switch Baru
         * syntax	            :	                ->
         * break	          wajib	            tidak perlu
         * fall-through	      bisa	            tidak
         * return value	      tidak	            bisa
         * multiple case	  sulit	            mudah
         */

        /**
         * PENTING, perbedaan switch sebagai ekspresi dan statement
         * 
         * 1. Switch sebagai Statement (tidak perlu ;)
         * Kalau switch hanya dipakai untuk menjalankan aksi, dia adalah statement,
         * jadi tidak perlu titik koma di akhir.
         *
         * 2. Switch sebagai Expression (harus ada ;)
         * Kalau switch menghasilkan nilai, dia jadi expression.
         * Karena expression biasanya berada di dalam assignment, maka harus diakhiri ;.
         * Kenapa?
         * Karena sebenarnya yang terjadi adalah:
         * String name = (hasil switch);
         * Dan assignment statement selalu diakhiri ;.
         *
         * Keyword yield
         * 
         * 1- Switch Expression Tanpa yield
         * Kalau setiap case hanya satu nilai, kita bisa langsung pakai ->.
         *
         * 2- Masalah Jika Case Punya Banyak Statement
         * Kadang kita ingin melakukan beberapa proses dulu.
         * Solusinya: yield
         * Untuk mengembalikan nilai dari block case, kita pakai yield.
         * yield artinya:
         * kembalikan nilai ini sebagai hasil switch
         *
         * Kenapa Tidak Pakai return?
         * Karena return digunakan untuk keluar dari method, bukan dari switch.
         * Contoh:
         * return value → keluar dari method
         * yield value → keluar dari switch expression
         * Jadi fungsi mereka berbeda.
         */

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
