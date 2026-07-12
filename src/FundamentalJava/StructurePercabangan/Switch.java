package FundamentalJava.StructurePercabangan;

/**
 * ------------------------------------------------------------------------
 * SWITCH STATEMENT
 * ------------------------------------------------------------------------
 * 
 * Switch adalah percabangan multi-arah (multiway branch) di Java.
 * 
 * Artinya:
 * Program bisa memilih banyak jalur eksekusi berdasarkan nilai suatu ekspresi.
 * 
 * Switch sering kali menjadi alternatif yang LEBIH BAIK dibandingkan
 * banyak if-else-if untuk kasus tertentu.
 * 
 * ------------------------------------------------------------------------
 * BATASAN SWITCH
 * ------------------------------------------------------------------------
 * 
 * Switch adalah alat yang powerful, tapi ada batasannya:
 * 
 * 1. Switch hanya bisa digunakan untuk perbandingan KESAMAAN (==)
 * 2. Hanya dengan tipe data:
 *    - byte, short, int, char
 *    - String (Java 7+)
 *    - enum
 * 3. TIDAK BISA digunakan dengan:
 *    - double atau float (angka desimal)
 *    - boolean
 *    - long (versi lama, Java 17+ sudah support)
 *    - Objek selain String
 * 
 * Karena keterbatasan ini, switch tidak bisa sepenuhnya menggantikan if-else.
 * Namun, untuk kasus membandingkan satu nilai dengan tiga atau lebih nilai
 * spesifik lainnya, switch sering membuat kode lebih RAPI dan MUDAH DIBACA.
 * 
 * ------------------------------------------------------------------------
 * BENTUK UMUM SWITCH
 * ------------------------------------------------------------------------
 * 
 *     switch (expression) {
 * 
 *         case value1:
 *             statement1;
 *             break;
 * 
 *         case value2:
 *             statement2;
 *             break;
 * 
 *         // ... banyak case lainnya ...
 * 
 *         case valueN:
 *             statementN;
 *             break;
 * 
 *         default:
 *             statementDefault;
 *     }
 * 
 * ------------------------------------------------------------------------
 * PENJELASAN BAGIAN-BAGIAN SWITCH
 * ------------------------------------------------------------------------
 * 
 * Bagian        | Fungsi
 * --------------|-----------------------------------------------------------
 * expression    | Nilai yang akan diperiksa/dibandingkan
 * case          | Nilai spesifik yang dibandingkan dengan expression
 * break         | Keluar dari switch (menghentikan eksekusi)
 * default       | Dijalankan jika TIDAK ADA case yang cocok (opsional)
 * 
 * ------------------------------------------------------------------------
 * CARA KERJA SWITCH
 * ------------------------------------------------------------------------
 * 
 * Langkah eksekusi:
 * 
 * 1. Program menghitung nilai expression
 * 2. Nilai tersebut dibandingkan dengan setiap case secara berurutan
 * 3. Jika cocok → kode dalam case dijalankan
 * 4. Jika break ditemukan → keluar dari switch
 * 5. Jika tidak ada yang cocok → default dijalankan (jika ada)
 * 
 * ------------------------------------------------------------------------
 * CONTOH SWITCH SEDERHANA
 * ------------------------------------------------------------------------
 * 
 *     int hari = 3;
 *     String namaHari;
 * 
 *     switch (hari) {
 *         case 1:
 *             namaHari = "Senin";
 *             break;
 *         case 2:
 *             namaHari = "Selasa";
 *             break;
 *         case 3:
 *             namaHari = "Rabu";
 *             break;
 *         case 4:
 *             namaHari = "Kamis";
 *             break;
 *         case 5:
 *             namaHari = "Jumat";
 *             break;
 *         case 6:
 *             namaHari = "Sabtu";
 *             break;
 *         case 7:
 *             namaHari = "Minggu";
 *             break;
 *         default:
 *             namaHari = "Hari tidak valid";
 *     }
 * 
 *     System.out.println(namaHari); // Output: Rabu
 * 
 * ------------------------------------------------------------------------
 * FUNGSI BREAK (PENTING!)
 * ------------------------------------------------------------------------
 * 
 * break digunakan untuk:
 * KELUAR dari switch.
 * 
 * Jika break dijalankan, program LANGSUNG keluar dari switch,
 * tanpa melanjutkan ke case berikutnya.
 * 
 *     switch (x) {
 *         case 1:
 *             System.out.println("Satu");
 *             break;   // Keluar dari switch
 *         case 2:
 *             System.out.println("Dua");
 *             break;
 *     }
 * 
 * ------------------------------------------------------------------------
 * FALL-THROUGH (Jika Break Tidak Ada)
 * ------------------------------------------------------------------------
 * 
 * Jika break TIDAK ditulis, program akan LANJUT ke case berikutnya.
 * Ini disebut fall-through.
 * 
 *     int x = 1;
 * 
 *     switch (x) {
 *         case 1:
 *             System.out.println("Satu");
 *             // Tidak ada break!
 *         case 2:
 *             System.out.println("Dua");
 *             break;
 *     }
 * 
 *     // Output:
 *     // Satu
 *     // Dua
 * 
 *     // Karena case 1 tidak punya break, program "jatuh" ke case 2
 * 
 * Fall-through bisa dimanfaatkan untuk menggabungkan beberapa case:
 * 
 *     switch (nilai) {
 *         case 1:
 *         case 2:
 *         case 3:
 *             System.out.println("Nilai rendah");
 *             break;
 *         case 4:
 *         case 5:
 *             System.out.println("Nilai tinggi");
 *             break;
 *     }
 * 
 * ------------------------------------------------------------------------
 * SWITCH DENGAN STRING (Java 7+)
 * ------------------------------------------------------------------------
 * 
 *     String warna = "merah";
 * 
 *     switch (warna.toLowerCase()) {
 *         case "merah":
 *             System.out.println("Berhenti");
 *             break;
 *         case "kuning":
 *             System.out.println("Hati-hati");
 *             break;
 *         case "hijau":
 *             System.out.println("Jalan");
 *             break;
 *         default:
 *             System.out.println("Warna tidak dikenal");
 *     }
 * 
 * ------------------------------------------------------------------------
 * SWITCH EXPRESSION (Java 14+ - MODERN)
 * ------------------------------------------------------------------------
 * 
 * Java modern (14+) memiliki switch expression yang lebih ringkas:
 * 
 *     // Tanpa break, pakai -> (arrow)
 *     String hasil = switch (hari) {
 *         case 1, 2, 3, 4, 5 -> "Hari kerja";
 *         case 6, 7 -> "Akhir pekan";
 *         default -> "Tidak valid";
 *     };
 * 
 *     // Atau pakai yield untuk nilai balik
 *     int poin = switch (peringkat) {
 *         case "A" -> 100;
 *         case "B" -> 80;
 *         case "C" -> 60;
 *         default -> {
 *             System.out.println("Peringkat tidak valid");
 *             yield 0;
 *         }
 *     };
 * 
 * ------------------------------------------------------------------------
 * CATATAN PENTING: INTEGER LEBIH CEPAT DARI STRING
 * ------------------------------------------------------------------------
 * 
 * Walaupun switch bisa pakai String,
 * biasanya switch dengan integer LEBIH CEPAT.
 * 
 * Jadi:
 * - Gunakan integer jika memungkinkan
 * - Gunakan String hanya jika data memang String
 * - Jangan dipaksa mengubah String ke integer hanya untuk switch
 * 
 * ------------------------------------------------------------------------
 * RINGKASAN KONSEP SWITCH
 * ------------------------------------------------------------------------
 * 
 * Konsep          | Arti
 * ----------------|-----------------------------------------------------------
 * switch          | Percabangan banyak arah (multiway branch)
 * case            | Nilai spesifik yang diperiksa
 * break           | Keluar dari switch (menghentikan eksekusi)
 * default         | Kondisi jika tidak ada case yang cocok
 * fall-through    | Lanjut ke case berikutnya jika tidak ada break
 * 
 * Kapan pakai switch:
 * - Banyak pilihan (3+ case)
 * - Perbandingan kesetaraan (==)
 * - Tipe data: int, char, String, enum
 * 
 * Kapan pakai if-else:
 * - Perbandingan kompleks (>, <, >=, <=, &&, ||)
 * - Hanya 1-2 pilihan
 * - Tipe data: boolean, double, float
 * 
 * ------------------------------------------------------------------------
 */

public class Switch {
    public static void main(String[] args) {

        // Contoh program
        for (int i = 0; i < 6; i++)
            switch (i) {
                case 0:
                    System.out.println("i is zero.");
                    break;
                case 1:
                    System.out.println("i is one.");
                    break;
                case 2:
                    System.out.println("i is two.");
                    break;
                case 3:
                    System.out.println("i is three.");
                    break;
                default:
                    System.out.println("i is greater than 3.");
            }

        /**
         * Output
         * i is zero.
         * i is one.
         * i is two.
         * i is three.
         * i is greater than 3.
         * i is greater than 3.
         *
         * Penjelasan:
         * for akan mengulang switch sebanyak kondisinya, meskipun gak pake block kode.
         * pada iterasi 1 dia akan memberikan nilai 0 dan switch akan mencetak case 1
         * pada iterasi 2 dia akan memberikan nilai 1 dan switch akan mencetak case 2
         * pada iterasi 3 dia akan memberikan nilai 2 dan switch akan mencetak case 3
         * pada iterasi 4 dia akan memberikan nilai 0 dan switch akan mencetak default
         * pada iterasi 5 dia akan memberikan nilai 0 dan switch akan mencetak default
         *
         * Mudahkan.
         */

        System.out.println("----------");

        // Contoh program tanpa break
        for (int i = 0; i < 12; i++)
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    System.out.println("i is less than 5.");
                    break; // opsional
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    System.out.println("i is less than 10.");
                    break; // opsional
                default:
                    System.out.println("i is 10 or more.");
            }

        /**
         * Output
         * i is less than 5.
         * i is less than 5.
         * i is less than 5.
         * i is less than 5.
         * i is less than 5.
         * i is less than 10.
         * i is less than 10.
         * i is less than 10.
         * i is less than 10.
         * i is less than 10.
         * i is 10 or more.
         * i is 10 or more.
         *
         * Penjelasan:
         * Sederhananya iterasi 0 sampai 4 dia akan mencetak - i is less than 5.
         * iterasi ini berhenti karena ada break, fall through berhenti.
         * saat iterasi ke 5 sampai 9 dia akan mencetak - i is less than 10.
         * iterasi ini berhenti karena ada break,
         * hingga kondisi iterasi terakhir dia akan mencetak default.
         *
         * Intinya kalo gak ada break, setiap iterasi akan mencetak semuanya sampai bawah.
         */

        System.out.println("----------");

        // Use a string to control a switch statement.
        String str = "two";
        switch (str) {
            case "one":
                System.out.println("one");
                break;
            case "two":
                System.out.println("two");
                break;
            case "three":
                System.out.println("three");
                break;
            default:
                System.out.println("no match.");
        }

        System.out.println("----------");

        // with char
        char inisial = 'F';
        switch (inisial) {
            case 'A':
                System.out.println("A");
                break;
            case 'B':
                System.out.println("B");
                break;
            case 'C':
                System.out.println("C");
                break;
            case 'E':
                System.out.println("E");
                break;
            case 'F':
                System.out.println("F");
                break;
            default:
                System.out.println("Karakter no match.");
        }

        System.out.println("----------");

        /**
         * BERBAGI KODE DI SWITCH STATEMENT
         * Salah satu kekuatan terbesar dari switch adalah kemampuannya untuk berbagi kode.
         * ini bisa dilakukan dengan dua cara
         * berbagi aksi untuk banyak case - seperti skenario bulan
         */

        int month = 2;
        boolean leapYear = true; // ubah ke false kalau bukan kabisat.
        int numberOfDays;

        switch (month) {
            case 1: // Januari
            case 3: // Maret
            case 5: // Mei
            case 7: // Juli
            case 8: // Agustus
            case 10: // Oktober
            case 12: // Desember
                numberOfDays = 31;
                break;
            case 2: // Februari
                if (leapYear)
                    numberOfDays = 29;
                else
                    numberOfDays = 28;
                break;
            case 4: // April
            case 6: // Juni
            case 9: // September
            case 11: // November
                numberOfDays = 30;
                break;
            default:
                numberOfDays = 0;
                break;
        }

        System.out.println("Jumlah hari pada bulan " + month + " = " + numberOfDays);

        System.out.println("----------");

        // Versi modern java 14+ dengan switch expression
        int bulan = 2;
        boolean tahunKabisat = true; // ubah ke false kalau bukan kabisat
        int nomorHari = switch (bulan) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> tahunKabisat ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> 0;
        };

        System.out.println("Jumlah hari pada bulan " + bulan + " = " + nomorHari);

        /**
         * Perbedaan utama
         *  versi konvensional pakai break untuk keluar dari case.
         *  versi modern lebih singkat, gak perlu break, langsung return value ke variabel.
         */

    }
}
