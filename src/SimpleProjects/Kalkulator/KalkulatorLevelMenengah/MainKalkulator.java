package SimpleProjects.Kalkulator.KalkulatorLevelMenengah;

import java.util.Scanner;

public class MainKalkulator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int pilihan;

        KalkulatorLanjutan k = null;

        do {
            System.out.println("\n----- Kalkulator Pro -----");
            System.out.println("1. Input angka");
            System.out.println("2. Pertambahan");
            System.out.println("3. Pengurangan");
            System.out.println("4. Perkalian");
            System.out.println("5. Pembagian");
            System.out.println("6. Lihat History");
            System.out.println("7. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan angka pertama: ");
                    double a = input.nextDouble();

                    System.out.print("Masukkan angka kedua: ");
                    double b = input.nextDouble();

                    k = new KalkulatorLanjutan(a, b);
                    break;
                case 2:
                    if (k != null)
                        System.out.println("Hasil: " + k.pertambahan());
                    else
                        System.out.println("Input angka dulu!");
                    break;
                case 3:
                    if (k != null)
                        System.out.println("Hasil: " + k.pengurangan());
                    else
                        System.out.println("Input angka dulu!");
                    break;
                case 4:
                    if (k != null)
                        System.out.println("Hasil: " + k.perkalian());
                    else
                        System.out.println("Input angka dulu!");
                    break;
                case 5:
                    if (k != null)
                        System.out.println("Hasil: " + k.pembagian());
                    else
                        System.out.println("Input angka dulu!");
                    break;
                case 6:
                    if (k != null)
                        k.tampilkanHistory();
                    else
                        System.out.println("Belum ada history!");
                    break;
                case 7:
                    System.out.println("Keluar bro 🙌");
                    break;
                default:
                    System.out.println("Pilihan salah!");
            }

        } while (pilihan != 7);

        input.close();
    }
}
