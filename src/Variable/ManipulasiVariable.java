package Variable;

/**
 * Mengubah Nilai Variabel
 * Di Java, kamu bisa mengubah nilai sebuah variabel melalui dua cara utama:
 * 1. Pernyataan Penugasan (Assignment Statement)
 * 2. Operator Increment atau Decrement (akan dibahas nanti)
 *
 * Dalam sebuah pernyataan penugasan, ekspresi di sisi kanan dievaluasi terlebih dahulu,
 * dan kemudian nilai yang dihitung disimpan di variabel di sisi kiri.
 * Oleh karena itu, dalam pernyataan penugasan, nilai ekspresi di sisi kanan
 * dan tipe data variabel di sisi kiri harus cocok dalam tipe data.
 */

public class ManipulasiVariable {
    public static void main(String[] args) {

        System.out.println("--- Demo Pernyataan Penugasan Sederhana ---");

        // Deklarasi beberapa variabel
        char grade;
        double currentScore;
        double totalScore = 0.0; // Inisialisasi awal
        int hoursWorked;
        double hourlyRate;
        double weeklySalary;
        String fullName;
        char status;

        // Penugasan nilai ke variabel
        grade = 'A'; // Menugaskan karakter 'A' ke variabel char 'grade'
        System.out.println("Nilai grade: " + grade);

        currentScore = 30.0; // Menugaskan nilai double
        System.out.println("Nilai currentScore: " + currentScore);

        totalScore = 95.7; // Mengubah nilai totalScore
        System.out.println("Nilai totalScore: " + totalScore);

        // Contoh ekspresi di sisi kanan
        hoursWorked = 5 * 8 - 3; // Ekspresi aritmatika dievaluasi dulu (37)
        System.out.println("Jam Kerja (hoursWorked): " + hoursWorked);

        hourlyRate = 16.75; // Penugasan double
        System.out.println("Tarif Per Jam (hourlyRate): " + hourlyRate);

        weeklySalary = hourlyRate * hoursWorked; // Hasil perkalian ditugaskan
        System.out.println("Gaji Mingguan (weeklySalary): " + weeklySalary);

        status = 'S'; // Penugasan karakter
        System.out.println("Status Karyawan (status): " + status);

        fullName = "James F. Kirk"; // Penugasan String
        System.out.println("Nama Lengkap (fullName): " + fullName);

        System.out.println("\n--- Demo Perubahan Nilai Variabel ---");

        int k = 10;
        System.out.println("Nilai k awal: " + k);

        k = k + 1; // Mengambil nilai k (10), menambah 1, lalu menyimpan kembali (11)
        System.out.println("Nilai k setelah k = k + 1: " + k); // Output: 11

        k = 5 * k - 2; // Mengambil nilai k (11), hitung 5*11 - 2 = 53, lalu simpan kembali
        System.out.println("Nilai k setelah k = 5 * k - 2: " + k); // Output: 53

        System.out.println("\n--- Demo Kecocokan Tipe Data (Promosi dan Error) ---");

        int intVar;
        double doubleVar;
        float floatVar;

        // Contoh promosi tipe data (aman)
        intVar = 37; // int ke int (cocok)
        doubleVar = 37; // int ke double (int dipromosikan ke double)
        System.out.println("doubleVar = 37 -> " + doubleVar); // Output: 37.0

        doubleVar = 12.5F; // float ke double (float dipromosikan ke double)
        System.out.println("doubleVar = 12.5F -> " + doubleVar); // Output: 12.5

        // Contoh 'possible loss of precision' (akan error jika di-uncomment)
        // intVar = 12.5F; // Error: possible loss of precision (float ke int)
        // intVar = 56.8;  // Error: possible loss of precision (double ke int)
        // Untuk mengatasinya, gunakan casting:
        intVar = (int) 12.5F; // Hasilnya 12 (kehilangan desimal)
        System.out.println("intVar = (int)12.5F -> " + intVar);

        // Contoh 'incompatible types' (akan error jika di-uncomment)
        // boolean boolVar;
        // boolVar = "True"; // Error: incompatible types (String ke boolean)
        // String strVar;
        // strVar = 123; // Error: incompatible types (int ke String)

        System.out.println("\n--- Demo Penugasan Berantai (Right to Left Associativity) ---");

        int a, b, c, d;
        d = 100;

        // Penugasan berantai: d ditugaskan ke c, hasilnya ditugaskan ke b, hasilnya ditugaskan ke a
        a = b = c = d;
        System.out.println("Setelah a = b = c = d;");
        System.out.println("Nilai a: " + a); // Output: 100
        System.out.println("Nilai b: " + b); // Output: 100
        System.out.println("Nilai c: " + c); // Output: 100
        System.out.println("Nilai d: " + d); // Output: 100

        System.out.println("\n--- Self-Check (Jawaban dalam Kode) ---");

        // Self-Check 31:
        int x = 10;
        int y = 20;
        System.out.println("Self-Check 31 - Awal: x = " + x + ", y = " + y);
        x = y; // Nilai y (20) ditugaskan ke x
        System.out.println("Self-Check 31 - Setelah x = y: x = " + x + ", y = " + y); // x=20, y=20

        // Self-Check 32:
        x = 10; // Menginisialisasi ulang x dan y untuk soal ini
        y = 20;
        System.out.println("Self-Check 32 - Awal: x = " + x + ", y = " + y);
        // Mengubah nilai x menjadi dua kali nilai x saat ini ditambah tiga kali nilai y saat ini
        x = 2 * x + 3 * y; // Evaluasi: 2 * 10 + 3 * 20 = 20 + 60 = 80
        System.out.println("Self-Check 32 - Setelah perhitungan: x = " + x + ", y = " + y); // x=80, y=20

    }
}
