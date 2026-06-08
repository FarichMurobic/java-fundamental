package Array;

/*

Array adalah sekelompok variabel dengan tipe data yang sama, yang diorganisisir dibawah satu nama.
setiap elemen di array diakses menggunakan nomor indeks, array bisa punya satu dimensi atau lebih.

PENTING!
Semua indeks array di java dimulai dari 0 bukan 1.

Sintaks deklarasi alternatif
1, tipedata namaArray[]; - mirip c/c++
2, tipedata[] namaArray; - lebih umum di java

Sintaks Alternatif Deklarasi Array
Ada cara lain untuk mendeklarasikan variabel array, yaitu dengan menempatkan tanda kurung
siku setelah tipe data. Kedua sintaks di bawah ini sama saja:
int month_days[] = new int[12];
int[] month_days = new int[12];

Bentuk kedua (int[]) sering dianggap lebih modern dan lebih disukai karena lebih konsisten.
Ini juga lebih mudah saat mendeklarasikan beberapa array dalam satu baris, 
seperti: int[] nums, nums2, nums3;

*/

public class Array {
    public static void main(String[] args) {
        
        /**
         * Array Satu Dimensi (One-Dimensional Arrays)
         * Array satu dimensi adalah daftar variabel yang dikelompokkan.
         * Untuk membuat sebuah array, ada dua langkah:
         *
         * 1.Deklarasi Variabel Array: Lo harus menyatakan variabel yang akan merujuk ke array.
         *   tipe_data nama_variabel_array[];
         *   Contoh: int month_days[];
         *   Sampai di sini, variabel month_days sudah dideklarasikan, tapi arraynya sendiri belum ada.
         *
         * 2.Alokasi Memori: Lo harus mengalokasikan memori untuk array menggunakan operator new.
         *   nama_variabel_array = new tipe_data[ukuran_array];
         *   Contoh: month_days = new int[12];
         *
         * Setelah baris ini, Java akan membuat sebuah array 12 elemen bertipe int dan
         * mengaitkannya dengan month_days. Secara default, semua elemen array akan
         * diinisialisasi ke nol (0) untuk tipe numerik, false untuk boolean, atau null untuk
         * tipe referensi.
         */

        System.out.println("----- Array Satu Dimensi -----");

        // Demonstrasi array 1 dimensi
        int month_Days[] = new int[12]; // Mengalokasikan memori
        
        // Jumlah 12 data array, index pertama dimulai dari 0.
        month_Days[0] = 31;  // inisialisasi index
        month_Days[1] = 28;  // inisialisasi index
        month_Days[2] = 31;  // inisialisasi index
        month_Days[3] = 30;  // inisialisasi index
        month_Days[4] = 31;  // inisialisasi index
        month_Days[5] = 30;  // inisialisasi index 
        month_Days[6] = 31;  // inisialisasi index
        month_Days[7] = 31;  // inisialisasi index
        month_Days[8] = 30;  // inisialisasi index
        month_Days[9] = 31;  // inisialisasi index
        month_Days[10] = 30; // inisialisasi index
        month_Days[11] = 31; // inisialisasi index

        // Panggil index array ke 5 (Bulan June)
        System.out.println("Jumlah hari di bulan June (6): " + month_Days[5]);

        /**
         * Inisialisasi Langsung Array
         * Lo juga bisa mendeklarasikan, mengalokasikan, dan menginisialisasi array dalam satu baris.
         * Java akan secara otomatis menentukan ukurannya dari jumlah elemen yang lo berikan.
         * ------------------------------------------------------------------------------------------
         * Contoh penulisan lebih professional
         * Ini adalah cara yang paling sering digunakan karena lebih ringkas dan efisien.
         * An improved version of the previous program.
         */

        int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        System.out.println("Lebih Professional: " + monthDays[0]);

        String namaBulan[] = {"January", "February", "Maret", "April", "Mei", "June", 
                              "July", "August", "September", "Oktober", "November", "Desember"};

                            System.out.println(namaBulan[5]); // Bulan June

        System.out.println("--------------------------------------------------");

        // Contoh berikutnya menggunakan for untuk menghasilkan data di array.
        double numberDouble[] = {10.1, 10.2, 10.3, 10.4, 10.5};
        double hasilDouble = 0; // Nilai default

        for (int i = 0; i < numberDouble.length; i++) {
            hasilDouble += numberDouble[i]; // Jumlahkan semua nilai didalam array
        }

        System.out.println("Jumlah nilai di NumberDouble: " + hasilDouble);

        // Nilai default jika belum di inisialisasi 0
        int angka[] = new int[3];
        // Jika belum di inisialisasi nilai default 0
        System.out.println(angka[1]); // 0

        // Isi data
        angka[0] = 1;
        angka[1] = 2;
        angka[2] = 3;

        System.out.println(angka[1]); // 2
        System.out.println(angka.length); // 3

        // Cetak semua isi
        for (int o = 0; o < angka.length; o++) 
            System.out.println("Number: " + angka[o]);

        /**
         * OUTPUT
         * Number: 1
         * Number: 2
         * Number: 3
         */

        System.out.println("-----------------------");

        /**
         * Sintaks Alternatif Deklarasi Array
         *
         * Ada bentuk kedua yang bisa digunakan untuk mendeklarasikan array:
         * type[] var-name;
         * Di sini, kurung siku mengikuti tipe data, bukan nama variabelnya. Sebagai contoh, dua
         * deklarasi ini adalah sama (ekivalen):
         * int a1[] = new int[3];
         * int[] a2 = new int[3];
         *
         * Bentuk alternatif ini memberikan kemudahan ketika lo ingin mendeklarasikan beberapa array
         * sekaligus dalam satu baris. Contohnya:
         * int[] nums, nums2, nums3; // Membuat tiga array int
         * Ini jauh lebih praktis daripada harus menuliskan kurung siku di setiap nama variabel seperti ini:
         * int nums[], nums2[], nums3[];
         */

        // A kuring siku di tipe data
        int[] a, b, c;
        // Hasilnya: a, b, c adalah int tipe array

        a = new int[5];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        a[3] = 4;
        a[4] = 5;

        b = new int[5];
        b[0] = 1;
        b[1] = 2;
        b[2] = 3;
        b[3] = 4;
        b[4] = 5;

        c = new int[5];
        c[0] = 1;
        c[1] = 2;
        c[2] = 3;
        c[3] = 4;
        c[4] = 5;

        // B kurung siku di nama variabel
        int i[], j, k;
        // Hasilnya: hanya i yang bertipe array, j dan k int biasa

        // I ARRAY
        i = new int[5];
        i[0] = 1;
        i[1] = 2;
        i[2] = 3;
        i[3] = 4;
        i[4] = 5;

        // J DAN K int biasa
        j = 10;
        k = 10;

    }
}
