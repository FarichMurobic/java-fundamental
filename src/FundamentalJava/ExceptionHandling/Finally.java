package FundamentalJava.ExceptionHandling;

/**
 * ------------------------------------------------------------
 * FINALLY
 * ------------------------------------------------------------
 *
 * Saat exception terjadi, alur eksekusi program dapat berubah secara
 * tiba-tiba. Akibatnya, kode setelah titik terjadinya exception
 * mungkin tidak pernah dijalankan..
 *
 * Contoh:
 * - File sudah dibuka
 * - Koneksi database sudah dibuat
 * - Socket jaringan sudah aktif
 *
 * Jika terjadi exception sebelum proses penutupan resource,
 * maka resource tersebut bisa tetap terbuka dan menyebabkan
 * masalah seperti:
 *
 * - Resource leak
 * - File lock
 * - Koneksi menumpuk
 * - Pemborosan memori
 *
 * Untuk mengatasi hal tersebut, Java menyediakan blok:
 *
 * finally
 *
 * ------------------------------------------------------------
 * FUNGSI FINALLY
 * ------------------------------------------------------------
 *
 * finally adalah blok kode yang dijalankan setelah blok try
 * dan catch selesai diproses.
 *
 * Tujuan utamanya adalah menjalankan kode cleanup
 * (pembersihan resource) yang harus dieksekusi terlepas dari
 * berhasil atau gagalnya operasi.
 *
 * Bentuk umum:
 *
 * try {
 * // kode yang berpotensi menghasilkan exception
 * }
 * catch (Exception e) {
 * // penanganan exception
 * }
 * finally {
 * // cleanup resource
 * }
 *
 * ------------------------------------------------------------
 * KAPAN FINALLY DIJALANKAN?
 * ------------------------------------------------------------
 *
 * Dalam kondisi normal, finally akan tetap dieksekusi:
 *
 * - Tidak ada exception
 * - Exception terjadi dan ditangani oleh catch
 * - Ada statement return di dalam try
 * - Ada statement return di dalam catch
 * - Exception diteruskan ke caller (throws)
 *
 * Contoh:
 *
 * static int test() {
 * try {
 * return 10;
 * } finally {
 * System.out.println("finally dijalankan");
 * }
 * }
 *
 * Output:
 * finally dijalankan
 *
 * Walaupun return sudah dieksekusi,
 * finally tetap dijalankan terlebih dahulu.
 *
 * ------------------------------------------------------------
 * KONDISI KHUSUS
 * ------------------------------------------------------------
 *
 * Walaupun sering disebut "selalu dijalankan",
 * ada beberapa kondisi ekstrem yang dapat membuat finally
 * tidak sempat dieksekusi, misalnya:
 *
 * - JVM dihentikan secara paksa menggunakan System.exit()
 * - Crash pada JVM
 * - Kegagalan sistem operasi
 * - Power loss / listrik mati
 *
 * Namun dalam alur program Java normal,
 * finally dapat dianggap selalu dijalankan.
 *
 * ------------------------------------------------------------
 * URUTAN EKSEKUSI
 * ------------------------------------------------------------
 *
 * Kasus 1 - Tidak ada exception:
 *
 * try
 * ↓
 * finally
 * ↓
 * lanjut program
 *
 * Kasus 2 - Exception ditangkap:
 *
 * try
 * ↓
 * catch
 * ↓
 * finally
 * ↓
 * lanjut program
 *
 * Kasus 3 - Exception tidak ditangkap:
 *
 * try
 * ↓
 * finally
 * ↓
 * exception diteruskan ke caller
 *
 * ------------------------------------------------------------
 * PENGGUNAAN DI JAVA MODERN
 * ------------------------------------------------------------
 *
 * Sebelum Java 7, finally sering digunakan untuk menutup
 * resource secara manual.
 *
 * Contoh:
 *
 * FileInputStream fis = null;
 *
 * try {
 * fis = new FileInputStream("data.txt");
 * }
 * finally {
 * if (fis != null) {
 * fis.close();
 * }
 * }
 *
 * Sejak Java 7, pendekatan yang lebih direkomendasikan adalah:
 *
 * try-with-resources
 *
 * karena resource akan ditutup otomatis.
 *
 * Contoh:
 *
 * try (FileInputStream fis =
 * new FileInputStream("data.txt")) {
 *
 * // gunakan file
 *
 * }
 *
 * Tidak perlu finally untuk menutup file.
 *
 * Oleh karena itu:
 *
 * Java modern:
 * - Utamakan try-with-resources untuk resource management
 * - Gunakan finally untuk cleanup umum yang tidak bisa
 * ditangani oleh try-with-resources
 *
 * ------------------------------------------------------------
 * KAPAN MENGGUNAKAN FINALLY?
 * ------------------------------------------------------------
 *
 * Gunakan finally ketika ada operasi yang HARUS dijalankan
 * sebelum method berakhir.
 *
 * Contoh:
 *
 * - Melepas lock
 * - Mengembalikan status sistem
 * - Membersihkan temporary data
 * - Menutup resource legacy
 * - Logging akhir proses
 *
 * ------------------------------------------------------------
 * ANALOGI
 * ------------------------------------------------------------
 *
 * try
 * = melakukan pekerjaan
 *
 * catch
 * = menangani masalah yang muncul
 *
 * finally
 * = membereskan semua sebelum pulang
 *
 * Mau pekerjaan berjalan lancar ataupun gagal,
 * proses beres-beres tetap harus dilakukan.
 *
 * ------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------
 *
 * - finally adalah blok cleanup dalam exception handling.
 * - finally dijalankan setelah try dan/atau catch selesai.
 * - finally tetap berjalan meskipun terdapat return.
 * - finally sangat berguna untuk memastikan resource
 * dibersihkan dengan benar.
 * - Pada Java modern, penutupan resource sebaiknya
 * menggunakan try-with-resources.
 * - finally tetap penting untuk operasi cleanup umum
 * yang harus selalu dieksekusi.
 */

public class Finally {

    // Contoh 1 ada 1 error
    static void procA() {

        try {
            System.out.println("inside procA");
            throw new RuntimeException("Demo"); // ERROR
        } finally {
            // Tetap dijalankan meskipun ada error
            System.out.println("procA's finally");
        }
    }

    // Contoh 2 ada retur
    static void procB() {

        try {
            System.out.println("inside procB");
            return; // Keluar method
        } finally {
            // Tetap dijalankan sebelum return
            System.out.println("procB's finally");
        }
    }

    // Contoh 3 normal
    static void procC() {

        try {
            System.out.println("inside proc'C");
        } finally {
            // Tetp dijalankan
            System.out.println("proC's finally");
        }
    }

    public static void main(String[] args) {

        // Method 1
        try {
            procA();
        } catch (Exception e) {
            System.out.println("Exception caught");
        }

        System.out.println();

        // Method 2
        procB();

        System.out.println();

        // Method 3
        procC();

        /**
         * Output
         * inside procA
         * procA's finally
         * Exception caught
         *
         * inside procB
         * procB's finally
         *
         * inside procC
         * procC's finally
         * 
         * ---------------------------------
         *
         * Penjelasan Per Kasus
         * procA (Ada Exception)
         * throw → finally → catch
         *
         * walaupun error, finally tetap jalan dulu
         *
         * procB (Ada return)
         * return → finally → keluar method
         *
         * finally tetap jalan sebelum keluar
         *
         * procC (Normal)
         * try selesai → finally jalan
         *
         * tetap dieksekusi
         */

    }
}
