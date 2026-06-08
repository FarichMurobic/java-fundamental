package ExceptionHandling;

    /**
     * Java’s Built-in Exceptions
     *
     * Di package java.lang, Java sudah menyediakan banyak class exception bawaan.
     * Sebagian sudah kita pakai di contoh sebelumnya.
     *
     * Dua Kategori Besar
     * 
     * 1. Unchecked Exceptions
     * Turunan dari RuntimeException
     * Tidak wajib pakai throws
     * Tidak dicek compiler
     *
     * disebut:
     * unchecked exception
     *
     * 2. Checked Exceptions
     * Harus ditangani atau dideklarasikan (throws)
     * Dicek oleh compiler
     *
     * disebut:
     * checked exception
     *
     * Intinya
     * Jenis	                Harus ditangani?	Dicek compiler?
     * RuntimeException	        Tidak wajib	        Tidak
     * Checked Exception	    Wajib	            Ya
     *
     * Kenapa dibedakan?
     * Java memisahkan:
     * Error karena logika programmer → RuntimeException
     * Error karena kondisi eksternal → Checked Exception
     *
     * ---------------------------------------------------------
     * 
     * Kesimpulan Penting (WAJIB INGAT)
     * Ini inti kerasnya:
     *
     * Semua exception ada di java.lang
     * Dibagi jadi:
     * Unchecked (RuntimeException)
     * Checked
     *
     * Unchecked Exception:
     * Tidak wajib ditangani
     * Biasanya karena bug di kode
     *
     * Contoh paling sering:
     * NullPointerException
     * ArrayIndexOutOfBoundsException
     * ArithmeticException
     * NumberFormatException
     *
     * Insight Tambahan (Level Up)
     * Mindset penting
     *
     * RuntimeException itu bukan buat ditutupin
     * tapi buat diperbaiki
     *
     * Salah:
     * catch (Exception e) {
     *     // diem aja
     * }
     *
     * Benar:
     * cari akar masalah:
     * null?
     * index salah?
     * parsing gagal?
     *
     * Tips biar gak kena
     * cek null sebelum pakai
     * cek panjang array
     * validasi input
     *
     * Ringkasan Super Singkat
     * RuntimeException = error logika (tidak wajib ditangani)
     * Checked Exception = harus ditangani
     */

    /**
     * DAFTAR UNCHECKED EXCEPTION (RuntimeException)
     *
     * Semua ini:
     * turunan dari RuntimeException
     * tidak wajib ditangani (unchecked)
     *
     * 1. ArithmeticException
     * Error matematika
     *
     * Contoh:
     * pembagian dengan nol
     * int a = 10 / 0;
     *
     * 2. ArrayIndexOutOfBoundsException
     * Index array di luar batas
     *
     * int[] arr = {1};
     * arr[5];
     *
     * 3. ArrayStoreException
     * Menyimpan tipe data yang salah ke array
     *
     * Object[] arr = new String[5];
     * arr[0] = 100; // ERROR
     *
     * 4. ClassCastException
     * Casting object ke tipe yang salah
     *
     * Object obj = "Hello";
     * Integer x = (Integer) obj;
     *
     * 5. EnumConstantNotPresentException
     * Mengakses enum yang tidak ada
     * // jarang terjadi, biasanya di enum advanced
     *
     * 6. IllegalArgumentException
     * Parameter method tidak valid
     * Thread.sleep(-1);
     *
     * 7. IllegalMonitorStateException
     * Operasi thread yang salah (wait/notify tanpa lock)
     * obj.wait(); // tanpa synchronized
     *
     * 8.️ IllegalStateException
     * Kondisi object tidak sesuai
     * // misalnya method dipanggil di state yang salah
     *
     * 9. IllegalThreadStateException
     * Operasi thread tidak sesuai state
     * Thread t = new Thread();
     * t.start();
     * t.start(); // ERROR
     *
     * 10. IndexOutOfBoundsException
     * Index umum di luar batas (induk dari array/string)
     *
     * 11. NegativeArraySizeException
     * Array dibuat dengan ukuran negatif
     * int[] arr = new int[-5];
     *
     * 12. NullPointerException (PALING SERING)
     * Akses object null
     * String s = null;
     * s.length();
     *
     * 13. NumberFormatException
     * String tidak bisa diubah jadi angka
     * Integer.parseInt("abc");
     *
     * 14. SecurityException
     * Melanggar aturan keamanan
     *
     * 15. StringIndexOutOfBoundsException
     * Index string di luar batas
     * "halo".charAt(10);
     *
     * 16. TypeNotPresentException
     * Tipe/class tidak ditemukan
     *
     * 17. UnsupportedOperationException
     * Operasi tidak didukung
     * List.of(1,2,3).add(4); // ERROR
     * 
     * ----------------------------------------------------
     *
     * Penjelasan Pola (BIAR NGERTI DALAM)
     * 
     * Kelompok Besar
     * 
     * 1. Error Logika Dasar
     * ArithmeticException
     * NullPointerException
     * NumberFormatException
     *
     * paling sering
     *
     * 2. Error Struktur Data
     * ArrayIndexOutOfBoundsException
     * IndexOutOfBoundsException
     * StringIndexOutOfBoundsException
     * NegativeArraySizeException
     *
     * 3. Error Type & Object
     * ClassCastException
     * ArrayStoreException
     * TypeNotPresentException
     *
     * 4. Error State / Logic
     * IllegalArgumentException
     * IllegalStateException
     * UnsupportedOperationException
     *
     * 5. Error Threading
     * IllegalMonitorStateException
     * IllegalThreadStateException
     *
     * ---------------------------------------
     * 
     * Kesimpulan Penting (WAJIB INGAT)
     *
     * Ini inti kerasnya:
     * Semua ini = RuntimeException
     * Tidak wajib ditangani
     * Biasanya karena bug di kode
     *
     * Ringkasan Super Singkat
     * RuntimeException = kesalahan programmer
     * → harus diperbaiki, bukan ditutup
     */

    /**
     * Checked Exceptions (java.lang)
     *
     * Exception berikut:
     * Harus ditangani (try-catch) atau
     * Dideklarasikan (throws)
     *
     * Kalau tidak:
     * compile error
     *
     * 1. ClassNotFoundException
     * Class tidak ditemukan
     *
     * Biasanya terjadi saat:
     * pakai Class.forName()
     * Class.forName("NamaClass");
     * kalau class gak ada → error
     *
     * 2. CloneNotSupportedException
     * Object tidak bisa di-clone
     * Terjadi kalau:
     * object tidak implement Cloneable
     * obj.clone(); // ERROR kalau gak Cloneable
     *
     * 3. IllegalAccessException
     * Tidak punya izin akses
     * Contoh:
     * akses field/method private via reflection
     *
     * 4. InstantiationException
     * Gagal membuat object
     * Terjadi kalau:
     * mencoba buat object dari:
     * abstract class
     * interface
     * Class c = AbstractClass.class;
     * c.newInstance(); // ERROR
     *
     * 5. InterruptedException
     * Thread diinterupsi
     * Contoh:
     * Thread.sleep(1000);
     * kalau thread di-interrupt → error
     *
     * 6. NoSuchFieldException
     * Field tidak ditemukan
     * Biasanya di reflection:
     * obj.getClass().getField("nama");
     * kalau gak ada → error
     *
     * 7. NoSuchMethodException
     * Method tidak ditemukan
     * obj.getClass().getMethod("method");
     * kalau gak ada → error
     *
     * 8. ReflectiveOperationException
     * Induk dari semua error reflection
     * Digunakan untuk:
     * operasi reflection (Class, Method, Field)
     * 
     * -----------------------------------------
     *
     * Intinya Checked Exception
     * Error yang:
     * bukan murni kesalahan coding
     * tapi karena kondisi eksternal / sistem
     *
     * Contoh perbandingan
     * RuntimeException:
     * int a = 10 / 0;
     *
     * salah lu 
     *
     * Checked Exception:
     * Thread.sleep(1000);
     *
     * bisa gagal karena sistems
     */

public class JavaBuiltInException {
    public static void main(String[] args) {

        // CONTOH UNCHECKED EXCEPTION
        // Runtime Exception
        int a = 100;
        int b = 0 / a;
        int c = 10 / (a -a);

        // CONTOH KODE - INTERRUPTED EXCEPTION
        // CHECKED EXCEPTION
        // Compile Exception
        try {
            Thread.sleep(1000); // wajib try catch
        } catch (InterruptedException e) {
            System.out.println("Thread terganggu.");
        }

        /**
         * Kesimpulan Penting (WAJIB INGAT)
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
         * Ringkasan Super Singkat
         * Checked Exception = harus ditangani (try-catch / throws)
         * RuntimeException = tidak wajib (bug programmer)
         */
            
    }
}