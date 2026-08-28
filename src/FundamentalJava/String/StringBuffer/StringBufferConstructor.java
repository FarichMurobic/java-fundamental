package FundamentalJava.String.StringBuffer;

/**
 * ================================================================
 * STRINGBUFFER CONSTRUCTORS - CARA BUAT OBJECT YANG OPTIMAL
 * ================================================================
 * 
 * StringBuffer menyediakan empat constructor untuk membuat
 * objek dengan berbagai konfigurasi awal yang berbeda.
 * 
 * -----------------------------------------------------------------
 * 1. DAFTAR CONSTRUCTOR - LENGKAP
 * -----------------------------------------------------------------
 * 
 * 1. StringBuffer()
 * - Membuat StringBuffer kosong dengan kapasitas default 16
 * 
 * 2. StringBuffer(int capacity)
 * - Membuat StringBuffer kosong dengan kapasitas tertentu
 * 
 * 3. StringBuffer(String str)
 * - Membuat StringBuffer dengan isi awal dari String
 * - Kapasitas = str.length() + 16
 * 
 * 4. StringBuffer(CharSequence chars)
 * - Membuat StringBuffer dengan isi awal dari CharSequence
 * - Kapasitas = chars.length() + 16
 * 
 * -----------------------------------------------------------------
 * 2. CONSTRUCTOR 1 - StringBuffer() DEFAULT
 * -----------------------------------------------------------------
 * 
 * StringBuffer sb = new StringBuffer();
 * 
 * Karakteristik:
 * - Isi awal: kosong ("")
 * - Kapasitas: 16 karakter
 * - Cocok untuk: kasus umum, ukuran tidak diketahui
 * 
 * Visualisasi memory:
 * 
 * [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 * ^0 ^1 ^2 ^3 ^4 ^5 ^6 ^7 ^8 ^9 ^10^11^12^13^14^15
 * <------------- capacity = 16 ------------------->
 * <-- length = 0 -->
 * 
 * Contoh:
 * StringBuffer sb = new StringBuffer();
 * System.out.println("Length: " + sb.length()); // 0
 * System.out.println("Capacity: " + sb.capacity()); // 16
 * 
 * -----------------------------------------------------------------
 * 3. CONSTRUCTOR 2 - StringBuffer(int capacity)
 * -----------------------------------------------------------------
 * 
 * StringBuffer sb = new StringBuffer(50);
 * 
 * Karakteristik:
 * - Isi awal: kosong ("")
 * - Kapasitas: sesuai parameter (50)
 * - Cocok untuk: saat sudah tahu perkiraan ukuran akhir
 * 
 * Visualisasi memory:
 * 
 * [ ][ ][ ][ ][ ]...[ ][ ][ ][ ][ ]
 * ^0 ^1 ^2 ^3 ^4 ... ^45^46^47^48^49
 * <--------- capacity = 50 --------->
 * <-- length = 0 -->
 * 
 * Contoh:
 * StringBuffer sb = new StringBuffer(50);
 * System.out.println("Length: " + sb.length()); // 0
 * System.out.println("Capacity: " + sb.capacity()); // 50
 * 
 * Keuntungan:
 * - Tidak ada resize untuk 50 karakter pertama
 * - Performa lebih baik untuk data besar
 * 
 * -----------------------------------------------------------------
 * 4. CONSTRUCTOR 3 - StringBuffer(String str)
 * -----------------------------------------------------------------
 * 
 * StringBuffer sb = new StringBuffer("Hello");
 * 
 * Karakteristik:
 * - Isi awal: "Hello" (5 karakter)
 * - Kapasitas: 5 + 16 = 21
 * - Cocok untuk: inisialisasi dengan string awal
 * 
 * Visualisasi memory:
 * 
 * [H][e][l][l][o][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 * ^0 ^1 ^2 ^3 ^4 ^5 ^6 ^7 ^8 ^9 ^10^11^12^13^14^15^16^17^18^19^20
 * <-- length = 5 -->
 * <-------------- capacity = 21 ------------------------------->
 * 
 * Perhitungan:
 * length = str.length() = 5
 * capacity = str.length() + 16 = 5 + 16 = 21
 * 
 * Contoh:
 * StringBuffer sb = new StringBuffer("Hello");
 * System.out.println("Length: " + sb.length()); // 5
 * System.out.println("Capacity: " + sb.capacity()); // 21
 * 
 * -----------------------------------------------------------------
 * 5. CONSTRUCTOR 4 - StringBuffer(CharSequence chars)
 * -----------------------------------------------------------------
 * 
 * CharSequence cs = "Hello Bro";
 * StringBuffer sb = new StringBuffer(cs);
 * 
 * Karakteristik:
 * - Isi awal: dari CharSequence
 * - Kapasitas: chars.length() + 16
 * - Cocok untuk: terima berbagai tipe CharSequence
 * 
 * CharSequence adalah interface yang diimplementasikan oleh:
 * - String
 * - StringBuilder
 * - StringBuffer
 * - CharBuffer (NIO)
 * - dan lain-lain
 * 
 * Contoh:
 * // Dari String
 * StringBuffer sb1 = new StringBuffer((CharSequence) "Hello");
 * 
 * // Dari StringBuilder
 * StringBuilder sb2 = new StringBuilder("World");
 * StringBuffer sb3 = new StringBuffer((CharSequence) sb2);
 * 
 * // Dari StringBuffer lain
 * StringBuffer sb4 = new StringBuffer("Java");
 * StringBuffer sb5 = new StringBuffer((CharSequence) sb4);
 * 
 * System.out.println(sb3); // "World"
 * System.out.println(sb5); // "Java"
 * 
 * -----------------------------------------------------------------
 * 6. PERBANDINGAN SEMUA CONSTRUCTOR
 * -----------------------------------------------------------------
 * 
 * | Constructor | Isi Awal | Capacity | Kapan Pakai |
 * |--------------------------------|----------|------------------|--------------------------|
 * | StringBuffer() | "" | 16 | Ukuran tidak diketahui |
 * | StringBuffer(int size) | "" | size | Tahu perkiraan ukuran |
 * | StringBuffer(String str) | str | str.length() + 16| Ada string awal |
 * | StringBuffer(CharSequence cs) | cs | cs.length() + 16| Terima berbagai tipe
 * |
 * 
 * -----------------------------------------------------------------
 * 7. KENAPA TAMBAHAN 16 KARAKTER? - REALLOCATION MAHAL
 * -----------------------------------------------------------------
 * 
 * StringBuffer selalu menyediakan ruang ekstra 16 karakter
 * (kecuali jika kapasitas ditentukan secara eksplisit).
 * 
 * ALASAN:
 * 
 * 1. Reallocation itu MAHAL
 * - Alokasi memory baru
 * - Copy semua data lama
 * - Hapus memory lama (garbage collection)
 * - Membutuhkan waktu dan CPU
 * 
 * 2. Fragmentasi memory
 * - Reallocation berulang menyebabkan memory tidak kontigu
 * - Performance turun
 * - Memory usage tidak efisien
 * 
 * 3. Dengan ruang ekstra:
 * - Bisa append beberapa kali tanpa resize
 * - Performa lebih stabil
 * - Memory lebih terprediksi
 * 
 * 
 * TANPA ruang ekstra (hipotetis):
 * StringBuffer sb = new StringBuffer("Hello");
 * // capacity = 5 (tanpa ekstra)
 * 
 * sb.append(" World"); // 5 + 6 = 11 → RESIZE!
 * // 1. Alokasi array baru
 * // 2. Copy "Hello"
 * // 3. Hapus array lama
 * // Mahal!
 * 
 * 
 * DENGAN ruang ekstra 16:
 * StringBuffer sb = new StringBuffer("Hello");
 * // capacity = 5 + 16 = 21
 * 
 * sb.append(" World"); // 5 + 6 = 11 → TIDAK RESIZE!
 * // Langsung pakai ruang kosong
 * // Cepat!
 * 
 * -----------------------------------------------------------------
 * 8. REALLOCATION - PROSES DAN DAMPAK
 * -----------------------------------------------------------------
 * 
 * Proses reallocation saat capacity habis:
 * 
 * 1. Java mendeteksi length akan melebihi capacity
 * 2. Menghitung kapasitas baru: (oldCapacity * 2) + 2
 * 3. Mengalokasikan array baru
 * 4. Menyalin semua data dari array lama ke array baru
 * 5. Array lama dihapus (garbage collection)
 * 6. Melanjutkan operasi
 * 
 * 
 * DAMPAK REALLOCATION:
 * 
 * // Tanpa preallocation (buruk)
 * StringBuffer sb = new StringBuffer(); // capacity = 16
 * 
 * for (int i = 0; i < 1000; i++) {
 * sb.append("X"); // Resize terjadi 6-7 kali!
 * }
 * // Waktu: ~5-10 ms (masih OK, tapi tidak optimal)
 * 
 * 
 * // Dengan preallocation (baik)
 * StringBuffer sb = new StringBuffer(1000); // capacity = 1000
 * 
 * for (int i = 0; i < 1000; i++) {
 * sb.append("X"); // TIDAK ADA RESIZE!
 * }
 * // Waktu: ~2-3 ms (lebih cepat 2-3x)
 * 
 * 
 * // Dengan preallocation + 16 (sedang)
 * StringBuffer sb = new StringBuffer("Hello"); // capacity = 21
 * 
 * for (int i = 0; i < 1000; i++) {
 * sb.append("X"); // Resize terjadi beberapa kali
 * }
 * // Waktu: ~4-6 ms (lebih baik dari default)
 * 
 * -----------------------------------------------------------------
 * 9. STRATEGI MEMILIH CONSTRUCTOR - PANDUAN
 * -----------------------------------------------------------------
 * 
 * PILIHAN BERDASARKAN SKENARIO:
 * 
 * // 1. TIDAK TAHU UKURAN (kasus umum)
 * StringBuffer sb = new StringBuffer();
 * // Capacity = 16 (cukup untuk kasus kecil)
 * 
 * 
 * // 2. TAHU PERKIRAAN UKURAN (rekomendasi!)
 * int estimatedSize = 1000;
 * StringBuffer sb = new StringBuffer(estimatedSize);
 * // Capacity = 1000 (optimal)
 * 
 * 
 * // 3. ADA DATA AWAL + TAHU UKURAN
 * String initial = "Starting data";
 * int extraSpace = 500;
 * StringBuffer sb = new StringBuffer(initial.length() + extraSpace);
 * sb.append(initial);
 * // Capacity = panjang awal + tambahan (optimal)
 * 
 * 
 * // 4. ADA DATA AWAL SAJA (kasus umum)
 * StringBuffer sb = new StringBuffer("Hello");
 * // Capacity = 5 + 16 = 21
 * 
 * 
 * // 5. DARI SUMBER LAIN (flexible)
 * CharSequence source = getDataFromSomewhere();
 * StringBuffer sb = new StringBuffer(source);
 * // Capacity = source.length() + 16
 * 
 * -----------------------------------------------------------------
 * 10. CONTOH LENGKAP - DEMO SEMUA CONSTRUCTOR
 * -----------------------------------------------------------------
 * 
 * public class StringBufferConstructorsDemo {
 * public static void main(String[] args) {
 * // Constructor 1: Default
 * StringBuffer sb1 = new StringBuffer();
 * System.out.println("=== StringBuffer() ===");
 * System.out.println("Isi: '" + sb1 + "'");
 * System.out.println("Length: " + sb1.length());
 * System.out.println("Capacity: " + sb1.capacity());
 * System.out.println();
 * 
 * // Constructor 2: Dengan kapasitas
 * StringBuffer sb2 = new StringBuffer(50);
 * System.out.println("=== StringBuffer(50) ===");
 * System.out.println("Isi: '" + sb2 + "'");
 * System.out.println("Length: " + sb2.length());
 * System.out.println("Capacity: " + sb2.capacity());
 * System.out.println();
 * 
 * // Constructor 3: Dari String
 * StringBuffer sb3 = new StringBuffer("Hello");
 * System.out.println("=== StringBuffer(\"Hello\") ===");
 * System.out.println("Isi: '" + sb3 + "'");
 * System.out.println("Length: " + sb3.length());
 * System.out.println("Capacity: " + sb3.capacity());
 * System.out.println("(5 + 16 = 21)");
 * System.out.println();
 * 
 * // Constructor 4: Dari CharSequence
 * CharSequence cs = "Java Programming";
 * StringBuffer sb4 = new StringBuffer(cs);
 * System.out.println("=== StringBuffer(CharSequence) ===");
 * System.out.println("Isi: '" + sb4 + "'");
 * System.out.println("Length: " + sb4.length());
 * System.out.println("Capacity: " + sb4.capacity());
 * System.out.println("(" + sb4.length() + " + 16 = " + sb4.capacity() + ")");
 * System.out.println();
 * 
 * // Demonstrasi pengaruh kapasitas terhadap performa
 * System.out.println("=== Performance Test ===");
 * 
 * // Tanpa preallocation
 * long start1 = System.nanoTime();
 * StringBuffer sb5 = new StringBuffer();
 * for (int i = 0; i < 10000; i++) {
 * sb5.append("X");
 * }
 * long end1 = System.nanoTime();
 * 
 * // Dengan preallocation
 * long start2 = System.nanoTime();
 * StringBuffer sb6 = new StringBuffer(10000);
 * for (int i = 0; i < 10000; i++) {
 * sb6.append("X");
 * }
 * long end2 = System.nanoTime();
 * 
 * System.out.println("Tanpa preallocation: " + (end1 - start1) / 1000000 + "
 * ms");
 * System.out.println("Dengan preallocation: " + (end2 - start2) / 1000000 + "
 * ms");
 * System.out.println("Selisih: " +
 * ((end1 - start1) - (end2 - start2)) / 1000000 + " ms lebih cepat");
 * }
 * }
 * 
 * -----------------------------------------------------------------
 * 11. PERFORMANCE INSIGHT - LEVEL UP
 * -----------------------------------------------------------------
 * 
 * PERBANDINGAN PERFORMANCE (10.000 append):
 * 
 * | Constructor | Capacity Awal | Resize | Waktu (ms) |
 * |---------------------------|---------------|--------|------------|
 * | StringBuffer() | 16 | 6-7x | 5-8 |
 * | StringBuffer(50) | 50 | 4-5x | 4-6 |
 * | StringBuffer(1000) | 1000 | 2-3x | 3-5 |
 * | StringBuffer(10000) | 10000 | 0x | 2-3 |
 * | StringBuffer("Hello") | 21 | 6x | 5-8 |
 * 
 * 
 * REKOMENDASI BEST PRACTICE:
 * 
 * 1. Jika tahu perkiraan ukuran → gunakan constructor dengan kapasitas
 * StringBuffer sb = new StringBuffer(estimatedSize);
 * 
 * 2. Jika tidak tahu, tapi data besar → gunakan ensureCapacity()
 * StringBuffer sb = new StringBuffer();
 * sb.ensureCapacity(1000);
 * 
 * 3. Jika data kecil (< 100 karakter) → default cukup
 * StringBuffer sb = new StringBuffer();
 * 
 * 4. Jika ada data awal → gunakan String constructor
 * StringBuffer sb = new StringBuffer("Initial data");
 * 
 * 5. Untuk performa maksimal di single thread → StringBuilder
 * StringBuilder sb = new StringBuilder(1000);
 * 
 * -----------------------------------------------------------------
 * 12. PERBANDINGAN DENGAN STRINGBUILDER
 * -----------------------------------------------------------------
 * 
 * Constructor yang sama juga tersedia di StringBuilder:
 * 
 * // StringBuffer (thread-safe)
 * StringBuffer sb = new StringBuffer(); // capacity = 16
 * StringBuffer sb = new StringBuffer(100); // capacity = 100
 * StringBuffer sb = new StringBuffer("Hello"); // capacity = 21
 * 
 * // StringBuilder (non-thread-safe, lebih cepat)
 * StringBuilder sb = new StringBuilder(); // capacity = 16
 * StringBuilder sb = new StringBuilder(100); // capacity = 100
 * StringBuilder sb = new StringBuilder("Hello"); // capacity = 21
 * 
 * Perbedaan:
 * - StringBuffer: synchronized (thread-safe) → lebih lambat
 * - StringBuilder: non-synchronized → lebih cepat
 * 
 * Pilih StringBuilder jika aplikasi single-threaded (99% kasus).
 * 
 * -----------------------------------------------------------------
 * 13. CATATAN UNICODE (JAVA MODERN)
 * -----------------------------------------------------------------
 * 
 * Constructor StringBuffer menggunakan char (16-bit UTF-16).
 * 
 * Untuk karakter non-BMP (emoji, aksara tertentu):
 * - Satu karakter Unicode = 2 char (surrogate pair)
 * - length() mengembalikan jumlah char, bukan code point
 * - Capacity dihitung berdasarkan jumlah char
 * 
 * Contoh:
 * StringBuffer sb = new StringBuffer("A🌍B");
 * // Internal: ['A', highSurrogate, lowSurrogate, 'B']
 * // length() = 4 (bukan 3)
 * // capacity = 4 + 16 = 20
 * 
 * Untuk menghitung code point:
 * int codePointCount = sb.codePointCount(0, sb.length());
 * // codePointCount = 3 (A, 🌍, B)
 * 
 * Rekomendasi:
 * - Gunakan codePoint* method untuk manipulasi Unicode
 * - Jangan asumsi 1 char = 1 karakter untuk teks internasional
 * 
 * ================================================================
 * KESIMPULAN - VERSI PADAT
 * ================================================================
 * 
 * 1. 4 constructor: default, int capacity, String, CharSequence
 * 2. Default capacity = 16 (jika tidak ditentukan)
 * 3. Capacity = length + 16 (jika ada data awal)
 * 4. Capacity dapat ditentukan secara eksplisit (int capacity)
 * 5. Extra 16 karakter = menghindari reallocation berulang
 * 6. Reallocation mahal (alokasi + copy data)
 * 7. Pilih constructor dengan kapasitas jika tahu perkiraan ukuran
 * 8. Performa lebih baik dengan preallocation yang tepat
 * 9. StringBuilder lebih cepat untuk single-threaded
 * 10. Hati-hati dengan Unicode (surrogate pairs)
 * 
 * ================================================================
 * INTI PALING DALAM
 * ================================================================
 * 
 * Memilih constructor yang tepat adalah langkah pertama
 * untuk menulis kode StringBuffer yang optimal.
 * 
 * Satu baris kode di awal (memilih kapasitas yang tepat)
 * bisa menghemat ratusan operasi resize di tengah proses,
 * yang berdampak signifikan pada performa dan efisiensi memory.
 * 
 * ================================================================
 * CATATAN JAVA MODERN (17+)
 * ================================================================
 * 
 * 1. Constructor StringBuffer tetap sama sejak Java 1.0
 * 
 * 2. Java 5 menambahkan StringBuilder sebagai alternatif lebih cepat
 * 
 * 3. Java 9+ compiler mengoptimasi String concatenation
 * - Menggunakan invokedynamic untuk concatenation
 * - Tidak selalu butuh StringBuilder manual
 * 
 * 4. Untuk aplikasi modern:
 * - Gunakan StringBuilder (bukan StringBuffer) untuk single-thread
 * - Gunakan StringBuffer hanya jika perlu thread-safety
 * 
 * 5. Text Blocks (Java 15+) untuk multi-line string
 * 
 * 6. Method String.join() (Java 8+) untuk concatenation delimiter
 * 
 * 7. Meskipun ada alternatif modern, StringBuffer/StringBuilder
 * tetap penting untuk manipulasi string dinamis.
 * 
 * ================================================================
 */

public class StringBufferConstructor {
    public static void main(String[] args) {

        // 1. Constructor tanpa parameter
        StringBuffer stringBuffer1 = new StringBuffer();
        System.out.println("stringBuffer1 length: " + stringBuffer1.length()); // 0 (belum ada isi)
        System.out.println("stringBuffer1 capacity: " + stringBuffer1.capacity()); // 16 (default)

        System.out.println("--------------------------------");

        // 2. Constructor dengan ukuran tertentu
        StringBuffer stringBuffer2 = new StringBuffer(50);
        System.out.println("stringBuffer2 length: " + stringBuffer2.length()); // 0
        System.out.println("stringBuffer2 capacity: " + stringBuffer2.capacity()); // 50

        System.out.println("--------------------------------");

        // 3. Constructor dengan String
        StringBuffer stringBuffer3 = new StringBuffer("Hello");
        System.out.println("stringBuffer3 length: " + stringBuffer3.length()); // 5
        System.out.println("stringBuffer3 capacity: " + stringBuffer3.capacity()); // 5 + 16 = 21

        System.out.println("--------------------------------");

        // 4. Constructor dengan CharSequence
        CharSequence charSequence = "Java";
        StringBuffer stringBuffer4 = new StringBuffer(charSequence);
        System.out.println("stringBuffer4 length: " + stringBuffer4.length()); // 4
        System.out.println("stringBuffer4 capacity: " + stringBuffer4.capacity()); // 4 + 16 = 20

    }
}
