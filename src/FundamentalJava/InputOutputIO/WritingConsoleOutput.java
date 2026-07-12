package FundamentalJava.InputOutputIO;

/**
 * ============================================================
 *                  Writing Console Output
 * ============================================================
 *
 * Java menyediakan beberapa cara untuk menampilkan output ke
 * console. Cara yang paling umum adalah menggunakan method:
 *
 *     print()
 *     println()
 *
 * Kedua method tersebut berasal dari class PrintStream dan
 * digunakan melalui object:
 *
 *     System.out
 *
 * Sebagai contoh:
 *
 * System.out.println("Hello, World!");
 *
 * ------------------------------------------------------------
 *
 * System.out
 *
 * System.out merupakan standard output pada Java.
 *
 * Field ini bertipe:
 *
 *     PrintStream
 *
 * Secara default, output diarahkan ke console, meskipun dapat
 * dialihkan (redirect) ke file, network, atau tujuan output
 * lainnya.
 *
 * Meskipun PrintStream merupakan byte stream, class ini
 * menyediakan method yang memudahkan penulisan teks dan
 * berbagai tipe data tanpa perlu melakukan konversi secara
 * manual.
 *
 * ------------------------------------------------------------
 *
 * Method print() dan println()
 *
 * Method print() digunakan untuk menampilkan data tanpa
 * berpindah ke baris berikutnya.
 *
 * Method println() digunakan untuk menampilkan data kemudian
 * menambahkan karakter pemisah baris (line separator) sesuai
 * sistem operasi yang digunakan.
 *
 * Karena kemudahannya, kedua method ini merupakan pilihan utama
 * untuk menghasilkan output pada aplikasi console.
 *
 * ------------------------------------------------------------
 *
 * Method write()
 *
 * Selain print() dan println(), PrintStream juga mewarisi
 * method write() dari OutputStream.
 *
 * Bentuk sederhananya adalah:
 *
 *     void write(int b)
 *
 * Method ini menulis satu byte ke output.
 *
 * Walaupun parameter bertipe int, hanya 8 bit paling rendah
 * yang digunakan sebagai nilai byte yang akan ditulis.
 *
 * Method ini bekerja pada level yang lebih rendah dibandingkan
 * print() maupun println().
 *
 * ------------------------------------------------------------
 *
 * Perbedaan print()/println() dan write()
 *
 * print() / println()
 *     - Digunakan untuk menampilkan teks dan berbagai tipe data.
 *     - Melakukan konversi data secara otomatis.
 *     - Lebih mudah digunakan.
 *     - Cocok untuk sebagian besar aplikasi console.
 *
 * write()
 *     - Menulis data dalam bentuk byte.
 *     - Bekerja pada level yang lebih rendah.
 *     - Lebih sesuai untuk kebutuhan khusus yang berhubungan
 *       dengan manipulasi byte.
 *
 * ------------------------------------------------------------
 *
 * Hubungan PrintStream dan OutputStream
 *
 * Hierarki sederhananya adalah:
 *
 * OutputStream
 *      ↑
 * PrintStream
 *
 * Karena PrintStream merupakan turunan dari OutputStream,
 * seluruh kemampuan dasar OutputStream, termasuk write(),
 * tetap tersedia.
 *
 * Sementara itu, PrintStream menambahkan berbagai method
 * berlevel lebih tinggi seperti:
 *
 * - print()
 * - println()
 * - printf()
 *
 * sehingga proses penulisan output menjadi jauh lebih mudah.
 *
 * ------------------------------------------------------------
 *
 * Penggunaan di Java Modern
 *
 * Untuk aplikasi console, penggunaan print() dan println()
 * masih merupakan pendekatan yang umum dan direkomendasikan.
 *
 * Apabila aplikasi memerlukan output berbasis character stream,
 * Java juga menyediakan class PrintWriter yang menawarkan API
 * serupa dengan dukungan penuh terhadap character stream.
 *
 * ------------------------------------------------------------
 *
 * Ringkasan
 *
 * - System.out merupakan standard output pada Java.
 * - System.out bertipe PrintStream.
 * - print() dan println() digunakan untuk menghasilkan output
 *   teks dengan mudah.
 * - write() menulis data dalam bentuk byte dan bekerja pada
 *   level yang lebih rendah.
 * - PrintStream menyediakan abstraksi sehingga penulisan teks
 *   menjadi lebih sederhana dibandingkan menggunakan write()
 *   secara langsung.
 */

public class WritingConsoleOutput {
    public static void main(String[] args) {
        
        int b;
        b = 'a'; // karakter 'A' → dikonversi ke ASCII (65)

        // NULIS 1 BYTE:
        // HASILNYA A
        System.out.write(b);
        // newline (ENTER)
        System.out.write('\n'); // lihat ini char bukan string
    }

}
