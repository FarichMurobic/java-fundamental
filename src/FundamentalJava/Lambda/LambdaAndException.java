package FundamentalJava.Lambda;

// Functional interface
interface DoubleNumericArrayFunc {

    // Method bisa throw exception
    // METHOD SAM (SINGLE MEMBER METHOD)
    double func(double[] n) throws EmptyArrayException;
}

// Custom exception
class EmptyArrayException extends Exception {

    // Constructor exception
    EmptyArrayException() {
        super("Array Empty"); // pesan error
    }
}

public class LambdaAndException {
    public static void main(String[] args) throws EmptyArrayException {

        double[] values = { 1.0, 2.0, 3.0, 4.0 };

        // BLOCK LAMBDA: hitung rata-rata
        DoubleNumericArrayFunc average = (n) -> {
            double sum = 0;

            // Kalau array kosong → lempar exception
            if (n.length == 0)
                throw new EmptyArrayException();

            // Hitung total
            for (int i = 0; i < n.length; i++)
                sum += n[i];

            // Return rata-rata
            return sum / n.length;
        };

        // Normal case
        System.out.println("The average is: " + average.func(values));
        // Error case (array kosong)
        System.out.println("The average is " + average.func(new double[0]));

        /*
         * ==========================================================
         * LAMBDA EXPRESSION DAN EXCEPTION HANDLING
         * ==========================================================
         *
         * Lambda Expression tidak bebas menentukan aturan sendiri.
         *
         * Lambda harus selalu mengikuti kontrak yang dibuat oleh
         * Functional Interface.
         *
         * Kontrak tersebut mencakup:
         *
         * - Nama method.
         * - Jumlah parameter.
         * - Tipe parameter.
         * - Return type.
         * - Aturan exception.
         *
         * Jadi, jika abstract method pada functional interface memiliki
         * aturan exception tertentu, maka lambda yang mengisinya harus
         * mengikuti aturan tersebut.
         *
         * ==========================================================
         * 1. INTERFACE MENENTUKAN ATURAN EXCEPTION
         * ==========================================================
         *
         * Contoh functional interface:
         *
         * @FunctionalInterface
         * interface ArrayFunc {
         *
         * double func(double[] n)
         * throws EmptyArrayException;
         *
         * }
         *
         * Perhatikan bagian:
         *
         * throws EmptyArrayException
         *
         * Artinya:
         *
         * Method func() diperbolehkan melempar exception
         * EmptyArrayException.
         *
         * Karena lambda menjadi implementasi dari method tersebut,
         * maka lambda juga mendapatkan izin untuk melempar exception
         * yang sama.
         *
         * ==========================================================
         * 2. LAMBDA MELEMPARKAN EXCEPTION
         * ==========================================================
         *
         * Contoh:
         *
         * ArrayFunc average = (n) -> {
         *
         * if (n.length == 0) {
         * throw new EmptyArrayException();
         * }
         *
         * return 0;
         * };
         *
         * Ketika array kosong:
         *
         * - Lambda melempar EmptyArrayException.
         * - Exception tersebut valid karena sudah dideklarasikan pada
         * abstract method interface.
         *
         * ==========================================================
         * KENAPA INTERFACE HARUS PUNYA throws?
         * ==========================================================
         *
         * Karena lambda dianggap sebagai implementasi method interface.
         *
         * Tanpa lambda, konsepnya sama seperti membuat method biasa.
         *
         * Contoh:
         *
         * public double func(double[] n)
         * throws EmptyArrayException {
         *
         * if (n.length == 0) {
         * throw new EmptyArrayException();
         * }
         *
         * return 0;
         * }
         *
         * Method tersebut harus mendeklarasikan throws karena dapat
         * melempar checked exception.
         *
         * Lambda mengikuti aturan yang sama.
         *
         * ==========================================================
         * JIKA INTERFACE TIDAK MENULIS throws
         * ==========================================================
         *
         * Contoh:
         *
         * @FunctionalInterface
         * interface ArrayFunc {
         *
         * double func(double[] n);
         *
         * }
         *
         *
         * Tetapi lambda melakukan:
         *
         * n -> {
         *
         * throw new EmptyArrayException();
         *
         * }
         *
         * Maka hasilnya:
         *
         * COMPILE ERROR
         *
         * Alasannya:
         *
         * Functional interface tidak mengizinkan abstract method untuk
         * melempar checked exception tersebut.
         *
         * Lambda harus mengikuti kontrak interface.
         *
         * ==========================================================
         * CHECKED EXCEPTION PADA LAMBDA
         * ==========================================================
         *
         * EmptyArrayException merupakan contoh checked exception.
         *
         * Checked exception memiliki aturan:
         *
         * - Harus ditulis menggunakan throws.
         * - Atau harus ditangani menggunakan try-catch.
         *
         * Contoh:
         *
         * void process()
         * throws IOException {
         *
         * }
         *
         * Jika tidak dilakukan, compiler akan menolak kode tersebut.
         *
         * ==========================================================
         * PERBEDAAN CHECKED DAN UNCHECKED EXCEPTION
         * ==========================================================
         *
         * Checked Exception:
         *
         * Contoh:
         *
         * IOException
         * SQLException
         *
         * Aturan:
         *
         * - Wajib dideklarasikan.
         * - Wajib ditangani.
         *
         *
         * Unchecked Exception:
         *
         * Contoh:
         *
         * RuntimeException
         * NullPointerException
         *
         * Aturan:
         *
         * - Tidak wajib menggunakan throws.
         * - Compiler tidak memaksa penanganan.
         *
         * Contoh:
         *
         * throw new RuntimeException();
         *
         * Dapat dilakukan langsung tanpa deklarasi throws.
         *
         * ==========================================================
         * PARAMETER ARRAY PADA LAMBDA
         * ==========================================================
         *
         * Contoh interface:
         *
         * double func(double[] n);
         *
         *
         * Implementasi lambda:
         *
         * (n) -> {
         *
         * return n.length;
         *
         * }
         *
         *
         * Banyak programmer baru bingung dan menulis:
         *
         * (n[]) -> ...
         *
         * Ini salah.
         *
         * Kenapa?
         *
         * Karena deklarasi tipe array hanya digunakan ketika
         * mendefinisikan parameter.
         *
         * Lambda tidak perlu menulis tipe tersebut karena Java sudah
         * mengetahui tipe parameter dari functional interface.
         *
         * ==========================================================
         * TYPE INFERENCE
         * ==========================================================
         *
         * Kemampuan Java untuk menentukan tipe parameter lambda secara
         * otomatis disebut:
         *
         * Type Inference
         *
         * Contoh:
         *
         * ArrayFunc func = n -> n.length;
         *
         * Java mengetahui:
         *
         * n adalah:
         *
         * double[]
         *
         * karena method interface sudah mendefinisikan:
         *
         * double func(double[] n);
         *
         *
         * Jika ingin menulis tipe secara eksplisit:
         *
         * (double[] n) -> {
         *
         * return n.length;
         *
         * }
         *
         * Tetap valid, tetapi biasanya tidak diperlukan.
         *
         * ==========================================================
         * INSIGHT PENTING
         * ==========================================================
         *
         * 1. Lambda tunduk pada aturan Functional Interface
         *
         * Lambda harus mengikuti:
         *
         * - Return type.
         * - Parameter.
         * - Exception.
         *
         *
         * 2. Checked exception lebih ketat
         *
         * Harus:
         *
         * - Ditulis pada throws interface.
         *
         * atau:
         *
         * - Ditangani menggunakan try-catch.
         *
         *
         * 3. Unchecked exception berbeda
         *
         * RuntimeException dan turunannya tidak membutuhkan deklarasi
         * throws.
         *
         *
         * 4. Konsep ini banyak digunakan di dunia nyata
         *
         * Contoh:
         *
         * - File processing.
         * - Database operation.
         * - API request.
         * - Parsing data.
         *
         * Banyak error lambda terjadi karena developer lupa bahwa
         * exception juga bagian dari kontrak interface.
         *
         * ==========================================================
         * KESIMPULAN
         * ==========================================================
         *
         * Lambda Expression dapat melempar exception, tetapi harus
         * mengikuti aturan dari Functional Interface.
         *
         * Poin penting:
         *
         * - Lambda mengikuti kontrak interface.
         * - Checked exception harus dideklarasikan menggunakan throws.
         * - Jika interface tidak mengizinkan exception, lambda tidak
         * boleh melemparkannya.
         * - Parameter lambda dapat menggunakan type inference.
         * - Array parameter tetap ditentukan dari interface.
         *
         * Hubungan konsep:
         *
         * Functional Interface
         * |
         * v
         * Menentukan parameter, return, dan exception
         * |
         * v
         * Lambda Expression
         * |
         * v
         * Memberikan implementasi method tersebut
         *
         * ==========================================================
         */
    }
}
