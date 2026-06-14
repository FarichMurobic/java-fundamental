package FundamentalJava.String.StringHandling;

/**
 * Searching Strings
 *
 * Class String menyediakan dua method untuk mencari karakter atau substring:
 *
 * 1. indexOf()
 * Mencari kemunculan pertama
 *
 * 2. lastIndexOf()
 * Mencari kemunculan terakhir
 *
 * Semua method ini:
 * return index
 * kalau tidak ditemukan → return -1
 *
 * BENTUK METHOD (LENGKAP)
 * Cari karakter
 * int indexOf(int ch)
 * int lastIndexOf(int ch)
 *
 * ch = karakter
 *
 * Cari substring
 * int indexOf(String str)
 * int lastIndexOf(String str)
 *
 * Dengan start index
 * int indexOf(int ch, int startIndex)
 * int lastIndexOf(int ch, int startIndex)
 *
 * int indexOf(String str, int startIndex)
 * int lastIndexOf(String str, int startIndex)
 *
 * PERBEDAAN PENTING
 * Method	        Arah pencarian
 * indexOf	        kiri ➜ kanan
 * lastIndexOf	    kanan ➜ kiri
 *
 * HAL PENTING BANGET (JANGAN SAMPAI MISS)
 * 1. Return -1 kalau gak ketemu
 * int result = s.indexOf("xyz");
 *
 * hasil:
 * -1
 *
 * 2. Case-sensitive
 * s.indexOf("The")
 *
 * beda dengan:
 * s.indexOf("the") 
 *
 * 3. Tidak mengubah string
 * semua method ini:
 * cuma baca
 * tidak modify string
 */

public class SearchingString {
    public static void main(String[] args) {

        String s = "Now is the time for all good men " +
                "to come to the aid of their country.";

        System.out.println(s);

        // cari huruf 't' pertama
        // ketemu di index 7
        System.out.println("indexOf(t) = " + s.indexOf('t'));
        // cari dari belakang
        // ketemu terakhir di index 65
        System.out.println("lastIndexOf(t) = " + s.lastIndexOf('t'));

        // cari substring "the" pertama
        // ketemu di index 7
        System.out.println(s.indexOf("the"));
        // cari "the" terakhir
        // ketemu di index 55
        System.out.println(s.lastIndexOf("the"));

        // mulai dari index 10
        // ketemu di index 11
        System.out.println(s.indexOf('t',10));
        // mulai dari index 60 (mundur ke kiri)
        // ketemu di index 55
        System.out.println(s.lastIndexOf('t', 60));

        // cari "the" mulai dari index 10
        // ketemu di index 44
        System.out.println(s.indexOf("the", 10));
        // cari "the" dari index 60 ke kiri
        // ketemu di index 55
        System.out.println(s.lastIndexOf("the", 60));

        System.out.println();

        // 1. Cek substring ada atau tidak
        String string1 = "Hello Java";

        if (string1.indexOf("Java") != -1)
            System.out.println("ketemu");

        // Penjelasan:
        // indexOf != -1 berarti ada

        // 2. Ambil posisi semua karakter
        String string2 = "test text";
        int index = s.indexOf('t');

        while (index != -1) {
            System.out.println("ketemu di index: " + index);
            index = string2.indexOf('t', index + 1);
        }

        // Penjelasan:
        // looping cari semua 't'
    }
}
