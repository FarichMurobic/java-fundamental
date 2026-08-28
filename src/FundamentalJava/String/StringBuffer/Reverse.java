package FundamentalJava.String.StringBuffer;

/**
 * ================================================================
 * reverse() - MEMBALIK URUTAN KARAKTER
 * ================================================================
 * 
 * Method reverse() digunakan untuk membalik urutan karakter
 * di dalam StringBuffer secara langsung dan efisien.
 * 
 * -----------------------------------------------------------------
 * 1. DEKLARASI METHOD - BENTUK UMUM
 * -----------------------------------------------------------------
 * 
 * StringBuffer reverse()
 * 
 * - Tidak menerima parameter apapun
 * - Mengembalikan objek StringBuffer yang sama (yang sudah dibalik)
 * - Mendukung method chaining
 * 
 * -----------------------------------------------------------------
 * 2. FUNGSI UTAMA - APA YANG DILAKUKAN
 * -----------------------------------------------------------------
 * 
 * reverse() membalik urutan karakter di dalam StringBuffer.
 * 
 * Contoh sederhana:
 * StringBuffer sb = new StringBuffer("abcdef");
 * System.out.println("Sebelum: " + sb); // "abcdef"
 * 
 * sb.reverse();
 * System.out.println("Sesudah: " + sb); // "fedcba"
 * 
 * -----------------------------------------------------------------
 * 3. VISUALISASI - BIAR MAKIN JELAS
 * -----------------------------------------------------------------
 * 
 * StringBuffer awal: "Hello World"
 * Indeks: 0 1 2 3 4 5 6 7 8 9 10
 * Karakter: H e l l o W o r l d
 * 
 * Proses reverse (swap simetris):
 * 
 * Iterasi 1: swap index 0 dan 10
 * [H][e][l][l][o][ ][W][o][r][l][d]
 * ^ ^
 * |___________________________|
 * 
 * Hasil: [d][e][l][l][o][ ][W][o][r][l][H]
 * 
 * Iterasi 2: swap index 1 dan 9
 * [d][e][l][l][o][ ][W][o][r][l][H]
 * ^ ^
 * |_______________________|
 * 
 * Hasil: [d][l][l][l][o][ ][W][o][r][e][H]
 * 
 * Iterasi 3: swap index 2 dan 8
 * [d][l][l][l][o][ ][W][o][r][e][H]
 * ^ ^
 * |___________________|
 * 
 * Hasil: [d][l][r][l][o][ ][W][o][l][e][H]
 * 
 * Iterasi 4: swap index 3 dan 7
 * [d][l][r][l][o][ ][W][o][l][e][H]
 * ^ ^
 * |_______________|
 * 
 * Hasil: [d][l][r][o][o][ ][W][l][l][e][H]
 * 
 * Iterasi 5: swap index 4 dan 6 (tengah)
 * [d][l][r][o][o][ ][W][l][l][e][H]
 * ^ ^
 * |_______|
 * 
 * Hasil: [d][l][r][o][W][ ][o][l][l][e][H]
 * 
 * Hasil akhir: "dlroW olleH"
 * 
 * -----------------------------------------------------------------
 * 4. IN-PLACE OPERATION - TIDAK BIKIN OBJECT BARU
 * -----------------------------------------------------------------
 * 
 * Perbedaan KRUSIAL antara String dan StringBuffer:
 * 
 * // STRING - MEMBUAT OBJECT BARU
 * String str = "abcdef";
 * String reversed = new StringBuilder(str).reverse().toString();
 * // Object baru tercipta, str tetap "abcdef"
 * 
 * // STRINGBUFFER - IN-PLACE (MENGUBAH OBJECT SAMA)
 * StringBuffer sb = new StringBuffer("abcdef");
 * sb.reverse();
 * // Object sb yang sama, isinya berubah menjadi "fedcba"
 * // Tidak ada object baru!
 * 
 * 
 * // Contoh konkret:
 * StringBuffer sb1 = new StringBuffer("Java");
 * StringBuffer sb2 = sb1.reverse(); // sb1 dan sb2 merujuk ke object yang SAMA!
 * 
 * System.out.println(sb1); // "avaJ"
 * System.out.println(sb2); // "avaJ"
 * System.out.println(sb1 == sb2); // true (sama object)
 * 
 * -----------------------------------------------------------------
 * 5. RETURN VALUE - METHOD CHAINING
 * -----------------------------------------------------------------
 * 
 * Karena reverse() mengembalikan objek yang sama (return this),
 * maka bisa digunakan dalam method chaining:
 * 
 * StringBuffer sb = new StringBuffer("Hello World");
 * 
 * sb.reverse() // Balik → "dlroW olleH"
 * .append("!!!") // Tambah → "dlroW olleH!!!"
 * .insert(0, "Greetings: "); // Sisip di awal → "Greetings: dlroW olleH!!!"
 * 
 * System.out.println(sb);
 * // Output: "Greetings: dlroW olleH!!!"
 * 
 * 
 * // Contoh lain:
 * StringBuffer sb2 = new StringBuffer("12345");
 * String result = sb2.reverse() // "54321"
 * .append("0") // "543210"
 * .insert(3, "-") // "543-210"
 * .toString(); // Konversi ke String
 * 
 * System.out.println(result); // "543-210"
 * 
 * -----------------------------------------------------------------
 * 6. MEKANISME INTERNAL - BAGAIMANA JAVA BEKERJA
 * -----------------------------------------------------------------
 * 
 * Algoritma reverse() di internal:
 * 
 * 1. Dapatkan panjang string (n)
 * 2. Loop dari i = 0 sampai n/2 - 1:
 * - Swap karakter di index i dengan karakter di index (n - 1 - i)
 * 3. Kembalikan objek yang sama (this)
 * 
 * Pseudocode:
 * 
 * public StringBuffer reverse() {
 * int n = length();
 * for (int i = 0; i < n / 2; i++) {
 * char temp = charAt(i);
 * setCharAt(i, charAt(n - 1 - i));
 * setCharAt(n - 1 - i, temp);
 * }
 * return this;
 * }
 * 
 * Kompleksitas:
 * - Waktu : O(n) → n/2 swap, sangat efisien
 * - Memory: O(1) → hanya pakai satu variabel temp
 * 
 * -----------------------------------------------------------------
 * 7. PERBANDINGAN DENGAN ALTERNATIF LAIN
 * -----------------------------------------------------------------
 * 
 * // OPSI 1: StringBuffer.reverse() - PALING EFFISIEN
 * StringBuffer sb = new StringBuffer("Hello");
 * sb.reverse();
 * // ✅ In-place, O(n), O(1) memory
 * 
 * // OPSI 2: StringBuilder.reverse() - JUGA EFFISIEN
 * StringBuilder sb2 = new StringBuilder("Hello");
 * sb2.reverse();
 * // ✅ In-place, O(n), O(1) memory, lebih cepat (non-synchronized)
 * 
 * // OPSI 3: Manual loop - KURANG EFFISIEN
 * String str = "Hello";
 * char[] chars = str.toCharArray();
 * for (int i = 0; i < chars.length / 2; i++) {
 * char temp = chars[i];
 * chars[i] = chars[chars.length - 1 - i];
 * chars[chars.length - 1 - i] = temp;
 * }
 * String result = new String(chars);
 * // ❌ Butuh char[] + String baru
 * 
 * // OPSI 4: Loop concat - PALING BOROS
 * String str = "Hello";
 * String result = "";
 * for (int i = str.length() - 1; i >= 0; i--) {
 * result += str.charAt(i); // Bikin object String baru setiap iterasi!
 * }
 * // ❌ Sangat lambat, banyak object, jangan pernah lakukan ini!
 * 
 * -----------------------------------------------------------------
 * 8. KASUS PENGGUNAAN - KAPAN DIPAKAI
 * -----------------------------------------------------------------
 * 
 * reverse() COCOK digunakan saat:
 * 
 * 1. Palindrome checker
 * - Cek apakah string sama dengan kebalikannya
 * - "radar" → reversed = "radar" (palindrome)
 * 
 * 2. Membalik kata atau kalimat
 * - "Hello World" → "dlroW olleH"
 * - Untuk aplikasi obfuscation atau encoding sederhana
 * 
 * 3. Reverse iterasi atau processing
 * - Proses data dari akhir ke awal
 * - Membalik urutan hasil
 * 
 * 4. Game atau puzzle
 * - Membalik kata dalam permainan
 * - Enkripsi sederhana
 * 
 * 5. Manipulasi data
 * - Reverse string untuk format tertentu
 * 
 * reverse() TIDAK COCOK digunakan saat:
 * 
 * 1. Hanya perlu mengakses karakter dari belakang
 * - Gunakan charAt() dengan loop dari length()-1 ke 0
 * 
 * 2. Data sangat besar dan hanya butuh reverse sekali
 * - Masih OK, tapi pertimbangkan memory
 * 
 * 3. Butuh mempertahankan original string
 * - Buat copy dulu, atau gunakan StringBuilder/string lain
 * 
 * -----------------------------------------------------------------
 * 9. CONTOH LENGKAP - PALINDROME CHECKER
 * -----------------------------------------------------------------
 * 
 * public class ReverseDemo {
 * public static void main(String[] args) {
 * // Contoh 1: Reverse sederhana
 * StringBuffer sb = new StringBuffer("abcdef");
 * System.out.println("Original: " + sb);
 * sb.reverse();
 * System.out.println("Reversed: " + sb);
 * System.out.println();
 * 
 * // Contoh 2: Palindrome checker
 * String[] testStrings = {"radar", "hello", "level", "java"};
 * 
 * for (String test : testStrings) {
 * StringBuffer buffer = new StringBuffer(test);
 * String reversed = buffer.reverse().toString();
 * 
 * boolean isPalindrome = test.equals(reversed);
 * System.out.println(test + " → " + reversed + " → " +
 * (isPalindrome ? "PALINDROME" : "NOT palindrome"));
 * }
 * System.out.println();
 * 
 * // Contoh 3: Reverse dengan method chaining
 * StringBuffer sb2 = new StringBuffer("Java Programming");
 * String result = sb2.reverse()
 * .append(" is fun")
 * .insert(0, "Reverse: ")
 * .toString();
 * 
 * System.out.println(result);
 * // Output: "Reverse: gnimmargorP avaJ is fun"
 * }
 * }
 * 
 * Output:
 * Original: abcdef
 * Reversed: fedcba
 * 
 * radar → radar → PALINDROME
 * hello → olleh → NOT palindrome
 * level → level → PALINDROME
 * java → avaj → NOT palindrome
 * 
 * Reverse: gnimmargorP avaJ is fun
 * 
 * -----------------------------------------------------------------
 * 10. REVERSE DENGAN KONDISI TERTENTU
 * -----------------------------------------------------------------
 * 
 * // Case 1: Reverse hanya sebagian (gak langsung reverse semua)
 * StringBuffer sb = new StringBuffer("Hello World");
 * 
 * // Ambil sebagian, reverse, lalu replace
 * String sub = sb.substring(0, 5); // "Hello"
 * String reversed = new StringBuilder(sub).reverse().toString(); // "olleH"
 * sb.replace(0, 5, reversed);
 * 
 * System.out.println(sb); // "olleH World"
 * 
 * 
 * // Case 2: Reverse tiap kata (bukan seluruh kalimat)
 * StringBuffer sb2 = new StringBuffer("Hello World Java");
 * String[] words = sb2.toString().split(" ");
 * 
 * StringBuffer result = new StringBuffer();
 * for (String word : words) {
 * StringBuffer wordBuf = new StringBuffer(word);
 * result.append(wordBuf.reverse()).append(" ");
 * }
 * 
 * System.out.println(result.toString().trim()); // "olleH dlroW avaJ"
 * 
 * 
 * // Case 3: Reverse dengan batasan (misal hanya huruf, bukan simbol)
 * StringBuffer sb3 = new StringBuffer("H3ll0 W0rld!");
 * // Banyak cara, tapi ini contoh sederhana
 * char[] chars = sb3.toString().toCharArray();
 * int left = 0, right = chars.length - 1;
 * 
 * while (left < right) {
 * // Skip non-letter
 * if (!Character.isLetter(chars[left])) {
 * left++;
 * } else if (!Character.isLetter(chars[right])) {
 * right--;
 * } else {
 * // Swap letters
 * char temp = chars[left];
 * chars[left] = chars[right];
 * chars[right] = temp;
 * left++;
 * right--;
 * }
 * }
 * 
 * System.out.println(new String(chars)); // "r3ll0 W0rldH!" (contoh)
 * 
 * -----------------------------------------------------------------
 * 11. PERFORMANCE INSIGHT - LEVEL UP
 * -----------------------------------------------------------------
 * 
 * Keunggulan reverse() di StringBuffer:
 * 
 * 1. IN-PLACE
 * - Tidak alokasi memory tambahan
 * - Hanya swap di array internal
 * 
 * 2. O(n) DENGAN n/2 SWAP
 * - Hanya setengah dari panjang yang di-swap
 * - Sangat efisien
 * 
 * 3. CACHE-FRIENDLY
 * - Operasi pada contiguous memory
 * - Cache locality bagus
 * 
 * 4. NO GARBAGE
 * - Tidak ada object sementara
 * - Tidak trigger GC
 * 
 * 
 * Benchmark perkiraan (1.000.000 karakter):
 * - StringBuffer.reverse() : 2-3 ms
 * - StringBuilder.reverse() : 1-2 ms (lebih cepat)
 * - Manual char[] loop : 5-8 ms
 * - Loop concat : > 5000 ms (sangat lambat)
 * 
 * -----------------------------------------------------------------
 * 12. CATATAN UNICODE (JAVA MODERN)
 * -----------------------------------------------------------------
 * 
 * reverse() bekerja pada level char (16-bit UTF-16).
 * 
 * Untuk karakter non-BMP (emoji, aksara tertentu):
 * - Satu karakter = 2 char (surrogate pair)
 * - reverse() akan membalik URUTAN CHAR, BUKAN CODE POINT!
 * - Ini bisa merusak surrogate pair jika tidak hati-hati
 * 
 * Contoh:
 * StringBuffer sb = new StringBuffer("A🌍B");
 * // Internal: ['A', highSurrogate, lowSurrogate, 'B']
 * // Panjang = 4
 * 
 * sb.reverse();
 * // Hasil internal: ['B', lowSurrogate, highSurrogate, 'A']
 * // Ketika dicetak: "B�A" (surrogate pair rusak)
 * 
 * REKOMENDASI:
 * - Untuk Unicode non-BMP, reverse() TIDAK AMAN
 * - Gunakan code point level reverse jika perlu Unicode aman
 * 
 * // Alternatif aman untuk Unicode:
 * String str = "A🌍B";
 * int[] codePoints = str.codePoints().toArray();
 * 
 * // Reverse code points
 * for (int i = 0; i < codePoints.length / 2; i++) {
 * int temp = codePoints[i];
 * codePoints[i] = codePoints[codePoints.length - 1 - i];
 * codePoints[codePoints.length - 1 - i] = temp;
 * }
 * 
 * String result = new String(codePoints, 0, codePoints.length);
 * System.out.println(result); // "B🌍A" (aman)
 * 
 * -----------------------------------------------------------------
 * 13. PERBANDINGAN STRING VS STRINGBUFFER REVERSE
 * -----------------------------------------------------------------
 * 
 * // STRING - TIDAK ADA REVERSE METHOD
 * String str = "Hello";
 * // Harus menggunakan StringBuilder atau manual
 * String reversed = new StringBuilder(str).reverse().toString();
 * // String asli tetap "Hello", object baru tercipta
 * 
 * // STRINGBUFFER - ADA REVERSE METHOD
 * StringBuffer sb = new StringBuffer("Hello");
 * sb.reverse();
 * // Object yang sama, isinya berubah menjadi "olleH"
 * // Tidak ada object baru
 * 
 * ================================================================
 * KESIMPULAN - VERSI PADAT
 * ================================================================
 * 
 * 1. reverse() = membalik urutan karakter dalam StringBuffer
 * 2. In-place operation (mengubah object yang sama)
 * 3. Tidak membuat object String baru
 * 4. Kompleksitas O(n) → sangat efisien
 * 5. Return objek yang sama → support method chaining
 * 6. Lebih cepat dari alternative manual loop
 * 7. StringBuffer.reverse() vs String: String harus bikin object baru
 * 8. Hati-hati dengan Unicode surrogate pairs (bisa rusak)
 * 
 * ================================================================
 * INTI PALING DALAM
 * ================================================================
 * 
 * reverse() adalah bukti bahwa StringBuffer dirancang untuk
 * operasi string yang efisien dan in-place.
 * 
 * Kemampuan membalik string tanpa membuat object baru
 * menjadikan reverse() pilihan utama untuk manipulasi
 * string yang membutuhkan efisiensi memory dan kecepatan.
 * 
 * ================================================================
 * CATATAN JAVA MODERN (17+)
 * ================================================================
 * 
 * Method reverse() telah tersedia sejak Java 1.0 dan tetap
 * identik fungsinya hingga Java 17+.
 * 
 * Untuk aplikasi single-threaded:
 * - StringBuilder.reverse() lebih cepat (tanpa synchronized)
 * - Perilaku identik dengan StringBuffer.reverse()
 * 
 * Alternatif modern:
 * - Stream API: new StringBuilder(str).reverse().toString()
 * - Guava: Strings.reverse(str)
 * - Apache Commons: StringUtils.reverse(str)
 * 
 * Namun untuk kasus in-place modification, StringBuffer.reverse()
 * atau StringBuilder.reverse() tetap menjadi pilihan terbaik.
 * 
 * ================================================================
 */

public class Reverse {
    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer("Farich");
        System.out.println(stringBuffer);
        stringBuffer.reverse(); // hciraF
        System.out.println(stringBuffer);

    }
}
