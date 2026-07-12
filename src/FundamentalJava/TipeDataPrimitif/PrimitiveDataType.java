package FundamentalJava.TipeDataPrimitif;

public class PrimitiveDataType {

    /**
     * Java adalah bahasa yang strongly typed.
     * 
     * Ini berarti setiap variabel dan ekspresi harus memiliki tipe data yang jelas,
     * dan semua penugasan (assignment) harus kompatibel. Kompilator Java akan memeriksa semua ini,
     * dan jika ada ketidaksesuaian tipe, program tidak akan berhasil dikompilasi.
     * Ini adalah salah satu alasan kenapa Java dikenal aman dan kuat.
     */

    /**
     * Tipe Data Primitif (Primitive Types)
     * 
     * Java memiliki delapan tipe data primitif, yang dibagi menjadi empat kelompok:
     * 1.	Integer (Bilangan Bulat): byte, short, int, long.
     * 2.	Floating-Point (Angka Desimal): float, double.
     * 3.	Characters (Karakter): char.
     * 4.	Boolean (Logika): boolean.
     *
     * Tipe primitif ini bukan objek, melainkan nilai tunggal. Ini dilakukan untuk efisiensi performa.
     */

    public static void main(String[] args) {

        // Primitive Types, Tipe data merepresentasikan sesuai proporsinya masing-masing!
        byte thisByte = 10;
        System.out.println(thisByte);
        short thisShort = 100;
        System.out.println(thisShort);
        int thisInteger = 1000;
        System.out.println(thisInteger);
        long thisLong = 10000l;
        System.out.println(thisLong);

        float thisFloat = 1000f;
        System.out.println(thisFloat);
        double thisDouble = 1000;
        System.out.println(thisDouble);

        char thisCharacter = 'F';
        System.out.println(thisCharacter);
        boolean thisBoolean = true;
        System.out.println(thisBoolean);

    }
}
