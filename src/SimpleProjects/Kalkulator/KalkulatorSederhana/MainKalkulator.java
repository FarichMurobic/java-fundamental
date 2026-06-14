package SimpleProjects.Kalkulator.KalkulatorSederhana;

import java.util.Scanner;

public class MainKalkulator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n----- Kalkulator Menu -----");
            System.out.println("1. Pertambahan");
            System.out.println("2. Pengurangan");
            System.out.println("3. Perkalian");
            System.out.println("4. Pembagian");
            System.out.println("5. Modulus");
            System.out.println("6. Keluar Program");
            System.out.print("Pilih Menu: ");
            pilihan = input.nextInt();

            if (pilihan >= 1 && pilihan <= 5) {
                System.out.print("Masukkan angka pertama: ");
                int a = input.nextInt();

                System.out.print("Masukkan angka kedua: ");
                int b = input.nextInt();

                KalkulatorCanggih k = new KalkulatorCanggih(a, b);

                switch (pilihan) {
                    case 1:
                        System.out.println("Hasil: " + k.tambah());
                        break;
                    case 2:
                        System.out.println("Hasil: " + k.kurang());
                        break;
                    case 3:
                        System.out.println("Hasil: " + k.kali());
                        break;
                    case 4:
                        System.out.println("Hasil: " + k.bagi());
                        break;
                    case 5:
                        System.out.println("Hasil: " + k.modulus());
                }
            } else if (pilihan == 6) {
                System.out.println("Terima kasih bro.");
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 6);

        input.close();

    }
}
