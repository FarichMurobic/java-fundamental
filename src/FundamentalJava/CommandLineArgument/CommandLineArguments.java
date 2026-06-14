package FundamentalJava.CommandLineArgument;

    /**
     * Kadang kita ingin mengirim data ke program saat program dijalankan.
     * Ini dilakukan dengan command-line arguments.
     *
     * Command-line argument adalah:
     * data yang ditulis setelah nama program di terminal saat dijalankan
     *
     * Contoh di terminal:
     * java NamaProgram halo dunia 123
     * 
     * itu berarti:
     * "halo"
     * "dunia"
     * "123"
     * adalah input ke program
     *
     * Semua command-line arguments disimpan dalam bentuk array String yang dikirim ke parameter args di main().
     *
     * Ini penting banget:
     * public static void main(String args[])
     * args = array of String
     * semua input masuk ke sini
     * 
     * Posisi index:
     * Input	Index
     * pertama	args[0]
     * kedua	args[1]
     * ketiga	args[2]
     * 
     * -------------------------------------------------------------
     * 
     * CARA MENJALANKAN 
     * Masuk ke terminal ke bin
     * 
     * java CommandLineArgument.CommandLineArguments hello dunia 123
     * 
     * OUTPUT
     * args[0]: hello
     * args[1]: dunia
     * args[2]: 123
     */

public class CommandLineArguments {
    public static void main(String[] args) {
        
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "]: " + args[i]);
        }
    }
}
