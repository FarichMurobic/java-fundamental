package FundamentalJava.String.StringBuffer;

/**
 * setLength()
 *
 * Untuk mengatur panjang string di dalam objek StringBuffer, gunakan setLength().
 * Bentuk umumnya:
 * void setLength(int len)
 *
 * Di sini, len menentukan panjang string. Nilai ini harus tidak negatif.
 * Ketika kamu memperbesar ukuran string, karakter null akan ditambahkan di bagian akhir.
 * Jika kamu memanggil setLength() dengan nilai yang lebih kecil dari panjang saat ini (length()),
 * maka karakter yang berada di luar panjang baru tersebut akan hilang.
 *
 * 1. Fungsi utama setLength()
 * Ngatur panjang string secara paksa
 *
 * Artinya:
 * Bisa dipotong
 * Bisa diperpanjang
 * 
 * 2. Dua Skenario Penting
 * A. Kalau len LEBIH KECIL (memotong)
 * StringBuffer sb = new StringBuffer("Hello World");
 * sb.setLength(5);
 *
 * Hasil:
 * "Hello"
 *
 * Semua setelah index ke-4 hilang permanen
 *
 * B. Kalau len LEBIH BESAR (memperpanjang)
 * StringBuffer sb = new StringBuffer("Hi");
 * sb.setLength(5);
 *
 * Hasil internal:
 * "H i \0 \0 \0"
 *
 * \0 = null character (bukan string kosong biasa)
 *
 * Penting: Null Character itu apa?
 * Bukan " " (spasi)
 * Bukan "" (kosong)
 * Tapi karakter ASCII 0
 *
 * Biasanya:
 * gak keliatan pas di-print
 * tapi tetap ada di memory
 *
 * Yang Terjadi di Balik Layar
 * Saat DIPOTONG:
 * Data setelah batas → dihapus
 * Memory bisa tetap ada, tapi gak dianggap bagian string
 *
 * Saat DIPERPANJANG:
 * Java isi dengan:
 * \0 \0 \0
 *
 * Ini placeholder, bukan karakter normal
 *
 * ---------------------------------------
 * 
 * Insight penting (level naik)
 * setLength() itu low-level control
 * Jarang dipakai di coding biasa, tapi:
 * penting buat optimasi
 * dipakai di library internal Java
 *
 * Kesimpulan (versi nempel keras)
 * setLength(int len) = atur panjang string manual
 * Kalau:
 * lebih kecil → string dipotong
 * lebih besar → ditambah null character
 * Null char:
 * gak keliatan
 * tapi tetap ada di memory
 *
 * Inti banget:
 * setLength() = “paksa string jadi panjang tertentu”
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
