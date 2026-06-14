package FundamentalJava.JumpStatements;

public class Return {
    public static void main(String[] args) {
        
        /**
         * return
         *
         * Statement kontrol terakhir adalah return.
         * return digunakan untuk keluar dari sebuah method secara langsung.
         *
         * Artinya:
         * program kembali ke pemanggil method
         * eksekusi method langsung berhenti
         * Karena return membuat program lompat ke tempat lain, maka dia juga termasuk jump statement.
         *
         * return bisa digunakan kapan saja di dalam method untuk langsung kembali ke pemanggil method.
         * Ketika return dijalankan:
         * method langsung berhenti
         *
         * -------------------------------------------------------
         * 
         * Perbedaan break, continue, dan return
         * Ini mental model penting buat programmer.
         *
         * Statement	    Efek
         * break	        keluar dari loop
         * continue	        lompat ke iterasi berikutnya
         * return	        keluar dari method
         *
         * Kesalahan yang Sering Terjadi 
         * Mengira return hanya untuk mengembalikan nilai
         *
         * Banyak pemula berpikir:
         * return harus mengembalikan nilai
         *
         * Padahal tidak.
         * Kalau method tipe void:
         * return hanya menghentikan method
         *
         * Mengira return hanya dipakai di akhir method
         * Padahal return bisa dipakai di mana saja.
         * Contoh:
         *
         * if(error)
         *     return;
         *
         * Ini sangat sering dipakai dalam kode profesional.
         *
         * Contoh Penggunaan Nyata
         * Misalnya validasi input:
         *
         * public static void login(String password){
         *
         *     if(password == null){
         *         System.out.println("Password kosong");
         *         return;
         *     }
         *
         *     System.out.println("Login diproses...");
         * }
         *
         * Jika password kosong:
         * method langsung berhenti
         *
         * return sering dipakai untuk:
         * validasi awal
         * menghentikan method lebih cepat
         * mengembalikan hasil fungsi
         */

        // Contoh program sederhana
        boolean t = true;
        System.out.println("Before the return.");

        if(t)
            return; // kembali ke pemanggil method

        System.out.println("This won't execute.");

        /**
         * Output:
         * Before the return.
         *
         * Cara Kerja Program Contoh
         * Kode:
         * System.out.println("Before the return.");
         * if(t) return;
         * System.out.println("This won't execute.");
         *
         * Langkah program
         * Step 1
         * print Before the return.
         *
         * Output:
         * Before the return.
         *
         * Step 2
         * if(t)
         * Karena:
         * t = true
         * maka:
         * return
         *
         * Step 3
         * Method langsung berhenti.
         * Baris ini:
         * System.out.println("This won't execute.");
         * tidak dijalankan.
         */

    }
}
