package PROJECTSEDERHANA.Kalkulator.KalkulatorImplementsRunnable;

import java.util.Scanner;

public class MainApps {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Kalkulator calc = new Kalkulator();

        boolean running = true;

        while (running) {
            try {
                System.out.println("----- Kalkulator Thread -----");
                System.out.println("1. Hitung");
                System.out.println("2. Keluar");
                System.out.print("Pilih: ");

                int choice = input.nextInt();
                input.nextLine();

                if (choice == 1) {
                    System.out.print("Masukkan angka pertama: ");
                    double a = input.nextDouble();

                    System.out.print("Masukkan angka kedua: ");
                    double b = input.nextDouble();

                    input.nextLine();

                    System.out.print("Masukkan operator (+, -, *, /): ");
                    char op = input.next().charAt(0);

                    // bikin thread
                    ClculationTask task = new ClculationTask(a, b, op, calc);
                    Thread thread = new Thread(task);

                    thread.start(); // jalanin thread
                } else if (choice == 2) {
                    running = false;
                    System.out.println("Keluar program...");
                } else {
                    System.out.println("Menu tidak Valid!.");
                }
            } catch (Exception e) {
                System.out.println("Input tidak Valid!.");
                input.nextLine(); // clean buffer
            }
        }

        input.close();
        System.out.println("Program selesai.");

    }
}
