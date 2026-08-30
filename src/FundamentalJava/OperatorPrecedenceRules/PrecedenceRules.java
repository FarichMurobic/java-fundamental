package FundamentalJava.OperatorPrecedenceRules;

public class PrecedenceRules {
    public static void main(String[] args) {

        /**
         * Operator precedence adalah urutan prioritas operator saat Java menghitung
         * sebuah ekspresi..
         * 
         * Berikut urutan sederhananya.
         * 
         * Prioritas Operator
         * 1 ++ -- (postfix)
         * 2 ++ -- ~ ! + - (type cast)
         * 3 * / %
         * 4 + -
         * 5 >> << >>>
         * 6 > >= < <= instanceof
         * 7 == !=
         * 8 &
         * 9 ^
         * 10 |
         * 11 &&
         * 12 ||
         * 13 ?: (ternary)
         * 14 -> (lambda)
         * 15 = += -= *= /=
         * 
         * Yang paling rendah adalah assignment (=).
         *
         * Perbandingan Associavity Operator
         * Operator Associativity
         * Unary (! ~ ++ --) kanan → kiri
         * Arithmetic (+ - * /) kiri → kanan
         * Relational kiri → kanan
         * Logical kiri → kanan
         * Assignment (=) kanan → kiri
         * 
         * (Penting)
         * Menggunakan parentheses (tanda kurung) ().
         * tanda kurung menaikkan prioritas operasi
         * 
         * contoh:
         * a >> b + 3;
         * java membaca ini sebagai:
         * a >> (b + 3);
         * 
         * karena + lebih tinggi dari >>.
         * Tanda kurung tidak memperlambat program
         * Sederhananya ekspresi yang menggunakan tanda kurung adalah prioritas
         * tertinggi.
         */

        // Contoh 1: Perkalian lebih dulu dari penjumlahan
        // Sesuai aturan: 3 * 2 = 6, lalu 7 + 6 = 13
        int hasil1 = 7 + 3 * 2;
        System.out.println("7 + 3 * 2 = " + hasil1); // Output: 13

        // Contoh 2: Pengurangan dengan asosiativitas kiri ke kanan
        // Sesuai aturan: (13 - 7) = 6, lalu 6 - 2 = 4
        int hasil2 = 13 - 7 - 2;
        System.out.println("13 - 7 - 2 = " + hasil2); // Output: 4

        /**
         * 3: Ekspresi kompleks tanpa tanda kurung
         * Ikuti langkah-langkah seperti di pembahasan:
         * 1. Unary minus: (-4) * 2 + 8 - 9 / 3 * 5 + 7
         * 2. Perkalian/Pembagian (dari kiri ke kanan):
         * (-8) + 8 - 9 / 3 * 5 + 7
         * -8 + 8 - 3 * 5 + 7
         * -8 + 8 - 15 + 7
         * 3. Penjumlahan/Pengurangan (dari kiri ke kanan):
         * 0 - 15 + 7
         * -15 + 7
         * -8
         */

        int hasilKompleks = -4 * 2 + 8 - 9 / 3 * 5 + 7;
        System.out.println("-4 * 2 + 8 - 9 / 3 * 5 + 7 = " + hasilKompleks); // Output: -8

        System.out.println("\n--- Demo Penggunaan Tanda Kurung ---");

        // Contoh 4: Mengubah urutan eksekusi dengan tanda kurung
        // Tanpa kurung: 3 / 3 = 1, lalu 6 + 1 = 7
        // Dengan kurung: (6 + 3) = 9, lalu 9 / 3 = 3
        int hasilDenganKurung = (6 + 3) / 3;
        System.out.println("(6 + 3) / 3 = " + hasilDenganKurung); // Output: 3

        int hasilTanpaKurung = 6 + 3 / 3;
        System.out.println("6 + 3 / 3 = " + hasilTanpaKurung); // Output: 7

        // Contoh 5: Tanda kurung untuk keterbacaan (meskipun tidak mengubah urutan)
        // Perkalian tetap lebih dulu, tapi kurung membantu mata membaca
        int hasilBacaBagus = 7 + (3 * 2);
        System.out.println("7 + (3 * 2) = " + hasilBacaBagus); // Output: 13 (sama dengan hasil1)

        System.out.println("\n--- Demo Operasi Aritmatika pada Char ---");

        // Contoh 6: Penjumlahan dua karakter
        // '6' memiliki nilai ASCII/Unicode 54. Jadi 54 + 54 = 108
        char charAngka1 = '6';
        char charAngka2 = '6';
        int hasilCharJumlah = charAngka1 + charAngka2;
        System.out.println("Nilai '6' (char) = " + (int) charAngka1); // Cast ke int untuk lihat nilai numeriknya
        System.out.println("Nilai '6' (char) + '6' (char) = " + hasilCharJumlah); // Output: 108

        // Contoh 7: Perbedaan antara huruf besar dan kecil
        // 'a' = 97, 'A' = 65. Jadi 97 - 65 = 32
        System.out.println("'a' - 'A' = " + ('a' - 'A')); // Output: 32

        // Contoh 8: Menyimpan hasil operasi char ke tipe data char
        // Ini akan mengambil karakter yang memiliki nilai ASCII/Unicode 97 + 5 = 102
        // (yaitu 'f')
        char hurufA = 'a';
        char hasilHuruf = (char) (hurufA + 5); // Perlu cast eksplisit karena hasil penjumlahan int
        System.out.println("('a' + 5) = " + hasilHuruf); // Output: f

    }
}
