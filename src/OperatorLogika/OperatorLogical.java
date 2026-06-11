package OperatorLogika;

        /**
         * Ekspresi dan operator logika
         * ekspresi disebut logika kalau hasil akhirnya cuma dua: benar (true) dan salah (false)
         *
         * Operator logika
         * Operator ! (TIDAK - Logika "Negasi") Operator NOT ( !) digunakan untuk membalik nilai boolean .
         * Java punya lima operator biner dan satu operator unary untuk membentuk ekspresi logika.
         * Operator biner berarti butuh dua input (dua nilai boolean), sedangkan operator unary cuma butuh satu input
         *
         * Operator logika
         *
         * -Operator Not ! - ini adalah operator unary artinya cuma butuh satu input,
         * fungsinya membalikkan nilai,
         * kalau inputnya true hasilnya false.
         * kalau inputnya false hasilnya true.
         *
         * -Operator And && - ini adalah operator biner
         * Operator && (logika AND) akan menghasilkan true hanya jika kedua operandnya bernilai true.
         * fungsinya, untuk menghasilkan nilai true hanya kalau semua inputnya true
         * true and true = true
         * true and false = false
         * false and true = false
         * false and false = false
         *
         * -Operator Or || - ini juga operator biner
         * Operator || (logika OR) akan menghasilkan true jika salah satu operan bernilai true
         * fungsinya untuk menghasilkan false hanya jika semua inputnya bernilai false
         * true or true = true
         * true or false = true
         * false or true = true
         * false or false = false
         *
         * -Operator Xor ^ - ini juga termasuk operator biner
         * operator ini memang jarang dipake, tapi penting untuk diketahui.
         * intinya operator ini akan menghasilkan true kalau salah satu inputnya true, tapi bukan keduanya.
         * true xor true = false
         * true xor false = true
         * false xor true = true
         * false xor false = false
         *
         * PENTING DIINGAT, OPERATOR LOGIKA PUNYA ASOSIATIF PENGERJAAN DENGAN TADA KURUNG.
         *
         * Perbedaan Penting && vs &, | vs ||.
         * && (Short Circuit AND) - Kalau kondisi pertama false, kondisi kedua tidak dicek.
         * & (Non Short Circuit AND) - Operator ini tetap mengecek kedua sisi.
         *
         * Rule Penting di Java
         * Biasanya programmer di java menggunakan
         * && dan ||
         * untuk logika boolean.
         *
         * Sedangkan
         * & dan |
         * biasanya dipakai untuk bitwise operator.
         */

public class OperatorLogical {
    public static void main(String[] args) {
        
        // Demonstrate the boolean logical operators.
        boolean booleanA = true;
        boolean booleanB = false;
        boolean booleanC = booleanA | booleanB;
        boolean booleanD = booleanA & booleanB;
        boolean booleanE = booleanA ^ booleanB;
        boolean booleanF = (!booleanA & booleanB) | (booleanA & !booleanB);
        boolean booleanG = !booleanA;

        System.out.println(" booleanA = " + booleanA);
        System.out.println(" booleanB = " + booleanB);
        System.out.println(" booleanA | booleanB = " + booleanC);
        System.out.println(" booleanA & booleanB = " + booleanD);
        System.out.println(" booleanA ^ booleanB = " + booleanE);
        System.out.println("!booleanA & booleanB | booleanA & !booleanB = " + booleanF);
        System.out.println(" !booleanA = " + booleanG);

        /**
         *  booleanA = true
         *  booleanB = false
         *  booleanA | booleanB = true
         *  booleanA & booleanB = false
         *  booleanA ^ booleanB = true
         * !booleanA & booleanB | booleanA & !booleanB = true
         *  !booleanA = false
         */

        // Short circuit
        boolean a = true;
        boolean b = false;

        System.out.println("a && b = " + (a && b));
        System.out.println("a || b = " + (a || b));
        System.out.println("!a = " + (!a));
        System.out.println("!b = " + (!b));

        boolean trueValueOne = true;
        boolean trueValueTwo = true;
        boolean falseValueOne = false;
        boolean falseValueTwo = false;

        // Membalikan sebuah nilai boolean
        System.out.println("\nLogical Not (!) Operator");
        System.out.println("!false = " + (!falseValueOne));
        System.out.println("!true = " + (!trueValueOne));

        // Operator && (logika AND) akan menghasilkan true hanya jika kedua operandnya bernilai true.
        System.out.println("\nLogical And (&&) Operator");
        System.out.println("false && false = " + (falseValueOne && falseValueTwo));
        System.out.println("true && false = " + (trueValueOne && falseValueTwo));
        System.out.println("false && true = " + (falseValueOne && trueValueTwo));
        System.out.println("true && true = " + (trueValueOne && trueValueTwo));

        // Operator || (logika OR) akan menghasilkan true jika salah satu operan bernilai true
        System.out.println("\nLogical Or (||) Operator");
        System.out.println("false || false = " + (falseValueOne || falseValueTwo));
        System.out.println("true || false = " + (trueValueOne || falseValueTwo));
        System.out.println("false || true = " + (falseValueOne || trueValueTwo));
        System.out.println("true || true = " + (trueValueOne || trueValueTwo));

        // intinya operator ini akan menghasilkan true kalau salah satu inputnya true, tapi bukan keduanya.
        System.out.println("\nLogical Xor (^) Operator");
        System.out.println("false ^ false = " + (falseValueOne ^ falseValueTwo));
        System.out.println("true ^ false = " + (trueValueOne ^ falseValueTwo));
        System.out.println("false ^ true = " + (falseValueOne ^ trueValueTwo));
        System.out.println("true ^ true = " + (trueValueOne ^ trueValueTwo));

    }
}
