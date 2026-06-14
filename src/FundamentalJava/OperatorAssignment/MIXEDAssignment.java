package FundamentalJava.OperatorAssignment;

public class MIXEDAssignment {
    public static void main(String[] args) {

        System.out.println("--- Demo Operator Penugasan Gabungan ---");

        // --- Contoh 1: Penjumlahan (+=) ---
        int totalScore = 100;
        int bonusPoints = 25;
        System.out.println("Total Score awal: " + totalScore); // 100

        // totalScore = totalScore + bonusPoints; (Versi panjang)
        totalScore += bonusPoints; // Setara dengan totalScore = 100 + 25;
        System.out.println("Total Score setelah += bonusPoints: " + totalScore); // 125
        System.out.println("--------------------\n");

        // --- Contoh 2: Pengurangan (-=) ---
        int stockAvailable = 50;
        int itemsSold = 10;
        System.out.println("Stock Available awal: " + stockAvailable); // 50

        // stockAvailable = stockAvailable - itemsSold; (Versi panjang)
        stockAvailable -= itemsSold; // Setara dengan stockAvailable = 50 - 10;
        System.out.println("Stock Available setelah -= itemsSold: " + stockAvailable); // 40
        System.out.println("--------------------\n");

        // --- Contoh 3: Perkalian (*=) ---
        double currentSalary = 5000.0;
        double raisePercentage = 0.10; // 10%
        System.out.println("Current Salary awal: " + currentSalary); // 5000.0

        // currentSalary = currentSalary * (1 + raisePercentage); (Versi panjang)
        // Kita bisa gabungkan operasi matematika kompleks di sisi kanan
        currentSalary *= (1 + raisePercentage); // Setara dengan currentSalary = 5000.0 * (1 + 0.10);
        System.out.println("Current Salary setelah *= (1 + raisePercentage): " + currentSalary); // 5500.0
        System.out.println("--------------------\n");

        // --- Contoh 4: Pembagian (/=) ---
        double priceWithTax = 120.0;
        double taxRate = 1.20; // Jika harga asli = priceWithTax / 1.20
        System.out.println("Price With Tax awal: " + priceWithTax); // 120.0

        // priceWithTax = priceWithTax / taxRate; (Versi panjang)
        priceWithTax /= taxRate; // Setara dengan priceWithTax = 120.0 / 1.20;
        System.out.println("Price With Tax setelah /= taxRate: " + priceWithTax); // 100.0
        System.out.println("--------------------\n");

        // --- Contoh 5: Modulo (%=) ---
        int totalMinutes = 150;
        int minutesInHour = 60;
        System.out.println("Total Minutes awal: " + totalMinutes); // 150

        // totalMinutes = totalMinutes % minutesInHour; (Versi panjang)
        totalMinutes %= minutesInHour; // Setara dengan totalMinutes = 150 % 60; (Sisa bagi)
        System.out.println("Total Minutes setelah %= minutesInHour: " + totalMinutes); // 30
        System.out.println("--------------------\n");

        // --- Contoh 6: Konkatenasi String (+=) ---
        String greeting = "Hello ";
        String recipient = "World";
        System.out.println("Greeting awal: \"" + greeting + "\""); // "Hello "

        // greeting = greeting + recipient + "!"; (Versi panjang)
        greeting += recipient + "!"; // Setara dengan greeting = "Hello " + "World" + "!";
        System.out.println("Greeting setelah += recipient + \"!\": \"" + greeting + "\""); // "Hello World!"
        System.out.println("--------------------\n");

        // --- Good Programming Practice: Fokus pada += dan -= ---
        System.out.println("--- Good Programming Practice ---");
        System.out.println("Meskipun semua operator biner bisa digabungkan,");
        System.out.println(" += dan -= adalah yang paling sering direkomendasikan");
        System.out.println("karena paling mudah dibaca dan dipahami.\n");

    }
}
