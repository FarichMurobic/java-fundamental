package FundamentalJava.String.StringHandling;

/**
 * String Comparison
 *
 * Class String punya beberapa method untuk membandingkan string.
 * equals()
 * boolean equals(Object str)
 *
 * Membandingkan isi string (character by character)
 * case-sensitive
 *
 * equalsIgnoreCase()
 * boolean equalsIgnoreCase(String str)
 *
 * Sama seperti equals()
 * tapi abaikan huruf besar/kecil
 *
 * regionMatches()
 * Bandingkan sebagian string:
 * boolean regionMatches(int startIndex, String str2, int str2StartIndex, int numChars)
 *
 * Versi ignore case:
 * boolean regionMatches(boolean ignoreCase, int startIndex, String str2, int str2StartIndex, int numChars)
 *
 * startsWith() dan endsWith()
 * boolean startsWith(String str)
 * boolean endsWith(String str)
 *
 * Contoh:
 * "Foobar".startsWith("Foo") → true
 * "Foobar".endsWith("bar") → true
 *
 * Versi dengan index:
 * boolean startsWith(String str, int startIndex)
 *
 * equals() vs ==
 * equals() → bandingin isi
 * == → bandingin referensi (object yang sama atau tidak)
 *
 * compareTo()
 * int compareTo(String str)
 *
 * Intinya
 * compareTo() memang bandingin per karakter,
 * tapi bukan pakai ASCII murni, melainkan pakai Unicode value (UTF-16 code unit).
 *
 * Contoh
 * String a = "abc";
 * String b = "abd";
 *
 * System.out.println(a.compareTo(b));
 *
 * Perbandingan:
 * 'a' vs 'a' → sama
 * 'b' vs 'b' → sama
 * 'c' vs 'd' → beda
 *
 * Nilai:
 * 'c' - 'd' = -1
 *
 * Jadi hasil:
 * -1
 *
 * Contoh lain
 * String a = "Apple";
 * String b = "apple";
 *
 * System.out.println(a.compareTo(b));
 *
 * 'A' vs 'a'
 * Unicode 'A' = 65
 * Unicode 'a' = 97
 *
 * hasil:
 * 65 - 97 = -32
 *
 * Jadi bukan ASCII?
 *
 * Secara praktis:
 * Untuk huruf latin dasar → ASCII = Unicode (nilainya sama)
 *
 * Tapi Java sebenarnya pakai:
 * Unicode (UTF-16 encoding)
 *
 * Makanya:
 * Bisa handle karakter internasional
 * Tidak terbatas ASCII
 *
 * Return value:
 * 0 → sama persis
 * < 0 → string pertama “lebih kecil”
 * > 0 → string pertama “lebih besar”
 *
 * berdasarkan urutan kamus (lexicographical)
 *
 * compareToIgnoreCase()
 * sama seperti compareTo()
 * tapi ignore case
 */

/**
 * 1. equals() = bandingin isi
 * "Hello".equals("Hello") → true
 *
 * compare karakter:
 * H == H
 * e == e
 * ...
 *
 * 2. equalsIgnoreCase()
 * "hello".equalsIgnoreCase("HELLO") → true
 *
 * cocok untuk:
 * login username
 * input user
 *
 * 3. == (INI YANG BAHAYA BANGET)
 * String a = "Hello";
 * String b = "Hello";
 * bisa true (karena String Pool)
 *
 * String a = "Hello";
 * String b = new String("Hello");
 * a == b → false
 *
 * INTI:
 * == = alamat memory
 * equals() = isi
 *
 * 4. regionMatches() (LEVEL ADVANCED)
 * "HelloWorld".regionMatches(5, "WorldTest", 0, 5)
 *
 * bandingin:
 * World vs World
 *
 * 5. startsWith / endsWith
 * ini shortcut dari regionMatches()
 *
 * 6. compareTo() (PENTING BANGET)
 * "apple".compareTo("banana") < 0
 *
 * karena:
 * a < b
 *
 * Case-sensitive:
 * "Now".compareTo("apple")
 *
 * "Now" lebih kecil karena:
 * 'N' < 'a' di ASCII
 *
 * 7. compareToIgnoreCase()
 * solusi kalau mau sorting normal:
 * "Now".compareToIgnoreCase("apple")
 *
 * Kesimpulan Simpel
 * equals() → bandingin isi
 * == → bandingin referensi 
 *
 * equalsIgnoreCase() → ignore case
 *
 * compareTo() → buat sorting
 * startsWith() / endsWith() → cek awal/akhir
 *
 * Insight Backend (INI YANG REAL BANGET)
 * Login System
 * if (username.equalsIgnoreCase(input)) {
 *
 * Bug paling sering:
 * if (username == input)
 * login gagal walau sama
 *
 * Sorting data:
 * Collections.sort(list);
 * pakai compareTo()
 *
 * API validation:
 * if (!email.endsWith("@gmail.com"))
 *
 * Search engine:
 * if (text.contains(keyword))
 *
 * INTI DALAM
 * equals() = isi
 * == = alamat memory
 * Salah pakai == = bug serius 
 * compareTo() = dasar sorting
 * equalsIgnoreCase() = user-friendly
 */

public class StringComparison {
    public static void main(String[] args) {

        // 1. equals vs equalsIgnoreCase
        String string1 = "abc";
        String string2 = "Abc";

        System.out.println(string1.equals(string2)); // false
        System.out.println(string1.equalsIgnoreCase(string2)); // true

        // Penjelasan:
        // equals → case-sensitive
        // equalsIgnoreCase → tidak peduli huruf besar kecil

        // 2. equals vs ==
        String string3 = "Hello";
        String string4 = new String("Hello");

        System.out.println(string3.equals(string4)); // true
        System.out.println(string3 == string4); // false

        // Penjelasan:
        // equals → isi sama
        // == → beda object di memory

        // 3. startsWith & endsWith
        String string5 = "Foobar";

        System.out.println(string5.startsWith("Foo")); // true
        System.out.println(string5.endsWith("bar")); // true
        System.out.println(string5.startsWith("foo")); // false

        // Dengan index
        System.out.println(string5.startsWith("bar",3)); // true

        // 4. compareTo()
        String string6 = "apple";
        String string7 = "banana";

        System.out.println(string6.compareTo(string7)); // -1
        System.out.println(string7.compareTo(string6)); // 1
        System.out.println(string6.compareTo("apple")); // 0

        // Penjelasan:
        // compareTo digunakan untuk sorting
        // Dia bakal:
        // Bandingin karakter dari index 0
        // Kalau sama → lanjut ke karakter berikutnya
        // Kalau beda → langsung berhenti dan hitung selisih nilainya

        // 5. Sorting String
        String arr[] = {
                "Now", "is", "the", "time", "for", "all", "good", "men",
                "to", "come", "to", "the", "aid", "of", "their", "country"
        };

        // bubble sort algoritma
        for (int j = 0; j < arr.length; j++) {
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i].compareTo(arr[j]) < 0) {
                    // tukar posisi
                    String temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            System.out.println(arr[j]);
        }

        // Penjelasan:
        // Sorting berdasarkan urutan alfabet
        // jika ada logika untuk pengurutan huruf seperti kamus
        // pakai method compare.To()
        // pakai logika di atas

        // 6. regionMatches() (LEVEL ADVANCED)
        String s1 = "HelloWorld";
        String s2 = "WorldTest";

        // Bandingkan bagian "World" di s1 dengan "World" di s2
        boolean hasil1 = s1.regionMatches(5, s2, 0, 5);
        System.out.println(hasil1); // true

        // Versi ignore case
        String s3 = "HELLOWORLD";
        boolean hasil2 = s3.regionMatches(true, 5, s2, 0, 5);
        System.out.println(hasil2); // true
    }
}
