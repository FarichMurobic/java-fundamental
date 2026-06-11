package OperatorLogika;

/**
         * Aturan de morgan
         * untuk ekspresi logika yang lebih kompleks, kita pakai aturan de morgan.
         * aturan ini seperti sihir yan memindahkan operator ! dari luar ke dalam kurung, sambil membalikkan operator && dan ||.
         *
         * aturan 1
         * !(EksperrsiSatu && EkspresiDua) itu sama dengan !(EkspresiSatu) || !(EkspresiDua).
         * analogi, "Bukan (lo punya ktp dan sim)" itu sama aja dengan lo tidak punya ktp atau lo tidak punya sim.
         *
         * aturan 2
         * !(Ekspresi1 || Ekspresi2) itu sama dengan !(Ekspresi1) && !(Ekspresi2).
         * analogi, "Bukan (lo udah makan atau lo udah mandi). itu sama aja dengan "lo tidak makan dan lo tidak mandi"
         *
         * intinya mengubah logka negatif menjadi positif agar lebih mudah dibaca.
         * untuk mengubah logika negatid ke positif, cukup ganti operator relasionalnya dengan kebalikannya. ini dikenal sebagai aturan de morgan.
         */

        /**
         * Aturan pelengkap operator relasional, ini adalah pelengkap atau komplemen mengubah opeator menjadi pasangannya.
         * <    -   >=      contoh !(number1 < 7)   =   (number1 >= 7)
         * <=   -   >       contoh !(number1 <= 7)  =   (number1 > 7)
         * >    -   <=      contoh !(number1 > 7)   =   (number1 <= 7)
         * >=   -   <       contoh !(number1 >= 7)  =   (number1 < 7)
         * ==   -   !=      contoh !(number1 == 7)  =   (number1 != 7)
         * !=   -   ==      contoh !(number1 == 7)  =   (number1 == 7)
         *
         * Analogi: kalau lu bilang "Bukan(umur lu dibawah 17) itu sama aja lu bilang
         * "umur lu lebih dari atau sama dengan 17" ini lebih mudah dipahami kan.
         */

import java.util.Scanner;

public class AturanDeMorgan {
    public static void main(String[] args) {
        
        // penerapan kode: validator kata sandi

        Scanner input = new Scanner(System.in);

        System.out.println("--- Pendaftaran Akun Baru ---");
        System.out.println("Syarat kata sandi: ");
        System.out.println("1, Minimal 8 karakter");
        System.out.println("2, Mengandung huruf kapital");
        System.out.println("3, Tidak ada spasi");
        System.out.println("------------------------------");

        System.out.print("Masukkan kata sandi baru: ");
        String password = input.nextLine();

        // Logika positif (cara yang direkomendasikan)
        // Kita mendefinisikan kondisi yang harus benar

        boolean isLongEnough = password.length() >= 8;
        boolean hasUpperCase = !password.equals(password.toLowerCase()); // password mengecek apakah ada huruf kapital
        boolean noSpace = !password.contains(" ");

        System.out.println("\n--- Pengecekan dengan Logika Positif (jelas dan langsung) ---");
        if (isLongEnough && hasUpperCase && noSpace) {
            System.out.println("Kata sandi **valid**! Akun anda berhasil dibuat.");
        } else {
            System.out.println("Kata sandi **tidak valid**! Silakan coba lagi.");
        }

        // Logika negatif (kurang direkomendasikan & sulit dibaca)
        // kita mendefinisikan kondisi yang menyebabkan error
        // !(isLongEnough && hasUpperCase && noSpace)
        // setelah diubah dengan aturan de morgan, ini sama dengan
        // (!isLongEnough || !hasUpperCase || !noSpace)
        boolean isToShort = password.length() < 8;
        boolean noUpperCase = password.equals(password.toLowerCase());
        boolean hasSpace = password.contains(" ");

        System.out.println("\n--- Pengecekan dengan Logika Negatif (Memutar dan Bingung) ---");
        if (isToShort || noUpperCase || hasSpace) {
            System.out.println("Kata sandi **tidak valid**! Silakan coba lagi.");
            // kode disini bisa dipakai untuk nunjukin error spesifiknya
            if (isToShort)
                System.out.println("  -Error: Kata sandi terlalu pendek.");
            if (noUpperCase)
                System.out.println("  -Error: Kata sandi tidak ada huruf kapital.");
            if (hasSpace)
                System.out.println("  -Error: ada spasi.");
        } else {
            System.out.println("Kata sandi valid. Akun Anda berhasil dibuat.");
        }

        input.close();

    }
}
