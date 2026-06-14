package FundamentalJava.String.StringBuffer;

/**
 * replace()
 *
 * Kamu bisa mengganti satu kumpulan karakter dengan kumpulan karakter lain di dalam objek StringBuffer dengan memanggil replace().
 *
 * Bentuknya:
 * StringBuffer replace(int startIndex, int endIndex, String str)
 * Substring yang akan diganti ditentukan oleh index startIndex dan endIndex.
 *
 * Artinya:
 * substring dari startIndex sampai endIndex - 1 akan diganti.
 *
 * String pengganti diberikan melalui parameter str.
 * Method ini mengembalikan objek StringBuffer hasilnya.
 *
 * Contoh program:
 *
 * // Demonstrate replace()
 * class replaceDemo {
 *   public static void main(String args[]) {
 *     StringBuffer sb = new StringBuffer("This is a test.");
 *     sb.replace(5, 7, "was");
 *     System.out.println("After replace: " + sb);
 *   }
 * }
 *
 * Output:
 * After replace: This was a test.
 *
 * 1. Apa itu replace()?
 *
 * Fungsi:
 * Mengganti sebagian string dengan string baru
 *
 * 2. Cara kerja (WAJIB PAHAM)
 * replace(startIndex, endIndex, "teksBaru")
 *
 * Artinya:
 * Hapus substring lama
 * Ganti dengan string baru
 *
 * Penting: endIndex itu EXCLUSIVE
 * Contoh dari materi
 * "This is a test."
 *  0123456789...
 * sb.replace(5, 7, "was");
 *
 * Yang diganti:
 *
 * index 5 → 'i'
 * index 6 → 's'
 *
 * hasil:
 * "This was a test."
 *
 * Replace bisa beda panjang
 * Lebih panjang
 * StringBuffer sb = new StringBuffer("Hello");
 * sb.replace(0, 1, "HAAA");
 *
 * hasil:
 * "HAAAello"
 *
 * Lebih pendek
 * StringBuffer sb = new StringBuffer("Hello");
 * sb.replace(0, 4, "H");
 *
 * hasil:
 * "Ho"
 *
 * Di balik layar
 *
 * replace() itu sebenarnya gabungan:
 * delete() + insert()
 * Tapi lebih efisien karena langsung di-handle internal
 *
 * Perbandingan penting
 * Method	        Fungsi
 * delete()	        hapus
 * insert()	        tambah
 * replace()	    ganti
 *
 * Inti banget:
 * replace() = cara paling praktis buat ubah isi string di tengah
 *
 * PENUTUP BESAR (biar lo dapet gambaran full)
 *
 * Sekarang lo udah ngerti hampir semua senjata StringBuffer:
 * append → tambah belakang
 * insert → tambah tengah
 * delete → hapus
 * replace → ganti
 * reverse → balik
 * charAt / setCharAt → akses per karakter
 * getChars → copy ke array
 * setLength → paksa panjang
 * ensureCapacity → optimasi performa
 */

public class Replace {
    public static void main(String[] args) {

        // Membuat StringBuffer dengan isi awal
        StringBuffer sb = new StringBuffer("This is a test.");

        // Mengganti karakter dari index 5 sampai 6 (7 tidak ikut)
        // "is" diganti menjadi "was"
        sb.replace(5, 7, "was");

        // Menampilkan hasil
        System.out.println("After replace: " + sb);
        // Output: "This was a test."

        StringBuffer sb1 = new StringBuffer("I hate Java");

        // Ganti "hate" jadi "love"
        sb1.replace(2, 6, "love");

        System.out.println(sb1); // "I love Java"

    }
}
