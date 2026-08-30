package FundamentalJava.Variable;

/**
 * Variabel
 * 
 * Variabel adalah unit dasar penyimpanan dalam program Java. Variabel
 * didefinisikan oleh:
 * - Tipe: Jenis data yang bisa disimpan.
 * - Identifier: Nama variabel.
 * - Inisialisasi (opsional): Nilai awal yang ditetapkan.
 * - Lingkup (Scope): Bagian program di mana variabel terlihat.
 * - Masa Hidup (Lifetime): Periode di mana variabel itu ada.
 *
 * Deklarasi dan Inisialisasi Dinamis.
 * Semua variabel harus dideklarasikan sebelum digunakan. Lo bisa
 * mendeklarasikan beberapa
 * variabel sekaligus dengan tipe yang sama menggunakan koma. Inisialisasi bisa
 * dilakukan secara
 * dinamis, menggunakan ekspresi yang valid pada saat deklarasi.
 */

public class Variabel {

    public static void main(String[] args) {

        /**
         * VARIABEL ADALAH TEMPAT UNTUK MENYIMPAN DATA
         *
         * Di Java, variabel harus dideklarasikan dengan tipe data sebelum digunakan.
         * Format umumnya:
         * TipeData namaVariabel = nilai;
         *
         * Aturan umum untuk penamaan variabel adalah :
         * -Nama dapat berisi huruf, angka, garis bawah (underscore), dan tanda dolar
         * -Nama harus dimulai dengan huruf tidak boleh angka
         * -Nama harus dimulai dengan huruf kecil, dan tidak boleh mengandung spasi
         * -Nama juga bisa dimulai dengan $ dan _
         * -Nama peka huruf besar/kecil ("myVar" dan "myvar" adalah variabel yang
         * berbeda)
         * -Kata-kata yang dicadangkan (seperti kata kunci Java, seperti int atau
         * boolean) tidak dapat digunakan sebagai nama variabel
         */

        byte variabelByte;
        short variabelShort;
        int variabelInteger;
        long variabelLong;
        float variabelFloat;
        double variabelDouble;
        char variabelChar;
        boolean variabelBoolean;
        String variabelString;

        System.out.println("\n--- Inisialisasi Dinamis ---");
        double double1 = 3.0, double2 = 4.0;
        // double3 is dynamically initialized
        double double3 = Math.sqrt(double1 * double1 + double2 * double2);
        System.out.println("Hypotenuse is " + double3);
        // Di sini, nilai double3 dihitung menggunakan hasil dari ekspresi
        // Math.sqrt(...), bukan nilai konstan.

        System.out.println();

        /**
         * Lingkup dan Masa Hidup Variabel
         * 
         * Dalam Java, lingkup (scope) didefinisikan oleh blok kode, yaitu area di
         * antara kurung kurawal
         * { dan }. Lingkup menentukan visibilitas dan masa hidup variabel.
         *
         * Aturan Penting tentang Lingkup:
         * 1. Variabel Lokal: Variabel yang dideklarasikan di dalam sebuah blok hanya
         * terlihat
         * dan dapat diakses di dalam blok itu saja.
         * 2. Lingkup Bersarang: Lingkup bisa bersarang. Variabel yang dideklarasikan di
         * lingkup luar (outer scope)
         * dapat diakses oleh kode di lingkup dalam (inner scope), tetapi tidak
         * sebaliknya.
         * 3. Masa Hidup: Variabel diciptakan saat lingkupnya dimasuki dan dihancurkan
         * saat lingkupnya ditinggalkan.
         * Ini berarti nilai variabel tidak akan bertahan jika lingkupnya berakhir.
         * 4. Inisialisasi Ulang: Jika sebuah variabel diinisialisasi di dalam sebuah
         * blok,
         * ia akan diinisialisasi ulang setiap kali blok itu dimasuki.
         * 5. Nama Variabel: Lo tidak bisa mendeklarasikan variabel dengan nama yang
         * sama di lingkup dalam
         * jika nama tersebut sudah digunakan di lingkup luar.
         */

        // Program ini menunjukkan masa hidup variabel y yang pendek
        int x;
        for (x = 0; x < 3; x++) {
            int y = -1; // y diinisialisasi setiap kali blok dimasuki
            System.out.println("y is: " + y); // Selalu mencetak -1
            y = 100;
            System.out.println("y is now: " + y); // y berubah
        } // y dihancurkan disini

        // Setiap kali for loop berulang, variabel y baru dibuat, diinisialisasi ke -1,
        // dan setelah perulangan
        // selesai, y dihancurkan, sehingga nilainya tidak bertahan untuk iterasi
        // berikutnya

        int scope1;
        scope1 = 10;
        if (scope1 == 10) {
            int scope2 = 20;
            // scope1 and scope2 hanya hidup di scope ini
            System.out.println("scope1 and scope2: " + scope1 + " " + scope2);
            scope1 = scope2 * 2;
        }

        // scope2 = 100; // error! not known here
        // System.out.println(scope2) // is Error!
        // scope1 is still known here.
        System.out.println("scope1 is " + scope1);

    }
}
