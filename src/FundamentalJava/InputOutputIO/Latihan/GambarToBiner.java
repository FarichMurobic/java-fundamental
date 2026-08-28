package FundamentalJava.InputOutputIO.Latihan;

// Latihan.

import java.io.FileInputStream;
import java.io.IOException;

public class GambarToBiner {
    public static void main(String[] args) {

        String path = "C:\\Users\\Farich Murobiq\\My Project Repositori\\Java Fundamental\\data\\gambar.jpg";

        try (FileInputStream FIS = new FileInputStream(path)) {

            int data;
            int count = 0;

            while ((data = FIS.read()) != -1 && count < 100) { // Batasi 100 byte biar gak panjang!
                // UBAH MENJADI KODE BINER 8 BIT
                String CodeBiner = String.format("%8s", Integer.toBinaryString(data)).replace(' ', '0');
                // byte temp = (byte) data;
                // TAMPILKAN DATA SUDAH DI CONVERT KE BINER
                System.out.println(CodeBiner);
                // DATA ASLI
                // System.out.println(data);

                count++; // NAIKAN Count
            }

        } catch (IOException e) {
            e.getCause();
        }

    }

}
