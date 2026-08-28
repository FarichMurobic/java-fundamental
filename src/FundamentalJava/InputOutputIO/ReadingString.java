package FundamentalJava.InputOutputIO;

/**
 * ============================================================
 *                     Reading Strings
 * ============================================================
 *
 * Untuk membaca teks dari console, BufferedReader menyediakan
 * method:
 *
 *     String readLine() throws IOException
 *
 * Method ini membaca satu baris teks dari input dan
 * mengembalikannya sebagai object String...
 *
 * Pembacaan akan selesai setelah pengguna menekan tombol Enter.
 *
 * Karena proses I/O dapat mengalami kegagalan, method ini
 * mendeklarasikan throws IOException sehingga exception tersebut
 * harus ditangani atau diteruskan oleh pemanggil.
 *
 * ------------------------------------------------------------
 *
 * Cara Kerja readLine()
 *
 * Ketika method readLine() dipanggil, alur yang terjadi adalah:
 *
 * 1. Pengguna mengetikkan teks pada console.
 * 2. Pengguna menekan tombol Enter.
 * 3. Seluruh baris teks dibaca oleh BufferedReader.
 * 4. Hasil pembacaan dikembalikan sebagai sebuah String.
 *
 * Contoh:
 *
 * String input = br.readLine();
 *
 * Jika pengguna mengetik:
 *
 * Hello Java
 *
 * kemudian menekan Enter, maka nilai variabel input adalah:
 *
 * "Hello Java"
 *
 * ------------------------------------------------------------
 *
 * Perbedaan read() dan readLine()
 *
 * BufferedReader menyediakan dua method utama untuk membaca
 * input dari character stream:
 *
 * read()
 *     Membaca satu karakter dan mengembalikan nilai bertipe int.
 *
 * readLine()
 *     Membaca satu baris teks dan mengembalikannya sebagai
 *     object String.
 *
 * Dalam kebanyakan aplikasi console, readLine() lebih praktis
 * karena pengguna umumnya memasukkan data dalam bentuk baris,
 * bukan karakter satu per satu.
 *
 * ------------------------------------------------------------
 *
 * Contoh Penggunaan
 *
 * Program sederhana yang menggunakan readLine() umumnya
 * melakukan hal-hal berikut:
 *
 * - Membaca satu baris teks dari pengguna.
 * - Menampilkan kembali teks yang dimasukkan.
 * - Mengulangi proses hingga kondisi tertentu terpenuhi,
 *   misalnya ketika pengguna mengetik "stop".
 *
 * readLine() juga sering digunakan untuk membuat aplikasi
 * console sederhana seperti editor teks, menu interaktif,
 * maupun utilitas command-line.
 *
 * ------------------------------------------------------------
 *
 * Ringkasan
 *
 * - readLine() merupakan method milik BufferedReader.
 * - Method ini membaca satu baris teks dari console.
 * - Nilai yang dikembalikan bertipe String.
 * - Pembacaan selesai setelah pengguna menekan Enter.
 * - Method ini dapat melempar IOException sehingga harus
 *   ditangani dengan tepat.
 * - Untuk input teks, readLine() umumnya lebih sesuai
 *   dibandingkan read() karena bekerja per baris.
 */

import java.io.*;

public class ReadingString {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;

        System.out.println("Enter lines of text.");
        System.out.println("Enter 'stop' to quit.");

        do {
            str = bufferedReader.readLine(); // baca perbaris
            System.out.println(str);
        } while (!str.equalsIgnoreCase("stop"));

        System.out.println();

        // CONTOH 2
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = new String[100];

        System.out.println("Enter line of text.");
        System.out.println("Enter 'stop' to quit.");

        for (int i = 0; i < 100; i++) {
            strings[i] = bReader.readLine();
            if (strings[i].equalsIgnoreCase("STOP"))
                break; // Keluar
        }

        System.out.println("\nHere is your file: ");

        // CETAK
        for (int i = 0; i < 100; i++) {
            if (strings[i].equalsIgnoreCase("STOP"))
                break; // KELUAR
            System.out.println(strings[i]);
        }
    }
}
