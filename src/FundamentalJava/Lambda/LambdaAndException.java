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

        double[] values = {1.0, 2.0, 3.0, 4.0};

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

        /**
         * Penjelasan Mendalam 
         * 
         * 1. Interface menentukan aturan exception
         * double func(double[] n) throws EmptyArrayException;
         *
         * Ini penting banget:
         * method boleh throw exception
         * lambda HARUS ikut aturan ini
         *
         * 2. Lambda melempar exception
         * if (n.length == 0)
         *     throw new EmptyArrayException();
         *
         * Ini checked exception
         *
         * Kenapa harus ada throws di interface?
         * Karena:
         * Lambda dianggap implementasi method
         *
         * Analogi:
         * // Versi manual tanpa lambda
         * double func(double[] n) throws EmptyArrayException {
         *     if(n.length == 0)
         *         throw new EmptyArrayException();
         * }
         *
         * Jadi aturan sama
         *
         * Kalau gak ditulis throws?
         * double func(double[] n); // TANPA throws
         *
         * tapi lambda throw exception
         * hasil:
         * COMPILE ERROR
         *
         * Tentang Parameter Array (Ini tricky dikit)
         *
         * Di interface:
         * double func(double[] n);
         * Di lambda:
         * (n) -> { ... }
         *
         * bukan:
         * (n[]) -> ... 
         *
         * Kenapa?
         * Karena:
         * Java otomatis tau n adalah double[]
         *
         * ini lagi-lagi:
         * TYPE INFERENCE
         *
         * Kalau mau eksplisit:
         * (double[] n) -> { ... }
         *
         * ini valid, tapi jarang dipakai
         *
         * ----------------------------------------
         * 
         * Insight Mentor (Ini penting banget)
         * 
         * 1. Lambda tunduk ke aturan interface
         * termasuk:
         * return type
         * parameter
         * exception
         *
         * 2. Checked exception = strict
         * HARUS:
         * ditulis di throws
         * atau di-handle
         *
         * 3. Ini beda dengan unchecked exception
         * Contoh:
         * throw new RuntimeException();
         *
         * ini bebas (gak wajib throws)
         *
         * 4. Ini penting di dunia nyata
         * Dipakai di:
         * file processing
         * database
         * API call
         * parsing data
         *
         * 5. Ini sering bikin error di beginner
         * Karena:
         * lupa declare throws di interface
         *
         * ============================================
         * 
         * Kesimpulan Super Sederhana
         *
         * 1. Lambda boleh throw exception
         * 2. Checked exception harus ada di interface
         *    throws EmptyArrayException
         * 3. Kalau gak → compile error
         * 4. Lambda ikut aturan method interface
         * 5. Tipe array tetap inferred
         *    (n) -> ...
         */
    }
}
