package FundamentalJava.String.StringHandling;

/**
 * String Length
 * Panjang dari sebuah string adalah jumlah karakter yang dikandungnya.
 *
 * Untuk mendapatkan nilai ini, gunakan method:
 * int length()
 *
 * Contoh berikut akan mencetak "3", karena string s memiliki tiga karakter:
 * char chars[] = { 'a', 'b', 'c' };
 * String s = new String(chars);
 * System.out.println(s.length());
 *
 * Apa itu length()?
 * s.length()
 *
 * artinya:
 * "Berapa jumlah karakter di dalam string ini?"
 *
 * Contoh:
 * String s = "Hello";
 * s.length() → 5
 *
 * Bedain: length vs length()
 * Ini sering banget bikin error di awal belajar.
 *
 * Array:
 * char[] arr = {'a','b','c'};
 * System.out.println(arr.length);
 *
 * tanpa kurung
 *
 * String:
 * String s = "abc";
 * System.out.println(s.length());
 *
 * pakai method (ada ())
 *
 * Kalau kebalik:
 * s.length; // ERROR
 *
 * Kenapa String pakai method?
 *
 * Karena:
 * String = object
 * bukan array
 *
 * Jadi:
 * pakai method
 * bukan property
 *
 * Immutable & length()
 * Karena String immutable:
 * panjangnya tidak bisa berubah
 *
 * String s = "abc";
 * panjang selalu 3 (object itu)
 *
 * Kalau diubah:
 * s = s + "d";
 *
 * sebenarnya:
 * object baru dibuat
 * length jadi 4
 *
 * Edge Case (INI YANG JARANG DIAJARIN)
 * String kosong:
 * String s = "";
 * s.length() → 0
 *
 * String dengan spasi:
 * String s = " ";
 * s.length() → 1
 *
 * spasi dihitung karakter!
 *
 * String dengan newline/tab:
 * String s = "\n";
 *
 * tetap dihitung 1
 *
 * Unicode (LEVEL LANJUT DIKIT)
 *
 * Kadang:
 * String s = "😊";
 *
 * length() bisa jadi 2, bukan 1
 *
 * Kenapa?
 * Java pakai UTF-16
 * emoji bisa pakai 2 code unit
 *
 * ini penting kalau lo handle:
 * emoji
 * multilingual text
 *
 * Kesimpulan Simpel
 * length() = jumlah karakter dalam String
 * String pakai method → length()
 * Array pakai property → length
 *
 * String kosong → 0
 * Spasi tetap dihitung
 *
 * Unicode bisa bikin length “aneh” (emoji, dll)
 *
 * Insight Backend (PENTING BANGET)
 * Case nyata:
 * Validasi input:
 * if (username.length() < 5) {
 *     // reject
 * }
 *
 * Parsing data:
 * if (json.length() == 0) {
 *     // empty request
 * }
 *
 * Bug umum:
 * if (text.length() == 0)
 *
 * tapi user input " " (spasi)
 * length = 3
 *
 * Solusi:
 * if (text.trim().length() == 0)
 */

public class StringLength {
    public static void main(String[] args) {

        // Membuat array karakter
        char chars[] = {'a', 'b', 'c'};

        // Membuat String dari array
        String string = new String(chars);

        // Mengambil panjang string
        System.out.println(string.length());

        // Penjelasan:
        // String "abc" memiliki 3 karakter
        // Maka output: 3

        // Perbandingan String vs Array

        // Array
        char[] array = {'a', 'b', 'c'};
        System.out.println(array.length); // tanpa ()

        // String
        String string1 = "abc";
        System.out.println(string1.length()); // pakai ()

        // Penjelasan:
        // Array → property
        // String → method

        // Edge Case

        String kosong = "";
        String spasi = " ";
        String teks = "Hello";

        System.out.println(kosong.length()); // 0
        System.out.println(spasi.length());  // 1
        System.out.println(teks.length());   // 5

        // Penjelasan:
        // String kosong → 0
        // Spasi tetap dihitung karakter

        // Unicode Case

        String emoji = "😊";
        System.out.println(emoji.length()); // 2

        // Penjelasan:
        // Bisa output 2 karena UTF-16
        // Ini penting kalau handle emoji

    }
}
