package FundamentalJava.String.StringBuffer;

/**
 * ================================================================
 * replace() - MENGGANTI SUBSTRING DENGAN STRING BARU
 * ================================================================
 * 
 * Method replace() digunakan untuk mengganti satu kumpulan
 * karakter dengan kumpulan karakter lain di dalam StringBuffer.
 * 
 * -----------------------------------------------------------------
 * 1. DEKLARASI METHOD - BENTUK UMUM
 * -----------------------------------------------------------------
 * 
 * StringBuffer replace(int startIndex, int endIndex, String str)
 * 
 * Parameter:
 * - startIndex : index awal substring yang akan diganti (inklusif)
 * - endIndex : index akhir substring yang akan diganti (eksklusif)
 * - str : string pengganti
 * 
 * Method ini mengembalikan objek StringBuffer yang sama
 * (mendukung method chaining).
 * 
 * -----------------------------------------------------------------
 * 2. FUNGSI UTAMA - APA YANG DILAKUKAN
 * -----------------------------------------------------------------
 * 
 * replace() menghapus substring dari startIndex sampai endIndex - 1,
 * lalu menyisipkan string str di posisi yang sama.
 * 
 * Konsep Kunci:
 * - endIndex adalah EXCLUSIVE (karakter di endIndex TIDAK dihapus)
 * - Panjang string pengganti BISA berbeda dari panjang substring yang dihapus
 * - Buffer otomatis menyesuaikan panjangnya
 * 
 * -----------------------------------------------------------------
 * 3. CONTOH DASAR - DARI MATERI
 * -----------------------------------------------------------------
 * 
 * // Program lengkap
 * class ReplaceDemo {
 * public static void main(String[] args) {
 * StringBuffer sb = new StringBuffer("This is a test.");
 * 
 * // Ganti "is" (index 5-7) dengan "was"
 * sb.replace(5, 7, "was");
 * 
 * System.out.println("After replace: " + sb);
 * // Output: "This was a test."
 * }
 * }
 * 
 * Visualisasi:
 * 
 * Sebelum: "This is a test."
 * Indeks: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * Karakter: T h i s i s a t e s t .
 * ^5 ^6 ^7
 * | | |
 * | | endIndex = 7 (TIDAK dihapus)
 * | endIndex - 1 = 6 (karakter 's' dihapus)
 * startIndex = 5 (karakter 'i' dihapus)
 * 
 * Yang dihapus: indeks 5 ('i') dan 6 ('s')
 * Diganti dengan: "was" (3 karakter)
 * 
 * Setelah: "This was a test."
 * Indeks: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * Karakter: T h i s w a s a t e s t .
 * 
 * -----------------------------------------------------------------
 * 4. REPLACE BISA BEDA PANJANG - FLEKSIBEL
 * -----------------------------------------------------------------
 * 
 * replace() TIDAK mengharuskan panjang string pengganti sama
 * dengan panjang substring yang dihapus.
 * 
 * // Case 1: Lebih PANJANG (3 karakter → 4 karakter)
 * StringBuffer sb1 = new StringBuffer("Hello");
 * sb1.replace(0, 1, "HAAA");
 * System.out.println(sb1); // "HAAAello"
 * 
 * Visualisasi:
 * Sebelum: [H][e][l][l][o]
 * ^0 ^1 ^2 ^3 ^4
 * 
 * replace(0, 1, "HAAA"):
 * - Hapus index 0 ('H')
 * - Sisipkan "HAAA" (4 karakter)
 * 
 * Setelah: [H][A][A][A][e][l][l][o]
 * ^0 ^1 ^2 ^3 ^4 ^5 ^6 ^7
 * 
 * // Case 2: Lebih PENDEK (4 karakter → 1 karakter)
 * StringBuffer sb2 = new StringBuffer("Hello");
 * sb2.replace(0, 4, "H");
 * System.out.println(sb2); // "Ho"
 * 
 * Visualisasi:
 * Sebelum: [H][e][l][l][o]
 * ^0 ^1 ^2 ^3 ^4
 * 
 * replace(0, 4, "H"):
 * - Hapus index 0,1,2,3 ("Hell")
 * - Sisipkan "H" (1 karakter)
 * 
 * Setelah: [H][o]
 * ^0 ^1
 * 
 * // Case 3: Sama panjang (3 karakter → 3 karakter)
 * StringBuffer sb3 = new StringBuffer("Hello World");
 * sb3.replace(6, 11, "Java");
 * System.out.println(sb3); // "Hello Java"
 * 
 * -----------------------------------------------------------------
 * 5. CARA KERJA INTERNAL - DELETE + INSERT
 * -----------------------------------------------------------------
 * 
 * Secara konsep, replace() adalah gabungan dari:
 * 
 * // 1. Hapus substring lama
 * sb.delete(startIndex, endIndex);
 * 
 * // 2. Sisipkan string baru di posisi yang sama
 * sb.insert(startIndex, str);
 * 
 * // TAPI, replace() lebih efisien!
 * // Karena langsung di-handle secara internal tanpa
 * // dua kali operasi terpisah
 * 
 * Perbandingan:
 * // Dengan delete + insert (2 operasi)
 * sb.delete(5, 7);
 * sb.insert(5, "was");
 * // 2 kali geser karakter
 * 
 * // Dengan replace (1 operasi)
 * sb.replace(5, 7, "was");
 * // 1 kali geser karakter (lebih cepat)
 * 
 * -----------------------------------------------------------------
 * 6. ATURAN INDEX - WAJIB PAHAM
 * -----------------------------------------------------------------
 * 
 * Aturan untuk replace():
 * 
 * 1. startIndex >= 0
 * 2. endIndex <= length()
 * 3. startIndex <= endIndex
 * 4. Jika startIndex == endIndex, tidak ada yang dihapus,
 * hanya insert di posisi startIndex
 * 
 * Pelanggaran aturan:
 * - StringIndexOutOfBoundsException
 * 
 * 
 * Contoh Kode yang SALAH:
 * StringBuffer sb = new StringBuffer("Java");
 * 
 * // startIndex negatif
 * // sb.replace(-1, 2, "X"); // StringIndexOutOfBoundsException
 * 
 * // endIndex > length()
 * // sb.replace(0, 10, "X"); // StringIndexOutOfBoundsException
 * 
 * // startIndex > endIndex
 * // sb.replace(3, 1, "X"); // StringIndexOutOfBoundsException
 * 
 * 
 * Contoh Kode yang BENAR:
 * StringBuffer sb = new StringBuffer("Programming");
 * 
 * // Ganti "gram" (index 3-6) dengan "XYZ"
 * sb.replace(3, 7, "XYZ");
 * System.out.println(sb); // "ProXYZing"
 * 
 * // startIndex == endIndex (sama dengan insert)
 * sb.replace(3, 3, "!!!");
 * System.out.println(sb); // "Pro!!!XYZing"
 * 
 * -----------------------------------------------------------------
 * 7. METHOD CHAINING - KOMBINASI DENGAN METHOD LAIN
 * -----------------------------------------------------------------
 * 
 * Karena replace() mengembalikan objek yang sama, bisa dirantai:
 * 
 * StringBuffer sb = new StringBuffer("Hello World!");
 * 
 * sb.replace(6, 11, "Java")
 * .replace(0, 5, "Hi")
 * .append("!!!")
 * .insert(2, ",");
 * 
 * System.out.println(sb); // "Hi, Java!!!"
 * 
 * 
 * // Contoh lain:
 * sb = new StringBuffer("I like Java programming");
 * 
 * sb.replace(7, 11, "Python")
 * .replace(0, 1, "We")
 * .replace(sb.length() - 11, sb.length(), "coding");
 * 
 * System.out.println(sb); // "We like Python coding"
 * 
 * -----------------------------------------------------------------
 * 8. KASUS PENGGUNAAN - KAPAN DIPAKAI
 * -----------------------------------------------------------------
 * 
 * replace() COCOK digunakan saat:
 * 
 * 1. Mengganti kata dalam kalimat
 * - "I like Java" → "I love Java"
 * - Replace kata dengan sinonim atau terjemahan
 * 
 * 2. Memperbaiki typo atau error
 * - "teh" → "the"
 * - "recieve" → "receive"
 * 
 * 3. Memformat data
 * - "2023-01-15" → "15/01/2023"
 * - Replace separator atau format
 * 
 * 4. Template engine sederhana
 * - "Hello {name}" → "Hello John"
 * - Replace placeholder dengan nilai
 * 
 * 5. Sanitasi atau filtering
 * - Replace karakter terlarang
 * - Replace unsafe characters
 * 
 * replace() TIDAK COCOK digunakan saat:
 * 
 * 1. Hanya perlu menghapus → gunakan delete()
 * 2. Hanya perlu menambah → gunakan insert() atau append()
 * 3. Perlu mengganti banyak substring berbeda
 * - Pertimbangkan loop atau regex (Pattern/Matcher)
 * 
 * -----------------------------------------------------------------
 * 9. PERBANDINGAN DENGAN STRING (IMMUTABLE)
 * -----------------------------------------------------------------
 * 
 * // STRING - SANGAT MAHAL UNTUK REPLACE
 * String str = "Hello World";
 * // Tidak ada method replace yang mengubah objek asli
 * // Harus bikin String baru:
 * str = str.replace("World", "Java");
 * // Object baru tercipta, objek lama dihapus
 * 
 * // STRINGBUFFER - EFFISIEN
 * StringBuffer sb = new StringBuffer("Hello World");
 * sb.replace(6, 11, "Java");
 * // Modifikasi langsung di buffer yang sama
 * // Tidak ada objek String tambahan
 * 
 * -----------------------------------------------------------------
 * 10. PERFORMANCE INSIGHT - LEVEL UP
 * -----------------------------------------------------------------
 * 
 * replace() lebih efisien daripada delete() + insert() karena:
 * 
 * 1. SATU OPERASI GESER
 * - delete() + insert() = 2 kali geser karakter
 * - replace() = 1 kali geser karakter
 * 
 * 2. OPTIMASI INTERNAL
 * - replace() dioptimasi di level JVM
 * - Menghindari overhead method call ganda
 * 
 * 3. EFFISIENSI UNTUK BEDA PANJANG
 * - Jika string pengganti lebih pendek: geser ke kiri
 * - Jika string pengganti lebih panjang: geser ke kanan
 * - Dilakukan sekali, bukan dua kali
 * 
 * Kompleksitas waktu:
 * - replace() : O(n) di mana n adalah jumlah karakter yang digeser
 * - delete() + insert() : O(n) + O(m) = lebih lambat
 * 
 * -----------------------------------------------------------------
 * 11. CONTOH LANJUTAN - BERBAGAI SKENARIO
 * -----------------------------------------------------------------
 * 
 * public class ReplaceAdvancedDemo {
 * public static void main(String[] args) {
 * // Skenario 1: Ganti kata
 * StringBuffer sb1 = new StringBuffer("I love programming");
 * sb1.replace(7, 11, "hate");
 * System.out.println(sb1); // "I hate programming"
 * 
 * // Skenario 2: Ganti format date
 * StringBuffer sb2 = new StringBuffer("2023-12-25");
 * sb2.replace(4, 5, "/")
 * .replace(7, 8, "/");
 * System.out.println(sb2); // "2023/12/25"
 * 
 * // Skenario 3: Replace placeholder
 * StringBuffer sb3 = new StringBuffer("Hello {name}, welcome to {city}");
 * sb3.replace(6, 12, "John")
 * .replace(26, 32, "Jakarta");
 * System.out.println(sb3); // "Hello John, welcome to Jakarta"
 * 
 * // Skenario 4: Ganti dengan panjang berbeda
 * StringBuffer sb4 = new StringBuffer("ID: 12345");
 * sb4.replace(4, 9, "6789012345");
 * System.out.println(sb4); // "ID: 6789012345"
 * }
 * }
 * 
 * -----------------------------------------------------------------
 * 12. CATATAN UNICODE (JAVA MODERN)
 * -----------------------------------------------------------------
 * 
 * replace() bekerja pada level char (16-bit UTF-16).
 * 
 * Untuk karakter non-BMP (emoji, aksara tertentu):
 * - Satu karakter = 2 char (surrogate pair)
 * - replace() harus digunakan dengan hati-hati
 * - Jangan memotong surrogate pair di tengah
 * 
 * Contoh aman:
 * StringBuffer sb = new StringBuffer("A🌍B");
 * // Panjang = 4 (A + surrogate pair + B)
 * 
 * // AMAN: Ganti seluruh surrogate pair
 * sb.replace(1, 3, "X");
 * System.out.println(sb); // "AXB" (🌍 diganti X)
 * 
 * // BERBAHAYA: Ganti di tengah surrogate pair
 * // sb.replace(1, 2, "X"); // Merusak 🌍
 * 
 * Rekomendasi:
 * - Untuk Unicode, gunakan codePoint* method untuk akurasi
 * - Pastikan tidak memotong surrogate pair
 * 
 * -----------------------------------------------------------------
 * 13. RINGKASAN SEMUA SENJATA STRINGBUFFER
 * -----------------------------------------------------------------
 * 
 * Sekarang lo udah ngerti hampir semua method StringBuffer:
 * 
 * | Method | Fungsi |
 * |----------------- |--------------------------------------------|
 * | append() | Tambah data di akhir |
 * | insert() | Tambah data di posisi tertentu |
 * | delete() | Hapus banyak karakter |
 * | deleteCharAt() | Hapus satu karakter |
 * | replace() | Ganti substring dengan string baru |
 * | reverse() | Balik urutan karakter |
 * | charAt() | Ambil karakter di posisi tertentu |
 * | setCharAt() | Ubah karakter di posisi tertentu |
 * | getChars() | Copy substring ke char array |
 * | setLength() | Atur panjang buffer (bisa truncate) |
 * | ensureCapacity() | Optimasi kapasitas untuk performa |
 * | trimToSize() | Potong kapasitas sesuai isi (hemat memory) |
 * | length() | Dapatkan jumlah karakter terpakai |
 * | capacity() | Dapatkan total kapasitas buffer |
 * | substring() | Ambil substring sebagai String |
 * | subSequence() | Ambil substring sebagai CharSequence |
 * 
 * ================================================================
 * KESIMPULAN - VERSI PADAT
 * ================================================================
 * 
 * 1. replace(start, end, str) = ganti substring dengan string baru
 * 2. endIndex adalah EXCLUSIVE (karakter di endIndex TIDAK dihapus)
 * 3. Panjang string pengganti BISA berbeda (lebih panjang/pendek)
 * 4. Buffer otomatis menyesuaikan panjangnya
 * 5. replace() = delete() + insert() tapi lebih efisien
 * 6. Index harus valid (0 <= start <= end <= length())
 * 7. Mengembalikan objek yang sama → support chaining
 * 8. Lebih efisien daripada manipulasi String biasa
 * 
 * ================================================================
 * INTI PALING DALAM
 * ================================================================
 * 
 * replace() adalah salah satu method paling powerful di
 * StringBuffer yang menggabungkan kemampuan delete dan insert
 * dalam satu operasi yang efisien.
 * 
 * Dengan replace(), lo bisa mengubah isi string di posisi
 * manapun dengan fleksibilitas penuh, baik itu mengganti satu
 * karakter, satu kata, atau seluruh kalimat.
 * 
 * ================================================================
 * CATATAN JAVA MODERN (17+)
 * ================================================================
 * 
 * Method replace() telah tersedia sejak Java 1.0 dan tetap
 * identik fungsinya hingga Java 17+.
 * 
 * Perbedaan dengan String.replace():
 * - String.replace() : mengganti semua kemunculan, mengembalikan String baru
 * - StringBuffer.replace() : mengganti satu rentang, memodifikasi buffer
 * 
 * Untuk aplikasi modern:
 * - Gunakan StringBuffer.replace() untuk modifikasi in-place
 * - Gunakan String.replace() / replaceAll() untuk penggantian global
 * 
 * ================================================================
 */

public class Replace {
    public static void main(String[] args) {

        // Membuat StringBuffer dengan isi awal
        StringBuffer sb = new StringBuffer("This is a test.");

        // Mengganti karakter dari index 5 sampai 6 (7 tidak ikut)
        // "is" diganti menjadi "was"
        sb.replace(5, 7, "was");

        // Menampilkan hasil
        System.out.println("After replace: " + sb);
        // Output: "This was a test."

        StringBuffer sb1 = new StringBuffer("I hate Java");

        // Ganti "hate" jadi "love"
        sb1.replace(2, 6, "love");

        System.out.println(sb1); // "I love Java"

    }
}
