package FundamentalJava.String.StringBuffer;

/**
 * reverse()
 *
 * Kamu bisa membalik urutan karakter dalam sebuah objek StringBuffer menggunakan method reverse().
 *
 * Bentuknya:
 * StringBuffer reverse()
 * Method ini mengembalikan hasil kebalikan dari objek yang memanggilnya.
 *
 * 1. Apa itu reverse()?
 * Fungsi:
 * Membalik urutan karakter dalam StringBuffer
 *
 * Contoh:
 * "abcdef"
 *
 * jadi:
 * "fedcba"
 *
 * 2. Penting: IN-PLACE (tidak bikin object baru)
 * Berbeda dengan String:
 * String → bikin object baru 
 * StringBuffer → ubah object yang sama 
 *
 * 3. Return value (buat chaining)
 * StringBuffer reverse()
 *
 * return:
 * object itu sendiri
 *
 * Jadi bisa:
 * sb.reverse().append("!!!");
 *
 * Hal yang perlu diperhatikan
 * reverse():
 * mengubah object langsung
 * bukan copy
 *
 * ----------------------------------------
 * 
 * Insight penting (level naik)
 * Kompleksitas:
 * O(n) → karena swap setengah karakter
 * Sangat efisien dibanding manual loop
 *
 * Kesimpulan (versi nempel keras)
 * reverse() = membalik isi string
 * Tidak bikin object baru (in-place)
 * Return object → bisa chaining
 */

public class Reverse {
    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer("Farich");
        System.out.println(stringBuffer);
        stringBuffer.reverse(); // hciraF
        System.out.println(stringBuffer);

    }
}
