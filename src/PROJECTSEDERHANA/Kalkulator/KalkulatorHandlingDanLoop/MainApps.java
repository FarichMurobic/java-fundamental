package PROJECTSEDERHANA.Kalkulator.KalkulatorHandlingDanLoop;

import java.util.Scanner;

public class MainApps {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Calculator calc = new Calculator();
        boolean running = true;

        while (running) {
            try {
                System.out.println("--- Kalkulator ---");
                System.out.println("1. Hitung");
                System.out.println("2. Keluar");
                System.out.print("Pilih Menu: ");

                int choice = input.nextInt();

                if (choice == 1) {
                    System.out.print("Masukkan angka pertama: ");
                    double a = input.nextDouble();

                    System.out.print("Masukkan angka kedua: ");
                    double b = input.nextDouble();

                    System.out.print("Masukkan Operator (+, -, *, /): ");
                    char op = input.next().charAt(0);

                    double result = calc.calculate(a, b, op);
                    System.out.println("Hasil: " + result);
                } else if (choice == 2) {
                    running = false;
                    System.out.println("Keluar dari program.");
                } else {
                    System.out.println("Menu tidak valid!.");
                }
            } catch (ArithmeticException e) {
                System.out.println("Error Matematika: " + e.getMessage());
            } catch (InvalidOperatorException e) {
                System.out.println("Error Operator: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Input tidak valid!.");
                input.nextLine(); // penting. buang input error biar gak infinite loop.
            }
        }

        input.close();
        System.out.println("Program Selesai.");

    }
}
