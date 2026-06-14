package ExploreJavaLang.AppendableInterface;

/**
 * The Appendable Interface
 *
 * Object dari class yang mengimplementasikan Appendable bisa 
 * ditambahkan (append) karakter atau urutan karakter ke dalamnya.
 *
 * Appendable mendefinisikan 3 method:
 * Appendable append(char ch) throws IOException
 * Appendable append(CharSequence chars) throws IOException
 * Appendable append(CharSequence chars, int begin, int end) throws IOException
 *
 * -------------------------------------------
 * 
 * Penjelasan:
 * 
 * append(char ch)
 * ➝ Menambahkan satu karakter ke object
 * append(CharSequence chars)
 * ➝ Menambahkan teks (String, StringBuilder, dll)
 * append(CharSequence chars, int begin, int end)
 * ➝ Menambahkan sebagian teks (dari index begin sampai end-1)
 *
 * Semua method:
 * Mengembalikan object itu sendiri (return this)
 *
 * Bisa di-chain (disambung)
 *
 * -------------------------------
 * 
 * Inti konsep
 *
 * Appendable =
 * kemampuan untuk menambahkan teks ke object
 *
 * Siapa yang implement?
 *
 * Beberapa class penting:
 * StringBuilder
 * StringBuffer
 * Writer (FileWriter, BufferedWriter, dll)
 *
 * Analogi
 * Appendable = papan tulis
 * append() = nambah tulisan ke papan
 *
 * 1. Kenapa return Appendable?
 * 
 * Supaya bisa chaining:
 * app.append("Hello").append(" ").append("World");
 *
 * Lebih clean
 *
 * 2. Kenapa ada IOException?
 *
 * Karena:
 * Beberapa implementasi (Writer) bisa error I/O
 *
 * 3. Flexible banget
 *
 * Method ini bisa nerima:
 * String
 * StringBuilder
 * StringBuffer
 *
 * Karena semuanya CharSequence
 *
 * KAITAN KE CLASS LAIN
 * Hubungan penting:
 * Appendable ← StringBuilder
 * Appendable ← Writer
 * Appendable ← StringBuffer
 *
 * Digabung dengan CharSequence:
 *
 * input: CharSequence
 * output: Appendable
 *
 * ini design API Java yang powerful
 *
 * --------------------------
 * 
 * HAL PENTING
 * String TIDAK implement Appendable
 *
 * Kenapa?
 * String immutable
 *
 * Appendable = mutable object
 * bisa diubah
 *
 * USE CASE DI BACKEND
 * Dipakai di:
 * Logging system
 * File writing
 * String building (JSON, SQL)
 * Response builder
 *
 * Contoh real:
 * StringBuilder sb = new StringBuilder();
 *
 * sb.append("{")
 *   .append("\"name\":\"John\"")
 *   .append("}");
 *
 * ---------------------------
 * 
 * KESIMPULAN
 * 
 * Inti:
 * Appendable = interface untuk menambahkan teks
 * 
 * Method utama:
 * append(char)
 * append(CharSequence)
 * append(CharSequence, begin, end)
 *
 * Ciri khas:
 * Bisa chaining
 * Bisa lempar IOException
 * Mutable
 *
 * Insight penting:
 *
 * Ini bagian dari desain API Java
 * Banyak class penting implement ini
 */

import java.io.FileWriter;

public class AppendableInterface {
    public static void main(String[] args) throws Exception {
        
        // Contoh penggunaan Appendable dengan StringBuilder
        Appendable app = new StringBuilder();

        // MENAMBAHKAN KARAKTER
        app.append('H');
        // MENAMBAHKAN STRING
        app.append("ello ");
        // MENAMBAHKAN SEBAGIAN TEKS
        app.append("Janera", 0, 6);

        System.out.println(app.toString());

        /**
         * Output:
         * Hello Janera
         */

        System.out.println();

        // Buat file .txt dengan isi -> path tersebut!
        Appendable app1 = new FileWriter("data//Data3.txt");
        
        app1.append("Hello ");
        app1.append("Janera!");

        // CASTING KE FILEWRITER UNTUK CLOSE
        ((FileWriter) app1).close();

        System.out.println(app1.toString()); // java.io.FileWriter@1f32e575
        
    }
}
