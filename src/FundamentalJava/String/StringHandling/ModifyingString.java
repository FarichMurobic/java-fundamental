package FundamentalJava.String.StringHandling;

/**
 * Modifying a String
 *
 * Karena String di Java itu immutable (tidak bisa diubah):
 * setiap kali lo “mengubah” string
 * sebenarnya Java membuat object String baru
 *
 * Ada 2 cara:
 *
 * 1, Pakai:
 *    StringBuffer
 *    StringBuilder
 *
 * 2. Pakai method String yang menghasilkan string baru'
 *
 * substring()
 * DEFINISI
 *
 * 1. Versi 1 parameter
 * String substring(int startIndex)
 * ambil dari startIndex sampai akhir
 *
 * 2. Versi 2 parameter
 * String substring(int startIndex, int endIndex)
 *
 * ambil dari:
 * startIndex → sampai sebelum endIndex
 * endIndex tidak ikut (exclusive)
 *
 * concat()
 * DEFINISI
 * String concat(String str)
 * menggabungkan string
 *
 * replace()
 * 1. Replace char
 * String replace(char original, char replacement)
 * 2. Replace string
 * String replace(CharSequence original, CharSequence replacement)
 *
 * trim()
 * DEFINISI
 * String trim()
 *
 * menghapus:
 * spasi di depan
 * spasi di belakang
 *
 * KESIMPULAN DALAM
 * String = immutable
 * setiap perubahan = object baru
 *
 * Method penting:
 * Method	        Fungsi
 * substring	    ambil bagian string
 * concat	        gabung string
 * replace	        ganti isi
 * trim	            hapus spasi
 *
 * INTI PALING DALAM
 *
 * lo gak pernah benar-benar “ubah” string
 * lo selalu bikin string baru
 *
 * method-method ini = tools manipulasi data
 */

public class ModifyingString {
    public static void main(String[] args) {

        // 1. subString
        String org = "This is a test. This is, too.";
        String search = "is";
        String sub = "was";
        String result = "";
        int i;

        do {
            System.out.println(org);
            i = org.indexOf(search);

            if (i != -1) {
                result = org.substring(0, i);
                result = result + sub;
                result = result + org.substring(i + search.length());
                org = result;
            }
        } while (i != -1);

        System.out.println();

        // 2. concat
        String string1 = "one";
        String string2 = string1.concat("two");

        System.out.println(string2);

        // Output: onetwo
        // sama dengan String string2 = string1 + "two";

        // 3. replace

        // replace char
        String s = "Hello".replace('l', 'w');
        System.out.println(s);
        // Output: Hewwo

        // replace string
        String s1 = "Farich".replace("Farich", "Murobic");
        System.out.println(s1);

        // 4. trim
        String s2 = "     Hello     ".trim();
        System.out.println(s2);
    }
}
