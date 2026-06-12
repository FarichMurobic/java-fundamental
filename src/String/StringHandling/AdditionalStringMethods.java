package String.StringHandling;

import java.util.Locale;

/**
 * Additional String Methods ------------------------------------------------------------------------------------------------------------------------------------
 * Method	                                                            Deskripsi
 * int codePointAt(int i)	                                            Mengembalikan nilai Unicode (code point) dari karakter pada index ke-i.
 *                                                                      Cocok untuk karakter Unicode (misalnya emoji, simbol).
 * int codePointBefore(int i)	                                        Mengembalikan nilai Unicode dari karakter sebelum index i.
 * int codePointCount(int start, int end)	                            Menghitung jumlah karakter Unicode (code point) dari index start sampai end - 1.
 * boolean contains(CharSequence str)	                                Mengecek apakah string mengandung substring tertentu. Return true jika ada.
 * boolean contentEquals(CharSequence str)	                            Membandingkan isi string dengan CharSequence. Return true jika sama.
 * boolean contentEquals(StringBuffer str)	                            Membandingkan isi string dengan StringBuffer. Return true jika sama.
 * static String format(String fmtstr, Object... args)	                Membuat string dengan format tertentu (mirip printf). Sangat berguna untuk formatting output.
 * static String format(Locale loc, String fmtstr, Object... args)	    Sama seperti format(), tapi menggunakan aturan locale (bahasa/negara).
 * boolean isEmpty()	                                                Mengecek apakah string kosong (""). Return true jika panjang = 0.
 * boolean matches(String regExp)	                                    Mengecek apakah string sesuai dengan pola regex (regular expression).
 * int offsetByCodePoints(int start, int num)	                        Mengembalikan index baru setelah maju/mundur sejumlah num code point dari index start.
 * String replaceFirst(String regExp, String newStr)	                Mengganti hanya kemunculan pertama yang cocok dengan regex.
 * String replaceAll(String regExp, String newStr)	                    Mengganti semua bagian string yang cocok dengan regex.
 * String[] split(String regExp)	                                    Memecah string menjadi array berdasarkan pola regex.
 * String[] split(String regExp, int max)	                            Sama seperti split, tapi jumlah potongan dibatasi oleh max.
 * CharSequence subSequence(int startIndex, int stopIndex)	            Mengambil sebagian string (mirip substring()), dari startIndex sampai sebelum stopIndex.
 */

public class AdditionalStringMethods {
    public static void main(String[] args) {

        // 1. codePointAt()
        String codepoint = "Java";
        int hasil = codepoint.codePointAt(0);
        System.out.println(hasil);

        // Penjelasan:
        // Mengambil nilai Unicode dari karakter di index 0 ('J')
        // Output: 74

        // 2. codePointBefore()
        String codepointbefore = "Java";
        int hasil1 = codepointbefore.codePointBefore(2);
        System.out.println(hasil1);

        // Penjelasan:
        // Ambil karakter sebelum index 2 ('a' di index 1)
        // Output: 97

        // 3. codePointCount()
        String codepointcount = "Java";
        int hasil2 = codepointcount.codePointCount(0, codepointcount.length());
        System.out.println(hasil2);

        // Penjelasan:
        // Menghitung jumlah karakter dari index 0 sampai akhir
        // Output: 4

        // 4. contains()
        String contains = "Hello Java";
        boolean hasil3 = contains.contains("Java");
        System.out.println(hasil3);

        // Penjelasan:
        // Mengecek apakah string mengandung "Java"
        // Output: true

        // 5. contentEquals(CharSequence)
        String contenequals = "Hello";
        StringBuilder stringBuilder = new StringBuilder("Hello");

        boolean hasil4 = contenequals.contentEquals(stringBuilder);
        System.out.println(hasil4);

        // Penjelasan:
        // Membandingkan isi String dengan StringBuilder
        // Output: true

        // 6. contentEquals(StringBuffer)
        String contenEquals = "Hello";
        StringBuffer stringBuffer = new StringBuffer("Hello");

        boolean hasil5 = contenEquals.contentEquals(stringBuffer);
        System.out.println(hasil5);

        // Penjelasan:
        // Membandingkan isi String dengan StringBuffer
        // Output: true

        // 7. format()
        String format = String.format("Nama: %s, Umur: %d", "Farich", 20);
        System.out.println(format);

        // Penjelasan:
        // %s = string, %d = integer
        // Output: Nama: Farich, Umur: 20

        // 8. format(Locale)
        String formatLocal = String.format(Locale.US, "Harga: %.2f", 1234.56 );
        System.out.println(formatLocal);

        // Penjelasan:
        // Locale.US digunakan untuk format angka
        // %.2f = 2 angka di belakang koma

        // 9. isEmpty()
        String empty = "";
        System.out.println(empty.isEmpty());

        // Penjelasan:
        // Mengecek apakah string kosong
        // Output: true

        // 10. matches()
        String email = "test@gmail.com";
        boolean hasil7 = email.matches(".*@gmail.com");
        System.out.println(hasil7);

        // Penjelasan:
        // .* = karakter apa saja
        // Mengecek apakah email berakhiran @gmail.com
        // Output: true

        // 11. offsetByCodePoints()
        String s = "Java";
        int index = s.offsetByCodePoints(0,2);
        System.out.println(index);

        // Penjelasan:
        // Dari index 0 maju 2 karakter → index 2

        // 12. replaceFirst()
        String replaceFirst = "one one one";
        String hasil8 = replaceFirst.replaceFirst("one", "two");
        System.out.println(hasil8);

        // Output: two one one

        // 13. replaceAll()
        String replaceAll = "one one one";
        String hasil9 = replaceAll.replaceAll("one", "two");
        System.out.println(hasil9);

        // Output: two two two

        // 14. split()
        String split = "A,B,C";
        String[] result = split.split(",");

        for (String str : result) {
            System.out.println(str);
        }

        // Output:
        // A
        // B
        // C

        // 15. split(regExp, max)
        String split2 = "A,B,C,D";
        String[] result1 = split2.split(",",2);

        for (String x : result1) {
            System.out.println(x);
        }

        // Output:
        // A
        // B,C,D

        // 16. subSequence()
        String subsequence = "Hello Java";
        CharSequence sub = subsequence.subSequence(0,5);
        System.out.println(sub);

        // Output: Hello
        // Penjelasan:
        // Mengambil substring dari index 0 sampai sebelum 5
    }
}
