package FundamentalJava.Casting;

public class PrecedenceCasting {
    public static void main(String[] args) {
        
        byte byte1 = 100;
        byte byte2 = 27;
        // byte byte3 = byte1 + byte2; Ini akan error
        // Pesan error: "possible lossy conversion from int to byte"
        // SOLUSINYA: Lo harus cast (paksa) hasilnya balik ke byte
        byte byte3 = (byte) (byte1 + byte2);

        /**
         * Jawabannya adalah: Bukan nilainya yang nggak muat, tapi aturannya.
         * Meskipun hasilnya adalah 100 dan tipe byte sanggup menampung sampai 127, Java punya
         * Standard Operating Procedure (SOP) yang nggak bisa ditawar untuk urusan hitung-hitungan.
         *
         * Java punya aturan Automatic Type Promotion.
         * 1, Setiap kali lo melakukan operasi aritmatika (+, -, *, /) pada tipe data "kecil" seperti
         *    byte atau short, Java secara otomatis mempromosikan keduanya menjadi int
         *    sebelum dijumlahkan.
         *
         * 2, Jadi, kalau lo punya byte a = 50; dan byte b = 50;, operasi a + b itu hasilnya di
         *    mata Java bukan lagi byte, melainkan int bernilai 100.
         *
         * 3, Nah, saat lo mencoba memasukkan hasil int itu kembali ke variabel bertipe byte, Java
         *    akan protes: "Eits, ini ember (int) nggak bisa lo tuang langsung ke gelas (byte) tanpa izin gue!"
         */

        int a = 7, b = 10;
        double c = 4.25, d = 5.80;

        // cast antara int dan double
        System.out.print("(double)(b / a) = " + (double)(b / a) + "\n");
        // hasilnya 1.0, karena b/a hasilnya masih integer, kemudian hasilnya dikonversi jadi double
        System.out.print("(int)(c) + (int)(d) = " + ((int)(c) + (int)(d)) + "\n");
        // hasilnya 9, karena keduanya di casting dulu ke integer, kemudian di jumlahkan. 4 + 5 = 9
        System.out.print("(int)(c + d) = " + ((int) (c + d)) + "\n");
        // hasilnya 10, karena dijumlahkan dulu baru dicasting ke integer, jadi 4.25 + 5.80 = 10,5 di casting jadi 10.
        System.out.print("(double)(a / b) + c = " + ((double) (a / b) + c) + "\n");
        // hasilnya 4.25, karena 0 * 7 hasilnya 0 hasilnya integer kemudian di casting jadi double 0,0 dan ditambahkan 4.25, jadi 0,0 + 4.25 = 4.25
        System.out.print("(double)(a) / b) + d = " + ((double)(a) / b + d) + "\n");
        // hasilnya 6.5 karena a menjadi double dan dibagi ke b, kemudian ditambahkan ke d, 7,0 / 10 = 0,7, 0,7 + 5.80, jadi 6.5

        System.out.println("\n---------------------------------");

        // cast char dan int
        char ch1 = 'A';
        char ch2 = 'F';

        System.out.println("(int)('A') = " + (int)(ch1)); // 65
        System.out.println("(int)('F') = " + (int)(ch2)); // 70
        System.out.println("'A' + 'F' = " + (int)(ch1 + ch2)); // 135
        System.out.println("(char)(74) = " + (char)(74)); // J
        System.out.println("(char)(48) = " + (char)(48)); // 0

        System.out.println("\n------------------------");

        // extra cast : perbandingan dua cara casting

        double totalArea = 2586.24;
        int minimumRoomArea = 120;

        // salah jika tanpa casting, jadi harus kita cast
        int numberOfRoomsPossible = (int)(totalArea / minimumRoomArea);

        System.out.println("numberOfRoomsPossible = " + numberOfRoomsPossible);
    }
}
