package FundamentalJava.InputOutputIO;

/**
 * Writing Console Output
 *
 * Output ke console paling gampang pakai:
 * print()
 * println()
 *
 * ini yang selama ini lu pakai
 *
 * Asalnya dari mana?
 * Method itu berasal dari class:
 * PrintStream
 * dan:
 * System.out
 * itu adalah object dari PrintStream
 *
 * -------------------------
 * 
 * Fakta penting
 * 
 * Walaupun:
 * System.out adalah byte stream
 *
 * tetap boleh dipakai untuk output teks sederhana
 *
 * Tapi…
 * Ada alternatif:
 * pakai character stream (dibahas setelah ini)
 *
 * Method lain: write()
 * Karena PrintStream turunan dari:
 * OutputStream
 * dia punya method:
 * write()
 *
 * Bentuk paling sederhana
 * void write(int byteval)
 *
 * artinya:
 * tulis 1 byte ke output
 *
 * Catatan penting
 * Walaupun parameternya int:
 * yang dipakai cuma 8 bit terakhir (1 byte)
 *
 * --------------------
 * 
 * Perbedaan besar
 * println()
 * high-level
 * gampang
 * otomatis format
 *
 * write()
 * low-level
 * nulis byte langsung
 * lebih “dekat ke mesin”
 *
 * Analogi
 * Method	        Analogi
 * println()	    ngetik kalimat di Word
 * write()	        ngirim kode ASCII langsung
 *
 * ---------------------------------------------
 * 
 * Kenapa ada write()?
 * Karena:
 * Java dibangun dari level rendah → tinggi
 * write() = fondasi
 * print() = versi gampangnya
 *
 * Kenapa jarang dipakai?
 * Karena:
 * ribet
 * gak fleksibel
 * harus handle karakter manual
 *
 * PERBANDINGAN
 * Aspek	        write()	        print()/println()
 * Level	        rendah	        tinggi
 * Kemudahan	    susah	        gampang
 * Output	        byte	        teks
 * Penggunaan	    jarang	        sering
 *
 * KAPAN write() DIPAKAI?
 * Jarang, tapi berguna kalau:
 * kerja di level byte
 * custom output
 * performance tuning (jarang banget di console)
 *
 * ---------------------------------------
 * 
 * INSIGHT LEVEL PRO
 * 
 * Ini yang harus lu tangkap:
 * System.out itu sebenarnya byte stream
 *
 * tapi:
 * Java kasih wrapper (PrintStream)
 * biar bisa:
 * println("Hello")
 *
 * Artinya:
 * Yang lu pakai selama ini:
 * System.out.println()
 *
 * itu sebenarnya:
 * sudah di-“abstraksi” dari write()
 *
 * -----------------------------------
 * 
 * KESIMPULAN SUPER SEDERHANA
 * 
 * Output console paling mudah:
 * System.out.println()
 *
 * write():
 * nulis byte langsung
 * low-level
 * jarang dipakai
 *
 * PrintStream:
 * class di balik System.out
 *
 * Inti besar
 * Java punya:
 * level rendah → write()
 * level tinggi → print()
 *
 * lu biasanya pakai yang tinggi
 */

public class WritingConsoleOutput {
    public static void main(String[] args) {
        
        int b;
        b = 'a'; // karakter 'A' → dikonversi ke ASCII (65)

        // NULIS 1 BYTE:
        // HASILNYA A
        System.out.write(b);
        // newline (ENTER)
        System.out.write('\n'); // lihat ini char bukan string
    }

}
