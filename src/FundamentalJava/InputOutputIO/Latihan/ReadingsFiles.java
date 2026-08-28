package FundamentalJava.InputOutputIO.Latihan;

// Latihan

import java.io.*;

public class ReadingsFiles {
    public static void main(String[] args) {

        try {
            FileInputStream fileInputStream = new FileInputStream(
                    "C:\\Users\\Farich Murobiq\\My Project Repositori\\Java Fundamental\\data\\Data1.txt");
            int data;
            while ((data = fileInputStream.read()) != -1) {
                // String biner = String.format("%8s", Integer.toBinaryString(data).replace(' ',
                // '0'));
                // KALO MAU CONVERT KE BINER
                // System.out.println(biner);
                // CETAK DATA ASLI
                System.out.print((char) data);
            }
            fileInputStream.close();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n----------\n");

        // Cara ke dua
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(
                    "C:\\Users\\Farich Murobiq\\My Project Repositori\\Java Fundamental\\data\\Data2.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("-------------");

        try {
            FileReader fileReader = new FileReader(
                    "C:\\Users\\Farich Murobiq\\My Project Repositori\\Java Fundamental\\data\\Data1.txt");
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }

            File file = new File("C:\\Users\\Farich Murobiq\\My Project Repositori\\Java Fundamental\\data\\Data2.txt");
            System.out.println("\n" + file.exists());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
