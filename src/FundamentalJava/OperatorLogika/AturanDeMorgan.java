package FundamentalJava.OperatorLogika;

/**
 * ------------------------------------------------------------------------
 * ATURAN DE MORGAN
 * ------------------------------------------------------------------------
 * 
 * Untuk ekspresi logika yang lebih kompleks, kita menggunakan Aturan De Morgan.
 * Aturan ini seperti sihir yang memindahkan operator ! (not) dari luar ke
 * dalam kurung, sambil membalikkan operator && (and) dan || (or).
 * 
 * Tujuan utama:
 * Mengubah logika negatif menjadi positif agar lebih mudah dibaca dan dipahami.
 * 
 * ------------------------------------------------------------------------
 * ATURAN 1
 * ------------------------------------------------------------------------
 * 
 * !(EkspresiSatu && EkspresiDua) sama dengan !(EkspresiSatu) || !(EkspresiDua)
 * 
 * Not (A and B) = (Not A) or (Not B)
 * 
 * Analogi:
 * "Bukan (kamu punya KTP dan SIM)"
 * Sama saja dengan:
 * "Kamu tidak punya KTP atau kamu tidak punya SIM"
 * 
 * Contoh kode:
 * 
 *     boolean punyaKTP = true;
 *     boolean punyaSIM = false;
 * 
 *     // Cara negatif (kurang jelas)
 *     boolean tidakBolehMengemudi1 = !(punyaKTP && punyaSIM);
 * 
 *     // Cara positif (lebih mudah dibaca) - menggunakan Aturan De Morgan
 *     boolean tidakBolehMengemudi2 = !punyaKTP || !punyaSIM;
 * 
 * ------------------------------------------------------------------------
 * ATURAN 2
 * ------------------------------------------------------------------------
 * 
 * !(Ekspresi1 || Ekspresi2) sama dengan !(Ekspresi1) && !(Ekspresi2)
 * 
 * Not (A or B) = (Not A) and (Not B)
 * 
 * Analogi:
 * "Bukan (kamu sudah makan atau kamu sudah mandi)"
 * Sama saja dengan:
 * "Kamu tidak makan dan kamu tidak mandi"
 * 
 * Contoh kode:
 * 
 *     boolean sudahMakan = true;
 *     boolean sudahMandi = false;
 * 
 *     // Cara negatif (kurang jelas)
 *     boolean belumSiap1 = !(sudahMakan || sudahMandi);
 * 
 *     // Cara positif (lebih mudah dibaca) - menggunakan Aturan De Morgan
 *     boolean belumSiap2 = !sudahMakan && !sudahMandi;
 * 
 * ------------------------------------------------------------------------
 * ATURAN DE MORGAN UNTUK OPERATOR RELASIONAL
 * ------------------------------------------------------------------------
 * 
 * Untuk mengubah logika negatif ke positif, cukup ganti operator
 * relasionalnya dengan kebalikannya.
 * 
 * Operator        | Kebalikannya
 * ----------------|-------------
 * ==              | !=
 * !=              | ==
 * >               | <=
 * >=              | <
 * <               | >=
 * <=              | >
 * 
 * Contoh:
 * 
 *     // Negatif (kurang jelas)
 *     boolean hasil1 = !(nilai > 10);
 * 
 *     // Positif (lebih jelas) - ubah > menjadi <=
 *     boolean hasil2 = nilai <= 10;
 * 
 *     // Negatif (kurang jelas)
 *     boolean hasil3 = !(nama.equals("Budi"));
 * 
 *     // Positif (lebih jelas)
 *     boolean hasil4 = !nama.equals("Budi");
 * 
 * ------------------------------------------------------------------------
 * CONTOH KOMPLEKS
 * ------------------------------------------------------------------------
 * 
 * Ekspresi kompleks dengan beberapa kondisi:
 * 
 *     // Kondisi awal (sulit dibaca)
 *     boolean bolehMasuk = !(umur >= 17 && (punyaKTP || punyaSIM));
 * 
 *     // Gunakan Aturan De Morgan step by step:
 *     // 1. !(A && (B || C))
 *     // 2. !A || !(B || C)
 *     // 3. !A || (!B && !C)
 * 
 *     boolean bolehMasuk2 = !(umur >= 17) || (!punyaKTP && !punyaSIM);
 * 
 *     // Sederhanakan lagi:
 *     boolean bolehMasuk3 = umur < 17 || (!punyaKTP && !punyaSIM);
 * 
 * ------------------------------------------------------------------------
 * KAPAN MENGGUNAKAN ATURAN DE MORGAN?
 * ------------------------------------------------------------------------
 * 
 * 1. Ketika kondisi logika terlihat rumit dan sulit dipahami
 * 2. Untuk menyederhanakan ekspresi boolean yang kompleks
 * 3. Untuk mengubah logika negatif menjadi positif (lebih natural)
 * 4. Saat melakukan refactoring kode agar lebih readable
 * 
 * ------------------------------------------------------------------------
 * KESIMPULAN INTI
 * ------------------------------------------------------------------------
 * 
 * Aturan De Morgan:
 * 
 * 1. !(A && B) = !A || !B
 * 2. !(A || B) = !A && !B
 * 
 * Intinya:
 * - Pindahkan ! ke dalam
 * - Balik && menjadi ||
 * - Balik || menjadi &&
 * 
 * Manfaat:
 * - Kode lebih mudah dibaca
 * - Logika lebih natural
 * - Mengurangi kebingungan
 * 
 * ------------------------------------------------------------------------
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
