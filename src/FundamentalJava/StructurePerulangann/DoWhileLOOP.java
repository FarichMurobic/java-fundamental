package FundamentalJava.StructurePerulangann;

public class DoWhileLOOP {
    public static void main(String[] args) throws java.io.IOException {

        /**
         * do-while
         * 
         * Seperti yang baru saja kita lihat pada while, 
         * jika kondisi awalnya false, maka isi loop tidak dijalankan sama sekali.
         * 
         * Namun kadang kita ingin loop tetap dijalankan minimal sekali, walaupun kondisi awalnya false.
         * Artinya kita ingin:
         * Mengecek kondisi di akhir loop, bukan di awal.
         * Java menyediakan loop untuk itu, yaitu do-while.
         * Loop do-while selalu menjalankan isi loop minimal satu kali, 
         * karena pengecekan kondisi dilakukan di bagian bawah loop.
         * 
         * Bentuk umum:
         * 
         * do {
         *     // isi loop
         * } while(condition);
         *
         * Urutannya:
         * Jalankan isi loop dulu
         * Cek kondisi
         * Jika kondisi true → ulangi loop
         * Jika false → berhenti
         * Seperti loop lain di Java, condition harus boolean.
         *
         * Perbedaan besar antara while dan do-while adalah posisi pengecekan kondisi.
         * while        -> cek kondisi dulu baru jalankan kode
         * do while     -> jalankan kode dulu baru cek kondisi, Jadi minimal pasti jalan 1 kali.
         *
         * Aturan Dasar Tracing Loop
         * Saat membaca loop, lakukan 3 langkah ini di kepala:
         * Lihat nilai awal
         * Lihat perubahan variabel di dalam loop
         * Lihat kapan kondisi berhenti
         *
         * Jangan lupa ; di akhir
         * Berbeda dari while.
         * Harus ada titik koma.
         * } while(condition); titik koma
         * Kalau tidak ada → compile error.
         *
         * Perbandingan
         * Loop	            Kondisi Dicek
         * while	        di awal
         * do-while	        di akhir
         *
         * Tips Programmer Senior
         * Biasanya:
         * Gunakan while kalau:
         * loop bisa saja tidak dijalankan
         * Gunakan do-while kalau:
         * loop harus dijalankan minimal sekali
         *
         * Contoh nyata:
         * menu program
         * input validasi
         * login attempt
         */

        // Contoh program sederhana
        int n = 10;

        do {
            System.out.println("tick" + n);
            n--;
        } while (n > 0);

        System.out.println(n); // nilai n sekarang jadi 0

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
         */

        // do-while selalu jalan sekali, meskipun kondisi false
        int x = 100;

        do {
            System.out.println("Hello");
        } while (x < 50);

        /**
         * Walaupun kondisi salah 
         * x < 50 = false karena x 100
         * namun statement tetep dicetak sekali.
         * berbeda dengan while, yang tidak akan di cetak sama sekali
         */

        // Using a do-while to process a menu selection
        char choice;

        do {
            System.out.println("Help on: ");
            System.out.println("  1. if");
            System.out.println("  2. switch");
            System.out.println("  3. while");
            System.out.println("  4. do-while");
            System.out.println("  5. for\n");
            System.out.println("Choose one:");
            choice = (char) System.in.read(); // Console Input: Input dari keyboard melalui terminal/console.
        } while (choice < '1' || choice > '5');

        System.out.println("\n");

        switch(choice) {
            case '1':
                System.out.println("The if:\n");
                System.out.println("if(condition) statement;");
                System.out.println("else statement;");
                break;
            case '2':
                System.out.println("The switch:\n");
                System.out.println("switch(expression) {");
                System.out.println("  case constant:");
                System.out.println("    statement sequence");
                System.out.println("    break;");
                System.out.println("  //...");
                System.out.println("}");
                break;
            case '3':
                System.out.println("The while:\n");
                System.out.println("while(condition) statement;");
                break;
            case '4':
                System.out.println("The do-while:\n");
                System.out.println("do {");
                System.out.println("  statement;");
                System.out.println("} while (condition);");
                break;
            case '5':
                System.out.println("The for:\n");
                System.out.print("for(init; condition; iteration)");
                System.out.println(" statement;");
                break;
        }

        /**
         * Program ini membuat menu sederhana.
         * 
         * User memilih angka.
         * Program membaca input:
         * choice = (char) System.in.read();
         *
         * Loop ini:
         * do{
         *    tampilkan menu
         *    baca input
         * } while(choice < '1' || choice > '5');
         *
         * Artinya:
         * selama input bukan 1-5
         * ulang lagi
         *
         * Kenapa pakai do-while?
         * Karena menu harus tampil minimal sekali.
         * Kalau pakai while:
         * Program bisa saja tidak pernah menampilkan menu jika kondisi salah.
         */

    }
}
