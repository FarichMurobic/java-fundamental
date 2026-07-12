package FundamentalJava.InputOutputIO;

/* ============================================================
 *                     DASAR INPUT/OUTPUT (I/O)
 * ============================================================
 *
 * Input/Output (I/O) adalah mekanisme yang digunakan program
 * untuk menerima data (input) dan menghasilkan data (output).
 *
 * Contoh input:
 *
 * - Keyboard
 * - File
 * - Network
 *
 * Contoh output:
 *
 * - Layar (console)
 * - File
 * - Network
 *
 * Hampir setiap aplikasi Java memanfaatkan I/O untuk
 * berinteraksi dengan pengguna, sistem, atau aplikasi lain.
 */


/* ------------------------------------------------------------
 * I/O pada Materi Sebelumnya
 * ------------------------------------------------------------
 *
 * Pada materi-materi sebelumnya, sebagian besar contoh
 * program hanya menggunakan output sederhana melalui:
 *
 * System.out.print()
 * System.out.println()
 *
 * Pendekatan ini dipilih agar fokus pembelajaran tetap
 * tertuju pada konsep dasar bahasa Java tanpa terdistraksi
 * oleh kompleksitas mekanisme I/O.
 */


/* ------------------------------------------------------------
 * Mengapa Tidak Banyak Menggunakan Console I/O?
 * ------------------------------------------------------------
 *
 * Sebagian besar aplikasi Java modern tidak bergantung
 * pada console sebagai media interaksi utama.
 *
 * Contohnya meliputi:
 *
 * - Aplikasi desktop (GUI)
 * - Aplikasi web
 * - Web service dan REST API
 * - Aplikasi enterprise
 * - Layanan server (backend)
 *
 * Program berbasis console tetap banyak digunakan,
 * terutama untuk:
 *
 * - Pembelajaran
 * - Utilitas (utility tools)
 * - Script otomatisasi
 * - Aplikasi command-line (CLI)
 *
 * Dengan demikian, console bukan satu-satunya bentuk
 * aplikasi Java, tetapi tetap memiliki peran penting
 * dalam berbagai skenario pengembangan.
 */


/* ------------------------------------------------------------
 * Console I/O di Java
 * ------------------------------------------------------------
 *
 * Java menyediakan fasilitas untuk melakukan input
 * dan output melalui console.
 *
 * Dibandingkan beberapa bahasa pemrograman lain,
 * penggunaan console I/O di Java terkadang memerlukan
 * lebih banyak kelas dan objek sehingga terlihat
 * sedikit lebih kompleks.
 *
 * Namun, pendekatan tersebut memberikan fleksibilitas,
 * konsistensi, dan kemampuan untuk menangani berbagai
 * sumber data dengan antarmuka yang seragam.
 */


/* ------------------------------------------------------------
 * Kekuatan Sistem I/O Java
 * ------------------------------------------------------------
 *
 * Salah satu keunggulan Java adalah desain sistem I/O
 * yang bersifat umum dan dapat digunakan untuk berbagai
 * jenis sumber data.
 *
 * Sistem I/O Java dapat bekerja dengan:
 *
 * - File
 * - Network (socket)
 * - Memory
 * - Stream data lainnya
 *
 * Konsep yang digunakan pada berbagai media tersebut
 * pada dasarnya sama, sehingga mempermudah proses
 * pembelajaran dan pengembangan aplikasi.
 */


/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * - I/O (Input/Output) digunakan untuk menerima dan
 *   menghasilkan data.
 *
 * - Pada materi sebelumnya, contoh program umumnya hanya
 *   menggunakan System.out.print() dan
 *   System.out.println().
 *
 * - Sebagian besar aplikasi Java modern tidak hanya
 *   menggunakan console, tetapi juga GUI, web,
 *   maupun layanan backend.
 *
 * - Java menyediakan sistem I/O yang kuat, fleksibel,
 *   dan konsisten untuk berbagai sumber data,
 *   seperti file, network, dan media lainnya.
 */


/* ------------------------------------------------------------
 * Insight
 * ------------------------------------------------------------
 *
 * Seluruh mekanisme I/O di Java dibangun di atas konsep
 * stream (aliran data).
 *
 * Setelah memahami dasar I/O, materi selanjutnya biasanya
 * akan membahas berbagai jenis stream, seperti:
 *
 * - Byte Stream
 * - Character Stream
 * - Buffered Stream
 * - File I/O
 *
 * Konsep-konsep tersebut menjadi fondasi dalam pengolahan
 * data pada hampir semua aplikasi Java, baik aplikasi
 * desktop, web, maupun server.
 */

// -------------------------------------------------------------

/* ============================================================
 *                          STREAMS
 * ============================================================
 *
 * Stream merupakan konsep dasar dalam sistem Input/Output (I/O)
 * Java. Stream berfungsi sebagai jalur (flow) yang digunakan
 * untuk memindahkan data dari sumber (input) ke tujuan (output).
 *
 * Secara sederhana, stream dapat diartikan sebagai aliran data.
 */


/* ------------------------------------------------------------
 * Apa Itu Stream?
 * ------------------------------------------------------------
 *
 * Stream adalah abstraksi yang merepresentasikan aliran data
 * antara program dan suatu sumber atau tujuan data.
 *
 * Stream dapat digunakan untuk:
 *
 * - Membaca data (Input Stream)
 * - Menulis data (Output Stream)
 *
 * Dengan adanya abstraksi ini, Java menyediakan cara yang
 * konsisten untuk melakukan operasi I/O tanpa perlu
 * memperhatikan secara langsung media yang digunakan.
 */


/* ------------------------------------------------------------
 * Konsep Abstraksi Stream
 * ------------------------------------------------------------
 *
 * Stream dapat terhubung ke berbagai sumber maupun tujuan data,
 * misalnya:
 *
 * Sumber data (Input):
 * - File
 * - Keyboard
 * - Network
 * - Memory
 *
 * Tujuan data (Output):
 * - Layar (console)
 * - File
 * - Network
 * - Memory
 *
 * Meskipun media yang digunakan berbeda, Java memperlakukannya
 * dengan konsep stream yang sama sehingga pola penggunaan API
 * tetap konsisten.
 */


/* ------------------------------------------------------------
 * Keuntungan Menggunakan Stream
 * ------------------------------------------------------------
 *
 * Dengan konsep stream, developer tidak perlu mempelajari cara
 * berbeda untuk setiap media I/O.
 *
 * Misalnya, proses membaca data dari:
 *
 * - File
 * - Keyboard
 * - Socket jaringan
 *
 * pada dasarnya mengikuti pola yang serupa karena semuanya
 * direpresentasikan sebagai stream.
 *
 * Hal ini membuat kode menjadi lebih mudah dipelajari,
 * digunakan kembali (reusable), dan dipelihara (maintainable).
 */


/* ------------------------------------------------------------
 * Package yang Menyediakan Stream
 * ------------------------------------------------------------
 *
 * Sebagian besar kelas I/O tradisional berada dalam package:
 *
 * java.io
 *
 * Package ini menyediakan berbagai kelas untuk membaca dan
 * menulis data menggunakan konsep stream.
 *
 * Selain itu, Java juga menyediakan package yang lebih modern:
 *
 * java.nio
 *
 * NIO (New I/O) diperkenalkan untuk menyediakan mekanisme I/O
 * yang lebih efisien melalui fitur seperti Buffer, Channel,
 * dan operasi non-blocking.
 */


/* ============================================================
 *                BYTE STREAM vs CHARACTER STREAM
 * ============================================================
 *
 * Java menyediakan dua kelompok utama stream berdasarkan jenis
 * data yang diproses.
 */


/* ------------------------------------------------------------
 * 1. Byte Stream
 * ------------------------------------------------------------
 *
 * Byte Stream memproses data dalam satuan byte (8 bit).
 *
 * Byte Stream cocok digunakan untuk data biner (binary data),
 * seperti:
 *
 * - Gambar
 * - Audio
 * - Video
 * - File PDF
 * - File executable
 *
 * Seluruh data diperlakukan sebagai byte tanpa proses
 * konversi karakter.
 */


/* ------------------------------------------------------------
 * 2. Character Stream
 * ------------------------------------------------------------
 *
 * Character Stream memproses data dalam bentuk karakter Unicode.
 *
 * Character Stream lebih sesuai untuk data berbasis teks,
 * misalnya:
 *
 * - File .txt
 * - File .java
 * - File .xml
 * - File .json
 * - String
 *
 * Character Stream secara otomatis menangani proses konversi
 * antara byte dan karakter menggunakan character encoding
 * yang sesuai.
 */


/* ------------------------------------------------------------
 * Sejarah Singkat
 * ------------------------------------------------------------
 *
 * Pada Java 1.0, sistem I/O hanya menyediakan Byte Stream.
 *
 * Mulai Java 1.1, Character Stream diperkenalkan untuk
 * mempermudah pengolahan data teks, terutama yang menggunakan
 * Unicode.
 *
 * Saat ini:
 *
 * - Gunakan Byte Stream untuk data biner.
 * - Gunakan Character Stream untuk data teks.
 */


/* ------------------------------------------------------------
 * Fakta Penting
 * ------------------------------------------------------------
 *
 * Pada level sistem operasi dan perangkat keras, seluruh data
 * tetap disimpan dan dipindahkan dalam bentuk byte.
 *
 * Character Stream bukanlah jenis data yang berbeda, melainkan
 * lapisan (wrapper) di atas Byte Stream yang menangani proses
 * konversi byte menjadi karakter, serta sebaliknya.
 *
 * Dengan demikian, developer dapat bekerja langsung dengan
 * karakter tanpa harus mengelola proses encoding secara manual.
 */


/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * - Stream adalah abstraksi yang merepresentasikan aliran data.
 *
 * - Stream digunakan untuk membaca (input) maupun menulis
 *   (output) data.
 *
 * - Java menggunakan konsep stream agar seluruh proses I/O
 *   memiliki pola penggunaan yang konsisten, terlepas dari
 *   media yang digunakan.
 *
 * - Package java.io menyediakan API I/O tradisional, sedangkan
 *   java.nio menyediakan API I/O yang lebih modern dan efisien.
 *
 * - Byte Stream digunakan untuk data biner.
 *
 * - Character Stream digunakan untuk data teks (Unicode).
 *
 * - Pada akhirnya, seluruh operasi I/O tetap bekerja pada level
 *   byte, sedangkan Character Stream bertugas melakukan konversi
 *   antara byte dan karakter secara otomatis.
 */


/* ------------------------------------------------------------
 * Insight
 * ------------------------------------------------------------
 *
 * Hampir seluruh kelas I/O di Java dibangun berdasarkan konsep
 * stream. Setelah memahami materi ini, biasanya pembahasan akan
 * berlanjut ke kelas-kelas seperti:
 *
 * - InputStream dan OutputStream (Byte Stream)
 * - Reader dan Writer (Character Stream)
 * - BufferedInputStream / BufferedOutputStream
 * - BufferedReader / BufferedWriter
 * - FileInputStream / FileOutputStream
 * - FileReader / FileWriter
 *
 * Memahami konsep stream akan memudahkan dalam mempelajari
 * seluruh API I/O di Java.
 */

// ------------------------------------------------------------------

/* ============================================================
 *                    BYTE STREAM CLASSES
 * ============================================================
 *
 * Seluruh Byte Stream di Java dibangun di atas dua abstract class
 * utama yang berada dalam package java.io:
 *
 * - InputStream
 * - OutputStream
 *
 * Kedua class ini menjadi fondasi bagi seluruh operasi I/O yang
 * memproses data dalam bentuk byte (8 bit).
 */


/* ------------------------------------------------------------
 * Hierarki Byte Stream
 * ------------------------------------------------------------
 *
 * InputStream
 * - Abstract class untuk membaca data dalam bentuk byte.
 *
 * OutputStream
 * - Abstract class untuk menulis data dalam bentuk byte.
 *
 * Karena keduanya merupakan abstract class, objek tidak dapat
 * dibuat langsung dari InputStream maupun OutputStream.
 * Sebagai gantinya, Java menyediakan berbagai subclass yang
 * mengimplementasikan perilaku spesifik sesuai sumber atau tujuan
 * data.
 */


/* ------------------------------------------------------------
 * Class-Class Byte Stream
 * ------------------------------------------------------------
 *
 * Berikut beberapa subclass penting yang terdapat pada package
 * java.io:
 *
 * BufferedInputStream
 * - Membaca byte menggunakan buffer sehingga proses pembacaan
 *   menjadi lebih efisien.
 *
 * BufferedOutputStream
 * - Menulis byte menggunakan buffer agar proses penulisan
 *   lebih cepat.
 *
 * ByteArrayInputStream
 * - Membaca data dari array byte yang berada di memori.
 *
 * ByteArrayOutputStream
 * - Menulis data ke array byte di memori.
 *
 * DataInputStream
 * - Membaca tipe data primitif Java, seperti int, double,
 *   boolean, dan lain-lain.
 *
 * DataOutputStream
 * - Menulis tipe data primitif Java ke suatu output stream.
 *
 * FileInputStream
 * - Membaca data byte dari file.
 *
 * FileOutputStream
 * - Menulis data byte ke file.
 *
 * FilterInputStream
 * - Abstract class dasar untuk stream input yang memodifikasi
 *   atau menambahkan perilaku pada stream lain.
 *
 * FilterOutputStream
 * - Abstract class dasar untuk stream output yang menambahkan
 *   perilaku tertentu pada stream lain.
 *
 * ObjectInputStream
 * - Membaca objek Java melalui proses deserialization.
 *
 * ObjectOutputStream
 * - Menulis objek Java melalui proses serialization.
 *
 * PipedInputStream
 * - Digunakan untuk menerima data dari thread lain melalui
 *   PipedOutputStream.
 *
 * PipedOutputStream
 * - Digunakan untuk mengirim data ke PipedInputStream.
 *
 * PrintStream
 * - Output stream yang menyediakan method seperti print(),
 *   println(), dan printf().
 *
 * PushbackInputStream
 * - Memungkinkan satu atau beberapa byte dikembalikan (push back)
 *   ke stream sehingga dapat dibaca kembali.
 *
 * SequenceInputStream
 * - Menggabungkan beberapa InputStream sehingga dapat dibaca
 *   seolah-olah menjadi satu stream.
 */


/* ------------------------------------------------------------
 * Method Penting pada Byte Stream
 * ------------------------------------------------------------
 *
 * Hampir seluruh Byte Stream mengimplementasikan dua operasi
 * dasar berikut.
 *
 * read()
 * - Membaca satu atau beberapa byte dari stream.
 * - Mengembalikan nilai byte yang dibaca.
 * - Mengembalikan -1 jika sudah mencapai akhir stream (EOF).
 *
 * write()
 * - Menulis satu atau beberapa byte ke output stream.
 *
 * Kedua operasi ini didefinisikan pada abstract class induknya
 * dan diimplementasikan oleh subclass sesuai perilaku masing-masing.
 */


/* ------------------------------------------------------------
 * Konsep Penting
 * ------------------------------------------------------------
 *
 * Java menggunakan satu konsep yang konsisten untuk seluruh
 * operasi I/O, yaitu stream.
 *
 * Dengan demikian, pola penggunaan API relatif sama meskipun
 * media yang digunakan berbeda, misalnya:
 *
 * - File
 * - Network
 * - Memory
 * - Device lainnya
 *
 * Inilah yang membuat sistem I/O Java menjadi fleksibel dan
 * mudah dikembangkan.
 */


/* ------------------------------------------------------------
 * Byte Stream vs Character Stream
 * ------------------------------------------------------------
 *
 * Byte Stream
 * - Memproses data mentah dalam bentuk byte.
 * - Cocok untuk file biner seperti gambar, audio, video,
 *   PDF, atau file executable.
 *
 * Character Stream
 * - Memproses data dalam bentuk karakter Unicode.
 * - Cocok untuk data teks seperti file .txt, .java, atau .xml.
 */


/* ------------------------------------------------------------
 * Hal yang Perlu Diperhatikan
 * ------------------------------------------------------------
 *
 * - Selalu tutup stream setelah selesai digunakan agar resource
 *   sistem dilepaskan.
 *
 * - Gunakan try-with-resources jika memungkinkan karena stream
 *   akan ditutup secara otomatis.
 *
 * - Gunakan Character Stream untuk data teks agar proses
 *   encoding dan decoding karakter ditangani secara otomatis.
 *
 * - Gunakan Byte Stream untuk data biner agar isi file tetap
 *   diproses secara utuh.
 */


/* ------------------------------------------------------------
 * Penggunaan di Dunia Nyata
 * ------------------------------------------------------------
 *
 * Konsep Byte Stream menjadi dasar berbagai fitur Java,
 * antara lain:
 *
 * - File handling
 * - Upload dan download file
 * - Socket programming
 * - REST API
 * - Backend server
 *
 * Hampir seluruh proses pemindahan data pada aplikasi Java
 * memanfaatkan konsep stream.
 */


/* ============================================================
 *                 CHARACTER STREAM CLASSES
 * ============================================================
 *
 * Character Stream digunakan untuk memproses data dalam bentuk
 * karakter Unicode.
 *
 * Hierarki Character Stream dibangun di atas dua abstract class:
 *
 * - Reader
 * - Writer
 */


/* ------------------------------------------------------------
 * Hierarki Character Stream
 * ------------------------------------------------------------
 *
 * Reader
 * - Abstract class untuk membaca karakter.
 *
 * Writer
 * - Abstract class untuk menulis karakter.
 *
 * Character Stream menangani proses konversi antara byte dan
 * karakter secara otomatis menggunakan character encoding.
 */


/* ------------------------------------------------------------
 * Class-Class Character Stream
 * ------------------------------------------------------------
 *
 * BufferedReader
 * - Membaca karakter menggunakan buffer sehingga lebih efisien.
 *
 * BufferedWriter
 * - Menulis karakter menggunakan buffer.
 *
 * CharArrayReader
 * - Membaca karakter dari array char.
 *
 * CharArrayWriter
 * - Menulis karakter ke array char.
 *
 * FileReader
 * - Membaca karakter dari file teks.
 *
 * FileWriter
 * - Menulis karakter ke file teks.
 *
 * FilterReader
 * - Abstract class dasar untuk reader yang memodifikasi
 *   perilaku stream lain.
 *
 * FilterWriter
 * - Abstract class dasar untuk writer yang memodifikasi
 *   perilaku stream lain.
 *
 * InputStreamReader
 * - Mengubah Byte Stream menjadi Character Stream.
 *
 * LineNumberReader
 * - Reader yang dapat melacak nomor baris.
 *
 * OutputStreamWriter
 * - Mengubah Character Stream menjadi Byte Stream.
 *
 * PipedReader
 * - Menerima karakter dari thread lain melalui PipedWriter.
 *
 * PipedWriter
 * - Mengirim karakter ke PipedReader.
 *
 * PrintWriter
 * - Menyediakan method print(), println(), dan printf()
 *   untuk output karakter.
 *
 * PushbackReader
 * - Memungkinkan karakter dikembalikan ke stream agar dapat
 *   dibaca kembali.
 *
 * StringReader
 * - Membaca karakter dari objek String.
 *
 * StringWriter
 * - Menulis karakter ke objek String.
 */


/* ------------------------------------------------------------
 * Method Penting pada Character Stream
 * ------------------------------------------------------------
 *
 * Character Stream juga memiliki dua operasi utama:
 *
 * read()
 * - Membaca karakter dari stream.
 *
 * write()
 * - Menulis karakter ke stream.
 *
 * Seluruh subclass Reader dan Writer mengimplementasikan
 * operasi dasar tersebut sesuai fungsinya masing-masing.
 */


/* ------------------------------------------------------------
 * Mengapa Character Stream Penting?
 * ------------------------------------------------------------
 *
 * Sebagian besar data yang diproses manusia berupa teks.
 *
 * Oleh karena itu, Character Stream menjadi pilihan utama
 * ketika bekerja dengan:
 *
 * - File teks
 * - Source code
 * - Dokumen
 * - Konfigurasi
 * - Data berbasis teks lainnya
 *
 * Dibandingkan Byte Stream, Character Stream jauh lebih nyaman
 * karena proses konversi karakter ditangani secara otomatis.
 */


/* ------------------------------------------------------------
 * InputStreamReader & OutputStreamWriter
 * ------------------------------------------------------------
 *
 * Dua class ini berperan sebagai jembatan antara Byte Stream
 * dan Character Stream.
 *
 * InputStreamReader
 * - Mengubah Byte Stream menjadi Character Stream.
 *
 * OutputStreamWriter
 * - Mengubah Character Stream menjadi Byte Stream.
 *
 * Class ini juga bertanggung jawab melakukan proses encoding
 * dan decoding karakter menggunakan charset tertentu
 * (misalnya UTF-8).
 */


/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * Byte Stream
 * - Berbasis InputStream dan OutputStream.
 * - Digunakan untuk data biner.
 *
 * Character Stream
 * - Berbasis Reader dan Writer.
 * - Digunakan untuk data teks.
 *
 * Character Stream sebenarnya bekerja di atas Byte Stream,
 * kemudian menambahkan proses konversi karakter sehingga
 * lebih mudah digunakan untuk pengolahan teks.
 */

// --------------------------------------------------------------------

/* ============================================================
 *                    PREDEFINED STREAMS (System Streams)
 * ============================================================
 *
 * Setiap program Java secara otomatis memiliki akses ke class
 * System.
 *
 * Class System berada di package java.lang sehingga tidak perlu
 * di-import secara manual.
 *
 * Class ini menyediakan berbagai utilitas sistem, termasuk
 * tiga stream standar (standard streams) yang digunakan untuk
 * operasi Input/Output (I/O).
 */


/* ------------------------------------------------------------
 * Class System
 * ------------------------------------------------------------
 *
 * Class System menyediakan akses ke berbagai resource milik JVM,
 * seperti:
 *
 * - Standard input
 * - Standard output
 * - Standard error
 * - Waktu sistem
 * - Environment variables
 * - System properties
 *
 * Pada pembahasan I/O, fokus utama kita adalah tiga standard
 * stream yang dimiliki oleh class System.
 */


/* ------------------------------------------------------------
 * Tiga Standard Stream
 * ------------------------------------------------------------
 *
 * Java menyediakan tiga predefined stream yang langsung siap
 * digunakan:
 *
 * - System.in
 * - System.out
 * - System.err
 *
 * Ketiganya dibuat oleh JVM saat program dijalankan sehingga
 * dapat langsung digunakan tanpa membuat object sendiri.
 */


/* ------------------------------------------------------------
 * 1. System.out
 * ------------------------------------------------------------
 *
 * System.out merupakan standard output stream.
 *
 * Secara default, output akan diarahkan ke console (terminal).
 *
 * Contoh penggunaan:
 *
 * System.out.println("Hello, World!");
 *
 * Stream ini biasanya digunakan untuk:
 *
 * - Menampilkan informasi
 * - Menampilkan hasil program
 * - Debug sederhana
 */


/* ------------------------------------------------------------
 * 2. System.in
 * ------------------------------------------------------------
 *
 * System.in merupakan standard input stream.
 *
 * Secara default, input berasal dari keyboard.
 *
 * Stream ini digunakan untuk membaca data yang dimasukkan
 * oleh pengguna.
 *
 * Karena bertipe InputStream (Byte Stream), biasanya
 * System.in dibungkus menggunakan Character Stream agar
 * lebih nyaman digunakan saat membaca teks.
 */


/* ------------------------------------------------------------
 * 3. System.err
 * ------------------------------------------------------------
 *
 * System.err merupakan standard error stream.
 *
 * Secara default, output juga ditampilkan ke console.
 *
 * Stream ini digunakan untuk menampilkan pesan kesalahan
 * (error message) atau informasi diagnostik.
 *
 * Walaupun secara default tampil di console yang sama,
 * System.err dipisahkan dari System.out sehingga keduanya
 * dapat diarahkan (redirect) ke tujuan yang berbeda.
 */


/* ------------------------------------------------------------
 * Tipe Data Standard Stream
 * ------------------------------------------------------------
 *
 * Standard Stream      Tipe
 * ------------------------------------------
 * System.in            InputStream
 * System.out           PrintStream
 * System.err           PrintStream
 *
 * Perhatikan bahwa:
 *
 * - System.in menggunakan Byte Stream.
 * - System.out dan System.err menggunakan PrintStream,
 *   yang merupakan turunan dari OutputStream.
 */


/* ------------------------------------------------------------
 * Mengapa System.out Bisa Menampilkan Teks?
 * ------------------------------------------------------------
 *
 * Walaupun PrintStream termasuk Byte Stream, kita tetap dapat
 * mencetak karakter atau String menggunakan method seperti:
 *
 * - print()
 * - println()
 * - printf()
 *
 * Hal ini karena PrintStream secara otomatis melakukan konversi
 * karakter menjadi byte menggunakan character encoding yang sesuai.
 */


/* ------------------------------------------------------------
 * Stream Redirection
 * ------------------------------------------------------------
 *
 * Standard stream tidak harus selalu terhubung ke console.
 *
 * Stream tersebut dapat dialihkan (redirect) ke media lain,
 * misalnya:
 *
 * - File
 * - Network
 * - Memory
 * - Device lain
 *
 * Contohnya, output yang biasanya tampil di console dapat
 * diarahkan ke sebuah file tanpa mengubah logika program.
 */


/* ------------------------------------------------------------
 * Membungkus System.in dengan Character Stream
 * ------------------------------------------------------------
 *
 * Karena System.in merupakan Byte Stream, pembacaan teks akan
 * lebih nyaman jika menggunakan Character Stream.
 *
 * Contoh yang sangat umum:
 *
 * BufferedReader br =
 *     new BufferedReader(
 *         new InputStreamReader(System.in)
 *     );
 *
 * InputStreamReader bertugas mengubah Byte Stream menjadi
 * Character Stream, sedangkan BufferedReader menambahkan
 * mekanisme buffer agar pembacaan teks menjadi lebih efisien.
 *
 * Pada Java modern, pembacaan input dari console juga sering
 * menggunakan Scanner, meskipun BufferedReader tetap banyak
 * digunakan karena lebih efisien pada kondisi tertentu.
 */


/* ============================================================
 *            BYTE STREAM vs CHARACTER STREAM
 * ============================================================
 *
 * Byte Stream
 * - Memproses data dalam bentuk byte.
 * - Cocok untuk data biner.
 *
 * Character Stream
 * - Memproses data dalam bentuk karakter Unicode.
 * - Cocok untuk data teks.
 *
 * Contoh:
 *
 * Byte Stream        Character Stream
 * ----------------------------------------------
 * FileInputStream    FileReader
 * FileOutputStream   FileWriter
 * InputStream        Reader
 * OutputStream       Writer
 *
 * Character Stream bekerja di atas Byte Stream dan menangani
 * proses encoding serta decoding karakter secara otomatis.
 */


/* ------------------------------------------------------------
 * Penggunaan di Dunia Nyata
 * ------------------------------------------------------------
 *
 * Konsep standard stream dan Character Stream banyak digunakan
 * dalam berbagai jenis aplikasi, misalnya:
 *
 * - Membaca input pengguna
 * - Membaca file teks
 * - Parsing data
 * - Logging
 * - Aplikasi command-line (CLI)
 * - Backend server
 */


/* ------------------------------------------------------------
 * Mindset yang Perlu Diingat
 * ------------------------------------------------------------
 *
 * Byte Stream
 * - Berorientasi pada data mentah.
 *
 * Character Stream
 * - Berorientasi pada data yang dibaca dan ditulis manusia,
 *   yaitu karakter atau teks.
 *
 * Oleh karena itu:
 *
 * - Gunakan Byte Stream untuk data biner.
 * - Gunakan Character Stream untuk data teks.
 */


/* ------------------------------------------------------------
 * Ringkasan
 * ------------------------------------------------------------
 *
 * - Class System menyediakan tiga standard stream:
 *   System.in, System.out, dan System.err.
 *
 * - System.in bertipe InputStream dan digunakan untuk input.
 *
 * - System.out dan System.err bertipe PrintStream dan digunakan
 *   untuk output normal maupun output error.
 *
 * - Ketiga stream tersebut secara default terhubung ke console,
 *   tetapi dapat dialihkan (redirect) ke media lain.
 *
 * - Untuk membaca teks, System.in biasanya dibungkus dengan
 *   InputStreamReader dan BufferedReader, atau menggunakan
 *   Scanner pada Java modern.
 *
 * - Byte Stream bekerja dengan byte, sedangkan Character Stream
 *   bekerja dengan karakter Unicode dan lebih sesuai untuk
 *   pengolahan data teks.
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
