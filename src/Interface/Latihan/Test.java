package Interface.Latihan;

public class Test {
    public static void main(String[] args) {

        InStack mystack;

        DynStack ds = new DynStack(5);
        FixedStack fs = new FixedStack(8);

        mystack = ds; // pakai dynstack

        for (int i = 0; i < 12; i++) {
            mystack.push(i);
        }

        mystack = fs; // pindah ke fixedstack

        for (int i = 0; i < 8; i++) {
            mystack.push(i);
        }

        mystack = ds;
        System.out.println("Dynamic Stack:");
        for (int i = 0; i < 12; i++) {
            System.out.println(mystack.pop());
        }

        mystack = fs;
        System.out.println("Fixed Stack");
        for (int i = 0; i < 8; i++) {
            System.out.println(mystack.pop());
        }
    }

}
