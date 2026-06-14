package FundamentalJava.String.StringHandling;

    /**
     * Class String adalah salah satu class yang paling sering digunakan di Java.
     * Karena string (teks) itu bagian penting dalam programming.
     *
     * Hampir semua program:
     * input user
     * output
     * nama, teks, dll
     * pasti pakai String
     *
     * String itu Object
     * Setiap string yang lo buat itu sebenarnya adalah object dari class String.
     * Bahkan string literal (yang pakai tanda " ") juga object.
     * Contoh:
     * System.out.println("This is a String, too");
     * "This is a String, too" itu object String
     *
     * ----------------------------------------------------
     * 
     * Immutable (INI KRUSIAL)
     * String itu immutable → tidak bisa diubah setelah dibuat.
     *
     * Misal:
     * String s = "Halo";
     * s = "Dunia";
     * bukan mengubah string lama
     * tapi bikin object baru!
     *
     * Kenapa gak masalah?
     * Bisa bikin string baru
     * Ada class lain:
     * StringBuffer
     * StringBuilder
     * yang bisa diubah (mutable)
     */

public class ClassString {
    public static void main(String[] args) {

        String objek1 = "First String"; // objek string 1
        String objek2 = "Second String"; // objek string 2

        // gabung string
        String objek3 = objek1 + " and " + objek2;

        // tampilkan semua
        System.out.println(objek1);
        System.out.println(objek2);
        System.out.println(objek3);

        /**
         * String itu:
         * Object (class String)
         * Immutable (tidak bisa diubah)
         * Banyak method untuk manipulasi teks
         *
         * Semua method String itu TIDAK mengubah string asli, tapi menghasilkan string baru
         */

        System.out.println("----------");

        String a = "Hello";
        String b = "hello";
        String c = "Hello";
        String d = "World";

        // TABEL METHOD STRING (LENGKAP & TERSTRUKTUR
        /**
         * A. Method Perbandingan
         * Method	                        Fungsi	                                        Contoh
         * equals(String s)	                Bandingin isi string	                        "a".equals("a") → true
         * equalsIgnoreCase(String s)	    Bandingin tanpa peduli huruf besar/kecil	    "A".equalsIgnoreCase("a") → true
         * compareTo(String s)	            Bandingkan urutan (ASCII/Unicode)	            "a".compareTo("b") → -1
         * compareToIgnoreCase(String s)	Sama tapi ignore case
         */

        // 1. equals()
        System.out.println("equals():");
        System.out.println(a.equals(c)); // true (isi sama persis)
        System.out.println(a.equals(b)); // false (beda huruf besar/kecil)
        System.out.println("a".equals("a")); // membandingkan langsung string

        // 2. equalsIgnoreCase()
        System.out.println("\nequalsIgnoreCase():");
        System.out.println(a.equalsIgnoreCase(b)); // true (abaikan huruf besar/kecil)
        System.out.println("a".equalsIgnoreCase("b")); // false a dan b beda

        // 3. compareTo()
        System.out.println("\ncompareTo():");
        System.out.println(a.compareTo(c)); // 0 (sama)
        System.out.println(a.compareTo(d)); // negatif (Hello < World)
        System.out.println(d.compareTo(a)); // positif (World > Hello)
        System.out.println("a".compareTo("c")); // -2

        // 4. compareToIgnoreCase()
        System.out.println("\ncompareToIgnoreCase():");
        System.out.println(a.compareToIgnoreCase(c)); // 0 (dianggap sama) tanpa pedulikan huruf besar dan kecil
        System.out.println("a".compareToIgnoreCase("A")); // 0

        System.out.println();

        /**
         * B. Method Pencarian
         * Method	                         Fungsi	                                        Contoh
         * contains(CharSequence s)	         Cek apakah ada substring	                    "java".contains("av")
         * indexOf(String s)	             Cari index pertama	                            "java".indexOf("a") → 1
         * lastIndexOf(String s)	         Cari index terakhir	                        "java".lastIndexOf("a") → 3
         * startsWith(String s)	             Awalan	                                        "java".startsWith("ja")
         * endsWith(String s)	             Akhiran	                                    "java".endsWith("va")
         */

        String teks = "Belajar Java itu seru";

        // 1. contains()
        System.out.println("contains():");
        System.out.println(teks.contains("Java")); // true
        System.out.println(teks.contains("Python")); // false
        System.out.println("Farich Murobic".contains("obic")); // true, ada substring obic di kata murobic

        // 2. indexOf()
        System.out.println("\nindexOf():");
        System.out.println(teks.indexOf("Java")); // 8, posisi awal "Java"
        System.out.println(teks.indexOf("a")); // 3, cari indek huruf a pertama
        System.out.println("Meong".indexOf("o")); // 2

        // 3. lastIndexOf()
        System.out.println("\nlastIndexOf():");
        System.out.println(teks.lastIndexOf("a")); // huruf 'a' terakhir
        System.out.println("bebek".lastIndexOf("b")); // 2

        // 4. startsWith()
        System.out.println("\nstartsWith():");
        System.out.println(teks.startsWith("Belajar")); // true
        System.out.println(teks.startsWith("belajar")); // false, karena case sensitif
        System.out.println(teks.startsWith("Java")); // false
        System.out.println("bebek".startsWith("b")); // true

        // 5. endsWith()
        System.out.println("\nendsWith():");
        System.out.println(teks.endsWith("seru")); // true
        System.out.println(teks.endsWith("u")); // true
        System.out.println(teks.endsWith("Java")); // false
        System.out.println("bebek".endsWith("b")); // false

        System.out.println();

        /**
         * C. Method Panjang & Akses
         * Method	                        Fungsi	                                        Contoh
         * length()	                        Panjang string	                                "java".length() → 4
         * charAt(int index)	            Ambil karakter	                                "java".charAt(0) → 'j'
         * toCharArray()	                Ubah ke array char
         */

        // 1. length()
        System.out.println("length():");
        System.out.println(teks.length()); // 21
        System.out.println("Bebek".length()); // 5

        // 2. charAt()
        System.out.println("\ncharAt():");
        System.out.println(teks.charAt(1)); // e
        System.out.println("bebek".charAt(4));

        // 3. toCharArray()
        System.out.println("\ntoCharArray():");
        char[] arr = teks.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Index " + i + ": " + arr[i]);
        }

        System.out.println();

        /**
         * D. Method Manipulasi (BUAT STRING BARU)
         * Method	                        Fungsi	                                        Contoh
         * substring(int begin)	            Ambil dari index tertentu	                    "java".substring(2) → "va"
         * substring(int begin, int end)	Ambil range	                                    "java".substring(1,3) → "av"
         * replace(char old, char new)	    Ganti karakter	                                "java".replace('a','o') → "jovo"
         * replace(String old, String new)	Ganti string
         * toLowerCase()	                Huruf kecil semua
         * toUpperCase()	                Huruf besar semua
         * trim()	                        Hapus spasi depan & belakang	                " hi ".trim()
         * strip()	                        Versi modern trim
         * concat(String s)	                Gabung string	                                "a".concat("b") → "ab"
         */

        String text = "  Java Programming  ";

        // 1. substring()
        System.out.println("substring:");
        System.out.println(text.substring(7));
        System.out.println("Murobic".substring(1));
        System.out.println(text.substring(1,5));
        System.out.println("Murobic".substring(2,5));

        // 2. replace()
        System.out.println("\nreplace:");
        System.out.println(text.replace('a', 'o'));
        System.out.println("java".replace('a', 'o')); // jovo
        System.out.println("java java".replace("java", "php")); // php php

        // 3. toLowerCase & toUpperCase
        System.out.println("\nCase:");
        System.out.println("JAVA".toLowerCase()); // java
        System.out.println("java".toUpperCase()); // JAVA

        // 4. trim & strip
        System.out.println("\nTrim / Strip:");
        System.out.println(teks.trim());  // hapus spasi depan belakang
        System.out.println(teks.strip()); // versi modern

        // 5. concat()
        System.out.println("\nconcat:");
        System.out.println("Hello".concat(" World")); // Hello World

        System.out.println();

        /**
         * E. Method Validasi
         * Method	                        Fungsi	                                        Contoh
         * isEmpty()	                    Cek kosong	                                    ""
         * isBlank()	                    Cek kosong + spasi	                            " "
         */

        String a1 = "";
        String b1 = "   ";
        String c1 = "Java";

        // 1. isEmpty()
        System.out.println("isEmpty():");
        System.out.println(a1.isEmpty()); // true
        System.out.println(b1.isEmpty()); // false (karena ada spasi)
        System.out.println(c1.isEmpty()); // false

        // 2. isBlank()
        System.out.println("\nisBlank():");
        System.out.println(a1.isBlank()); // true
        System.out.println(b1.isBlank()); // true (spasi dianggap kosong)
        System.out.println(c1.isBlank()); // false

        System.out.println();

        /**
         * F. Method Split & Join
         * Method	                        Fungsi	                                        Contoh
         * split(String regex)	            Pecah string	                                "a,b".split(",")
         * join(delimiter, data)	        Gabung array
         */

        // 1. split()
        String data = "apel,jeruk,mangga";

        String[] hasil = data.split(",");

        System.out.println("Hasil split:");
        for (String buah : hasil) {
            System.out.println(buah);
        }

        // 2. join()
        String gabung = String.join("-", hasil);

        System.out.println("\nHasil join:");
        System.out.println(gabung); // apel-jeruk-mangga

        System.out.println();

        /**
         * G. Method Lain (Advanced)
         * Method	                        Fungsi
         * valueOf()	                    Convert ke String
         * intern()	                        Masuk ke String pool
         * matches(regex)	                Cocokkan regex
         * repeat(int n)	                Ulang string
         * format()	                        Format seperti printf
         */

        // 1. valueOf()
        int angka = 100;
        String s1 = String.valueOf(angka);
        System.out.println("valueOf: " + s1);

        // 2. intern()
        String aa = new String("Java");
        String bb = "Java";

        System.out.println("\nintern:");
        System.out.println(aa == bb);           // false
        System.out.println(aa.intern() == bb);  // true

        // 3. matches()
        String email = "test@gmail.com";
        System.out.println("\nmatches:");
        System.out.println(email.matches(".*@gmail\\.com")); // true

        // 4. repeat()
        System.out.println("\nrepeat:");
        System.out.println("ha".repeat(3)); // hahaha

        // 5. format()
        String nama = "Farich";
        int umur = 17;

        String result = String.format("Nama: %s, Umur: %d", nama, umur);
        System.out.println("\nformat:");
        System.out.println(result);
    }
}
