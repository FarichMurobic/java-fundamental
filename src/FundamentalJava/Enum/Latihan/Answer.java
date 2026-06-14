package FundamentalJava.Enum.Latihan;

// impiort untuk angka random
import java.util.Random;

// ENUM BERISI SEMUA KEMUNGKINAN JAWABAN
public enum Answer {
    NO, YES, MAYBE, LATER, SOON, NEVER
}

// Class untuk menghasilkan jawaban
class Question {

    // Buat objek random
    Random acak = new Random();

    // Method untuk menentukan jawaban
    Answer ask() {
        // Ambil angka random dari 0-100
        int probabilitas = (int) (100 * acak.nextDouble());

        if (probabilitas < 15)
            return Answer.MAYBE;        // 15%
        else if (probabilitas < 30) 
            return Answer.NO;           // 15%
        else if (probabilitas < 60)
            return Answer.YES;          // 30%
        else if (probabilitas < 70)
            return Answer.LATER;        // 15%
        else if (probabilitas < 95)
            return Answer.SOON;         // 23%
        else 
            return Answer.NEVER;        // 2%

    }
}
