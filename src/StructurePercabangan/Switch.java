package StructurePercabangan;

public class Switch {
    public static void main(String[] args) {

        /**
         * Switch
         * switch adalah percabangan multi-arah (multiway branch) di Java.
         * Artinya:
         * program bisa memilih banyak jalur eksekusi berdasarkan nilai suatu ekspresi.
         * Sering kali switch menjadi alternatif yang lebih baik dibandingkan banyak if-else-if.
         *
         * Switch adalah alat yg powerful, tapi ada batasannya,
         * switch tidak bisa digunakan untuk semua jenis perbandingan,
         * kita hanya bisa pakai switch untuk perbandingan kesetaraan ==
         * dan hanya dengan tipe data integral int, char, String, dll.
         * switch tidak bisa digunakan dengan angka desimal double atau float.
         * karena keterbatasan ini, switch tidak bisa sepenuhnya menggantikan if else, 
         * namun dalam kasus dimana kita perlu
         * membandingkan satu nilai dengan tiga atau lebih nilai spesifik lainnya,
         * switch sering kali membuat kode kita lebih rapi dangampang dibaca.
         *
         * Bentuk Umum Switch
         * switch(expression) {
         *
         *     case value1:
         *         statement;
         *         break;
         *
         *     case value2:
         *         statement;
         *         break;
         *
         *     ...
         *
         *     case valueN:
         *         statement;
         *         break;
         *
         *     default:
         *         statement;
         * }
         *
         * Penjelasan:
         * Bagian	        Fungsi
         * expression	    nilai yang akan diperiksa
         * case	            nilai yang dibandingkan
         * break	        keluar dari switch
         * default	        dijalankan jika tidak ada case cocok
         *
         * Cara Kerja Switch
         * Langkah eksekusinya:
         * 1-Program menghitung nilai expression
         * 2-Nilai itu dibandingkan dengan setiap case
         * 3-Jika cocok → kode dalam case dijalankan
         * 4-Jika tidak ada yang cocok → default dijalankan
         *
         * Fungsi break
         * break digunakan untuk:
         * keluar dari switch.
         * Jika break dijalankan, program langsung keluar dari switch.
         *
         * Jika break Tidak Ada (Fall Through)
         * Jika break tidak ditulis, program akan lanjut ke case berikutnya.
         *
         * Catatan Penting
         * Walaupun bisa pakai String, biasanya lebih cepat memakai integer.
         * Jadi gunakan String hanya jika:
         * datanya memang string
         * Jangan dipaksa.
         *
         * Ringkasan Konsep Switch:
         * Konsep	        Arti
         * switch	        percabangan banyak arah
         * case	            nilai yang diperiksa
         * break	        keluar dari switch
         * default	        kondisi jika tidak ada yang cocok
         * fall-through	    lanjut ke case berikutnya jika tidak ada break
         */

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
