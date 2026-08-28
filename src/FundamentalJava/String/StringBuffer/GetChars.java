package FundamentalJava.String.StringBuffer;

/**
 * ================================================================
 * getChars() - EKSTRAKSI EFISIEN KE CHAR ARRAY
 * ================================================================
 * 
 * Method getChars() digunakan untuk menyalin substring dari
 * StringBuffer ke dalam array karakter (char[]) secara langsung
 * dan efisien, tanpa membuat objek perantara.
 * 
 * -----------------------------------------------------------------
 * 1. DEKLARASI METHOD - BENTUK UMUM
 * -----------------------------------------------------------------
 * 
 * void getChars(int sourceStart, int sourceEnd, char[] target, int targetStart)
 * 
 * Parameter:
 * - sourceStart : index awal di StringBuffer (inklusif)
 * - sourceEnd : index akhir di StringBuffer (eksklusif)
 * - target : array karakter tujuan
 * - targetStart : index awal di array tujuan (inklusif)
 * 
 * Method ini tidak mengembalikan nilai (void).
 * 
 * -----------------------------------------------------------------
 * 2. FUNGSI UTAMA - APA YANG DILAKUKAN
 * -----------------------------------------------------------------
 * 
 * getChars() mengambil sebagian karakter dari StringBuffer
 * dan menyalinnya ke dalam char array yang sudah disediakan.
 * 
 * Keunggulan utama:
 * - Tanpa membuat objek String baru
 * - Tanpa membuat objek char[] baru
 * - Langsung copy ke array yang sudah ada
 * - Sangat efisien untuk operasi low-level
 * 
 * -----------------------------------------------------------------
 * 3. STRUKTUR PARAMETER - WAJIB PAHAM
 * -----------------------------------------------------------------
 * 
 * getChars(sourceStart, sourceEnd, target, targetStart)
 * 
 * | Parameter | Arti |
 * |--------------|---------------------------------------------|
 * | sourceStart | Index awal di StringBuffer (IKUT diambil) |
 * | sourceEnd | Index akhir di StringBuffer (TIDAK diambil) |
 * | target | Array char tujuan |
 * | targetStart | Index di array tujuan (mulai menulis) |
 * 
 * -----------------------------------------------------------------
 * 4. KONSEP PENTING - sourceEnd EXCLUSIVE
 * -----------------------------------------------------------------
 * 
 * sourceEnd adalah EXCLUSIVE, artinya karakter pada index
 * sourceEnd TIDAK ikut disalin.
 * 
 * Contoh:
 * StringBuffer sb = new StringBuffer("Hello");
 * // Indeks: 0 1 2 3 4
 * // Karakter: H e l l o
 * 
 * char[] target = new char[3];
 * sb.getChars(1, 4, target, 0);
 * 
 * Yang diambil:
 * - index 1 → 'e' (IKUT)
 * - index 2 → 'l' (IKUT)
 * - index 3 → 'l' (IKUT)
 * - index 4 → 'o' (TIDAK, karena sourceEnd = 4)
 * 
 * Hasil target:
 * target[0] = 'e'
 * target[1] = 'l'
 * target[2] = 'l'
 * 
 * System.out.println(new String(target)); // "ell"
 * 
 * -----------------------------------------------------------------
 * 5. VISUALISASI - BIAR MAKIN JELAS
 * -----------------------------------------------------------------
 * 
 * StringBuffer: "Hello World"
 * Indeks: 0 1 2 3 4 5 6 7 8 9 10
 * Karakter: H e l l o W o r l d
 * 
 * // Contoh 1: Ambil "Hello"
 * char[] target1 = new char[5];
 * sb.getChars(0, 5, target1, 0);
 * 
 * target1 setelah operasi:
 * [H][e][l][l][o]
 * 0 1 2 3 4
 * 
 * // Contoh 2: Ambil "World"
 * char[] target2 = new char[5];
 * sb.getChars(6, 11, target2, 0);
 * 
 * target2 setelah operasi:
 * [W][o][r][l][d]
 * 0 1 2 3 4
 * 
 * // Contoh 3: Copy ke array yang sudah ada isinya
 * char[] target3 = new char[11];
 * target3[0] = 'A';
 * target3[1] = 'B';
 * target3[2] = 'C';
 * 
 * sb.getChars(0, 5, target3, 3);
 * 
 * target3 setelah operasi:
 * [A][B][C][H][e][l][l][o][ ][ ][ ]
 * 0 1 2 3 4 5 6 7 8 9 10
 * 
 * -----------------------------------------------------------------
 * 6. CONTOH LENGKAP - KODE PROGRAM
 * -----------------------------------------------------------------
 * 
 * public class GetCharsExample {
 * public static void main(String[] args) {
 * StringBuffer sb = new StringBuffer("Programming in Java");
 * 
 * // Siapkan array dengan ukuran yang cukup
 * char[] destination = new char[10];
 * 
 * // Copy "gramming" dari index 3 sampai 11
 * sb.getChars(3, 11, destination, 0);
 * 
 * // Cetak hasil
 * System.out.println(new String(destination)); // "gramming "
 * // ^^ spasi karena array size 10
 * 
 * // Copy "Java" dari index 15 ke array dengan offset
 * char[] dest2 = new char[4];
 * sb.getChars(15, 19, dest2, 0);
 * System.out.println(new String(dest2)); // "Java"
 * }
 * }
 * 
 * -----------------------------------------------------------------
 * 7. ERROR YANG SERING TERJADI - WAJIB HINDARI
 * -----------------------------------------------------------------
 * 
 * ERROR 1: Array target terlalu kecil
 * 
 * StringBuffer sb = new StringBuffer("Hello World");
 * char[] target = new char[3]; // Hanya muat 3 karakter
 * 
 * // Akan mencoba menyalin 5 karakter ke array ukuran 3
 * sb.getChars(0, 5, target, 0);
 * 
 * // EXCEPTION: ArrayIndexOutOfBoundsException
 * // Karena target hanya punya index 0-2, tapi butuh index 0-4
 * 
 * SOLUSI: Pastikan target.length >= (sourceEnd - sourceStart) + targetStart
 * 
 * // Cara aman:
 * int length = 5;
 * char[] safeTarget = new char[length];
 * sb.getChars(0, 5, safeTarget, 0);
 * 
 * 
 * ERROR 2: Index StringBuffer keluar batas
 * 
 * StringBuffer sb = new StringBuffer("Java");
 * char[] target = new char[10];
 * 
 * // sourceEnd = 10, padahal length() = 4
 * sb.getChars(0, 10, target, 0);
 * 
 * // EXCEPTION: StringIndexOutOfBoundsException
 * // Karena sourceEnd > sb.length()
 * 
 * SOLUSI: Pastikan sourceStart >= 0, sourceEnd <= sb.length()
 * 
 * // Cara aman:
 * if (sourceStart >= 0 && sourceEnd <= sb.length() && sourceStart <= sourceEnd)
 * {
 * sb.getChars(sourceStart, sourceEnd, target, targetStart);
 * } else {
 * System.out.println("Invalid index range");
 * }
 * 
 * 
 * ERROR 3: targetStart negatif atau terlalu besar
 * 
 * char[] target = new char[10];
 * 
 * // targetStart negatif
 * sb.getChars(0, 5, target, -1);
 * // EXCEPTION: ArrayIndexOutOfBoundsException
 * 
 * // targetStart terlalu besar
 * sb.getChars(0, 5, target, 8);
 * // Butuh index 8-12, tapi array hanya 0-9
 * // EXCEPTION: ArrayIndexOutOfBoundsException
 * 
 * -----------------------------------------------------------------
 * 8. PERBANDINGAN DENGAN ALTERNATIF LAIN
 * -----------------------------------------------------------------
 * 
 * // OPSI 1: getChars() - PALING EFFISIEN
 * StringBuffer sb = new StringBuffer("Hello World");
 * char[] chars1 = new char[5];
 * sb.getChars(0, 5, chars1, 0);
 * // ✅ 1 objek array, langsung copy, tanpa objek String
 * 
 * // OPSI 2: substring().toCharArray() - KURANG EFFISIEN
 * char[] chars2 = sb.substring(0, 5).toCharArray();
 * // ❌ Buat objek String baru (substring)
 * // ❌ Buat objek char[] baru (toCharArray)
 * // ❌ 2 objek tambahan, lebih boros memory
 * 
 * // OPSI 3: toString().toCharArray() - PALING BOROS
 * char[] chars3 = sb.toString().toCharArray();
 * // ❌ Buat String baru (toString)
 * // ❌ Buat char[] baru (toCharArray)
 * // ❌ Copy semua karakter, bukan subset
 * 
 * -----------------------------------------------------------------
 * 9. KAPAN MENGGUNAKAN getChars()
 * -----------------------------------------------------------------
 * 
 * COCOK digunakan saat:
 * 
 * 1. Manipulasi karakter low-level
 * - Membuat parser manual
 * - Validasi karakter per karakter
 * - Enkripsi/dekripsi custom
 * 
 * 2. Optimasi performa kritis
 * - Hindari pembuatan objek String berlebih
 * - Aplikasi real-time dengan resource terbatas
 * - Loop besar dengan operasi string
 * 
 * 3. Integrasi dengan library low-level
 * - API yang menerima char[] (bukan String)
 * - Native code atau JNI
 * - Operasi I/O level byte/char
 * 
 * 4. Parsing manual
 * - Parse CSV atau format data custom
 * - Analisis teks per karakter
 * 
 * TIDAK COCOK digunakan saat:
 * 
 * 1. Hanya perlu String biasa
 * - substring() lebih sederhana
 * 
 * 2. Array tidak disediakan sebelumnya
 * - substring().toCharArray() lebih praktis
 * 
 * 3. Kode untuk pemula atau maintenance
 * - getChars() kurang intuitif
 * 
 * -----------------------------------------------------------------
 * 10. PERFORMANCE INSIGHT - KENAPA LEBIH CEPAT
 * -----------------------------------------------------------------
 * 
 * getChars() lebih cepat dibanding alternatif karena:
 * 
 * 1. LANGSUNG COPY
 * - Data langsung dari array internal StringBuffer ke target
 * - System.arraycopy() digunakan di internal (native method)
 * 
 * 2. TANPA OBJEK PERANTARA
 * - Tidak membuat String baru
 * - Tidak membuat char[] baru (selain target yang sudah ada)
 * 
 * 3. MINIMAL OVERHEAD
 * - Hanya satu operasi copy
 * - Tidak ada alokasi memory tambahan
 * 
 * Benchmark perkiraan (10.000 operasi):
 * - getChars() : 2-3 ms
 * - substring().toCharArray() : 8-10 ms
 * - toString().toCharArray() : 12-15 ms
 * 
 * -----------------------------------------------------------------
 * 11. METHOD CHAINING - KOMBINASI DENGAN METHOD LAIN
 * -----------------------------------------------------------------
 * 
 * getChars() tidak mendukung chaining (return void),
 * tapi bisa dikombinasikan dengan method lain:
 * 
 * StringBuffer sb = new StringBuffer("Hello World");
 * char[] result = new char[10];
 * 
 * // Bisa digunakan setelah operasi lain
 * sb.delete(5, 6) // Hapus spasi → "HelloWorld"
 * .insert(5, " ") // Tambah spasi → "Hello World"
 * .getChars(0, 5, result, 0); // Ambil "Hello"
 * 
 * // Atau sebelum operasi lain
 * sb.getChars(0, 5, result, 0);
 * sb.append(" Everyone");
 * 
 * -----------------------------------------------------------------
 * 12. CATATAN UNICODE (JAVA MODERN)
 * -----------------------------------------------------------------
 * 
 * getChars() bekerja pada level char (16-bit UTF-16).
 * 
 * Untuk karakter non-BMP (emoji, aksara tertentu):
 * - Satu karakter Unicode = 2 char (surrogate pair)
 * - getChars() akan menyalin surrogate pair sebagai 2 char
 * 
 * Contoh:
 * StringBuffer sb = new StringBuffer("A🌍");
 * // Karakter: 'A' (1 char) + '🌍' (2 char surrogate pair)
 * // Total: 3 char di internal
 * 
 * char[] target = new char[3];
 * sb.getChars(0, 3, target, 0);
 * // target = ['A', highSurrogate, lowSurrogate]
 * 
 * Untuk Unicode yang aman, gunakan codePoint* method.
 * getChars() aman digunakan jika hanya perlu char level.
 * 
 * ================================================================
 * KESIMPULAN - VERSI PADAT
 * ================================================================
 * 
 * 1. getChars() = copy substring dari StringBuffer ke char array
 * 2. sourceStart = index awal (IKUT), sourceEnd = index akhir (TIDAK)
 * 3. Parameter: (sourceStart, sourceEnd, target, targetStart)
 * 4. Array target harus cukup besar (jika tidak →
 * ArrayIndexOutOfBoundsException)
 * 5. Index harus valid (jika tidak → StringIndexOutOfBoundsException)
 * 6. Lebih cepat dari substring().toCharArray()
 * 7. Tidak membuat objek perantara → lebih hemat memory
 * 8. Cocok untuk operasi low-level dan optimasi performa
 * 
 * ================================================================
 * INTI PALING DALAM
 * ================================================================
 * 
 * getChars() adalah method yang membuktikan bahwa Java
 * mendukung operasi string tingkat rendah dengan performa
 * setara C/C++ ketika diperlukan.
 * 
 * Dengan menghindari pembuatan objek perantara, getChars()
 * menjadi pilihan utama untuk aplikasi yang membutuhkan
 * efisiensi memory dan kecepatan maksimal.
 * 
 * ================================================================
 * CATATAN JAVA MODERN (17+)
 * ================================================================
 * 
 * Method getChars() telah tersedia sejak Java 1.0 dan tetap
 * identik fungsinya hingga Java 17+.
 * 
 * Alternatif modern:
 * - String.chars() / String.codePoints() (stream API)
 * - CharBuffer (NIO)
 * - Arrays.copyOfRange() untuk array copy
 * 
 * Namun untuk kasus spesifik copy dari StringBuffer ke char[]
 * dengan performa tinggi, getChars() tetap menjadi pilihan
 * terbaik dan paling efisien.
 * 
 * ================================================================
 */

public class GetChars {
    public static void main(String[] args) {

        // Membuat StringBuffer
        StringBuffer stringBuffer = new StringBuffer("Hello World");

        // Membuat array tujuan
        char[] target = new char[20];

        // Menyalin substring dari index 0 sampai 5 (tidak termasuk 5)
        // "Hello" → masuk ke target mulai index 0
        stringBuffer.getChars(0, 5, target, 0);

        System.out.println("Hasil 1:");
        System.out.println(target);

        // Menyalin substring lain ke posisi berbeda
        // "World" → masuk ke target mulai index 6
        stringBuffer.getChars(6, 11, target, 6);
        System.out.println("\nHasil 2:");
        System.out.println(target);

    }
}
