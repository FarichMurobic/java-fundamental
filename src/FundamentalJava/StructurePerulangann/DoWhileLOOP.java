package FundamentalJava.StructurePerulangann;

/**
 * ------------------------------------------------------------------------
 * DO-WHILE LOOP
 * ------------------------------------------------------------------------
 * 
 * Seperti yang sudah kita lihat pada while,
 * jika kondisi awalnya false, maka isi loop TIDAK dijalankan sama sekali.
 * 
 * Namun kadang kita ingin loop tetap dijalankan MINIMAL SEKALI,
 * walaupun kondisi awalnya false.
 * 
 * Artinya kita ingin:
 * Mengecek kondisi di AKHIR loop, bukan di AWAL.
 * 
 * Java menyediakan loop untuk itu, yaitu do-while.
 * 
 * ------------------------------------------------------------------------
 * BENTUK UMUM
 * ------------------------------------------------------------------------
 * 
 *     do {
 *         // isi loop (dijalankan minimal sekali)
 *     } while (kondisi);
 * 
 * Urutan eksekusi:
 * 
 *     1. Jalankan isi loop dulu
 *     2. Cek kondisi
 *     3. Jika kondisi true → ulangi loop (kembali ke langkah 1)
 *     4. Jika kondisi false → berhenti
 * 
 * ------------------------------------------------------------------------
 * PERBEDAAN WHILE vs DO-WHILE
 * ------------------------------------------------------------------------
 * 
 * while         | do-while
 * --------------|-----------------------------------------------------------
 * Cek kondisi   | Cek kondisi
 * di AWAL       | di AKHIR
 *               |
 * if (kondisi)  | do {
 *     // kode   |     // kode
 * }             | } while (kondisi);
 *               |
 * Bisa 0 kali   | Minimal 1 kali
 * dieksekusi    | dieksekusi
 * 
 * ------------------------------------------------------------------------
 * CONTOH SEDERHANA
 * ------------------------------------------------------------------------
 * 
 *     // while - jika kondisi false, tidak dijalankan
 *     int x = 10;
 *     while (x < 5) {
 *         System.out.println("While: " + x); // TIDAK dijalankan
 *     }
 * 
 *     // do-while - tetap dijalankan minimal sekali
 *     int y = 10;
 *     do {
 *         System.out.println("Do-while: " + y); // DIJALANKAN sekali
 *     } while (y < 5);
 * 
 *     // Output: Do-while: 10
 * 
 * ------------------------------------------------------------------------
 * CONTOH DO-WHILE YANG BERULANG
 * ------------------------------------------------------------------------
 * 
 *     int i = 1;
 * 
 *     do {
 *         System.out.println("Perulangan ke-" + i);
 *         i++;
 *     } while (i <= 5);
 * 
 *     // Output:
 *     // Perulangan ke-1
 *     // Perulangan ke-2
 *     // Perulangan ke-3
 *     // Perulangan ke-4
 *     // Perulangan ke-5
 * 
 * ------------------------------------------------------------------------
 * CONTOH KASUS NYATA
 * ------------------------------------------------------------------------
 * 
 * 1. Menu Program (harus tampil minimal sekali)
 * 
 *     int pilihan;
 * 
 *     do {
 *         System.out.println("=== MENU ===");
 *         System.out.println("1. Lihat Data");
 *         System.out.println("2. Tambah Data");
 *         System.out.println("3. Keluar");
 *         System.out.print("Pilih: ");
 * 
 *         pilihan = scanner.nextInt();
 * 
 *         switch (pilihan) {
 *             case 1 -> System.out.println("Menampilkan data...");
 *             case 2 -> System.out.println("Menambah data...");
 *             case 3 -> System.out.println("Keluar...");
 *             default -> System.out.println("Pilihan tidak valid!");
 *         }
 * 
 *     } while (pilihan != 3);
 * 
 * 2. Validasi Input (pastikan user input yang benar)
 * 
 *     int umur;
 * 
 *     do {
 *         System.out.print("Masukkan umur (17-60): ");
 *         umur = scanner.nextInt();
 * 
 *         if (umur < 17 || umur > 60) {
 *             System.out.println("Umur tidak valid! Ulangi.");
 *         }
 * 
 *     } while (umur < 17 || umur > 60);
 * 
 *     System.out.println("Umur valid: " + umur);
 * 
 * 3. Login Attempt (percobaan login)
 * 
 *     int percobaan = 0;
 *     boolean loginSukses = false;
 * 
 *     do {
 *         percobaan++;
 *         System.out.print("Username: ");
 *         String user = scanner.nextLine();
 *         System.out.print("Password: ");
 *         String pass = scanner.nextLine();
 * 
 *         if (user.equals("admin") && pass.equals("12345")) {
 *             loginSukses = true;
 *             System.out.println("Login berhasil!");
 *         } else {
 *             System.out.println("Login gagal! Percobaan ke-" + percobaan);
 *         }
 * 
 *     } while (!loginSukses && percobaan < 3);
 * 
 *     if (!loginSukses) {
 *         System.out.println("Terlalu banyak percobaan. Akun terkunci.");
 *     }
 * 
 * ------------------------------------------------------------------------
 * ATURAN DASAR TRACING LOOP
 * ------------------------------------------------------------------------
 * 
 * Saat membaca/menganalisis loop, lakukan 3 langkah ini di kepala:
 * 
 * 1. Lihat NILAI AWAL variabel kontrol
 * 2. Lihat PERUBAHAN variabel di dalam loop
 * 3. Lihat KAPAN KONDISI BERHENTI
 * 
 * Contoh:
 * 
 *     int i = 1;      // Nilai awal
 *     do {
 *         System.out.println(i);
 *         i++;        // Perubahan
 *     } while (i <= 5); // Kondisi berhenti
 * 
 * ------------------------------------------------------------------------
 * JANGAN LUPA ; DI AKHIR!
 * ------------------------------------------------------------------------
 * 
 * Berbeda dari while, do-while WAJIB diakhiri dengan titik koma.
 * 
 *     // BENAR
 *     do {
 *         // ...
 *     } while (kondisi);   // <- WAJIB ada ;
 * 
 *     // SALAH (compile error)
 *     do {
 *         // ...
 *     } while (kondisi)    // <- ERROR! Tidak ada ;
 * 
 * ------------------------------------------------------------------------
 * KAPAN MENGGUNAKAN DO-WHILE?
 * ------------------------------------------------------------------------
 * 
 * Gunakan do-while jika:
 * - Loop HARUS dijalankan minimal SATU KALI
 * - Validasi input user (pastikan input dicek)
 * - Menu program (harus tampil dulu baru pilih)
 * - Login attempt (coba login dulu baru cek)
 * 
 * Gunakan while jika:
 * - Loop BOLEH TIDAK dijalankan sama sekali
 * - Kondisi harus dicek sebelum eksekusi
 * 
 * ------------------------------------------------------------------------
 * RINGKASAN SUPER PADAT
 * ------------------------------------------------------------------------
 * 
 * - do-while = jalankan dulu, cek kondisi di akhir
 * - Minimal dijalankan 1 kali
 * - Bentuk: do { ... } while (kondisi);
 * - WAJIB ada ; di akhir
 * - while = cek di awal, do-while = cek di akhir
 * - Cocok untuk: menu, validasi input, login attempt
 * 
 * ------------------------------------------------------------------------
 */

public class DoWhileLOOP {
    public static void main(String[] args) throws java.io.IOException {

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
