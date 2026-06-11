package PROJECTSEDERHANA.Kalkulator.KalkulatorAkarKuadrat;

import java.util.Scanner;

public class InputHandler {

    public static double inputDouble(Scanner input, String message) {
        while (true) {
            try {
                System.out.print(message);
                double value = input.nextDouble();
                input.nextLine(); // clear buffer
                return value;
            } catch (Exception e) {
                System.out.println("Harus angka!");
                input.nextLine(); // buang input error
            }
        }
    }

    public static char inputOperator(Scanner input) {
        while (true) {
            System.out.print("Massukkan Operator (+, -, *, /, ^, r untuk akar): ");
            String op = input.nextLine();

            if (op.length() == 1) {
                return op.charAt(0);
            } else {
                System.out.println("Operator tidak valid!.");
            }
        }
    }
}
