package FundamentalJava.OperatorLogika;

public class ShortCircuitVSNormalOperator {
    public static void main(String[] args) {

        /**
         * Di java operator logika && dan || itu pemalas atau lebih tepatnya effisien,
         * mereka pakai yg namanya short-circuit evaluation,
         * artinya mereka hanya mengevaluasi satu ekspresi saja yang sesuai dengan
         * hasilnya..
         *
         * ada operator lain, yaitu & dan | (tanpa double)
         * ini adalah operator "tidak pemalas" mereka selalu mengevaluasi kedua sisi
         * ekspresi.
         * terlepas dari hasil ekspresi pertamanya.
         *
         * ini sangat penting kalau ekspresi kedua punya efek samping (side effect),
         * seperti menambahkan nilai variabel.
         */

        int num1 = 7, num2 = 9, num3 = 20;
        int num4 = 107, num5 = 109, num6 = 120;

        System.out.println("--- Skenario 1: || vs | ---");
        System.out.println("Ekspresi: (num1 <= num2 || num2 == num3++");
        System.out.println("Hasil: " + (num1 <= num2 || num2 == num3++));
        System.out.println("num3 setelah operasi: " + num3);
        // num3 tetep 20 karena short-circuit

        num3 = 20; // reset nilai
        System.out.println("--- Skenario 2: (tanpa sort-circuit) ---");
        System.out.println("Ekspresi: (num1 <= num2 | num2 == num3++)");
        System.out.println("Hasil: " + (num1 <= num2 | num2 == num3++));
        System.out.println("num3 setelah operasi: " + num3);
        // num3 jadi 21 karena operasi ++ tetap dijalankan

        System.out.println("\n--- Skenario 3: && vs & ---");
        System.out.println("Ekspresi: (num4 >= num5 && 200 <= num5++)");
        System.out.println("Hasil: " + (num4 >= num5 && 200 <= num5++));
        System.out.println("num5 setelah operasi: " + num5);
        // num5 tetap 109 karena short-circuit

        num5 = 109; // reset nilai
        System.out.println("--- Skenario 4: & (tanpa short-circuit) ---");
        System.out.println("Ekspresi: (num4 >= num5 & 200 <= num5++)");
        System.out.println("Hasil: " + (num4 >= num5 & 200 <= num5++));
        System.out.println("num5 setelah operasi: " + num5);
        // num5 jadi 110 karena operasi ++ tetap dijalankan.

        // Kesimpulan
        // pengajaran ini menyarankan untuk konsisten menggunakan && dan || dan
        // menghindari menempatkan operasi yg punya
        // efek samping didalam ekspresi logika,
        // ini membuat kode lebih bersih dan mudah dibaca

    }
}
