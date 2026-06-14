package FundamentalJava.String.StringHandling;

/**
 * String Pool itu memang bagian dari memori, tapi bukan sekadar memori biasa.
 *
 * Lebih tepatnya:
 * String Pool = area khusus di memori (heap) yang dipakai Java untuk nyimpen String yang sama biar gak dobel
 *
 * Di Java, semua object disimpan di:
 * Heap Memory
 *
 * Nah, khusus untuk String, Java bikin area khusus di dalam heap yang namanya:
 * String Constant Pool
 *
 * Tujuannya:
 * Hemat memori
 * Optimasi performa
 *
 * Contoh biar kebayang
 * String a = "Farich";
 * String b = "Farich";
 *
 * Yang terjadi:
 * Java cek dulu ke String Pool
 * "Farich" udah ada belum?
 *
 * Kalau belum:
 * disimpan ke pool
 *
 * Kalau sudah:
 * gak bikin object baru, tapi b refer ke object yang sama
 *
 * Jadi:
 * a == b  // true
 *
 * Karena mereka nunjuk ke object yang sama di pool
 *
 * Bandingkan dengan new String()
 * String a = new String("Farich");
 * String b = new String("Farich");
 *
 * Yang terjadi:
 * String "Farich" tetap masuk ke pool
 * Tapi new String() bikin object BARU di heap (di luar pool)
 *
 * Jadi:
 * a == b  // false
 *
 * Karena:
 * a dan b beda object
 * walaupun isinya sama
 *
 * Kesimpulan
 * String Pool = bagian dari heap memory
 * Digunakan untuk reuse String literal
 * Bikin program lebih hemat memori
 * new String() bypass pool (bikin object baru)
 */

public class StringPool {
    public static void main(String[] args) {
        
        System.out.println("Hello");
    }
}
