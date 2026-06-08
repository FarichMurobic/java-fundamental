package EscapeSequence;

        /**
         *  Escape sequence adalah kombinasi dua karakter yang dimulai dengan backslash (\)
         *  yang memungkinkanmu menyertakan karakter "spesial" dalam sebuah String. 
         *  Karakternya mungkin nggak bisa kamu ketik langsung atau punya makna khusus.
         *
         *  Memindahkan kursor ke awal baris saat ini                   \r Return
         *  Memindahkan kursor ke awal baris berikutnya	                \n	Newline
         *  Memindahkan kursor ke awal baris halaman berikutnya	        \f Form feed
         *  Memindahkan kursor ke posisi tab berhenti berikutnya	    \t	Tab
         *  Memindahkan kursor satu spasi ke kiri	                    \b	Backspace
         *  Mencetak karakter backslash	                                \\	Backslash
         *  Mencetak karakter kutip tunggal	                            \'	Single quotation
         *  Mencetak karakter kutip ganda	                            \"	Double quotation
         *
         *  Mencetak karakter Unicode (misal: simbol) Unicode Escape
         *  Mencetak karakter oktal (jarang dipakai) \0XXX	Octal Escape
         */

public class EscapeSequence {
    public static void main(String[] args) {
        
        System.out.println("-- Escape Sequence ---");
        System.out.println("A return\r<- character");
        System.out.println("A newline\n<- character");
        System.out.println("A tab stop\t<- character");
        System.out.println("A backspace\b<- character");
        System.out.println("A backslash\\<- character");
        System.out.println("A single quotation\'<- character");
        System.out.println("A double quotation\"<- character");

        // Unicode
        System.out.println("\u00A9 Kita Belajar");
        System.out.println("Emoji Wajah Senyum: \uD83D\uDE00");

        System.out.println("----------");

        System.out.println("Ini baris pertama.\nIni baris kedua.");

        /**
         * \n (Newline): Memindahkan kursor ke baris baru.
         * Analoginya: Tekan tombol ENTER.
         */

        System.out.println("Kolom1\tKolom2\tKolom3");

        /**
         * \t (Tab): Menambahkan spasi horizontal (tab).
         * Analoginya: Tekan tombol TAB.
         */

        System.out.println("Path file: C:\\FolderKu\\dokumen.txt");

        /**
         * \\ (Backslash): Mencetak karakter backslash itu sendiri.
         * Analoginya: Kamu mau cetak simbol \ , tapi karena \ itu spesial, harus pakai dua kali.
         */

        System.out.println("Dia bilang, \"Halo Dunia!\"");

        /**
         * \" (Double Quotation): Mencetak karakter kutip ganda di dalam String.
         * Analoginya: Kalau kutip ganda itu pembungkus String, kalau mau cetak pembungkusnya, harus "dibungkus lagi".
         */

        System.out.println("Itu adalah karakter tunggal: \'A\'");

        /**
         * \' (Single Quotation): Mencetak karakter kutip tunggal di dalam String.
         * Analoginya: Mirip dengan \" tapi untuk kutip tunggal.
         */

        System.out.println("Proses ini akan mundur: ABCDE\b\b\bFGHI");

        /**
         * \b (Backspace): Menghapus satu karakter ke belakang (menimpa).
         * Analoginya: Tekan tombol BACKSPACE di keyboard.
         */

        System.out.println("Mulai dari sini, lalu \rKembali ke awal.");

        /**
         * \r (Carriage Return): Memindahkan kursor ke awal baris saat ini, menimpa teks.
         * Analoginya: Seperti mesin ketik yang head-nya balik ke awal baris tanpa pindah baris.
         */

        System.out.println("Simbol Copyright: \u00A9");

        /**
         * (Unicode Escape): Mencetak karakter berdasarkan kode Unicode-nya.
         * Analoginya: Memanggil karakter dari "kamus" karakter dunia.
         */

        System.out.println("Simbol Euro: \u20AC");

        /**
         * Contoh lain Unicode Escape.
         */

        System.out.println("Emoji Wajah Senyum: \uD83D\uDE00");
        
        /**
         * Contoh Unicode untuk emoji (beberapa emoji butuh dua kode unicode).
         */
    }
}
