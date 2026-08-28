package FundamentalJava.String.StringBuffer;

/**
 * ================================================================
 * charAt() DAN setCharAt() - AKSES & MODIFIKASI KARAKTER
 * ================================================================
 * 
 * StringBuffer menyediakan dua method fundamental untuk mengakses
 * dan memodifikasi karakter individual di dalam buffer.
 * 
 * -----------------------------------------------------------------
 * 1. DEKLARASI METHOD - BENTUK UMUM
 * -----------------------------------------------------------------
 * 
 * char charAt(int index)
 * - Mengambil satu karakter pada posisi index yang ditentukan.
 * - Mengembalikan nilai char pada posisi tersebut.
 * 
 * void setCharAt(int index, char ch)
 * - Mengganti karakter pada posisi index dengan karakter baru ch.
 * - Tidak mengembalikan nilai apa pun (void).
 * 
 * -----------------------------------------------------------------
 * 2. charAt() - MEMBACA KARAKTER
 * -----------------------------------------------------------------
 * 
 * Fungsi utama:
 * Mengambil satu karakter dari posisi tertentu di dalam StringBuffer.
 * 
 * Contoh:
 * StringBuffer sb = new StringBuffer("Hello");
 * // Indeks: 0 1 2 3 4
 * // Karakter: H e l l o
 * 
 * char c = sb.charAt(1);
 * System.out.println(c); // Output: 'e'
 * 
 * char c2 = sb.charAt(4);
 * System.out.println(c2); // Output: 'o'
 * 
 * -----------------------------------------------------------------
 * 3. setCharAt() - MENGUBAH KARAKTER
 * -----------------------------------------------------------------
 * 
 * Fungsi utama:
 * Mengganti karakter di posisi tertentu dengan karakter baru.
 * 
 * Contoh:
 * StringBuffer sb = new StringBuffer("Hello");
 * // Indeks: 0 1 2 3 4
 * // Karakter: H e l l o
 * 
 * sb.setCharAt(1, 'i');
 * System.out.println(sb); // Output: "Hillo"
 * 
 * sb.setCharAt(0, 'Y');
 * System.out.println(sb); // Output: "Yillo"
 * 
 * -----------------------------------------------------------------
 * 4. ATURAN INDEX - WAJIB PAHAM
 * -----------------------------------------------------------------
 * 
 * Index pada StringBuffer mengikuti aturan ketat:
 * 
 * 1. Index harus >= 0 (tidak boleh negatif)
 * 2. Index harus < length() (tidak boleh melebihi panjang string)
 * 
 * Jika aturan ini dilanggar, Java akan melempar exception:
 * StringIndexOutOfBoundsException
 * 
 * Contoh kode yang SALAH:
 * StringBuffer sb = new StringBuffer("Java");
 * 
 * // Index negatif - ERROR
 * // char c = sb.charAt(-1); // StringIndexOutOfBoundsException
 * 
 * // Index melebihi panjang - ERROR
 * // char c = sb.charAt(4); // StringIndexOutOfBoundsException
 * // (karena indeks valid hanya 0-3)
 * 
 * // Index sama dengan length - ERROR
 * // sb.setCharAt(4, 'X'); // StringIndexOutOfBoundsException
 * 
 * Contoh kode yang BENAR:
 * StringBuffer sb = new StringBuffer("Java");
 * // Indeks: 0=J, 1=a, 2=v, 3=a
 * 
 * char first = sb.charAt(0); // 'J' - valid
 * char last = sb.charAt(3); // 'a' - valid
 * sb.setCharAt(0, 'L'); // menjadi "Lava" - valid
 * sb.setCharAt(3, 'e'); // menjadi "Lave" - valid
 * 
 * -----------------------------------------------------------------
 * 5. PERBANDINGAN DENGAN STRING (IMMUTABLE)
 * -----------------------------------------------------------------
 * 
 * INI ADALAH KEUNGGULAN UTAMA STRINGBUFFER:
 * 
 * // STRING - TIDAK BISA DIUBAH LANGSUNG
 * String str = "Hello";
 * // str.setCharAt(1, 'i'); // TIDAK ADA METHOD INI!
 * // Harus bikin String baru:
 * str = str.substring(0, 1) + 'i' + str.substring(2);
 * // Object String baru tercipta di memori
 * 
 * // STRINGBUFFER - BISA DIUBAH LANGSUNG
 * StringBuffer sb = new StringBuffer("Hello");
 * sb.setCharAt(1, 'i'); // LANGSUNG diubah di buffer yang sama
 * // Tidak ada objek baru, memory lebih hemat
 * 
 * -----------------------------------------------------------------
 * 6. KASUS PENGGUNAAN - KAPAN DIPAKAI
 * -----------------------------------------------------------------
 * 
 * charAt() cocok digunakan saat:
 * - Membaca karakter spesifik dari posisi tertentu
 * - Validasi karakter (misal: mengecek apakah karakter pertama huruf kapital)
 * - Proses iterasi karakter per karakter
 * - Parsing teks sederhana
 * 
 * setCharAt() cocok digunakan saat:
 * - Mengganti satu karakter tanpa mengubah panjang string
 * - Mengkoreksi typo pada posisi tertentu
 * - Enkripsi/dekripsi sederhana (substitusi karakter)
 * - Manipulasi data teks di posisi tetap
 * 
 * -----------------------------------------------------------------
 * 7. PERFORMANCE - EFEK TERHADAP MEMORI
 * -----------------------------------------------------------------
 * 
 * charAt() adalah O(1) - akses langsung ke array internal.
 * Tidak ada overhead, sangat cepat.
 * 
 * setCharAt() juga O(1) - modifikasi langsung di array internal.
 * Tidak mengubah kapasitas buffer, tidak mengalokasikan memori baru.
 * 
 * Perbedaan besar dengan String:
 * - String: setiap modifikasi (bahkan 1 karakter) butuh object baru
 * - StringBuffer: modifikasi langsung di tempat, tanpa object baru
 * 
 * -----------------------------------------------------------------
 * 8. CATATAN PENTING UNICODE (JAVA MODERN)
 * -----------------------------------------------------------------
 * 
 * charAt() dan setCharAt() bekerja pada level char (16-bit UTF-16).
 * 
 * Untuk karakter di luar Basic Multilingual Plane (BMP),
 * seperti emoji atau aksara tertentu, satu karakter Unicode
 * direpresentasikan oleh 2 char (surrogate pair).
 * 
 * Pada kasus ini:
 * - charAt() hanya akan mengembalikan satu bagian dari pasangan
 * - setCharAt() bisa merusak surrogate pair jika tidak hati-hati
 * 
 * Rekomendasi untuk Unicode kompleks:
 * Gunakan method codePointAt(), codePointBefore(), dan
 * appendCodePoint() sebagai alternatif yang lebih aman.
 * 
 * ================================================================
 * KESIMPULAN - VERSI PADAT
 * ================================================================
 * 
 * 1. charAt(index) = membaca karakter pada posisi index
 * 2. setCharAt(index, ch) = mengubah karakter pada posisi index
 * 3. Index harus 0 <= index < length()
 * 4. Melanggar aturan index → StringIndexOutOfBoundsException
 * 5. StringBuffer memungkinkan modifikasi langsung (tidak perlu bikin objek
 * baru)
 * 6. Kedua method O(1) - sangat cepat
 * 7. Untuk Unicode non-BMP, pertimbangkan codePoint* method
 * 
 * ================================================================
 * INTI PALING DALAM
 * ================================================================
 * 
 * charAt() dan setCharAt() adalah bukti nyata bahwa StringBuffer
 * dirancang untuk manipulasi string dengan presisi karakter.
 * 
 * Kemampuan mengubah satu karakter tanpa membuat objek baru
 * menjadikan StringBuffer pilihan utama untuk operasi string
 * berat yang membutuhkan modifikasi granular.
 * 
 * ================================================================
 * CATATAN JAVA MODERN (17+)
 * ================================================================
 * 
 * Method charAt() dan setCharAt() telah tersedia sejak Java 1.0
 * dan tetap identik fungsinya hingga Java 17+.
 * 
 * Tidak ada perubahan signifikan, namun pemahaman tentang
 * surrogate pairs menjadi semakin penting seiring maraknya
 * penggunaan emoji dan karakter internasional di aplikasi modern.
 * 
 * Untuk aplikasi berbasis teks internasional, selalu pertimbangkan
 * apakah charAt() cukup atau perlu menggunakan codePointAt().
 * 
 * ================================================================
 */

public class CharAtAndSetCharAt {
    public static void main(String[] args) {

        // Membuat StringBuffer dengan isi awal
        StringBuffer stringBuffer = new StringBuffer("Hello");

        // Menampilkan isi awal buffer
        System.out.println("buffer before: " + stringBuffer); // Hello

        // Mengambil karakter pada index ke-1
        System.out.println("charAt(1) before: " + stringBuffer.charAt(1)); // e

        // Mengubah karakter pada index ke-1 menjadi 'i'
        stringBuffer.setCharAt(1, 'i');

        // Memotong panjang string jadi 2 karakter
        stringBuffer.setLength(2);

        // Menampilkan isi setelah perubahan
        System.out.println("buffer after: " + stringBuffer); // Hi

        // Mengambil karakter pada index ke-1 setelah perubahan
        System.out.println("charAt(1) after: " + stringBuffer.charAt(1)); // i
    }
}
