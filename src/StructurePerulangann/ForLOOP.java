package StructurePerulangann;

public class ForLOOP {
    public static void main(String[] args) {

        /**
         * for adalah loop yang sangat kuat dan fleksibel.
         * 
         * Mulai dari JDK 5, Java punya dua jenis for loop:
         * 1️- Traditional for loop (yang klasik)
         * 2️- for-each loop (untuk array dan collection
         * Di bagian ini buku menjelaskan for klasik dulu.
         *
         * Bentuk Umum for:
         * for(initialization; condition; iteration) {
         *     // body loop
         * }
         *
         * Kalau hanya 1 statement, {} tidak wajib.
         *
         * Mari kita bahas satu-satu.
         *
         * 1️- Initialization
         * Bagian ini dijalankan sekali saja di awal loop.
         * Biasanya untuk menginisialisasi variabel counter.
         * Contoh:
         * int i = 0
         *
         * 2️- Condition
         * Ini adalah kondisi boolean.
         * Selama kondisi true → loop jalan.
         * Contoh:
         * i < 10
         *
         * 3️- Iteration
         * Ini bagian yang dijalankan setelah setiap loop selesai.
         * Biasanya untuk menambah atau mengurangi counter.
         * Contoh:
         * i++
         *
         * Urutan Kerja for Loop
         * Urutannya seperti ini:
         * 1 initialization
         * 2 cek condition
         * 3 jalankan body
         * 4 iteration
         * 5 balik lagi ke condition
         *
         * Deklarasi Variabel di Dalam for
         * Variabel loop bisa langsung dibuat di dalam for.
         * Contoh:
         * for(int n = 10; n > 0; n--)
         *     System.out.println("tick " + n);
         *
         * Kenapa sering dilakukan?
         * Karena variabel itu hanya dipakai di loop.
         * Ini membuat kode lebih rapi dan aman.
         *
         * Konsep Penting: Scope Variabel
         * Kalau variabel dibuat di dalam for, maka scope-nya hanya di dalam loop.
         * Contoh:
         * for(int i = 0; i < 5; i++){
         *     System.out.println(i);
         * }
         *
         * Di luar loop:
         * System.out.println(i); // ERROR
         * Karena:
         * i sudah tidak ada
         *
         * ------------------------------------------
         * 
         * Cara Programmer Senior Memilih Loop:
         * Biasanya seperti ini:
         * while
         * Dipakai kalau:
         * jumlah loop belum jelas
         * Contoh:
         * -membaca file
         * -login
         * -menunggu input
         *
         * do-while
         * Dipakai kalau:
         * harus jalan minimal sekali
         * Contoh:
         * menu program
         * input validation
         *
         * for
         * Dipakai kalau:
         * jumlah iterasi jelas
         * Contoh:
         * loop array
         * loop angka
         * loop data
         *
         * Istilah Penting
         * Multiple Initialization
         * Menginisialisasi lebih dari satu variabel di bagian for.
         * Contoh:
         * for(int i=0, j=10; i<j; i++, j--)
         * Multiple Iteration
         * Menjalankan lebih dari satu operasi setiap loop.
         * Contoh:
         * i++
         * j--
         * Separator
         * Tanda yang memisahkan statement.
         * Dalam kasus ini:
         * ,
         *
         * Semua variabel harus tipe sama jika dideklarasi di for
         *
         * Contoh benar:
         * for(int i = 0, j = 10; i < j; i++, j--)
         *
         * Contoh salah:
         * for(int i = 0, double j = 10; i < j; i++, j--)
         * Java tidak mengizinkan ini.
         *
         * Ringkasan Super Singkat
         *
         * Dalam for loop, kita bisa menulis lebih dari satu statement di:
         * initialization
         * a=1, b=4
         * iteration
         * a++, b--
         * Dipisahkan dengan:
         * ,
         * Contoh lengkap:
         * for(a=1, b=4; a<b; a++, b--)
         */

        // Contoh sederhana
        int n;

        for (n = 10; n > 0; n--)
            System.out.println("tick " + n);

        System.out.println(n); // nilai n sekarang menjadi 0, namun tidak di print karena kondisi false.

        /**
         * Output
         * tick 10
         * tick 9
         * tick 8
         * tick 7
         * tick 6
         * tick 5
         * tick 4
         * tick 3
         * tick 2
         * tick 1
         * 0
         *
         * Cara kerjanya
         * Awal:
         * n = 10
         * Loop 1
         * n > 0 → true
         * print tick 10
         * n--
         * n = 9
         * Loop 2
         * n > 0
         * print tick 9
         * n--
         * Sampai:
         * tick 1
         * Setelah itu:
         * n = 0
         * Kondisi:
         * 0 > 0 = false
         * Loop berhenti.
         *
         * nilai n sekarang menjadi 0, dan karena false dia tidak di cetak.
         */

        // Contoh Program: Mengecek Bilangan Prima
        int num;
        boolean isPrime;

        num = 14;

        if (num < 2)
            isPrime = false;
        else
            isPrime = true;

        for (int i = 2; i <= num / i; i++) {
            if ((num % i) == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime)
            System.out.println("Prime");
        else
            System.out.println("Not Prime");

        /**
         * Using the Comma
         *
         * Kadang kita ingin memasukkan lebih dari satu statement di bagian:
         * initialization
         * iteration
         * dalam for loop.
         * Contoh program berikut:
         */

        int a, b;
        b = 4;

        for (a = 1; a < b; a++) {
            System.out.println("a = " + a);
            System.out.println("b = " + b);
            b--;
        }

        /**
         * Loop ini dikontrol oleh dua variabel, yaitu:
         * a
         * b
         * Namun di program itu hanya a yang ada di bagian for, sedangkan b dikurangi secara manual di dalam loop.
         *
         * Agar lebih rapi, Java memungkinkan kita menulis lebih dari satu statement di bagian:
         * initialization
         * iteration
         * Caranya dengan memisahkan statement menggunakan koma ,.
         */

        // Versi yang Lebih Efisien
        a = b = 0; // reset nilai

        for (a = 1, b =4; a < b; a++, b--) {
            System.out.println("a = " + a);
            System.out.println("b = " + b);
        }

        /**
         * Penjelasan Cara Kerjanya
         * Bagian for:
         *
         * for(a = 1, b = 4; a < b; a++, b--)
         *
         * Mari kita pecah.
         *
         * Initialization
         * a = 1, b = 4
         *
         * Artinya:
         * a mulai dari 1
         * b mulai dari 4
         *
         * Dua variabel diinisialisasi sekaligus.
         * Condition
         * a < b
         * Loop berjalan selama:
         * a lebih kecil dari b
         *
         * Iteration
         * a++, b--
         *
         * Setiap loop:
         *
         * a bertambah 1
         * b berkurang 1
         *
         * Simulasi Loop
         * Awal:
         * a = 1
         * b = 4
         * Loop 1
         * 1 < 4 → true
         * Output:
         * a = 1
         * b = 4
         * Iteration:
         * a++
         * b--
         * a = 2
         * b = 3
         * Loop 2
         * 2 < 3 → true
         * Output:
         * a = 2
         * b = 3
         * Iteration:
         * a = 3
         * b = 2
         * Loop 3
         * 3 < 2 → false
         * Loop berhenti.
         * Output Program
         * a = 1
         * b = 4
         * a = 2
         * b = 3
         */

        // Contoh Loop dari dua arah.
        for (int left = 0, right = 9; left < right; left++, right--) {
            System.out.println(left + " " + right);
        }

        /**
         * Output:
         *
         * 0 9
         * 1 8
         * 2 7
         * 3 6
         * 4 5
         *
         * Ini sering dipakai untuk:
         * algoritma array
         * two pointer technique
         * string reverse
         */

        /**
         * Variasi pada for Loop
         *
         * for loop punya banyak variasi yang membuatnya sangat fleksibel dan kuat.
         * Kenapa bisa fleksibel?
         *
         * Karena tiga bagian utama for:
         * initialization
         * condition
         * iteration
         *
         * tidak wajib hanya dipakai untuk fungsi standar mereka.
         * Ketiga bagian itu bisa digunakan untuk tujuan apa saja yang kamu inginkan.
         *
         * Variasi 1: Condition Tidak Harus Menggunakan Counter
         * Biasanya for seperti ini:
         * for(int i = 0; i < 10; i++)
         * Artinya loop berdasarkan nilai i.
         * Tapi sebenarnya condition bisa berupa boolean apa saja.
         * Contoh dari buku:
         * boolean done = false;
         * for(int i = 1; !done; i++) {
         *
         *   // ...
         *
         *   if(interrupted())
         *       done = true;
         *
         * }
         *
         * Cara kerjanya
         * Loop berjalan selama:
         * !done
         *
         * Artinya:
         * selama done = false
         * Jika suatu saat:
         * done = true
         * loop berhenti.
         * Perhatikan:
         * loop tidak bergantung pada i
         * i hanya ikut bertambah.
         *
         *
         * Variasi 2: Bagian for Bisa Kosong
         * Salah satu variasi menarik:
         * initialization
         * iteration
         *
         * bisa dikosongkan.
         * Contoh dari buku:
         *
         * class ForVar {
         *
         *   public static void main(String args[]) {
         *
         *     int i;
         *     boolean done = false;
         *
         *     i = 0;
         *
         *     for( ; !done; ) { // perhatikan inisialisasi ini kosong
         *
         *       System.out.println("i is " + i);
         *
         *       if(i == 10)
         *           done = true;
         *
         *       i++;
         *
         *     }
         *
         *   }
         * }
         *
         * Struktur loopnya
         * for( ; !done; )
         *
         * Artinya:
         * initialization kosong
         * iteration kosong
         *
         * Jadi:
         * init dan iteration dilakukan di luar loop
         * Cara kerja
         *
         * Awal:
         * i = 0
         * done = false
         * Loop:
         * print i
         * i++
         * Ketika:
         * i == 10
         * maka:
         * done = true
         * Loop berhenti.
         *
         * Output
         * i is 0
         * i is 1
         * i is 2
         * ...
         * i is 10
         *
         * Kenapa Ini Jarang Dipakai
         * Buku bilang:
         * Ini dianggap poor style (gaya kode buruk) dalam contoh sederhana.
         * Kenapa?
         *
         * Karena lebih jelas pakai:
         * while(!done)
         *
         * Tetapi kadang cara ini berguna jika:
         * 1️- kondisi awal dibuat di tempat lain
         * 2️- perubahan variabel loop tidak berurutan
         */

        /**
         * Variasi 3: Infinite Loop
         *
         * Kita bisa membuat loop yang tidak pernah berhenti.
         * Caranya:
         * Kosongkan semua bagian for.
         * for( ; ; ) {
         *
         * }
         *
         * Kenapa ini infinite?
         * Karena tidak ada:
         * initialization
         * condition
         * iteration
         *
         * Terutama:
         * tidak ada condition
         * Artinya kondisi dianggap selalu true.
         * Loop berjalan selamanya.
         *
         * Contoh sederhana
         * for(;;){
         *     System.out.println("hello");
         * }
         */

        /**
         * Menghentikan Infinite Loop
         *
         * Buku memberi hint di akhir:
         * Ada cara menghentikan loop tanpa menggunakan condition di for
         * Caranya menggunakan:
         * break
         * Contoh:
         *
         * for(;;){
         *
         *     int x = 5;
         *
         *     if(x == 5)
         *         break;
         *
         * }
         *
         * Loop berhenti karena break.
         */

    }
}
