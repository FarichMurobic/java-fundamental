package FundamentalJava.IncrementDecrement;

        /**
         * Increment and Decrement
         * Operator ++ dan -- adalah operator increment dan decrement di Java.
         * -Operator increment (++) menambah nilai operand sebanyak 1.
         * -Operator decrement (--) mengurangi nilai operand sebanyak 1.
         *
         * Operator ini unik karena bisa digunakan dalam dua bentuk:
         * -Postfix → operator berada setelah variabel (x++)
         * -Prefix → operator berada sebelum variabel (++x)
         *
         * Jika operator ini berdiri sendiri, tidak ada perbedaan antara prefix dan postfix.
         * Namun jika operator ini digunakan dalam ekspresi yang lebih besar, maka ada perbedaan penting.
         *
         * Prefix - Nilai variabel diubah terlebih dahulu, baru digunakan dalam ekspresi.
         * Postfix - Nilai lama digunakan dulu dalam ekspresi, baru setelah itu variabel diubah.
         */

public class IncrementDecrement {
    public static void main(String[] args) {
        
        int prefix = 5;
        int hasilPrefix = ++prefix;
        System.out.println(prefix); // 6 variabel diubah dahulu, baru digunakan di ekspresi hasil
        System.out.println(hasilPrefix); // 6

        int postfix = 5;
        int hasilPosfix = postfix++;
        System.out.println(postfix); // 6
        System.out.println(hasilPosfix); // 5 nilai lama digunakan dahulu, baru variabel diubah

        int x = 10;
        int y = ++x;
        System.out.println(y);
        System.out.println(x);

        x = 10;
        y = x++;
        System.out.println(y);
        System.out.println(x);

        // Demo application

        int i, j, k;
        j = 65;
        k = 10;

        // pre increment : ++j (j dinaikkan dulu baru digunakan)
        ++j;
        i = j * k;
        System.out.println("Pre-increment (++j): i = " + i + ", j = " + j); // // i = 66 * 10 = 660

        // reset nilai
        j = 65;
        k = 10;

        // Post-increment: j++ (j digunakan dulu, baru dinaikkan)
        i = j * k;
        j++;
        System.out.println("Post-increment (j++): i = " + i + ", j = " + j); // i = 65 * 10 = 650

        // reset nilai
        j = 65;
        k = 10;

        // Pre-decrement: --j (j diturunkan dulu, lalu digunakan)
        --j;
        i = j * k;
        System.out.println("Pre-decrement (--j): i = " + i + ", j = " + j); // i = 64 * 10 = 640

        // Reset nilai
        j = 65;
        k = 10;

        // Post-decrement: j-- (j digunakan dulu, baru diturunkan)
        i = j * k;
        j--;
        System.out.println("Post-decrement (j--): i = " + i + ", j = " + j); // i = 65 * 10 = 650

        // Penjelasan output
        // Pre-increment (++j): i = 660, j = 66
        // Post-increment (j++): i = 650, j = 66
        // Pre-decrement (--j): i = 640, j = 64
        // Post-decrement (j--): i = 650, j = 64

        int coba = 5;
        int cobacoba = coba++ + ++coba;
        System.out.println(cobacoba);

    }

}
