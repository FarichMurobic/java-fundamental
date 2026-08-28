package FundamentalJava.String.StringBuffer;

/**
 * ================================================================
 * substring() - MENGAMBIL BAGIAN DARI STRINGBUFFER
 * ================================================================
 * 
 * Method substring() digunakan untuk mengambil sebagian isi
 * dari StringBuffer dan mengembalikannya sebagai objek String.
 * 
 * -----------------------------------------------------------------
 * 1. DEKLARASI METHOD - BENTUK UMUM
 * -----------------------------------------------------------------
 * 
 * String substring(int startIndex)
 * - Mengambil substring dari startIndex sampai akhir buffer
 * 
 * String substring(int startIndex, int endIndex)
 * - Mengambil substring dari startIndex sampai endIndex - 1
 * 
 * Parameter:
 * - startIndex : posisi awal substring (inklusif)
 * - endIndex : posisi akhir substring (eksklusif)
 * 
 * Return:
 * - Objek String baru yang berisi substring yang diambil
 * 
 * -----------------------------------------------------------------
 * 2. POIN PENTING - WAJIB PAHAM
 * -----------------------------------------------------------------
 * 
 * 1. substring() TIDAK mengubah StringBuffer
 * - Buffer asli tetap utuh
 * - Tidak ada modifikasi pada objek asli
 * 
 * 2. Mengembalikan String (BUKAN StringBuffer)
 * - Return type = String (immutable)
 * - Bukan StringBuffer (mutable)
 * 
 * 3. endIndex adalah EXCLUSIVE
 * - Karakter di endIndex TIDAK diambil
 * - Sama seperti method lainnya (delete, replace, dll)
 * 
 * 4. Membuat objek String baru
 * - Substring yang diambil menjadi String baru
 * - Data di-copy dari buffer ke String
 * 
 * -----------------------------------------------------------------
 * 3. BENTUK 1 - SATU PARAMETER (startIndex)
 * -----------------------------------------------------------------
 * 
 * substring(int startIndex)
 * 
 * Fungsi:
 * Mengambil karakter dari startIndex sampai akhir StringBuffer.
 * 
 * Contoh:
 * StringBuffer sb = new StringBuffer("Hello World");
 * String result = sb.substring(6);
 * 
 * Visualisasi:
 * 
 * StringBuffer: "Hello World"
 * Indeks: 0 1 2 3 4 5 6 7 8 9 10
 * Karakter: H e l l o W o r l d
 * ^
 * startIndex = 6
 * 
 * substring(6) mengambil:
 * index 6 → 'W'
 * index 7 → 'o'
 * index 8 → 'r'
 * index 9 → 'l'
 * index 10 → 'd'
 * 
 * Hasil: "World"
 * 
 * System.out.println(result); // "World"
 * System.out.println(sb); // "Hello World" (tetap sama)
 * 
 * -----------------------------------------------------------------
 * 4. BENTUK 2 - DUA PARAMETER (startIndex, endIndex)
 * -----------------------------------------------------------------
 * 
 * substring(int startIndex, int endIndex)
 * 
 * Fungsi:
 * Mengambil karakter dari startIndex sampai endIndex - 1.
 * 
 * Contoh:
 * StringBuffer sb = new StringBuffer("Hello World");
 * String result = sb.substring(0, 5);
 * 
 * Visualisasi:
 * 
 * StringBuffer: "Hello World"
 * Indeks: 0 1 2 3 4 5 6 7 8 9 10
 * Karakter: H e l l o W o r l d
 * ^ ^
 * | |
 * start=0 end=5 (TIDAK diambil)
 * 
 * substring(0, 5) mengambil:
 * index 0 → 'H'
 * index 1 → 'e'
 * index 2 → 'l'
 * index 3 → 'l'
 * index 4 → 'o'
 * index 5 → TIDAK diambil (endIndex = 5)
 * 
 * Hasil: "Hello"
 * 
 * System.out.println(result); // "Hello"
 * System.out.println(sb); // "Hello World" (tetap sama)
 * 
 * -----------------------------------------------------------------
 * 5. CONTOH DENGAN endIndex EXCLUSIVE
 * -----------------------------------------------------------------
 * 
 * "Hello"
 * 01234
 * 
 * substring(1, 4)
 * 
 * Yang diambil:
 * index 1 → 'e' (IKUT)
 * index 2 → 'l' (IKUT)
 * index 3 → 'l' (IKUT)
 * index 4 → 'o' (TIDAK, karena endIndex = 4)
 * 
 * Hasil: "ell"
 * 
 * 
 * Contoh lain:
 * StringBuffer sb = new StringBuffer("Programming");
 * // Indeks: 0 1 2 3 4 5 6 7 8 9 10
 * // Karakter:P r o g r a m m i n g
 * 
 * String sub1 = sb.substring(0, 4); // "Prog"
 * String sub2 = sb.substring(4, 8); // "ramm"
 * String sub3 = sb.substring(8, 11); // "ing"
 * 
 * System.out.println(sub1); // "Prog"
 * System.out.println(sub2); // "ramm"
 * System.out.println(sub3); // "ing"
 * 
 * -----------------------------------------------------------------
 * 6. ATURAN INDEX - WAJIB PAHAM
 * -----------------------------------------------------------------
 * 
 * Aturan untuk substring():
 * 
 * 1. startIndex >= 0
 * 2. endIndex <= length()
 * 3. startIndex <= endIndex
 * 4. Jika startIndex == endIndex → substring kosong ("")
 * 
 * Pelanggaran aturan:
 * - StringIndexOutOfBoundsException
 * 
 * 
 * Contoh Kode yang SALAH:
 * StringBuffer sb = new StringBuffer("Java");
 * 
 * // startIndex negatif
 * // String s = sb.substring(-1); // StringIndexOutOfBoundsException
 * 
 * // startIndex > endIndex
 * // String s = sb.substring(3, 1); // StringIndexOutOfBoundsException
 * 
 * // endIndex > length()
 * // String s = sb.substring(0, 10); // StringIndexOutOfBoundsException
 * 
 * // startIndex == length() → OK (kembali "")
 * String s1 = sb.substring(4);
 * System.out.println(s1); // "" (kosong)
 * 
 * // startIndex == endIndex → OK (kembali "")
 * String s2 = sb.substring(2, 2);
 * System.out.println(s2); // "" (kosong)
 * 
 * 
 * Contoh Kode yang BENAR:
 * StringBuffer sb = new StringBuffer("Java Programming");
 * 
 * String sub1 = sb.substring(0, 4); // "Java"
 * String sub2 = sb.substring(5, 16); // "Programming"
 * String sub3 = sb.substring(5); // "Programming"
 * String sub4 = sb.substring(0, 0); // "" (kosong)
 * 
 * System.out.println(sub1); // "Java"
 * System.out.println(sub2); // "Programming"
 * System.out.println(sub3); // "Programming"
 * System.out.println(sub4); // ""
 * 
 * -----------------------------------------------------------------
 * 7. PERBANDINGAN DENGAN METHOD LAIN
 * -----------------------------------------------------------------
 * 
 * | Method | Return Type | Mengubah Data? | Fungsi |
 * |---------------|---------------|----------------|-------------------------------|
 * | substring() | String | TIDAK | Ambil sebagian string |
 * | delete() | StringBuffer | YA | Hapus sebagian string |
 * | replace() | StringBuffer | YA | Ganti sebagian string |
 * | insert() | StringBuffer | YA | Sisipkan di posisi tertentu |
 * 
 * 
 * // substring() - TIDAK mengubah buffer
 * StringBuffer sb = new StringBuffer("Hello World");
 * String result = sb.substring(0, 5);
 * System.out.println(sb); // "Hello World" (tetap)
 * System.out.println(result); // "Hello"
 * 
 * // delete() - MENGUBAH buffer
 * sb.delete(0, 5);
 * System.out.println(sb); // " World" (berubah)
 * 
 * // replace() - MENGUBAH buffer
 * sb.replace(0, 1, "Java");
 * System.out.println(sb); // "JavaWorld" (berubah)
 * 
 * -----------------------------------------------------------------
 * 8. PERBANDINGAN DENGAN STRING.substring()
 * -----------------------------------------------------------------
 * 
 * // String.substring() - dari String (immutable)
 * String str = "Hello World";
 * String sub1 = str.substring(0, 5);
 * // str tetap "Hello World", sub1 = "Hello"
 * 
 * // StringBuffer.substring() - dari StringBuffer (mutable)
 * StringBuffer sb = new StringBuffer("Hello World");
 * String sub2 = sb.substring(0, 5);
 * // sb tetap "Hello World", sub2 = "Hello"
 * 
 * KESAMAAN:
 * - Syntax sama
 * - Return String
 * - Tidak mengubah sumber asli
 * - endIndex exclusive
 * 
 * PERBEDAAN:
 * - String.substring(): dari String (immutable)
 * - StringBuffer.substring(): dari StringBuffer (mutable)
 * - Tapi sama-sama return String baru
 * 
 * -----------------------------------------------------------------
 * 9. KASUS PENGGUNAAN - KAPAN DIPAKAI
 * -----------------------------------------------------------------
 * 
 * substring() COCOK digunakan saat:
 * 
 * 1. Perlu mengambil bagian dari StringBuffer
 * - Ekstrak kata dari kalimat
 * - Ambil prefix atau suffix
 * 
 * 2. Perlu mempertahankan StringBuffer asli
 * - Tidak ingin mengubah data sumber
 * - Ingin buffer tetap utuh untuk penggunaan lain
 * 
 * 3. Konversi sebagian data ke String
 * - Butuh String dari bagian buffer
 * - Untuk passing ke method yang menerima String
 * 
 * 4. Parsing sederhana
 * - Ambil bagian tertentu dari data terstruktur
 * - Ekstrak field dari fixed-width format
 * 
 * substring() TIDAK COCOK digunakan saat:
 * 
 * 1. Ingin memodifikasi buffer
 * - Gunakan delete(), replace(), insert()
 * 
 * 2. Ingin mengambil substring sebagai StringBuffer (mutable)
 * - substring() return String (immutable)
 * - Pakai new StringBuffer(sb.substring(...))
 * 
 * 3. Hanya perlu akses karakter
 * - Gunakan charAt() dalam loop
 * 
 * -----------------------------------------------------------------
 * 10. SUBSTRING DAN CAPACITY - HUBUNGANNYA
 * -----------------------------------------------------------------
 * 
 * substring() tidak mempengaruhi capacity atau length dari buffer:
 * 
 * StringBuffer sb = new StringBuffer("Hello World");
 * System.out.println("Length: " + sb.length()); // 11
 * System.out.println("Capacity: " + sb.capacity()); // 27 (11 + 16)
 * 
 * String result = sb.substring(0, 5);
 * System.out.println("Hasil substring: " + result); // "Hello"
 * 
 * System.out.println("Length: " + sb.length()); // 11 (tetap)
 * System.out.println("Capacity: " + sb.capacity()); // 27 (tetap)
 * 
 * // Buffer TIDAK berubah sama sekali!
 * 
 * -----------------------------------------------------------------
 * 11. CONTOH LENGKAP - BERBAGAI SKENARIO
 * -----------------------------------------------------------------
 * 
 * public class SubstringDemo {
 * public static void main(String[] args) {
 * StringBuffer sb = new StringBuffer("Welcome to Java Programming");
 * 
 * // Skenario 1: Ambil kata pertama
 * String firstWord = sb.substring(0, 7);
 * System.out.println("Kata pertama: " + firstWord); // "Welcome"
 * 
 * // Skenario 2: Ambil kata terakhir
 * String lastWord = sb.substring(15);
 * System.out.println("Kata terakhir: " + lastWord); // "Programming"
 * 
 * // Skenario 3: Ambil bagian tengah
 * String middle = sb.substring(8, 10);
 * System.out.println("Bagian tengah: " + middle); // "to"
 * 
 * // Skenario 4: Buffer tetap utuh
 * System.out.println("Buffer asli: " + sb);
 * // "Welcome to Java Programming"
 * 
 * // Skenario 5: substring kosong
 * String empty1 = sb.substring(0, 0);
 * String empty2 = sb.substring(sb.length());
 * System.out.println("Empty 1: '" + empty1 + "'"); // "''"
 * System.out.println("Empty 2: '" + empty2 + "'"); // "''"
 * 
 * // Skenario 6: substring dari hasil substring
 * String sub = sb.substring(11, 15); // "Java"
 * String subSub = sub.substring(0, 2); // "Ja"
 * System.out.println("Sub dari substring: " + subSub); // "Ja"
 * }
 * }
 * 
 * Output:
 * Kata pertama: Welcome
 * Kata terakhir: Programming
 * Bagian tengah: to
 * Buffer asli: Welcome to Java Programming
 * Empty 1: ''
 * Empty 2: ''
 * Sub dari substring: Ja
 * 
 * -----------------------------------------------------------------
 * 12. SUBSTRING DENGAN METHOD CHAINING
 * -----------------------------------------------------------------
 * 
 * Karena substring() return String, bisa dirantai dengan method String:
 * 
 * StringBuffer sb = new StringBuffer("Hello World");
 * 
 * // Chaining dengan method String
 * String result = sb.substring(0, 5)
 * .toUpperCase()
 * .concat("!!!");
 * 
 * System.out.println(result); // "HELLO!!!"
 * 
 * 
 * // TAPI tidak bisa chaining dengan method StringBuffer
 * // karena substring() return String, BUKAN StringBuffer
 * 
 * // INI ERROR:
 * // sb.substring(0, 5).append("!!!"); // ERROR! append() bukan method String
 * 
 * // INI BENAR:
 * sb.append("!!!"); // Langsung di StringBuffer
 * System.out.println(sb); // "Hello World!!!"
 * 
 * -----------------------------------------------------------------
 * 13. PERFORMANCE INSIGHT - LEVEL UP
 * -----------------------------------------------------------------
 * 
 * substring() di StringBuffer:
 * 
 * 1. Membuat objek String baru
 * - Alokasi memory untuk String baru
 * - Copy data dari buffer ke String
 * - O(n) di mana n = panjang substring
 * 
 * 2. Tidak mengubah buffer
 * - Tidak ada modifikasi pada buffer
 * - Tidak ada geser karakter
 * 
 * 3. Lebih cepat dari modifikasi
 * - Lebih cepat dari delete/replace/insert
 * - Karena hanya baca dan copy, tidak modifikasi
 * 
 * 4. Perhatikan memory
 * - Jika sering ambil substring besar, banyak String baru
 * - Pertimbangkan apakah perlu menggunakan index saja
 * 
 * 
 * Performance tips:
 * // Lebih efisien jika hanya perlu akses karakter
 * for (int i = 0; i < 5; i++) {
 * char c = sb.charAt(i); // Tanpa bikin String baru
 * }
 * 
 * // Kurang efisien jika buat String baru setiap kali
 * for (int i = 0; i < 5; i++) {
 * String s = sb.substring(i, i+1); // Bikin String baru
 * }
 * 
 * -----------------------------------------------------------------
 * 14. CATATAN UNICODE (JAVA MODERN)
 * -----------------------------------------------------------------
 * 
 * substring() bekerja pada level char (16-bit UTF-16).
 * 
 * Untuk karakter non-BMP (emoji, aksara tertentu):
 * - Satu karakter = 2 char (surrogate pair)
 * - substring() bisa memotong di tengah surrogate pair
 * - Ini akan merusak karakter Unicode
 * 
 * Contoh:
 * StringBuffer sb = new StringBuffer("A🌍B");
 * // Internal: ['A', highSurrogate, lowSurrogate, 'B']
 * // Panjang = 4
 * 
 * // AMAN: Ambil seluruh karakter
 * String safe = sb.substring(0, 1); // "A" (aman)
 * String safe2 = sb.substring(3, 4); // "B" (aman)
 * 
 * // BERBAHAYA: Memotong di tengah surrogate pair
 * // String broken = sb.substring(1, 3); // Merusak 🌍
 * 
 * REKOMENDASI:
 * - Untuk Unicode, gunakan codePoint* method
 * - Jangan gunakan substring() dengan index yang memotong surrogate
 * 
 * // Alternatif aman untuk Unicode:
 * String str = "A🌍B";
 * int[] codePoints = str.codePoints().toArray();
 * 
 * // Ambil code point pertama
 * String first = new String(codePoints, 0, 1); // "A"
 * 
 * // Ambil code point kedua
 * String second = new String(codePoints, 1, 1); // "🌍"
 * 
 * ================================================================
 * KESIMPULAN - VERSI PADAT
 * ================================================================
 * 
 * 1. substring(start) = ambil dari start sampai akhir
 * 2. substring(start, end) = ambil dari start sampai end - 1
 * 3. endIndex adalah EXCLUSIVE (karakter di endIndex TIDAK diambil)
 * 4. TIDAK mengubah StringBuffer asli
 * 5. Mengembalikan String (BUKAN StringBuffer)
 * 6. Index harus valid (0 <= start <= end <= length())
 * 7. Membuat objek String baru setiap kali dipanggil
 * 8. Sama seperti String.substring() dalam perilaku
 * 9. Hati-hati dengan Unicode surrogate pairs
 * 
 * ================================================================
 * INTI PALING DALAM
 * ================================================================
 * 
 * substring() adalah jembatan antara dunia mutable (StringBuffer)
 * dan dunia immutable (String).
 * 
 * Dengan substring(), lo bisa mengambil bagian dari buffer
 * untuk digunakan sebagai String biasa tanpa mengganggu
 * integritas buffer asli.
 * 
 * ================================================================
 * CATATAN JAVA MODERN (17+)
 * ================================================================
 * 
 * 1. Method substring() telah tersedia sejak Java 1.0
 * 
 * 2. Java 7+ menggunakan shared char array untuk substring
 * - String.substring() di Java 7+ membuat String baru dengan array baru
 * - Java 6 kebawah sharing array (potensi memory leak)
 * 
 * 3. Untuk StringBuffer, substring() selalu membuat String baru
 * - Aman dari memory leak
 * 
 * 4. Alternatif modern:
 * - String.chars() / String.codePoints() untuk stream
 * - CharBuffer (NIO)
 * - Pattern/Matcher untuk regex extraction
 * 
 * 5. Jika butuh substring sebagai CharSequence:
 * - Gunakan subSequence() dari StringBuffer
 * - return CharSequence (lebih fleksibel)
 * 
 * ================================================================
 */

public class SubString {
    public static void main(String[] args) {

        // Membuat StringBuffer
        StringBuffer sb = new StringBuffer("Hello World");

        // 1. substring(startIndex)
        String result1 = sb.substring(6);
        // Ambil dari index 6 sampai akhir → "World"

        System.out.println("Substring dari index 6: " + result1);

        // 2. substring(startIndex, endIndex)
        String result2 = sb.substring(0, 5);
        // Ambil dari index 0 sampai 4 → "Hello"

        System.out.println("Substring 0-5: " + result2);

        // 3. Cek bahwa StringBuffer tidak berubah
        System.out.println("StringBuffer asli: " + sb);

    }
}
