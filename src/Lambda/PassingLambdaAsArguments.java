package Lambda;

/**
 * Intinya:
 *
 * Lambda bisa dipakai di mana aja selama ada:
 * target type (functional interface)
 *
 * Salah satu tempat paling penting:
 * sebagai argument method
 *
 * Artinya:
 *
 * Lo bisa:
 * method(lambda)
 *
 * alias:
 * kirim kode sebagai parameter
 *
 * Syaratnya:
 * Parameter method harus:
 * functional interface yang cocok dengan lambda
 *
 * --------------------------------
 * 
 * Penjelasan 
 * 1. Method ini kunci utama
 * static String stringOp(StringFunc sf, String s)
 *
 * Parameter pertama:
 * StringFunc sf → ini functional interface
 *
 * Artinya:
 * bisa terima lambda
 *
 * 2. Cara kerja di dalam method
 * return sf.func(s);
 *
 * Yang terjadi:
 * lambda dipanggil lewat func()
 * s jadi inputnya
 *
 * 3. Kirim lambda langsung
 * stringOp((str) -> str.toUpperCase(), inStr);
 *
 * Yang terjadi:
 * Java bikin object dari lambda
 * dikirim ke sf
 * dipanggil di dalam method
 *
 * Ini konsep penting:
 * "Function bisa dikirim sebagai parameter"
 *
 * 4. Block lambda sebagai argument
 * (str) -> { ... }
 *
 * Sama seperti sebelumnya
 * cuma lebih panjang
 *
 * Kekurangan:
 * kalau terlalu panjang → jadi susah dibaca
 *
 * 5. Solusi: simpan dulu ke variable
 * StringFunc reverse = (str) -> { ... };
 *
 * lalu kirim:
 * stringOp(reverse, inStr);
 *
 * Ini best practice:
 * lambda pendek → inline
 * lambda panjang → simpan dulu
 *
 * --------------------------------------------------
 * 
 * Insight Mentor (Ini yang bikin lo beda)
 * 
 * 1. Ini konsep besar:
 * “Passing behavior ke method”
 *
 * 2. Ini dasar dari:
 * Stream API (filter, map)
 * callback
 * event handling
 *
 * 3. Ini mirip konsep di bahasa lain:
 * JavaScript → function sebagai parameter
 * Python → first-class function
 *
 * 4. Ini bikin code fleksibel banget
 *
 * Satu method:
 * stringOp(...)
 *
 * bisa:
 * uppercase
 * remove space
 * reverse
 * dll
 *
 * 5. Ini seperti strategy pattern versi simpel
 *
 * ----------------------------------------
 * 
 * Kesimpulan Super Sederhana
 * 
 * 1. Lambda bisa dikirim ke method
 *    method(lambda)
 *
 * 2. Parameter harus functional interface
 *
 * 3. Lambda bisa:
 *    langsung (inline)
 *    lewat variable
 *
 * 4. Lambda pendek → inline
 *    Lambda panjang → simpan dulu
 */

// Functional interface
interface Kata {
    // method menerima string dan return string
    String func(String n);
}

public class PassingLambdaAsArguments {
    // method yang menerima lambda sebagai parameter
    static String stringOp(Kata kata, String s) {
        // memanggil method dari interface
        // lambda akan di eksekusi disini
        return kata.func(s);
    }

    public static void main(String[] args) {

        String inStr = "Lambdas add power to Java";
        String outStr;

        System.out.println("here is input string: " + inStr);

        //  1. Lambda langsung (expression lambda)

        // mengubah string menjadi uppercase
        outStr = stringOp((str) -> str.toUpperCase(), inStr); // parameter kedua di methode stringOp(Kata kata, String s)
        System.out.println("The string in uppercase: " + outStr);

        // 2. Block Lambda (hapus spasi)
        outStr = stringOp((str) -> {
            String result = "";
            int i;

            // kalau bukan spasi tambahkan ke result
            for (i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ')
                    result += str.charAt(i);
            }
            return result;
        }, inStr); // parameter kedua di methode stringOp(Kata kata, String s)

        System.out.println("The string with spaces removed: " + outStr);

        // 3. Lambda disimpan dulu ke variable

        Kata reverse = (str) -> {
            String result = "";
            int i;

            for (i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        }; 

        System.out.println("The string reversed: " + stringOp(reverse, inStr));
    }
}
