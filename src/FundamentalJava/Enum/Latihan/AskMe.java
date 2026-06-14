package FundamentalJava.Enum.Latihan;

public class AskMe {

    // Method untuk menampilkan jawaban
    static void answer(Answer result) {
        switch (result) {
            case NO:
                System.out.println("NO");
                break;
            case YES:
                System.out.println("YES");
                break;
            case MAYBE:
                System.out.println("MAYBE");
                break;
            case LATER:
                System.out.println("LATER");
                break;
            case SOON:
                System.out.println("SOON");
                break;
            case NEVER:
                System.out.println("NEVER");
                break;
        }
    }

    public static void main(String[] args) {
        
        // Buat objek Question
        Question question = new Question();

        // Panggil 4x -> hasil random
        answer(question.ask());
        answer(question.ask());
        answer(question.ask());
        answer(question.ask());

        /**
         * CEMUNGUTTTTTTTTTTT!!!!!!!!!  @Haaaaa
         * 
         * ALUR PROGRAM
         * 
         * Setiap kali q.ask() dipanggil:
         * Generate angka random (0–99)
         * 
         * Masuk ke kondisi:
         * <15 → MAYBE
         * <30 → NO
         * <60 → YES
         * dst
         * 
         * Return enum Answers
         * Lalu:
         * answer(question.ask());
         *
         * Masuk ke method answer():
         *
         * switch berdasarkan enum
         * print hasil
         *
         * CONTOH OUTPUT (random)
         * Yes
         * Maybe
         * Soon
         * No
         * 
         * -------------------------------------
         *
         * KONSEP PENTING 
         *
         * 1. Enum sebagai return type
         * Answers ask()
         * method bisa return enum
         *
         * 2. Enum sebagai parameter
         * answer(Answers result)
         * enum bisa dipakai kayak tipe biasa
         *
         * 3. Enum + switch = perfect combo
         * ini pattern yang sering banget dipakai
         *
         * -------------------------------------------
         * 
         * INSIGHT PENTING (LEVEL UP)
         *
         * Ini contoh nunjukin:
         * enum cocok buat:
         * state (status)
         * pilihan terbatas
         * decision making
         *
         * Bahkan di dunia nyata:
         * Enum sering dipakai buat:
         * status order (PENDING, PAID, CANCELLED)
         * role user (ADMIN, USER)
         * state game
         *
         * INTI YANG HARUS LU INGAT
         * enum bikin kode:
         * lebih aman
         * lebih readable
         * lebih terstruktur
         * 
         * bisa dipakai:
         * return value
         * parameter
         * switch
         */

    }
}
