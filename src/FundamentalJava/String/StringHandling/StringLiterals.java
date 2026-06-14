package FundamentalJava.String.StringHandling;

public class StringLiterals {
    public static void main(String[] args) {

        /**
         * String Literals
         * Literal string diwakili oleh sepasang tanda kutip ganda, misalnya "Hello World".
         * Escape sequences juga bisa digunakan di dalamnya.
         * Perlu diingat bahwa string di Java adalah objek, bukan sekadar array karakter.
         *
         * String = kumpulan karakter (huruf, angka, simbol)
         * Tipe data bawaan Java
         * Bukan tipe primitif (String tipe data referensi/bukan primitif) → String = object
         *
         * String = Immutable
         * String tidak bisa diubah langsung
         * Semua method membuat String baru
         *
         * Note: String harus diapit titik dua: " "
         *
         * System.out.println("");
         * System: adalah sebuah kelas bawaan Java yang menyediakan banyak fungsi sistem dasar
         * out: Kelas System punya sebuah atribut (data) bernama out. out ini sendiri adalah sebuah instans (objek) dari kelas PrintStream.
         * println: Kelas PrintStream punya sebuah operasi (metode) bernama println. Metode println ini menerima String sebagai argumen atau parameter.
         */

        String stringOne = "Say Hello";
        System.out.println(stringOne);
        String stringTwo = "\"Hello\"";
        System.out.println(stringOne + " " + stringTwo);
        String resultOne = stringOne.toUpperCase(); // Jadi Kapital
        System.out.println(resultOne);
        String resultTwo = stringOne.toLowerCase(); // Jadi Kecil
        System.out.println(resultTwo);

        System.out.println("----------------------");

        /**
         * DAFTAR METHOD PENTING STRING:
         * 1, length()	Panjang string s.length()
         * 2, charAt(int index) Ambil karakter di posisi index	s.charAt(2)
         * 3, substring(int start)	Ambil dari posisi start sampai akhir s.substring(5)
         * 4, substring(int start, int end) Ambil potongan (start..end-1)	s.substring(2,5)
         * 5, toUpperCase() Ubah ke huruf besar s.toUpperCase()
         * 6, toLowerCase() Ubah ke huruf kecil s.toLowerCase()
         * 7, trim() Hilangkan spasi awal & akhir s.trim()
         * 8, equals(String s2) Cek sama persis s.equals("Hello")
         * 9, equalsIgnoreCase(String s2) Cek sama tanpa peduli huruf besar/kecil s.equalsIgnoreCase("hello")
         * 10, contains(String teks) Apakah mengandung teks? s.contains("Java")
         * 11, startsWith(String teks) Apakah diawali dengan teks? s.startsWith("Saya")
         * 12, endsWith(String teks) Apakah diakhiri dengan teks? s.endsWith("Java")
         * 13, indexOf(char / String) Posisi index dari karakter/teks s.indexOf('a')
         * 14, lastIndexOf(char / String) Posisi index terakhir dari karakter s.lastIndexOf("Java")
         * 15, replace(char / String, baru)	Ganti karakter/teks	s.replace("Belajar", "Menguasai")
         * 16, split(String regex) Potong String jadi array	s.split(" ")
         */

        // CONTOH

        String quotes = " Alhamdulillah Broo ";
        System.out.print(quotes + "\n");

        System.out.println
                ("(1) Panjang Kalimat \" Alhamdulillah Broo \": " + quotes.length());
        // (1) Panjang Kalimat " Alhamdulillah Broo ": 20
        System.out.println
                ("(2) Ambil index huruf ke-2 dari \" Alhamdulillah Broo \": " + quotes.charAt(1));
        // (2) Ambil index huruf ke-2 dari " Alhamdulillah Broo ": A
        System.out.println
                ("(3) Ambil dari posisi awal-akhir, Ambil \" Alha\" dari \" Alhamdulillah Broo \": " + quotes.substring(5));
        // (3) Ambil dari posisi awal-akhir, Ambil " Alha" dari " Alhamdulillah Broo ": mdulillah Broo
        System.out.println
                ("(4) Ambil potongan posisi huruf dari awal-akhir \" Alhamdulillah Broo \": " + quotes.substring(8,14));
        // (4) Ambil potongan posisi huruf dari awal-akhir " Alhamdulillah Broo ": lillah
        System.out.println
                ("(5) Ubah jadi huruf besar \" Alhamdulillah Broo \": " + quotes.toUpperCase());
        // (5) Ubah jadi huruf besar " Alhamdulillah Broo ":  ALHAMDULILLAH BROO
        System.out.println
                ("(6) Ubah jadi huruf kecil \" Alhamdulillah Broo \": " + quotes.toLowerCase());
        // (6) Ubah jadi huruf kecil " Alhamdulillah Broo ":  alhamdulillah broo
        System.out.println
                ("(7) Menghilangkan spasi awal dan akhir \" Alhamdulillah Broo \": " + quotes.trim());
        // (7) Menghilangkan spasi awal dan akhir " Alhamdulillah Broo ": Alhamdulillah Broo
        System.out.println
                ("(8) Mengecek kata yang sama \" Alhamdulillah Broo \": " + quotes.equals(" Alhamdulillah Broo "));
        // (8) Mengecek kata yang sama " Alhamdulillah Broo ": true
        System.out.println
                ("(9) Mengecek kata yang sama tanpa peduli huruf besar/kecil \" Alhamdulillah Broo \": " + quotes.equalsIgnoreCase(" alhamdulillah broo "));
        // (9) Mengecek kata yang sama tanpa peduli huruf besar/kecil " Alhamdulillah Broo ": true
        System.out.println
                ("(10) Mengecek apakah ada kata \"Broo\" di \" Alhamdulillah Broo \": " + quotes.contains("Broo"));
        // (10) Mengecek apakah ada kata "Broo" di " Alhamdulillah Broo ": true
        System.out.println
                ("(11) Mengecek apakah diawali kata \" Alhamdulillah \" di \" Alhamdulillah Broo \": " + quotes.startsWith(" Alhamdulillah "));
        // (11) Mengecek apakah diawali kata " Alhamdulillah " di " Alhamdulillah Broo ": true
        System.out.println
                ("(12) Mengecek apakah diakhiri kata \" Broo \" di \" Alhamdulillah Broo \": " + quotes.endsWith("Broo "));
        // (12) Mengecek apakah diakhiri kata " Broo " di " Alhamdulillah Broo ": true
        System.out.println
                ("(13) Mengecek posisi index \"A\" di \" Alhamdulillah Broo \": " + quotes.indexOf('A'));
        // (13) Mengecek posisi index "A" di " Alhamdulillah Broo ": 1
        System.out.println
                ("(14) Mengecek posisi index terakhir dari karakter di \" Alhamdulillah Broo \": " + quotes.lastIndexOf("Broo "));
        // (14) Mengecek posisi index terakhir dari karakter di " Alhamdulillah Broo ": 15
        System.out.println
                ("(15) Mengganti karakter \"Bree \" di \" Alhamdulillah Broo \": " + quotes.replace("Broo ", "Bree "));
        // (15) Mengganti karakter "Bree " di " Alhamdulillah Broo ":  Alhamdulillah Bree

        System.out.println("----------------------");

        // Split String jadi Array kata

        String words = "Bismillahirrohamnirrohim";
        String [] kata = words.trim().split(" ");
        System.out.println("(16) Jumlah Kata \t: " + kata.length);
        // (16) Jumlah Kata 	: 1
        // Kata : Bismillahirrohamnirrohim
        for (String k : kata) {
            System.out.println("Kata : " + k);
        }

        /**
         * Tips & Best Practice:
         * Selalu trim() input user
         * Jangan pakai == untuk membandingkan String → pakai .equals() atau .equalsIgnoreCase()
         * Untuk parsing data teks → pakai .split(" ")
         * Pakai .substring() untuk ambil bagian kalimat
         * Gunakan .contains() untuk validasi kata
         */

        System.out.println("----------------------");

        /**
         * String Literal
         * String Kosong
         * String Null
         */

        String literal = "Ini Literal", kosong = "Ini Kosong";

        System.out.println("Hello Bro " + literal ); // String Literal
        // Hello Bro Ini Literal
        System.out.println("" + kosong); // String Kosong
        // Ini Kosong
        System.out.println(); // String Null

    }
}
