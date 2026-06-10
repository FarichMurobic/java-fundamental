package InputOutputIO.ReadingAndWritingFile;

/**
 * Reading and Writing Files
 *
 * Java menyediakan banyak class dan method untuk:
 * membaca file
 * menulis file
 *
 * Topik ini sebenarnya besar banget, dan dibahas lebih dalam di bagian lain buku.
 * Di sini kita fokus ke dasar-dasarnya dulu.
 *
 * Walaupun contoh pakai byte stream, konsepnya bisa dipakai juga ke character stream.
 *
 * ---------------------------------
 * 
 * Class penting
 * 
 * Dua class yang sering dipakai:
 * FileInputStream
 * FileOutputStream
 *
 * fungsinya:
 * FileInputStream → baca file
 * FileOutputStream → tulis file
 *
 * Cara buka file
 * FileInputStream(String fileName)
 * FileOutputStream(String fileName)
 *
 * Penjelasan
 * fileName → nama file
 * kalau file gak ada:
 * FileNotFoundException
 * kalau gagal buka:
 * juga error
 *
 * dan:
 * FileNotFoundException = turunan dari IOException
 *
 * ------------------------------------------
 * 
 * Fakta penting
 * 
 * Kalau pakai FileOutputStream:
 * file lama akan ditimpa (overwrite)
 *
 * Wajib: close()
 * close()
 *
 * fungsi:
 * menutup file
 * membebaskan resource
 *
 * Kalau gak ditutup?
 * bisa terjadi:
 * memory leak
 * resource kebuang sia-sia
 *
 * Dua cara close file
 * 1. Cara lama (manual)
 * fin.close();
 *
 * 2. Cara modern (JDK 7+)
 * try-with-resources (nanti dibahas)
 *
 * Kenapa belajar cara lama?
 * Karena:
 * banyak kode lama masih pakai ini
 * lu pasti bakal nemu di dunia nyata
 */

/* Display a Data2 file.
   Cara pakai:
   java InputOutputIO.ReadingAndWritingFile.ReadingAndWritingg ../data/Data2.txt
*/

import java.io.*;

public class ReadingAndWritingg {
    public static void main(String[] args) {

        int i; // untuk menyimpan byte yang dibaca
        FileInputStream fileInputStream; // stream untuk membca file

        System.out.println("Masuk Program");

        // cek apakah user memasukan nama file
        if (args.length != 1) {
            System.out.println("Usage: showfile Data2.txt");
            return;
        }

        // DEBUG
        System.out.println("Mau buka file");

        File file = new File(args[0]);

        System.out.println("Path: " + args[0]);
        System.out.println("Absolute: " + file.getAbsolutePath());
        System.out.println("Exist: " + file.exists());

        // coba buka file
        try {
            fileInputStream = new FileInputStream(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("cannot open file");
            return;
        }

        // file berhasil dibuka, sekarang dibaca
        try {
            do {
                i = fileInputStream.read(); // baca 1 byte
                if (i != -1) // kalau belum EOF
                    System.out.print((char) i); // tampilkan sebagai karakter
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("error reading file.");
        }

        // tutup file
        try {
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("error closing file");
        }

        /**
         * BEDAH DALAM PROGRAM 1
         *
         * Alur kerja
         * Buka file → baca byte → tampilkan → ulang → tutup file
         *
         * read() penting
         * i = fin.read();
         * baca 1 byte
         * return:
         * data
         * atau -1 → EOF
         *
         * Kenapa cast ke char?
         * (char) i
         *
         * karena:
         * data masih byte
         * kita ubah jadi karakter
         *
         * EXCEPTION HANDLING
         * 
         * Kenapa banyak try-catch?
         *
         * Karena:
         * file bisa gagal dibuka
         * bisa error saat dibaca
         * bisa error saat ditutup
         */
        
    }
}
