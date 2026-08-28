package FundamentalJava.InputOutputIO.ReadingAndWritingFile;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {

        int i;

        FileInputStream fin = null;
        FileOutputStream fon = null;

        // CEK ARGUMEN
        if (args.length != 2) {
            System.out.println("Usage: copyfile from to...");
            return;
        }

        try {
            // BUKA FILE INPUT DAN OUTPUT
            fin = new FileInputStream(args[0]);
            fon = new FileOutputStream(args[1]);

            do {
                i = fin.read(); // BACA FILE DARI SUMBER

                if (i != -1) {
                    fon.write(i); // TULIS KE FILE TUJUAN
                }
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("IO Error: " + e);
        } finally {
            // TUTUP FILE INPUT
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException e1) {
                System.out.println("Error closing input file...");
            }

            // TUTUP FILE OUTPUT
            try {
                if (fon != null)
                    fon.close();
            } catch (IOException e1) {
                System.out.println("Error closing output file...");
            }
        }

        /**
         * Bedah
         *
         * Alur
         * Buka file A → buka file B → baca A → tulis ke B → ulang → tutup semua
         *
         * Kunci utama
         * i = fin.read();
         * fout.write(i);
         *
         * ini:
         * baca → tulis
         * jadi proses copy
         *
         * -------------------------------
         * 
         * Kenapa 2 try saat close?
         *
         * supaya:
         * kalau satu gagal → yang lain tetap ditutup...
         *
         * ------------------------------
         * 
         * KESIMPULAN SUPER LENGKAP
         * 
         * FileInputStream → baca file
         * FileOutputStream → tulis file
         * read() → baca byte
         * write() → tulis byte
         * -1 → EOF
         * close() → WAJIB
         *
         * Inti besar:
         * File I/O = stream
         * Semua berbasis byte
         * Harus handle error
         * Harus close file
         */

    }

}
