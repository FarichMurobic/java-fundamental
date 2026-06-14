package FundamentalJava.ExceptionHandling;

    /**
     * Nested try Statements
     *
     * try bisa ditaruh di dalam try lain (nested).
     * Setiap masuk ke try, Java menyimpan konteks exception ke dalam stack.
     * Kalau try di dalam (inner try):
     * tidak punya catch yang cocok
     * maka exception akan naik ke luar (outer try)
     *
     * Proses ini terus terjadi sampai:
     * ketemu catch yang cocok, atau
     * semua try habis → ditangani default handler
     *
     * Exception itu bisa “naik level”
     * inner try → gak bisa handle → lempar ke outer try → outer handle
     */

public class NestedTryStatements {

    // Nested via Method (Lebih Dalam Lagi)
    static void nesttry(int a) {
        try {
            if (a == 1) {
                a = a / (a -a); // ERROR
            }

            if (a == 2) {
                int[] c = {1};
                c[42] = 99; // ERROR
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array error: " + e);
        }
    }
    
    public static void main(String[] args) {
        
        // OUTER try
        try {
            int a = args.length; // 0
            int b = 42 / a; // bisa error outer try
            System.out.println(a);

            // Inner try
            try {
                if (a == 1) {
                    // ERROR pembagian 0
                    a = a / (a - a);
                }

                if (a == 2) {
                    int[] c = {1};
                    // Error index out of boundss
                    c[42] = 99;
                }
            } catch (ArrayIndexOutOfBoundsException e) { // Catch inner
                // Hanya handle error array
                System.out.println("Array error: " + e);
            }
        } catch (ArithmeticException e) { // catch outer
            // Handle pembagian 0 dari luar (outer try)
            System.out.println("Divide by 0: " + e);
        }

        /**
         * Skenario Jalan Program
         * 
         * 1. Tanpa argumen
         * a = 0 → 42/0 → ERROR
         *
         * ditangkap outer catch
         *
         * 2. 1 argumen
         * a = 1 → masuk inner try
         * a / (a-a) = 1 / 0 → ERROR
         *
         * inner tidak handle
         * naik ke outer
         * outer handle
         *
         * 3. 2 argumen
         * a = 2 → masuk inner try
         * c[42] → ERROR
         *
         * inner handle langsung
         * outer gak ikut
         *
         * Pola Penting (WAJIB INGAT)
         *
         * Ini inti nested try:
         *
         * Inner try → gak bisa handle → naik ke outer try
         * Alur lengkap
         * try dalam → catch cocok? → ya → selesai
         *                          → tidak → lempar ke luar
         * outer try → catch cocok? → ya → selesai
         *                          → tidak → lanjut keluar
         */

        // Nested via Method (Lebih Dalam Lagi)
        try {
            int a = args.length;
            int b = 42 / a; // Error bisa disini
            System.out.println(a);
            // Panggil method
            nesttry(a);
        } catch (ArithmeticException e) {
            System.out.println("Divide by 0: " + e);
        }

        /**
         * Walaupun beda method, tetap dianggap nested
         * main() → manggil method → di dalam method ada try
         * tetap satu “alur stack”
         *
         * Kesimpulan Penting (WAJIB INGAT)
         *
         * Ini inti kerasnya:
         * try bisa di dalam try
         * Exception akan naik kalau tidak ditangani
         * Java cek dari dalam ke luar
         *
         * Pola utama:
         * Inner → Outer → Default Handler
         *
         * Kapan pakai nested try?
         * Saat:
         * bagian dalam punya error spesifik
         * bagian luar handle error umum
         *
         * Cara pro
         * inner try → error spesifik
         * outer try → error umum
         */

    }
}
