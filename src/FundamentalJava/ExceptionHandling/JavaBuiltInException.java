package FundamentalJava.ExceptionHandling;

/**
 * ------------------------------------------------------------
 * JAVA'S BUILT-IN EXCEPTIONS
 * ------------------------------------------------------------
 *
 * Java menyediakan banyak exception bawaan (built-in exceptions)
 * yang dapat digunakan langsung tanpa perlu membuat class
 * exception sendiri..
 *
 * Sebagian besar exception bawaan berada dalam package:
 *
 * java.lang
 *
 * Karena package java.lang di-import otomatis oleh Java,
 * exception tersebut dapat langsung digunakan tanpa
 * import tambahan.
 *
 * Contoh:
 *
 * ArithmeticException
 * NullPointerException
 * IllegalArgumentException
 * NumberFormatException
 *
 * ------------------------------------------------------------
 * DUA KATEGORI BESAR EXCEPTION
 * ------------------------------------------------------------
 *
 * Secara umum exception di Java dibagi menjadi:
 *
 * 1. Checked Exceptions
 * 2. Unchecked Exceptions
 *
 * Perbedaan ini sangat penting karena mempengaruhi
 * bagaimana compiler memperlakukan exception tersebut.
 *
 * ------------------------------------------------------------
 * 1. CHECKED EXCEPTIONS
 * ------------------------------------------------------------
 *
 * Checked Exception adalah exception yang diperiksa
 * oleh compiler saat proses kompilasi.
 *
 * Jika sebuah method dapat menghasilkan checked exception,
 * programmer WAJIB:
 *
 * - Menangkapnya dengan try-catch
 * atau
 * - Mendeklarasikannya dengan throws
 *
 * Jika tidak dilakukan,
 * program tidak akan berhasil dikompilasi.
 *
 * Contoh:
 *
 * FileReader reader =
 *         new FileReader("data.txt");
 *
 * Compiler akan memaksa kita menangani:
 *
 * FileNotFoundException
 *
 * Contoh:
 *
 * try {
 *     FileReader reader =
 *             new FileReader("data.txt");
 * }
 * catch (FileNotFoundException e) {
 *     e.printStackTrace();
 * }
 *
 * atau:
 *
 * void bacaFile()
 *         throws FileNotFoundException {
 * }
 *
 * ------------------------------------------------------------
 * CONTOH CHECKED EXCEPTIONS
 * ------------------------------------------------------------
 *
 * IOException
 * FileNotFoundException
 * SQLException
 * ClassNotFoundException
 * InterruptedException
 *
 * Umumnya exception ini muncul karena:
 *
 * - File tidak ditemukan
 * - Database gagal diakses
 * - Network error
 * - Resource eksternal tidak tersedia
 *
 * Artinya:
 * masalah berasal dari luar program
 * dan sering kali berada di luar kontrol programmer.
 *
 * ------------------------------------------------------------
 * 2. UNCHECKED EXCEPTIONS
 * ------------------------------------------------------------
 *
 * Unchecked Exception adalah exception yang merupakan
 * turunan dari:
 *
 * RuntimeException
 *
 * Exception jenis ini:
 *
 * - Tidak diperiksa compiler
 * - Tidak wajib ditangani
 * - Tidak wajib menggunakan throws
 *
 * Program tetap bisa dikompilasi meskipun exception
 * tersebut tidak ditangani.
 *
 * Contoh:
 *
 * int result = 10 / 0;
 *
 * Compiler tidak protes.
 *
 * Tetapi saat runtime:
 *
 * ArithmeticException
 *
 * akan terjadi.
 *
 * ------------------------------------------------------------
 * CONTOH UNCHECKED EXCEPTIONS
 * ------------------------------------------------------------
 *
 * ArithmeticException
 * NullPointerException
 * NumberFormatException
 * ArrayIndexOutOfBoundsException
 * IndexOutOfBoundsException
 * IllegalArgumentException
 * IllegalStateException
 * ClassCastException
 *
 * Biasanya exception ini muncul karena:
 *
 * - Kesalahan logika program
 * - Bug pada kode
 * - Validasi yang kurang
 *
 * ------------------------------------------------------------
 * PERBANDINGAN CHECKED DAN UNCHECKED
 * ------------------------------------------------------------
 *
 * Jenis                    Dicek Compiler    Wajib Ditangani
 * ------------------------------------------------------------
 * Checked Exception        Ya                Ya
 * RuntimeException         Tidak             Tidak
 *
 * ------------------------------------------------------------
 * FILOSOFI DESAIN JAVA
 * ------------------------------------------------------------
 *
 * Java membedakan kedua kategori ini karena
 * sumber masalahnya berbeda.
 *
 * Checked Exception:
 *
 * Kondisi eksternal yang masih mungkin terjadi
 * meskipun kode sudah benar.
 *
 * Contoh:
 *
 * - File hilang
 * - Database offline
 * - Network putus
 *
 * Karena masih mungkin terjadi,
 * programmer dipaksa memikirkan cara menanganinya.
 *
 * ------------------------------------------------------------
 *
 * RuntimeException:
 *
 * Biasanya menunjukkan kesalahan pada logika program.
 *
 * Contoh:
 *
 * String name = null;
 * name.length();
 *
 * menghasilkan:
 *
 * NullPointerException
 *
 * Masalahnya bukan kondisi eksternal.
 * Masalahnya ada pada kode yang ditulis programmer.
 *
 * Oleh karena itu Java tidak memaksa penggunaan
 * try-catch untuk RuntimeException.
 *
 * Yang seharusnya dilakukan:
 *
 * memperbaiki kode,
 * bukan menyembunyikan error.
 *
 * ------------------------------------------------------------
 * HIERARKI SEDERHANA
 * ------------------------------------------------------------
 *
 * Throwable
 * │
 * ├── Error
 * │
 * └── Exception
 *      │
 *      ├── RuntimeException
 *      │    ├── NullPointerException
 *      │    ├── ArithmeticException
 *      │    ├── NumberFormatException
 *      │    └── ...
 *      │
 *      ├── IOException
 *      ├── SQLException
 *      ├── InterruptedException
 *      └── ...
 *
 * ------------------------------------------------------------
 * PRAKTIK MODERN JAVA
 * ------------------------------------------------------------
 *
 * Jangan menangkap RuntimeException hanya untuk
 * menyembunyikan bug.
 *
 * Hindari pola seperti:
 *
 * try {
 *     // kode
 * }
 * catch (Exception e) {
 * }
 *
 * karena:
 *
 * - Menyembunyikan masalah sebenarnya
 * - Menyulitkan debugging
 * - Membuat bug sulit ditemukan
 *
 * Lebih baik:
 *
 * - Perbaiki akar masalah
 * - Validasi input
 * - Hindari nilai null yang tidak perlu
 * - Gunakan exception yang spesifik
 *
 * ------------------------------------------------------------
 * MINDSET PROGRAMMER JAVA
 * ------------------------------------------------------------
 *
 * Error karena kondisi eksternal
 * -> Handle (try-catch / throws)
 *
 * Error karena bug atau logika salah
 * -> Fix kode
 *
 * Jangan menggunakan try-catch sebagai alat
 * untuk menutupi kesalahan desain program.
 *
 * ------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------
 *
 * - Java menyediakan banyak built-in exceptions.
 * - Exception dibagi menjadi Checked dan Unchecked.
 * - Checked Exception wajib ditangani atau
 *   dideklarasikan dengan throws.
 * - Unchecked Exception (RuntimeException)
 *   tidak wajib ditangani.
 * - Checked Exception biasanya berkaitan dengan
 *   kondisi eksternal.
 * - RuntimeException biasanya menunjukkan bug
 *   atau kesalahan logika program.
 * - Programmer profesional tidak berusaha
 *   menyembunyikan RuntimeException,
 *   tetapi mencari dan memperbaiki penyebabnya.
 */

/**
 * ------------------------------------------------------------
 * DAFTAR UNCHECKED EXCEPTIONS (RuntimeException)
 * ------------------------------------------------------------
 *
 * Unchecked Exception adalah exception yang merupakan turunan dari:
 *
 * RuntimeException
 *
 * Exception jenis ini:
 *
 * - Tidak diperiksa oleh compiler
 * - Tidak wajib ditangani menggunakan try-catch
 * - Tidak wajib dideklarasikan dengan throws
 *
 * Walaupun tidak wajib ditangani, exception ini tetap dapat
 * menyebabkan program berhenti saat runtime jika tidak
 * dicegah atau diperbaiki.
 *
 * Dalam praktik modern Java, RuntimeException umumnya
 * menunjukkan adanya bug, kesalahan logika, atau validasi
 * yang kurang baik pada program.
 *
 * ------------------------------------------------------------
 * EXCEPTION YANG PALING SERING DITEMUI
 * ------------------------------------------------------------
 *
 * 1. ArithmeticException
 *
 * Terjadi ketika operasi aritmatika tidak valid.
 *
 * Contoh:
 *
 * int result = 10 / 0;
 *
 * Output:
 *
 * java.lang.ArithmeticException: / by zero
 *
 * ------------------------------------------------------------
 *
 * 2. NullPointerException (NPE)
 *
 * Terjadi saat mencoba mengakses member dari reference
 * yang bernilai null.
 *
 * Contoh:
 *
 * String text = null;
 * text.length();
 *
 * Salah satu RuntimeException yang paling sering terjadi.
 *
 * Sejak Java 14, JVM menampilkan pesan NPE yang jauh lebih
 * informatif (Helpful NullPointerExceptions).
 *
 * ------------------------------------------------------------
 *
 * 3. NumberFormatException
 *
 * Terjadi saat String tidak dapat dikonversi ke angka.
 *
 * Contoh:
 *
 * Integer.parseInt("abc");
 *
 * ------------------------------------------------------------
 * EXCEPTION TERKAIT INDEX DAN KOLEKSI
 * ------------------------------------------------------------
 *
 * 4. ArrayIndexOutOfBoundsException
 *
 * Index array berada di luar batas.
 *
 * Contoh:
 *
 * int[] numbers = {1, 2, 3};
 * numbers[10];
 *
 * ------------------------------------------------------------
 *
 * 5. StringIndexOutOfBoundsException
 *
 * Index String berada di luar batas.
 *
 * Contoh:
 *
 * "Hello".charAt(10);
 *
 * ------------------------------------------------------------
 *
 * 6. IndexOutOfBoundsException
 *
 * Superclass umum untuk exception yang berkaitan
 * dengan index yang tidak valid.
 *
 * Sering muncul pada:
 *
 * - List
 * - Array
 * - String
 * - Buffer
 *
 * ------------------------------------------------------------
 *
 * 7. NegativeArraySizeException
 *
 * Terjadi ketika array dibuat dengan ukuran negatif.
 *
 * Contoh:
 *
 * int[] arr = new int[-5];
 *
 * ------------------------------------------------------------
 * EXCEPTION TERKAIT TIPE DATA DAN CASTING
 * ------------------------------------------------------------
 *
 * 8. ClassCastException
 *
 * Terjadi ketika object dicasting ke tipe yang tidak sesuai.
 *
 * Contoh:
 *
 * Object obj = "Hello";
 * Integer number = (Integer) obj;
 *
 * ------------------------------------------------------------
 *
 * 9. ArrayStoreException
 *
 * Terjadi ketika tipe object yang tidak sesuai disimpan
 * ke dalam array bertipe spesifik.
 *
 * Contoh:
 *
 * Object[] data = new String[5];
 * data[0] = 100;
 *
 * ------------------------------------------------------------
 *
 * 10. TypeNotPresentException
 *
 * Terjadi ketika suatu tipe yang direferensikan
 * tidak ditemukan saat runtime.
 *
 * Biasanya muncul pada:
 *
 * - Reflection
 * - Annotation processing
 * - Dynamic class loading
 *
 * Relatif jarang ditemui dalam kode sehari-hari.
 *
 * ------------------------------------------------------------
 * EXCEPTION TERKAIT VALIDASI DAN STATE
 * ------------------------------------------------------------
 *
 * 11. IllegalArgumentException
 *
 * Terjadi ketika argument yang diberikan ke method
 * tidak valid.
 *
 * Contoh:
 *
 * Thread.sleep(-1);
 *
 * Dalam Java modern, exception ini sangat sering digunakan
 * untuk validasi parameter method.
 *
 * ------------------------------------------------------------
 *
 * 12. IllegalStateException
 *
 * Terjadi ketika object berada pada kondisi (state)
 * yang tidak sesuai untuk menjalankan operasi tertentu.
 *
 * Contoh:
 *
 * Scanner scanner = new Scanner(System.in);
 * scanner.close();
 * scanner.nextLine();
 *
 * ------------------------------------------------------------
 *
 * 13. UnsupportedOperationException
 *
 * Terjadi ketika operasi tidak didukung oleh object.
 *
 * Contoh:
 *
 * List<Integer> list = List.of(1, 2, 3);
 * list.add(4);
 *
 * List.of() menghasilkan collection immutable
 * sehingga operasi modifikasi tidak diperbolehkan.
 *
 * ------------------------------------------------------------
 * EXCEPTION TERKAIT THREADING
 * ------------------------------------------------------------
 *
 * 14. IllegalMonitorStateException
 *
 * Terjadi ketika wait(), notify(), atau notifyAll()
 * dipanggil tanpa memiliki monitor lock yang sesuai.
 *
 * Contoh:
 *
 * obj.wait();
 *
 * tanpa synchronized.
 *
 * ------------------------------------------------------------
 *
 * 15. IllegalThreadStateException
 *
 * Terjadi ketika operasi thread dilakukan
 * pada state yang tidak valid.
 *
 * Contoh:
 *
 * Thread t = new Thread();
 * t.start();
 * t.start();
 *
 * Thread hanya boleh dijalankan satu kali.
 *
 * ------------------------------------------------------------
 * EXCEPTION TERKAIT ENUM DAN SECURITY
 * ------------------------------------------------------------
 *
 * 16. EnumConstantNotPresentException
 *
 * Terjadi ketika konstanta enum yang diminta
 * tidak ditemukan.
 *
 * Umumnya muncul pada:
 *
 * - Reflection
 * - Annotation processing
 * - Framework internal
 *
 * Relatif jarang ditemui.
 *
 * ------------------------------------------------------------
 *
 * 17. SecurityException
 *
 * Terjadi ketika operasi melanggar kebijakan keamanan.
 *
 * Pada Java modern exception ini relatif jarang
 * ditemui secara langsung karena SecurityManager
 * telah deprecated dan dihapus secara bertahap.
 *
 * Namun SecurityException masih digunakan oleh
 * beberapa library dan framework tertentu.
 *
 * ------------------------------------------------------------
 * POLA BESAR RUNTIMEEXCEPTION
 * ------------------------------------------------------------
 *
 * RuntimeException umumnya dapat dikelompokkan menjadi:
 *
 * 1. Error Logika Dasar
 *
 * - NullPointerException
 * - ArithmeticException
 * - NumberFormatException
 *
 * ------------------------------------------------------------
 *
 * 2. Error Index dan Struktur Data
 *
 * - ArrayIndexOutOfBoundsException
 * - IndexOutOfBoundsException
 * - StringIndexOutOfBoundsException
 * - NegativeArraySizeException
 *
 * ------------------------------------------------------------
 *
 * 3. Error Tipe dan Casting
 *
 * - ClassCastException
 * - ArrayStoreException
 * - TypeNotPresentException
 *
 * ------------------------------------------------------------
 *
 * 4. Error State dan Validasi
 *
 * - IllegalArgumentException
 * - IllegalStateException
 * - UnsupportedOperationException
 *
 * ------------------------------------------------------------
 *
 * 5. Error Concurrency dan Threading
 *
 * - IllegalMonitorStateException
 * - IllegalThreadStateException
 *
 * ------------------------------------------------------------
 * PRAKTIK MODERN JAVA
 * ------------------------------------------------------------
 *
 * Sebagian besar RuntimeException seharusnya dicegah
 * melalui desain kode yang baik, bukan ditangani
 * dengan try-catch secara membabi buta.
 *
 * Hindari:
 *
 * try {
 *     // kode
 * } catch (RuntimeException e) {
 * }
 *
 * karena dapat menyembunyikan bug.
 *
 * Lebih baik:
 *
 * - Validasi input
 * - Periksa null
 * - Validasi index
 * - Gunakan Optional jika sesuai
 * - Gunakan collection dengan benar
 * - Perbaiki logika program
 *
 * ------------------------------------------------------------
 * MINDSET PROGRAMMER JAVA
 * ------------------------------------------------------------
 *
 * Checked Exception
 * -> Biasanya kondisi eksternal
 * -> Handle atau propagate
 *
 * RuntimeException
 * -> Biasanya bug atau kesalahan logika
 * -> Cari penyebab dan perbaiki
 *
 * Jangan menggunakan try-catch untuk menutupi bug.
 *
 * ------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------
 *
 * - Semua exception di atas merupakan turunan
 *   RuntimeException.
 * - Compiler tidak memaksa penanganannya.
 * - Sebagian besar menunjukkan adanya bug,
 *   kesalahan logika, atau validasi yang kurang.
 * - RuntimeException umumnya harus diperbaiki
 *   pada sumber masalahnya, bukan sekadar ditangkap.
 * - NullPointerException, IllegalArgumentException,
 *   NumberFormatException, dan IndexOutOfBoundsException
 *   adalah exception yang paling sering ditemui
 *   dalam pengembangan aplikasi Java modern.
 */

/**
 * ------------------------------------------------------------
 * CHECKED EXCEPTIONS (java.lang dan Subpackage Terkait)
 * ------------------------------------------------------------
 *
 * Checked Exception adalah exception yang diperiksa oleh
 * compiler saat proses kompilasi.
 *
 * Jika sebuah method dapat menghasilkan checked exception,
 * programmer WAJIB:
 *
 * - Menangkapnya dengan try-catch
 * atau
 * - Meneruskannya menggunakan throws
 *
 * Jika tidak dilakukan:
 *
 * Compile Error
 *
 * Contoh:
 *
 * Thread.sleep(1000);
 *
 * Compiler akan memaksa kita:
 *
 * try {
 * Thread.sleep(1000);
 * } catch (InterruptedException e) {
 * e.printStackTrace();
 * }
 *
 * atau:
 *
 * void pause() throws InterruptedException {
 * Thread.sleep(1000);
 * }
 *
 * ------------------------------------------------------------
 * CONTOH CHECKED EXCEPTIONS PENTING
 * ------------------------------------------------------------
 *
 * 1. ClassNotFoundException
 *
 * Terjadi ketika JVM tidak dapat menemukan class
 * yang diminta saat runtime.
 *
 * Umumnya muncul saat menggunakan:
 *
 * Class.forName()
 *
 * Contoh:
 *
 * Class.forName("com.example.User");
 *
 * Jika class tidak ditemukan:
 *
 * ClassNotFoundException
 *
 * Banyak digunakan pada:
 *
 * - JDBC lama
 * - Dynamic class loading
 * - Framework
 * - Reflection
 *
 * ------------------------------------------------------------
 *
 * 2. CloneNotSupportedException
 *
 * Terjadi ketika clone() dipanggil pada object
 * yang tidak mengimplementasikan interface Cloneable.
 *
 * Contoh:
 *
 * obj.clone();
 *
 * jika object bukan Cloneable:
 *
 * CloneNotSupportedException
 *
 * Saat ini clone() relatif jarang digunakan
 * dalam Java modern.
 *
 * Lebih umum menggunakan:
 *
 * - Copy constructor
 * - Factory method
 * - Builder pattern
 *
 * ------------------------------------------------------------
 *
 * 3. IllegalAccessException
 *
 * Terjadi ketika kode mencoba mengakses member
 * yang tidak memiliki izin akses.
 *
 * Biasanya muncul pada Reflection API.
 *
 * Contoh:
 *
 * Field field =
 * clazz.getDeclaredField("name");
 *
 * field.get(obj);
 *
 * Jika akses tidak diizinkan:
 *
 * IllegalAccessException
 *
 * ------------------------------------------------------------
 *
 * 4. InstantiationException
 *
 * Terjadi ketika JVM gagal membuat instance
 * dari suatu class.
 *
 * Biasanya karena:
 *
 * - Abstract class
 * - Interface
 * - Class tertentu yang tidak dapat diinstansiasi
 *
 * Contoh:
 *
 * Class<?> clazz = Runnable.class;
 * clazz.newInstance();
 *
 * Akan menghasilkan:
 *
 * InstantiationException
 *
 * Catatan:
 *
 * newInstance() sudah deprecated.
 *
 * Java modern menggunakan:
 *
 * clazz.getDeclaredConstructor().newInstance();
 *
 * ------------------------------------------------------------
 *
 * 5. InterruptedException
 *
 * Terjadi ketika thread yang sedang menunggu
 * atau tidur (sleep) diinterupsi oleh thread lain.
 *
 * Contoh:
 *
 * Thread.sleep(1000);
 *
 * Jika thread di-interrupt:
 *
 * InterruptedException
 *
 * Exception ini sangat penting dalam:
 *
 * - Multithreading
 * - ExecutorService
 * - Concurrency API
 * - Parallel Processing
 *
 * ------------------------------------------------------------
 *
 * 6. NoSuchFieldException
 *
 * Terjadi ketika field yang dicari
 * tidak ditemukan.
 *
 * Umumnya muncul pada Reflection API.
 *
 * Contoh:
 *
 * clazz.getField("username");
 *
 * Jika field tidak ada:
 *
 * NoSuchFieldException
 *
 * ------------------------------------------------------------
 *
 * 7. NoSuchMethodException
 *
 * Terjadi ketika method yang dicari
 * tidak ditemukan.
 *
 * Contoh:
 *
 * clazz.getMethod("save");
 *
 * Jika method tidak ada:
 *
 * NoSuchMethodException
 *
 * Sering ditemui pada:
 *
 * - Reflection
 * - Framework internal
 * - Dynamic proxy
 *
 * ------------------------------------------------------------
 *
 * 8. ReflectiveOperationException
 *
 * Merupakan superclass modern untuk banyak
 * exception yang berkaitan dengan Reflection.
 *
 * Contoh turunannya:
 *
 * - ClassNotFoundException
 * - InstantiationException
 * - IllegalAccessException
 * - NoSuchFieldException
 * - NoSuchMethodException
 *
 * Digunakan ketika kita ingin menangkap
 * berbagai exception reflection sekaligus.
 *
 * Contoh:
 *
 * try {
 * // reflection code
 * }
 * catch (ReflectiveOperationException e) {
 * e.printStackTrace();
 * }
 *
 * ------------------------------------------------------------
 * POLA BESAR CHECKED EXCEPTIONS
 * ------------------------------------------------------------
 *
 * Checked Exception umumnya muncul karena:
 *
 * 1. Kondisi eksternal
 *
 * - File tidak ditemukan
 * - Database gagal diakses
 * - Network error
 *
 * ------------------------------------------------------------
 *
 * 2. Reflection dan Dynamic Loading
 *
 * - ClassNotFoundException
 * - NoSuchFieldException
 * - NoSuchMethodException
 * - IllegalAccessException
 *
 * ------------------------------------------------------------
 *
 * 3. Concurrency
 *
 * - InterruptedException
 *
 * ------------------------------------------------------------
 *
 * 4. Resource dan Sistem
 *
 * - IOException
 * - SQLException
 * - TimeoutException
 * (package lain)
 *
 * ------------------------------------------------------------
 * PERBANDINGAN DENGAN RUNTIMEEXCEPTION
 * ------------------------------------------------------------
 *
 * RuntimeException:
 *
 * int result = 10 / 0;
 *
 * Masalah:
 * bug atau kesalahan logika programmer.
 *
 * ------------------------------------------------------------
 *
 * Checked Exception:
 *
 * Thread.sleep(1000);
 *
 * Masalah:
 * kondisi eksternal yang masih mungkin terjadi
 * walaupun kode sudah benar.
 *
 * ------------------------------------------------------------
 *
 * RuntimeException:
 *
 * String name = null;
 * name.length();
 *
 * Salah programmer.
 *
 * ------------------------------------------------------------
 *
 * Checked Exception:
 *
 * Files.readString(path);
 *
 * File bisa saja:
 *
 * - Tidak ada
 * - Tidak bisa dibaca
 * - Sedang dikunci sistem
 *
 * Walaupun kode sudah benar.
 *
 * ------------------------------------------------------------
 * PRAKTIK MODERN JAVA
 * ------------------------------------------------------------
 *
 * Tidak semua Checked Exception harus ditangani
 * langsung dengan try-catch.
 *
 * Dalam aplikasi besar (misalnya Spring Boot),
 * sering kali exception diteruskan ke layer atas:
 *
 * service -> controller -> global handler
 *
 * menggunakan:
 *
 * throws
 *
 * agar penanganan error tetap terpusat.
 *
 * ------------------------------------------------------------
 * KOREKSI PENTING DARI CATATAN LAMA
 * ------------------------------------------------------------
 *
 * Tidak semua Checked Exception berada di java.lang.
 *
 * Contoh:
 *
 * java.lang
 * - InterruptedException
 * - ClassNotFoundException
 *
 * java.io
 * - IOException
 * - EOFException
 *
 * java.sql
 * - SQLException
 *
 * java.net
 * - MalformedURLException
 *
 * java.nio.file
 * - FileSystemException
 *
 * Jadi:
 *
 * Checked Exception tersebar di banyak package Java,
 * tidak hanya di java.lang.
 *
 * ------------------------------------------------------------
 * MINDSET PROGRAMMER JAVA
 * ------------------------------------------------------------
 *
 * RuntimeException
 * -> Biasanya bug
 * -> Perbaiki kode
 *
 * Checked Exception
 * -> Kondisi yang mungkin terjadi saat runtime
 * -> Handle atau propagate dengan throws
 *
 * ------------------------------------------------------------
 * KESIMPULAN
 * ------------------------------------------------------------
 *
 * - Checked Exception diperiksa oleh compiler.
 * - Wajib ditangani atau dideklarasikan menggunakan throws.
 * - Biasanya berkaitan dengan kondisi eksternal,
 * reflection, resource, atau concurrency.
 * - Exception seperti InterruptedException,
 * ClassNotFoundException, dan NoSuchMethodException
 * termasuk kategori Checked Exception.
 * - Dalam Java modern, banyak Checked Exception
 * diteruskan ke layer yang lebih tinggi agar
 * penanganan error tetap terpusat dan rapi.
 */

public class JavaBuiltInException {
    public static void main(String[] args) {

        // CONTOH UNCHECKED EXCEPTION
        // Runtime Exception
        int a = 100;
        int b = 0 / a;
        int c = 10 / (a - a);

        // CONTOH KODE - INTERRUPTED EXCEPTION
        // CHECKED EXCEPTION
        // Compile Exception
        try {
            Thread.sleep(1000); // wajib try catch
        } catch (InterruptedException e) {
            System.out.println("Thread terganggu.");
        }

        /**
         * Kesimpulan Penting
         *
         * Ini inti kerasnya:
         * Checked Exception = WAJIB ditangani
         * Kalau tidak:
         * compile error
         *
         * Contoh dunia nyata
         * file gak ada
         * koneksi putus
         * thread berhenti
         *
         * harus lu siapin solusinya
         *
         * Cara pro
         * tangkap spesifik:
         * catch (InterruptedException e)
         *
         * Ringkasan
         * 
         * Checked Exception = harus ditangani (try-catch / throws)
         * RuntimeException = tidak wajib (bug programmer)
         */

    }
}