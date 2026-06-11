package StructurePercabangan;

public class IFELSEMultiarah {
    public static void main(String[] args) {

        /**
         * The If Else If Ladder
         * Salah satu struktur pemrograman yang umum digunakan dan berdasarkan serangkaian if
         * yang bersarang (nested) adalah if-else-if ladder.
         *
         * Bentuk umumnya seperti ini:
         *
         * if(condition)
         *     statement;
         * else if(condition)
         *     statement;
         * else if(condition)
         *     statement;
         * ...
         * else
         *     statement;
         *
         * Cara kerjanya:
         *
         * if akan dievaluasi dari atas ke bawah.
         * Begitu ada kondisi yang bernilai true, maka:
         * statement yang terkait akan dijalankan
         * sisa kondisi di bawahnya tidak diperiksa lagi
         * Jika tidak ada kondisi yang bernilai true, maka:
         *
         * else terakhir akan dijalankan
         * else terakhir berfungsi sebagai default condition.
         * Artinya: jika semua kondisi sebelumnya gagal, maka jalankan statement di else.
         * Jika tidak ada else terakhir dan semua kondisi bernilai false, maka tidak ada kode yang dijalankan.
         *
         * PENTING:
         * Begitu satu kondisi benar, program langsung berhenti mengecek yang lain.
         *
         * Ini adalah cara yang lebih baik untuk menangani banyak kondisi yg saling eksklusif (hanya satu yg bisa benar).
         * Struktur ini adalah gabungan dari if dan else yang ditulis secara rapi tanpa lekukan yang dalam.
         *
         * Begitu salah satu kondisi benar, program akan langsung menjalankan aksinya dan berhenti, tanpa mengecek kondisi yg lain.
         * dalam urutan if else if, urutan logika itu sangat penting, kita harus hati-hati menyusunnya, karena program akan berhenti mengevaluasi
         * begitu hasil pertama true.
         * Agar kode if else if, bekerja dengan benar, anda harus menyusun ekspresi logika dari yg paling spesifik ke yang paling umum.
         * dalam kasus nilai, berarti dari nilai tertinggi ke terendah.
         */

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

        // Efisiensi: Jika wats adalah 95, program akan mengecek if pertama, melihat itu true, lalu langsung memberikan nilai "A", dan berhenti.
        // Tidak ada pengecekan yg sia-sia.

        // Latihan
        String[] nameDrink = {"Fanta", "Kopi", "Aqua"};
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
