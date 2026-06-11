package String.StringBuffer;

/**
 * StringBuffer Constructors
 *
 * StringBuffer memiliki empat constructor berikut:
 *
 * StringBuffer()
 * StringBuffer(int size)
 * StringBuffer(String str)
 * StringBuffer(CharSequence chars)
 *
 * Constructor default (yang tanpa parameter) menyediakan ruang untuk 16 karakter tanpa perlu melakukan reallocation (pengalokasian ulang memori).
 * Versi kedua menerima argumen integer yang secara eksplisit menentukan ukuran buffer.
 * Versi ketiga menerima argumen String yang menetapkan isi awal dari objek StringBuffer dan menyediakan ruang tambahan 16 karakter tanpa reallocation.
 * StringBuffer menyediakan tambahan ruang 16 karakter ketika panjang buffer tidak ditentukan secara spesifik,
 * karena proses reallocation itu mahal dari segi waktu. Selain itu, reallocation yang sering dapat menyebabkan fragmentasi memori.
 * Dengan menyediakan ruang ekstra beberapa karakter, StringBuffer mengurangi jumlah reallocation yang terjadi.
 * Constructor keempat membuat objek yang berisi urutan karakter dari chars dan menyediakan tambahan ruang 16 karakter.
 *
 * 1. Apa itu Constructor di sini?
 * Constructor = cara buat object + setting awalnya
 *
 * Jadi:
 * Cara lo bikin StringBuffer bakal ngaruh ke performa
 *
 * -------------------------------------------------
 * 
 * 4 Jenis Constructor (dibedah satu-satu)
 * 
 * 1. StringBuffer()
 * StringBuffer sb = new StringBuffer();
 *
 * Artinya:
 * Isi awal: kosong ("")
 * Capacity: 16
 *
 * Ini default
 *
 * 2. StringBuffer(int size)
 * StringBuffer sb = new StringBuffer(50);
 *
 * Artinya:
 * Lo langsung tentuin kapasitas = 50
 * Cocok kalau lo tahu bakal isi panjang
 *
 * Ini penting untuk performa:
 * Biar gak resize berkali-kali
 *
 * 3. StringBuffer(String str)
 * StringBuffer sb = new StringBuffer("Hello");
 *
 * Artinya:
 * Isi awal = "Hello"
 * Capacity = panjang string + 16
 *
 * Jadi:
 * "Hello" = 5
 * capacity = 5 + 16 = 21
 *
 * 4. StringBuffer(CharSequence chars)
 * CharSequence cs = "Hello Bro";
 * StringBuffer sb = new StringBuffer(cs);
 *
 * Sama kayak yang String, tapi lebih fleksibel:
 * Bisa terima String, StringBuilder, dll
 * Capacity = panjang data + 16
 *
 * Konsep Penting: Capacity vs Length
 * Istilah	        Arti
 * length	        jumlah karakter yang dipakai
 * capacity	        jumlah maksimum sebelum resize
 *
 * Contoh:
 * StringBuffer sb = new StringBuffer("Hello");
 * length = 5
 * capacity = 21
 *
 * Kenapa ada tambahan 16?
 * Karena:
 * Resize (reallocation) itu mahal
 *
 * Kalau gak dikasih buffer:
 * tiap append → resize
 * jadi lambat
 *
 * Dengan tambahan:
 * bisa append berkali-kali tanpa resize
 */

/**
 * Insight Penting (biar naik level dikit)
 * 
 * Kalau lo:
 * bikin StringBuffer() → default 16
 * append terus → bisa resize berkali-kali
 *
 * Tapi kalau lo:
 * new StringBuffer(1000);
 *
 * jauh lebih efisien kalau lo tahu data besar
 *
 * Kesimpulan (versi nempel di otak)
 * StringBuffer punya 4 constructor utama
 * Default capacity = 16
 * Kalau ada isi awal → capacity = length + 16
 * Extra 16 itu buat:
 * performa lebih cepat
 * menghindari reallocation berulang
 *
 * Intinya:
 * Kalau lo tau bakal banyak data → set capacity dari awal
 */

public class StringBufferConstructor {
    public static void main(String[] args) {

        // 1. Constructor tanpa parameter
        StringBuffer stringBuffer1 = new StringBuffer();
        System.out.println("stringBuffer1 length: " + stringBuffer1.length()); // 0 (belum ada isi)
        System.out.println("stringBuffer1 capacity: " + stringBuffer1.capacity()); // 16 (default)

        System.out.println("--------------------------------");

        // 2. Constructor dengan ukuran tertentu
        StringBuffer stringBuffer2 = new StringBuffer(50);
        System.out.println("stringBuffer2 length: " + stringBuffer2.length());  // 0
        System.out.println("stringBuffer2 capacity: " + stringBuffer2.capacity()); // 50

        System.out.println("--------------------------------");

        // 3. Constructor dengan String
        StringBuffer stringBuffer3 = new StringBuffer("Hello");
        System.out.println("stringBuffer3 length: " + stringBuffer3.length()); // 5
        System.out.println("stringBuffer3 capacity: " + stringBuffer3.capacity()); // 5 + 16 = 21

        System.out.println("--------------------------------");

        // 4. Constructor dengan CharSequence
        CharSequence charSequence = "Java";
        StringBuffer stringBuffer4 = new StringBuffer(charSequence);
        System.out.println("stringBuffer4 length: " + stringBuffer4.length());  // 4
        System.out.println("stringBuffer4 capacity: " + stringBuffer4.capacity());  // 4 + 16 = 20
 
    } 
}
