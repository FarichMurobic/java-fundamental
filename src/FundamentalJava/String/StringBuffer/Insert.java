package FundamentalJava.String.StringBuffer;

/**
 * insert()
 *
 * Method insert() menyisipkan satu string ke dalam string lainnya. 
 * Method ini di-overload untuk menerima semua tipe data primitif,
 * serta String, Object, dan CharSequence.
 * Seperti append(), method ini akan mengambil representasi string dari nilai yang diberikan.
 * String tersebut kemudian disisipkan ke dalam objek StringBuffer yang memanggilnya.
 *
 * Berikut beberapa bentuknya:
 * StringBuffer insert(int index, String str)
 * StringBuffer insert(int index, char ch)
 * StringBuffer insert(int index, Object obj)
 *
 * Di sini, index menentukan posisi di mana string akan disisipkan ke dalam objek StringBuffer.
 *
 * --------------------------------
 * 
 * 1. Apa itu insert()?
 * Fungsi:
 * Menyisipkan data ke posisi tertentu (index)
 *
 * Contoh dasar:
 * StringBuffer sb = new StringBuffer("Hello World");
 * sb.insert(6, "Beautiful ");
 *
 * Hasil:
 * "Hello Beautiful World"
 *
 * 2. Cara kerja index (WAJIB PAHAM)
 * "I Java!"
 *  0123456
 * sb.insert(2, "like ");
 *
 * Posisi 2 = sebelum huruf J
 * Hasil:
 * "I like Java!"
 *
 * 3. Bisa nerima banyak tipe data
 * sb.insert(0, 100);       // int
 * sb.insert(3, true);      // boolean
 * sb.insert(5, 'X');       // char
 * sb.insert(2, obj);       // object
 *
 * Semua akan diubah jadi string otomatis
 *
 * Sama kayak append (di balik layar)
 * String.valueOf(data)
 *
 * Perbandingan penting
 * Method	    Fungsi
 * append()	    tambah di akhir
 * insert()	    tambah di posisi tertentu
 *
 * Analogi biar nempel
 * append() = nambah kata di akhir kalimat
 * insert() = nyelip kata di tengah kalimat
 *
 * Insight penting (level naik)
 * insert() lebih “mahal” dari append()
 * karena harus geser karakter setelahnya
 * Tapi tetap lebih efisien dari String
 *
 * Kesimpulan (versi nempel keras)
 * insert(index, data) = sisipkan data di posisi tertentu
 * Bisa nerima banyak tipe data
 * Index:
 * mulai dari 0
 * gak boleh keluar batas
 *
 * Inti banget:
 * insert() = cara fleksibel buat nyelip string di mana aja
 */

public class Insert {
    public static void main(String[] args) {

        // Membuat StringBuffer dengan isi awal
        StringBuffer stringBuffer = new StringBuffer("i Java!");

        // Menyisipkan "like " pada index ke-2
        // index 2 = sebelum huruf 'J'
        stringBuffer.insert(2, "love ");
        // Menampilkan hasil
        System.out.println(stringBuffer); // i love Java!

        System.out.println("--------------------------");

        StringBuffer stringBuffer1 = new StringBuffer("Java");

        // Sisipkan di depan
        stringBuffer1.insert(0, "I love ");
        // Sisipkan di tengah
        stringBuffer1.insert(7, "very much, like i love Januar ");
        // Sisipkan di akhir (mirip append)
        stringBuffer1.insert(stringBuffer1.length(), "!!!");

        System.out.println(stringBuffer1);

    }
}
