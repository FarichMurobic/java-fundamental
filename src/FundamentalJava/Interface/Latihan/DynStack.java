package FundamentalJava.Interface.Latihan;

// Latihan

public class DynStack implements InStack {

    private int stck[];
    private int tos;

    DynStack(int size) {
        this.stck = new int[size];
        this.tos = -1;
    }

    @Override
    public void push(int item) {
        if (this.tos == stck.length - 1) {
            // buat array 2 kali lebih besar
            int temp[] = new int[this.stck.length * 2];

            // copy isi lama
            for (int i = 0; i < stck.length; i++) {
                temp[i] = stck[i];
            }
            stck = temp; // ganti array lama
        }
        stck[++tos] = item; // tambah data
    }

    @Override
    public int pop() {
        if (tos < 0) {
            System.out.println("Stack underflow");
            return 0;
        } else {
            return stck[tos--];
        }

    }

}
