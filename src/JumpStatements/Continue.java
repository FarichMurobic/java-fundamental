package JumpStatements;

public class Continue {
    public static void main(String[] args) {
        
        /**
         * Menggunakan continue
         *
         * Kadang kita ingin loop tetap berjalan, tetapi menghentikan sisa kode di iterasi saat ini.
         * Artinya:
         * loop tidak berhenti
         * tetapi sisa kode dalam loop dilewati
         * loop langsung lanjut ke iterasi berikutnya
         * Statement continue melakukan hal tersebut.
         *
         * Perbedaannya tergantung jenis loop:
         * Pada while dan do-while
         * Ketika continue dijalankan:
         * program langsung kembali ke pengecekan kondisi loop.
         *
         * Pada for
         * Ketika continue dijalankan:
         * program pergi ke bagian iterasi (i++)
         * lalu mengecek kondisi loop
         * Semua kode setelah continue dilewati.
         *
         * Penggunaan continue yang bagus cukup jarang.
         *
         * Kenapa?
         * Karena Java sudah punya banyak jenis loop yang biasanya sudah cukup.
         * Tetapi continue tetap berguna saat kita ingin:
         * skip data tertentu
         *
         * Contoh:
         * melewati angka negatif
         * melewati data invalid
         * skip item tertentu di list
         *
         * -----------------------------
         * 
         * Kesimpulan penting
         *
         * continue artinya:
         * skip sisa kode di iterasi ini
         * lanjut iterasi berikutnya
         */

        // Contoh sederhana
        for(int i=0;i<5;i++){
            if(i==2) // ketika i = 2
                continue; // lanjutkan ke iterasi berikutnya

            System.out.println(i); // ketika i tidak sama dengan 2 maka ini akan dieksekusi
        }

        /**
         * Output
         * 0
         * 1
         * 3
         * 4
         */

        System.out.println();

        // Contoh program
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            if (i % 2 == 0)
                continue;

            System.out.println("");
        }

        System.out.println();

        /**
         * Output:
         *
         * 0 1
         * 2 3
         * 4 5
         * 6 7
         * 8 9
         *
         * Cara Berpikir Programnya
         * Kode pentingnya:
         * if (i % 2 == 0)
         *     continue;
         *
         * % adalah modulus operator (sisa pembagian).
         * i % 2 == 0
         *
         * artinya:
         * angka genap
         *
         * Iterasi contoh
         * i = 0
         * print 0
         * 0 % 2 == 0 → true
         * continue
         * println dilewati.
         * Output:
         * 0
         * i = 1
         * print 1
         * 1 % 2 == 0 → false
         * println
         *
         * Output:
         * 0 1
         * i = 2
         * print 2
         * continue
         *
         * Output:
         * 2
         */

        // Continue dengan Label
        // Seperti break, continue juga bisa pakai label.
        outer: for (int i = 0; i < 10; i++) {
             for (int j = 0; j < 10; j++) {
                 if (j > i) {
                     System.out.println();
                     continue outer;
                 }

                 System.out.print(" " + (i * j));
             }
        }

        /**
         * Outputnya
         *
         *  0
         *  0 1
         *  0 2 4
         *  0 3 6 9
         *  0 4 8 12 16
         *  0 5 10 15 20 25
         *  0 6 12 18 24 30 36
         *  0 7 14 21 28 35 42 49
         *  0 8 16 24 32 40 48 56 64
         *  0 9 18 27 36 45 54 63 72 81
         *
         * Ini adalah tabel perkalian segitiga.
         *
         * Struktur loopnya
         *
         * Di sini ada dua loop bersarang.
         *
         * outer loop  → i
         * inner loop  → j
         *
         * Strukturnya:
         *
         * outer:
         * for i = 0..9
         *     for j = 0..9
         *
         * Label outer: menunjuk ke loop i.
         *
         * Apa arti continue outer
         *
         * Biasanya continue hanya melanjutkan loop terdekat.
         *
         * Contoh biasa:
         *
         * continue;
         *
         * → kembali ke loop j
         *
         * Tapi kalau:
         *
         * continue outer;
         *
         * → loncat ke iterasi berikutnya dari loop i
         *
         * Artinya:
         *
         * loop j langsung dihentikan
         *
         * i bertambah 1
         *
         * j dimulai lagi dari 0
         *
         * Logika utama program
         *
         * Bagian pentingnya ini:
         *
         * if (j > i) {
         *     System.out.println();
         *     continue outer;
         * }
         *
         * Artinya:
         *
         * Kalau j lebih besar dari i:
         *
         * pindah baris
         *
         * lompat ke iterasi berikutnya dari i
         *
         * Jadi loop j tidak dilanjutkan lagi.
         *
         * Iterasi contoh (biar kebayang)
         * Iterasi 1
         * i = 0
         *
         * Loop j:
         *
         * j = 0 → 0*0 = 0
         * j = 1 → j > i → true
         *
         * Program melakukan:
         *
         * println()
         * continue outer
         *
         * Output baris pertama:
         *
         * 0
         * Iterasi 2
         * i = 1
         *
         * Loop j:
         *
         * j = 0 → 1*0 = 0
         * j = 1 → 1*1 = 1
         * j = 2 → j > i → true
         *
         * Output:
         *
         * 0 1
         * Iterasi 3
         * i = 2
         *
         * Loop j:
         *
         * 0*2 = 0
         * 1*2 = 2
         * 2*2 = 4
         * j = 3 → stop
         *
         * Output:
         *
         * 0 2 4
         * 
         * Pola output yang terbentuk
         * Program ini mencetak setengah tabel perkalian.
         *
         * Output kira-kira:
         *
         *  0
         *  0 1
         *  0 2 4
         *  0 3 6 9
         *  0 4 8 12 16
         *  0 5 10 15 20 25
         *  0 6 12 18 24 30 36
         *  ...
         *
         * Karena setiap baris hanya sampai:
         *
         * j <= i
         * 
         * Kenapa pakai continue outer?
         * Kalau tidak pakai label biasanya harus:
         * for (int j = 0; j <= i; j++)
         *
         * Tapi contoh ini dibuat untuk mendemonstrasikan label continue di Java.
         *
         * Visual alurnya
         * i loop
         *  ├─ j loop
         *  │   ├─ print i*j
         *  │   ├─ kalau j > i
         *  │   │      ↓
         *  │   │   continue outer
         *  │   │      ↓
         *  │   └─ lompat ke i++
         *
         * --------------------------------------
         * 
         * Kesimpulan penting
         *
         * continue outer berarti:
         *
         * skip seluruh sisa loop j
         * lanjut ke iterasi berikutnya dari loop i
         */
    }
}
