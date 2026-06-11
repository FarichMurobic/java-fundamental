package Rekursion.Latihan;

public class Latihan1 {
    // faktorial pake rekursi
    static int faktorialRekursive(int n) {
        if (n == 0)
            return 1;
        return n * faktorialRekursive(n - 1);
    }

    // faktorial pake for
    static int faktorialFor(int n) {
        int hasil = 1;
        for (int i = 1; i <= n; i++) {
            hasil *= i;
        }
        return hasil;
    }

    public static void main(String[] args) {

        int angka = 0;
        int hasil = faktorialRekursive(angka);
        System.out.println(hasil);

        int angka1 = 0;
        int hasil1 = faktorialFor(angka1);
        System.out.println(hasil1);

    }
}
