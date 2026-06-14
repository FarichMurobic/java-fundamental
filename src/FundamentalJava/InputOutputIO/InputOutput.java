package FundamentalJava.InputOutputIO;

/**
 * I/O Basics (Dasar I/O)
 *
 * Kalau kamu perhatikan di 12 chapter sebelumnya:
 * hampir tidak ada penggunaan I/O
 *
 * hanya pakai:
 * print()
 * println()
 *
 * Kenapa?
 *
 * Karena:
 * kebanyakan aplikasi Java di dunia nyata bukan program console
 * biasanya:
 * aplikasi GUI (Swing, AWT, JavaFX)
 * aplikasi web
 *
 * Program console cuma bagus untuk belajar, bukan penggunaan utama di dunia nyata.
 *
 * -----------------------------------
 * 
 * Selain itu:
 * 
 * I/O console di Java itu:
 * terbatas
 * agak ribet dipakai
 *
 * Tapi…
 * Java tetap punya sistem I/O yang:
 * kuat
 * fleksibel
 * konsisten
 *
 * Terutama untuk:
 * file
 * network
 */

/**
 * STREAMS (INTI BANGET)
 *
 * Apa itu Stream?
 * Stream adalah:
 * abstraksi yang menghasilkan atau mengonsumsi data
 *
 * bahasa gampangnya:
 * alur data
 *
 * Cara kerja stream
 * 
 * Stream terhubung ke:
 * device fisik:
 * file
 * keyboard
 * network
 *
 * TAPI:
 * Java bikin semuanya terlihat sama
 *
 * jadi:
 * kode yang sama bisa dipakai ke berbagai sumber
 *
 * Contoh
 * Input Stream:
 * baca dari file
 * baca dari keyboard
 * baca dari network
 *
 * Output Stream:
 * tampil ke layar
 * simpan ke file
 * kirim ke network
 *
 * Intinya:
 * Java menyederhanakan semua I/O jadi “stream”
 *
 * --------------------------------------------------
 * 
 * Kenapa ini penting?
 * 
 * Karena:
 * lu gak perlu mikirin:
 * ini dari file?
 * ini dari keyboard?
 * semua pakai cara yang sama
 *
 * Implementasi di Java
 * Semua stream ada di:
 * java.io
 *
 * Catatan tambahan
 * Selain java.io, Java juga punya:
 * java.nio → versi lebih modern (buffer & channel)
 *
 * -----------------------------------------------------
 * 
 * BYTE STREAM vs CHARACTER STREAM
 * 
 * Java punya 2 jenis stream
 *
 * 1. Byte Stream
 * bekerja dengan byte (data mentah)
 * cocok untuk:
 * file binary
 * gambar
 * video
 *
 * 2. Character Stream
 * bekerja dengan karakter (Unicode)
 * cocok untuk:
 * teks
 * string
 * file text
 *
 * Sejarah singkat
 * Java 1.0 → hanya byte stream
 * Java 1.1 → tambah character stream
 *
 * sekarang:
 * lebih disarankan pakai character stream untuk teks
 *
 * Fakta penting
 * Di level paling bawah, semua I/O tetap byte
 * Character stream cuma:
 * pembungkus biar lebih nyaman
 */

/**
 * BYTE STREAM CLASSES (STRUKTUR UTAMA)
 *
 * Dua class paling atas
 * InputStream
 * OutputStream
 *
 * keduanya:
 * abstract class
 * jadi dasar semua byte stream
 *
 * Konsepnya
 * InputStream → baca data
 * OutputStream → tulis data
 *
 * TABEL LENGKAP BYTE STREAM
 * Class	                        Penjelasan
 * BufferedInputStream	            Input stream dengan buffer (lebih cepat membaca)
 * BufferedOutputStream	            Output stream dengan buffer (lebih cepat menulis)
 * ByteArrayInputStream	            Membaca data dari array byte di memori
 * ByteArrayOutputStream	        Menulis data ke array byte di memori
 * DataInputStream	                Membaca tipe data standar Java (int, double, dll)
 * DataOutputStream	                Menulis tipe data standar Java
 * FileInputStream	                Membaca data dari file
 * FileOutputStream	                Menulis data ke file
 * FilterInputStream	            Class dasar untuk filter input
 * FilterOutputStream	            Class dasar untuk filter output
 * InputStream	                    Abstract class dasar untuk input
 * ObjectInputStream	            Membaca object (deserialization)
 * ObjectOutputStream	            Menulis object (serialization)
 * OutputStream	                    Abstract class dasar untuk output
 * PipedInputStream	                Input stream untuk komunikasi antar thread
 * PipedOutputStream	            Output stream untuk komunikasi antar thread
 * PrintStream	                    Output stream yang punya print() dan println()
 * PushbackInputStream	            Bisa “balikin” 1 byte ke stream
 * SequenceInputStream	            Gabungan beberapa input stream jadi satu
 *
 * ----------------------------
 * 
 * METHOD PENTING
 * 
 * Dua method inti:
 * read()
 * write()
 *
 * read()
 * membaca data (byte)
 * return: data atau -1 kalau sudah habis
 *
 * write()
 * menulis data ke output
 *
 * Kedua method ini:
 * ada di abstract class
 * harus di-override oleh subclass
 *
 * ----------------------------------------
 * 
 * Inti besar dari semua ini
 * 
 * Java bilang:
 * “Semua I/O itu stream”
 *
 * Kenapa powerful?
 * Karena:
 * satu konsep → bisa dipakai ke semua
 * gak perlu belajar beda-beda tiap device
 *
 * Byte vs Character (cara mikir gampang)
 * Tipe	            Cara mikir
 * Byte	            data mentah
 * Character	    data yang sudah jadi huruf
 *
 * ------------------------
 * 
 * Kesalahan umum
 * 
 * lupa close() → resource leak
 * pakai byte stream buat teks → ribet
 * gak ngerti stream → bakal stuck di:
 * file handling
 * networking
 * API backend
 *
 * Real world
 * Konsep stream dipakai di:
 * backend server
 * upload/download file
 * REST API
 * socket programming
 *
 * ini fondasi besar, bukan materi kecil
 *
 * --------------------
 *
 * Character Stream Classes
 *
 * Character stream didefinisikan menggunakan dua hirarki class.
 * Di bagian paling atas ada dua abstract class:
 * Reader
 * Writer
 *
 * Reader → untuk input karakter
 * Writer → untuk output karakter
 *
 * Kedua class ini:
 * menangani data dalam bentuk Unicode
 * punya banyak subclass konkret
 *
 * Tabel Character Stream (Lengkap)
 * Berikut class-class yang ada di java.io:
 *
 * Class	                    Penjelasan
 * BufferedReader	            Input karakter dengan buffer (lebih cepat)
 * BufferedWriter	            Output karakter dengan buffer
 * CharArrayReader	            Membaca dari array karakter
 * CharArrayWriter	            Menulis ke array karakter
 * FileReader	                Membaca karakter dari file
 * FileWriter	                Menulis karakter ke file
 * FilterReader	                Reader yang difilter
 * FilterWriter	                Writer yang difilter
 * InputStreamReader	        Mengubah byte → karakter
 * LineNumberReader	            Reader yang menghitung nomor baris
 * OutputStreamWriter	        Mengubah karakter → byte
 * PipedReader	                Input untuk komunikasi antar thread
 * PipedWriter	                Output untuk komunikasi antar thread
 * PrintWriter	                Output yang punya print() & println()
 * PushbackReader	            Bisa “balikin” karakter ke stream
 * Reader	                    Abstract class untuk input karakter
 * StringReader	                Membaca dari String
 * StringWriter	                Menulis ke String
 * Writer	                    Abstract class untuk output karakter
 *
 * ------------------
 * 
 * Method Penting
 * Sama seperti byte stream, ada dua method utama:
 * read()
 * write()
 * read() → baca karakter
 * write() → tulis karakter
 *
 * Kedua method ini:
 * abstract di parent class
 * harus diimplementasi subclass
 *
 * Intinya gini bro:
 * Kalau tadi:
 * Byte stream → data mentah
 *
 * Sekarang:
 * Character stream → data yang sudah jadi huruf
 *
 * Kenapa penting?
 * Karena:
 * manusia kerja dengan teks
 * bukan byte
 *
 * Contoh nyata
 * Kalau lu baca file .txt:
 *
 * Pakai byte stream:
 * dapet angka (ribet)
 * harus convert manual
 *
 * Pakai character stream:
 * langsung dapet huruf
 * jauh lebih nyaman
 *
 * ------------------------------------
 * 
 * Peran penting 2 class ini
 * 
 * InputStreamReader
 * jembatan:
 * byte → character
 *
 * OutputStreamWriter
 * kebalikannya:
 * character → byte
 *
 * Insight penting
 * Character stream = wrapper dari byte stream
 * jadi sebenernya:
 * di bawahnya tetap byte
 * tapi dibungkus biar gampang
 *
 */

/**
 * PREDEFINED STREAMS (WAJIB PAHAM)
 *
 * Class System
 * 
 * Semua program Java otomatis punya:
 * System
 *
 * Class ini:
 * bagian dari java.lang
 * otomatis di-import
 *
 * ----------------
 * 
 * 3 Stream bawaan
 * 
 * Java punya 3 stream default:
 * System.in
 * System.out
 * System.err
 *
 * Penjelasan
 * 
 * 1. System.out
 * output standar
 *
 * default: console
 * dipakai buat:
 * System.out.println("Hello");
 *
 * 2. System.in
 * input standar
 *
 * default: keyboard
 * buat baca input user
 *
 * 3. System.err
 * output error
 *
 * default: console
 * buat error message
 *
 * Sifat penting
 * Ketiga ini:
 * public
 * static
 * final
 *
 * artinya:
 * bisa dipakai di mana saja
 * tanpa buat object
 *
 * Tipe data mereka
 * Stream	        Tipe
 * System.in	    InputStream
 * System.out	    PrintStream
 * System.err	    PrintStream
 *
 * --------------------------------
 * 
 * Fakta penting
 * Walaupun:
 * System.out.println("text")
 *
 * sebenarnya:
 * itu byte stream
 *
 * Kenapa bisa tulis teks?
 * Karena:
 * Java otomatis convert karakter → byte
 *
 * Bisa diubah?
 * Bisa!
 *
 * Stream ini bisa:
 * diarahkan ke:
 * file
 * network
 * device lain
 *
 * ini disebut:
 * redirection
 *
 * ---------------------
 * 
 * Insight penting
 * 
 * Kalau lu mau lebih proper:
 * System.out → bisa dibungkus jadi character stream
 *
 * Contoh:
 * new BufferedReader(new InputStreamReader(System.in))
 *
 * ini sering banget dipakai di real-world
 *
 * PERBANDINGAN SUPER JELAS
 * Aspek	            Byte Stream	            Character Stream
 * Data	                byte	                karakter
 * Cocok untuk	        binary	                teks
 * Contoh	            FileInputStream	        FileReader
 * Level	            rendah	                lebih tinggi
 * Kemudahan	        lebih ribet	            lebih gampang
 *
 * Ini sering banget muncul di dunia nyata:
 * baca file text
 * parsing data
 * input user
 * logging
 *
 * Kunci mindset
 * Byte = mesin
 * Character = manusia
 *
 * --------------------------------
 * 
 * KESIMPULAN SUPER SEDERHANA
 * 
 * Character stream = buat teks
 * pakai:
 * Reader
 * Writer
 * lebih nyaman dibanding byte stream
 *
 * Predefined stream:
 * System.in → input
 * System.out → output
 * System.err → error
 *
 * semuanya default ke console
 *
 * Hal paling penting dari materi ini
 * Java punya 2 level:
 * byte (rendah)
 * character (tinggi)
 * Character stream lebih sering dipakai untuk teks
 * System.in/out itu sebenarnya byte stream yang bisa dibungkus
 */

import java.io.*; // LEBIH UMUM
import java.io.FileInputStream; // SPESIFIK
import java.io.IOException; // SPESIFIK

// Input dari keyboard (pakai character stream)
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputOutput {
    public static void main(String[] args) {
        
        // BYTE STREAM (BACA FILE)
        try {
            // BUKA FILE
            FileInputStream fis = new FileInputStream("data/Data1.txt");
            // Nampung data per byte
            int data;

            // BACA TERUS SAMPAI EOF 
            while ((data = fis.read()) != -1) {
                // CASTING BYTE KE CHARACTER
                System.out.print((char) data);
            }
            // TUTUP STREAM WAJIB
            fis.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.fillInStackTrace());
            System.out.println(e.getCause());
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.getSuppressed());
            e.printStackTrace();
        }

        System.out.println();

        // INPUT DARI KEYBOARD (PAKAI CHARACTER STREAM)
        try {
            // BIKIN LEBIH CEPAT & bisa baca 1 baris
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // UBAH BYTE KE CHAR

            System.out.println("Masukkan Nama: ");
            String nama = br.readLine(); // baca 1 baris teks!
            System.out.println("Hellooo " + nama);
        } catch (IOException e) {
            e.getMessage();
            System.out.println(e);
        }
    }

}
