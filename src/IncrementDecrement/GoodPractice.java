package IncrementDecrement;

public class GoodPractice {
    public static void main(String[] args) {
        
        System.out.println("--- Demo Operator Increment dan Decrement (Stand-Alone) ---");

        int numberOfItems = 25;
        System.out.println("numberOfItems awal: " + numberOfItems);

        // Menggunakan operator increment (post-increment sebagai stand-alone)
        numberOfItems++; // Sama dengan numberOfItems = numberOfItems + 1;
        System.out.println("numberOfItems setelah ++: " + numberOfItems); // Output: 26

        // Menggunakan operator decrement (pre-decrement sebagai stand-alone)
        --numberOfItems; // Sama dengan numberOfItems = numberOfItems - 1;
        System.out.println("numberOfItems setelah --: " + numberOfItems); // Output: 25 (kembali ke awal)

        int itemsOnStock = 157;
        System.out.println("\nitemsOnStock awal: " + itemsOnStock);

        itemsOnStock--; // Sama dengan itemsOnStock = itemsOnStock - 1;
        System.out.println("itemsOnStock setelah --: " + itemsOnStock); // Output: 156

        ++itemsOnStock; // Sama dengan itemsOnStock = itemsOnStock + 1;
        System.out.println("itemsOnStock setelah ++: " + itemsOnStock); // Output: 157 (kembali ke awal)

        System.out.println("\n--- Demo Perbedaan Pre- dan Post- dalam Penugasan ---");

        int i, j;

        // Contoh 2.28 - Baris 1: i = ++j;
        j = 65;
        i = ++j; // j di-increment DULU (jadi 66), baru nilai j (66) ditugaskan ke i
        System.out.println("Jika j = 65, lalu i = ++j;  -> i = " + i + ", j = " + j); // Output: i=66, j=66

        // Contoh 2.28 - Baris 2: i = j++;
        j = 65; // Reset j
        i = j++; // Nilai j (65) ditugaskan ke i DULU, baru j di-increment (jadi 66)
        System.out.println("Jika j = 65, lalu i = j++;  -> i = " + i + ", j = " + j); // Output: i=65, j=66

        // Contoh 2.28 - Baris 3: i = --j;
        j = 65; // Reset j
        i = --j; // j di-decrement DULU (jadi 64), baru nilai j (64) ditugaskan ke i
        System.out.println("Jika j = 65, lalu i = --j;  -> i = " + i + ", j = " + j); // Output: i=64, j=64

        // Contoh 2.28 - Baris 4: i = j--;
        j = 65; // Reset j
        i = j--; // Nilai j (65) ditugaskan ke i DULU, baru j di-decrement (jadi 64)
        System.out.println("Jika j = 65, lalu i = j--;  -> i = " + i + ", j = " + j); // Output: i=65, j=64

        System.out.println("\n--- Demo Perbedaan Pre- dan Post- dalam Ekspresi ---");

        int k = 10; // Variabel tambahan untuk perkalian

        // Contoh 2.29 - Baris 1: i = (++j) * k;
        j = 65; // Reset j
        i = (++j) * k; // j di-increment DULU (jadi 66), lalu 66 * 10 = 660. 660 ditugaskan ke i
        System.out.println("Jika j = 65, k = 10, lalu i = (++j) * k; -> i = " + i + ", j = " + j); // Output: i=660, j=66

        // Contoh 2.29 - Baris 2: i = (j++) * k;
        j = 65; // Reset j
        i = (j++) * k; // Nilai j (65) digunakan DULU untuk perkalian (65 * 10 = 650), baru j di-increment (jadi 66). 650 ditugaskan ke i
        System.out.println("Jika j = 65, k = 10, lalu i = (j++) * k; -> i = " + i + ", j = " + j); // Output: i=650, j=66

        // Contoh 2.29 - Baris 3: i = (--j) * k;
        j = 65; // Reset j
        i = (--j) * k; // j di-decrement DULU (jadi 64), lalu 64 * 10 = 640. 640 ditugaskan ke i
        System.out.println("Jika j = 65, k = 10, lalu i = (--j) * k; -> i = " + i + ", j = " + j); // Output: i=640, j=64

        // Contoh 2.29 - Baris 4: i = (j--) * k;
        j = 65; // Reset j
        i = (j--) * k; // Nilai j (65) digunakan DULU untuk perkalian (65 * 10 = 650), baru j di-decrement (jadi 64). 650 ditugaskan ke i
        System.out.println("Jika j = 65, k = 10, lalu i = (j--) * k; -> i = " + i + ", j = " + j); // Output: i=650, j=64

        System.out.println("\n--- Good Programming Practice (Hindari dalam Ekspresi) ---");
        System.out.println("Sebaiknya hindari penggunaan ++/-- dalam ekspresi kompleks.");
        System.out.println("Misalnya, daripada `i = (++j) * k;`, lebih baik:");
        j = 65;
        j++; // Langkah 1: Increment j
        i = j * k; // Langkah 2: Gunakan nilai j yang sudah di-increment
        System.out.println("  j = 65; j++; i = j * k; -> i = " + i + ", j = " + j); // Output: i=660, j=66

        System.out.println("Daripada `i = (j++) * k;`, lebih baik:");
        j = 65;
        i = j * k; // Langkah 1: Gunakan nilai j saat ini
        j++; // Langkah 2: Increment j
        System.out.println("  j = 65; i = j * k; j++; -> i = " + i + ", j = " + j); // Output: i=650, j=66

    }
}

