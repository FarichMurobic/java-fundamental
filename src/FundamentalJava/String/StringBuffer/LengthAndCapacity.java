package FundamentalJava.String.StringBuffer;

/**
 * ================================================================
 * length() DAN capacity() - UKURAN ISI & RUANG BUFFER
 * ================================================================
 * 
 * StringBuffer menyediakan dua method untuk mengetahui ukuran
 * buffer: length() untuk jumlah karakter yang terisi, dan
 * capacity() untuk total ruang yang dialokasikan di memory.
 * 
 * -----------------------------------------------------------------
 * 1. DEKLARASI METHOD - BENTUK UMUM
 * -----------------------------------------------------------------
 * 
 * int length()
 * - Mengembalikan jumlah karakter yang sedang digunakan
 * - Menunjukkan panjang aktual string di dalam buffer
 * 
 * int capacity()
 * - Mengembalikan total kapasitas buffer yang dialokasikan
 * - Menunjukkan ruang maksimum sebelum resize diperlukan
 * 
 * -----------------------------------------------------------------
 * 2. length() - JUMLAH KARAKTER YANG DIPAKAI
 * -----------------------------------------------------------------
 * 
 * Fungsi utama:
 * Mengetahui berapa banyak karakter yang sedang tersimpan
 * di dalam StringBuffer saat ini.
 * 
 * Contoh:
 * StringBuffer sb = new StringBuffer("Hello");
 * System.out.println(sb.length()); // Output: 5
 * 
 * sb.append(" World");
 * System.out.println(sb.length()); // Output: 11
 * 
 * sb.delete(0, 6); // Hapus "Hello "
 * System.out.println(sb.length()); // Output: 5 ("World")
 * 
 * -----------------------------------------------------------------
 * 3. capacity() - TOTAL RUANG YANG DISEDIAKAN
 * -----------------------------------------------------------------
 * 
 * Fungsi utama:
 * Mengetahui total kapasitas buffer yang sudah dialokasikan
 * di memory, termasuk ruang kosong yang belum terpakai.
 * 
 * Contoh:
 * StringBuffer sb = new StringBuffer("Hello");
 * System.out.println(sb.capacity()); // Output: 21
 * 
 * // Detail: 5 (isi) + 16 (default buffer) = 21
 * 
 * sb.append(" World");
 * System.out.println(sb.capacity()); // Output: 21 (masih cukup)
 * 
 * sb.append("!!!");
 * System.out.println(sb.capacity()); // Output: 21 (masih cukup)
 * 
 * // Isi sekarang: 14 karakter, kapasitas 21
 * // Masih ada 7 slot kosong
 * 
 * -----------------------------------------------------------------
 * 4. PERBEDAAN PENTING - WAJIB PAHAM
 * -----------------------------------------------------------------
 * 
 * | Method | Arti | Contoh (Hello) |
 * |------------|--------------------------------|----------------|
 * | length() | Jumlah karakter yang terisi | 5 |
 * | capacity() | Total ruang yang dialokasikan | 21 (5 + 16) |
 * 
 * Konsep Kunci:
 * - capacity() >= length() (selalu)
 * - capacity() - length() = ruang kosong yang tersedia
 * - Jika length() mencapai capacity(), resize akan terjadi
 * 
 * -----------------------------------------------------------------
 * 5. STUDI KASUS - DEFAULT CAPACITY
 * -----------------------------------------------------------------
 * 
 * // Case 1: Default constructor
 * StringBuffer sb1 = new StringBuffer();
 * System.out.println("Length: " + sb1.length()); // 0
 * System.out.println("Capacity: " + sb1.capacity()); // 16
 * 
 * // Case 2: Constructor dengan String
 * StringBuffer sb2 = new StringBuffer("Hello");
 * System.out.println("Length: " + sb2.length()); // 5
 * System.out.println("Capacity: " + sb2.capacity()); // 21 (5 + 16)
 * 
 * // Case 3: Constructor dengan kapasitas
 * StringBuffer sb3 = new StringBuffer(100);
 * System.out.println("Length: " + sb3.length()); // 0
 * System.out.println("Capacity: " + sb3.capacity()); // 100
 * 
 * -----------------------------------------------------------------
 * 6. KENAPA CAPACITY LEBIH BESAR? - MEKANISME OPTIMASI
 * -----------------------------------------------------------------
 * 
 * Java secara default menyediakan ruang ekstra (16 karakter)
 * untuk mengantisipasi operasi append di masa depan.
 * 
 * Tujuan:
 * - Mengurangi frekuensi resize/reallocation
 * - Meningkatkan performa pada operasi append
 * - Menghemat waktu eksekusi
 * 
 * Tanpa capacity ekstra:
 * StringBuffer sb = new StringBuffer("Hello");
 * // capacity = 5 (tanpa ekstra)
 * 
 * sb.append(" World"); // HARUS RESIZE! (karena 5 < 11)
 * // 1. Alokasi array baru
 * // 2. Copy semua data
 * // 3. Hapus array lama
 * // Mahal!
 * 
 * Dengan capacity ekstra:
 * StringBuffer sb = new StringBuffer("Hello");
 * // capacity = 21 (5 + 16 ekstra)
 * 
 * sb.append(" World"); // TIDAK RESIZE! (21 >= 11)
 * // Langsung pakai ruang kosong
 * // Cepat!
 * 
 * -----------------------------------------------------------------
 * 7. RESIZE / REALLOCATION - SAAT CAPACITY HABIS
 * -----------------------------------------------------------------
 * 
 * Apa yang terjadi saat capacity habis?
 * 
 * 1. Java mendeteksi bahwa length() akan melebihi capacity()
 * 2. Menghitung kapasitas baru: (oldCapacity * 2) + 2
 * 3. Mengalokasikan array baru dengan kapasitas tersebut
 * 4. Menyalin semua data dari array lama ke array baru
 * 5. Array lama dihapus (garbage collection)
 * 6. Melanjutkan operasi append/insert
 * 
 * Contoh proses resize:
 * 
 * StringBuffer sb = new StringBuffer(); // capacity = 16
 * 
 * for (int i = 0; i < 100; i++) {
 * sb.append("X"); // Append 100 karakter
 * }
 * 
 * // Proses resize yang terjadi:
 * // 1. 16 → 34 (resize 1, setelah 17 karakter)
 * // 2. 34 → 70 (resize 2, setelah 35 karakter)
 * // 3. 70 → 142 (resize 3, setelah 71 karakter)
 * // Total: 3 kali resize untuk 100 karakter
 * 
 * Mengapa resize mahal?
 * 
 * 1. Alokasi memory baru
 * 2. Copy data lama (O(n) operasi)
 * 3. Garbage collection overhead
 * 4. Waktu eksekusi lebih lama
 * 
 * -----------------------------------------------------------------
 * 8. ILUSTRASI - MEMORI BUFFER
 * -----------------------------------------------------------------
 * 
 * StringBuffer sb = new StringBuffer("Hello");
 * 
 * Representasi memory:
 * 
 * [H][e][l][l][o][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 * ^0 ^1 ^2 ^3 ^4 ^5 ^6 ^7 ^8 ^9 ^10^11^12^13^14^15^16^17^18^19^20
 * <------- length = 5 ------->
 * <---------------- capacity = 21 ------------------------------>
 * 
 * Setelah append(" World"):
 * 
 * [H][e][l][l][o][ ][W][o][r][l][d][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 * ^0 ^1 ^2 ^3 ^4 ^5 ^6 ^7 ^8 ^9 ^10^11^12^13^14^15^16^17^18^19^20
 * <---------- length = 11 --------->
 * <---------------- capacity = 21 ------------------------------>
 * 
 * Setelah append("!!! Today"):
 * 
 * [H][e][l][l][o][ ][W][o][r][l][d][!][!][!][ ][T][o][d][a][y][ ]
 * ^0 ^1 ^2 ^3 ^4 ^5 ^6 ^7 ^8 ^9 ^10^11^12^13^14^15^16^17^18^19^20
 * <--------------- length = 20 -------------->
 * <---------------- capacity = 21 ------------------------------>
 * 
 * Setelah append(" is sunny"):
 * 
 * // capacity = 21, tapi butuh 29 karakter (20 + 9)
 * // RESIZE TERJADI!
 * 
 * [H][e][l][l][o][ ][W][o][r][l][d][!][!][!][ ][T][o][d][a][y][ ][i][s][
 * ][s][u][n][n][y]
 * ^0 ^1 ^2 ^3 ^4 ^5 ^6 ^7 ^8 ^9
 * ^10^11^12^13^14^15^16^17^18^19^20^21^22^23^24^25^26^27^28
 * <---------------------------- length = 29 --------------------------->
 * <---------------------------- capacity = 44 (resize) --------------->
 * 
 * -----------------------------------------------------------------
 * 9. CARA CEK LENGTH & CAPACITY - CONTOH KODE
 * -----------------------------------------------------------------
 * 
 * public class LengthCapacityExample {
 * public static void main(String[] args) {
 * StringBuffer sb = new StringBuffer("Java");
 * 
 * System.out.println("Awal:");
 * System.out.println(" Length: " + sb.length()); // 4
 * System.out.println(" Capacity: " + sb.capacity()); // 20 (4 + 16)
 * 
 * // Tambah 10 karakter
 * for (int i = 0; i < 10; i++) {
 * sb.append("X");
 * }
 * 
 * System.out.println("\nSetelah tambah 10 karakter:");
 * System.out.println(" Length: " + sb.length()); // 14
 * System.out.println(" Capacity: " + sb.capacity()); // 20 (masih cukup)
 * 
 * // Tambah sampai melewati kapasitas
 * for (int i = 0; i < 10; i++) {
 * sb.append("Y");
 * }
 * 
 * System.out.println("\nSetelah tambah 10 karakter lagi:");
 * System.out.println(" Length: " + sb.length()); // 24
 * System.out.println(" Capacity: " + sb.capacity()); // 42 (resize)
 * 
 * // Cek perbedaan
 * System.out.println("\nRuang kosong: " + (sb.capacity() - sb.length()));
 * // 42 - 24 = 18 slot kosong
 * }
 * }
 * 
 * -----------------------------------------------------------------
 * 10. STRATEGI OPTIMAL - MENGELOLA CAPACITY
 * -----------------------------------------------------------------
 * 
 * 1. Jika tahu perkiraan ukuran akhir:
 * // Gunakan constructor dengan kapasitas
 * StringBuffer sb = new StringBuffer(1000);
 * // Langsung capacity 1000, hindari resize
 * 
 * 2. Jika tidak tahu, tapi akan banyak append:
 * StringBuffer sb = new StringBuffer();
 * sb.ensureCapacity(1000);
 * // Alokasi kapasitas minimum 1000
 * 
 * 3. Jika sudah selesai dan ingin hemat memory:
 * sb.trimToSize();
 * // Potong capacity menjadi length (hemat memory)
 * 
 * 4. Monitor length dan capacity:
 * if (sb.length() > sb.capacity() * 0.8) {
 * // Jika sudah 80% penuh, siapkan resize atau
 * // ensureCapacity untuk menghindari resize mendadak
 * }
 * 
 * -----------------------------------------------------------------
 * 11. KAPAN LENGTH DAN CAPACITY DIGUNAKAN
 * -----------------------------------------------------------------
 * 
 * length() digunakan saat:
 * - Mengetahui ukuran string saat ini
 * - Looping atau iterasi karakter
 * - Validasi panjang string
 * - Menentukan posisi insert di akhir (sb.insert(sb.length(), data))
 * - Menghapus semua karakter (sb.delete(0, sb.length()))
 * 
 * capacity() digunakan saat:
 * - Optimasi performa (memantau ruang kosong)
 * - Debugging memory allocation
 * - Menentukan apakah perlu ensureCapacity
 * - Profiling aplikasi
 * 
 * -----------------------------------------------------------------
 * 12. PERBANDINGAN - STRING VS STRINGBUFFER
 * -----------------------------------------------------------------
 * 
 * // STRING - TIDAK ADA CAPACITY
 * String str = "Hello";
 * System.out.println(str.length()); // 5
 * // Tidak ada method capacity() pada String
 * // String selalu tepat ukuran (immutable)
 * 
 * // STRINGBUFFER - ADA LENGTH DAN CAPACITY
 * StringBuffer sb = new StringBuffer("Hello");
 * System.out.println(sb.length()); // 5
 * System.out.println(sb.capacity()); // 21 (5 + 16)
 * // Ada ruang ekstra untuk modifikasi
 * 
 * -----------------------------------------------------------------
 * 13. CATATAN PENTING (JAVA MODERN)
 * -----------------------------------------------------------------
 * 
 * 1. Kapasitas default = 16 (sejak Java 1.0)
 * - Tidak berubah di Java 17+
 * 
 * 2. Rumus resize default:
 * - Java 8 ke bawah: (oldCapacity * 2) + 2
 * - Java 9+: optimasi lebih kompleks, tetap exponential
 * 
 * 3. StringBuffer vs StringBuilder:
 * - length() dan capacity() identik di kedua kelas
 * - Perilaku resize sama
 * - Hanya thread-safety yang membedakan
 * 
 * 4. Memory consideration:
 * - capacity() bisa besar (hingga Integer.MAX_VALUE - 8)
 * - Terlalu besar bisa menyebabkan OutOfMemoryError
 * - Gunakan trimToSize() untuk mengurangi memory
 * 
 * ================================================================
 * KESIMPULAN - VERSI PADAT
 * ================================================================
 * 
 * 1. length() = jumlah karakter yang terpakai saat ini
 * 2. capacity() = total ruang yang dialokasikan di memory
 * 3. capacity() >= length() (selalu)
 * 4. Default capacity = length + 16 (untuk constructor String)
 * 5. Default capacity = 16 (untuk constructor kosong)
 * 6. Capacity ekstra = strategi optimasi untuk hindari resize
 * 7. Resize terjadi saat length() mencapai capacity()
 * 8. Resize mahal (alokasi + copy data)
 * 9. Gunakan ensureCapacity() atau constructor dengan kapasitas
 * 
 * ================================================================
 * INTI PALING DALAM
 * ================================================================
 * 
 * StringBuffer bukan sekadar wadah string, tapi juga memiliki
 * konsep "ruang kosong" yang disiapkan untuk masa depan.
 * 
 * Memahami length() dan capacity() adalah kunci untuk menulis
 * kode StringBuffer yang optimal, efisien, dan bebas dari
 * performance bottleneck akibat resize berulang.
 * 
 * ================================================================
 * CATATAN JAVA MODERN (17+)
 * ================================================================
 * 
 * Method length() dan capacity() telah tersedia sejak Java 1.0
 * dan tetap identik fungsinya hingga Java 17+.
 * 
 * Untuk aplikasi performa tinggi:
 * - Gunakan constructor dengan kapasitas jika tahu ukuran akhir
 * - Monitor capacity() secara berkala di development
 * - Gunakan trimToSize() setelah selesai membangun string
 * 
 * Ingat: capacity yang lebih besar = performa lebih cepat
 * tapi memory lebih boros. Trade-off yang harus dipertimbangkan.
 * 
 * ================================================================
 */

public class LengthAndCapacity {

    public static void main(String[] args) {

        // Membuat StringBuffer dengan isi awal "Hello"
        StringBuffer stringBuffer = new StringBuffer("Hello");
        // Menampilkan isi buffer
        System.out.println(stringBuffer);

        // length() = jumlah karakter yang sedang digunakan
        // Output: 5 (karena "Hello" punya 5 huruf)
        System.out.println("Length: " + stringBuffer.length());

        // capacity() = total kapasitas yang tersedia di memory
        // Output: 21 (5 dari "Hello" + 16 tambahan default)
        System.out.println("Capacity: " + stringBuffer.capacity());

        System.out.println("------------------------------------");

        StringBuffer stringBuffer1 = new StringBuffer("Hello");
        System.out.println("Awal:");
        System.out.println("Length: " + stringBuffer1.length());
        System.out.println("Capacity: " + stringBuffer1.capacity());

        // Tambah isi sampai melewati capacity
        stringBuffer1.append(" bro ini tambahan string panjang banget");

        System.out.println("\nSetelah append:");
        System.out.println("Length: " + stringBuffer1.length());
        System.out.println("Capacity: " + stringBuffer1.capacity());
    }
}
