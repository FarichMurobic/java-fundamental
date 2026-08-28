package FundamentalJava.String.StringBuffer;

/**
 * ================================================================
 * setLength() - MENGATUR PANJANG STRING SECARA PAKSA
 * ================================================================
 * 
 * Method setLength() digunakan untuk mengubah panjang string
 * di dalam StringBuffer secara manual dan paksa.
 * 
 * -----------------------------------------------------------------
 * 1. DEKLARASI METHOD - BENTUK UMUM
 * -----------------------------------------------------------------
 * 
 * void setLength(int len)
 * 
 * Parameter:
 * - len : panjang baru yang diinginkan (harus >= 0)
 * 
 * Method ini tidak mengembalikan nilai (void).
 * 
 * -----------------------------------------------------------------
 * 2. FUNGSI UTAMA - APA YANG DILAKUKAN
 * -----------------------------------------------------------------
 * 
 * setLength() mengubah panjang string menjadi nilai yang ditentukan:
 * 
 * 1. Jika len < current length → STRING DIPOTONG
 * - Karakter di luar batas baru dihapus
 * - Data hilang secara permanen
 * 
 * 2. Jika len > current length → STRING DIPERPANJANG
 * - Karakter null (\0) ditambahkan di akhir
 * - Null character = ASCII 0 (bukan spasi, bukan string kosong)
 * 
 * 3. Jika len == current length → TIDAK ADA PERUBAHAN
 * 
 * -----------------------------------------------------------------
 * 3. SKENARIO 1 - MEMOTONG STRING (len < length)
 * -----------------------------------------------------------------
 * 
 * StringBuffer sb = new StringBuffer("Hello World");
 * System.out.println("Sebelum: " + sb); // "Hello World"
 * System.out.println("Length: " + sb.length()); // 11
 * 
 * sb.setLength(5);
 * System.out.println("Sesudah: " + sb); // "Hello"
 * System.out.println("Length: " + sb.length()); // 5
 * 
 * Visualisasi:
 * 
 * Sebelum setLength(5):
 * [H][e][l][l][o][ ][W][o][r][l][d]
 * ^0 ^1 ^2 ^3 ^4 ^5 ^6 ^7 ^8 ^9 ^10
 * <---------- length = 11 --------->
 * 
 * Pemotongan:
 * batas baru (index 5)
 * ↓
 * [H][e][l][l][o][X][X][X][X][X][X]
 * ^0 ^1 ^2 ^3 ^4 ^5 ^6 ^7 ^8 ^9 ^10
 * <--- length = 5 -->
 * 
 * Setelah setLength(5):
 * [H][e][l][l][o]
 * ^0 ^1 ^2 ^3 ^4
 * <--- length = 5 -->
 * 
 * Karakter setelah index 4 (spasi, W, o, r, l, d) HILANG PERMANEN.
 * 
 * -----------------------------------------------------------------
 * 4. SKENARIO 2 - MEMPERPANJANG STRING (len > length)
 * -----------------------------------------------------------------
 * 
 * StringBuffer sb = new StringBuffer("Hi");
 * System.out.println("Sebelum: " + sb); // "Hi"
 * System.out.println("Length: " + sb.length()); // 2
 * 
 * sb.setLength(5);
 * System.out.println("Sesudah: " + sb); // "Hi" (null tidak terlihat)
 * System.out.println("Length: " + sb.length()); // 5
 * 
 * Visualisasi:
 * 
 * Sebelum setLength(5):
 * [H][i]
 * ^0 ^1
 * <-- length = 2 -->
 * 
 * Perpanjangan:
 * [H][i][\0][\0][\0]
 * ^0 ^1 ^2 ^3 ^4
 * <----- length = 5 ------>
 * 
 * Setelah setLength(5):
 * [H][i][\0][\0][\0]
 * ^0 ^1 ^2 ^3 ^4
 * <----- length = 5 ------>
 * 
 * Null character (\0) ditambahkan, tapi TIDAK TERLIHAT saat print.
 * 
 * -----------------------------------------------------------------
 * 5. NULL CHARACTER (\0) - APA ITU?
 * -----------------------------------------------------------------
 * 
 * Null character adalah karakter khusus dengan nilai ASCII 0.
 * 
 * Perbedaan penting:
 * 
 * | Karakter | Nilai | Penampilan | Kegunaan |
 * |---------------|--------|------------|-------------------------|
 * | \0 (null) | ASCII 0| Tidak tampak| Placeholder, padding |
 * | ' ' (spasi) | ASCII 32| Terlihat | Whitespace normal |
 * | "" (kosong) | - | Tidak ada | String kosong, length 0 |
 * 
 * 
 * Contoh perbedaan:
 * StringBuffer sb = new StringBuffer("Hi");
 * sb.setLength(5);
 * 
 * // Null character TIDAK TERLIHAT
 * System.out.println("'" + sb.toString() + "'"); // "Hi" (bukan "Hi ")
 * 
 * // Tapi length berubah
 * System.out.println(sb.length()); // 5 (bukan 2)
 * 
 * // Akses karakter null
 * char c = sb.charAt(2);
 * System.out.println((int) c); // 0 (ASCII 0)
 * 
 * // Bandingkan dengan spasi
 * sb.setCharAt(2, ' ');
 * System.out.println("'" + sb.toString() + "'"); // "Hi " (ada spasi)
 * 
 * -----------------------------------------------------------------
 * 6. KONSEP PENTING - LENGTH VS CAPACITY
 * -----------------------------------------------------------------
 * 
 * setLength() mempengaruhi length, BUKAN capacity.
 * 
 * // Capacity TIDAK berubah
 * StringBuffer sb = new StringBuffer("Hello");
 * System.out.println("Length: " + sb.length()); // 5
 * System.out.println("Capacity: " + sb.capacity()); // 21
 * 
 * sb.setLength(3);
 * System.out.println("Length: " + sb.length()); // 3
 * System.out.println("Capacity: " + sb.capacity()); // 21 (TETAP!)
 * 
 * sb.setLength(10);
 * System.out.println("Length: " + sb.length()); // 10
 * System.out.println("Capacity: " + sb.capacity()); // 21 (TETAP!)
 * 
 * 
 * Perbedaan length dan capacity:
 * - setLength() → mengubah panjang yang terpakai
 * - capacity() → tetap sama (kecuali resize)
 * 
 * -----------------------------------------------------------------
 * 7. MEKANISME INTERNAL - BAGAIMANA JAVA BEKERJA
 * -----------------------------------------------------------------
 * 
 * Saat setLength() dipanggil:
 * 
 * 1. Validasi parameter (len >= 0)
 * 2. Jika len > capacity → RESIZE TERJADI
 * - Alokasi array baru dengan kapasitas cukup
 * - Copy data lama
 * 
 * 3. Jika len > current length:
 * - Tambahkan null character (\0) dari current length sampai len - 1
 * - Update length menjadi len
 * 
 * 4. Jika len < current length:
 * - Update length menjadi len (karakter setelah batas diabaikan)
 * - Data sebenarnya masih ada di memory, tapi tidak dianggap bagian string
 * 
 * 5. Jika len == current length:
 * - Tidak ada perubahan
 * 
 * 
 * Pseudocode internal (sederhana):
 * 
 * public void setLength(int len) {
 * if (len < 0) {
 * throw new StringIndexOutOfBoundsException();
 * }
 * 
 * if (len > capacity()) {
 * // Resize buffer
 * ensureCapacity(len);
 * }
 * 
 * if (len > length()) {
 * // Isi dengan null character
 * for (int i = length(); i < len; i++) {
 * internalArray[i] = '\0';
 * }
 * }
 * 
 * // Update length
 * this.count = len;
 * }
 * 
 * -----------------------------------------------------------------
 * 8. ATURAN PARAMETER - WAJIB PAHAM
 * -----------------------------------------------------------------
 * 
 * Parameter len HARUS:
 * 
 * 1. >= 0 (tidak boleh negatif)
 * 2. <= Integer.MAX_VALUE (tapi praktis, dibatasi memory)
 * 
 * Pelanggaran aturan:
 * - StringIndexOutOfBoundsException jika len < 0
 * - OutOfMemoryError jika len terlalu besar
 * 
 * 
 * Contoh Kode yang SALAH:
 * StringBuffer sb = new StringBuffer("Java");
 * 
 * // len negatif
 * // sb.setLength(-1); // StringIndexOutOfBoundsException
 * 
 * // len terlalu besar (out of memory)
 * // sb.setLength(Integer.MAX_VALUE); // Mungkin OutOfMemoryError
 * 
 * 
 * Contoh Kode yang BENAR:
 * StringBuffer sb = new StringBuffer("Java");
 * 
 * // Potong
 * sb.setLength(2);
 * System.out.println(sb); // "Ja"
 * 
 * // Perpanjang (dengan null)
 * sb.setLength(5);
 * System.out.println(sb.length()); // 5
 * 
 * // Reset ke 0 (kosong)
 * sb.setLength(0);
 * System.out.println(sb.length()); // 0
 * System.out.println("'" + sb.toString() + "'"); // "''" (string kosong)
 * 
 * -----------------------------------------------------------------
 * 9. KASUS PENGGUNAAN - KAPAN DIPAKAI
 * -----------------------------------------------------------------
 * 
 * setLength() COCOK digunakan saat:
 * 
 * 1. Memotong string dengan cepat
 * - "Hello World" → "Hello"
 * - Lebih cepat dari delete() karena tidak menggeser karakter
 * 
 * 2. Mengosongkan StringBuffer (reuse)
 * - sb.setLength(0); → kosongkan buffer
 * - Bisa digunakan ulang tanpa membuat object baru
 * 
 * 3. Padding atau placeholder
 * - Menyiapkan ruang untuk data yang akan diisi
 * - Array dengan placeholder null
 * 
 * 4. Optimasi performa (reuse object)
 * - Alih-alih new StringBuffer() setiap kali
 * - Gunakan setLength(0) untuk reset
 * 
 * 5. Low-level manipulation
 * - Library internal
 * - Parsing data biner atau custom format
 * 
 * setLength() TIDAK COCOK digunakan saat:
 * 
 * 1. Hanya perlu menghapus beberapa karakter di tengah
 * - Gunakan delete() atau deleteCharAt()
 * 
 * 2. Perlu mempertahankan data yang dipotong
 * - setLength() menghapus permanen
 * 
 * 3. Aplikasi biasa tanpa kebutuhan optimasi spesifik
 * - substring() atau delete() lebih mudah dipahami
 * 
 * -----------------------------------------------------------------
 * 10. SETLENGTH UNTUK REUSE BUFFER - OPTIMASI
 * -----------------------------------------------------------------
 * 
 * // TANPA REUSE (bikin object baru setiap kali)
 * for (int i = 0; i < 1000; i++) {
 * StringBuffer sb = new StringBuffer(); // Object baru
 * sb.append("Data ").append(i);
 * process(sb.toString());
 * }
 * // ❌ 1000 object baru, banyak garbage collection
 * 
 * 
 * // DENGAN REUSE (1 object dipakai berulang)
 * StringBuffer sb = new StringBuffer();
 * for (int i = 0; i < 1000; i++) {
 * sb.setLength(0); // Kosongkan buffer
 * sb.append("Data ").append(i);
 * process(sb.toString());
 * }
 * // ✅ 1 object, 1000 kali pakai, lebih efisien
 * 
 * 
 * // DENGAN REUSE + CAPACITY OPTIMAL
 * StringBuffer sb = new StringBuffer(100); // Kapasitas awal 100
 * for (int i = 0; i < 1000; i++) {
 * sb.setLength(0);
 * sb.append("Data ").append(i);
 * process(sb.toString());
 * }
 * // ✅ 1 object + kapasitas optimal, performa terbaik
 * 
 * -----------------------------------------------------------------
 * 11. PERBANDINGAN DENGAN METHOD LAIN
 * -----------------------------------------------------------------
 * 
 * | Method | Fungsi | Return | Efisiensi |
 * |---------------|---------------------------------|--------|-----------|
 * | setLength(0) | Kosongkan buffer | void | O(1) |
 * | delete(0, n) | Hapus semua karakter | object | O(n) |
 * | new StringBuffer() | Buat object baru | object | O(1) |
 * 
 * 
 * // Rekomendasi:
 * // - Untuk reset buffer → gunakan setLength(0)
 * // - Lebih cepat dari delete()
 * // - Menghindari garbage collection
 * 
 * -----------------------------------------------------------------
 * 12. CONTOH LENGKAP - BERBAGAI SKENARIO
 * -----------------------------------------------------------------
 * 
 * public class SetLengthDemo {
 * public static void main(String[] args) {
 * // Skenario 1: Memotong string
 * StringBuffer sb1 = new StringBuffer("Hello World");
 * System.out.println("Asli: " + sb1); // "Hello World"
 * sb1.setLength(5);
 * System.out.println("SetLength 5: " + sb1); // "Hello"
 * System.out.println();
 * 
 * // Skenario 2: Memperpanjang string (null character)
 * StringBuffer sb2 = new StringBuffer("Hi");
 * System.out.println("Asli: " + sb2); // "Hi"
 * System.out.println("Length: " + sb2.length()); // 2
 * 
 * sb2.setLength(5);
 * System.out.println("SetLength 5: " + sb2); // "Hi"
 * System.out.println("Length: " + sb2.length()); // 5
 * System.out.println("Char at index 2: " + (int) sb2.charAt(2)); // 0
 * System.out.println();
 * 
 * // Skenario 3: Mengosongkan buffer (reuse)
 * StringBuffer sb3 = new StringBuffer("Java");
 * System.out.println("Asli: " + sb3);
 * 
 * sb3.setLength(0);
 * System.out.println("SetLength 0: " + sb3); // ""
 * System.out.println("Length: " + sb3.length()); // 0
 * 
 * sb3.append("Programming");
 * System.out.println("After append: " + sb3); // "Programming"
 * System.out.println();
 * 
 * // Skenario 4: Capacity tetap, length berubah
 * StringBuffer sb4 = new StringBuffer("Hello");
 * System.out.println("Awal - Length: " + sb4.length() +
 * ", Capacity: " + sb4.capacity());
 * 
 * sb4.setLength(3);
 * System.out.println("SetLength 3 - Length: " + sb4.length() +
 * ", Capacity: " + sb4.capacity());
 * 
 * sb4.setLength(10);
 * System.out.println("SetLength 10 - Length: " + sb4.length() +
 * ", Capacity: " + sb4.capacity());
 * }
 * }
 * 
 * -----------------------------------------------------------------
 * 13. PERFORMANCE INSIGHT - LEVEL UP
 * -----------------------------------------------------------------
 * 
 * setLength() adalah operasi yang SANGAT CEPAT untuk memotong string:
 * 
 * 1. HANYA UPDATE COUNTER
 * - Tidak menggeser karakter (beda dengan delete)
 * - Hanya mengubah nilai length counter
 * 
 * 2. O(1) UNTUK MEMOTONG
 * - Tidak peduli seberapa besar string
 * - Langsung update length
 * 
 * 3. O(n) UNTUK MEMPERPANJANG
 * - Harus mengisi null character dari length lama ke length baru
 * - n = selisih length baru - length lama
 * 
 * 4. BISA RESIZE JIKA PERLU
 * - Jika len > capacity, resize terjadi
 * - O(n) untuk copy data ke array baru
 * 
 * 
 * Benchmark perkiraan (1.000.000 operasi pada string 1000 char):
 * - setLength(0) : 1-2 ms (O(1))
 * - delete(0, length()) : 5-8 ms (O(n), harus geser)
 * - new StringBuffer() : 10-15 ms (alokasi object baru)
 * 
 * -----------------------------------------------------------------
 * 14. CATATAN UNICODE (JAVA MODERN)
 * -----------------------------------------------------------------
 * 
 * setLength() bekerja pada level char (16-bit UTF-16).
 * 
 * Untuk karakter non-BMP (emoji, aksara tertentu):
 * - Satu karakter = 2 char (surrogate pair)
 * - setLength() bisa memotong di tengah surrogate pair
 * - Ini akan merusak karakter Unicode
 * 
 * Contoh:
 * StringBuffer sb = new StringBuffer("A🌍B");
 * // Internal: ['A', highSurrogate, lowSurrogate, 'B']
 * // Panjang = 4
 * 
 * sb.setLength(3);
 * // Memotong di tengah surrogate pair!
 * // Hasil: ['A', highSurrogate] → karakter rusak
 * 
 * REKOMENDASI:
 * - Untuk Unicode, gunakan codePoint* method untuk akurasi
 * - Jangan gunakan setLength() untuk memotong string Unicode
 * - Gunakan substring() atau delete() dengan code point awareness
 * 
 * ================================================================
 * KESIMPULAN - VERSI PADAT
 * ================================================================
 * 
 * 1. setLength(len) = mengatur panjang string secara paksa
 * 2. len < length → string dipotong (karakter hilang permanen)
 * 3. len > length → string diperpanjang (ditambah null character \0)
 * 4. Null character = ASCII 0 (tidak terlihat saat print)
 * 5. len harus >= 0 (jika tidak → StringIndexOutOfBoundsException)
 * 6. Capacity TIDAK berubah (hanya length yang berubah)
 * 7. setLength(0) = cara cepat mengosongkan buffer (reuse)
 * 8. Memotong dengan setLength() lebih cepat dari delete()
 * 9. Hati-hati dengan Unicode surrogate pairs
 * 
 * ================================================================
 * INTI PALING DALAM
 * ================================================================
 * 
 * setLength() adalah method low-level yang memberikan kontrol
 * penuh atas panjang string tanpa harus membuat object baru.
 * 
 * Kemampuan ini menjadikan setLength() tool penting untuk
 * optimasi performa, terutama dalam reuse buffer dan
 * operasi string yang membutuhkan kontrol granular.
 * 
 * ================================================================
 * CATATAN JAVA MODERN (17+)
 * ================================================================
 * 
 * Method setLength() telah tersedia sejak Java 1.0 dan tetap
 * identik fungsinya hingga Java 17+.
 * 
 * Perbedaan dengan StringBuilder:
 * - StringBuffer.setLength() : synchronized (thread-safe)
 * - StringBuilder.setLength() : non-synchronized (lebih cepat)
 * 
 * Untuk aplikasi modern:
 * - Gunakan setLength(0) untuk reuse StringBuilder
 * - Gunakan trimToSize() setelah setLength(0) untuk hemat memory
 * 
 * Best practice untuk reuse:
 * 1. StringBuffer sb = new StringBuffer(initialCapacity);
 * 2. sb.setLength(0);
 * 3. sb.append(data);
 * 4. Process sb.toString()
 * 5. Repeat dari step 2
 * 
 * ================================================================
 */

public class SetLength {
    public static void main(String[] args) {

        // CONTOH 1: MEMOTONG STRING
        StringBuffer stringBuffer = new StringBuffer("Hello World");

        System.out.println("Sebelum dipotong:");
        System.out.println("Isi: " + stringBuffer); // Isi: Hello World
        System.out.println("Length: " + stringBuffer.length()); // Length: 11

        // Memotong string jadi panjang 5
        stringBuffer.setLength(5);

        System.out.println("\nSetelah dipotong:");
        System.out.println("Isi: " + stringBuffer); // Isi: Hello
        System.out.println("Length: " + stringBuffer.length()); // Length: 5

        // CONTOH 2: MEMPERPANJANG STRING
        StringBuffer stringBuffer1 = new StringBuffer("Hi");

        System.out.println("\nSebelum diperpanjang:");
        System.out.println("Isi: " + stringBuffer1); // Isi: Hi
        System.out.println("Length: " + stringBuffer1.length()); // Length: 2

        // Memperpanjang jadi 5 karakter
        stringBuffer1.setLength(5);

        // Akan terlihat seperti "Hi" tapi sebenarnya ada null char di belakang
        System.out.println("\nSetelah diperpanjang:");
        System.out.println("Isi: " + stringBuffer1); // Isi: Hi
        System.out.println("Length: " + stringBuffer1.length()); // Length: 5

        // Menampilkan tiap karakter biar keliatan null char
        System.out.println("\nDetail Karakter:");
        for (int i = 0; i < stringBuffer1.length(); i++) {
            System.out.println("Index " + i + ": " + (int) stringBuffer1.charAt(i));

            /**
             * Output
             * Index 0: 72
             * Index 1: 105
             * Index 2: 0
             * Index 3: 0
             * Index 4: 0
             */
        }
    }
}
