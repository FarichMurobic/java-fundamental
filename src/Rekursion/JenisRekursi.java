package Rekursion;

public class JenisRekursi {
    public static void main(String[] args) {

        // membuat objek kelas factorial
        // rekursi linear
        Factorial f = new Factorial();

        // memanggil methode factorial
        System.out.println("factorial 3 = " + f.fact(3));
        System.out.println("factorial 4 = " + f.fact(4));
        System.out.println("factorial 5 = " + f.fact(5));

        System.out.println();

        // membuat objek kelas countdown
        // rekursi tail - rekursi call berada diakhir method
        Countdown c = new Countdown();
        c.hitungMundur(5);

        System.out.println();

        // membuat objek di kelas fibonacci
        Fibonacci fibonaci = new Fibonacci();
        
        // menampilkan beberapa nilai fibonacci
        for (int i = 0; i <= 10; i++) {
            System.out.println("fib(" + i + ") = " + fibonaci.fib(i));
        }

        System.out.println();

        // membuat objek di kelas array
        ArrayPrinter ap = new ArrayPrinter(10);
        ap.printarray(10);
    }
}

// Linear Recursion (Factorial)
class Factorial {

    // methode untuk menghitung factorial
    int fact(int n) {
        // base case
        // jika n = 1 maka berhenti
        if (n == 1)
            return 1;

        // rekursip case
        // memanggil methode sendiri dengan nilai lebih kecil
        return n * fact(n - 1);
    }

    /**
     * Output:
     * Factorial 3 = 6
     * Factorial 4 = 24
     * Factorial 5 = 120
     *
     * Alur Program Saat Dijalankan
     * Jika dipanggil:
     * fact(4)
     *
     * Urutan call:
     * fact(4)
     * fact(3)
     * fact(2)
     * fact(1)
     *
     * Lalu hasil kembali:
     * fact(1) = 1
     * fact(2) = 2
     * fact(3) = 6
     * fact(4) = 24
     */
}

// Tail Recursion (Countdown)
// Tail recursion adalah recursion dimana recursive call ada di akhir method.
class Countdown {

    // methode rekursi
    void hitungMundur(int n) {
        // base case
        if (n == 0)
            return;
        // menampilkan angka
        System.out.println("nilai: " + n);
        // rekursiv call
        hitungMundur(n - 1);
    }

    /**
     * Output
     * nilai: 5
     * nilai: 4
     * nilai: 3
     * nilai: 2
     * nilai: 1
     *
     * Cara Kerja
     * Call sequence:
     * hitungMundur(5)
     * hitungMundur(4)
     * hitungMundur(3)
     * hitungMundur(2)
     * hitungMundur(1)
     * hitungMundur(0)
     *
     * Saat n = 0 recursion berhenti.
     */
}

// Tree Recursion (Fibonacci)
// Ini contoh recursion yang bercabang.
class Fibonacci {

    int fib(int n) {
        // base case
        if (n <= 1)
            return n;

        // rekursiv call bercabang
        return fib(n - 1) + fib(n - 2);

        /**
         * Output
         * fib(0) = 0
         * fib(1) = 1
         * fib(2) = 1
         * fib(3) = 2
         * fib(4) = 3
         * fib(5) = 5
         * fib(6) = 8
         * fib(7) = 13
         * fib(8) = 21
         * fib(9) = 34
         * fib(10) = 55
         *
         * Diagram Recursion Fibonacci
         *
         * Contoh:
         * fib(5)
         * Diagram:
         *
         *           fib(5)
         *         /       \
         *      fib(4)     fib(3)
         *      /   \       /   \
         *  fib(3) fib(2) fib(2) fib(1)
         *
         * Makanya ini disebut tree recursion.
         */

    }
}

// Contoh Recursion yang Lebih Realistis (Print Array)
class ArrayPrinter {

    int data[];

    ArrayPrinter(int size) {
        data = new int[size];

        // isi array
        for (int i = 0; i < size; i++) {
            data[i] = i;
        }
    }

    // methode rekursiv untuk print array
    void printarray(int i ) {
        // base case
        if (i == 0)
            return;

        // rekursiv call
        printarray(i - 1);

        // print setelah kembali
        System.out.println("Index " + (i - 1) + " = " + data[i - 1]);
    }

    /**
     * Output
     * Index 0 = 0
     * Index 1 = 1
     * Index 2 = 2
     * Index 3 = 3
     * Index 4 = 4
     * Index 5 = 5
     * Index 6 = 6
     * Index 7 = 7
     * Index 8 = 8
     * Index 9 = 9
     */
}