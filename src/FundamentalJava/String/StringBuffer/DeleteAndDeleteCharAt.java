package FundamentalJava.String.StringBuffer;

/**
 * ================================================================
 * delete() DAN deleteCharAt() - MENGHAPUS KARAKTER
 * ================================================================
 * 
 * StringBuffer menyediakan dua method untuk menghapus karakter
 * dari buffer: delete() untuk menghapus banyak karakter sekaligus,
 * dan deleteCharAt() untuk menghapus satu karakter saja.
 * 
 * -----------------------------------------------------------------
 * 1. DEKLARASI METHOD - BENTUK UMUM
 * -----------------------------------------------------------------
 * 
 * StringBuffer delete(int startIndex, int endIndex)
 * - Menghapus karakter dari startIndex hingga endIndex - 1
 * - Mengembalikan objek StringBuffer yang sama (mendukung chaining)
 * 
 * StringBuffer deleteCharAt(int index)
 * - Menghapus satu karakter pada posisi index
 * - Mengembalikan objek StringBuffer yang sama (mendukung chaining)
 * 
 * -----------------------------------------------------------------
 * 2. delete() - MENGHAPUS BANYAK KARAKTER
 * -----------------------------------------------------------------
 * 
 * Fungsi utama:
 * Menghapus rentang karakter dari posisi start sampai end - 1.
 * 
 * ATURAN PENTING:
 * endIndex adalah EXCLUSIVE (tidak ikut dihapus)
 * 
 * Contoh:
 * StringBuffer sb = new StringBuffer("This is a test.");
 * // Indeks: 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * // Karakter:T h i s i s a t e s t .
 * 
 * sb.delete(4, 7);
 * // Menghapus indeks 4, 5, 6 (karakter ' ', 'i', 's')
 * 
 * System.out.println(sb); // Output: "This a test."
 * // ^^^ ^^^
 * // indeks 4-6 hasil: spasi + a + test
 * 
 * Visualisasi:
 * Sebelum: T h i s [ ] i s [ ] a [ ] t e s t .
 * ^4 ^5 ^6
 * Setelah: T h i s [ ] a [ ] t e s t .
 * 
 * -----------------------------------------------------------------
 * 3. deleteCharAt() - MENGHAPUS SATU KARAKTER
 * -----------------------------------------------------------------
 * 
 * Fungsi utama:
 * Menghapus satu karakter pada posisi tertentu.
 * 
 * Contoh:
 * StringBuffer sb = new StringBuffer("Hello World");
 * // Indeks: 0 1 2 3 4 5 6 7 8 9 10
 * // Karakter:H e l l o W o r l d
 * 
 * sb.deleteCharAt(5); // Menghapus karakter spasi di indeks 5
 * System.out.println(sb); // Output: "HelloWorld"
 * 
 * sb.deleteCharAt(0); // Menghapus karakter 'H'
 * System.out.println(sb); // Output: "elloWorld"
 * 
 * -----------------------------------------------------------------
 * 4. PERBANDINGAN CEPAT - MANA YANG DIPAKAI
 * -----------------------------------------------------------------
 * 
 * delete(int start, int end) -> Menghapus BANYAK karakter
 * deleteCharAt(int index) -> Menghapus SATU karakter
 * 
 * Contoh pemilihan:
 * 
 * // Hapus 1 karakter
 * sb.deleteCharAt(3); // Lebih tepat dan efisien
 * 
 * // Hapus 5 karakter
 * sb.delete(2, 7); // Gunakan delete() untuk rentang
 * 
 * // Hapus semua karakter (kosongkan buffer)
 * sb.delete(0, sb.length()); // Hapus semua
 * 
 * // Hapus karakter terakhir
 * sb.deleteCharAt(sb.length() - 1);
 * 
 * -----------------------------------------------------------------
 * 5. ATURAN INDEX - WAJIB PAHAM
 * -----------------------------------------------------------------
 * 
 * Aturan untuk delete():
 * - startIndex harus >= 0
 * - endIndex harus <= length()
 * - startIndex <= endIndex
 * - Jika startIndex == endIndex, tidak ada yang dihapus (no-op)
 * - Jika endIndex > length(), akan dianggap sama dengan length()
 * 
 * Aturan untuk deleteCharAt():
 * - index harus >= 0
 * - index harus < length()
 * 
 * Pelanggaran aturan:
 * - StringIndexOutOfBoundsException
 * 
 * Contoh Kode yang SALAH:
 * StringBuffer sb = new StringBuffer("Java");
 * 
 * // Index negatif
 * // sb.delete(-1, 2); // StringIndexOutOfBoundsException
 * 
 * // start > end
 * // sb.delete(3, 1); // StringIndexOutOfBoundsException
 * 
 * // index >= length()
 * // sb.deleteCharAt(4); // StringIndexOutOfBoundsException
 * 
 * Contoh Kode yang BENAR:
 * StringBuffer sb = new StringBuffer("Programming");
 * 
 * // Hapus "gram" (indeks 3-6)
 * sb.delete(3, 7);
 * System.out.println(sb); // "Proing" (karena "gram" dihapus)
 * 
 * // Hapus karakter 'P'
 * sb.deleteCharAt(0);
 * System.out.println(sb); // "roing"
 * 
 * -----------------------------------------------------------------
 * 6. MEKANISME INTERNAL - BAGAIMANA JAVA BEKERJA
 * -----------------------------------------------------------------
 * 
 * Saat delete() atau deleteCharAt() dipanggil:
 * 
 * 1. Java memeriksa validitas index
 * 2. Menandai karakter yang akan dihapus
 * 3. Menggeser semua karakter setelah posisi hapus ke kiri
 * 4. Mengurangi panjang buffer
 * 5. Mengembalikan objek yang sama (return this)
 * 
 * Kompleksitas waktu:
 * - deleteCharAt() : O(n) karena harus menggeser karakter
 * - delete() : O(n) karena harus menggeser karakter
 * - n adalah jumlah karakter yang digeser (bukan yang dihapus)
 * 
 * -----------------------------------------------------------------
 * 7. PERBANDINGAN DENGAN STRING (IMMUTABLE)
 * -----------------------------------------------------------------
 * 
 * // STRING - TIDAK EFFISIEN UNTUK DELETE
 * String str = "Hello World";
 * // Tidak ada method delete
 * // Harus buat String baru:
 * str = str.substring(0, 5) + str.substring(6);
 * // Object String baru tercipta
 * 
 * // STRINGBUFFER - EFFISIEN
 * StringBuffer sb = new StringBuffer("Hello World");
 * sb.deleteCharAt(5); // Modifikasi langsung di buffer yang sama
 * // Tidak ada objek baru
 * 
 * -----------------------------------------------------------------
 * 8. KASUS PENGGUNAAN - KAPAN DIPAKAI
 * -----------------------------------------------------------------
 * 
 * delete() cocok digunakan saat:
 * - Menghapus kata atau frasa dari kalimat
 * - Menghapus bagian tertentu dari data terstruktur
 * - Membersihkan karakter yang tidak diinginkan dalam rentang
 * - Mengosongkan seluruh buffer (delete(0, length()))
 * 
 * deleteCharAt() cocok digunakan saat:
 * - Menghapus karakter tertentu (misal: spasi berlebih)
 * - Menghapus karakter di posisi spesifik (misal: tanda baca)
 * - Menghapus karakter terakhir (trimming)
 * - Koreksi pada posisi tertentu
 * 
 * -----------------------------------------------------------------
 * 9. METHOD CHAINING - KOMBINASI DENGAN METHOD LAIN
 * -----------------------------------------------------------------
 * 
 * Karena delete() dan deleteCharAt() mengembalikan objek yang sama,
 * mereka bisa dirantai dengan method lain:
 * 
 * StringBuffer sb = new StringBuffer("Hello World!");
 * 
 * sb.delete(5, 6) // Hapus spasi → "HelloWorld!"
 * .deleteCharAt(5) // Hapus 'W' → "Helloorld!"
 * .insert(5, " ") // Tambah spasi → "Hello orld!"
 * .append(" Java"); // Tambah " Java" → "Hello orld! Java"
 * 
 * System.out.println(sb);
 * 
 * -----------------------------------------------------------------
 * 10. PERFORMANCE INSIGHT - LEVEL UP
 * -----------------------------------------------------------------
 * 
 * PENTING:
 * 
 * delete() dan insert() sama-sama melakukan operasi penggeseran
 * karakter di dalam array internal.
 * 
 * Biaya penggeseran:
 * - Jika menghapus di awal string → menggeser banyak karakter (mahal)
 * - Jika menghapus di akhir string → menggeser sedikit karakter (murah)
 * - Jika menghapus di tengah string → menggeser karakter di belakangnya
 * 
 * Dibandingkan dengan String:
 * - String: setiap operasi delete bikin object baru (SANGAT MAHAL)
 * - StringBuffer: menggeser di array yang sama (LEBIH EFFISIEN)
 * 
 * TIPS OPTIMAL:
 * - Untuk menghapus di awal string, pertimbangkan substring() saja
 * - Untuk banyak operasi delete, lakukan di akhir string
 * - Kapasitas awal yang besar mengurangi resize
 * 
 * -----------------------------------------------------------------
 * 11. CATATAN UNICODE (JAVA MODERN)
 * -----------------------------------------------------------------
 * 
 * delete() dan deleteCharAt() bekerja pada level char (16-bit).
 * 
 * Untuk karakter non-BMP (emoji, aksara tertentu):
 * - Satu karakter = 2 char (surrogate pair)
 * - deleteCharAt() bisa merusak surrogate pair jika index di tengah
 * - delete() juga harus hati-hati dengan batas surrogate pair
 * 
 * Rekomendasi:
 * - Untuk teks Unicode kompleks, gunakan codePoint* method
 * - Pastikan tidak memotong surrogate pair di tengah
 * 
 * ================================================================
 * KESIMPULAN - VERSI PADAT
 * ================================================================
 * 
 * 1. delete(start, end) = hapus banyak karakter (end EXCLUSIVE)
 * 2. deleteCharAt(index) = hapus satu karakter
 * 3. Kedua method return objek yang sama → support chaining
 * 4. Index harus 0 <= index < length()
 * 5. delete() lebih efisien untuk hapus banyak karakter sekaligus
 * 6. Kompleksitas O(n) karena penggeseran karakter
 * 7. Jauh lebih efisien dibandingkan manipulasi String biasa
 * 8. Hati-hati dengan Unicode surrogate pairs
 * 
 * ================================================================
 * INTI PALING DALAM
 * ================================================================
 * 
 * delete() dan deleteCharAt() adalah bukti bahwa StringBuffer
 * memberikan kontrol penuh atas manipulasi string di tingkat
 * karakter, tanpa harus membuat objek baru setiap kali.
 * 
 * Kemampuan ini menjadikan StringBuffer pilihan utama untuk
 * operasi edit teks, parsing data, dan manipulasi string
 * yang membutuhkan penghapusan karakter secara efisien.
 * 
 * ================================================================
 * CATATAN JAVA MODERN (17+)
 * ================================================================
 * 
 * Method delete() dan deleteCharAt() telah tersedia sejak Java 1.0
 * dan tetap valid hingga Java 17+ dengan perilaku yang identik.
 * 
 * Tidak ada perubahan signifikan, namun pemahaman tentang
 * efisiensi relatif terhadap StringBuilder penting untuk
 * aplikasi performa tinggi.
 * 
 * Untuk penggunaan single-threaded:
 * - StringBuilder lebih cepat dari StringBuffer
 * - Method delete() dan deleteCharAt() memiliki perilaku identik
 * - Preferensi: StringBuilder untuk performa maksimal
 * 
 * ================================================================
 */

public class DeleteAndDeleteCharAt {

    public static void main(String[] args) {

        // Membuat StringBuffer dengan isi awal
        StringBuffer sb = new StringBuffer("This is a test.");

        // Menghapus karakter dari index 4 sampai 6 (7 tidak ikut)
        sb.delete(4, 7);

        // Menampilkan hasil setelah delete
        System.out.println("After delete: " + sb);
        // Hasil: "This a test."

        // Menghapus karakter di index ke-0
        sb.deleteCharAt(0);

        // Menampilkan hasil setelah deleteCharAt
        System.out.println("After deleteCharAt: " + sb);
        // Hasil: "his a test."

    }
}
