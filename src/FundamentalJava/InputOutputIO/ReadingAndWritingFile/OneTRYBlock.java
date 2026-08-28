package FundamentalJava.InputOutputIO.ReadingAndWritingFile;

// Farich Murobic.

import java.io.*;

public class OneTRYBlock {
    public static void main(String[] args) {

        int i;
        FileInputStream fileInputStream = null;

        if (args.length != 1) {
            System.out.println("Usage: showfile filename");
            return;
        }

        try {
            fileInputStream = new FileInputStream(args[0]);
            do {
                i = fileInputStream.read();
                if (i != -1)
                    System.out.print((char) i);
            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("An I/O Error Occured");
        } finally {
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                System.out.println("Error closing File");
            }
        }

    }

}
