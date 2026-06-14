package FundamentalJava.InputOutputIO;

/**
 * Reading Strings
 *
 * Untuk membaca string (teks) dari keyboard, gunakan method:
 * String readLine() throws IOException
 *
 * Method ini:
 * bagian dari BufferedReader
 * mengembalikan object String
 *
 * Method ini:
 * bagian dari BufferedReader
 * mengembalikan object String
 *
 * Program contoh 1
 *
 * Program ini:
 * membaca baris teks dari user
 * menampilkan kembali
 * berhenti kalau user mengetik "stop"
 *
 * Program contoh 2
 *
 * Program ini:
 * seperti text editor sederhana
 * menyimpan input ke array
 * maksimal 100 baris
 * berhenti kalau "stop"
 *
 * Perbedaan penting dari sebelumnya
 * Sebelumnya:
 * read()
 * baca 1 karakter
 *
 * Sekarang:
 * readLine()
 * baca 1 baris penuh
 *
 * Kenapa ini jauh lebih penting?
 *
 * Karena:
 * manusia input → biasanya per baris
 * bukan per karakter
 *
 * jadi ini jauh lebih realistis
 *
 * Cara kerja readLine()
 * User ngetik → tekan ENTER → readLine() ambil seluruh baris
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
