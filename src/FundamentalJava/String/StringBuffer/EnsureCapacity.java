package FundamentalJava.String.StringBuffer;

/**
 * ================================================================
 * ensureCapacity() - OPTIMASI MEMORY & PERFORMANCE
 * ================================================================
 * 
 * Method ensureCapacity() digunakan untuk mengalokasikan ruang
 * buffer secara proaktif sebelum melakukan banyak operasi append.
 * 
 * -----------------------------------------------------------------
 * 1. DEKLARASI METHOD - BENTUK UMUM
 * -----------------------------------------------------------------
 * 
 * void ensureCapacity(int minCapacity)
 * 
 * Parameter:
 * - minCapacity : ukuran minimum kapasitas buffer yang diinginkan
 * 
 * Method ini tidak mengembalikan nilai (void).
 * 
 * -----------------------------------------------------------------
 * 2. MASALAH YANG DISELESAIKAN - KENAPA BUTUH INI
 * -----------------------------------------------------------------
 * 
 * StringBuffer sb = new StringBuffer();
 * // Kapasitas awal = 16 karakter
 * 
 * // Lo append ratusan kali:
 * sb.append("a");
 * sb.append("b");
 * sb.append("c");
 * // ... dan seterusnya
 * 
 * MASALAH:
 * Setiap kali buffer penuh, Java melakukan resize:
 * 1. Membuat array baru dengan kapasitas lebih besar
 * 2. Menyalin semua data dari array lama ke array baru
 * 3. Array lama dihapus (garbage collection)
 * 
 * Akibatnya:
 * - Proses resize berkali-kali (jika append banyak)
 * - Boros waktu (copy data berulang)
 * - Boros memory (object array sementara)
 * - Overhead garbage collection
 * 
 * -----------------------------------------------------------------
 * 3. SOLUSI - ENSURE CAPACITY SEBELUMNYA
 * -----------------------------------------------------------------
 * 
 * StringBuffer sb = new StringBuffer();
 * 
 * // Siapkan kapasitas dari awal
 * sb.ensureCapacity(1000);
 * 
 * // Sekarang aman append ratusan kali
 * for (int i = 0; i < 500; i++) {
 * sb.append("data");
 * }
 * 
 * HASIL:
 * - Buffer siap menampung 1000 karakter dari awal
 * - Tidak ada resize selama append
 * - Performa jauh lebih cepat
 * - Memory lebih efisien
 * 
 * -----------------------------------------------------------------
 * 4. MEKANISME INTERNAL - BAGAIMANA JAVA BEKERJA
 * -----------------------------------------------------------------
 * 
 * Saat ensureCapacity(int minCapacity) dipanggil:
 * 
 * 1. Java mengecek kapasitas saat ini
 * 2. Jika kapasitas saat ini >= minCapacity → TIDAK ADA TINDAKAN
 * 3. Jika kapasitas saat ini < minCapacity → LAKUKAN RESIZE
 * 
 * Rumus resize default StringBuffer/StringBuilder:
 * newCapacity = (oldCapacity * 2) + 2
 * 
 * Contoh:
 * oldCapacity = 16
 * newCapacity = (16 * 2) + 2 = 34
 * 
 * TAPI:
 * Jika newCapacity masih < minCapacity, Java akan pakai minCapacity
 * 
 * PENTING:
 * "minCapacity" artinya MINIMUM, bukan pasti.
 * Java bisa mengalokasikan LEBIH BESAR dari yang diminta
 * untuk alasan efisiensi internal.
 * 
 * Contoh:
 * sb.ensureCapacity(1000);
 * 
 * Java mungkin alokasikan:
 * - 1000 (tepat)
 * - 1024 (alignment memory)
 * - 1500 (alasan optimasi)
 * 
 * -----------------------------------------------------------------
 * 5. ILUSTRASI - DENGAN DAN TANPA ENSURE CAPACITY
 * -----------------------------------------------------------------
 * 
 * TANPA ensureCapacity (RESIZE BERKALI):
 * 
 * StringBuffer sb = new StringBuffer();
 * // Kapasitas: 16
 * 
 * for (int i = 0; i < 100; i++) {
 * sb.append("X");
 * // Resize terjadi saat kapasitas penuh:
 * // - 16 → 34 (resize 1)
 * // - 34 → 70 (resize 2)
 * // - 70 → 142 (resize 3)
 * // Total 3 kali resize
 * }
 * 
 * DENGAN ensureCapacity (SATU KALI ALOKASI):
 * 
 * StringBuffer sb = new StringBuffer();
 * sb.ensureCapacity(100); // Siapkan dari awal
 * // Kapasitas: 100 (atau lebih)
 * 
 * for (int i = 0; i < 100; i++) {
 * sb.append("X");
 * // Tidak ada resize sama sekali!
 * }
 * 
 * PERBANDINGAN PERFORMANCE:
 * - Tanpa ensureCapacity: 3 kali resize, setiap resize copy data
 * - Dengan ensureCapacity: 0 kali resize, langsung pakai
 * 
 * -----------------------------------------------------------------
 * 6. KAPAN HARUS PAKAI ENSURE CAPACITY
 * -----------------------------------------------------------------
 * 
 * HARUS pakai ensureCapacity() jika:
 * 
 * 1. Lo tahu akan append BANYAK data
 * - Contoh: membaca file besar ke StringBuffer
 * - Contoh: build string dari database dengan ratusan record
 * 
 * 2. Ada loop panjang dengan append
 * - for (int i = 0; i < 10000; i++) { sb.append(data); }
 * 
 * 3. Membangun string dari streaming data
 * - Menerima chunk data dari API atau socket
 * 
 * 4. Operasi string yang membutuhkan prediktabilitas memory
 * - Aplikasi real-time atau low-latency
 * 
 * TIDAK PERLU ensureCapacity() jika:
 * 
 * 1. Hanya append beberapa karakter saja (< 20)
 * - Kapasitas default 16 cukup
 * 
 * 2. Isi buffer kecil dan tidak sering berubah
 * 
 * 3. Aplikasi kecil atau script sederhana
 * - Overhead optimasi tidak sebanding
 * 
 * -----------------------------------------------------------------
 * 7. CARA MENENTUKAN KAPASITAS YANG TEPAT
 * -----------------------------------------------------------------
 * 
 * Strategi menentukan minCapacity:
 * 
 * // 1. Perkiraan kasar
 * sb.ensureCapacity(1000); // Perkiraan 1000 karakter
 * 
 * // 2. Dari ukuran data yang diketahui
 * int estimatedSize = dataList.size() * 50; // tiap data 50 char
 * sb.ensureCapacity(estimatedSize);
 * 
 * // 3. Dari file atau resource
 * File file = new File("data.txt");
 * long fileSize = file.length();
 * sb.ensureCapacity((int) fileSize);
 * 
 * // 4. Kombinasi dengan buffer yang sudah ada
 * int currentLength = sb.length();
 * int estimatedAddition = 1000;
 * sb.ensureCapacity(currentLength + estimatedAddition);
 * 
 * -----------------------------------------------------------------
 * 8. STRATEGI OPTIMAL - KAPAN DIPANGGIL
 * -----------------------------------------------------------------
 * 
 * Waktu terbaik memanggil ensureCapacity():
 * 
 * // 1. SETELAH INSTANSIASI, SEBELUM APPEND
 * StringBuffer sb = new StringBuffer();
 * sb.ensureCapacity(5000);
 * // Mulai append...
 * 
 * // 2. ATAU BISA MENGGUNAKAN CONSTRUCTOR
 * StringBuffer sb = new StringBuffer(5000);
 * // Kapasitas langsung 5000 (tanpa ensureCapacity)
 * 
 * Mana yang lebih baik?
 * 
 * new StringBuffer(int capacity) → Langsung alokasi di awal
 * ensureCapacity(int minCapacity) → Alokasi setelah objek dibuat
 * 
 * Lebih efisien: new StringBuffer(int capacity) jika sudah tahu
 * kapasitas dari awal.
 * 
 * -----------------------------------------------------------------
 * 9. PERBANDINGAN DENGAN METHOD LAIN
 * -----------------------------------------------------------------
 * 
 * Method Fungsi Return
 * --------------------------------------------------------------------
 * new StringBuffer(n) Set kapasitas di constructor objek
 * ensureCapacity(n) Set kapasitas setelah objek dibuat void
 * capacity() Cek kapasitas saat ini int
 * trimToSize() Potong kapasitas sesuai isi void
 * 
 * Contoh kombinasi:
 * 
 * StringBuffer sb = new StringBuffer();
 * System.out.println("Capacity awal: " + sb.capacity()); // 16
 * 
 * sb.ensureCapacity(1000);
 * System.out.println("Capacity setelah ensure: " + sb.capacity()); // 1000+
 * 
 * for (int i = 0; i < 500; i++) {
 * sb.append("x");
 * }
 * 
 * System.out.println("Length: " + sb.length()); // 500
 * System.out.println("Capacity: " + sb.capacity()); // 1000+ (masih besar)
 * 
 * sb.trimToSize();
 * System.out.println("Capacity setelah trim: " + sb.capacity()); // 500
 * 
 * -----------------------------------------------------------------
 * 10. PERFORMANCE IMPACT - ANGKA NYATA
 * -----------------------------------------------------------------
 * 
 * Tanpa ensureCapacity (resize berkali):
 * - 10.000 append kecil → ~10-15 ms (dengan 4-5 resize)
 * - 100.000 append kecil → ~100-150 ms (dengan 6-7 resize)
 * 
 * Dengan ensureCapacity (satu alokasi):
 * - 10.000 append kecil → ~2-3 ms (tanpa resize)
 * - 100.000 append kecil → ~20-30 ms (tanpa resize)
 * 
 * Perbedaan signifikan untuk skala besar!
 * 
 * -----------------------------------------------------------------
 * 11. CATATAN PENTING (JAVA MODERN)
 * -----------------------------------------------------------------
 * 
 * 1. Kapasitas default StringBuffer = 16 (sejak Java 1.0)
 * 
 * 2. Rumus resize berubah di versi Java:
 * - Java 8 ke bawah: (oldCapacity * 2) + 2
 * - Java 9 ke atas: optimization lebih kompleks, tetap exponential
 * 
 * 3. StringBuilder vs StringBuffer:
 * - ensureCapacity() berlaku di kedua kelas
 * - Perilaku identik
 * - Hanya thread-safety yang membedakan
 * 
 * 4. Over-allocation:
 * - Java selalu over-allocate (alokasi lebih besar)
 * - Mencegah resize di masa depan
 * 
 * 5. Memory consideration:
 * - ensureCapacity(1000000) = alokasi 1 juta char (~2 MB)
 * - Pastikan memory mencukupi
 * - Bisa menyebabkan OutOfMemoryError jika terlalu besar
 * 
 * ================================================================
 * KESIMPULAN - VERSI PADAT
 * ================================================================
 * 
 * 1. ensureCapacity() = mengalokasikan kapasitas minimum buffer
 * 2. Mencegah resize berulang saat banyak append
 * 3. Meningkatkan performa secara signifikan
 * 4. minCapacity adalah MINIMUM, Java bisa alokasi lebih besar
 * 5. Gunakan saat tahu akan append banyak data
 * 6. Lebih efisien daripada konstruktor jika kapasitas tidak pasti
 * 7. Perhatikan memory jika kapasitas sangat besar
 * 
 * ================================================================
 * INTI PALING DALAM
 * ================================================================
 * 
 * ensureCapacity() adalah teknik mikro-optimasi yang dampaknya
 * sangat terasa pada operasi string skala besar.
 * 
 * Satu kali alokasi di awal lebih baik daripada puluhan kali
 * resize di tengah proses. Ini adalah prinsip dasar optimasi
 * memory management di Java.
 * 
 * ================================================================
 * CATATAN JAVA MODERN (17+)
 * ================================================================
 * 
 * Method ensureCapacity() tetap relevan di Java 17+ untuk
 * aplikasi yang membutuhkan performa tinggi.
 * 
 * Alternatif lain:
 * - new StringBuilder(int capacity) → langsung alokasi
 * - String.join() → untuk concatenation sederhana
 * - Text Blocks (Java 15+) → untuk string multi-line
 * 
 * Namun untuk dynamic string building dengan banyak append,
 * ensureCapacity() atau konstruktor dengan kapasitas awal
 * tetap menjadi pilihan terbaik.
 * 
 * ================================================================
 */

public class EnsureCapacity {
    public static void main(String[] args) {

        // Membuat StringBuffer kosong (capacity default = 16)
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println("Sebelum ensureCapacity():");
        System.out.println("Capacity: " + stringBuffer.capacity());

        // Menentukan kapasitas minimal 100
        // Biasanya >= 100 (bisa lebih tergantung implementasi)
        stringBuffer.ensureCapacity(100);

        System.out.println("\nSetelah ensureCapacity(100):");
        System.out.println("Capacity: " + stringBuffer.capacity());

        // Simulasi append banyak data
        for (int i = 0; i < 50; i++) {
            stringBuffer.append("A"); // menambahkan karakter A berulang
        }

        System.out.println("\nSetelah append 50 karakter:");
        System.out.println("Length: " + stringBuffer.length()); // 50
        System.out.println("Capacity: " + stringBuffer.capacity()); // tetap >= 100 (tidak resize)

        System.out.println("---------------------------------");

        // Bandingkan TANPA ensureCapacity

        StringBuffer stringBuffer1 = new StringBuffer();

        // Tanpa ensureCapacity
        for (int i = 0; i < 50; i++) {
            stringBuffer1.append(50);
        }

        // Capacity akan naik beberapa kali (resize berkali-kali)
        System.out.println("Length: " + stringBuffer1.length());
        System.out.println("Capacity: " + stringBuffer1.capacity());

        // Ini lebih lambat karena:
        // resize terjadi berulang kali

    }
}
