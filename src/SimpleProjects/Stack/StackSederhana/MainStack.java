package SimpleProjects.Stack.StackSederhana;

import java.util.Scanner;

public class MainStack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // minta user tentukan ukuran stack
        System.out.print("Masukkan ukuran stack: ");
        int size = input.nextInt();

        // buat object stack
        Stack stack = new Stack(size);

        int pilihan;

        do {
            System.out.println("\n=== MENU STACK ===");
            System.out.println("1. Push (Tambah data)");
            System.out.println("2. Pop (Ambil data)");
            System.out.println("3. Peek (Lihat atas)");
            System.out.println("4. Tampilkan semua");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    // input nilai
                    System.out.print("Masukkan nilai: ");
                    int nilai = input.nextInt();

                    // panggil push
                    stack.push(nilai);
                    break;

                case 2:
                    // ambil data
                    int hasilPop = stack.pop();

                    // kalau tidak error
                    if (hasilPop != -1) {
                        System.out.println("Data yang diambil: " + hasilPop);
                    }
                    break;

                case 3:
                    // lihat data paling atas
                    int atas = stack.peek();

                    if (atas != -1) {
                        System.out.println("Data paling atas: " + atas);
                    }
                    break;

                case 4:
                    // tampilkan semua isi
                    stack.display();
                    break;

                case 5:
                    System.out.println("Program selesai bro 🙌");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 5);
        input.close();
    }
}
