package FundamentalJava.TipeDataPrimitif;

/**
 * Characters (Karakter)
 * Tipe data char di Java adalah tipe 16-bit, berbeda dengan C/C++ yang 8-bit. Ini karena Java
 * menggunakan Unicode untuk merepresentasikan karakter, yang dapat mencakup semua karakter
 * dari bahasa manusia di seluruh dunia. Rentang nilai char adalah 0 hingga 65.536 dan tidak ada nilai negatif.
 * Meskipun utamanya untuk karakter, char juga bisa digunakan dalam operasi
 * aritmatika, layaknya integer.
 */

public class Character {
    public static void main(String[] args) {

        /**
         * Tipe Data char
         * Tipe data char merepresentasikan karakter tunggal. Karakter tunggal bisa berupa huruf (a-z, A-Z),
         * angka (0-9), dan karakter khusus (!, @, #, $, &, *, {, }, [, ], dan sebagainya). Secara khusus, tipe
         * data char bisa digunakan untuk merepresentasikan karakter apa pun yang kamu lihat di keyboard.
         *
         * Sebuah literal char direpresentasikan menggunakan sepasang kutip tunggal ('').
         * Java menggunakan set karakter Unicode yang berisi 65536 karakter.
         * Oleh karena itu, tipe data char membutuhkan 2 byte (atau 16 bit) memori.
         * Ke-65536 karakter ini direpresentasikan menggunakan nilai 0 hingga 65535.
         *
         * NOTE More information about Unicode can be found at http://www.unicode.org.
         */

        char char1 = 'F';
        char char2 = 'A';
        char char3 = 'R';
        char char4 = 'I';
        char char5 = 'C';
        char char6 = 'H';

        System.out.println(char1 + " " + char2 + " " + char3 + " " + char4 + " " + char5 + " " + char6);

        System.out.println('a' - 'A'); // Mengurangi nilai integer 'A' dari 'a'
        System.out.println('A' - 'a'); // Mengurangi nilai integer 'a' dari 'A'
        System.out.println('q' - 'Q'); // Mengurangi nilai integer 'Q' dari 'q'
        System.out.println('Q' - 'q'); // Mengurangi nilai integer 'q' dari 'Q'

        /**
         * Output
         * 32
         * -32
         * 32
         * -32
         *
         * Penjelasan:
         * 'a' - 'A': Outputnya 32. Ini karena nilai ASCII/Unicode dari 'a' adalah 97, dan 'A' adalah 65. Jadi, 97−65=32.
         * 'A' - 'a': Outputnya -32. Ini karena 65−97=−32.
         */

        System.out.println("-------------------------------");

        System.out.println("\n--- Char dengan Aritmatika ---");
        // Program ini menunjukkan bahwa char bisa dioperasikan secara aritmatika:
        char character1;
        character1 = 'X';
        System.out.println("Character1 is " + character1); // Character1 is X
        character1++;
        System.out.println("Character1 is now " + character1); // Character1 is now Y

        char valueAngka = 56; // 56 is value 8 in unicode
        System.out.println(valueAngka);
        char untukAngka = '4'; // 4
        System.out.println(untukAngka);
        char untukSimbol = '$'; // $
        System.out.println(untukSimbol);

        System.out.println("-------------------------------");

        // Note: jika tanpa String untuk concatenation, Char akan dikonversi ke integer bukan String
        // Jika Anda terbiasa dengan nilai ASCII, Anda dapat menggunakannya untuk menampilkan karakter tertentu:
        char usingChar = 'M';
        System.out.println((int) usingChar); // 77
        System.out.println((int) 'O'); // 79
        System.out.println(usingChar - 'O'); // -2, Karena 77 - 79 (M - O)

    }
}
