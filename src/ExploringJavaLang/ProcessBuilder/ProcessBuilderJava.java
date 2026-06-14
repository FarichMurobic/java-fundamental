package ExploringJavaLang.ProcessBuilder;

/**
 * ProcessBuilder
 *
 * ProcessBuilder menyediakan cara lain untuk memulai dan mengelola proses (program).
 *
 * Seperti dijelaskan sebelumnya:
 * semua proses direpresentasikan oleh class Process
 * proses bisa dijalankan dengan Runtime.exec()
 *
 * Namun:
 * ProcessBuilder memberikan kontrol yang lebih besar
 *
 * Contoh:
 * bisa set working directory
 *
 * Constructor
 * ProcessBuilder(List<String> args)
 * ProcessBuilder(String... args)
 *
 * args = list argumen:
 * nama program
 * parameter command-line
 *
 * Perbedaan:
 * versi 1 → pakai List
 * versi 2 → pakai varargs (lebih simpel)
 *
 * ProcessBuilder.Redirect
 * Class abstrak ini mengatur I/O (input-output) dari subprocess
 *
 * Lo bisa:
 * redirect ke file → to()
 * baca dari file → from()
 * append ke file → appendTo()
 *
 * static ProcessBuilder.Redirect to(File f)
 * static ProcessBuilder.Redirect from(File f)
 * static ProcessBuilder.Redirect appendTo(File f)
 * File file()
 *
 * Tipe Redirect
 *
 * Method:
 * type()
 *
 * Return:
 * APPEND, INHERIT, PIPE, READ, WRITE
 *
 * Bagian 1
 * Method	                                            Description
 * List<String> command()	                            Mengembalikan list command + argumen
 * ProcessBuilder command(List<String> args)	        Set command dari list
 * ProcessBuilder command(String... args)	            Set command dari varargs
 * File directory()	                                    Mengembalikan working directory
 *
 * Bagian 2
 * Method	                                            Description
 * ProcessBuilder directory(File dir)	                Set working directory
 * Map<String, String> environment()	                Ambil environment variables
 * ProcessBuilder inheritIO()	                        Pakai I/O yang sama dengan program Java
 * ProcessBuilder.Redirect redirectError()	            Ambil target error
 * ProcessBuilder redirectError(File f)	                Redirect error ke file
 * ProcessBuilder redirectError(Redirect target)	    Set target error
 * boolean redirectErrorStream()	                    Cek apakah error digabung ke output
 * ProcessBuilder redirectErrorStream(boolean)	        Gabungkan error ke output
 * ProcessBuilder.Redirect redirectInput()	            Ambil source input
 * ProcessBuilder redirectInput(File f)	                Input dari file
 * ProcessBuilder redirectInput(Redirect source)	    Set input
 * ProcessBuilder.Redirect redirectOutput()	            Ambil target output
 * ProcessBuilder redirectOutput(File f)	            Output ke file
 * ProcessBuilder redirectOutput(Redirect target)	    Set output
 * Process start()	                                    Menjalankan proses
 *
 * enapa ProcessBuilder dibuat?
 *
 * Karena:
 * Runtime.exec() terlalu sederhana
 *
 * Masalah exec():
 * susah handle argumen kompleks
 * susah redirect output
 * kurang fleksibel
 *
 * ProcessBuilder = versi PRO 
 *
 * Perbandingan
 * Runtime.exec	            ProcessBuilder
 * simple	                powerful
 * kurang fleksibel	        fleksibel
 * susah redirect	        gampang redirect
 *
 * Analogi
 * Runtime.exec() → nyuruh orang lewat telepon 
 * ProcessBuilder → kasih SOP lengkap + alat kerja 
 *
 * Insight Penting (REAL WORLD)
 * Ini dipakai di:
 * automation script
 * CI/CD
 * Docker integration
 * running shell command dari backend
 * microservices orchestration
 *
 * Kesalahan umum
 *
 * lupa handle output → bisa nge-hang
 * salah command OS
 * gak set working directory
 *
 * Best Practice
 *
 * pakai ProcessBuilder daripada Runtime.exec()
 * selalu handle stream
 * gunakan environment config
 *
 * Kesimpulan Simpel
 *
 * ProcessBuilder = cara modern & powerful buat jalanin program
 *
 * kelebihan:
 *
 * lebih fleksibel
 * bisa redirect I/O
 * bisa set environment
 * bisa set working directory
 *
 * flow:
 * buat ProcessBuilder
 * set config
 * start()
 */

public class ProcessBuilderJava {
    public static void main(String[] args) {

        try {
            // Membuat ProcessBuilder
            // Program: notepad.exe
            // Argument: testfile (nama file yang akan dibuka)
            ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe", "testfile");

            // Menjalankan program
            processBuilder.start();
        } catch (Exception e) {
            // Jika error saat menjalankan
            System.out.println("Error executing notepad.");
        }

        /**
         * STEP 1 — Buat ProcessBuilder
         * new ProcessBuilder("notepad.exe", "testfile");
         *
         * artinya:
         * notepad.exe testfile
         * STEP 2 — Jalankan
         * proc.start();
         *
         * ini pengganti:
         * Runtime.exec()
         */
    }
}
