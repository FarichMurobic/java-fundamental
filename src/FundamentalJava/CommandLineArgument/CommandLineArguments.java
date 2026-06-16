package FundamentalJava.CommandLineArgument;

/**
 * ------------------------------------------------------------
 * COMMAND-LINE ARGUMENTS
 * ------------------------------------------------------------
 *
 * Kadang kita ingin mengirim data ke program saat program
 * dijalankan tanpa harus meminta input melalui keyboard.
 *
 * Java menyediakan mekanisme yang disebut:
 *
 * Command-Line Arguments
 *
 * Command-line argument adalah data yang diberikan setelah
 * nama program ketika program dijalankan melalui terminal
 * atau command prompt.
 *
 * Contoh:
 *
 * java NamaProgram hello dunia 123
 *
 * Pada contoh tersebut:
 *
 * - hello
 * - dunia
 * - 123
 *
 * merupakan command-line arguments yang dikirim ke program.
 *
 * ------------------------------------------------------------
 * BAGAIMANA JAVA MENYIMPAN ARGUMENT?
 * ------------------------------------------------------------
 *
 * Semua command-line arguments secara otomatis disimpan
 * oleh Java ke dalam sebuah array bertipe String yang
 * diterima oleh method main().
 *
 * Bentuk umum method main:
 *
 * public static void main(String[] args)
 *
 * atau
 *
 * public static void main(String args[])
 *
 * Kedua bentuk tersebut identik dan memiliki fungsi yang sama.
 *
 * Keterangan:
 *
 * String[] args
 * -> Array yang menyimpan seluruh command-line arguments.
 *
 * args
 * -> Nama variable array (dapat diganti dengan nama lain,
 *    tetapi "args" merupakan konvensi yang paling umum).
 *
 * ------------------------------------------------------------
 * INDEX COMMAND-LINE ARGUMENTS
 * ------------------------------------------------------------
 *
 * Karena arguments disimpan dalam array, setiap data
 * diakses menggunakan nomor indeks.
 *
 * Seperti array Java pada umumnya:
 *
 * - Indeks dimulai dari 0.
 * - Bukan dimulai dari 1.
 *
 * Contoh:
 *
 * java NamaProgram hello dunia 123
 *
 * Maka isi array args:
 *
 * args[0] = "hello"
 * args[1] = "dunia"
 * args[2] = "123"
 *
 * Tabel Index:
 *
 * Input Pertama  -> args[0]
 * Input Kedua    -> args[1]
 * Input Ketiga   -> args[2]
 *
 * Flow:
 *
 * User Menjalankan Program
 * -> Menuliskan Argument
 * -> Java Menyimpan Ke Array String
 * -> Program Mengakses Melalui args[index]
 *
 * ------------------------------------------------------------
 * CONTOH PROGRAM
 * ------------------------------------------------------------
 *
 * public class CommandLineArguments {
 *
 *     public static void main(String[] args) {
 *
 *         System.out.println(args[0]);
 *         System.out.println(args[1]);
 *         System.out.println(args[2]);
 *
 *     }
 * }
 *
 * Jika dijalankan:
 *
 * java CommandLineArguments hello dunia 123
 *
 * Output:
 *
 * hello
 * dunia
 * 123
 *
 * ------------------------------------------------------------
 * CONTOH MENAMPILKAN INDEX
 * ------------------------------------------------------------
 *
 * public class CommandLineArguments {
 *
 *     public static void main(String[] args) {
 *
 *         System.out.println("args[0] : " + args[0]);
 *         System.out.println("args[1] : " + args[1]);
 *         System.out.println("args[2] : " + args[2]);
 *
 *     }
 * }
 *
 * Menjalankan program:
 *
 * java CommandLineArguments hello dunia 123
 *
 * Output:
 *
 * args[0] : hello
 * args[1] : dunia
 * args[2] : 123
 *
 * ------------------------------------------------------------
 * ARGUMENT SELALU BERTIPE STRING
 * ------------------------------------------------------------
 *
 * Hal yang sangat penting untuk dipahami:
 *
 * Semua command-line arguments selalu diterima sebagai String.
 *
 * Contoh:
 *
 * java Program 100
 *
 * Maka:
 *
 * args[0]
 *
 * berisi:
 *
 * "100"
 *
 * Bukan:
 *
 * 100 (int)
 *
 * Jika ingin mengubahnya menjadi tipe numerik,
 * diperlukan proses konversi.
 *
 * Contoh:
 *
 * int angka = Integer.parseInt(args[0]);
 *
 * Flow:
 *
 * Command-Line Argument
 * -> String
 * -> Parsing / Konversi
 * -> int / double / Tipe Lain
 *
 * ------------------------------------------------------------
 * JUMLAH ARGUMENT TIDAK HARUS TETAP
 * ------------------------------------------------------------
 *
 * Karena args adalah array,
 * jumlah argument dapat berbeda-beda setiap kali program
 * dijalankan.
 *
 * Contoh:
 *
 * java Program A
 *
 * args.length = 1
 *
 * ------------------------------------------------------------
 *
 * java Program A B C
 *
 * args.length = 3
 *
 * ------------------------------------------------------------
 *
 * java Program A B C D E
 *
 * args.length = 5
 *
 * ------------------------------------------------------------
 * MENGGUNAKAN args.length
 * ------------------------------------------------------------
 *
 * Property length dapat digunakan untuk mengetahui jumlah
 * argument yang diterima.
 *
 * Contoh:
 *
 * public static void main(String[] args) {
 *
 *     System.out.println(args.length);
 *
 * }
 *
 * Menjalankan:
 *
 * java Program A B C
 *
 * Output:
 *
 * 3
 *
 * ------------------------------------------------------------
 * RISIKO ArrayIndexOutOfBoundsException
 * ------------------------------------------------------------
 *
 * Karena args adalah array,
 * mengakses indeks yang tidak ada akan menyebabkan error.
 *
 * Contoh:
 *
 * java Program hello
 *
 * Kemudian:
 *
 * System.out.println(args[1]);
 *
 * Error:
 *
 * ArrayIndexOutOfBoundsException
 *
 * Karena:
 *
 * args[1] tidak ada.
 *
 * Solusi:
 *
 * Selalu periksa jumlah argument terlebih dahulu.
 *
 * Contoh:
 *
 * if (args.length > 1) {
 *     System.out.println(args[1]);
 * }
 *
 * ------------------------------------------------------------
 * KEGUNAAN COMMAND-LINE ARGUMENTS
 * ------------------------------------------------------------
 *
 * Command-line arguments sering digunakan untuk:
 *
 * - Mengirim konfigurasi program.
 * - Mengirim nama file.
 * - Menentukan mode aplikasi.
 * - Mengirim parameter saat testing.
 * - Menjalankan tool atau utility dari terminal.
 *
 * Banyak aplikasi Java modern menggunakan command-line
 * arguments untuk konfigurasi awal saat startup.
 *
 * ------------------------------------------------------------
 * ISTILAH PENTING
 * ------------------------------------------------------------
 *
 * Command-Line Argument
 * -> Data yang dikirim saat program dijalankan.
 *
 * args
 * -> Array String yang menyimpan argument.
 *
 * args[index]
 * -> Mengakses argument berdasarkan posisi.
 *
 * args.length
 * -> Jumlah argument yang diterima.
 *
 * Parsing
 * -> Proses mengubah String menjadi tipe data lain.
 *
 * ------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------
 *
 * Command-Line Arguments memungkinkan program menerima data
 * langsung saat dijalankan melalui terminal.
 *
 * Semua argument:
 *
 * - Disimpan dalam String[] args.
 * - Diakses menggunakan indeks array.
 * - Selalu bertipe String.
 *
 * Flow utama:
 *
 * User Menjalankan Program
 * -> Menulis Argument Di Terminal
 * -> Java Menyimpan Ke String[] args
 * -> Program Membaca args[index]
 * -> Data Diproses
 *
 * Command-line arguments merupakan salah satu cara paling
 * sederhana untuk memberikan input ke program Java tanpa
 * menggunakan Scanner atau mekanisme input lainnya.
 */

public class CommandLineArguments {
    public static void main(String[] args) {
        
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "]: " + args[i]);
        }
    }
}
