package SimpleProjects.ValidasiData.ValidasiSederhana;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            try {
                System.out.println("--- Registrasi User ---");

                System.out.print("Masukkan Username: ");
                String userName = input.nextLine();
                UserValidator.validatorUserName(userName);

                System.out.print("Masukkan Usia: ");
                int age = input.nextInt();
                input.nextLine(); // buang new line
                UserValidator.validateAge(age);

                System.out.print("Masukkan Password: ");
                String password = input.nextLine();
                UserValidator.validatePassword(password);

                // kalau kamu lolos
                System.out.println("\nRegistrasi Berhasil!");
                System.out.println("Username: " + userName);
                System.out.println("Umur: " + age);

                running = false; // keluar loop

            } catch (InvalidUsernameException e) {
                System.out.println("Error Username: " + e.getMessage());
            } catch (InvalidAgeException e) {
                System.out.println("Error Umur: " + e.getMessage());
            } catch (WeakPasswordException e) {
                System.out.println("Error Password: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Input tidak valid!");
                input.nextLine(); // penting banget clear buffer
            }
        }

        input.close();
        System.out.println("Program Selesai.");

    }
}
