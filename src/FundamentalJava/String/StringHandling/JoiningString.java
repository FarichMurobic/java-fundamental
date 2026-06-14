package FundamentalJava.String.StringHandling;

import java.util.Arrays;
import java.util.List;

/**
 * Joining Strings
 *
 * Di Java (mulai JDK 8), ada method baru:
 * String.join()
 *
 * Digunakan untuk:
 * menggabungkan banyak string menjadi satu, dengan pemisah (delimiter)
 *
 * Bentuk method
 * Versi 1 (langsung list parameter)
 * static String join(CharSequence delim, CharSequence... strs)
 *
 * Parameter	    Arti
 * delim	        pemisah
 * strs	            kumpulan string
 *
 * karena String implement CharSequence, maka:
 * String.join(" ", "A", "B", "C")
 * valid
 *
 * VERSI KE-2 (ITERABLE)
 * Bentuk
 * static String join(CharSequence delim, Iterable<? extends CharSequence> strs)
 *
 * Artinya:
 * bisa pakai:
 * List
 * Set
 * dll
 *
 * KESIMPULAN PALING DALAM
 *
 * String.join() = cara modern gabung string
 * pakai delimiter
 * lebih clean daripada +
 *
 * support:
 * banyak string
 * array
 * list (Iterable)
 *
 * INTI AKHIR
 * kalau lo lihat:
 * String.join(...)
 *
 * itu artinya:
 * “gabung semua data jadi satu string dengan format tertentu”
 */

public class JoiningString {
    public static void main(String[] args) {

        String result = String.join(" ", "Alpha", "Beta", "Gamma");
        System.out.println(result);

        result = String.join(",", "John", "ID#: 569", "E-mail: Farich@Murobiq.com");
        System.out.println(result);

        System.out.println();

        List<String> names = Arrays.asList("Farich", "Janera", "El");
        String result1 = String.join(" | ", names);
        System.out.println(result1);

    }
}
