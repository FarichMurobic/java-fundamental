package FundamentalJava.String.StringBuffer;

/**
 * ================================================================
 * insert() - MENYISIPKAN DATA DI POSISI MANAPUN
 * ================================================================
 * 
 * Method insert() digunakan untuk menyisipkan data (string atau
 * tipe lainnya) ke posisi tertentu di dalam StringBuffer.
 * 
 * -----------------------------------------------------------------
 * 1. DEKLARASI METHOD - BENTUK UMUM
 * -----------------------------------------------------------------
 * 
 * StringBuffer insert(int index, String str)
 * StringBuffer insert(int index, char ch)
 * StringBuffer insert(int index, int num)
 * StringBuffer insert(int index, long num)
 * StringBuffer insert(int index, double num)
 * StringBuffer insert(int index, float num)
 * StringBuffer insert(int index, boolean bool)
 * StringBuffer insert(int index, char[] charArray)
 * StringBuffer insert(int index, Object obj)
 * StringBuffer insert(int index, CharSequence cs)
 * 
 * Parameter:
 * - index : posisi di mana data akan disisipkan
 * - data : nilai yang akan disisipkan (berbagai tipe)
 * 
 * Method ini mengembalikan objek StringBuffer yang sama
 * (mendukung method chaining).
 * 
 * -----------------------------------------------------------------
 * 2. FUNGSI UTAMA - APA YANG DILAKUKAN
 * -----------------------------------------------------------------
 * 
 * insert() menyisipkan representasi string dari parameter kedua
 * ke dalam StringBuffer pada posisi yang ditentukan oleh index.
 * 
 * Konsep index:
 * - index = 0 : sisipkan di awal (sebelum karakter pertama)
 * - index = length() : sama dengan append() (di akhir)
 * - index = n : sisipkan sebelum karakter pada posisi n
 * 
 * -----------------------------------------------------------------
 * 3. CONTOH DASAR - CARA KERJA INDEX
 * -----------------------------------------------------------------
 * 
 * // Contoh 1: Sisipkan di tengah
 * StringBuffer sb = new StringBuffer("I Java!");
 * // Indeks: 0 1 2 3 4 5 6 7
 * // Karakter:I J a v a !
 * // ^0 ^1 ^2 ^3 ^4 ^5 ^6 ^7
 * 
 * sb.insert(2, "like ");
 * // Sisipkan "like " sebelum index 2 (sebelum huruf 'J')
 * 
 * System.out.println(sb); // "I like Java!"
 * 
 * // Contoh 2: Sisipkan di awal
 * StringBuffer sb2 = new StringBuffer("World");
 * sb2.insert(0, "Hello ");
 * System.out.println(sb2); // "Hello World"
 * 
 * // Contoh 3: Sisipkan di akhir (sama dengan append)
 * StringBuffer sb3 = new StringBuffer("Hello");
 * sb3.insert(sb3.length(), " World");
 * System.out.println(sb3); // "Hello World"
 * 
 * -----------------------------------------------------------------
 * 4. VISUALISASI - BIAR MAKIN JELAS
 * -----------------------------------------------------------------
 * 
 * StringBuffer awal: "Hello World"
 * Indeks: 0 1 2 3 4 5 6 7 8 9 10
 * Karakter: H e l l o W o r l d
 * 
 * // Kasus 1: Insert di index 5 (sebelum spasi)
 * sb.insert(5, " Beautiful");
 * 
 * Sebelum: [H][e][l][l][o][ ][W][o][r][l][d]
 * ^
 * index 5 (sebelum spasi)
 * 
 * Setelah: [H][e][l][l][o][ ][B][e][a][u][t][i][f][u][l][ ][W][o][r][l][d]
 * ^^^^^^^^^^^^^^^^^^^^^^^^
 * data yang disisipkan
 * 
 * Hasil: "Hello Beautiful World"
 * 
 * // Kasus 2: Insert di index 0 (awal)
 * sb.insert(0, "Greetings: ");
 * 
 * Sebelum: [G][r][e][e][t][i][n][g][s][:][ ][H][e][l][l][o][ ][W][o][r][l][d]
 * ^
 * index 0
 * 
 * Hasil: "Greetings: Hello World"
 * 
 * -----------------------------------------------------------------
 * 5. OVERLOADING - BANYAK TIPE DATA
 * -----------------------------------------------------------------
 * 
 * StringBuffer sb = new StringBuffer("Value: ");
 * 
 * // Insert berbagai tipe data
 * sb.insert(7, 100); // int → "Value: 100"
 * sb.insert(7, 3.14); // double → "Value: 3.14100" (jika dirantai)
 * 
 * // Lebih baik contoh terpisah:
 * StringBuffer sb2 = new StringBuffer("Data: ");
 * sb2.insert(6, 42); // int
 * System.out.println(sb2); // "Data: 42"
 * 
 * StringBuffer sb3 = new StringBuffer("Flag: ");
 * sb3.insert(6, true); // boolean
 * System.out.println(sb3); // "Flag: true"
 * 
 * StringBuffer sb4 = new StringBuffer("Char: ");
 * sb4.insert(6, 'X'); // char
 * System.out.println(sb4); // "Char: X"
 * 
 * StringBuffer sb5 = new StringBuffer("Object: ");
 * sb5.insert(8, new Object()); // Object
 * System.out.println(sb5); // "Object: java.lang.Object@..."
 * 
 * Semua tipe data otomatis dikonversi ke string menggunakan
 * String.valueOf() di balik layar.
 * 
 * -----------------------------------------------------------------
 * 6. MEKANISME INTERNAL - BAGAIMANA JAVA BEKERJA
 * -----------------------------------------------------------------
 * 
 * Saat insert() dipanggil:
 * 
 * 1. Validasi index (0 <= index <= length())
 * 2. Konversi parameter ke string (String.valueOf())
 * 3. Cek apakah kapasitas cukup (resize jika perlu)
 * 4. Geser karakter setelah posisi index ke kanan
 * 5. Copy data baru ke posisi index
 * 6. Update panjang buffer
 * 7. Kembalikan objek yang sama (return this)
 * 
 * Kompleksitas waktu:
 * - insert() : O(n) karena harus menggeser karakter
 * - n adalah jumlah karakter yang digeser ke kanan
 * - Semakin ke kiri posisi insert, semakin banyak karakter digeser
 * 
 * -----------------------------------------------------------------
 * 7. PERBANDINGAN APPEND VS INSERT
 * -----------------------------------------------------------------
 * 
 * | Method | Fungsi | Posisi | Kompleksitas |
 * |----------|-----------------------------|---------------|--------------|
 * | append() | Tambah data | Selalu di akhir| O(1) amortized|
 * | insert() | Sisipkan data di posisi tertentu| Di tengah | O(n) |
 * 
 * 
 * // APPEND - LEBIH CEPAT
 * sb.append(" World");
 * // Langsung di akhir, tidak perlu geser karakter
 * 
 * // INSERT - LEBIH LAMBAT (tapi fleksibel)
 * sb.insert(5, " Beautiful ");
 * // Harus geser semua karakter setelah index 5 ke kanan
 * 
 * 
 * ANALOGI BIAR NEMPEL:
 * 
 * append() = nambah kata di akhir kalimat (tinggal tulis)
 * insert() = nyelip kata di tengah kalimat (harus geser kata-kata setelahnya)
 * 
 * -----------------------------------------------------------------
 * 8. ATURAN INDEX - WAJIB PAHAM
 * -----------------------------------------------------------------
 * 
 * Aturan index untuk insert():
 * 
 * 1. index >= 0 (tidak boleh negatif)
 * 2. index <= length() (boleh sama dengan panjang)
 * 3. Jika index == length(), sama dengan append()
 * 
 * Pelanggaran aturan:
 * - StringIndexOutOfBoundsException
 * 
 * 
 * Contoh Kode yang SALAH:
 * StringBuffer sb = new StringBuffer("Java");
 * 
 * // Index negatif
 * // sb.insert(-1, "X"); // StringIndexOutOfBoundsException
 * 
 * // Index melebihi length()
 * // sb.insert(5, "X"); // StringIndexOutOfBoundsException
 * // (karena length = 4, index valid 0-4)
 * 
 * 
 * Contoh Kode yang BENAR:
 * StringBuffer sb = new StringBuffer("Java");
 * 
 * // index = 0 (awal)
 * sb.insert(0, "I love ");
 * System.out.println(sb); // "I love Java"
 * 
 * // index = length (akhir)
 * sb.insert(sb.length(), "!!!");
 * System.out.println(sb); // "I love Java!!!"
 * 
 * // index di tengah
 * sb = new StringBuffer("Hello World");
 * sb.insert(5, ",");
 * System.out.println(sb); // "Hello, World"
 * 
 * -----------------------------------------------------------------
 * 9. METHOD CHAINING - KOMBINASI DENGAN METHOD LAIN
 * -----------------------------------------------------------------
 * 
 * Karena insert() mengembalikan objek yang sama, bisa dirantai:
 * 
 * StringBuffer sb = new StringBuffer("Hello");
 * 
 * sb.insert(5, " World")
 * .insert(0, "Greetings, ")
 * .insert(17, "!!!");
 * 
 * System.out.println(sb); // "Greetings, Hello World!!!"
 * 
 * 
 * // Kombinasi dengan method lain
 * sb.delete(0, 10) // Hapus "Greetings,"
 * .insert(0, "Hi")
 * .append("!") // Append di akhir
 * .insert(2, ",");
 * 
 * System.out.println(sb); // "Hi, Hello World!!!"
 * 
 * -----------------------------------------------------------------
 * 10. KASUS PENGGUNAAN - KAPAN DIPAKAI
 * -----------------------------------------------------------------
 * 
 * insert() COCOK digunakan saat:
 * 
 * 1. Menambahkan prefix atau suffix
 * - insert(0, "Mr. ") → tambah gelar di depan
 * - insert(length(), " (draft)") → tambah status di belakang
 * 
 * 2. Memformat teks
 * - Menambahkan separator di posisi tertentu
 * - Memasukkan punctuation (koma, titik, dll)
 * 
 * 3. Build query atau template
 * - Sisipkan parameter ke dalam template string
 * - "INSERT INTO table VALUES (?, ?, ?)"
 * 
 * 4. Koreksi atau editing teks
 * - Memperbaiki typo dengan menyisipkan karakter
 * - Menambahkan kata yang terlewat
 * 
 * 5. Format data terstruktur
 * - CSV, JSON, XML, dll.
 * 
 * insert() TIDAK COCOK digunakan saat:
 * 
 * 1. Hanya perlu tambah di akhir → gunakan append()
 * 2. Operasi insert dilakukan sangat sering di awal string
 * - Karena geser karakter banyak → mahal
 * 3. String-nya sangat besar dan insert di posisi awal
 * - Pertimbangkan struktur data lain (LinkedList, dll)
 * 
 * -----------------------------------------------------------------
 * 11. PERFORMANCE INSIGHT - LEVEL UP
 * -----------------------------------------------------------------
 * 
 * insert() lebih mahal dari append() karena:
 * 
 * 1. HARUS GESER KARAKTER
 * - Setiap insert di posisi n, semua karakter setelah n
 * harus digeser ke kanan
 * - Biaya: O(n) di mana n = length() - index
 * 
 * 2. RESIZE POTENSIAL
 * - Jika kapasitas tidak cukup, resize terjadi
 * - Resize = copy semua data ke array baru
 * 
 * 3. STRATEGI OPTIMAL:
 * - Jika banyak insert di posisi yang sama, lakukan sekaligus
 * - Untuk banyak insert di awal, pertimbangkan reverse build
 * - Gunakan kapasitas awal yang cukup (ensureCapacity)
 * 
 * 
 * // SUB-OPTIMAL (banyak insert kecil)
 * StringBuffer sb = new StringBuffer("12345");
 * sb.insert(0, "A");
 * sb.insert(1, "B");
 * sb.insert(2, "C");
 * // 3 kali geser karakter, tidak efisien
 * 
 * // OPTIMAL (insert sekaligus)
 * StringBuffer sb = new StringBuffer("12345");
 * sb.insert(0, "ABC");
 * // 1 kali geser karakter, lebih efisien
 * 
 * 
 * -----------------------------------------------------------------
 * 12. PERBANDINGAN DENGAN STRING (IMMUTABLE)
 * -----------------------------------------------------------------
 * 
 * // STRING - SANGAT MAHAL UNTUK INSERT
 * String str = "Hello World";
 * // Tidak ada method insert
 * // Harus bikin String baru:
 * str = str.substring(0, 5) + " Beautiful" + str.substring(5);
 * // 3 objek String tercipta: substring kiri, " Beautiful", substring kanan
 * // Total: 3 objek baru + concatenation overhead
 * 
 * // STRINGBUFFER - EFFISIEN
 * StringBuffer sb = new StringBuffer("Hello World");
 * sb.insert(5, " Beautiful");
 * // 1 objek StringBuffer, langsung dimodifikasi
 * // Tidak ada objek String tambahan
 * 
 * -----------------------------------------------------------------
 * 13. CATATAN UNICODE (JAVA MODERN)
 * -----------------------------------------------------------------
 * 
 * insert() bekerja pada level char (16-bit UTF-16).
 * 
 * Untuk karakter non-BMP (emoji, aksara tertentu):
 * - Satu karakter = 2 char (surrogate pair)
 * - insert() akan memperlakukan surrogate pair sebagai 2 char
 * - Menyisipkan di tengah surrogate pair bisa merusak karakter
 * 
 * Contoh:
 * StringBuffer sb = new StringBuffer("A🌍B");
 * // Internal: ['A', highSurrogate, lowSurrogate, 'B']
 * // Panjang = 4 (bukan 3)
 * 
 * sb.insert(2, "X");
 * // Menyisipkan di tengah surrogate pair → merusak 🌍
 * // Hasil: ['A', highSurrogate, 'X', lowSurrogate, 'B']
 * // Karakter menjadi rusak
 * 
 * Rekomendasi:
 * - Untuk Unicode kompleks, gunakan codePoint* method
 * - Gunakan insert dengan hati-hati pada text internasional
 * 
 * ================================================================
 * KESIMPULAN - VERSI PADAT
 * ================================================================
 * 
 * 1. insert(index, data) = menyisipkan data di posisi tertentu
 * 2. Menerima semua tipe data (String, int, double, boolean, Object)
 * 3. index = 0 → sisip di awal, index = length() → sisip di akhir (sama append)
 * 4. Index harus 0 <= index <= length()
 * 5. Mengembalikan objek yang sama → support chaining
 * 6. Lebih mahal dari append() (harus geser karakter)
 * 7. Tetap lebih efisien daripada manipulasi String biasa
 * 8. Hati-hati dengan Unicode surrogate pairs
 * 
 * ================================================================
 * INTI PALING DALAM
 * ================================================================
 * 
 * insert() adalah method yang memberikan fleksibilitas total
 * dalam memanipulasi string di posisi manapun.
 * 
 * Meskipun lebih mahal dari append(), kemampuan untuk menyisipkan
 * di posisi arbitrer menjadikan insert() tool yang tak tergantikan
 * untuk formatting, editing, dan pembangunan teks dinamis.
 * 
 * ================================================================
 * CATATAN JAVA MODERN (17+)
 * ================================================================
 * 
 * Method insert() telah tersedia sejak Java 1.0 dan tetap
 * identik fungsinya hingga Java 17+.
 * 
 * Selain overload untuk tipe primitif, Java 17+ juga mendukung
 * insert untuk CharSequence, yang memungkinkan insert dari
 * berbagai sumber (String, StringBuilder, StringBuffer, dll).
 * 
 * Untuk performa optimal pada banyak operasi insert:
 * - Gunakan StringBuilder (non-thread-safe) jika single-threaded
 * - Atur kapasitas awal dengan ensureCapacity()
 * - Gabungkan insert jika memungkinkan
 * 
 * ================================================================
 */

public class Insert {
    public static void main(String[] args) {

        // Membuat StringBuffer dengan isi awal
        StringBuffer stringBuffer = new StringBuffer("i Java!");

        // Menyisipkan "like " pada index ke-2
        // index 2 = sebelum huruf 'J'
        stringBuffer.insert(2, "love ");
        // Menampilkan hasil
        System.out.println(stringBuffer); // i love Java!

        System.out.println("--------------------------");

        StringBuffer stringBuffer1 = new StringBuffer("Java");

        // Sisipkan di depan
        stringBuffer1.insert(0, "I love ");
        // Sisipkan di tengah
        stringBuffer1.insert(7, "very much, like i love Januar ");
        // Sisipkan di akhir (mirip append)
        stringBuffer1.insert(stringBuffer1.length(), "!!!");

        System.out.println(stringBuffer1);

    }
}
