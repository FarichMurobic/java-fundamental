package JumpStatements;

public class Label {
    public static void main(String[] args) {
        
        /**
         * Apa itu Label?
         *
         * Label adalah nama yang diberikan pada sebuah blok kode.
         * Formatnya:
         *
         * label: {
         *    kode
         * }
         *
         * Menggunakan break sebagai Bentuk goto
         * Selain digunakan di switch dan loop, statement break juga bisa digunakan sendiri untuk membuat bentuk goto yang lebih aman.
         * Java tidak memiliki goto karena goto memungkinkan program melompat ke tempat mana saja secara bebas dan tidak terstruktur.
         *
         * -------------------------------------------
         * 
         * Masalah goto:
         * membuat kode sulit dipahami
         * membuat kode sulit dirawat
         * mengganggu optimisasi compiler
         *
         * Namun ada beberapa situasi di mana konsep seperti goto sebenarnya berguna, misalnya:
         * keluar dari loop yang sangat bersarang (nested loops).
         * Untuk mengatasi situasi seperti ini, Java menyediakan bentuk khusus dari break yang disebut labeled break.
         * Dengan bentuk ini kita bisa:
         * keluar dari satu atau beberapa blok kode
         * menentukan ke mana program akan melanjutkan eksekusi
         *
         * Bentuk umum:
         * break label;
         *
         * Bagaimana break label bekerja?
         * Ketika program menjalankan:
         * break label;
         *
         * Program akan:
         * keluar dari blok yang memiliki label tersebut
         * melanjutkan eksekusi setelah blok itu
         *
         * --------------------------------------
         * 
         * Aturan Java:
         * 
         * break label
         * harus berada di dalam blok label itu
         *
         * break biasa
         * hanya keluar dari loop terdekat.
         *
         * for i
         *    for j
         *       break
         * yang berhenti hanya j.
         *
         * break label
         * bisa keluar dari loop luar.
         * outer:
         * for i
         *    for j
         *       break outer
         *
         * yang berhenti:
         * loop i dan loop j
         */

        /**
         * Penting
         *
         * perbedaan break dan continue dalam menggunakan label
         * continue tidak bisa dipakai ke label yang menunjuk ke block {}, sedangkan break bisa
         * Aturan dasar continue di Java
         *
         * continue hanya bekerja pada loop, yaitu:
         * for
         * while
         * do-while
         *
         * Fungsinya:
         * loncat ke iterasi berikutnya dari loop
         * Karena itu Java harus tahu loop mana yang mau dilanjutkan.
         *
         * Contoh continue dengan label (VALID)
         * outer:
         * for (int i = 0; i < 5; i++) {
         *
         *     for (int j = 0; j < 5; j++) {
         *
         *         if (j == 3)
         *             continue outer;
         *
         *         System.out.println(i + " " + j);
         *     }
         * }
         *
         * Artinya:
         * continue outer
         * ↓
         * lanjut ke iterasi berikutnya dari loop i
         * Karena outer menunjuk ke loop, maka valid.
         *
         * Contoh continue ke block (ERROR)
         * test: {
         *     int x = 10;
         *
         *     continue test; // ERROR
         * }
         *
         * Kenapa error?
         * Karena:
         * continue = lanjut iterasi loop
         * Sedangkan:
         * test: { }
         * bukan loop.
         * Block {} tidak punya iterasi berikutnya.
         * Jadi compiler bingung:
         * lanjut ke iterasi yang mana?
         *
         * Kenapa break boleh?
         * 
         * break artinya:
         * keluar dari statement
         * Bukan melanjutkan iterasi.
         * Jadi dia bisa keluar dari:
         * loop
         * switch
         * block berlabel
         *
         * Contoh valid:
         *
         * test: {
         *     int x = 10;
         *
         *     if (x == 10)
         *         break test;
         *
         *     System.out.println("tidak tampil");
         * }
         *
         * break test → keluar dari block test.
         *
         * Perbedaan konsep inti
         * Statement	    Fungsi
         * break	        keluar dari statement
         * continue	        lanjut ke iterasi loop berikutnya
         *
         * Makanya aturan Java jadi seperti ini
         * Target Label	    break	continue
         * loop	            ya	      ya
         * block {}	        ya	      tidak
         * switch	        ya	      tidak
         *
         * continue = hanya loop
         * break = semua statement
         */

        boolean t = true;

        first: {
            second: {
                third: {

                    System.out.println("Before the break.");

                    if (t) // jika t true
                        break second; // break, keluar dari label second

                    System.out.println("This won't execute"); // artinya ini tidak akan dieksekusi
                }
                System.out.println("This won't execute"); // ini juga tidak akan dieksekusi, karena berada di blok second
            }
            System.out.println("This is after second block."); // ini tetep dieksekusi, karena bukan bagian dari blok second
        }

        System.out.println();

        /**
         * Output:
         * Before the break.
         * This is after second block.
         *
         * Cara berpikir programnya
         * Struktur blok:
         *
         * first
         *  └── second
         *       └── third
         *
         * Program jalan seperti ini:
         * Before the break.
         * if(t) break second
         *
         * Karena t = true, maka:
         * break second
         * Program lompat keluar dari blok second.
         * Semua kode di dalam second dilewati.
         * Program lanjut ke:
         * This is after second block.
         */

        // Labeled Break pada Nested Loop
        outer: for (int i = 0; i < 3; i++) {
            System.out.print("Pass " + i + ": ");
            for (int j = 0; j < 100; j++) {
                if (j == 10)
                    break outer;
                System.out.print(j + " ");
            }
            System.out.println("This will not print");
        }
        System.out.println("Loops complete.");

        /**
         * Output:
         * Pass 0: 0 1 2 3 4 5 6 7 8 9
         * Loops complete.
         *
         * Kenapa outer loop berhenti?
         * Struktur loop:
         * outer loop (i)
         *    inner loop (j)
         *
         * Normalnya:
         * i = 0
         * i = 1
         * i = 2
         *
         * Tapi ketika:
         * j == 10
         * break outer
         * Program keluar dari outer loop juga.
         * Jadi kedua loop langsung berhenti.
         *
         * Visual
         * outer loop
         *    inner loop
         *       j = 0..9
         *       j = 10 → break outer
         *
         * Program langsung lompat ke:
         * Loops complete.
         */

        // Nested label tanpa block (paling umum)

        outer:
        for (int i = 0; i < 3; i++) {

            inner:
            for (int j = 0; j < 3; j++) {

                if (j == 1) break outer;

                System.out.println(i + " " + j);
            }
        }

        /**
         * Label meskipun kita membuat dengan nama yang sama namun tidak bermasalah
         * selama scopenya berbeda,
         * artinya kita boleh membuat nama label yang sama hanya jika scopenya berbeda.
         * namun tidak boleh membuat nama label yang sama di dalam scope yang sama.
         */
    }
}
