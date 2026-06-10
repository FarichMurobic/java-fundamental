package InputOutputIO.ReadingAndWritingFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.*;

public class CleanVersion {
    public static void main(String[] args) {
        
        int i;
        FileInputStream fin = null;

        if (args.length != 1) {
            System.out.println("Usage: showfile filname...");
            return;
        }

        try {
            fin = new FileInputStream(args[0]);
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.print((char) i);
                }
            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
        } catch (IOException e) {
            System.out.println("An I/O Ocurred");
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException e) {
                System.out.println("ERROR Closing...");
            }
        }

         /**
         * VERSI DENGAN finally (LEBIH AMAN)
         *
         * Kenapa pakai finally?
         *
         * supaya:
         * file tetap ditutup walaupun error
         */
    }

}
