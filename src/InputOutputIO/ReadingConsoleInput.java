package InputOutputIO;

/**
 * Reading Console Input
 *
 * Di Java 1.0:
 * satu-satunya cara baca input console adalah pakai byte stream
 *
 * Sekarang:
 * masih boleh pakai byte stream
 * tapi untuk aplikasi serius (production):
 * lebih disarankan pakai character stream
 *
 * Kenapa?
 * lebih mudah di-maintain
 * lebih gampang support berbagai bahasa (Unicode)
 *
 * -----------------------------
 * 
 * Cara kerja input console
 * Di Java:
 * System.in
 *
 * ini sumber input (keyboard)
 *
 * Masalahnya
 * System.in itu:
 * bertipe InputStream (byte stream)
 *
 * sedangkan kita mau:
 * character stream
 *
 * Solusinya (dibungkus!)
 * Kita bungkus jadi:
 * BufferedReader br = new BufferedReader(
 *     new InputStreamReader(System.in)
 * );
 *
 * Penjelasan constructor
 * 
 * 1. BufferedReader
 * BufferedReader(Reader inputReader)
 * butuh Reader
 *
 * 2. InputStreamReader
 * InputStreamReader(InputStream inputStream)
 *
 * mengubah:
 * byte → karakter
 *
 * Jadi alurnya:
 * Keyboard → System.in → InputStreamReader → BufferedReader → Program
 *
 * ---------------------------------
 * 
 * Kenapa harus ribet dibungkus?
 *
 * Karena:
 * keyboard → byte
 * manusia → karakter
 *
 * jadi harus ada “translator”
 *
 * Peran masing-masing
 * System.in
 * sumber data (byte)
 *
 * InputStreamReader
 * translator:
 * byte → karakter
 *
 * BufferedReader
 * bikin lebih cepat
 * bisa baca per karakter / per baris
 *
 * Kenapa gak langsung muncul?
 *
 * Karena:
 * System.in itu line-buffered
 *
 * artinya:
 * input baru dikirim ke program setelah tekan ENTER
 *
 * Dampaknya
 * lu gak bisa baca karakter real-time
 * harus tunggu ENTER dulu
 *
 * ------------------------------------
 * 
 * KEKURANGAN read()
 * Masalah utama:
 * br.read()
 *
 * kurang cocok buat input interaktif
 *
 * Kenapa?
 * harus ENTER dulu
 * gak fleksibel
 *
 * SOLUSI YANG LEBIH BAGUS
 *
 * Biasanya dipakai:
 * br.readLine()
 *
 * baca langsung 1 baris
 *
 * Contoh:
 * String input = br.readLine();
 *
 * ---------------------
 * 
 * INSIGHT LEVEL PRO
 * 
 * Ini penting banget
 * Walaupun ini kelihatan sederhana:
 * ini dasar dari:
 * input user
 * CLI tools
 * backend processing
 *
 * Real-world
 *
 * Di dunia nyata:
 * jarang pakai read()
 * lebih sering:
 * readLine()
 * atau Scanner
 *
 * ---------------------------
 * 
 * KESIMPULAN SUPER SEDERHANA
 * 
 * System.in = input dari keyboard (byte)
 * harus dibungkus jadi character stream:
 * BufferedReader br = new BufferedReader(
 *     new InputStreamReader(System.in)
 * );
 *
 * read():
 * baca 1 karakter
 * return int
 * -1 = EOF
 *
 * input console:
 * harus tekan ENTER dulu (line-buffered)
 */

import java.io.*;

public class ReadingConsoleInput {
    public static void main(String[] args) throws IOException {
        
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter characters, 'q' to quit!");

        // BACA CHARACTERS
        // JIKA q QUIT
        do {
            c = (char) br.read();
            System.out.print(c);
        } while (c != 'q');
    }

}
