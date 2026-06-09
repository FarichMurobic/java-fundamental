package ExceptionHandling;

    /**
     * Creating Your Own Exception Subclasses
     *
     * Walaupun Java sudah punya banyak exception bawaan, 
     * kadang lu butuh bikin exception sendiri untuk kasus spesifik di aplikasi lu.
     * 
     * Ini gampang:
     * cukup bikin class yang extends Exception (yang sebenarnya turunan dari Throwable).
     * Subclass exception ini gak wajib punya isi khusus—cukup keberadaannya aja udah bisa dipakai sebagai exception.
     *
     * Tentang Class Exception
     * Class Exception sendiri gak punya method tambahan.
     * Dia mewarisi method dari Throwable
     *
     * Jadi:
     * semua exception (termasuk buatan lu)
     * punya method seperti:
     * getMessage()
     * printStackTrace()
     * toString()
     * dll
     *
     * --------------------------------------
     * 
     * Constructor Exception
     * Ada 2 constructor utama:
     * Exception()
     * Exception(String msg)
     * 
     * tanpa parameter → tanpa deskripsi
     * dengan String → bisa kasih pesan error
     *
     * Override toString()
     * Biasanya output exception:
     * NamaException: pesan
     *
     * Kalau lu override toString():
     * lu bisa kontrol output sendiri
     * bikin lebih clean
     * 
     * -------------------------------------------------------
     *
     * INTI BESARNYA:
     * Exception itu bukan cuma error
     * tapi cara komunikasi error
     *
     * Kenapa bikin exception sendiri?
     *
     * Bayangin:
     * if (saldo < 0) throw new Exception("Error");
     *
     * jelek
     * gak jelas konteks
     *
     * Lebih bagus:
     * throw new SaldoTidakCukupException();
     *
     * langsung jelas:
     * ini error apa
     * terjadi di domain apa
     *
     * Analogi
     * Exception = alarm
     * Exception bawaan = alarm umum (kebakaran, gempa)
     * Custom Exception = alarm khusus (server down, saldo minus)
     *
     * ---------------------------------------------------------
     * 
     * Hal Penting
     * Custom Exception:
     * hanya perlu extends Exception
     * gak wajib override apa-apa
     * tapi lebih powerful kalau lu customize
     *
     * POIN PENTING
     * Exception bisa dibuat sendiri
     * cukup extends Exception
     * bisa simpan data tambahan (kayak detail)
     * bisa override toString() untuk output custom
     * tetap mewarisi method dari Throwable
     *
     * Custom Exception = bahasa error lu sendiri
     *
     * Lu gak lagi pakai bahasa Java
     * Lu bikin bahasa error sesuai domain aplikasi lu
     *
     * Contoh:
     * LoginFailedException
     * InvalidEmailException
     * SaldoTidakCukupException
     *
     * Ini yang bikin code lu “professional level”
     * 
     * ----------------------------------------------------
     *
     * KESIMPULAN
     * Java kasih exception umum
     * tapi aplikasi real butuh exception spesifik
     * custom exception bikin code:
     * lebih jelas
     * lebih readable
     * lebih scalable
     *
     * Inti utama = bikin class baru turunan Exception
     * class MyException extends Exception
     * Itu aja udah cukup bikin:
     * “jenis error baru”
     *
     * Custom Exception itu:
     * cara bikin error jadi bagian dari desain program lu
     *
     * Bukan sekadar:
     * nampilin pesan error
     *
     * Tapi:
     * mendefinisikan jenis kegagalan dalam sistem
     *
     * Tanpa custom exception:
     * semua error = "error umum"
     *
     * Dengan custom exception:
     * error punya identitas
     *
     * Kayak:
     * DatabaseConnectionException
     * InvalidPasswordException
     * PaymentFailedException
     *
     * ini bikin code lu:
     *
     * lebih readable
     * lebih maintainable
     * lebih profesional
     *
     * Logika jadi terpisah rapi
     *
     * Lu bisa:
     * handle error login beda
     * handle error database beda
     * handle error saldo beda
     *
     * bukan satu “catch semua”
     *
     * catch (Exception e)
     * ini bahaya bro
     *
     * Karena:
     * semua error masuk sini
     * debugging jadi neraka
     *
     * Exception jadi bagian dari sistem
     * Ini yang paling dalam:
     * Lu gak cuma “lempar error”
     * Lu lagi mendefinisikan aturan dunia program lu
     * 
     * --------------------------------------------------
     *
     * INTI PALING DALAM (NAIK LEVEL BANGET)
     *
     * extends Exception itu artinya:
     * “Gua bikin kategori kegagalan baru di sistem gua”
     *
     * Bukan sekadar:
     * biar readable
     *
     * Tapi:
     * biar program lu ngerti jenis kegagalannya
     *
     * KESIMPULAN
     * Exception = general (superclass)
     * Custom exception = spesifik
     * Tangkap spesifik = clean design
     * Tangkap umum = hanya sebagai 
     * 
     * ---------------------------------------------------------
     *
     * KESIMPULAN
     * extends Exception
     * error yang harus dipikirin & ditangani
     *
     * extends RuntimeException
     * error yang biasanya bug & tidak wajib ditangani
     *
     * Kenapa harus extends dari class (khususnya Exception)?
     * JAWABAN INTI (langsung nancep)
     *
     * Karena Java pakai inheritance buat:
     * “ngasih identitas + behavior ke object”
     *
     * Java butuh “TANDA” bahwa itu Exception
     * Kalau lu bikin:
     * class MyError {
     * }
     *
     * Ini BUKAN exception
     * gak bisa:
     * throw new MyError(); // ERROR
     *
     * Harus:
     * class MyException extends Exception {
     * }
     * 
     * Sekarang:
     * bisa di-throw
     * bisa di-catch
     *
     * KENAPA?
     * Karena Java cuma nganggap:
     * object yang turunan dari Throwable = exception
     *
     * Struktur Java:
     *
     * Throwable
     *  ├── Exception
     *  │    └── MyException
     *  └── Error
     *
     * Jadi:
     * extends = masuk ke “keluarga error”
     *
     * DAPET “KEKUATAN” DARI PARENT
     * Dengan extends Exception, lu otomatis dapet:
     * getMessage()
     * printStackTrace()
     * toString()
     *
     * Tanpa nulis ulang
     *
     * Tanpa extends:
     * Lu harus bikin semua sendiri (ribet + gak standar)
     *
     * POLYMORPHISM (INI LEVEL LANJUT)
     * Karena inheritance:
     * catch (Exception e)
     *
     * bisa nangkep:
     * MyException
     * IOException
     * dll
     *
     * Ini karena:
     * semua itu “IS-A Exception”
     *
     * DESIGN SYSTEM JAVA
     *
     * Java itu strict banget:
     * semua error HARUS:
     *
     * punya struktur
     * punya behavior standar
     *
     * Makanya:
     * gak boleh bikin exception sembarangan
     * harus ikut sistem Throwable
     *
     * INTI PALING DALAM
     * extends itu bukan cuma “warisan”
     *
     * Tapi:
     * cara Java mengenali dan mengatur object dalam sistemnya
     *
     * KHUSUS DI EXCEPTION
     * Kenapa extends Exception?
     *
     * supaya:
     * bisa di-throw
     * bisa di-catch
     * punya behavior standar
     * masuk ke ekosistem error Java
     */

    /**
     * TABEL METHOD DI Throwable (CORE EXCEPTION JAVA)
     * Method	                                Deskripsi                                                   Penjelasan 
     * addSuppressed(Throwable exc)	            Menambahkan exception ke daftar suppressed exception	    Dipakai buat nyimpen error tambahan (biasanya dari try-with-resources)
     * fillInStackTrace()	                    Mengembalikan object Throwable dengan stack trace lengkap	“Ngerekam ulang” jejak error (jarang dipakai langsung)
     * getCause()	                            Mengembalikan penyebab utama exception	                    Buat tau akar masalah dari error
     * getLocalizedMessage()	                Mengembalikan pesan error sesuai locale	                    Versi “multibahasa” dari error message
     * getMessage()	                            Mengembalikan deskripsi error	                            Ini yang paling sering dipakai (isi pesan error)
     * getStackTrace()	                        Mengembalikan array stack trace	                            Ngasih detail urutan method sebelum error terjadi
     * getSuppressed()	                        Mengembalikan daftar suppressed exception	                Ambil error tambahan yang “disembunyikan”
     * initCause(Throwable causeExc)	        Mengaitkan penyebab ke exception	                        Set manual “penyebab error”
     * printStackTrace()	                    Menampilkan stack trace	                                    Print detail error ke console
     * printStackTrace(PrintStream stream)	    Kirim stack trace ke stream tertentu	                    Print error ke tempat lain (misal file/log)
     * printStackTrace(PrintWriter stream)	    Kirim stack trace ke writer	                                Sama, tapi pakai writer
     * setStackTrace(StackTraceElement[])	    Mengatur stack trace secara manual	                        Custom stack trace (jarang banget dipakai)
     * toString()	                            Mengembalikan deskripsi exception	                        Default output saat System.out.println(e)
     *
     * INTI PALING DALAM
     * Semua exception di Java itu:
     * punya sistem pelacakan error yang lengkap
     *
     * Bukan cuma:
     * “error terjadi”
     *
     * Tapi juga:
     * dimana
     * kenapa
     * dari mana asalnya
     *
     * Kalau ada exception, lu bisa tanya:
     * apa pesannya → getMessage()
     * dari mana asalnya → getStackTrace()
     * penyebabnya apa → getCause()
     * tampilkan semua → printStackTrace()
     *
     * KESIMPULAN
     * Throwable = root dari semua error
     * semua method ini diwarisin ke semua exception
     * sebagian besar jarang dipakai
     * tapi beberapa itu WAJIB ngerti (getMessage, printStackTrace, toString)
     *
     * Kenapa Java punya banyak method ini?
     * Karena:
     * error handling di Java itu bukan cuma nangkep error, tapi ANALISA error
     */

// Custome Exception
// extends Exception
// ini yang bikin class jadi exception
class MyException extends Throwable {

    private int detail; // Menyimpan data tambahan

    // Constructor
    MyException(int a) {
        detail = a;
    }

    // Override toString untuk costum output
    @Override
        public String toString() {
            return "MyException[" + detail + "]";
        }

        /**
         * PENJELASAN
         * 
         * Kenapa toString() di override?
         * Default:
         * MyException: null
         *
         * Custom:
         * MyException[20]
         * lebih clean & controlled
         */
}

public class BikinExceptionSendiri {

    // Method yang bisa melempar exception
    static void compute(int a) throws MyException { // Method bilang: “gua bisa error, siap-siap ya”

        System.out.println("Called Compute(" + a + ")");
        // KONDISI ERROR
        if (a > 10) 
            // MyException Error yang kita but
            throw new MyException(a); // Lempar error
        
            System.out.println("Normal Exit...");
    }

    public static void main(String[] args) {
        
        // HANDLE THROWS
        try {
            compute(1); // aman
            System.out.println("Ini tetep diproses."); // tetep jalan
            System.out.println();
            compute(20); // error! dijalankan, karena a > 10
        } catch (MyException e) { // TANGKAP ERROR YANG KITA BUAT
            System.out.println("Caught: " + e);
        }
    }
}
