package Casting;

public class ExplicitCasting {
    public static void main(String[] args) {

        System.out.println("--- Demo Konversi Tipe Data Eksplisit ---");

        // --- Skenario 1: Mengatasi 'possible loss of precision' ---
        double totalArea = 2586.24;
        int minimumRoomArea = 120;
        int numberOfRoomsPossible;

        // Tanpa casting, baris di bawah akan menyebabkan error kompilasi:
        // numberOfRoomsPossible = totalArea / minimumRoomArea;

        // Menggunakan casting untuk mengonversi hasil double ke int
        // Hasil pembagian (21.552) akan DIPOTONG menjadi 21
        numberOfRoomsPossible = (int) (totalArea / minimumRoomArea);
        System.out.println("Total Area: " + totalArea);
        System.out.println("Minimum Room Area: " + minimumRoomArea);
        System.out.println("Jumlah Ruangan yang Mungkin (setelah cast): " + numberOfRoomsPossible);
        System.out.println("  (Perhatikan: 21.552 dipotong menjadi 21)\n");

        // --- Skenario 2: Casting Literal ---
        System.out.println("--- Casting Literal ---");
        System.out.println("(int)(1000.9999) hasilnya: " + (int)(1000.9999)); // Dibuang desimal
        System.out.println("(int)(1000.0000) hasilnya: " + (int)(1000.0000)); // Dibuang desimal
        System.out.println("(double)(267) hasilnya: " + (double)(267));       // int dipromosikan ke double
        System.out.println("(double)(150-84) hasilnya: " + (double)(150-84)); // Ekspresi dihitung dulu, lalu di-cast
        System.out.println("(double)(151) % 2 hasilnya: " + ((double)(151) % 2)); // 151.0 % 2 = 1.0
        System.out.println("(double)(151 % 2) hasilnya: " + (double)(151 % 2)); // 151%2=1, lalu (double)1 = 1.0
        System.out.println("(double)(151)/2 hasilnya: " + (double)(151)/2);     // 151.0/2 = 75.5
        System.out.println("(double)(151/2) hasilnya: " + (double)(151/2));     // 151/2 (int div) = 75, lalu (double)75 = 75.0
        System.out.println("\n");

        // --- Skenario 3: Casting Variabel dan Ekspresi ---
        System.out.println("--- Casting Variabel dan Ekspresi ---");
        int a = 7, b = 10;
        double c = 4.25, d = 5.80;

        System.out.println("int a = " + a + ", b = " + b);
        System.out.println("double c = " + c + ", d = " + d);

        System.out.println("(double)(b/a) hasilnya: " + (double)(b/a));       // (10/7) = 1 (int), lalu di-cast jadi 1.0
        System.out.println("(int)(c) + (int)(d) hasilnya: " + ((int)(c) + (int)(d))); // (int)4.25=4, (int)5.80=5. Lalu 4+5=9
        System.out.println("(int)(c + d) hasilnya: " + (int)(c + d));         // (4.25+5.80)=10.05, lalu di-cast jadi 10
        System.out.println("(double)(a/b) + c hasilnya: " + ((double)(a/b) + c)); // (7/10)=0 (int), lalu di-cast jadi 0.0. Lalu 0.0 + 4.25 = 4.25
        System.out.println("(double)(a)/b + d hasilnya: " + ((double)(a)/b + d)); // (double)7=7.0. Lalu 7.0/10 (promosi 10 jadi 10.0) = 0.7. Lalu 0.7 + 5.80 = 6.50
        System.out.println("\n");

        // --- Skenario 4: Casting antara char dan int ---
        System.out.println("--- Casting antara char dan int ---");
        char charJ = 'J';
        char char0 = '0'; // Karakter '0' (bukan angka 0)

        // char otomatis dipromosikan ke int dalam operasi aritmatika
        System.out.println("(int)('J') hasilnya: " + (int)('J')); // Kode ASCII/Unicode untuk 'J'
        System.out.println("(int)('0') hasilnya: " + (int)('0')); // Kode ASCII/Unicode untuk '0'
        System.out.println("(int)('J') + (int)('0') hasilnya: " + ((int)('J') + (int)('0'))); // 74 + 48 = 122
        System.out.println("'J' + '0' (tanpa cast eksplisit) hasilnya: " + ('J' + '0')); // Hasilnya tetap 122 karena promosi otomatis

        // Harus menggunakan cast saat mengonversi int kembali ke char
        System.out.println("(char)(74) hasilnya: " + (char)(74)); // Mengonversi 74 kembali ke karakter
        System.out.println("(char)(48) hasilnya: " + (char)(48)); // Mengonversi 48 kembali ke karakter
        System.out.println("\n");

        // --- Self-Check Jawaban dalam Kode ---
        System.out.println("--- Self-Check ---");
        // Self-Check 41: Apa itu (char)(65)?
        System.out.println("Self-Check 41: (char)(65) adalah: " + (char)(65)); // Output: A

        // Self-Check 42: True or false: Cast operation can convert "123" to 123.
        // False. Untuk String ke int/double, gunakan Integer.parseInt() atau Double.parseDouble()
        // int numFromString = (int)"123"; // Ini akan ERROR kompilasi
        System.out.println("Self-Check 42: Mengonversi String \"123\" ke int 123 dengan cast? FALSE.");
        System.out.println("  (Harusnya menggunakan Integer.parseInt(\"123\") -> " + Integer.parseInt("123") + ")");

    }
}
