package ExploringJavaLang.ProcessJava;

/**
 * Process
 *
 * Class abstrak Process merepresentasikan sebuah proses—yaitu program yang sedang berjalan (executing program).
 * Class ini biasanya digunakan sebagai superclass untuk objek-objek yang dibuat oleh method:
 * exec() di class Runtime class
 * start() di class ProcessBuilder class
 *
 * Class Process memiliki method-method seperti yang ditunjukkan pada Tabel 17-10.
 *
 * Table 17-10 — Methods Defined by Process
 * Method	                                                    Description
 * void destroy()	                                            Menghentikan (terminate) proses.
 * Process destroyForcibly()	                                Memaksa menghentikan proses. Mengembalikan referensi ke process. (Ditambahkan di JDK 8)
 * int exitValue()	                                            Mengembalikan kode exit dari subprocess.
 * InputStream getErrorStream() 	                            Mengembalikan input stream untuk membaca error output dari proses.
 * InputStream getInputStream()	                                Mengembalikan input stream untuk membaca output normal dari proses.
 * OutputStream getOutputStream()	                            Mengembalikan output stream untuk mengirim input ke proses.
 * boolean isAlive()	                                        Mengembalikan true jika proses masih berjalan, false jika tidak. (JDK 8)
 * int waitFor() throws InterruptedException	                Menunggu proses selesai dan mengembalikan exit code.
 * boolean waitFor(long waitTime, TimeUnit timeUnit) throws InterruptedException	Menunggu proses selesai dalam waktu tertentu. Return true jika selesai, false jika timeout. (JDK 8)
 *
 * Apa itu Process?
 *
 * Bayangin gini bro:
 * Java lo bisa jalanin program lain dari dalam Java
 *
 * Contoh:
 * Jalanin notepad.exe
 * Jalanin command ping google.com
 * Jalanin script Python
 *
 * Nah, ketika lo jalanin itu → Java bikin Process object
 * Jadi Process = representasi program luar yang lagi jalan
 *
 * Cara biasanya dipakai
 *
 * Biasanya lewat:
 * Runtime.exec()
 * ProcessBuilder.start()
 *
 * Contoh:
 * Process p = Runtime.getRuntime().exec("notepad");
 *
 * Ini bakal buka Notepad dari Java
 *
 * Ini kepake di mana?
 *
 * Di dunia nyata:
 * DevOps tools
 * Automation script
 * Microservice yang trigger CLI
 * Running Docker dari Java
 * Integrasi dengan system OS
 *
 * Hal yang sering bikin bingung
 * getInputStream() = output program 
 * Harus handle stream → kalau nggak bisa nge-hang
 * Jangan lupa waitFor() → kalau nggak, race condition
 *
 * Kesimpulan Simpel
 *
 * Process = representasi program yang dijalankan dari Java
 *
 * Lo bisa:
 * jalanin program lain
 * baca output-nya
 * kirim input ke dia
 * kontrol hidup/matinya
 *
 * Method penting:
 * getInputStream() → baca output
 * waitFor() → tunggu selesai
 * destroy() → stop
 * isAlive() → cek status
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcessJava {
    public static void main(String[] args) {

        try {
            // Menjalankan command ping ke google
            Process process = Runtime.getRuntime().exec("ping google.com");
            // Ambil output dari process (hasil ping)
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            // Baca output satu per satu
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // tampilkan ke console
            }

            // Tunggu sampai proses selesai
            int exitCode = process.waitFor();
            // Tampilkan hasil exit code
            System.out.println("Process selesai dengan kode: " + exitCode);
            // Cek apakah masih hidup
            System.out.println("Masih berjalan? " + process.isAlive());
        } catch (Exception e) {
            e.printStackTrace();  // tampilkan error kalau ada
        }
    }
}
