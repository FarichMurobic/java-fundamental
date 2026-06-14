package ExploringJavaLang.Runtime;

import java.io.IOException;

/**
 * Runtime
 *
 * Class Runtime merepresentasikan lingkungan runtime (run-time environment).
 * Lo tidak bisa membuat instance dari Runtime secara langsung.
 * Namun, lo bisa mendapatkan referensi ke objek Runtime yang sedang berjalan dengan memanggil method static:
 *
 * Runtime.getRuntime()
 *
 * Setelah mendapatkan referensi ke objek Runtime, lo bisa memanggil berbagai method untuk mengontrol:
 * keadaan (state)
 * perilaku (behavior)
 *
 * dari Java Virtual Machine.
 *
 * Applet atau kode yang tidak dipercaya biasanya tidak boleh memanggil method Runtime, karena akan menyebabkan SecurityException.
 *
 * Beberapa method penting ditampilkan di tabel berikut.
 * Method	                            Description
 * void destroy()	                    Menghentikan proses
 * Process destroyForcibly()	        Memaksa menghentikan proses (JDK 8)
 * int exitValue()	                    Mengembalikan kode exit
 * InputStream getErrorStream()	        Membaca error output
 * InputStream getInputStream()	        Membaca output normal
 * OutputStream getOutputStream()	    Mengirim input ke proses
 * boolean isAlive()	                Cek proses masih hidup
 * int waitFor()	                    Tunggu proses selesai
 * boolean waitFor(long, TimeUnit)	    Tunggu dengan timeout
 *
 * Bagian 1
 * Method	                                                Description
 * void addShutdownHook(Thread thrd)	                    Mendaftarkan thread yang akan dijalankan saat JVM berhenti
 * Process exec(String progName)	                        Menjalankan program sebagai proses baru
 * Process exec(String progName, String environment[])	    Menjalankan program dengan environment tertentu
 * Process exec(String comLineArray[])	                    Menjalankan command dalam bentuk array
 *
 * Bagian 2
 * Method	                                                        Description
 * Process exec(String comLineArray[], String environment[])	    Menjalankan command + environment
 * void exit(int exitCode)	                                        Menghentikan program dan mengembalikan exit code
 * long freeMemory()	                                            Jumlah memory bebas
 * void gc()	                                                    Menjalankan garbage collector
 * static Runtime getRuntime()	                                    Mendapatkan instance Runtime
 * void halt(int code)	                                            Mematikan JVM secara paksa
 * void load(String libraryFileName)	                            Load library dengan path lengkap
 * void loadLibrary(String libraryName)	                            Load library berdasarkan nama
 * boolean removeShutdownHook(Thread thrd)	                        Menghapus shutdown hook
 * void runFinalization()	                                        Menjalankan finalize() object
 * long totalMemory()	                                            Total memory yang tersedia
 * void traceInstructions(boolean)	                                Debug tracing instruction
 * void traceMethodCalls(boolean)	                                Debug tracing method
 *
 * Apa itu Runtime?
 * Kalau tadi:
 * Process = program luar
 *
 * Sekarang:
 * Runtime = mesin utama Java (JVM controller)
 *
 * Analoginya:
 * Konsep	            Analogi
 * JVM	                Mesin mobil
 * Runtime	            Dashboard / kontrol
 * Process	            Mobil lain di jalan
 *
 * Cara ambil Runtime
 * Runtime rt = Runtime.getRuntime();
 *
 * Ini penting:
 * gak bisa new Runtime()
 * harus pakai singleton dari JVM
 *
 * Runtime sering dipakai buat:
 * monitoring memory server
 * running script (bash, bat, dll)
 * shutdown handling (Spring Boot)
 * integrasi dengan OS
 *
 * Best Practice
 * Jangan sering pakai gc()
 * Jangan pakai halt() sembarangan
 * Gunakan ProcessBuilder (lebih modern dari exec)
 *
 * Kesimpulan Simpel
 *
 * Runtime = kontrol utama JVM
 *
 * Lo bisa:
 * jalanin program (exec)
 * kontrol memory (freeMemory)
 * handle shutdown (addShutdownHook)
 * matiin program (exit)
 *
 * Ini penting banget di:
 * backend
 * server
 * system programming
 */

public class RuntimeJava {
    public static void main(String[] args) {

        // Ambil instance Runtime dari JVM
        Runtime runtime = Runtime.getRuntime();

        // MEMORY INFO
        System.out.println("Total memory: " + runtime.totalMemory()); // total memory JVM
        System.out.println("Free memory: " + runtime.freeMemory()); // memory yang masih kosong

        // SHUTDOWN HOOK
        runtime.addShutdownHook(new Thread(() -> {
            // Ini akan dijalankan saat program berhenti
            System.out.println("Shutdown hook jalan broo...");
        }));

        try {
            // EXEC PROCESS
            Process process = runtime.exec("notepad");  // buka notepad (Windows)
            // Tunggu proses selesai
            process.waitFor();
            System.out.println("Notepad ditutup.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        // GC (opsional)
        runtime.gc();  // minta JVM bersihin memory

        // EXIT PROGRAM
        System.out.println("Program selesai!");

    }
}
