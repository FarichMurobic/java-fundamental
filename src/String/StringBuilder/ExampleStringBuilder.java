package String.StringBuilder;

import java.util.Scanner;

public class ExampleStringBuilder {
    public static void main(String[] args) {

        Scanner inputUser = new Scanner(System.in);

        StringBuilder stringBuilder = new StringBuilder();

        int pilihan;

        do {
            System.out.println("\n----- Mini Project -----");
            System.out.println("Text saat ini: " + stringBuilder);
            System.out.println("1. Tambah text (append)");
            System.out.println("2. Sisipkan text (insert)");
            System.out.println("3. Delete text (delete)");
            System.out.println("4. Ganti text (replace)");
            System.out.println("5. Balik text (reverse)");
            System.out.println("6. Ambil subString");
            System.out.println("7. Cari kata (indexOf)");
            System.out.println("0. Keluar");
            System.out.print("pilih: ");

            pilihan = inputUser.nextInt();
            inputUser.nextLine();

            switch (pilihan) {
                case 1:
                    // append
                    System.out.print("Masukkan teks: ");
                    String addText = inputUser.nextLine();
                    stringBuilder.append(addText);
                    break;
                case 2:
                    // insert
                    System.out.print("Index: ");
                    int insertIndex = inputUser.nextInt();
                    inputUser.nextLine();

                    System.out.print("Teks: ");
                    String insertText = inputUser.nextLine();

                    try {
                        stringBuilder.insert(insertIndex, insertText);
                    } catch (Exception e) {
                        System.out.println("Index tidak valid!.");
                    }
                    break;
                case 3:
                    // 3. DELETE
                    System.out.print("Start Index: ");
                    int start = inputUser.nextInt();

                    System.out.print("End Index: ");
                    int end = inputUser.nextInt();

                    try {
                        stringBuilder.delete(start, end);
                    } catch (Exception e) {
                        System.out.println("Index tidak valid!.");
                    }
                    break;
                case 4:
                    // 4. REPLACE
                    System.out.print("Start Index: ");
                    int startReplace = inputUser.nextInt();

                    System.out.println("End Index: ");
                    int endReplace = inputUser.nextInt();
                    inputUser.nextLine();

                    System.out.print("Teks baru: ");
                    String newText = inputUser.nextLine();

                    try {
                        stringBuilder.replace(startReplace, endReplace, newText);
                    } catch (Exception e) {
                        System.out.println("Index tidak valid!.");
                    }
                    break;
                case 5:
                    // REVERSE
                    stringBuilder.reverse();
                    break;
                case 6:
                    // SUBSTRING
                    System.out.print("Start Index: ");
                    int startSub = inputUser.nextInt();

                    System.out.print("End Index: ");
                    int endSub = inputUser.nextInt();

                    try {
                        String sub = stringBuilder.substring(startSub, endSub);
                        System.out.println("Hasil subString: " + sub);
                    } catch (Exception e) {
                        System.out.println("Index tidak valid!.");
                    }
                    break;
                case 7:
                    // INDEX OF
                    System.out.print("Cari kata: ");
                    String keyword = inputUser.nextLine();
                    int index = stringBuilder.indexOf(keyword);

                    if (index != -1) {
                        System.out.println("Ditemukan di index: " + index);
                    } else {
                        System.out.println("Tidak ditemukan!.");
                    }
                    break;
                case 0:
                    // KELUAR
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!.");
            }
        } while (pilihan != 0);
        inputUser.close();
        
    }
}
