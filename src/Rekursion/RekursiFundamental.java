package Rekursion;

public class RekursiFundamental {

    /**
     * Kenapa rekursi bisa memanggil dirinya terus menerus, bukan hanya sekali?
     * Jawabannya ada di alur eksekusi method + call stack di JVM.
     * Program Java Selalu Dieksekusi Baris Demi Baris
     */

    static void test(int n) {
        // base case
        if (n == 0)
            return;

        System.out.println(n);
        // rekursif
        test(n - 1);
    }

    public static void main(String[] args) {

        test(3);
    }

    /**
     * Sekarang kita lihat bagaimana JVM mengeksekusinya.
     * Pemanggilan Pertama
     *
     * Program mulai:
     * test(3)
     *
     * Eksekusi:
     * if(n == 0) → false
     * print
     *
     * test(2)
     * Karena ada baris:
     * test(n - 1);
     *
     * maka method dipanggil lagi.
     * Program lompat ke awal method lagi.
     *
     * Pemanggilan Kedua
     * Sekarang yang berjalan adalah:
     * test(2)
     *
     * Eksekusi lagi:
     * if(n == 0) → false
     * print 2
     * test(1)
     *
     * Method dipanggil lagi.
     *
     * Pemanggilan Ketiga
     * test(1)
     *
     * Eksekusi:
     * if(n == 0) → false
     * print 1
     * test(0)
     *
     * Method dipanggil lagi.
     *
     * Pemanggilan Keempat (Base Case)
     * test(0)
     *
     * Eksekusi:
     * if(n == 0) → true
     * return
     *
     * Di sinilah rekursi berhenti.
     */

    /**
     * Kenapa Bisa Terus Dipanggil?
     * Karena setiap pemanggilan method membuat eksekusi baru.
     * Java tidak membatasi bahwa method hanya boleh dipanggil sekali.
     *
     * Setiap baris ini:
     * test(n - 1);
     *
     * artinya:
     * "jalankan method ini lagi dengan parameter baru"
     * Selama kondisi ini masih terpenuhi:
     * n != 0
     * method akan terus memanggil dirinya lagi.
     *
     * Peran Call Stack (Ini Yang Paling Penting)
     * Setiap method dipanggil, JVM menyimpan informasi di Stack Memory.
     * Misalnya:
     * test(3)
     * Stack:
     * test(3)
     *
     * Kemudian:
     * test(2)
     * Stack:
     * test(3)
     * test(2)
     *
     * Kemudian:
     * test(1)
     * Stack:
     * test(3)
     * test(2)
     * test(1)
     *
     * Kemudian:
     * test(0)
     * Stack:
     * test(3)
     * test(2)
     * test(1)
     * test(0)
     *
     * Ketika test(0) return, stack mulai dibongkar:
     * test(1) selesai
     * test(2) selesai
     * test(3) selesai
     */

    /**
     * Kenapa Tidak Hanya Sekali?
     * Karena method dipanggil lagi dari dalam dirinya sendiri.
     * Baris ini:
     * test(n - 1);
     * adalah pemanggilan baru, bukan lanjutan yang lama.
     * Setiap kali dipanggil:
     * -method baru dibuat
     * -parameter baru dibuat
     * -stack baru dibuat
     *
     * Makanya bisa:
     * test()
     * test()
     * test()
     * test()
     *
     * berulang-ulang.
     */

    /**
     * Cara Berpikir Rekursi Yang Benar
     *
     * Ketika melihat:
     * test(n - 1);
     *
     * jangan pikir:
     * method berjalan lagi
     *
     * Tapi pikir:
     * method baru dibuat
     * Jadi sebenarnya seperti ini:
     * test(3)
     *    └ test(2)
     *         └ test(1)
     *              └ test(0)
     *
     * Kesimpulan
     * Rekursi bisa memanggil dirinya berkali-kali karena:
     * Ada statement pemanggilan method di dalam method itu sendiri.
     * Setiap pemanggilan membuat instance eksekusi baru.
     * JVM menyimpannya di call stack.
     * Proses berhenti ketika base case terpenuhi.
     */
}
