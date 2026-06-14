package FundamentalJava.String.StringBuffer;

/**
 * charAt() dan setCharAt()
 *
 * Nilai dari satu karakter dapat diambil dari sebuah StringBuffer menggunakan method charAt().
 * Kamu bisa mengatur nilai karakter di dalam StringBuffer menggunakan setCharAt().
 *
 * Bentuk umum dari kedua method ini adalah:
 * char charAt(int where)
 * void setCharAt(int where, char ch)
 *
 * Untuk charAt(), parameter where menentukan index karakter yang ingin diambil.
 * Untuk setCharAt(), parameter where menentukan index karakter yang ingin diubah, dan ch menentukan nilai baru dari karakter tersebut.
 * Untuk kedua method ini, nilai where harus tidak negatif dan tidak boleh melebihi panjang string.
 *
 * 1. charAt(int index)
 * Fungsi:
 *
 * Ambil 1 karakter dari posisi tertentu
 * Contoh:
 * "Hello"
 *  01234
 * char c = sb.charAt(1);
 *
 * Hasil:
 * 'e'
 *
 * 2. setCharAt(int index, char ch)
 * Fungsi:
 *
 * Ganti karakter di posisi tertentu
 * Contoh:
 * "Hello"
 *  01234
 * sb.setCharAt(1, 'i');
 *
 * Jadi:
 * "Hillo"
 *
 * --------------------------
 * 
 * RULE PENTING (WAJIB PAHAM)
 * 
 * Index harus:
 * ≥ 0
 * < length()
 *
 * Kalau gak:
 * StringIndexOutOfBoundsException
 *
 * Insight penting
 * charAt() = baca data
 * setCharAt() = ubah data
 *
 * Ini beda sama String:
 * String gak bisa ubah karakter langsung
 * StringBuffer bisa
 *
 * Kelebihan besar StringBuffer
 *
 * Lo bisa:
 * ubah karakter tanpa bikin object baru
 * manipulasi string secara efisien
 *
 * Kesimpulan (versi nempel keras)
 * charAt(index) = ambil karakter
 * setCharAt(index, char) = ubah karakter
 * Index:
 * mulai dari 0
 * gak boleh keluar batas
 *
 * Inti banget:
 * StringBuffer bisa manipulasi karakter langsung, bukan bikin ulang string
 */

public class CharAtAndSetCharAt {
    public static void main(String[] args) {

        // Membuat StringBuffer dengan isi awal
        StringBuffer stringBuffer = new StringBuffer("Hello");

        // Menampilkan isi awal buffer
        System.out.println("buffer before: " + stringBuffer); // Hello

        // Mengambil karakter pada index ke-1
        System.out.println("charAt(1) before: " + stringBuffer.charAt(1)); // e

        // Mengubah karakter pada index ke-1 menjadi 'i'
        stringBuffer.setCharAt(1, 'i');

        // Memotong panjang string jadi 2 karakter
        stringBuffer.setLength(2);

        // Menampilkan isi setelah perubahan
        System.out.println("buffer after: " + stringBuffer); // Hi

        // Mengambil karakter pada index ke-1 setelah perubahan
        System.out.println("charAt(1) after: " + stringBuffer.charAt(1)); // i
    }
}
