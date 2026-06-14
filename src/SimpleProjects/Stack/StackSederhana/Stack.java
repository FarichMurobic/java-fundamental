package SimpleProjects.Stack.StackSederhana;

public class Stack {
    // array untuk menyimpan data stack
    private int[] data;

    // penunjuk posisi paling atas (top)
    private int top;

    // ukuran maksimal stack
    private int maxSize;

    // constructor (dipanggil saat object dibuat)
    public Stack(int size) {
        maxSize = size;              // set ukuran maksimal
        data = new int[maxSize];     // buat array sesuai ukuran
        top = -1;                    // -1 artinya stack masih kosong
    }

    // cek apakah stack penuh
    public boolean isFull() {
        return top == maxSize - 1;
        // kalau top sudah di ujung array → penuh
    }

    // cek apakah stack kosong
    public boolean isEmpty() {
        return top == -1;
        // kalau top masih -1 → belum ada data
    }

    // method untuk menambah data (push)
    public void push(int nilai) {
        if (isFull()) {
            System.out.println("Stack penuh! Tidak bisa tambah data.");
        } else {
            top++;              // naikkan posisi top
            data[top] = nilai;  // simpan nilai ke posisi top
            System.out.println("Data " + nilai + " berhasil ditambahkan.");
        }
    }

    // method untuk mengambil data (pop)
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong! Tidak ada data.");
            return -1; // tanda error
        } else {
            int nilai = data[top]; // ambil data paling atas
            top--;                 // turunkan posisi top
            return nilai;          // kembalikan nilai
        }
    }

    // method untuk melihat data paling atas (tanpa menghapus)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack kosong!");
            return -1;
        } else {
            return data[top]; // hanya melihat, tidak menghapus
        }
    }

    // method untuk menampilkan semua isi stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack kosong!");
        } else {
            System.out.println("Isi stack (dari atas ke bawah):");

            // loop dari atas ke bawah
            for (int i = top; i >= 0; i--) {
                System.out.println(data[i]);
            }
        }
    }
}
