package FundamentalJava.String.StringBuffer;

/**
 * ================================================================
 * STRINGBUFFER - STRING MUTABLE UNTUK MANIPULASI DINAMIS
 * ================================================================
 * 
 * StringBuffer adalah kelas di Java yang mendukung string
 * yang bisa dimodifikasi (mutable), berbeda dengan String
 * yang immutable (tidak bisa diubah setelah dibuat).
 * 
 * -----------------------------------------------------------------
 * 1. PERBEDAAN DASAR - STRING VS STRINGBUFFER
 * -----------------------------------------------------------------
 * 
 * | Konsep | String | StringBuffer |
 * |---------------|---------------------------------|---------------------------------|
 * | Sifat | Immutable (tidak bisa diubah) | Mutable (bisa diubah) |
 * | Perubahan | Selalu buat objek String baru | Mengubah objek yang sama |
 * | Performa | Lambat untuk modifikasi berulang| Cepat untuk modifikasi
 * berulang |
 * | Thread-safety | Aman (immutable) | Aman (synchronized) |
 * | Memory | Boros untuk banyak perubahan | Efisien untuk banyak perubahan |
 * 
 * -----------------------------------------------------------------
 * 2. KENAPA STRING MENJADI MASALAH SAAT SERING DIUBAH
 * -----------------------------------------------------------------
 * 
 * // Contoh kode yang sering ditemui:
 * String s = "Hello";
 * s = s + " World";
 * s = s + " from";
 * s = s + " Java";
 * 
 * // Yang terjadi di balik layar:
 * // 1. "Hello" tetap ada di memory
 * // 2. Dibuat object baru "Hello World"
 * // 3. Dibuat object baru "Hello World from"
 * // 4. Dibuat object baru "Hello World from Java"
 * // 5. Object lama menjadi garbage
 * 
 * MASALAH:
 * - Memory boros (banyak object tidak terpakai)
 * - Performance turun (alokasi memory terus-menerus)
 * - Garbage collection bekerja lebih keras
 * - Waktu eksekusi lebih lambat
 * 
 * -----------------------------------------------------------------
 * 3. STRINGBUFFER SEBAGAI SOLUSI
 * -----------------------------------------------------------------
 * 
 * StringBuffer ibarat:
 * "Kotak yang bisa dibuka-tutup dan diisi ulang"
 * 
 * // Dengan StringBuffer:
 * StringBuffer sb = new StringBuffer("Hello");
 * sb.append(" World");
 * sb.append(" from");
 * sb.append(" Java");
 * 
 * // Yang terjadi di balik layar:
 * // 1. Satu object StringBuffer dibuat
 * // 2. Isi buffer dimodifikasi langsung
 * // 3. Tidak ada object String baru
 * // 4. Memory lebih efisien
 * // 5. Performa lebih cepat
 * 
 * -----------------------------------------------------------------
 * 4. GROWABLE - UKURAN BISA BERTAMBAH OTOMATIS
 * -----------------------------------------------------------------
 * 
 * "Growable" artinya StringBuffer bisa bertambah ukurannya
 * secara otomatis tanpa perlu intervensi manual.
 * 
 * // Kapasitas awal
 * StringBuffer sb = new StringBuffer("Hello");
 * // Kapasitas = 5 + 16 = 21
 * 
 * // Append sampai melewati kapasitas
 * for (int i = 0; i < 50; i++) {
 * sb.append("X");
 * }
 * 
 * // Java otomatis:
 * // 1. Mendeteksi bahwa kapasitas kurang
 * // 2. Mengalokasikan array baru yang lebih besar
 * // 3. Menyalin data lama ke array baru
 * // 4. Melanjutkan operasi append
 * // 5. TIDAK ERROR!
 * 
 * Keuntungan:
 * - Tidak perlu menentukan ukuran maksimal
 * - Tidak perlu khawatir overflow
 * - Otomatis menyesuaikan kebutuhan
 * 
 * -----------------------------------------------------------------
 * 5. WRITABLE - BISA DITULIS DAN DIUBAH
 * -----------------------------------------------------------------
 * 
 * "Writable" artinya StringBuffer mendukung berbagai operasi
 * modifikasi tanpa membuat object baru.
 * 
 * Operasi yang tersedia:
 * 
 * // 1. Tambah di akhir (append)
 * sb.append(" data");
 * 
 * // 2. Sisipkan di posisi tertentu (insert)
 * sb.insert(5, " new ");
 * 
 * // 3. Hapus karakter (delete, deleteCharAt)
 * sb.delete(0, 5);
 * sb.deleteCharAt(3);
 * 
 * // 4. Ganti isi (replace)
 * sb.replace(0, 5, "new");
 * 
 * // 5. Ubah karakter spesifik (setCharAt)
 * sb.setCharAt(0, 'J');
 * 
 * // 6. Balik urutan (reverse)
 * sb.reverse();
 * 
 * // 7. Akses karakter (charAt)
 * char c = sb.charAt(3);
 * 
 * Semua operasi ini mengubah objek yang SAMA.
 * 
 * -----------------------------------------------------------------
 * 6. PREALLOCATED CAPACITY - RUANG EKSTRA DI AWAL
 * -----------------------------------------------------------------
 * 
 * StringBuffer biasanya mengalokasikan kapasitas lebih besar
 * dari yang dibutuhkan untuk mengantisipasi pertumbuhan.
 * 
 * Kapasitas default:
 * 
 * // Constructor default
 * StringBuffer sb1 = new StringBuffer();
 * // Capacity = 16 (default)
 * 
 * // Constructor dengan String
 * StringBuffer sb2 = new StringBuffer("Hello");
 * // Capacity = 5 + 16 = 21
 * 
 * // Constructor dengan kapasitas tertentu
 * StringBuffer sb3 = new StringBuffer(100);
 * // Capacity = 100
 * 
 * 
 * KENAPA ADA RUANG EKSTRA?
 * 
 * // Tanpa ruang ekstra:
 * sb.append("Hello"); // Isi 5, capacity 5
 * sb.append(" World"); // HARUS RESIZE! (butuh 11, capacity 5)
 * // 1. Alokasi array baru
 * // 2. Copy 5 data
 * // 3. Hapus array lama
 * // Mahal!
 * 
 * // Dengan ruang ekstra (16):
 * sb.append("Hello"); // Isi 5, capacity 21
 * sb.append(" World"); // Isi 11, capacity 21 (MASIH CUKUP)
 * // TIDAK RESIZE! Lebih cepat!
 * 
 * -----------------------------------------------------------------
 * 7. KAPAN PAKAI STRING, KAPAN PAKAI STRINGBUFFER
 * -----------------------------------------------------------------
 * 
 * PAKAI STRING (immutable) jika:
 * 
 * 1. String TIDAK PERNAH diubah setelah dibuat
 * - Konstanta
 * - Nilai tetap
 * - Key di HashMap (immutable lebih aman)
 * 
 * 2. Hanya perlu baca atau akses karakter
 * - String lebih sederhana
 * - Syntax lebih ringkas
 * 
 * 3. Concatenation sederhana (sedikit)
 * - "Hello" + " " + "World" (compiler optimasi)
 * - Java compiler bisa optimasi dengan StringBuilder
 * 
 * 4. Perlu thread-safety yang maksimal
 * - Immutable object inherently thread-safe
 * 
 * 
 * PAKAI STRINGBUFFER (mutable) jika:
 * 
 * 1. String SERING DIUBAH
 * - Banyak operasi append, insert, delete
 * - Loop panjang dengan modifikasi string
 * 
 * 2. Perlu manipulasi string yang efisien
 * - Membangun string dari banyak bagian
 * - Parsing atau editing teks
 * 
 * 3. Performa menjadi concern utama
 * - Menghindari alokasi object berulang
 * - Aplikasi dengan resource terbatas
 * 
 * 4. Reuse buffer
 * - sb.setLength(0) untuk reset
 * - Menggunakan object yang sama berulang kali
 * 
 * -----------------------------------------------------------------
 * 8. PERBANDINGAN PERFORMANCE - CONTOH NYATA
 * -----------------------------------------------------------------
 * 
 * // Contoh 1: Concatenation dalam loop (100.000 iterasi)
 * 
 * // MENGGUNAKAN STRING (LAMBAT)
 * String str = "";
 * for (int i = 0; i < 100000; i++) {
 * str = str + "x"; // Object String baru setiap iterasi
 * }
 * // Waktu: ~5000-8000 ms
 * // Memory: Banyak garbage, sering GC
 * 
 * 
 * // MENGGUNAKAN STRINGBUFFER (CEPAT)
 * StringBuffer sb = new StringBuffer();
 * for (int i = 0; i < 100000; i++) {
 * sb.append("x"); // Modifikasi object yang sama
 * }
 * String result = sb.toString();
 * // Waktu: ~5-10 ms
 * // Memory: 1 object, minimal GC
 * 
 * 
 * // MENGGUNAKAN STRINGBUILDER (PALING CEPAT - single thread)
 * StringBuilder sb2 = new StringBuilder();
 * for (int i = 0; i < 100000; i++) {
 * sb2.append("x");
 * }
 * String result2 = sb2.toString();
 * // Waktu: ~2-5 ms
 * // Memory: 1 object, minimal GC
 * 
 * -----------------------------------------------------------------
 * 9. STRING VS STRINGBUFFER - ILUSTRASI MEMORI
 * -----------------------------------------------------------------
 * 
 * // STRING - IMMUTABLE
 * String str = "Hello";
 * // Memory: [H][e][l][l][o]
 * 
 * str = str + " World";
 * // Memory:
 * // [H][e][l][l][o] ← object lama (masih ada, jadi garbage)
 * // [H][e][l][l][o][ ][W][o][r][l][d] ← object baru
 * 
 * str = str + "!";
 * // Memory:
 * // [H][e][l][l][o] ← garbage
 * // [H][e][l][l][o][ ][W][o][r][l][d] ← garbage
 * // [H][e][l][l][o][ ][W][o][r][l][d][!] ← object baru lagi
 * 
 * // STRINGBUFFER - MUTABLE
 * StringBuffer sb = new StringBuffer("Hello");
 * // Memory: [H][e][l][l][o][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 * 
 * sb.append(" World");
 * // Memory: [H][e][l][l][o][ ][W][o][r][l][d][ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 * // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ object yang sama
 * 
 * sb.append("!");
 * // Memory: [H][e][l][l][o][ ][W][o][r][l][d][!][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 * // ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ object yang sama
 * 
 * -----------------------------------------------------------------
 * 10. STRING VS STRINGBUFFER VS STRINGBUILDER
 * -----------------------------------------------------------------
 * 
 * Java memiliki 3 kelas untuk string:
 * 
 * 1. String (Java 1.0)
 * - Immutable
 * - Thread-safe (karena immutable)
 * - Paling lambat untuk modifikasi
 * 
 * 2. StringBuffer (Java 1.0)
 * - Mutable
 * - Thread-safe (synchronized)
 * - Sedang untuk modifikasi (ada overhead sync)
 * 
 * 3. StringBuilder (Java 5)
 * - Mutable
 * - NOT thread-safe (tidak synchronized)
 * - Paling cepat untuk modifikasi
 * 
 * 
 * REKOMENDASI PEMILIHAN:
 * 
 * // 1. Single-threaded dan butuh performa
 * StringBuilder sb = new StringBuilder(); // Pilih ini
 * 
 * // 2. Multi-threaded dan butuh keamanan
 * StringBuffer sb = new StringBuffer(); // Pilih ini
 * 
 * // 3. Tidak pernah diubah
 * String str = "Hello"; // Pilih ini
 * 
 * -----------------------------------------------------------------
 * 11. CONTOH KODE LENGKAP - PERBANDINGAN
 * -----------------------------------------------------------------
 * 
 * public class StringVsBufferDemo {
 * public static void main(String[] args) {
 * // === DEMO 1: Perubahan String (Immutable) ===
 * String str = "Hello";
 * System.out.println("String asli: " + str);
 * System.out.println("HashCode asli: " + System.identityHashCode(str));
 * 
 * str = str + " World";
 * System.out.println("String baru: " + str);
 * System.out.println("HashCode baru: " + System.identityHashCode(str));
 * System.out.println("(HashCode berbeda → object baru)");
 * System.out.println();
 * 
 * // === DEMO 2: Perubahan StringBuffer (Mutable) ===
 * StringBuffer sb = new StringBuffer("Hello");
 * System.out.println("StringBuffer asli: " + sb);
 * System.out.println("HashCode asli: " + System.identityHashCode(sb));
 * 
 * sb.append(" World");
 * System.out.println("StringBuffer baru: " + sb);
 * System.out.println("HashCode baru: " + System.identityHashCode(sb));
 * System.out.println("(HashCode SAMA → object yang sama)");
 * System.out.println();
 * 
 * // === DEMO 3: Kapasitas dan Pertumbuhan ===
 * StringBuffer sb2 = new StringBuffer();
 * System.out.println("Default capacity: " + sb2.capacity()); // 16
 * 
 * sb2.append("1234567890123456"); // 16 karakter
 * System.out.println("Setelah 16 karakter: " + sb2.capacity()); // 16
 * 
 * sb2.append("17"); // 17 karakter
 * System.out.println("Setelah 17 karakter: " + sb2.capacity()); // 34 (resize)
 * }
 * }
 * 
 * -----------------------------------------------------------------
 * 12. PERFORMANCE INSIGHT - LEVEL UP
 * -----------------------------------------------------------------
 * 
 * KAPAN STRINGBUFFER LEBIH CEPAT?
 * 
 * 1. Looping dengan banyak concatenation
 * - for (int i = 0; i < 10000; i++) { sb.append(i); }
 * - StringBuffer: 1 object, O(n)
 * - String: n object baru, O(n²)
 * 
 * 2. Operasi insert, delete, replace di tengah string
 * - StringBuffer: modifikasi langsung
 * - String: harus split + concatenate (banyak object)
 * 
 * 3. Membangun string dari banyak sumber
 * - API response
 * - JSON/XML builder
 * - Query builder
 * 
 * 
 * KAPAN STRING CUKUP?
 * 
 * 1. Concatenation sederhana (1-3 operasi)
 * - "Hello" + " " + "World"
 * - Compiler Java otomatis optimasi pakai StringBuilder
 * 
 * 2. String constants
 * - final String CONSTANT = "value";
 * 
 * 3. Key di HashMap atau Collection
 * - Immutable lebih aman untuk key
 * 
 * -----------------------------------------------------------------
 * 13. CATATAN UNICODE (JAVA MODERN)
 * -----------------------------------------------------------------
 * 
 * StringBuffer, StringBuilder, dan String semuanya menggunakan
 * UTF-16 encoding untuk menyimpan karakter.
 * 
 * Untuk karakter non-BMP (emoji, aksara tertentu):
 * - Satu karakter = 2 char (surrogate pair)
 * - Semua method bekerja pada level char
 * - Hati-hati dengan index pada surrogate pair
 * 
 * Contoh:
 * StringBuffer sb = new StringBuffer("A🌍B");
 * // Internal: ['A', highSurrogate, lowSurrogate, 'B']
 * // length() = 4 (bukan 3)
 * 
 * System.out.println(sb.length()); // 4
 * System.out.println(sb.charAt(1)); // highSurrogate (tidak terbaca)
 * 
 * Untuk Unicode yang aman:
 * - Gunakan codePointAt() dan codePointCount()
 * - Gunakan appendCodePoint()
 * - Gunakan offsetByCodePoints()
 * 
 * ================================================================
 * KESIMPULAN - VERSI PADAT
 * ================================================================
 * 
 * 1. String = immutable (tidak bisa diubah)
 * - Setiap modifikasi buat object baru
 * - Boros memory dan lambat untuk banyak perubahan
 * 
 * 2. StringBuffer = mutable (bisa diubah)
 * - Modifikasi langsung di object yang sama
 * - Efisien untuk banyak perubahan
 * - Thread-safe (synchronized)
 * 
 * 3. StringBuilder = mutable (bisa diubah)
 * - Sama seperti StringBuffer tapi tidak thread-safe
 * - Paling cepat untuk single-threaded
 * 
 * 4. StringBuffer memiliki kapasitas ekstra
 * - Default: 16 karakter ekstra
 * - Growable: otomatis bertambah jika perlu
 * - Untuk mengurangi frekuensi resize
 * 
 * 5. Pilih String jika:
 * - String tidak pernah diubah
 * - Concatenation sederhana
 * 
 * 6. Pilih StringBuffer/StringBuilder jika:
 * - String sering diubah
 * - Banyak operasi append/insert/delete
 * - Membangun string dari banyak bagian
 * 
 * ================================================================
 * INTI PALING DALAM
 * ================================================================
 * 
 * StringBuffer adalah evolusi dari String untuk kasus di mana
 * string perlu dimodifikasi secara dinamis dan efisien.
 * 
 * Konsep "mutable" dan "growable" membuat StringBuffer menjadi
 * pilihan utama untuk operasi string yang kompleks, sementara
 * String tetap menjadi pilihan untuk data yang statis dan aman.
 * 
 * ================================================================
 * CATATAN JAVA MODERN (17+)
 * ================================================================
 * 
 * 1. Java compiler otomatis mengubah String concatenation
 * menjadi StringBuilder di bytecode (sejak Java 5)
 * 
 * 2. Method String.join() (Java 8+) untuk concatenation sederhana
 * 
 * 3. Text Blocks (Java 15+) untuk multi-line string
 * 
 * 4. StringBuffer masih relevan untuk aplikasi multi-threaded
 * 
 * 5. Untuk single-threaded, StringBuilder adalah pilihan terbaik
 * - 99% kasus di aplikasi modern menggunakan StringBuilder
 * - StringBuffer digunakan jika ada kebutuhan thread-safety
 * 
 * 6. Ingat: StringBuffer vs StringBuilder
 * - Perilaku identik, hanya thread-safety yang berbeda
 * - Jangan gunakan StringBuffer jika tidak perlu thread-safe
 * 
 * ================================================================
 */

public class Stringbuffer {
    public static void main(String[] args) {

        // Membuat StringBuffer dengan isi awal
        StringBuffer stringBuffer = new StringBuffer("Hello");

        // Menampilkan isi awal
        System.out.println("Awal " + stringBuffer); // Awal Hello

        // Menambahkan string ke akhir (append)
        stringBuffer.append(" World");
        System.out.println("Setelah append: " + stringBuffer); // Setelah append: Hello World

        // Menyisipkan string di tengah
        stringBuffer.insert(5, "java");
        System.out.println("Setelah insert: " + stringBuffer); // Setelah insert: Hellojava World

        // Mengganti sebagian string
        stringBuffer.replace(0, 5, "Hi");
        System.out.println("Setelah replace: " + stringBuffer); // Setelah replace: Hijava World

        // Menghapus sebagian string
        stringBuffer.delete(2, 7);
        System.out.println("Setelah delete: " + stringBuffer); // Setelah delete: HiWorld

        // Menampilkan panjang string
        System.out.println("Length: " + stringBuffer.length()); // Length: 7
        // Menampilkan kapasitas (ruang yang tersedia)
        System.out.println("Capacity: " + stringBuffer.capacity()); // Capacity: 21

        /**
         * Alur yang Terjadi di Kode
         *
         * "Hello" masuk ke StringBuffer
         * append → nambah tanpa bikin object baru
         * insert → nyelip di tengah
         * replace → ganti sebagian isi
         * delete → hapus sebagian
         * Semua perubahan terjadi di objek yang sama
         *
         */
    }
}
