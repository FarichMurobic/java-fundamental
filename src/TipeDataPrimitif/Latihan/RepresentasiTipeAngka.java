package TipeDataPrimitif.Latihan;

public class RepresentasiTipeAngka {
    public static void main(String[] args) {

        // --- Contoh Representasi Integer ---
        System.out.println("--- Contoh Representasi Integer ---");

        // Desimal (Default)
        int angkaDesimal = 71;
        System.out.println("Angka desimal (default 71): " + angkaDesimal); // Output: 71

        // Oktal (diawali dengan 0)
        int angkaOktal = 071; // Ini akan diinterpretasikan sebagai oktal
        System.out.println("Angka oktal (071): " + angkaOktal);       // Output: 57 (karena 071 basis 8 = 57 basis 10)

        // Heksadesimal (diawali dengan 0x atau 0X)
        int angkaHeksadesimal = 0X71; // Ini akan diinterpretasikan sebagai heksadesimal
        System.out.println("Angka heksadesimal (0X71): " + angkaHeksadesimal); // Output: 113 (karena 0X71 basis 16 = 113 basis 10)

        // Contoh long literal (angka besar yang butuh 8 byte)
        long angkaSangatBesar = 9876543210L; // Wajib pakai 'L' di akhir
        System.out.println("Angka long (9876543210L): " + angkaSangatBesar);

        System.out.println("\n"); // Baris kosong untuk pemisah output

        // --- Contoh Tipe Data Floating Point ---
        System.out.println("--- Contoh Tipe Data Floating Point ---");

        // double (default untuk angka desimal, presisi tinggi)
        double beratBadan = 65.75;
        System.out.println("Berat badan (double 65.75): " + beratBadan);

        double suhuRuangan = 25.0; // Bisa juga pakai .0 di akhir
        System.out.println("Suhu ruangan (double 25.0): " + suhuRuangan);

        double nilaiPi = 3.1415926535; // double bisa menampung lebih banyak digit presisi
        System.out.println("Nilai Pi (double): " + nilaiPi);

        // float (perlu ditandai dengan 'f' atau 'F', presisi lebih rendah)
        float hargaBarang = 19.99F; // Wajib pakai 'F' di akhir
        System.out.println("Harga barang (float 19.99F): " + hargaBarang);

        float jarak = 123.456789F; // Perhatikan, float punya presisi lebih terbatas
        System.out.println("Jarak (float): " + jarak);

        // Contoh penggunaan floating point dengan bagian integer/pecahan dihilangkan
        double hanyaPecahan = .123; // Sama dengan 0.123
        System.out.println("Hanya bagian pecahan (.123): " + hanyaPecahan);

        double hanyaInteger = 456.; // Sama dengan 456.0
        System.out.println("Hanya bagian integer (456.): " + hanyaInteger);

    }
}
