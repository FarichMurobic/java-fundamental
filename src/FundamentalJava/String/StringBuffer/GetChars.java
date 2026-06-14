package FundamentalJava.String.StringBuffer;

/**
 * getChars()
 *
 * Untuk menyalin substring dari sebuah StringBuffer ke dalam array, gunakan method getChars().
 * Bentuk umumnya:
 * void getChars(int sourceStart, int sourceEnd, char target[], int targetStart)
 *
 * Di sini:
 * sourceStart menentukan index awal substring
 * sourceEnd menentukan index satu posisi setelah akhir substring
 *
 * Artinya:
 * substring berisi karakter dari sourceStart sampai sourceEnd - 1
 *
 * Array yang akan menerima karakter ditentukan oleh target.
 * Index dalam target tempat substring akan mulai disalin ditentukan oleh targetStart.
 * Harus diperhatikan bahwa array target cukup besar untuk menampung jumlah karakter yang akan disalin.
 *
 * 1. Fungsi utama getChars()
 * Copy sebagian isi StringBuffer ke:
 * char[]
 *
 * 2. Struktur parameter (WAJIB PAHAM)
 * getChars(sourceStart, sourceEnd, target, targetStart)
 * Parameter	Arti
 * sourceStart	index awal di StringBuffer
 * sourceEnd	index akhir (tidak ikut diambil)
 * target	array tujuan
 * targetStart	mulai masukin ke index ke berapa di array
 *
 * --------------------------------------
 * 
 * Konsep PENTING: sourceEnd itu EXCLUSIVE
 *
 * Misalnya:
 * "Hello"
 *  01234
 * getChars(1, 4, ...)
 * Yang diambil:
 *
 * index 1 → e
 * index 2 → l
 * index 3 → l
 *
 * Hasil:
 * "ell"
 *
 * Visual Biar Makin Jelas
 * StringBuffer:
 * "Hello World"
 *  01234567890
 *
 * Setelah:
 * sb.getChars(0, 5, target, 0);
 * target:
 * [H][e][l][l][o][ ][ ][ ][ ][ ][ ]
 *
 * Setelah:
 * sb.getChars(6, 11, target, 6);
 * target:
 * [H][e][l][l][o][ ][W][o][r][l][d]
 *
 * Error yang sering terjadi (WAJIB HINDARI)
 * 1. Array target kekecilan
 * char[] target = new char[3];
 * sb.getChars(0, 5, target, 0);
 *
 * ERROR:
 * ArrayIndexOutOfBoundsException
 *
 * 2. Index keluar batas
 * sb.getChars(0, 50, target, 0);
 *
 * ERROR:
 * StringIndexOutOfBoundsException
 *
 * Kapan dipakai?
 * Biasanya:
 * manipulasi karakter low-level
 * parsing manual
 * optimasi performa (hindari object baru)
 *
 * -------------------------------------
 * 
 * Insight penting (level naik)
 * getChars() itu lebih cepat dibanding:
 * substring().toCharArray()
 *
 * Karena:
 * langsung copy
 * gak bikin object tambahan
 *
 * Kesimpulan (versi nempel keras)
 * getChars() = copy substring ke array
 * sourceEnd = tidak ikut (exclusive)
 * Harus:
 * array cukup besar
 * index valid
 *
 * Inti banget:
 * getChars() = cara cepat & efisien ambil sebagian string ke array
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
        stringBuffer.getChars(6,11, target, 6);
        System.out.println("\nHasil 2:");
        System.out.println(target);

    }
}
