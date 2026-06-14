package SimpleProjects.Kalkulator.KalkulatorAkarKuadrat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApps {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Calculator calc = new Calculator();
        List<String> history = new ArrayList<>();

        boolean running = true;

        while (running) {
            try {
                System.out.println("----- Kalkulator Advanced -----");
                System.out.println("1. Hitung");
                System.out.println("2. Lihat History");
                System.out.println("3. Keluar");
                System.out.print("Pilih: ");

                int choice = input.nextInt();
                input.nextLine();

                if (choice == 1) {
                    char op = InputHandler.inputOperator(input);

                    double result;

                    if (op == 'r') {
                        double a = InputHandler.inputDouble(input, "Masukkan angka: ");
                        result = calc.sqrt(a);

                        String record = "√" + a + " = " + result;
                        history.add(record);

                        System.out.println("Hasil: " + result);
                    } else {
                        double a = InputHandler.inputDouble(input, "Masukkan angka pertama: ");
                        double b = InputHandler.inputDouble(input, "Masukkan angka kedua: ");

                        result = calc.calculate(a, b, op);

                        String record = a + " " + op + " " + b + " = " + result;
                        history.add(record);

                        System.out.println("Hasil: " + result);
                    }
                } else if (choice == 2) {
                    System.out.println("\n=== HISTORY ===");
                    if (history.isEmpty()) {
                        System.out.println("Belum ada perhitungan.");
                    } else {
                        for (String h : history) {
                            System.out.println(h);
                        }
                    }

                } else if (choice == 3) {
                    running = false;
                    System.out.println("Keluar program...");
                } else {
                    System.out.println("Menu tidak valid!");
                }

            } catch (ValidationException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (Exception e) {
                System.out.println("Input menu harus angka!");
                input.nextLine(); // clear buffer
                    
                }
        }
    }
}
