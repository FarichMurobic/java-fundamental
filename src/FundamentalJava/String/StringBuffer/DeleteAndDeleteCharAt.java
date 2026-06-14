package FundamentalJava.String.StringBuffer;

/**
 * delete() dan deleteCharAt()
 *
 * Kamu bisa menghapus karakter dalam StringBuffer menggunakan method delete() dan deleteCharAt().
 *
 * Bentuknya:
 * StringBuffer delete(int startIndex, int endIndex)
 * StringBuffer deleteCharAt(int loc)
 *
 * Method delete() menghapus sekumpulan karakter dari objek yang memanggilnya.
 * Di sini:
 * startIndex = index awal yang akan dihapus
 * endIndex = index satu posisi setelah karakter terakhir yang dihapus
 *
 * Artinya:
 * karakter yang dihapus dari startIndex sampai endIndex - 1
 *
 * Method ini mengembalikan objek StringBuffer hasilnya.
 *
 * 1. delete(start, end)
 * Fungsi:
 * Hapus beberapa karakter sekaligus
 *
 * Penting: end itu EXCLUSIVE
 *
 * Contoh:
 * "This is a test."
 *  0123456789...
 * sb.delete(4, 7);
 *
 * Yang dihapus:
 * index 4 → ' '
 * index 5 → 'i'
 * index 6 → 's'
 *
 * hasil:
 * "This a test."
 *
 * 2. deleteCharAt(index)
 * Fungsi:
 * Hapus 1 karakter saja
 *
 * Perbandingan cepat
 * Method	            Fungsi
 * delete(start, end)	hapus banyak karakter
 * deleteCharAt(index)	hapus 1 karakter
 *
 * ----------------------------------------
 * 
 * Insight penting (level naik)
 * 
 * delete() dan insert():
 * sama-sama “geser karakter”
 * jadi lebih mahal dari append()
 * Tapi tetap jauh lebih efisien dari String
 *
 * Inti banget:
 * delete() = hapus banyak, deleteCharAt() = hapus satu
 */

public class DeleteAndDeleteCharAt {

    public static void main(String[] args) {

        // Membuat StringBuffer dengan isi awal
        StringBuffer sb = new StringBuffer("This is a test.");

        // Menghapus karakter dari index 4 sampai 6 (7 tidak ikut)
        sb.delete(4, 7);

        // Menampilkan hasil setelah delete
        System.out.println("After delete: " + sb);
        // Hasil: "This a test."

        // Menghapus karakter di index ke-0
        sb.deleteCharAt(0);

        // Menampilkan hasil setelah deleteCharAt
        System.out.println("After deleteCharAt: " + sb);
        // Hasil: "his a test."

    }
}
