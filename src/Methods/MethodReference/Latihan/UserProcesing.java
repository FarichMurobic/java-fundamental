package Methods.MethodReference.Latihan;

/**
 * Kasus:
 * Ada data user
 * Filter user aktif
 * Ambil nama
 * Ubah ke uppercase
 * Print
 */

import java.util.List;
import java.util.stream.Collectors;

// Entity / Model (mirip di Spring Boot)
class User {
    private String nama;
    private boolean active;

    public User(String nama, boolean active) {
        this.nama = nama;
        this.active = active;
    }

    // Getter
    public String getNama() {
        return nama;
    }

    // Getter
    public boolean isActive() {
        return active;
    }
}

public class UserProcesing {
    public static void main(String[] args) {

        // data biasanya dari database
        List<User> users = List.of(
                new User("andi", true),
                new User("budi",false),
                new User("caca", true),
                new User("dedi", false)
        );

        // PROCESSING DATA (REAL STYLE)
        List<String> result = users.stream()
                // Filter user aktif
                // Instance Methode reference objek type
                .filter(User::isActive)
                // Ambil nama
                // Instance Methode reference objek type
                .map(User::getNama)
                // Uppercase
                // Instance Methode reference class type
                .map(String::toUpperCase)
                // Collect ke List
                // Instance Methode reference class type
                .collect(Collectors.toList());

        // Print hasil
        result.forEach(System.out::println);

    }
}
