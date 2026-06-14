package ExploreJavaLang.ExecuteOtherProgram;

/**
 * Executing Other Programs
 *
 * Di lingkungan yang aman, 
 * lo bisa menggunakan Java untuk menjalankan proses lain (program) yang berat di sistem operasi multitasking.
 *
 * Beberapa bentuk method exec() memungkinkan lo:
 * menentukan nama program yang ingin dijalankan
 * serta parameter inputnya
 *
 * Method exec() mengembalikan objek Process, yang bisa digunakan untuk:
 * mengontrol interaksi antara program Java lo dengan proses baru tersebut
 *
 * Karena Java bisa berjalan di berbagai platform dan sistem operasi:
 * exec() bergantung pada environment (OS)
 *
 * --------------------------------------------------
 * 
 * Intinya apa?
 * Java bisa jadi "remote control" buat OS
 *
 * Lo bisa:
 * buka aplikasi
 * jalanin command
 * trigger script
 *
 * Flow exec()
 * Java → Runtime.exec() → OS → Program jalan → Process object balik ke Java
 *
 * Penting: Environment Dependent
 *
 * Contoh:
 * r.exec("notepad"); // Windows
 *
 * Kalau di Linux:
 * r.exec("gedit");
 *
 * beda OS → beda command
 *
 * -------------------------------------------------------
 * 
 * Penjelasan Lanjutan
 * Ada beberapa versi exec(), tapi yang paling umum:
 * exec(String programName)
 *
 * Setelah dapat Process
 *
 * Lo bisa kontrol pakai method dari class Process class:
 * destroy() → matiin
 * waitFor() → tunggu selesai
 * exitValue() → hasil program
 *
 * Interaksi Dengan Subprocess
 *
 * Selama program berjalan, lo bisa:
 * Ambil output
 * p.getInputStream();
 * Kirim input
 * p.getOutputStream();
 *
 * ini dipakai kalau:
 * jalanin CLI
 * kirim command ke program
 *
 * -----------------------------------------------
 * 
 * Insight Penting (INI YANG SERING JEBOL)
 * Jangan lupa waitFor()
 *
 * Kalau enggak:
 * program bisa lanjut sebelum subprocess selesai
 *
 * Bisa nge-hang kalau stream gak dibaca
 *
 * Kalau subprocess output banyak:
 * buffer penuh → program freeze
 *
 * Lebih bagus pakai:
 * ProcessBuilder (modern way)
 *
 * --------------------------------------
 * 
 * Analogi Biar Nempel
 *
 * Bayangin:
 * Java = boss 
 * OS = karyawan 
 * Program lain = pekerja lapangan 
 * Java: "buka notepad!"
 * OS: "siap boss"
 * Notepad: "jalan..."
 *
 * Relevansi ke Backend
 *
 * Ini kepake di:
 * automation tool
 * DevOps (run script)
 * CI/CD pipeline
 * integrasi Docker / shell
 * microservice trigger external process
 *
 * -------------------------------------------
 * 
 * Kesimpulan Simpel
 * exec() = jalanin program lain dari Java
 *
 * hasilnya = Process object
 * lo bisa:
 *
 * tunggu (waitFor)
 * ambil hasil (exitValue)
 * kontrol (destroy)
 *
 * hati-hati:
 * tergantung OS
 * bisa nge-hang kalau salah handle
 */

/**
 * Contoh:
 * Program berikut menggunakan exec() untuk membuka Notepad (editor teks sederhana di Windows)
 * Program ini hanya bisa dijalankan di Windows
 */

public class ExecOtherProgram {
    public static void main(String[] args) {
        
        // Demonstrasi exec()

        // Ambil Runtime (akses ke JVM)
        Runtime runtime = Runtime.getRuntime();

        // Object Process untuk handle program yang dijalankan
        Process proses = null;

        // PROGRAM MENJALANKAN NOTEPAD
        try {
            // Menjalankan program Notepad
            // Jalankan Notepad
            proses = runtime.exec("notepad");

            // Tunggu sampai user nutup notepad
            proses.waitFor();

        } catch (Exception e) {
            // Jika gagal menjalankan
            System.out.println("ERROR executing notepad...");
        }

        // Ambil exit value (hasil dari program)
        System.out.println("Notepad returned " + proses.exitValue());

        /**
         * STEP 1 — Jalankan Notepad
         * proses = runtime.exec("notepad");
         *
         * STEP 2 — Tunggu selesai
         * p.waitFor();
         * program Java pause sampai notepad ditutup
         *
         * STEP 3 — Ambil hasil
         * proses.exitValue();
         *
         * biasanya:
         * 0 = sukses
         * selain itu = error
         */

    }
}
