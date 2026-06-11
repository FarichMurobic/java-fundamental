package StructurePercabangan;

public class NestedSWITCH {
    public static void main(String[] args) {

        /**
         * Nested Switch Statements
         * 
         * Kita bisa menaruh sebuah switch di dalam switch lain. Ini disebut nested switch.
         * Karena setiap switch memiliki bloknya sendiri {}, maka tidak ada konflik antara
         * nilai case di switch luar dan switch dalam.
         *
         * Penjelasan Konsep
         * Program bekerja seperti dua tahap pengecekan.
         * 
         * Urutannya:
         * cek switch pertama
         *    ↓
         * jika cocok → jalankan switch kedua
         * Jadi seperti pintu dua lapis.
         *
         * ---------------------------------------
         * 
         * Tiga Hal Penting Tentang Switch
         * 
         * 1. Switch hanya bisa cek kesamaan
         * switch hanya bisa membandingkan:
         * nilai == case
         * Sedangkan if lebih fleksibel:
         * Jadi:
         * if	switch
         * bisa semua kondisi	hanya equality
         *
         * 2. Case Tidak Boleh Sama
         * Dalam satu switch tidak boleh ada:
         * case 2:
         * case 2:
         * Ini error.
         *
         * Tapi ini boleh:
         * switch luar
         * case 1
         * switch dalam
         * case 1
         * Karena beda switch.
         *
         * 3. Switch Biasanya Lebih Cepat
         * Switch sering lebih efisien daripada banyak if.
         * Kenapa?
         * Karena compiler Java membuat sesuatu yang disebut: Jump Table
         * Apa Itu Jump Table?
         * Ketika Java mengcompile switch, compiler membuat tabel lompat.
         * Contoh:
         * switch(x)
         * case 1
         * case 2
         * case 3
         * case 4
         *
         * Compiler membuat tabel seperti ini:
         * 1 → lompat ke kode A
         * 2 → lompat ke kode B
         * 3 → lompat ke kode C
         * 4 → lompat ke kode D
         *
         * Jadi program langsung lompat ke case yang cocok.
         *
         * Kenapa If Lebih Lambat?
         *
         * Jika memakai:
         * if(x == 1)
         * else if(x == 2)
         * else if(x == 3)
         * else if(x == 4)
         *
         * Program harus mengecek satu per satu:
         * cek 1
         * cek 2
         * cek 3
         * cek 4
         *
         * Sedangkan switch bisa langsung lompat.
         * Makanya untuk banyak pilihan nilai, switch lebih cepat.
         *
         * Ringkasan Nested Switch
         * Konsep	        Penjelasan
         * nested switch	switch di dalam switch
         * scope	        setiap switch punya blok sendiri
         * case	            tidak konflik antar switch
         * break	        keluar dari switch
         * jump table	    membuat switch lebih cepat
         */

        int count = 1;
        int target = 0;

        switch (count) { // perhatikan variabel count
            case 1: // case 1 awal
                switch (target) { // perhatikan variabel target
                    case 0:
                        System.out.println("target is zero");
                        break;
                    case 1:
                        System.out.println("target is one");
                        break;
                }
                break; // break dari case 1 awal
            case 2:
                System.out.println("Freedom");
                break;
            default:
                System.out.println("Free");
        }

        /**
         * Output
         * target is zero
         *
         * Penjelasan:
         * switch pertama akan dijalankan dulu jika true.
         * kemudian menjalankan switch kedua jika ada yang true.
         */

    }
}
