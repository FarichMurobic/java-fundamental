package PROJECTSEDERHANA.Kalkulator.KalkulatorExceptionHandling;

// import scanner
import java.util.Scanner;

public class MainApps {
    public static void main(String[] args) {

        // buat objek scanner
        Scanner input = new Scanner(System.in);
        // buat objek class Calculator
        Calculator calc = new Calculator();

        // persiapan handle
        try {
            System.out.print("Masukkan angka pertama: ");
            double a = input.nextDouble();

            System.out.print("Masukkan angka kedua: ");
            double b = input.nextDouble();

            System.out.print("Masukkan operator (+, -, *, /): ");
            char op = input.next().charAt(0);

            double result = calc.calculate(a, b, op);
            System.out.println("Hasil: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error Matematika: " + e.getMessage());
        } catch (InvalidOperatorException e) {
            System.out.println("Error Operator: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Input tidak valid.");
        } finally {
            input.close();
            System.out.println("Program selesai.");
        }
    }
}
