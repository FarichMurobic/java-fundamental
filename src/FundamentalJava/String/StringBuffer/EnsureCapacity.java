package FundamentalJava.String.StringBuffer;

/**
 * ensureCapacity()
 *
 * Jika kamu ingin menyediakan ruang terlebih dahulu 
 * untuk sejumlah karakter setelah sebuah StringBuffer dibuat,
 * 
 * kamu bisa menggunakan ensureCapacity() untuk mengatur ukuran buffer.
 * Hal ini berguna jika kamu sudah tahu sebelumnya bahwa kamu akan 
 * menambahkan banyak string kecil ke dalam sebuah StringBuffer.
 *
 * Bentuk umum dari ensureCapacity() adalah:
 * void ensureCapacity(int minCapacity)
 *
 * Di sini, minCapacity menentukan ukuran minimum dari buffer. 
 * (Buffer yang lebih besar dari minCapacity bisa saja dialokasikan demi alasan efisiensi.)
 *
 * 1. Masalah yang ingin diselesaikan
 *
 * Bayangin lo punya code:
 * StringBuffer sb = new StringBuffer();
 *
 * capacity awal = 16
 *
 * Terus lo:
 * sb.append("a");
 * sb.append("b");
 * sb.append("c");
 * ... (ratusan kali)
 *
 * Masalah:
 * Buffer bakal resize berkali-kali
 * Setiap resize:
 * bikin array baru
 * copy data lama
 * BOROS waktu + memory
 *
 * Solusi: ensureCapacity()
 * sb.ensureCapacity(1000);
 *
 * Artinya:
 * “Bro, siapin tempat minimal 1000 karakter dari sekarang”
 *
 * Hasil:
 * append jadi lebih cepat
 * gak sering resize
 *
 * Penting: “minimum”, bukan “fix”
 * Kalau lo tulis:
 * sb.ensureCapacity(1000);
 *
 * Java bisa:
 * kasih 1000
 * atau lebih (misal 1024)
 *
 * Kenapa?
 * Karena Java optimize internal memory allocation
 *
 * ----------------------------
 * 
 * Kapan HARUS pakai ini?
 *
 * Pakai kalau:
 * Lo tahu bakal append banyak data
 * Contoh:
 * baca file besar 
 * loop panjang 
 * build string dari database/API 
 */

/**
 * Insight penting (level intermediate)
 * 
 * StringBuffer growth biasanya:
 * newCapacity = (oldCapacity * 2) + 2
 *
 * Makanya:
 * resize itu mahal
 * lebih baik prevent dari awal
 *
 * Kesimpulan (versi nempel keras)
 * ensureCapacity(int minCapacity) = set kapasitas minimum
 * 
 * Berguna untuk:
 * performa lebih cepat
 * menghindari resize berulang
 * Java bisa kasih kapasitas lebih besar dari yang diminta
 * Cocok untuk:
 * loop besar
 * append banyak string
 *
 * Inti banget:
 * Kalau lo tau bakal append banyak → prepare memory dari awal
 */

public class EnsureCapacity {
    public static void main(String[] args) {

        // Membuat StringBuffer kosong (capacity default = 16)
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println("Sebelum ensureCapacity():");
        System.out.println("Capacity: " + stringBuffer.capacity());

        // Menentukan kapasitas minimal 100
        // Biasanya >= 100 (bisa lebih tergantung implementasi)
        stringBuffer.ensureCapacity(100);

        System.out.println("\nSetelah ensureCapacity(100):");
        System.out.println("Capacity: " + stringBuffer.capacity());

        // Simulasi append banyak data
        for (int i = 0; i < 50; i++) {
            stringBuffer.append("A"); // menambahkan karakter A berulang
        }

        System.out.println("\nSetelah append 50 karakter:");
        System.out.println("Length: " + stringBuffer.length()); // 50
        System.out.println("Capacity: " + stringBuffer.capacity()); // tetap >= 100 (tidak resize)

        System.out.println("---------------------------------");

        // Bandingkan TANPA ensureCapacity

        StringBuffer stringBuffer1 = new StringBuffer();

        // Tanpa ensureCapacity
        for (int i = 0; i < 50; i++) {
            stringBuffer1.append(50);
        }

        // Capacity akan naik beberapa kali (resize berkali-kali)
        System.out.println("Length: " + stringBuffer1.length());
        System.out.println("Capacity: " + stringBuffer1.capacity());

        // Ini lebih lambat karena:
        // resize terjadi berulang kali

    }
}
