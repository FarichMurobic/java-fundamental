package FundamentalJava.InputOutputIO.Latihan;

// Latihan.

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyGambar {
    public static void main(String[] args) {

        // CARI ALAMAT FOLDER SUMBER GAMBAR
        String sumber = "C:\\Users\\Farich Murobiq\\My Project Repositori\\Java Fundamental\\data\\gambar.jpg";
        // ALAMAT FOLDER UNTUK MENYIMPAN COPY AN
        String tujuan = "C:\\Users\\Farich Murobiq\\My Project Repositori\\Java Fundamental\\data\\copy1.jpg";

        // CONTOH KODE COPY GAMBAR
        try (FileInputStream fis = new FileInputStream(sumber); // BUKA GAMBAR
                FileOutputStream fos = new FileOutputStream(tujuan)) { // TULIS ULANG (COPY)

            // BUAT DATA PENAMPUNG
            byte[] buffer = new byte[4096];
            int length;

            // ULANGI SAMPAI COPYAN HABIS TIDAK ADA NILAI!
            while ((length = fis.read(buffer)) != -1) {
                buffer[0] = 0;
                fos.write(buffer, 0, length); // COPY (TULIS)
            }

            System.out.println("Gambar berhasil di copy");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
