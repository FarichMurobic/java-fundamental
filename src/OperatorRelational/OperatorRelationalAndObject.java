package OperatorRelational;

/**
 * Operator perbandingan dan objek
 * saat membandingkan objek, situasinya beda banget dari membandingkan angka dan karakter.
 * gad ada urutab yg pasti, kita harus menentukan sendiri, berdasarkan kebutuhan aplikasi.
 *
 * setiap perbandingan punya tujuannya sendiri
 * kita juga bisa menggunakan operator == dan != pada objek, tapi disini ada jebakan.
 * saat kita pakai == untuk membandingkan itu bukan isinya, tapi alamat memori atau lokasi dari kedua objek tersebut.
 *
 * kasus khusus Sting. string adalah sebuah objek jadi kalo mau ngebandingin pakai ==
 * hasilnya bisa gak sesuai harapan.
 * yg benar adalah pakai metode khusus. menggunakan .equals()
 *
 * Mengurutkan String secara leksikografi
 * leksikografi artinya adalah urutan kata seperti dikamus.
 * Contoh :
 * kata lake dan kata like, kata lake muncul lebih awal karena nilai huruf kedua a lebih kecil dari huruf i.
 * cara komputer mengurutkannya mirip dengan cara kita mencari di kamus.
 *
 * -dibandingkan karakter per karakter - program akan membandingkan string dari karakter pertama
 * -mencari perbedaan pertama - begitu ada karakter yg berbeda, perbandingan langsung berhenti.
 * urutan dari karakter yg berbeda itulah yg menentukan urutan string-nya.
 *
 * Jika salah satu string lebih pendek
 * kalau dua string cocok sampai salah satunya habis, string yg lebih pendek dianggap lebih kecil.
 * contoh :
 * live dan liver, karena live lebih pendek maka live lebih kecil.
 *
 * Metode perbandingan string
 * di java kita gak bisa pakai operator relasional (<,>) untuk string, kita harus pakai method kusus yg ada di kelas string.
 * dua metode yg paling sering dipakai adalah.
 * strOne.equals(strTwo) - metode ini mengembalikan nilai boolean (true atau false)
 * strOne.compareTo(strTwo) - metode ini mengembalikan nilai integer (angka)
 */

import java.util.Scanner;

public class OperatorRelationalAndObject {
    public static void main(String[] args) {

        String s1 = "Hello";
        String s2 = "Dunia";
        System.out.println(s1 == s2); // hasilnya bisa sesuai dan gak sesuai.

        // Alih-alih menggunakan seperti tadi mending pakai .equals() metode khusus string
        System.out.println(s1.equals(s2));

        String strOne = "America the beautiful";
        String strTwo = "America the beautiful!";
        String strThree = "Maple leaf";
        String strFour = "Maple Leaf";
        String strFive = "Maple Leaf";

        System.out.println("strOne.equals(strTwo) is " + strOne.equals(strTwo));
        // false, karena strtwo punya tanda seru !
        System.out.println("strOne.compareTo(strTwo) is " + strOne.compareTo(strTwo));
        // -1, karena strone tanpa !, lebih kecil dari strtwo
        System.out.println("strTwo.equals(strOne) is " + strTwo.equals(strOne));
        // false, karena ada perbedaan tanda seru
        System.out.println("strTwo.compareTo(strOne) is " + strTwo.compareTo(strOne));
        // 1, karena strtwo ada ! nilainya lebih besar dari strone
        System.out.println("strThree.equals(strFour) is " + strThree.equals(strFour));
        // false, karena ada perbedaan huruf besar leaf dan Leaf
        System.out.println("strThree.compareTo(strFour) is " + strThree.compareTo(strFour));
        // 32, karena kode karakter spasi adalah 32, dan kode karakter huruf besar dan kecil juga memiliki selisih 32
        System.out.println("strThree.equals((\"Maple leaf\") is " + strThree.equals(("Maple leaf")));
        // true, karena isi string nya sama persis
        System.out.println("strFour.compareTo(strFive) is " + strFour.compareTo(strFive));
        // 0, karena strfour dan strfive isinya sama persis.

        System.out.println("--------------------\n");

        // Point penting
        // kenapa kita gak bisa pakai == buat string karena operator ini hanya membandingkan alamat referensi objek,
        // compareTo untuk membandingkan isinya string bukan sekedar alamat referensinya saja.

        // LATIHAN - program sederhana untuk mengecek kelayakan penonton film
        Scanner input = new Scanner(System.in);
        // Informasi film yang akan di tonton
        String movieTittle = "Avengers: Endgame";
        int movieRatingAge = 13; // Rating film: PG-13

        System.out.println("Selamat datang di bioskop!");
        System.out.println("Film yang anda pilih: " + movieTittle);
        System.out.println("Rating usia: " + movieRatingAge + " tahun ke atas.");
        System.out.println("----------------------");

        // meminta input usia penonton
        System.out.print("Masukkan usia Anda: ");
        int userAge = input.nextInt();

        // meminta persetujuan syarat dan ketentuan? (true/false): ";
        System.out.print("Apakah anda setuju dengan syarat & ketentuan? (true/false): ");
        boolean isAcceptedTerms = input.nextBoolean();

        // variabel untuk menyimpan hasil pengecekan film
        String selectedMovie = "Avengers: Endgame";

        // logic pengambilan keputusan
        // kita gunakan operator relational dan logika untuk membuat keputusan
        // syaratnya usia penonton >= rating usia dan menyetujui syarat dan judul film sama.
        if (userAge >= movieRatingAge && isAcceptedTerms && selectedMovie.equals(movieTittle)) {
            // blok kode ini dijalankan jika semua kondisi diatas benar
            System.out.println("\n----------------------------------");
            System.out.println("Selamat! Anda diperbolehkan menonton film '" + movieTittle + "'.");
            System.out.println("Silakan masuk.");
        } else { // blok kode ini dijalankan jika satu kondisi di atas ada yg salah
            System.out.println("\n----------------------------------");
            System.out.println("Maaf, Anda tidak memenuhi syarat untuk menonton film ini.");
            System.out.println("Mohon periksa kembali usia atau persetujuan Anda");
        }

        input.close();

    }
}
