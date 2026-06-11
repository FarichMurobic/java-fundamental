package OperatorTernary;

import java.util.Scanner;

public class Ternary {
    public static void main(String[] args) {

        /**
         * Operator ternary adalah operator kondisional sederhana yang berfungsi sebagai alternatif dari if-else.
         * Bentuk umum:
         * variabel = (kondisi) ? nilai_jika_true : nilai_jika_false;
         * Jika kondisi bernilai true, maka ekspresi akan menghasilkan nilai_jika_true.
         * Jika kondisi bernilai false, maka ekspresi akan menghasilkan nilai_jika_false.
         *
         * Ini adalah jalan pintas untuk if else yang sangat sederhana, gunakan disaat menetapkan salah satu dari dua nilai ke sebuah variabel.
         * tergantung pada sebuah kondisi.
         */

        // Demonstrate ?.
        int i, k;
        i = 10;
        k = i < 0 ? -i : i; // get absolute value of i
        System.out.print("Absolute value of ");
        System.out.println(i + " is " + k);

        i = -10;
        k = i < 0 ? -i : i; // get absolute value of i
        System.out.print("Absolute value of ");
        System.out.println(i + " is " + k);

        i = -100;
        k = i < 0 ? i : -i;
        System.out.println("The value real of i is " + k);

        // Ternary with char
        char char1 = 'F';
        char char2 = 'f';
        boolean perbandingan = char1 > char2 ? true : false;
        System.out.println("Apakah karakter F lebih besar dari karakter f ? " + perbandingan);
        System.out.println((int) (char1) + " " + (int) (char2));

        // Ternary with boolean
        boolean hujan = true;
        boolean ramalan = hujan == true ? true : false;
        System.out.println("Apakah hari ini hujan ? " + ramalan);

        // Ternary with String
        String sapaan = "Haloo";
        String hasilSapaan = sapaan.equalsIgnoreCase("Haloo") ? "Benar" : "Berbeda";
        System.out.println(hasilSapaan);
        hasilSapaan = sapaan.equals("Heloo") ? "Benar" : sapaan.replace('a', 'e');
        System.out.println(hasilSapaan);

        System.out.println();

        // Menentukan Bilangan ganjil atau genap
        int angkaSatu = 10;
        String hasilSatu = (angkaSatu % 2 == 0) ? "Genap" : "Ganjil";
        System.out.println(hasilSatu);

        // Menentukan Bilangan Positif atau Negatif
        int angkaDua = -5;
        String hasilDua = (angkaDua >= 0) ? "Positif" : "Negatif";
        System.out.println(hasilDua);

        // Menentukan Nilai Maksimum
        int angkaTiga = 10, iniB = 20;
        int maksimum = (angkaTiga > iniB) ? angkaTiga : iniB;
        System.out.println("Nilai maksimum: " + maksimum);

        // Menentukan Kelulusan
        int nilai = 75;
        String status = (nilai >= 70) ? "Lulus" : "Tidak Lulus";
        System.out.println("Status: " + status);

        // Menggunakan Operator Ternary Bersarang (Nested)
        int nilai1 = 85;
        String hasilNilai = (nilai1 >= 90) ? "A" : (nilai1 >= 80) ? "B" : (nilai1 >= 70) ? "C" : "D";
        System.out.println("Grade: " + hasilNilai);

        System.out.println("-----------------------------\n");

        // contoh latihan
        Scanner input = new Scanner(System.in);

        System.out.print("Masukan sebuah angka: ");
        System.out.flush();
        int numInput = input.nextInt();
        String hasilNya = (numInput > 0) ? "Positif" : (numInput < 0) ? "Negatif" : "Nol";
        System.out.println("Angka tersebut adalah: " + hasilNya);

        System.out.println("-----------------------------\n");

        // latihan again broo
        Scanner inputLagi = new Scanner(System.in);
        System.out.print("Masukkan usia Anda: ");
        System.out.flush();
        int usia = inputLagi.nextInt();
        String kategoriUsia = (usia < 13) ? "Anak-anak" : (usia < 18) ? "Remaja" : (usia > 18) ? "Dewasa" : "Lansia";
        System.out.println("Kategori Usia Anda adalah: " + kategoriUsia);

        input.close();

    }
}
