package StructurePerulangann;

public class WhileLOOP {
    public static void main(String[] args) {

        /**
         * while
         * 
         * while adalah loop paling dasar di Java.
         * Loop ini akan mengulang sebuah statement atau blok kode selama kondisi bernilai true.
         * 
         * Bentuk umum while:
         * while(condition) {
         *     // isi loop
         * }
         *
         * Penjelasan:
         * condition → ekspresi boolean (true atau false)
         * Selama kondisi true, kode di dalam loop akan terus dijalankan
         * Kalau kondisi false, program langsung lanjut ke kode setelah loop
         * Kalau hanya 1 baris statement, { } sebenarnya tidak wajib.
         *
         * Bayangin while seperti ini:
         * "Selama kondisi benar, lakukan sesuatu."
         *
         * Hal Penting: while mengecek kondisi di AWAL
         * while selalu cek kondisi dulu sebelum menjalankan loop.
         *
         * Konsep Menarik: Loop Tanpa Body
         * Di Java, loop boleh kosong.
         *
         * Contoh dari buku:
         * while(++i < --j);
         * Perhatikan:
         * ;   ← ini body kosong
         * Artinya loop tidak menjalankan kode apa pun.
         * Semua kerja terjadi di condition.
         *
         * Infinite Loop
         * Kalau kondisi selalu true, loop tidak akan berhenti.
         *
         * while = loop yang berjalan selama kondisi true.
         * Urutan kerja:
         * 1 cek kondisi
         * 2 kalau true → jalankan code
         * 3 ulang lagi
         * 4 kalau false → keluar loop
         */

        // Contoh sederhana
        int n = 10;
        while (n > 0) {
            System.out.println("tick" + n);
            n--;
        }

        /**
         * Output
         * tick10
         * tick9
         * tick8
         * tick7
         * tick6
         * tick5
         * tick4
         * tick3
         * tick2
         * tick1
         *
         * Cara kerjanya:
         * Awalnya
         * n = 10
         * Loop berjalan selama
         * n > 0
         * Setiap loop:
         * print "tick"
         * nilai n dikurangi 1
         */

        // while mengecek kondisi di AWAL
        int a = 10, b = 20;
        while (a > b) { // kondisi false
            System.out.println("Ini tidak akan di proses, karena kondisi false.");
        }

        /**
         * Cek kondisi:
         * 10 > 20 ?
         * false
         * Karena langsung false, loop tidak pernah dijalankan.
         * Output:
         * (tidak ada)
         */

        // Konsep Menarik: Loop Tanpa Body
        int i = 100;
        int j = 200;

        while (++i < --j);
        System.out.println("Midpoint is " + i);

        /**
         * Tujuannya mencari titik tengah antara 100 dan 200.
         *
         * Prosesnya:
         * i naik terus
         * j turun terus
         * Sampai:
         * i = 150
         * j = 150
         *
         * Output:
         * Midpoint is 150
         */

    }
}
