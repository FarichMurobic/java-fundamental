package String.StringHandling;

/**
 * Seperti kebanyakan bahasa pemrograman lainnya, di Java, string adalah urutan karakter (sequence of characters).
 * Namun, berbeda dengan beberapa bahasa lain yang mengimplementasikan string sebagai array karakter,
 * Java mengimplementasikan string sebagai objek dari tipe String.
 *
 * Mengimplementasikan string sebagai objek bawaan memungkinkan Java menyediakan berbagai
 * fitur lengkap yang memudahkan pengolahan string. Contohnya, Java menyediakan method untuk:
 * membandingkan dua string
 * mencari substring
 * menggabungkan dua string
 * mengubah huruf besar/kecil dalam string
 *
 * Selain itu, objek String bisa dibuat dengan berbagai cara, 
 * sehingga memudahkan kita mendapatkan string kapan pun dibutuhkan.
 *
 * Hal yang agak mengejutkan adalah:
 * ketika kamu membuat objek String, kamu sebenarnya membuat string yang tidak bisa diubah (immutable).
 * Artinya, setelah objek String dibuat, kamu tidak bisa mengubah karakter di dalamnya.
 *
 * Awalnya ini mungkin terlihat seperti batasan yang serius. Tapi sebenarnya tidak.
 * Kamu tetap bisa melakukan berbagai operasi string.
 * Bedanya adalah: setiap kali kamu butuh versi string yang sudah diubah,
 * Java akan membuat objek String baru yang berisi perubahan tersebut. String yang lama tetap tidak berubah.
 *
 * Pendekatan ini digunakan karena string yang tidak bisa diubah bisa diimplementasikan 
 * lebih efisien dibanding string yang bisa diubah.
 *
 * Untuk kasus di mana kamu butuh string yang bisa diubah, Java menyediakan dua kelas:
 * StringBuffer
 * StringBuilder
 *
 * Keduanya bisa menyimpan string yang bisa dimodifikasi setelah dibuat.
 *
 * Class String, StringBuffer, dan StringBuilder ada di package java.lang, jadi otomatis tersedia di semua program Java.
 * Ketiganya dideklarasikan sebagai final, artinya tidak bisa diturunkan (tidak bisa di-extend).
 * Semua kelas tersebut juga mengimplementasikan interface CharSequence.
 *
 * Poin terakhir:
 * Meskipun isi dari objek String tidak bisa diubah, 
 * variabel referensi String tetap bisa diarahkan ke objek String lain kapan saja.
 */

/**
 * 1. String di Java = Object, bukan array
 *
 * Di bahasa lain (misalnya C):
 * char name[] = "Farich";
 *
 * Di Java:
 * String name = "Farich";
 *
 * Ini bukan array, tapi object dari class String
 *
 * Artinya:
 * punya method
 * punya behavior
 * bukan sekadar kumpulan char
 *
 * 2. Kenapa String itu Immutable?
 *
 * Contoh:
 *
 * String s = "Hello";
 * s = s + " World";
 *
 * Kelihatannya kayak "mengubah" string...
 * Padahal yang terjadi:
 * "Hello" dibuat (object 1)
 * "Hello World" dibuat (object 2)
 * s sekarang menunjuk ke object baru
 *
 * Object lama tetap ada, gak diubah.
 *
 * 3. Kenapa dibuat immutable?
 * Ini penting banget (level backend banget):
 *
 * Alasan utama:
 * Performance (String Pool)
 * Security
 * Thread-safe
 *
 * Contoh String Pool
 * String a = "Hello";
 * String b = "Hello";
 *
 * Ini TIDAK bikin 2 object!
 *
 * Java simpan di String Pool:
 * "Hello" cuma 1 di memory
 * a dan b refer ke object yang sama
 *
 * Kalau string bisa diubah → kacau
 *
 * 4. Mutable String (StringBuilder & StringBuffer)
 * Kalau lo sering ubah string:
 * Jangan pakai:
 *
 * String s = "";
 * for(int i=0; i<1000; i++){
 *     s = s + i;
 * }
 *
 * Ini bikin 1000 object
 *
 * Pakai:
 * StringBuilder sb = new StringBuilder();
 *
 * Kenapa?
 * bisa diubah langsung
 * gak bikin object baru terus
 *
 * String vs StringBuilder vs StringBuffer
 * Tipe	            Mutable	    Thread Safe	    Cepat
 * String	        tidak	    ya	            ya
 * StringBuffer	    ya	        ya	            tidak terlalu
 * StringBuilder	ya	        tidak	        ya
 *
 * Kesimpulan Simpel (BIAR NEMPEL)
 *
 * String di Java adalah object, bukan array
 * String itu immutable (tidak bisa diubah)
 * Kalau "diubah", sebenarnya bikin object baru
 * Ini dibuat untuk:
 *
 * efisiensi
 * keamanan
 * thread safety
 *
 * Kalau butuh ubah string berkali-kali:
 * pakai StringBuilder (paling sering di backend)
 *
 * Insight Backend
 * Di dunia backend:
 *
 * Case nyata:
 * parsing JSON
 * logging
 * build query
 * generate response
 *
 * Kalau lo salah pakai String:
 * bisa bikin aplikasi lo lemot parah + boros memory
 *
 * Makanya:
 * gunakan String → untuk data tetap
 * gunakan StringBuilder → untuk manipulasi
 */

public class StringHandling {
    public static void main(String[] args) {

        // Contoh Immutable String

        // Membuat String awal
        String s = "Hello";

        // Ini bukan mengubah "Hello"
        // Tapi membuat object baru "Hello World"
        s = s + " World";

        // Output hasil
        System.out.println(s);

        // Penjelasan:
        // 1. "Hello" dibuat di memory
        // 2. "Hello World" dibuat object baru
        // 3. variabel s sekarang menunjuk ke object baru
        // 4. "Hello" tetap ada (tidak berubah)

        // Contoh Mutable String (StringBuilder)

        // Membuat StringBuilder (mutable)
        StringBuilder sb = new StringBuilder("Hello");

        // Ini benar-benar mengubah isi object yang sama
        sb.append(" World");

        // Output
        System.out.println(sb);

        // Penjelasan:
        // Tidak membuat object baru
        // Memory lebih hemat
        // Lebih cepat untuk operasi berulang

        // Contoh Reference Bisa Berubah

        // Membuat object pertama
        String a = "Hello";

        // Mengganti referensi ke object baru
        a = "Java";

        // Output
        System.out.println(a);

        // Penjelasan:
        // "Hello" tetap ada di memory
        // Tapi a sekarang menunjuk ke "Java"

    }
}
