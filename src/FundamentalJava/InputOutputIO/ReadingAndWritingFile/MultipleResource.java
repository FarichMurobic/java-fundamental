package FundamentalJava.InputOutputIO.ReadingAndWritingFile;

import java.io.*;

public class MultipleResource {
    public static void main(String[] args) {

        int i;

        // CEK argumen
        if (args.length != 2) {
            System.out.println("Usage: copyfile from to");
            return;
        }

        // 2 resources sekaligus
        try (FileInputStream fileInputStream = new FileInputStream(args[0]);
                FileOutputStream fileOutputStream = new FileOutputStream(args[1])) {
            do {
                i = fileInputStream.read();
                if (i != -1)
                    fileOutputStream.write(i);
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("IO Error: " + e);
        }

        /**
         * PENJELASAN
         * 
         * try (
         * FileInputStream fin = ...
         * FileOutputStream fout = ...
         * )
         *
         * dua resource
         * dipisah pakai ;
         *
         * setelah try selesai:
         *
         * fin ditutup
         * fout ditutup
         *
         * otomatis semua.
         *
         * --------------------------------
         * 
         * KELEBIHAN BESAR
         * 
         * 1. Gak bisa lupa close
         * 2. Lebih pendek
         * 3. Lebih aman
         * 4. Standard modern Java
         */

    }

}
