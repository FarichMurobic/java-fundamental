package ExploringJavaLang.ReadableInterface;

/**
 * The Readable Interface
 *
 * Interface Readable menunjukkan bahwa suatu object bisa digunakan sebagai sumber karakter (source of characters).
 *
 * Method utama
 * int read(CharBuffer buf) throws IOException
 * Penjelasan:
 * Membaca karakter ke dalam buf (CharBuffer)
 * Return:
 * jumlah karakter yang dibaca
 * -1 → jika sudah EOF (End Of File / tidak ada data lagi)
 *
 * PENJELASAN MENDALAM
 *
 * Inti konsep
 *
 * Readable =
 * object yang bisa dibaca sebagai teks
 *
 * Analogi
 * Readable = sumber air
 * CharBuffer = ember
 *
 * read() = isi ember dari sumber
 *
 * Siapa yang implement?
 * Contoh penting:
 * Reader (FileReader, BufferedReader)
 * Scanner
 *
 * 1. CharBuffer itu apa?
 * tempat menyimpan karakter sementara
 *
 * 2. Kenapa ada flip()?
 * buffer.flip();
 *
 * Mengubah mode:
 * dari write → read
 *
 * 3. EOF (-1)
 * if (readable.read(buffer) == -1)
 *
 * berarti:
 * data sudah habis
 *
 * HAL PENTING
 * Readable ≠ InputStream
 * Readable	                    InputStream
 * karakter (char)	            byte
 * text oriented	            binary
 *
 * CharBuffer wajib dikelola
 * flip() → baca
 * clear() → tulis ulang
 *
 * USE CASE DI BACKEND
 * Dipakai di:
 * membaca file teks
 * parsing input
 * Scanner input
 * streaming data
 *
 * Contoh real:
 * Scanner scanner = new Scanner(System.in);
 *
 * di belakang layar pakai Readable
 *
 * KESIMPULAN
 * Inti:
 * Readable = sumber karakter
 * Method utama:
 * read(CharBuffer)
 *
 * Return value:
 * angka → jumlah karakter
 * -1 → EOF
 *
 * Insight penting:
 * Ini bagian dari sistem I/O Java
 * Dipakai di banyak class penting
 */

import java.io.*;
import java.nio.CharBuffer;

public class ReadableInterface {
    public static void main(String[] args) throws Exception {

        // Contoh penggunaan Readable
        // StringReader implement Readable
        Readable readable = new StringReader("Hello World");

        // Buffer untuk menampung karakter
        CharBuffer buffer = CharBuffer.allocate(20);

        // Membaca data
        int charsRead = readable.read(buffer);

        System.out.println("Jumlah karakter dibaca: " + charsRead);

        // Balik buffer untuk dibaca
        buffer.flip();

        // Print isi buffer
        System.out.println(buffer.toString());

        /**
         * OUTPUT
         * Jumlah karakter dibaca: 11
         * Hello World
         */

        System.out.println();

        // CONTOH LOOP (REAL USE)
        // Membaca sampai habis
        Readable readable1 = new StringReader("Belajar Java");
        CharBuffer buffer1 = CharBuffer.allocate(5);

        int result1;

        // Loop sampai EOF
        while ((result1 = readable1.read(buffer1)) != -1) {
            buffer1.flip();
            System.out.println(buffer1.toString());
            buffer1.clear(); // reset buffer
        }

        /**
         * FLOW KERJA
         * read() → isi buffer
         * flip() → siap dibaca
         * clear() → reset buffer
         */
    }
}
