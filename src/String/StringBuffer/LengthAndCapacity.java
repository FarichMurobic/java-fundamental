package String.StringBuffer;

/**
 * length() dan capacity()
 *
 * Panjang saat ini dari sebuah StringBuffer bisa didapat melalui method length(),
 * sedangkan total kapasitas yang dialokasikan bisa didapat melalui method capacity().
 *
 * Bentuk umumnya adalah:
 * int length()
 * int capacity()
 *
 * 1. length() itu apa?
 * Jumlah karakter yang sedang dipakai
 *
 * Contoh:
 * "Hello"
 *
 * length = 5
 *
 * 2. capacity() itu apa?
 * Total ruang yang disediakan di memory
 *
 * Jadi:
 * Bisa lebih besar dari length
 * Dipakai buat antisipasi append
 *
 * Perbedaan penting (WAJIB PAHAM)
 * Method	        Arti
 * length()	        jumlah isi
 * capacity()	    kapasitas total
 *
 * Studi Kasus dari Contoh
 * StringBuffer sb = new StringBuffer("Hello");
 *
 * Yang terjadi:
 * Isi = "Hello" → 5 karakter
 * Java otomatis nambah 16 ruang ekstra
 *
 * Jadi:
 * capacity = 5 + 16 = 21
 *
 * Kenapa capacity lebih besar?
 * Karena:
 * Java “nyiapin tempat duluan” biar gak sering resize
 *
 * Apa itu resize / reallocation?
 *
 * Kalau kapasitas habis:
 * Java bikin buffer baru 
 * Copy data lama 
 * Buang yang lama 
 *
 * Ini mahal (lambat + boros memory)
 *
 * Kesimpulan (biar nempel keras)
 * length() = jumlah karakter yang dipakai
 * capacity() = total kapasitas buffer
 * Default:
 * tambah 16 karakter ekstra
 * Tujuan:
 * optimasi performa
 * hindari resize terus-terusan
 *
 * Inti banget:
 * StringBuffer itu bukan cuma nyimpen string, tapi juga “nyiapin ruang buat masa depan”
 */

public class LengthAndCapacity {

    public static void main(String[] args) {

        // Membuat StringBuffer dengan isi awal "Hello"
        StringBuffer stringBuffer = new StringBuffer("Hello");
        // Menampilkan isi buffer
        System.out.println(stringBuffer);

        // length() = jumlah karakter yang sedang digunakan
        // Output: 5 (karena "Hello" punya 5 huruf)
        System.out.println("Length: " + stringBuffer.length());

        // capacity() = total kapasitas yang tersedia di memory
        // Output: 21 (5 dari "Hello" + 16 tambahan default)
        System.out.println("Capacity: " + stringBuffer.capacity());

        System.out.println("------------------------------------");

        StringBuffer stringBuffer1 = new StringBuffer("Hello");
        System.out.println("Awal:");
        System.out.println("Length: " + stringBuffer1.length());
        System.out.println("Capacity: " + stringBuffer1.capacity());

        // Tambah isi sampai melewati capacity
        stringBuffer1.append(" bro ini tambahan string panjang banget");

        System.out.println("\nSetelah append:");
        System.out.println("Length: " + stringBuffer1.length());
        System.out.println("Capacity: " + stringBuffer1.capacity());
    }
}
