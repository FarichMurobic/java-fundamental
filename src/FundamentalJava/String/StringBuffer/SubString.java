package FundamentalJava.String.StringBuffer;

/**
 * substring()
 *
 * Kamu bisa mengambil sebagian isi dari StringBuffer dengan memanggil method substring().
 *
 * Method ini memiliki dua bentuk:
 * String substring(int startIndex)
 * String substring(int startIndex, int endIndex)
 *
 * Bentuk pertama mengembalikan substring yang dimulai dari startIndex sampai ke akhir objek StringBuffer.
 * Bentuk kedua mengembalikan substring yang dimulai dari startIndex sampai endIndex - 1.
 *
 * Method ini bekerja sama seperti method substring() pada String yang telah dijelaskan sebelumnya.
 *
 * Apa itu substring()?
 *
 * Fungsi:
 * Mengambil sebagian isi string
 *
 * POIN PENTING BANGET
 *
 * substring() itu:
 * TIDAK mengubah StringBuffer
 * Mengembalikan String (bukan StringBuffer)
 *
 * Dua Bentuk substring()
 * A. Satu parameter
 * substring(startIndex)
 *
 * Ambil dari index sampai akhir
 *
 * Contoh:
 * StringBuffer sb = new StringBuffer("Hello World");
 * String result = sb.substring(6);
 *
 * hasil:
 * "World"
 *
 * B. Dua parameter
 * substring(startIndex, endIndex)
 *
 * Ambil dari start sampai endIndex - 1
 *
 * Contoh:
 * StringBuffer sb = new StringBuffer("Hello World");
 * String result = sb.substring(0, 5);
 *
 * hasil:
 * "Hello"
 *
 * RULE PENTING: endIndex EXCLUSIVE
 * "Hello"
 *  01234
 * substring(1, 4)
 *
 * ambil:
 * index 1 → e
 * index 2 → l
 * index 3 → l
 *
 * hasil:
 * "ell"
 *
 * Perbandingan penting
 * Method	        Return	        Mengubah data?
 * substring()	    String	        tidak
 * delete()	        StringBuffer	ya
 * replace()	    StringBuffer	ya
 *
 * Kesimpulan (versi nempel keras)
 * substring() = ambil sebagian string
 * Tidak mengubah StringBuffer
 * Return = String
 * endIndex = tidak ikut (exclusive)
 *
 * Inti banget:
 * substring() = ambil data, bukan ubah data
 */

public class SubString {
    public static void main(String[] args) {

        // Membuat StringBuffer
        StringBuffer sb = new StringBuffer("Hello World");

        // 1. substring(startIndex)
        String result1 = sb.substring(6);
        // Ambil dari index 6 sampai akhir → "World"

        System.out.println("Substring dari index 6: " + result1);

        // 2. substring(startIndex, endIndex)
        String result2 = sb.substring(0, 5);
        // Ambil dari index 0 sampai 4 → "Hello"

        System.out.println("Substring 0-5: " + result2);

        // 3. Cek bahwa StringBuffer tidak berubah
        System.out.println("StringBuffer asli: " + sb);

    }
}
