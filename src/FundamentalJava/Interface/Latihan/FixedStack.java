package FundamentalJava.Interface.Latihan;

// Latihan

public class FixedStack implements InStack {

    private int stck[];
    private int tos;

    FixedStack(int size) {
        this.stck = new int[size];
        tos = -1;
    }

    @Override
    public void push(int item) {
        if (this.tos == stck.length - 1) {
            System.out.println("Stack full.");
        } else {
            this.stck[++tos] = item; // tambah data
        }
    }

    @Override
    public int pop() {
        if (this.tos < 0) {
            System.out.println("Stack Underflow"); // kosong
            return 0;
        } else {
            return this.stck[tos--]; // ambill
        }
    }

}
